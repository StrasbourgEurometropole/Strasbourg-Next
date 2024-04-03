/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LigneService}.
 *
 * @author Cedric Henry
 * @see LigneService
 * @generated
 */
public class LigneServiceWrapper
	implements LigneService, ServiceWrapper<LigneService> {

	public LigneServiceWrapper() {
		this(null);
	}

	public LigneServiceWrapper(LigneService ligneService) {
		_ligneService = ligneService;
	}

	/**
	 * Recuperer les couleurs des lignes
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray getLigneColors() {
		return _ligneService.getLigneColors();
	}

	/**
	 * Recuperer les couleurs des lignes pour freemarker
	 */
	@Override
	public java.util.Map<String, String[]> getLigneColorsFreemarker() {
		return _ligneService.getLigneColorsFreemarker();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ligneService.getOSGiServiceIdentifier();
	}

	@Override
	public LigneService getWrappedService() {
		return _ligneService;
	}

	@Override
	public void setWrappedService(LigneService ligneService) {
		_ligneService = ligneService;
	}

	private LigneService _ligneService;

}