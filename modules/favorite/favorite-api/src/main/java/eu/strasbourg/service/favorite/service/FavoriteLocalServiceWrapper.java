/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link FavoriteLocalService}.
 *
 * @author BenjaminBini
 * @see FavoriteLocalService
 * @generated
 */
public class FavoriteLocalServiceWrapper
	implements FavoriteLocalService, ServiceWrapper<FavoriteLocalService> {

	public FavoriteLocalServiceWrapper() {
		this(null);
	}

	public FavoriteLocalServiceWrapper(
		FavoriteLocalService favoriteLocalService) {

		_favoriteLocalService = favoriteLocalService;
	}

	/**
	 * Adds the favorite to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favorite the favorite
	 * @return the favorite that was added
	 */
	@Override
	public eu.strasbourg.service.favorite.model.Favorite addFavorite(
		eu.strasbourg.service.favorite.model.Favorite favorite) {

		return _favoriteLocalService.addFavorite(favorite);
	}

	/**
	 * Crée un nouveau favoris
	 */
	@Override
	public eu.strasbourg.service.favorite.model.Favorite createFavorite() {
		return _favoriteLocalService.createFavorite();
	}

	/**
	 * Creates a new favorite with the primary key. Does not add the favorite to the database.
	 *
	 * @param favoriteId the primary key for the new favorite
	 * @return the new favorite
	 */
	@Override
	public eu.strasbourg.service.favorite.model.Favorite createFavorite(
		long favoriteId) {

		return _favoriteLocalService.createFavorite(favoriteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the favorite from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favorite the favorite
	 * @return the favorite that was removed
	 */
	@Override
	public eu.strasbourg.service.favorite.model.Favorite deleteFavorite(
		eu.strasbourg.service.favorite.model.Favorite favorite) {

		return _favoriteLocalService.deleteFavorite(favorite);
	}

	/**
	 * Deletes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite that was removed
	 * @throws PortalException if a favorite with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.favorite.model.Favorite deleteFavorite(
			long favoriteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteLocalService.deleteFavorite(favoriteId);
	}

	@Override
	public void deleteFavoriteByEntityIdAndType(long entityId, long typeId) {
		_favoriteLocalService.deleteFavoriteByEntityIdAndType(entityId, typeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _favoriteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _favoriteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _favoriteLocalService.dynamicQuery();
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

		return _favoriteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl</code>.
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

		return _favoriteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl</code>.
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

		return _favoriteLocalService.dynamicQuery(
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

		return _favoriteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _favoriteLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.favorite.model.Favorite fetchFavorite(
		long favoriteId) {

		return _favoriteLocalService.fetchFavorite(favoriteId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _favoriteLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des favoris d'un utilisateur
	 */
	@Override
	public java.util.List<eu.strasbourg.service.favorite.model.Favorite>
		getByPublikUser(String publikUserId) {

		return _favoriteLocalService.getByPublikUser(publikUserId);
	}

	/**
	 * Retourne le favori qui possede les memes donnees
	 */
	@Override
	public java.util.List<eu.strasbourg.service.favorite.model.Favorite>
		getByTypeIdAndEntityIdAndPublikUserIdAndContent(
			long type, long entityId, String publikUserId, String content) {

		return _favoriteLocalService.
			getByTypeIdAndEntityIdAndPublikUserIdAndContent(
				type, entityId, publikUserId, content);
	}

	/**
	 * Retourne la liste des favoris liferay passés en paramètre
	 */
	@Override
	public java.util.List<eu.strasbourg.service.favorite.model.Favorite>
		getCSMapFavoriteById(java.util.List<Long> favoriteIds) {

		return _favoriteLocalService.getCSMapFavoriteById(favoriteIds);
	}

	/**
	 * Retourne la liste des favoris liferay d'un utilisateur
	 */
	@Override
	public java.util.List<eu.strasbourg.service.favorite.model.Favorite>
		getCSMapFavoriteByPublikUser(String publikUserId) {

		return _favoriteLocalService.getCSMapFavoriteByPublikUser(publikUserId);
	}

	/**
	 * Returns the favorite with the primary key.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite
	 * @throws PortalException if a favorite with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.favorite.model.Favorite getFavorite(
			long favoriteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteLocalService.getFavorite(favoriteId);
	}

	/**
	 * Returns a range of all the favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of favorites
	 */
	@Override
	public java.util.List<eu.strasbourg.service.favorite.model.Favorite>
		getFavorites(int start, int end) {

		return _favoriteLocalService.getFavorites(start, end);
	}

	/**
	 * Returns the number of favorites.
	 *
	 * @return the number of favorites
	 */
	@Override
	public int getFavoritesCount() {
		return _favoriteLocalService.getFavoritesCount();
	}

	/**
	 * Retourne le type du favori de l'élément
	 */
	@Override
	public Long getFavoriteTypeByClass(String favoriteClass) {
		return _favoriteLocalService.getFavoriteTypeByClass(favoriteClass);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _favoriteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des favoris liferay d'un utilisateur
	 */
	@Override
	public java.util.List<eu.strasbourg.service.favorite.model.Favorite>
		getLiferayFavoriteByPublikUser(String publikUserId) {

		return _favoriteLocalService.getLiferayFavoriteByPublikUser(
			publikUserId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _favoriteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Retourne si l'entité est un favori
	 */
	@Override
	public boolean isFavorite(long entityId, long typeId, String publikUserId) {
		return _favoriteLocalService.isFavorite(entityId, typeId, publikUserId);
	}

	/**
	 * Updates the favorite in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favorite the favorite
	 * @return the favorite that was updated
	 */
	@Override
	public eu.strasbourg.service.favorite.model.Favorite updateFavorite(
		eu.strasbourg.service.favorite.model.Favorite favorite) {

		return _favoriteLocalService.updateFavorite(favorite);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _favoriteLocalService.getBasePersistence();
	}

	@Override
	public FavoriteLocalService getWrappedService() {
		return _favoriteLocalService;
	}

	@Override
	public void setWrappedService(FavoriteLocalService favoriteLocalService) {
		_favoriteLocalService = favoriteLocalService;
	}

	private FavoriteLocalService _favoriteLocalService;

}