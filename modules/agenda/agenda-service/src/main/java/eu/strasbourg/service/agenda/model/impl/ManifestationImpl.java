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

package eu.strasbourg.service.agenda.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.agenda.service.ManifestationLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.DateHelper;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.constants.VocabularyNames;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The extended model implementation for the Manifestation service. Represents a
 * row in the &quot;event_Manifestation&quot; database table, with each column
 * mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link eu.strasbourg.service.agenda.model.Manifestation} interface.
 * </p>
 *
 * @author BenjaminBini
 */
@ProviderType
public class ManifestationImpl extends ManifestationBaseImpl {

	private static final long serialVersionUID = -2751235155292359761L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a event
	 * manifestation model instance should use the {@link
	 * eu.strasbourg.service.agenda.model.Manifestation} interface instead.
	 */
	public ManifestationImpl() {
	}

	/**
	 * Retourne l'AssetEntry rattachée cet item
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(
			Manifestation.class.getName(), this.getManifestationId());
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
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		if (Validator.isNotNull(this.getExternalImageURL())) {
			return this.getExternalImageURL();
		} else {
			return FileEntryHelper.getFileEntryURL(this.getImageId());
		}
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(Locale locale) {
		if (Validator.isNotNull(this.getExternalImageCopyright())) {
			return this.getExternalImageCopyright();
		} else {
			return FileEntryHelper.getImageCopyright(this.getImageId(), locale);
		}
	}

	/**
	 * Renvoie la liste des éditions de la galerie
	 */
	@Override
	public List<Event> getEvents() {
		return EventLocalServiceUtil
			.getManifestationEvents(this.getManifestationId());
	}

	/**
	 * Renvoie la liste des ids des éditions de la galerie sous forme de String
	 */
	@Override
	public String getEventsIds() {
		List<Event> events = this.getEvents();
		String ids = "";
		for (Event event : events) {
			if (ids.length() > 0) {
				ids += ",";
			}
			ids += event.getEventId();
		}
		return ids;
	}

	/**
	 * Renvoie la liste des éditions publiées de la galerie
	 */
	@Override
	public List<Event> getPublishedEvents() {
		List<Event> events = this.getEvents();
		List<Event> result = new ArrayList<Event>();
		for (Event event : events) {
			if (event.isApproved()) {
				result.add(event);
			}
		}
		return result;
	}

	/**
	 * Retourne la période principale de la manifestation sous forme de String
	 * dans la locale passée en paramètre
	 */
	@Override
	public String getManifestationScheduleDisplay(Locale locale) {
		return DateHelper.displayPeriod(this.getStartDate(), this.getEndDate(),
			locale, true, false);
	}

	/**
	 * Renvoie la version live de la manifestation, si elle existe
	 */
	@Override
	public Manifestation getLiveVersion() {
		long groupId = this.getGroupId();
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);
		if (group == null || !group.isStagingGroup()) {
			return null;
		}
		long liveGroupId = group.getLiveGroupId();
		Manifestation liveManifestation = ManifestationLocalServiceUtil
			.fetchManifestationByUuidAndGroupId(this.getUuid(), liveGroupId);
		return liveManifestation;
	}

	/**
	 * Retourne les types de la manifestation
	 */
	@Override
	public List<AssetCategory> getTypes() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(
			this.getAssetEntry(), VocabularyNames.EVENT_TYPE);
	}
	
	/**
	 * Retourne le label des types de l'événement
	 */
	@Override
	public String getTypeLabel(Locale locale) {
		String types = "";
		for (AssetCategory type : this.getTypes()) {
			if (types.length() > 0) {
				types += " - ";
			}
			types += type.getTitle(locale);
		}
		return types;
	}

	/**
	 * Retourne les themes de la manifestation
	 */
	@Override
	public List<AssetCategory> getThemes() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(
			this.getAssetEntry(), VocabularyNames.EVENT_THEME);
	}
	
	/**
	 * Retourne le label des themes de l'événement
	 */
	@Override
	public String getThemeLabel(Locale locale) {
		String themes = "";
		for (AssetCategory theme : this.getThemes()) {
			if (themes.length() > 0) {
				themes += " - ";
			}
			themes += theme.getTitle(locale);
		}
		return themes;
	}

	/**
	 * Retourne les publics de la manifestation
	 */
	@Override
	public List<AssetCategory> getPublics() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(
			this.getAssetEntry(), VocabularyNames.EVENT_PUBLIC);
	}
	
	/**
	 * Retourne le label des publics de l'événement
	 */
	@Override
	public String getPublicLabel(Locale locale) {
		String publics = "";
		for (AssetCategory publicManif : this.getPublics()) {
			if (publics.length() > 0) {
				publics += " - ";
			}
			publics += publicManif.getTitle(locale);
		}
		return publics;
	}

	/**
	 * Retourne les territoires de la manifestation
	 */
	@Override
	public List<AssetCategory> getServices() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(
			this.getAssetEntry(), VocabularyNames.EVENT_SERVICE);
	}

	/**
	 * Renvoie la version JSON de la manifestation
	 */
	@Override
	public JSONObject toJSON() {
		JSONObject jsonManifestation = JSONFactoryUtil.createJSONObject();
		
		jsonManifestation.put("id", this.getManifestationId());
		jsonManifestation.put("externalId", this.getIdSource());

		// date de création de la source (YYYY-MM-DD HH:MM:SS)
		DateFormat dateTimeFormat = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonManifestation.put("creation_date",
				dateTimeFormat.format(this.getCreateDate().toString()));

		// date de modification de la source (YYYY-MM-DD HH:MM:SS)
		jsonManifestation.put("modification_date",
				dateTimeFormat.format(this.getModifiedDate()));

		jsonManifestation.put("title",
			JSONHelper.getJSONFromI18nMap(this.getTitleMap()));
		
		jsonManifestation.put("description",
			JSONHelper.getJSONFromI18nMap(this.getDescriptionMap()));
		
		jsonManifestation.put("imageURL", this.getImageURL());
		
		jsonManifestation.put("imageCopyright",
			this.getImageCopyright(Locale.getDefault()));

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd");
		jsonManifestation.put("startDate", dateFormat.format(this.getStartDate()));
		jsonManifestation.put("endDate", dateFormat.format(this.getEndDate()));
		
		JSONArray jsonEvents = JSONFactoryUtil.createJSONArray();
		for (Event event : this.getPublishedEvents()) {
			jsonEvents.put(event.getEventId());
		}
		if (jsonEvents.length() > 0) {
			jsonManifestation.put("events", jsonEvents);
		}
		
		JSONArray jsonCategories = AssetVocabularyHelper
			.getExternalIdsJSONArray(this.getCategories());
		if (jsonCategories.length() > 0) {
			jsonManifestation.put("categories", jsonCategories);
		}

		JSONArray jsonThemes = AssetVocabularyHelper
			.getExternalIdsJSONArray(this.getThemes());	
		if (jsonThemes.length() > 0) {
			jsonManifestation.put("themes", jsonThemes);
		}

		JSONArray jsonTypes = AssetVocabularyHelper
			.getExternalIdsJSONArray(this.getTypes());	
		if (jsonTypes.length() > 0) {
			jsonManifestation.put("types", jsonTypes);
		}
		
		JSONArray jsonPublics = AssetVocabularyHelper
			.getExternalIdsJSONArray(this.getPublics());	
		if (jsonPublics.length() > 0) {
			jsonManifestation.put("publics", jsonPublics);
		}

		JSONArray jsonServices = AssetVocabularyHelper
			.getExternalIdsJSONArray(this.getServices());		
		if (jsonServices.length() > 0) {
			jsonManifestation.put("services", jsonServices);
		}
		return jsonManifestation;
	}
}