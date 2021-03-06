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

package eu.strasbourg.service.artwork.service.base;

import aQute.bnd.annotation.ProviderType;

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
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.artwork.model.ArtworkCollection;
import eu.strasbourg.service.artwork.service.ArtworkCollectionLocalService;
import eu.strasbourg.service.artwork.service.persistence.ArtworkCollectionPersistence;
import eu.strasbourg.service.artwork.service.persistence.ArtworkPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the artwork collection local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.artwork.service.impl.ArtworkCollectionLocalServiceImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see eu.strasbourg.service.artwork.service.impl.ArtworkCollectionLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class ArtworkCollectionLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements ArtworkCollectionLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ArtworkCollectionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>eu.strasbourg.service.artwork.service.ArtworkCollectionLocalServiceUtil</code>.
	 */

	/**
	 * Adds the artwork collection to the database. Also notifies the appropriate model listeners.
	 *
	 * @param artworkCollection the artwork collection
	 * @return the artwork collection that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ArtworkCollection addArtworkCollection(
		ArtworkCollection artworkCollection) {

		artworkCollection.setNew(true);

		return artworkCollectionPersistence.update(artworkCollection);
	}

	/**
	 * Creates a new artwork collection with the primary key. Does not add the artwork collection to the database.
	 *
	 * @param collectionId the primary key for the new artwork collection
	 * @return the new artwork collection
	 */
	@Override
	@Transactional(enabled = false)
	public ArtworkCollection createArtworkCollection(long collectionId) {
		return artworkCollectionPersistence.create(collectionId);
	}

	/**
	 * Deletes the artwork collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param collectionId the primary key of the artwork collection
	 * @return the artwork collection that was removed
	 * @throws PortalException if a artwork collection with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ArtworkCollection deleteArtworkCollection(long collectionId)
		throws PortalException {

		return artworkCollectionPersistence.remove(collectionId);
	}

	/**
	 * Deletes the artwork collection from the database. Also notifies the appropriate model listeners.
	 *
	 * @param artworkCollection the artwork collection
	 * @return the artwork collection that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ArtworkCollection deleteArtworkCollection(
		ArtworkCollection artworkCollection) {

		return artworkCollectionPersistence.remove(artworkCollection);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ArtworkCollection.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return artworkCollectionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.artwork.model.impl.ArtworkCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return artworkCollectionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.artwork.model.impl.ArtworkCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return artworkCollectionPersistence.findWithDynamicQuery(
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
		return artworkCollectionPersistence.countWithDynamicQuery(dynamicQuery);
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

		return artworkCollectionPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ArtworkCollection fetchArtworkCollection(long collectionId) {
		return artworkCollectionPersistence.fetchByPrimaryKey(collectionId);
	}

	/**
	 * Returns the artwork collection matching the UUID and group.
	 *
	 * @param uuid the artwork collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching artwork collection, or <code>null</code> if a matching artwork collection could not be found
	 */
	@Override
	public ArtworkCollection fetchArtworkCollectionByUuidAndGroupId(
		String uuid, long groupId) {

		return artworkCollectionPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the artwork collection with the primary key.
	 *
	 * @param collectionId the primary key of the artwork collection
	 * @return the artwork collection
	 * @throws PortalException if a artwork collection with the primary key could not be found
	 */
	@Override
	public ArtworkCollection getArtworkCollection(long collectionId)
		throws PortalException {

		return artworkCollectionPersistence.findByPrimaryKey(collectionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			artworkCollectionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ArtworkCollection.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("collectionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			artworkCollectionLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ArtworkCollection.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"collectionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			artworkCollectionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ArtworkCollection.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("collectionId");
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
									ArtworkCollection.class.getName());

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
			new ActionableDynamicQuery.PerformActionMethod
				<ArtworkCollection>() {

				@Override
				public void performAction(ArtworkCollection artworkCollection)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, artworkCollection);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ArtworkCollection.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return artworkCollectionLocalService.deleteArtworkCollection(
			(ArtworkCollection)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return artworkCollectionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the artwork collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the artwork collections
	 * @param companyId the primary key of the company
	 * @return the matching artwork collections, or an empty list if no matches were found
	 */
	@Override
	public List<ArtworkCollection> getArtworkCollectionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return artworkCollectionPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of artwork collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the artwork collections
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of artwork collections
	 * @param end the upper bound of the range of artwork collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching artwork collections, or an empty list if no matches were found
	 */
	@Override
	public List<ArtworkCollection> getArtworkCollectionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ArtworkCollection> orderByComparator) {

		return artworkCollectionPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the artwork collection matching the UUID and group.
	 *
	 * @param uuid the artwork collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching artwork collection
	 * @throws PortalException if a matching artwork collection could not be found
	 */
	@Override
	public ArtworkCollection getArtworkCollectionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return artworkCollectionPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the artwork collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.artwork.model.impl.ArtworkCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of artwork collections
	 * @param end the upper bound of the range of artwork collections (not inclusive)
	 * @return the range of artwork collections
	 */
	@Override
	public List<ArtworkCollection> getArtworkCollections(int start, int end) {
		return artworkCollectionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of artwork collections.
	 *
	 * @return the number of artwork collections
	 */
	@Override
	public int getArtworkCollectionsCount() {
		return artworkCollectionPersistence.countAll();
	}

	/**
	 * Updates the artwork collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param artworkCollection the artwork collection
	 * @return the artwork collection that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ArtworkCollection updateArtworkCollection(
		ArtworkCollection artworkCollection) {

		return artworkCollectionPersistence.update(artworkCollection);
	}

	/**
	 */
	@Override
	public void addArtworkArtworkCollection(long artworkId, long collectionId) {
		artworkPersistence.addArtworkCollection(artworkId, collectionId);
	}

	/**
	 */
	@Override
	public void addArtworkArtworkCollection(
		long artworkId, ArtworkCollection artworkCollection) {

		artworkPersistence.addArtworkCollection(artworkId, artworkCollection);
	}

	/**
	 */
	@Override
	public void addArtworkArtworkCollections(
		long artworkId, long[] collectionIds) {

		artworkPersistence.addArtworkCollections(artworkId, collectionIds);
	}

	/**
	 */
	@Override
	public void addArtworkArtworkCollections(
		long artworkId, List<ArtworkCollection> artworkCollections) {

		artworkPersistence.addArtworkCollections(artworkId, artworkCollections);
	}

	/**
	 */
	@Override
	public void clearArtworkArtworkCollections(long artworkId) {
		artworkPersistence.clearArtworkCollections(artworkId);
	}

	/**
	 */
	@Override
	public void deleteArtworkArtworkCollection(
		long artworkId, long collectionId) {

		artworkPersistence.removeArtworkCollection(artworkId, collectionId);
	}

	/**
	 */
	@Override
	public void deleteArtworkArtworkCollection(
		long artworkId, ArtworkCollection artworkCollection) {

		artworkPersistence.removeArtworkCollection(
			artworkId, artworkCollection);
	}

	/**
	 */
	@Override
	public void deleteArtworkArtworkCollections(
		long artworkId, long[] collectionIds) {

		artworkPersistence.removeArtworkCollections(artworkId, collectionIds);
	}

	/**
	 */
	@Override
	public void deleteArtworkArtworkCollections(
		long artworkId, List<ArtworkCollection> artworkCollections) {

		artworkPersistence.removeArtworkCollections(
			artworkId, artworkCollections);
	}

	/**
	 * Returns the artworkIds of the artworks associated with the artwork collection.
	 *
	 * @param collectionId the collectionId of the artwork collection
	 * @return long[] the artworkIds of artworks associated with the artwork collection
	 */
	@Override
	public long[] getArtworkPrimaryKeys(long collectionId) {
		return artworkCollectionPersistence.getArtworkPrimaryKeys(collectionId);
	}

	/**
	 */
	@Override
	public List<ArtworkCollection> getArtworkArtworkCollections(
		long artworkId) {

		return artworkPersistence.getArtworkCollections(artworkId);
	}

	/**
	 */
	@Override
	public List<ArtworkCollection> getArtworkArtworkCollections(
		long artworkId, int start, int end) {

		return artworkPersistence.getArtworkCollections(artworkId, start, end);
	}

	/**
	 */
	@Override
	public List<ArtworkCollection> getArtworkArtworkCollections(
		long artworkId, int start, int end,
		OrderByComparator<ArtworkCollection> orderByComparator) {

		return artworkPersistence.getArtworkCollections(
			artworkId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getArtworkArtworkCollectionsCount(long artworkId) {
		return artworkPersistence.getArtworkCollectionsSize(artworkId);
	}

	/**
	 */
	@Override
	public boolean hasArtworkArtworkCollection(
		long artworkId, long collectionId) {

		return artworkPersistence.containsArtworkCollection(
			artworkId, collectionId);
	}

	/**
	 */
	@Override
	public boolean hasArtworkArtworkCollections(long artworkId) {
		return artworkPersistence.containsArtworkCollections(artworkId);
	}

	/**
	 */
	@Override
	public void setArtworkArtworkCollections(
		long artworkId, long[] collectionIds) {

		artworkPersistence.setArtworkCollections(artworkId, collectionIds);
	}

	/**
	 * Returns the artwork local service.
	 *
	 * @return the artwork local service
	 */
	public eu.strasbourg.service.artwork.service.ArtworkLocalService
		getArtworkLocalService() {

		return artworkLocalService;
	}

	/**
	 * Sets the artwork local service.
	 *
	 * @param artworkLocalService the artwork local service
	 */
	public void setArtworkLocalService(
		eu.strasbourg.service.artwork.service.ArtworkLocalService
			artworkLocalService) {

		this.artworkLocalService = artworkLocalService;
	}

	/**
	 * Returns the artwork persistence.
	 *
	 * @return the artwork persistence
	 */
	public ArtworkPersistence getArtworkPersistence() {
		return artworkPersistence;
	}

	/**
	 * Sets the artwork persistence.
	 *
	 * @param artworkPersistence the artwork persistence
	 */
	public void setArtworkPersistence(ArtworkPersistence artworkPersistence) {
		this.artworkPersistence = artworkPersistence;
	}

	/**
	 * Returns the artwork collection local service.
	 *
	 * @return the artwork collection local service
	 */
	public ArtworkCollectionLocalService getArtworkCollectionLocalService() {
		return artworkCollectionLocalService;
	}

	/**
	 * Sets the artwork collection local service.
	 *
	 * @param artworkCollectionLocalService the artwork collection local service
	 */
	public void setArtworkCollectionLocalService(
		ArtworkCollectionLocalService artworkCollectionLocalService) {

		this.artworkCollectionLocalService = artworkCollectionLocalService;
	}

	/**
	 * Returns the artwork collection persistence.
	 *
	 * @return the artwork collection persistence
	 */
	public ArtworkCollectionPersistence getArtworkCollectionPersistence() {
		return artworkCollectionPersistence;
	}

	/**
	 * Sets the artwork collection persistence.
	 *
	 * @param artworkCollectionPersistence the artwork collection persistence
	 */
	public void setArtworkCollectionPersistence(
		ArtworkCollectionPersistence artworkCollectionPersistence) {

		this.artworkCollectionPersistence = artworkCollectionPersistence;
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
			"eu.strasbourg.service.artwork.model.ArtworkCollection",
			artworkCollectionLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.artwork.model.ArtworkCollection");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ArtworkCollectionLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ArtworkCollection.class;
	}

	protected String getModelClassName() {
		return ArtworkCollection.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				artworkCollectionPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.artwork.service.ArtworkLocalService.class
	)
	protected eu.strasbourg.service.artwork.service.ArtworkLocalService
		artworkLocalService;

	@BeanReference(type = ArtworkPersistence.class)
	protected ArtworkPersistence artworkPersistence;

	@BeanReference(type = ArtworkCollectionLocalService.class)
	protected ArtworkCollectionLocalService artworkCollectionLocalService;

	@BeanReference(type = ArtworkCollectionPersistence.class)
	protected ArtworkCollectionPersistence artworkCollectionPersistence;

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

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}