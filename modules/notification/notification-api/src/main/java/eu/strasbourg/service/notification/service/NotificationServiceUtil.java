/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Notification. This utility wraps
 * <code>eu.strasbourg.service.notification.service.impl.NotificationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author BenjaminBini
 * @see NotificationService
 * @generated
 */
public class NotificationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.notification.service.impl.NotificationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Envoie une notification à un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject addNotification(
		String userId, boolean isGlobal, String title, String description,
		String url, String publicationDate, String expirationDate,
		String typeId) {

		return getService().addNotification(
			userId, isGlobal, title, description, url, publicationDate,
			expirationDate, typeId);
	}

	/**
	 * Retourne la liste des canaux de notifications
	 */
	public static com.liferay.portal.kernel.json.JSONObject getChannels() {
		return getService().getChannels();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Retourne la liste des types de notifications
	 */
	public static com.liferay.portal.kernel.json.JSONObject getTypes()
		throws PortalException {

		return getService().getTypes();
	}

	/**
	 * Retourne la liste des notifications d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject
		getUserNotifications(String userId) {

		return getService().getUserNotifications(userId);
	}

	/**
	 * Retourne la liste des types et des canaux de communication d'un
	 * utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject getUserSettings(
		String userId) {

		return getService().getUserSettings(userId);
	}

	/**
	 * Modification des abonnements et des canaux de communication d'un
	 * utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject setUserSettings(
		String userId, String typeIds, String channelIds) {

		return getService().setUserSettings(userId, typeIds, channelIds);
	}

	public static NotificationService getService() {
		return _service;
	}

	public static void setService(NotificationService service) {
		_service = service;
	}

	private static volatile NotificationService _service;

}