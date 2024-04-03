/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import eu.strasbourg.service.favorite.service.FavoriteServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>FavoriteServiceUtil</code> service
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
public class FavoriteServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject getTypes(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				FavoriteServiceUtil.class, "getTypes",
				_getTypesParameterTypes0);

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

	public static com.liferay.portal.kernel.json.JSONObject getUserFavorites(
		HttpPrincipal httpPrincipal, String userId) {

		try {
			MethodKey methodKey = new MethodKey(
				FavoriteServiceUtil.class, "getUserFavorites",
				_getUserFavoritesParameterTypes1);

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

	public static com.liferay.portal.kernel.json.JSONObject addFavorite(
		HttpPrincipal httpPrincipal, String title, String url, long typeId,
		String userId, long entityId) {

		try {
			MethodKey methodKey = new MethodKey(
				FavoriteServiceUtil.class, "addFavorite",
				_addFavoriteParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, url, typeId, userId, entityId);

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

	public static com.liferay.portal.kernel.json.JSONObject addFavoriteLink(
		HttpPrincipal httpPrincipal, String title, String url, long typeId,
		long entityId, long entityGroupId) {

		try {
			MethodKey methodKey = new MethodKey(
				FavoriteServiceUtil.class, "addFavoriteLink",
				_addFavoriteLinkParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, url, typeId, entityId, entityGroupId);

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

	public static com.liferay.portal.kernel.json.JSONObject deleteFavorite(
		HttpPrincipal httpPrincipal, String userId, long favoriteId) {

		try {
			MethodKey methodKey = new MethodKey(
				FavoriteServiceUtil.class, "deleteFavorite",
				_deleteFavoriteParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, favoriteId);

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

	public static com.liferay.portal.kernel.json.JSONObject deleteFavoriteLink(
		HttpPrincipal httpPrincipal, String title, String url, long typeId,
		long entityId) {

		try {
			MethodKey methodKey = new MethodKey(
				FavoriteServiceUtil.class, "deleteFavoriteLink",
				_deleteFavoriteLinkParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, url, typeId, entityId);

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

	private static Log _log = LogFactoryUtil.getLog(FavoriteServiceHttp.class);

	private static final Class<?>[] _getTypesParameterTypes0 = new Class[] {};
	private static final Class<?>[] _getUserFavoritesParameterTypes1 =
		new Class[] {String.class};
	private static final Class<?>[] _addFavoriteParameterTypes2 = new Class[] {
		String.class, String.class, long.class, String.class, long.class
	};
	private static final Class<?>[] _addFavoriteLinkParameterTypes3 =
		new Class[] {
			String.class, String.class, long.class, long.class, long.class
		};
	private static final Class<?>[] _deleteFavoriteParameterTypes4 =
		new Class[] {String.class, long.class};
	private static final Class<?>[] _deleteFavoriteLinkParameterTypes5 =
		new Class[] {String.class, String.class, long.class, long.class};

}