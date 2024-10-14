/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.favorite.exception.NoSuchFavoriteException;
import eu.strasbourg.service.favorite.model.Favorite;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the favorite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see FavoriteUtil
 * @generated
 */
@ProviderType
public interface FavoritePersistence extends BasePersistence<Favorite> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FavoriteUtil} to access the favorite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the favorites where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching favorites
	 */
	public java.util.List<Favorite> findByPublikUserId(String publikUserId);

	/**
	 * Returns a range of all the favorites where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of matching favorites
	 */
	public java.util.List<Favorite> findByPublikUserId(
		String publikUserId, int start, int end);

	/**
	 * Returns an ordered range of all the favorites where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching favorites
	 */
	public java.util.List<Favorite> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the favorites where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching favorites
	 */
	public java.util.List<Favorite> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByPublikUserId_First(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Returns the first favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByPublikUserId_First(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns the last favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByPublikUserId_Last(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Returns the last favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByPublikUserId_Last(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns the favorites before and after the current favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param favoriteId the primary key of the current favorite
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	public Favorite[] findByPublikUserId_PrevAndNext(
			long favoriteId, String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Removes all the favorites where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	public void removeByPublikUserId(String publikUserId);

	/**
	 * Returns the number of favorites where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching favorites
	 */
	public int countByPublikUserId(String publikUserId);

	/**
	 * Returns the favorite where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63; or throws a <code>NoSuchFavoriteException</code> if it could not be found.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @return the matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByAllAttributes(
			String publikUserId, String title, long typeId, long entityId)
		throws NoSuchFavoriteException;

	/**
	 * Returns the favorite where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByAllAttributes(
		String publikUserId, String title, long typeId, long entityId);

	/**
	 * Returns the favorite where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByAllAttributes(
		String publikUserId, String title, long typeId, long entityId,
		boolean useFinderCache);

	/**
	 * Removes the favorite where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @return the favorite that was removed
	 */
	public Favorite removeByAllAttributes(
			String publikUserId, String title, long typeId, long entityId)
		throws NoSuchFavoriteException;

	/**
	 * Returns the number of favorites where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @return the number of matching favorites
	 */
	public int countByAllAttributes(
		String publikUserId, String title, long typeId, long entityId);

	/**
	 * Returns all the favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @return the matching favorites
	 */
	public java.util.List<Favorite> findByEntityIdAndTypeId(
		long entityId, long typeId);

	/**
	 * Returns a range of all the favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of matching favorites
	 */
	public java.util.List<Favorite> findByEntityIdAndTypeId(
		long entityId, long typeId, int start, int end);

	/**
	 * Returns an ordered range of all the favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching favorites
	 */
	public java.util.List<Favorite> findByEntityIdAndTypeId(
		long entityId, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching favorites
	 */
	public java.util.List<Favorite> findByEntityIdAndTypeId(
		long entityId, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByEntityIdAndTypeId_First(
			long entityId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Returns the first favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByEntityIdAndTypeId_First(
		long entityId, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns the last favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByEntityIdAndTypeId_Last(
			long entityId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Returns the last favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByEntityIdAndTypeId_Last(
		long entityId, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns the favorites before and after the current favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param favoriteId the primary key of the current favorite
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	public Favorite[] findByEntityIdAndTypeId_PrevAndNext(
			long favoriteId, long entityId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Removes all the favorites where entityId = &#63; and typeId = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 */
	public void removeByEntityIdAndTypeId(long entityId, long typeId);

	/**
	 * Returns the number of favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @return the number of matching favorites
	 */
	public int countByEntityIdAndTypeId(long entityId, long typeId);

	/**
	 * Returns all the favorites where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @return the matching favorites
	 */
	public java.util.List<Favorite> findByGroupIdEntityIdAndTypeId(
		long entityGroupId, long entityId, long typeId);

	/**
	 * Returns a range of all the favorites where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of matching favorites
	 */
	public java.util.List<Favorite> findByGroupIdEntityIdAndTypeId(
		long entityGroupId, long entityId, long typeId, int start, int end);

	/**
	 * Returns an ordered range of all the favorites where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching favorites
	 */
	public java.util.List<Favorite> findByGroupIdEntityIdAndTypeId(
		long entityGroupId, long entityId, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the favorites where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching favorites
	 */
	public java.util.List<Favorite> findByGroupIdEntityIdAndTypeId(
		long entityGroupId, long entityId, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first favorite in the ordered set where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByGroupIdEntityIdAndTypeId_First(
			long entityGroupId, long entityId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Returns the first favorite in the ordered set where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByGroupIdEntityIdAndTypeId_First(
		long entityGroupId, long entityId, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns the last favorite in the ordered set where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByGroupIdEntityIdAndTypeId_Last(
			long entityGroupId, long entityId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Returns the last favorite in the ordered set where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByGroupIdEntityIdAndTypeId_Last(
		long entityGroupId, long entityId, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns the favorites before and after the current favorite in the ordered set where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * @param favoriteId the primary key of the current favorite
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	public Favorite[] findByGroupIdEntityIdAndTypeId_PrevAndNext(
			long favoriteId, long entityGroupId, long entityId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Removes all the favorites where entityGroupId = &#63; and entityId = &#63; and typeId = &#63; from the database.
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 */
	public void removeByGroupIdEntityIdAndTypeId(
		long entityGroupId, long entityId, long typeId);

	/**
	 * Returns the number of favorites where entityGroupId = &#63; and entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityGroupId the entity group ID
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @return the number of matching favorites
	 */
	public int countByGroupIdEntityIdAndTypeId(
		long entityGroupId, long entityId, long typeId);

	/**
	 * Returns all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @return the matching favorites
	 */
	public java.util.List<Favorite>
		findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			long typeId, long entityId, String publikUserId, String content);

	/**
	 * Returns a range of all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of matching favorites
	 */
	public java.util.List<Favorite>
		findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			long typeId, long entityId, String publikUserId, String content,
			int start, int end);

	/**
	 * Returns an ordered range of all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching favorites
	 */
	public java.util.List<Favorite>
		findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			long typeId, long entityId, String publikUserId, String content,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator);

	/**
	 * Returns an ordered range of all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching favorites
	 */
	public java.util.List<Favorite>
		findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			long typeId, long entityId, String publikUserId, String content,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByTypeIdAndEntityIdAndPublikUserIdAndContent_First(
			long typeId, long entityId, String publikUserId, String content,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Returns the first favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByTypeIdAndEntityIdAndPublikUserIdAndContent_First(
		long typeId, long entityId, String publikUserId, String content,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns the last favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	public Favorite findByTypeIdAndEntityIdAndPublikUserIdAndContent_Last(
			long typeId, long entityId, String publikUserId, String content,
			com.liferay.portal.kernel.util.OrderByComparator<Favorite>
				orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Returns the last favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	public Favorite fetchByTypeIdAndEntityIdAndPublikUserIdAndContent_Last(
		long typeId, long entityId, String publikUserId, String content,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns the favorites before and after the current favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param favoriteId the primary key of the current favorite
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	public Favorite[]
			findByTypeIdAndEntityIdAndPublikUserIdAndContent_PrevAndNext(
				long favoriteId, long typeId, long entityId,
				String publikUserId, String content,
				com.liferay.portal.kernel.util.OrderByComparator<Favorite>
					orderByComparator)
		throws NoSuchFavoriteException;

	/**
	 * Removes all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 */
	public void removeByTypeIdAndEntityIdAndPublikUserIdAndContent(
		long typeId, long entityId, String publikUserId, String content);

	/**
	 * Returns the number of favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @return the number of matching favorites
	 */
	public int countByTypeIdAndEntityIdAndPublikUserIdAndContent(
		long typeId, long entityId, String publikUserId, String content);

	/**
	 * Caches the favorite in the entity cache if it is enabled.
	 *
	 * @param favorite the favorite
	 */
	public void cacheResult(Favorite favorite);

	/**
	 * Caches the favorites in the entity cache if it is enabled.
	 *
	 * @param favorites the favorites
	 */
	public void cacheResult(java.util.List<Favorite> favorites);

	/**
	 * Creates a new favorite with the primary key. Does not add the favorite to the database.
	 *
	 * @param favoriteId the primary key for the new favorite
	 * @return the new favorite
	 */
	public Favorite create(long favoriteId);

	/**
	 * Removes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite that was removed
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	public Favorite remove(long favoriteId) throws NoSuchFavoriteException;

	public Favorite updateImpl(Favorite favorite);

	/**
	 * Returns the favorite with the primary key or throws a <code>NoSuchFavoriteException</code> if it could not be found.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	public Favorite findByPrimaryKey(long favoriteId)
		throws NoSuchFavoriteException;

	/**
	 * Returns the favorite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite, or <code>null</code> if a favorite with the primary key could not be found
	 */
	public Favorite fetchByPrimaryKey(long favoriteId);

	/**
	 * Returns all the favorites.
	 *
	 * @return the favorites
	 */
	public java.util.List<Favorite> findAll();

	/**
	 * Returns a range of all the favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of favorites
	 */
	public java.util.List<Favorite> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of favorites
	 */
	public java.util.List<Favorite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of favorites
	 */
	public java.util.List<Favorite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the favorites from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of favorites.
	 *
	 * @return the number of favorites
	 */
	public int countAll();

}