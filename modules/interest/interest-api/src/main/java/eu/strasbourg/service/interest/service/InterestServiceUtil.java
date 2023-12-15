/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.service;

/**
 * Provides the remote service utility for Interest. This utility wraps
 * <code>eu.strasbourg.service.interest.service.impl.InterestServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author BenjaminBini
 * @see InterestService
 * @generated
 */
public class InterestServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.interest.service.impl.InterestServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Retourne la liste de tous les centres d'intérêt
	 */
	public static com.liferay.portal.kernel.json.JSONObject getInterests() {
		return getService().getInterests();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Retourne la liste des intérêts de l'utilisateur ayant l'id (publik) passé
	 * en paramètre
	 */
	public static com.liferay.portal.kernel.json.JSONObject getUserInterests(
		java.lang.String userId) {

		return getService().getUserInterests(userId);
	}

	/**
	 * Modifie les intérêts de l'utilisateur ayant l'id (publik) passé en
	 * paramètre
	 */
	public static com.liferay.portal.kernel.json.JSONObject setUserInterests(
		java.lang.String userId, java.lang.String interestIds) {

		return getService().setUserInterests(userId, interestIds);
	}

	public static InterestService getService() {
		return _service;
	}

	public static void setService(InterestService service) {
		_service = service;
	}

	private static volatile InterestService _service;

}