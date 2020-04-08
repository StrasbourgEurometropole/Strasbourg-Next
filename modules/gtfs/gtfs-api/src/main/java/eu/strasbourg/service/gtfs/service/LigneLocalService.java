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

package eu.strasbourg.service.gtfs.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.ImportHistoric;
import eu.strasbourg.service.gtfs.model.Ligne;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service interface for Ligne. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see LigneLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LigneLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LigneLocalServiceUtil} to access the ligne local service. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.LigneLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the ligne to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ligne the ligne
	 * @return the ligne that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Ligne addLigne(Ligne ligne);

	/**
	 * Creates a new ligne with the primary key. Does not add the ligne to the database.
	 *
	 * @param ligneId the primary key for the new ligne
	 * @return the new ligne
	 */
	@Transactional(enabled = false)
	public Ligne createLigne(long ligneId);

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	public Ligne createLigne(ServiceContext sc) throws PortalException;

	/**
	 * Deletes the ligne from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ligne the ligne
	 * @return the ligne that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Ligne deleteLigne(Ligne ligne);

	/**
	 * Deletes the ligne with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne that was removed
	 * @throws PortalException if a ligne with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Ligne deleteLigne(long ligneId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Ligne fetchLigne(long ligneId);

	/**
	 * Returns the ligne matching the UUID and group.
	 *
	 * @param uuid the ligne's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Ligne fetchLigneByUuidAndGroupId(String uuid, long groupId);

	/**
	 * Recherche par mot clés
	 */
	public List<Ligne> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Recherche par mot clés (compte)
	 */
	public long findByKeywordCount(String keyword, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Retourne la liste de toutes les lignes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Ligne> getAll();

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entree
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Ligne> getByGroupId(long groupId);

	/**
	 * Retourne une ligne via son routeId CTS
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Ligne getByRouteId(String routeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the ligne with the primary key.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne
	 * @throws PortalException if a ligne with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Ligne getLigne(long ligneId) throws PortalException;

	/**
	 * Returns the ligne matching the UUID and group.
	 *
	 * @param uuid the ligne's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ligne
	 * @throws PortalException if a matching ligne could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Ligne getLigneByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Recuperer toutes les couleurs de ligne au format JSON
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getLigneColors();

	/**
	 * Recuperer toutes les couleurs de ligne au format HashMap
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, String[]> getLigneColorsFreemarker();

	/**
	 * Returns a range of all the lignes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of lignes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Ligne> getLignes(int start, int end);

	/**
	 * Returns all the lignes matching the UUID and company.
	 *
	 * @param uuid the UUID of the lignes
	 * @param companyId the primary key of the company
	 * @return the matching lignes, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Ligne> getLignesByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of lignes matching the UUID and company.
	 *
	 * @param uuid the UUID of the lignes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching lignes, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Ligne> getLignesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Ligne> orderByComparator);

	/**
	 * Returns the number of lignes.
	 *
	 * @return the number of lignes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLignesCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Supprime l'entree
	 */
	public Ligne removeLigne(long ligneId) throws PortalException;

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow) des entrees
	 */
	public void unpublishLignes(
			List<Ligne> lignes, ImportHistoric importHistoric,
			ServiceContext sc)
		throws PortalException;

	/**
	 * Updates the ligne in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ligne the ligne
	 * @return the ligne that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Ligne updateLigne(Ligne ligne);

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public Ligne updateLigne(Ligne ligne, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	public void updateLignes(List<Ligne> lignes, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow)
	 */
	public void updateStatus(Ligne ligne, int status) throws PortalException;

	/**
	 * Met à jour le statut de l'entree par le framework workflow
	 */
	public Ligne updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}