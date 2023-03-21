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