/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.agenda.exception.NoSuchCampaignEventStatusException;
import eu.strasbourg.service.agenda.model.CampaignEventStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the campaign event status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see CampaignEventStatusUtil
 * @generated
 */
@ProviderType
public interface CampaignEventStatusPersistence
	extends BasePersistence<CampaignEventStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignEventStatusUtil} to access the campaign event status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the campaign event statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findByUuid(String uuid);

	/**
	 * Returns a range of all the campaign event statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @return the range of matching campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the campaign event statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the campaign event statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event status
	 * @throws NoSuchCampaignEventStatusException if a matching campaign event status could not be found
	 */
	public CampaignEventStatus findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException;

	/**
	 * Returns the first campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event status, or <code>null</code> if a matching campaign event status could not be found
	 */
	public CampaignEventStatus fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator);

	/**
	 * Returns the last campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event status
	 * @throws NoSuchCampaignEventStatusException if a matching campaign event status could not be found
	 */
	public CampaignEventStatus findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException;

	/**
	 * Returns the last campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event status, or <code>null</code> if a matching campaign event status could not be found
	 */
	public CampaignEventStatus fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator);

	/**
	 * Returns the campaign event statuses before and after the current campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param statusId the primary key of the current campaign event status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event status
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	public CampaignEventStatus[] findByUuid_PrevAndNext(
			long statusId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException;

	/**
	 * Removes all the campaign event statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of campaign event statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching campaign event statuses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the campaign event statuses where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the matching campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findByCampaignEventId(
		long campaignEventId);

	/**
	 * Returns a range of all the campaign event statuses where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @return the range of matching campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findByCampaignEventId(
		long campaignEventId, int start, int end);

	/**
	 * Returns an ordered range of all the campaign event statuses where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findByCampaignEventId(
		long campaignEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the campaign event statuses where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findByCampaignEventId(
		long campaignEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event status
	 * @throws NoSuchCampaignEventStatusException if a matching campaign event status could not be found
	 */
	public CampaignEventStatus findByCampaignEventId_First(
			long campaignEventId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException;

	/**
	 * Returns the first campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event status, or <code>null</code> if a matching campaign event status could not be found
	 */
	public CampaignEventStatus fetchByCampaignEventId_First(
		long campaignEventId,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator);

	/**
	 * Returns the last campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event status
	 * @throws NoSuchCampaignEventStatusException if a matching campaign event status could not be found
	 */
	public CampaignEventStatus findByCampaignEventId_Last(
			long campaignEventId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException;

	/**
	 * Returns the last campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event status, or <code>null</code> if a matching campaign event status could not be found
	 */
	public CampaignEventStatus fetchByCampaignEventId_Last(
		long campaignEventId,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator);

	/**
	 * Returns the campaign event statuses before and after the current campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param statusId the primary key of the current campaign event status
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event status
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	public CampaignEventStatus[] findByCampaignEventId_PrevAndNext(
			long statusId, long campaignEventId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException;

	/**
	 * Removes all the campaign event statuses where campaignEventId = &#63; from the database.
	 *
	 * @param campaignEventId the campaign event ID
	 */
	public void removeByCampaignEventId(long campaignEventId);

	/**
	 * Returns the number of campaign event statuses where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the number of matching campaign event statuses
	 */
	public int countByCampaignEventId(long campaignEventId);

	/**
	 * Caches the campaign event status in the entity cache if it is enabled.
	 *
	 * @param campaignEventStatus the campaign event status
	 */
	public void cacheResult(CampaignEventStatus campaignEventStatus);

	/**
	 * Caches the campaign event statuses in the entity cache if it is enabled.
	 *
	 * @param campaignEventStatuses the campaign event statuses
	 */
	public void cacheResult(
		java.util.List<CampaignEventStatus> campaignEventStatuses);

	/**
	 * Creates a new campaign event status with the primary key. Does not add the campaign event status to the database.
	 *
	 * @param statusId the primary key for the new campaign event status
	 * @return the new campaign event status
	 */
	public CampaignEventStatus create(long statusId);

	/**
	 * Removes the campaign event status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statusId the primary key of the campaign event status
	 * @return the campaign event status that was removed
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	public CampaignEventStatus remove(long statusId)
		throws NoSuchCampaignEventStatusException;

	public CampaignEventStatus updateImpl(
		CampaignEventStatus campaignEventStatus);

	/**
	 * Returns the campaign event status with the primary key or throws a <code>NoSuchCampaignEventStatusException</code> if it could not be found.
	 *
	 * @param statusId the primary key of the campaign event status
	 * @return the campaign event status
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	public CampaignEventStatus findByPrimaryKey(long statusId)
		throws NoSuchCampaignEventStatusException;

	/**
	 * Returns the campaign event status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statusId the primary key of the campaign event status
	 * @return the campaign event status, or <code>null</code> if a campaign event status with the primary key could not be found
	 */
	public CampaignEventStatus fetchByPrimaryKey(long statusId);

	/**
	 * Returns all the campaign event statuses.
	 *
	 * @return the campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findAll();

	/**
	 * Returns a range of all the campaign event statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @return the range of campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the campaign event statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the campaign event statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of campaign event statuses
	 */
	public java.util.List<CampaignEventStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CampaignEventStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the campaign event statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of campaign event statuses.
	 *
	 * @return the number of campaign event statuses
	 */
	public int countAll();

}