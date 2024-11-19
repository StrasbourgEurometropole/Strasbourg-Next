/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.favorite.model.Favorite;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Favorite. This utility wraps
 * <code>eu.strasbourg.service.favorite.service.impl.FavoriteLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see FavoriteLocalService
 * @generated
 */
public class FavoriteLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.favorite.service.impl.FavoriteLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Favorite addFavorite(Favorite favorite) {
		return getService().addFavorite(favorite);
	}

	/**
	 * Crée un nouveau favoris
	 */
	public static Favorite createFavorite() {
		return getService().createFavorite();
	}

	/**
	 * Creates a new favorite with the primary key. Does not add the favorite to the database.
	 *
	 * @param favoriteId the primary key for the new favorite
	 * @return the new favorite
	 */
	public static Favorite createFavorite(long favoriteId) {
		return getService().createFavorite(favoriteId);
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
	 * Deletes the favorite from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favorite the favorite
	 * @return the favorite that was removed
	 */
	public static Favorite deleteFavorite(Favorite favorite) {
		return getService().deleteFavorite(favorite);
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
	public static Favorite deleteFavorite(long favoriteId)
		throws PortalException {

		return getService().deleteFavorite(favoriteId);
	}

	public static void deleteFavoriteByEntityIdAndType(
		long entityId, long typeId) {

		getService().deleteFavoriteByEntityIdAndType(entityId, typeId);
	}

	public static void deleteFavoriteByGroupIdEntityIdAndType(
		long groupId, long entityId, long typeId) {

		getService().deleteFavoriteByGroupIdEntityIdAndType(
			groupId, entityId, typeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl</code>.
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

	public static Favorite fetchFavorite(long favoriteId) {
		return getService().fetchFavorite(favoriteId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des favoris d'un utilisateur
	 */
	public static List<Favorite> getByPublikUser(String publikUserId) {
		return getService().getByPublikUser(publikUserId);
	}

	/**
	 * Retourne le favori qui possede les memes donnees
	 */
	public static List<Favorite>
		getByTypeIdAndEntityIdAndPublikUserIdAndContent(
			long type, long entityId, String publikUserId, String content) {

		return getService().getByTypeIdAndEntityIdAndPublikUserIdAndContent(
			type, entityId, publikUserId, content);
	}

	/**
	 * Retourne la liste des favoris liferay passés en paramètre
	 */
	public static List<Favorite> getCSMapFavoriteById(List<Long> favoriteIds) {
		return getService().getCSMapFavoriteById(favoriteIds);
	}

	/**
	 * Retourne la liste des favoris liferay d'un utilisateur
	 */
	public static List<Favorite> getCSMapFavoriteByPublikUser(
		String publikUserId) {

		return getService().getCSMapFavoriteByPublikUser(publikUserId);
	}

	/**
	 * Retourne les favoris de type Event d'un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject
		getEventsFavoriteByUser(String publikUserId) {

		return getService().getEventsFavoriteByUser(publikUserId);
	}

	/**
	 * Returns the favorite with the primary key.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite
	 * @throws PortalException if a favorite with the primary key could not be found
	 */
	public static Favorite getFavorite(long favoriteId) throws PortalException {
		return getService().getFavorite(favoriteId);
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
	public static List<Favorite> getFavorites(int start, int end) {
		return getService().getFavorites(start, end);
	}

	/**
	 * Returns the number of favorites.
	 *
	 * @return the number of favorites
	 */
	public static int getFavoritesCount() {
		return getService().getFavoritesCount();
	}

	/**
	 * Retourne le type du favori de l'élément
	 */
	public static Long getFavoriteTypeByClass(String favoriteClass) {
		return getService().getFavoriteTypeByClass(favoriteClass);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des favoris liferay d'un utilisateur
	 */
	public static List<Favorite> getLiferayFavoriteByPublikUser(
		String publikUserId) {

		return getService().getLiferayFavoriteByPublikUser(publikUserId);
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
	 * Retourne si l'entité est un favori
	 */
	public static boolean isFavorite(
		long entityId, long typeId, String publikUserId) {

		return getService().isFavorite(entityId, typeId, publikUserId);
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
	public static Favorite updateFavorite(Favorite favorite) {
		return getService().updateFavorite(favorite);
	}

	public static FavoriteLocalService getService() {
		return _service;
	}

	public static void setService(FavoriteLocalService service) {
		_service = service;
	}

	private static volatile FavoriteLocalService _service;

}