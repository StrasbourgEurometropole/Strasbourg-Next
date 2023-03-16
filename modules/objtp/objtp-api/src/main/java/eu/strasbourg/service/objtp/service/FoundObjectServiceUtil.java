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

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for FoundObject. This utility wraps
 * <code>eu.strasbourg.service.objtp.service.impl.FoundObjectServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author JeremyZwickert
 * @see FoundObjectService
 * @generated
 */
public class FoundObjectServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.objtp.service.impl.FoundObjectServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Retourne la liste des objets d'une catégorie
	 *
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.json.JSONArray
			getFoundObjectByCategoryCode(String codeCategory)
		throws PortalException {

		return getService().getFoundObjectByCategoryCode(codeCategory);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static FoundObjectService getService() {
		return _service;
	}

	private static volatile FoundObjectService _service;

}