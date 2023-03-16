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

package eu.strasbourg.service.agenda.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetLinkPersistence;
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
import com.liferay.portal.kernel.dao.orm.Conjunction;
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

import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.service.CampaignLocalService;
import eu.strasbourg.service.agenda.service.CampaignLocalServiceUtil;
import eu.strasbourg.service.agenda.service.persistence.AgendaExportPeriodPersistence;
import eu.strasbourg.service.agenda.service.persistence.AgendaExportPersistence;
import eu.strasbourg.service.agenda.service.persistence.CacheJsonPersistence;
import eu.strasbourg.service.agenda.service.persistence.CampaignEventFinder;
import eu.strasbourg.service.agenda.service.persistence.CampaignEventPersistence;
import eu.strasbourg.service.agenda.service.persistence.CampaignEventStatusPersistence;
import eu.strasbourg.service.agenda.service.persistence.CampaignPersistence;
import eu.strasbourg.service.agenda.service.persistence.CsmapCacheJsonPersistence;
import eu.strasbourg.service.agenda.service.persistence.EventFinder;
import eu.strasbourg.service.agenda.service.persistence.EventParticipationPersistence;
import eu.strasbourg.service.agenda.service.persistence.EventPeriodPersistence;
import eu.strasbourg.service.agenda.service.persistence.EventPersistence;
import eu.strasbourg.service.agenda.service.persistence.HistoricPersistence;
import eu.strasbourg.service.agenda.service.persistence.ImportReportLinePersistence;
import eu.strasbourg.service.agenda.service.persistence.ImportReportPersistence;
import eu.strasbourg.service.agenda.service.persistence.ManifestationPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the campaign local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.agenda.service.impl.CampaignLocalServiceImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see eu.strasbourg.service.agenda.service.impl.CampaignLocalServiceImpl
 * @generated
 */
public abstract class CampaignLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CampaignLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CampaignLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CampaignLocalServiceUtil</code>.
	 */

	/**
	 * Adds the campaign to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaign the campaign
	 * @return the campaign that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Campaign addCampaign(Campaign campaign) {
		campaign.setNew(true);

		return campaignPersistence.update(campaign);
	}

	/**
	 * Creates a new campaign with the primary key. Does not add the campaign to the database.
	 *
	 * @param campaignId the primary key for the new campaign
	 * @return the new campaign
	 */
	@Override
	@Transactional(enabled = false)
	public Campaign createCampaign(long campaignId) {
		return campaignPersistence.create(campaignId);
	}

	/**
	 * Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign that was removed
	 * @throws PortalException if a campaign with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Campaign deleteCampaign(long campaignId) throws PortalException {
		return campaignPersistence.remove(campaignId);
	}

	/**
	 * Deletes the campaign from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaign the campaign
	 * @return the campaign that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Campaign deleteCampaign(Campaign campaign) {
		return campaignPersistence.remove(campaign);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return campaignPersistence.dslQuery(dslQuery);
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
			Campaign.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return campaignPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignModelImpl</code>.
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

		return campaignPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignModelImpl</code>.
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

		return campaignPersistence.findWithDynamicQuery(
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
		return campaignPersistence.countWithDynamicQuery(dynamicQuery);
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

		return campaignPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Campaign fetchCampaign(long campaignId) {
		return campaignPersistence.fetchByPrimaryKey(campaignId);
	}

	/**
	 * Returns the campaign matching the UUID and group.
	 *
	 * @param uuid the campaign's UUID
	 * @param groupId the primary key of the group
	 * @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	@Override
	public Campaign fetchCampaignByUuidAndGroupId(String uuid, long groupId) {
		return campaignPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the campaign with the primary key.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign
	 * @throws PortalException if a campaign with the primary key could not be found
	 */
	@Override
	public Campaign getCampaign(long campaignId) throws PortalException {
		return campaignPersistence.findByPrimaryKey(campaignId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(campaignLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Campaign.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("campaignId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			campaignLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Campaign.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("campaignId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(campaignLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Campaign.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("campaignId");
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

					if (modifiedDateCriterion != null) {
						Conjunction conjunction =
							RestrictionsFactoryUtil.conjunction();

						conjunction.add(modifiedDateCriterion);

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(
							RestrictionsFactoryUtil.gtProperty(
								"modifiedDate", "lastPublishDate"));

						Property lastPublishDateProperty =
							PropertyFactoryUtil.forName("lastPublishDate");

						disjunction.add(lastPublishDateProperty.isNull());

						conjunction.add(disjunction);

						modifiedDateCriterion = conjunction;
					}

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
									Campaign.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setGroupId(
			portletDataContext.getScopeGroupId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Campaign>() {

				@Override
				public void performAction(Campaign campaign)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, campaign);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Campaign.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return campaignPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement CampaignLocalServiceImpl#deleteCampaign(Campaign) to avoid orphaned data");
		}

		return campaignLocalService.deleteCampaign((Campaign)persistedModel);
	}

	@Override
	public BasePersistence<Campaign> getBasePersistence() {
		return campaignPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return campaignPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the campaigns matching the UUID and company.
	 *
	 * @param uuid the UUID of the campaigns
	 * @param companyId the primary key of the company
	 * @return the matching campaigns, or an empty list if no matches were found
	 */
	@Override
	public List<Campaign> getCampaignsByUuidAndCompanyId(
		String uuid, long companyId) {

		return campaignPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of campaigns matching the UUID and company.
	 *
	 * @param uuid the UUID of the campaigns
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching campaigns, or an empty list if no matches were found
	 */
	@Override
	public List<Campaign> getCampaignsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Campaign> orderByComparator) {

		return campaignPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the campaign matching the UUID and group.
	 *
	 * @param uuid the campaign's UUID
	 * @param groupId the primary key of the group
	 * @return the matching campaign
	 * @throws PortalException if a matching campaign could not be found
	 */
	@Override
	public Campaign getCampaignByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return campaignPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of campaigns
	 */
	@Override
	public List<Campaign> getCampaigns(int start, int end) {
		return campaignPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of campaigns.
	 *
	 * @return the number of campaigns
	 */
	@Override
	public int getCampaignsCount() {
		return campaignPersistence.countAll();
	}

	/**
	 * Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaign the campaign
	 * @return the campaign that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Campaign updateCampaign(Campaign campaign) {
		return campaignPersistence.update(campaign);
	}

	/**
	 * Returns the agenda export local service.
	 *
	 * @return the agenda export local service
	 */
	public eu.strasbourg.service.agenda.service.AgendaExportLocalService
		getAgendaExportLocalService() {

		return agendaExportLocalService;
	}

	/**
	 * Sets the agenda export local service.
	 *
	 * @param agendaExportLocalService the agenda export local service
	 */
	public void setAgendaExportLocalService(
		eu.strasbourg.service.agenda.service.AgendaExportLocalService
			agendaExportLocalService) {

		this.agendaExportLocalService = agendaExportLocalService;
	}

	/**
	 * Returns the agenda export persistence.
	 *
	 * @return the agenda export persistence
	 */
	public AgendaExportPersistence getAgendaExportPersistence() {
		return agendaExportPersistence;
	}

	/**
	 * Sets the agenda export persistence.
	 *
	 * @param agendaExportPersistence the agenda export persistence
	 */
	public void setAgendaExportPersistence(
		AgendaExportPersistence agendaExportPersistence) {

		this.agendaExportPersistence = agendaExportPersistence;
	}

	/**
	 * Returns the agenda export period local service.
	 *
	 * @return the agenda export period local service
	 */
	public eu.strasbourg.service.agenda.service.AgendaExportPeriodLocalService
		getAgendaExportPeriodLocalService() {

		return agendaExportPeriodLocalService;
	}

	/**
	 * Sets the agenda export period local service.
	 *
	 * @param agendaExportPeriodLocalService the agenda export period local service
	 */
	public void setAgendaExportPeriodLocalService(
		eu.strasbourg.service.agenda.service.AgendaExportPeriodLocalService
			agendaExportPeriodLocalService) {

		this.agendaExportPeriodLocalService = agendaExportPeriodLocalService;
	}

	/**
	 * Returns the agenda export period persistence.
	 *
	 * @return the agenda export period persistence
	 */
	public AgendaExportPeriodPersistence getAgendaExportPeriodPersistence() {
		return agendaExportPeriodPersistence;
	}

	/**
	 * Sets the agenda export period persistence.
	 *
	 * @param agendaExportPeriodPersistence the agenda export period persistence
	 */
	public void setAgendaExportPeriodPersistence(
		AgendaExportPeriodPersistence agendaExportPeriodPersistence) {

		this.agendaExportPeriodPersistence = agendaExportPeriodPersistence;
	}

	/**
	 * Returns the cache json local service.
	 *
	 * @return the cache json local service
	 */
	public eu.strasbourg.service.agenda.service.CacheJsonLocalService
		getCacheJsonLocalService() {

		return cacheJsonLocalService;
	}

	/**
	 * Sets the cache json local service.
	 *
	 * @param cacheJsonLocalService the cache json local service
	 */
	public void setCacheJsonLocalService(
		eu.strasbourg.service.agenda.service.CacheJsonLocalService
			cacheJsonLocalService) {

		this.cacheJsonLocalService = cacheJsonLocalService;
	}

	/**
	 * Returns the cache json persistence.
	 *
	 * @return the cache json persistence
	 */
	public CacheJsonPersistence getCacheJsonPersistence() {
		return cacheJsonPersistence;
	}

	/**
	 * Sets the cache json persistence.
	 *
	 * @param cacheJsonPersistence the cache json persistence
	 */
	public void setCacheJsonPersistence(
		CacheJsonPersistence cacheJsonPersistence) {

		this.cacheJsonPersistence = cacheJsonPersistence;
	}

	/**
	 * Returns the campaign local service.
	 *
	 * @return the campaign local service
	 */
	public CampaignLocalService getCampaignLocalService() {
		return campaignLocalService;
	}

	/**
	 * Sets the campaign local service.
	 *
	 * @param campaignLocalService the campaign local service
	 */
	public void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		this.campaignLocalService = campaignLocalService;
	}

	/**
	 * Returns the campaign persistence.
	 *
	 * @return the campaign persistence
	 */
	public CampaignPersistence getCampaignPersistence() {
		return campaignPersistence;
	}

	/**
	 * Sets the campaign persistence.
	 *
	 * @param campaignPersistence the campaign persistence
	 */
	public void setCampaignPersistence(
		CampaignPersistence campaignPersistence) {

		this.campaignPersistence = campaignPersistence;
	}

	/**
	 * Returns the campaign event local service.
	 *
	 * @return the campaign event local service
	 */
	public eu.strasbourg.service.agenda.service.CampaignEventLocalService
		getCampaignEventLocalService() {

		return campaignEventLocalService;
	}

	/**
	 * Sets the campaign event local service.
	 *
	 * @param campaignEventLocalService the campaign event local service
	 */
	public void setCampaignEventLocalService(
		eu.strasbourg.service.agenda.service.CampaignEventLocalService
			campaignEventLocalService) {

		this.campaignEventLocalService = campaignEventLocalService;
	}

	/**
	 * Returns the campaign event persistence.
	 *
	 * @return the campaign event persistence
	 */
	public CampaignEventPersistence getCampaignEventPersistence() {
		return campaignEventPersistence;
	}

	/**
	 * Sets the campaign event persistence.
	 *
	 * @param campaignEventPersistence the campaign event persistence
	 */
	public void setCampaignEventPersistence(
		CampaignEventPersistence campaignEventPersistence) {

		this.campaignEventPersistence = campaignEventPersistence;
	}

	/**
	 * Returns the campaign event finder.
	 *
	 * @return the campaign event finder
	 */
	public CampaignEventFinder getCampaignEventFinder() {
		return campaignEventFinder;
	}

	/**
	 * Sets the campaign event finder.
	 *
	 * @param campaignEventFinder the campaign event finder
	 */
	public void setCampaignEventFinder(
		CampaignEventFinder campaignEventFinder) {

		this.campaignEventFinder = campaignEventFinder;
	}

	/**
	 * Returns the campaign event status local service.
	 *
	 * @return the campaign event status local service
	 */
	public eu.strasbourg.service.agenda.service.CampaignEventStatusLocalService
		getCampaignEventStatusLocalService() {

		return campaignEventStatusLocalService;
	}

	/**
	 * Sets the campaign event status local service.
	 *
	 * @param campaignEventStatusLocalService the campaign event status local service
	 */
	public void setCampaignEventStatusLocalService(
		eu.strasbourg.service.agenda.service.CampaignEventStatusLocalService
			campaignEventStatusLocalService) {

		this.campaignEventStatusLocalService = campaignEventStatusLocalService;
	}

	/**
	 * Returns the campaign event status persistence.
	 *
	 * @return the campaign event status persistence
	 */
	public CampaignEventStatusPersistence getCampaignEventStatusPersistence() {
		return campaignEventStatusPersistence;
	}

	/**
	 * Sets the campaign event status persistence.
	 *
	 * @param campaignEventStatusPersistence the campaign event status persistence
	 */
	public void setCampaignEventStatusPersistence(
		CampaignEventStatusPersistence campaignEventStatusPersistence) {

		this.campaignEventStatusPersistence = campaignEventStatusPersistence;
	}

	/**
	 * Returns the csmap cache json local service.
	 *
	 * @return the csmap cache json local service
	 */
	public eu.strasbourg.service.agenda.service.CsmapCacheJsonLocalService
		getCsmapCacheJsonLocalService() {

		return csmapCacheJsonLocalService;
	}

	/**
	 * Sets the csmap cache json local service.
	 *
	 * @param csmapCacheJsonLocalService the csmap cache json local service
	 */
	public void setCsmapCacheJsonLocalService(
		eu.strasbourg.service.agenda.service.CsmapCacheJsonLocalService
			csmapCacheJsonLocalService) {

		this.csmapCacheJsonLocalService = csmapCacheJsonLocalService;
	}

	/**
	 * Returns the csmap cache json persistence.
	 *
	 * @return the csmap cache json persistence
	 */
	public CsmapCacheJsonPersistence getCsmapCacheJsonPersistence() {
		return csmapCacheJsonPersistence;
	}

	/**
	 * Sets the csmap cache json persistence.
	 *
	 * @param csmapCacheJsonPersistence the csmap cache json persistence
	 */
	public void setCsmapCacheJsonPersistence(
		CsmapCacheJsonPersistence csmapCacheJsonPersistence) {

		this.csmapCacheJsonPersistence = csmapCacheJsonPersistence;
	}

	/**
	 * Returns the event local service.
	 *
	 * @return the event local service
	 */
	public eu.strasbourg.service.agenda.service.EventLocalService
		getEventLocalService() {

		return eventLocalService;
	}

	/**
	 * Sets the event local service.
	 *
	 * @param eventLocalService the event local service
	 */
	public void setEventLocalService(
		eu.strasbourg.service.agenda.service.EventLocalService
			eventLocalService) {

		this.eventLocalService = eventLocalService;
	}

	/**
	 * Returns the event persistence.
	 *
	 * @return the event persistence
	 */
	public EventPersistence getEventPersistence() {
		return eventPersistence;
	}

	/**
	 * Sets the event persistence.
	 *
	 * @param eventPersistence the event persistence
	 */
	public void setEventPersistence(EventPersistence eventPersistence) {
		this.eventPersistence = eventPersistence;
	}

	/**
	 * Returns the event finder.
	 *
	 * @return the event finder
	 */
	public EventFinder getEventFinder() {
		return eventFinder;
	}

	/**
	 * Sets the event finder.
	 *
	 * @param eventFinder the event finder
	 */
	public void setEventFinder(EventFinder eventFinder) {
		this.eventFinder = eventFinder;
	}

	/**
	 * Returns the event participation local service.
	 *
	 * @return the event participation local service
	 */
	public eu.strasbourg.service.agenda.service.EventParticipationLocalService
		getEventParticipationLocalService() {

		return eventParticipationLocalService;
	}

	/**
	 * Sets the event participation local service.
	 *
	 * @param eventParticipationLocalService the event participation local service
	 */
	public void setEventParticipationLocalService(
		eu.strasbourg.service.agenda.service.EventParticipationLocalService
			eventParticipationLocalService) {

		this.eventParticipationLocalService = eventParticipationLocalService;
	}

	/**
	 * Returns the event participation persistence.
	 *
	 * @return the event participation persistence
	 */
	public EventParticipationPersistence getEventParticipationPersistence() {
		return eventParticipationPersistence;
	}

	/**
	 * Sets the event participation persistence.
	 *
	 * @param eventParticipationPersistence the event participation persistence
	 */
	public void setEventParticipationPersistence(
		EventParticipationPersistence eventParticipationPersistence) {

		this.eventParticipationPersistence = eventParticipationPersistence;
	}

	/**
	 * Returns the event period local service.
	 *
	 * @return the event period local service
	 */
	public eu.strasbourg.service.agenda.service.EventPeriodLocalService
		getEventPeriodLocalService() {

		return eventPeriodLocalService;
	}

	/**
	 * Sets the event period local service.
	 *
	 * @param eventPeriodLocalService the event period local service
	 */
	public void setEventPeriodLocalService(
		eu.strasbourg.service.agenda.service.EventPeriodLocalService
			eventPeriodLocalService) {

		this.eventPeriodLocalService = eventPeriodLocalService;
	}

	/**
	 * Returns the event period persistence.
	 *
	 * @return the event period persistence
	 */
	public EventPeriodPersistence getEventPeriodPersistence() {
		return eventPeriodPersistence;
	}

	/**
	 * Sets the event period persistence.
	 *
	 * @param eventPeriodPersistence the event period persistence
	 */
	public void setEventPeriodPersistence(
		EventPeriodPersistence eventPeriodPersistence) {

		this.eventPeriodPersistence = eventPeriodPersistence;
	}

	/**
	 * Returns the historic local service.
	 *
	 * @return the historic local service
	 */
	public eu.strasbourg.service.agenda.service.HistoricLocalService
		getHistoricLocalService() {

		return historicLocalService;
	}

	/**
	 * Sets the historic local service.
	 *
	 * @param historicLocalService the historic local service
	 */
	public void setHistoricLocalService(
		eu.strasbourg.service.agenda.service.HistoricLocalService
			historicLocalService) {

		this.historicLocalService = historicLocalService;
	}

	/**
	 * Returns the historic persistence.
	 *
	 * @return the historic persistence
	 */
	public HistoricPersistence getHistoricPersistence() {
		return historicPersistence;
	}

	/**
	 * Sets the historic persistence.
	 *
	 * @param historicPersistence the historic persistence
	 */
	public void setHistoricPersistence(
		HistoricPersistence historicPersistence) {

		this.historicPersistence = historicPersistence;
	}

	/**
	 * Returns the import report local service.
	 *
	 * @return the import report local service
	 */
	public eu.strasbourg.service.agenda.service.ImportReportLocalService
		getImportReportLocalService() {

		return importReportLocalService;
	}

	/**
	 * Sets the import report local service.
	 *
	 * @param importReportLocalService the import report local service
	 */
	public void setImportReportLocalService(
		eu.strasbourg.service.agenda.service.ImportReportLocalService
			importReportLocalService) {

		this.importReportLocalService = importReportLocalService;
	}

	/**
	 * Returns the import report persistence.
	 *
	 * @return the import report persistence
	 */
	public ImportReportPersistence getImportReportPersistence() {
		return importReportPersistence;
	}

	/**
	 * Sets the import report persistence.
	 *
	 * @param importReportPersistence the import report persistence
	 */
	public void setImportReportPersistence(
		ImportReportPersistence importReportPersistence) {

		this.importReportPersistence = importReportPersistence;
	}

	/**
	 * Returns the import report line local service.
	 *
	 * @return the import report line local service
	 */
	public eu.strasbourg.service.agenda.service.ImportReportLineLocalService
		getImportReportLineLocalService() {

		return importReportLineLocalService;
	}

	/**
	 * Sets the import report line local service.
	 *
	 * @param importReportLineLocalService the import report line local service
	 */
	public void setImportReportLineLocalService(
		eu.strasbourg.service.agenda.service.ImportReportLineLocalService
			importReportLineLocalService) {

		this.importReportLineLocalService = importReportLineLocalService;
	}

	/**
	 * Returns the import report line persistence.
	 *
	 * @return the import report line persistence
	 */
	public ImportReportLinePersistence getImportReportLinePersistence() {
		return importReportLinePersistence;
	}

	/**
	 * Sets the import report line persistence.
	 *
	 * @param importReportLinePersistence the import report line persistence
	 */
	public void setImportReportLinePersistence(
		ImportReportLinePersistence importReportLinePersistence) {

		this.importReportLinePersistence = importReportLinePersistence;
	}

	/**
	 * Returns the manifestation local service.
	 *
	 * @return the manifestation local service
	 */
	public eu.strasbourg.service.agenda.service.ManifestationLocalService
		getManifestationLocalService() {

		return manifestationLocalService;
	}

	/**
	 * Sets the manifestation local service.
	 *
	 * @param manifestationLocalService the manifestation local service
	 */
	public void setManifestationLocalService(
		eu.strasbourg.service.agenda.service.ManifestationLocalService
			manifestationLocalService) {

		this.manifestationLocalService = manifestationLocalService;
	}

	/**
	 * Returns the manifestation persistence.
	 *
	 * @return the manifestation persistence
	 */
	public ManifestationPersistence getManifestationPersistence() {
		return manifestationPersistence;
	}

	/**
	 * Sets the manifestation persistence.
	 *
	 * @param manifestationPersistence the manifestation persistence
	 */
	public void setManifestationPersistence(
		ManifestationPersistence manifestationPersistence) {

		this.manifestationPersistence = manifestationPersistence;
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
	public com.liferay.asset.kernel.service.AssetLinkLocalService
		getAssetLinkLocalService() {

		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.kernel.service.AssetLinkLocalService
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
			"eu.strasbourg.service.agenda.model.Campaign",
			campaignLocalService);

		_setLocalServiceUtilService(campaignLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.agenda.model.Campaign");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CampaignLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Campaign.class;
	}

	protected String getModelClassName() {
		return Campaign.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = campaignPersistence.getDataSource();

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
		CampaignLocalService campaignLocalService) {

		try {
			Field field = CampaignLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, campaignLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.AgendaExportLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.AgendaExportLocalService
		agendaExportLocalService;

	@BeanReference(type = AgendaExportPersistence.class)
	protected AgendaExportPersistence agendaExportPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.AgendaExportPeriodLocalService.class
	)
	protected
		eu.strasbourg.service.agenda.service.AgendaExportPeriodLocalService
			agendaExportPeriodLocalService;

	@BeanReference(type = AgendaExportPeriodPersistence.class)
	protected AgendaExportPeriodPersistence agendaExportPeriodPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.CacheJsonLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.CacheJsonLocalService
		cacheJsonLocalService;

	@BeanReference(type = CacheJsonPersistence.class)
	protected CacheJsonPersistence cacheJsonPersistence;

	@BeanReference(type = CampaignLocalService.class)
	protected CampaignLocalService campaignLocalService;

	@BeanReference(type = CampaignPersistence.class)
	protected CampaignPersistence campaignPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.CampaignEventLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.CampaignEventLocalService
		campaignEventLocalService;

	@BeanReference(type = CampaignEventPersistence.class)
	protected CampaignEventPersistence campaignEventPersistence;

	@BeanReference(type = CampaignEventFinder.class)
	protected CampaignEventFinder campaignEventFinder;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.CampaignEventStatusLocalService.class
	)
	protected
		eu.strasbourg.service.agenda.service.CampaignEventStatusLocalService
			campaignEventStatusLocalService;

	@BeanReference(type = CampaignEventStatusPersistence.class)
	protected CampaignEventStatusPersistence campaignEventStatusPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.CsmapCacheJsonLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.CsmapCacheJsonLocalService
		csmapCacheJsonLocalService;

	@BeanReference(type = CsmapCacheJsonPersistence.class)
	protected CsmapCacheJsonPersistence csmapCacheJsonPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.EventLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.EventLocalService
		eventLocalService;

	@BeanReference(type = EventPersistence.class)
	protected EventPersistence eventPersistence;

	@BeanReference(type = EventFinder.class)
	protected EventFinder eventFinder;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.EventParticipationLocalService.class
	)
	protected
		eu.strasbourg.service.agenda.service.EventParticipationLocalService
			eventParticipationLocalService;

	@BeanReference(type = EventParticipationPersistence.class)
	protected EventParticipationPersistence eventParticipationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.EventPeriodLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.EventPeriodLocalService
		eventPeriodLocalService;

	@BeanReference(type = EventPeriodPersistence.class)
	protected EventPeriodPersistence eventPeriodPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.HistoricLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.HistoricLocalService
		historicLocalService;

	@BeanReference(type = HistoricPersistence.class)
	protected HistoricPersistence historicPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.ImportReportLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.ImportReportLocalService
		importReportLocalService;

	@BeanReference(type = ImportReportPersistence.class)
	protected ImportReportPersistence importReportPersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.ImportReportLineLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.ImportReportLineLocalService
		importReportLineLocalService;

	@BeanReference(type = ImportReportLinePersistence.class)
	protected ImportReportLinePersistence importReportLinePersistence;

	@BeanReference(
		type = eu.strasbourg.service.agenda.service.ManifestationLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.ManifestationLocalService
		manifestationLocalService;

	@BeanReference(type = ManifestationPersistence.class)
	protected ManifestationPersistence manifestationPersistence;

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
		type = com.liferay.asset.kernel.service.AssetLinkLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
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
		CampaignLocalServiceBaseImpl.class);

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}