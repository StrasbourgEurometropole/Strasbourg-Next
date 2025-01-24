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

import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.service.place.model.CsmapCacheJson;
import eu.strasbourg.service.place.service.PlaceService;
import eu.strasbourg.service.place.service.PlaceServiceUtil;
import org.osgi.annotation.versioning.ProviderType;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.model.PlaceSchedule;
import eu.strasbourg.service.place.service.base.PlaceServiceBaseImpl;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.OccupationState;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.constants.VocabularyNames;
import eu.strasbourg.utils.models.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * The implementation of the place remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link PlaceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PlaceServiceBaseImpl
 * @see PlaceServiceUtil
 */
@ProviderType
public class PlaceServiceImpl extends PlaceServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * eu.strasbourg.service.place.service.PlaceServiceUtil} to access the place
	 * remote service.
	 */

	@Override
	public JSONArray getPlaces() throws PortalException {
		List<Place> places = this.placeLocalService.getPlaces(-1, -1);
		return this.getApprovedJSONPlaces(places);
	}

	@Override
	public JSONObject getPlaceById(long id) {
		Place place = this.placeLocalService.fetchPlace(id);
		if (place == null || !place.isApproved()) {
			return JSONFactoryUtil.createJSONObject();
		}
		return place.toJSON();
	}

	@Override
	public JSONObject getPlaceByIdSIG(String sigId) {
		Place place = this.placeLocalService.getPlaceBySIGId(sigId);
		if (place == null || !place.isApproved()) {
			return JSONFactoryUtil.createJSONObject();
		}
		return place.toJSON();
	}

	@Override
	public JSONArray getPlacesByType(String typeId) throws PortalException {
		// Recherche du catégoryId
		AssetVocabulary vocabularyTypeLieu = AssetVocabularyHelper
				.getGlobalVocabulary("Type de lieu");
		AssetCategory category = AssetVocabularyHelper
				.getCategoryByExternalId(vocabularyTypeLieu, typeId);
		long[] categoriesIds = { category.getCategoryId() };

		Hits hits = SearchHelper.getPlaceWebServiceSearchHits(
				Place.class.getName(), categoriesIds, null, null);
		List<Place> places = new ArrayList<Place>();
		for (Document document : hits.getDocs()) {
			Long placeId = GetterUtil
					.getLong(document.get(Field.ENTRY_CLASS_PK));
			Place place = this.placeLocalService.fetchPlace(placeId);
			if (place != null) {
				places.add(place);
			}
		}
		return this.getApprovedJSONPlaces(places);
	}

	@Override
	public JSONArray getPlacesByTypes(List<String> typesId) throws PortalException {
		// Recherche du catégoryId
		AssetVocabulary vocabularyTypeLieu = AssetVocabularyHelper
				.getGlobalVocabulary("Type de lieu");
		List<AssetCategory> categories = AssetVocabularyHelper
				.getCategoriesByExternalsId(vocabularyTypeLieu, typesId);
		List<Long> listCategoriesIds = new ArrayList<Long>();
		for (AssetCategory assetCategory : categories) {
			listCategoriesIds.add(assetCategory.getCategoryId());
		}
		
		long[] categoriesIds = listCategoriesIds.stream().mapToLong(l -> l).toArray();

		Hits hits = SearchHelper.getPlaceWebServiceSearchHits(
				Place.class.getName(), categoriesIds, null, null, false);
		List<Place> places = new ArrayList<Place>();
		for (Document document : hits.getDocs()) {
			Long placeId = GetterUtil
					.getLong(document.get(Field.ENTRY_CLASS_PK));
			Place place = this.placeLocalService.fetchPlace(placeId);
			if (place != null) {
				places.add(place);
			}
		}
		return this.getApprovedJSONPlaces(places);
	}

	@Override
	public JSONArray getPlacesByTerritory(String territoryId)throws PortalException {
		// Recherche du catégoryId
		AssetVocabulary vocabularyTerritory = AssetVocabularyHelper
				.getGlobalVocabulary("Territoire");
		AssetCategory category = AssetVocabularyHelper
				.getCategoryByExternalId(vocabularyTerritory, territoryId);
		long[] categoriesIds = { category.getCategoryId() };

		Hits hits = SearchHelper.getPlaceWebServiceSearchHits(
				Place.class.getName(), categoriesIds, null, null);
		List<Place> places = new ArrayList<Place>();
		for (Document document : hits.getDocs()) {
			Long placeId = GetterUtil
					.getLong(document.get(Field.ENTRY_CLASS_PK));
			Place place = this.placeLocalService.fetchPlace(placeId);
			if (place != null) {
				places.add(place);
			}
		}
		return this.getApprovedJSONPlaces(places);
	}

	@Override
	public JSONArray getPlacesByNameAndLanguage(String name, String language) throws PortalException {
		Locale locale = LocaleUtil.fromLanguageId(language);
		Hits hits = SearchHelper.getPlaceWebServiceSearchHits(
				Place.class.getName(), null, name, locale);
		List<Place> places = new ArrayList<Place>();
		for (Document document : hits.getDocs()) {
			Long placeId = GetterUtil
					.getLong(document.get(Field.ENTRY_CLASS_PK));
			Place place = this.placeLocalService.fetchPlace(placeId);
			if (place != null) {
				places.add(place);
			}
		}
		return this.getApprovedJSONPlaces(places);
	}

	@Override
	public JSONArray getPlacesByTerritoryAndType(String territoryId, String typeId) throws PortalException {
		// Recherche du catégoryId du vocabulaire Territoire
		AssetVocabulary vocabularyTerritory = AssetVocabularyHelper
				.getGlobalVocabulary("Territoire");
		AssetCategory categoryTerritory = AssetVocabularyHelper
				.getCategoryByExternalId(vocabularyTerritory, territoryId);

		// Recherche du catégoryId du vocabulaire Type de lieu
		AssetVocabulary vocabularyType = AssetVocabularyHelper
				.getGlobalVocabulary("Type de lieu");
		AssetCategory categoryType = AssetVocabularyHelper
				.getCategoryByExternalId(vocabularyType, typeId);

		long[] categoriesIds = { categoryTerritory.getCategoryId(),
				categoryType.getCategoryId() };

		Hits hits = SearchHelper.getPlaceWebServiceSearchHits(
				Place.class.getName(), categoriesIds, null, null);
		List<Place> places = new ArrayList<Place>();
		for (Document document : hits.getDocs()) {
			Long placeId = GetterUtil
					.getLong(document.get(Field.ENTRY_CLASS_PK));
			Place place = this.placeLocalService.fetchPlace(placeId);
			if (place != null) {
				places.add(place);
			}
		}
		return this.getApprovedJSONPlaces(places);
	}

	@Override
	public JSONArray getTypes() throws PortalException {
		return AssetVocabularyHelper.toJSON(AssetVocabularyHelper.getGlobalVocabulary(VocabularyNames.PLACE_TYPE));
	}

	@Override
	public JSONArray getEquipments() throws PortalException {
		return AssetVocabularyHelper.toJSON(AssetVocabularyHelper.getGlobalVocabulary(VocabularyNames.EQUIPMENT));
	}

	@Override
	public JSONObject getRealtime() {
		JSONObject jsonRealtime = JSONFactoryUtil.createJSONObject();
		JSONArray jsonResults = JSONFactoryUtil.createJSONArray();

		// Récupère tous les lieux valides ayant un externalId différent de "NO" et non vide, ainsi qu'une date de modification
		List<Place> places = this.placeLocalService.getPlaces(-1, -1).stream().filter(p -> p.isApproved() && Validator.isNotNull(p.getRTExternalId())
					&& !p.getRTExternalId().equals("NO") && !p.getRTExternalId().equals("") && Validator.isNotNull(p.getRTLastUpdate()))
				.collect(Collectors.toList());

		for (Place place : places) {

			try {
				JSONObject jsonPlace = JSONFactoryUtil.createJSONObject();
				jsonPlace.put("sigId", place.getSIGid());
				JSONArray jsonTypes = JSONFactoryUtil.createJSONArray();
				List<AssetCategory> types = place.getTypes();
				for (AssetCategory type : types) {
					jsonTypes.put(AssetVocabularyHelper.getCategoryProperty(type.getCategoryId(), "SIG"));
				}
				jsonPlace.put("types", jsonTypes);
				OccupationState realtime = place.getRealTime();
				switch (realtime.getLabel()) {
					case "closed-period":
						jsonPlace.put("realTimeStatus", "CLOSED");
						break;
					case "not-available":
						jsonPlace.put("realTimeStatus", "NOT_AVAILABLE");
						break;
					case "open-period":
						jsonPlace.put("realTimeStatus", "OPEN");
						break;
					case "green-period":
						jsonPlace.put("realTimeStatus", "GREEN");
						break;
					case "orange-period":
						jsonPlace.put("realTimeStatus", "ORANGE");
						break;
					case "red-period":
						jsonPlace.put("realTimeStatus", "RED");
						break;
					case "black-period":
						jsonPlace.put("realTimeStatus", "BLACK");
						break;
					case "full-period":
						jsonPlace.put("realTimeStatus", "FULL");
						break;
					case "real-time-disabled":
						jsonPlace.put("realTimeStatus", "DISABLED");
						break;
				}
				switch (place.getRTType()) {
					case "1": // Piscines
					case "4": // Patinoires
						jsonPlace.put("occupation", realtime.getOccupationLabel());
						jsonPlace.put("available", org.json.JSONObject.NULL);
						jsonPlace.put("capacity", org.json.JSONObject.NULL);
						jsonPlace.put("averageWaitingTime", org.json.JSONObject.NULL);
						break;
					case "2": // Parkings
						jsonPlace.put("available", realtime.getAvailable());
						jsonPlace.put("capacity", realtime.getCapacity());
						jsonPlace.put("occupation", org.json.JSONObject.NULL);
						jsonPlace.put("averageWaitingTime", org.json.JSONObject.NULL);
						break;
					case "3": // Mairies
						jsonPlace.put("averageWaitingTime", realtime.getOccupation());
						jsonPlace.put("occupation", org.json.JSONObject.NULL);
						jsonPlace.put("available", org.json.JSONObject.NULL);
						jsonPlace.put("capacity", org.json.JSONObject.NULL);
						break;
				}
				List<PlaceSchedule> listeHoraire = place.getPlaceSchedule(new Date(), 1, Locale.FRANCE).entrySet().iterator().next().getValue();
				JSONArray jsonSchedules = JSONFactoryUtil.createJSONArray();
				if(!listeHoraire.isEmpty()) {
					PlaceSchedule schedule = listeHoraire.get(0);
					jsonPlace.put("isOpen", place.isOpenNow());
					jsonPlace.put("isOpen247", schedule.isAlwaysOpen());
					if (!(schedule.isAlwaysOpen() || schedule.isClosed())) {
						List<Pair<LocalTime, LocalTime>> openingTimes = schedule.getOpeningTimes();
						for (Pair<LocalTime, LocalTime> openingTime : openingTimes) {
							JSONObject jsonSchedule = JSONFactoryUtil.createJSONObject();
							LocalTime opening = openingTime.getFirst();
							jsonSchedule.put("openingHour", opening.getHour());
							jsonSchedule.put("openingMinute", opening.getMinute());
							LocalTime closing = openingTime.getSecond();
							jsonSchedule.put("closingHour", closing.getHour());
							jsonSchedule.put("closingMinute", closing.getMinute());
							jsonSchedules.put(jsonSchedule);
						}
					}
				}else {
					jsonPlace.put("isOpen", org.json.JSONObject.NULL);
					jsonPlace.put("isOpen247", org.json.JSONObject.NULL);
				}
				jsonPlace.put("daySchedule", jsonSchedules);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				jsonPlace.put("updateDate", df.format(place.getRTLastUpdate()));

				jsonResults.put(jsonPlace);

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}
		jsonRealtime.put("results", jsonResults);
		return jsonRealtime;
	}

	/**
	 * Retourne le géoJSON des lieux
	 */
	@Override
	public JSONObject getPlacesGeoJSON() {
		List<Place> places = this.placeLocalService.getPlaces(-1, -1);
		return this.getApprovedGeoJSONPlaces(places);
	}

	private JSONArray getApprovedJSONPlaces(List<Place> places) throws PortalException {
		JSONArray jsonPlaces = JSONFactoryUtil.createJSONArray();
		long companyId = PortalUtil.getDefaultCompanyId();
		long companyGroupId = CompanyLocalServiceUtil.getCompany(companyId)
				.getGroup().getGroupId();

		long territoryVocabularyId = 0;
		AssetVocabulary territoryVocabulary = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(companyGroupId, VocabularyNames.TERRITORY);
		if(Validator.isNotNull(territoryVocabulary))
			territoryVocabularyId = territoryVocabulary.getVocabularyId();

		long typeVocabularyId = 0;
		AssetVocabulary typeVocabulary = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(companyGroupId, VocabularyNames.PLACE_TYPE);
		if(Validator.isNotNull(typeVocabulary))
			typeVocabularyId = typeVocabulary.getVocabularyId();

		long equipmentVocabularyId = 0;
		AssetVocabulary equipmentVocabulary = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(companyGroupId, VocabularyNames.EQUIPMENT);
		if(Validator.isNotNull(equipmentVocabulary))
			equipmentVocabularyId = equipmentVocabulary.getVocabularyId();

		for (Place place : places) {
			try {
				if (place.isApproved()) {
					jsonPlaces.put(place.toJSON(territoryVocabularyId, typeVocabularyId, equipmentVocabularyId));
				}
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}
		return jsonPlaces;
	}

	private JSONObject getApprovedGeoJSONPlaces(List<Place> places) {
		JSONObject geoJSON = JSONFactoryUtil.createJSONObject();
		geoJSON.put("type", "FeatureCollection");
		JSONArray features = JSONFactoryUtil.createJSONArray();
		for (Place place : places) {
			try {
				if (place.isApproved()) {
					features.put(place.toGeoJSON());
				}
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}
		geoJSON.put("features", features);
		return geoJSON;
	}

	/**
	 * Retourne les horaires du jour
	 */
	@Override
	public JSONObject getCacheJsonHoraire(String sigId, String localeId) {
		Locale locale = LocaleUtil.fromLanguageId(localeId);

		// initialisation pour un lieu fermé pendant les 3 prochains jours (aujourd'hui compris)
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String schedule = "";
		String nextOpen = "";
		String startHour = "";
		String endHour = "";
		String opened = LanguageUtil.get(locale, "closed-now");
		// On récupère le cache horaires du lieu
		CsmapCacheJson cache = csmapCacheJsonLocalService.fetchCsmapCacheJson(sigId);
		if (Validator.isNotNull(cache)) {
			try {
				if (!cache.getJsonHoraire().equals("{}")){
					JSONObject jsonHoraire = JSONFactoryUtil.createJSONObject(cache.getJsonHoraire());
					JSONArray weeksJSON = jsonHoraire.getJSONArray("schedules");

					for (int i = 0; i < 3; i++) {
						JSONObject scheduleJSON = weeksJSON.getJSONObject(i);
						if (scheduleJSON.getBoolean("alwaysOpen")) {
							// le lieu est toujours ouvert pas besoin de continuer
							schedule = LanguageUtil.get(locale,"open-all-time");
							opened = LanguageUtil.get(locale,"open-period");
							break;
						}else{
							if(scheduleJSON.getBoolean("isClosed")){
								// le lieu est fermé on passe au jour suivant
								continue;
							}else{
								// le lieu est ouvert
								JSONArray hoursJSON = scheduleJSON.getJSONArray("hours");
								if(i > 0) {
									// pas le jour J
									schedule = LanguageUtil.get(locale,"reopening");
									if (i == 1) {
										nextOpen = LanguageUtil.get(locale,"tomorrow");
									} else {
										nextOpen = LanguageUtil.get(locale,"after-tomorrow");
									}
									schedule += " " + LanguageUtil.get(locale,nextOpen);
									JSONObject hourJSON = hoursJSON.getJSONObject(0);
									startHour = hourJSON.getString("startHour").replace(':', 'H');
									schedule += " " + LanguageUtil.get(locale,"at") + " " + startHour;
									opened = LanguageUtil.get(locale,"closed-period");
									break;
								}else{
									// le jour J
									LocalTime now = LocalTime.now();
									boolean isOpenNow = false;
									boolean isClosedNow = true;
									for (int j = 0; j < hoursJSON.length(); j++) {
										JSONObject hourJSON = hoursJSON.getJSONObject(j);
										if (schedule.length() > 0) {
											schedule += "<br>";
										}
										schedule += hourJSON.getString("startHour").replace(':', 'H') + " - " + hourJSON.getString("endHour").replace(':', 'H');
										String[] startTimeString = hourJSON.getString("startHour").split(":");
										LocalTime startTime = LocalTime.of(Integer.parseInt(startTimeString[0]), Integer.parseInt(startTimeString[1]));
										String[] endTimeString = hourJSON.getString("endHour").split(":");
										LocalTime endTime = LocalTime.of(Integer.parseInt(endTimeString[0]), Integer.parseInt(endTimeString[1]));
										if(!endTime.isBefore(now) && !startTime.isAfter(now))
											isOpenNow = true;
										if(!endTime.isBefore(now)) {
											isClosedNow = false;
											if(Validator.isNull(startHour))
												startHour = hourJSON.getString("startHour").replace(':', 'H');
											if(Validator.isNull(endHour))
												endHour = hourJSON.getString("endHour").replace(':', 'H');
										}

									}
									if(isOpenNow){
										opened = LanguageUtil.get(locale,"open-period");
										break;
									}
									if(!isClosedNow){
										schedule = LanguageUtil.get(locale,"reopening");
										schedule += " " + LanguageUtil.get(locale,"at") + " " + startHour;
										schedule += " " + LanguageUtil.get(locale,"up-to") + " " + endHour;
										opened = LanguageUtil.get(locale,"closed-period");
										break;
									}
								}
							}
						}
					}
				}
			} catch (JSONException e) {
				_log.error(e.getMessage(), e);
			}
		}
		json.put("schedule", schedule);
		json.put("opened", opened);
		return json;
	}

	private static final Log _log = LogFactoryUtil.getLog(PlaceServiceImpl.class.getName());
}