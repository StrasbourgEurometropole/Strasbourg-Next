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

package eu.strasbourg.service.place.model.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import eu.strasbourg.service.place.model.Period;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.model.PlaceSchedule;
import eu.strasbourg.service.place.model.Price;
import eu.strasbourg.service.place.model.PublicHoliday;
import eu.strasbourg.service.place.model.ScheduleException;
import eu.strasbourg.service.place.model.Slot;
import eu.strasbourg.service.place.model.SubPlace;
import eu.strasbourg.service.place.service.PeriodLocalServiceUtil;
import eu.strasbourg.service.place.service.PriceLocalServiceUtil;
import eu.strasbourg.service.place.service.PublicHolidayLocalServiceUtil;
import eu.strasbourg.service.place.service.ScheduleExceptionLocalServiceUtil;
import eu.strasbourg.service.place.service.SubPlaceLocalServiceUtil;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.service.video.service.VideoLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

/**
 * The extended model implementation for the Place service. Represents a row in
 * the &quot;place_Place&quot; database table, with each column mapped to a
 * property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link eu.strasbourg.service.place.model.Place} interface.
 * </p>
 *
 * @author Angelique Zunino Champougny
 */
@ProviderType
public class PlaceImpl extends PlaceBaseImpl {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8684903451087898120L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a place
	 * model instance should use the {@link
	 * eu.strasbourg.service.place.model.Place} interface instead.
	 */
	public PlaceImpl() {
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(Place.class.getName(),
				this.getPlaceId());
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public List<AssetCategory> getCategories() {
		return AssetVocabularyHelper
				.getAssetEntryCategories(this.getAssetEntry());
	}

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return FileEntryHelper.getFileEntryURL(this.getImageId());
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(Locale locale) {
		return FileEntryHelper.getImageCopyright(this.getImageId(), locale);
	}

	/**
	 * Retourne le prix rattaché au lieu
	 */
	@Override
	public Price getPrice() {
		return PriceLocalServiceUtil.fetchPrice(this.getPriceId());
	}

	/**
	 * Retourne les ScheduleExceptions du lieu
	 */
	@Override
	public List<ScheduleException> getScheduleExceptions() {
		return ScheduleExceptionLocalServiceUtil
				.getByPlaceId(this.getPlaceId());
	}

	/**
	 * Retourne les PublicHolidays du lieu
	 */
	@Override
	public List<PublicHoliday> getPublicHolidays() {
		return PublicHolidayLocalServiceUtil.getPublicHolidaies(0, 0);
	}

	/**
	 * Renvoie la liste des IDs des ScheduleExceptions auxquelles ce lieu
	 * appartient sous forme de String
	 */
	@Override
	public String getScheduleExceptionsIds() {
		List<ScheduleException> scheduleExceptions = this
				.getScheduleExceptions();
		String ids = "";
		for (ScheduleException scheduleException : scheduleExceptions) {
			if (ids.length() > 0) {
				ids += ",";
			}
			ids += scheduleException.getExceptionId();
		}
		return ids;
	}

	/**
	 * Retourne les sous lieux du lieux
	 */
	@Override
	public List<SubPlace> getSubPlaces() {
		return SubPlaceLocalServiceUtil.getByPlaceId(this.getPlaceId());
	}

	/**
	 * Renvoie la liste des IDs des sous lieux auxquelles ce lieu appartient
	 * sous forme de String
	 */
	@Override
	public String getSubPlacesIds() {
		List<SubPlace> subPlaces = this.getSubPlaces();
		String ids = "";
		for (SubPlace subPlace : subPlaces) {
			if (ids.length() > 0) {
				ids += ",";
			}
			ids += subPlace.getSubPlaceId();
		}
		return ids;
	}

	/**
	 * Retourne les Periods du lieux
	 */
	@Override
	public List<Period> getPeriods() {
		return PeriodLocalServiceUtil.getByPlaceId(this.getPlaceId());
	}

	/**
	 * Retourne les territoire du lieu
	 */
	@Override
	public List<AssetCategory> getTerritories() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(
				this.getAssetEntry(), "Territoire");
	}

	/**
	 * Retourne les types du lieu
	 */
	@Override
	public List<AssetCategory> getTypes() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(
				this.getAssetEntry(), "Type de lieu");
	}

	/**
	 * Retourne la ville
	 */
	@Override
	public String getCity(Locale locale) {
		AssetCategory cityCategory = this.getCityCategory();
		if (cityCategory != null) {
			return cityCategory.getTitle(locale);
		}
		return "";
	}

	/**
	 * Retourne la catégorie Territoire correspondant à la ville du lieu
	 */
	@Override
	public AssetCategory getCityCategory() {
		List<AssetCategory> territories = this.getTerritories();
		for (AssetCategory territory : territories) {
			try {
				if (territory.getAncestors().size() == 1) {
					return territory;
				}
			} catch (PortalException e) {
				continue;
			}
		}
		return null;
	}

	/**
	 * Retourne le quartier
	 */
	@Override
	public String getDistrict(Locale locale) {
		AssetCategory districtCategory = this.getDistrictCategory();
		if (districtCategory != null) {
			return districtCategory.getTitle(locale);
		}
		return "";
	}

	/**
	 * Retourne la catégorie Territoire correspondant au quartier du lieu
	 */
	@Override
	public AssetCategory getDistrictCategory() {
		List<AssetCategory> territories = this.getTerritories();
		for (AssetCategory territory : territories) {
			try {
				if (territory.getAncestors().size() == 2) {
					return territory;
				}
			} catch (PortalException e) {
				continue;
			}
		}
		return null;
	}

	/**
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	@Override
	public List<String> getImagesURLs() {
		List<String> URLs = new ArrayList<String>();
		for (String imageIdStr : this.getImageIds().split(",")) {
			Long imageId = GetterUtil.getLong(imageIdStr);
			if (Validator.isNotNull(imageId)) {
				String imageURL = FileEntryHelper.getFileEntryURL(imageId);
				URLs.add(imageURL);
			}
		}
		return URLs;
	}

	/**
	 * Retourne la liste des URL des documents de ce lieu
	 */
	@Override
	public List<String> getDocumentURLs() {
		List<String> URLs = new ArrayList<String>();
		for (String documentIdStr : this.getDocumentsIds().split(",")) {
			Long documentId = GetterUtil.getLong(documentIdStr);
			if (Validator.isNotNull(documentId)) {
				String documentURL = FileEntryHelper
						.getFileEntryURL(documentId);
				URLs.add(documentURL);
			}
		}
		return URLs;
	}

	/**
	 * Retourne true si l'événement est accessible pour au moins un type de
	 * handicap
	 */
	@Override
	public boolean hasAnyAccessForDisabled() {
		return this.getAccessForBlind() || this.getAccessForDeaf()
				|| this.getAccessForWheelchair() || this.getAccessForDeficient()
				|| this.getAccessForElder();
	}

	/**
	 * Retourne une map contennant le jour et une autre map contenant les horaires
	 * d'ouverture de la semaine en cours (key = schedule, from et/ou to)
	 */
	@Override
	public Map<String, Map<String, String>> getHoraire(Date dateJour) {
		Map<String, Map<String, String>> listHoraires = new HashMap<String, Map<String, String>>();

		// réupère le jour voulu de la semaine
		GregorianCalendar jourSemaine = new GregorianCalendar();
		jourSemaine.setTime(dateJour);
		jourSemaine.set(Calendar.HOUR_OF_DAY, 0);
		jourSemaine.clear(Calendar.MINUTE);
		jourSemaine.clear(Calendar.SECOND);
		jourSemaine.clear(Calendar.MILLISECOND);
		for (int jour = 0; jour <= 6; jour++) {
			jourSemaine.set(Calendar.DAY_OF_WEEK,
					(int) (jour == 6 ? 1 : jour + 2));

			Map<String, String> map = new HashMap<String, String>();
			for (PlaceSchedule placeSchedule : getPlaceSchedule(jourSemaine)) {
				if (placeSchedule.isClosed()) {
					map.put("schedule", "closed");
				} else if (placeSchedule.isAlwaysOpen()) {
					map.put("schedule", "always-open");
				} else {
					map.put("from", placeSchedule.getStartTime().toString());
					map.put("to", placeSchedule.getEndTime().toString());
				}
			}

			listHoraires.put(Integer.toString(jour), map);
		}
		return listHoraires;
	}

	/**
	 * Retourne les horaires d'ouverture de la semaine en cours
	 */
	@Override
	public List<PlaceSchedule> getPlaceSchedule(GregorianCalendar jourSemaine) {
		List<PlaceSchedule> listHoraires = new ArrayList<PlaceSchedule>();

		// vérifie si cette date n'est pas dans les horaires d'exception
		for (ScheduleException scheduleException : this
				.getScheduleExceptions()) {
			if (scheduleException.getStartDate() != null
					&& scheduleException.getEndDate() != null
					&& scheduleException.getStartDate()
							.compareTo(jourSemaine.getTime()) <= 0
					&& scheduleException.getEndDate()
							.compareTo(jourSemaine.getTime()) >= 0) {
				PlaceSchedule placeSchedule = new PlaceSchedule();
				placeSchedule.setException(true);
				placeSchedule
						.setDescriptionMap(scheduleException.getCommentMap());
				if (scheduleException.isClosed()) {
					placeSchedule.setClosed(true);
				} else {
					String[] heure = scheduleException.getStartHour()
							.split(":");
					LocalTime startHour = LocalTime.of(
							Integer.parseInt(heure[0]),
							Integer.parseInt(heure[1]));
					heure = scheduleException.getEndHour().split(":");
					LocalTime endHour = LocalTime.of(Integer.parseInt(heure[0]),
							Integer.parseInt(heure[1]));
					placeSchedule.setStartTime(startHour);
					placeSchedule.setEndTime(endHour);
				}
				listHoraires.add(placeSchedule);
				return listHoraires;
			}
		}

		// vérifie si cette date n'est pas dans les horaires d'exception
		for (PublicHoliday publicHoliday : this.getPublicHolidays()) {
			if (publicHoliday.getDate() != null && publicHoliday.getDate()
					.compareTo(jourSemaine.getTime()) == 0) {
				PlaceSchedule placeSchedule = new PlaceSchedule();
				placeSchedule.setPublicHoliday(true);
				placeSchedule.setDescriptionMap(publicHoliday.getNameMap());
				placeSchedule.setClosed(true);
				listHoraires.add(placeSchedule);
				return listHoraires;
			}
		}

		// s'il n'y a pas d'exception, on récupère les horaires de la
		// période concernée
		if (listHoraires.isEmpty()) {
			for (Period period : this.getPeriods()) {
				if (!period.getDefaultPeriod()) {
					if (period.getStartDate() != null
							&& period.getEndDate() != null
							&& period.getStartDate()
									.compareTo(jourSemaine.getTime()) <= 0
							&& period.getEndDate()
									.compareTo(jourSemaine.getTime()) >= 0) {
						listHoraires.clear();
						// on vérifie si le lieu n'est pas ouvert 24h/24
						// 7j/7
						if (period.getAlwaysOpen()) {
							PlaceSchedule placeSchedule = new PlaceSchedule();
							placeSchedule
									.setDescriptionMap(period.getNameMap());
							placeSchedule.setAlwaysOpen(true);
							listHoraires.add(placeSchedule);
						} else {
							for (Slot slot : period.getSlots()) {
								if (slot.getDayOfWeek() == (jourSemaine
										.get(Calendar.DAY_OF_WEEK) == 1
												? 6
												: jourSemaine
														.get(Calendar.DAY_OF_WEEK)
														- 2)) {
									PlaceSchedule placeSchedule = new PlaceSchedule();
									placeSchedule.setDescriptionMap(
											period.getNameMap());
									String[] heure = slot.getStartHour()
											.split(":");
									LocalTime startHour = LocalTime.of(
											Integer.parseInt(heure[0]),
											Integer.parseInt(heure[1]));
									heure = slot.getEndHour().split(":");
									LocalTime endHour = LocalTime.of(
											Integer.parseInt(heure[0]),
											Integer.parseInt(heure[1]));
									placeSchedule.setStartTime(startHour);
									placeSchedule.setEndTime(endHour);
									listHoraires.add(placeSchedule);
								}
							}
						}
						if (listHoraires.isEmpty()) {
							PlaceSchedule placeSchedule = new PlaceSchedule();
							placeSchedule
									.setDescriptionMap(period.getNameMap());
							placeSchedule.setClosed(true);
							listHoraires.add(placeSchedule);
						}
						return listHoraires;
					}
				} else {
					// on vérifie si le lieu n'est pas ouvert 24h/24
					// 7j/7
					if (period.getAlwaysOpen()) {
						PlaceSchedule placeSchedule = new PlaceSchedule();
						placeSchedule.setDescriptionMap(period.getNameMap());
						placeSchedule.setAlwaysOpen(true);
						listHoraires.add(placeSchedule);
					} else {
						for (Slot slot : period.getSlots()) {
							if (slot.getDayOfWeek() == (jourSemaine
									.get(Calendar.DAY_OF_WEEK) == 1
											? 6
											: jourSemaine
													.get(Calendar.DAY_OF_WEEK)
													- 2)) {
								PlaceSchedule placeSchedule = new PlaceSchedule();
								placeSchedule
										.setDescriptionMap(period.getNameMap());
								String[] heure = slot.getStartHour().split(":");
								LocalTime startHour = LocalTime.of(
										Integer.parseInt(heure[0]),
										Integer.parseInt(heure[1]));
								heure = slot.getEndHour().split(":");
								LocalTime endHour = LocalTime.of(
										Integer.parseInt(heure[0]),
										Integer.parseInt(heure[1]));
								placeSchedule.setStartTime(startHour);
								placeSchedule.setEndTime(endHour);
								listHoraires.add(placeSchedule);
							}
						}
						if (listHoraires.isEmpty()) {
							PlaceSchedule placeSchedule = new PlaceSchedule();
							placeSchedule
									.setDescriptionMap(period.getNameMap());
							placeSchedule.setClosed(true);
							listHoraires.add(placeSchedule);
						}
					}
				}
			}
		}
		return listHoraires;
	}

	/**
	 * Retourne la version JSON du lieu
	 */
	@Override
	public JSONObject toJSON() {
		JSONObject jsonPlace = JSONFactoryUtil.createJSONObject();

		jsonPlace.put("idSurfs", this.getSIGid());
		jsonPlace.put("name",
				JSONHelper.getJSONFromI18nMap(this.getAliasMap()));
		jsonPlace.put("address",
				this.getAddressStreet() + "<br />" + this.getAddressZipCode()
						+ " " + this.getCity(Locale.getDefault()) + "<br />"
						+ this.getAddressCountry());
		if (Validator.isNotNull(this.getAddressDistribution())) {
			jsonPlace.put("distribution", this.getAddressDistribution());
		}
		jsonPlace.put("street", this.getAddressStreet());
		if (Validator.isNotNull(this.getAddressComplement())) {
			jsonPlace.put("complement", this.getAddressComplement());
		}

		// Code postal
		jsonPlace.put("zipCode", this.getAddressZipCode());

		// Quartier
		AssetCategory districtCategory = this.getDistrictCategory();
		if (districtCategory != null) {
			String SIGId = AssetVocabularyHelper.getCategoryProperty(
					districtCategory.getCategoryId(), "SIG");
			jsonPlace.put("districtCode", SIGId);
		}

		// Ville
		AssetCategory cityCategory = this.getCityCategory();
		if (cityCategory != null) {
			String SIGId = AssetVocabularyHelper
					.getCategoryProperty(cityCategory.getCategoryId(), "SIG");
			jsonPlace.put("cityCode", SIGId);
		}

		jsonPlace.put("city", this.getCity(Locale.getDefault()));

		// Pays
		jsonPlace.put("country", this.getAddressCountry());

		// Coordonnées
		jsonPlace.put("RGF93Y", this.getRGF93Y());
		jsonPlace.put("RGF93X", this.getRGF93X());
		jsonPlace.put("mercatorY", this.getMercatorY());
		jsonPlace.put("mercatorX", this.getMercatorX());

		// Types
		JSONArray jsonTypes = JSONFactoryUtil.createJSONArray();
		for (AssetCategory assetCategory : this.getTypes()) {
			jsonTypes.put(AssetVocabularyHelper
					.getCategoryProperty(assetCategory.getCategoryId(), "SIG"));
		}
		if (jsonTypes.length() > 0) {
			jsonPlace.put("types", jsonTypes);
		}

		// Description
		jsonPlace.put("description",
				JSONHelper.getJSONFromI18nMap(this.getPresentationMap()));

		// Services et activités
		if (Validator.isNotNull(this.getServiceAndActivities())) {
			jsonPlace.put("serviceAndActivities", JSONHelper
					.getJSONFromI18nMap(this.getServiceAndActivitiesMap()));
		}

		// Caractéristiques
		if (Validator.isNotNull(this.getCharacteristics())) {
			jsonPlace.put("characteristics", JSONHelper
					.getJSONFromI18nMap(this.getCharacteristicsMap()));
		}

		// Tarifs
		if (Validator.isNotNull(this.getPrice())
				&& Validator.isNotNull(this.getPrice().getPrice())) {
			jsonPlace.put("price", JSONHelper
					.getJSONFromI18nMap(this.getPrice().getPriceMap()));
		}

		// Mail
		if (Validator.isNotNull(this.getMail())) {
			jsonPlace.put("mail", this.getMail());
		}
		if (Validator.isNotNull(this.getPhone())) {
			jsonPlace.put("phone", this.getPhone());
		}

		// Facebook
		if (Validator.isNotNull(this.getFacebookLabel())) {
			jsonPlace.put("facebookName",
					JSONHelper.getJSONFromI18nMap(this.getFacebookLabelMap()));
			jsonPlace.put("facebookURL",
					JSONHelper.getJSONFromI18nMap(this.getFacebookURLMap()));
		}

		// Site
		if (Validator.isNotNull(this.getSiteLabel())) {
			jsonPlace.put("websiteName",
					JSONHelper.getJSONFromI18nMap(this.getSiteLabelMap()));
			jsonPlace.put("websiteURL",
					JSONHelper.getJSONFromI18nMap(this.getSiteURLMap()));
		}

		// Accès
		if (Validator.isNotNull(this.getAccess())) {
			jsonPlace.put("access",
					JSONHelper.getJSONFromI18nMap(this.getAccessMap()));
		}
		if (Validator.isNotNull(this.getAccessForDisabled())) {
			jsonPlace.put("accessForDisabled", JSONHelper
					.getJSONFromI18nMap(this.getAccessForDisabledMap()));
		}
		jsonPlace.put("accessForBlind", this.getAccessForBlind());
		jsonPlace.put("accessForWheelchair", this.getAccessForWheelchair());
		jsonPlace.put("accessForDeaf", this.getAccessForDeaf());
		jsonPlace.put("accessForElder", this.getAccessForElder());
		jsonPlace.put("accessForDeficient", this.getAccessForDeficient());

		// Horaires et périodes
		JSONArray periodsJSON = JSONFactoryUtil.createJSONArray();
		for (Period period : this.getPeriods()) {
			periodsJSON.put(period.toJSON());
		}
		if (periodsJSON.length() > 0) {
			jsonPlace.put("periods", periodsJSON);
		}

		JSONArray scheduleExceptionsJSON = JSONFactoryUtil.createJSONArray();
		for (ScheduleException scheduleException : this
				.getScheduleExceptions()) {
			scheduleExceptionsJSON.put(scheduleException.toJSON());
		}
		if (scheduleExceptionsJSON.length() > 0) {
			jsonPlace.put("exceptions", scheduleExceptionsJSON);
		}

		if (Validator.isNotNull(this.getExceptionalSchedule())) {
			jsonPlace.put("exceptionalSchedule", JSONHelper
					.getJSONFromI18nMap(this.getExceptionalScheduleMap()));
		}

		// Information complémentaire
		if (Validator.isNotNull(this.getAdditionalInformation())) {
			jsonPlace.put("additionalInformation", JSONHelper
					.getJSONFromI18nMap(this.getAdditionalInformationMap()));
		}

		// URL du lieu
		jsonPlace.put("friendlyURL", StrasbourgPropsUtil.getPlaceDetailURL()
				+ "/-/entity/id/" + this.getPlaceId());

		// Image principale
		if (Validator.isNotNull(this.getImageURL())) {
			String imageURL = this.getImageURL();
			imageURL = StrasbourgPropsUtil.getURL() + imageURL;
			jsonPlace.put("imageURL", imageURL);
			jsonPlace.put("imageCopyright",
					this.getImageCopyright(Locale.getDefault()));
		}

		// Images secondaires
		JSONArray imagesJSON = JSONFactoryUtil.createJSONArray();
		for (String imageIdString : this.getImageIds().split(",")) {
			JSONObject imageJSON = JSONFactoryUtil.createJSONObject();
			Long imageId = GetterUtil.getLong(imageIdString);
			if (imageId > 0) {
				String imageURL = FileEntryHelper.getFileEntryURL(imageId);
				imageURL = StrasbourgPropsUtil.getURL() + imageURL;
				String imageCopyright = FileEntryHelper
						.getImageCopyright(imageId, LocaleUtil.FRENCH);
				imageJSON.put("imageURL", imageURL);
				imageJSON.put("imageCopyright", imageCopyright);
				imagesJSON.put(imageJSON);
			}
		}
		if (imagesJSON.length() > 0) {
			jsonPlace.put("images", imagesJSON);
		}

		// Vidéos
		JSONArray videosJSON = JSONFactoryUtil.createJSONArray();
		for (String videoIdString : this.getVideosIds().split(",")) {
			Long videoId = GetterUtil.getLong(videoIdString);
			Video video = VideoLocalServiceUtil.fetchVideo(videoId);
			if (Validator.isNotNull(video)) {
				videosJSON.put(video.getSource());
			}
		}
		if (videosJSON.length() > 0) {
			jsonPlace.put("videos", videosJSON);
		}

		// Documents
		JSONArray documentsJSON = JSONFactoryUtil.createJSONArray();
		for (String documentURL : this.getDocumentURLs()) {
			documentURL = StrasbourgPropsUtil.getURL() + documentURL;
			documentsJSON.put(documentURL);
		}
		if (documentsJSON.length() > 0) {
			jsonPlace.put("documents", documentsJSON);
		}

		return jsonPlace;
	}
}