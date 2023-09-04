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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.PlacitPlaceLocalServiceUtil;
import eu.strasbourg.service.project.service.SaisineObservatoireLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.constants.VocabularyNames;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    public SaisineObservatoireImpl() {
    }

    @Override
    public String getThematicLabel(Locale locale) {
        List<AssetCategory> thematics = getThematicCategories();
        return AssetVocabularyHelper.getThematicTitle(locale, thematics);
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

        AssetCategory category = this.getStatusCategorie();
        if (category != null) {
            result = category.getName();
        }

        return result;
    }

    @Override
    // TODO SAISINE
    public String getAuthorLabel() {
 /*       if (this.getInTheNameOf() != "" && this.getInTheNameOf() != null) {
            return this.getInTheNameOf();
        } else {
            return StringUtil.upperCaseFirstLetter(this.getPetitionnaireFirstname()) + " " + StringUtil.toUpperCase(StringUtil.shorten(this.getPetitionnaireLastname(), 2, "."));
        }*/
 return null;
    }

    /**
     * Retourne la liste des lieux placit liés à la petition
     */
    @Override
    public List<PlacitPlace> getPlacitPlaces() {
        return PlacitPlaceLocalServiceUtil.getBySaisineObservatoire(this.getSaisineObservatoireId());
    }

    /**
     * Retourne X suggestions max pour une pétition
     *
     * @param request
     *            la requete
     * @param nbSuggestions
     *            le nombre de suggestions.
     * @return la liste de pétition.
     */
    @Override
    public List<SaisineObservatoire> getSuggestions(HttpServletRequest request, int nbSuggestions) {

        List<SaisineObservatoire> suggestions = new ArrayList<>();

        try {
            // Initialisation du seachContext
            SearchContext searchContext = SearchContextFactory.getInstance(request);
            searchContext.setStart(0);
            searchContext.setEnd(nbSuggestions);

            // utilisation de l'indexer de l'entite pétition (Permet de rechercher uniquement des pétitions)
            Indexer indexer = IndexerRegistryUtil.getIndexer(SaisineObservatoire.class.getName());

            // création de la query avec des filtre sur les entités publiées uniquement
            BooleanQuery mainQuery = new BooleanQueryImpl();
            mainQuery.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
            mainQuery.addRequiredTerm("visible", true);

            // Un ou plusieurs territoire
            BooleanQuery territoryQuery = new BooleanQueryImpl();
            for (AssetCategory category : this.getTerritoryCategories()) {
                BooleanQuery categoryQuery = new BooleanQueryImpl();
                categoryQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, String.valueOf(category.getCategoryId()));
                territoryQuery.add(categoryQuery, BooleanClauseOccur.SHOULD);
            }
            mainQuery.add(territoryQuery, BooleanClauseOccur.MUST);

            // Une ou plusieurs thématiques
            BooleanQuery thematiqueQuery = new BooleanQueryImpl();
            for (AssetCategory category : this.getThematicCategories()) {
                BooleanQuery categoryQuery = new BooleanQueryImpl();
                categoryQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, String.valueOf(category.getCategoryId()));
                thematiqueQuery.add(categoryQuery, BooleanClauseOccur.SHOULD);
            }
            mainQuery.add(thematiqueQuery, BooleanClauseOccur.MUST);

            // Le même projet
            if (this.getProjectCategory() != null) {
                BooleanQuery projetQuery = new BooleanQueryImpl();
                projetQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, String.valueOf(this.getProjectCategory().getCategoryId()));
                mainQuery.add(projetQuery, BooleanClauseOccur.MUST);
            }

            BooleanClause booleanClause = BooleanClauseFactoryUtil.create(mainQuery, BooleanClauseOccur.MUST.getName());
            searchContext.setBooleanClauses(new BooleanClause[] { booleanClause });

            // Lance la recherche elasticSearch
            Hits hits = indexer.search(searchContext);

            // Generation de notre liste de suggestion
            for (Document document : hits.getDocs()) {
                // récupération de l'élément en base
                SaisineObservatoire saisineObservatoire = SaisineObservatoireLocalServiceUtil.fetchSaisineObservatoire(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));

                // Vérification que la pétition recherchée existe bien base (En théorie ne devrait pas arriver) et qu'elle est
                // différente de la pétition courante
                if (saisineObservatoire != null && saisineObservatoire.getSaisineObservatoireId() != this.getSaisineObservatoireId())
                    suggestions.add(saisineObservatoire);
            }
        } catch (Exception ex) {
            _log.error(ex.getMessage(), ex);
        }

        return suggestions;
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
     * Retourne les commentaires de l'entité
     */
    @Override
    public List<Comment> getApprovedComments() {
        return CommentLocalServiceUtil.getByAssetEntry(this.getAssetEntry().getEntryId(), WorkflowConstants.STATUS_APPROVED);
    }

    /**
     * Retourne les thematiques de la saisine (
     */
    @Override
    public List<AssetCategory> getThematicCategories() {
        return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(), VocabularyNames.THEMATIC);
    }

    /**
     * Retourne le projet de la saisine (
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
        jsonSaisineObservatoire.put("frontStatusFR", this.getSaisineObservatoireStatus());
        jsonSaisineObservatoire.put("districtLabel", HtmlUtil.stripHtml(HtmlUtil.escape(this.getDistrictLabel(Locale.FRENCH))));
        jsonSaisineObservatoire.put("title", HtmlUtil.stripHtml(HtmlUtil.escape(this.getTitle())));
        jsonSaisineObservatoire.put("projectTitle", this.getProjectTitle(Locale.FRANCE));
        jsonSaisineObservatoire.put("projectTarget", this.getProjectTarget());

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
     * Retourne la liste des URLs des documents
     */
    @Override
    public List<String> getFilesURLs() {
        List<String> URLs = new ArrayList<>();
        for (String fileIdStr : this.getFilesIds().split(",")) {
            Long fileId = GetterUtil.getLong(fileIdStr);
            if (Validator.isNotNull(fileId)) {
                String fileURL = FileEntryHelper.getFileEntryURL(fileId);
                URLs.add(fileURL);
            }
        }
        return URLs;
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

    @Override
    public AssetCategory getStatusCategorie() {
        AssetCategory category = null;
        List<AssetCategory> assetCategories = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(), VocabularyNames.SAISINE_STATUS);
        if (!assetCategories.isEmpty()) {
            category = assetCategories.get(0);
        }

        return category;
    }
}