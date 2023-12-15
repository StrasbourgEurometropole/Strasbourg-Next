/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.edition.exception.NoSuchEditionGalleryException;
import eu.strasbourg.service.edition.model.EditionGallery;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the edition gallery service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see EditionGalleryUtil
 * @generated
 */
@ProviderType
public interface EditionGalleryPersistence
	extends BasePersistence<EditionGallery> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EditionGalleryUtil} to access the edition gallery persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the edition galleries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching edition galleries
	 */
	public java.util.List<EditionGallery> findByUuid(String uuid);

	/**
	 * Returns a range of all the edition galleries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the edition galleries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns an ordered range of all the edition galleries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the first edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the last edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the last edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public EditionGallery[] findByUuid_PrevAndNext(
			long galleryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Removes all the edition galleries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of edition galleries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching edition galleries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the edition gallery where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEditionGalleryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByUUID_G(String uuid, long groupId)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the edition gallery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the edition gallery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the edition gallery where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the edition gallery that was removed
	 */
	public EditionGallery removeByUUID_G(String uuid, long groupId)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the number of edition galleries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching edition galleries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching edition galleries
	 */
	public java.util.List<EditionGallery> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns an ordered range of all the edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the first edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the last edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the last edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public EditionGallery[] findByUuid_C_PrevAndNext(
			long galleryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Removes all the edition galleries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching edition galleries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the edition galleries where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching edition galleries
	 */
	public java.util.List<EditionGallery> findBytitle(String title);

	/**
	 * Returns a range of all the edition galleries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findBytitle(
		String title, int start, int end);

	/**
	 * Returns an ordered range of all the edition galleries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns an ordered range of all the edition galleries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first edition gallery in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findBytitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the first edition gallery in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchBytitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the last edition gallery in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findBytitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the last edition gallery in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchBytitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where title = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public EditionGallery[] findBytitle_PrevAndNext(
			long galleryId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Removes all the edition galleries where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeBytitle(String title);

	/**
	 * Returns the number of edition galleries where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching edition galleries
	 */
	public int countBytitle(String title);

	/**
	 * Returns all the edition galleries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching edition galleries
	 */
	public java.util.List<EditionGallery> findByGroupId(long groupId);

	/**
	 * Returns a range of all the edition galleries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the edition galleries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns an ordered range of all the edition galleries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the first edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the last edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the last edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public EditionGallery[] findByGroupId_PrevAndNext(
			long galleryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Removes all the edition galleries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of edition galleries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching edition galleries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the matching edition galleries
	 */
	public java.util.List<EditionGallery> findByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Returns a range of all the edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end);

	/**
	 * Returns an ordered range of all the edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns an ordered range of all the edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public java.util.List<EditionGallery> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByPublicationDateAndStatus_First(
			Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the first edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByPublicationDateAndStatus_First(
		Date publicationDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the last edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public EditionGallery findByPublicationDateAndStatus_Last(
			Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the last edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public EditionGallery fetchByPublicationDateAndStatus_Last(
		Date publicationDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public EditionGallery[] findByPublicationDateAndStatus_PrevAndNext(
			long galleryId, Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
				orderByComparator)
		throws NoSuchEditionGalleryException;

	/**
	 * Removes all the edition galleries where publicationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 */
	public void removeByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Returns the number of edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the number of matching edition galleries
	 */
	public int countByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Caches the edition gallery in the entity cache if it is enabled.
	 *
	 * @param editionGallery the edition gallery
	 */
	public void cacheResult(EditionGallery editionGallery);

	/**
	 * Caches the edition galleries in the entity cache if it is enabled.
	 *
	 * @param editionGalleries the edition galleries
	 */
	public void cacheResult(java.util.List<EditionGallery> editionGalleries);

	/**
	 * Creates a new edition gallery with the primary key. Does not add the edition gallery to the database.
	 *
	 * @param galleryId the primary key for the new edition gallery
	 * @return the new edition gallery
	 */
	public EditionGallery create(long galleryId);

	/**
	 * Removes the edition gallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery that was removed
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public EditionGallery remove(long galleryId)
		throws NoSuchEditionGalleryException;

	public EditionGallery updateImpl(EditionGallery editionGallery);

	/**
	 * Returns the edition gallery with the primary key or throws a <code>NoSuchEditionGalleryException</code> if it could not be found.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public EditionGallery findByPrimaryKey(long galleryId)
		throws NoSuchEditionGalleryException;

	/**
	 * Returns the edition gallery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery, or <code>null</code> if a edition gallery with the primary key could not be found
	 */
	public EditionGallery fetchByPrimaryKey(long galleryId);

	/**
	 * Returns all the edition galleries.
	 *
	 * @return the edition galleries
	 */
	public java.util.List<EditionGallery> findAll();

	/**
	 * Returns a range of all the edition galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of edition galleries
	 */
	public java.util.List<EditionGallery> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the edition galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of edition galleries
	 */
	public java.util.List<EditionGallery> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator);

	/**
	 * Returns an ordered range of all the edition galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of edition galleries
	 */
	public java.util.List<EditionGallery> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EditionGallery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the edition galleries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of edition galleries.
	 *
	 * @return the number of edition galleries
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of editions associated with the edition gallery.
	 *
	 * @param pk the primary key of the edition gallery
	 * @return long[] of the primaryKeys of editions associated with the edition gallery
	 */
	public long[] getEditionPrimaryKeys(long pk);

	/**
	 * Returns all the editions associated with the edition gallery.
	 *
	 * @param pk the primary key of the edition gallery
	 * @return the editions associated with the edition gallery
	 */
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditions(long pk);

	/**
	 * Returns a range of all the editions associated with the edition gallery.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the edition gallery
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of editions associated with the edition gallery
	 */
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditions(long pk, int start, int end);

	/**
	 * Returns an ordered range of all the editions associated with the edition gallery.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the edition gallery
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of editions associated with the edition gallery
	 */
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditions(
			long pk, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.edition.model.Edition>
					orderByComparator);

	/**
	 * Returns the number of editions associated with the edition gallery.
	 *
	 * @param pk the primary key of the edition gallery
	 * @return the number of editions associated with the edition gallery
	 */
	public int getEditionsSize(long pk);

	/**
	 * Returns <code>true</code> if the edition is associated with the edition gallery.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPK the primary key of the edition
	 * @return <code>true</code> if the edition is associated with the edition gallery; <code>false</code> otherwise
	 */
	public boolean containsEdition(long pk, long editionPK);

	/**
	 * Returns <code>true</code> if the edition gallery has any editions associated with it.
	 *
	 * @param pk the primary key of the edition gallery to check for associations with editions
	 * @return <code>true</code> if the edition gallery has any editions associated with it; <code>false</code> otherwise
	 */
	public boolean containsEditions(long pk);

	/**
	 * Adds an association between the edition gallery and the edition. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPK the primary key of the edition
	 * @return <code>true</code> if an association between the edition gallery and the edition was added; <code>false</code> if they were already associated
	 */
	public boolean addEdition(long pk, long editionPK);

	/**
	 * Adds an association between the edition gallery and the edition. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param edition the edition
	 * @return <code>true</code> if an association between the edition gallery and the edition was added; <code>false</code> if they were already associated
	 */
	public boolean addEdition(
		long pk, eu.strasbourg.service.edition.model.Edition edition);

	/**
	 * Adds an association between the edition gallery and the editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPKs the primary keys of the editions
	 * @return <code>true</code> if at least one association between the edition gallery and the editions was added; <code>false</code> if they were all already associated
	 */
	public boolean addEditions(long pk, long[] editionPKs);

	/**
	 * Adds an association between the edition gallery and the editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editions the editions
	 * @return <code>true</code> if at least one association between the edition gallery and the editions was added; <code>false</code> if they were all already associated
	 */
	public boolean addEditions(
		long pk,
		java.util.List<eu.strasbourg.service.edition.model.Edition> editions);

	/**
	 * Clears all associations between the edition gallery and its editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery to clear the associated editions from
	 */
	public void clearEditions(long pk);

	/**
	 * Removes the association between the edition gallery and the edition. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPK the primary key of the edition
	 */
	public void removeEdition(long pk, long editionPK);

	/**
	 * Removes the association between the edition gallery and the edition. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param edition the edition
	 */
	public void removeEdition(
		long pk, eu.strasbourg.service.edition.model.Edition edition);

	/**
	 * Removes the association between the edition gallery and the editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPKs the primary keys of the editions
	 */
	public void removeEditions(long pk, long[] editionPKs);

	/**
	 * Removes the association between the edition gallery and the editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editions the editions
	 */
	public void removeEditions(
		long pk,
		java.util.List<eu.strasbourg.service.edition.model.Edition> editions);

	/**
	 * Sets the editions associated with the edition gallery, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPKs the primary keys of the editions to be associated with the edition gallery
	 */
	public void setEditions(long pk, long[] editionPKs);

	/**
	 * Sets the editions associated with the edition gallery, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editions the editions to be associated with the edition gallery
	 */
	public void setEditions(
		long pk,
		java.util.List<eu.strasbourg.service.edition.model.Edition> editions);

}