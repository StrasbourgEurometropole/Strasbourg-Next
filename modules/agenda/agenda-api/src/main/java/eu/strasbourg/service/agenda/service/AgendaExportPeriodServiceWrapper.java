/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AgendaExportPeriodService}.
 *
 * @author BenjaminBini
 * @see AgendaExportPeriodService
 * @generated
 */
public class AgendaExportPeriodServiceWrapper
	implements AgendaExportPeriodService,
			   ServiceWrapper<AgendaExportPeriodService> {

	public AgendaExportPeriodServiceWrapper() {
		this(null);
	}

	public AgendaExportPeriodServiceWrapper(
		AgendaExportPeriodService agendaExportPeriodService) {

		_agendaExportPeriodService = agendaExportPeriodService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agendaExportPeriodService.getOSGiServiceIdentifier();
	}

	@Override
	public AgendaExportPeriodService getWrappedService() {
		return _agendaExportPeriodService;
	}

	@Override
	public void setWrappedService(
		AgendaExportPeriodService agendaExportPeriodService) {

		_agendaExportPeriodService = agendaExportPeriodService;
	}

	private AgendaExportPeriodService _agendaExportPeriodService;

}