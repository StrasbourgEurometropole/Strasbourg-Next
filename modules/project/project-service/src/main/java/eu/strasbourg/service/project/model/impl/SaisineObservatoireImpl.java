/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.model.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.PlacitPlaceLocalServiceUtil;
import eu.strasbourg.service.project.service.SignataireLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.constants.VocabularyNames;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

import static eu.strasbourg.service.project.constants.ParticiperCategories.*;

/**
 * The extended model implementation for the SaisineObservatoire service. Represents a row in the &quot;project_SaisineObservatoire&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>eu.strasbourg.service.project.model.SaisineObservatoire</code> interface.
 * </p>
 *
 * @author Joshua Chacha
 */
public class SaisineObservatoireImpl extends SaisineObservatoireBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a saisine observatoire model instance should use the {@link eu.strasbourg.service.project.model.SaisineObservatoire} interface instead.
     */
    public SaisineObservatoireImpl() {
    }

    /**
     * Retourne l'AssetEntry rattaché cet item
     */
    @Override
    public AssetEntry getAssetEntry() {
        return AssetEntryLocalServiceUtil.fetchEntry(SaisineObservatoire.class.getName(), this.getSaisineObservatoireId());
    }

    /**
     * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
     */
    @Override
    public List<AssetCategory> getCategories() {
        return AssetVocabularyHelper.getAssetEntryCategories(this.getAssetEntry());
    }

    /**
     * méthode de récupération du status
     *
     * @return le status.
     */
    @Override
    public String getSaisineObservatoireStatus() {

        //Statut par défaut quand déposée
        String result = DRAFT.getName();

        // TODO : implémenter les bonnes propriétés

        return result;
    }

    @Override
    public String getAuthorLabel() {
        if (this.getInTheNameOf() != "" && this.getInTheNameOf() != null) {
            return this.getInTheNameOf();
        } else {
            return StringUtil.upperCaseFirstLetter(this.getPetitionnaireFirstname()) + " " + StringUtil.toUpperCase(StringUtil.shorten(this.getPetitionnaireLastname(), 2, "."));
        }
    }

    /**
     * Retourne la liste des lieux placit liés à la petition
     */
    @Override
    public List<PlacitPlace> getPlacitPlaces() {
        return PlacitPlaceLocalServiceUtil.getBySaisineObservatoire(this.getSaisineObservatoireId());
    }

    /**
     * Retourne le label de 5 digits du nombre de commentaires de l'entité
     */
    @Override
    public String getNbApprovedCommentsLabel() {
        // Transforme le numero en chaine de caractere
        String stringNum = Integer.toString(this.getNbApprovedComments());
        // Recupere le nombre de chiffre
        int nbDigits = stringNum.length();
        // Ajoute les zeros manquants avant la chaine
        stringNum = new String(new char[5 - nbDigits]).replace("\0", "0") + stringNum;
        return stringNum;
    }

    /**
     * Retourne le nombre de commentaires de l'entité
     */
    @Override
    public int getNbApprovedComments() {
        return CommentLocalServiceUtil.getByAssetEntry(this.getAssetEntry().getEntryId(), WorkflowConstants.STATUS_APPROVED).size();
    }

    /**
     * Retourne les thematiques de la petition (
     */
    @Override
    public List<AssetCategory> getThematicCategories() {
        return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(), VocabularyNames.THEMATIC);
    }

    /**
     * Retourne le projet de la petition (
     */
    @Override
    public AssetCategory getProjectCategory() {
        List<AssetCategory> listProject = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(), VocabularyNames.PROJECT);
        return (listProject != null && !listProject.isEmpty()) ? listProject.get(0) : null;
    }

    /**
     * Retourne la version JSON de l'entité
     */
    @Override
    public JSONObject toJSON(String publikUserId) {
        // Initialisation des variables tempons et résultantes
        JSONObject jsonSaisineObservatoire = JSONFactoryUtil.createJSONObject();
        JSONArray jsonPlacitPlaces = JSONFactoryUtil.createJSONArray();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        jsonSaisineObservatoire.put("id", this.getSaisineObservatoireId());
        jsonSaisineObservatoire.put("createDate", dateFormat.format(this.getCreateDate()));

        jsonSaisineObservatoire.put("imageURL", this.getImageURL());
        jsonSaisineObservatoire.put("userName", HtmlUtil.stripHtml(HtmlUtil.escape(this.getUserName())));
        jsonSaisineObservatoire.put("author", this.getAuthorLabel());
        jsonSaisineObservatoire.put("authorImageURL", this.getAuthorImageURL());
        jsonSaisineObservatoire.put("nbApprovedComments", this.getNbApprovedComments());
//        jsonSaisineObservatoire.put("frontStatusFR", this.getFrontStatusFR());
        jsonSaisineObservatoire.put("districtLabel", HtmlUtil.stripHtml(HtmlUtil.escape(this.getDistrictLabel(Locale.FRENCH))));
        jsonSaisineObservatoire.put("title", HtmlUtil.stripHtml(HtmlUtil.escape(this.getTitle())));
//        jsonPetition.put("proDureeFR", this.getProDureeFR());
//        jsonPetition.put("quotaSignature", this.getQuotaSignature());
        jsonSaisineObservatoire.put("projectTitle", this.getProjectTitle(Locale.FRANCE));

        // Lieux placit
        for (PlacitPlace placitPlace : this.getPlacitPlaces()) {
            jsonPlacitPlaces.put(placitPlace.toJSON());
        }
        jsonSaisineObservatoire.put("placitPlaces", jsonPlacitPlaces);

        return jsonSaisineObservatoire;
    }

    public String getProjectTitle(Locale locale) {
        AssetCategory project = getProjectCategory();
        return (project != null) ? project.getName() : "";
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
     * Retourne l'URL de l'image de l'utilisateur
     */
    @Override
    public String getAuthorImageURL() {
        PublikUser author = this.getAuthorPublikUser();
        if (author != null) {
            return author.getImageURLOrSurrogate();
        }
        return "";
    }

    /**
     * Retourne l'auteur en publik user
     *
     * @return
     */
    @Override
    public PublikUser getAuthorPublikUser() {
        return PublikUserLocalServiceUtil.getByPublikUserId(this.getPublikId());
    }

    /**
     * Retourne une chaine des 'Territoires' correspondant aux quartiers de la petition
     *
     * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
     */
    @Override
    public String getDistrictLabel(Locale locale) {
        List<AssetCategory> districts = getDistrictCategories();
        List<AssetCategory> cities = getCityCategories();
        return AssetVocabularyHelper.getDistrictTitle(locale, districts, cities);
    }

    /**
     * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la petition
     *
     * @return : null si vide, sinon la liste des catégories
     */
    @Override
    public List<AssetCategory> getDistrictCategories() {
        List<AssetCategory> districts = AssetVocabularyHelper.getDistrictCategories(this.getTerritoryCategories());
        return districts;
    }

    /**
     * Retourne les sous-sous-catégories 'Territoire' correspondant aux communes de la pétition
     *
     * @return : null si vide, sinon la liste des catégories
     */
    @Override
    public List<AssetCategory> getCityCategories() {
        List<AssetCategory> cities = AssetVocabularyHelper.getCityCategories(this.getTerritoryCategories());
        return cities;
    }

    /**
     * Retourne les catégories 'Territoire' correspondant aux pays de la petition
     */
    @Override
    public List<AssetCategory> getTerritoryCategories() {
        return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(), VocabularyNames.TERRITORY);
    }
}