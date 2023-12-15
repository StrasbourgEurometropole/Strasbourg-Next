/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ObjectCategoryService}.
 *
 * @author JeremyZwickert
 * @see ObjectCategoryService
 * @generated
 */
public class ObjectCategoryServiceWrapper
	implements ObjectCategoryService, ServiceWrapper<ObjectCategoryService> {

	public ObjectCategoryServiceWrapper() {
		this(null);
	}

	public ObjectCategoryServiceWrapper(
		ObjectCategoryService objectCategoryService) {

		_objectCategoryService = objectCategoryService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getObjectCategories() {
		return _objectCategoryService.getObjectCategories();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _objectCategoryService.getOSGiServiceIdentifier();
	}

	@Override
	public ObjectCategoryService getWrappedService() {
		return _objectCategoryService;
	}

	@Override
	public void setWrappedService(ObjectCategoryService objectCategoryService) {
		_objectCategoryService = objectCategoryService;
	}

	private ObjectCategoryService _objectCategoryService;

}