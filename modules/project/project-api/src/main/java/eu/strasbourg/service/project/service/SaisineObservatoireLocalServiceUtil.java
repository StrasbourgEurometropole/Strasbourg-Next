/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.SaisineObservatoire;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SaisineObservatoire. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.SaisineObservatoireLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see SaisineObservatoireLocalService
 * @generated
 */
public class SaisineObservatoireLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.SaisineObservatoireLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the saisine observatoire to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was added
	 */
	public static SaisineObservatoire addSaisineObservatoire(
		SaisineObservatoire saisineObservatoire) {

		return getService().addSaisineObservatoire(saisineObservatoire);
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
	 * Creates a new saisine observatoire with the primary key. Does not add the saisine observatoire to the database.
	 *
	 * @param saisineObservatoireId the primary key for the new saisine observatoire
	 * @return the new saisine observatoire
	 */
	public static SaisineObservatoire createSaisineObservatoire(
		long saisineObservatoireId) {

		return getService().createSaisineObservatoire(saisineObservatoireId);
	}

	/**
	 * Crée une saisine vide avec une PK, non ajouté à la base de donnée
	 */
	public static SaisineObservatoire createSaisineObservatoire(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createSaisineObservatoire(sc);
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
	 * Deletes the saisine observatoire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire that was removed
	 * @throws PortalException if a saisine observatoire with the primary key could not be found
	 */
	public static SaisineObservatoire deleteSaisineObservatoire(
			long saisineObservatoireId)
		throws PortalException {

		return getService().deleteSaisineObservatoire(saisineObservatoireId);
	}

	/**
	 * Deletes the saisine observatoire from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was removed
	 */
	public static SaisineObservatoire deleteSaisineObservatoire(
		SaisineObservatoire saisineObservatoire) {

		return getService().deleteSaisineObservatoire(saisineObservatoire);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
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

	public static SaisineObservatoire fetchSaisineObservatoire(
		long saisineObservatoireId) {

		return getService().fetchSaisineObservatoire(saisineObservatoireId);
	}

	public static List<SaisineObservatoire> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SaisineObservatoire> getByPublikUserID(String publikId) {
		return getService().getByPublikUserID(publikId);
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
	 * Retourne toutes les saisines publiées d'un groupe
	 */
	public static List<SaisineObservatoire> getPublishedByGroupId(
		long groupId) {

		return getService().getPublishedByGroupId(groupId);
	}

	/**
	 * Returns the saisine observatoire with the primary key.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire
	 * @throws PortalException if a saisine observatoire with the primary key could not be found
	 */
	public static SaisineObservatoire getSaisineObservatoire(
			long saisineObservatoireId)
		throws PortalException {

		return getService().getSaisineObservatoire(saisineObservatoireId);
	}

	/**
	 * Returns a range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of saisine observatoires
	 */
	public static List<SaisineObservatoire> getSaisineObservatoires(
		int start, int end) {

		return getService().getSaisineObservatoires(start, end);
	}

	/**
	 * Returns the number of saisine observatoires.
	 *
	 * @return the number of saisine observatoires
	 */
	public static int getSaisineObservatoiresCount() {
		return getService().getSaisineObservatoiresCount();
	}

	public static List<SaisineObservatoire> getTheMostCommented(long groupId) {
		return getService().getTheMostCommented(groupId);
	}

	/**
	 * Supprime une saisine
	 */
	public static SaisineObservatoire removeSaisineObservatoire(
			long saisineObservatoireId)
		throws PortalException {

		return getService().removeSaisineObservatoire(saisineObservatoireId);
	}

	public static void updateAllSaisineObservatoireStatus()
		throws PortalException {

		getService().updateAllSaisineObservatoireStatus();
	}

	/**
	 * Updates the saisine observatoire in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was updated
	 */
	public static SaisineObservatoire updateSaisineObservatoire(
		SaisineObservatoire saisineObservatoire) {

		return getService().updateSaisineObservatoire(saisineObservatoire);
	}

	public static SaisineObservatoire updateSaisineObservatoire(
			SaisineObservatoire saisineObservatoire,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateSaisineObservatoire(saisineObservatoire, sc);
	}

	public static SaisineObservatoireLocalService getService() {
		return _service;
	}

	public static void setService(SaisineObservatoireLocalService service) {
		_service = service;
	}

	private static volatile SaisineObservatoireLocalService _service;

}