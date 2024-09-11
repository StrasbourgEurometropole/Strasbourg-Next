/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.link.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LinkService}.
 *
 * @author BenjaminBini
 * @see LinkService
 * @generated
 */
public class LinkServiceWrapper
	implements LinkService, ServiceWrapper<LinkService> {

	public LinkServiceWrapper() {
		this(null);
	}

	public LinkServiceWrapper(LinkService linkService) {
		_linkService = linkService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _linkService.getOSGiServiceIdentifier();
	}

	@Override
	public LinkService getWrappedService() {
		return _linkService;
	}

	@Override
	public void setWrappedService(LinkService linkService) {
		_linkService = linkService;
	}

	private LinkService _linkService;

}