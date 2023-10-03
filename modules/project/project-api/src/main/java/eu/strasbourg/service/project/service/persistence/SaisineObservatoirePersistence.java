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

import eu.strasbourg.service.project.exception.NoSuchSaisineObservatoireException;
import eu.strasbourg.service.project.model.SaisineObservatoire;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the saisine observatoire service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see SaisineObservatoireUtil
 * @generated
 */
@ProviderType
public interface SaisineObservatoirePersistence
	extends BasePersistence<SaisineObservatoire> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SaisineObservatoireUtil} to access the saisine observatoire persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the saisine observatoires where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching saisine observatoires
	 */
	public java.util.List<SaisineObservatoire> findByGroupId(long groupId);

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
	public java.util.List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

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
	public java.util.List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Returns the first saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

	/**
	 * Returns the last saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Returns the last saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

	/**
	 * Returns the saisine observatoires before and after the current saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param saisineObservatoireId the primary key of the current saisine observatoire
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public SaisineObservatoire[] findByGroupId_PrevAndNext(
			long saisineObservatoireId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Removes all the saisine observatoires where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of saisine observatoires where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching saisine observatoires
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching saisine observatoires
	 */
	public java.util.List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId);

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
	public java.util.List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end);

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
	public java.util.List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

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
	public java.util.List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire findByStatusAndGroupId_First(
			int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Returns the first saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire fetchByStatusAndGroupId_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

	/**
	 * Returns the last saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire findByStatusAndGroupId_Last(
			int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Returns the last saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire fetchByStatusAndGroupId_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

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
	public SaisineObservatoire[] findByStatusAndGroupId_PrevAndNext(
			long saisineObservatoireId, int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Removes all the saisine observatoires where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	public void removeByStatusAndGroupId(int status, long groupId);

	/**
	 * Returns the number of saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching saisine observatoires
	 */
	public int countByStatusAndGroupId(int status, long groupId);

	/**
	 * Returns all the saisine observatoires where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching saisine observatoires
	 */
	public java.util.List<SaisineObservatoire> findByPublikId(String publikId);

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
	public java.util.List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end);

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
	public java.util.List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

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
	public java.util.List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire findByPublikId_First(
			String publikId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Returns the first saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire fetchByPublikId_First(
		String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

	/**
	 * Returns the last saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire findByPublikId_Last(
			String publikId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Returns the last saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	public SaisineObservatoire fetchByPublikId_Last(
		String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

	/**
	 * Returns the saisine observatoires before and after the current saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param saisineObservatoireId the primary key of the current saisine observatoire
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public SaisineObservatoire[] findByPublikId_PrevAndNext(
			long saisineObservatoireId, String publikId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Removes all the saisine observatoires where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	public void removeByPublikId(String publikId);

	/**
	 * Returns the number of saisine observatoires where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching saisine observatoires
	 */
	public int countByPublikId(String publikId);

	/**
	 * Caches the saisine observatoire in the entity cache if it is enabled.
	 *
	 * @param saisineObservatoire the saisine observatoire
	 */
	public void cacheResult(SaisineObservatoire saisineObservatoire);

	/**
	 * Caches the saisine observatoires in the entity cache if it is enabled.
	 *
	 * @param saisineObservatoires the saisine observatoires
	 */
	public void cacheResult(
		java.util.List<SaisineObservatoire> saisineObservatoires);

	/**
	 * Creates a new saisine observatoire with the primary key. Does not add the saisine observatoire to the database.
	 *
	 * @param saisineObservatoireId the primary key for the new saisine observatoire
	 * @return the new saisine observatoire
	 */
	public SaisineObservatoire create(long saisineObservatoireId);

	/**
	 * Removes the saisine observatoire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire that was removed
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public SaisineObservatoire remove(long saisineObservatoireId)
		throws NoSuchSaisineObservatoireException;

	public SaisineObservatoire updateImpl(
		SaisineObservatoire saisineObservatoire);

	/**
	 * Returns the saisine observatoire with the primary key or throws a <code>NoSuchSaisineObservatoireException</code> if it could not be found.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	public SaisineObservatoire findByPrimaryKey(long saisineObservatoireId)
		throws NoSuchSaisineObservatoireException;

	/**
	 * Returns the saisine observatoire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire, or <code>null</code> if a saisine observatoire with the primary key could not be found
	 */
	public SaisineObservatoire fetchByPrimaryKey(long saisineObservatoireId);

	/**
	 * Returns all the saisine observatoires.
	 *
	 * @return the saisine observatoires
	 */
	public java.util.List<SaisineObservatoire> findAll();

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
	public java.util.List<SaisineObservatoire> findAll(int start, int end);

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
	public java.util.List<SaisineObservatoire> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator);

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
	public java.util.List<SaisineObservatoire> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaisineObservatoire>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the saisine observatoires from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of saisine observatoires.
	 *
	 * @return the number of saisine observatoires
	 */
	public int countAll();

}