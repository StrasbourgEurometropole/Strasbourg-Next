/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

/**
 * Provides the remote service utility for EventParticipation. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.EventParticipationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author BenjaminBini
 * @see EventParticipationService
 * @generated
 */
public class EventParticipationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.EventParticipationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Ajoute une participation à un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject
		addEventParticipationLink(long eventId, long groupId) {

		return getService().addEventParticipationLink(eventId, groupId);
	}

	/**
	 * Supprime une participation d'evenement d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject
		deleteEventParticipationLink(long eventId) {

		return getService().deleteEventParticipationLink(eventId);
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
	 * Retourne les participation d'evenement d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject
		getUserEventParticipations(java.lang.String userId) {

		return getService().getUserEventParticipations(userId);
	}

	/**
	 * Verifie si l'utilisateur courant participe a l'evenement
	 */
	public static com.liferay.portal.kernel.json.JSONObject isUserParticipates(
		long eventId) {

		return getService().isUserParticipates(eventId);
	}

	public static EventParticipationService getService() {
		return _service;
	}

	public static void setService(EventParticipationService service) {
		_service = service;
	}

	private static volatile EventParticipationService _service;

}