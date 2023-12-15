/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.council.exception.NoSuchCouncilSessionException;
import eu.strasbourg.service.council.model.CouncilSession;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the council session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CouncilSessionUtil
 * @generated
 */
@ProviderType
public interface CouncilSessionPersistence
	extends BasePersistence<CouncilSession> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CouncilSessionUtil} to access the council session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the council sessions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching council sessions
	 */
	public java.util.List<CouncilSession> findByUuid(String uuid);

	/**
	 * Returns a range of all the council sessions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @return the range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the council sessions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns an ordered range of all the council sessions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first council session in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the first council session in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the last council session in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the last council session in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the council sessions before and after the current council session in the ordered set where uuid = &#63;.
	 *
	 * @param councilSessionId the primary key of the current council session
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next council session
	 * @throws NoSuchCouncilSessionException if a council session with the primary key could not be found
	 */
	public CouncilSession[] findByUuid_PrevAndNext(
			long councilSessionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Removes all the council sessions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of council sessions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching council sessions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the council session where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCouncilSessionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByUUID_G(String uuid, long groupId)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the council session where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the council session where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the council session where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the council session that was removed
	 */
	public CouncilSession removeByUUID_G(String uuid, long groupId)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the number of council sessions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching council sessions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the council sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching council sessions
	 */
	public java.util.List<CouncilSession> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the council sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @return the range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the council sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns an ordered range of all the council sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first council session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the first council session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the last council session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the last council session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the council sessions before and after the current council session in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param councilSessionId the primary key of the current council session
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next council session
	 * @throws NoSuchCouncilSessionException if a council session with the primary key could not be found
	 */
	public CouncilSession[] findByUuid_C_PrevAndNext(
			long councilSessionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Removes all the council sessions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of council sessions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching council sessions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the council sessions where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching council sessions
	 */
	public java.util.List<CouncilSession> findByTitle(String title);

	/**
	 * Returns a range of all the council sessions where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @return the range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByTitle(
		String title, int start, int end);

	/**
	 * Returns an ordered range of all the council sessions where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns an ordered range of all the council sessions where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first council session in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the first council session in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the last council session in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the last council session in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the council sessions before and after the current council session in the ordered set where title = &#63;.
	 *
	 * @param councilSessionId the primary key of the current council session
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next council session
	 * @throws NoSuchCouncilSessionException if a council session with the primary key could not be found
	 */
	public CouncilSession[] findByTitle_PrevAndNext(
			long councilSessionId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Removes all the council sessions where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of council sessions where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching council sessions
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the council sessions where date = &#63;.
	 *
	 * @param date the date
	 * @return the matching council sessions
	 */
	public java.util.List<CouncilSession> findByDate(Date date);

	/**
	 * Returns a range of all the council sessions where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @return the range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByDate(
		Date date, int start, int end);

	/**
	 * Returns an ordered range of all the council sessions where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByDate(
		Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns an ordered range of all the council sessions where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByDate(
		Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first council session in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByDate_First(
			Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the first council session in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByDate_First(
		Date date,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the last council session in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByDate_Last(
			Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the last council session in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByDate_Last(
		Date date,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the council sessions before and after the current council session in the ordered set where date = &#63;.
	 *
	 * @param councilSessionId the primary key of the current council session
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next council session
	 * @throws NoSuchCouncilSessionException if a council session with the primary key could not be found
	 */
	public CouncilSession[] findByDate_PrevAndNext(
			long councilSessionId, Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Removes all the council sessions where date = &#63; from the database.
	 *
	 * @param date the date
	 */
	public void removeByDate(Date date);

	/**
	 * Returns the number of council sessions where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching council sessions
	 */
	public int countByDate(Date date);

	/**
	 * Returns all the council sessions where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching council sessions
	 */
	public java.util.List<CouncilSession> findByTypeId(long typeId);

	/**
	 * Returns a range of all the council sessions where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @return the range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByTypeId(
		long typeId, int start, int end);

	/**
	 * Returns an ordered range of all the council sessions where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByTypeId(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns an ordered range of all the council sessions where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching council sessions
	 */
	public java.util.List<CouncilSession> findByTypeId(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first council session in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByTypeId_First(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the first council session in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByTypeId_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the last council session in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session
	 * @throws NoSuchCouncilSessionException if a matching council session could not be found
	 */
	public CouncilSession findByTypeId_Last(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the last council session in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public CouncilSession fetchByTypeId_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns the council sessions before and after the current council session in the ordered set where typeId = &#63;.
	 *
	 * @param councilSessionId the primary key of the current council session
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next council session
	 * @throws NoSuchCouncilSessionException if a council session with the primary key could not be found
	 */
	public CouncilSession[] findByTypeId_PrevAndNext(
			long councilSessionId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
				orderByComparator)
		throws NoSuchCouncilSessionException;

	/**
	 * Removes all the council sessions where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	public void removeByTypeId(long typeId);

	/**
	 * Returns the number of council sessions where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching council sessions
	 */
	public int countByTypeId(long typeId);

	/**
	 * Caches the council session in the entity cache if it is enabled.
	 *
	 * @param councilSession the council session
	 */
	public void cacheResult(CouncilSession councilSession);

	/**
	 * Caches the council sessions in the entity cache if it is enabled.
	 *
	 * @param councilSessions the council sessions
	 */
	public void cacheResult(java.util.List<CouncilSession> councilSessions);

	/**
	 * Creates a new council session with the primary key. Does not add the council session to the database.
	 *
	 * @param councilSessionId the primary key for the new council session
	 * @return the new council session
	 */
	public CouncilSession create(long councilSessionId);

	/**
	 * Removes the council session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param councilSessionId the primary key of the council session
	 * @return the council session that was removed
	 * @throws NoSuchCouncilSessionException if a council session with the primary key could not be found
	 */
	public CouncilSession remove(long councilSessionId)
		throws NoSuchCouncilSessionException;

	public CouncilSession updateImpl(CouncilSession councilSession);

	/**
	 * Returns the council session with the primary key or throws a <code>NoSuchCouncilSessionException</code> if it could not be found.
	 *
	 * @param councilSessionId the primary key of the council session
	 * @return the council session
	 * @throws NoSuchCouncilSessionException if a council session with the primary key could not be found
	 */
	public CouncilSession findByPrimaryKey(long councilSessionId)
		throws NoSuchCouncilSessionException;

	/**
	 * Returns the council session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param councilSessionId the primary key of the council session
	 * @return the council session, or <code>null</code> if a council session with the primary key could not be found
	 */
	public CouncilSession fetchByPrimaryKey(long councilSessionId);

	/**
	 * Returns all the council sessions.
	 *
	 * @return the council sessions
	 */
	public java.util.List<CouncilSession> findAll();

	/**
	 * Returns a range of all the council sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @return the range of council sessions
	 */
	public java.util.List<CouncilSession> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the council sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of council sessions
	 */
	public java.util.List<CouncilSession> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator);

	/**
	 * Returns an ordered range of all the council sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of council sessions
	 */
	public java.util.List<CouncilSession> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CouncilSession>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the council sessions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of council sessions.
	 *
	 * @return the number of council sessions
	 */
	public int countAll();

}