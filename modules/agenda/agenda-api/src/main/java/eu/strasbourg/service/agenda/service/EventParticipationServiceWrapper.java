/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventParticipationService}.
 *
 * @author BenjaminBini
 * @see EventParticipationService
 * @generated
 */
public class EventParticipationServiceWrapper
	implements EventParticipationService,
			   ServiceWrapper<EventParticipationService> {

	public EventParticipationServiceWrapper() {
		this(null);
	}

	public EventParticipationServiceWrapper(
		EventParticipationService eventParticipationService) {

		_eventParticipationService = eventParticipationService;
	}

	/**
	 * Ajoute une participation à un utilisateur
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject addEventParticipationLink(
		long eventId, long groupId) {

		return _eventParticipationService.addEventParticipationLink(
			eventId, groupId);
	}

	/**
	 * Supprime une participation d'evenement d'un utilisateur
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject
		deleteEventParticipationLink(long eventId) {

		return _eventParticipationService.deleteEventParticipationLink(eventId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventParticipationService.getOSGiServiceIdentifier();
	}

	/**
	 * Retourne les participation d'evenement d'un utilisateur
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserEventParticipations(
		String userId) {

		return _eventParticipationService.getUserEventParticipations(userId);
	}

	/**
	 * Verifie si l'utilisateur courant participe a l'evenement
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject isUserParticipates(
		long eventId) {

		return _eventParticipationService.isUserParticipates(eventId);
	}

	@Override
	public EventParticipationService getWrappedService() {
		return _eventParticipationService;
	}

	@Override
	public void setWrappedService(
		EventParticipationService eventParticipationService) {

		_eventParticipationService = eventParticipationService;
	}

	private EventParticipationService _eventParticipationService;

}