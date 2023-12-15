/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.project.exception.NoSuchBudgetPhaseException;
import eu.strasbourg.service.project.model.BudgetPhase;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the budget phase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetPhaseUtil
 * @generated
 */
@ProviderType
public interface BudgetPhasePersistence extends BasePersistence<BudgetPhase> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BudgetPhaseUtil} to access the budget phase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the budget phases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching budget phases
	 */
	public java.util.List<BudgetPhase> findByUuid(String uuid);

	/**
	 * Returns a range of all the budget phases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the budget phases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns an ordered range of all the budget phases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the first budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns the last budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the last budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns the budget phases before and after the current budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param budgetPhaseId the primary key of the current budget phase
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public BudgetPhase[] findByUuid_PrevAndNext(
			long budgetPhaseId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Removes all the budget phases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of budget phases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching budget phases
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the budget phase where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBudgetPhaseException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByUUID_G(String uuid, long groupId)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the budget phase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the budget phase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the budget phase where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the budget phase that was removed
	 */
	public BudgetPhase removeByUUID_G(String uuid, long groupId)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the number of budget phases where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching budget phases
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching budget phases
	 */
	public java.util.List<BudgetPhase> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns an ordered range of all the budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the first budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns the last budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the last budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns the budget phases before and after the current budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param budgetPhaseId the primary key of the current budget phase
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public BudgetPhase[] findByUuid_C_PrevAndNext(
			long budgetPhaseId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Removes all the budget phases where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching budget phases
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the budget phases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching budget phases
	 */
	public java.util.List<BudgetPhase> findByGroupId(long groupId);

	/**
	 * Returns a range of all the budget phases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the budget phases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns an ordered range of all the budget phases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the first budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns the last budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the last budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns the budget phases before and after the current budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param budgetPhaseId the primary key of the current budget phase
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public BudgetPhase[] findByGroupId_PrevAndNext(
			long budgetPhaseId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Removes all the budget phases where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of budget phases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching budget phases
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @return the matching budget phases
	 */
	public java.util.List<BudgetPhase> findByIsActiveAndGroupId(
		boolean isActive, long groupId);

	/**
	 * Returns a range of all the budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByIsActiveAndGroupId(
		boolean isActive, long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByIsActiveAndGroupId(
		boolean isActive, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns an ordered range of all the budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget phases
	 */
	public java.util.List<BudgetPhase> findByIsActiveAndGroupId(
		boolean isActive, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByIsActiveAndGroupId_First(
			boolean isActive, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the first budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByIsActiveAndGroupId_First(
		boolean isActive, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns the last budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public BudgetPhase findByIsActiveAndGroupId_Last(
			boolean isActive, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the last budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public BudgetPhase fetchByIsActiveAndGroupId_Last(
		boolean isActive, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns the budget phases before and after the current budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param budgetPhaseId the primary key of the current budget phase
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public BudgetPhase[] findByIsActiveAndGroupId_PrevAndNext(
			long budgetPhaseId, boolean isActive, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
				orderByComparator)
		throws NoSuchBudgetPhaseException;

	/**
	 * Removes all the budget phases where isActive = &#63; and groupId = &#63; from the database.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 */
	public void removeByIsActiveAndGroupId(boolean isActive, long groupId);

	/**
	 * Returns the number of budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @return the number of matching budget phases
	 */
	public int countByIsActiveAndGroupId(boolean isActive, long groupId);

	/**
	 * Caches the budget phase in the entity cache if it is enabled.
	 *
	 * @param budgetPhase the budget phase
	 */
	public void cacheResult(BudgetPhase budgetPhase);

	/**
	 * Caches the budget phases in the entity cache if it is enabled.
	 *
	 * @param budgetPhases the budget phases
	 */
	public void cacheResult(java.util.List<BudgetPhase> budgetPhases);

	/**
	 * Creates a new budget phase with the primary key. Does not add the budget phase to the database.
	 *
	 * @param budgetPhaseId the primary key for the new budget phase
	 * @return the new budget phase
	 */
	public BudgetPhase create(long budgetPhaseId);

	/**
	 * Removes the budget phase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase that was removed
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public BudgetPhase remove(long budgetPhaseId)
		throws NoSuchBudgetPhaseException;

	public BudgetPhase updateImpl(BudgetPhase budgetPhase);

	/**
	 * Returns the budget phase with the primary key or throws a <code>NoSuchBudgetPhaseException</code> if it could not be found.
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public BudgetPhase findByPrimaryKey(long budgetPhaseId)
		throws NoSuchBudgetPhaseException;

	/**
	 * Returns the budget phase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase, or <code>null</code> if a budget phase with the primary key could not be found
	 */
	public BudgetPhase fetchByPrimaryKey(long budgetPhaseId);

	/**
	 * Returns all the budget phases.
	 *
	 * @return the budget phases
	 */
	public java.util.List<BudgetPhase> findAll();

	/**
	 * Returns a range of all the budget phases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of budget phases
	 */
	public java.util.List<BudgetPhase> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the budget phases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of budget phases
	 */
	public java.util.List<BudgetPhase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator);

	/**
	 * Returns an ordered range of all the budget phases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of budget phases
	 */
	public java.util.List<BudgetPhase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BudgetPhase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the budget phases from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of budget phases.
	 *
	 * @return the number of budget phases
	 */
	public int countAll();

}