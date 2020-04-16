package eu.strasbourg.service.poi.impl;

import com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalService;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.favorite.model.Favorite;
import eu.strasbourg.service.favorite.model.FavoriteType;
import eu.strasbourg.service.favorite.service.FavoriteLocalServiceUtil;
import eu.strasbourg.service.gtfs.model.Arret;
import eu.strasbourg.service.gtfs.service.ArretLocalServiceUtil;
import eu.strasbourg.service.interest.model.Interest;
import eu.strasbourg.service.interest.service.InterestLocalServiceUtil;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.service.poi.PoiService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Benjamin Bini
 */
@Component(immediate = true, property = {}, service = PoiService.class)
public class PoiServiceImpl implements PoiService {

	public JSONObject getPois(String idInterests, long groupId) {
		return getPois(idInterests, "", "", groupId, Place.class.getName());
	}
	
	public JSONObject getPois(String idInterests, long groupId, String localeId) {
		return getPois(idInterests, "", "", groupId, Place.class.getName(), localeId);
	}
	
	public JSONObject getPois(String idInterests, String idCategories, String prefilters, long groupId,
			String classNames) {
		return getPois( idInterests,  idCategories,  prefilters,  groupId,
				classNames, "fr_FR");
	}

	public JSONObject getPois(String idInterests, String idCategories, String prefilters, long groupId,
			String classNames, String localeId) {
		JSONObject geoJson = null;

		long globalGroupId = -1;

		Locale locale = LocaleUtil.fromLanguageId(localeId);

		// Récupération des préfiltres
		Long[] prefiltersCategoryIds = new Long[0];
		if (prefilters.length() > 0) {
			String[] prefiltersParts = prefilters.split(",");
			prefiltersCategoryIds = new Long[prefiltersParts.length];
			for (int i = 0; i < prefiltersParts.length; i++) {
				prefiltersCategoryIds[i] = Long.valueOf(prefiltersParts[i]);
			}
		}

		// récupère les catégories ainsi que les catégories enfants des
		// catégories
		List<AssetCategory> filterCategories = new ArrayList<AssetCategory>();
		if (Validator.isNotNull(idCategories)) {
			for (String idCategory : idCategories.split(",")) {
				AssetCategory assetCategory = AssetCategoryLocalServiceUtil
						.fetchAssetCategory(Long.parseLong(idCategory));
				filterCategories.add(assetCategory);
				// récupère les catégories enfants
				List<AssetCategory> chilsCategories = AssetCategoryLocalServiceUtil
						.getChildCategories(assetCategory.getCategoryId());
				if (!chilsCategories.isEmpty()) {
					filterCategories.addAll(chilsCategories);
				}
				if (globalGroupId == -1) {
					globalGroupId = assetCategory.getGroupId();
				}
			}
		}

		// récupère les catégories ainsi que les catégories enfants des centres
		// d'intérêts
		if (Validator.isNotNull(idInterests)) {
			for (String idInterest : idInterests.split(",")) {
				Interest interest = InterestLocalServiceUtil.fetchInterest(Long.parseLong(idInterest));
				List<AssetCategory> categories = interest.getCategories();
				filterCategories.addAll(categories);
				for (AssetCategory assetCategory : categories) {
					// récupère les catégories enfants
					List<AssetCategory> chilsCategories = AssetCategoryLocalServiceUtil
							.getChildCategories(assetCategory.getCategoryId());
					if (!chilsCategories.isEmpty()) {
						filterCategories.addAll(chilsCategories);
					}
				}
				if (globalGroupId == -1) {
					globalGroupId = interest.getGroupId();
				}
			}
		}

		Long[] filterCategoryIds = new Long[filterCategories.size()];
		for (int i = 0; i < filterCategories.size(); i++) {
			filterCategoryIds[i] = filterCategories.get(i).getCategoryId();
		}

		long startTime = 0, endTime = 0, duration = 0;
		List<Place> places = new ArrayList<Place>();
		if (classNames.equals("all") || classNames.contains(Place.class.getName())) {
			// récupère les lieux des catégories et centres d'intérêt
			startTime = System.nanoTime();
			places = getPlaces(filterCategoryIds, prefiltersCategoryIds, globalGroupId);
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1_000_000;
			System.out.println("GetPlaces : " + duration + "ms (" + places.size() + " items)");
		}

		List<Event> events = new ArrayList<Event>();
		if (classNames.equals("all") || classNames.contains(Event.class.getName())) {
			// récupère les évènements des catégories et centres d'intérêt
			startTime = System.nanoTime();
			events = getEvents(filterCategoryIds, prefiltersCategoryIds, globalGroupId);
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1_000_000;
			System.out.println("GetEvents : " + duration + "ms (" + events.size() + " items)");
		}

		// récupère les arrêts
		List<Arret> arrets = new ArrayList<Arret>();
		if (classNames.equals("all") || classNames.contains(Arret.class.getName())) {
			// récupère les arrets
			startTime = System.nanoTime();
			arrets = getArrets(filterCategoryIds, prefiltersCategoryIds, globalGroupId);
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1_000_000;
			System.out.println("GetArrets : " + duration + "ms (" + arrets.size() + " items)");
		}

		// récupère le fichier geoJson
		try {
			startTime = System.nanoTime();
			geoJson = getGeoJSON(places, events, arrets, groupId, locale);
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1_000_000;
			System.out.println("getGeoJSON : " + duration + "ms");
			System.out.println();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return geoJson;
	}

	public int getPoisCategoryCount(long idCategory, String prefilters, long groupId, String classNames) {

		// récupère les catégories ainsi que les catégories enfants des
		// catégories
		long globalGroupId = -1;
		List<AssetCategory> categories = new ArrayList<AssetCategory>();
		if (Validator.isNotNull(idCategory)) {
			AssetCategory assetCategory = AssetCategoryLocalServiceUtil.fetchAssetCategory(idCategory);
			categories.add(assetCategory);
			// récupère les catégories enfants
			List<AssetCategory> childCategories = AssetCategoryLocalServiceUtil
					.getChildCategories(assetCategory.getCategoryId());
			if (!childCategories.isEmpty()) {
				categories.addAll(childCategories);
			}
			if (globalGroupId == -1) {
				globalGroupId = assetCategory.getGroupId();
			}
		}

		AssetEntryQuery query = new AssetEntryQuery();
		// Récupération des préfiltres
		long[] prefiltersCategoryIds = new long[0];
		if (prefilters.length() > 0) {
			String[] prefiltersParts = prefilters.split(",");
			prefiltersCategoryIds = new long[prefiltersParts.length];
			for (int i = 0; i < prefiltersParts.length; i++) {
				prefiltersCategoryIds[i] = Long.valueOf(prefiltersParts[i]);
			}
		}
		if (prefiltersCategoryIds.length > 0) {
			query.setAllCategoryIds(prefiltersCategoryIds);
		}
		query.setAnyCategoryIds(categories.stream().mapToLong(c -> c.getCategoryId()).toArray());

		List<AssetEntry> entriesForFiltersAndPrefilters = AssetEntryLocalServiceUtil.getEntries(query);

		List<AssetEntry> entries = new ArrayList<AssetEntry>();

		for (AssetEntry entry : entriesForFiltersAndPrefilters) {
			if(entry.getAssetRenderer() != null && entry.getAssetRenderer().getStatus() == WorkflowConstants.STATUS_APPROVED && entry.getVisible() && entry.getListable()
					&& (classNames.contains(entry.getClassName()) || classNames.equals("all"))) {
				if (entry.getClassName().equals(Event.class.getName())) {
					Event event = EventLocalServiceUtil.fetchEvent(entry.getClassPK());
					if (event != null && event.getNextOpenDate().isEqual(LocalDate.now())) {
						entries.add(entry);
					}
				} else {
					entries.add(entry);
				}
			}
		}
		return entries.size();
	}

	public int getPoisInterestCount(long idInterest, long groupId, String classNames) {

		Interest interest = InterestLocalServiceUtil.fetchInterest(idInterest);
		List<AssetCategory> interestCategories = interest.getCategories();
		// récupère les catégories ainsi que les catégories enfants des
		// catégories
		long globalGroupId = -1;
		List<AssetCategory> categories = new ArrayList<AssetCategory>();
		for (AssetCategory interestCategory : interestCategories) {
			categories.add(interestCategory);
			// récupère les catégories enfants
			List<AssetCategory> childCategories = AssetCategoryLocalServiceUtil
					.getChildCategories(interestCategory.getCategoryId());
			if (!childCategories.isEmpty()) {
				categories.addAll(childCategories);
			}
			if (globalGroupId == -1) {
				globalGroupId = interestCategory.getGroupId();
			}
		}

		AssetEntryQuery query = new AssetEntryQuery();
		query.setAnyCategoryIds(categories.stream().mapToLong(c -> c.getCategoryId()).toArray());

		List<AssetEntry> entriesForFilters = AssetEntryLocalServiceUtil.getEntries(query);

		List<AssetEntry> entries = new ArrayList<>();

		for (AssetEntry entry : entriesForFilters) {
			if (entry.getAssetRenderer() != null && entry.getAssetRenderer().getStatus() == WorkflowConstants.STATUS_APPROVED && entry.getVisible() && entry.getListable()
					&& (classNames.contains(entry.getClassName()) || classNames.equals("all"))) {
				if (entry.getClassName().equals(Event.class.getName())) {
					Event event = EventLocalServiceUtil.fetchEvent(entry.getClassPK());
					if (event != null && event.getNextOpenDate().isEqual(LocalDate.now())) {
						entries.add(entry);
					}
				} else {
					entries.add(entry);
				}
			}
		}
		return entries.size();
	}

	private List<Place> getPlaces(Long[] categoryIds, Long[] prefilters, long globalGroupId) {

		List<AssetEntryAssetCategoryRel> entriesFromFilters = new ArrayList<>();
		for (Long categoryId : categoryIds) {
			entriesFromFilters.addAll(assetEntryAssetCategoryRelLocalService.getAssetEntryAssetCategoryRelsByAssetCategoryId(categoryId));
		}
		List<AssetEntryAssetCategoryRel> entriesRel = new ArrayList(entriesFromFilters);

		if (prefilters.length > 0) {
			List<AssetEntryAssetCategoryRel> entriesFromPrefilters = new ArrayList<>();
			for (Long categoryId : prefilters) {
				entriesFromPrefilters.addAll(assetEntryAssetCategoryRelLocalService.getAssetEntryAssetCategoryRelsByAssetCategoryId(categoryId));
			}

			entriesRel = entriesRel.stream()
					.filter(e -> entriesFromPrefilters.stream().anyMatch(p -> p.getAssetEntryId() == e.getAssetEntryId()))
					.collect(Collectors.toList());
		}

		//transforme les AssetEntriesAssetCategories en AssetEntries
		List<AssetEntry> entries = new ArrayList<>();
		for (AssetEntryAssetCategoryRel entryRel : entriesRel) {
			if (Validator.isNotNull(entryRel)) {
				try {
					entries.add(AssetEntryLocalServiceUtil.getAssetEntry(entryRel.getAssetEntryId()));
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}

		List<Long> classPks = entries.stream().map(AssetEntry::getClassPK).distinct().collect(Collectors.toList());
		if (classPks.size() > 0) {
			Criterion idCriterion = RestrictionsFactoryUtil.in("placeId", classPks);
			Criterion statusCriterion = RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED);
			DynamicQuery placeQuery = PlaceLocalServiceUtil.dynamicQuery().add(idCriterion).add(statusCriterion);
			return PlaceLocalServiceUtil.dynamicQuery(placeQuery);
		} else {
			return new ArrayList<Place>();
		}
	}

	private List<Event> getEvents(Long[] categoryIds, Long[] prefilters, long globalGroupId) {

		List<AssetEntryAssetCategoryRel> entriesFromFilters = new ArrayList<>();
		for (Long categoryId : categoryIds) {
			entriesFromFilters.addAll(assetEntryAssetCategoryRelLocalService.getAssetEntryAssetCategoryRelsByAssetCategoryId(categoryId));
		}
		List<AssetEntryAssetCategoryRel> entriesRel = new ArrayList(entriesFromFilters);

		if (prefilters.length > 0) {
			List<AssetEntryAssetCategoryRel> entriesFromPrefilters = new ArrayList<>();
			for (Long categoryId : prefilters) {
				entriesFromPrefilters.addAll(assetEntryAssetCategoryRelLocalService.getAssetEntryAssetCategoryRelsByAssetCategoryId(categoryId));
			}

			entriesRel = entriesRel.stream()
					.filter(e -> entriesFromPrefilters.stream().anyMatch(p -> p.getAssetEntryId() == e.getAssetEntryId()))
					.collect(Collectors.toList());
		}

		//transforme les AssetEntriesAssetCategories en AssetEntries
		List<AssetEntry> entries = new ArrayList<>();
		for (AssetEntryAssetCategoryRel entryRel : entriesRel) {
			if (Validator.isNotNull(entryRel)) {
				try {
					entries.add(AssetEntryLocalServiceUtil.getAssetEntry(entryRel.getAssetEntryId()));
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}

		List<Long> classPks = entries.stream().map(AssetEntry::getClassPK).collect(Collectors.toList());
		if (classPks.size() > 0) {
			Criterion idCriterion = RestrictionsFactoryUtil.in("eventId", classPks);
			Criterion statusCriterion = RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED);
			DynamicQuery eventQuery = EventLocalServiceUtil.dynamicQuery().add(idCriterion).add(statusCriterion);
			List<Event> events = EventLocalServiceUtil.dynamicQuery(eventQuery);
			// on ne garde que les évènements du jour
			events = events.stream().filter(e -> e.getNextOpenDate().isEqual(LocalDate.now()))
					.collect(Collectors.toList());

			return events;
		} else {
			return new ArrayList<Event>();
		}
	}

	private List<Arret> getArrets(Long[] categoryIds, Long[] prefilters, long globalGroupId) {

		List<AssetEntryAssetCategoryRel> entriesFromFilters = new ArrayList<>();
		for (Long categoryId : categoryIds) {
			entriesFromFilters.addAll(assetEntryAssetCategoryRelLocalService.getAssetEntryAssetCategoryRelsByAssetCategoryId(categoryId));
		}
		List<AssetEntryAssetCategoryRel> entriesRel = new ArrayList(entriesFromFilters);

		if (prefilters.length > 0) {
			List<AssetEntryAssetCategoryRel> entriesFromPrefilters = new ArrayList<>();
			for (Long categoryId : prefilters) {
				entriesFromPrefilters.addAll(assetEntryAssetCategoryRelLocalService.getAssetEntryAssetCategoryRelsByAssetCategoryId(categoryId));
			}

			entriesRel = entriesRel.stream()
					.filter(e -> entriesFromPrefilters.stream().anyMatch(p -> p.getAssetEntryId() == e.getAssetEntryId()))
					.collect(Collectors.toList());
		}

		//transforme les AssetEntriesAssetCategories en AssetEntries
		List<AssetEntry> entries = new ArrayList<>();
		for (AssetEntryAssetCategoryRel entryRel : entriesRel) {
			if (Validator.isNotNull(entryRel)) {
				try {
					entries.add(AssetEntryLocalServiceUtil.getAssetEntry(entryRel.getAssetEntryId()));
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}

		List<Long> classPks = entries.stream().map(AssetEntry::getClassPK).distinct().collect(Collectors.toList());
		if (classPks.size() > 0) {
			Criterion idCriterion = RestrictionsFactoryUtil.in("arretId", classPks);
			Criterion statusCriterion = RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED);
			DynamicQuery arretQuery = ArretLocalServiceUtil.dynamicQuery().add(idCriterion).add(statusCriterion);
			return ArretLocalServiceUtil.dynamicQuery(arretQuery);
		} else {
			return new ArrayList<Arret>();
		}
	}

	public JSONObject getFavoritesPois(String userId, long groupId) {
		return getFavoritesPois(userId, groupId, Place.class.getName());
	}

	public JSONObject getFavoritesPois(String userId, long groupId, String classNames) {
		return getFavoritesPois( userId,  groupId,  classNames,  "fr_FR");
	}
	
	public JSONObject getFavoritesPois(String userId, long groupId, String classNames, String localeId) {
		JSONObject geoJSON = JSONFactoryUtil.createJSONObject();
		geoJSON.put("type", "FeatureCollection");
		
		Locale locale = LocaleUtil.fromLanguageId(localeId);

		// récupère les favoris de l'uilisateur
		List<Favorite> favorites = FavoriteLocalServiceUtil.getByPublikUser(userId);
		if (favorites != null) {
			JSONArray features = JSONFactoryUtil.createJSONArray();
			if (classNames.equals("all") || classNames.contains(Place.class.getName())) {
				Stream<Favorite> placeFavorites = favorites.stream()
						.filter(f -> f.getTypeId() == FavoriteType.PLACE.getId());
				if (placeFavorites != null) {
					for (Favorite favorite : placeFavorites.collect(Collectors.toList())) {
						Place place = PlaceLocalServiceUtil.fetchPlace(favorite.getEntityId());
						if (place != null) {
							features.put(place.getGeoJSON(groupId,locale));
						}
					}
				}
			}
			if (classNames.equals("all") || classNames.contains(Arret.class.getName())) {
				Stream<Favorite> arretFavorites = favorites.stream()
						.filter(f -> f.getTypeId() == FavoriteType.ARRET.getId());
				if (arretFavorites != null) {
					for (Favorite favorite : arretFavorites.collect(Collectors.toList())) {
						Arret arret = ArretLocalServiceUtil.fetchArret(favorite.getEntityId());
						if (arret != null) {
							features.put(arret.getGeoJSON(groupId,locale));
						}
					}
				}
			}
			if (classNames.equals("all") || classNames.contains(Event.class.getName())) {
				Stream<Favorite> eventFavorites = favorites.stream()
						.filter(f -> f.getTypeId() == FavoriteType.EVENT.getId());
				if (eventFavorites != null) {
					for (Favorite favorite : eventFavorites.collect(Collectors.toList())) {
						Event event = EventLocalServiceUtil.fetchEvent(favorite.getEntityId());
						if (event != null && event.getNextOpenDate().isEqual(LocalDate.now())) {
							// on ne garde que les évènements du jour
							features.put(event.getGeoJSON(groupId,locale));
						}
					}
				}
			}
			geoJSON.put("features", features);
		}
		return geoJSON;
	}

	public int getFavoritesPoisCount(String userId, long groupId, String classNames) {
		int count = 0;

		// récupère les favoris de l'uilisateur
		List<Favorite> favorites = FavoriteLocalServiceUtil.getByPublikUser(userId);
		if (classNames.equals("all")) {
			count += favorites.stream().filter(f -> f.getTypeId() == FavoriteType.PLACE.getId() || f.getTypeId() == FavoriteType.ARRET.getId())
					.collect(Collectors.toList()).size();
			List<Favorite> eventsfavorites = favorites.stream().filter(f -> f.getTypeId() == FavoriteType.EVENT.getId())
					.collect(Collectors.toList());
			for (Favorite favorite : eventsfavorites) {
				Event event = EventLocalServiceUtil.fetchEvent(favorite.getEntityId());
				if (event != null && event.getNextOpenDate().isEqual(LocalDate.now())) {
					count++;
					;
				}
			}
		} else {
			if (classNames.contains(Place.class.getName()))
				count += favorites.stream().filter(f -> f.getTypeId() == FavoriteType.PLACE.getId())
						.collect(Collectors.toList()).size();
			if (classNames.contains(Arret.class.getName()))
				count += favorites.stream().filter(f -> f.getTypeId() == FavoriteType.ARRET.getId())
						.collect(Collectors.toList()).size();
			if (classNames.contains(Event.class.getName())) {
				List<Favorite> eventsfavorites = favorites.stream()
						.filter(f -> f.getTypeId() == FavoriteType.EVENT.getId()).collect(Collectors.toList());
				for (Favorite favorite : eventsfavorites) {
					Event event = EventLocalServiceUtil.fetchEvent(favorite.getEntityId());
					if (event != null && event.getNextOpenDate().isEqual(LocalDate.now())) {
						count++;
						;
					}
				}
			}
		}
		return count;
	}

	static private JSONObject getGeoJSON(List<Place> places, List<Event> events, long groupId, Locale locale) throws JSONException {
		return getGeoJSON(places, events, new ArrayList<Arret>(), groupId, locale);
	}

	static private JSONObject getGeoJSON(List<Place> places, List<Event> events, List<Arret> arrets, long groupId, Locale locale) throws JSONException {
		JSONObject geoJSON = JSONFactoryUtil.createJSONObject();
		geoJSON.put("type", "FeatureCollection");

		JSONArray features = JSONFactoryUtil.createJSONArray();
		for (Place place : places) {
			features.put(place.getGeoJSON(groupId,locale));
		}

		for (Event event : events) {
			features.put(event.getGeoJSON(groupId, locale));
		}

		for (Arret arret : arrets) {
			features.put(arret.getGeoJSON(groupId, locale));
		}
		geoJSON.put("features", features);

		return geoJSON;
	}

}
