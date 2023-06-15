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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
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
import eu.strasbourg.service.council.model.CouncilSession;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Provides the local service interface for CouncilSession. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CouncilSessionLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CouncilSessionLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.council.service.impl.CouncilSessionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the council session local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CouncilSessionLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the council session to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CouncilSessionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param councilSession the council session
	 * @return the council session that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CouncilSession addCouncilSession(CouncilSession councilSession);

	/**
	 * Calcul de la date pour trouver le conseil
	 * Si la date du jour moins 6h est sur le jour d'avant, alors on fait la recherche sur le jour d'avant
	 */
	public GregorianCalendar calculDateForFindCouncil();

	/**
	 * Creates a new council session with the primary key. Does not add the council session to the database.
	 *
	 * @param councilSessionId the primary key for the new council session
	 * @return the new council session
	 */
	@Transactional(enabled = false)
	public CouncilSession createCouncilSession(long councilSessionId);

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	public CouncilSession createCouncilSession(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the council session from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CouncilSessionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param councilSession the council session
	 * @return the council session that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public CouncilSession deleteCouncilSession(CouncilSession councilSession);

	/**
	 * Deletes the council session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CouncilSessionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param councilSessionId the primary key of the council session
	 * @return the council session that was removed
	 * @throws PortalException if a council session with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public CouncilSession deleteCouncilSession(long councilSessionId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.CouncilSessionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.CouncilSessionModelImpl</code>.
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
	public CouncilSession fetchCouncilSession(long councilSessionId);

	/**
	 * Returns the council session matching the UUID and group.
	 *
	 * @param uuid the council session's UUID
	 * @param groupId the primary key of the group
	 * @return the matching council session, or <code>null</code> if a matching council session could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CouncilSession fetchCouncilSessionByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Recherche par Date de CouncilSession
	 */
	public List<CouncilSession> findByDate(Date date);

	/**
	 * Recherche par titre de CouncilSession
	 */
	public List<CouncilSession> findByTitre(String title);

	/**
	 * Recherche par type de CouncilSession
	 */
	public List<CouncilSession> findByTypeId(long typeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the council session with the primary key.
	 *
	 * @param councilSessionId the primary key of the council session
	 * @return the council session
	 * @throws PortalException if a council session with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CouncilSession getCouncilSession(long councilSessionId)
		throws PortalException;

	/**
	 * Returns the council session matching the UUID and group.
	 *
	 * @param uuid the council session's UUID
	 * @param groupId the primary key of the group
	 * @return the matching council session
	 * @throws PortalException if a matching council session could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CouncilSession getCouncilSessionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the council sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @return the range of council sessions
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CouncilSession> getCouncilSessions(int start, int end);

	/**
	 * Returns all the council sessions matching the UUID and company.
	 *
	 * @param uuid the UUID of the council sessions
	 * @param companyId the primary key of the company
	 * @return the matching council sessions, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CouncilSession> getCouncilSessionsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of council sessions matching the UUID and company.
	 *
	 * @param uuid the UUID of the council sessions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching council sessions, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CouncilSession> getCouncilSessionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CouncilSession> orderByComparator);

	/**
	 * Returns the number of council sessions.
	 *
	 * @return the number of council sessions
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCouncilSessionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Retourne les conseils dont la date est égale ou supérieure à celle passée en paramètre
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CouncilSession> getFutureCouncilSessions(Date date);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Si le conseil a des délib
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDelib(long councilSessionId);

	/**
	 * Si le titre avec l'ID donné est déjà utilisé par une autre session du même type de conseil
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isTitleAlreadyUsedInCouncilTypeId(
		String title, long councilSessionId, long typeId);

	/**
	 * Supprime une entité
	 */
	public CouncilSession removeCouncilSession(long councilSessionId)
		throws PortalException;

	/**
	 * Updates the council session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CouncilSessionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param councilSession the council session
	 * @return the council session that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CouncilSession updateCouncilSession(CouncilSession councilSession);

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	public CouncilSession updateCouncilSession(
			CouncilSession councilSession, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut de l'entité "manuellement" (pas via le workflow)
	 */
	public void updateStatus(CouncilSession councilSession, int status)
		throws PortalException;

	/**
	 * Met à jour le statut de l'entité par le framework workflow
	 */
	public CouncilSession updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}