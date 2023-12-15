/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventPeriodService}.
 *
 * @author BenjaminBini
 * @see EventPeriodService
 * @generated
 */
public class EventPeriodServiceWrapper
	implements EventPeriodService, ServiceWrapper<EventPeriodService> {

	public EventPeriodServiceWrapper() {
		this(null);
	}

	public EventPeriodServiceWrapper(EventPeriodService eventPeriodService) {
		_eventPeriodService = eventPeriodService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventPeriodService.getOSGiServiceIdentifier();
	}

	@Override
	public EventPeriodService getWrappedService() {
		return _eventPeriodService;
	}

	@Override
	public void setWrappedService(EventPeriodService eventPeriodService) {
		_eventPeriodService = eventPeriodService;
	}

	private EventPeriodService _eventPeriodService;

}