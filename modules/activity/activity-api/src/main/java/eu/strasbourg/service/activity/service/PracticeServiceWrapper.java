/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PracticeService}.
 *
 * @author Brian Wing Shun Chan
 * @see PracticeService
 * @generated
 */
public class PracticeServiceWrapper
	implements PracticeService, ServiceWrapper<PracticeService> {

	public PracticeServiceWrapper() {
		this(null);
	}

	public PracticeServiceWrapper(PracticeService practiceService) {
		_practiceService = practiceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _practiceService.getOSGiServiceIdentifier();
	}

	@Override
	public PracticeService getWrappedService() {
		return _practiceService;
	}

	@Override
	public void setWrappedService(PracticeService practiceService) {
		_practiceService = practiceService;
	}

	private PracticeService _practiceService;

}