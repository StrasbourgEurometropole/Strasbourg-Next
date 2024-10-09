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
 * The extended model interface for the ActivityCourseSchedule service. Represents a row in the &quot;activity_ActivityCourseSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseScheduleModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleImpl"
)
@ProviderType
public interface ActivityCourseSchedule
	extends ActivityCourseScheduleModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ActivityCourseSchedule, Long>
		ACTIVITY_COURSE_SCHEDULE_ID_ACCESSOR =
			new Accessor<ActivityCourseSchedule, Long>() {

				@Override
				public Long get(ActivityCourseSchedule activityCourseSchedule) {
					return activityCourseSchedule.getActivityCourseScheduleId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ActivityCourseSchedule> getTypeClass() {
					return ActivityCourseSchedule.class;
				}

			};

	/**
	 * Retourne le lieu de l'horaire
	 */
	public ActivityCoursePlace getActivityCoursePlace();

	/**
	 * Retourne la version live de cette entité
	 */
	public ActivityCourseSchedule getLiveVersion();

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Renvoie un tableau de 7 booléens valant true si l'horaire concerne le
	 * jour, false sinon
	 */
	public boolean[] getWeekDays();

	/**
	 * Renvoie true si l'horaire concerne le jour passé en paramètre (jour entre
	 * 0 et 6)
	 */
	public boolean hasScheduleOnDay(int day);

	/**
	 * Retourne les périodes du schedule
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPeriods();

}