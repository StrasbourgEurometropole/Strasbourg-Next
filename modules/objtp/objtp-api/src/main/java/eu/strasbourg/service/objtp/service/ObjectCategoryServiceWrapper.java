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