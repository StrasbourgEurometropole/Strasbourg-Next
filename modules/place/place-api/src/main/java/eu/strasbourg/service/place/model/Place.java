/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Place service. Represents a row in the &quot;place_Place&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see PlaceModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.place.model.impl.PlaceImpl")
@ProviderType
public interface Place extends PersistedModel, PlaceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.place.model.impl.PlaceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Place, Long> PLACE_ID_ACCESSOR =
		new Accessor<Place, Long>() {

			@Override
			public Long get(Place place) {
				return place.getPlaceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Place> getTypeClass() {
				return Place.class;
			}

		};

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Retourne le prix rattaché au lieu
	 */
	public eu.strasbourg.service.place.model.Price getPrice();

	/**
	 * Retourne les ScheduleExceptions du lieu
	 */
	public java.util.List<eu.strasbourg.service.place.model.ScheduleException>
		getScheduleExceptions();

	/**
	 * Retourne les PublicHolidays
	 */
	public java.util.List<eu.strasbourg.service.place.model.PublicHoliday>
		getPublicHolidays();

	/**
	 * Renvoie la liste des IDs des ScheduleExceptions auxquelles ce lieu
	 * appartient sous forme de String
	 */
	public String getScheduleExceptionsIds();

	/**
	 * Retourne les sous lieux du lieux
	 */
	public java.util.List<eu.strasbourg.service.place.model.SubPlace>
		getSubPlaces();

	/**
	 * Retourne les sous lieux publiés du lieu
	 */
	public java.util.List<eu.strasbourg.service.place.model.SubPlace>
		getPublishedSubPlaces();

	/**
	 * Retourne les Periods du lieux
	 */
	public java.util.List<eu.strasbourg.service.place.model.Period>
		getPeriods();

	/**
	 * Retourne les périodes qui ne sont pas par défaut (uniquement les périodes en cours ou futures)
	 */
	public java.util.List<eu.strasbourg.service.place.model.Period>
		getNonDefaultPeriods();

	/**
	 * Retourne la période par défaut
	 */
	public eu.strasbourg.service.place.model.Period getDefaultPeriod();

	/**
	 * Retourne les territoire du lieu
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritories();

	/**
	 * Retourne les types du lieu
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne le label des types de l'événement
	 */
	public String getTypeLabel(java.util.Locale locale);

	/**
	 * Retourne la ville
	 */
	public String getCity(java.util.Locale locale);

	/**
	 * Vérifie si le lieu à accès au temps réel
	 *
	 * @throws PortalException
	 */
	public Boolean isEnabled()
		throws com.liferay.portal.kernel.exception.PortalException;

	/**
	 * Retourne true si le type du lieu doit avoir un calendrier d'horaires
	 */
	public Boolean hasScheduleTable();

	/**
	 * Retourne true si le type du lieu est recherchable (utilisé pour affiche tous les lieux de meme type)
	 */
	public Boolean isSearchable();

	/**
	 * Retourne la catégorie Territoire correspondant à la ville du lieu
	 */
	public com.liferay.asset.kernel.model.AssetCategory getCityCategory();

	/**
	 * Retourne le quartier
	 */
	public String getDistrict(java.util.Locale locale);

	/**
	 * Retourne la catégorie Territoire correspondant au quartier du lieu
	 */
	public com.liferay.asset.kernel.model.AssetCategory getDistrictCategory();

	/**
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	public java.util.List<String> getImagesURLs();

	/**
	 * Retourne la liste des URL publiques des images additionnelles avec la version et le timastamp
	 */
	public java.util.List<String> getImageURLsWithTimeStamp();

	/**
	 * Retourne une map d'URL et de titre des images additionnelles et des
	 * vidéos
	 *
	 * @throws PortalException
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetEntry>
			getRandomContents()
		throws com.liferay.portal.kernel.exception.PortalException;

	/**
	 * Retourne l'URL publiques de l'image
	 */
	public String getImageURL(Long imageId);

	/**
	 * Retourne le copyright publiques de l'image
	 */
	public String getImageCopyright(Long imageId, java.util.Locale locale);

	/**
	 * Retourne la légende publiques de l'image
	 */
	public String getImageLegend(Long imageId, java.util.Locale locale);

	/**
	 * Retourne la liste des URL des documents de ce lieu
	 */
	public java.util.List<String> getDocumentURLs();

	/**
	 * Retourne une map de titre et d'URL des documents de ce lieu
	 */
	public java.util.Map<String, String> getDocuments();

	/**
	 * Retourne la liste des vidéos de ce lieu
	 */
	public java.util.List<eu.strasbourg.service.video.model.Video> getVideos();

	/**
	 * Retourne true si l'événement est accessible pour au moins un type de
	 * handicap
	 *
	 * @Override public List<Event> getEvents() {
	 List<Event> events = EventLocalServiceUtil.findByPlaceSIGId(this.getSIGid());
	 return events;
	 }
	 * @Override public List<Event> getPublishedEvents() {
	 List<Event> events = EventLocalServiceUtil.findByPlaceSIGId(this.getSIGid());
	 return events.stream().filter(e -> e.isApproved()).collect(Collectors.toList());
	 }
	 * @Override public List<Event> getCurrentAndFuturePublishedEvents() {
	 final Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, -1);
	 Date yesterday = cal.getTime();
	 List<Event> events = EventLocalServiceUtil.findByPlaceSIGId(this.getSIGid());
	 return events.stream().filter(e -> e.isApproved() && e.getStartDateFirstCurrentAndFuturePeriod().compareTo(yesterday) > 0).collect(Collectors.toList());
	 }
	 */
	public boolean hasAnyAccessForDisabled();

	/**
	 * Retourne true si le lieu est ouvert à l'instant passé en paramètre
	 */
	public Boolean isOpen(java.time.LocalDateTime localDateTime);

	/**
	 * Retourne true si le lieu est ouvert à l'instant présent
	 */
	public Boolean isOpenNow();

	public com.liferay.portal.kernel.json.JSONArray getExceptionJSON();

	/**
	 * Vérifie si le lieu est fermé un jour donné
	 */
	public Boolean isClosed(java.util.GregorianCalendar jourSemaine);

	/**
	 * Retourne true si le lieu est une piscine
	 *
	 * @return
	 */
	public boolean isSwimmingPool();

	/**
	 * Retourne true si le lieu est un parking
	 *
	 * @return
	 */
	public boolean isParking();

	/**
	 * Retourne true si le lieu est une mairie
	 *
	 * @return
	 */
	public boolean isMairie();

	/**
	 * Retourne true si le lieu est une patinoire
	 *
	 * @return
	 */
	public boolean isIceRink();

	/**
	 * Retourne true si le lieu est une station vélhop
	 *
	 * @return
	 */
	public boolean isVelhopStation();

	/**
	 * Retourne le temps réel (en gérant automatiquement le fait que ce soit une
	 * piscine,une mairie ou un parking)
	 *
	 * @throws Exception
	 */
	public eu.strasbourg.utils.OccupationState getRealTime();

	/**
	 * Retourne le temps réel (couleur de fond,valeur)
	 *
	 * @param type (1 = piscine, 2 = parking, 3 = mairie, 4 = patinoire, 5 =Vélop)
	 * @throws Exception
	 */
	public eu.strasbourg.utils.OccupationState getRealTime(String type);

	/**
	 * Retourne une map contennant les horaires de chaque jour des 7 jours
	 * suivants "startDate" (inclus)
	 */
	public java.util.Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getFollowingWeekSchedules(
				java.util.Date startDate, java.util.Locale locale);

	/**
	 * Retourne une map contennant le jour et une liste de PlaceSchedule de la
	 * semaine en cours
	 */
	public java.util.Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getHoraire(java.util.Date dateJour, java.util.Locale locale);

	/**
	 * Retourne le PlaceSchedule de la prochaine ouverture (pour X jour)
	 */
	public eu.strasbourg.service.place.model.PlaceSchedule
		getNextScheduleOpening(
			java.util.GregorianCalendar today, int nbDays,
			java.util.Locale locale);

	/**
	 * Retourne le PlaceSchedule de la prochaine ouverture (sous quinzaine)
	 */
	public eu.strasbourg.service.place.model.PlaceSchedule
		getNextScheduleOpening(
			java.util.GregorianCalendar today, java.util.Locale locale);

	/**
	 * Retourne les horaires d'ouverture du jour passé en paramètre jusqu'à
	 * "date" + "daysCount"
	 */
	public java.util.Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getPlaceSchedule(
				java.util.Date date, int daysCount, java.util.Locale locale);

	/**
	 * Retourne les horaires d'ouverture du jour
	 */
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getPlaceSchedule(
			java.util.GregorianCalendar jourSemaine, java.util.Locale locale);

	/**
	 * Retourne les horaires habituels d'ouverture du jour
	 */
	public eu.strasbourg.service.place.model.PlaceSchedule
		getRegularPlaceSchedule(
			java.util.GregorianCalendar jourSemaine, java.util.Locale locale);

	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getPlaceScheduleException(
			java.util.GregorianCalendar dateChoisie, Boolean surPeriode,
			java.util.Locale locale);

	/**
	 * Retourne les horaires des exceptions d'ouverture à partir du lundi de la
	 * semaine en cours
	 *
	 * @param surPeriode (false = horaires d'une journée uniquement , true = horaires
	 sur 3 mois à partir du jour )
	 * @param startOfWeek (true = début de la semaine, false = jour donné)
	 */
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getPlaceScheduleException(
			java.util.GregorianCalendar dateChoisie, Boolean surPeriode,
			Boolean startOfWeek, java.util.Locale locale);

	/**
	 * Retourne les jours fériés dans une plage de dates donnée.
	 * Les jours fériés récurrents sont inclus dans la plage donnée.
	 *
	 * @param premierJour  La date de début de la plage.
	 * @param dernierJour  La date de fin de la plage.
	 * @return La liste des jours fériés dans la plage donnée.
	 */
	public java.util.HashMap
		<java.util.Date, eu.strasbourg.service.place.model.PublicHoliday>
			getHolidays(
				java.util.Calendar premierJour, java.util.Calendar dernierJour);

	/**
	 * Retourne les PlaceSchedule des exceptions d'ouverture à partir du lundi
	 * de la semaine en cours, jusqu'à dans 3 mois (pour freemarker)
	 */
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getPlaceScheduleExceptionFreeMarker(
			java.util.Date dateDeb, Boolean surPeriode,
			java.util.Locale locale);

	/**
	 * Retourne la version JSON du lieu
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

	/**
	 * Retourne la version JSON du lieu
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		long territoryVocabularyId, long typeVocabularyId,
		long equipmentVocabularyId);

	/**
	 * Retourne la version GeoJSON du lieu
	 */
	public com.liferay.portal.kernel.json.JSONObject toGeoJSON();

	/**
	 * Renvoie le JSON de l'entite au format GeoJSON pour la map
	 */
	public com.liferay.portal.kernel.json.JSONObject getGeoJSON(
		long groupId, java.util.Locale locale, long territoryVocabularyId,
		long placeTypeVocabularyId);

	/**
	 * Renvoie le JSON de l'entite au format CSMap
	 */
	public com.liferay.portal.kernel.json.JSONObject getCSMapJSON();

	/**
	 * Renvoie le JSON de l'entite au format CSMap
	 */
	public com.liferay.portal.kernel.json.JSONObject getCSMapExceptionJSON();

	/**
	 * Renvoie le JSON des horaires sur 7 jours au format CSMap
	 */
	public com.liferay.portal.kernel.json.JSONObject getScheduleCSMapJSON();

	/**
	 * Renvoie le titre du lieu pour friendlyUrl
	 */
	public String getNormalizedAlias();

	/**
	 * Renvoie le titre du lieu pour friendlyUrl
	 */
	public String getNormalizedAlias(java.util.Locale locale);

}