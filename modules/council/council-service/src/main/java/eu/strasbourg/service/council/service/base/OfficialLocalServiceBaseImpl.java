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

package eu.strasbourg.service.council.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.service.OfficialLocalService;
import eu.strasbourg.service.council.service.persistence.CouncilSessionPersistence;
import eu.strasbourg.service.council.service.persistence.DeliberationPersistence;
import eu.strasbourg.service.council.service.persistence.OfficialPersistence;
import eu.strasbourg.service.council.service.persistence.ProcurationPersistence;
import eu.strasbourg.service.council.service.persistence.VotePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the official local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.council.service.impl.OfficialLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.strasbourg.service.council.service.impl.OfficialLocalServiceImpl
 * @see eu.strasbourg.service.council.service.OfficialLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class OfficialLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements OfficialLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link eu.strasbourg.service.council.service.OfficialLocalServiceUtil} to access the official local service.
	 */

	/**
	 * Adds the official to the database. Also notifies the appropriate model listeners.
	 *
	 * @param official the official
	 * @return the official that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Official addOfficial(Official official) {
		official.setNew(true);

		return officialPersistence.update(official);
	}

	/**
	 * Creates a new official with the primary key. Does not add the official to the database.
	 *
	 * @param officailId the primary key for the new official
	 * @return the new official
	 */
	@Override
	public Official createOfficial(long officailId) {
		return officialPersistence.create(officailId);
	}

	/**
	 * Deletes the official with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officailId the primary key of the official
	 * @return the official that was removed
	 * @throws PortalException if a official with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Official deleteOfficial(long officailId) throws PortalException {
		return officialPersistence.remove(officailId);
	}

	/**
	 * Deletes the official from the database. Also notifies the appropriate model listeners.
	 *
	 * @param official the official
	 * @return the official that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Official deleteOfficial(Official official) {
		return officialPersistence.remove(official);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Official.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return officialPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return officialPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return officialPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return officialPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return officialPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Official fetchOfficial(long officailId) {
		return officialPersistence.fetchByPrimaryKey(officailId);
	}

	/**
	 * Returns the official matching the UUID and group.
	 *
	 * @param uuid the official's UUID
	 * @param groupId the primary key of the group
	 * @return the matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchOfficialByUuidAndGroupId(String uuid, long groupId) {
		return officialPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the official with the primary key.
	 *
	 * @param officailId the primary key of the official
	 * @return the official
	 * @throws PortalException if a official with the primary key could not be found
	 */
	@Override
	public Official getOfficial(long officailId) throws PortalException {
		return officialPersistence.findByPrimaryKey(officailId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(officialLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Official.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("officailId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(officialLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Official.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("officailId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(officialLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Official.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("officailId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion = portletDataContext.getDateRangeCriteria(
							"modifiedDate");

					Criterion statusDateCriterion = portletDataContext.getDateRangeCriteria(
							"statusDate");

					if ((modifiedDateCriterion != null) &&
							(statusDateCriterion != null)) {
						Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty = PropertyFactoryUtil.forName(
							"status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler = StagedModelDataHandlerRegistryUtil.getStagedModelDataHandler(Official.class.getName());

						dynamicQuery.add(workflowStatusProperty.in(
								stagedModelDataHandler.getExportableStatuses()));
					}
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Official>() {
				@Override
				public void performAction(Official official)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						official);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(Official.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return officialLocalService.deleteOfficial((Official)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return officialPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the officials matching the UUID and company.
	 *
	 * @param uuid the UUID of the officials
	 * @param companyId the primary key of the company
	 * @return the matching officials, or an empty list if no matches were found
	 */
	@Override
	public List<Official> getOfficialsByUuidAndCompanyId(String uuid,
		long companyId) {
		return officialPersistence.findByUuid_C(uuid, companyId);
	}

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
	@Override
	public List<Official> getOfficialsByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<Official> orderByComparator) {
		return officialPersistence.findByUuid_C(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the official matching the UUID and group.
	 *
	 * @param uuid the official's UUID
	 * @param groupId the primary key of the group
	 * @return the matching official
	 * @throws PortalException if a matching official could not be found
	 */
	@Override
	public Official getOfficialByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {
		return officialPersistence.findByUUID_G(uuid, groupId);
	}

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
	@Override
	public List<Official> getOfficials(int start, int end) {
		return officialPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of officials.
	 *
	 * @return the number of officials
	 */
	@Override
	public int getOfficialsCount() {
		return officialPersistence.countAll();
	}

	/**
	 * Updates the official in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param official the official
	 * @return the official that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Official updateOfficial(Official official) {
		return officialPersistence.update(official);
	}

	/**
	 * Returns the council session local service.
	 *
	 * @return the council session local service
	 */
	public eu.strasbourg.service.council.service.CouncilSessionLocalService getCouncilSessionLocalService() {
		return councilSessionLocalService;
	}

	/**
	 * Sets the council session local service.
	 *
	 * @param councilSessionLocalService the council session local service
	 */
	public void setCouncilSessionLocalService(
		eu.strasbourg.service.council.service.CouncilSessionLocalService councilSessionLocalService) {
		this.councilSessionLocalService = councilSessionLocalService;
	}

	/**
	 * Returns the council session persistence.
	 *
	 * @return the council session persistence
	 */
	public CouncilSessionPersistence getCouncilSessionPersistence() {
		return councilSessionPersistence;
	}

	/**
	 * Sets the council session persistence.
	 *
	 * @param councilSessionPersistence the council session persistence
	 */
	public void setCouncilSessionPersistence(
		CouncilSessionPersistence councilSessionPersistence) {
		this.councilSessionPersistence = councilSessionPersistence;
	}

	/**
	 * Returns the deliberation local service.
	 *
	 * @return the deliberation local service
	 */
	public eu.strasbourg.service.council.service.DeliberationLocalService getDeliberationLocalService() {
		return deliberationLocalService;
	}

	/**
	 * Sets the deliberation local service.
	 *
	 * @param deliberationLocalService the deliberation local service
	 */
	public void setDeliberationLocalService(
		eu.strasbourg.service.council.service.DeliberationLocalService deliberationLocalService) {
		this.deliberationLocalService = deliberationLocalService;
	}

	/**
	 * Returns the deliberation persistence.
	 *
	 * @return the deliberation persistence
	 */
	public DeliberationPersistence getDeliberationPersistence() {
		return deliberationPersistence;
	}

	/**
	 * Sets the deliberation persistence.
	 *
	 * @param deliberationPersistence the deliberation persistence
	 */
	public void setDeliberationPersistence(
		DeliberationPersistence deliberationPersistence) {
		this.deliberationPersistence = deliberationPersistence;
	}

	/**
	 * Returns the official local service.
	 *
	 * @return the official local service
	 */
	public OfficialLocalService getOfficialLocalService() {
		return officialLocalService;
	}

	/**
	 * Sets the official local service.
	 *
	 * @param officialLocalService the official local service
	 */
	public void setOfficialLocalService(
		OfficialLocalService officialLocalService) {
		this.officialLocalService = officialLocalService;
	}

	/**
	 * Returns the official persistence.
	 *
	 * @return the official persistence
	 */
	public OfficialPersistence getOfficialPersistence() {
		return officialPersistence;
	}

	/**
	 * Sets the official persistence.
	 *
	 * @param officialPersistence the official persistence
	 */
	public void setOfficialPersistence(OfficialPersistence officialPersistence) {
		this.officialPersistence = officialPersistence;
	}

	/**
	 * Returns the procuration local service.
	 *
	 * @return the procuration local service
	 */
	public eu.strasbourg.service.council.service.ProcurationLocalService getProcurationLocalService() {
		return procurationLocalService;
	}

	/**
	 * Sets the procuration local service.
	 *
	 * @param procurationLocalService the procuration local service
	 */
	public void setProcurationLocalService(
		eu.strasbourg.service.council.service.ProcurationLocalService procurationLocalService) {
		this.procurationLocalService = procurationLocalService;
	}

	/**
	 * Returns the procuration persistence.
	 *
	 * @return the procuration persistence
	 */
	public ProcurationPersistence getProcurationPersistence() {
		return procurationPersistence;
	}

	/**
	 * Sets the procuration persistence.
	 *
	 * @param procurationPersistence the procuration persistence
	 */
	public void setProcurationPersistence(
		ProcurationPersistence procurationPersistence) {
		this.procurationPersistence = procurationPersistence;
	}

	/**
	 * Returns the vote local service.
	 *
	 * @return the vote local service
	 */
	public eu.strasbourg.service.council.service.VoteLocalService getVoteLocalService() {
		return voteLocalService;
	}

	/**
	 * Sets the vote local service.
	 *
	 * @param voteLocalService the vote local service
	 */
	public void setVoteLocalService(
		eu.strasbourg.service.council.service.VoteLocalService voteLocalService) {
		this.voteLocalService = voteLocalService;
	}

	/**
	 * Returns the vote persistence.
	 *
	 * @return the vote persistence
	 */
	public VotePersistence getVotePersistence() {
		return votePersistence;
	}

	/**
	 * Sets the vote persistence.
	 *
	 * @param votePersistence the vote persistence
	 */
	public void setVotePersistence(VotePersistence votePersistence) {
		this.votePersistence = votePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("eu.strasbourg.service.council.model.Official",
			officialLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.council.model.Official");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return OfficialLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Official.class;
	}

	protected String getModelClassName() {
		return Official.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = officialPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = eu.strasbourg.service.council.service.CouncilSessionLocalService.class)
	protected eu.strasbourg.service.council.service.CouncilSessionLocalService councilSessionLocalService;
	@BeanReference(type = CouncilSessionPersistence.class)
	protected CouncilSessionPersistence councilSessionPersistence;
	@BeanReference(type = eu.strasbourg.service.council.service.DeliberationLocalService.class)
	protected eu.strasbourg.service.council.service.DeliberationLocalService deliberationLocalService;
	@BeanReference(type = DeliberationPersistence.class)
	protected DeliberationPersistence deliberationPersistence;
	@BeanReference(type = OfficialLocalService.class)
	protected OfficialLocalService officialLocalService;
	@BeanReference(type = OfficialPersistence.class)
	protected OfficialPersistence officialPersistence;
	@BeanReference(type = eu.strasbourg.service.council.service.ProcurationLocalService.class)
	protected eu.strasbourg.service.council.service.ProcurationLocalService procurationLocalService;
	@BeanReference(type = ProcurationPersistence.class)
	protected ProcurationPersistence procurationPersistence;
	@BeanReference(type = eu.strasbourg.service.council.service.VoteLocalService.class)
	protected eu.strasbourg.service.council.service.VoteLocalService voteLocalService;
	@BeanReference(type = VotePersistence.class)
	protected VotePersistence votePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}