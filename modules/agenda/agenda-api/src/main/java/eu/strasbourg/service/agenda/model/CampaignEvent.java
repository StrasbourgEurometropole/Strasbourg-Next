/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CampaignEvent service. Represents a row in the &quot;agenda_CampaignEvent&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see CampaignEventModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.agenda.model.impl.CampaignEventImpl"
)
@ProviderType
public interface CampaignEvent extends CampaignEventModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.CampaignEventImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CampaignEvent, Long>
		CAMPAIGN_EVENT_ID_ACCESSOR = new Accessor<CampaignEvent, Long>() {

			@Override
			public Long get(CampaignEvent campaignEvent) {
				return campaignEvent.getCampaignEventId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CampaignEvent> getTypeClass() {
				return CampaignEvent.class;
			}

		};

	public Campaign getCampaign();

	/**
	 * Retourne la liste de CampaignEventStatus, correspondant à l'historique
	 * des statuts de l'événement classé par ordre chronologique
	 */
	public java.util.List<CampaignEventStatus> getStatusHistory();

	/**
	 * Renvoie le dernier statut en date de l'événement
	 */
	public CampaignEventStatus getLastStatus();

	public CampaignEventStatus updateStatus(
			int newStatus, String comment,
			com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException;

	/**
	 * Retourne true si l'utilisateur est manager de la campagne à laquelle
	 * appartient l'événement
	 */
	public boolean isUserManagerOfTheEvent(long userId);

	/**
	 * Retourne les thèmes
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes();

	/**
	 * Retourne le label des thèles de l'événement
	 */
	public String getThemeLabel(java.util.Locale locale);

	/**
	 * Retourne les types
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne le label des types de l'événement
	 */
	public String getTypeLabel(java.util.Locale locale);

	/**
	 * Retourne les publics
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics();

	/**
	 * Retourne le label des publics de l'événement
	 */
	public String getPublicLabel(java.util.Locale locale);

	/**
	 * Retourne le nom du service
	 */
	public String getServiceName(java.util.Locale locale);

	public void sendDeleteMail()
		throws com.liferay.portal.kernel.exception.PortalException;

	public void sendDeletionDeniedMail()
		throws com.liferay.portal.kernel.exception.PortalException;

	public void sendStatusMail()
		throws com.liferay.portal.kernel.exception.PortalException;

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getWebImageURL();

	/**
	 * Retourne les périodes
	 */
	public java.util.List<EventPeriod> getPeriods();

	/**
	 * Retourne le territoire (la ville) de l'événement (si lieu manuel)
	 */
	public String getCity();

	/**
	 * Retourne le label des manifestations de l'événement
	 */
	public String getManifestationLabel(java.util.Locale locale);

	/**
	 * Retourne la version JSON de l'object
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

	/**
	 * Retourne le nom lieu rattaché à l'événement
	 */
	public String getPlaceAlias(java.util.Locale locale);

}