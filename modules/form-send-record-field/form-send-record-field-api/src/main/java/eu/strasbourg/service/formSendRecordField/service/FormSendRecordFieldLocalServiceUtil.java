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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

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
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
			addFormSendRecordField(
				eu.strasbourg.service.formSendRecordField.model.
					FormSendRecordField formSendRecordField) {

		return getService().addFormSendRecordField(formSendRecordField);
	}

	/**
	 * Creates a new form send record field with the primary key. Does not add the form send record field to the database.
	 *
	 * @param formSendRecordFieldId the primary key for the new form send record field
	 * @return the new form send record field
	 */
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
			createFormSendRecordField(long formSendRecordFieldId) {

		return getService().createFormSendRecordField(formSendRecordFieldId);
	}

	/**
	 * Crée un formSendRecordField vide avec une PK, non ajouté à la base de donnée
	 */
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
				createFormSendRecordField(
					com.liferay.portal.kernel.service.ServiceContext sc)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createFormSendRecordField(sc);
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
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
			deleteFormSendRecordField(
				eu.strasbourg.service.formSendRecordField.model.
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
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
				deleteFormSendRecordField(long formSendRecordFieldId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFormSendRecordField(formSendRecordFieldId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl</code>.
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

	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
			fetchFormSendRecordField(long formSendRecordFieldId) {

		return getService().fetchFormSendRecordField(formSendRecordFieldId);
	}

	/**
	 * Returns the form send record field matching the UUID and group.
	 *
	 * @param uuid the form send record field's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
			fetchFormSendRecordFieldByUuidAndGroupId(
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
	public static java.util.List
		<eu.strasbourg.service.formSendRecordField.model.FormSendRecordField>
			getByContentAndInstanceId(long contentId, String instanceId) {

		return getService().getByContentAndInstanceId(contentId, instanceId);
	}

	/**
	 * Retourne tous les formSendRecordField par contentId
	 */
	public static java.util.List
		<eu.strasbourg.service.formSendRecordField.model.FormSendRecordField>
			getByContentId(long contentId) {

		return getService().getByContentId(contentId);
	}

	/**
	 * Retourne tous les formSendRecordField d'un groupe
	 */
	public static java.util.List
		<eu.strasbourg.service.formSendRecordField.model.FormSendRecordField>
			getByGroupId(long groupId) {

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
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
				getFormSendRecordField(long formSendRecordFieldId)
			throws com.liferay.portal.kernel.exception.PortalException {

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
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
				getFormSendRecordFieldByUuidAndGroupId(
					String uuid, long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

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
	public static java.util.List
		<eu.strasbourg.service.formSendRecordField.model.FormSendRecordField>
			getFormSendRecordFields(int start, int end) {

		return getService().getFormSendRecordFields(start, end);
	}

	/**
	 * Returns all the form send record fields matching the UUID and company.
	 *
	 * @param uuid the UUID of the form send record fields
	 * @param companyId the primary key of the company
	 * @return the matching form send record fields, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.formSendRecordField.model.FormSendRecordField>
			getFormSendRecordFieldsByUuidAndCompanyId(
				String uuid, long companyId) {

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
	public static java.util.List
		<eu.strasbourg.service.formSendRecordField.model.FormSendRecordField>
			getFormSendRecordFieldsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.formSendRecordField.model.
						FormSendRecordField> orderByComparator) {

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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime un lien
	 */
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
				removeFormSendRecordField(long formSendRecordFieldId)
			throws com.liferay.portal.kernel.exception.PortalException {

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
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
			updateFormSendRecordField(
				eu.strasbourg.service.formSendRecordField.model.
					FormSendRecordField formSendRecordField) {

		return getService().updateFormSendRecordField(formSendRecordField);
	}

	/**
	 * Met à jour un formSendRecordField et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
				updateFormSendRecordField(
					eu.strasbourg.service.formSendRecordField.model.
						FormSendRecordField formSendRecordField,
					com.liferay.portal.kernel.service.ServiceContext sc)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateFormSendRecordField(formSendRecordField, sc);
	}

	/**
	 * Met à jour le statut du formSendRecordField "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
				formSendRecordField,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(formSendRecordField, status);
	}

	/**
	 * Met à jour le statut du formSendRecordField par le framework workflow
	 */
	public static
		eu.strasbourg.service.formSendRecordField.model.FormSendRecordField
				updateStatus(
					long userId, long entryId, int status,
					com.liferay.portal.kernel.service.ServiceContext sc,
					java.util.Map<String, java.io.Serializable> workflowContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static FormSendRecordFieldLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FormSendRecordFieldLocalService, FormSendRecordFieldLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			FormSendRecordFieldLocalService.class);

		ServiceTracker
			<FormSendRecordFieldLocalService, FormSendRecordFieldLocalService>
				serviceTracker =
					new ServiceTracker
						<FormSendRecordFieldLocalService,
						 FormSendRecordFieldLocalService>(
							 bundle.getBundleContext(),
							 FormSendRecordFieldLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}