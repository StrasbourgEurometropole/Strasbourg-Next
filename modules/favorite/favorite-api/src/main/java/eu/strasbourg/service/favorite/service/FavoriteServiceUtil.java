/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.service;

/**
 * Provides the remote service utility for Favorite. This utility wraps
 * <code>eu.strasbourg.service.favorite.service.impl.FavoriteServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author BenjaminBini
 * @see FavoriteService
 * @generated
 */
public class FavoriteServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.favorite.service.impl.FavoriteServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Ajoute un favoris à un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject addFavorite(
		java.lang.String title, java.lang.String url, long typeId,
		java.lang.String userId, long entityId) {

		return getService().addFavorite(title, url, typeId, userId, entityId);
	}

	/**
	 * Ajoute un favori à un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject addFavoriteLink(
		java.lang.String title, java.lang.String url, long typeId,
		long entityId, long entityGroupId) {

		return getService().addFavoriteLink(
			title, url, typeId, entityId, entityGroupId);
	}

	/**
	 * Supprime un favoris d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject deleteFavorite(
		java.lang.String userId, long favoriteId) {

		return getService().deleteFavorite(userId, favoriteId);
	}

	/**
	 * Supprime un favoris d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject deleteFavoriteLink(
		java.lang.String title, java.lang.String url, long typeId,
		long entityId) {

		return getService().deleteFavoriteLink(title, url, typeId, entityId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Retourne la liste des types de favoris
	 */
	public static com.liferay.portal.kernel.json.JSONObject getTypes() {
		return getService().getTypes();
	}

	/**
	 * Retourne les favoris d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject getUserFavorites(
		java.lang.String userId) {

		return getService().getUserFavorites(userId);
	}

	public static FavoriteService getService() {
		return _service;
	}

	public static void setService(FavoriteService service) {
		_service = service;
	}

	private static volatile FavoriteService _service;

}