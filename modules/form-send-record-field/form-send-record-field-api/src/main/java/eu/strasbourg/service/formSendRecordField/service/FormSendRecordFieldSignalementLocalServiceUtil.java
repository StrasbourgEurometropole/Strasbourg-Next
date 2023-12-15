/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.formSendRecordField.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FormSendRecordFieldSignalement. This utility wraps
 * <code>eu.strasbourg.service.formSendRecordField.service.impl.FormSendRecordFieldSignalementLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Angélique Zunino
 * @see FormSendRecordFieldSignalementLocalService
 * @generated
 */
public class FormSendRecordFieldSignalementLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.formSendRecordField.service.impl.FormSendRecordFieldSignalementLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the form send record field signalement to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldSignalementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordFieldSignalement the form send record field signalement
	 * @return the form send record field signalement that was added
	 */
	public static FormSendRecordFieldSignalement
		addFormSendRecordFieldSignalement(
			FormSendRecordFieldSignalement formSendRecordFieldSignalement) {

		return getService().addFormSendRecordFieldSignalement(
			formSendRecordFieldSignalement);
	}

	/**
	 * Creates a new form send record field signalement with the primary key. Does not add the form send record field signalement to the database.
	 *
	 * @param signalementId the primary key for the new form send record field signalement
	 * @return the new form send record field signalement
	 */
	public static FormSendRecordFieldSignalement
		createFormSendRecordFieldSignalement(long signalementId) {

		return getService().createFormSendRecordFieldSignalement(signalementId);
	}

	/**
	 * Permet de creer un signalement sans le persister.
	 *
	 * @param sc le serviceContext
	 * @return le signalement.
	 * @throws PortalException l'exception.
	 */
	public static FormSendRecordFieldSignalement
			createFormSendRecordFieldSignalement(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createFormSendRecordFieldSignalement(sc);
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
	 * Deletes the form send record field signalement from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldSignalementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordFieldSignalement the form send record field signalement
	 * @return the form send record field signalement that was removed
	 */
	public static FormSendRecordFieldSignalement
		deleteFormSendRecordFieldSignalement(
			FormSendRecordFieldSignalement formSendRecordFieldSignalement) {

		return getService().deleteFormSendRecordFieldSignalement(
			formSendRecordFieldSignalement);
	}

	/**
	 * Deletes the form send record field signalement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldSignalementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signalementId the primary key of the form send record field signalement
	 * @return the form send record field signalement that was removed
	 * @throws PortalException if a form send record field signalement with the primary key could not be found
	 */
	public static FormSendRecordFieldSignalement
			deleteFormSendRecordFieldSignalement(long signalementId)
		throws PortalException {

		return getService().deleteFormSendRecordFieldSignalement(signalementId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldSignalementModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldSignalementModelImpl</code>.
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

	public static FormSendRecordFieldSignalement
		fetchFormSendRecordFieldSignalement(long signalementId) {

		return getService().fetchFormSendRecordFieldSignalement(signalementId);
	}

	/**
	 * Returns the form send record field signalement matching the UUID and group.
	 *
	 * @param uuid the form send record field signalement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	 */
	public static FormSendRecordFieldSignalement
		fetchFormSendRecordFieldSignalementByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchFormSendRecordFieldSignalementByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<FormSendRecordFieldSignalement>
		findByFormSendRecordFieldId(long formSendRecordFieldId) {

		return getService().findByFormSendRecordFieldId(formSendRecordFieldId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<FormSendRecordFieldSignalement> getByGroupId(
		long groupId) {

		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne tous les signalementsd'une réponse à un formulaire d'un utilisateur
	 */
	public static List<FormSendRecordFieldSignalement> getByPublikId(
		String publikId) {

		return getService().getByPublikId(publikId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the form send record field signalement with the primary key.
	 *
	 * @param signalementId the primary key of the form send record field signalement
	 * @return the form send record field signalement
	 * @throws PortalException if a form send record field signalement with the primary key could not be found
	 */
	public static FormSendRecordFieldSignalement
			getFormSendRecordFieldSignalement(long signalementId)
		throws PortalException {

		return getService().getFormSendRecordFieldSignalement(signalementId);
	}

	/**
	 * Returns the form send record field signalement matching the UUID and group.
	 *
	 * @param uuid the form send record field signalement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form send record field signalement
	 * @throws PortalException if a matching form send record field signalement could not be found
	 */
	public static FormSendRecordFieldSignalement
			getFormSendRecordFieldSignalementByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getFormSendRecordFieldSignalementByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the form send record field signalements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldSignalementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form send record field signalements
	 * @param end the upper bound of the range of form send record field signalements (not inclusive)
	 * @return the range of form send record field signalements
	 */
	public static List<FormSendRecordFieldSignalement>
		getFormSendRecordFieldSignalements(int start, int end) {

		return getService().getFormSendRecordFieldSignalements(start, end);
	}

	/**
	 * Returns all the form send record field signalements matching the UUID and company.
	 *
	 * @param uuid the UUID of the form send record field signalements
	 * @param companyId the primary key of the company
	 * @return the matching form send record field signalements, or an empty list if no matches were found
	 */
	public static List<FormSendRecordFieldSignalement>
		getFormSendRecordFieldSignalementsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getFormSendRecordFieldSignalementsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of form send record field signalements matching the UUID and company.
	 *
	 * @param uuid the UUID of the form send record field signalements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of form send record field signalements
	 * @param end the upper bound of the range of form send record field signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching form send record field signalements, or an empty list if no matches were found
	 */
	public static List<FormSendRecordFieldSignalement>
		getFormSendRecordFieldSignalementsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FormSendRecordFieldSignalement>
				orderByComparator) {

		return getService().
			getFormSendRecordFieldSignalementsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of form send record field signalements.
	 *
	 * @return the number of form send record field signalements
	 */
	public static int getFormSendRecordFieldSignalementsCount() {
		return getService().getFormSendRecordFieldSignalementsCount();
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
	 * Updates the form send record field signalement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldSignalementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordFieldSignalement the form send record field signalement
	 * @return the form send record field signalement that was updated
	 */
	public static FormSendRecordFieldSignalement
		updateFormSendRecordFieldSignalement(
			FormSendRecordFieldSignalement formSendRecordFieldSignalement) {

		return getService().updateFormSendRecordFieldSignalement(
			formSendRecordFieldSignalement);
	}

	public static FormSendRecordFieldSignalement
			updateFormSendRecordFieldSignalement(
				FormSendRecordFieldSignalement signalement,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateFormSendRecordFieldSignalement(
			signalement, sc);
	}

	public static FormSendRecordFieldSignalementLocalService getService() {
		return _service;
	}

	public static void setService(
		FormSendRecordFieldSignalementLocalService service) {

		_service = service;
	}

	private static volatile FormSendRecordFieldSignalementLocalService _service;

}