/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * </p><p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * </p>
 */

package eu.strasbourg.service.official.model.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.official.service.OfficialLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.constants.VocabularyNames;
import org.osgi.annotation.versioning.ProviderType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * The extended model implementation for the Official service. Represents a row
 * in the &quot;official_Official&quot; database table, with each column mapped
 * to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the Official interface.
 * </p>
 *
 * @author AngeliqueZUNINO
 */
@ProviderType
public class OfficialImpl extends OfficialBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a official
	 * model instance should use the {@link official.model.Official} interface
	 * instead.
	 */
	public OfficialImpl() {
	}

	/**
	 * Renvoie la version live de l'élu, si il existe
	 */
	@Override
	public Official getLiveVersion() {
		long groupId = this.getGroupId();
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);
		if (group == null || !group.isStagingGroup()) {
			return null;
		}
		long liveGroupId = group.getLiveGroupId();
		return OfficialLocalServiceUtil
				.fetchOfficialByUuidAndGroupId(this.getUuid(), liveGroupId);
	}

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
        try {
			DLAppServiceUtil.getFileEntry(this.getImageId());
			return FileEntryHelper.getFileEntryURL(this.getImageId());
		}catch (PortalException e){
			if(this.getGender() == 2)
        		return "/o/strasbourg-theme/images/default/silhouette_femme.jpg";
			else
        		return "/o/strasbourg-theme/images/default/silhouette_homme.jpg";
        }
    }

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(Official.class.getName(),
				this.getOfficialId());
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
	 * Vérifie si la catégorie fait parti des catégories correspondants à l'élu
	 */
	@Override
	public boolean isCategoryOfficial(long categoryId) {
		List<AssetCategory> categories = getCategories();
		for (AssetCategory assetCategory : categories) {
			if (assetCategory.getCategoryId() == categoryId)
				return true;
		}
		return false;
	}

	/**
	 * Retourne les territoires du lieu
	 */
	@Override
	public List<AssetCategory> getTerritories() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(
				this.getAssetEntry(), VocabularyNames.TERRITORY);
	}

	/**
	 * Retourne l' id catégorie Fonction ville correspondant à l'élu
	 */
	@Override
	public AssetCategory getFonctionCity() {
		List<AssetCategory> fonctions = AssetVocabularyHelper
				.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
						VocabularyNames.FONCTIONS_CITY);
		if (!fonctions.isEmpty()) {
			return fonctions.get(0);
		}
		return null;
	}

	/**
	 * Retourne la liste des quartiers correspondants à l'élu
	 */
	@Override
	public List<AssetCategory> getDistricts() {
		List<AssetCategory> districts = new ArrayList<AssetCategory>();
		List<AssetCategory> territories = this.getTerritories();
		for (AssetCategory territory : territories) {
			try {
				if (territory.getAncestors().size() == 2) {
					districts.add(territory);
				}
			} catch (PortalException e) {
				continue;
			}
		}
		return districts;
	}

	/**
	 * Retourne la catégorie Groupe Politique ville correspondant à l'élu
	 */
	@Override
	public AssetCategory getPoliticalGroupCity() {
		List<AssetCategory> groups = AssetVocabularyHelper
				.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
						VocabularyNames.POLITICAL_GROUP_CITY);
		if (!groups.isEmpty()) {
			return groups.get(0);
		}
		return null;
	}

	/**
	 * Retourne la catégorie Fonction eurometropole correspondant à l'élu
	 */
	@Override
	public AssetCategory getFonctionEurometropole() {
		List<AssetCategory> fonctions = AssetVocabularyHelper
				.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
						VocabularyNames.FONCTIONS_EUROMETROPOLE);
		if (!fonctions.isEmpty()) {
			return fonctions.get(0);
		}
		return null;
	}

	/**
	 * Retourne la catégorie Fonction commune correspondant à l'élu
	 */
	@Override
	public AssetCategory getFonctionTown() {
		List<AssetCategory> fonctions = AssetVocabularyHelper
				.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
						VocabularyNames.FONCTIONS_TOWN);
		if (!fonctions.isEmpty()) {
			return fonctions.get(0);
		}
		return null;
	}

	/**
	 * Retourne la commune correspondants à l'élu
	 */
	@Override
	public AssetCategory getTown() {
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
	 * Retourne la catégorie Groupe Politique eurométropole correspondant à
	 * l'élu
	 */
	@Override
	public AssetCategory getPoliticalGroupEurometropole() {
		List<AssetCategory> groups = AssetVocabularyHelper
				.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
						VocabularyNames.POLITICAL_GROUP_EUROMETROPOLE);
		if (!groups.isEmpty()) {
			return groups.get(0);
		}
		return null;
	}

	/**
	 * Retourne la catégorie Autres mandats correspondant à l'élu
	 */
	@Override
	public List<AssetCategory> getOthersMandates() {
		return AssetVocabularyHelper
				.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
						VocabularyNames.OTHERS_MANDATES);
	}

	/**
	 * Retourne le nom féminin/masculin de la catégorie
	 *
     */
	@Override
	public String getName(AssetCategory category, Locale locale)
			throws PortalException {
		if (Validator.isNotNull(category)) {
			String female = AssetVocabularyHelper
					.getCategoryProperty(category.getCategoryId(), "female");
			if (this.getGender() == 2 && Validator.isNotNull(female)) {
				return female;
			} else {
				return category.getTitle(locale);
			}
		}
		return null;
	}

	/**
	 * Vérifie si c'est un élu municipal
	 * 
	 */
	@Override
	public boolean isAssistant() {
        return Validator.isNotNull(getDistricts());
    }

	/**
	 * Vérifie si c'est un élu municipal
	 * 
	 */
	@Override
	public boolean isEluMunicipal() {
        return Validator.isNotNull(getFonctionCity());
    }

	/**
	 * Vérifie si c'est un élu eurométropolitain
	 *
	 */
	@Override
	public boolean isEluEurometropole() {
        return Validator.isNotNull(getFonctionEurometropole());
    }

	/**
	 * Vérifie si c'est un élu eurométropolitain
	 * 
	 */
	@Override
	public boolean getCommunalMembership() {
        return Validator.isNotNull(getTown());
    }

	/**
	 * Retourne la version JSON de l'élu
	 */
	@Override
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();

		json.put("id", this.getOfficialId());
		// identité
		json.put("gender", (this.getGender() == 1 )? "male" : "female");
		json.put("lastName", this.getLastName());
		json.put("firstName", this.getFirstName());

		// élu municipal
		json.put("fonctionCity", JSONHelper.getJSONFromI18nMap(Validator.isNotNull(this.getFonctionCity())?this.getFonctionCity().getTitleMap():new HashMap<>()));
		json.put("orderDeputyMayor", this.getOrderDeputyMayor());
		json.put("thematicDelegation", JSONHelper.getJSONFromI18nMap(this.getThematicDelegationMap()));
		JSONArray districtsJSON = JSONFactoryUtil.createJSONArray();
		for(AssetCategory district : this.getDistricts()){
			districtsJSON.put(JSONHelper.getJSONFromI18nMap(district.getTitleMap()));
		}
		json.put("districts", districtsJSON);
		json.put("fonctionCity", JSONHelper.getJSONFromI18nMap(this.getPoliticalGroupCity().getTitleMap()));

		// élu communautaire
		json.put("fonctionEuro", JSONHelper.getJSONFromI18nMap(Validator.isNotNull(this.getFonctionEurometropole())?this.getFonctionEurometropole().getTitleMap():new HashMap<>()));
		json.put("orderVicePresident", this.getOrderVicePresident());
		json.put("missions", JSONHelper.getJSONFromI18nMap(this.getMissionsMap()));
		json.put("resumeFonction", JSONHelper.getJSONFromI18nMap(this.getResumeFonctionMap()));
		json.put("fonctionTown", JSONHelper.getJSONFromI18nMap(this.getFonctionTown().getTitleMap()));
		if(Validator.isNotNull(this.getFonctionEurometropole())){
			for (AssetCategory territory : this.getTerritories()) {
				try {
					if (territory.getAncestors().size() == 1) {
						json.put("town2", JSONHelper.getJSONFromI18nMap(territory.getTitleMap()));
						break;
					}
				} catch (PortalException e) {
					continue;
				}
			}
		}
        json.put("politicalsGroupsEurometropole", JSONHelper.getJSONFromI18nMap(this.getPoliticalGroupEurometropole().getTitleMap()));

		// info complémentaire
		JSONArray othersMandatesJSON = JSONFactoryUtil.createJSONArray();
		for(AssetCategory otherMandate : this.getOthersMandates()){
			othersMandatesJSON.put(JSONHelper.getJSONFromI18nMap(otherMandate.getTitleMap()));
		}
		json.put("othersMandates", othersMandatesJSON);
		json.put("wasMinister", this.getWasMinister());

		// contact
		json.put("contact", JSONHelper.getJSONFromI18nMap(this.getContactMap()));
		json.put("listeContact", this.getListeContact());

		return json;
	}

}