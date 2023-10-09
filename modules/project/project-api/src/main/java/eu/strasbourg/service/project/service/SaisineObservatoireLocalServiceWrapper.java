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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SaisineObservatoireLocalService}.
 *
 * @author Cedric Henry
 * @see SaisineObservatoireLocalService
 * @generated
 */
public class SaisineObservatoireLocalServiceWrapper
	implements SaisineObservatoireLocalService,
			   ServiceWrapper<SaisineObservatoireLocalService> {

	public SaisineObservatoireLocalServiceWrapper() {
		this(null);
	}

	public SaisineObservatoireLocalServiceWrapper(
		SaisineObservatoireLocalService saisineObservatoireLocalService) {

		_saisineObservatoireLocalService = saisineObservatoireLocalService;
	}

	/**
	 * Adds the saisine observatoire to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was added
	 */
	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
		addSaisineObservatoire(
			eu.strasbourg.service.project.model.SaisineObservatoire
				saisineObservatoire) {

		return _saisineObservatoireLocalService.addSaisineObservatoire(
			saisineObservatoire);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saisineObservatoireLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new saisine observatoire with the primary key. Does not add the saisine observatoire to the database.
	 *
	 * @param saisineObservatoireId the primary key for the new saisine observatoire
	 * @return the new saisine observatoire
	 */
	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
		createSaisineObservatoire(long saisineObservatoireId) {

		return _saisineObservatoireLocalService.createSaisineObservatoire(
			saisineObservatoireId);
	}

	/**
	 * Crée une saisine vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
			createSaisineObservatoire(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saisineObservatoireLocalService.createSaisineObservatoire(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saisineObservatoireLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the saisine observatoire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire that was removed
	 * @throws PortalException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
			deleteSaisineObservatoire(long saisineObservatoireId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saisineObservatoireLocalService.deleteSaisineObservatoire(
			saisineObservatoireId);
	}

	/**
	 * Deletes the saisine observatoire from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was removed
	 */
	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
		deleteSaisineObservatoire(
			eu.strasbourg.service.project.model.SaisineObservatoire
				saisineObservatoire) {

		return _saisineObservatoireLocalService.deleteSaisineObservatoire(
			saisineObservatoire);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _saisineObservatoireLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _saisineObservatoireLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _saisineObservatoireLocalService.dynamicQuery();
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

		return _saisineObservatoireLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
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

		return _saisineObservatoireLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
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

		return _saisineObservatoireLocalService.dynamicQuery(
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

		return _saisineObservatoireLocalService.dynamicQueryCount(dynamicQuery);
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

		return _saisineObservatoireLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
		fetchSaisineObservatoire(long saisineObservatoireId) {

		return _saisineObservatoireLocalService.fetchSaisineObservatoire(
			saisineObservatoireId);
	}

	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.SaisineObservatoire> findByKeyword(
			String keyword, long groupId, int start, int end) {

		return _saisineObservatoireLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _saisineObservatoireLocalService.findByKeywordCount(
			keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _saisineObservatoireLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _saisineObservatoireLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saisineObservatoireLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saisineObservatoireLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Retourne toutes les saisines publiées d'un groupe
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.SaisineObservatoire>
			getPublishedByGroupId(long groupId) {

		return _saisineObservatoireLocalService.getPublishedByGroupId(groupId);
	}

	/**
	 * Returns the saisine observatoire with the primary key.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire
	 * @throws PortalException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
			getSaisineObservatoire(long saisineObservatoireId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saisineObservatoireLocalService.getSaisineObservatoire(
			saisineObservatoireId);
	}

	/**
	 * Returns a range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of saisine observatoires
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.SaisineObservatoire>
			getSaisineObservatoires(int start, int end) {

		return _saisineObservatoireLocalService.getSaisineObservatoires(
			start, end);
	}

	/**
	 * Returns the number of saisine observatoires.
	 *
	 * @return the number of saisine observatoires
	 */
	@Override
	public int getSaisineObservatoiresCount() {
		return _saisineObservatoireLocalService.getSaisineObservatoiresCount();
	}

	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.SaisineObservatoire>
			getTheMostCommented(long groupId) {

		return _saisineObservatoireLocalService.getTheMostCommented(groupId);
	}

	/**
	 * Supprime une saisine
	 */
	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
			removeSaisineObservatoire(long saisineObservatoireId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saisineObservatoireLocalService.removeSaisineObservatoire(
			saisineObservatoireId);
	}

	@Override
	public void updateAllSaisineObservatoireStatus()
		throws com.liferay.portal.kernel.exception.PortalException {

		_saisineObservatoireLocalService.updateAllSaisineObservatoireStatus();
	}

	/**
	 * Updates the saisine observatoire in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was updated
	 */
	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
		updateSaisineObservatoire(
			eu.strasbourg.service.project.model.SaisineObservatoire
				saisineObservatoire) {

		return _saisineObservatoireLocalService.updateSaisineObservatoire(
			saisineObservatoire);
	}

	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
			updateSaisineObservatoire(
				eu.strasbourg.service.project.model.SaisineObservatoire
					saisineObservatoire,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _saisineObservatoireLocalService.updateSaisineObservatoire(
			saisineObservatoire, sc);
	}

	@Override
	public SaisineObservatoireLocalService getWrappedService() {
		return _saisineObservatoireLocalService;
	}

	@Override
	public void setWrappedService(
		SaisineObservatoireLocalService saisineObservatoireLocalService) {

		_saisineObservatoireLocalService = saisineObservatoireLocalService;
	}

	private SaisineObservatoireLocalService _saisineObservatoireLocalService;

}