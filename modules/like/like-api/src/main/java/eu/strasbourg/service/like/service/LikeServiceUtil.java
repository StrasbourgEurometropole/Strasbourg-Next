/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.like.service;

/**
 * Provides the remote service utility for Like. This utility wraps
 * <code>eu.strasbourg.service.like.service.impl.LikeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Cedric Henry
 * @see LikeService
 * @generated
 */
public class LikeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.like.service.impl.LikeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Ajoute un like/dislike d'un utilisateur a une entite
	 */
	public static com.liferay.portal.kernel.json.JSONObject addLike(
		java.lang.String userId, java.lang.String title, boolean isDislike,
		long typeId, long entityId) {

		return getService().addLike(userId, title, isDislike, typeId, entityId);
	}

	/**
	 * Ajoute un like à un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject addLikeLink(
		java.lang.String title, boolean isDislike, long typeId, long entityId,
		long entityGroupId) {

		return getService().addLikeLink(
			title, isDislike, typeId, entityId, entityGroupId);
	}

	/**
	 * Supprime un like d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject deleteLike(
		java.lang.String userId, long likeId) {

		return getService().deleteLike(userId, likeId);
	}

	/**
	 * Supprime un like d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject deleteLikeLink(
		java.lang.String title, java.lang.String url, boolean isDislike,
		long typeId, long entityId) {

		return getService().deleteLikeLink(
			title, url, isDislike, typeId, entityId);
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
	 * Retourne la liste des types de likes/dislikes
	 */
	public static com.liferay.portal.kernel.json.JSONObject getTypes() {
		return getService().getTypes();
	}

	/**
	 * Retourne les likes d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject getUserLikes(
		java.lang.String userId) {

		return getService().getUserLikes(userId);
	}

	public static LikeService getService() {
		return _service;
	}

	public static void setService(LikeService service) {
		_service = service;
	}

	private static volatile LikeService _service;

}