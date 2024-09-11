/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.like.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import eu.strasbourg.service.like.service.LikeServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>LikeServiceUtil</code> service
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
public class LikeServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject getTypes(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				LikeServiceUtil.class, "getTypes", _getTypesParameterTypes0);

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

	public static com.liferay.portal.kernel.json.JSONObject getUserLikes(
		HttpPrincipal httpPrincipal, String userId) {

		try {
			MethodKey methodKey = new MethodKey(
				LikeServiceUtil.class, "getUserLikes",
				_getUserLikesParameterTypes1);

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

	public static com.liferay.portal.kernel.json.JSONObject addLike(
		HttpPrincipal httpPrincipal, String userId, String title,
		boolean isDislike, long typeId, long entityId) {

		try {
			MethodKey methodKey = new MethodKey(
				LikeServiceUtil.class, "addLike", _addLikeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, title, isDislike, typeId, entityId);

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

	public static com.liferay.portal.kernel.json.JSONObject addLikeLink(
		HttpPrincipal httpPrincipal, String title, boolean isDislike,
		long typeId, long entityId, long entityGroupId) {

		try {
			MethodKey methodKey = new MethodKey(
				LikeServiceUtil.class, "addLikeLink",
				_addLikeLinkParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, isDislike, typeId, entityId, entityGroupId);

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

	public static com.liferay.portal.kernel.json.JSONObject deleteLike(
		HttpPrincipal httpPrincipal, String userId, long likeId) {

		try {
			MethodKey methodKey = new MethodKey(
				LikeServiceUtil.class, "deleteLike",
				_deleteLikeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, likeId);

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

	public static com.liferay.portal.kernel.json.JSONObject deleteLikeLink(
		HttpPrincipal httpPrincipal, String title, String url,
		boolean isDislike, long typeId, long entityId) {

		try {
			MethodKey methodKey = new MethodKey(
				LikeServiceUtil.class, "deleteLikeLink",
				_deleteLikeLinkParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, url, isDislike, typeId, entityId);

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

	private static Log _log = LogFactoryUtil.getLog(LikeServiceHttp.class);

	private static final Class<?>[] _getTypesParameterTypes0 = new Class[] {};
	private static final Class<?>[] _getUserLikesParameterTypes1 = new Class[] {
		String.class
	};
	private static final Class<?>[] _addLikeParameterTypes2 = new Class[] {
		String.class, String.class, boolean.class, long.class, long.class
	};
	private static final Class<?>[] _addLikeLinkParameterTypes3 = new Class[] {
		String.class, boolean.class, long.class, long.class, long.class
	};
	private static final Class<?>[] _deleteLikeParameterTypes4 = new Class[] {
		String.class, long.class
	};
	private static final Class<?>[] _deleteLikeLinkParameterTypes5 =
		new Class[] {
			String.class, String.class, boolean.class, long.class, long.class
		};

}