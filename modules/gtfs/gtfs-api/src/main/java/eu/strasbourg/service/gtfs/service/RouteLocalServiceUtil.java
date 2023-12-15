/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.Route;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

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
	public static Route addRoute(Route route) {
		return getService().addRoute(route);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new route with the primary key. Does not add the route to the database.
	 *
	 * @param id the primary key for the new route
	 * @return the new route
	 */
	public static Route createRoute(long id) {
		return getService().createRoute(id);
	}

	/**
	 * Crée une Route vide avec une PK, non ajouté à la base de donnée
	 */
	public static Route createRoute(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createRoute(sc);
	}

	/**
	 * Crée un Route à partir d'une entrée GTFS
	 */
	public static Route createRouteFromGTFS(
			eu.strasbourg.utils.models.RoutesGTFS entry)
		throws PortalException {

		return getService().createRouteFromGTFS(entry);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

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
	public static Route deleteRoute(long id) throws PortalException {
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
	public static Route deleteRoute(Route route) {
		return getService().deleteRoute(route);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
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
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Route fetchRoute(long id) {
		return getService().fetchRoute(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Recuperer toutes les lignes
	 */
	public static List<Route> getAllRoutes() {
		return getService().getAllRoutes();
	}

	/**
	 * Recuperer une ligne via son routeId
	 */
	public static Route getByRouteId(String routeId) {
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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the route with the primary key.
	 *
	 * @param id the primary key of the route
	 * @return the route
	 * @throws PortalException if a route with the primary key could not be found
	 */
	public static Route getRoute(long id) throws PortalException {
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
	public static List<Route> getRoutes(int start, int end) {
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
			Map<String, eu.strasbourg.utils.models.RoutesGTFS> data)
		throws PortalException {

		getService().importFromGTFS(data);
	}

	/**
	 * Supprime toutes les Routes
	 */
	public static void removeAllRoutes() throws PortalException {
		getService().removeAllRoutes();
	}

	/**
	 * Supprime une Route
	 */
	public static Route removeRoute(long routeId) throws PortalException {
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
	public static Route updateRoute(Route route) {
		return getService().updateRoute(route);
	}

	/**
	 * Met à jour une Route et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static Route updateRoute(
			Route route, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateRoute(route, sc);
	}

	public static RouteLocalService getService() {
		return _service;
	}

	public static void setService(RouteLocalService service) {
		_service = service;
	}

	private static volatile RouteLocalService _service;

}