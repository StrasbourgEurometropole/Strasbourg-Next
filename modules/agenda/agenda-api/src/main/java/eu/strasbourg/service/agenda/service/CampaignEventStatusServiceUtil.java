/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

/**
 * Provides the remote service utility for CampaignEventStatus. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.CampaignEventStatusServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author BenjaminBini
 * @see CampaignEventStatusService
 * @generated
 */
public class CampaignEventStatusServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.CampaignEventStatusServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CampaignEventStatusService getService() {
		return _service;
	}

	public static void setService(CampaignEventStatusService service) {
		_service = service;
	}

	private static volatile CampaignEventStatusService _service;

}