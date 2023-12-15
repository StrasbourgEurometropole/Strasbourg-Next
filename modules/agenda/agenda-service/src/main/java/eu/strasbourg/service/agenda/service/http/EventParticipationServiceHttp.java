/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import eu.strasbourg.service.agenda.service.EventParticipationServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>EventParticipationServiceUtil</code> service
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
public class EventParticipationServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject
		getUserEventParticipations(HttpPrincipal httpPrincipal, String userId) {

		try {
			MethodKey methodKey = new MethodKey(
				EventParticipationServiceUtil.class,
				"getUserEventParticipations",
				_getUserEventParticipationsParameterTypes0);

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
		addEventParticipationLink(
			HttpPrincipal httpPrincipal, long eventId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				EventParticipationServiceUtil.class,
				"addEventParticipationLink",
				_addEventParticipationLinkParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, eventId, groupId);

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
		deleteEventParticipationLink(
			HttpPrincipal httpPrincipal, long eventId) {

		try {
			MethodKey methodKey = new MethodKey(
				EventParticipationServiceUtil.class,
				"deleteEventParticipationLink",
				_deleteEventParticipationLinkParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, eventId);

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

	public static com.liferay.portal.kernel.json.JSONObject isUserParticipates(
		HttpPrincipal httpPrincipal, long eventId) {

		try {
			MethodKey methodKey = new MethodKey(
				EventParticipationServiceUtil.class, "isUserParticipates",
				_isUserParticipatesParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, eventId);

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
		EventParticipationServiceHttp.class);

	private static final Class<?>[] _getUserEventParticipationsParameterTypes0 =
		new Class[] {String.class};
	private static final Class<?>[] _addEventParticipationLinkParameterTypes1 =
		new Class[] {long.class, long.class};
	private static final Class<?>[]
		_deleteEventParticipationLinkParameterTypes2 = new Class[] {long.class};
	private static final Class<?>[] _isUserParticipatesParameterTypes3 =
		new Class[] {long.class};

}