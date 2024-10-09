/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ActivityCoursePlace service. Represents a row in the &quot;activity_ActivityCoursePlace&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePlaceModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceImpl"
)
@ProviderType
public interface ActivityCoursePlace
	extends ActivityCoursePlaceModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ActivityCoursePlace, Long>
		ACTIVITY_COURSE_PLACE_ID_ACCESSOR =
			new Accessor<ActivityCoursePlace, Long>() {

				@Override
				public Long get(ActivityCoursePlace activityCoursePlace) {
					return activityCoursePlace.getActivityCoursePlaceId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ActivityCoursePlace> getTypeClass() {
					return ActivityCoursePlace.class;
				}

			};

	/**
	 * Retourne true si le cours a des horaires pour ce lieux
	 */
	public boolean hasSchedules();

	/**
	 * Retourne les horaires du cours dans le lieu
	 */
	public java.util.List<ActivityCourseSchedule> getActivityCourseSchedules();

	/**
	 * Retourne les horaires du cours dans le lieu pour un jour donné (lundi =
	 * 0, mardi = 1, etc.)
	 */
	public java.util.List<ActivityCourseSchedule>
		getActivityCourseSchedulesForDay(int day);

	/**
	 * Retourne le cours du lieu
	 */
	public ActivityCourse getActivityCourse();

	/**
	 * Retourne la version live de cette entité
	 */
	public ActivityCoursePlace getLiveVersion();

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Retourne la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Retourne le nom du lieu SIG
	 */
	public String getSIGPlaceAlias(java.util.Locale locale);

	/**
	 * Retourne le nom du lieu SIG ou "manuel"
	 */
	public String getPlaceAlias(java.util.Locale locale);

}