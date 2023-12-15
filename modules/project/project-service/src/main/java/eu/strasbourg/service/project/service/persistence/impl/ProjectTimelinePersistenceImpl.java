/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.project.exception.NoSuchProjectTimelineException;
import eu.strasbourg.service.project.model.ProjectTimeline;
import eu.strasbourg.service.project.model.ProjectTimelineTable;
import eu.strasbourg.service.project.model.impl.ProjectTimelineImpl;
import eu.strasbourg.service.project.model.impl.ProjectTimelineModelImpl;
import eu.strasbourg.service.project.service.persistence.ProjectTimelinePersistence;
import eu.strasbourg.service.project.service.persistence.ProjectTimelineUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the project timeline service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class ProjectTimelinePersistenceImpl
	extends BasePersistenceImpl<ProjectTimeline>
	implements ProjectTimelinePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjectTimelineUtil</code> to access the project timeline persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjectTimelineImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByProjectId;
	private FinderPath _finderPathWithoutPaginationFindByProjectId;
	private FinderPath _finderPathCountByProjectId;

	/**
	 * Returns all the project timelines where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project timelines
	 */
	@Override
	public List<ProjectTimeline> findByProjectId(long projectId) {
		return findByProjectId(
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ProjectTimeline> findByProjectId(
		long projectId, int start, int end) {

		return findByProjectId(projectId, start, end, null);
	}

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
	@Override
	public List<ProjectTimeline> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ProjectTimeline> orderByComparator) {

		return findByProjectId(projectId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ProjectTimeline> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ProjectTimeline> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProjectId;
				finderArgs = new Object[] {projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProjectId;
			finderArgs = new Object[] {
				projectId, start, end, orderByComparator
			};
		}

		List<ProjectTimeline> list = null;

		if (useFinderCache) {
			list = (List<ProjectTimeline>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectTimeline projectTimeline : list) {
					if (projectId != projectTimeline.getProjectId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROJECTTIMELINE_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectTimelineModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				list = (List<ProjectTimeline>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project timeline
	 * @throws NoSuchProjectTimelineException if a matching project timeline could not be found
	 */
	@Override
	public ProjectTimeline findByProjectId_First(
			long projectId,
			OrderByComparator<ProjectTimeline> orderByComparator)
		throws NoSuchProjectTimelineException {

		ProjectTimeline projectTimeline = fetchByProjectId_First(
			projectId, orderByComparator);

		if (projectTimeline != null) {
			return projectTimeline;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchProjectTimelineException(sb.toString());
	}

	/**
	 * Returns the first project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project timeline, or <code>null</code> if a matching project timeline could not be found
	 */
	@Override
	public ProjectTimeline fetchByProjectId_First(
		long projectId, OrderByComparator<ProjectTimeline> orderByComparator) {

		List<ProjectTimeline> list = findByProjectId(
			projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project timeline
	 * @throws NoSuchProjectTimelineException if a matching project timeline could not be found
	 */
	@Override
	public ProjectTimeline findByProjectId_Last(
			long projectId,
			OrderByComparator<ProjectTimeline> orderByComparator)
		throws NoSuchProjectTimelineException {

		ProjectTimeline projectTimeline = fetchByProjectId_Last(
			projectId, orderByComparator);

		if (projectTimeline != null) {
			return projectTimeline;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchProjectTimelineException(sb.toString());
	}

	/**
	 * Returns the last project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project timeline, or <code>null</code> if a matching project timeline could not be found
	 */
	@Override
	public ProjectTimeline fetchByProjectId_Last(
		long projectId, OrderByComparator<ProjectTimeline> orderByComparator) {

		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<ProjectTimeline> list = findByProjectId(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project timelines before and after the current project timeline in the ordered set where projectId = &#63;.
	 *
	 * @param projectTimelineId the primary key of the current project timeline
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project timeline
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	@Override
	public ProjectTimeline[] findByProjectId_PrevAndNext(
			long projectTimelineId, long projectId,
			OrderByComparator<ProjectTimeline> orderByComparator)
		throws NoSuchProjectTimelineException {

		ProjectTimeline projectTimeline = findByPrimaryKey(projectTimelineId);

		Session session = null;

		try {
			session = openSession();

			ProjectTimeline[] array = new ProjectTimelineImpl[3];

			array[0] = getByProjectId_PrevAndNext(
				session, projectTimeline, projectId, orderByComparator, true);

			array[1] = projectTimeline;

			array[2] = getByProjectId_PrevAndNext(
				session, projectTimeline, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectTimeline getByProjectId_PrevAndNext(
		Session session, ProjectTimeline projectTimeline, long projectId,
		OrderByComparator<ProjectTimeline> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROJECTTIMELINE_WHERE);

		sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProjectTimelineModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectTimeline)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectTimeline> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project timelines where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(long projectId) {
		for (ProjectTimeline projectTimeline :
				findByProjectId(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectTimeline);
		}
	}

	/**
	 * Returns the number of project timelines where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project timelines
	 */
	@Override
	public int countByProjectId(long projectId) {
		FinderPath finderPath = _finderPathCountByProjectId;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTTIMELINE_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 =
		"projectTimeline.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByBudgetParticipatifId;
	private FinderPath _finderPathWithoutPaginationFindByBudgetParticipatifId;
	private FinderPath _finderPathCountByBudgetParticipatifId;

	/**
	 * Returns all the project timelines where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @return the matching project timelines
	 */
	@Override
	public List<ProjectTimeline> findByBudgetParticipatifId(
		long budgetParticipatifId) {

		return findByBudgetParticipatifId(
			budgetParticipatifId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ProjectTimeline> findByBudgetParticipatifId(
		long budgetParticipatifId, int start, int end) {

		return findByBudgetParticipatifId(
			budgetParticipatifId, start, end, null);
	}

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
	@Override
	public List<ProjectTimeline> findByBudgetParticipatifId(
		long budgetParticipatifId, int start, int end,
		OrderByComparator<ProjectTimeline> orderByComparator) {

		return findByBudgetParticipatifId(
			budgetParticipatifId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ProjectTimeline> findByBudgetParticipatifId(
		long budgetParticipatifId, int start, int end,
		OrderByComparator<ProjectTimeline> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBudgetParticipatifId;
				finderArgs = new Object[] {budgetParticipatifId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBudgetParticipatifId;
			finderArgs = new Object[] {
				budgetParticipatifId, start, end, orderByComparator
			};
		}

		List<ProjectTimeline> list = null;

		if (useFinderCache) {
			list = (List<ProjectTimeline>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectTimeline projectTimeline : list) {
					if (budgetParticipatifId !=
							projectTimeline.getBudgetParticipatifId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROJECTTIMELINE_WHERE);

			sb.append(
				_FINDER_COLUMN_BUDGETPARTICIPATIFID_BUDGETPARTICIPATIFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectTimelineModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(budgetParticipatifId);

				list = (List<ProjectTimeline>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project timeline
	 * @throws NoSuchProjectTimelineException if a matching project timeline could not be found
	 */
	@Override
	public ProjectTimeline findByBudgetParticipatifId_First(
			long budgetParticipatifId,
			OrderByComparator<ProjectTimeline> orderByComparator)
		throws NoSuchProjectTimelineException {

		ProjectTimeline projectTimeline = fetchByBudgetParticipatifId_First(
			budgetParticipatifId, orderByComparator);

		if (projectTimeline != null) {
			return projectTimeline;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("budgetParticipatifId=");
		sb.append(budgetParticipatifId);

		sb.append("}");

		throw new NoSuchProjectTimelineException(sb.toString());
	}

	/**
	 * Returns the first project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project timeline, or <code>null</code> if a matching project timeline could not be found
	 */
	@Override
	public ProjectTimeline fetchByBudgetParticipatifId_First(
		long budgetParticipatifId,
		OrderByComparator<ProjectTimeline> orderByComparator) {

		List<ProjectTimeline> list = findByBudgetParticipatifId(
			budgetParticipatifId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project timeline
	 * @throws NoSuchProjectTimelineException if a matching project timeline could not be found
	 */
	@Override
	public ProjectTimeline findByBudgetParticipatifId_Last(
			long budgetParticipatifId,
			OrderByComparator<ProjectTimeline> orderByComparator)
		throws NoSuchProjectTimelineException {

		ProjectTimeline projectTimeline = fetchByBudgetParticipatifId_Last(
			budgetParticipatifId, orderByComparator);

		if (projectTimeline != null) {
			return projectTimeline;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("budgetParticipatifId=");
		sb.append(budgetParticipatifId);

		sb.append("}");

		throw new NoSuchProjectTimelineException(sb.toString());
	}

	/**
	 * Returns the last project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project timeline, or <code>null</code> if a matching project timeline could not be found
	 */
	@Override
	public ProjectTimeline fetchByBudgetParticipatifId_Last(
		long budgetParticipatifId,
		OrderByComparator<ProjectTimeline> orderByComparator) {

		int count = countByBudgetParticipatifId(budgetParticipatifId);

		if (count == 0) {
			return null;
		}

		List<ProjectTimeline> list = findByBudgetParticipatifId(
			budgetParticipatifId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project timelines before and after the current project timeline in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param projectTimelineId the primary key of the current project timeline
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project timeline
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	@Override
	public ProjectTimeline[] findByBudgetParticipatifId_PrevAndNext(
			long projectTimelineId, long budgetParticipatifId,
			OrderByComparator<ProjectTimeline> orderByComparator)
		throws NoSuchProjectTimelineException {

		ProjectTimeline projectTimeline = findByPrimaryKey(projectTimelineId);

		Session session = null;

		try {
			session = openSession();

			ProjectTimeline[] array = new ProjectTimelineImpl[3];

			array[0] = getByBudgetParticipatifId_PrevAndNext(
				session, projectTimeline, budgetParticipatifId,
				orderByComparator, true);

			array[1] = projectTimeline;

			array[2] = getByBudgetParticipatifId_PrevAndNext(
				session, projectTimeline, budgetParticipatifId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectTimeline getByBudgetParticipatifId_PrevAndNext(
		Session session, ProjectTimeline projectTimeline,
		long budgetParticipatifId,
		OrderByComparator<ProjectTimeline> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROJECTTIMELINE_WHERE);

		sb.append(_FINDER_COLUMN_BUDGETPARTICIPATIFID_BUDGETPARTICIPATIFID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProjectTimelineModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(budgetParticipatifId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectTimeline)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectTimeline> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project timelines where budgetParticipatifId = &#63; from the database.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 */
	@Override
	public void removeByBudgetParticipatifId(long budgetParticipatifId) {
		for (ProjectTimeline projectTimeline :
				findByBudgetParticipatifId(
					budgetParticipatifId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(projectTimeline);
		}
	}

	/**
	 * Returns the number of project timelines where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @return the number of matching project timelines
	 */
	@Override
	public int countByBudgetParticipatifId(long budgetParticipatifId) {
		FinderPath finderPath = _finderPathCountByBudgetParticipatifId;

		Object[] finderArgs = new Object[] {budgetParticipatifId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTTIMELINE_WHERE);

			sb.append(
				_FINDER_COLUMN_BUDGETPARTICIPATIFID_BUDGETPARTICIPATIFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(budgetParticipatifId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_BUDGETPARTICIPATIFID_BUDGETPARTICIPATIFID_2 =
			"projectTimeline.budgetParticipatifId = ?";

	public ProjectTimelinePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("date", "date_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProjectTimeline.class);

		setModelImplClass(ProjectTimelineImpl.class);
		setModelPKClass(long.class);

		setTable(ProjectTimelineTable.INSTANCE);
	}

	/**
	 * Caches the project timeline in the entity cache if it is enabled.
	 *
	 * @param projectTimeline the project timeline
	 */
	@Override
	public void cacheResult(ProjectTimeline projectTimeline) {
		entityCache.putResult(
			ProjectTimelineImpl.class, projectTimeline.getPrimaryKey(),
			projectTimeline);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the project timelines in the entity cache if it is enabled.
	 *
	 * @param projectTimelines the project timelines
	 */
	@Override
	public void cacheResult(List<ProjectTimeline> projectTimelines) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (projectTimelines.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProjectTimeline projectTimeline : projectTimelines) {
			if (entityCache.getResult(
					ProjectTimelineImpl.class,
					projectTimeline.getPrimaryKey()) == null) {

				cacheResult(projectTimeline);
			}
		}
	}

	/**
	 * Clears the cache for all project timelines.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectTimelineImpl.class);

		finderCache.clearCache(ProjectTimelineImpl.class);
	}

	/**
	 * Clears the cache for the project timeline.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectTimeline projectTimeline) {
		entityCache.removeResult(ProjectTimelineImpl.class, projectTimeline);
	}

	@Override
	public void clearCache(List<ProjectTimeline> projectTimelines) {
		for (ProjectTimeline projectTimeline : projectTimelines) {
			entityCache.removeResult(
				ProjectTimelineImpl.class, projectTimeline);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProjectTimelineImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProjectTimelineImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new project timeline with the primary key. Does not add the project timeline to the database.
	 *
	 * @param projectTimelineId the primary key for the new project timeline
	 * @return the new project timeline
	 */
	@Override
	public ProjectTimeline create(long projectTimelineId) {
		ProjectTimeline projectTimeline = new ProjectTimelineImpl();

		projectTimeline.setNew(true);
		projectTimeline.setPrimaryKey(projectTimelineId);

		return projectTimeline;
	}

	/**
	 * Removes the project timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline that was removed
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	@Override
	public ProjectTimeline remove(long projectTimelineId)
		throws NoSuchProjectTimelineException {

		return remove((Serializable)projectTimelineId);
	}

	/**
	 * Removes the project timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project timeline
	 * @return the project timeline that was removed
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	@Override
	public ProjectTimeline remove(Serializable primaryKey)
		throws NoSuchProjectTimelineException {

		Session session = null;

		try {
			session = openSession();

			ProjectTimeline projectTimeline = (ProjectTimeline)session.get(
				ProjectTimelineImpl.class, primaryKey);

			if (projectTimeline == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectTimelineException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projectTimeline);
		}
		catch (NoSuchProjectTimelineException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ProjectTimeline removeImpl(ProjectTimeline projectTimeline) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectTimeline)) {
				projectTimeline = (ProjectTimeline)session.get(
					ProjectTimelineImpl.class,
					projectTimeline.getPrimaryKeyObj());
			}

			if (projectTimeline != null) {
				session.delete(projectTimeline);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projectTimeline != null) {
			clearCache(projectTimeline);
		}

		return projectTimeline;
	}

	@Override
	public ProjectTimeline updateImpl(ProjectTimeline projectTimeline) {
		boolean isNew = projectTimeline.isNew();

		if (!(projectTimeline instanceof ProjectTimelineModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectTimeline.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					projectTimeline);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectTimeline proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectTimeline implementation " +
					projectTimeline.getClass());
		}

		ProjectTimelineModelImpl projectTimelineModelImpl =
			(ProjectTimelineModelImpl)projectTimeline;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(projectTimeline);
			}
			else {
				projectTimeline = (ProjectTimeline)session.merge(
					projectTimeline);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProjectTimelineImpl.class, projectTimelineModelImpl, false, true);

		if (isNew) {
			projectTimeline.setNew(false);
		}

		projectTimeline.resetOriginalValues();

		return projectTimeline;
	}

	/**
	 * Returns the project timeline with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project timeline
	 * @return the project timeline
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	@Override
	public ProjectTimeline findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectTimelineException {

		ProjectTimeline projectTimeline = fetchByPrimaryKey(primaryKey);

		if (projectTimeline == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectTimelineException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projectTimeline;
	}

	/**
	 * Returns the project timeline with the primary key or throws a <code>NoSuchProjectTimelineException</code> if it could not be found.
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline
	 * @throws NoSuchProjectTimelineException if a project timeline with the primary key could not be found
	 */
	@Override
	public ProjectTimeline findByPrimaryKey(long projectTimelineId)
		throws NoSuchProjectTimelineException {

		return findByPrimaryKey((Serializable)projectTimelineId);
	}

	/**
	 * Returns the project timeline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline, or <code>null</code> if a project timeline with the primary key could not be found
	 */
	@Override
	public ProjectTimeline fetchByPrimaryKey(long projectTimelineId) {
		return fetchByPrimaryKey((Serializable)projectTimelineId);
	}

	/**
	 * Returns all the project timelines.
	 *
	 * @return the project timelines
	 */
	@Override
	public List<ProjectTimeline> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ProjectTimeline> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ProjectTimeline> findAll(
		int start, int end,
		OrderByComparator<ProjectTimeline> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ProjectTimeline> findAll(
		int start, int end,
		OrderByComparator<ProjectTimeline> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ProjectTimeline> list = null;

		if (useFinderCache) {
			list = (List<ProjectTimeline>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROJECTTIMELINE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTTIMELINE;

				sql = sql.concat(ProjectTimelineModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProjectTimeline>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the project timelines from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectTimeline projectTimeline : findAll()) {
			remove(projectTimeline);
		}
	}

	/**
	 * Returns the number of project timelines.
	 *
	 * @return the number of project timelines
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROJECTTIMELINE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "projectTimelineId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJECTTIMELINE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectTimelineModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project timeline persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"projectId"}, true);

		_finderPathWithoutPaginationFindByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			true);

		_finderPathCountByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			false);

		_finderPathWithPaginationFindByBudgetParticipatifId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBudgetParticipatifId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"budgetParticipatifId"}, true);

		_finderPathWithoutPaginationFindByBudgetParticipatifId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBudgetParticipatifId", new String[] {Long.class.getName()},
			new String[] {"budgetParticipatifId"}, true);

		_finderPathCountByBudgetParticipatifId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBudgetParticipatifId", new String[] {Long.class.getName()},
			new String[] {"budgetParticipatifId"}, false);

		ProjectTimelineUtil.setPersistence(this);
	}

	public void destroy() {
		ProjectTimelineUtil.setPersistence(null);

		entityCache.removeCache(ProjectTimelineImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROJECTTIMELINE =
		"SELECT projectTimeline FROM ProjectTimeline projectTimeline";

	private static final String _SQL_SELECT_PROJECTTIMELINE_WHERE =
		"SELECT projectTimeline FROM ProjectTimeline projectTimeline WHERE ";

	private static final String _SQL_COUNT_PROJECTTIMELINE =
		"SELECT COUNT(projectTimeline) FROM ProjectTimeline projectTimeline";

	private static final String _SQL_COUNT_PROJECTTIMELINE_WHERE =
		"SELECT COUNT(projectTimeline) FROM ProjectTimeline projectTimeline WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "projectTimeline.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjectTimeline exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProjectTimeline exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectTimelinePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"date"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}