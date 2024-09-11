/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import eu.strasbourg.service.notification.service.NotificationServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>NotificationServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class NotificationServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject getTypes(
			HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getTypes",
				_getTypesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getChannels(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getChannels",
				_getChannelsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getUserSettings(
		HttpPrincipal httpPrincipal, String userId) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getUserSettings",
				_getUserSettingsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getUserNotifications(HttpPrincipal httpPrincipal, String userId) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "getUserNotifications",
				_getUserNotificationsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject setUserSettings(
		HttpPrincipal httpPrincipal, String userId, String typeIds,
		String channelIds) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "setUserSettings",
				_setUserSettingsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, typeIds, channelIds);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject addNotification(
		HttpPrincipal httpPrincipal, String userId, boolean isGlobal,
		String title, String description, String url, String publicationDate,
		String expirationDate, String typeId) {

		try {
			MethodKey methodKey = new MethodKey(
				NotificationServiceUtil.class, "addNotification",
				_addNotificationParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, isGlobal, title, description, url,
				publicationDate, expirationDate, typeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		NotificationServiceHttp.class);

	private static final Class<?>[] _getTypesParameterTypes0 = new Class[] {};
	private static final Class<?>[] _getChannelsParameterTypes1 =
		new Class[] {};
	private static final Class<?>[] _getUserSettingsParameterTypes2 =
		new Class[] {String.class};
	private static final Class<?>[] _getUserNotificationsParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[] _setUserSettingsParameterTypes4 =
		new Class[] {String.class, String.class, String.class};
	private static final Class<?>[] _addNotificationParameterTypes5 =
		new Class[] {
			String.class, boolean.class, String.class, String.class,
			String.class, String.class, String.class, String.class
		};

}