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

package eu.strasbourg.service.activity.model.impl;

import org.osgi.annotation.versioning.ProviderType;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.model.ActivityCoursePlace;
import eu.strasbourg.service.activity.model.ActivityCourseSchedule;
import eu.strasbourg.service.activity.service.ActivityCourseLocalServiceUtil;
import eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalServiceUtil;
import eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalServiceUtil;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * The extended model implementation for the ActivityCoursePlace service.
 * Represents a row in the &quot;activity_ActivityCoursePlace&quot; database
 * table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link eu.strasbourg.service.activity.model.ActivityCoursePlace}
 * interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class ActivityCoursePlaceImpl extends ActivityCoursePlaceBaseImpl {
	private static final long serialVersionUID = 6670170500800493625L;

	public ActivityCoursePlaceImpl() {
	}

	/**
	 * Retourne true si le cours a des horaires pour ce lieux
	 */
	@Override
	public boolean hasSchedules() {
		return ActivityCourseScheduleLocalServiceUtil
			.getByActivityCoursePlace(this.getActivityCoursePlaceId())
			.size() > 0;
	}

	/**
	 * Retourne les horaires du cours dans le lieu
	 */
	@Override
	public List<ActivityCourseSchedule> getActivityCourseSchedules() {
		return ActivityCourseScheduleLocalServiceUtil
			.getByActivityCoursePlace(this.getActivityCoursePlaceId());
	}

	/**
	 * Retourne les horaires du cours dans le lieu pour un jour donné (lundi =
	 * 0, mardi = 1, etc.)
	 */
	@Override
	public List<ActivityCourseSchedule> getActivityCourseSchedulesForDay(
		int day) {
		List<ActivityCourseSchedule> schedules = ActivityCourseScheduleLocalServiceUtil
			.getByActivityCoursePlace(this.getActivityCoursePlaceId());
		return schedules.stream().filter(s -> s.hasScheduleOnDay(day))
			.collect(Collectors.toList());
	}

	/**
	 * Retourne le cours du lieu
	 */
	@Override
	public ActivityCourse getActivityCourse() {
		return ActivityCourseLocalServiceUtil
			.fetchActivityCourse(this.getActivityCourseId());
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public ActivityCoursePlace getLiveVersion() {
		long groupId = this.getGroupId();
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);
		if (group == null || !group.isStagingGroup()) {
			return null;
		}
		long liveGroupId = group.getLiveGroupId();
		ActivityCoursePlace liveActivity = ActivityCoursePlaceLocalServiceUtil
			.fetchActivityCoursePlaceByUuidAndGroupId(this.getUuid(),
				liveGroupId);
		return liveActivity;
	}

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(ActivityCoursePlace.class.getName(),
			this.getPrimaryKey());
	}

	/**
	 * Retourne la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	@Override
	public List<AssetCategory> getCategories() {
		return AssetVocabularyHelper
			.getAssetEntryCategories(this.getAssetEntry());
	}

	/**
	 * Retourne le nom du lieu SIG
	 */
	@Override
	public String getSIGPlaceAlias(Locale locale) {
		Place place = PlaceLocalServiceUtil
			.getPlaceBySIGId(this.getPlaceSIGId());
		if (place != null) {
			return place.getAlias(locale);
		} else {
			return "";
		}
	}

	/**
	 * Retourne le nom du lieu SIG ou "manuel"
	 */
	@Override
	public String getPlaceAlias(Locale locale) {
		Place place = PlaceLocalServiceUtil
			.getPlaceBySIGId(this.getPlaceSIGId());
		if (place != null) {
			return place.getAlias(locale);
		} else {
			return this.getPlaceName(locale);
		}
	}

}