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

package eu.strasbourg.service.gtfs.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Route. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.RouteLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see RouteLocalService
 * @generated
 */
public class RouteLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.RouteLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the route to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RouteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param route the route
	 * @return the route that was added
	 */
	public static eu.strasbourg.service.gtfs.model.Route addRoute(
		eu.strasbourg.service.gtfs.model.Route route) {

		return getService().addRoute(route);
	}

	/**
	 * Creates a new route with the primary key. Does not add the route to the database.
	 *
	 * @param id the primary key for the new route
	 * @return the new route
	 */
	public static eu.strasbourg.service.gtfs.model.Route createRoute(long id) {
		return getService().createRoute(id);
	}

	/**
	 * Crée une Route vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.gtfs.model.Route createRoute(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createRoute(sc);
	}

	/**
	 * Crée un Route à partir d'une entrée GTFS
	 */
	public static eu.strasbourg.service.gtfs.model.Route createRouteFromGTFS(
			eu.strasbourg.utils.models.RoutesGTFS entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createRouteFromGTFS(entry);
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
	 * Deletes the route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RouteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the route
	 * @return the route that was removed
	 * @throws PortalException if a route with the primary key could not be found
	 */
	public static eu.strasbourg.service.gtfs.model.Route deleteRoute(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRoute(id);
	}

	/**
	 * Deletes the route from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RouteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param route the route
	 * @return the route that was removed
	 */
	public static eu.strasbourg.service.gtfs.model.Route deleteRoute(
		eu.strasbourg.service.gtfs.model.Route route) {

		return getService().deleteRoute(route);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.RouteModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.RouteModelImpl</code>.
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

	public static eu.strasbourg.service.gtfs.model.Route fetchRoute(long id) {
		return getService().fetchRoute(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Recuperer toutes les lignes
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.Route>
		getAllRoutes() {

		return getService().getAllRoutes();
	}

	/**
	 * Recuperer une ligne via son routeId
	 */
	public static eu.strasbourg.service.gtfs.model.Route getByRouteId(
		String routeId) {

		return getService().getByRouteId(routeId);
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
	 * Returns the route with the primary key.
	 *
	 * @param id the primary key of the route
	 * @return the route
	 * @throws PortalException if a route with the primary key could not be found
	 */
	public static eu.strasbourg.service.gtfs.model.Route getRoute(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRoute(id);
	}

	/**
	 * Returns a range of all the routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.RouteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @return the range of routes
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.Route>
		getRoutes(int start, int end) {

		return getService().getRoutes(start, end);
	}

	/**
	 * Returns the number of routes.
	 *
	 * @return the number of routes
	 */
	public static int getRoutesCount() {
		return getService().getRoutesCount();
	}

	/**
	 * Import des lignes sous le format de données GTFS
	 */
	public static void importFromGTFS(
			java.util.Map<String, eu.strasbourg.utils.models.RoutesGTFS> data)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().importFromGTFS(data);
	}

	/**
	 * Supprime toutes les Routes
	 */
	public static void removeAllRoutes()
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().removeAllRoutes();
	}

	/**
	 * Supprime une Route
	 */
	public static eu.strasbourg.service.gtfs.model.Route removeRoute(
			long routeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeRoute(routeId);
	}

	/**
	 * Updates the route in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RouteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param route the route
	 * @return the route that was updated
	 */
	public static eu.strasbourg.service.gtfs.model.Route updateRoute(
		eu.strasbourg.service.gtfs.model.Route route) {

		return getService().updateRoute(route);
	}

	/**
	 * Met à jour une Route et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static eu.strasbourg.service.gtfs.model.Route updateRoute(
			eu.strasbourg.service.gtfs.model.Route route,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateRoute(route, sc);
	}

	public static RouteLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RouteLocalService, RouteLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RouteLocalService.class);

		ServiceTracker<RouteLocalService, RouteLocalService> serviceTracker =
			new ServiceTracker<RouteLocalService, RouteLocalService>(
				bundle.getBundleContext(), RouteLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}