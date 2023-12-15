/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssociationService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssociationService
 * @generated
 */
public class AssociationServiceWrapper
	implements AssociationService, ServiceWrapper<AssociationService> {

	public AssociationServiceWrapper() {
		this(null);
	}

	public AssociationServiceWrapper(AssociationService associationService) {
		_associationService = associationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _associationService.getOSGiServiceIdentifier();
	}

	@Override
	public AssociationService getWrappedService() {
		return _associationService;
	}

	@Override
	public void setWrappedService(AssociationService associationService) {
		_associationService = associationService;
	}

	private AssociationService _associationService;

}