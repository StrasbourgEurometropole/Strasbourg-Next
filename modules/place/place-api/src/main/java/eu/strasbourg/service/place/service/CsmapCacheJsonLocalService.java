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

package eu.strasbourg.service.place.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import eu.strasbourg.service.place.model.CsmapCacheJson;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for CsmapCacheJson. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Angelique Zunino Champougny
 * @see CsmapCacheJsonLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CsmapCacheJsonLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.CsmapCacheJsonLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the csmap cache json local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CsmapCacheJsonLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the csmap cache json to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CsmapCacheJsonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param csmapCacheJson the csmap cache json
	 * @return the csmap cache json that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CsmapCacheJson addCsmapCacheJson(CsmapCacheJson csmapCacheJson);

	/**
	 * Creates a new csmap cache json with the primary key. Does not add the csmap cache json to the database.
	 *
	 * @param sigId the primary key for the new csmap cache json
	 * @return the new csmap cache json
	 */
	@Transactional(enabled = false)
	public CsmapCacheJson createCsmapCacheJson(String sigId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the csmap cache json from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CsmapCacheJsonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param csmapCacheJson the csmap cache json
	 * @return the csmap cache json that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public CsmapCacheJson deleteCsmapCacheJson(CsmapCacheJson csmapCacheJson);

	/**
	 * Deletes the csmap cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CsmapCacheJsonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sigId the primary key of the csmap cache json
	 * @return the csmap cache json that was removed
	 * @throws PortalException if a csmap cache json with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public CsmapCacheJson deleteCsmapCacheJson(String sigId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CsmapCacheJson fetchCsmapCacheJson(String sigId);

	/**
	 * Retourne les caches d'un lieu créé après une date et actif
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CsmapCacheJson> getByCreatedDateAndIsActive(Date date);

	/**
	 * Retourne les caches d'un lieu modifié après une date, créé avant cette date et actif
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CsmapCacheJson> getByCreatedDateAndModifiedDateAndIsActive(
		Date date);

	/**
	 * Retourne les caches d'un lieu modifié après une date et inactif
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CsmapCacheJson> getByModifiedDateAndIsNotActive(Date date);

	/**
	 * Returns the csmap cache json with the primary key.
	 *
	 * @param sigId the primary key of the csmap cache json
	 * @return the csmap cache json
	 * @throws PortalException if a csmap cache json with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CsmapCacheJson getCsmapCacheJson(String sigId)
		throws PortalException;

	/**
	 * Returns a range of all the csmap cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of csmap cache jsons
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CsmapCacheJson> getCsmapCacheJsons(int start, int end);

	/**
	 * Returns the number of csmap cache jsons.
	 *
	 * @return the number of csmap cache jsons
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCsmapCacheJsonsCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the csmap cache json in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CsmapCacheJsonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param csmapCacheJson the csmap cache json
	 * @return the csmap cache json that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CsmapCacheJson updateCsmapCacheJson(CsmapCacheJson csmapCacheJson);

}