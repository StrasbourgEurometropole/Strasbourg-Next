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

package eu.strasbourg.service.like.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LikeService}.
 *
 * @author Cedric Henry
 * @see LikeService
 * @generated
 */
public class LikeServiceWrapper
	implements LikeService, ServiceWrapper<LikeService> {

	public LikeServiceWrapper() {
		this(null);
	}

	public LikeServiceWrapper(LikeService likeService) {
		_likeService = likeService;
	}

	/**
	 * Ajoute un like/dislike d'un utilisateur a une entite
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject addLike(
		String userId, String title, boolean isDislike, long typeId,
		long entityId) {

		return _likeService.addLike(userId, title, isDislike, typeId, entityId);
	}

	/**
	 * Ajoute un like à un utilisateur
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject addLikeLink(
		String title, boolean isDislike, long typeId, long entityId,
		long entityGroupId) {

		return _likeService.addLikeLink(
			title, isDislike, typeId, entityId, entityGroupId);
	}

	/**
	 * Supprime un like d'un utilisateur
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject deleteLike(
		String userId, long likeId) {

		return _likeService.deleteLike(userId, likeId);
	}

	/**
	 * Supprime un like d'un utilisateur
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject deleteLikeLink(
		String title, String url, boolean isDislike, long typeId,
		long entityId) {

		return _likeService.deleteLikeLink(
			title, url, isDislike, typeId, entityId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _likeService.getOSGiServiceIdentifier();
	}

	/**
	 * Retourne la liste des types de likes/dislikes
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getTypes() {
		return _likeService.getTypes();
	}

	/**
	 * Retourne les likes d'un utilisateur
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserLikes(
		String userId) {

		return _likeService.getUserLikes(userId);
	}

	@Override
	public LikeService getWrappedService() {
		return _likeService;
	}

	@Override
	public void setWrappedService(LikeService likeService) {
		_likeService = likeService;
	}

	private LikeService _likeService;

}