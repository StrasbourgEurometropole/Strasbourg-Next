/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AgendaExportService}.
 *
 * @author BenjaminBini
 * @see AgendaExportService
 * @generated
 */
public class AgendaExportServiceWrapper
	implements AgendaExportService, ServiceWrapper<AgendaExportService> {

	public AgendaExportServiceWrapper() {
		this(null);
	}

	public AgendaExportServiceWrapper(AgendaExportService agendaExportService) {
		_agendaExportService = agendaExportService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agendaExportService.getOSGiServiceIdentifier();
	}

	/**
	 * Renvoit la liste des catégories parentes d'un vocabulaire
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray getParentCategories(
			Long vocabularyId, String localeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaExportService.getParentCategories(vocabularyId, localeId);
	}

	@Override
	public AgendaExportService getWrappedService() {
		return _agendaExportService;
	}

	@Override
	public void setWrappedService(AgendaExportService agendaExportService) {
		_agendaExportService = agendaExportService;
	}

	private AgendaExportService _agendaExportService;

}