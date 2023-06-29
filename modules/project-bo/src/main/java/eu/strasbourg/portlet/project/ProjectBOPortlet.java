package eu.strasbourg.portlet.project;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.project.display.context.*;
import eu.strasbourg.service.project.constants.ParticiperCategories;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import static eu.strasbourg.portlet.project.constants.ProjectConstants.*;

/**
 * @author cedric.henry
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/project-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/project-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/project-bo-view-projects.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProjectBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
					   RenderResponse renderResponse) throws IOException, PortletException {


		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Verification des requetes issues d'un champ repetable
		Boolean fromAjaxProject = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxProject"));
		Boolean fromAjaxParticipation = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxParticipation"));
		Boolean fromAjaxPetition = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxPetition"));
		Boolean fromAjaxBudgetParticipatif = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxBudgetParticipatif"));
		Boolean fromAjaxInitiative = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxInitiative"));

		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {
				case PROJECTS:
					if (navigationDC.getSelectedCmd().equals(EDIT_PROJECT) || navigationDC.getSelectedCmd().equals(SAVE_PROJECT) || fromAjaxProject) {
						EditProjectDisplayContext dc = new EditProjectDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewProjectsDisplayContext dc = new ViewProjectsDisplayContext(renderRequest, renderResponse, _itemSelector);
						ManagementProjectsToolBarDisplayContext managementDC = new ManagementProjectsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case PARTICIPATIONS:
					if (navigationDC.getSelectedCmd().equals(EDIT_PARTICIPATION) || navigationDC.getSelectedCmd().equals(SAVE_PARTICIPATION)|| fromAjaxParticipation) {
						EditParticipationDisplayContext dc = new EditParticipationDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewParticipationsDisplayContext dc = new ViewParticipationsDisplayContext(renderRequest, renderResponse, _itemSelector);
						ManagementParticipationsToolBarDisplayContext managementDC = new ManagementParticipationsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case PETITIONS:
					if (navigationDC.getSelectedCmd().equals(EDIT_PETITION) || navigationDC.getSelectedCmd().equals(SAVE_PETITION)|| fromAjaxPetition) {
						EditPetitionDisplayContext dc = new EditPetitionDisplayContext(renderRequest, renderResponse);
						String signatureNumber = Integer.toString((int)themeDisplay.getSiteGroup().getExpandoBridge().getAttribute("number_of_signatures_required_per_petition"));
						renderRequest.setAttribute("signatureNumber", signatureNumber);
						renderRequest.setAttribute("dc", dc);

					} else {
						ViewPetitionsDisplayContext dc = new ViewPetitionsDisplayContext(renderRequest, renderResponse, _itemSelector);
						ManagementPetitionsToolBarDisplayContext managementDC = new ManagementPetitionsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case INITIATIVES:
					if (navigationDC.getSelectedCmd().equals(EDIT_INITIATIVE) || navigationDC.getSelectedCmd().equals(SAVE_INITIATIVE)|| fromAjaxInitiative) {
						EditInitiativeDisplayContext dc = new EditInitiativeDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewInitiativesDisplayContext dc = new ViewInitiativesDisplayContext(renderRequest, renderResponse, _itemSelector);
						ManagementInitiativesToolBarDisplayContext managementDC = new ManagementInitiativesToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case BUDGET_PARICIPATIFS:
					if (navigationDC.getSelectedCmd().equals(EDIT_BUDGET_PARICIPATIF)
							||navigationDC.getSelectedCmd().equals(SAVE_BUDGET_PARICIPATIF)
							||fromAjaxBudgetParticipatif) {

						EditBudgetParticipatifDisplayContext dc = new EditBudgetParticipatifDisplayContext(renderRequest, renderResponse);

						//On initialise le BP avec la catégorie de la phase en cours, la catégorie et la phase en cours et la catégorie statut depose
						if(navigationDC.getSelectedCmd().equals(SAVE_BUDGET_PARICIPATIF)) {
							AssetCategory category = AssetVocabularyHelper.getCategory(ParticiperCategories.BP_SUBMITTED.getName(), themeDisplay.getScopeGroupId());
							String assetCategoryIds = Long.toString(category.getCategoryId());

							BudgetPhase budgetPhaseActive = BudgetPhaseLocalServiceUtil.getActivePhase(themeDisplay.getSiteGroupId());
							if (budgetPhaseActive != null) {
								renderRequest.setAttribute("budgetPhaseId", budgetPhaseActive.getBudgetPhaseId());
								AssetCategory phaseCat = budgetPhaseActive.getPhaseCategory();
								assetCategoryIds = assetCategoryIds + "," + phaseCat.getCategoryId();
							}
							renderRequest.setAttribute("defaultAssetCategoryIds", assetCategoryIds);
						}

						renderRequest.setAttribute("dc", dc);
					}else {
						ViewBudgetParticipatifDisplayContext dc = new ViewBudgetParticipatifDisplayContext(renderRequest, renderResponse, _itemSelector);
						ManagementBudgetParticipatifsToolBarDisplayContext managementDC = new ManagementBudgetParticipatifsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case BUDGET_PHASES:
					if (navigationDC.getSelectedCmd().equals(EDIT_BUDGET_PHASE) || navigationDC.getSelectedCmd().equals(SAVE_BUDGET_PHASE)) {
						EditBudgetPhaseDisplayContext dc = new EditBudgetPhaseDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewBudgetPhasesDisplayContext dc = new ViewBudgetPhasesDisplayContext(renderRequest, renderResponse, _itemSelector);
						ManagementBudgetPhasesToolBarDisplayContext managementDC = new ManagementBudgetPhasesToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		//String title = PortalUtil.getPortletTitle(renderRequest);


		// Si on est sur la page d'ajout, on affiche un lien de retour
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL.toString());
		}

		// Admin ou pas
		renderRequest.setAttribute("isAdmin", themeDisplay.getPermissionChecker().isOmniadmin());

		super.render(renderRequest, renderResponse);


		//title = LanguageUtil.get(PortalUtil.getHttpServletRequest(renderRequest), title);
		//renderResponse.setTitle(title);

	}
	@Reference
	private ItemSelector _itemSelector;
}