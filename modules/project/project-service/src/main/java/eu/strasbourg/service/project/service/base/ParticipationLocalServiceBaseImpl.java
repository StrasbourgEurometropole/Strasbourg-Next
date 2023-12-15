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

package eu.strasbourg.service.project.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.link.service.persistence.AssetLinkPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;
import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.project.model.Participation;
import eu.strasbourg.service.project.service.ParticipationLocalService;
import eu.strasbourg.service.project.service.ParticipationLocalServiceUtil;
import eu.strasbourg.service.project.service.persistence.BudgetParticipatifFinder;
import eu.strasbourg.service.project.service.persistence.BudgetParticipatifPersistence;
import eu.strasbourg.service.project.service.persistence.BudgetPhasePersistence;
import eu.strasbourg.service.project.service.persistence.BudgetSupportPersistence;
import eu.strasbourg.service.project.service.persistence.InitiativeHelpPersistence;
import eu.strasbourg.service.project.service.persistence.InitiativePersistence;
import eu.strasbourg.service.project.service.persistence.ParticipationPersistence;
import eu.strasbourg.service.project.service.persistence.PetitionPersistence;
import eu.strasbourg.service.project.service.persistence.PlacitPlacePersistence;
import eu.strasbourg.service.project.service.persistence.ProjectFollowedPersistence;
import eu.strasbourg.service.project.service.persistence.ProjectPersistence;
import eu.strasbourg.service.project.service.persistence.ProjectTimelinePersistence;
import eu.strasbourg.service.project.service.persistence.SaisineObservatoirePersistence;
import eu.strasbourg.service.project.service.persistence.SignatairePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the participation local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.project.service.impl.ParticipationLocalServiceImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see eu.strasbourg.service.project.service.impl.ParticipationLocalServiceImpl
 * @generated
 */
public abstract class ParticipationLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements IdentifiableOSGiService, ParticipationLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ParticipationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ParticipationLocalServiceUtil</code>.
	 */

	/**
	 * Adds the participation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participation the participation
	 * @return the participation that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Participation addParticipation(Participation participation) {
		participation.setNew(true);

		return participationPersistence.update(participation);
	}

	/**
	 * Creates a new participation with the primary key. Does not add the participation to the database.
	 *
	 * @param participationId the primary key for the new participation
	 * @return the new participation
	 */
	@Override
	@Transactional(enabled = false)
	public Participation createParticipation(long participationId) {
		return participationPersistence.create(participationId);
	}

	/**
	 * Deletes the participation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationId the primary key of the participation
	 * @return the participation that was removed
	 * @throws PortalException if a participation with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Participation deleteParticipation(long participationId)
		throws PortalException {

		return participationPersistence.remove(participationId);
	}

	/**
	 * Deletes the participation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participation the participation
	 * @return the participation that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Participation deleteParticipation(Participation participation) {
		return participationPersistence.remove(participation);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return participationPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Participation.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return participationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ParticipationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return participationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ParticipationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return participationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return participationPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return participationPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Participation fetchParticipation(long participationId) {
		return participationPersistence.fetchByPrimaryKey(participationId);
	}

	/**
	 * Returns the participation matching the UUID and group.
	 *
	 * @param uuid the participation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation, or <code>null</code> if a matching participation could not be found
	 */
	@Override
	public Participation fetchParticipationByUuidAndGroupId(
		String uuid, long groupId) {

		return participationPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the participation with the primary key.
	 *
	 * @param participationId the primary key of the participation
	 * @return the participation
	 * @throws PortalException if a participation with the primary key could not be found
	 */
	@Override
	public Participation getParticipation(long participationId)
		throws PortalException {

		return participationPersistence.findByPrimaryKey(participationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(participationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Participation.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("participationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			participationLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Participation.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"participationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(participationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Participation.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("participationId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									Participation.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Participation>() {

				@Override
				public void performAction(Participation participation)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, participation);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Participation.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return participationPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement ParticipationLocalServiceImpl#deleteParticipation(Participation) to avoid orphaned data");
		}

		return participationLocalService.deleteParticipation(
			(Participation)persistedModel);
	}

	@Override
	public BasePersistence<Participation> getBasePersistence() {
		return participationPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return participationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the participations matching the UUID and company.
	 *
	 * @param uuid the UUID of the participations
	 * @param companyId the primary key of the company
	 * @return the matching participations, or an empty list if no matches were found
	 */
	@Override
	public List<Participation> getParticipationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return participationPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of participations matching the UUID and company.
	 *
	 * @param uuid the UUID of the participations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of participations
	 * @param end the upper bound of the range of participations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching participations, or an empty list if no matches were found
	 */
	@Override
	public List<Participation> getParticipationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Participation> orderByComparator) {

		return participationPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the participation matching the UUID and group.
	 *
	 * @param uuid the participation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation
	 * @throws PortalException if a matching participation could not be found
	 */
	@Override
	public Participation getParticipationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return participationPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the participations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ParticipationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participations
	 * @param end the upper bound of the range of participations (not inclusive)
	 * @return the range of participations
	 */
	@Override
	public List<Participation> getParticipations(int start, int end) {
		return participationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of participations.
	 *
	 * @return the number of participations
	 */
	@Override
	public int getParticipationsCount() {
		return participationPersistence.countAll();
	}

	/**
	 * Updates the participation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participation the participation
	 * @return the participation that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Participation updateParticipation(Participation participation) {
		return participationPersistence.update(participation);
	}

	/**
	 * Returns the budget participatif local service.
	 *
	 * @return the budget participatif local service
	 */
	public eu.strasbourg.service.project.service.BudgetParticipatifLocalService
		getBudgetParticipatifLocalService() {

		return budgetParticipatifLocalService;
	}

	/**
	 * Sets the budget participatif local service.
	 *
	 * @param budgetParticipatifLocalService the budget participatif local service
	 */
	public void setBudgetParticipatifLocalService(
		eu.strasbourg.service.project.service.BudgetParticipatifLocalService
			budgetParticipatifLocalService) {

		this.budgetParticipatifLocalService = budgetParticipatifLocalService;
	}

	/**
	 * Returns the budget participatif persistence.
	 *
	 * @return the budget participatif persistence
	 */
	public BudgetParticipatifPersistence getBudgetParticipatifPersistence() {
		return budgetParticipatifPersistence;
	}

	/**
	 * Sets the budget participatif persistence.
	 *
	 * @param budgetParticipatifPersistence the budget participatif persistence
	 */
	public void setBudgetParticipatifPersistence(
		BudgetParticipatifPersistence budgetParticipatifPersistence) {

		this.budgetParticipatifPersistence = budgetParticipatifPersistence;
	}

	/**
	 * Returns the budget participatif finder.
	 *
	 * @return the budget participatif finder
	 */
	public BudgetParticipatifFinder getBudgetParticipatifFinder() {
		return budgetParticipatifFinder;
	}

	/**
	 * Sets the budget participatif finder.
	 *
	 * @param budgetParticipatifFinder the budget participatif finder
	 */
	public void setBudgetParticipatifFinder(
		BudgetParticipatifFinder budgetParticipatifFinder) {

		this.budgetParticipatifFinder = budgetParticipatifFinder;
	}

	/**
	 * Returns the budget phase local service.
	 *
	 * @return the budget phase local service
	 */
	public eu.strasbourg.service.project.service.BudgetPhaseLocalService
		getBudgetPhaseLocalService() {

		return budgetPhaseLocalService;
	}

	/**
	 * Sets the budget phase local service.
	 *
	 * @param budgetPhaseLocalService the budget phase local service
	 */
	public void setBudgetPhaseLocalService(
		eu.strasbourg.service.project.service.BudgetPhaseLocalService
			budgetPhaseLocalService) {

		this.budgetPhaseLocalService = budgetPhaseLocalService;
	}

	/**
	 * Returns the budget phase persistence.
	 *
	 * @return the budget phase persistence
	 */
	public BudgetPhasePersistence getBudgetPhasePersistence() {
		return budgetPhasePersistence;
	}

	/**
	 * Sets the budget phase persistence.
	 *
	 * @param budgetPhasePersistence the budget phase persistence
	 */
	public void setBudgetPhasePersistence(
		BudgetPhasePersistence budgetPhasePersistence) {

		this.budgetPhasePersistence = budgetPhasePersistence;
	}

	/**
	 * Returns the budget support local service.
	 *
	 * @return the budget support local service
	 */
	public eu.strasbourg.service.project.service.BudgetSupportLocalService
		getBudgetSupportLocalService() {

		return budgetSupportLocalService;
	}

	/**
	 * Sets the budget support local service.
	 *
	 * @param budgetSupportLocalService the budget support local service
	 */
	public void setBudgetSupportLocalService(
		eu.strasbourg.service.project.service.BudgetSupportLocalService
			budgetSupportLocalService) {

		this.budgetSupportLocalService = budgetSupportLocalService;
	}

	/**
	 * Returns the budget support persistence.
	 *
	 * @return the budget support persistence
	 */
	public BudgetSupportPersistence getBudgetSupportPersistence() {
		return budgetSupportPersistence;
	}

	/**
	 * Sets the budget support persistence.
	 *
	 * @param budgetSupportPersistence the budget support persistence
	 */
	public void setBudgetSupportPersistence(
		BudgetSupportPersistence budgetSupportPersistence) {

		this.budgetSupportPersistence = budgetSupportPersistence;
	}

	/**
	 * Returns the initiative local service.
	 *
	 * @return the initiative local service
	 */
	public eu.strasbourg.service.project.service.InitiativeLocalService
		getInitiativeLocalService() {

		return initiativeLocalService;
	}

	/**
	 * Sets the initiative local service.
	 *
	 * @param initiativeLocalService the initiative local service
	 */
	public void setInitiativeLocalService(
		eu.strasbourg.service.project.service.InitiativeLocalService
			initiativeLocalService) {

		this.initiativeLocalService = initiativeLocalService;
	}

	/**
	 * Returns the initiative persistence.
	 *
	 * @return the initiative persistence
	 */
	public InitiativePersistence getInitiativePersistence() {
		return initiativePersistence;
	}

	/**
	 * Sets the initiative persistence.
	 *
	 * @param initiativePersistence the initiative persistence
	 */
	public void setInitiativePersistence(
		InitiativePersistence initiativePersistence) {

		this.initiativePersistence = initiativePersistence;
	}

	/**
	 * Returns the initiative help local service.
	 *
	 * @return the initiative help local service
	 */
	public eu.strasbourg.service.project.service.InitiativeHelpLocalService
		getInitiativeHelpLocalService() {

		return initiativeHelpLocalService;
	}

	/**
	 * Sets the initiative help local service.
	 *
	 * @param initiativeHelpLocalService the initiative help local service
	 */
	public void setInitiativeHelpLocalService(
		eu.strasbourg.service.project.service.InitiativeHelpLocalService
			initiativeHelpLocalService) {

		this.initiativeHelpLocalService = initiativeHelpLocalService;
	}

	/**
	 * Returns the initiative help persistence.
	 *
	 * @return the initiative help persistence
	 */
	public InitiativeHelpPersistence getInitiativeHelpPersistence() {
		return initiativeHelpPersistence;
	}

	/**
	 * Sets the initiative help persistence.
	 *
	 * @param initiativeHelpPersistence the initiative help persistence
	 */
	public void setInitiativeHelpPersistence(
		InitiativeHelpPersistence initiativeHelpPersistence) {

		this.initiativeHelpPersistence = initiativeHelpPersistence;
	}

	/**
	 * Returns the participation local service.
	 *
	 * @return the participation local service
	 */
	public ParticipationLocalService getParticipationLocalService() {
		return participationLocalService;
	}

	/**
	 * Sets the participation local service.
	 *
	 * @param participationLocalService the participation local service
	 */
	public void setParticipationLocalService(
		ParticipationLocalService participationLocalService) {

		this.participationLocalService = participationLocalService;
	}

	/**
	 * Returns the participation persistence.
	 *
	 * @return the participation persistence
	 */
	public ParticipationPersistence getParticipationPersistence() {
		return participationPersistence;
	}

	/**
	 * Sets the participation persistence.
	 *
	 * @param participationPersistence the participation persistence
	 */
	public void setParticipationPersistence(
		ParticipationPersistence participationPersistence) {

		this.participationPersistence = participationPersistence;
	}

	/**
	 * Returns the petition local service.
	 *
	 * @return the petition local service
	 */
	public eu.strasbourg.service.project.service.PetitionLocalService
		getPetitionLocalService() {

		return petitionLocalService;
	}

	/**
	 * Sets the petition local service.
	 *
	 * @param petitionLocalService the petition local service
	 */
	public void setPetitionLocalService(
		eu.strasbourg.service.project.service.PetitionLocalService
			petitionLocalService) {

		this.petitionLocalService = petitionLocalService;
	}

	/**
	 * Returns the petition persistence.
	 *
	 * @return the petition persistence
	 */
	public PetitionPersistence getPetitionPersistence() {
		return petitionPersistence;
	}

	/**
	 * Sets the petition persistence.
	 *
	 * @param petitionPersistence the petition persistence
	 */
	public void setPetitionPersistence(
		PetitionPersistence petitionPersistence) {

		this.petitionPersistence = petitionPersistence;
	}

	/**
	 * Returns the placit place local service.
	 *
	 * @return the placit place local service
	 */
	public eu.strasbourg.service.project.service.PlacitPlaceLocalService
		getPlacitPlaceLocalService() {

		return placitPlaceLocalService;
	}

	/**
	 * Sets the placit place local service.
	 *
	 * @param placitPlaceLocalService the placit place local service
	 */
	public void setPlacitPlaceLocalService(
		eu.strasbourg.service.project.service.PlacitPlaceLocalService
			placitPlaceLocalService) {

		this.placitPlaceLocalService = placitPlaceLocalService;
	}

	/**
	 * Returns the placit place persistence.
	 *
	 * @return the placit place persistence
	 */
	public PlacitPlacePersistence getPlacitPlacePersistence() {
		return placitPlacePersistence;
	}

	/**
	 * Sets the placit place persistence.
	 *
	 * @param placitPlacePersistence the placit place persistence
	 */
	public void setPlacitPlacePersistence(
		PlacitPlacePersistence placitPlacePersistence) {

		this.placitPlacePersistence = placitPlacePersistence;
	}

	/**
	 * Returns the project local service.
	 *
	 * @return the project local service
	 */
	public eu.strasbourg.service.project.service.ProjectLocalService
		getProjectLocalService() {

		return projectLocalService;
	}

	/**
	 * Sets the project local service.
	 *
	 * @param projectLocalService the project local service
	 */
	public void setProjectLocalService(
		eu.strasbourg.service.project.service.ProjectLocalService
			projectLocalService) {

		this.projectLocalService = projectLocalService;
	}

	/**
	 * Returns the project persistence.
	 *
	 * @return the project persistence
	 */
	public ProjectPersistence getProjectPersistence() {
		return projectPersistence;
	}

	/**
	 * Sets the project persistence.
	 *
	 * @param projectPersistence the project persistence
	 */
	public void setProjectPersistence(ProjectPersistence projectPersistence) {
		this.projectPersistence = projectPersistence;
	}

	/**
	 * Returns the project followed local service.
	 *
	 * @return the project followed local service
	 */
	public eu.strasbourg.service.project.service.ProjectFollowedLocalService
		getProjectFollowedLocalService() {

		return projectFollowedLocalService;
	}

	/**
	 * Sets the project followed local service.
	 *
	 * @param projectFollowedLocalService the project followed local service
	 */
	public void setProjectFollowedLocalService(
		eu.strasbourg.service.project.service.ProjectFollowedLocalService
			projectFollowedLocalService) {

		this.projectFollowedLocalService = projectFollowedLocalService;
	}

	/**
	 * Returns the project followed persistence.
	 *
	 * @return the project followed persistence
	 */
	public ProjectFollowedPersistence getProjectFollowedPersistence() {
		return projectFollowedPersistence;
	}

	/**
	 * Sets the project followed persistence.
	 *
	 * @param projectFollowedPersistence the project followed persistence
	 */
	public void setProjectFollowedPersistence(
		ProjectFollowedPersistence projectFollowedPersistence) {

		this.projectFollowedPersistence = projectFollowedPersistence;
	}

	/**
	 * Returns the project timeline local service.
	 *
	 * @return the project timeline local service
	 */
	public eu.strasbourg.service.project.service.ProjectTimelineLocalService
		getProjectTimelineLocalService() {

		return projectTimelineLocalService;
	}

	/**
	 * Sets the project timeline local service.
	 *
	 * @param projectTimelineLocalService the project timeline local service
	 */
	public void setProjectTimelineLocalService(
		eu.strasbourg.service.project.service.ProjectTimelineLocalService
			projectTimelineLocalService) {

		this.projectTimelineLocalService = projectTimelineLocalService;
	}

	/**
	 * Returns the project timeline persistence.
	 *
	 * @return the project timeline persistence
	 */
	public ProjectTimelinePersistence getProjectTimelinePersistence() {
		return projectTimelinePersistence;
	}

	/**
	 * Sets the project timeline persistence.
	 *
	 * @param projectTimelinePersistence the project timeline persistence
	 */
	public void setProjectTimelinePersistence(
		ProjectTimelinePersistence projectTimelinePersistence) {

		this.projectTimelinePersistence = projectTimelinePersistence;
	}

	/**
	 * Returns the saisine observatoire local service.
	 *
	 * @return the saisine observatoire local service
	 */
	public eu.strasbourg.service.project.service.SaisineObservatoireLocalService
		getSaisineObservatoireLocalService() {

		return saisineObservatoireLocalService;
	}

	/**
	 * Sets the saisine observatoire local service.
	 *
	 * @param saisineObservatoireLocalService the saisine observatoire local service
	 */
	public void setSaisineObservatoireLocalService(
		eu.strasbourg.service.project.service.SaisineObservatoireLocalService
			saisineObservatoireLocalService) {

		this.saisineObservatoireLocalService = saisineObservatoireLocalService;
	}

	/**
	 * Returns the saisine observatoire persistence.
	 *
	 * @return the saisine observatoire persistence
	 */
	public SaisineObservatoirePersistence getSaisineObservatoirePersistence() {
		return saisineObservatoirePersistence;
	}

	/**
	 * Sets the saisine observatoire persistence.
	 *
	 * @param saisineObservatoirePersistence the saisine observatoire persistence
	 */
	public void setSaisineObservatoirePersistence(
		SaisineObservatoirePersistence saisineObservatoirePersistence) {

		this.saisineObservatoirePersistence = saisineObservatoirePersistence;
	}

	/**
	 * Returns the signataire local service.
	 *
	 * @return the signataire local service
	 */
	public eu.strasbourg.service.project.service.SignataireLocalService
		getSignataireLocalService() {

		return signataireLocalService;
	}

	/**
	 * Sets the signataire local service.
	 *
	 * @param signataireLocalService the signataire local service
	 */
	public void setSignataireLocalService(
		eu.strasbourg.service.project.service.SignataireLocalService
			signataireLocalService) {

		this.signataireLocalService = signataireLocalService;
	}

	/**
	 * Returns the signataire persistence.
	 *
	 * @return the signataire persistence
	 */
	public SignatairePersistence getSignatairePersistence() {
		return signatairePersistence;
	}

	/**
	 * Sets the signataire persistence.
	 *
	 * @param signatairePersistence the signataire persistence
	 */
	public void setSignatairePersistence(
		SignatairePersistence signatairePersistence) {

		this.signatairePersistence = signatairePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

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
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

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

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService
		getAssetEntryLocalService() {

		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService
			assetEntryLocalService) {

		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {

		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.asset.link.service.AssetLinkLocalService
		getAssetLinkLocalService() {

		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.link.service.AssetLinkLocalService
			assetLinkLocalService) {

		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {

		this.assetLinkPersistence = assetLinkPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.asset.kernel.service.AssetTagLocalService
		getAssetTagLocalService() {

		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService
			assetTagLocalService) {

		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(
		AssetTagPersistence assetTagPersistence) {

		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"eu.strasbourg.service.project.model.Participation",
			participationLocalService);

		_setLocalServiceUtilService(participationLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.project.model.Participation");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ParticipationLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Participation.class;
	}

	protected String getModelClassName() {
		return Participation.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = participationPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ParticipationLocalService participationLocalService) {

		try {
			Field field = ParticipationLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, participationLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetParticipatifLocalService.class
	)
	protected
		eu.strasbourg.service.project.service.BudgetParticipatifLocalService
			budgetParticipatifLocalService;

	@BeanReference(type = BudgetParticipatifPersistence.class)
	protected BudgetParticipatifPersistence budgetParticipatifPersistence;

	@BeanReference(type = BudgetParticipatifFinder.class)
	protected BudgetParticipatifFinder budgetParticipatifFinder;

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetPhaseLocalService.class
	)
	protected eu.strasbourg.service.project.service.BudgetPhaseLocalService
		budgetPhaseLocalService;

	@BeanReference(type = BudgetPhasePersistence.class)
	protected BudgetPhasePersistence budgetPhasePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetSupportLocalService.class
	)
	protected eu.strasbourg.service.project.service.BudgetSupportLocalService
		budgetSupportLocalService;

	@BeanReference(type = BudgetSupportPersistence.class)
	protected BudgetSupportPersistence budgetSupportPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.InitiativeLocalService.class
	)
	protected eu.strasbourg.service.project.service.InitiativeLocalService
		initiativeLocalService;

	@BeanReference(type = InitiativePersistence.class)
	protected InitiativePersistence initiativePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.InitiativeHelpLocalService.class
	)
	protected eu.strasbourg.service.project.service.InitiativeHelpLocalService
		initiativeHelpLocalService;

	@BeanReference(type = InitiativeHelpPersistence.class)
	protected InitiativeHelpPersistence initiativeHelpPersistence;

	@BeanReference(type = ParticipationLocalService.class)
	protected ParticipationLocalService participationLocalService;

	@BeanReference(type = ParticipationPersistence.class)
	protected ParticipationPersistence participationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.PetitionLocalService.class
	)
	protected eu.strasbourg.service.project.service.PetitionLocalService
		petitionLocalService;

	@BeanReference(type = PetitionPersistence.class)
	protected PetitionPersistence petitionPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.PlacitPlaceLocalService.class
	)
	protected eu.strasbourg.service.project.service.PlacitPlaceLocalService
		placitPlaceLocalService;

	@BeanReference(type = PlacitPlacePersistence.class)
	protected PlacitPlacePersistence placitPlacePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ProjectLocalService.class
	)
	protected eu.strasbourg.service.project.service.ProjectLocalService
		projectLocalService;

	@BeanReference(type = ProjectPersistence.class)
	protected ProjectPersistence projectPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ProjectFollowedLocalService.class
	)
	protected eu.strasbourg.service.project.service.ProjectFollowedLocalService
		projectFollowedLocalService;

	@BeanReference(type = ProjectFollowedPersistence.class)
	protected ProjectFollowedPersistence projectFollowedPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ProjectTimelineLocalService.class
	)
	protected eu.strasbourg.service.project.service.ProjectTimelineLocalService
		projectTimelineLocalService;

	@BeanReference(type = ProjectTimelinePersistence.class)
	protected ProjectTimelinePersistence projectTimelinePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.SaisineObservatoireLocalService.class
	)
	protected
		eu.strasbourg.service.project.service.SaisineObservatoireLocalService
			saisineObservatoireLocalService;

	@BeanReference(type = SaisineObservatoirePersistence.class)
	protected SaisineObservatoirePersistence saisineObservatoirePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.SignataireLocalService.class
	)
	protected eu.strasbourg.service.project.service.SignataireLocalService
		signataireLocalService;

	@BeanReference(type = SignatairePersistence.class)
	protected SignatairePersistence signatairePersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;

	@ServiceReference(
		type = com.liferay.asset.link.service.AssetLinkLocalService.class
	)
	protected com.liferay.asset.link.service.AssetLinkLocalService
		assetLinkLocalService;

	@ServiceReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ParticipationLocalServiceBaseImpl.class);

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}