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

package eu.strasbourg.service.project.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.project.exception.NoSuchProjectTimelineException;
import eu.strasbourg.service.project.model.ProjectTimeline;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project timeline service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectTimelineUtil
 * @generated
 */
@ProviderType
public interface ProjectTimelinePersistence
	extends BasePersistence<ProjectTimeline> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectTimelineUtil} to access the project timeline persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project timelines where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project timelines
	 */
	public java.util.List<ProjectTimeline> findByProjectId(long projectId);

	/**
	 * Returns a range of all the project timelines where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @return the range of matching project timelines
	 */
	public java.util.List<ProjectTimeline> findByProjectId(
		long projectId, int start, int end);

	/**
	 * Returns an ordered range of all the project timelines where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project timelines
	 */
	public java.util.List<ProjectTimeline> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project timelines where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project timelines
	 */
	public java.util.List<ProjectTimeline> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project timeline
	 * @throws NoSuchProjectTimelineException if a matching project timeline could not be found
	 */
	public ProjectTimeline findByProjectId_First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
				orderByComparator)
		throws NoSuchProjectTimelineException;

	/**
	 * Returns the first project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project timeline, or <code>null</code> if a matching project timeline could not be found
	 */
	public ProjectTimeline fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator);

	/**
	 * Returns the last project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project timeline
	 * @throws NoSuchProjectTimelineException if a matching project timeline could not be found
	 */
	public ProjectTimeline findByProjectId_Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
				orderByComparator)
		throws NoSuchProjectTimelineException;

	/**
	 * Returns the last project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project timeline, or <code>null</code> if a matching project timeline could not be found
	 */
	public ProjectTimeline fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator);

	/**
	 * Returns the project timelines before and after the current project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectTimelineId the primary key of the current project timeline
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project timeline
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	public ProjectTimeline[] findByProjectId_PrevAndNext(
			long projectTimelineId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
				orderByComparator)
		throws NoSuchProjectTimelineException;

	/**
	 * Removes all the project timelines where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByProjectId(long projectId);

	/**
	 * Returns the number of project timelines where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project timelines
	 */
	public int countByProjectId(long projectId);

	/**
	 * Returns all the project timelines where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @return the matching project timelines
	 */
	public java.util.List<ProjectTimeline> findByBudgetParticipatifId(
		long budgetParticipatifId);

	/**
	 * Returns a range of all the project timelines where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @return the range of matching project timelines
	 */
	public java.util.List<ProjectTimeline> findByBudgetParticipatifId(
		long budgetParticipatifId, int start, int end);

	/**
	 * Returns an ordered range of all the project timelines where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project timelines
	 */
	public java.util.List<ProjectTimeline> findByBudgetParticipatifId(
		long budgetParticipatifId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project timelines where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project timelines
	 */
	public java.util.List<ProjectTimeline> findByBudgetParticipatifId(
		long budgetParticipatifId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project timeline
	 * @throws NoSuchProjectTimelineException if a matching project timeline could not be found
	 */
	public ProjectTimeline findByBudgetParticipatifId_First(
			long budgetParticipatifId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
				orderByComparator)
		throws NoSuchProjectTimelineException;

	/**
	 * Returns the first project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project timeline, or <code>null</code> if a matching project timeline could not be found
	 */
	public ProjectTimeline fetchByBudgetParticipatifId_First(
		long budgetParticipatifId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator);

	/**
	 * Returns the last project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project timeline
	 * @throws NoSuchProjectTimelineException if a matching project timeline could not be found
	 */
	public ProjectTimeline findByBudgetParticipatifId_Last(
			long budgetParticipatifId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
				orderByComparator)
		throws NoSuchProjectTimelineException;

	/**
	 * Returns the last project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project timeline, or <code>null</code> if a matching project timeline could not be found
	 */
	public ProjectTimeline fetchByBudgetParticipatifId_Last(
		long budgetParticipatifId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator);

	/**
	 * Returns the project timelines before and after the current project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param projectTimelineId the primary key of the current project timeline
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project timeline
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	public ProjectTimeline[] findByBudgetParticipatifId_PrevAndNext(
			long projectTimelineId, long budgetParticipatifId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
				orderByComparator)
		throws NoSuchProjectTimelineException;

	/**
	 * Removes all the project timelines where budgetParticipatifId = &#63; from the database.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 */
	public void removeByBudgetParticipatifId(long budgetParticipatifId);

	/**
	 * Returns the number of project timelines where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @return the number of matching project timelines
	 */
	public int countByBudgetParticipatifId(long budgetParticipatifId);

	/**
	 * Caches the project timeline in the entity cache if it is enabled.
	 *
	 * @param projectTimeline the project timeline
	 */
	public void cacheResult(ProjectTimeline projectTimeline);

	/**
	 * Caches the project timelines in the entity cache if it is enabled.
	 *
	 * @param projectTimelines the project timelines
	 */
	public void cacheResult(java.util.List<ProjectTimeline> projectTimelines);

	/**
	 * Creates a new project timeline with the primary key. Does not add the project timeline to the database.
	 *
	 * @param projectTimelineId the primary key for the new project timeline
	 * @return the new project timeline
	 */
	public ProjectTimeline create(long projectTimelineId);

	/**
	 * Removes the project timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline that was removed
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	public ProjectTimeline remove(long projectTimelineId)
		throws NoSuchProjectTimelineException;

	public ProjectTimeline updateImpl(ProjectTimeline projectTimeline);

	/**
	 * Returns the project timeline with the primary key or throws a <code>NoSuchProjectTimelineException</code> if it could not be found.
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	public ProjectTimeline findByPrimaryKey(long projectTimelineId)
		throws NoSuchProjectTimelineException;

	/**
	 * Returns the project timeline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline, or <code>null</code> if a project timeline with the primary key could not be found
	 */
	public ProjectTimeline fetchByPrimaryKey(long projectTimelineId);

	/**
	 * Returns all the project timelines.
	 *
	 * @return the project timelines
	 */
	public java.util.List<ProjectTimeline> findAll();

	/**
	 * Returns a range of all the project timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @return the range of project timelines
	 */
	public java.util.List<ProjectTimeline> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project timelines
	 */
	public java.util.List<ProjectTimeline> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project timelines
	 */
	public java.util.List<ProjectTimeline> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTimeline>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project timelines from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project timelines.
	 *
	 * @return the number of project timelines
	 */
	public int countAll();

}