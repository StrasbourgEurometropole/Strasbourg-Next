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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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

import eu.strasbourg.service.council.model.Vote;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Vote. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see VoteLocalServiceUtil
 * @see eu.strasbourg.service.council.service.base.VoteLocalServiceBaseImpl
 * @see eu.strasbourg.service.council.service.impl.VoteLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VoteLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VoteLocalServiceUtil} to access the vote local service. Add custom service methods to {@link eu.strasbourg.service.council.service.impl.VoteLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

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
	* Adds the vote to the database. Also notifies the appropriate model listeners.
	*
	* @param vote the vote
	* @return the vote that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Vote addVote(Vote vote);

	/**
	* Crée une entité vide avec une PK, non ajouté à la base de donnée
	*/
	public Vote createVote(ServiceContext sc) throws PortalException;

	/**
	* Creates a new vote with the primary key. Does not add the vote to the database.
	*
	* @param voteId the primary key for the new vote
	* @return the new vote
	*/
	public Vote createVote(long voteId);

	/**
	* Deletes the vote from the database. Also notifies the appropriate model listeners.
	*
	* @param vote the vote
	* @return the vote that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Vote deleteVote(Vote vote);

	/**
	* Deletes the vote with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param voteId the primary key of the vote
	* @return the vote that was removed
	* @throws PortalException if a vote with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Vote deleteVote(long voteId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vote fetchVote(long voteId);

	/**
	* Returns the vote matching the UUID and group.
	*
	* @param uuid the vote's UUID
	* @param groupId the primary key of the group
	* @return the matching vote, or <code>null</code> if a matching vote could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vote fetchVoteByUuidAndGroupId(java.lang.String uuid, long groupId);

	/**
	* Retourne le vote d'un élu pour une délibération
	*/
	public Vote findByDeliberationIdandOfficialId(long deliberationId,
		long officialId);

	/**
	* Returns the vote with the primary key.
	*
	* @param voteId the primary key of the vote
	* @return the vote
	* @throws PortalException if a vote with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vote getVote(long voteId) throws PortalException;

	/**
	* Returns the vote matching the UUID and group.
	*
	* @param uuid the vote's UUID
	* @param groupId the primary key of the group
	* @return the matching vote
	* @throws PortalException if a matching vote could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vote getVoteByUuidAndGroupId(java.lang.String uuid, long groupId)
		throws PortalException;

	/**
	* Supprime une entité
	*/
	public Vote removeVote(long voteId) throws PortalException;

	/**
	* Updates the vote in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vote the vote
	* @return the vote that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Vote updateVote(Vote vote);

	/**
	* Met à jour une entité et l'enregistre en base de données
	*/
	public Vote updateVote(Vote vote, ServiceContext sc)
		throws PortalException;

	/**
	* Returns the number of votes.
	*
	* @return the number of votes
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVotesCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.council.model.impl.VoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.council.model.impl.VoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Retourne la liste des votes d'une délibération
	*/
	public List<Vote> findByDeliberationId(long deliberationId);

	/**
	* Returns a range of all the votes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.council.model.impl.VoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of votes
	* @param end the upper bound of the range of votes (not inclusive)
	* @return the range of votes
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Vote> getVotes(int start, int end);

	/**
	* Returns all the votes matching the UUID and company.
	*
	* @param uuid the UUID of the votes
	* @param companyId the primary key of the company
	* @return the matching votes, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Vote> getVotesByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of votes matching the UUID and company.
	*
	* @param uuid the UUID of the votes
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of votes
	* @param end the upper bound of the range of votes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching votes, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Vote> getVotesByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Vote> orderByComparator);

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
	* Supprime les votes d'une délibération
	*/
	public void removeVotesFromDeliberation(long deliberationId)
		throws PortalException;
}