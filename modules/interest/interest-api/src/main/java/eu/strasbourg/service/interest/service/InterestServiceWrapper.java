/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InterestService}.
 *
 * @author BenjaminBini
 * @see InterestService
 * @generated
 */
public class InterestServiceWrapper
	implements InterestService, ServiceWrapper<InterestService> {

	public InterestServiceWrapper() {
		this(null);
	}

	public InterestServiceWrapper(InterestService interestService) {
		_interestService = interestService;
	}

	/**
	 * Retourne la liste de tous les centres d'intérêt
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getInterests() {
		return _interestService.getInterests();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _interestService.getOSGiServiceIdentifier();
	}

	/**
	 * Retourne la liste des intérêts de l'utilisateur ayant l'id (publik) passé
	 * en paramètre
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserInterests(
		String userId) {

		return _interestService.getUserInterests(userId);
	}

	/**
	 * Modifie les intérêts de l'utilisateur ayant l'id (publik) passé en
	 * paramètre
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject setUserInterests(
		String userId, String interestIds) {

		return _interestService.setUserInterests(userId, interestIds);
	}

	@Override
	public InterestService getWrappedService() {
		return _interestService;
	}

	@Override
	public void setWrappedService(InterestService interestService) {
		_interestService = interestService;
	}

	private InterestService _interestService;

}