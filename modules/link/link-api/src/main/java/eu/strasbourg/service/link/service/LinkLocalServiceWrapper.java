/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.link.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LinkLocalService}.
 *
 * @author BenjaminBini
 * @see LinkLocalService
 * @generated
 */
public class LinkLocalServiceWrapper
	implements LinkLocalService, ServiceWrapper<LinkLocalService> {

	public LinkLocalServiceWrapper() {
		this(null);
	}

	public LinkLocalServiceWrapper(LinkLocalService linkLocalService) {
		_linkLocalService = linkLocalService;
	}

	/**
	 * Adds the link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param link the link
	 * @return the link that was added
	 */
	@Override
	public eu.strasbourg.service.link.model.Link addLink(
		eu.strasbourg.service.link.model.Link link) {

		return _linkLocalService.addLink(link);
	}

	/**
	 * Creates a new link with the primary key. Does not add the link to the database.
	 *
	 * @param linkId the primary key for the new link
	 * @return the new link
	 */
	@Override
	public eu.strasbourg.service.link.model.Link createLink(long linkId) {
		return _linkLocalService.createLink(linkId);
	}

	/**
	 * Crée un lien vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.link.model.Link createLink(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.createLink(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param link the link
	 * @return the link that was removed
	 */
	@Override
	public eu.strasbourg.service.link.model.Link deleteLink(
		eu.strasbourg.service.link.model.Link link) {

		return _linkLocalService.deleteLink(link);
	}

	/**
	 * Deletes the link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linkId the primary key of the link
	 * @return the link that was removed
	 * @throws PortalException if a link with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.link.model.Link deleteLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.deleteLink(linkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _linkLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _linkLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _linkLocalService.dynamicQuery();
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

		return _linkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.link.model.impl.LinkModelImpl</code>.
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

		return _linkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.link.model.impl.LinkModelImpl</code>.
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

		return _linkLocalService.dynamicQuery(
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

		return _linkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _linkLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.link.model.Link fetchLink(long linkId) {
		return _linkLocalService.fetchLink(linkId);
	}

	/**
	 * Returns the link matching the UUID and group.
	 *
	 * @param uuid the link's UUID
	 * @param groupId the primary key of the group
	 * @return the matching link, or <code>null</code> if a matching link could not be found
	 */
	@Override
	public eu.strasbourg.service.link.model.Link fetchLinkByUuidAndGroupId(
		String uuid, long groupId) {

		return _linkLocalService.fetchLinkByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.link.model.Link> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return _linkLocalService.findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _linkLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _linkLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne les vocabulaires rattachés à l'entité Link
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _linkLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les liens d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.link.model.Link> getByGroupId(
		long groupId) {

		return _linkLocalService.getByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _linkLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _linkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the link with the primary key.
	 *
	 * @param linkId the primary key of the link
	 * @return the link
	 * @throws PortalException if a link with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.link.model.Link getLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.getLink(linkId);
	}

	/**
	 * Returns the link matching the UUID and group.
	 *
	 * @param uuid the link's UUID
	 * @param groupId the primary key of the group
	 * @return the matching link
	 * @throws PortalException if a matching link could not be found
	 */
	@Override
	public eu.strasbourg.service.link.model.Link getLinkByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.getLinkByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.link.model.impl.LinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of links
	 */
	@Override
	public java.util.List<eu.strasbourg.service.link.model.Link> getLinks(
		int start, int end) {

		return _linkLocalService.getLinks(start, end);
	}

	/**
	 * Returns all the links matching the UUID and company.
	 *
	 * @param uuid the UUID of the links
	 * @param companyId the primary key of the company
	 * @return the matching links, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.link.model.Link>
		getLinksByUuidAndCompanyId(String uuid, long companyId) {

		return _linkLocalService.getLinksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of links matching the UUID and company.
	 *
	 * @param uuid the UUID of the links
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching links, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.link.model.Link>
		getLinksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.link.model.Link> orderByComparator) {

		return _linkLocalService.getLinksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of links.
	 *
	 * @return the number of links
	 */
	@Override
	public int getLinksCount() {
		return _linkLocalService.getLinksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _linkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime un lien
	 */
	@Override
	public eu.strasbourg.service.link.model.Link removeLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.removeLink(linkId);
	}

	/**
	 * Recherche
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _linkLocalService.search(searchContext);
	}

	/**
	 * Updates the link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param link the link
	 * @return the link that was updated
	 */
	@Override
	public eu.strasbourg.service.link.model.Link updateLink(
		eu.strasbourg.service.link.model.Link link) {

		return _linkLocalService.updateLink(link);
	}

	/**
	 * Met à jour un lien et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.link.model.Link updateLink(
			eu.strasbourg.service.link.model.Link link,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.updateLink(link, sc);
	}

	/**
	 * Met à jour le statut du lien "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.link.model.Link link, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_linkLocalService.updateStatus(link, status);
	}

	/**
	 * Met à jour le statut du lien par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.link.model.Link updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linkLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _linkLocalService.getBasePersistence();
	}

	@Override
	public LinkLocalService getWrappedService() {
		return _linkLocalService;
	}

	@Override
	public void setWrappedService(LinkLocalService linkLocalService) {
		_linkLocalService = linkLocalService;
	}

	private LinkLocalService _linkLocalService;

}