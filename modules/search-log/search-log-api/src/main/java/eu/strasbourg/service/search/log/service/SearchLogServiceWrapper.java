/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.search.log.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SearchLogService}.
 *
 * @author BenjaminBini
 * @see SearchLogService
 * @generated
 */
public class SearchLogServiceWrapper
	implements SearchLogService, ServiceWrapper<SearchLogService> {

	public SearchLogServiceWrapper() {
		this(null);
	}

	public SearchLogServiceWrapper(SearchLogService searchLogService) {
		_searchLogService = searchLogService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _searchLogService.getOSGiServiceIdentifier();
	}

	@Override
	public SearchLogService getWrappedService() {
		return _searchLogService;
	}

	@Override
	public void setWrappedService(SearchLogService searchLogService) {
		_searchLogService = searchLogService;
	}

	private SearchLogService _searchLogService;

}