/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import eu.strasbourg.service.gtfs.service.ArretServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ArretServiceUtil</code> service
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
 * @author Cedric Henry
 * @generated
 */
public class ArretServiceHttp {

	public static com.liferay.portal.kernel.json.JSONArray getArretRealTime(
		HttpPrincipal httpPrincipal, String stopCode) {

		try {
			MethodKey methodKey = new MethodKey(
				ArretServiceUtil.class, "getArretRealTime",
				_getArretRealTimeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, stopCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getArretRealTime(
		HttpPrincipal httpPrincipal, String stopCode, int type, int timeOut) {

		try {
			MethodKey methodKey = new MethodKey(
				ArretServiceUtil.class, "getArretRealTime",
				_getArretRealTimeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, stopCode, type, timeOut);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<String> getAlerts(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				ArretServiceUtil.class, "getAlerts", _getAlertsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ArretServiceHttp.class);

	private static final Class<?>[] _getArretRealTimeParameterTypes0 =
		new Class[] {String.class};
	private static final Class<?>[] _getArretRealTimeParameterTypes1 =
		new Class[] {String.class, int.class, int.class};
	private static final Class<?>[] _getAlertsParameterTypes2 = new Class[] {};

}