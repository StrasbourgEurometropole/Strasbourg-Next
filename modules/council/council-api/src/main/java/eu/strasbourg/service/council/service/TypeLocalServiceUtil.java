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

import eu.strasbourg.service.council.model.Type;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Type. This utility wraps
 * <code>eu.strasbourg.service.council.service.impl.TypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TypeLocalService
 * @generated
 */
public class TypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.council.service.impl.TypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param type the type
	 * @return the type that was added
	 */
	public static Type addType(Type type) {
		return getService().addType(type);
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
	 * Creates a new type with the primary key. Does not add the type to the database.
	 *
	 * @param typeId the primary key for the new type
	 * @return the new type
	 */
	public static Type createType(long typeId) {
		return getService().createType(typeId);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	public static Type createType(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createType(sc);
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
	 * Deletes the type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeId the primary key of the type
	 * @return the type that was removed
	 * @throws PortalException if a type with the primary key could not be found
	 */
	public static Type deleteType(long typeId) throws PortalException {
		return getService().deleteType(typeId);
	}

	/**
	 * Deletes the type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param type the type
	 * @return the type that was removed
	 */
	public static Type deleteType(Type type) {
		return getService().deleteType(type);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.TypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.TypeModelImpl</code>.
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

	public static Type fetchType(long typeId) {
		return getService().fetchType(typeId);
	}

	/**
	 * Returns the type matching the UUID and group.
	 *
	 * @param uuid the type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching type, or <code>null</code> if a matching type could not be found
	 */
	public static Type fetchTypeByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par roleId de Type
	 */
	public static List<Type> findByRoleId(long roleId) {
		return getService().findByRoleId(roleId);
	}

	/**
	 * Recherche par titre de Type
	 */
	public static List<Type> findByTitre(String title) {
		return getService().findByTitre(title);
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
	 * Returns the type with the primary key.
	 *
	 * @param typeId the primary key of the type
	 * @return the type
	 * @throws PortalException if a type with the primary key could not be found
	 */
	public static Type getType(long typeId) throws PortalException {
		return getService().getType(typeId);
	}

	/**
	 * Returns the type matching the UUID and group.
	 *
	 * @param uuid the type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching type
	 * @throws PortalException if a matching type could not be found
	 */
	public static Type getTypeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.TypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of types
	 * @param end the upper bound of the range of types (not inclusive)
	 * @return the range of types
	 */
	public static List<Type> getTypes(int start, int end) {
		return getService().getTypes(start, end);
	}

	/**
	 * Returns all the types matching the UUID and company.
	 *
	 * @param uuid the UUID of the types
	 * @param companyId the primary key of the company
	 * @return the matching types, or an empty list if no matches were found
	 */
	public static List<Type> getTypesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTypesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of types matching the UUID and company.
	 *
	 * @param uuid the UUID of the types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of types
	 * @param end the upper bound of the range of types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching types, or an empty list if no matches were found
	 */
	public static List<Type> getTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Type> orderByComparator) {

		return getService().getTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of types.
	 *
	 * @return the number of types
	 */
	public static int getTypesCount() {
		return getService().getTypesCount();
	}

	/**
	 * Si le type a des conseils
	 */
	public static boolean hasCouncil(long typeId) {
		return getService().hasCouncil(typeId);
	}

	/**
	 * Si le titre avec l'ID donné est déjà utilisé par un autre type
	 */
	public static boolean isTitleAlreadyUsed(String title, long typeId) {
		return getService().isTitleAlreadyUsed(title, typeId);
	}

	/**
	 * Supprime une entité
	 */
	public static Type removeType(long typeId) throws PortalException {
		return getService().removeType(typeId);
	}

	/**
	 * Met à jour le statut de l'entité par le framework workflow
	 */
	public static Type updateStatus(
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
	public static void updateStatus(Type type, int status)
		throws PortalException {

		getService().updateStatus(type, status);
	}

	/**
	 * Updates the type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param type the type
	 * @return the type that was updated
	 */
	public static Type updateType(Type type) {
		return getService().updateType(type);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	public static Type updateType(
			Type type, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateType(type, sc);
	}

	public static TypeLocalService getService() {
		return _service;
	}

	public static void setService(TypeLocalService service) {
		_service = service;
	}

	private static volatile TypeLocalService _service;

}