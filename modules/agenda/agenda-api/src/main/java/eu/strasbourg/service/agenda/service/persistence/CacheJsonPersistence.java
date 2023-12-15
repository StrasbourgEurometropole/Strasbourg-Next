/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.agenda.exception.NoSuchCacheJsonException;
import eu.strasbourg.service.agenda.model.CacheJson;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cache json service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see CacheJsonUtil
 * @generated
 */
@ProviderType
public interface CacheJsonPersistence extends BasePersistence<CacheJson> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CacheJsonUtil} to access the cache json persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the cache json where eventId = &#63; or throws a <code>NoSuchCacheJsonException</code> if it could not be found.
	 *
	 * @param eventId the event ID
	 * @return the matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public CacheJson findByeventId(long eventId)
		throws NoSuchCacheJsonException;

	/**
	 * Returns the cache json where eventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @return the matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public CacheJson fetchByeventId(long eventId);

	/**
	 * Returns the cache json where eventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public CacheJson fetchByeventId(long eventId, boolean useFinderCache);

	/**
	 * Removes the cache json where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @return the cache json that was removed
	 */
	public CacheJson removeByeventId(long eventId)
		throws NoSuchCacheJsonException;

	/**
	 * Returns the number of cache jsons where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching cache jsons
	 */
	public int countByeventId(long eventId);

	/**
	 * Returns the cache json where eventId = &#63; and isApproved = &#63; or throws a <code>NoSuchCacheJsonException</code> if it could not be found.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @return the matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public CacheJson findByeventIdAndIsApproved(
			long eventId, boolean isApproved)
		throws NoSuchCacheJsonException;

	/**
	 * Returns the cache json where eventId = &#63; and isApproved = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @return the matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public CacheJson fetchByeventIdAndIsApproved(
		long eventId, boolean isApproved);

	/**
	 * Returns the cache json where eventId = &#63; and isApproved = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public CacheJson fetchByeventIdAndIsApproved(
		long eventId, boolean isApproved, boolean useFinderCache);

	/**
	 * Removes the cache json where eventId = &#63; and isApproved = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @return the cache json that was removed
	 */
	public CacheJson removeByeventIdAndIsApproved(
			long eventId, boolean isApproved)
		throws NoSuchCacheJsonException;

	/**
	 * Returns the number of cache jsons where eventId = &#63; and isApproved = &#63;.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @return the number of matching cache jsons
	 */
	public int countByeventIdAndIsApproved(long eventId, boolean isApproved);

	/**
	 * Returns all the cache jsons where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @return the matching cache jsons
	 */
	public java.util.List<CacheJson> findByisApproved(boolean isApproved);

	/**
	 * Returns a range of all the cache jsons where isApproved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param isApproved the is approved
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of matching cache jsons
	 */
	public java.util.List<CacheJson> findByisApproved(
		boolean isApproved, int start, int end);

	/**
	 * Returns an ordered range of all the cache jsons where isApproved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param isApproved the is approved
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache jsons
	 */
	public java.util.List<CacheJson> findByisApproved(
		boolean isApproved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cache jsons where isApproved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param isApproved the is approved
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cache jsons
	 */
	public java.util.List<CacheJson> findByisApproved(
		boolean isApproved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public CacheJson findByisApproved_First(
			boolean isApproved,
			com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
				orderByComparator)
		throws NoSuchCacheJsonException;

	/**
	 * Returns the first cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public CacheJson fetchByisApproved_First(
		boolean isApproved,
		com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
			orderByComparator);

	/**
	 * Returns the last cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public CacheJson findByisApproved_Last(
			boolean isApproved,
			com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
				orderByComparator)
		throws NoSuchCacheJsonException;

	/**
	 * Returns the last cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public CacheJson fetchByisApproved_Last(
		boolean isApproved,
		com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
			orderByComparator);

	/**
	 * Returns the cache jsons before and after the current cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param eventId the primary key of the current cache json
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public CacheJson[] findByisApproved_PrevAndNext(
			long eventId, boolean isApproved,
			com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
				orderByComparator)
		throws NoSuchCacheJsonException;

	/**
	 * Removes all the cache jsons where isApproved = &#63; from the database.
	 *
	 * @param isApproved the is approved
	 */
	public void removeByisApproved(boolean isApproved);

	/**
	 * Returns the number of cache jsons where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @return the number of matching cache jsons
	 */
	public int countByisApproved(boolean isApproved);

	/**
	 * Caches the cache json in the entity cache if it is enabled.
	 *
	 * @param cacheJson the cache json
	 */
	public void cacheResult(CacheJson cacheJson);

	/**
	 * Caches the cache jsons in the entity cache if it is enabled.
	 *
	 * @param cacheJsons the cache jsons
	 */
	public void cacheResult(java.util.List<CacheJson> cacheJsons);

	/**
	 * Creates a new cache json with the primary key. Does not add the cache json to the database.
	 *
	 * @param eventId the primary key for the new cache json
	 * @return the new cache json
	 */
	public CacheJson create(long eventId);

	/**
	 * Removes the cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the cache json
	 * @return the cache json that was removed
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public CacheJson remove(long eventId) throws NoSuchCacheJsonException;

	public CacheJson updateImpl(CacheJson cacheJson);

	/**
	 * Returns the cache json with the primary key or throws a <code>NoSuchCacheJsonException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cache json
	 * @return the cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public CacheJson findByPrimaryKey(long eventId)
		throws NoSuchCacheJsonException;

	/**
	 * Returns the cache json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cache json
	 * @return the cache json, or <code>null</code> if a cache json with the primary key could not be found
	 */
	public CacheJson fetchByPrimaryKey(long eventId);

	/**
	 * Returns all the cache jsons.
	 *
	 * @return the cache jsons
	 */
	public java.util.List<CacheJson> findAll();

	/**
	 * Returns a range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of cache jsons
	 */
	public java.util.List<CacheJson> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cache jsons
	 */
	public java.util.List<CacheJson> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cache jsons
	 */
	public java.util.List<CacheJson> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CacheJson>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cache jsons from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cache jsons.
	 *
	 * @return the number of cache jsons
	 */
	public int countAll();

}