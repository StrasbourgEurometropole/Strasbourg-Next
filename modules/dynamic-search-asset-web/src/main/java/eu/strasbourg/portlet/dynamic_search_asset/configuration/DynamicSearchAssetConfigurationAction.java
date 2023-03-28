package eu.strasbourg.portlet.dynamic_search_asset.configuration;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component(
	configurationPid = "eu.strasbourg.portlet.dynamic_search_asset.configuration.DynamicSearchAssetConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL,
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.DYNAMIC_SEARCH_ASSET_WEB
	},
	service = ConfigurationAction.class
)
public class DynamicSearchAssetConfigurationAction extends DefaultConfigurationAction {
	
	/**
	 * Action : Sauvegarde de la configuration si on a validé le formulaire ou
	 * envoi de la JSP des sélecteurs si on a changé la liste déroulante des
	 * types d'entité
	 */
	@Override
	public void processAction(PortletConfig portletConfig,
		ActionRequest request, ActionResponse response) throws Exception {
		
		String cmd = ParamUtil.getString(request, "cmd");
		
		if (cmd.equals("update")) {
			
			// CHAMP : ClassNamesIds
			String assetClassNamesIdsString = "";
			long assetClassNamesCount = ParamUtil.getLong(request, "assetClassNamesCount");
			
			for (long i = 0; i < assetClassNamesCount; i++) {
				String assetClassNameIdString = ParamUtil.getString(request, "assetClassNameId_" + i);
				boolean assetClassNameSelected = !Validator.isNull(assetClassNameIdString)
					&& !assetClassNameIdString.equals("false");
				
				if (assetClassNameSelected) {
					// ClassName
					if (assetClassNamesIdsString.length() > 0) {
						assetClassNamesIdsString += ",";
					}
					assetClassNamesIdsString += assetClassNameIdString;
				}
			}
			
			setPreference(request, "assetClassNamesIds", assetClassNamesIdsString);
			
			// CHAMP : ClassNames
			String assetClassNames = "";
			for (String assetClassNameIdString : assetClassNamesIdsString.split(",")) {
				if (assetClassNameIdString.length() > 0) {
					ClassName assetClassName = ClassNameLocalServiceUtil.getClassName(Long.parseLong(assetClassNameIdString));
					if (assetClassNames.length() > 0) {
						assetClassNames += ",";
					}
					assetClassNames += assetClassName.getValue();
				}
			}
			setPreference(request, "assetClassNames", assetClassNames);

			// CHAMP : Recherche des JournalArticle
			boolean searchNews = ParamUtil.getBoolean(request, "searchNews");
			setPreference(request, "searchNews", String.valueOf(searchNews));

			// CHAMP : Recherche de documents
			boolean searchDocument = ParamUtil.getBoolean(request, "searchDocument");
			setPreference(request, "searchDocument", String.valueOf(searchDocument));
			
			// CHAMP : Scope global
			boolean globalScope = ParamUtil.getBoolean(request, "globalScope");
			setPreference(request, "globalScope", String.valueOf(globalScope));
			
			// CHAMP : date
			boolean dateField = ParamUtil.getBoolean(request, "dateField");
			setPreference(request, "dateField", String.valueOf(dateField));
			
			// CHAMP : Delta (nombre de resultats max à afficher)
			long delta = ParamUtil.getLong(request, "delta");
			setPreference(request, "delta", String.valueOf(delta));
			
			// CHAMP : Formulaire à afficher
			String searchForm = ParamUtil.getString(request, "searchForm", "placit");
			setPreference(request, "searchForm", searchForm);
			
			// CHAMP : Préfiltre catégories
			String prefilterCategoriesIds = ParamUtil.getString(request, "prefilterCategoriesIds");
			// On enregistre les ids des catégories sous forme de String
			// On sépare les catégories d'un même vocabulaire par des virgules
			// et les vocabulaires par des points-virgules
			List<Long> vocabulariesIds = new ArrayList<Long>();
			for (String categoryIdStr : prefilterCategoriesIds.split(",")) {
				Long categoryId = GetterUtil.getLong(categoryIdStr);
				if (categoryId > 0) {
					AssetCategory category = AssetCategoryLocalServiceUtil.fetchAssetCategory(categoryId);
					if (category != null && !vocabulariesIds.contains(category.getVocabularyId())) {
						vocabulariesIds.add(category.getVocabularyId());
					}
				}
			}
			String sortedPrefilterCategoriesIds = "";
			for (Long vocabularyId : vocabulariesIds) {
				if (sortedPrefilterCategoriesIds.length() > 0) {
					sortedPrefilterCategoriesIds += ";";
				}
				for (String categoryIdStr : prefilterCategoriesIds.split(",")) {
					Long categoryId = GetterUtil.getLong(categoryIdStr);
					if (categoryId > 0) {
						AssetCategory category = AssetCategoryLocalServiceUtil.fetchAssetCategory(categoryId);
						if (category != null && vocabularyId == category.getVocabularyId()) {
							if (sortedPrefilterCategoriesIds.length() > 0 && !sortedPrefilterCategoriesIds.endsWith(";")) {
								sortedPrefilterCategoriesIds += ",";
							}
							sortedPrefilterCategoriesIds += categoryId;
						}
					}
				}
			}
			setPreference(request, "prefilterCategoriesIds", sortedPrefilterCategoriesIds);

			// CHAMP : Préfiltre tags
			String prefilterTagsNames = ParamUtil.getString(request, "prefilterTagsNames");
			setPreference(request, "prefilterTagsNames", prefilterTagsNames);
			
			// CHAMP : Boost tags
			String boostTagsNames = ParamUtil.getString(request, "boostTagsNames");
			setPreference(request, "boostTagsNames", boostTagsNames);
			
			// CHAMP : Filtre par dates par défaut
			Long dateRangeFrom = ParamUtil.getLong(request, "dateRangeFrom");
			Long dateRangeTo = ParamUtil.getLong(request, "dateRangeTo");
			setPreference(request, "dateRangeFrom", String.valueOf(dateRangeFrom));
			setPreference(request, "dateRangeTo", String.valueOf(dateRangeTo));
			
			// CHAMP : Recherche dynamique (au fur et à mesure de l'écriture)
			Boolean dynamicSearch = ParamUtil.getBoolean(request, "dynamicSearch", false);
			setPreference(request, "dynamicSearch", String.valueOf(dynamicSearch));
		}
		
		super.processAction(portletConfig, request, response);
	}
	
	/**
	 * Envoie à la JSP de configuration des informations nécessaires
	 */
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			DynamicSearchAssetConfiguration configuration = themeDisplay
				.getPortletDisplay()
				.getPortletInstanceConfiguration(DynamicSearchAssetConfiguration.class);
			
			// Liste tous les types possibles d'asset
			// On ne prend que ceux qui commencent par "eu.strasbourg"
			List<AssetRendererFactory<?>> availableAssetRendererFactories = AssetRendererFactoryRegistryUtil.getAssetRendererFactories(
					themeDisplay.getCompany().getCompanyId()).stream().filter(a -> a.isCategorizable()
					&& a.getClassName().startsWith("eu.strasbourg")).collect(Collectors.toList());
//			List<AssetRendererFactory<?>> availableAssetRendererFactories = ListUtil
//					.filter(
//							AssetRendererFactoryRegistryUtil.getAssetRendererFactories(
//									themeDisplay.getCompany().getCompanyId()),
//							new Predicate<AssetRendererFactory<?>>() {
//								@Override
//								public boolean filter(AssetRendererFactory<?> assetRendererFactory) {
//									return assetRendererFactory.isCategorizable()
//											&& assetRendererFactory.getClassName().startsWith("eu.strasbourg");
//								}
//							}
//					);
			request.setAttribute("availableAssetRendererFactories", availableAssetRendererFactories);
			
			// Types d'assets sélectionnés
			long[] assetClassNamesIds = ParamUtil.getLongValues(request, "assetClassNamesIds");
			String assetClassNamesIdsString;
			if (assetClassNamesIds.length > 0) {
				assetClassNamesIdsString = StringUtil.merge(assetClassNamesIds);
			} else {
				assetClassNamesIdsString = configuration.assetClassNamesIds();
			}
			request.setAttribute("assetClassNamesIds",
				assetClassNamesIdsString);

			// Recherche de JournalArticle
			boolean searchNews = ParamUtil.getBoolean(request, "searchNews", configuration.searchNews());
			request.setAttribute("searchNews", searchNews);

			// Recherche de documents
			boolean searchDocument = ParamUtil.getBoolean(request, "searchDocument", configuration.searchDocument());
			request.setAttribute("searchDocument", searchDocument);
			
			// Scope global
			boolean globalScope = ParamUtil.getBoolean(request, "globalScope", configuration.globalScope());
			request.setAttribute("globalScope", globalScope);
			
			// Champ date
			boolean dateField = ParamUtil.getBoolean(request, "dateField", configuration.dateField());
			request.setAttribute("dateField", dateField);
			
			// Filtre par date par défault
			long dateRangeFrom = configuration.dateRangeFrom();
			long dateRangeTo = configuration.dateRangeTo();
			request.setAttribute("dateRangeFrom", dateRangeFrom);
			request.setAttribute("dateRangeTo", dateRangeTo);
			
			// Delta
			long delta = ParamUtil.getLong(request, "delta", configuration.delta());
			request.setAttribute("delta", delta);
			
			// Formulaire à afficher
			String searchForm = ParamUtil.getString(request, "searchForm", configuration.searchForm());
			request.setAttribute("searchForm", searchForm);

			// Préfiltres catégories
			String prefilterCategoriesIds = configuration.prefilterCategoriesIds().replace(";", ",");
			request.setAttribute("prefilterCategoriesIds", prefilterCategoriesIds);

			// Préfiltre tags
			String prefilterTagsNames = configuration.prefilterTagsNames();
			request.setAttribute("prefilterTagsNames", prefilterTagsNames);

			// Boost tags
			String boostTagsNames = configuration.boostTagsNames();
			request.setAttribute("boostTagsNames", boostTagsNames);
			
			// Recherche dynamique (au fur et à mesure de l'écriture)
			Boolean dynamicSearch = configuration.dynamicSearch();
			request.setAttribute("dynamicSearch", dynamicSearch);
			

		} catch (ConfigurationException e) {
			_log.error(e);
		}
		super.include(portletConfig, request, response);
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
	
}
