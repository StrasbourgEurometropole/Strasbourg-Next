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

package eu.strasbourg.service.agenda.service.persistence.impl;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.agenda.exception.NoSuchImportReportLineException;
import eu.strasbourg.service.agenda.model.ImportReportLine;
import eu.strasbourg.service.agenda.model.impl.ImportReportLineImpl;
import eu.strasbourg.service.agenda.model.impl.ImportReportLineModelImpl;
import eu.strasbourg.service.agenda.service.persistence.ImportReportLinePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the import report line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class ImportReportLinePersistenceImpl
	extends BasePersistenceImpl<ImportReportLine>
	implements ImportReportLinePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ImportReportLineUtil</code> to access the import report line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ImportReportLineImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the import report lines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import report lines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @return the range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import report lines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ImportReportLine> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import report lines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ImportReportLine> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ImportReportLine> list = null;

		if (useFinderCache) {
			list = (List<ImportReportLine>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportReportLine importReportLine : list) {
					if (!uuid.equals(importReportLine.getUuid())) {
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

			sb.append(_SQL_SELECT_IMPORTREPORTLINE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImportReportLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ImportReportLine>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first import report line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import report line
	 * @throws NoSuchImportReportLineException if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine findByUuid_First(
			String uuid, OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		ImportReportLine importReportLine = fetchByUuid_First(
			uuid, orderByComparator);

		if (importReportLine != null) {
			return importReportLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchImportReportLineException(sb.toString());
	}

	/**
	 * Returns the first import report line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import report line, or <code>null</code> if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine fetchByUuid_First(
		String uuid, OrderByComparator<ImportReportLine> orderByComparator) {

		List<ImportReportLine> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import report line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import report line
	 * @throws NoSuchImportReportLineException if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine findByUuid_Last(
			String uuid, OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		ImportReportLine importReportLine = fetchByUuid_Last(
			uuid, orderByComparator);

		if (importReportLine != null) {
			return importReportLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchImportReportLineException(sb.toString());
	}

	/**
	 * Returns the last import report line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import report line, or <code>null</code> if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine fetchByUuid_Last(
		String uuid, OrderByComparator<ImportReportLine> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ImportReportLine> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import report lines before and after the current import report line in the ordered set where uuid = &#63;.
	 *
	 * @param lineId the primary key of the current import report line
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import report line
	 * @throws NoSuchImportReportLineException if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine[] findByUuid_PrevAndNext(
			long lineId, String uuid,
			OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		uuid = Objects.toString(uuid, "");

		ImportReportLine importReportLine = findByPrimaryKey(lineId);

		Session session = null;

		try {
			session = openSession();

			ImportReportLine[] array = new ImportReportLineImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, importReportLine, uuid, orderByComparator, true);

			array[1] = importReportLine;

			array[2] = getByUuid_PrevAndNext(
				session, importReportLine, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportReportLine getByUuid_PrevAndNext(
		Session session, ImportReportLine importReportLine, String uuid,
		OrderByComparator<ImportReportLine> orderByComparator,
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

		sb.append(_SQL_SELECT_IMPORTREPORTLINE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			sb.append(ImportReportLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						importReportLine)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ImportReportLine> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import report lines where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ImportReportLine importReportLine :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(importReportLine);
		}
	}

	/**
	 * Returns the number of import report lines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching import report lines
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IMPORTREPORTLINE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"importReportLine.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(importReportLine.uuid IS NULL OR importReportLine.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByTypeAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByTypeAndStatus;
	private FinderPath _finderPathCountByTypeAndStatus;

	/**
	 * Returns all the import report lines where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByTypeAndStatus(
		String type, long status) {

		return findByTypeAndStatus(
			type, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import report lines where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @return the range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByTypeAndStatus(
		String type, long status, int start, int end) {

		return findByTypeAndStatus(type, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import report lines where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByTypeAndStatus(
		String type, long status, int start, int end,
		OrderByComparator<ImportReportLine> orderByComparator) {

		return findByTypeAndStatus(
			type, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import report lines where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByTypeAndStatus(
		String type, long status, int start, int end,
		OrderByComparator<ImportReportLine> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTypeAndStatus;
				finderArgs = new Object[] {type, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTypeAndStatus;
			finderArgs = new Object[] {
				type, status, start, end, orderByComparator
			};
		}

		List<ImportReportLine> list = null;

		if (useFinderCache) {
			list = (List<ImportReportLine>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportReportLine importReportLine : list) {
					if (!type.equals(importReportLine.getType()) ||
						(status != importReportLine.getStatus())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_IMPORTREPORTLINE_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);
			}

			sb.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImportReportLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				queryPos.add(status);

				list = (List<ImportReportLine>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first import report line in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import report line
	 * @throws NoSuchImportReportLineException if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine findByTypeAndStatus_First(
			String type, long status,
			OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		ImportReportLine importReportLine = fetchByTypeAndStatus_First(
			type, status, orderByComparator);

		if (importReportLine != null) {
			return importReportLine;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchImportReportLineException(sb.toString());
	}

	/**
	 * Returns the first import report line in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import report line, or <code>null</code> if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine fetchByTypeAndStatus_First(
		String type, long status,
		OrderByComparator<ImportReportLine> orderByComparator) {

		List<ImportReportLine> list = findByTypeAndStatus(
			type, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import report line in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import report line
	 * @throws NoSuchImportReportLineException if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine findByTypeAndStatus_Last(
			String type, long status,
			OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		ImportReportLine importReportLine = fetchByTypeAndStatus_Last(
			type, status, orderByComparator);

		if (importReportLine != null) {
			return importReportLine;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchImportReportLineException(sb.toString());
	}

	/**
	 * Returns the last import report line in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import report line, or <code>null</code> if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine fetchByTypeAndStatus_Last(
		String type, long status,
		OrderByComparator<ImportReportLine> orderByComparator) {

		int count = countByTypeAndStatus(type, status);

		if (count == 0) {
			return null;
		}

		List<ImportReportLine> list = findByTypeAndStatus(
			type, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import report lines before and after the current import report line in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param lineId the primary key of the current import report line
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import report line
	 * @throws NoSuchImportReportLineException if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine[] findByTypeAndStatus_PrevAndNext(
			long lineId, String type, long status,
			OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		type = Objects.toString(type, "");

		ImportReportLine importReportLine = findByPrimaryKey(lineId);

		Session session = null;

		try {
			session = openSession();

			ImportReportLine[] array = new ImportReportLineImpl[3];

			array[0] = getByTypeAndStatus_PrevAndNext(
				session, importReportLine, type, status, orderByComparator,
				true);

			array[1] = importReportLine;

			array[2] = getByTypeAndStatus_PrevAndNext(
				session, importReportLine, type, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportReportLine getByTypeAndStatus_PrevAndNext(
		Session session, ImportReportLine importReportLine, String type,
		long status, OrderByComparator<ImportReportLine> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_IMPORTREPORTLINE_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);
		}

		sb.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

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
			sb.append(ImportReportLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						importReportLine)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ImportReportLine> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import report lines where type = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param status the status
	 */
	@Override
	public void removeByTypeAndStatus(String type, long status) {
		for (ImportReportLine importReportLine :
				findByTypeAndStatus(
					type, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(importReportLine);
		}
	}

	/**
	 * Returns the number of import report lines where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the number of matching import report lines
	 */
	@Override
	public int countByTypeAndStatus(String type, long status) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByTypeAndStatus;

		Object[] finderArgs = new Object[] {type, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IMPORTREPORTLINE_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);
			}

			sb.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPEANDSTATUS_TYPE_2 =
		"importReportLine.type = ? AND ";

	private static final String _FINDER_COLUMN_TYPEANDSTATUS_TYPE_3 =
		"(importReportLine.type IS NULL OR importReportLine.type = '') AND ";

	private static final String _FINDER_COLUMN_TYPEANDSTATUS_STATUS_2 =
		"importReportLine.status = ?";

	private FinderPath _finderPathWithPaginationFindByReportId;
	private FinderPath _finderPathWithoutPaginationFindByReportId;
	private FinderPath _finderPathCountByReportId;

	/**
	 * Returns all the import report lines where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @return the matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByReportId(long reportId) {
		return findByReportId(
			reportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import report lines where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @return the range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByReportId(
		long reportId, int start, int end) {

		return findByReportId(reportId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import report lines where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByReportId(
		long reportId, int start, int end,
		OrderByComparator<ImportReportLine> orderByComparator) {

		return findByReportId(reportId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import report lines where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import report lines
	 */
	@Override
	public List<ImportReportLine> findByReportId(
		long reportId, int start, int end,
		OrderByComparator<ImportReportLine> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByReportId;
				finderArgs = new Object[] {reportId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByReportId;
			finderArgs = new Object[] {reportId, start, end, orderByComparator};
		}

		List<ImportReportLine> list = null;

		if (useFinderCache) {
			list = (List<ImportReportLine>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportReportLine importReportLine : list) {
					if (reportId != importReportLine.getReportId()) {
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

			sb.append(_SQL_SELECT_IMPORTREPORTLINE_WHERE);

			sb.append(_FINDER_COLUMN_REPORTID_REPORTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImportReportLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reportId);

				list = (List<ImportReportLine>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first import report line in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import report line
	 * @throws NoSuchImportReportLineException if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine findByReportId_First(
			long reportId,
			OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		ImportReportLine importReportLine = fetchByReportId_First(
			reportId, orderByComparator);

		if (importReportLine != null) {
			return importReportLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reportId=");
		sb.append(reportId);

		sb.append("}");

		throw new NoSuchImportReportLineException(sb.toString());
	}

	/**
	 * Returns the first import report line in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import report line, or <code>null</code> if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine fetchByReportId_First(
		long reportId, OrderByComparator<ImportReportLine> orderByComparator) {

		List<ImportReportLine> list = findByReportId(
			reportId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import report line in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import report line
	 * @throws NoSuchImportReportLineException if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine findByReportId_Last(
			long reportId,
			OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		ImportReportLine importReportLine = fetchByReportId_Last(
			reportId, orderByComparator);

		if (importReportLine != null) {
			return importReportLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reportId=");
		sb.append(reportId);

		sb.append("}");

		throw new NoSuchImportReportLineException(sb.toString());
	}

	/**
	 * Returns the last import report line in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import report line, or <code>null</code> if a matching import report line could not be found
	 */
	@Override
	public ImportReportLine fetchByReportId_Last(
		long reportId, OrderByComparator<ImportReportLine> orderByComparator) {

		int count = countByReportId(reportId);

		if (count == 0) {
			return null;
		}

		List<ImportReportLine> list = findByReportId(
			reportId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import report lines before and after the current import report line in the ordered set where reportId = &#63;.
	 *
	 * @param lineId the primary key of the current import report line
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import report line
	 * @throws NoSuchImportReportLineException if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine[] findByReportId_PrevAndNext(
			long lineId, long reportId,
			OrderByComparator<ImportReportLine> orderByComparator)
		throws NoSuchImportReportLineException {

		ImportReportLine importReportLine = findByPrimaryKey(lineId);

		Session session = null;

		try {
			session = openSession();

			ImportReportLine[] array = new ImportReportLineImpl[3];

			array[0] = getByReportId_PrevAndNext(
				session, importReportLine, reportId, orderByComparator, true);

			array[1] = importReportLine;

			array[2] = getByReportId_PrevAndNext(
				session, importReportLine, reportId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportReportLine getByReportId_PrevAndNext(
		Session session, ImportReportLine importReportLine, long reportId,
		OrderByComparator<ImportReportLine> orderByComparator,
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

		sb.append(_SQL_SELECT_IMPORTREPORTLINE_WHERE);

		sb.append(_FINDER_COLUMN_REPORTID_REPORTID_2);

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
			sb.append(ImportReportLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(reportId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						importReportLine)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ImportReportLine> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import report lines where reportId = &#63; from the database.
	 *
	 * @param reportId the report ID
	 */
	@Override
	public void removeByReportId(long reportId) {
		for (ImportReportLine importReportLine :
				findByReportId(
					reportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(importReportLine);
		}
	}

	/**
	 * Returns the number of import report lines where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @return the number of matching import report lines
	 */
	@Override
	public int countByReportId(long reportId) {
		FinderPath finderPath = _finderPathCountByReportId;

		Object[] finderArgs = new Object[] {reportId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IMPORTREPORTLINE_WHERE);

			sb.append(_FINDER_COLUMN_REPORTID_REPORTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reportId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REPORTID_REPORTID_2 =
		"importReportLine.reportId = ?";

	public ImportReportLinePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("log", "log_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		setModelClass(ImportReportLine.class);
	}

	/**
	 * Caches the import report line in the entity cache if it is enabled.
	 *
	 * @param importReportLine the import report line
	 */
	@Override
	public void cacheResult(ImportReportLine importReportLine) {
		entityCache.putResult(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineImpl.class, importReportLine.getPrimaryKey(),
			importReportLine);

		importReportLine.resetOriginalValues();
	}

	/**
	 * Caches the import report lines in the entity cache if it is enabled.
	 *
	 * @param importReportLines the import report lines
	 */
	@Override
	public void cacheResult(List<ImportReportLine> importReportLines) {
		for (ImportReportLine importReportLine : importReportLines) {
			if (entityCache.getResult(
					ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
					ImportReportLineImpl.class,
					importReportLine.getPrimaryKey()) == null) {

				cacheResult(importReportLine);
			}
			else {
				importReportLine.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all import report lines.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImportReportLineImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the import report line.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImportReportLine importReportLine) {
		entityCache.removeResult(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineImpl.class, importReportLine.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ImportReportLine> importReportLines) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImportReportLine importReportLine : importReportLines) {
			entityCache.removeResult(
				ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
				ImportReportLineImpl.class, importReportLine.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
				ImportReportLineImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new import report line with the primary key. Does not add the import report line to the database.
	 *
	 * @param lineId the primary key for the new import report line
	 * @return the new import report line
	 */
	@Override
	public ImportReportLine create(long lineId) {
		ImportReportLine importReportLine = new ImportReportLineImpl();

		importReportLine.setNew(true);
		importReportLine.setPrimaryKey(lineId);

		String uuid = PortalUUIDUtil.generate();

		importReportLine.setUuid(uuid);

		return importReportLine;
	}

	/**
	 * Removes the import report line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lineId the primary key of the import report line
	 * @return the import report line that was removed
	 * @throws NoSuchImportReportLineException if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine remove(long lineId)
		throws NoSuchImportReportLineException {

		return remove((Serializable)lineId);
	}

	/**
	 * Removes the import report line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the import report line
	 * @return the import report line that was removed
	 * @throws NoSuchImportReportLineException if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine remove(Serializable primaryKey)
		throws NoSuchImportReportLineException {

		Session session = null;

		try {
			session = openSession();

			ImportReportLine importReportLine = (ImportReportLine)session.get(
				ImportReportLineImpl.class, primaryKey);

			if (importReportLine == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImportReportLineException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(importReportLine);
		}
		catch (NoSuchImportReportLineException noSuchEntityException) {
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
	protected ImportReportLine removeImpl(ImportReportLine importReportLine) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importReportLine)) {
				importReportLine = (ImportReportLine)session.get(
					ImportReportLineImpl.class,
					importReportLine.getPrimaryKeyObj());
			}

			if (importReportLine != null) {
				session.delete(importReportLine);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (importReportLine != null) {
			clearCache(importReportLine);
		}

		return importReportLine;
	}

	@Override
	public ImportReportLine updateImpl(ImportReportLine importReportLine) {
		boolean isNew = importReportLine.isNew();

		if (!(importReportLine instanceof ImportReportLineModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(importReportLine.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					importReportLine);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in importReportLine proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ImportReportLine implementation " +
					importReportLine.getClass());
		}

		ImportReportLineModelImpl importReportLineModelImpl =
			(ImportReportLineModelImpl)importReportLine;

		if (Validator.isNull(importReportLine.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			importReportLine.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (importReportLine.isNew()) {
				session.save(importReportLine);

				importReportLine.setNew(false);
			}
			else {
				importReportLine = (ImportReportLine)session.merge(
					importReportLine);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ImportReportLineModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {importReportLineModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				importReportLineModelImpl.getType(),
				importReportLineModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByTypeAndStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTypeAndStatus, args);

			args = new Object[] {importReportLineModelImpl.getReportId()};

			finderCache.removeResult(_finderPathCountByReportId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByReportId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((importReportLineModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					importReportLineModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {importReportLineModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((importReportLineModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTypeAndStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					importReportLineModelImpl.getOriginalType(),
					importReportLineModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByTypeAndStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTypeAndStatus, args);

				args = new Object[] {
					importReportLineModelImpl.getType(),
					importReportLineModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByTypeAndStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTypeAndStatus, args);
			}

			if ((importReportLineModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByReportId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					importReportLineModelImpl.getOriginalReportId()
				};

				finderCache.removeResult(_finderPathCountByReportId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByReportId, args);

				args = new Object[] {importReportLineModelImpl.getReportId()};

				finderCache.removeResult(_finderPathCountByReportId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByReportId, args);
			}
		}

		entityCache.putResult(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineImpl.class, importReportLine.getPrimaryKey(),
			importReportLine, false);

		importReportLine.resetOriginalValues();

		return importReportLine;
	}

	/**
	 * Returns the import report line with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the import report line
	 * @return the import report line
	 * @throws NoSuchImportReportLineException if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImportReportLineException {

		ImportReportLine importReportLine = fetchByPrimaryKey(primaryKey);

		if (importReportLine == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImportReportLineException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return importReportLine;
	}

	/**
	 * Returns the import report line with the primary key or throws a <code>NoSuchImportReportLineException</code> if it could not be found.
	 *
	 * @param lineId the primary key of the import report line
	 * @return the import report line
	 * @throws NoSuchImportReportLineException if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine findByPrimaryKey(long lineId)
		throws NoSuchImportReportLineException {

		return findByPrimaryKey((Serializable)lineId);
	}

	/**
	 * Returns the import report line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the import report line
	 * @return the import report line, or <code>null</code> if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ImportReportLine importReportLine = (ImportReportLine)serializable;

		if (importReportLine == null) {
			Session session = null;

			try {
				session = openSession();

				importReportLine = (ImportReportLine)session.get(
					ImportReportLineImpl.class, primaryKey);

				if (importReportLine != null) {
					cacheResult(importReportLine);
				}
				else {
					entityCache.putResult(
						ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
						ImportReportLineImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
					ImportReportLineImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return importReportLine;
	}

	/**
	 * Returns the import report line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lineId the primary key of the import report line
	 * @return the import report line, or <code>null</code> if a import report line with the primary key could not be found
	 */
	@Override
	public ImportReportLine fetchByPrimaryKey(long lineId) {
		return fetchByPrimaryKey((Serializable)lineId);
	}

	@Override
	public Map<Serializable, ImportReportLine> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ImportReportLine> map =
			new HashMap<Serializable, ImportReportLine>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ImportReportLine importReportLine = fetchByPrimaryKey(primaryKey);

			if (importReportLine != null) {
				map.put(primaryKey, importReportLine);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
				ImportReportLineImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ImportReportLine)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		sb.append(_SQL_SELECT_IMPORTREPORTLINE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			sb.append((long)primaryKey);

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			for (ImportReportLine importReportLine :
					(List<ImportReportLine>)query.list()) {

				map.put(importReportLine.getPrimaryKeyObj(), importReportLine);

				cacheResult(importReportLine);

				uncachedPrimaryKeys.remove(importReportLine.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
					ImportReportLineImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the import report lines.
	 *
	 * @return the import report lines
	 */
	@Override
	public List<ImportReportLine> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import report lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @return the range of import report lines
	 */
	@Override
	public List<ImportReportLine> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the import report lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import report lines
	 */
	@Override
	public List<ImportReportLine> findAll(
		int start, int end,
		OrderByComparator<ImportReportLine> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import report lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of import report lines
	 */
	@Override
	public List<ImportReportLine> findAll(
		int start, int end,
		OrderByComparator<ImportReportLine> orderByComparator,
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

		List<ImportReportLine> list = null;

		if (useFinderCache) {
			list = (List<ImportReportLine>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IMPORTREPORTLINE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTREPORTLINE;

				sql = sql.concat(ImportReportLineModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ImportReportLine>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the import report lines from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ImportReportLine importReportLine : findAll()) {
			remove(importReportLine);
		}
	}

	/**
	 * Returns the number of import report lines.
	 *
	 * @return the number of import report lines
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_IMPORTREPORTLINE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return ImportReportLineModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the import report line persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED,
			ImportReportLineImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED,
			ImportReportLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED,
			ImportReportLineImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED,
			ImportReportLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ImportReportLineModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTypeAndStatus = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED,
			ImportReportLineImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeAndStatus",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTypeAndStatus = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED,
			ImportReportLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypeAndStatus",
			new String[] {String.class.getName(), Long.class.getName()},
			ImportReportLineModelImpl.TYPE_COLUMN_BITMASK |
			ImportReportLineModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByTypeAndStatus = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndStatus",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByReportId = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED,
			ImportReportLineImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReportId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByReportId = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED,
			ImportReportLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReportId",
			new String[] {Long.class.getName()},
			ImportReportLineModelImpl.REPORTID_COLUMN_BITMASK);

		_finderPathCountByReportId = new FinderPath(
			ImportReportLineModelImpl.ENTITY_CACHE_ENABLED,
			ImportReportLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReportId",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ImportReportLineImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IMPORTREPORTLINE =
		"SELECT importReportLine FROM ImportReportLine importReportLine";

	private static final String _SQL_SELECT_IMPORTREPORTLINE_WHERE_PKS_IN =
		"SELECT importReportLine FROM ImportReportLine importReportLine WHERE lineId IN (";

	private static final String _SQL_SELECT_IMPORTREPORTLINE_WHERE =
		"SELECT importReportLine FROM ImportReportLine importReportLine WHERE ";

	private static final String _SQL_COUNT_IMPORTREPORTLINE =
		"SELECT COUNT(importReportLine) FROM ImportReportLine importReportLine";

	private static final String _SQL_COUNT_IMPORTREPORTLINE_WHERE =
		"SELECT COUNT(importReportLine) FROM ImportReportLine importReportLine WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "importReportLine.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ImportReportLine exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ImportReportLine exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ImportReportLinePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type", "log"});

}