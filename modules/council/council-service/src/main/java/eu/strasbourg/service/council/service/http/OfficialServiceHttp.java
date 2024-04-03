/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import eu.strasbourg.service.council.service.OfficialServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>OfficialServiceUtil</code> service
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
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OfficialServiceHttp {

	public static com.liferay.portal.kernel.json.JSONArray
		getOfficialByFullNameAndType(
			HttpPrincipal httpPrincipal, String fullName, String type,
			long removedOfficialId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				OfficialServiceUtil.class, "getOfficialByFullNameAndType",
				_getOfficialByFullNameAndTypeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fullName, type, removedOfficialId, groupId);

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

	public static com.liferay.portal.kernel.json.JSONObject
		getOfficialByConnexionStatus(
			HttpPrincipal httpPrincipal, long councilSessionId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				OfficialServiceUtil.class, "getOfficialByConnexionStatus",
				_getOfficialByConnexionStatusParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, councilSessionId, groupId);

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

	private static Log _log = LogFactoryUtil.getLog(OfficialServiceHttp.class);

	private static final Class<?>[]
		_getOfficialByFullNameAndTypeParameterTypes0 = new Class[] {
			String.class, String.class, long.class, long.class
		};
	private static final Class<?>[]
		_getOfficialByConnexionStatusParameterTypes1 = new Class[] {
			long.class, long.class
		};

}