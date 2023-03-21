/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.activity.service.impl;

import org.osgi.annotation.versioning.ProviderType;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalService;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.activity.model.ActivityCourseSchedule;
import eu.strasbourg.service.activity.service.base.ActivityCourseScheduleLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Reference;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * The implementation of the activity course schedule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseScheduleLocalServiceBaseImpl
 * @see eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalServiceUtil
 */
@ProviderType
public class ActivityCourseScheduleLocalServiceImpl
	extends ActivityCourseScheduleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * eu.strasbourg.service.activity.service.
	 * ActivityCourseScheduleLocalServiceUtil} to access the activity course
	 * schedule local service.
	 */

	/**
	 * Retourne les horaires d'un cours dans un lieu
	 */
	@Override
	public List<ActivityCourseSchedule> getByActivityCoursePlace(
		long activityCoursePlaceId) {
		return this.activityCourseSchedulePersistence
			.findByActivityCoursePlace(activityCoursePlaceId);
	}

	/**
	 * Crée une activité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public ActivityCourseSchedule createActivityCourseSchedule(
		ServiceContext sc) throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		long pk = counterLocalService.increment();

		ActivityCourseSchedule activityCourseSchedule = this.activityCourseScheduleLocalService
			.createActivityCourseSchedule(pk);

		activityCourseSchedule.setGroupId(sc.getScopeGroupId());
		activityCourseSchedule.setUserName(user.getFullName());
		activityCourseSchedule.setUserId(sc.getUserId());

		return activityCourseSchedule;
	}

	/**
	 * Met à jour une activité et l'enregistre en base de données
	 */
	@Override
	public ActivityCourseSchedule updateActivityCourseSchedule(
		ActivityCourseSchedule activityCourseSchedule, ServiceContext sc)
		throws PortalException {
		activityCourseSchedule = this.activityCourseScheduleLocalService
			.updateActivityCourseSchedule(activityCourseSchedule);
		this.updateAssetEntry(activityCourseSchedule, sc);
		this.reindex(activityCourseSchedule, false);

		return activityCourseSchedule;
	}

	/**
	 * Met à jour l'AssetEntry rattachée à l'entité
	 */
	private void updateAssetEntry(ActivityCourseSchedule activityCourseSchedule,
		ServiceContext sc) throws PortalException {
		this.assetEntryLocalService.updateEntry(sc.getUserId(), // User ID
			sc.getScopeGroupId(), // Group ID
			activityCourseSchedule.getCreateDate(), // Date of creation
			activityCourseSchedule.getModifiedDate(), // Date of modification
			ActivityCourseSchedule.class.getName(), // Class name
			activityCourseSchedule.getPrimaryKey(), // Class PK
			activityCourseSchedule.getUuid(), // UUID
			0, // Class type ID
			sc.getAssetCategoryIds(), // Categories IDs
			sc.getAssetTagNames(), // Tags IDs
			true, // Listable
			true, // Visible
			activityCourseSchedule.getCreateDate(), // Start date
			null, // End date
			activityCourseSchedule.getCreateDate(), // Publication date
			null, // Date of expiration
			ContentTypes.TEXT_HTML, // Content type
			"", // Title
			"", // Description
			"", // Summary
			null, // URL
			null, // Layout uuid
			0, // Width
			0, // Height
			null); // Priority

		// Réindexe l'édition
		this.reindex(activityCourseSchedule, false);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public ActivityCourseSchedule removeActivityCourseSchedule(
		long activityCourseScheduleId) throws PortalException {
		AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(
			ActivityCourseSchedule.class.getName(), activityCourseScheduleId);

		if (entry != null) {
			// Supprime le lien avec les catégories
			assetEntryAssetCategoryRelLocalService.
					deleteAssetEntryAssetCategoryRelByAssetEntryId(entry.getEntryId());

			// Supprime le lien avec les tags
			long[] tagIds = AssetEntryLocalServiceUtil
				.getAssetTagPrimaryKeys(entry.getEntryId());
			for (int i = 0; i < tagIds.length; i++) {
				AssetEntryLocalServiceUtil.deleteAssetTagAssetEntry(tagIds[i],
					entry.getEntryId());
			}

			// Supprime l'assetEntry
			AssetEntryLocalServiceUtil.deleteEntry(
				ActivityCourseSchedule.class.getName(),
				activityCourseScheduleId);

		}

		// Supprime l'entité
		ActivityCourseSchedule activityCourseSchedule = this.activityCourseSchedulePersistence
			.remove(activityCourseScheduleId);

		// Supprime l'index
		this.reindex(activityCourseSchedule, true);

		return activityCourseSchedule;
	}

	/**
	 * Reindex l'entité dans le moteur de recherche
	 */
	private void reindex(ActivityCourseSchedule activityCourseSchedule,
		boolean delete) throws SearchException {
		Indexer<ActivityCourseSchedule> indexer = IndexerRegistryUtil
			.nullSafeGetIndexer(ActivityCourseSchedule.class);
		if (delete) {
			indexer.delete(activityCourseSchedule);
		} else {
			indexer.reindex(activityCourseSchedule);
		}
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	@Override
	public List<AssetVocabulary> getAttachedVocabularies(long groupId) {
		List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil
			.getAssetVocabularies(-1, -1);
		List<AssetVocabulary> attachedVocabularies = new ArrayList<AssetVocabulary>();
		long classNameId = ClassNameLocalServiceUtil
			.getClassNameId(ActivityCourseSchedule.class);
		for (AssetVocabulary vocabulary : vocabularies) {
			if (vocabulary.getGroupId() == groupId
				&& LongStream.of(vocabulary.getSelectedClassNameIds())
					.anyMatch(c -> c == classNameId)) {
				attachedVocabularies.add(vocabulary);
			}
		}
		return attachedVocabularies;
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	@Override
	public List<ActivityCourseSchedule> getByGroupId(long groupId) {
		return this.activityCourseSchedulePersistence.findByGroupId(groupId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		Indexer<ActivityCourseSchedule> indexer = IndexerRegistryUtil
			.nullSafeGetIndexer(ActivityCourseSchedule.class);
		return indexer.search(searchContext);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public List<ActivityCourseSchedule> findByKeyword(String keyword,
		long groupId, int start, int end) {
		DynamicQuery dynamicQuery = dynamicQuery();

		if (keyword.length() > 0) {
			dynamicQuery.add(
				RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
		}
		if (groupId > 0) {
			dynamicQuery
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		}
		dynamicQuery.add(PropertyFactoryUtil.forName("status")
			.eq(WorkflowConstants.STATUS_APPROVED));

		return activityCourseSchedulePersistence
			.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Retourne la liste des horaires pour une liste de jours donnés sur une
	 * plage horaire donnée
	 */
	@Override
	public List<ActivityCourseSchedule> findByDaysAndTimes(long groupId,
		boolean[] days, String startTime, String endTime) {

		List<ActivityCourseSchedule> schedules = new ArrayList<ActivityCourseSchedule>();

		DynamicQuery dynamicQuery = dynamicQuery();

		// GroupId
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));

		// Jours
		if (days == null || days.length != 7) {
			return new ArrayList<ActivityCourseSchedule>();
		}
		String[] dayFields = { "monday", "tuesday", "wednesday", "thursday",
			"friday", "saturday", "sunday" };
		Disjunction daysDisjunction = RestrictionsFactoryUtil.disjunction();
		for (int i = 0; i < 7; i++) {
			if (days[i]) {
				daysDisjunction
					.add(PropertyFactoryUtil.forName(dayFields[i]).eq(true));
			}
		}
		dynamicQuery.add(daysDisjunction);

		List<ActivityCourseSchedule> schedulesForDays = activityCourseSchedulePersistence
			.findWithDynamicQuery(dynamicQuery, -1, -1);

		// Horaires
		LocalTime criterionStartTime = null;
		LocalTime criterionEndTime = null;
		try {
			criterionStartTime = LocalTime.parse(startTime);
		} catch (DateTimeParseException ex) {
			criterionStartTime = LocalTime.parse("00:00");
		}
		try {
			criterionEndTime = LocalTime.parse(endTime);
		} catch (DateTimeParseException ex) {
			criterionEndTime = LocalTime.parse("23:59");
		}
		for (ActivityCourseSchedule schedule : schedulesForDays) {
			LocalTime scheduleStartTime = null;
			LocalTime scheduleEndTime = null;
			try {
				scheduleStartTime = LocalTime.parse(schedule.getStartTime());
			} catch (DateTimeParseException ex) {
				scheduleStartTime = LocalTime.parse("00:00");
			}
			try {
				scheduleEndTime = LocalTime.parse(schedule.getEndTime());
			} catch (DateTimeParseException ex) {
				scheduleEndTime = LocalTime.parse("23:59");
			}
			if (!(criterionStartTime.isAfter(scheduleEndTime)
				|| criterionEndTime.isBefore(scheduleStartTime)
				|| criterionStartTime.isAfter(criterionEndTime))) {
				schedules.add(schedule);
			}
		}

		return schedules;
	}
	@Reference
	private AssetEntryAssetCategoryRelLocalService assetEntryAssetCategoryRelLocalService;
}