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

package eu.strasbourg.service.agenda.service.impl;

import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.asset.link.model.AssetLink;
import com.liferay.asset.link.service.AssetLinkLocalService;
import com.liferay.asset.link.service.AssetLinkLocalServiceUtil;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import eu.strasbourg.service.agenda.exception.NoSuchEventException;
import eu.strasbourg.service.agenda.model.CacheJson;
import eu.strasbourg.service.agenda.model.CsmapCacheJson;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.EventModel;
import eu.strasbourg.service.agenda.model.EventParticipation;
import eu.strasbourg.service.agenda.model.EventPeriod;
import eu.strasbourg.service.agenda.model.Historic;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.agenda.service.EventParticipationLocalServiceUtil;
import eu.strasbourg.service.agenda.service.EventPeriodLocalServiceUtil;
import eu.strasbourg.service.agenda.service.base.EventLocalServiceBaseImpl;
import eu.strasbourg.service.agenda.utils.AgendaImporter;
import eu.strasbourg.service.comment.exception.NoSuchCommentException;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.models.StopTime;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * The implementation of the event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link eu.strasbourg.service.agenda.service.EventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author BenjaminBini
 * @see EventLocalServiceBaseImpl
 * @see eu.strasbourg.service.agenda.service.EventLocalServiceUtil
 */
@ProviderType
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * eu.strasbourg.service.agenda.service.EventLocalServiceUtil} to access the
	 * event local service.
	 */

	/**
	 * Crée une édition vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public Event createEvent(ServiceContext sc) throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		long pk = counterLocalService.increment();

		Event event = this.eventLocalService.createEvent(pk);

		event.setGroupId(sc.getScopeGroupId());
		event.setCompanyId(sc.getCompanyId());
		event.setUserName(user.getFullName());
		event.setUserId(sc.getUserId());

		event.setStatus(WorkflowConstants.STATUS_DRAFT);

		return event;
	}

	/**
	 * Met à jour un event et l'enregistre en base de données
	 * @throws IOException 
	 */
	@Override
	public Event updateEvent(Event event, ServiceContext sc)
		throws PortalException, IOException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		event.setCompanyId(sc.getCompanyId());
		event.setStatusByUserId(sc.getUserId());
		event.setStatusByUserName(user.getFullName());
		event.setStatusDate(sc.getModifiedDate());
		event.setImageHeight(0);
		event.setImageWidth(0);

		try {
			if(event.getImageId() == null || event.getImageId() == 0) {
				URL url = new URL(event.getExternalImageURL());
				final BufferedImage bi = ImageIO.read(url);
				event.setImageHeight(bi.getHeight());
				event.setImageWidth(bi.getWidth());
			}
			else {
				String imageURL = FileEntryHelper.getFileEntryURL(event.getImageId());

				String completeImageURL = StrasbourgPropsUtil.getURL() + imageURL;
				URL url = new URL(completeImageURL);
				final BufferedImage bi = ImageIO.read(url);
				event.setImageHeight(bi.getHeight());
				event.setImageWidth(bi.getWidth());
			}
		}catch (Exception e){
			_log.warn("Evenement : " + event.getTitle(Locale.FRANCE) + " image : " + event.getImageId() + "\n" + e);
		}

		if (event.getEventPeriods().size() > 0) {
			List<EventPeriod> periods = new ArrayList<EventPeriod>(
				event.getEventPeriods());

			// On classe les périodes par date de début, ce qui va nous
			// permettre de setter le champ "firstStartDate" sur l'événement
			periods.sort(
				(p1, p2) -> p1.getStartDate().compareTo(p2.getStartDate()));
			EventPeriod firstPeriod = periods.get(0);
			Date firstStartDate = firstPeriod.getStartDate();
			if(Validator.isNotNull(firstPeriod.getStartTime())) {
				LocalTime firstStartLocalTime = LocalTime.parse(firstPeriod.getStartTime());
				Calendar firstStartDateTime = getCalendar(firstStartDate, firstStartLocalTime);
				event.setFirstStartDate(firstStartDateTime.getTime());
			}else
				event.setFirstStartDate(firstStartDate);


			// On classe les périodes par date de fin, ce qui va nous
			// permettre de setter le champ "lastEndDate" sur l'événement
			periods.sort(
					(p1, p2) -> p1.getEndDate().compareTo(p2.getEndDate()));
			EventPeriod lastPeriod = periods.get(periods.size() - 1);
			Date lastEndDate = lastPeriod.getEndDate();
			// s'il n'y a pas d'heure de fin, on set 23:59:59
			LocalTime lastEndLocalTime = LocalTime.parse("23:59:59");
			Calendar lastEndDateTime;
			if(Validator.isNotNull(lastPeriod.getEndTime())) {
				lastEndLocalTime = LocalTime.parse(lastPeriod.getEndTime());
				lastEndDateTime = getCalendar(lastEndDate, lastEndLocalTime);
				// si l'heure de fin de l'event est après minuit, mais avant l'heure de début et que c'est une période récurrente, on ajout un jour
				if (lastPeriod.getIsRecurrent() && Validator.isNotNull(firstPeriod.getStartTime()) && lastEndLocalTime.isAfter(LocalTime.parse("00:00"))) {
					LocalTime lastStartLocalTime = LocalTime.parse(lastPeriod.getStartTime());
					if (lastEndLocalTime.isBefore(lastStartLocalTime))
						lastEndDateTime.add(Calendar.DATE, 1);
				}
			}else {
				lastEndDateTime = getCalendar(lastEndDate, lastEndLocalTime);
			}
			event.setLastEndDate(lastEndDateTime.getTime());
			event.setIsRecurrent(lastPeriod.getIsRecurrent());
		}

		// Si on n'utilise pas le framework workflow, simple gestion
		// brouillon/publié
		if (!WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
			sc.getCompanyId(), sc.getScopeGroupId(), Event.class.getName())) {
			if (sc.getWorkflowAction() == WorkflowConstants.ACTION_PUBLISH) {
				if (event.getPublicationDate().after(new Date())) {
					event.setStatus(WorkflowConstants.STATUS_SCHEDULED);
				} else {
					event.setStatus(WorkflowConstants.STATUS_APPROVED);
				}
			} else {
				event.setStatus(WorkflowConstants.STATUS_DRAFT);
				// Si le statut est "DRAFT" et qu'il y a une version live, on
				// supprime cette dernière
				Event liveEvent = event.getLiveVersion();
				if (liveEvent != null) {
					this.removeEvent(liveEvent.getEventId());
				}
			}
			event = this.eventLocalService.updateEvent(event);
			this.updateAssetEntry(event, sc);
			this.reindex(event, false);
		} else { // Si le framework worflow est actif, c'est celui-ci qui gère
				 // l'enregistrement
			event = this.eventLocalService.updateEvent(event);
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
				event.getCompanyId(), event.getGroupId(), event.getUserId(),
				Event.class.getName(), event.getPrimaryKey(), event, sc);
		}

		// Génération des caches
		createCacheJSON(event);

		return event;
	}

	private static Calendar getCalendar(Date date, LocalTime time) {
		Calendar dateTime = new GregorianCalendar();
		dateTime.setTime(date);
		dateTime.set(Calendar.HOUR_OF_DAY,time.getHour());
		dateTime.set(Calendar.MINUTE,time.getMinute());
		dateTime.set(Calendar.SECOND,time.getSecond());
		dateTime.set(Calendar.MILLISECOND,0);
		return dateTime;
	}

	/**
	 * Généréation des caches pour API et CSMap
	 * Appelé après un UPDATE(event,sc) et lors de l'import des lieux
	 * @param event
	 */
	@Override
	public void createCacheJSON(Event event) throws PortalException {

		//Mise à jour pour CSMap
		CsmapCacheJson csmapCacheJson = this.csmapCacheJsonLocalService.fetchCsmapCacheJson(event.getEventId());
		if(Validator.isNull(csmapCacheJson)){
			csmapCacheJson = this.csmapCacheJsonLocalService.createCsmapCacheJson(event.getEventId());
			csmapCacheJson.setCreateEvent(event.getCreateDate());

			// si il a été supprimé, on enlève la ligne dans historic
			if(Validator.isNotNull(this.historicLocalService.fetchHistoric(event.getEventId())))
				this.historicLocalService.deleteHistoric(event.getEventId());
		}
		csmapCacheJson.setModifiedEvent(event.getModifiedDate());
		JSONObject csmapJson = event.getCSMapJSON();
		csmapCacheJson.setJsonEvent(csmapJson.toString());
		if(csmapJson.getJSONArray("schedules").length() > 0)
			csmapCacheJson.setHasSchedules(true);
		else
			csmapCacheJson.setHasSchedules(false);
		csmapCacheJson.setRegeneratedDate(event.getModifiedDate());
		csmapCacheJson.setIsActive((event.getStatus()==WorkflowConstants.STATUS_APPROVED)?true:false);
		this.csmapCacheJsonLocalService.updateCsmapCacheJson(csmapCacheJson);

		//Mise à jour pour Cache
		CacheJson cacheJson = this.cacheJsonLocalService.fetchCacheJson(event.getEventId());
		if(Validator.isNull(cacheJson)){
			cacheJson = this.cacheJsonLocalService.createCacheJson(event.getEventId());
			cacheJson.setCreateEvent(event.getCreateDate());

			// si il a été supprimé, on enlève la ligne dans historic
			if(Validator.isNotNull(this.historicLocalService.fetchHistoric(event.getEventId())))
				this.historicLocalService.deleteHistoric(event.getEventId());
		}
		cacheJson.setModifiedEvent(event.getModifiedDate());
		JSONObject eventJson = event.toJSON();
		if (Validator.isNotNull(event.getPlaceSIGId())) {
			Place place = PlaceLocalServiceUtil.getPlaceBySIGId(event.getPlaceSIGId());
			if(place != null)
				eventJson.put("place", place.toJSON());
		}
		cacheJson.setJsonEvent(eventJson.toString());
		cacheJson.setIsApproved(event.getStatus() == WorkflowConstants.STATUS_APPROVED);
		this.cacheJsonLocalService.updateCacheJson(cacheJson);
	}

	/**
	 * Convertit une liste d'événements en TreeMap, avec pour clé les dates
	 * @param entries
	 * @return
	 */
	@Override
	public TreeMap<Date, List<AssetEntry>> convertEventsToTreeMap(List<AssetEntry> entries) {
		TreeMap<Date, List<AssetEntry>> eventsByDate = new TreeMap<>();
		for (AssetEntry entry : entries) {
			long eventEntryId = entry.getClassPK();

			// Fetch the Event directly by entryId, reducing database calls
			Event event = EventLocalServiceUtil.fetchEvent(eventEntryId);

			if (event != null) {
				List<EventPeriod> eventPeriods = event.getEventPeriods();
				for (EventPeriod eventPeriod : eventPeriods) {
					List<LocalDate> dateRange = generateDateRange(eventPeriod.getStartDate().toInstant().atZone(ZoneId.of("UTC")).toLocalDate(), eventPeriod.getEndDate().toInstant().atZone(ZoneId.of("UTC")).toLocalDate());
					for (LocalDate eventDate : dateRange) {
						if(eventDate.isBefore(LocalDate.now())) {
							continue;
						}
						eventsByDate.computeIfAbsent(Date.from(eventDate.atStartOfDay(ZoneId.of("UTC")).toInstant()), k -> new ArrayList<>()).add(entry);
					}

				}
			}
		}

		return eventsByDate;
	}

	public static List<LocalDate> generateDateRange(LocalDate startDate, LocalDate endDate) {
		List<LocalDate> dateRange = new ArrayList<>();

		LocalDate currentDate = startDate;
		while (!currentDate.isAfter(endDate)) {
			dateRange.add(currentDate);
			currentDate = currentDate.plusDays(1); // Move to the next day
		}

		return dateRange;
	}

	/**
	 * Met à jour l'AssetEntry rattachée à l'édition
	 */
	private void updateAssetEntry(Event event, ServiceContext sc)
		throws PortalException {
		this.assetEntryLocalService.updateEntry(sc.getUserId(), // User ID
			sc.getScopeGroupId(), // Group ID
			event.getCreateDate(), // Date of creation
			event.getModifiedDate(), // Date of modification
			Event.class.getName(), // Class name
			event.getPrimaryKey(), // Class PK
			event.getUuid(), // UUID
			0, // Class type ID
			sc.getAssetCategoryIds(), // Categories IDs
			sc.getAssetTagNames(), // Tags IDs
			true, // Listable
			event.isApproved(), // Visible
			event.getPublicationDate(), // Start date
			null, // End date
			event.getPublicationDate(), // Publication date
			null, // Date of expiration
			ContentTypes.TEXT_HTML, // Content type
			event.getTitle(), // Title
			event.getDescription(), // Description
			event.getDescription(), // Summary
			null, // URL
			null, // Layout uuid
			0, // Width
			0, // Height
			null); // Priority

		// Réindexe l'édition
		this.reindex(event, false);
	}

	/**
	 * Met à jour le statut de l'édition par le framework workflow
	 */
	@Override
	public Event updateStatus(long userId, long entryId, int status,
		ServiceContext sc, Map<String, Serializable> workflowContext)
		throws PortalException {
		Date now = new Date();
		Event event = this.getEvent(entryId);

		event.setStatus(status);
		User user = UserLocalServiceUtil.fetchUser(userId);
		if (user != null) {
			event.setStatusByUserId(user.getUserId());
			event.setStatusByUserName(user.getFullName());
		}
		event.setStatusDate(new Date());
		if (event.isApproved()) {
			event.setPublicationDate(now);
		}

		event = this.eventLocalService.updateEvent(event);

		AssetEntry entry = this.assetEntryLocalService
			.getEntry(Event.class.getName(), event.getPrimaryKey());
		entry.setVisible(status == WorkflowConstants.STATUS_APPROVED);
		if (entry.isVisible()) {
			entry.setPublishDate(now);
		}
		this.assetEntryLocalService.updateAssetEntry(entry);

		this.reindex(event, false);

		// Si le nouveau statut est "DRAFT" et qu'il y a une version live, on
		// supprime cette dernière
		Event liveEvent = event.getLiveVersion();
		if (status == WorkflowConstants.STATUS_DRAFT && liveEvent != null) {
			this.removeEvent(liveEvent.getEventId());
		}

		//Mise à jour pour CSMap
		CsmapCacheJson csmapCacheJson = this.csmapCacheJsonLocalService.fetchCsmapCacheJson(event.getEventId());
		if(Validator.isNotNull(csmapCacheJson)){
			csmapCacheJson.setModifiedEvent(event.getModifiedDate());
			csmapCacheJson.setIsActive(event.getStatus() == WorkflowConstants.STATUS_APPROVED);
			this.csmapCacheJsonLocalService.updateCsmapCacheJson(csmapCacheJson);
		}

		//Mise à jour pour cache
		CacheJson cacheJson = this.cacheJsonLocalService.fetchCacheJson(event.getEventId());
		if(Validator.isNotNull(cacheJson)){
			cacheJson.setModifiedEvent(event.getModifiedDate());
			cacheJson.setIsApproved(event.getStatus() == WorkflowConstants.STATUS_APPROVED);
			this.cacheJsonLocalService.updateCacheJson(cacheJson);
		}

		return event;
	}

	/**
	 * Met à jour le statut de l'édition "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(Event event, int status) throws PortalException {
		this.updateStatus(event.getUserId(), event.getEventId(), status, null,
			null);
	}

	/**
	 * Modifie le statut de tous les events au statut "SCHEDULED" qui ont une
	 * date de publication dans le futur.
	 */
	@Override
	public void checkEvents() throws PortalException {
		List<Event> events = this.eventPersistence
			.findByPublicationDateAndStatus(new Date(),
				WorkflowConstants.STATUS_SCHEDULED);
		int n = 0;
		for (Event event : events) {
			this.updateStatus(event, WorkflowConstants.STATUS_APPROVED);
			n++;
		}
		if (n > 0) {
			_log.info("Published " + n + " events");
		}
	}

	/**
	 * Dépublie les événements dont la dernière date de fin est dépassée
	 */
	@Override
	public void unpublishPastEvents() throws PortalException {
		List<Event> events = this.eventPersistence
			.findByLastEndDateAndNotStatus(new Date(), WorkflowConstants.STATUS_DRAFT);
		for (Event event : events) {
			this.updateStatus(event, WorkflowConstants.STATUS_DRAFT);
		}
	}

	/**
	 * Supprime les événements dépubliés depuis au moins un mois
	 */
	@Override
	public void deleteOldUnpublishedEvents() throws PortalException {
		LocalDate oneMonthAgoLocalDate = LocalDate.now().minusMonths(1);
		Date oneMonthAgo = Date.from(oneMonthAgoLocalDate
			.atStartOfDay(ZoneId.systemDefault()).toInstant());
		List<Event> events = this.eventPersistence.findByStatusDateAndStatus(
			oneMonthAgo, WorkflowConstants.STATUS_DRAFT);
		for (Event event : events) {
			this.removeEvent(event.getEventId());
		}
	}

	/**
	 * Delete an Event
	 * 
	 * @param eventId
	 *            The ID of the event to delete
	 * @return The deleted Event
	 * @throws PortalException
	 */
	@Override
	public Event removeEvent(long eventId) throws PortalException {
		AssetEntry entry = AssetEntryLocalServiceUtil
			.fetchEntry(Event.class.getName(), eventId);

		if (entry != null) {
			// Delete the link with categories
			AssetEntryAssetCategoryRelLocalServiceUtil.
					deleteAssetEntryAssetCategoryRelByAssetEntryId(entry.getEntryId());

			// Delete the link with tags
			long[] tagIds = AssetEntryLocalServiceUtil
				.getAssetTagPrimaryKeys(entry.getEntryId());
			for (int i = 0; i < tagIds.length; i++) {
				AssetEntryLocalServiceUtil.deleteAssetTagAssetEntry(tagIds[i],
					entry.getEntryId());
			}

			// Supprime lien avec les autres entries
			List<AssetLink> links = AssetLinkLocalServiceUtil
				.getLinks(entry.getEntryId());
			for (AssetLink link : links) {
				this.assetLinkLocalService.deleteAssetLink(link);
			}

			// Supprime l'assetEntry
			AssetEntryLocalServiceUtil.deleteEntry(Event.class.getName(),
				eventId);

			// Supprime les Comments
			try {
				// Récupère uniquement les commentaires de niveau 1, les enfants sont gérés par la méthode de supprssion
				List<Comment> comments = CommentLocalServiceUtil.getByAssetEntryAndLevel(entry.getEntryId(), 1,0);
				if (comments != null && !comments.isEmpty()) {
					for (Comment comment : comments) {
						CommentLocalServiceUtil.removeComment(comment.getCommentId());
					}
				}
			} catch (NoSuchCommentException e) {
				_log.error(e);
			}

			// Supprime les périodes
			List<EventPeriod> periods = EventPeriodLocalServiceUtil
				.getByEventId(eventId);
			for (EventPeriod period : periods) {
				EventPeriodLocalServiceUtil.deleteEventPeriod(period);
			}
			
			// Supprimer les participations des usagers aux events
			List<EventParticipation> participations = EventParticipationLocalServiceUtil.getByEventId(eventId);
			for(EventParticipation ep : participations) {
				EventParticipationLocalServiceUtil.deleteEventParticipation(ep);
			}
		}

		// Delete the Event
		Event event = eventPersistence.remove(eventId);

		// Delete the index
		this.reindex(event, true);

		// Supprime ce qui a rapport au workflow
		WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(
			event.getCompanyId(), event.getGroupId(), Event.class.getName(),
			event.getEventId());

		//Mise à jour pour CSMap
		if(Validator.isNotNull(csmapCacheJsonLocalService.fetchCsmapCacheJson(event.getEventId())))
			csmapCacheJsonLocalService.deleteCsmapCacheJson(event.getEventId());

		//Mise à jour pour Cache
		if(Validator.isNotNull(cacheJsonLocalService.fetchCacheJson(event.getEventId())))
			cacheJsonLocalService.deleteCacheJson(event.getEventId());

		Historic historic = historicLocalService.fetchHistoric(event.getEventId());
		if(Validator.isNull(historic))
			historic = historicLocalService.createHistoric(event.getEventId());
		historic.setTitle(event.getTitle());
		historic.setSuppressionDate(new Date());
		historicLocalService.updateHistoric(historic);
		
		return event;
	}

	/**
	 * Reindex l'édition dans le moteur de recherche
	 */
	private void reindex(Event event, boolean delete) throws SearchException {
		Indexer<Event> indexer = IndexerRegistryUtil
			.nullSafeGetIndexer(Event.class);
		if (delete) {
			indexer.delete(event);
		} else {
			indexer.reindex(event);
		}
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité Event
	 */
	@Override
	public List<AssetVocabulary> getAttachedVocabularies(long groupId) {
		List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil
			.getAssetVocabularies(-1, -1);
		List<AssetVocabulary> attachedVocabularies = new ArrayList<AssetVocabulary>();
		long classNameId = ClassNameLocalServiceUtil
			.getClassNameId(Event.class);
		for (AssetVocabulary vocabulary : vocabularies) {
			if (vocabulary.getGroupId() == groupId
				&& LongStream.of(vocabulary.getSelectedClassNameIds())
					.anyMatch(c -> c == classNameId)) {
				attachedVocabularies.add(vocabulary);
			}
		}
		return attachedVocabularies;
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	@Override
	public List<Event> getByGroupId(long groupId) {
		return this.eventPersistence.findByGroupId(groupId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		Indexer<Event> indexer = IndexerRegistryUtil
			.nullSafeGetIndexer(Event.class);
		return indexer.search(searchContext);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public List<Event> findByKeyword(String keyword, long groupId, int start,
		int end) {
		DynamicQuery dynamicQuery = dynamicQuery();

		if (keyword.length() > 0) {
			dynamicQuery.add(
				RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
		}
		if (groupId > 0) {
			dynamicQuery
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		}
		dynamicQuery.add(PropertyFactoryUtil.forName("status")
			.eq(WorkflowConstants.STATUS_APPROVED));

		return eventPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		DynamicQuery dynamicQuery = dynamicQuery();
		if (keyword.length() > 0) {
			dynamicQuery.add(
				RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
		}
		if (groupId > 0) {
			dynamicQuery
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		}
		dynamicQuery.add(PropertyFactoryUtil.forName("status")
			.eq(WorkflowConstants.STATUS_APPROVED));

		return eventPersistence.countWithDynamicQuery(dynamicQuery);
	}
	
	/**
	 * Retourne les resultats publiés
	 */
	@Override
	public List<Event> getPublished() {
		return this.eventPersistence.findByStatus(WorkflowConstants.STATUS_APPROVED);
	}
	
	/**
	 * Retourne les resultats possèdant en etiquette l'une appelation demandee
	 */
	@Override
	public List<Event> getByTagsWithOrSelection (List <String> tagLabels) {
		List<Event> results = new ArrayList<Event>();
		List<String> eventAssetTags;
		AssetEntry eventAsset;
		
		for (Event event : this.getPublished()) {
			eventAsset = event.getAssetEntry();
			
			eventAssetTags =  Arrays.asList(eventAsset.getTagNames());
			
			// Y'a t'il un element en commum entre les deux listes d'etiquette
			if (!Collections.disjoint(eventAssetTags, tagLabels)) {
				results.add(event);
			}
		}
		
		return results;
	}

	/**
	 * Retourne une list d'évènements lié à un lieu
	 */
	@Override
	public List<Event> getCurrentAndFuturePublishedEventsFromPlace(String SIGId) {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		List<Event> events = this.findByPlaceSIGId(SIGId);
		return events.stream().filter(e -> e.isApproved() && e.getStartDateFirstCurrentAndFuturePeriod().compareTo(yesterday) > 0).collect(Collectors.toList());
	}

	/**
	 * Lance l'import des événements
	 * @throws IOException 
	 */
	@Override
	public boolean doImport() throws Exception {
		AgendaImporter agendaImporter = new AgendaImporter();
		agendaImporter.doImport();
		return true;
	}
	
	@Override
	public Event findBySourceAndIdSource(String source, String idSource) {
		try {
			return eventPersistence.findBySourceAndIdSource(source, idSource);
		} catch (NoSuchEventException e) {
			return null;
		}
	}

    @Override
	public List<Event> findEventByUserPublikId(String publikId){
		List<EventParticipation> resultList = eventParticipationLocalService.getByPublikUser(publikId);
		List<Event> eventList = resultList.stream().map(result -> {
			Event event = null;
			try {
				event = getEvent(result.getEventId());
			} catch (PortalException e) {
				_log.error(e.getMessage() + " : " + result);
			}
			return event;
		}).collect(Collectors.toList());
		return eventList.stream()
				.filter(EventModel::isApproved)
				.collect(Collectors.toList());
	}

	/**
	 * Retourne les évènements triés par prochaine date de représentation
	 */
	@Override
	public List<Event> findByNextHappening() {
		return eventFinder.findByNextHappening();
	}
    
    /**
	 * Lance une recherche par placeSIGId
	 */
	@Override
	public List<Event> findByPlaceSIGId(String placeSIGId) {
		return eventPersistence.findByPlaceSIGId(placeSIGId);
	}

	/**
	 * Recherche des Evenements
	 * @param idsEvents: liste des identifiants
	 * @return
	 */
	public List <Event> findByids(List<Long> idsEvents){
		if(idsEvents.isEmpty()) {
			return new ArrayList<Event>();
		}
		DynamicQuery eventDynamicQuery = this.dynamicQuery();
		eventDynamicQuery.add(PropertyFactoryUtil.forName("eventId").in(idsEvents));
		return this.dynamicQuery(eventDynamicQuery);
	}

	/**
	 * Transform le timeDetail en startTime et endTime si on peut
	 */
	@Override
	public List<String[]> getTimeDetailFormated(String timeDetail){
		List<String[]> timesSchedule = new ArrayList<>();

		// regexp de l'heure
		// catche les horaires en 0-23h0-59m0-59
		String timeRegex = "(((?<![0-9])[0-9](?![0-9]))|([0-1][0-9]|2[0-3]))( ?(h|:) ?)([0-5](\\d)?)?(( ?(m|:) ?)([0-5](\\d)?)?)?";

		Pattern timePattern = Pattern.compile(timeRegex, Pattern.CASE_INSENSITIVE);
		Pattern between2TimesPattern = Pattern.compile("( ?[-àa>\\u00E0] ?)", Pattern.CASE_INSENSITIVE);

		// on récupère toutes les heures trouvées
		Matcher timesMatcher = timePattern.matcher(timeDetail);
		// on récupère dans une liste tout ce qu'il y a entre les heures
		List<String> timesTexts = timePattern.splitAsStream(timeDetail).collect(Collectors.toList());

		String startTime = "", endTime = "";
		int i = 0;
		while(timesMatcher.find()) { // se positionne sur l'heure suivante (commence par la 1ere)
			if(Validator.isNull(startTime))
				startTime = getTimeFormated(timesMatcher.group()); // .group récupère la valeur de l'heure
			else {
				String between2Times = timesTexts.get(i);
				List<String> between2TimesTexts = between2TimesPattern.splitAsStream(between2Times).collect(Collectors.toList());
				if (between2TimesTexts.size() == 0 || Validator.isNull(between2TimesTexts.get(0))) {
					Matcher between2TimesMarcher = between2TimesPattern.matcher(between2Times);
					if (between2TimesMarcher.find()) {
						endTime = getTimeFormated(timesMatcher.group());
						String[] timeSchedule = {startTime, endTime};
						timesSchedule.add(timeSchedule);
						startTime = "";
						endTime = "";
					}
				}else{
					// si on rentre là c'est qu'on n'a pas d'heure de fin
					endTime = null;
					String[] timeSchedule = {startTime, endTime};
					timesSchedule.add(timeSchedule);
					startTime = getTimeFormated(timesMatcher.group());
					endTime = "";
				}
			}
			i++;
		}

		// c'est une phrase et non un horaire on renvoi minuit
		if(i == 0) {
			startTime = "00:00:00";
			endTime = null;
			String[] timeSchedule = {startTime, endTime};
			timesSchedule.add(timeSchedule);
		}else{
			if(Validator.isNotNull(startTime)) {
				if(Validator.isNull(endTime)) {
					endTime = null;
				}
				String[] timeSchedule = {startTime, endTime};
				timesSchedule.add(timeSchedule);
			}
		}

		return timesSchedule;
	}

	private String getTimeFormated(String time){
		String hourRegex = "( ?(h|:) ?)";
		Pattern formatHourPattern = Pattern.compile(hourRegex, Pattern.CASE_INSENSITIVE);
		// on récupère dans une liste tout ce qu'il y a entre les regex trouvé
		List<String> heureMinuteSeconde = formatHourPattern.splitAsStream(time).collect(Collectors.toList());
		String heure = (String.valueOf(heureMinuteSeconde.get(0)).length() == 1 ? "0" : "") + heureMinuteSeconde.get(0);

		String minute = "00";
		String seconde = "00";
		if(heureMinuteSeconde.size() > 1){
			if(heureMinuteSeconde.size() == 2){
				String minuteRegex = "( ?m ?)";
				Pattern formatMinutePattern = Pattern.compile(minuteRegex, Pattern.CASE_INSENSITIVE);
				List<String> minuteSeconde = formatMinutePattern.splitAsStream(heureMinuteSeconde.get(heureMinuteSeconde.size() - 1)).collect(Collectors.toList());
				minute = (String.valueOf(minuteSeconde.get(0)).length() == 1 ? "0" : "") + minuteSeconde.get(0);
				if(minuteSeconde.size() > 1){
					seconde = (String.valueOf(minuteSeconde.get(minuteSeconde.size()-1)).length() == 1 ? "0" : "") + minuteSeconde.get(minuteSeconde.size()-1);
				}
			}else{
				minute = (String.valueOf(heureMinuteSeconde.get(1)).length() == 1 ? "0" : "") + heureMinuteSeconde.get(1);
				seconde = (String.valueOf(heureMinuteSeconde.get(2)).length() == 1 ? "0" : "") + heureMinuteSeconde.get(2);
			}
		}

		return heure + ":" + minute + ":" + seconde;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass());

	@BeanReference(
			type = eu.strasbourg.service.agenda.service.CsmapCacheJsonLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.CsmapCacheJsonLocalService
			csmapCacheJsonLocalService;

	@BeanReference(
			type = eu.strasbourg.service.agenda.service.CacheJsonLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.CacheJsonLocalService
			cacheJsonLocalService;

	@BeanReference(
			type = eu.strasbourg.service.agenda.service.HistoricLocalService.class
	)
	protected eu.strasbourg.service.agenda.service.HistoricLocalService
			historicLocalService;

	@Reference
	private AssetLinkLocalService assetLinkLocalService;

}