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

package eu.strasbourg.service.activity.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ActivityCourse service. Represents a row in the &quot;activity_ActivityCourse&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.activity.model.impl.ActivityCourseImpl"
)
@ProviderType
public interface ActivityCourse extends ActivityCourseModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.activity.model.impl.ActivityCourseImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ActivityCourse, Long>
		ACTIVITY_COURSE_ID_ACCESSOR = new Accessor<ActivityCourse, Long>() {

			@Override
			public Long get(ActivityCourse activityCourse) {
				return activityCourse.getActivityCourseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ActivityCourse> getTypeClass() {
				return ActivityCourse.class;
			}

		};

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne le nom de l'organisateur du cours
	 */
	public String getOrganizerName(java.util.Locale locale);

	/**
	 * Retourne la liste des URL des documents de ce cours
	 */
	public java.util.List<String> getDocumentURLs();

	/**
	 * Retourne une map de titre et d'URL des documents de ce cours
	 */
	public java.util.Map<String, String> getDocuments();

	/**
	 * Retourne l'URL publiques de l'image
	 */
	public String getImageURL(Long imageId);

	/**
	 * Retourne le titre publiques de l'image
	 */
	public String getImageTitle(Long imageId, java.util.Locale locale);

	/**
	 * Retourne la légende publiques de l'image
	 */
	public String getImageLegend(Long imageId, java.util.Locale locale);

	/**
	 * Retourne le copyright publiques de l'image
	 */
	public String getImageCopyright(Long imageId, java.util.Locale locale);

	/**
	 * Retourne la liste des vidéos de ce lieu
	 */
	public java.util.List<eu.strasbourg.service.video.model.Video> getVideos();

	/**
	 * Retourne l'organisateur du cours
	 */
	public eu.strasbourg.service.activity.model.ActivityOrganizer
		getActivityOrganizer();

	/**
	 * Retourne l'activité du cours
	 */
	public eu.strasbourg.service.activity.model.Activity getActivity();

	/**
	 * Retourne les horaires par lieu du cours
	 */
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCoursePlace>
			getActivityCoursePlaces();

	/**
	 * Retourne les noms des lieux du cours
	 */
	public java.util.List<String> getPlaceNames(java.util.Locale locale);

	/**
	 * Retourne les ids SIG des lieux duc ours
	 */
	public java.util.List<String> getPlaceSIGIds(java.util.Locale locale);

	/**
	 * Retourne les publics dui cours
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics();

	/**
	 * Retourne le texte à afficher pour les publics du cours
	 */
	public String getPublicsLabel(java.util.Locale locale);

	/**
	 * Retourne les types du cours
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne le texte à afficher pour les types du cours
	 */
	public String getTypesLabels(java.util.Locale locale);

	/**
	 * Retourne la version live de cette entité
	 */
	public eu.strasbourg.service.activity.model.ActivityCourse getLiveVersion();

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
	 * Retourne l'affichage de l'agenda d'un cours Transformation de :
	 * ActivityCourse -> ActivityCoursePlace -> ActivityCourseSchedule ^ ^ | |
	 * Place Period
	 *
	 * En : Period -> Place -> Schedule
	 */
	public eu.strasbourg.service.activity.model.CourseAgenda getCourseAgenda(
		long groupId, java.util.Locale locale);

	/**
	 * Retourne la version JSON de la course
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}