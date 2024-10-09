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
 * The extended model interface for the ActivityOrganizer service. Represents a row in the &quot;activity_ActivityOrganizer&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityOrganizerModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.activity.model.impl.ActivityOrganizerImpl"
)
@ProviderType
public interface ActivityOrganizer
	extends ActivityOrganizerModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.activity.model.impl.ActivityOrganizerImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ActivityOrganizer, Long>
		ACTIVITY_ORGANIZER_ID_ACCESSOR =
			new Accessor<ActivityOrganizer, Long>() {

				@Override
				public Long get(ActivityOrganizer activityOrganizer) {
					return activityOrganizer.getActivityOrganizerId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ActivityOrganizer> getTypeClass() {
					return ActivityOrganizer.class;
				}

			};

	/**
	 * Retourne la version live de cette entité
	 */
	public ActivityOrganizer getLiveVersion();

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
	 * Retourne l'URL de l'image
	 */
	public String getImageURL();

}