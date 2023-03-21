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

package eu.strasbourg.service.objtp.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.objtp.model.ObjectCategory;
import eu.strasbourg.service.objtp.service.ObjectCategoryService;
import eu.strasbourg.service.objtp.service.ObjectCategoryServiceUtil;
import eu.strasbourg.service.objtp.service.persistence.FoundObjectPersistence;
import eu.strasbourg.service.objtp.service.persistence.ObjectCategoryPersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the object category remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.objtp.service.impl.ObjectCategoryServiceImpl}.
 * </p>
 *
 * @author JeremyZwickert
 * @see eu.strasbourg.service.objtp.service.impl.ObjectCategoryServiceImpl
 * @generated
 */
public abstract class ObjectCategoryServiceBaseImpl
	extends BaseServiceImpl
	implements IdentifiableOSGiService, ObjectCategoryService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ObjectCategoryService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ObjectCategoryServiceUtil</code>.
	 */

	/**
	 * Returns the found object local service.
	 *
	 * @return the found object local service
	 */
	public eu.strasbourg.service.objtp.service.FoundObjectLocalService
		getFoundObjectLocalService() {

		return foundObjectLocalService;
	}

	/**
	 * Sets the found object local service.
	 *
	 * @param foundObjectLocalService the found object local service
	 */
	public void setFoundObjectLocalService(
		eu.strasbourg.service.objtp.service.FoundObjectLocalService
			foundObjectLocalService) {

		this.foundObjectLocalService = foundObjectLocalService;
	}

	/**
	 * Returns the found object remote service.
	 *
	 * @return the found object remote service
	 */
	public eu.strasbourg.service.objtp.service.FoundObjectService
		getFoundObjectService() {

		return foundObjectService;
	}

	/**
	 * Sets the found object remote service.
	 *
	 * @param foundObjectService the found object remote service
	 */
	public void setFoundObjectService(
		eu.strasbourg.service.objtp.service.FoundObjectService
			foundObjectService) {

		this.foundObjectService = foundObjectService;
	}

	/**
	 * Returns the found object persistence.
	 *
	 * @return the found object persistence
	 */
	public FoundObjectPersistence getFoundObjectPersistence() {
		return foundObjectPersistence;
	}

	/**
	 * Sets the found object persistence.
	 *
	 * @param foundObjectPersistence the found object persistence
	 */
	public void setFoundObjectPersistence(
		FoundObjectPersistence foundObjectPersistence) {

		this.foundObjectPersistence = foundObjectPersistence;
	}

	/**
	 * Returns the object category local service.
	 *
	 * @return the object category local service
	 */
	public eu.strasbourg.service.objtp.service.ObjectCategoryLocalService
		getObjectCategoryLocalService() {

		return objectCategoryLocalService;
	}

	/**
	 * Sets the object category local service.
	 *
	 * @param objectCategoryLocalService the object category local service
	 */
	public void setObjectCategoryLocalService(
		eu.strasbourg.service.objtp.service.ObjectCategoryLocalService
			objectCategoryLocalService) {

		this.objectCategoryLocalService = objectCategoryLocalService;
	}

	/**
	 * Returns the object category remote service.
	 *
	 * @return the object category remote service
	 */
	public ObjectCategoryService getObjectCategoryService() {
		return objectCategoryService;
	}

	/**
	 * Sets the object category remote service.
	 *
	 * @param objectCategoryService the object category remote service
	 */
	public void setObjectCategoryService(
		ObjectCategoryService objectCategoryService) {

		this.objectCategoryService = objectCategoryService;
	}

	/**
	 * Returns the object category persistence.
	 *
	 * @return the object category persistence
	 */
	public ObjectCategoryPersistence getObjectCategoryPersistence() {
		return objectCategoryPersistence;
	}

	/**
	 * Sets the object category persistence.
	 *
	 * @param objectCategoryPersistence the object category persistence
	 */
	public void setObjectCategoryPersistence(
		ObjectCategoryPersistence objectCategoryPersistence) {

		this.objectCategoryPersistence = objectCategoryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		_setServiceUtilService(objectCategoryService);
	}

	public void destroy() {
		_setServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ObjectCategoryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ObjectCategory.class;
	}

	protected String getModelClassName() {
		return ObjectCategory.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = objectCategoryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(
		ObjectCategoryService objectCategoryService) {

		try {
			Field field = ObjectCategoryServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, objectCategoryService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.objtp.service.FoundObjectLocalService.class
	)
	protected eu.strasbourg.service.objtp.service.FoundObjectLocalService
		foundObjectLocalService;

	@BeanReference(
		type = eu.strasbourg.service.objtp.service.FoundObjectService.class
	)
	protected eu.strasbourg.service.objtp.service.FoundObjectService
		foundObjectService;

	@BeanReference(type = FoundObjectPersistence.class)
	protected FoundObjectPersistence foundObjectPersistence;

	@BeanReference(
		type = eu.strasbourg.service.objtp.service.ObjectCategoryLocalService.class
	)
	protected eu.strasbourg.service.objtp.service.ObjectCategoryLocalService
		objectCategoryLocalService;

	@BeanReference(type = ObjectCategoryService.class)
	protected ObjectCategoryService objectCategoryService;

	@BeanReference(type = ObjectCategoryPersistence.class)
	protected ObjectCategoryPersistence objectCategoryPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ObjectCategoryServiceBaseImpl.class);

}