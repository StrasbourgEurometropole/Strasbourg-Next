/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.PlacitPlace;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PlacitPlace. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see PlacitPlaceLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.project.model.PlacitPlace"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PlacitPlaceLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.PlacitPlaceLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the placit place local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PlacitPlaceLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the placit place to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PlacitPlace addPlacitPlace(PlacitPlace placitPlace);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new placit place with the primary key. Does not add the placit place to the database.
	 *
	 * @param placitPlaceId the primary key for the new placit place
	 * @return the new placit place
	 */
	@Transactional(enabled = false)
	public PlacitPlace createPlacitPlace(long placitPlaceId);

	/**
	 * Crée un lieu Placit vide avec une PK, non ajouté à la base de donnée
	 */
	public PlacitPlace createPlacitPlace(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the placit place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place that was removed
	 * @throws PortalException if a placit place with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PlacitPlace deletePlacitPlace(long placitPlaceId)
		throws PortalException;

	/**
	 * Deletes the placit place from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PlacitPlace deletePlacitPlace(PlacitPlace placitPlace);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
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
	public PlacitPlace fetchPlacitPlace(long placitPlaceId);

	/**
	 * Returns the placit place matching the UUID and group.
	 *
	 * @param uuid the placit place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PlacitPlace fetchPlacitPlaceByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Lance une recherche par liste d'ids
	 */
	public List<PlacitPlace> findByIds(List<Long> placitPlaceIds);

	/**
	 * Lance une recherche par mots-clés
	 */
	public List<PlacitPlace> findByKeyword(
		String keyword, long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne les lieux d'une participation
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getByBudgetParticipatif(long budgetParticipatifId);

	/**
	 * Retourne tous les lieux Placit d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getByGroupId(long groupId);

	/**
	 * Retourne les lieux d'une initiative
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getByInitiative(long initiativeId);

	/**
	 * Retourne les lieux d'une participation
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getByParticipation(long participationId);

	/**
	 * Retourne les lieux d'une participation
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getByPetition(long petitionId);

	/**
	 * Retourne les lieux d'un projet
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getByProject(long projectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getBySaisineObservatoire(
		long saisineObservatoireId);

	/**
	 * Retourne toutes les lieux de cours d'un lieu
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getBySigId(String sigId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	 * Returns the placit place with the primary key.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place
	 * @throws PortalException if a placit place with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PlacitPlace getPlacitPlace(long placitPlaceId)
		throws PortalException;

	/**
	 * Returns the placit place matching the UUID and group.
	 *
	 * @param uuid the placit place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching placit place
	 * @throws PortalException if a matching placit place could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PlacitPlace getPlacitPlaceByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of placit places
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getPlacitPlaces(int start, int end);

	/**
	 * Returns all the placit places matching the UUID and company.
	 *
	 * @param uuid the UUID of the placit places
	 * @param companyId the primary key of the company
	 * @return the matching placit places, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getPlacitPlacesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of placit places matching the UUID and company.
	 *
	 * @param uuid the UUID of the placit places
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching placit places, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PlacitPlace> getPlacitPlacesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator);

	/**
	 * Returns the number of placit places.
	 *
	 * @return the number of placit places
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPlacitPlacesCount();

	/**
	 * Supprime une entité
	 */
	public PlacitPlace removePlacitPlace(long placitPlaceId)
		throws PortalException;

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(SearchContext searchContext) throws SearchException;

	/**
	 * Updates the placit place in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PlacitPlace updatePlacitPlace(PlacitPlace placitPlace);

	/**
	 * Met à jour un lieu Placit et l'enregistre en base de données
	 */
	public PlacitPlace updatePlacitPlace(
			PlacitPlace placitPlace, ServiceContext sc)
		throws PortalException;

}