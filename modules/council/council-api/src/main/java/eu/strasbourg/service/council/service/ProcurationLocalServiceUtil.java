/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.council.model.Procuration;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Procuration. This utility wraps
 * <code>eu.strasbourg.service.council.service.impl.ProcurationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProcurationLocalService
 * @generated
 */
public class ProcurationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.council.service.impl.ProcurationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the procuration to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procuration the procuration
	 * @return the procuration that was added
	 */
	public static Procuration addProcuration(Procuration procuration) {
		return getService().addProcuration(procuration);
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
	 * Creates a new procuration with the primary key. Does not add the procuration to the database.
	 *
	 * @param procurationId the primary key for the new procuration
	 * @return the new procuration
	 */
	public static Procuration createProcuration(long procurationId) {
		return getService().createProcuration(procurationId);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	public static Procuration createProcuration(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createProcuration(sc);
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
	 * Deletes the procuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration that was removed
	 * @throws PortalException if a procuration with the primary key could not be found
	 */
	public static Procuration deleteProcuration(long procurationId)
		throws PortalException {

		return getService().deleteProcuration(procurationId);
	}

	/**
	 * Deletes the procuration from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procuration the procuration
	 * @return the procuration that was removed
	 */
	public static Procuration deleteProcuration(Procuration procuration) {
		return getService().deleteProcuration(procuration);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.ProcurationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.ProcurationModelImpl</code>.
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

	public static Procuration fetchProcuration(long procurationId) {
		return getService().fetchProcuration(procurationId);
	}

	/**
	 * Returns the procuration matching the UUID and group.
	 *
	 * @param uuid the procuration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchProcurationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProcurationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche d'une absence à une session
	 */
	public static Procuration findAbsenceForCouncilSession(
		long councilSessionId, long officialId) {

		return getService().findAbsenceForCouncilSession(
			councilSessionId, officialId);
	}

	/**
	 * Recherche par ID de CouncilSession
	 */
	public static List<Procuration> findByCouncilSessionId(
		long councilSessionId) {

		return getService().findByCouncilSessionId(councilSessionId);
	}

	/**
	 * Recherche d'une procuration pour un officiel
	 */
	public static List<Procuration>
		findByCouncilSessionIdAndOfficialUnavailableId(
			long councilSessionId, long officialId) {

		return getService().findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialId);
	}

	/**
	 * Recherche par ID de CouncilSession, élu et mandataire,
	 */
	public static Procuration
		findByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
			long councilSessionId, long officialVoter,
			long officialUnavailableId) {

		return getService().
			findByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				councilSessionId, officialVoter, officialUnavailableId);
	}

	/**
	 * Recherche par ID de CouncilSession et Mandataire
	 */
	public static List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVoter) {

		return getService().findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVoter);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Returns the procuration with the primary key.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration
	 * @throws PortalException if a procuration with the primary key could not be found
	 */
	public static Procuration getProcuration(long procurationId)
		throws PortalException {

		return getService().getProcuration(procurationId);
	}

	/**
	 * Returns the procuration matching the UUID and group.
	 *
	 * @param uuid the procuration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procuration
	 * @throws PortalException if a matching procuration could not be found
	 */
	public static Procuration getProcurationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProcurationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of procurations
	 */
	public static List<Procuration> getProcurations(int start, int end) {
		return getService().getProcurations(start, end);
	}

	/**
	 * Returns all the procurations matching the UUID and company.
	 *
	 * @param uuid the UUID of the procurations
	 * @param companyId the primary key of the company
	 * @return the matching procurations, or an empty list if no matches were found
	 */
	public static List<Procuration> getProcurationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProcurationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of procurations matching the UUID and company.
	 *
	 * @param uuid the UUID of the procurations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procurations, or an empty list if no matches were found
	 */
	public static List<Procuration> getProcurationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return getService().getProcurationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of procurations.
	 *
	 * @return the number of procurations
	 */
	public static int getProcurationsCount() {
		return getService().getProcurationsCount();
	}

	/**
	 * Recherche d'une procuration active
	 * Si une procuration est active, alors l'élu est absent
	 */
	public static boolean isOfficialAbsent(
		long councilSessionId, long officialId) {

		return getService().isOfficialAbsent(councilSessionId, officialId);
	}

	/**
	 * Supprime une entité
	 */
	public static Procuration removeProcuration(long procurationId)
		throws PortalException {

		return getService().removeProcuration(procurationId);
	}

	/**
	 * Updates the procuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procuration the procuration
	 * @return the procuration that was updated
	 */
	public static Procuration updateProcuration(Procuration procuration) {
		return getService().updateProcuration(procuration);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	public static Procuration updateProcuration(
			Procuration procuration,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateProcuration(procuration, sc);
	}

	/**
	 * Met à jour le statut de l'entité par le framework workflow
	 */
	public static Procuration updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut de l'entité "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Procuration procuration, int status)
		throws PortalException {

		getService().updateStatus(procuration, status);
	}

	public static ProcurationLocalService getService() {
		return _service;
	}

	public static void setService(ProcurationLocalService service) {
		_service = service;
	}

	private static volatile ProcurationLocalService _service;

}