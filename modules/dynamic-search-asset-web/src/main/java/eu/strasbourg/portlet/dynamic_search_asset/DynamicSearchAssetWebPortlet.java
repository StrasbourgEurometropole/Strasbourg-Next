package eu.strasbourg.portlet.dynamic_search_asset;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.Query;
import com.liferay.portlet.documentlibrary.lar.FileEntryUtil;
import eu.strasbourg.portlet.dynamic_search_asset.configuration.DynamicSearchAssetConfiguration;
import eu.strasbourg.portlet.dynamic_search_asset.constants.Constants;
import eu.strasbourg.portlet.dynamic_search_asset.handler.AssetHandler;
import eu.strasbourg.portlet.dynamic_search_asset.handler.AssetHandlerFactory;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.service.ActivityCourseLocalServiceUtil;
import eu.strasbourg.service.activity.service.ActivityLocalServiceUtil;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.agenda.service.ManifestationLocalServiceUtil;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.model.EditionGallery;
import eu.strasbourg.service.edition.service.EditionGalleryLocalServiceUtil;
import eu.strasbourg.service.edition.service.EditionLocalServiceUtil;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.official.service.OfficialLocalServiceUtil;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.model.Participation;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.model.Project;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalServiceUtil;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.service.project.service.InitiativeLocalServiceUtil;
import eu.strasbourg.service.project.service.ParticipationLocalServiceUtil;
import eu.strasbourg.service.project.service.PetitionLocalServiceUtil;
import eu.strasbourg.service.project.service.ProjectLocalServiceUtil;
import eu.strasbourg.service.search.log.model.SearchLog;
import eu.strasbourg.service.search.log.service.SearchLogLocalServiceUtil;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.service.video.service.VideoLocalServiceUtil;
import eu.strasbourg.utils.*;
import eu.strasbourg.utils.api.FileEntryHelperService;
import eu.strasbourg.utils.api.LayoutHelperService;
import eu.strasbourg.utils.bean.AssetType;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.time.LocalDate;
import java.util.*;

import static eu.strasbourg.portlet.dynamic_search_asset.SearchUtils.logSearchChoice;

/**
 * @author cedric.henry
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=Strasbourg",
                "com.liferay.portlet.instanceable=false",
                "com.liferay.portlet.css-class-wrapper=dynamic-search-asset-portlet",
                "javax.portlet.display-name=Recherche d'asset dynamique",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/dynamic-search-asset-view.jsp",
                "javax.portlet.name=" + StrasbourgPortletKeys.DYNAMIC_SEARCH_ASSET_WEB,
                "javax.portlet.init-param.config-template=/dynamic-search-asset-configuration.jsp",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class DynamicSearchAssetWebPortlet extends MVCPortlet {

    // Add SearchHelperV2
    @Reference(unbind = "-")
    private SearchHelperV2 _searchHelperV2;

    /**
     * Initialisation de la vue
     */
    @Override
    public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        try {
            // Recuperation du contexte de la requete
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            DynamicSearchAssetConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(DynamicSearchAssetConfiguration.class, themeDisplay);

            // Recuperation et attribution des informations de l'utilisateur
            String publikUserId = getPublikID(request);
            request.setAttribute("publikUserId", publikUserId);

            // Recuperation et attribution de l'URL de base du site
            String homeUrl = SearchUtils.getHomeURL(themeDisplay);
            request.setAttribute("homeURL", homeUrl);


            Boolean isPublikLoggedin = (Boolean) themeDisplay.getRequest().getSession().getAttribute("publik_logged_in");
            request.setAttribute("isPublikLoggedin", isPublikLoggedin != null && isPublikLoggedin);

            String currentUrl = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent();
            String dashboardURL = _layoutHelperService.getDashboardURL();
            request.setAttribute("dashboardURL", dashboardURL);

            String publikLoginURL = _layoutHelperService.getPublikLoginURL(currentUrl);
            request.setAttribute("publikLoginURL", publikLoginURL);

            String publikLogoutURL = _layoutHelperService.getPublikLogoutURL(currentUrl);
            request.setAttribute("publikLogoutURL", publikLogoutURL);

            if (isPublikLoggedin != null && isPublikLoggedin) {
                String publikName = themeDisplay.getRequest().getSession().getAttribute("publik_given_name") + " " + themeDisplay.getRequest().getSession().getAttribute("publik_family_name").toString().charAt(0);
                request.setAttribute("publikName", publikName);
            }


            // Recuperation du formulaire configuré
            String searchForm = configuration.searchForm();
            request.setAttribute("searchForm", searchForm);

            // Recuperation du type de recherche
            Boolean dynamicSearch = configuration.dynamicSearch();
            request.setAttribute("dynamicSearch", dynamicSearch);

            // Recuperation des classes demandees
            List<String> classNames = this.getConfiguredClassNamesList(configuration);
            request.setAttribute("classNames", classNames);

            // Retourne le delta
            request.setAttribute("delta", configuration.delta());

        } catch (ConfigurationException e) {
            _log.error(e.getMessage(), e);
        }

        super.render(request, response);
    }

    /**
     * Méthode exécutée lors d'un appel AJAX
     * Chaque appel est identifié par un RessourceID permettant de gérer le comportement
     * à fourir
     *
     * @note Il est possible de gérer chaque fonction dans une classe MVCRessourceCommand
     * comme dans les modules BO pour les MVCActionCommand, toutefois il faudrait mutualiser
     * les données dans une classe externe pour agir sur les même résultats
     */
    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response)
            throws IOException, PortletException {
        try {
            // Recuperation du contexte de la requete
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            DynamicSearchAssetConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(DynamicSearchAssetConfiguration.class, themeDisplay);

            String resourceID = request.getResourceID();

            // ---------------------------------------------------------------
            // -------- REQUETE : Effectuer une recherche --------------------
            // ---------------------------------------------------------------
            if (resourceID.equals("searchSubmit")) {

                String keywords = ParamUtil.getString(request, "keywords");

                int start = ParamUtil.getInteger(request, "start");

                SearchHits hits = searchFromParam(request, configuration, themeDisplay, keywords, start);

				List<AssetEntry> assetEntries = SearchUtils.getAssetEntriesFromSearchHits(hits, themeDisplay, themeDisplay.getLayout().getGroupId());

				SearchUtils.applyTemplateBehaviors(configuration, assetEntries);

                JSONArray jsonResponse = this.constructJSONSelection(request, configuration, assetEntries,
                        hits.getTotalHits(), start + configuration.delta());

                SearchUtils.logSearch(request, assetEntries,  keywords, hits.getTotalHits(), hits.getSearchTime() * 1000, jsonResponse);

                // Recuperation de l'élément d'écriture de la réponse
                PrintWriter writer = response.getWriter();
                writer.print(jsonResponse);
            } else if (resourceID.equals("logChoice")) {
                // HOTFIX DEACTIVATE SEARCHLOG
                //SearchUtils.logSearchChoice(request);
            }

        } catch (Exception e) {
            _log.error(e);
        }
        super.serveResource(request, response);
    }

	public SearchHits searchFromParam(PortletRequest request, DynamicSearchAssetConfiguration configuration,
                              ThemeDisplay themeDisplay, String keywords, int start) throws PortalException {
		// Recuperation du searchContext
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(request);
		SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

		long groupId = themeDisplay.getLayout().getGroupId();

		// Recuperation des classNames selectionnes demandes par l'utilisateur
		String[] classNames;
		String selectedClassNames = ParamUtil.getString(request, "selectedClassNames");
		if (Validator.isNotNull(selectedClassNames))
			classNames = selectedClassNames.split(",");
		else {
			// si le paramètre n'existe pas on prend les className de la configuration
			String configurationClassNames = this.getConfiguredClassNames(configuration);
			classNames = configurationClassNames.split(",");
		}

		// Inclusion ou non du scope global
		boolean globalScope = configuration.globalScope();
		long globalGroupId = themeDisplay.getCompanyGroupId();

		// Recuperation du nombre de resultats max demandés
		int maxResults = (int) configuration.delta();

		// Recuperation de la configuration du prefiltre par date de la configuration
		boolean useDatePrefilter = configuration.dateField();
		long dateRangeFrom = (int) configuration.dateRangeFrom();
		long dateRangeTo = (int) configuration.dateRangeTo();
		LocalDate fromDate = LocalDate.now().plusDays(dateRangeFrom);
		LocalDate toDate = LocalDate.now().plusDays(dateRangeTo);

		// Recuperation de la configuration des prefiltre sur les categories
		String prefilterCategoriesIdsString = configuration.prefilterCategoriesIds();
		List<Long[]> prefilterCategoriesIds = new ArrayList<>();
		for (String prefilterCategoriesIdsGroupByVocabulary : prefilterCategoriesIdsString.split(";")) {
			Long[] prefilterCategoriesIdsForVocabulary = ArrayUtil
					.toLongArray(StringUtil.split(prefilterCategoriesIdsGroupByVocabulary, ",", 0));
            if(prefilterCategoriesIdsForVocabulary.length > 0) {
                prefilterCategoriesIds.add(prefilterCategoriesIdsForVocabulary);
            }

		}

		// Recuperation de la configuration des prefiltre sur les etiquettes
		String prefilterTagsNamesString = configuration.prefilterTagsNames();
		String[] prefilterTagsNames = StringUtil.split(prefilterTagsNamesString);

		return getSearchHitFromSearch(
				Arrays.asList(classNames), groupId, globalGroupId, globalScope,
				searchContext, keywords, useDatePrefilter, fromDate, toDate, prefilterCategoriesIds,
				themeDisplay, start, maxResults, prefilterTagsNames, configuration.searchForm());
	}

	public SearchHits getSearchHitFromSearch(
			List<String> classNames, long groupId, long globalGroupId, boolean globalScope,
			SearchContext searchContext, String keywords, boolean useDatePrefilter,
			LocalDate fromDate, LocalDate toDate, List<Long[]> prefilterCategoriesIds,
			ThemeDisplay themeDisplay, int start, int maxResults, String[] prefilterTagsNames, String configAffichage) throws PortalException {

		// Turn classNames into AssetType
		List<AssetType> assetTypes = getAssetTypesFromClassNames(classNames, groupId, globalGroupId, globalScope, configAffichage);

        // Construct the query
        QueryBuilder queryBuilder = new QueryBuilder(queries);

        queryBuilder = queryBuilder
                .withAssetTypes(assetTypes, classNames, keywords);

        queryBuilder = queryBuilder
                .withStatus(WorkflowConstants.STATUS_APPROVED)
                .withKeywords(keywords, themeDisplay.getLocale());

        if (useDatePrefilter) {
            queryBuilder = queryBuilder.withDate(Field.PUBLISH_DATE + "_sortable",fromDate, toDate);
        }

        if(prefilterCategoriesIds.size() > 0) {
            queryBuilder = queryBuilder.withCategories(prefilterCategoriesIds);
        }

        if(prefilterTagsNames.length > 0) {
            queryBuilder = queryBuilder.withTags(List.of(prefilterTagsNames));
        }

        // Exclure le tag technique

        queryBuilder = queryBuilder.withoutTags(List.of("technique"));

        Query query = queryBuilder.build();


		// Perform the search
		SearchHits hit = _searchHelperV2.search(
				searchContext, query ,new HashMap<>(), 0, start, start + maxResults);

        return hit;
	}

    public List<AssetType> getAssetTypesFromClassNames(List<String> classNames, long groupId, long globalGroupId, boolean globalScope, String configAffichage) {
        // Turn classNames into AssetType
        List<AssetType> assetTypes = new ArrayList<>();

        for (String className : classNames) {
            List<Long> groupIds = getGroupIds(className, groupId, globalGroupId, globalScope);

            if (isSpecialJournalArticleCase(className, configAffichage)) {
                addSpecialJournalArticleAssetTypes(assetTypes, className, groupIds);
            } else {
                assetTypes.add(new AssetType(className, groupIds));
            }
        }
        return assetTypes;
    }

    private List<Long> getGroupIds(String className, long groupId, long globalGroupId, boolean globalScope) {
        if (className.equals(Place.class.getName()) || className.equals(Event.class.getName())) {
            return globalScope ? List.of(globalGroupId) : List.of(groupId);
        } else {
            return List.of(groupId);
        }
    }

    private boolean isSpecialJournalArticleCase(String className, String configAffichage) {
        return className.equals(JournalArticle.class.getName()) && configAffichage.equals(Constants.SEARCH_FORM_STRASBOURG);
    }

    private void addSpecialJournalArticleAssetTypes(List<AssetType> assetTypes, String className, List<Long> groupIds) {
        Long[] structureIds = {
                1064291L,
                5099142L,
                5099148L,
                1564337L
        };
        for (Long structureId : structureIds) {
            assetTypes.add(new AssetType(className, groupIds, structureId));
        }
    }


    /**
     * Retourne un objet JSON contenant l'ensemble des entités voulues et valide
     * un atribut "isMarkeable" à afficher sur la map en front
     *
     * @return JSONObject sous la forme :
     * {
     * "projects" :
     * [
     * {"id" : 0000,
     * "title" : "blablabla"
     * ...},
     * {...}
     * ],
     * "participations" :
     * [{...}],
     * "events" :
     * [{...}],
     * }
     * @throws PortalException
     */
    @SuppressWarnings("JavaDoc")
    private JSONArray constructJSONSelection(ResourceRequest request, DynamicSearchAssetConfiguration configuration,
                                             List<AssetEntry> assetEntries, long totalResult, long displayResult) throws PortalException {

        // Récupération du contexte de la requète
        String publikUserId = this.getPublikID(request);

        // Initialisation du JSON de réponse
        JSONArray jsonResponse = JSONFactoryUtil.createJSONArray();

        JSONObject jsonTotalResult = JSONFactoryUtil.createJSONObject();
        jsonTotalResult.put("totalResult", totalResult);
        jsonResponse.put(jsonTotalResult);

        JSONObject jsonDisplayResult = JSONFactoryUtil.createJSONObject();
        jsonDisplayResult.put("displayResult", displayResult);
        jsonResponse.put(jsonDisplayResult);

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Locale locale = themeDisplay.getLocale();
        String configAffichage = configuration.searchForm();

        // Parcours des résultats
        for (AssetEntry assetEntry : assetEntries) {

            String assetClassName = assetEntry.getClassName();

            int descriptionMaxLength = configAffichage.equals("strasbourg") ? 100 : -1;

            // Récupération du JSON de l'entité selon le type d'assetEntry
            // Note : impossibilité d'utilisé un switch case pour cause d'utilisation de non-constante
            // TODO : Trouver comment contrer l'archaïssité de java sur le sujet des constantes sur les switch
            // Update 26/06/2024 J'ai trouvé comment contrer l'archaïssité

            // Lire readme.md pour plus d'informations
            AssetHandler handler = AssetHandlerFactory.getHandler(assetClassName);
            if (handler != null) {
                handler.handleAsset(fileEntryHelperService, jsonResponse, assetEntry, locale, themeDisplay, publikUserId, configAffichage, descriptionMaxLength);
            } else {
                _log.error("No handler found for asset class name " + assetClassName);
            }
        }



        return jsonResponse;
    }

    /**
     * Retourne la liste des class names configurés recherchable
     */
    public String getConfiguredClassNames(DynamicSearchAssetConfiguration configuration) {
        String classNames = configuration.assetClassNames();
        if (configuration.searchNews()) {
            if (Validator.isNotNull(classNames)) {
                classNames += ",";
            }
            classNames += JournalArticle.class.getName();
        }
        if (configuration.searchDocument()) {
            if (Validator.isNotNull(classNames)) {
                classNames += ",";
            }
            classNames += DLFileEntry.class.getName();
        }
        return classNames;
    }

    /**
     * Retourne la liste des class names configurés recherchable
     */
    public List<String> getConfiguredClassNamesList(DynamicSearchAssetConfiguration configuration) {
        List<String> classNames = new ArrayList<String>(Arrays.asList(this.getConfiguredClassNames(configuration).split(",")));
        return classNames;
    }

    /**
     * Récupération du publik ID avec la session
     *
     * @return L'id publik de l'utilisateur courant
     */
    private String getPublikID(PortletRequest request) {
        LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(request);
        HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();

        return SessionParamUtil.getString(originalRequest, "publik_internal_id");
    }



    @Reference
    public FileEntryHelperService fileEntryHelperService;

    @Reference
    private LayoutHelperService _layoutHelperService;

    @Reference
    protected Queries queries;

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}