/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FoundObjectService}.
 *
 * @author JeremyZwickert
 * @see FoundObjectService
 * @generated
 */
public class FoundObjectServiceWrapper
	implements FoundObjectService, ServiceWrapper<FoundObjectService> {

	public FoundObjectServiceWrapper() {
		this(null);
	}

	public FoundObjectServiceWrapper(FoundObjectService foundObjectService) {
		_foundObjectService = foundObjectService;
	}

	/**
	 * Retourne la liste des objets d'une catégorie
	 *
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray
			getFoundObjectByCategoryCode(String codeCategory)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _foundObjectService.getFoundObjectByCategoryCode(codeCategory);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _foundObjectService.getOSGiServiceIdentifier();
	}

	@Override
	public FoundObjectService getWrappedService() {
		return _foundObjectService;
	}

	@Override
	public void setWrappedService(FoundObjectService foundObjectService) {
		_foundObjectService = foundObjectService;
	}

	private FoundObjectService _foundObjectService;

}