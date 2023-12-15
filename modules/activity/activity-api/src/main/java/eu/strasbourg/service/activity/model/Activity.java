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
 * The extended model interface for the Activity service. Represents a row in the &quot;activity_Activity&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.activity.model.impl.ActivityImpl"
)
@ProviderType
public interface Activity extends ActivityModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.activity.model.impl.ActivityImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Activity, Long> ACTIVITY_ID_ACCESSOR =
		new Accessor<Activity, Long>() {

			@Override
			public Long get(Activity activity) {
				return activity.getActivityId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Activity> getTypeClass() {
				return Activity.class;
			}

		};

	/**
	 * Retourne les cours de l'activité
	 */
	public java.util.List<eu.strasbourg.service.activity.model.ActivityCourse>
		getActivityCourses();

	/**
	 * Retourne les cours publiés du lieu
	 */
	public java.util.List<eu.strasbourg.service.activity.model.ActivityCourse>
		getPublishedActivityCourses();

	/**
	 * Retourne la version live de cette entité
	 *
	 * @return
	 */
	public eu.strasbourg.service.activity.model.Activity getLiveVersion();

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
	 * Retourne les types de l'activité
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne le texte à afficher pour les types de l'activité
	 */
	public String getTypesLabel(java.util.Locale locale);

	/**
	 * Retourne l'URL de l'image
	 */
	public String getImageURL();

	/**
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	public java.util.List<String> getImagesURLs();

	/**
	 * Retourne la liste des vidéos
	 */
	public java.util.List<eu.strasbourg.service.video.model.Video> getVideos();

	/**
	 * Retourne la liste des URLs des documents
	 */
	public java.util.List<String> getFilesURLs();

	/**
	 * Retourne la version JSON de l'activité
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}