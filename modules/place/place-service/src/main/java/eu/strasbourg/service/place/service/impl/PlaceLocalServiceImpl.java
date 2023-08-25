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

package eu.strasbourg.service.place.service.impl;

import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
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
import eu.strasbourg.service.place.MairieStateSOAPClient;
import eu.strasbourg.service.place.ParkingStateClient;
import eu.strasbourg.service.place.PoolStateSOAPClient;
import eu.strasbourg.service.place.VelhopStateClient;
import eu.strasbourg.service.place.exception.NoSuchPlaceException;
import eu.strasbourg.service.place.model.CsmapCacheJson;
import eu.strasbourg.service.place.model.Historic;
import eu.strasbourg.service.place.model.Period;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.model.ScheduleException;
import eu.strasbourg.service.place.model.SubPlace;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.service.place.service.base.PlaceLocalServiceBaseImpl;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import org.osgi.annotation.versioning.ProviderType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The implementation of the place local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link eu.strasbourg.service.place.service.PlaceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PlaceLocalServiceBaseImpl
 * @see eu.strasbourg.service.place.service.PlaceLocalServiceUtil
 */
@ProviderType
public class PlaceLocalServiceImpl extends PlaceLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link
     * eu.strasbourg.service.place.service.PlaceLocalServiceUtil} to access the
     * place local service.
     */

    /**
     * Crée un lieu vide avec une PK, non ajouté à la base de donnée
     */
    @Override
    public Place createPlace(ServiceContext sc) throws PortalException {
        User user = UserLocalServiceUtil.getUser(sc.getUserId());

        long pk = counterLocalService.increment();

        Place place = this.placeLocalService.createPlace(pk);

        place.setGroupId(sc.getScopeGroupId());
        place.setUserName(user.getFullName());
        place.setUserId(sc.getUserId());

        place.setAccessForBlind(false);
        place.setAccessForDeaf(false);
        place.setAccessForDeficient(false);
        place.setAccessForElder(false);
        place.setAccessForWheelchair(false);
        place.setDisplayEvents(true);
        place.setSubjectToPublicHoliday(false);
        place.setRTEnabled(false);


        place.setImageHeight(0);
        place.setImageWidth(0);

        place.setStatus(WorkflowConstants.STATUS_DRAFT);

        return place;
    }

    /**
     * Met à jour un lieu et l'enregistre en base de données
     */
    @Override
    public Place updatePlace(Place place, ServiceContext sc)
            throws PortalException {
        User user = UserLocalServiceUtil.getUser(sc.getUserId());

        place.setStatusByUserId(sc.getUserId());
        place.setStatusByUserName(user.getFullName());
        place.setStatusDate(sc.getModifiedDate());

        try {
            if (place.getImageId() != 0) {
                String imageURL = FileEntryHelper.getFileEntryURL(place.getImageId());

                String completeImageURL = StrasbourgPropsUtil.getURL() + imageURL;
                URL url = new URL(completeImageURL);
                final BufferedImage bi = ImageIO.read(url);
                place.setImageHeight(bi.getHeight());
                place.setImageWidth(bi.getWidth());
            }
        } catch (Exception e) {
            log.warn("Lieu : " + place.getAlias(Locale.FRANCE) + " image : " + place.getImageId() + "\n" + e);
        }

        // Si on n'utilise pas le framework workflow, simple gestion
        // brouillon/publié
        if (!WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
                sc.getCompanyId(), sc.getScopeGroupId(),
                Place.class.getName())) {
            if (sc.getWorkflowAction() == WorkflowConstants.ACTION_PUBLISH) {
                place.setStatus(WorkflowConstants.STATUS_APPROVED);
            } else {
                place.setStatus(WorkflowConstants.STATUS_DRAFT);
            }
            place = this.placeLocalService.updatePlace(place);
            this.updateAssetEntry(place, sc);
        } else { // Si le framework worflow est actif, c'est celui-ci qui gère
            // l'enregistrement
            place = this.placeLocalService.updatePlace(place);
            WorkflowHandlerRegistryUtil.startWorkflowInstance(
                    place.getCompanyId(), place.getGroupId(), place.getUserId(),
                    Place.class.getName(), place.getPrimaryKey(), place, sc);
        }

        //Mise à jour pour CSMap
        CsmapCacheJson csmapCacheJson = this.csmapCacheJsonLocalService.fetchCsmapCacheJson(place.getSIGid());
        if (Validator.isNull(csmapCacheJson)) {
            csmapCacheJson = this.csmapCacheJsonLocalService.createCsmapCacheJson(place.getSIGid());
            csmapCacheJson.setCreatePlace(place.getCreateDate());

            // si il a été supprimé, on enlève la ligne dans historic
            if (Validator.isNotNull(this.historicLocalService.fetchHistoric(place.getSIGid())))
                this.historicLocalService.deleteHistoric(place.getSIGid());
        }
        csmapCacheJson.setModifiedPlace(place.getModifiedDate());
        csmapCacheJson.setJsonLieu(place.getCSMapJSON().toString());
        csmapCacheJson.setJsonHoraire(place.getScheduleCSMapJSON().toString());
        csmapCacheJson.setIsActive((place.getStatus() == WorkflowConstants.STATUS_APPROVED) ? true : false);
        this.csmapCacheJsonLocalService.updateCsmapCacheJson(csmapCacheJson);

        return place;
    }

    /**
     * Met à jour l'AssetEntry rattachée au lieu
     */
    private void updateAssetEntry(Place place, ServiceContext sc)
            throws PortalException {
        this.assetEntryLocalService.updateEntry(sc.getUserId(), // User ID
                sc.getScopeGroupId(), // Group ID
                place.getCreateDate(), // Date of creation
                place.getModifiedDate(), // Date of modification
                Place.class.getName(), // Class name
                place.getPrimaryKey(), // Class PK
                place.getUuid(), // UUID
                0, // Class type ID
                sc.getAssetCategoryIds(), // Categories IDs
                sc.getAssetTagNames(), // Tags IDs
                true, // Listable
                place.isApproved(), // Visible
                place.getCreateDate(), // Start date
                null, // End date
                place.getCreateDate(), // Publication date
                null, // Date of expiration
                ContentTypes.TEXT_HTML, // Content type
                place.getAlias(), // Title
                place.getPresentation(), // Description
                place.getPresentation(), // Summary
                null, // URL
                null, // Layout uuid
                0, // Width
                0, // Height
                null); // Priority

        // Réindexe l'place
        this.reindex(place, false);
    }

    /**
     * Met à jour le statut du lieu par le framework workflow
     */
    @Override
    public Place updateStatus(long userId, long entryId, int status,
                              ServiceContext sc, Map<String, Serializable> workflowContext)
            throws PortalException {
        Date now = new Date();
        // Statut de l'entité
        Place place = this.getPlace(entryId);
        place.setStatus(status);
        User user = UserLocalServiceUtil.fetchUser(userId);
        if (user != null) {
            place.setStatusByUserId(user.getUserId());
            place.setStatusByUserName(user.getFullName());
        }
        place.setStatusDate(new Date());
        place = this.placeLocalService.updatePlace(place);

        // Statut de l'entry
        AssetEntry entry = this.assetEntryLocalService
                .getEntry(Place.class.getName(), place.getPrimaryKey());
        entry.setVisible(status == WorkflowConstants.STATUS_APPROVED);
        if (entry.isVisible()) {
            entry.setPublishDate(now);
        }
        this.assetEntryLocalService.updateAssetEntry(entry);

        this.reindex(place, false);

        //Mise à jour pour CSMap
        CsmapCacheJson csmapCacheJson = this.csmapCacheJsonLocalService.fetchCsmapCacheJson(place.getSIGid());
        if (Validator.isNotNull(csmapCacheJson)) {
            csmapCacheJson.setModifiedPlace(place.getModifiedDate());
            csmapCacheJson.setIsActive((place.getStatus() == WorkflowConstants.STATUS_APPROVED) ? true : false);
            this.csmapCacheJsonLocalService.updateCsmapCacheJson(csmapCacheJson);
        }

        return place;
    }

    @Override
    public void updateRealTime() throws SearchException {
        updateRealTime(JSONFactoryUtil.createJSONArray());
    }

    @Override
    public void updateRealTime(JSONArray parkingJsonArray) throws SearchException {
        // System.out.println("Start import of places real time data");
        // System.out.println("RT import started");

        // Récupère tous les lieux ayant un externalId
        List<Place> places = this.getPlaces(-1, -1);
        List<Place> placesWithRT = places.stream().filter(p -> Validator.isNotNull(p.getRTExternalId()))
                .collect(Collectors.toList());

        // On boucle sur les lieux ayant du temps réel configuré
        for (Place place : placesWithRT) {

            String rtType = place.getRTType();
            long rtOccupation = place.getRTOccupation();
            long rtCapacity = place.getRTCapacity();
            long rtAvailable = place.getRTAvailable();
            String rtStatus = place.getRTStatus();
            Date rtLastUpdate = null;// date de la derniere met à jour success
            // System.out.println("Place : " + place.getAlias(Locale.FRANCE));
            // S'ils n'ont pas de type, on set le type correctement
            if (Validator.isNull(place.getRTType())) {
                // System.out.println("Set of type");
                for (AssetCategory type : place.getTypes()) {
                    String typeSigId = AssetVocabularyHelper.getCategoryProperty(type.getCategoryId(), "SIG");
                    if (typeSigId.toLowerCase().equals("cat_06_05")) { // Piscines
                        rtType = "1";
                        // System.out.println("Type 1");
                    } else if (typeSigId.toLowerCase().equals("cat_12_07")) { // Mairies
                        rtType = "3";
                        // System.out.println("Type 3");
                    } else if (typeSigId.toLowerCase().contains("cat_22")) { // Parkings
                        rtType = "2";
                        // System.out.println("Type 2");
                    } else if (typeSigId.toLowerCase().contains("cat_06_04")) { // Patinoire
                        rtType = "4";
                        // System.out.println("Type 4");
                    } else if (typeSigId.toLowerCase().contains("cat_02_14")) { // Station Vélhop
                        rtType = "5";
                        // System.out.println("Type 4");
                    }
                }
            }

            // On récupère les données temps réel
            if (!place.getRTExternalId().equals("NO")) {
                switch (place.getRTType()) {
                    case "1":
                        try {
                            rtLastUpdate = new Date();
                            long poolOccupation = PoolStateSOAPClient.getOccupation(place);
                            rtOccupation = poolOccupation;
                        } catch (Exception ex) {
                            log.error(printUpdateError("piscine", place.getRTExternalId(), place.getSIGid()));
                            rtOccupation = -1;
                        }
                        break;

                    case "2":
                        try {
                            if (Validator.isNotNull(parkingJsonArray) && parkingJsonArray.length() != 0) {
                                JSONObject parkingData = ParkingStateClient.getOccupationState(place.getRTExternalId(), parkingJsonArray);
                                String status = String.valueOf(parkingData.getInt("etat"));
                                long capacity = parkingData.getInt("total");
                                long libre = parkingData.getInt("libre");
                                long available;
                                rtLastUpdate = new Date();
                                String infousager = parkingData.getString("infousager");
                                try {
                                    available = Long.parseLong(infousager);
                                } catch (Exception e) {
                                    available = libre;
                                }
                                rtAvailable = available;
                                rtOccupation = capacity - available;
                                rtCapacity = capacity;
                                rtStatus = status;
                                rtLastUpdate = new Date();
                                if (status.equals("2")) {
                                    rtAvailable = 0;
                                }
                            } else {
                                throw new Exception();

                            }
                        } catch (Exception ex) {
                            log.error(printUpdateError("parking", place.getRTExternalId(), place.getSIGid()));

                        }
                        break;

                    case "3":
                        try {
                            long occupation = MairieStateSOAPClient.getWaitingTime(place.getRTExternalId());
                            rtOccupation = occupation;
                            rtLastUpdate = new Date();
                        } catch (Exception ex) {
                            //ex.printStackTrace();
                            log.error(printUpdateError("mairie", place.getRTExternalId(), place.getSIGid()));
                            rtOccupation = -1;
                        }
                        break;

                    case "4":
                        try {
                            long iceRinkOccupation = PoolStateSOAPClient.getOccupation(place);
                            rtOccupation = iceRinkOccupation;
                            rtLastUpdate = new Date();
                        } catch (Exception ex) {
                            log.error(printUpdateError("patinoire", place.getRTExternalId(), place.getSIGid()));
                            rtOccupation = -1;
                        }
                        break;

                    case "5":
                        try {
                            JSONObject velhopData = VelhopStateClient.getOccupationState(place);
                            long capacity = Long.parseLong(velhopData.getString("to"));
                            long available = Long.parseLong(velhopData.getString("av"));
                            rtAvailable = available;
                            rtOccupation = capacity - available;
                            rtCapacity = capacity;
                            rtLastUpdate = new Date();
                        } catch (Exception ex) {
                            log.error(printUpdateError("station vélhop", place.getRTExternalId(), place.getSIGid()));
                            rtOccupation = -1;
                        }
                        break;
                }
            }

            this.updateRealTime(place, rtType, rtOccupation, rtAvailable, rtCapacity, rtStatus, rtLastUpdate);
        }
        Indexer<Place> indexer = IndexerRegistryUtil
                .nullSafeGetIndexer(Place.class);
        indexer.reindex(placesWithRT);
        // System.out.println("RT import finished");
    }

    @Override
    public void updateRealTime(Place place, String type, long occupation, long available, long capacity, String status, Date rtLastUpdate) {

        if (rtLastUpdate != null) {
            place.setRTLastUpdate(rtLastUpdate);
        }
        place.setRTEnabled(true);
        place.setRTOccupation(occupation);
        place.setRTAvailable(available);
        place.setRTCapacity(capacity);
        place.setRTStatus(status);
        place.setRTType(type);
        place.setModifiedDate(place.getModifiedDate());
        this.updatePlace(place);
    }

    /**
     * Met à jour le statut du lieu "manuellement" (pas via le workflow)
     */
    @Override
    public void updateStatus(Place place, int status) throws PortalException {
        this.updateStatus(place.getUserId(), place.getPlaceId(), status, null,
                null);
    }


    /**
     * Récupère le nombre d'emplacements approuvés associés à une catégorie d'actifs spécifique
     * au sein d'un groupe d'entreprise donné.
     *
     * @param assetCategory La catégorie d'actifs pour laquelle compter les emplacements.
     * @param companyGroupId L'identifiant du groupe d'entreprise dans lequel effectuer la recherche.
     * @return Le nombre d'emplacements approuvés associés à la catégorie d'actifs donnée.
     * @throws PortalException En cas d'erreur lors de la récupération des données.
     */
    @Override
    public Integer getPlaceCountByAssetCategory(AssetCategory assetCategory, long companyGroupId) throws PortalException {
        List<AssetEntry> entries = AssetVocabularyHelper.getAssetEntriesByAssetCategory(assetCategory);
        return entries.parallelStream()
                .map(entry -> PlaceLocalServiceUtil.fetchPlaceByUuidAndGroupId(entry.getClassUuid(), companyGroupId))
                .filter(Objects::nonNull)
                .filter(Place::isApproved)
                .collect(Collectors.toList()).size();
    }

    /**
     * Supprime un lieu
     */
    @Override
    public Place removePlace(long placeId) throws PortalException {
        AssetEntry entry = AssetEntryLocalServiceUtil
                .fetchEntry(Place.class.getName(), placeId);
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
			List<AssetLink> links = this.assetLinkLocalService
					.getLinks(entry.getEntryId());
			for (AssetLink link : links) {
				this.assetLinkLocalService.deleteAssetLink(link);
			}

			// Delete the AssetEntry
			AssetEntryLocalServiceUtil.deleteEntry(Place.class.getName(),
					placeId);

		}

		// Supprime le lieu
		Place place = placePersistence.remove(placeId);

		// Supprime les exceptions liées au lieu
		List<ScheduleException> exceptions = place.getScheduleExceptions();
		for (ScheduleException exception : exceptions) {
			this.scheduleExceptionLocalService.deleteScheduleException(exception.getExceptionId());
		}

		// Supprime les sous-lieux
		List<SubPlace> subPlaces = place.getSubPlaces();
		for (SubPlace subPlace : subPlaces) {
			this.subPlaceLocalService.removeSubPlace(subPlace.getSubPlaceId());
		}
		
		// Supprime les périodes
		List<Period> periods = place.getPeriods();
		for (Period period : periods) {
			 this.periodLocalService.removePeriod(period.getPeriodId());
		}

        //Mise à jour pour CSMap
        if (Validator.isNotNull(csmapCacheJsonLocalService.fetchCsmapCacheJson(place.getSIGid())))
            csmapCacheJsonLocalService.deleteCsmapCacheJson(place.getSIGid());
        Historic historic = historicLocalService.fetchHistoric(place.getSIGid());
        if (Validator.isNull(historic))
            historic = historicLocalService.createHistoric(place.getSIGid());
        historic.setName(place.getName());
        historic.setSuppressionDate(new Date());
        historicLocalService.updateHistoric(historic);

        // Delete the index
        this.reindex(place, true);

        // Supprime ce qui a rapport au workflow
        WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(
                place.getCompanyId(), place.getGroupId(), Place.class.getName(),
                place.getPlaceId());

        return place;
    }

    /**
     * Reindex le lieu dans le moteur de recherche
     */
    private void reindex(Place place, boolean delete) throws SearchException {
        Indexer<Place> indexer = IndexerRegistryUtil
                .nullSafeGetIndexer(Place.class);
        if (delete) {
            indexer.delete(place);
        } else {
            indexer.reindex(place);
        }
    }

    /**
     * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
     */
    @Override
    public List<AssetVocabulary> getAttachedVocabularies(long groupId) {
        long classNameId = ClassNameLocalServiceUtil
                .getClassNameId(Place.class);
        return AssetVocabularyHelper.getVocabulariesForAssetType(groupId,
                classNameId);
    }

    /**
     * Lance une recherche selon le searchContext
     */
    @Override
    public Hits search(SearchContext searchContext) throws SearchException {
        Indexer<Place> indexer = IndexerRegistryUtil
                .nullSafeGetIndexer(Place.class);
        return indexer.search(searchContext);
    }

    /**
     * Lance une recherche par mots-clés
     */
    @Override
    public List<Place> findByKeyword(String keyword, long groupId, int start,
                                     int end) {
        DynamicQuery dynamicQuery = dynamicQuery();

        if (keyword.length() > 0) {
            dynamicQuery.add(
                    RestrictionsFactoryUtil.like("alias", "%" + keyword + "%"));
        }
        if (groupId > 0) {
            dynamicQuery
                    .add(PropertyFactoryUtil.forName("groupId").eq(groupId));
        }

        return placePersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Lance une recherche par nom
     *
     * @throws NoSuchPlaceException
     */
    @Override
    public List<Place> findByName(String name) throws NoSuchPlaceException {

        return placePersistence.findByname(name);
    }

    /**
     * Compte de la recherche par mots-clés
     */
    @Override
    public long findByKeywordCount(String keyword, long groupId) {
        DynamicQuery dynamicQuery = dynamicQuery();
        if (keyword.length() > 0) {
            dynamicQuery.add(
                    RestrictionsFactoryUtil.like("alias", "%" + keyword + "%"));
        }
        if (groupId > 0) {
            dynamicQuery
                    .add(PropertyFactoryUtil.forName("groupId").eq(groupId));
        }

        return placePersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Retourne les lieux d'un groupe
     */
    @Override
    public List<Place> getByGroupId(long groupId) {
        return this.placePersistence.findByGroupId(groupId);
    }
    
	/**
	 * Recherche des places par identifiants
	 * @param idsPlace : liste ids places
	 * @return
	 */
	public List<Place>findByIds(List<Long>idsPlace){
        // Si pas d'Ids envoyé, on renvoie une liste vide
        if(idsPlace.isEmpty()) {
            return new ArrayList<Place>();
        }
		DynamicQuery placeDynamicQuery = this.dynamicQuery();
		placeDynamicQuery.add(PropertyFactoryUtil.forName("placeId").in(idsPlace));
		return this.dynamicQuery(placeDynamicQuery);
	}
	/**
	 * Retourne les lieux rattachés à un tarif
	 */
	@Override
	public List<Place> getByPriceId(long priceId) {
		return this.placePersistence.findByPriceId(priceId);
	}

    @Override
    public Place getPlaceBySIGId(String idSIG) {
        return this.placePersistence.fetchBySIGId(idSIG);
    }

    /**
     * Met à jour le jsonHoraire d'un lieu
     */
    @Override
    public Place updateJsonHoraire(Place place)
            throws PortalException {
        //Mise à jour pour CSMap
        CsmapCacheJson csmapCacheJson = this.csmapCacheJsonLocalService.fetchCsmapCacheJson(place.getSIGid());
        if (Validator.isNotNull(csmapCacheJson)) {
            csmapCacheJson.setJsonHoraire(place.getScheduleCSMapJSON().toString());
            this.csmapCacheJsonLocalService.updateCsmapCacheJson(csmapCacheJson);
        }

        return place;
    }

    private String printUpdateError(String lieu, String rtExternalId, String sigId) {
        return "Can not update real time data for" + "'" + lieu + "' rtExternalId :" + rtExternalId + ", sigId :" + sigId;
    }
    private Log log = LogFactoryUtil.getLog(this.getClass().getName());
}