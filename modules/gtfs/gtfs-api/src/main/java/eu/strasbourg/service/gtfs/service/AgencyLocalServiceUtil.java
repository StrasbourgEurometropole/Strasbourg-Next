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

import eu.strasbourg.service.gtfs.model.Agency;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Agency. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.AgencyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see AgencyLocalService
 * @generated
 */
public class AgencyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.AgencyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the agency to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was added
	 */
	public static Agency addAgency(Agency agency) {
		return getService().addAgency(agency);
	}

	/**
	 * Creates a new agency with the primary key. Does not add the agency to the database.
	 *
	 * @param id the primary key for the new agency
	 * @return the new agency
	 */
	public static Agency createAgency(long id) {
		return getService().createAgency(id);
	}

	/**
	 * Crée une agence vide avec une PK, non ajouté à la base de donnée
	 */
	public static Agency createAgency(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createAgency(sc);
	}

	/**
	 * Crée une agence à partir d'une entrée GTFS
	 */
	public static Agency createAgencyFromGTFS(
			eu.strasbourg.utils.models.AgencyGTFS entry)
		throws PortalException {

		return getService().createAgencyFromGTFS(entry);
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
	 * Deletes the agency from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was removed
	 */
	public static Agency deleteAgency(Agency agency) {
		return getService().deleteAgency(agency);
	}

	/**
	 * Deletes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the agency
	 * @return the agency that was removed
	 * @throws PortalException if a agency with the primary key could not be found
	 */
	public static Agency deleteAgency(long id) throws PortalException {
		return getService().deleteAgency(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
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

	public static Agency fetchAgency(long id) {
		return getService().fetchAgency(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the agencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @return the range of agencies
	 */
	public static List<Agency> getAgencies(int start, int end) {
		return getService().getAgencies(start, end);
	}

	/**
	 * Returns the number of agencies.
	 *
	 * @return the number of agencies
	 */
	public static int getAgenciesCount() {
		return getService().getAgenciesCount();
	}

	/**
	 * Returns the agency with the primary key.
	 *
	 * @param id the primary key of the agency
	 * @return the agency
	 * @throws PortalException if a agency with the primary key could not be found
	 */
	public static Agency getAgency(long id) throws PortalException {
		return getService().getAgency(id);
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
	 * Import des agences sous le format de données GTFS
	 */
	public static void importFromGTFS(
			Map<String, eu.strasbourg.utils.models.AgencyGTFS> data)
		throws PortalException {

		getService().importFromGTFS(data);
	}

	/**
	 * Supprime une agence
	 */
	public static Agency removeAgency(long agencyId) throws PortalException {
		return getService().removeAgency(agencyId);
	}

	/**
	 * Supprime toutes les agences
	 */
	public static void removeAllAgencies() throws PortalException {
		getService().removeAllAgencies();
	}

	/**
	 * Updates the agency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was updated
	 */
	public static Agency updateAgency(Agency agency) {
		return getService().updateAgency(agency);
	}

	/**
	 * Met à jour une agence et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static Agency updateAgency(
			Agency agency, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateAgency(agency, sc);
	}

	public static AgencyLocalService getService() {
		return _service;
	}

	public static void setService(AgencyLocalService service) {
		_service = service;
	}

	private static volatile AgencyLocalService _service;

}