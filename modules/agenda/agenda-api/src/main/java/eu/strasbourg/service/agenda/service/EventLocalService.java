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

import eu.strasbourg.service.agenda.model.Event;

import java.io.IOException;
import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Event. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author BenjaminBini
 * @see EventLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=eu.strasbourg.service.agenda.model.Event"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EventLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.EventLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the event local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EventLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the event to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param event the event
	 * @return the event that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Event addEvent(Event event);

	public boolean addManifestationEvent(long manifestationId, Event event);

	public boolean addManifestationEvent(long manifestationId, long eventId);

	public boolean addManifestationEvents(
		long manifestationId, List<Event> events);

	public boolean addManifestationEvents(
		long manifestationId, long[] eventIds);

	/**
	 * Modifie le statut de tous les events au statut "SCHEDULED" qui ont une
	 * date de publication dans le futur.
	 */
	public void checkEvents() throws PortalException;

	public void clearManifestationEvents(long manifestationId);

	/**
	 * Généréation des caches pour API et CSMap
	 * Appelé après un UPDATE(event,sc) et lors de l'import des lieux
	 *
	 * @param event
	 */
	public void createCacheJSON(Event event) throws PortalException;

	/**
	 * Creates a new event with the primary key. Does not add the event to the database.
	 *
	 * @param eventId the primary key for the new event
	 * @return the new event
	 */
	@Transactional(enabled = false)
	public Event createEvent(long eventId);

	/**
	 * Crée une édition vide avec une PK, non ajouté à la base de donnée
	 */
	public Event createEvent(ServiceContext sc) throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the event from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param event the event
	 * @return the event that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Event deleteEvent(Event event);

	/**
	 * Deletes the event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventId the primary key of the event
	 * @return the event that was removed
	 * @throws PortalException if a event with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Event deleteEvent(long eventId) throws PortalException;

	public void deleteManifestationEvent(long manifestationId, Event event);

	public void deleteManifestationEvent(long manifestationId, long eventId);

	public void deleteManifestationEvents(
		long manifestationId, List<Event> events);

	public void deleteManifestationEvents(
		long manifestationId, long[] eventIds);

	/**
	 * Supprime les événements dépubliés depuis au moins un mois
	 */
	public void deleteOldUnpublishedEvents() throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Lance l'import des événements
	 *
	 * @throws IOException
	 */
	public boolean doImport() throws Exception;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventModelImpl</code>.
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
	public Event fetchEvent(long eventId);

	/**
	 * Returns the event matching the UUID and group.
	 *
	 * @param uuid the event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching event, or <code>null</code> if a matching event could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Event fetchEventByUuidAndGroupId(String uuid, long groupId);

	/**
	 * Recherche des Evenements
	 *
	 * @param idsEvents: liste des identifiants
	 * @return
	 */
	public List<Event> findByids(List<Long> idsEvents);

	/**
	 * Lance une recherche par mots-clés
	 */
	public List<Event> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Compte de la recherche par mots-clés
	 */
	public long findByKeywordCount(String keyword, long groupId);

	/**
	 * Retourne les évènements triés par prochaine date de représentation
	 */
	public List<Event> findByNextHappening();

	/**
	 * Lance une recherche par placeSIGId
	 */
	public List<Event> findByPlaceSIGId(String placeSIGId);

	public Event findBySourceAndIdSource(String source, String idSource);

	public List<Event> findEventByUserPublikId(String publikId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité Event
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getByGroupId(long groupId);

	/**
	 * Retourne les resultats possèdant en etiquette l'une appelation demandee
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getByTagsWithOrSelection(List<String> tagLabels);

	/**
	 * Retourne une list d'évènements lié à un lieu
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getCurrentAndFuturePublishedEventsFromPlace(
		String SIGId);

	/**
	 * Returns the event with the primary key.
	 *
	 * @param eventId the primary key of the event
	 * @return the event
	 * @throws PortalException if a event with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Event getEvent(long eventId) throws PortalException;

	/**
	 * Returns the event matching the UUID and group.
	 *
	 * @param uuid the event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching event
	 * @throws PortalException if a matching event could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Event getEventByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @return the range of events
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getEvents(int start, int end);

	/**
	 * Returns all the events matching the UUID and company.
	 *
	 * @param uuid the UUID of the events
	 * @param companyId the primary key of the company
	 * @return the matching events, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getEventsByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of events matching the UUID and company.
	 *
	 * @param uuid the UUID of the events
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching events, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getEventsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator);

	/**
	 * Returns the number of events.
	 *
	 * @return the number of events
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getManifestationEvents(long manifestationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getManifestationEvents(
		long manifestationId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getManifestationEvents(
		long manifestationId, int start, int end,
		OrderByComparator<Event> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getManifestationEventsCount(long manifestationId);

	/**
	 * Returns the manifestationIds of the manifestations associated with the event.
	 *
	 * @param eventId the eventId of the event
	 * @return long[] the manifestationIds of manifestations associated with the event
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getManifestationPrimaryKeys(long eventId);

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
	 * Retourne les resultats publiés
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Event> getPublished();

	/**
	 * Transform le timeDetail en startTime et endTime si on peut
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String[]> getTimeDetailFormated(String timeDetail);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasManifestationEvent(long manifestationId, long eventId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasManifestationEvents(long manifestationId);

	/**
	 * Delete an Event
	 *
	 * @param eventId
	 The ID of the event to delete
	 * @return The deleted Event
	 * @throws PortalException
	 */
	public Event removeEvent(long eventId) throws PortalException;

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(SearchContext searchContext) throws SearchException;

	public void setManifestationEvents(long manifestationId, long[] eventIds);

	/**
	 * Dépublie les événements dont la dernière date de fin est dépassée
	 */
	public void unpublishPastEvents() throws PortalException;

	/**
	 * Updates the event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param event the event
	 * @return the event that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Event updateEvent(Event event);

	/**
	 * Met à jour un event et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public Event updateEvent(Event event, ServiceContext sc)
		throws IOException, PortalException;

	/**
	 * Met à jour le statut de l'édition "manuellement" (pas via le workflow)
	 */
	public void updateStatus(Event event, int status) throws PortalException;

	/**
	 * Met à jour le statut de l'édition par le framework workflow
	 */
	public Event updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}