/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.SaisineObservatoire;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the saisine observatoire service. This utility wraps <code>eu.strasbourg.service.project.service.persistence.impl.SaisineObservatoirePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see SaisineObservatoirePersistence
 * @generated
 */
public class SaisineObservatoireUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SaisineObservatoire saisineObservatoire) {
		getPersistence().clearCache(saisineObservatoire);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SaisineObservatoire> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SaisineObservatoire> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SaisineObservatoire> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SaisineObservatoire> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SaisineObservatoire update(
		SaisineObservatoire saisineObservatoire) {

		return getPersistence().update(saisineObservatoire);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SaisineObservatoire update(
		SaisineObservatoire saisineObservatoire,
		ServiceContext serviceContext) {

		return getPersistence().update(saisineObservatoire, serviceContext);
	}

	/**
	 * Returns all the saisine observatoires where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the saisine observatoires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire findByGroupId_First(
			long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire fetchByGroupId_First(
		long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire findByGroupId_Last(
			long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire fetchByGroupId_Last(
		long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the saisine observatoires before and after the current saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param saisineObservatoireId the primary key of the current saisine observatoire
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public static SaisineObservatoire[] findByGroupId_PrevAndNext(
			long saisineObservatoireId, long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByGroupId_PrevAndNext(
			saisineObservatoireId, groupId, orderByComparator);
	}

	/**
	 * Removes all the saisine observatoires where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of saisine observatoires where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching saisine observatoires
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId) {

		return getPersistence().findByStatusAndGroupId(status, groupId);
	}

	/**
	 * Returns a range of all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire findByStatusAndGroupId_First(
			int status, long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByStatusAndGroupId_First(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire fetchByStatusAndGroupId_First(
		int status, long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().fetchByStatusAndGroupId_First(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire findByStatusAndGroupId_Last(
			int status, long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByStatusAndGroupId_Last(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire fetchByStatusAndGroupId_Last(
		int status, long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().fetchByStatusAndGroupId_Last(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the saisine observatoires before and after the current saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param saisineObservatoireId the primary key of the current saisine observatoire
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public static SaisineObservatoire[] findByStatusAndGroupId_PrevAndNext(
			long saisineObservatoireId, int status, long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByStatusAndGroupId_PrevAndNext(
			saisineObservatoireId, status, groupId, orderByComparator);
	}

	/**
	 * Removes all the saisine observatoires where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	public static void removeByStatusAndGroupId(int status, long groupId) {
		getPersistence().removeByStatusAndGroupId(status, groupId);
	}

	/**
	 * Returns the number of saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching saisine observatoires
	 */
	public static int countByStatusAndGroupId(int status, long groupId) {
		return getPersistence().countByStatusAndGroupId(status, groupId);
	}

	/**
	 * Returns all the saisine observatoires where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByPublikId(String publikId) {
		return getPersistence().findByPublikId(publikId);
	}

	/**
	 * Returns a range of all the saisine observatoires where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end) {

		return getPersistence().findByPublikId(publikId, start, end);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().findByPublikId(
			publikId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching saisine observatoires
	 */
	public static List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPublikId(
			publikId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire findByPublikId_First(
			String publikId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByPublikId_First(
			publikId, orderByComparator);
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire fetchByPublikId_First(
		String publikId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().fetchByPublikId_First(
			publikId, orderByComparator);
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire findByPublikId_Last(
			String publikId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByPublikId_Last(
			publikId, orderByComparator);
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public static SaisineObservatoire fetchByPublikId_Last(
		String publikId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().fetchByPublikId_Last(
			publikId, orderByComparator);
	}

	/**
	 * Returns the saisine observatoires before and after the current saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param saisineObservatoireId the primary key of the current saisine observatoire
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public static SaisineObservatoire[] findByPublikId_PrevAndNext(
			long saisineObservatoireId, String publikId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByPublikId_PrevAndNext(
			saisineObservatoireId, publikId, orderByComparator);
	}

	/**
	 * Removes all the saisine observatoires where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	public static void removeByPublikId(String publikId) {
		getPersistence().removeByPublikId(publikId);
	}

	/**
	 * Returns the number of saisine observatoires where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching saisine observatoires
	 */
	public static int countByPublikId(String publikId) {
		return getPersistence().countByPublikId(publikId);
	}

	/**
	 * Caches the saisine observatoire in the entity cache if it is enabled.
	 *
	 * @param saisineObservatoire the saisine observatoire
	 */
	public static void cacheResult(SaisineObservatoire saisineObservatoire) {
		getPersistence().cacheResult(saisineObservatoire);
	}

	/**
	 * Caches the saisine observatoires in the entity cache if it is enabled.
	 *
	 * @param saisineObservatoires the saisine observatoires
	 */
	public static void cacheResult(
		List<SaisineObservatoire> saisineObservatoires) {

		getPersistence().cacheResult(saisineObservatoires);
	}

	/**
	 * Creates a new saisine observatoire with the primary key. Does not add the saisine observatoire to the database.
	 *
	 * @param saisineObservatoireId the primary key for the new saisine observatoire
	 * @return the new saisine observatoire
	 */
	public static SaisineObservatoire create(long saisineObservatoireId) {
		return getPersistence().create(saisineObservatoireId);
	}

	/**
	 * Removes the saisine observatoire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire that was removed
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public static SaisineObservatoire remove(long saisineObservatoireId)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().remove(saisineObservatoireId);
	}

	public static SaisineObservatoire updateImpl(
		SaisineObservatoire saisineObservatoire) {

		return getPersistence().updateImpl(saisineObservatoire);
	}

	/**
	 * Returns the saisine observatoire with the primary key or throws a <code>NoSuchSaisineObservatoireException</code> if it could not be found.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public static SaisineObservatoire findByPrimaryKey(
			long saisineObservatoireId)
		throws eu.strasbourg.service.project.exception.
			NoSuchSaisineObservatoireException {

		return getPersistence().findByPrimaryKey(saisineObservatoireId);
	}

	/**
	 * Returns the saisine observatoire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire, or <code>null</code> if a saisine observatoire with the primary key could not be found
	 */
	public static SaisineObservatoire fetchByPrimaryKey(
		long saisineObservatoireId) {

		return getPersistence().fetchByPrimaryKey(saisineObservatoireId);
	}

	/**
	 * Returns all the saisine observatoires.
	 *
	 * @return the saisine observatoires
	 */
	public static List<SaisineObservatoire> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of saisine observatoires
	 */
	public static List<SaisineObservatoire> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of saisine observatoires
	 */
	public static List<SaisineObservatoire> findAll(
		int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of saisine observatoires
	 */
	public static List<SaisineObservatoire> findAll(
		int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the saisine observatoires from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of saisine observatoires.
	 *
	 * @return the number of saisine observatoires
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SaisineObservatoirePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		SaisineObservatoirePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile SaisineObservatoirePersistence _persistence;

}