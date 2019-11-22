/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.formSendRecordField.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.formSendRecordField.exception.NoSuchSignalementException;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;

/**
 * The persistence interface for the form send record field signalement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angélique Zunino
 * @see eu.strasbourg.service.formSendRecordField.service.persistence.impl.FormSendRecordFieldSignalementPersistenceImpl
 * @see FormSendRecordFieldSignalementUtil
 * @generated
 */
@ProviderType
public interface FormSendRecordFieldSignalementPersistence
	extends BasePersistence<FormSendRecordFieldSignalement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormSendRecordFieldSignalementUtil} to access the form send record field signalement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the form send record field signalements where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByUuid(
		java.lang.String uuid);

	/**
	* Returns a range of all the form send record field signalements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @return the range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByUuid(
		java.lang.String uuid, int start, int end);

	/**
	* Returns an ordered range of all the form send record field signalements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns an ordered range of all the form send record field signalements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first form send record field signalement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the first form send record field signalement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the last form send record field signalement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the last form send record field signalement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the form send record field signalements before and after the current form send record field signalement in the ordered set where uuid = &#63;.
	*
	* @param signalementId the primary key of the current form send record field signalement
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form send record field signalement
	* @throws NoSuchSignalementException if a form send record field signalement with the primary key could not be found
	*/
	public FormSendRecordFieldSignalement[] findByUuid_PrevAndNext(
		long signalementId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Removes all the form send record field signalements where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of form send record field signalements where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching form send record field signalements
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the form send record field signalement where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSignalementException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchSignalementException;

	/**
	* Returns the form send record field signalement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByUUID_G(java.lang.String uuid,
		long groupId);

	/**
	* Returns the form send record field signalement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache);

	/**
	* Removes the form send record field signalement where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the form send record field signalement that was removed
	*/
	public FormSendRecordFieldSignalement removeByUUID_G(
		java.lang.String uuid, long groupId) throws NoSuchSignalementException;

	/**
	* Returns the number of form send record field signalements where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching form send record field signalements
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the form send record field signalements where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByUuid_C(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of all the form send record field signalements where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @return the range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

	/**
	* Returns an ordered range of all the form send record field signalements where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns an ordered range of all the form send record field signalements where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first form send record field signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the first form send record field signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the last form send record field signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the last form send record field signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the form send record field signalements before and after the current form send record field signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param signalementId the primary key of the current form send record field signalement
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form send record field signalement
	* @throws NoSuchSignalementException if a form send record field signalement with the primary key could not be found
	*/
	public FormSendRecordFieldSignalement[] findByUuid_C_PrevAndNext(
		long signalementId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Removes all the form send record field signalements where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of form send record field signalements where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching form send record field signalements
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the form send record field signalements where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByGroupId(
		long groupId);

	/**
	* Returns a range of all the form send record field signalements where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @return the range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByGroupId(
		long groupId, int start, int end);

	/**
	* Returns an ordered range of all the form send record field signalements where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns an ordered range of all the form send record field signalements where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first form send record field signalement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the first form send record field signalement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the last form send record field signalement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the last form send record field signalement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the form send record field signalements before and after the current form send record field signalement in the ordered set where groupId = &#63;.
	*
	* @param signalementId the primary key of the current form send record field signalement
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form send record field signalement
	* @throws NoSuchSignalementException if a form send record field signalement with the primary key could not be found
	*/
	public FormSendRecordFieldSignalement[] findByGroupId_PrevAndNext(
		long signalementId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Removes all the form send record field signalements where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of form send record field signalements where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching form send record field signalements
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the form send record field signalements where publikId = &#63;.
	*
	* @param publikId the publik ID
	* @return the matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByPublikId(
		java.lang.String publikId);

	/**
	* Returns a range of all the form send record field signalements where publikId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publikId the publik ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @return the range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByPublikId(
		java.lang.String publikId, int start, int end);

	/**
	* Returns an ordered range of all the form send record field signalements where publikId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publikId the publik ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByPublikId(
		java.lang.String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns an ordered range of all the form send record field signalements where publikId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publikId the publik ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByPublikId(
		java.lang.String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first form send record field signalement in the ordered set where publikId = &#63;.
	*
	* @param publikId the publik ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByPublikId_First(
		java.lang.String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the first form send record field signalement in the ordered set where publikId = &#63;.
	*
	* @param publikId the publik ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByPublikId_First(
		java.lang.String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the last form send record field signalement in the ordered set where publikId = &#63;.
	*
	* @param publikId the publik ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByPublikId_Last(
		java.lang.String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the last form send record field signalement in the ordered set where publikId = &#63;.
	*
	* @param publikId the publik ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByPublikId_Last(
		java.lang.String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the form send record field signalements before and after the current form send record field signalement in the ordered set where publikId = &#63;.
	*
	* @param signalementId the primary key of the current form send record field signalement
	* @param publikId the publik ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form send record field signalement
	* @throws NoSuchSignalementException if a form send record field signalement with the primary key could not be found
	*/
	public FormSendRecordFieldSignalement[] findByPublikId_PrevAndNext(
		long signalementId, java.lang.String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Removes all the form send record field signalements where publikId = &#63; from the database.
	*
	* @param publikId the publik ID
	*/
	public void removeByPublikId(java.lang.String publikId);

	/**
	* Returns the number of form send record field signalements where publikId = &#63;.
	*
	* @param publikId the publik ID
	* @return the number of matching form send record field signalements
	*/
	public int countByPublikId(java.lang.String publikId);

	/**
	* Returns all the form send record field signalements where formSendRecordFieldId = &#63;.
	*
	* @param formSendRecordFieldId the form send record field ID
	* @return the matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByFormSendRecordFieldId(
		long formSendRecordFieldId);

	/**
	* Returns a range of all the form send record field signalements where formSendRecordFieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param formSendRecordFieldId the form send record field ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @return the range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByFormSendRecordFieldId(
		long formSendRecordFieldId, int start, int end);

	/**
	* Returns an ordered range of all the form send record field signalements where formSendRecordFieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param formSendRecordFieldId the form send record field ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByFormSendRecordFieldId(
		long formSendRecordFieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns an ordered range of all the form send record field signalements where formSendRecordFieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param formSendRecordFieldId the form send record field ID
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findByFormSendRecordFieldId(
		long formSendRecordFieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first form send record field signalement in the ordered set where formSendRecordFieldId = &#63;.
	*
	* @param formSendRecordFieldId the form send record field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByFormSendRecordFieldId_First(
		long formSendRecordFieldId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the first form send record field signalement in the ordered set where formSendRecordFieldId = &#63;.
	*
	* @param formSendRecordFieldId the form send record field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByFormSendRecordFieldId_First(
		long formSendRecordFieldId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the last form send record field signalement in the ordered set where formSendRecordFieldId = &#63;.
	*
	* @param formSendRecordFieldId the form send record field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement
	* @throws NoSuchSignalementException if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement findByFormSendRecordFieldId_Last(
		long formSendRecordFieldId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Returns the last form send record field signalement in the ordered set where formSendRecordFieldId = &#63;.
	*
	* @param formSendRecordFieldId the form send record field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form send record field signalement, or <code>null</code> if a matching form send record field signalement could not be found
	*/
	public FormSendRecordFieldSignalement fetchByFormSendRecordFieldId_Last(
		long formSendRecordFieldId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns the form send record field signalements before and after the current form send record field signalement in the ordered set where formSendRecordFieldId = &#63;.
	*
	* @param signalementId the primary key of the current form send record field signalement
	* @param formSendRecordFieldId the form send record field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form send record field signalement
	* @throws NoSuchSignalementException if a form send record field signalement with the primary key could not be found
	*/
	public FormSendRecordFieldSignalement[] findByFormSendRecordFieldId_PrevAndNext(
		long signalementId, long formSendRecordFieldId,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator)
		throws NoSuchSignalementException;

	/**
	* Removes all the form send record field signalements where formSendRecordFieldId = &#63; from the database.
	*
	* @param formSendRecordFieldId the form send record field ID
	*/
	public void removeByFormSendRecordFieldId(long formSendRecordFieldId);

	/**
	* Returns the number of form send record field signalements where formSendRecordFieldId = &#63;.
	*
	* @param formSendRecordFieldId the form send record field ID
	* @return the number of matching form send record field signalements
	*/
	public int countByFormSendRecordFieldId(long formSendRecordFieldId);

	/**
	* Caches the form send record field signalement in the entity cache if it is enabled.
	*
	* @param formSendRecordFieldSignalement the form send record field signalement
	*/
	public void cacheResult(
		FormSendRecordFieldSignalement formSendRecordFieldSignalement);

	/**
	* Caches the form send record field signalements in the entity cache if it is enabled.
	*
	* @param formSendRecordFieldSignalements the form send record field signalements
	*/
	public void cacheResult(
		java.util.List<FormSendRecordFieldSignalement> formSendRecordFieldSignalements);

	/**
	* Creates a new form send record field signalement with the primary key. Does not add the form send record field signalement to the database.
	*
	* @param signalementId the primary key for the new form send record field signalement
	* @return the new form send record field signalement
	*/
	public FormSendRecordFieldSignalement create(long signalementId);

	/**
	* Removes the form send record field signalement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param signalementId the primary key of the form send record field signalement
	* @return the form send record field signalement that was removed
	* @throws NoSuchSignalementException if a form send record field signalement with the primary key could not be found
	*/
	public FormSendRecordFieldSignalement remove(long signalementId)
		throws NoSuchSignalementException;

	public FormSendRecordFieldSignalement updateImpl(
		FormSendRecordFieldSignalement formSendRecordFieldSignalement);

	/**
	* Returns the form send record field signalement with the primary key or throws a {@link NoSuchSignalementException} if it could not be found.
	*
	* @param signalementId the primary key of the form send record field signalement
	* @return the form send record field signalement
	* @throws NoSuchSignalementException if a form send record field signalement with the primary key could not be found
	*/
	public FormSendRecordFieldSignalement findByPrimaryKey(long signalementId)
		throws NoSuchSignalementException;

	/**
	* Returns the form send record field signalement with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param signalementId the primary key of the form send record field signalement
	* @return the form send record field signalement, or <code>null</code> if a form send record field signalement with the primary key could not be found
	*/
	public FormSendRecordFieldSignalement fetchByPrimaryKey(long signalementId);

	@Override
	public java.util.Map<java.io.Serializable, FormSendRecordFieldSignalement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the form send record field signalements.
	*
	* @return the form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findAll();

	/**
	* Returns a range of all the form send record field signalements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @return the range of form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the form send record field signalements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator);

	/**
	* Returns an ordered range of all the form send record field signalements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSendRecordFieldSignalementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form send record field signalements
	* @param end the upper bound of the range of form send record field signalements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of form send record field signalements
	*/
	public java.util.List<FormSendRecordFieldSignalement> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSendRecordFieldSignalement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the form send record field signalements from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of form send record field signalements.
	*
	* @return the number of form send record field signalements
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}