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
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCoursePlace;
import eu.strasbourg.service.activity.model.ActivityCourseSchedule;
import eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalServiceUtil;
import eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The extended model implementation for the ActivityCourseSchedule service.
 * Represents a row in the &quot;activity_ActivityCourseSchedule&quot; database
 * table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link eu.strasbourg.service.activity.model.ActivityCourseSchedule}
 * interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class ActivityCourseScheduleImpl extends ActivityCourseScheduleBaseImpl {
	private static final long serialVersionUID = -3804075489036515389L;

	public ActivityCourseScheduleImpl() {
	}

	/**
	 * Retourne le lieu de l'horaire
	 */
	@Override
	public ActivityCoursePlace getActivityCoursePlace() {
		return ActivityCoursePlaceLocalServiceUtil
			.fetchActivityCoursePlace(this.getActivityCoursePlaceId());
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public ActivityCourseSchedule getLiveVersion() {
		long groupId = this.getGroupId();
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);
		if (group == null || !group.isStagingGroup()) {
			return null;
		}
		long liveGroupId = group.getLiveGroupId();
		ActivityCourseSchedule liveActivity = ActivityCourseScheduleLocalServiceUtil
			.fetchActivityCourseScheduleByUuidAndGroupId(this.getUuid(),
				liveGroupId);
		return liveActivity;
	}

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(Activity.class.getName(),
			this.getPrimaryKey());
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	@Override
	public List<AssetCategory> getCategories() {
		return AssetVocabularyHelper
			.getAssetEntryCategories(this.getAssetEntry());
	}

	/**
	 * Renvoie un tableau de 7 booléens valant true si l'horaire concerne le
	 * jour, false sinon
	 */
	@Override
	public boolean[] getWeekDays() {
		boolean[] days = new boolean[7];
		Arrays.fill(days, false);
		days[0] = this.getMonday();
		days[1] = this.getTuesday();
		days[2] = this.getWednesday();
		days[3] = this.getThursday();
		days[4] = this.getFriday();
		days[5] = this.getSaturday();
		days[6] = this.getSunday();
		return days;
	}
	
	/**
	 * Renvoie true si l'horaire concerne le jour passé en paramètre (jour entre
	 * 0 et 6)
	 */
	@Override
	public boolean hasScheduleOnDay(int day) {
		return this.getWeekDays()[day];
	}

	/**
	 * Retourne les périodes du schedule
	 */
	@Override
	public List<AssetCategory> getPeriods() {
		return ListUtil.fromArray(this.getPeriodsIds().split(","))
			.stream()
			.filter(s -> Validator.isNotNull(s))
			.mapToLong(Long::valueOf)
			.mapToObj(l -> AssetCategoryLocalServiceUtil.fetchAssetCategory(l))
			.filter(c -> c != null)
			.collect(Collectors.toList());
	}
}