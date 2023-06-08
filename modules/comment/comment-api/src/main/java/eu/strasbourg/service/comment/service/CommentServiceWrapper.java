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

package eu.strasbourg.service.comment.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommentService}.
 *
 * @author Romain Vergnais
 * @see CommentService
 * @generated
 */
public class CommentServiceWrapper
	implements CommentService, ServiceWrapper<CommentService> {

	public CommentServiceWrapper(CommentService commentService) {
		_commentService = commentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commentService.getOSGiServiceIdentifier();
	}

	@Override
	public CommentService getWrappedService() {
		return _commentService;
	}

	@Override
	public void setWrappedService(CommentService commentService) {
		_commentService = commentService;
	}

	private CommentService _commentService;

}