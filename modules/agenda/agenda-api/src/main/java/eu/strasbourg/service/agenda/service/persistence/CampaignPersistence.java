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

package eu.strasbourg.service.agenda.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.agenda.exception.NoSuchCampaignException;
import eu.strasbourg.service.agenda.model.Campaign;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see CampaignUtil
 * @generated
 */
@ProviderType
public interface CampaignPersistence extends BasePersistence<Campaign> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignUtil} to access the campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Campaign> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the campaigns where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching campaigns
	 */
	public java.util.List<Campaign> findByUuid(String uuid);

	/**
	 * Returns a range of all the campaigns where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns
	 */
	public java.util.List<Campaign> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the campaigns where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns
	 */
	public java.util.List<Campaign> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns an ordered range of all the campaigns where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaigns
	 */
	public java.util.List<Campaign> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first campaign in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Returns the first campaign in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns the last campaign in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Returns the last campaign in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where uuid = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws NoSuchCampaignException if a campaign with the primary key could not be found
	 */
	public Campaign[] findByUuid_PrevAndNext(
			long campaignId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Removes all the campaigns where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of campaigns where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching campaigns
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the campaign where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCampaignException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByUUID_G(String uuid, long groupId)
		throws NoSuchCampaignException;

	/**
	 * Returns the campaign where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the campaign where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the campaign where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the campaign that was removed
	 */
	public Campaign removeByUUID_G(String uuid, long groupId)
		throws NoSuchCampaignException;

	/**
	 * Returns the number of campaigns where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching campaigns
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the campaigns where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching campaigns
	 */
	public java.util.List<Campaign> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the campaigns where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns
	 */
	public java.util.List<Campaign> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the campaigns where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns
	 */
	public java.util.List<Campaign> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns an ordered range of all the campaigns where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaigns
	 */
	public java.util.List<Campaign> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Returns the first campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns the last campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Returns the last campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws NoSuchCampaignException if a campaign with the primary key could not be found
	 */
	public Campaign[] findByUuid_C_PrevAndNext(
			long campaignId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Removes all the campaigns where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of campaigns where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching campaigns
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the campaigns where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching campaigns
	 */
	public java.util.List<Campaign> findByTitle(String title);

	/**
	 * Returns a range of all the campaigns where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns
	 */
	public java.util.List<Campaign> findByTitle(
		String title, int start, int end);

	/**
	 * Returns an ordered range of all the campaigns where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns
	 */
	public java.util.List<Campaign> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns an ordered range of all the campaigns where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaigns
	 */
	public java.util.List<Campaign> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first campaign in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Returns the first campaign in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns the last campaign in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Returns the last campaign in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where title = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws NoSuchCampaignException if a campaign with the primary key could not be found
	 */
	public Campaign[] findByTitle_PrevAndNext(
			long campaignId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Removes all the campaigns where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of campaigns where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching campaigns
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the campaigns where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching campaigns
	 */
	public java.util.List<Campaign> findByGroupId(long groupId);

	/**
	 * Returns a range of all the campaigns where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns
	 */
	public java.util.List<Campaign> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the campaigns where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns
	 */
	public java.util.List<Campaign> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns an ordered range of all the campaigns where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaigns
	 */
	public java.util.List<Campaign> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first campaign in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Returns the first campaign in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns the last campaign in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws NoSuchCampaignException if a matching campaign could not be found
	 */
	public Campaign findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Returns the last campaign in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public Campaign fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where groupId = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws NoSuchCampaignException if a campaign with the primary key could not be found
	 */
	public Campaign[] findByGroupId_PrevAndNext(
			long campaignId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Campaign>
				orderByComparator)
		throws NoSuchCampaignException;

	/**
	 * Removes all the campaigns where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of campaigns where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching campaigns
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the campaign in the entity cache if it is enabled.
	 *
	 * @param campaign the campaign
	 */
	public void cacheResult(Campaign campaign);

	/**
	 * Caches the campaigns in the entity cache if it is enabled.
	 *
	 * @param campaigns the campaigns
	 */
	public void cacheResult(java.util.List<Campaign> campaigns);

	/**
	 * Creates a new campaign with the primary key. Does not add the campaign to the database.
	 *
	 * @param campaignId the primary key for the new campaign
	 * @return the new campaign
	 */
	public Campaign create(long campaignId);

	/**
	 * Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign that was removed
	 * @throws NoSuchCampaignException if a campaign with the primary key could not be found
	 */
	public Campaign remove(long campaignId) throws NoSuchCampaignException;

	public Campaign updateImpl(Campaign campaign);

	/**
	 * Returns the campaign with the primary key or throws a <code>NoSuchCampaignException</code> if it could not be found.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign
	 * @throws NoSuchCampaignException if a campaign with the primary key could not be found
	 */
	public Campaign findByPrimaryKey(long campaignId)
		throws NoSuchCampaignException;

	/**
	 * Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	 */
	public Campaign fetchByPrimaryKey(long campaignId);

	/**
	 * Returns all the campaigns.
	 *
	 * @return the campaigns
	 */
	public java.util.List<Campaign> findAll();

	/**
	 * Returns a range of all the campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of campaigns
	 */
	public java.util.List<Campaign> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaigns
	 */
	public java.util.List<Campaign> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator);

	/**
	 * Returns an ordered range of all the campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of campaigns
	 */
	public java.util.List<Campaign> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the campaigns from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of campaigns.
	 *
	 * @return the number of campaigns
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}