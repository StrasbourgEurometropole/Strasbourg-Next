/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.asset.kernel.model.AssetVocabulary;
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
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.activity.model.ActivityCourseSchedule;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ActivityCourseSchedule. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseScheduleLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.activity.model.ActivityCourseSchedule"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ActivityCourseScheduleLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.activity.service.impl.ActivityCourseScheduleLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the activity course schedule local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ActivityCourseScheduleLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the activity course schedule to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ActivityCourseSchedule addActivityCourseSchedule(
		ActivityCourseSchedule activityCourseSchedule);

	/**
	 * Creates a new activity course schedule with the primary key. Does not add the activity course schedule to the database.
	 *
	 * @param activityCourseScheduleId the primary key for the new activity course schedule
	 * @return the new activity course schedule
	 */
	@Transactional(enabled = false)
	public ActivityCourseSchedule createActivityCourseSchedule(
		long activityCourseScheduleId);

	/**
	 * Crée une activité vide avec une PK, non ajouté à la base de donnée
	 */
	public ActivityCourseSchedule createActivityCourseSchedule(
			ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the activity course schedule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ActivityCourseSchedule deleteActivityCourseSchedule(
		ActivityCourseSchedule activityCourseSchedule);

	/**
	 * Deletes the activity course schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule that was removed
	 * @throws PortalException if a activity course schedule with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ActivityCourseSchedule deleteActivityCourseSchedule(
			long activityCourseScheduleId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
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
	public ActivityCourseSchedule fetchActivityCourseSchedule(
		long activityCourseScheduleId);

	/**
	 * Returns the activity course schedule matching the UUID and group.
	 *
	 * @param uuid the activity course schedule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActivityCourseSchedule fetchActivityCourseScheduleByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Retourne la liste des horaires pour une liste de jours donnés sur une
	 * plage horaire donnée
	 */
	public List<ActivityCourseSchedule> findByDaysAndTimes(
		long groupId, boolean[] days, String startTime, String endTime);

	/**
	 * Lance une recherche par mots-clés
	 */
	public List<ActivityCourseSchedule> findByKeyword(
		String keyword, long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the activity course schedule with the primary key.
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule
	 * @throws PortalException if a activity course schedule with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActivityCourseSchedule getActivityCourseSchedule(
			long activityCourseScheduleId)
		throws PortalException;

	/**
	 * Returns the activity course schedule matching the UUID and group.
	 *
	 * @param uuid the activity course schedule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course schedule
	 * @throws PortalException if a matching activity course schedule could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActivityCourseSchedule getActivityCourseScheduleByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the activity course schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @return the range of activity course schedules
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityCourseSchedule> getActivityCourseSchedules(
		int start, int end);

	/**
	 * Returns all the activity course schedules matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity course schedules
	 * @param companyId the primary key of the company
	 * @return the matching activity course schedules, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityCourseSchedule>
		getActivityCourseSchedulesByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of activity course schedules matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity course schedules
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching activity course schedules, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityCourseSchedule>
		getActivityCourseSchedulesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ActivityCourseSchedule> orderByComparator);

	/**
	 * Returns the number of activity course schedules.
	 *
	 * @return the number of activity course schedules
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getActivityCourseSchedulesCount();

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne les horaires d'un cours dans un lieu
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityCourseSchedule> getByActivityCoursePlace(
		long activityCoursePlaceId);

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ActivityCourseSchedule> getByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

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
	 * Supprime une entité
	 */
	public ActivityCourseSchedule removeActivityCourseSchedule(
			long activityCourseScheduleId)
		throws PortalException;

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(SearchContext searchContext) throws SearchException;

	/**
	 * Updates the activity course schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ActivityCourseSchedule updateActivityCourseSchedule(
		ActivityCourseSchedule activityCourseSchedule);

	/**
	 * Met à jour une activité et l'enregistre en base de données
	 */
	public ActivityCourseSchedule updateActivityCourseSchedule(
			ActivityCourseSchedule activityCourseSchedule, ServiceContext sc)
		throws PortalException;

}