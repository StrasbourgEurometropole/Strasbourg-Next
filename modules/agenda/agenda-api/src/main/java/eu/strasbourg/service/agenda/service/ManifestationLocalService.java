/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

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

import eu.strasbourg.service.agenda.model.Manifestation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Manifestation. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author BenjaminBini
 * @see ManifestationLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.agenda.model.Manifestation"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ManifestationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.ManifestationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the manifestation local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ManifestationLocalServiceUtil} if injection and service tracking are not available.
	 */
	public boolean addEventManifestation(long eventId, long manifestationId);

	public boolean addEventManifestation(
		long eventId, Manifestation manifestation);

	public boolean addEventManifestations(
		long eventId, List<Manifestation> manifestations);

	public boolean addEventManifestations(
		long eventId, long[] manifestationIds);

	/**
	 * Adds the manifestation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ManifestationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param manifestation the manifestation
	 * @return the manifestation that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Manifestation addManifestation(Manifestation manifestation);

	/**
	 * Modifie le statut de tous les manifestations au statut "SCHEDULED" qui
	 * ont une date de publication dans le futur
	 */
	public void checkManifestations() throws PortalException;

	public void clearEventManifestations(long eventId);

	/**
	 * Creates a new manifestation with the primary key. Does not add the manifestation to the database.
	 *
	 * @param manifestationId the primary key for the new manifestation
	 * @return the new manifestation
	 */
	@Transactional(enabled = false)
	public Manifestation createManifestation(long manifestationId);

	/**
	 * Crée un lien vide avec une PK, non ajouté à la base de donnée
	 */
	public Manifestation createManifestation(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteEventManifestation(long eventId, long manifestationId);

	public void deleteEventManifestation(
		long eventId, Manifestation manifestation);

	public void deleteEventManifestations(
		long eventId, List<Manifestation> manifestations);

	public void deleteEventManifestations(
		long eventId, long[] manifestationIds);

	/**
	 * Deletes the manifestation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ManifestationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation that was removed
	 * @throws PortalException if a manifestation with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Manifestation deleteManifestation(long manifestationId)
		throws PortalException;

	/**
	 * Deletes the manifestation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ManifestationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param manifestation the manifestation
	 * @return the manifestation that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Manifestation deleteManifestation(Manifestation manifestation);

	/**
	 * Supprime les manifestations dépubliés depuis au moins un mois
	 */
	public void deleteOldUnpublishedManifestations() throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ManifestationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ManifestationModelImpl</code>.
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
	public Manifestation fetchManifestation(long manifestationId);

	/**
	 * Returns the manifestation matching the UUID and group.
	 *
	 * @param uuid the manifestation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Manifestation fetchManifestationByUuidAndGroupId(
		String uuid, long groupId);

	public Manifestation findByIdSource(String idSource);

	public List<Manifestation> findByKeyword(
		String keyword, long groupId, int start, int end);

	public long findByKeywordCount(String keyword, long groupId);

	public Manifestation findBySourceAndIdSource(
		String source, String idSource);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne toutes les galeries éditions d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Manifestation> getByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Manifestation> getEventManifestations(long eventId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Manifestation> getEventManifestations(
		long eventId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Manifestation> getEventManifestations(
		long eventId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventManifestationsCount(long eventId);

	/**
	 * Returns the eventIds of the events associated with the manifestation.
	 *
	 * @param manifestationId the manifestationId of the manifestation
	 * @return long[] the eventIds of events associated with the manifestation
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getEventPrimaryKeys(long manifestationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the manifestation with the primary key.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation
	 * @throws PortalException if a manifestation with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Manifestation getManifestation(long manifestationId)
		throws PortalException;

	/**
	 * Returns the manifestation matching the UUID and group.
	 *
	 * @param uuid the manifestation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching manifestation
	 * @throws PortalException if a matching manifestation could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Manifestation getManifestationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of manifestations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Manifestation> getManifestations(int start, int end);

	/**
	 * Returns all the manifestations matching the UUID and company.
	 *
	 * @param uuid the UUID of the manifestations
	 * @param companyId the primary key of the company
	 * @return the matching manifestations, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Manifestation> getManifestationsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of manifestations matching the UUID and company.
	 *
	 * @param uuid the UUID of the manifestations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching manifestations, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Manifestation> getManifestationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator);

	/**
	 * Returns the number of manifestations.
	 *
	 * @return the number of manifestations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getManifestationsCount();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEventManifestation(long eventId, long manifestationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEventManifestations(long eventId);

	/**
	 * Delete an Event Manifestation
	 *
	 * @param manifestationId
	 The ID of the event manifestation to delete
	 * @return The deleted Manifestation
	 * @throws PortalException
	 */
	public Manifestation removeManifestation(long manifestationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(SearchContext searchContext) throws SearchException;

	public void setEventManifestations(long eventId, long[] manifestationIds);

	/**
	 * Dépublie les manifestations dont la date de fin est dépassée
	 */
	public void unpublishPastManifestations() throws PortalException;

	/**
	 * Updates the manifestation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ManifestationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param manifestation the manifestation
	 * @return the manifestation that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Manifestation updateManifestation(Manifestation manifestation);

	/**
	 * Met à jour un lien et l'enregistre en base de données
	 */
	public Manifestation updateManifestation(
			Manifestation manifestation, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut de la galerie par le framework workflow
	 */
	public Manifestation updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

	/**
	 * Met à jour le statut de la galerie "manuellement" (pas via le workflow)
	 */
	public void updateStatus(Manifestation manifestation, int status)
		throws PortalException;

}