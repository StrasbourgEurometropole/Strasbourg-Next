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

package eu.strasbourg.service.formSendRecordField.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
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
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordField;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldLocalService;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldLocalServiceUtil;
import eu.strasbourg.service.formSendRecordField.service.persistence.FormSendRecordFieldPersistence;
import eu.strasbourg.service.formSendRecordField.service.persistence.FormSendRecordFieldSignalementPersistence;

import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Provides the base implementation for the form send record field local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.formSendRecordField.service.impl.FormSendRecordFieldLocalServiceImpl}.
 * </p>
 *
 * @author Angélique Zunino
 * @see eu.strasbourg.service.formSendRecordField.service.impl.FormSendRecordFieldLocalServiceImpl
 * @generated
 */
public abstract class FormSendRecordFieldLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements FormSendRecordFieldLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>FormSendRecordFieldLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>FormSendRecordFieldLocalServiceUtil</code>.
	 */

	/**
	 * Adds the form send record field to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordField the form send record field
	 * @return the form send record field that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FormSendRecordField addFormSendRecordField(
		FormSendRecordField formSendRecordField) {

		formSendRecordField.setNew(true);

		return formSendRecordFieldPersistence.update(formSendRecordField);
	}

	/**
	 * Creates a new form send record field with the primary key. Does not add the form send record field to the database.
	 *
	 * @param formSendRecordFieldId the primary key for the new form send record field
	 * @return the new form send record field
	 */
	@Override
	@Transactional(enabled = false)
	public FormSendRecordField createFormSendRecordField(
		long formSendRecordFieldId) {

		return formSendRecordFieldPersistence.create(formSendRecordFieldId);
	}

	/**
	 * Deletes the form send record field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordFieldId the primary key of the form send record field
	 * @return the form send record field that was removed
	 * @throws PortalException if a form send record field with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FormSendRecordField deleteFormSendRecordField(
			long formSendRecordFieldId)
		throws PortalException {

		return formSendRecordFieldPersistence.remove(formSendRecordFieldId);
	}

	/**
	 * Deletes the form send record field from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordField the form send record field
	 * @return the form send record field that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FormSendRecordField deleteFormSendRecordField(
		FormSendRecordField formSendRecordField) {

		return formSendRecordFieldPersistence.remove(formSendRecordField);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return formSendRecordFieldPersistence.dslQuery(dslQuery);
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
			FormSendRecordField.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return formSendRecordFieldPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl</code>.
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

		return formSendRecordFieldPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl</code>.
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

		return formSendRecordFieldPersistence.findWithDynamicQuery(
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
		return formSendRecordFieldPersistence.countWithDynamicQuery(
			dynamicQuery);
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

		return formSendRecordFieldPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public FormSendRecordField fetchFormSendRecordField(
		long formSendRecordFieldId) {

		return formSendRecordFieldPersistence.fetchByPrimaryKey(
			formSendRecordFieldId);
	}

	/**
	 * Returns the form send record field matching the UUID and group.
	 *
	 * @param uuid the form send record field's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchFormSendRecordFieldByUuidAndGroupId(
		String uuid, long groupId) {

		return formSendRecordFieldPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the form send record field with the primary key.
	 *
	 * @param formSendRecordFieldId the primary key of the form send record field
	 * @return the form send record field
	 * @throws PortalException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField getFormSendRecordField(
			long formSendRecordFieldId)
		throws PortalException {

		return formSendRecordFieldPersistence.findByPrimaryKey(
			formSendRecordFieldId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			formSendRecordFieldLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(FormSendRecordField.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"formSendRecordFieldId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			formSendRecordFieldLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			FormSendRecordField.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"formSendRecordFieldId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			formSendRecordFieldLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(FormSendRecordField.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"formSendRecordFieldId");
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
									FormSendRecordField.class.getName());

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
			new ActionableDynamicQuery.PerformActionMethod
				<FormSendRecordField>() {

				@Override
				public void performAction(
						FormSendRecordField formSendRecordField)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, formSendRecordField);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					FormSendRecordField.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return formSendRecordFieldPersistence.create(
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
				"Implement FormSendRecordFieldLocalServiceImpl#deleteFormSendRecordField(FormSendRecordField) to avoid orphaned data");
		}

		return formSendRecordFieldLocalService.deleteFormSendRecordField(
			(FormSendRecordField)persistedModel);
	}

	@Override
	public BasePersistence<FormSendRecordField> getBasePersistence() {
		return formSendRecordFieldPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return formSendRecordFieldPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the form send record fields matching the UUID and company.
	 *
	 * @param uuid the UUID of the form send record fields
	 * @param companyId the primary key of the company
	 * @return the matching form send record fields, or an empty list if no matches were found
	 */
	@Override
	public List<FormSendRecordField> getFormSendRecordFieldsByUuidAndCompanyId(
		String uuid, long companyId) {

		return formSendRecordFieldPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of form send record fields matching the UUID and company.
	 *
	 * @param uuid the UUID of the form send record fields
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching form send record fields, or an empty list if no matches were found
	 */
	@Override
	public List<FormSendRecordField> getFormSendRecordFieldsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		return formSendRecordFieldPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the form send record field matching the UUID and group.
	 *
	 * @param uuid the form send record field's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form send record field
	 * @throws PortalException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField getFormSendRecordFieldByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return formSendRecordFieldPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the form send record fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of form send record fields
	 */
	@Override
	public List<FormSendRecordField> getFormSendRecordFields(
		int start, int end) {

		return formSendRecordFieldPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of form send record fields.
	 *
	 * @return the number of form send record fields
	 */
	@Override
	public int getFormSendRecordFieldsCount() {
		return formSendRecordFieldPersistence.countAll();
	}

	/**
	 * Updates the form send record field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormSendRecordFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formSendRecordField the form send record field
	 * @return the form send record field that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FormSendRecordField updateFormSendRecordField(
		FormSendRecordField formSendRecordField) {

		return formSendRecordFieldPersistence.update(formSendRecordField);
	}

	/**
	 * Returns the form send record field local service.
	 *
	 * @return the form send record field local service
	 */
	public FormSendRecordFieldLocalService
		getFormSendRecordFieldLocalService() {

		return formSendRecordFieldLocalService;
	}

	/**
	 * Sets the form send record field local service.
	 *
	 * @param formSendRecordFieldLocalService the form send record field local service
	 */
	public void setFormSendRecordFieldLocalService(
		FormSendRecordFieldLocalService formSendRecordFieldLocalService) {

		this.formSendRecordFieldLocalService = formSendRecordFieldLocalService;
	}

	/**
	 * Returns the form send record field persistence.
	 *
	 * @return the form send record field persistence
	 */
	public FormSendRecordFieldPersistence getFormSendRecordFieldPersistence() {
		return formSendRecordFieldPersistence;
	}

	/**
	 * Sets the form send record field persistence.
	 *
	 * @param formSendRecordFieldPersistence the form send record field persistence
	 */
	public void setFormSendRecordFieldPersistence(
		FormSendRecordFieldPersistence formSendRecordFieldPersistence) {

		this.formSendRecordFieldPersistence = formSendRecordFieldPersistence;
	}

	/**
	 * Returns the form send record field signalement local service.
	 *
	 * @return the form send record field signalement local service
	 */
	public eu.strasbourg.service.formSendRecordField.service.
		FormSendRecordFieldSignalementLocalService
			getFormSendRecordFieldSignalementLocalService() {

		return formSendRecordFieldSignalementLocalService;
	}

	/**
	 * Sets the form send record field signalement local service.
	 *
	 * @param formSendRecordFieldSignalementLocalService the form send record field signalement local service
	 */
	public void setFormSendRecordFieldSignalementLocalService(
		eu.strasbourg.service.formSendRecordField.service.
			FormSendRecordFieldSignalementLocalService
				formSendRecordFieldSignalementLocalService) {

		this.formSendRecordFieldSignalementLocalService =
			formSendRecordFieldSignalementLocalService;
	}

	/**
	 * Returns the form send record field signalement persistence.
	 *
	 * @return the form send record field signalement persistence
	 */
	public FormSendRecordFieldSignalementPersistence
		getFormSendRecordFieldSignalementPersistence() {

		return formSendRecordFieldSignalementPersistence;
	}

	/**
	 * Sets the form send record field signalement persistence.
	 *
	 * @param formSendRecordFieldSignalementPersistence the form send record field signalement persistence
	 */
	public void setFormSendRecordFieldSignalementPersistence(
		FormSendRecordFieldSignalementPersistence
			formSendRecordFieldSignalementPersistence) {

		this.formSendRecordFieldSignalementPersistence =
			formSendRecordFieldSignalementPersistence;
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

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"eu.strasbourg.service.formSendRecordField.model.FormSendRecordField",
			formSendRecordFieldLocalService);

		_setLocalServiceUtilService(formSendRecordFieldLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.formSendRecordField.model.FormSendRecordField");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return FormSendRecordFieldLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return FormSendRecordField.class;
	}

	protected String getModelClassName() {
		return FormSendRecordField.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				formSendRecordFieldPersistence.getDataSource();

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
		FormSendRecordFieldLocalService formSendRecordFieldLocalService) {

		try {
			Field field =
				FormSendRecordFieldLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, formSendRecordFieldLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(type = FormSendRecordFieldLocalService.class)
	protected FormSendRecordFieldLocalService formSendRecordFieldLocalService;

	@BeanReference(type = FormSendRecordFieldPersistence.class)
	protected FormSendRecordFieldPersistence formSendRecordFieldPersistence;

	@BeanReference(
		type = eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldSignalementLocalService.class
	)
	protected eu.strasbourg.service.formSendRecordField.service.
		FormSendRecordFieldSignalementLocalService
			formSendRecordFieldSignalementLocalService;

	@BeanReference(type = FormSendRecordFieldSignalementPersistence.class)
	protected FormSendRecordFieldSignalementPersistence
		formSendRecordFieldSignalementPersistence;

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

	private static final Log _log = LogFactoryUtil.getLog(
		FormSendRecordFieldLocalServiceBaseImpl.class);

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}