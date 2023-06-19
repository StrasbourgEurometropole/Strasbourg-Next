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

package eu.strasbourg.service.project.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.InitiativeHelp;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for InitiativeHelp. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.InitiativeHelpLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see InitiativeHelpLocalService
 * @generated
 */
public class InitiativeHelpLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.InitiativeHelpLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the initiative help to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeHelpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was added
	 */
	public static InitiativeHelp addInitiativeHelp(
		InitiativeHelp initiativeHelp) {

		return getService().addInitiativeHelp(initiativeHelp);
	}

	/**
	 * Creates a new initiative help with the primary key. Does not add the initiative help to the database.
	 *
	 * @param initiativeHelpId the primary key for the new initiative help
	 * @return the new initiative help
	 */
	public static InitiativeHelp createInitiativeHelp(long initiativeHelpId) {
		return getService().createInitiativeHelp(initiativeHelpId);
	}

	/**
	 * Methode de creation d'une initiative
	 *
	 * @param sc Le contexte de la requete.
	 * @return L'aide cree.
	 */
	public static InitiativeHelp createInitiativeHelp(
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().createInitiativeHelp(sc);
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
	 * Deletes the initiative help from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeHelpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was removed
	 */
	public static InitiativeHelp deleteInitiativeHelp(
		InitiativeHelp initiativeHelp) {

		return getService().deleteInitiativeHelp(initiativeHelp);
	}

	/**
	 * Deletes the initiative help with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeHelpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help that was removed
	 * @throws PortalException if a initiative help with the primary key could not be found
	 */
	public static InitiativeHelp deleteInitiativeHelp(long initiativeHelpId)
		throws PortalException {

		return getService().deleteInitiativeHelp(initiativeHelpId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl</code>.
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

	public static InitiativeHelp fetchInitiativeHelp(long initiativeHelpId) {
		return getService().fetchInitiativeHelp(initiativeHelpId);
	}

	/**
	 * Returns the initiative help matching the UUID and group.
	 *
	 * @param uuid the initiative help's UUID
	 * @param groupId the primary key of the group
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchInitiativeHelpByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchInitiativeHelpByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des aides d'une initiative
	 */
	public static List<InitiativeHelp> getByInitiativeId(long initiativeId) {
		return getService().getByInitiativeId(initiativeId);
	}

	/**
	 * Retourne les aides proposees par un utilisateur
	 */
	public static List<InitiativeHelp> getByPublikUserId(String publikUserId) {
		return getService().getByPublikUserId(publikUserId);
	}

	/**
	 * Retourne l'aide proposee par un utilisateur pour une initiative donnee
	 */
	public static InitiativeHelp getByPublikUserIdAndInitiativeId(
		String publikUserId, long initiativeId) {

		return getService().getByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the initiative help with the primary key.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help
	 * @throws PortalException if a initiative help with the primary key could not be found
	 */
	public static InitiativeHelp getInitiativeHelp(long initiativeHelpId)
		throws PortalException {

		return getService().getInitiativeHelp(initiativeHelpId);
	}

	/**
	 * Returns the initiative help matching the UUID and group.
	 *
	 * @param uuid the initiative help's UUID
	 * @param groupId the primary key of the group
	 * @return the matching initiative help
	 * @throws PortalException if a matching initiative help could not be found
	 */
	public static InitiativeHelp getInitiativeHelpByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getInitiativeHelpByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of initiative helps
	 */
	public static List<InitiativeHelp> getInitiativeHelps(int start, int end) {
		return getService().getInitiativeHelps(start, end);
	}

	/**
	 * Returns the number of initiative helps.
	 *
	 * @return the number of initiative helps
	 */
	public static int getInitiativeHelpsCount() {
		return getService().getInitiativeHelpsCount();
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
	 * Supprimer un soutien donne
	 *
	 * @param initiativeHelpId Id de l'aide inititative
	 */
	public static InitiativeHelp removeInitiativeHelp(long initiativeHelpId) {
		return getService().removeInitiativeHelp(initiativeHelpId);
	}

	/**
	 * Updates the initiative help in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeHelpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was updated
	 */
	public static InitiativeHelp updateInitiativeHelp(
		InitiativeHelp initiativeHelp) {

		return getService().updateInitiativeHelp(initiativeHelp);
	}

	public static InitiativeHelpLocalService getService() {
		return _service;
	}

	private static volatile InitiativeHelpLocalService _service;

}