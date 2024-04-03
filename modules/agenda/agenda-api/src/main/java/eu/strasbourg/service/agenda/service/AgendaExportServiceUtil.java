/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for AgendaExport. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.AgendaExportServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author BenjaminBini
 * @see AgendaExportService
 * @generated
 */
public class AgendaExportServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.AgendaExportServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Renvoit la liste des catégories parentes d'un vocabulaire
	 */
	public static com.liferay.portal.kernel.json.JSONArray getParentCategories(
			Long vocabularyId, String localeId)
		throws PortalException {

		return getService().getParentCategories(vocabularyId, localeId);
	}

	public static AgendaExportService getService() {
		return _service;
	}

	public static void setService(AgendaExportService service) {
		_service = service;
	}

	private static volatile AgendaExportService _service;

}