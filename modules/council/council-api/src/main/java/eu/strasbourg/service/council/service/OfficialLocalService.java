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

package eu.strasbourg.service.council.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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

import eu.strasbourg.service.council.model.Official;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service interface for Official. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see OfficialLocalServiceUtil
 * @see eu.strasbourg.service.council.service.base.OfficialLocalServiceBaseImpl
 * @see eu.strasbourg.service.council.service.impl.OfficialLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface OfficialLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfficialLocalServiceUtil} to access the official local service. Add custom service methods to {@link eu.strasbourg.service.council.service.impl.OfficialLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the official to the database. Also notifies the appropriate model listeners.
	*
	* @param official the official
	* @return the official that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Official addOfficial(Official official);

	/**
	* Crée une entité vide avec une PK, non ajouté à la base de donnée
	*/
	public Official createOfficial(ServiceContext sc) throws PortalException;

	/**
	* Creates a new official with the primary key. Does not add the official to the database.
	*
	* @param officialId the primary key for the new official
	* @return the new official
	*/
	public Official createOfficial(long officialId);

	/**
	* Deletes the official from the database. Also notifies the appropriate model listeners.
	*
	* @param official the official
	* @return the official that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Official deleteOfficial(Official official);

	/**
	* Deletes the official with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officialId the primary key of the official
	* @return the official that was removed
	* @throws PortalException if a official with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Official deleteOfficial(long officialId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Official fetchOfficial(long officialId);

	/**
	* Returns the official matching the UUID and group.
	*
	* @param uuid the official's UUID
	* @param groupId the primary key of the group
	* @return the matching official, or <code>null</code> if a matching official could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Official fetchOfficialByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	/**
	* Recherche par ID de CouncilSession
	*/
	public Official findByEmail(java.lang.String email);

	/**
	* Returns the official with the primary key.
	*
	* @param officialId the primary key of the official
	* @return the official
	* @throws PortalException if a official with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Official getOfficial(long officialId) throws PortalException;

	/**
	* Returns the official matching the UUID and group.
	*
	* @param uuid the official's UUID
	* @param groupId the primary key of the group
	* @return the matching official
	* @throws PortalException if a matching official could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Official getOfficialByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	/**
	* Supprime une entité
	*/
	public Official removeOfficial(long officialId) throws PortalException;

	/**
	* Updates the official in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param official the official
	* @return the official that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Official updateOfficial(Official official);

	/**
	* Met à jour une entité et l'enregistre en base de données
	*/
	public Official updateOfficial(Official official, ServiceContext sc)
		throws PortalException;

	/**
	* Met à jour le statut de l'entité par le framework workflow
	*/
	public Official updateStatus(long userId, long entryId, int status,
		ServiceContext sc, Map<java.lang.String, Serializable> workflowContext)
		throws PortalException;

	/**
	* Returns the number of officials.
	*
	* @return the number of officials
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOfficialsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.council.model.impl.OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.council.model.impl.OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Recherche par site et activité ou non de l'élu
	*/
	public List<Official> findByGroupIdAndIsActive(long groupId,
		boolean isActive);

	/**
	* Recherche par site, activité ou non de l'élu et type
	*/
	public List<Official> findByGroupIdAndIsActiveAndType(long groupId,
		boolean isActive, java.lang.String type);

	/**
	* Returns a range of all the officials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.council.model.impl.OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of officials
	* @param end the upper bound of the range of officials (not inclusive)
	* @return the range of officials
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Official> getOfficials(int start, int end);

	/**
	* Returns all the officials matching the UUID and company.
	*
	* @param uuid the UUID of the officials
	* @param companyId the primary key of the company
	* @return the matching officials, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Official> getOfficialsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of officials matching the UUID and company.
	*
	* @param uuid the UUID of the officials
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of officials
	* @param end the upper bound of the range of officials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching officials, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Official> getOfficialsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<Official> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	/**
	* Met à jour le statut de l'entité "manuellement" (pas via le workflow)
	*/
	public void updateStatus(Official official, int status)
		throws PortalException;
}