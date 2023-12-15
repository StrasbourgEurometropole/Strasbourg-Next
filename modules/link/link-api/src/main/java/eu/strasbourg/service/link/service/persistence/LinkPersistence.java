/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.link.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.link.exception.NoSuchLinkException;
import eu.strasbourg.service.link.model.Link;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see LinkUtil
 * @generated
 */
@ProviderType
public interface LinkPersistence extends BasePersistence<Link> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinkUtil} to access the link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching links
	 */
	public java.util.List<Link> findByUuid(String uuid);

	/**
	 * Returns a range of all the links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of matching links
	 */
	public java.util.List<Link> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching links
	 */
	public java.util.List<Link> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns an ordered range of all the links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching links
	 */
	public java.util.List<Link> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public Link findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 */
	public Link fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns the last link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public Link findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 */
	public Link fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns the links before and after the current link in the ordered set where uuid = &#63;.
	 *
	 * @param linkId the primary key of the current link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public Link[] findByUuid_PrevAndNext(
			long linkId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Removes all the links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching links
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the link where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public Link findByUUID_G(String uuid, long groupId)
		throws NoSuchLinkException;

	/**
	 * Returns the link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link, or <code>null</code> if a matching link could not be found
	 */
	public Link fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link, or <code>null</code> if a matching link could not be found
	 */
	public Link fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the link where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the link that was removed
	 */
	public Link removeByUUID_G(String uuid, long groupId)
		throws NoSuchLinkException;

	/**
	 * Returns the number of links where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching links
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching links
	 */
	public java.util.List<Link> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of matching links
	 */
	public java.util.List<Link> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching links
	 */
	public java.util.List<Link> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns an ordered range of all the links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching links
	 */
	public java.util.List<Link> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public Link findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 */
	public Link fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns the last link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public Link findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 */
	public Link fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns the links before and after the current link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param linkId the primary key of the current link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public Link[] findByUuid_C_PrevAndNext(
			long linkId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Removes all the links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching links
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching links
	 */
	public java.util.List<Link> findByGroupId(long groupId);

	/**
	 * Returns a range of all the links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of matching links
	 */
	public java.util.List<Link> findByGroupId(long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching links
	 */
	public java.util.List<Link> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns an ordered range of all the links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching links
	 */
	public java.util.List<Link> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public Link findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the first link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 */
	public Link fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns the last link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public Link findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Returns the last link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 */
	public Link fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns the links before and after the current link in the ordered set where groupId = &#63;.
	 *
	 * @param linkId the primary key of the current link
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public Link[] findByGroupId_PrevAndNext(
			long linkId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Link>
				orderByComparator)
		throws NoSuchLinkException;

	/**
	 * Removes all the links where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching links
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the link in the entity cache if it is enabled.
	 *
	 * @param link the link
	 */
	public void cacheResult(Link link);

	/**
	 * Caches the links in the entity cache if it is enabled.
	 *
	 * @param links the links
	 */
	public void cacheResult(java.util.List<Link> links);

	/**
	 * Creates a new link with the primary key. Does not add the link to the database.
	 *
	 * @param linkId the primary key for the new link
	 * @return the new link
	 */
	public Link create(long linkId);

	/**
	 * Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the link
	 * @return the link that was removed
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public Link remove(long linkId) throws NoSuchLinkException;

	public Link updateImpl(Link link);

	/**
	 * Returns the link with the primary key or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link
	 * @return the link
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public Link findByPrimaryKey(long linkId) throws NoSuchLinkException;

	/**
	 * Returns the link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link
	 * @return the link, or <code>null</code> if a link with the primary key could not be found
	 */
	public Link fetchByPrimaryKey(long linkId);

	/**
	 * Returns all the links.
	 *
	 * @return the links
	 */
	public java.util.List<Link> findAll();

	/**
	 * Returns a range of all the links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of links
	 */
	public java.util.List<Link> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of links
	 */
	public java.util.List<Link> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator);

	/**
	 * Returns an ordered range of all the links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of links
	 */
	public java.util.List<Link> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Link>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of links.
	 *
	 * @return the number of links
	 */
	public int countAll();

}