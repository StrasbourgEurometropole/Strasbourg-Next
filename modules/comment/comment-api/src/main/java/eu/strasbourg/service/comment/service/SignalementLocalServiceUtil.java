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

package eu.strasbourg.service.comment.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;
import eu.strasbourg.service.comment.model.Signalement;

import java.io.Serializable;
import java.util.List;

/**
 * Provides the local service utility for Signalement. This utility wraps
 * <code>eu.strasbourg.service.comment.service.impl.SignalementLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Romain Vergnais
 * @see SignalementLocalService
 * @generated
 */
public class SignalementLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.comment.service.impl.SignalementLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the signalement to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignalementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signalement the signalement
	 * @return the signalement that was added
	 */
	public static Signalement addSignalement(Signalement signalement) {
		return getService().addSignalement(signalement);
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
	 * Creates a new signalement with the primary key. Does not add the signalement to the database.
	 *
	 * @param signalementId the primary key for the new signalement
	 * @return the new signalement
	 */
	public static Signalement createSignalement(long signalementId) {
		return getService().createSignalement(signalementId);
	}

	/**
	 * Permet de creer un signalement sans le persister.
	 *
	 * @param sc le serviceContext
	 * @return le signalement.
	 * @throws PortalException l'exception.
	 */
	public static Signalement createSignalement(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createSignalement(sc);
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
	 * Deletes the signalement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignalementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signalementId the primary key of the signalement
	 * @return the signalement that was removed
	 * @throws PortalException if a signalement with the primary key could not be found
	 */
	public static Signalement deleteSignalement(long signalementId)
		throws PortalException {

		return getService().deleteSignalement(signalementId);
	}

	/**
	 * Deletes the signalement from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignalementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signalement the signalement
	 * @return the signalement that was removed
	 */
	public static Signalement deleteSignalement(Signalement signalement) {
		return getService().deleteSignalement(signalement);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.comment.model.impl.SignalementModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.comment.model.impl.SignalementModelImpl</code>.
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

	public static Signalement fetchSignalement(long signalementId) {
		return getService().fetchSignalement(signalementId);
	}

	/**
	 * Returns the signalement matching the UUID and group.
	 *
	 * @param uuid the signalement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public static Signalement fetchSignalementByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSignalementByUuidAndGroupId(uuid, groupId);
	}

	public static List<Signalement> findByCommentId(long commentId) {
		return getService().findByCommentId(commentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Signalement> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne tous les signalements d'un utilisateur
	 */
	public static List<Signalement> getByPublikId(String publikId) {
		return getService().getByPublikId(publikId);
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
	 * Returns the signalement with the primary key.
	 *
	 * @param signalementId the primary key of the signalement
	 * @return the signalement
	 * @throws PortalException if a signalement with the primary key could not be found
	 */
	public static Signalement getSignalement(long signalementId)
		throws PortalException {

		return getService().getSignalement(signalementId);
	}

	/**
	 * Returns the signalement matching the UUID and group.
	 *
	 * @param uuid the signalement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signalement
	 * @throws PortalException if a matching signalement could not be found
	 */
	public static Signalement getSignalementByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSignalementByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the signalements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.comment.model.impl.SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of signalements
	 */
	public static List<Signalement> getSignalements(int start, int end) {
		return getService().getSignalements(start, end);
	}

	/**
	 * Returns all the signalements matching the UUID and company.
	 *
	 * @param uuid the UUID of the signalements
	 * @param companyId the primary key of the company
	 * @return the matching signalements, or an empty list if no matches were found
	 */
	public static List<Signalement> getSignalementsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSignalementsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of signalements matching the UUID and company.
	 *
	 * @param uuid the UUID of the signalements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching signalements, or an empty list if no matches were found
	 */
	public static List<Signalement> getSignalementsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Signalement> orderByComparator) {

		return getService().getSignalementsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of signalements.
	 *
	 * @return the number of signalements
	 */
	public static int getSignalementsCount() {
		return getService().getSignalementsCount();
	}

	/**
	 * Updates the signalement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignalementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signalement the signalement
	 * @return the signalement that was updated
	 */
	public static Signalement updateSignalement(Signalement signalement) {
		return getService().updateSignalement(signalement);
	}

	public static Signalement updateSignalement(
			Signalement signalement,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateSignalement(signalement, sc);
	}

	public static SignalementLocalService getService() {
		return _service;
	}

	private static volatile SignalementLocalService _service;

}