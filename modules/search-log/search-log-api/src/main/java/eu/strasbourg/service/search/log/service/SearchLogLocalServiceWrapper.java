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

package eu.strasbourg.service.search.log.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SearchLogLocalService}.
 *
 * @author BenjaminBini
 * @see SearchLogLocalService
 * @generated
 */
@ProviderType
public class SearchLogLocalServiceWrapper
	implements SearchLogLocalService, ServiceWrapper<SearchLogLocalService> {

	public SearchLogLocalServiceWrapper(
		SearchLogLocalService searchLogLocalService) {

		_searchLogLocalService = searchLogLocalService;
	}

	/**
	 * Adds the search log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchLog the search log
	 * @return the search log that was added
	 */
	@Override
	public eu.strasbourg.service.search.log.model.SearchLog addSearchLog(
		eu.strasbourg.service.search.log.model.SearchLog searchLog) {

		return _searchLogLocalService.addSearchLog(searchLog);
	}

	/**
	 * Crée un log de la recherche
	 */
	@Override
	public eu.strasbourg.service.search.log.model.SearchLog addSearchLog(
			com.liferay.portal.kernel.service.ServiceContext sc,
			String keywords, long resultCount,
			com.liferay.asset.kernel.model.AssetEntry result1,
			com.liferay.asset.kernel.model.AssetEntry result2,
			com.liferay.asset.kernel.model.AssetEntry result3,
			com.liferay.asset.kernel.model.AssetEntry userTargetResult,
			long searchTime)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _searchLogLocalService.addSearchLog(
			sc, keywords, resultCount, result1, result2, result3,
			userTargetResult, searchTime);
	}

	/**
	 * Creates a new search log with the primary key. Does not add the search log to the database.
	 *
	 * @param searchLogId the primary key for the new search log
	 * @return the new search log
	 */
	@Override
	public eu.strasbourg.service.search.log.model.SearchLog createSearchLog(
		long searchLogId) {

		return _searchLogLocalService.createSearchLog(searchLogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _searchLogLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the search log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchLogId the primary key of the search log
	 * @return the search log that was removed
	 * @throws PortalException if a search log with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.search.log.model.SearchLog deleteSearchLog(
			long searchLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _searchLogLocalService.deleteSearchLog(searchLogId);
	}

	/**
	 * Deletes the search log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchLog the search log
	 * @return the search log that was removed
	 */
	@Override
	public eu.strasbourg.service.search.log.model.SearchLog deleteSearchLog(
		eu.strasbourg.service.search.log.model.SearchLog searchLog) {

		return _searchLogLocalService.deleteSearchLog(searchLog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _searchLogLocalService.dynamicQuery();
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

		return _searchLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.search.log.model.impl.SearchLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _searchLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.search.log.model.impl.SearchLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _searchLogLocalService.dynamicQuery(
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

		return _searchLogLocalService.dynamicQueryCount(dynamicQuery);
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

		return _searchLogLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.search.log.model.SearchLog fetchSearchLog(
		long searchLogId) {

		return _searchLogLocalService.fetchSearchLog(searchLogId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _searchLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _searchLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _searchLogLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _searchLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the search log with the primary key.
	 *
	 * @param searchLogId the primary key of the search log
	 * @return the search log
	 * @throws PortalException if a search log with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.search.log.model.SearchLog getSearchLog(
			long searchLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _searchLogLocalService.getSearchLog(searchLogId);
	}

	/**
	 * Returns a range of all the search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.search.log.model.impl.SearchLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of search logs
	 * @param end the upper bound of the range of search logs (not inclusive)
	 * @return the range of search logs
	 */
	@Override
	public java.util.List<eu.strasbourg.service.search.log.model.SearchLog>
		getSearchLogs(int start, int end) {

		return _searchLogLocalService.getSearchLogs(start, end);
	}

	/**
	 * Returns the number of search logs.
	 *
	 * @return the number of search logs
	 */
	@Override
	public int getSearchLogsCount() {
		return _searchLogLocalService.getSearchLogsCount();
	}

	/**
	 * Updates the search log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param searchLog the search log
	 * @return the search log that was updated
	 */
	@Override
	public eu.strasbourg.service.search.log.model.SearchLog updateSearchLog(
		eu.strasbourg.service.search.log.model.SearchLog searchLog) {

		return _searchLogLocalService.updateSearchLog(searchLog);
	}

	@Override
	public SearchLogLocalService getWrappedService() {
		return _searchLogLocalService;
	}

	@Override
	public void setWrappedService(SearchLogLocalService searchLogLocalService) {
		_searchLogLocalService = searchLogLocalService;
	}

	private SearchLogLocalService _searchLogLocalService;

}