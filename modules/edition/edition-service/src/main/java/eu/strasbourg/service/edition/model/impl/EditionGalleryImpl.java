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

package eu.strasbourg.service.edition.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.model.EditionGallery;
import eu.strasbourg.service.edition.service.EditionGalleryLocalServiceUtil;
import eu.strasbourg.service.edition.service.EditionLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.constants.VocabularyNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The extended model implementation for the EditionGallery service. Represents
 * a row in the &quot;edition_EditionGallery&quot; database table, with each
 * column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link eu.strasbourg.service.edition.model.EditionGallery}
 * interface.
 * </p>
 *
 * @author BenjaminBini
 */
@ProviderType
public class EditionGalleryImpl extends EditionGalleryBaseImpl {

	private static final long serialVersionUID = -2751235155292359761L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a edition
	 * gallery model instance should use the {@link
	 * eu.strasbourg.service.edition.model.EditionGallery} interface instead.
	 */
	public EditionGalleryImpl() {
	}

	/**
	 * Retourne l'AssetEntry rattachée cet item
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil
			.fetchEntry(EditionGallery.class.getName(), this.getGalleryId());
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public List<AssetCategory> getCategories() {
		return AssetVocabularyHelper.getAssetEntryCategories(this.getAssetEntry());
	}

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 * 
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
	 * Renvoie la liste des éditions de la galerie
	 */
	@Override
	public List<Edition> getEditions() {
		return EditionLocalServiceUtil
			.getEditionGalleryEditions(this.getGalleryId());
	}

	/**
	 * Renvoie la liste des ids des éditions de la galerie sous forme de String
	 */
	@Override
	public String getEditionsIds() {
		List<Edition> editions = this.getEditions();
		String ids = "";
		for (Edition edition : editions) {
			if (ids.length() > 0) {
				ids += ",";
			}
			ids += edition.getEditionId();
		}
		return ids;
	}

	/**
	 * Retourne les types de la galerie d'éditions
	 */
	@Override
	public List<AssetCategory> getTypes() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(
			this.getAssetEntry(), VocabularyNames.EDITION_TYPE);
	}

	
	/**
	 * Retourne le texte à afficher pour les types de la galerie d'éditions
	 */
	@Override
	public String getTypesLabels(Locale locale) {
		List<AssetCategory> types = this.getTypes();
		String label = "";
		for (AssetCategory typeCategory : types) {
			if (label.length() > 0) {
				label += ", ";
			}
			label += typeCategory.getTitle(locale);
		}
		return label;
	}
	
	
	/**
	 * Renvoie la liste des éditions publiées de la galerie
	 */
	@Override
	public List<Edition> getPublishedEditions() {
		List<Edition> editions = this.getEditions();
		List<Edition> result = new ArrayList<Edition>();
		for (Edition edition : editions) {
			if (edition.isApproved()) {
				result.add(edition);
			}
		}
		return result;
	}

	/**
	 * Renvoie la version live de la galerie d'édition, si elle existe
	 */
	@Override
	public EditionGallery getLiveVersion() {
		long groupId = this.getGroupId();
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);
		if (group == null || !group.isStagingGroup()) {
			return null;
		}
		long liveGroupId = group.getLiveGroupId();
		EditionGallery liveGallery = EditionGalleryLocalServiceUtil
			.fetchEditionGalleryByUuidAndGroupId(this.getUuid(), liveGroupId);
		return liveGallery;
	}

	/**
	 * Retourne la version JSON de la galerie
	 */
	@Override
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();

		json.put("id", this.getGalleryId());
		json.put("title", JSONHelper.getJSONFromI18nMap(this.getTitleMap()));
		json.put("description", JSONHelper.getJSONFromI18nMap(this.getDescriptionMap()));

		return json;
	}
}