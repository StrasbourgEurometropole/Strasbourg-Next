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

package eu.strasbourg.service.project.model.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.service.like.model.Like;
import eu.strasbourg.service.like.service.LikeLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.model.InitiativeHelp;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.service.InitiativeHelpLocalServiceUtil;
import eu.strasbourg.service.project.service.InitiativeLocalServiceUtil;
import eu.strasbourg.service.project.service.PlacitPlaceLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.constants.VocabularyNames;
import org.osgi.annotation.versioning.ProviderType;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * The extended model implementation for the Initiative service. Represents a row in the &quot;project_Initiative&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.project.model.Initiative} interface.
 * </p>
 *
 * @author Cedric Henry
 */
@ProviderType
public class InitiativeImpl extends InitiativeBaseImpl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1046377730894483466L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a initiative model instance should use the {@link eu.strasbourg.service.project.model.Initiative} interface instead.
	 */
	public InitiativeImpl() {
	}
	
	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(Initiative.class.getName(),
			this.getInitiativeId());
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
	 * Retourne la liste des lieux placit liés à l'initiative
	 */
	@Override
	public List<PlacitPlace> getPlacitPlaces() {
		return PlacitPlaceLocalServiceUtil.getByInitiative(this.getInitiativeId());
	}

	/**
	 * Retourne les noms des lieux placit de l'initiative
	 */
	@Override
	public List<String> getPlaceNames(Locale locale) {
		List<PlacitPlace> placitPlaces = this.getPlacitPlaces();
		return placitPlaces.stream().map(c -> c.getPlaceAlias(locale)).distinct().collect(Collectors.toList());
	}

	/**
	 * Retourne les ids SIG des lieux placit de l'initiative
	 */
	@Override
	public List<String> getPlaceSIGIds(Locale locale) {
		List<PlacitPlace> placitPlaces = this.getPlacitPlaces();
		return placitPlaces.stream().map(c -> c.getPlaceSIGId()).distinct().collect(Collectors.toList());
	}
	
	
	/**
	 * Retourne les thematiques de la initiative (
	 */
	@Override
	public List<AssetCategory> getThematicCategories() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
				VocabularyNames.THEMATIC);
	}
	
	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la initiative
	 */
	@Override
	public List<AssetCategory> getTerritoryCategories() {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
				VocabularyNames.TERRITORY);
	}
	
	/**
	 * Retourne les sous-catégories 'Territoire' correspondant aux villes de la initiative
	 * @return : null si vide, sinon la liste des catégories 
	 */
	@Override
	public List<AssetCategory> getCityCategories() {
		List<AssetCategory> cities = AssetVocabularyHelper.getCityCategories(this.getTerritoryCategories());
		return cities;
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la initiative
	 * @return : null si vide, sinon la liste des catégories 
	 */
	@Override
	public List<AssetCategory> getDistrictCategories() {
		List<AssetCategory> districts = AssetVocabularyHelper.getDistrictCategories(this.getTerritoryCategories());
		return districts;
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la initiative
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(Locale locale) {
		List<AssetCategory> districts = getDistrictCategories();
		List<AssetCategory> cities = getCityCategories();
		return AssetVocabularyHelper.getDistrictTitle(locale, districts, cities);
	}
	
	/**
	 * Retourne une chaine des 'Thematics' sépararée d'un '-'
	 */
	@Override
	public String getThematicsLabel(Locale locale) {
		StringBuilder result = new StringBuilder();
		List<AssetCategory> thematics = this.getThematicCategories();

	    result.append(thematics.stream()
                .map(thematic -> thematic.getTitle(locale))
                .collect(Collectors.joining(" - ")));

		return result.toString();
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
     * Retourne la liste des URLs des documents
     */
    @Override
    public List<String> getFilesURLs() {
        List<String> URLs = new ArrayList<String>();
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
     * Retourne le nom de du depositaire sous forme "Truc M." ou le "Au nom de ..."
     */
    @Override
    public String getAuthorLabel() {
    	PublikUser author = this.getAuthor();
    	if (this.getInTheNameOf() != "" && this.getInTheNameOf() != null) {
    		return this.getInTheNameOf();
    	}
    	else if (author != null) {
    		return StringUtil.upperCaseFirstLetter(author.getFirstName())
    				+ " "
    				+  StringUtil.toUpperCase(StringUtil.shorten(author.getLastName(), 2, "."));
    	} else {
    		return null;
    	}
    	
    }
    
    /**
     * Retourne l'adresse mail du depositaire s'il existe
     */
    @Override
    public String getAuthorEmail() {
    	PublikUser author = this.getAuthor();
    	if (author != null) {
    		return author.getEmail();
    	} else {
    		return "";
    	}
    }
    
    /**
     * Retourne le nom prenom du depositaire s'il existe
     */
    @Override
    public String getAuthorNameLabel() {
    	PublikUser author = this.getAuthor();
    	if (author != null) {
    		return author.getFirstName()
        			+ " "
       				+  author.getLastName();
    	} else {
    		return "";
    	}
    }
   
    
    /**
	 * Retourne l'utilisateur Publik depositaire
	 * @return
	 */
	public PublikUser getAuthor() {
		return PublikUserLocalServiceUtil.getByPublikUserId(this.getPublikId());
	}
    
    
	/**
     * Retourne l'URL de l'image de l'utilisateur
     */
    @Override
    public String getAuthorImageURL() {
        PublikUser author =  this.getAuthor();
        if (author != null) {
        	return author.getImageURLOrSurrogate();
        }
        return "";
    }
    
	/**
	 * Retourne le statut de l'initiative (
	 */
	@Override
	public AssetCategory getStatusCategory() {
		List <AssetCategory> status = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
				VocabularyNames.INITIATIVE_STATUS);
		return status.size() > 0 ? status.get(0) : null;
	}
	
	/**
	 * Retourne la couleur hexa du statut de l'initiative contenu dans la
	 * propriete 'code_color' de la categorie associee
	 */
	@Override
	public String getStatusCategoryColor() {
		AssetCategory status = this.getStatusCategory();
		if (status != null) {
			long categoryId = this.getStatusCategory().getCategoryId();
			return AssetVocabularyHelper.getCategoryProperty(categoryId, "color_code");
		} else {
			return "";
		}
	}
	
	/**
	 * Retourne le nombre d'aides de l'initiative
	 */
	@Override
	public int getNbHelps() {
		return InitiativeHelpLocalServiceUtil.getByInitiativeId(this.getInitiativeId()).size();
	}
	
	/**
	 * Retourne les aides qu'on affiche de l'initiative
	 */
	@Override
	public List<InitiativeHelp> getHelps() {
		return InitiativeHelpLocalServiceUtil.getByInitiativeId(this.getInitiativeId()).stream().filter(c -> c.getHelpDisplay()).collect(Collectors.toList());
	}
	
	/**
	 * L'utilisateur donne a t-il deja propose son aide a l'initiative
	 * @param publikUserId L'identifiant Publik de l'utilisateur
	 * @return La verite
	 */
	@Override
	public boolean isUserAlreadyHelp(String publikUserId) {
		return InitiativeHelpLocalServiceUtil.getByPublikUserIdAndInitiativeId(publikUserId, this.getInitiativeId()) != null;
	}
	
	/**
	 * Retourne la categorie projet
	 */
	@Override
	public AssetCategory getProjectCategory() {
		List<AssetCategory> assetCategories = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(this.getAssetEntry(),
				VocabularyNames.PROJECT);
        if (assetCategories.size() > 0) {
        	return assetCategories.get(0);
        } else {
        	return null;
        }
	}
	
	/**
	 * Retourne la titre du projet
	 */
	@Override
	public String getProjectName() {
        AssetCategory project = getProjectCategory();
        return (project != null) ? project.getTitle(Locale.FRANCE) : "";
    }
	
	/**
	 * Retourne la liste des like/dislike de l'entité
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public List<Like> getLikesDislikes() {
		return LikeLocalServiceUtil.getByEntityIdAndTypeId(
				this.getInitiativeId(), 
				15);
	}
	
	/**
	 * Retourne la liste des likes de l'entité
	 *  @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public List<Like> getLikes() {
		return LikeLocalServiceUtil.getByEntityIdAndTypeIdAndIsDislike(
				this.getInitiativeId(), 
				15, 
				false);
	}
	
	/**
	 * Retourne la liste des dislikes de l'entité
	 *  @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public List<Like> getDislikes() {
		return LikeLocalServiceUtil.getByEntityIdAndTypeIdAndIsDislike(
				this.getInitiativeId(), 
				15, 
				true);
	}
	
	/**
	 * Retourne le nombre de likes/dislikes de l'entité
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikesDislikes() {
		return LikeLocalServiceUtil.getByEntityIdAndTypeId(
				this.getInitiativeId(), 
				15).size();
	}
	
	/**
	 * Retourne le nombre de likes de l'entité
	 *  @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikes() {
		return LikeLocalServiceUtil.getByEntityIdAndTypeIdAndIsDislike(
				this.getInitiativeId(), 
				19, 
				false).size();
	}
	
	/**
	 * Retourne le nombre de dislikes de l'entité
	 *  @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbDislikes() {
		return LikeLocalServiceUtil.getByEntityIdAndTypeIdAndIsDislike(
				this.getInitiativeId(), 
				19, 
				true).size();
	}
	
	/**
	 * Retourne les commentaires de l'entité
	 */
	@Override
	public List<Comment> getApprovedComments() {
		return CommentLocalServiceUtil.getByAssetEntry(this.getAssetEntry().getEntryId(),
				WorkflowConstants.STATUS_APPROVED);
	}

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	@Override
	public int getNbApprovedComments() {
		return CommentLocalServiceUtil
				.getByAssetEntry(this.getAssetEntry().getEntryId(), WorkflowConstants.STATUS_APPROVED).size();
	}
	
	public String getPublicationDateFr(){
        Date date = this.getAssetEntry().getPublishDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
	
	/**
     * Retourne X suggestions max pour une initiative
     *
     * @param request la requete
     * @param nbSuggestions le nombre de suggestions.
     * @return la liste d'initiatives.
     */
    @Override
    public List<Initiative> getSuggestions(HttpServletRequest request, int nbSuggestions) throws SearchException, PortalException {
		
    	List<Initiative> suggestions = new ArrayList<>();
		
		try {
			//Initialisation du seachContext
			SearchContext searchContext = SearchContextFactory.getInstance(request);
			searchContext.setStart(0);
			searchContext.setEnd(nbSuggestions);
			
			//utilisation de l'indexer de l'entite initiative (Permet de rechercher uniquement des initiatives)
			Indexer indexer = IndexerRegistryUtil.getIndexer(Initiative.class.getName());
			
			//création de la query avec des filtre sur les entités publiées uniquement
			BooleanQuery mainQuery = new BooleanQueryImpl();
			mainQuery.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
			mainQuery.addRequiredTerm("visible", true);
			
			//Un ou plusieurs territoire
			BooleanQuery territoryQuery = new BooleanQueryImpl();
			for (AssetCategory category : this.getTerritoryCategories()) {
				BooleanQuery categoryQuery = new BooleanQueryImpl();
				categoryQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, String.valueOf(category.getCategoryId()));
				territoryQuery.add(categoryQuery, BooleanClauseOccur.SHOULD);
			}
			mainQuery.add(territoryQuery, BooleanClauseOccur.MUST);
			
			//Une ou plusieurs thématiques
			BooleanQuery thematiqueQuery = new BooleanQueryImpl();
			for (AssetCategory category : this.getThematicCategories()) {
				BooleanQuery categoryQuery = new BooleanQueryImpl();
				categoryQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, String.valueOf(category.getCategoryId()));
				thematiqueQuery.add(categoryQuery, BooleanClauseOccur.SHOULD);
			}
			mainQuery.add(thematiqueQuery, BooleanClauseOccur.MUST);
			
			//Le même projet
			if(this.getProjectCategory() != null) {
				BooleanQuery projetQuery = new BooleanQueryImpl();
				projetQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, String.valueOf(this.getProjectCategory().getCategoryId()));
				mainQuery.add(projetQuery, BooleanClauseOccur.MUST);
			}
			
			BooleanClause booleanClause = BooleanClauseFactoryUtil.create(mainQuery, BooleanClauseOccur.MUST.getName());
			searchContext.setBooleanClauses(new BooleanClause[] {booleanClause});
			
			//Lance la recherche elasticSearch
		    Hits hits = indexer.search(searchContext);
			
		    //Generation de notre liste de suggestion
		    for (Document document : hits.getDocs()) {
		    	//récupération de l'élément en base
		    	Initiative ini = InitiativeLocalServiceUtil.fetchInitiative(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
	            
	            //Vérification que l'initiative recherchée existe bien base (En théorie ne devrait pas arriver) et qu'elle est différente de l'initiative courante
	            if(ini != null && ini.getInitiativeId() != this.getInitiativeId())
	            	suggestions.add(ini);
	        }
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	    
		return suggestions;
    }
	
	/**
	 * Retourne la version JSON de l'entité
	 *
	 * @throws PortalException
	 */
	@Override
	public JSONObject toJSON() throws PortalException {
		// Initialisation des variables tempons et résultantes
		JSONObject jsonInitiative = JSONFactoryUtil.createJSONObject();
		JSONArray jsonPlacitPlaces = JSONFactoryUtil.createJSONArray();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat unformatedDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		// Champs : Gestion
		jsonInitiative.put("id", this.getInitiativeId());
		jsonInitiative.put("createDate", dateFormat.format(this.getCreateDate()));
		jsonInitiative.put("unformatedCreateDate", unformatedDateFormat.format(this.getCreateDate()));
		jsonInitiative.put("userName", HtmlUtil.stripHtml(HtmlUtil.escape(this.getUserName())));
		
		// Champs : Generaux
		jsonInitiative.put("title", HtmlUtil.stripHtml(HtmlUtil.escape(this.getTitle())));
		jsonInitiative.put("author", HtmlUtil.stripHtml(HtmlUtil.escape(this.getAuthorLabel())));
		jsonInitiative.put("authorImageURL", this.getAuthorImageURL());
		jsonInitiative.put("description", this.getDescription());
		jsonInitiative.put("placeTextArea", this.getPlaceTextArea());
		jsonInitiative.put("publishedDate", dateFormat.format(this.getPublicationDate()));
		jsonInitiative.put("unformatedPublishedDate", unformatedDateFormat.format(this.getPublicationDate()));
		
		// Champs : Médias
		jsonInitiative.put("videoUrl", this.getVideoUrl());
		jsonInitiative.put("imageURL", this.getImageURL());
		jsonInitiative.put("mediaChoice", this.getMediaChoice());
		
		// Champs : Categorisations
		AssetCategory statusCategory = this.getStatusCategory();
		AssetCategory projectCategory = this.getProjectCategory();
		
		jsonInitiative.put("statusLabel", statusCategory != null ? statusCategory.getTitle(Locale.FRENCH) : "");
		jsonInitiative.put("statusColor", this.getStatusCategoryColor());
		jsonInitiative.put("districtsLabel", this.getDistrictLabel(Locale.FRENCH));
		jsonInitiative.put("thematicsLabel", this.getThematicsLabel(Locale.FRENCH));
		jsonInitiative.put("projectName", projectCategory != null ? projectCategory.getTitle(Locale.FRENCH) : "");
		
		// Aides
		jsonInitiative.put("nbHelps", this.getNbHelps());
		
		// Lieux placit
		for (PlacitPlace placitPlace : this.getPlacitPlaces()) {
			jsonPlacitPlaces.put(placitPlace.toJSON());
		}
		jsonInitiative.put("placitPlaces", jsonPlacitPlaces);

		// Liste des Ids des catégories Territoire
		JSONArray jsonTerritories = AssetVocabularyHelper.getExternalIdsJSONArray(this.getTerritoryCategories());
		if (jsonTerritories.length() > 0) {
			jsonInitiative.put("territories", jsonTerritories);
		}

		// Liste des Ids des catégories Thématiques
		JSONArray jsonThematics = AssetVocabularyHelper.getExternalIdsJSONArray(this.getThematicCategories());
		if (jsonThematics.length() > 0) {
			jsonInitiative.put("thematics", jsonThematics);
		}

		return jsonInitiative;
	}
}