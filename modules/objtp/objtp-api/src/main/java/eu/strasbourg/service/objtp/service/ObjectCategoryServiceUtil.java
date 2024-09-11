/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.service;

/**
 * Provides the remote service utility for ObjectCategory. This utility wraps
 * <code>eu.strasbourg.service.objtp.service.impl.ObjectCategoryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author JeremyZwickert
 * @see ObjectCategoryService
 * @generated
 */
public class ObjectCategoryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.objtp.service.impl.ObjectCategoryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONArray
		getObjectCategories() {

		return getService().getObjectCategories();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ObjectCategoryService getService() {
		return _service;
	}

	public static void setService(ObjectCategoryService service) {
		_service = service;
	}

	private static volatile ObjectCategoryService _service;

}