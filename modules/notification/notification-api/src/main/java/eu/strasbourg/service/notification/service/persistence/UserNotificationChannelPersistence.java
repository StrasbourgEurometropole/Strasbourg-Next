/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.notification.exception.NoSuchUserNotificationChannelException;
import eu.strasbourg.service.notification.model.UserNotificationChannel;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user notification channel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationChannelUtil
 * @generated
 */
@ProviderType
public interface UserNotificationChannelPersistence
	extends BasePersistence<UserNotificationChannel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserNotificationChannelUtil} to access the user notification channel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user notification channels where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching user notification channels
	 */
	public java.util.List<UserNotificationChannel> findByPublikUserId(
		String publikUserId);

	/**
	 * Returns a range of all the user notification channels where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @return the range of matching user notification channels
	 */
	public java.util.List<UserNotificationChannel> findByPublikUserId(
		String publikUserId, int start, int end);

	/**
	 * Returns an ordered range of all the user notification channels where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification channels
	 */
	public java.util.List<UserNotificationChannel> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator);

	/**
	 * Returns an ordered range of all the user notification channels where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user notification channels
	 */
	public java.util.List<UserNotificationChannel> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification channel
	 * @throws NoSuchUserNotificationChannelException if a matching user notification channel could not be found
	 */
	public UserNotificationChannel findByPublikUserId_First(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException;

	/**
	 * Returns the first user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification channel, or <code>null</code> if a matching user notification channel could not be found
	 */
	public UserNotificationChannel fetchByPublikUserId_First(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator);

	/**
	 * Returns the last user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification channel
	 * @throws NoSuchUserNotificationChannelException if a matching user notification channel could not be found
	 */
	public UserNotificationChannel findByPublikUserId_Last(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException;

	/**
	 * Returns the last user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification channel, or <code>null</code> if a matching user notification channel could not be found
	 */
	public UserNotificationChannel fetchByPublikUserId_Last(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator);

	/**
	 * Returns the user notification channels before and after the current user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param userNotificationChannelPK the primary key of the current user notification channel
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification channel
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	public UserNotificationChannel[] findByPublikUserId_PrevAndNext(
			UserNotificationChannelPK userNotificationChannelPK,
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException;

	/**
	 * Removes all the user notification channels where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	public void removeByPublikUserId(String publikUserId);

	/**
	 * Returns the number of user notification channels where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching user notification channels
	 */
	public int countByPublikUserId(String publikUserId);

	/**
	 * Returns all the user notification channels where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching user notification channels
	 */
	public java.util.List<UserNotificationChannel> findByChannelId(
		long channelId);

	/**
	 * Returns a range of all the user notification channels where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @return the range of matching user notification channels
	 */
	public java.util.List<UserNotificationChannel> findByChannelId(
		long channelId, int start, int end);

	/**
	 * Returns an ordered range of all the user notification channels where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification channels
	 */
	public java.util.List<UserNotificationChannel> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator);

	/**
	 * Returns an ordered range of all the user notification channels where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user notification channels
	 */
	public java.util.List<UserNotificationChannel> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification channel
	 * @throws NoSuchUserNotificationChannelException if a matching user notification channel could not be found
	 */
	public UserNotificationChannel findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException;

	/**
	 * Returns the first user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification channel, or <code>null</code> if a matching user notification channel could not be found
	 */
	public UserNotificationChannel fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator);

	/**
	 * Returns the last user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification channel
	 * @throws NoSuchUserNotificationChannelException if a matching user notification channel could not be found
	 */
	public UserNotificationChannel findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException;

	/**
	 * Returns the last user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification channel, or <code>null</code> if a matching user notification channel could not be found
	 */
	public UserNotificationChannel fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator);

	/**
	 * Returns the user notification channels before and after the current user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param userNotificationChannelPK the primary key of the current user notification channel
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification channel
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	public UserNotificationChannel[] findByChannelId_PrevAndNext(
			UserNotificationChannelPK userNotificationChannelPK, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException;

	/**
	 * Removes all the user notification channels where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of user notification channels where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching user notification channels
	 */
	public int countByChannelId(long channelId);

	/**
	 * Caches the user notification channel in the entity cache if it is enabled.
	 *
	 * @param userNotificationChannel the user notification channel
	 */
	public void cacheResult(UserNotificationChannel userNotificationChannel);

	/**
	 * Caches the user notification channels in the entity cache if it is enabled.
	 *
	 * @param userNotificationChannels the user notification channels
	 */
	public void cacheResult(
		java.util.List<UserNotificationChannel> userNotificationChannels);

	/**
	 * Creates a new user notification channel with the primary key. Does not add the user notification channel to the database.
	 *
	 * @param userNotificationChannelPK the primary key for the new user notification channel
	 * @return the new user notification channel
	 */
	public UserNotificationChannel create(
		UserNotificationChannelPK userNotificationChannelPK);

	/**
	 * Removes the user notification channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationChannelPK the primary key of the user notification channel
	 * @return the user notification channel that was removed
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	public UserNotificationChannel remove(
			UserNotificationChannelPK userNotificationChannelPK)
		throws NoSuchUserNotificationChannelException;

	public UserNotificationChannel updateImpl(
		UserNotificationChannel userNotificationChannel);

	/**
	 * Returns the user notification channel with the primary key or throws a <code>NoSuchUserNotificationChannelException</code> if it could not be found.
	 *
	 * @param userNotificationChannelPK the primary key of the user notification channel
	 * @return the user notification channel
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	public UserNotificationChannel findByPrimaryKey(
			UserNotificationChannelPK userNotificationChannelPK)
		throws NoSuchUserNotificationChannelException;

	/**
	 * Returns the user notification channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userNotificationChannelPK the primary key of the user notification channel
	 * @return the user notification channel, or <code>null</code> if a user notification channel with the primary key could not be found
	 */
	public UserNotificationChannel fetchByPrimaryKey(
		UserNotificationChannelPK userNotificationChannelPK);

	/**
	 * Returns all the user notification channels.
	 *
	 * @return the user notification channels
	 */
	public java.util.List<UserNotificationChannel> findAll();

	/**
	 * Returns a range of all the user notification channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @return the range of user notification channels
	 */
	public java.util.List<UserNotificationChannel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user notification channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user notification channels
	 */
	public java.util.List<UserNotificationChannel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator);

	/**
	 * Returns an ordered range of all the user notification channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user notification channels
	 */
	public java.util.List<UserNotificationChannel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationChannel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user notification channels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user notification channels.
	 *
	 * @return the number of user notification channels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}