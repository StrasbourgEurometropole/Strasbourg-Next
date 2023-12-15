/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see TypeService
 * @generated
 */
public class TypeServiceWrapper
	implements ServiceWrapper<TypeService>, TypeService {

	public TypeServiceWrapper() {
		this(null);
	}

	public TypeServiceWrapper(TypeService typeService) {
		_typeService = typeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _typeService.getOSGiServiceIdentifier();
	}

	@Override
	public TypeService getWrappedService() {
		return _typeService;
	}

	@Override
	public void setWrappedService(TypeService typeService) {
		_typeService = typeService;
	}

	private TypeService _typeService;

}