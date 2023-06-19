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

package eu.strasbourg.service.formSendRecordField.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.formSendRecordField.model.FormSendRecordField;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for FormSendRecordField. This utility wraps
 * <code>eu.strasbourg.service.formSendRecordField.service.impl.FormSendRecordFieldLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Angélique Zunino
 * @see FormSendRecordFieldLocalService
 * @generated
 */
public class FormSendRecordFieldLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.formSendRecordField.service.impl.FormSendRecordFieldLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the form send record field to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordField the form send record field
	 * @return the form send record field that was added
	 */
	public static FormSendRecordField addFormSendRecordField(
		FormSendRecordField formSendRecordField) {

		return getService().addFormSendRecordField(formSendRecordField);
	}

	/**
	 * Creates a new form send record field with the primary key. Does not add the form send record field to the database.
	 *
	 * @param formSendRecordFieldId the primary key for the new form send record field
	 * @return the new form send record field
	 */
	public static FormSendRecordField createFormSendRecordField(
		long formSendRecordFieldId) {

		return getService().createFormSendRecordField(formSendRecordFieldId);
	}

	/**
	 * Crée un formSendRecordField vide avec une PK, non ajouté à la base de donnée
	 */
	public static FormSendRecordField createFormSendRecordField(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createFormSendRecordField(sc);
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
	 * Deletes the form send record field from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordField the form send record field
	 * @return the form send record field that was removed
	 */
	public static FormSendRecordField deleteFormSendRecordField(
		FormSendRecordField formSendRecordField) {

		return getService().deleteFormSendRecordField(formSendRecordField);
	}

	/**
	 * Deletes the form send record field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordFieldId the primary key of the form send record field
	 * @return the form send record field that was removed
	 * @throws PortalException if a form send record field with the primary key could not be found
	 */
	public static FormSendRecordField deleteFormSendRecordField(
			long formSendRecordFieldId)
		throws PortalException {

		return getService().deleteFormSendRecordField(formSendRecordFieldId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl</code>.
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

	public static FormSendRecordField fetchFormSendRecordField(
		long formSendRecordFieldId) {

		return getService().fetchFormSendRecordField(formSendRecordFieldId);
	}

	/**
	 * Returns the form send record field matching the UUID and group.
	 *
	 * @param uuid the form send record field's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	public static FormSendRecordField fetchFormSendRecordFieldByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFormSendRecordFieldByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne tous les formSendRecordField par contentIKd et instanceId
	 */
	public static List<FormSendRecordField> getByContentAndInstanceId(
		long contentId, String instanceId) {

		return getService().getByContentAndInstanceId(contentId, instanceId);
	}

	/**
	 * Retourne tous les formSendRecordField par contentId
	 */
	public static List<FormSendRecordField> getByContentId(long contentId) {
		return getService().getByContentId(contentId);
	}

	/**
	 * Retourne tous les formSendRecordField d'un groupe
	 */
	public static List<FormSendRecordField> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the form send record field with the primary key.
	 *
	 * @param formSendRecordFieldId the primary key of the form send record field
	 * @return the form send record field
	 * @throws PortalException if a form send record field with the primary key could not be found
	 */
	public static FormSendRecordField getFormSendRecordField(
			long formSendRecordFieldId)
		throws PortalException {

		return getService().getFormSendRecordField(formSendRecordFieldId);
	}

	/**
	 * Returns the form send record field matching the UUID and group.
	 *
	 * @param uuid the form send record field's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form send record field
	 * @throws PortalException if a matching form send record field could not be found
	 */
	public static FormSendRecordField getFormSendRecordFieldByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFormSendRecordFieldByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the form send record fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of form send record fields
	 */
	public static List<FormSendRecordField> getFormSendRecordFields(
		int start, int end) {

		return getService().getFormSendRecordFields(start, end);
	}

	/**
	 * Returns all the form send record fields matching the UUID and company.
	 *
	 * @param uuid the UUID of the form send record fields
	 * @param companyId the primary key of the company
	 * @return the matching form send record fields, or an empty list if no matches were found
	 */
	public static List<FormSendRecordField>
		getFormSendRecordFieldsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getFormSendRecordFieldsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of form send record fields matching the UUID and company.
	 *
	 * @param uuid the UUID of the form send record fields
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching form send record fields, or an empty list if no matches were found
	 */
	public static List<FormSendRecordField>
		getFormSendRecordFieldsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FormSendRecordField> orderByComparator) {

		return getService().getFormSendRecordFieldsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of form send record fields.
	 *
	 * @return the number of form send record fields
	 */
	public static int getFormSendRecordFieldsCount() {
		return getService().getFormSendRecordFieldsCount();
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
	 * Supprime un lien
	 */
	public static FormSendRecordField removeFormSendRecordField(
			long formSendRecordFieldId)
		throws PortalException {

		return getService().removeFormSendRecordField(formSendRecordFieldId);
	}

	/**
	 * Updates the form send record field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordField the form send record field
	 * @return the form send record field that was updated
	 */
	public static FormSendRecordField updateFormSendRecordField(
		FormSendRecordField formSendRecordField) {

		return getService().updateFormSendRecordField(formSendRecordField);
	}

	/**
	 * Met à jour un formSendRecordField et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static FormSendRecordField updateFormSendRecordField(
			FormSendRecordField formSendRecordField,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateFormSendRecordField(formSendRecordField, sc);
	}

	/**
	 * Met à jour le statut du formSendRecordField "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			FormSendRecordField formSendRecordField, int status)
		throws PortalException {

		getService().updateStatus(formSendRecordField, status);
	}

	/**
	 * Met à jour le statut du formSendRecordField par le framework workflow
	 */
	public static FormSendRecordField updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static FormSendRecordFieldLocalService getService() {
		return _service;
	}

	private static volatile FormSendRecordFieldLocalService _service;

}