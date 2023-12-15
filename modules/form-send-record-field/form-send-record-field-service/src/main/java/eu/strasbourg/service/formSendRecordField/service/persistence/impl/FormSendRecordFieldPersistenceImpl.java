/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.formSendRecordField.service.persistence.impl;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.formSendRecordField.exception.NoSuchFormSendRecordFieldException;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordField;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldTable;
import eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldImpl;
import eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldModelImpl;
import eu.strasbourg.service.formSendRecordField.service.persistence.FormSendRecordFieldPersistence;
import eu.strasbourg.service.formSendRecordField.service.persistence.FormSendRecordFieldUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the form send record field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angélique Zunino
 * @generated
 */
public class FormSendRecordFieldPersistenceImpl
	extends BasePersistenceImpl<FormSendRecordField>
	implements FormSendRecordFieldPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FormSendRecordFieldUtil</code> to access the form send record field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FormSendRecordFieldImpl.class.getName();

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
	 * Returns all the form send record fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form send record fields where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form send record fields where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form send record fields where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator,
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

		List<FormSendRecordField> list = null;

		if (useFinderCache) {
			list = (List<FormSendRecordField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormSendRecordField formSendRecordField : list) {
					if (!uuid.equals(formSendRecordField.getUuid())) {
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

			sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

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
				sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
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

				list = (List<FormSendRecordField>)QueryUtil.list(
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
	 * Returns the first form send record field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByUuid_First(
			String uuid,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByUuid_First(
			uuid, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the first form send record field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByUuid_First(
		String uuid, OrderByComparator<FormSendRecordField> orderByComparator) {

		List<FormSendRecordField> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form send record field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByUuid_Last(
			String uuid,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByUuid_Last(
			uuid, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the last form send record field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByUuid_Last(
		String uuid, OrderByComparator<FormSendRecordField> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FormSendRecordField> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form send record fields before and after the current form send record field in the ordered set where uuid = &#63;.
	 *
	 * @param formSendRecordFieldId the primary key of the current form send record field
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form send record field
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField[] findByUuid_PrevAndNext(
			long formSendRecordFieldId, String uuid,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		uuid = Objects.toString(uuid, "");

		FormSendRecordField formSendRecordField = findByPrimaryKey(
			formSendRecordFieldId);

		Session session = null;

		try {
			session = openSession();

			FormSendRecordField[] array = new FormSendRecordFieldImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, formSendRecordField, uuid, orderByComparator, true);

			array[1] = formSendRecordField;

			array[2] = getByUuid_PrevAndNext(
				session, formSendRecordField, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FormSendRecordField getByUuid_PrevAndNext(
		Session session, FormSendRecordField formSendRecordField, String uuid,
		OrderByComparator<FormSendRecordField> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

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
			sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
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
						formSendRecordField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormSendRecordField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form send record fields where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FormSendRecordField formSendRecordField :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(formSendRecordField);
		}
	}

	/**
	 * Returns the number of form send record fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching form send record fields
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FORMSENDRECORDFIELD_WHERE);

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
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"formSendRecordField.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(formSendRecordField.uuid IS NULL OR formSendRecordField.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the form send record field where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormSendRecordFieldException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByUUID_G(String uuid, long groupId)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByUUID_G(uuid, groupId);

		if (formSendRecordField == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFormSendRecordFieldException(sb.toString());
		}

		return formSendRecordField;
	}

	/**
	 * Returns the form send record field where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the form send record field where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof FormSendRecordField) {
			FormSendRecordField formSendRecordField =
				(FormSendRecordField)result;

			if (!Objects.equals(uuid, formSendRecordField.getUuid()) ||
				(groupId != formSendRecordField.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<FormSendRecordField> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FormSendRecordField formSendRecordField = list.get(0);

					result = formSendRecordField;

					cacheResult(formSendRecordField);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FormSendRecordField)result;
		}
	}

	/**
	 * Removes the form send record field where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form send record field that was removed
	 */
	@Override
	public FormSendRecordField removeByUUID_G(String uuid, long groupId)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = findByUUID_G(uuid, groupId);

		return remove(formSendRecordField);
	}

	/**
	 * Returns the number of form send record fields where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching form send record fields
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMSENDRECORDFIELD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"formSendRecordField.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(formSendRecordField.uuid IS NULL OR formSendRecordField.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"formSendRecordField.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the form send record fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form send record fields where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form send record fields where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form send record fields where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<FormSendRecordField> list = null;

		if (useFinderCache) {
			list = (List<FormSendRecordField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormSendRecordField formSendRecordField : list) {
					if (!uuid.equals(formSendRecordField.getUuid()) ||
						(companyId != formSendRecordField.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<FormSendRecordField>)QueryUtil.list(
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
	 * Returns the first form send record field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the first form send record field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		List<FormSendRecordField> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form send record field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the last form send record field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FormSendRecordField> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form send record fields before and after the current form send record field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param formSendRecordFieldId the primary key of the current form send record field
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form send record field
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField[] findByUuid_C_PrevAndNext(
			long formSendRecordFieldId, String uuid, long companyId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		uuid = Objects.toString(uuid, "");

		FormSendRecordField formSendRecordField = findByPrimaryKey(
			formSendRecordFieldId);

		Session session = null;

		try {
			session = openSession();

			FormSendRecordField[] array = new FormSendRecordFieldImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, formSendRecordField, uuid, companyId,
				orderByComparator, true);

			array[1] = formSendRecordField;

			array[2] = getByUuid_C_PrevAndNext(
				session, formSendRecordField, uuid, companyId,
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

	protected FormSendRecordField getByUuid_C_PrevAndNext(
		Session session, FormSendRecordField formSendRecordField, String uuid,
		long companyId,
		OrderByComparator<FormSendRecordField> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formSendRecordField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormSendRecordField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form send record fields where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FormSendRecordField formSendRecordField :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(formSendRecordField);
		}
	}

	/**
	 * Returns the number of form send record fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching form send record fields
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMSENDRECORDFIELD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"formSendRecordField.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(formSendRecordField.uuid IS NULL OR formSendRecordField.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"formSendRecordField.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the form send record fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form send record fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form send record fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form send record fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<FormSendRecordField> list = null;

		if (useFinderCache) {
			list = (List<FormSendRecordField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormSendRecordField formSendRecordField : list) {
					if (groupId != formSendRecordField.getGroupId()) {
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

			sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<FormSendRecordField>)QueryUtil.list(
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
	 * Returns the first form send record field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByGroupId_First(
			long groupId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByGroupId_First(
			groupId, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the first form send record field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByGroupId_First(
		long groupId,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		List<FormSendRecordField> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form send record field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByGroupId_Last(
			long groupId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the last form send record field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByGroupId_Last(
		long groupId,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<FormSendRecordField> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form send record fields before and after the current form send record field in the ordered set where groupId = &#63;.
	 *
	 * @param formSendRecordFieldId the primary key of the current form send record field
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form send record field
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField[] findByGroupId_PrevAndNext(
			long formSendRecordFieldId, long groupId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = findByPrimaryKey(
			formSendRecordFieldId);

		Session session = null;

		try {
			session = openSession();

			FormSendRecordField[] array = new FormSendRecordFieldImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, formSendRecordField, groupId, orderByComparator, true);

			array[1] = formSendRecordField;

			array[2] = getByGroupId_PrevAndNext(
				session, formSendRecordField, groupId, orderByComparator,
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

	protected FormSendRecordField getByGroupId_PrevAndNext(
		Session session, FormSendRecordField formSendRecordField, long groupId,
		OrderByComparator<FormSendRecordField> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formSendRecordField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormSendRecordField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form send record fields where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (FormSendRecordField formSendRecordField :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(formSendRecordField);
		}
	}

	/**
	 * Returns the number of form send record fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching form send record fields
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FORMSENDRECORDFIELD_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"formSendRecordField.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByAssetEntryId;
	private FinderPath _finderPathWithoutPaginationFindByAssetEntryId;
	private FinderPath _finderPathCountByAssetEntryId;

	/**
	 * Returns all the form send record fields where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @return the matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByAssetEntryId(
		long assetEntryId, int status) {

		return findByAssetEntryId(
			assetEntryId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form send record fields where assetEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByAssetEntryId(
		long assetEntryId, int status, int start, int end) {

		return findByAssetEntryId(assetEntryId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form send record fields where assetEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByAssetEntryId(
		long assetEntryId, int status, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		return findByAssetEntryId(
			assetEntryId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form send record fields where assetEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByAssetEntryId(
		long assetEntryId, int status, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAssetEntryId;
				finderArgs = new Object[] {assetEntryId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAssetEntryId;
			finderArgs = new Object[] {
				assetEntryId, status, start, end, orderByComparator
			};
		}

		List<FormSendRecordField> list = null;

		if (useFinderCache) {
			list = (List<FormSendRecordField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormSendRecordField formSendRecordField : list) {
					if ((assetEntryId !=
							formSendRecordField.getAssetEntryId()) ||
						(status != formSendRecordField.getStatus())) {

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

			sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

			sb.append(_FINDER_COLUMN_ASSETENTRYID_ASSETENTRYID_2);

			sb.append(_FINDER_COLUMN_ASSETENTRYID_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assetEntryId);

				queryPos.add(status);

				list = (List<FormSendRecordField>)QueryUtil.list(
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
	 * Returns the first form send record field in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByAssetEntryId_First(
			long assetEntryId, int status,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByAssetEntryId_First(
			assetEntryId, status, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("assetEntryId=");
		sb.append(assetEntryId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the first form send record field in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByAssetEntryId_First(
		long assetEntryId, int status,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		List<FormSendRecordField> list = findByAssetEntryId(
			assetEntryId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form send record field in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByAssetEntryId_Last(
			long assetEntryId, int status,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByAssetEntryId_Last(
			assetEntryId, status, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("assetEntryId=");
		sb.append(assetEntryId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the last form send record field in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByAssetEntryId_Last(
		long assetEntryId, int status,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		int count = countByAssetEntryId(assetEntryId, status);

		if (count == 0) {
			return null;
		}

		List<FormSendRecordField> list = findByAssetEntryId(
			assetEntryId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form send record fields before and after the current form send record field in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param formSendRecordFieldId the primary key of the current form send record field
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form send record field
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField[] findByAssetEntryId_PrevAndNext(
			long formSendRecordFieldId, long assetEntryId, int status,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = findByPrimaryKey(
			formSendRecordFieldId);

		Session session = null;

		try {
			session = openSession();

			FormSendRecordField[] array = new FormSendRecordFieldImpl[3];

			array[0] = getByAssetEntryId_PrevAndNext(
				session, formSendRecordField, assetEntryId, status,
				orderByComparator, true);

			array[1] = formSendRecordField;

			array[2] = getByAssetEntryId_PrevAndNext(
				session, formSendRecordField, assetEntryId, status,
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

	protected FormSendRecordField getByAssetEntryId_PrevAndNext(
		Session session, FormSendRecordField formSendRecordField,
		long assetEntryId, int status,
		OrderByComparator<FormSendRecordField> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

		sb.append(_FINDER_COLUMN_ASSETENTRYID_ASSETENTRYID_2);

		sb.append(_FINDER_COLUMN_ASSETENTRYID_STATUS_2);

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
			sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(assetEntryId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formSendRecordField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormSendRecordField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form send record fields where assetEntryId = &#63; and status = &#63; from the database.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 */
	@Override
	public void removeByAssetEntryId(long assetEntryId, int status) {
		for (FormSendRecordField formSendRecordField :
				findByAssetEntryId(
					assetEntryId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(formSendRecordField);
		}
	}

	/**
	 * Returns the number of form send record fields where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @return the number of matching form send record fields
	 */
	@Override
	public int countByAssetEntryId(long assetEntryId, int status) {
		FinderPath finderPath = _finderPathCountByAssetEntryId;

		Object[] finderArgs = new Object[] {assetEntryId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMSENDRECORDFIELD_WHERE);

			sb.append(_FINDER_COLUMN_ASSETENTRYID_ASSETENTRYID_2);

			sb.append(_FINDER_COLUMN_ASSETENTRYID_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assetEntryId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_ASSETENTRYID_ASSETENTRYID_2 =
		"formSendRecordField.assetEntryId = ? AND ";

	private static final String _FINDER_COLUMN_ASSETENTRYID_STATUS_2 =
		"formSendRecordField.status = ?";

	private FinderPath _finderPathWithPaginationFindByContentId;
	private FinderPath _finderPathWithoutPaginationFindByContentId;
	private FinderPath _finderPathCountByContentId;

	/**
	 * Returns all the form send record fields where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @return the matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByContentId(long contentId) {
		return findByContentId(
			contentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form send record fields where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByContentId(
		long contentId, int start, int end) {

		return findByContentId(contentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form send record fields where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByContentId(
		long contentId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		return findByContentId(contentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form send record fields where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByContentId(
		long contentId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContentId;
				finderArgs = new Object[] {contentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContentId;
			finderArgs = new Object[] {
				contentId, start, end, orderByComparator
			};
		}

		List<FormSendRecordField> list = null;

		if (useFinderCache) {
			list = (List<FormSendRecordField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormSendRecordField formSendRecordField : list) {
					if (contentId != formSendRecordField.getContentId()) {
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

			sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

			sb.append(_FINDER_COLUMN_CONTENTID_CONTENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contentId);

				list = (List<FormSendRecordField>)QueryUtil.list(
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
	 * Returns the first form send record field in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByContentId_First(
			long contentId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByContentId_First(
			contentId, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contentId=");
		sb.append(contentId);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the first form send record field in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByContentId_First(
		long contentId,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		List<FormSendRecordField> list = findByContentId(
			contentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form send record field in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByContentId_Last(
			long contentId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByContentId_Last(
			contentId, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contentId=");
		sb.append(contentId);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the last form send record field in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByContentId_Last(
		long contentId,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		int count = countByContentId(contentId);

		if (count == 0) {
			return null;
		}

		List<FormSendRecordField> list = findByContentId(
			contentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form send record fields before and after the current form send record field in the ordered set where contentId = &#63;.
	 *
	 * @param formSendRecordFieldId the primary key of the current form send record field
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form send record field
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField[] findByContentId_PrevAndNext(
			long formSendRecordFieldId, long contentId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = findByPrimaryKey(
			formSendRecordFieldId);

		Session session = null;

		try {
			session = openSession();

			FormSendRecordField[] array = new FormSendRecordFieldImpl[3];

			array[0] = getByContentId_PrevAndNext(
				session, formSendRecordField, contentId, orderByComparator,
				true);

			array[1] = formSendRecordField;

			array[2] = getByContentId_PrevAndNext(
				session, formSendRecordField, contentId, orderByComparator,
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

	protected FormSendRecordField getByContentId_PrevAndNext(
		Session session, FormSendRecordField formSendRecordField,
		long contentId,
		OrderByComparator<FormSendRecordField> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

		sb.append(_FINDER_COLUMN_CONTENTID_CONTENTID_2);

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
			sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(contentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formSendRecordField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormSendRecordField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form send record fields where contentId = &#63; from the database.
	 *
	 * @param contentId the content ID
	 */
	@Override
	public void removeByContentId(long contentId) {
		for (FormSendRecordField formSendRecordField :
				findByContentId(
					contentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(formSendRecordField);
		}
	}

	/**
	 * Returns the number of form send record fields where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @return the number of matching form send record fields
	 */
	@Override
	public int countByContentId(long contentId) {
		FinderPath finderPath = _finderPathCountByContentId;

		Object[] finderArgs = new Object[] {contentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FORMSENDRECORDFIELD_WHERE);

			sb.append(_FINDER_COLUMN_CONTENTID_CONTENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contentId);

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

	private static final String _FINDER_COLUMN_CONTENTID_CONTENTID_2 =
		"formSendRecordField.contentId = ?";

	private FinderPath _finderPathWithPaginationFindByContentAndInstanceId;
	private FinderPath _finderPathWithoutPaginationFindByContentAndInstanceId;
	private FinderPath _finderPathCountByContentAndInstanceId;

	/**
	 * Returns all the form send record fields where contentId = &#63; and instanceId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @return the matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByContentAndInstanceId(
		long contentId, String instanceId) {

		return findByContentAndInstanceId(
			contentId, instanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form send record fields where contentId = &#63; and instanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByContentAndInstanceId(
		long contentId, String instanceId, int start, int end) {

		return findByContentAndInstanceId(
			contentId, instanceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form send record fields where contentId = &#63; and instanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByContentAndInstanceId(
		long contentId, String instanceId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		return findByContentAndInstanceId(
			contentId, instanceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form send record fields where contentId = &#63; and instanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form send record fields
	 */
	@Override
	public List<FormSendRecordField> findByContentAndInstanceId(
		long contentId, String instanceId, int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator,
		boolean useFinderCache) {

		instanceId = Objects.toString(instanceId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByContentAndInstanceId;
				finderArgs = new Object[] {contentId, instanceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContentAndInstanceId;
			finderArgs = new Object[] {
				contentId, instanceId, start, end, orderByComparator
			};
		}

		List<FormSendRecordField> list = null;

		if (useFinderCache) {
			list = (List<FormSendRecordField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormSendRecordField formSendRecordField : list) {
					if ((contentId != formSendRecordField.getContentId()) ||
						!instanceId.equals(
							formSendRecordField.getInstanceId())) {

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

			sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

			sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_CONTENTID_2);

			boolean bindInstanceId = false;

			if (instanceId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_INSTANCEID_3);
			}
			else {
				bindInstanceId = true;

				sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_INSTANCEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contentId);

				if (bindInstanceId) {
					queryPos.add(instanceId);
				}

				list = (List<FormSendRecordField>)QueryUtil.list(
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
	 * Returns the first form send record field in the ordered set where contentId = &#63; and instanceId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByContentAndInstanceId_First(
			long contentId, String instanceId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField =
			fetchByContentAndInstanceId_First(
				contentId, instanceId, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contentId=");
		sb.append(contentId);

		sb.append(", instanceId=");
		sb.append(instanceId);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the first form send record field in the ordered set where contentId = &#63; and instanceId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByContentAndInstanceId_First(
		long contentId, String instanceId,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		List<FormSendRecordField> list = findByContentAndInstanceId(
			contentId, instanceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form send record field in the ordered set where contentId = &#63; and instanceId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field
	 * @throws NoSuchFormSendRecordFieldException if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField findByContentAndInstanceId_Last(
			long contentId, String instanceId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField =
			fetchByContentAndInstanceId_Last(
				contentId, instanceId, orderByComparator);

		if (formSendRecordField != null) {
			return formSendRecordField;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contentId=");
		sb.append(contentId);

		sb.append(", instanceId=");
		sb.append(instanceId);

		sb.append("}");

		throw new NoSuchFormSendRecordFieldException(sb.toString());
	}

	/**
	 * Returns the last form send record field in the ordered set where contentId = &#63; and instanceId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form send record field, or <code>null</code> if a matching form send record field could not be found
	 */
	@Override
	public FormSendRecordField fetchByContentAndInstanceId_Last(
		long contentId, String instanceId,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		int count = countByContentAndInstanceId(contentId, instanceId);

		if (count == 0) {
			return null;
		}

		List<FormSendRecordField> list = findByContentAndInstanceId(
			contentId, instanceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form send record fields before and after the current form send record field in the ordered set where contentId = &#63; and instanceId = &#63;.
	 *
	 * @param formSendRecordFieldId the primary key of the current form send record field
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form send record field
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField[] findByContentAndInstanceId_PrevAndNext(
			long formSendRecordFieldId, long contentId, String instanceId,
			OrderByComparator<FormSendRecordField> orderByComparator)
		throws NoSuchFormSendRecordFieldException {

		instanceId = Objects.toString(instanceId, "");

		FormSendRecordField formSendRecordField = findByPrimaryKey(
			formSendRecordFieldId);

		Session session = null;

		try {
			session = openSession();

			FormSendRecordField[] array = new FormSendRecordFieldImpl[3];

			array[0] = getByContentAndInstanceId_PrevAndNext(
				session, formSendRecordField, contentId, instanceId,
				orderByComparator, true);

			array[1] = formSendRecordField;

			array[2] = getByContentAndInstanceId_PrevAndNext(
				session, formSendRecordField, contentId, instanceId,
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

	protected FormSendRecordField getByContentAndInstanceId_PrevAndNext(
		Session session, FormSendRecordField formSendRecordField,
		long contentId, String instanceId,
		OrderByComparator<FormSendRecordField> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMSENDRECORDFIELD_WHERE);

		sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_CONTENTID_2);

		boolean bindInstanceId = false;

		if (instanceId.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_INSTANCEID_3);
		}
		else {
			bindInstanceId = true;

			sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_INSTANCEID_2);
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
			sb.append(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(contentId);

		if (bindInstanceId) {
			queryPos.add(instanceId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formSendRecordField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormSendRecordField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form send record fields where contentId = &#63; and instanceId = &#63; from the database.
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 */
	@Override
	public void removeByContentAndInstanceId(
		long contentId, String instanceId) {

		for (FormSendRecordField formSendRecordField :
				findByContentAndInstanceId(
					contentId, instanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(formSendRecordField);
		}
	}

	/**
	 * Returns the number of form send record fields where contentId = &#63; and instanceId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param instanceId the instance ID
	 * @return the number of matching form send record fields
	 */
	@Override
	public int countByContentAndInstanceId(long contentId, String instanceId) {
		instanceId = Objects.toString(instanceId, "");

		FinderPath finderPath = _finderPathCountByContentAndInstanceId;

		Object[] finderArgs = new Object[] {contentId, instanceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMSENDRECORDFIELD_WHERE);

			sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_CONTENTID_2);

			boolean bindInstanceId = false;

			if (instanceId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_INSTANCEID_3);
			}
			else {
				bindInstanceId = true;

				sb.append(_FINDER_COLUMN_CONTENTANDINSTANCEID_INSTANCEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contentId);

				if (bindInstanceId) {
					queryPos.add(instanceId);
				}

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
		_FINDER_COLUMN_CONTENTANDINSTANCEID_CONTENTID_2 =
			"formSendRecordField.contentId = ? AND ";

	private static final String
		_FINDER_COLUMN_CONTENTANDINSTANCEID_INSTANCEID_2 =
			"formSendRecordField.instanceId = ?";

	private static final String
		_FINDER_COLUMN_CONTENTANDINSTANCEID_INSTANCEID_3 =
			"(formSendRecordField.instanceId IS NULL OR formSendRecordField.instanceId = '')";

	public FormSendRecordFieldPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FormSendRecordField.class);

		setModelImplClass(FormSendRecordFieldImpl.class);
		setModelPKClass(long.class);

		setTable(FormSendRecordFieldTable.INSTANCE);
	}

	/**
	 * Caches the form send record field in the entity cache if it is enabled.
	 *
	 * @param formSendRecordField the form send record field
	 */
	@Override
	public void cacheResult(FormSendRecordField formSendRecordField) {
		entityCache.putResult(
			FormSendRecordFieldImpl.class, formSendRecordField.getPrimaryKey(),
			formSendRecordField);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				formSendRecordField.getUuid(), formSendRecordField.getGroupId()
			},
			formSendRecordField);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the form send record fields in the entity cache if it is enabled.
	 *
	 * @param formSendRecordFields the form send record fields
	 */
	@Override
	public void cacheResult(List<FormSendRecordField> formSendRecordFields) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (formSendRecordFields.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FormSendRecordField formSendRecordField : formSendRecordFields) {
			if (entityCache.getResult(
					FormSendRecordFieldImpl.class,
					formSendRecordField.getPrimaryKey()) == null) {

				cacheResult(formSendRecordField);
			}
		}
	}

	/**
	 * Clears the cache for all form send record fields.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FormSendRecordFieldImpl.class);

		finderCache.clearCache(FormSendRecordFieldImpl.class);
	}

	/**
	 * Clears the cache for the form send record field.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FormSendRecordField formSendRecordField) {
		entityCache.removeResult(
			FormSendRecordFieldImpl.class, formSendRecordField);
	}

	@Override
	public void clearCache(List<FormSendRecordField> formSendRecordFields) {
		for (FormSendRecordField formSendRecordField : formSendRecordFields) {
			entityCache.removeResult(
				FormSendRecordFieldImpl.class, formSendRecordField);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FormSendRecordFieldImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FormSendRecordFieldImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FormSendRecordFieldModelImpl formSendRecordFieldModelImpl) {

		Object[] args = new Object[] {
			formSendRecordFieldModelImpl.getUuid(),
			formSendRecordFieldModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, formSendRecordFieldModelImpl);
	}

	/**
	 * Creates a new form send record field with the primary key. Does not add the form send record field to the database.
	 *
	 * @param formSendRecordFieldId the primary key for the new form send record field
	 * @return the new form send record field
	 */
	@Override
	public FormSendRecordField create(long formSendRecordFieldId) {
		FormSendRecordField formSendRecordField = new FormSendRecordFieldImpl();

		formSendRecordField.setNew(true);
		formSendRecordField.setPrimaryKey(formSendRecordFieldId);

		String uuid = PortalUUIDUtil.generate();

		formSendRecordField.setUuid(uuid);

		formSendRecordField.setCompanyId(CompanyThreadLocal.getCompanyId());

		return formSendRecordField;
	}

	/**
	 * Removes the form send record field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formSendRecordFieldId the primary key of the form send record field
	 * @return the form send record field that was removed
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField remove(long formSendRecordFieldId)
		throws NoSuchFormSendRecordFieldException {

		return remove((Serializable)formSendRecordFieldId);
	}

	/**
	 * Removes the form send record field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form send record field
	 * @return the form send record field that was removed
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField remove(Serializable primaryKey)
		throws NoSuchFormSendRecordFieldException {

		Session session = null;

		try {
			session = openSession();

			FormSendRecordField formSendRecordField =
				(FormSendRecordField)session.get(
					FormSendRecordFieldImpl.class, primaryKey);

			if (formSendRecordField == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormSendRecordFieldException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(formSendRecordField);
		}
		catch (NoSuchFormSendRecordFieldException noSuchEntityException) {
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
	protected FormSendRecordField removeImpl(
		FormSendRecordField formSendRecordField) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formSendRecordField)) {
				formSendRecordField = (FormSendRecordField)session.get(
					FormSendRecordFieldImpl.class,
					formSendRecordField.getPrimaryKeyObj());
			}

			if (formSendRecordField != null) {
				session.delete(formSendRecordField);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (formSendRecordField != null) {
			clearCache(formSendRecordField);
		}

		return formSendRecordField;
	}

	@Override
	public FormSendRecordField updateImpl(
		FormSendRecordField formSendRecordField) {

		boolean isNew = formSendRecordField.isNew();

		if (!(formSendRecordField instanceof FormSendRecordFieldModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(formSendRecordField.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					formSendRecordField);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in formSendRecordField proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FormSendRecordField implementation " +
					formSendRecordField.getClass());
		}

		FormSendRecordFieldModelImpl formSendRecordFieldModelImpl =
			(FormSendRecordFieldModelImpl)formSendRecordField;

		if (Validator.isNull(formSendRecordField.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			formSendRecordField.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (formSendRecordField.getCreateDate() == null)) {
			if (serviceContext == null) {
				formSendRecordField.setCreateDate(date);
			}
			else {
				formSendRecordField.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!formSendRecordFieldModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				formSendRecordField.setModifiedDate(date);
			}
			else {
				formSendRecordField.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(formSendRecordField);
			}
			else {
				formSendRecordField = (FormSendRecordField)session.merge(
					formSendRecordField);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FormSendRecordFieldImpl.class, formSendRecordFieldModelImpl, false,
			true);

		cacheUniqueFindersCache(formSendRecordFieldModelImpl);

		if (isNew) {
			formSendRecordField.setNew(false);
		}

		formSendRecordField.resetOriginalValues();

		return formSendRecordField;
	}

	/**
	 * Returns the form send record field with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form send record field
	 * @return the form send record field
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormSendRecordFieldException {

		FormSendRecordField formSendRecordField = fetchByPrimaryKey(primaryKey);

		if (formSendRecordField == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormSendRecordFieldException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return formSendRecordField;
	}

	/**
	 * Returns the form send record field with the primary key or throws a <code>NoSuchFormSendRecordFieldException</code> if it could not be found.
	 *
	 * @param formSendRecordFieldId the primary key of the form send record field
	 * @return the form send record field
	 * @throws NoSuchFormSendRecordFieldException if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField findByPrimaryKey(long formSendRecordFieldId)
		throws NoSuchFormSendRecordFieldException {

		return findByPrimaryKey((Serializable)formSendRecordFieldId);
	}

	/**
	 * Returns the form send record field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formSendRecordFieldId the primary key of the form send record field
	 * @return the form send record field, or <code>null</code> if a form send record field with the primary key could not be found
	 */
	@Override
	public FormSendRecordField fetchByPrimaryKey(long formSendRecordFieldId) {
		return fetchByPrimaryKey((Serializable)formSendRecordFieldId);
	}

	/**
	 * Returns all the form send record fields.
	 *
	 * @return the form send record fields
	 */
	@Override
	public List<FormSendRecordField> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form send record fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @return the range of form send record fields
	 */
	@Override
	public List<FormSendRecordField> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the form send record fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form send record fields
	 */
	@Override
	public List<FormSendRecordField> findAll(
		int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form send record fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormSendRecordFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form send record fields
	 * @param end the upper bound of the range of form send record fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of form send record fields
	 */
	@Override
	public List<FormSendRecordField> findAll(
		int start, int end,
		OrderByComparator<FormSendRecordField> orderByComparator,
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

		List<FormSendRecordField> list = null;

		if (useFinderCache) {
			list = (List<FormSendRecordField>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FORMSENDRECORDFIELD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FORMSENDRECORDFIELD;

				sql = sql.concat(FormSendRecordFieldModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FormSendRecordField>)QueryUtil.list(
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
	 * Removes all the form send record fields from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FormSendRecordField formSendRecordField : findAll()) {
			remove(formSendRecordField);
		}
	}

	/**
	 * Returns the number of form send record fields.
	 *
	 * @return the number of form send record fields
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_FORMSENDRECORDFIELD);

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
		return "formSendRecordFieldId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FORMSENDRECORDFIELD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FormSendRecordFieldModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the form send record field persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByAssetEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAssetEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"assetEntryId", "status"}, true);

		_finderPathWithoutPaginationFindByAssetEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAssetEntryId",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"assetEntryId", "status"}, true);

		_finderPathCountByAssetEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAssetEntryId",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"assetEntryId", "status"}, false);

		_finderPathWithPaginationFindByContentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"contentId"}, true);

		_finderPathWithoutPaginationFindByContentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContentId",
			new String[] {Long.class.getName()}, new String[] {"contentId"},
			true);

		_finderPathCountByContentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContentId",
			new String[] {Long.class.getName()}, new String[] {"contentId"},
			false);

		_finderPathWithPaginationFindByContentAndInstanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContentAndInstanceId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"contentId", "instanceId"}, true);

		_finderPathWithoutPaginationFindByContentAndInstanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContentAndInstanceId",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"contentId", "instanceId"}, true);

		_finderPathCountByContentAndInstanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContentAndInstanceId",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"contentId", "instanceId"}, false);

		FormSendRecordFieldUtil.setPersistence(this);
	}

	public void destroy() {
		FormSendRecordFieldUtil.setPersistence(null);

		entityCache.removeCache(FormSendRecordFieldImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FORMSENDRECORDFIELD =
		"SELECT formSendRecordField FROM FormSendRecordField formSendRecordField";

	private static final String _SQL_SELECT_FORMSENDRECORDFIELD_WHERE =
		"SELECT formSendRecordField FROM FormSendRecordField formSendRecordField WHERE ";

	private static final String _SQL_COUNT_FORMSENDRECORDFIELD =
		"SELECT COUNT(formSendRecordField) FROM FormSendRecordField formSendRecordField";

	private static final String _SQL_COUNT_FORMSENDRECORDFIELD_WHERE =
		"SELECT COUNT(formSendRecordField) FROM FormSendRecordField formSendRecordField WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "formSendRecordField.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FormSendRecordField exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FormSendRecordField exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FormSendRecordFieldPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}