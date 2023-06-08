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

package eu.strasbourg.service.place.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Price. This utility wraps
 * <code>eu.strasbourg.service.place.service.impl.PriceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Angelique Zunino Champougny
 * @see PriceLocalService
 * @generated
 */
public class PriceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.PriceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the price to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param price the price
	 * @return the price that was added
	 */
	public static eu.strasbourg.service.place.model.Price addPrice(
		eu.strasbourg.service.place.model.Price price) {

		return getService().addPrice(price);
	}

	/**
	 * Creates a new price with the primary key. Does not add the price to the database.
	 *
	 * @param priceId the primary key for the new price
	 * @return the new price
	 */
	public static eu.strasbourg.service.place.model.Price createPrice(
		long priceId) {

		return getService().createPrice(priceId);
	}

	/**
	 * Crée un prix vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.place.model.Price createPrice(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPrice(sc);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priceId the primary key of the price
	 * @return the price that was removed
	 * @throws PortalException if a price with the primary key could not be found
	 */
	public static eu.strasbourg.service.place.model.Price deletePrice(
			long priceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePrice(priceId);
	}

	/**
	 * Deletes the price from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param price the price
	 * @return the price that was removed
	 */
	public static eu.strasbourg.service.place.model.Price deletePrice(
		eu.strasbourg.service.place.model.Price price) {

		return getService().deletePrice(price);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PriceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PriceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static eu.strasbourg.service.place.model.Price fetchPrice(
		long priceId) {

		return getService().fetchPrice(priceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the price with the primary key.
	 *
	 * @param priceId the primary key of the price
	 * @return the price
	 * @throws PortalException if a price with the primary key could not be found
	 */
	public static eu.strasbourg.service.place.model.Price getPrice(long priceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPrice(priceId);
	}

	/**
	 * Returns a range of all the prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @return the range of prices
	 */
	public static java.util.List<eu.strasbourg.service.place.model.Price>
		getPrices(int start, int end) {

		return getService().getPrices(start, end);
	}

	/**
	 * Returns the number of prices.
	 *
	 * @return the number of prices
	 */
	public static int getPricesCount() {
		return getService().getPricesCount();
	}

	/**
	 * Supprime un tarif
	 */
	public static eu.strasbourg.service.place.model.Price removePrice(
			long priceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removePrice(priceId);
	}

	/**
	 * Updates the price in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param price the price
	 * @return the price that was updated
	 */
	public static eu.strasbourg.service.place.model.Price updatePrice(
		eu.strasbourg.service.place.model.Price price) {

		return getService().updatePrice(price);
	}

	/**
	 * Met à jour un tarif et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.place.model.Price updatePrice(
			eu.strasbourg.service.place.model.Price price,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePrice(price, sc);
	}

	/**
	 * Met à jour le statut du tarif par le framework workflow
	 */
	public static eu.strasbourg.service.place.model.Price updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut du tarif "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			long userId, eu.strasbourg.service.place.model.Price price,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(userId, price, status);
	}

	public static PriceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PriceLocalService, PriceLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PriceLocalService.class);

		ServiceTracker<PriceLocalService, PriceLocalService> serviceTracker =
			new ServiceTracker<PriceLocalService, PriceLocalService>(
				bundle.getBundleContext(), PriceLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}