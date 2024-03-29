/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.notification.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import eu.strasbourg.service.notification.service.NotificationServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>NotificationServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>eu.strasbourg.service.notification.model.NotificationSoap</code>. If the method in the
 * service utility returns a
 * <code>eu.strasbourg.service.notification.model.Notification</code>, that is translated to a
 * <code>eu.strasbourg.service.notification.model.NotificationSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author BenjaminBini
 * @see NotificationServiceHttp
 * @generated
 */
public class NotificationServiceSoap {

	/**
	 * Retourne la liste des types de notifications
	 */
	public static String getTypes() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				NotificationServiceUtil.getTypes();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Retourne la liste des canaux de notifications
	 */
	public static String getChannels() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				NotificationServiceUtil.getChannels();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Retourne la liste des types et des canaux de communication d'un
	 * utilisateur
	 */
	public static String getUserSettings(String userId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				NotificationServiceUtil.getUserSettings(userId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Retourne la liste des notifications d'un utilisateur
	 */
	public static String getUserNotifications(String userId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				NotificationServiceUtil.getUserNotifications(userId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Modification des abonnements et des canaux de communication d'un
	 * utilisateur
	 */
	public static String setUserSettings(
			String userId, String typeIds, String channelIds)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				NotificationServiceUtil.setUserSettings(
					userId, typeIds, channelIds);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Envoie une notification à un utilisateur
	 */
	public static String addNotification(
			String userId, boolean isGlobal, String title, String description,
			String url, String publicationDate, String expirationDate,
			String typeId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				NotificationServiceUtil.addNotification(
					userId, isGlobal, title, description, url, publicationDate,
					expirationDate, typeId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		NotificationServiceSoap.class);

}