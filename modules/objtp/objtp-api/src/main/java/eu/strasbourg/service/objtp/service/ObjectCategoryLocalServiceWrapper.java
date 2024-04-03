/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ObjectCategoryLocalService}.
 *
 * @author JeremyZwickert
 * @see ObjectCategoryLocalService
 * @generated
 */
public class ObjectCategoryLocalServiceWrapper
	implements ObjectCategoryLocalService,
			   ServiceWrapper<ObjectCategoryLocalService> {

	public ObjectCategoryLocalServiceWrapper() {
		this(null);
	}

	public ObjectCategoryLocalServiceWrapper(
		ObjectCategoryLocalService objectCategoryLocalService) {

		_objectCategoryLocalService = objectCategoryLocalService;
	}

	/**
	 * Adds the object category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ObjectCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param objectCategory the object category
	 * @return the object category that was added
	 */
	@Override
	public eu.strasbourg.service.objtp.model.ObjectCategory addObjectCategory(
		eu.strasbourg.service.objtp.model.ObjectCategory objectCategory) {

		return _objectCategoryLocalService.addObjectCategory(objectCategory);
	}

	/**
	 * Creates a new object category with the primary key. Does not add the object category to the database.
	 *
	 * @param code the primary key for the new object category
	 * @return the new object category
	 */
	@Override
	public eu.strasbourg.service.objtp.model.ObjectCategory
		createObjectCategory(String code) {

		return _objectCategoryLocalService.createObjectCategory(code);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _objectCategoryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the object category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ObjectCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param objectCategory the object category
	 * @return the object category that was removed
	 */
	@Override
	public eu.strasbourg.service.objtp.model.ObjectCategory
		deleteObjectCategory(
			eu.strasbourg.service.objtp.model.ObjectCategory objectCategory) {

		return _objectCategoryLocalService.deleteObjectCategory(objectCategory);
	}

	/**
	 * Deletes the object category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ObjectCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param code the primary key of the object category
	 * @return the object category that was removed
	 * @throws PortalException if a object category with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.objtp.model.ObjectCategory
			deleteObjectCategory(String code)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _objectCategoryLocalService.deleteObjectCategory(code);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _objectCategoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _objectCategoryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _objectCategoryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _objectCategoryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _objectCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.objtp.model.impl.ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _objectCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.objtp.model.impl.ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _objectCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _objectCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _objectCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.objtp.model.ObjectCategory fetchObjectCategory(
		String code) {

		return _objectCategoryLocalService.fetchObjectCategory(code);
	}

	/**
	 * Returns a range of all the object categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.objtp.model.impl.ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of object categories
	 * @param end the upper bound of the range of object categories (not inclusive)
	 * @return the range of object categories
	 */
	@Override
	public java.util.List<eu.strasbourg.service.objtp.model.ObjectCategory>
		getObjectCategories(int start, int end) {

		return _objectCategoryLocalService.getObjectCategories(start, end);
	}

	/**
	 * Returns the number of object categories.
	 *
	 * @return the number of object categories
	 */
	@Override
	public int getObjectCategoriesCount() {
		return _objectCategoryLocalService.getObjectCategoriesCount();
	}

	/**
	 * Returns the object category with the primary key.
	 *
	 * @param code the primary key of the object category
	 * @return the object category
	 * @throws PortalException if a object category with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.objtp.model.ObjectCategory getObjectCategory(
			String code)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _objectCategoryLocalService.getObjectCategory(code);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _objectCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _objectCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the object category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ObjectCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param objectCategory the object category
	 * @return the object category that was updated
	 */
	@Override
	public eu.strasbourg.service.objtp.model.ObjectCategory
		updateObjectCategory(
			eu.strasbourg.service.objtp.model.ObjectCategory objectCategory) {

		return _objectCategoryLocalService.updateObjectCategory(objectCategory);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _objectCategoryLocalService.getBasePersistence();
	}

	@Override
	public ObjectCategoryLocalService getWrappedService() {
		return _objectCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ObjectCategoryLocalService objectCategoryLocalService) {

		_objectCategoryLocalService = objectCategoryLocalService;
	}

	private ObjectCategoryLocalService _objectCategoryLocalService;

}