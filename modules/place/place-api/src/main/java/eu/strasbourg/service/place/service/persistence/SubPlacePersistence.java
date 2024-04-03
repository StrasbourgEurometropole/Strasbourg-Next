/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.place.exception.NoSuchSubPlaceException;
import eu.strasbourg.service.place.model.SubPlace;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sub place service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see SubPlaceUtil
 * @generated
 */
@ProviderType
public interface SubPlacePersistence extends BasePersistence<SubPlace> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubPlaceUtil} to access the sub place persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sub places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sub places
	 */
	public java.util.List<SubPlace> findByUuid(String uuid);

	/**
	 * Returns a range of all the sub places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @return the range of matching sub places
	 */
	public java.util.List<SubPlace> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the sub places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub places
	 */
	public java.util.List<SubPlace> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub places
	 */
	public java.util.List<SubPlace> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sub place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub place
	 * @throws NoSuchSubPlaceException if a matching sub place could not be found
	 */
	public SubPlace findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
				orderByComparator)
		throws NoSuchSubPlaceException;

	/**
	 * Returns the first sub place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub place, or <code>null</code> if a matching sub place could not be found
	 */
	public SubPlace fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator);

	/**
	 * Returns the last sub place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub place
	 * @throws NoSuchSubPlaceException if a matching sub place could not be found
	 */
	public SubPlace findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
				orderByComparator)
		throws NoSuchSubPlaceException;

	/**
	 * Returns the last sub place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub place, or <code>null</code> if a matching sub place could not be found
	 */
	public SubPlace fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator);

	/**
	 * Returns the sub places before and after the current sub place in the ordered set where uuid = &#63;.
	 *
	 * @param subPlaceId the primary key of the current sub place
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub place
	 * @throws NoSuchSubPlaceException if a sub place with the primary key could not be found
	 */
	public SubPlace[] findByUuid_PrevAndNext(
			long subPlaceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
				orderByComparator)
		throws NoSuchSubPlaceException;

	/**
	 * Removes all the sub places where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sub places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sub places
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the sub places where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @return the matching sub places
	 */
	public java.util.List<SubPlace> findByPlaceId(long placeId);

	/**
	 * Returns a range of all the sub places where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @return the range of matching sub places
	 */
	public java.util.List<SubPlace> findByPlaceId(
		long placeId, int start, int end);

	/**
	 * Returns an ordered range of all the sub places where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub places
	 */
	public java.util.List<SubPlace> findByPlaceId(
		long placeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub places where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub places
	 */
	public java.util.List<SubPlace> findByPlaceId(
		long placeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sub place in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub place
	 * @throws NoSuchSubPlaceException if a matching sub place could not be found
	 */
	public SubPlace findByPlaceId_First(
			long placeId,
			com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
				orderByComparator)
		throws NoSuchSubPlaceException;

	/**
	 * Returns the first sub place in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub place, or <code>null</code> if a matching sub place could not be found
	 */
	public SubPlace fetchByPlaceId_First(
		long placeId,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator);

	/**
	 * Returns the last sub place in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub place
	 * @throws NoSuchSubPlaceException if a matching sub place could not be found
	 */
	public SubPlace findByPlaceId_Last(
			long placeId,
			com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
				orderByComparator)
		throws NoSuchSubPlaceException;

	/**
	 * Returns the last sub place in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub place, or <code>null</code> if a matching sub place could not be found
	 */
	public SubPlace fetchByPlaceId_Last(
		long placeId,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator);

	/**
	 * Returns the sub places before and after the current sub place in the ordered set where placeId = &#63;.
	 *
	 * @param subPlaceId the primary key of the current sub place
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub place
	 * @throws NoSuchSubPlaceException if a sub place with the primary key could not be found
	 */
	public SubPlace[] findByPlaceId_PrevAndNext(
			long subPlaceId, long placeId,
			com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
				orderByComparator)
		throws NoSuchSubPlaceException;

	/**
	 * Removes all the sub places where placeId = &#63; from the database.
	 *
	 * @param placeId the place ID
	 */
	public void removeByPlaceId(long placeId);

	/**
	 * Returns the number of sub places where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @return the number of matching sub places
	 */
	public int countByPlaceId(long placeId);

	/**
	 * Caches the sub place in the entity cache if it is enabled.
	 *
	 * @param subPlace the sub place
	 */
	public void cacheResult(SubPlace subPlace);

	/**
	 * Caches the sub places in the entity cache if it is enabled.
	 *
	 * @param subPlaces the sub places
	 */
	public void cacheResult(java.util.List<SubPlace> subPlaces);

	/**
	 * Creates a new sub place with the primary key. Does not add the sub place to the database.
	 *
	 * @param subPlaceId the primary key for the new sub place
	 * @return the new sub place
	 */
	public SubPlace create(long subPlaceId);

	/**
	 * Removes the sub place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subPlaceId the primary key of the sub place
	 * @return the sub place that was removed
	 * @throws NoSuchSubPlaceException if a sub place with the primary key could not be found
	 */
	public SubPlace remove(long subPlaceId) throws NoSuchSubPlaceException;

	public SubPlace updateImpl(SubPlace subPlace);

	/**
	 * Returns the sub place with the primary key or throws a <code>NoSuchSubPlaceException</code> if it could not be found.
	 *
	 * @param subPlaceId the primary key of the sub place
	 * @return the sub place
	 * @throws NoSuchSubPlaceException if a sub place with the primary key could not be found
	 */
	public SubPlace findByPrimaryKey(long subPlaceId)
		throws NoSuchSubPlaceException;

	/**
	 * Returns the sub place with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subPlaceId the primary key of the sub place
	 * @return the sub place, or <code>null</code> if a sub place with the primary key could not be found
	 */
	public SubPlace fetchByPrimaryKey(long subPlaceId);

	/**
	 * Returns all the sub places.
	 *
	 * @return the sub places
	 */
	public java.util.List<SubPlace> findAll();

	/**
	 * Returns a range of all the sub places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @return the range of sub places
	 */
	public java.util.List<SubPlace> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sub places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub places
	 */
	public java.util.List<SubPlace> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sub places
	 */
	public java.util.List<SubPlace> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubPlace>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sub places from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sub places.
	 *
	 * @return the number of sub places
	 */
	public int countAll();

}