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

package eu.strasbourg.service.strasbourg.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import eu.strasbourg.service.strasbourg.exception.NoSuchStrasbourgException;
import eu.strasbourg.service.strasbourg.model.Strasbourg;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the strasbourg service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrasbourgUtil
 * @generated
 */
@ProviderType
public interface StrasbourgPersistence extends BasePersistence<Strasbourg> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StrasbourgUtil} to access the strasbourg persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the strasbourgs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching strasbourgs
	 */
	public java.util.List<Strasbourg> findByUuid(String uuid);

	/**
	 * Returns a range of all the strasbourgs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @return the range of matching strasbourgs
	 */
	public java.util.List<Strasbourg> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the strasbourgs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching strasbourgs
	 */
	public java.util.List<Strasbourg> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the strasbourgs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching strasbourgs
	 */
	public java.util.List<Strasbourg> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching strasbourg
	 * @throws NoSuchStrasbourgException if a matching strasbourg could not be found
	 */
	public Strasbourg findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
				orderByComparator)
		throws NoSuchStrasbourgException;

	/**
	 * Returns the first strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching strasbourg, or <code>null</code> if a matching strasbourg could not be found
	 */
	public Strasbourg fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
			orderByComparator);

	/**
	 * Returns the last strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching strasbourg
	 * @throws NoSuchStrasbourgException if a matching strasbourg could not be found
	 */
	public Strasbourg findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
				orderByComparator)
		throws NoSuchStrasbourgException;

	/**
	 * Returns the last strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching strasbourg, or <code>null</code> if a matching strasbourg could not be found
	 */
	public Strasbourg fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
			orderByComparator);

	/**
	 * Returns the strasbourgs before and after the current strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current strasbourg
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next strasbourg
	 * @throws NoSuchStrasbourgException if a strasbourg with the primary key could not be found
	 */
	public Strasbourg[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
				orderByComparator)
		throws NoSuchStrasbourgException;

	/**
	 * Removes all the strasbourgs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of strasbourgs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching strasbourgs
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the strasbourg in the entity cache if it is enabled.
	 *
	 * @param strasbourg the strasbourg
	 */
	public void cacheResult(Strasbourg strasbourg);

	/**
	 * Caches the strasbourgs in the entity cache if it is enabled.
	 *
	 * @param strasbourgs the strasbourgs
	 */
	public void cacheResult(java.util.List<Strasbourg> strasbourgs);

	/**
	 * Creates a new strasbourg with the primary key. Does not add the strasbourg to the database.
	 *
	 * @param id the primary key for the new strasbourg
	 * @return the new strasbourg
	 */
	public Strasbourg create(long id);

	/**
	 * Removes the strasbourg with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the strasbourg
	 * @return the strasbourg that was removed
	 * @throws NoSuchStrasbourgException if a strasbourg with the primary key could not be found
	 */
	public Strasbourg remove(long id) throws NoSuchStrasbourgException;

	public Strasbourg updateImpl(Strasbourg strasbourg);

	/**
	 * Returns the strasbourg with the primary key or throws a <code>NoSuchStrasbourgException</code> if it could not be found.
	 *
	 * @param id the primary key of the strasbourg
	 * @return the strasbourg
	 * @throws NoSuchStrasbourgException if a strasbourg with the primary key could not be found
	 */
	public Strasbourg findByPrimaryKey(long id)
		throws NoSuchStrasbourgException;

	/**
	 * Returns the strasbourg with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the strasbourg
	 * @return the strasbourg, or <code>null</code> if a strasbourg with the primary key could not be found
	 */
	public Strasbourg fetchByPrimaryKey(long id);

	/**
	 * Returns all the strasbourgs.
	 *
	 * @return the strasbourgs
	 */
	public java.util.List<Strasbourg> findAll();

	/**
	 * Returns a range of all the strasbourgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @return the range of strasbourgs
	 */
	public java.util.List<Strasbourg> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the strasbourgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of strasbourgs
	 */
	public java.util.List<Strasbourg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the strasbourgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of strasbourgs
	 */
	public java.util.List<Strasbourg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Strasbourg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the strasbourgs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of strasbourgs.
	 *
	 * @return the number of strasbourgs
	 */
	public int countAll();

}