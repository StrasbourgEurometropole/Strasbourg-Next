/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.agenda.exception.NoSuchImportReportException;
import eu.strasbourg.service.agenda.model.ImportReport;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the import report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see ImportReportUtil
 * @generated
 */
@ProviderType
public interface ImportReportPersistence extends BasePersistence<ImportReport> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImportReportUtil} to access the import report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the import reports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching import reports
	 */
	public java.util.List<ImportReport> findByUuid(String uuid);

	/**
	 * Returns a range of all the import reports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import reports
	 * @param end the upper bound of the range of import reports (not inclusive)
	 * @return the range of matching import reports
	 */
	public java.util.List<ImportReport> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the import reports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import reports
	 * @param end the upper bound of the range of import reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import reports
	 */
	public java.util.List<ImportReport> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
			orderByComparator);

	/**
	 * Returns an ordered range of all the import reports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import reports
	 * @param end the upper bound of the range of import reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import reports
	 */
	public java.util.List<ImportReport> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first import report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import report
	 * @throws NoSuchImportReportException if a matching import report could not be found
	 */
	public ImportReport findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
				orderByComparator)
		throws NoSuchImportReportException;

	/**
	 * Returns the first import report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import report, or <code>null</code> if a matching import report could not be found
	 */
	public ImportReport fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
			orderByComparator);

	/**
	 * Returns the last import report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import report
	 * @throws NoSuchImportReportException if a matching import report could not be found
	 */
	public ImportReport findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
				orderByComparator)
		throws NoSuchImportReportException;

	/**
	 * Returns the last import report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import report, or <code>null</code> if a matching import report could not be found
	 */
	public ImportReport fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
			orderByComparator);

	/**
	 * Returns the import reports before and after the current import report in the ordered set where uuid = &#63;.
	 *
	 * @param reportId the primary key of the current import report
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import report
	 * @throws NoSuchImportReportException if a import report with the primary key could not be found
	 */
	public ImportReport[] findByUuid_PrevAndNext(
			long reportId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
				orderByComparator)
		throws NoSuchImportReportException;

	/**
	 * Removes all the import reports where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of import reports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching import reports
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the import report in the entity cache if it is enabled.
	 *
	 * @param importReport the import report
	 */
	public void cacheResult(ImportReport importReport);

	/**
	 * Caches the import reports in the entity cache if it is enabled.
	 *
	 * @param importReports the import reports
	 */
	public void cacheResult(java.util.List<ImportReport> importReports);

	/**
	 * Creates a new import report with the primary key. Does not add the import report to the database.
	 *
	 * @param reportId the primary key for the new import report
	 * @return the new import report
	 */
	public ImportReport create(long reportId);

	/**
	 * Removes the import report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the import report
	 * @return the import report that was removed
	 * @throws NoSuchImportReportException if a import report with the primary key could not be found
	 */
	public ImportReport remove(long reportId)
		throws NoSuchImportReportException;

	public ImportReport updateImpl(ImportReport importReport);

	/**
	 * Returns the import report with the primary key or throws a <code>NoSuchImportReportException</code> if it could not be found.
	 *
	 * @param reportId the primary key of the import report
	 * @return the import report
	 * @throws NoSuchImportReportException if a import report with the primary key could not be found
	 */
	public ImportReport findByPrimaryKey(long reportId)
		throws NoSuchImportReportException;

	/**
	 * Returns the import report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the import report
	 * @return the import report, or <code>null</code> if a import report with the primary key could not be found
	 */
	public ImportReport fetchByPrimaryKey(long reportId);

	/**
	 * Returns all the import reports.
	 *
	 * @return the import reports
	 */
	public java.util.List<ImportReport> findAll();

	/**
	 * Returns a range of all the import reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import reports
	 * @param end the upper bound of the range of import reports (not inclusive)
	 * @return the range of import reports
	 */
	public java.util.List<ImportReport> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the import reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import reports
	 * @param end the upper bound of the range of import reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import reports
	 */
	public java.util.List<ImportReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
			orderByComparator);

	/**
	 * Returns an ordered range of all the import reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportReportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import reports
	 * @param end the upper bound of the range of import reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of import reports
	 */
	public java.util.List<ImportReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportReport>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the import reports from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of import reports.
	 *
	 * @return the number of import reports
	 */
	public int countAll();

}