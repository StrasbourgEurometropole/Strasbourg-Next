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

package eu.strasbourg.service.ejob.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.ejob.model.Offer;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the offer service. This utility wraps <code>eu.strasbourg.service.ejob.service.persistence.impl.OfferPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfferPersistence
 * @generated
 */
@ProviderType
public class OfferUtil {

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
	public static void clearCache(Offer offer) {
		getPersistence().clearCache(offer);
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
	public static Map<Serializable, Offer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Offer> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Offer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Offer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Offer update(Offer offer) {
		return getPersistence().update(offer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Offer update(Offer offer, ServiceContext serviceContext) {
		return getPersistence().update(offer, serviceContext);
	}

	/**
	 * Returns all the offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching offers
	 */
	public static List<Offer> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of matching offers
	 */
	public static List<Offer> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offers
	 */
	public static List<Offer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching offers
	 */
	public static List<Offer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offer> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findByUuid_First(
			String uuid, OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchByUuid_First(
		String uuid, OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findByUuid_Last(
			String uuid, OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchByUuid_Last(
		String uuid, OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the offers before and after the current offer in the ordered set where uuid = &#63;.
	 *
	 * @param offerId the primary key of the current offer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public static Offer[] findByUuid_PrevAndNext(
			long offerId, String uuid,
			OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByUuid_PrevAndNext(
			offerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the offers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching offers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the offer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchOfferException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the offer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the offer that was removed
	 */
	public static Offer removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of offers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching offers
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the offers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching offers
	 */
	public static List<Offer> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the offers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of matching offers
	 */
	public static List<Offer> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the offers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offers
	 */
	public static List<Offer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the offers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching offers
	 */
	public static List<Offer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Offer> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the offers before and after the current offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param offerId the primary key of the current offer
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public static Offer[] findByUuid_C_PrevAndNext(
			long offerId, String uuid, long companyId,
			OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByUuid_C_PrevAndNext(
			offerId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the offers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of offers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching offers
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the offers where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the matching offers
	 */
	public static List<Offer> findByPublicationDateAndStatus(
		Date publicationDate, int status) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status);
	}

	/**
	 * Returns a range of all the offers where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of matching offers
	 */
	public static List<Offer> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end);
	}

	/**
	 * Returns an ordered range of all the offers where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offers
	 */
	public static List<Offer> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the offers where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching offers
	 */
	public static List<Offer> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<Offer> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first offer in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findByPublicationDateAndStatus_First(
			Date publicationDate, int status,
			OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByPublicationDateAndStatus_First(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the first offer in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchByPublicationDateAndStatus_First(
		Date publicationDate, int status,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchByPublicationDateAndStatus_First(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findByPublicationDateAndStatus_Last(
			Date publicationDate, int status,
			OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByPublicationDateAndStatus_Last(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchByPublicationDateAndStatus_Last(
		Date publicationDate, int status,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchByPublicationDateAndStatus_Last(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the offers before and after the current offer in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param offerId the primary key of the current offer
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public static Offer[] findByPublicationDateAndStatus_PrevAndNext(
			long offerId, Date publicationDate, int status,
			OrderByComparator<Offer> orderByComparator)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByPublicationDateAndStatus_PrevAndNext(
			offerId, publicationDate, status, orderByComparator);
	}

	/**
	 * Removes all the offers where publicationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 */
	public static void removeByPublicationDateAndStatus(
		Date publicationDate, int status) {

		getPersistence().removeByPublicationDateAndStatus(
			publicationDate, status);
	}

	/**
	 * Returns the number of offers where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the number of matching offers
	 */
	public static int countByPublicationDateAndStatus(
		Date publicationDate, int status) {

		return getPersistence().countByPublicationDateAndStatus(
			publicationDate, status);
	}

	/**
	 * Caches the offer in the entity cache if it is enabled.
	 *
	 * @param offer the offer
	 */
	public static void cacheResult(Offer offer) {
		getPersistence().cacheResult(offer);
	}

	/**
	 * Caches the offers in the entity cache if it is enabled.
	 *
	 * @param offers the offers
	 */
	public static void cacheResult(List<Offer> offers) {
		getPersistence().cacheResult(offers);
	}

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param offerId the primary key for the new offer
	 * @return the new offer
	 */
	public static Offer create(long offerId) {
		return getPersistence().create(offerId);
	}

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer that was removed
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public static Offer remove(long offerId)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().remove(offerId);
	}

	public static Offer updateImpl(Offer offer) {
		return getPersistence().updateImpl(offer);
	}

	/**
	 * Returns the offer with the primary key or throws a <code>NoSuchOfferException</code> if it could not be found.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public static Offer findByPrimaryKey(long offerId)
		throws eu.strasbourg.service.ejob.exception.NoSuchOfferException {

		return getPersistence().findByPrimaryKey(offerId);
	}

	/**
	 * Returns the offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer, or <code>null</code> if a offer with the primary key could not be found
	 */
	public static Offer fetchByPrimaryKey(long offerId) {
		return getPersistence().fetchByPrimaryKey(offerId);
	}

	/**
	 * Returns all the offers.
	 *
	 * @return the offers
	 */
	public static List<Offer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of offers
	 */
	public static List<Offer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of offers
	 */
	public static List<Offer> findAll(
		int start, int end, OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of offers
	 */
	public static List<Offer> findAll(
		int start, int end, OrderByComparator<Offer> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the offers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static OfferPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OfferPersistence, OfferPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OfferPersistence.class);

		ServiceTracker<OfferPersistence, OfferPersistence> serviceTracker =
			new ServiceTracker<OfferPersistence, OfferPersistence>(
				bundle.getBundleContext(), OfferPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}