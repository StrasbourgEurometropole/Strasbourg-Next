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

package eu.strasbourg.service.favorite.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import eu.strasbourg.service.favorite.service.FavoriteServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>FavoriteServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>eu.strasbourg.service.favorite.model.FavoriteSoap</code>. If the method in the
 * service utility returns a
 * <code>eu.strasbourg.service.favorite.model.Favorite</code>, that is translated to a
 * <code>eu.strasbourg.service.favorite.model.FavoriteSoap</code>. Methods that SOAP
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
 * @see FavoriteServiceHttp
 * @generated
 */
public class FavoriteServiceSoap {

	/**
	 * Retourne la liste des types de favoris
	 */
	public static String getTypes() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				FavoriteServiceUtil.getTypes();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Retourne les favoris d'un utilisateur
	 */
	public static String getUserFavorites(String userId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				FavoriteServiceUtil.getUserFavorites(userId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Ajoute un favoris à un utilisateur
	 */
	public static String addFavorite(
			String title, String url, long typeId, String userId, long entityId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				FavoriteServiceUtil.addFavorite(
					title, url, typeId, userId, entityId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Ajoute un favori à un utilisateur
	 */
	public static String addFavoriteLink(
			String title, String url, long typeId, long entityId,
			long entityGroupId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				FavoriteServiceUtil.addFavoriteLink(
					title, url, typeId, entityId, entityGroupId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Supprime un favoris d'un utilisateur
	 */
	public static String deleteFavorite(String userId, long favoriteId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				FavoriteServiceUtil.deleteFavorite(userId, favoriteId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Supprime un favoris d'un utilisateur
	 */
	public static String deleteFavoriteLink(
			String title, String url, long typeId, long entityId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				FavoriteServiceUtil.deleteFavoriteLink(
					title, url, typeId, entityId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FavoriteServiceSoap.class);

}