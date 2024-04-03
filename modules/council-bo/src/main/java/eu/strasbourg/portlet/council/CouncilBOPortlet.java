package eu.strasbourg.portlet.council;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.council.constants.CouncilConstants;
import eu.strasbourg.portlet.council.display.context.EditCouncilSessionDisplayContext;
import eu.strasbourg.portlet.council.display.context.EditDeliberationDisplayContext;
import eu.strasbourg.portlet.council.display.context.EditOfficialDisplayContext;
import eu.strasbourg.portlet.council.display.context.EditTypeDisplayContext;
import eu.strasbourg.portlet.council.display.context.ManageProcurationsDisplayContext;
import eu.strasbourg.portlet.council.display.context.ManagementCouncilSessionsToolBarDisplayContext;
import eu.strasbourg.portlet.council.display.context.ManagementDeliberationsToolBarDisplayContext;
import eu.strasbourg.portlet.council.display.context.ManagementOfficialsToolBarDisplayContext;
import eu.strasbourg.portlet.council.display.context.ManagementTypesToolBarDisplayContext;
import eu.strasbourg.portlet.council.display.context.NavigationBarDisplayContext;
import eu.strasbourg.portlet.council.display.context.ViewCouncilSessionsDisplayContext;
import eu.strasbourg.portlet.council.display.context.ViewDeliberationsDisplayContext;
import eu.strasbourg.portlet.council.display.context.ViewOfficialsConnectionDisplayContext;
import eu.strasbourg.portlet.council.display.context.ViewOfficialsDisplayContext;
import eu.strasbourg.portlet.council.display.context.ViewTypesDisplayContext;
import eu.strasbourg.portlet.council.utils.UserRoleType;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.service.council.service.CouncilSessionLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import static eu.strasbourg.portlet.council.constants.CouncilConstants.*;
/**
 * @author jeremy.zwickert
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
			"javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO,
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/council-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/council-bo-main.css",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/council-bo-view-types.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
	},
	service = Portlet.class
)
public class CouncilBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {
				case COUNCIL_SESSIONS: {
					if (navigationDC.getSelectedCmd().equals(EDIT_COUNCIL_SESSION)) {

						EditCouncilSessionDisplayContext dc = new EditCouncilSessionDisplayContext(renderRequest);
						renderRequest.setAttribute("dc", dc);
						long councilSessionId = ParamUtil.getLong(renderRequest, "councilSessionId");
						HttpServletRequest originalRequest = PortalUtil.getHttpServletRequest(renderRequest);
						HttpSession session = originalRequest.getSession();
						session.setAttribute("councilSessionId", councilSessionId);

					} else if (navigationDC.getSelectedCmd().equals(SAVE_COUNCIL_SESSION)) {
						EditCouncilSessionDisplayContext dc = new EditCouncilSessionDisplayContext(renderRequest);
						renderRequest.setAttribute("dc", dc);

					} else if (navigationDC.getSelectedCmd().equals(MANAGE_PROCURATION_COUNCIL_SESSION)) {
						ManageProcurationsDisplayContext dc = new ManageProcurationsDisplayContext(renderRequest);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewCouncilSessionsDisplayContext dc = new ViewCouncilSessionsDisplayContext(renderRequest, renderResponse);
						ManagementCouncilSessionsToolBarDisplayContext managementDC = new ManagementCouncilSessionsToolBarDisplayContext(
								servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("managementDC", managementDC);
						renderRequest.setAttribute("dc", dc);
					}
					break;
				}
				case DELIBERATIONS: {

					if (navigationDC.getSelectedCmd().equals(EDIT_DELIBERATION) || navigationDC.getSelectedCmd().equals(SAVE_DELIBERATION)
							|| navigationDC.getSelectedCmd().equals(IMPORT_DELIBERATION)) {
						EditDeliberationDisplayContext dc = new EditDeliberationDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {

						String filterCategoryDelibStage = "";
						// récupère le statut du filtre
						String categoriesFilter = ParamUtil.getString(renderRequest, "filterCategoriesIdByVocabulariesName", "");
						if (Validator.isNotNull(categoriesFilter)) {
							List<String> filterCategoriesIdByVocabulariesName = List.of(categoriesFilter.split("___"));
							String filterCategoryForState = filterCategoriesIdByVocabulariesName.stream()
									.filter(c -> c.startsWith(VocabularyNames.COUNCIL_STATE+"__")).findFirst().orElse(null);
							filterCategoryDelibStage = Validator.isNotNull(filterCategoryForState)?filterCategoryForState:"";
						}

						String filterCategoryCouncil = "";
						if(navigationDC.getSelectedCmd().equals(VIEW_DELIBERATIONS)) {
							HttpServletRequest originalRequest = PortalUtil.getHttpServletRequest(renderRequest);
							HttpSession session = originalRequest.getSession();

							long councilSessionId = Validator.isNotNull(session.getAttribute("councilSessionId"))?(long)session.getAttribute("councilSessionId"):-1;
							CouncilSession councilSession = CouncilSessionLocalServiceUtil.fetchCouncilSession(councilSessionId);
							if (Validator.isNotNull(councilSession)) {
								AssetCategory categoryCouncil = AssetVocabularyHelper.getCategory(councilSession.getTitle(), councilSession.getGroupId());
								if (categoryCouncil != null) {
									filterCategoryCouncil = VocabularyNames.COUNCIL_SESSION + "__" +
											categoryCouncil.getTitleCurrentValue() + "__" +
											categoryCouncil.getCategoryId();
									session.setAttribute("filterCategoryCouncil", filterCategoryCouncil);
								}
							}
						} else{
							filterCategoryCouncil = getCategoriesSession(renderRequest, themeDisplay);
						}

						String filterCategories = filterCategoryCouncil + (Validator.isNotNull(filterCategoryCouncil)?"___":"") +
								filterCategoryDelibStage + (Validator.isNotNull(filterCategoryDelibStage)?"___":"");

						ViewDeliberationsDisplayContext dc = new ViewDeliberationsDisplayContext(renderRequest, renderResponse, filterCategories);
						ManagementDeliberationsToolBarDisplayContext managementDC = new ManagementDeliberationsToolBarDisplayContext(
								servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer(), filterCategories);
						renderRequest.setAttribute("managementDC", managementDC);
						renderRequest.setAttribute("dc", dc);

					}
					break;
				}
				case OFFICIALS: {
					if (navigationDC.getSelectedCmd().equals(EDIT_OFFICIAL) || navigationDC.getSelectedCmd().equals(SAVE_OFFICIAL)) {
						EditOfficialDisplayContext dc = new EditOfficialDisplayContext(renderRequest);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewOfficialsDisplayContext dc = new ViewOfficialsDisplayContext(renderRequest, renderResponse);
						ManagementOfficialsToolBarDisplayContext managementDC = new ManagementOfficialsToolBarDisplayContext(
								servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("managementDC", managementDC);
						renderRequest.setAttribute("dc", dc);
					}
					break;
				}
				case OFFICIAL_CONNECTIONS: {
					ViewOfficialsConnectionDisplayContext dc = new ViewOfficialsConnectionDisplayContext(renderRequest, renderResponse);
					renderRequest.setAttribute("dc", dc);
					break;
				}
				case TYPES: {
					if (navigationDC.getSelectedCmd().equals(EDIT_TYPE) || navigationDC.getSelectedCmd().equals(SAVE_TYPE)) {
						EditTypeDisplayContext dc = new EditTypeDisplayContext(renderRequest);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewTypesDisplayContext dc = new ViewTypesDisplayContext(renderRequest, renderResponse);
						ManagementTypesToolBarDisplayContext managementDC = new ManagementTypesToolBarDisplayContext(
								servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("managementDC", managementDC);
						renderRequest.setAttribute("dc", dc);
					}
					break;
				}

			}

		} catch (PortalException e) {
			e.printStackTrace();
		}
		renderResponse.setTitle("CouncilSessions");

		// If we are on an "add" page, we set a return URL and show the "back"
		// button
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL);
		}
		// Admin ou pas
		renderRequest.setAttribute("isAdmin", themeDisplay.getPermissionChecker().isOmniadmin());

		// Admin EVOTE ou pas
		renderRequest.setAttribute("isAdminEvote", UserRoleType.IsAdminEvote(themeDisplay));

		super.render(renderRequest, renderResponse);
	}

	/**
	 * Récupère la catégorie du CouncilSession de la session, ou de celui du jour ou du dernier
	 *  qui se présente comme suit :
	 * "vocabularyName__categoryName__categoryId___..."
	 */
	private String getCategoriesSession(RenderRequest renderRequest, ThemeDisplay themeDisplay) {

		HttpServletRequest originalRequest = PortalUtil.getHttpServletRequest(renderRequest);
		HttpSession session = originalRequest.getSession();

		String filterCategoryCouncil = null;

		// récupère la catégorie du conseil du paramètre
		String categoriesFilter = ParamUtil.getString(renderRequest, "filterCategoriesIdByVocabulariesName", "");
		if (Validator.isNotNull(categoriesFilter)) {
			List<String> filterCategoriesIdByVocabulariesName = List.of(categoriesFilter.split("___"));

			String filterCategoryForCouncil = filterCategoriesIdByVocabulariesName.stream()
					.filter(c -> c.startsWith(VocabularyNames.COUNCIL_SESSION+"__")).findFirst().orElse(null);
			filterCategoryCouncil = filterCategoryForCouncil;
		}

		// Récupère la catégorie de conseil en session
		// au format vocabularyName__categoryTitle__categoryId
		Object sessionObject = session.getAttribute("filterCategoryCouncil");
		String filterCategoryCouncilSession = null;
		if (Validator.isNotNull(sessionObject)) {
			filterCategoryCouncilSession = sessionObject.toString();
		}

		// Si aucun conseil sélectionné, on prend celui de la session
		if (Validator.isNull(filterCategoryCouncil)) {
			filterCategoryCouncil = filterCategoryCouncilSession;

			// Si on a rien en session, on cherche le conseil du jour ou le dernier conseil
			// au format vocabularyName__categoryTitle__categoryId
			if (Validator.isNull(filterCategoryCouncil)) {

				// Calcul de la date
				GregorianCalendar gc = CouncilSessionLocalServiceUtil.calculDateForFindCouncil();
				List<CouncilSession> todayCouncils = CouncilSessionLocalServiceUtil.findByDate(gc.getTime());

				AssetCategory categoryCouncil = null;
				// On récupère le conseil du jour
				if (todayCouncils.size() == 1) {
					CouncilSession todayCouncil = todayCouncils.get(0);
					categoryCouncil = AssetVocabularyHelper.getCategory(todayCouncil.getTitle(), todayCouncil.getGroupId());
				}
				// Il y a plusieurs conseil aujourd'hui, on récupère "aucun conseil sélectionné"
				else if (todayCouncils.size() > 1) {
					long groupId = themeDisplay.getScopeGroupId();
					categoryCouncil = AssetVocabularyHelper.getCategory(CouncilConstants.NO_COUNCIL_CATEGORY_NAME, groupId);
				}
				// Il n'y a pas de conseil, on prend le dernier
				else {
					List<CouncilSession> futureCouncilSessions = CouncilSessionLocalServiceUtil.getCouncilSessions(-1,-1);
					if (futureCouncilSessions.size() > 0) {
						futureCouncilSessions = futureCouncilSessions.stream()
								.sorted(Comparator.comparing(CouncilSession::getDate).reversed())
								.collect(Collectors.toList());
						CouncilSession lastCouncil = futureCouncilSessions.get(0);
						categoryCouncil = AssetVocabularyHelper.getCategory(lastCouncil.getTitle(), lastCouncil.getGroupId());
					}
				}
				if (categoryCouncil != null) {
					filterCategoryCouncil = VocabularyNames.COUNCIL_SESSION + "__" +
							categoryCouncil.getTitleCurrentValue() + "__" +
							categoryCouncil.getCategoryId();
					session.setAttribute("filterCategoryCouncil", filterCategoryCouncil);
				}
			}
		}
		// Si on a sélectionné une catégorie différente à celle de la session, on prend la nouvelle et on l'enregistre en session
		else if (!filterCategoryCouncil.equals(filterCategoryCouncilSession)) {
			session.setAttribute("filterCategoryCouncil", filterCategoryCouncil);
		}

		// On récupère les catégories de type conseil autorisé par le rôle du USER
		List<AssetCategory> typeCoucilCats = UserRoleType.typeCategoriesForUser(themeDisplay);

		// On récupère toutes les catégories et sous catégories des types de conseils autorisés
		List<AssetCategory> councilCats = new ArrayList<>();
		councilCats.addAll(typeCoucilCats);
		for (AssetCategory cat : typeCoucilCats) {
			councilCats.addAll(AssetVocabularyHelper.getChild(cat.getCategoryId()));
		}

		// Si la catégorie qui était sélectionnée/choisie n'est pas dans les catégories autorisée,
		// on donne celle du premier type de conseil autorisé (même passé)
		final String finalCategoryCouncilId = filterCategoryCouncil.split("__").length==3?filterCategoryCouncil.split("__")[2]:"-1";
		if (!councilCats.stream().anyMatch(x -> String.valueOf(x.getCategoryId()).equals(finalCategoryCouncilId))) {
			filterCategoryCouncil = StringUtils.EMPTY;
			if (typeCoucilCats.size() > 0) {
				filterCategoryCouncil = VocabularyNames.COUNCIL_SESSION + "__" +
						typeCoucilCats.get(0).getTitleCurrentValue() + "__" +
						typeCoucilCats.get(0).getCategoryId();
			}
		}

		return filterCategoryCouncil;
	}
}