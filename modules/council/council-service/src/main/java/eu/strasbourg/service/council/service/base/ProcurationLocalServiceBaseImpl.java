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
import eu.strasbourg.service.council.model.Procuration;
import eu.strasbourg.service.council.service.ProcurationLocalService;
import eu.strasbourg.service.council.service.ProcurationLocalServiceUtil;
import eu.strasbourg.service.council.service.persistence.CouncilSessionPersistence;
import eu.strasbourg.service.council.service.persistence.DeliberationPersistence;
import eu.strasbourg.service.council.service.persistence.OfficialPersistence;
import eu.strasbourg.service.council.service.persistence.OfficialTypeCouncilPersistence;
import eu.strasbourg.service.council.service.persistence.ProcurationPersistence;
import eu.strasbourg.service.council.service.persistence.TypePersistence;
import eu.strasbourg.service.council.service.persistence.VotePersistence;

import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Provides the base implementation for the procuration local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.council.service.impl.ProcurationLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.strasbourg.service.council.service.impl.ProcurationLocalServiceImpl
 * @generated
 */
public abstract class ProcurationLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements IdentifiableOSGiService, ProcurationLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProcurationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ProcurationLocalServiceUtil</code>.
	 */

	/**
	 * Adds the procuration to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procuration the procuration
	 * @return the procuration that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Procuration addProcuration(Procuration procuration) {
		procuration.setNew(true);

		return procurationPersistence.update(procuration);
	}

	/**
	 * Creates a new procuration with the primary key. Does not add the procuration to the database.
	 *
	 * @param procurationId the primary key for the new procuration
	 * @return the new procuration
	 */
	@Override
	@Transactional(enabled = false)
	public Procuration createProcuration(long procurationId) {
		return procurationPersistence.create(procurationId);
	}

	/**
	 * Deletes the procuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration that was removed
	 * @throws PortalException if a procuration with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Procuration deleteProcuration(long procurationId)
		throws PortalException {

		return procurationPersistence.remove(procurationId);
	}

	/**
	 * Deletes the procuration from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procuration the procuration
	 * @return the procuration that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Procuration deleteProcuration(Procuration procuration) {
		return procurationPersistence.remove(procuration);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return procurationPersistence.dslQuery(dslQuery);
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
			Procuration.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return procurationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.ProcurationModelImpl</code>.
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

		return procurationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.ProcurationModelImpl</code>.
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

		return procurationPersistence.findWithDynamicQuery(
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
		return procurationPersistence.countWithDynamicQuery(dynamicQuery);
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

		return procurationPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Procuration fetchProcuration(long procurationId) {
		return procurationPersistence.fetchByPrimaryKey(procurationId);
	}

	/**
	 * Returns the procuration matching the UUID and group.
	 *
	 * @param uuid the procuration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchProcurationByUuidAndGroupId(
		String uuid, long groupId) {

		return procurationPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procuration with the primary key.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration
	 * @throws PortalException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration getProcuration(long procurationId)
		throws PortalException {

		return procurationPersistence.findByPrimaryKey(procurationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(procurationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Procuration.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("procurationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			procurationLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Procuration.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"procurationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(procurationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Procuration.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("procurationId");
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
									Procuration.class.getName());

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
			new ActionableDynamicQuery.PerformActionMethod<Procuration>() {

				@Override
				public void performAction(Procuration procuration)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, procuration);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Procuration.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return procurationPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement ProcurationLocalServiceImpl#deleteProcuration(Procuration) to avoid orphaned data");
		}

		return procurationLocalService.deleteProcuration(
			(Procuration)persistedModel);
	}

	@Override
	public BasePersistence<Procuration> getBasePersistence() {
		return procurationPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return procurationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the procurations matching the UUID and company.
	 *
	 * @param uuid the UUID of the procurations
	 * @param companyId the primary key of the company
	 * @return the matching procurations, or an empty list if no matches were found
	 */
	@Override
	public List<Procuration> getProcurationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return procurationPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of procurations matching the UUID and company.
	 *
	 * @param uuid the UUID of the procurations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procurations, or an empty list if no matches were found
	 */
	@Override
	public List<Procuration> getProcurationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return procurationPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the procuration matching the UUID and group.
	 *
	 * @param uuid the procuration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procuration
	 * @throws PortalException if a matching procuration could not be found
	 */
	@Override
	public Procuration getProcurationByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return procurationPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of procurations
	 */
	@Override
	public List<Procuration> getProcurations(int start, int end) {
		return procurationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of procurations.
	 *
	 * @return the number of procurations
	 */
	@Override
	public int getProcurationsCount() {
		return procurationPersistence.countAll();
	}

	/**
	 * Updates the procuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procuration the procuration
	 * @return the procuration that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Procuration updateProcuration(Procuration procuration) {
		return procurationPersistence.update(procuration);
	}

	/**
	 * Returns the council session local service.
	 *
	 * @return the council session local service
	 */
	public eu.strasbourg.service.council.service.CouncilSessionLocalService
		getCouncilSessionLocalService() {

		return councilSessionLocalService;
	}

	/**
	 * Sets the council session local service.
	 *
	 * @param councilSessionLocalService the council session local service
	 */
	public void setCouncilSessionLocalService(
		eu.strasbourg.service.council.service.CouncilSessionLocalService
			councilSessionLocalService) {

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
	public eu.strasbourg.service.council.service.DeliberationLocalService
		getDeliberationLocalService() {

		return deliberationLocalService;
	}

	/**
	 * Sets the deliberation local service.
	 *
	 * @param deliberationLocalService the deliberation local service
	 */
	public void setDeliberationLocalService(
		eu.strasbourg.service.council.service.DeliberationLocalService
			deliberationLocalService) {

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
	public eu.strasbourg.service.council.service.OfficialLocalService
		getOfficialLocalService() {

		return officialLocalService;
	}

	/**
	 * Sets the official local service.
	 *
	 * @param officialLocalService the official local service
	 */
	public void setOfficialLocalService(
		eu.strasbourg.service.council.service.OfficialLocalService
			officialLocalService) {

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
	public void setOfficialPersistence(
		OfficialPersistence officialPersistence) {

		this.officialPersistence = officialPersistence;
	}

	/**
	 * Returns the official type council local service.
	 *
	 * @return the official type council local service
	 */
	public eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService
		getOfficialTypeCouncilLocalService() {

		return officialTypeCouncilLocalService;
	}

	/**
	 * Sets the official type council local service.
	 *
	 * @param officialTypeCouncilLocalService the official type council local service
	 */
	public void setOfficialTypeCouncilLocalService(
		eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService
			officialTypeCouncilLocalService) {

		this.officialTypeCouncilLocalService = officialTypeCouncilLocalService;
	}

	/**
	 * Returns the official type council persistence.
	 *
	 * @return the official type council persistence
	 */
	public OfficialTypeCouncilPersistence getOfficialTypeCouncilPersistence() {
		return officialTypeCouncilPersistence;
	}

	/**
	 * Sets the official type council persistence.
	 *
	 * @param officialTypeCouncilPersistence the official type council persistence
	 */
	public void setOfficialTypeCouncilPersistence(
		OfficialTypeCouncilPersistence officialTypeCouncilPersistence) {

		this.officialTypeCouncilPersistence = officialTypeCouncilPersistence;
	}

	/**
	 * Returns the procuration local service.
	 *
	 * @return the procuration local service
	 */
	public ProcurationLocalService getProcurationLocalService() {
		return procurationLocalService;
	}

	/**
	 * Sets the procuration local service.
	 *
	 * @param procurationLocalService the procuration local service
	 */
	public void setProcurationLocalService(
		ProcurationLocalService procurationLocalService) {

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
	 * Returns the type local service.
	 *
	 * @return the type local service
	 */
	public eu.strasbourg.service.council.service.TypeLocalService
		getTypeLocalService() {

		return typeLocalService;
	}

	/**
	 * Sets the type local service.
	 *
	 * @param typeLocalService the type local service
	 */
	public void setTypeLocalService(
		eu.strasbourg.service.council.service.TypeLocalService
			typeLocalService) {

		this.typeLocalService = typeLocalService;
	}

	/**
	 * Returns the type persistence.
	 *
	 * @return the type persistence
	 */
	public TypePersistence getTypePersistence() {
		return typePersistence;
	}

	/**
	 * Sets the type persistence.
	 *
	 * @param typePersistence the type persistence
	 */
	public void setTypePersistence(TypePersistence typePersistence) {
		this.typePersistence = typePersistence;
	}

	/**
	 * Returns the vote local service.
	 *
	 * @return the vote local service
	 */
	public eu.strasbourg.service.council.service.VoteLocalService
		getVoteLocalService() {

		return voteLocalService;
	}

	/**
	 * Sets the vote local service.
	 *
	 * @param voteLocalService the vote local service
	 */
	public void setVoteLocalService(
		eu.strasbourg.service.council.service.VoteLocalService
			voteLocalService) {

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

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"eu.strasbourg.service.council.model.Procuration",
			procurationLocalService);

		_setLocalServiceUtilService(procurationLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.council.model.Procuration");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProcurationLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Procuration.class;
	}

	protected String getModelClassName() {
		return Procuration.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = procurationPersistence.getDataSource();

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
		ProcurationLocalService procurationLocalService) {

		try {
			Field field = ProcurationLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, procurationLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.council.service.CouncilSessionLocalService.class
	)
	protected eu.strasbourg.service.council.service.CouncilSessionLocalService
		councilSessionLocalService;

	@BeanReference(type = CouncilSessionPersistence.class)
	protected CouncilSessionPersistence councilSessionPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.DeliberationLocalService.class
	)
	protected eu.strasbourg.service.council.service.DeliberationLocalService
		deliberationLocalService;

	@BeanReference(type = DeliberationPersistence.class)
	protected DeliberationPersistence deliberationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.OfficialLocalService.class
	)
	protected eu.strasbourg.service.council.service.OfficialLocalService
		officialLocalService;

	@BeanReference(type = OfficialPersistence.class)
	protected OfficialPersistence officialPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService.class
	)
	protected
		eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService
			officialTypeCouncilLocalService;

	@BeanReference(type = OfficialTypeCouncilPersistence.class)
	protected OfficialTypeCouncilPersistence officialTypeCouncilPersistence;

	@BeanReference(type = ProcurationLocalService.class)
	protected ProcurationLocalService procurationLocalService;

	@BeanReference(type = ProcurationPersistence.class)
	protected ProcurationPersistence procurationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.TypeLocalService.class
	)
	protected eu.strasbourg.service.council.service.TypeLocalService
		typeLocalService;

	@BeanReference(type = TypePersistence.class)
	protected TypePersistence typePersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.VoteLocalService.class
	)
	protected eu.strasbourg.service.council.service.VoteLocalService
		voteLocalService;

	@BeanReference(type = VotePersistence.class)
	protected VotePersistence votePersistence;

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

	private static final Log _log = LogFactoryUtil.getLog(
		ProcurationLocalServiceBaseImpl.class);

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}