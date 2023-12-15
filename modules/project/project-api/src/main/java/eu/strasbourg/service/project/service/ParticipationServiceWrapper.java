/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ParticipationService}.
 *
 * @author Cedric Henry
 * @see ParticipationService
 * @generated
 */
public class ParticipationServiceWrapper
	implements ParticipationService, ServiceWrapper<ParticipationService> {

	public ParticipationServiceWrapper() {
		this(null);
	}

	public ParticipationServiceWrapper(
		ParticipationService participationService) {

		_participationService = participationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _participationService.getOSGiServiceIdentifier();
	}

	@Override
	public ParticipationService getWrappedService() {
		return _participationService;
	}

	@Override
	public void setWrappedService(ParticipationService participationService) {
		_participationService = participationService;
	}

	private ParticipationService _participationService;

}