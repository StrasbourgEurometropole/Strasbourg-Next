/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.notification.exception.NoSuchUserNotificationStatusException;
import eu.strasbourg.service.notification.model.UserNotificationStatus;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user notification status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationStatusUtil
 * @generated
 */
@ProviderType
public interface UserNotificationStatusPersistence
	extends BasePersistence<UserNotificationStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserNotificationStatusUtil} to access the user notification status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user notification statuses where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @return the matching user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findByNotificationId(
		long notificationId);

	/**
	 * Returns a range of all the user notification statuses where notificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param notificationId the notification ID
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @return the range of matching user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findByNotificationId(
		long notificationId, int start, int end);

	/**
	 * Returns an ordered range of all the user notification statuses where notificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param notificationId the notification ID
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findByNotificationId(
		long notificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user notification statuses where notificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param notificationId the notification ID
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findByNotificationId(
		long notificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user notification status in the ordered set where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification status
	 * @throws NoSuchUserNotificationStatusException if a matching user notification status could not be found
	 */
	public UserNotificationStatus findByNotificationId_First(
			long notificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationStatus> orderByComparator)
		throws NoSuchUserNotificationStatusException;

	/**
	 * Returns the first user notification status in the ordered set where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification status, or <code>null</code> if a matching user notification status could not be found
	 */
	public UserNotificationStatus fetchByNotificationId_First(
		long notificationId,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator);

	/**
	 * Returns the last user notification status in the ordered set where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification status
	 * @throws NoSuchUserNotificationStatusException if a matching user notification status could not be found
	 */
	public UserNotificationStatus findByNotificationId_Last(
			long notificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationStatus> orderByComparator)
		throws NoSuchUserNotificationStatusException;

	/**
	 * Returns the last user notification status in the ordered set where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification status, or <code>null</code> if a matching user notification status could not be found
	 */
	public UserNotificationStatus fetchByNotificationId_Last(
		long notificationId,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator);

	/**
	 * Returns the user notification statuses before and after the current user notification status in the ordered set where notificationId = &#63;.
	 *
	 * @param userNotificationStatusPK the primary key of the current user notification status
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification status
	 * @throws NoSuchUserNotificationStatusException if a user notification status with the primary key could not be found
	 */
	public UserNotificationStatus[] findByNotificationId_PrevAndNext(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationStatusPK userNotificationStatusPK,
			long notificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationStatus> orderByComparator)
		throws NoSuchUserNotificationStatusException;

	/**
	 * Removes all the user notification statuses where notificationId = &#63; from the database.
	 *
	 * @param notificationId the notification ID
	 */
	public void removeByNotificationId(long notificationId);

	/**
	 * Returns the number of user notification statuses where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @return the number of matching user notification statuses
	 */
	public int countByNotificationId(long notificationId);

	/**
	 * Returns all the user notification statuses where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findByPublikUserId(
		String publikUserId);

	/**
	 * Returns a range of all the user notification statuses where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @return the range of matching user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findByPublikUserId(
		String publikUserId, int start, int end);

	/**
	 * Returns an ordered range of all the user notification statuses where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user notification statuses where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user notification status in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification status
	 * @throws NoSuchUserNotificationStatusException if a matching user notification status could not be found
	 */
	public UserNotificationStatus findByPublikUserId_First(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationStatus> orderByComparator)
		throws NoSuchUserNotificationStatusException;

	/**
	 * Returns the first user notification status in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification status, or <code>null</code> if a matching user notification status could not be found
	 */
	public UserNotificationStatus fetchByPublikUserId_First(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator);

	/**
	 * Returns the last user notification status in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification status
	 * @throws NoSuchUserNotificationStatusException if a matching user notification status could not be found
	 */
	public UserNotificationStatus findByPublikUserId_Last(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationStatus> orderByComparator)
		throws NoSuchUserNotificationStatusException;

	/**
	 * Returns the last user notification status in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification status, or <code>null</code> if a matching user notification status could not be found
	 */
	public UserNotificationStatus fetchByPublikUserId_Last(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator);

	/**
	 * Returns the user notification statuses before and after the current user notification status in the ordered set where publikUserId = &#63;.
	 *
	 * @param userNotificationStatusPK the primary key of the current user notification status
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification status
	 * @throws NoSuchUserNotificationStatusException if a user notification status with the primary key could not be found
	 */
	public UserNotificationStatus[] findByPublikUserId_PrevAndNext(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationStatusPK userNotificationStatusPK,
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationStatus> orderByComparator)
		throws NoSuchUserNotificationStatusException;

	/**
	 * Removes all the user notification statuses where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	public void removeByPublikUserId(String publikUserId);

	/**
	 * Returns the number of user notification statuses where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching user notification statuses
	 */
	public int countByPublikUserId(String publikUserId);

	/**
	 * Caches the user notification status in the entity cache if it is enabled.
	 *
	 * @param userNotificationStatus the user notification status
	 */
	public void cacheResult(UserNotificationStatus userNotificationStatus);

	/**
	 * Caches the user notification statuses in the entity cache if it is enabled.
	 *
	 * @param userNotificationStatuses the user notification statuses
	 */
	public void cacheResult(
		java.util.List<UserNotificationStatus> userNotificationStatuses);

	/**
	 * Creates a new user notification status with the primary key. Does not add the user notification status to the database.
	 *
	 * @param userNotificationStatusPK the primary key for the new user notification status
	 * @return the new user notification status
	 */
	public UserNotificationStatus create(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationStatusPK userNotificationStatusPK);

	/**
	 * Removes the user notification status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationStatusPK the primary key of the user notification status
	 * @return the user notification status that was removed
	 * @throws NoSuchUserNotificationStatusException if a user notification status with the primary key could not be found
	 */
	public UserNotificationStatus remove(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationStatusPK userNotificationStatusPK)
		throws NoSuchUserNotificationStatusException;

	public UserNotificationStatus updateImpl(
		UserNotificationStatus userNotificationStatus);

	/**
	 * Returns the user notification status with the primary key or throws a <code>NoSuchUserNotificationStatusException</code> if it could not be found.
	 *
	 * @param userNotificationStatusPK the primary key of the user notification status
	 * @return the user notification status
	 * @throws NoSuchUserNotificationStatusException if a user notification status with the primary key could not be found
	 */
	public UserNotificationStatus findByPrimaryKey(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationStatusPK userNotificationStatusPK)
		throws NoSuchUserNotificationStatusException;

	/**
	 * Returns the user notification status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userNotificationStatusPK the primary key of the user notification status
	 * @return the user notification status, or <code>null</code> if a user notification status with the primary key could not be found
	 */
	public UserNotificationStatus fetchByPrimaryKey(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationStatusPK userNotificationStatusPK);

	/**
	 * Returns all the user notification statuses.
	 *
	 * @return the user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findAll();

	/**
	 * Returns a range of all the user notification statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @return the range of user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user notification statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user notification statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user notification statuses
	 */
	public java.util.List<UserNotificationStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user notification statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user notification statuses.
	 *
	 * @return the number of user notification statuses
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}