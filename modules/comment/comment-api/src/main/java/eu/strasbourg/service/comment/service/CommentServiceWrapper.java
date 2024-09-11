/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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

	public CommentServiceWrapper() {
		this(null);
	}

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