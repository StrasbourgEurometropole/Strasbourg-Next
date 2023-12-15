/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.csmap.model.BaseNonce;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BaseNonce. This utility wraps
 * <code>eu.strasbourg.service.csmap.service.impl.BaseNonceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BaseNonceLocalService
 * @generated
 */
public class BaseNonceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.csmap.service.impl.BaseNonceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the base nonce to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BaseNonceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param baseNonce the base nonce
	 * @return the base nonce that was added
	 */
	public static BaseNonce addBaseNonce(BaseNonce baseNonce) {
		return getService().addBaseNonce(baseNonce);
	}

	/**
	 * Creates a new base nonce with the primary key. Does not add the base nonce to the database.
	 *
	 * @param baseNonceId the primary key for the new base nonce
	 * @return the new base nonce
	 */
	public static BaseNonce createBaseNonce(long baseNonceId) {
		return getService().createBaseNonce(baseNonceId);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	public static BaseNonce createBaseNonce(
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().createBaseNonce(sc);
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
	 * Deletes the base nonce from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BaseNonceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param baseNonce the base nonce
	 * @return the base nonce that was removed
	 */
	public static BaseNonce deleteBaseNonce(BaseNonce baseNonce) {
		return getService().deleteBaseNonce(baseNonce);
	}

	/**
	 * Deletes the base nonce with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BaseNonceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param baseNonceId the primary key of the base nonce
	 * @return the base nonce that was removed
	 * @throws PortalException if a base nonce with the primary key could not be found
	 */
	public static BaseNonce deleteBaseNonce(long baseNonceId)
		throws PortalException {

		return getService().deleteBaseNonce(baseNonceId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.BaseNonceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.BaseNonceModelImpl</code>.
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

	public static BaseNonce fetchBaseNonce(long baseNonceId) {
		return getService().fetchBaseNonce(baseNonceId);
	}

	/**
	 * Retrouve un baseNonce par sa valeur
	 */
	public static BaseNonce fetchByValue(String value) {
		return getService().fetchByValue(value);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the base nonce with the primary key.
	 *
	 * @param baseNonceId the primary key of the base nonce
	 * @return the base nonce
	 * @throws PortalException if a base nonce with the primary key could not be found
	 */
	public static BaseNonce getBaseNonce(long baseNonceId)
		throws PortalException {

		return getService().getBaseNonce(baseNonceId);
	}

	/**
	 * Returns a range of all the base nonces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.BaseNonceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of base nonces
	 * @param end the upper bound of the range of base nonces (not inclusive)
	 * @return the range of base nonces
	 */
	public static List<BaseNonce> getBaseNonces(int start, int end) {
		return getService().getBaseNonces(start, end);
	}

	/**
	 * Returns the number of base nonces.
	 *
	 * @return the number of base nonces
	 */
	public static int getBaseNoncesCount() {
		return getService().getBaseNoncesCount();
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
	 * Updates the base nonce in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BaseNonceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param baseNonce the base nonce
	 * @return the base nonce that was updated
	 */
	public static BaseNonce updateBaseNonce(BaseNonce baseNonce) {
		return getService().updateBaseNonce(baseNonce);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	public static BaseNonce updateBaseNonce(
		BaseNonce baseNonce,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().updateBaseNonce(baseNonce, sc);
	}

	public static BaseNonceLocalService getService() {
		return _service;
	}

	public static void setService(BaseNonceLocalService service) {
		_service = service;
	}

	private static volatile BaseNonceLocalService _service;

}