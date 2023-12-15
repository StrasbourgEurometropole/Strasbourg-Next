/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.place.exception.NoSuchHistoricException;
import eu.strasbourg.service.place.model.Historic;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the historic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see HistoricUtil
 * @generated
 */
@ProviderType
public interface HistoricPersistence extends BasePersistence<Historic> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistoricUtil} to access the historic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching historics
	 */
	public java.util.List<Historic> findByUuid(String uuid);

	/**
	 * Returns a range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of matching historics
	 */
	public java.util.List<Historic> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching historics
	 */
	public java.util.List<Historic> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator);

	/**
	 * Returns an ordered range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching historics
	 */
	public java.util.List<Historic> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	public Historic findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Historic>
				orderByComparator)
		throws NoSuchHistoricException;

	/**
	 * Returns the first historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic, or <code>null</code> if a matching historic could not be found
	 */
	public Historic fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator);

	/**
	 * Returns the last historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	public Historic findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Historic>
				orderByComparator)
		throws NoSuchHistoricException;

	/**
	 * Returns the last historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic, or <code>null</code> if a matching historic could not be found
	 */
	public Historic fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator);

	/**
	 * Returns the historics before and after the current historic in the ordered set where uuid = &#63;.
	 *
	 * @param sigId the primary key of the current historic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	public Historic[] findByUuid_PrevAndNext(
			String sigId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Historic>
				orderByComparator)
		throws NoSuchHistoricException;

	/**
	 * Removes all the historics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching historics
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the historics where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @return the matching historics
	 */
	public java.util.List<Historic> findBySuppressionDate(Date suppressionDate);

	/**
	 * Returns a range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of matching historics
	 */
	public java.util.List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end);

	/**
	 * Returns an ordered range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching historics
	 */
	public java.util.List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator);

	/**
	 * Returns an ordered range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching historics
	 */
	public java.util.List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	public Historic findBySuppressionDate_First(
			Date suppressionDate,
			com.liferay.portal.kernel.util.OrderByComparator<Historic>
				orderByComparator)
		throws NoSuchHistoricException;

	/**
	 * Returns the first historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic, or <code>null</code> if a matching historic could not be found
	 */
	public Historic fetchBySuppressionDate_First(
		Date suppressionDate,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator);

	/**
	 * Returns the last historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	public Historic findBySuppressionDate_Last(
			Date suppressionDate,
			com.liferay.portal.kernel.util.OrderByComparator<Historic>
				orderByComparator)
		throws NoSuchHistoricException;

	/**
	 * Returns the last historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic, or <code>null</code> if a matching historic could not be found
	 */
	public Historic fetchBySuppressionDate_Last(
		Date suppressionDate,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator);

	/**
	 * Returns the historics before and after the current historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param sigId the primary key of the current historic
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	public Historic[] findBySuppressionDate_PrevAndNext(
			String sigId, Date suppressionDate,
			com.liferay.portal.kernel.util.OrderByComparator<Historic>
				orderByComparator)
		throws NoSuchHistoricException;

	/**
	 * Removes all the historics where suppressionDate &ge; &#63; from the database.
	 *
	 * @param suppressionDate the suppression date
	 */
	public void removeBySuppressionDate(Date suppressionDate);

	/**
	 * Returns the number of historics where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @return the number of matching historics
	 */
	public int countBySuppressionDate(Date suppressionDate);

	/**
	 * Caches the historic in the entity cache if it is enabled.
	 *
	 * @param historic the historic
	 */
	public void cacheResult(Historic historic);

	/**
	 * Caches the historics in the entity cache if it is enabled.
	 *
	 * @param historics the historics
	 */
	public void cacheResult(java.util.List<Historic> historics);

	/**
	 * Creates a new historic with the primary key. Does not add the historic to the database.
	 *
	 * @param sigId the primary key for the new historic
	 * @return the new historic
	 */
	public Historic create(String sigId);

	/**
	 * Removes the historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic that was removed
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	public Historic remove(String sigId) throws NoSuchHistoricException;

	public Historic updateImpl(Historic historic);

	/**
	 * Returns the historic with the primary key or throws a <code>NoSuchHistoricException</code> if it could not be found.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	public Historic findByPrimaryKey(String sigId)
		throws NoSuchHistoricException;

	/**
	 * Returns the historic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic, or <code>null</code> if a historic with the primary key could not be found
	 */
	public Historic fetchByPrimaryKey(String sigId);

	/**
	 * Returns all the historics.
	 *
	 * @return the historics
	 */
	public java.util.List<Historic> findAll();

	/**
	 * Returns a range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of historics
	 */
	public java.util.List<Historic> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of historics
	 */
	public java.util.List<Historic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator);

	/**
	 * Returns an ordered range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of historics
	 */
	public java.util.List<Historic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Historic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the historics from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of historics.
	 *
	 * @return the number of historics
	 */
	public int countAll();

}