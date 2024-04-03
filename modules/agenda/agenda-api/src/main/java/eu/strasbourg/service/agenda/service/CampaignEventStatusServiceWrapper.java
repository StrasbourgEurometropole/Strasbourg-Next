/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignEventStatusService}.
 *
 * @author BenjaminBini
 * @see CampaignEventStatusService
 * @generated
 */
public class CampaignEventStatusServiceWrapper
	implements CampaignEventStatusService,
			   ServiceWrapper<CampaignEventStatusService> {

	public CampaignEventStatusServiceWrapper() {
		this(null);
	}

	public CampaignEventStatusServiceWrapper(
		CampaignEventStatusService campaignEventStatusService) {

		_campaignEventStatusService = campaignEventStatusService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _campaignEventStatusService.getOSGiServiceIdentifier();
	}

	@Override
	public CampaignEventStatusService getWrappedService() {
		return _campaignEventStatusService;
	}

	@Override
	public void setWrappedService(
		CampaignEventStatusService campaignEventStatusService) {

		_campaignEventStatusService = campaignEventStatusService;
	}

	private CampaignEventStatusService _campaignEventStatusService;

}