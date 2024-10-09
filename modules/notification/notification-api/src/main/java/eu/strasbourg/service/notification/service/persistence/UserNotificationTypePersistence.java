/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.notification.exception.NoSuchUserNotificationTypeException;
import eu.strasbourg.service.notification.model.UserNotificationType;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user notification type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationTypeUtil
 * @generated
 */
@ProviderType
public interface UserNotificationTypePersistence
	extends BasePersistence<UserNotificationType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserNotificationTypeUtil} to access the user notification type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user notification types where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching user notification types
	 */
	public java.util.List<UserNotificationType> findByPublikUserId(
		String publikUserId);

	/**
	 * Returns a range of all the user notification types where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @return the range of matching user notification types
	 */
	public java.util.List<UserNotificationType> findByPublikUserId(
		String publikUserId, int start, int end);

	/**
	 * Returns an ordered range of all the user notification types where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification types
	 */
	public java.util.List<UserNotificationType> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user notification types where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user notification types
	 */
	public java.util.List<UserNotificationType> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user notification type in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification type
	 * @throws NoSuchUserNotificationTypeException if a matching user notification type could not be found
	 */
	public UserNotificationType findByPublikUserId_First(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationType> orderByComparator)
		throws NoSuchUserNotificationTypeException;

	/**
	 * Returns the first user notification type in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification type, or <code>null</code> if a matching user notification type could not be found
	 */
	public UserNotificationType fetchByPublikUserId_First(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator);

	/**
	 * Returns the last user notification type in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification type
	 * @throws NoSuchUserNotificationTypeException if a matching user notification type could not be found
	 */
	public UserNotificationType findByPublikUserId_Last(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationType> orderByComparator)
		throws NoSuchUserNotificationTypeException;

	/**
	 * Returns the last user notification type in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification type, or <code>null</code> if a matching user notification type could not be found
	 */
	public UserNotificationType fetchByPublikUserId_Last(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator);

	/**
	 * Returns the user notification types before and after the current user notification type in the ordered set where publikUserId = &#63;.
	 *
	 * @param userNotificationTypePK the primary key of the current user notification type
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification type
	 * @throws NoSuchUserNotificationTypeException if a user notification type with the primary key could not be found
	 */
	public UserNotificationType[] findByPublikUserId_PrevAndNext(
			UserNotificationTypePK userNotificationTypePK, String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationType> orderByComparator)
		throws NoSuchUserNotificationTypeException;

	/**
	 * Removes all the user notification types where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	public void removeByPublikUserId(String publikUserId);

	/**
	 * Returns the number of user notification types where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching user notification types
	 */
	public int countByPublikUserId(String publikUserId);

	/**
	 * Returns all the user notification types where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching user notification types
	 */
	public java.util.List<UserNotificationType> findByTypeId(long typeId);

	/**
	 * Returns a range of all the user notification types where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @return the range of matching user notification types
	 */
	public java.util.List<UserNotificationType> findByTypeId(
		long typeId, int start, int end);

	/**
	 * Returns an ordered range of all the user notification types where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification types
	 */
	public java.util.List<UserNotificationType> findByTypeId(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user notification types where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user notification types
	 */
	public java.util.List<UserNotificationType> findByTypeId(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user notification type in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification type
	 * @throws NoSuchUserNotificationTypeException if a matching user notification type could not be found
	 */
	public UserNotificationType findByTypeId_First(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationType> orderByComparator)
		throws NoSuchUserNotificationTypeException;

	/**
	 * Returns the first user notification type in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification type, or <code>null</code> if a matching user notification type could not be found
	 */
	public UserNotificationType fetchByTypeId_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator);

	/**
	 * Returns the last user notification type in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification type
	 * @throws NoSuchUserNotificationTypeException if a matching user notification type could not be found
	 */
	public UserNotificationType findByTypeId_Last(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationType> orderByComparator)
		throws NoSuchUserNotificationTypeException;

	/**
	 * Returns the last user notification type in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification type, or <code>null</code> if a matching user notification type could not be found
	 */
	public UserNotificationType fetchByTypeId_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator);

	/**
	 * Returns the user notification types before and after the current user notification type in the ordered set where typeId = &#63;.
	 *
	 * @param userNotificationTypePK the primary key of the current user notification type
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification type
	 * @throws NoSuchUserNotificationTypeException if a user notification type with the primary key could not be found
	 */
	public UserNotificationType[] findByTypeId_PrevAndNext(
			UserNotificationTypePK userNotificationTypePK, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationType> orderByComparator)
		throws NoSuchUserNotificationTypeException;

	/**
	 * Removes all the user notification types where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	public void removeByTypeId(long typeId);

	/**
	 * Returns the number of user notification types where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching user notification types
	 */
	public int countByTypeId(long typeId);

	/**
	 * Caches the user notification type in the entity cache if it is enabled.
	 *
	 * @param userNotificationType the user notification type
	 */
	public void cacheResult(UserNotificationType userNotificationType);

	/**
	 * Caches the user notification types in the entity cache if it is enabled.
	 *
	 * @param userNotificationTypes the user notification types
	 */
	public void cacheResult(
		java.util.List<UserNotificationType> userNotificationTypes);

	/**
	 * Creates a new user notification type with the primary key. Does not add the user notification type to the database.
	 *
	 * @param userNotificationTypePK the primary key for the new user notification type
	 * @return the new user notification type
	 */
	public UserNotificationType create(
		UserNotificationTypePK userNotificationTypePK);

	/**
	 * Removes the user notification type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationTypePK the primary key of the user notification type
	 * @return the user notification type that was removed
	 * @throws NoSuchUserNotificationTypeException if a user notification type with the primary key could not be found
	 */
	public UserNotificationType remove(
			UserNotificationTypePK userNotificationTypePK)
		throws NoSuchUserNotificationTypeException;

	public UserNotificationType updateImpl(
		UserNotificationType userNotificationType);

	/**
	 * Returns the user notification type with the primary key or throws a <code>NoSuchUserNotificationTypeException</code> if it could not be found.
	 *
	 * @param userNotificationTypePK the primary key of the user notification type
	 * @return the user notification type
	 * @throws NoSuchUserNotificationTypeException if a user notification type with the primary key could not be found
	 */
	public UserNotificationType findByPrimaryKey(
			UserNotificationTypePK userNotificationTypePK)
		throws NoSuchUserNotificationTypeException;

	/**
	 * Returns the user notification type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userNotificationTypePK the primary key of the user notification type
	 * @return the user notification type, or <code>null</code> if a user notification type with the primary key could not be found
	 */
	public UserNotificationType fetchByPrimaryKey(
		UserNotificationTypePK userNotificationTypePK);

	/**
	 * Returns all the user notification types.
	 *
	 * @return the user notification types
	 */
	public java.util.List<UserNotificationType> findAll();

	/**
	 * Returns a range of all the user notification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @return the range of user notification types
	 */
	public java.util.List<UserNotificationType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user notification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user notification types
	 */
	public java.util.List<UserNotificationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user notification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user notification types
	 */
	public java.util.List<UserNotificationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserNotificationType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user notification types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user notification types.
	 *
	 * @return the number of user notification types
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}