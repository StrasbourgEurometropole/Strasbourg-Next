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
 * The extended model interface for the CampaignEventStatus service. Represents a row in the &quot;agenda_CampaignEventStatus&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see CampaignEventStatusModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.agenda.model.impl.CampaignEventStatusImpl"
)
@ProviderType
public interface CampaignEventStatus
	extends CampaignEventStatusModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.CampaignEventStatusImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CampaignEventStatus, Long> STATUS_ID_ACCESSOR =
		new Accessor<CampaignEventStatus, Long>() {

			@Override
			public Long get(CampaignEventStatus campaignEventStatus) {
				return campaignEventStatus.getStatusId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CampaignEventStatus> getTypeClass() {
				return CampaignEventStatus.class;
			}

		};

	public eu.strasbourg.service.agenda.model.CampaignEventStatus
		getPreviousStatus();

	/**
	 * Retourne le label correspondant au statut
	 */
	public String getStatusLabel();

}