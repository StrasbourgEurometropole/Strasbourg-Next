/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PriceLocalService}.
 *
 * @author Angelique Zunino Champougny
 * @see PriceLocalService
 * @generated
 */
public class PriceLocalServiceWrapper
	implements PriceLocalService, ServiceWrapper<PriceLocalService> {

	public PriceLocalServiceWrapper() {
		this(null);
	}

	public PriceLocalServiceWrapper(PriceLocalService priceLocalService) {
		_priceLocalService = priceLocalService;
	}

	/**
	 * Adds the price to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param price the price
	 * @return the price that was added
	 */
	@Override
	public eu.strasbourg.service.place.model.Price addPrice(
		eu.strasbourg.service.place.model.Price price) {

		return _priceLocalService.addPrice(price);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new price with the primary key. Does not add the price to the database.
	 *
	 * @param priceId the primary key for the new price
	 * @return the new price
	 */
	@Override
	public eu.strasbourg.service.place.model.Price createPrice(long priceId) {
		return _priceLocalService.createPrice(priceId);
	}

	/**
	 * Crée un prix vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.place.model.Price createPrice(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.createPrice(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priceId the primary key of the price
	 * @return the price that was removed
	 * @throws PortalException if a price with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.place.model.Price deletePrice(long priceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.deletePrice(priceId);
	}

	/**
	 * Deletes the price from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param price the price
	 * @return the price that was removed
	 */
	@Override
	public eu.strasbourg.service.place.model.Price deletePrice(
		eu.strasbourg.service.place.model.Price price) {

		return _priceLocalService.deletePrice(price);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _priceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _priceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _priceLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _priceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PriceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _priceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PriceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _priceLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _priceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _priceLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.place.model.Price fetchPrice(long priceId) {
		return _priceLocalService.fetchPrice(priceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _priceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _priceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _priceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the price with the primary key.
	 *
	 * @param priceId the primary key of the price
	 * @return the price
	 * @throws PortalException if a price with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.place.model.Price getPrice(long priceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.getPrice(priceId);
	}

	/**
	 * Returns a range of all the prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @return the range of prices
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Price> getPrices(
		int start, int end) {

		return _priceLocalService.getPrices(start, end);
	}

	/**
	 * Returns the number of prices.
	 *
	 * @return the number of prices
	 */
	@Override
	public int getPricesCount() {
		return _priceLocalService.getPricesCount();
	}

	/**
	 * Supprime un tarif
	 */
	@Override
	public eu.strasbourg.service.place.model.Price removePrice(long priceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.removePrice(priceId);
	}

	/**
	 * Updates the price in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param price the price
	 * @return the price that was updated
	 */
	@Override
	public eu.strasbourg.service.place.model.Price updatePrice(
		eu.strasbourg.service.place.model.Price price) {

		return _priceLocalService.updatePrice(price);
	}

	/**
	 * Met à jour un tarif et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.place.model.Price updatePrice(
			eu.strasbourg.service.place.model.Price price,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.updatePrice(price, sc);
	}

	/**
	 * Met à jour le statut du tarif par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.place.model.Price updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priceLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut du tarif "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			long userId, eu.strasbourg.service.place.model.Price price,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_priceLocalService.updateStatus(userId, price, status);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _priceLocalService.getBasePersistence();
	}

	@Override
	public PriceLocalService getWrappedService() {
		return _priceLocalService;
	}

	@Override
	public void setWrappedService(PriceLocalService priceLocalService) {
		_priceLocalService = priceLocalService;
	}

	private PriceLocalService _priceLocalService;

}