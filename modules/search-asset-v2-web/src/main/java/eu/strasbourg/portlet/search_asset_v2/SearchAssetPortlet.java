package eu.strasbourg.portlet.search_asset_v2;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import eu.strasbourg.portlet.search_asset_v2.action.ExportPDF;
import eu.strasbourg.portlet.search_asset_v2.configuration.SearchAssetConfiguration;
import eu.strasbourg.portlet.search_asset_v2.configuration.bean.ConfigurationAssetData;
import eu.strasbourg.portlet.search_asset_v2.configuration.bean.ConfigurationData;
import eu.strasbourg.portlet.search_asset_v2.constants.SearchAssetPortletKeys;
import eu.strasbourg.portlet.search_asset_v2.context.SearchAssetDisplayContext;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.service.HelpProposalLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.service.project.model.*;
import eu.strasbourg.service.project.service.*;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.service.video.service.VideoLocalServiceUtil;
import eu.strasbourg.utils.AssetPublisherTemplateHelper;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.JournalArticleHelper;
import eu.strasbourg.utils.LayoutHelper;
import eu.strasbourg.utils.SearchHelperV2;
import eu.strasbourg.utils.constants.VocabularyNames;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jeremy.zwickert
 */

@Component(
		immediate = true,
		configurationPid = "eu.strasbourg.portlet.search_asset_v2.configuration.SearchAssetConfiguration",
		property = {
				"com.liferay.portlet.display-category=Strasbourg",
				"com.liferay.portlet.instanceable=false",
				"com.liferay.portlet.css-class-wrapper=search-asset-portlet",
				"com.liferay.portlet.header-portlet-css=/css/search-asset-web.css",
				"com.liferay.portlet.single-page-application=false",
				"javax.portlet.version=3.0",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/search-asset-view.jsp",
				"javax.portlet.init-param.check-auth-token=false",
				"javax.portlet.name=" + SearchAssetPortletKeys.SEARCHASSET,
				"javax.portlet.init-param.config-template=/search-asset-configuration.jsp",
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class SearchAssetPortlet extends MVCPortlet {

	public final static String PETITION = "eu.strasbourg.service.project.model.Petition";
	public final static String SAISINE_OBSERVATOIRE = "eu.strasbourg.service.project.model.SaisineObservatoire";
	public final static String PARTICIPATION = "eu.strasbourg.service.project.model.Participation";
	public final static String BUDGET = "eu.strasbourg.service.project.model.BudgetParticipatif";
	public final static String INITIATIVE = "eu.strasbourg.service.project.model.Initiative";
	public final static String AIDE = "eu.strasbourg.service.help.model.HelpProposal";

	@Override
	public void render(RenderRequest renderRequest,
					   RenderResponse renderResponse) {
		try {
			// On set le DisplayContext
			SearchAssetDisplayContext dc = new SearchAssetDisplayContext(
					renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
			ConfigurationData configurationData = dc.getConfigurationData();

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			// Boolean pour dire qu'on vient du portlet de recherche et non d'un
			// asset publisher (pour être utilisé dans les ADT si besoin
			renderRequest.setAttribute("fromSearchPortlet", true);

			// On envoie a la jsp la map className / layout qui fait
			// correspondre à chaque type d'asset une page de détail
			int i = 0;
			Map<String, Long> className_layoutId = new HashMap<>();
			List<ConfigurationAssetData> assetTypes = configurationData.getAssetTypeDataList();
			for (ConfigurationAssetData assetType : assetTypes) {
				Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
						themeDisplay.getScopeGroupId(), false,
						assetType.getFriendlyURL());
				if (layout != null) {
					className_layoutId.put(assetType.getClassName(), layout.getPlid());
				}
				i++;
			}

			renderRequest.setAttribute("classNameLayoutId", className_layoutId);

			// Recuperation de l'URL de "base" du site
			renderRequest.setAttribute("homeURL", dc.getHomeURL());

			if(Validator.isNotNull(assetTypes) && assetTypes.size() > 0) {
				String className = assetTypes.get(0).getClassName();
				long groupId = themeDisplay.getLayout().getGroupId();

				if (className.equals(PARTICIPATION)) {
					List<Participation> participationListMostCommented = _participationLocalService.getMostCommented(groupId);
					List<Participation> participationListLessCommented = _participationLocalService.getLessCommented(themeDisplay.getScopeGroupId());

					renderRequest.setAttribute("participationListMostCommented", participationListMostCommented);
					renderRequest.setAttribute("participationListLessCommented", participationListLessCommented);

				} else if (className.equals(PETITION)) {
					// Recuperer des objets des champs les plus/les moins.
					List<Petition> petitionListMostSigned = _petitionLocalService.getTheThreeMostSigned(themeDisplay.getScopeGroupId());
					List<Petition> petitionListLessSigned = _petitionLocalService.getTheThreeLessSigned(themeDisplay.getScopeGroupId());
					List<Petition> petitionListMostCommented = _petitionLocalService.getTheMostCommented(themeDisplay.getScopeGroupId());

					renderRequest.setAttribute("petitionListMostSigned", petitionListMostSigned);
					renderRequest.setAttribute("petitionListLessSigned", petitionListLessSigned);
					renderRequest.setAttribute("petitionListMostCommented", petitionListMostCommented);
				} else if (className.equals(SAISINE_OBSERVATOIRE)) {
					List<SaisineObservatoire> saisineObservatoireListMostCommented = _saisineObservatoireLocalService.getTheMostCommented(themeDisplay.getScopeGroupId());

					renderRequest.setAttribute("saisineObservatoireListMostCommented", saisineObservatoireListMostCommented);

				} else if (className.equals(BUDGET)) {

					//Recuperation de la categorie "Phase du budget participatif" configure
					AssetCategory phase = null;
					for (Long categoryPrefilterId :dc.getCategoryPrefilters()) {
						phase = AssetCategoryLocalServiceUtil.getCategory(categoryPrefilterId);
						if(AssetVocabularyLocalServiceUtil.getVocabulary(phase.getVocabularyId()).getName().equals(VocabularyNames.PLACIT_BUDGET_PARTICIPATIF_PHASE))
							break;
						else
							phase = null;
					}

					//On recupere les bp des classements seulement si une phase est configuree
					if(phase != null) {
						List<BudgetParticipatif> budgetsMostSupported = _budgetParticipatifLocalService.getMostSupported(groupId, 3, phase);
						List<BudgetParticipatif> budgetsMostCommented = _budgetParticipatifLocalService.getMostCommented(groupId, 3, phase);

						renderRequest.setAttribute("budgetsMostSupported", budgetsMostSupported);
						renderRequest.setAttribute("budgetsMostCommented", budgetsMostCommented);
					}

				} else if (className.equals(INITIATIVE)) {
					List<Initiative> initiativesMostLiked = _initiativeLocalService.getMostLiked(groupId, 3);
					List<Initiative> initiativesMostCommented = _initiativeLocalService.getMostCommented(groupId, 3);
					List<Initiative> initiativesMostHelped = _initiativeLocalService.getMostHelped(groupId, 3);

					renderRequest.setAttribute("initiativesMostLiked", initiativesMostLiked);
					renderRequest.setAttribute("initiativesMostCommented", initiativesMostCommented);
					renderRequest.setAttribute("initiativesMostHelped", initiativesMostHelped);
				}

				if(isStrasbourgEu(renderRequest)) {
					// Ajouter la page courant and le nombre de filtre applique dans le titre de la page
					String pageTitle = themeDisplay.getLayout().getTitle(themeDisplay.getLocale());
					if(!pageTitle.isEmpty()) {
						pageTitle = getPageTitle(pageTitle, dc);

						themeDisplay.getLayout().setTitle(pageTitle);
					}
				}

			}

			renderRequest.setAttribute("isUserloggedIn", false);
			renderRequest.setAttribute("hasUserPactSign", false);
			renderRequest.setAttribute("isUserBanned", false);

			String userPublikId = getPublikID(renderRequest);
			if (Validator.isNotNull(userPublikId)) {
				PublikUser user = PublikUserLocalServiceUtil.getByPublikUserId(userPublikId);
				if (user != null) {
					renderRequest.setAttribute("isUserloggedIn", true);
					renderRequest.setAttribute("hasUserPactSign", user.getPactSignature() != null);
					renderRequest.setAttribute("isUserBanned", user.isBanned());
				}
			}

			//Suppression des attributs de session
			HttpServletRequest request = PortalUtil.getLiferayPortletRequest(renderRequest).getHttpServletRequest();
			HttpSession session = request.getSession();
			ConcurrentHashMap portlet_render_parameters_ = ((ConcurrentHashMap) session.getAttribute("PORTLET_RENDER_PARAMETERS_"));
			portlet_render_parameters_.forEach((key,attribute)->{
				ConcurrentHashMap attributes = (ConcurrentHashMap) attribute;
				ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				attributes.remove(td.getPpid());
			});



			boolean isDueEntity = false;
			renderRequest.setAttribute("isDueEntity", isDueEntity);


			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}


	public boolean isStrasbourgEu(RenderRequest request) {
		ThemeDisplay themeDisplay = ((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY));
		if(themeDisplay.getScopeGroup().getGroupKey().equals("Strasbourg.eu")) {
			return true;
		}
		return false;
	}

	/**
	 * Génère le titre de la page avec des informations sur la pagination et les filtres appliqués.
	 *
	 * @param originalTitle Le titre original de la page.
	 * @param dc Le contexte d'affichage de l'actif de recherche contenant les informations de pagination et de filtrage.
	 * @return Le titre de la page modifié avec des informations sur la pagination et les filtres appliqués.
	 */
	public String getPageTitle(String originalTitle, SearchAssetDisplayContext dc) throws ConfigurationException {
		// Initialiser le titre avec le titre original
		String title = originalTitle;

		// Ajouter les informations de pagination au titre
		title += " | Page " + dc.getPager().getCurrentPage() + " sur " + dc.getPager().getPages().size();

		// Compter le nombre de filtres appliqués
		int filterCount = getAppliedFilterCount(dc);

		// Si des filtres sont appliqués, ajouter cette information au titre
		if (filterCount > 0) {
			title += " | " + filterCount + " filtre" + (filterCount > 1 ? "s" : "") + " appliqu\u00E9" + (filterCount > 1 ? "s" : "");
		}

		// Retourner le titre modifié
		return title;
	}

	/**
	 * Calcule le nombre de filtres appliqués dans le contexte d'affichage.
	 *
	 * @param dc Le contexte d'affichage de l'actif de recherche contenant les informations de pagination et de filtrage.
	 * @return Le nombre de filtres appliqués.
	 */
	private int getAppliedFilterCount(SearchAssetDisplayContext dc) throws ConfigurationException {
		int filterCount = 0;

		// Vérifier si une date est sélectionnée et incrémenter le compteur de filtres si c'est le cas
		if (dc.isDateField()) {
			filterCount++;
		}

		// Ajouter le nombre de vocabulaires de filtres appliqués au compteur de filtres
		filterCount += dc.getFilterCategoriesIds().size();


		// Ajouter le mots-clés de filtres appliqués au compteur de filtres
		if(!Validator.isNull(dc.getKeywords())) {
			filterCount++;
		}

		// Ajouter le mots-clés de filtres appliqués au compteur de filtres
		if(!Validator.isNull(dc.getIdSIGPlace())) {
			filterCount++;
		}

		return filterCount;
	}


	/**
	 * L'utilisateur a fait une recherche, on en profite pour set un attribut
	 */
	@Override
	public void processAction(ActionRequest actionRequest,
							  ActionResponse actionResponse)
			throws IOException, PortletException {

		actionRequest.setAttribute("userSearch", true);

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
							  ResourceResponse resourceResponse)
			throws IOException, PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			SearchAssetConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(SearchAssetConfiguration.class, themeDisplay);

			ConfigurationData configurationData = new ConfigurationData(configuration);

			String resourceID = resourceRequest.getResourceID();

			String publikUserId =  this.getPublikID(resourceRequest);

			// Verifions qu'il n'y ait pas d'entourloupe dans la solicitation
			// et réaction au type de la demande
			if (resourceID != null) {
				if (resourceID.startsWith("entrySelection")) {
					// Recherche
					SearchHits searchHits = searchEntries(resourceRequest, themeDisplay, configurationData);

					List<AssetEntry> entries = new ArrayList<>();
					if (searchHits != null) {
						for (SearchHit searchHit : searchHits.getSearchHits()) {
							com.liferay.portal.search.document.Document document = searchHit.getDocument();
							AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(
									document.getString(Field.ENTRY_CLASS_NAME),
									document.getLong(Field.ENTRY_CLASS_PK));
							if (entry != null) {
								entries.add(entry);
							}
						}
					}

					// Récupération du json des entités
					JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
					JSONArray jsonEntries = JSONFactoryUtil.createJSONArray();
					for (AssetEntry entry : entries) {
						String className = entry.getClassName();

						switch (className) {
							case "eu.strasbourg.service.agenda.model.Event":
								Event event = EventLocalServiceUtil.fetchEvent(entry.getClassPK());
								JSONObject jsonEvent = JSONFactoryUtil.createJSONObject();
								jsonEvent.put("class", className);
								JSONObject json = event.toJSON();
								json.put("eventScheduleDisplay", event.getCurrentOrFuturePeriodStringDate());
								json.put("placeAlias", event.getPlaceAlias(Locale.FRANCE));
								jsonEvent.put("json", json);
								jsonEntries.put(jsonEvent);
								break;
							case "eu.strasbourg.service.project.model.Project":
								Project project = ProjectLocalServiceUtil.fetchProject(entry.getClassPK());
								JSONObject jsonProject = JSONFactoryUtil.createJSONObject();
								jsonProject.put("class", className);
								json = project.toJSON(publikUserId);
								json.put("nbParticipations", project.getParticipations().size());
								json.put("nbEvents", project.getEvents().size());
								JSONArray jsonThematicCategoriesTitle = JSONFactoryUtil.createJSONArray();
								List<AssetCategory> thematicCategories = project.getThematicCategories();
								for (AssetCategory assetCategory : thematicCategories) {
									jsonThematicCategoriesTitle.put(JSONHelper.getJSONFromI18nMap(assetCategory.getTitleMap()));
								}
								json.put("jsonThematicCategoriesTitle", jsonThematicCategoriesTitle);
								jsonProject.put("json", json);
								jsonEntries.put(jsonProject);
								break;
							case "eu.strasbourg.service.project.model.Participation":
								Participation participation = ParticipationLocalServiceUtil.fetchParticipation(entry.getClassPK());
								JSONObject jsonParticipation = JSONFactoryUtil.createJSONObject();
								jsonParticipation.put("class", className);
								json = participation.toJSON(themeDisplay);
								json.put("todayExpirationDifferenceDays", participation.getTodayExpirationDifferenceDays());
								json.put("todayPublicationDifferenceDays", participation.getTodayPublicationDifferenceDays());
								json.put("isJudgeable", participation.isJudgeable());
								json.put("groupId", participation.getGroupId());
								LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(resourceRequest);
								HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();
								json.put("hasPactSigned", originalRequest.getSession().getAttribute("has_pact_signed"));
								jsonThematicCategoriesTitle = JSONFactoryUtil.createJSONArray();
								thematicCategories = participation.getThematicCategories();
								for (AssetCategory assetCategory : thematicCategories) {
									jsonThematicCategoriesTitle.put(JSONHelper.getJSONFromI18nMap(assetCategory.getTitleMap()));
								}
								json.put("jsonThematicCategoriesTitle", jsonThematicCategoriesTitle);
								jsonParticipation.put("json", json);
								jsonEntries.put(jsonParticipation);
								break;
							case "eu.strasbourg.service.project.model.Petition":
								Petition petition = PetitionLocalServiceUtil.fetchPetition(entry.getClassPK());
								JSONObject jsonPetition = JSONFactoryUtil.createJSONObject();
								jsonPetition.put("class", className);
								json = petition.toJSON(publikUserId);
								jsonThematicCategoriesTitle = JSONFactoryUtil.createJSONArray();
								thematicCategories = petition.getThematicCategories();
								for (AssetCategory assetCategory : thematicCategories) {
									jsonThematicCategoriesTitle.put(JSONHelper.getJSONFromI18nMap(assetCategory.getTitleMap()));
								}
								json.put("jsonThematicCategoriesTitle", jsonThematicCategoriesTitle);
								json.put("jsonProjectCategoryTitle", JSONHelper.getJSONFromI18nMap((Validator.isNull(petition.getProjectCategory()) ? LocalizationUtil.getLocalizationMap("") : petition.getProjectCategory().getTitleMap())));
								jsonPetition.put("json", json);
								jsonEntries.put(jsonPetition);
								break;
							case "eu.strasbourg.service.project.model.SaisineObservatoire":
								SaisineObservatoire saisineObservatoire = SaisineObservatoireLocalServiceUtil.fetchSaisineObservatoire(entry.getClassPK());
								JSONObject jsonSaisineObservatoire = JSONFactoryUtil.createJSONObject();
								jsonSaisineObservatoire.put("class", className);
								json = saisineObservatoire.toJSON(publikUserId);
								jsonThematicCategoriesTitle = JSONFactoryUtil.createJSONArray();
								thematicCategories = saisineObservatoire.getThematicCategories();
								for (AssetCategory assetCategory : thematicCategories) {
									jsonThematicCategoriesTitle.put(JSONHelper.getJSONFromI18nMap(assetCategory.getTitleMap()));
								}
								json.put("jsonThematicCategoriesTitle", jsonThematicCategoriesTitle);
								json.put("jsonProjectCategoryTitle", JSONHelper.getJSONFromI18nMap((Validator.isNull(saisineObservatoire.getProjectCategory()) ? LocalizationUtil.getLocalizationMap("") : saisineObservatoire.getProjectCategory().getTitleMap())));
								jsonSaisineObservatoire.put("json", json);
								jsonEntries.put(jsonSaisineObservatoire);
								break;
							case "eu.strasbourg.service.project.model.BudgetParticipatif":
								BudgetParticipatif budgetParticipatif = BudgetParticipatifLocalServiceUtil.fetchBudgetParticipatif(entry.getClassPK());
								JSONObject jsonBudget = JSONFactoryUtil.createJSONObject();
								jsonBudget.put("class", className);
								jsonBudget.put("json", budgetParticipatif.toJSON(publikUserId));
								jsonEntries.put(jsonBudget);
								break;
							case "eu.strasbourg.service.project.model.Initiative":
								Initiative initiative = InitiativeLocalServiceUtil.fetchInitiative(entry.getClassPK());
								JSONObject jsonInitiative = JSONFactoryUtil.createJSONObject();
								jsonInitiative.put("class", className);
								jsonInitiative.put("json", initiative.toJSON());
								jsonEntries.put(jsonInitiative);
								break;
							case "eu.strasbourg.service.help.model.HelpProposal":
								HelpProposal helpProposal = HelpProposalLocalServiceUtil.fetchHelpProposal(entry.getClassPK());
								JSONObject jsonHelpProposal = JSONFactoryUtil.createJSONObject();
								jsonHelpProposal.put("class", className);
								Locale locale = themeDisplay.getLocale();
								jsonHelpProposal.put("json", helpProposal.toJSON(locale));
								jsonEntries.put(jsonHelpProposal);
								break;
							case "eu.strasbourg.service.video.model.Video":
								Video video = VideoLocalServiceUtil.fetchVideo(entry.getClassPK());
								JSONObject jsonVideo = JSONFactoryUtil.createJSONObject();
								jsonVideo.put("class", className);
								jsonVideo.put("json", video.toJSON());
								jsonEntries.put(jsonVideo);
								break;
							case "com.liferay.journal.model.JournalArticle":
								JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(entry.getClassPK());
								JSONObject jsonJournalArticle = JSONFactoryUtil.createJSONObject();
								jsonJournalArticle.put("class", className);
								json = JSONFactoryUtil.createJSONObject();
								json.put("detailURL", LayoutHelper.getJournalArticleLayoutURL(journalArticle.getGroupId(), journalArticle.getArticleId(), themeDisplay));
								String title = JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "title", Locale.FRANCE);
								if (Validator.isNull(title)) {
									title = journalArticle.getTitle(Locale.FRANCE);
								}
								json.put("title", title);
								String thumbnail = JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "thumbnail", Locale.FRANCE);
								String imageURL = "";
								if (!thumbnail.isEmpty()) {
									imageURL = AssetPublisherTemplateHelper.getDocumentUrl(thumbnail);
								}
								json.put("thumbnail", imageURL);
								String image = JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "image", Locale.FRANCE);
								if (!image.isEmpty()) {
									imageURL = AssetPublisherTemplateHelper.getDocumentUrl(image);
								}
								json.put("image", imageURL);
								AssetEntry asset = AssetEntryLocalServiceUtil.getAssetEntry(entry.getEntryId());
								List<AssetCategory> listVocabulary = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(asset, "territoire");
								List<AssetCategory> districtCategories = AssetVocabularyHelper.getDistrictCategories(listVocabulary);
								List<AssetCategory> cityCategories = AssetVocabularyHelper.getCityCategories(listVocabulary);
								String districts = AssetVocabularyHelper.getDistrictTitle(Locale.FRANCE, districtCategories, cityCategories);
								json.put("jsonVocabulariesTitle", districts);
								List<AssetCategory> listMuseum = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(asset, "musees");
								JSONArray museums = JSONFactoryUtil.createJSONArray();
								for (AssetCategory museum : listMuseum) {
									museums.put(museum.getTitle(Locale.FRANCE));
								}
								json.put("jsonMuseumsTitle", museums);
								SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
								json.put("modifiedDate", dateFormat.format(journalArticle.getModifiedDate()));
								String chapo = JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "chapo", Locale.FRANCE);
								json.put("chapo", chapo.replaceAll("<[^>]*>", "").substring(0, Math.min(chapo.length(), 100)));
								jsonJournalArticle.put("json", json);
								jsonEntries.put(jsonJournalArticle);
								break;
						}
					}
					jsonResponse.put("entries", jsonEntries);
					jsonResponse.put("total", searchHits.getTotalHits());

					// Recuperation de l'élément d'écriture de la réponse
					PrintWriter writer = resourceResponse.getWriter();
					writer.print(jsonResponse.toString());

				} else if (resourceID.equals("exportResource")) {
					// pour l'export PDF

					HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
					SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

					// seed
					int seed = ParamUtil.getInteger(resourceRequest, "seed");

					// sortFieldAndType
					String sortFieldAndType = ParamUtil.getString(resourceRequest, "sortFieldAndType");

					// Mots clés
					String keywords = HtmlUtil.escape(ParamUtil.getString(resourceRequest, "keywords"));

					// Filtre sur les dates
					LocalDate fromDate = LocalDate.of(2017,1, 1);
					LocalDate toDate = LocalDate.now().minusDays(1);
					if(configurationData.getUtilsAssetTypeList().size() == 0
							|| configurationData.getUtilsAssetTypeList().size() > 1
							|| !configurationData.getFilterField().equals("endDate_Number_sortable")){
						int startDay = ParamUtil.getInteger(resourceRequest, "startDay");
						int startMonth = ParamUtil.getInteger(resourceRequest, "startMonth");
						int startYear = ParamUtil.getInteger(resourceRequest, "startYear");
						int endDay = ParamUtil.getInteger(resourceRequest, "endDay");
						int endMonth = ParamUtil.getInteger(resourceRequest, "endMonth");
						int endYear = ParamUtil.getInteger(resourceRequest, "endYear");
						fromDate = LocalDate.of(startYear, startMonth, startDay);
						toDate = LocalDate.of(endYear, endMonth, endDay);
					}

					// Catégories sélectionnées par l'utilisateur
					List<Long[]> categoriesIds = new ArrayList<>();
					String categoriesIdsString = ParamUtil.getString(resourceRequest, "categoriesIds");
					if (Validator.isNotNull(categoriesIdsString)) {
						for (String prefilterCategoriesIdsAnd : categoriesIdsString.split(";")) {
							Long[] categoriesIdsOr = ArrayUtil.toLongArray(StringUtil.split(prefilterCategoriesIdsAnd, ",", 0));
							categoriesIds.add(categoriesIdsOr);
						}
					}

					// Recherche
					SearchHits searchHits = _searchHelperV2.getGlobalSearchHitsV2(searchContext,
							configurationData.getUtilsAssetTypeList(), configurationData.isDisplayDateField(),
							configurationData.getFilterField(), seed,
							getSortFieldsAndTypes(configurationData, sortFieldAndType, keywords),
							/*getCategoriesIdsForGroupBy(configurationData),*/ keywords, fromDate, toDate, categoriesIds,
							null, getClassNames(configurationData), themeDisplay.getLocale(), -1, -1);

					StringBuilder ids = new StringBuilder();
					if (searchHits != null) {
						for (SearchHit searchHit : searchHits.getSearchHits()) {
							com.liferay.portal.search.document.Document document = searchHit.getDocument();

							if (ids.length() >= 0) {
								ids.append(",");
							}
							ids.append(document.getLong(Field.ENTRY_CLASS_PK));
						}
					}

					String exportType = configuration.exportType();
					ExportPDF.printPDF(resourceRequest, resourceResponse, exportType, ids.toString());
				}
			}
		} catch (Exception e2) {
			_log.error(e2);
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	/**
	 * Effectue concrètement la recherche
	 */
	private SearchHits searchEntries(ResourceRequest request, ThemeDisplay themeDisplay,
										   ConfigurationData configurationData) throws ConfigurationException {
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(request);
		SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

		SearchParameters param = new SearchParameters(request);

		// Filtre sur les dates
		LocalDate fromDate = LocalDate.of(getFromYear(configurationData, param.getStartYear()), getFromMonthValue(configurationData, param.getStartMonth()),
				getFromDay(configurationData, param.getStartDay()));
		LocalDate toDate = LocalDate.of(getToYear(configurationData, param.getEndYear()), getToMonthValue(configurationData,  param.getEndMonth()),
				getToDay(configurationData,  param.getEndDay()));

		// Catégories sélectionnées par l'utilisateur
		List<Long[]> categoriesIds = new ArrayList<>();
		if(Validator.isNull(param.getSelectedAllCategories())) {
			categoriesIds = this.getFilterCategoriesIds(param.getStates(), param.getStatuts(), param.getBpStatus(), param.getInitiativeStatus(), param.getProjects(),
					param.getDistricts(), param.getThematics(), param.getTypes(), param.getHelpProposalTypes(), param.getHelpProposalActivityStatus(), param.getLocalisations());
		}else {
			for (String selectedCategoriesByVocabulary : param.getSelectedAllCategories().split("--")) {
				String[] categoryIdsString = selectedCategoriesByVocabulary.split(",");
				Long[] categoryIds = new Long[categoryIdsString.length];
				for (int i = 0; i < categoryIdsString.length; i++) {
					categoryIds[i] = Long.valueOf(categoryIdsString[i]);
				}
				if (categoryIds.length > 0) {
					categoriesIds.add(categoryIds);
				}
			}
			;
		}

		// Permet de remonter la hiérarchie des Request
		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(servletRequest);
		// Lieu (pour la recherche agenda)
		String idSIGPlace = ParamUtil.getString(originalRequest, "idSIGPlace");

		//Récupération des variables de session
		HttpSession session = originalRequest.getSession();
		int seed = 0;
		if(Validator.isNull(session.getAttribute("seed"))){
			seed = new Random().nextInt();
			session.setAttribute("seed", seed);
		}else{
			seed = (int)session.getAttribute("seed");
		}

		// Recherche
		SearchHits searchHits = _searchHelperV2.getGlobalSearchHitsV2(searchContext,
				configurationData.getUtilsAssetTypeList(),
				configurationData.isDisplayDateField(), configurationData.getFilterField(),
				getSeed(configurationData, param.getSortFieldAndType(), param.getKeywords(), seed),
				getSortFieldsAndTypes(configurationData, param.getSortFieldAndType(), param.getKeywords()), /*getCategoriesIdsForGroupBy(configurationData),*/ param.getKeywords(), fromDate,
				toDate, categoriesIds, idSIGPlace, getClassNames(configurationData), themeDisplay.getLocale(),
				param.getStart(), param.getEnd());

		return searchHits;
	}

	/**
	 * Retourne l'année de la date de début de la recherche depuis les
	 * paramètres de la requête ou depuis la configuration
	 */
	public int getFromYear(ConfigurationData configurationData, int fromParam) {
		if (fromParam > 0) {
			return fromParam;
		} else {
			if (configurationData.getDefaultFilterDateRange() < 0) {
				return LocalDate.now().plusDays(configurationData.getDefaultFilterDateRange()).getYear();
			} else {
				return LocalDate.now().getYear();
			}
		}
	}

	/**
	 * Retourne le mois de la date de début de la recherche depuis les
	 * paramètres de la requête ou depuis la configuration, dans l'interval
	 * [1;12]
	 */
	public int getFromMonthValue(ConfigurationData configurationData, String fromMonthString) {
		if (Validator.isNull(fromMonthString)) {
			if (configurationData.getDefaultFilterDateRange() < 0) {
				return LocalDate.now().plusDays(configurationData.getDefaultFilterDateRange()).getMonthValue();
			} else {
				return LocalDate.now().getMonthValue();
			}
		} else {
			return Integer.parseInt(fromMonthString) + 1;
		}
	}

	/**
	 * Retourne la jour du mois de la date de début de la recherche. Soit depuis
	 * les paramètres de la requête soit le réglage par défaut via la
	 * configuration (date du jour, ou si la période de recherche par défaut par
	 * défaut est négative, X jour dans le passé)
	 */
	public int getFromDay(ConfigurationData configurationData, int fromParam) {
		if (fromParam > 0) {
			return fromParam;
		} else {
			if (configurationData.getDefaultFilterDateRange() < 0) {
				return LocalDate.now().plusDays(configurationData.getDefaultFilterDateRange()).getDayOfMonth();
			} else {
				return LocalDate.now().getDayOfMonth();
			}
		}
	}

	/**
	 * Retourne l'année de la date de fin de la recherche depuis les paramètres
	 * de la requête ou depuis la configuration
	 */
	public int getToYear(ConfigurationData configurationData, int toParam) {
		if (toParam > 0) {
			return toParam;
		} else {
			if (configurationData.getDefaultFilterDateRange() > 0) {
				return LocalDate.now().plusDays(configurationData.getDefaultFilterDateRange()).getYear();
			} else {
				return LocalDate.now().getYear();
			}
		}
	}

	/**
	 * Retourne le mois de la date de fin de la recherche depuis les paramètres
	 * de la requête ou depuis la configuration, dans l'interval [1;12]
	 */
	public int getToMonthValue(ConfigurationData configurationData, String toMonthString) {
		if (Validator.isNull(toMonthString)) {
			if (configurationData.getDefaultFilterDateRange() > 0) {
				return LocalDate.now().plusDays(configurationData.getDefaultFilterDateRange()).getMonthValue();
			} else {
				return LocalDate.now().getMonthValue();
			}
		} else {
			return Integer.parseInt(toMonthString) + 1;
		}
	}

	/**
	 * Retourne la jour du mois de la date de fin de la recherche. Soit depuis
	 * les paramètres de la requête soit le réglage par défaut via la
	 * configuration (date du jour + config, ou si la période de recherche par
	 * défaut par défaut est négative, date du jour)
	 */
	public int getToDay(ConfigurationData configurationData, int toParam) {
		if (toParam > 0) {
			return toParam;
		} else {
			if (configurationData.getDefaultFilterDateRange() > 0) {
				return LocalDate.now().plusDays(configurationData.getDefaultFilterDateRange()).getDayOfMonth();
			} else {
				return LocalDate.now().getDayOfMonth();
			}
		}
	}

	/**
	 * Renvoie la liste des catégories sur lesquelles on souhaite filtrer les
	 * entries. L'opérateur entre chaque id de catégorie d'un array est un "OU", celui entre chaque liste d'array est un "ET"
	 */
	private List<Long[]> getFilterCategoriesIds(long[] states, long[] statuts, long[] bpStatus, long[] initiativeStatus,
												long[] projects, long [] districts, long[] thematics, long[] types,
												long[] helpProposalTypes, long[] helpProposalActivityStatus, long[] localisations) {
		List<Long[]> filterCategoriesIds = new ArrayList<>();
		List<Long> categoriesIds = new ArrayList<>();

		// On récupère les états s'il y en a
		categoriesIds = new ArrayList<>();
		for (long state : states) {
			if (state > 0) {
				categoriesIds.add(state);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On récupère les statuts s'il y en a
		categoriesIds = new ArrayList<>();
		for (long statut : statuts) {
			if (statut > 0) {
				categoriesIds.add(statut);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On recupere les statuts BP s'il y en a
		categoriesIds = new ArrayList<>();
		for (long bpStatu : bpStatus) {
			if (bpStatu > 0) {
				categoriesIds.add(bpStatu);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On recupere les statuts initiative s'il y en a
		categoriesIds = new ArrayList<>();
		for (long initiativeStatu : initiativeStatus) {
			if (initiativeStatu > 0) {
				categoriesIds.add(initiativeStatu);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On récupère les projets s'il y en a
		categoriesIds = new ArrayList<>();
		for (long project : projects) {
			if (project > 0) {
				categoriesIds.add(project);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On récupère les quartiers s'il y en a
		categoriesIds = new ArrayList<>();
		for (long district : districts) {
			if (district > 0) {
				categoriesIds.add(district);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On récupère les thématiques s'il y en a
		categoriesIds = new ArrayList<>();
		for (long thematic : thematics) {
			if (thematic > 0) {
				categoriesIds.add(thematic);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On récupère les types s'il y en a
		categoriesIds = new ArrayList<>();
		for (long type : types) {
			if (type > 0) {
				categoriesIds.add(type);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On recupere les types d'aide s'il y en a
		categoriesIds = new ArrayList<>();
		for (long helpProposalType : helpProposalTypes) {
			if (helpProposalType > 0) {
				categoriesIds.add(helpProposalType);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On récupère l'état d'activité s'il y en a
		categoriesIds = new ArrayList<>();
		for (long helpProposalActivity : helpProposalActivityStatus) {
			if (helpProposalActivity > 0) {
				categoriesIds.add(helpProposalActivity);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		// On récupère les localisation s'il y en a
		categoriesIds = new ArrayList<>();
		for (long localisation : localisations) {
			if (localisation > 0) {
				categoriesIds.add(localisation);
			}
		}
		if (categoriesIds.size() > 0) {
			filterCategoriesIds.add(ArrayUtil.toLongArray(categoriesIds.stream().mapToLong(l -> l).toArray()));
		}

		return filterCategoriesIds;
	}

	/**
	 * Retourne le seed sur leuqel on mélange les résultats
	 */
	public int getSeed(ConfigurationData configurationData, String sortFieldAndTypeFromParam, String keywords, int seed) {
		if (Validator.isNull(sortFieldAndTypeFromParam) && Validator.isNull(keywords)) {
			if(configurationData.isRandomSort()) {
				return seed;
			}
		}
		return 0;
	}

	/**
	 * Retourne le(s) champ(s) sur le(s)quel on classe les résultats
	 */
	public Map<String, String> getSortFieldsAndTypes(ConfigurationData configurationData, String sortFieldAndTypeFromParam, String keywords) {
		Map fieldsAndTypes = new LinkedHashMap();
		if (Validator.isNull(sortFieldAndTypeFromParam)) {
			if (Validator.isNull(keywords)) {
				String firstSortingField = Validator.isNotNull(configurationData.getFirstSortingField())
						? configurationData.getFirstSortingField() : "modified_sortable";
				String firstSortingType = Validator.isNotNull(configurationData.getFirstSortingType())
						? configurationData.getFirstSortingType() : "DESC";
				fieldsAndTypes.put(firstSortingField, firstSortingType);
				String secondSortingField = Validator.isNotNull(configurationData.getSecondSortingField())
						? configurationData.getSecondSortingField() : "modified_sortable";
				if (!firstSortingField.equals(secondSortingField)) {
					String secondSortingType = Validator.isNotNull(configurationData.getSecondSortingType())
							? configurationData.getSecondSortingType() : "DESC";
					fieldsAndTypes.put(secondSortingField, secondSortingType);
				}
			}
		}else{
			String[] sorts = sortFieldAndTypeFromParam.split("--");
			for (String sort : sorts) {
				String[] sortArray = sort.split(",");
				if(!sortArray[0].equals("score"))
					fieldsAndTypes.put(sortArray[0], sortArray[1]);
			}
		}
		return fieldsAndTypes;
	}

	/**
	 * Retourne le vocabulaireId sur leuqel on regroupe les résultats
	 */

	/**
	 * Retourne les categories du vocabulaire sur lequel on regroupe les résultats (par tri)
	 */
//	public long[] getCategoriesIdsForGroupBy(ConfigurationData configurationData) {
//		long[] categoriesIdsForGroupBy = {0};
//		if(configurationData.getGroupBy() > 0) {
//			// On récupère le vocabulaire
//			AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.fetchAssetVocabulary(configurationData.getGroupBy());
//			if (Validator.isNotNull(vocabulary)) {
//				// On récupère les catégories
//				categoriesIdsForGroupBy = vocabulary.getCategories().stream().mapToLong(c -> c.getCategoryId()).toArray();
//			}
//		}else{
//			categoriesIdsForGroupBy[0] = configurationData.getGroupBy();
//		}
//		return categoriesIdsForGroupBy;
//	}

	/**
	 * Récupère la liste des class names sur lesquels faire la recherche
	 */
	public List<String> getClassNames(ConfigurationData configurationData) {
		List<String> classNames = new ArrayList<>();
		for (ConfigurationAssetData assetType : configurationData.getAssetTypeDataList()){
			if (Validator.isNotNull(assetType)){
				if(Validator.isNotNull(assetType.getClassName())) {
					classNames.add(assetType.getClassName());
				}
			}
		}

		return classNames;
	}

	/**
	 * Récupération du publik ID avec la session
	 */
	private String getPublikID(PortletRequest request) {
		LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(request);
		HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();
		return SessionParamUtil.getString(originalRequest, "publik_internal_id");
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

	/**
	 * interface des petitions
	 */
	private PetitionLocalService _petitionLocalService;

	/**
	 * interface des saisines
	 */
	private SaisineObservatoireLocalService _saisineObservatoireLocalService;

	/**
	 * interface des budgets
	 */
	private BudgetParticipatifLocalService _budgetParticipatifLocalService;

	/**
	 * interface des initiatives
	 */
	private InitiativeLocalService _initiativeLocalService;

	/**
	 * interface des participations
	 */
	private ParticipationLocalService _participationLocalService;

	@Reference(unbind = "-")
	protected void setPetitionLocalService(PetitionLocalService petitionLocalService) {
		_petitionLocalService = petitionLocalService;
	}

	@Reference(unbind = "-")
	protected void setSaisineObservatoireLocalService(SaisineObservatoireLocalService saisineObservatoireLocalService) {
		_saisineObservatoireLocalService = saisineObservatoireLocalService;
	}

	@Reference(unbind = "-")
	protected void setBudgetParticipatifLocalService(BudgetParticipatifLocalService budgetParticipatifLocalService) {
		_budgetParticipatifLocalService = budgetParticipatifLocalService;
	}

	@Reference(unbind = "-")
	protected void setInitiativeLocalService(InitiativeLocalService initiativeLocalService) {
		_initiativeLocalService = initiativeLocalService;
	}

	@Reference(unbind = "-")
	protected void setParticipationLocalService(ParticipationLocalService participationLocalService) {
		_participationLocalService = participationLocalService;
	}

	@Reference
	private SearchHelperV2 _searchHelperV2;

	@Reference(unbind = "-")
	protected void setSearchHelperV2(SearchHelperV2 searchHelperV2) {
		_searchHelperV2 = searchHelperV2;
	}

}