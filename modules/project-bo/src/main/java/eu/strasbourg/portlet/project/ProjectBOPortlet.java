package eu.strasbourg.portlet.project;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.project.display.context.EditBudgetParticipatifDisplayContext;
import eu.strasbourg.portlet.project.display.context.EditBudgetPhaseDisplayContext;
import eu.strasbourg.portlet.project.display.context.EditInitiativeDisplayContext;
import eu.strasbourg.portlet.project.display.context.EditParticipationDisplayContext;
import eu.strasbourg.portlet.project.display.context.EditPetitionDisplayContext;
import eu.strasbourg.portlet.project.display.context.EditProjectDisplayContext;
import eu.strasbourg.portlet.project.display.context.EditSaisineObservatoireDisplayContext;
import eu.strasbourg.portlet.project.display.context.ManagementBudgetParticipatifsToolBarDisplayContext;
import eu.strasbourg.portlet.project.display.context.ManagementBudgetPhasesToolBarDisplayContext;
import eu.strasbourg.portlet.project.display.context.ManagementInitiativesToolBarDisplayContext;
import eu.strasbourg.portlet.project.display.context.ManagementParticipationsToolBarDisplayContext;
import eu.strasbourg.portlet.project.display.context.ManagementPetitionsToolBarDisplayContext;
import eu.strasbourg.portlet.project.display.context.ManagementProjectsToolBarDisplayContext;
import eu.strasbourg.portlet.project.display.context.ManagementSaisineObservatoireToolBarDisplayContext;
import eu.strasbourg.portlet.project.display.context.NavigationBarDisplayContext;
import eu.strasbourg.portlet.project.display.context.ViewBudgetParticipatifDisplayContext;
import eu.strasbourg.portlet.project.display.context.ViewBudgetPhasesDisplayContext;
import eu.strasbourg.portlet.project.display.context.ViewInitiativesDisplayContext;
import eu.strasbourg.portlet.project.display.context.ViewParticipationsDisplayContext;
import eu.strasbourg.portlet.project.display.context.ViewPetitionsDisplayContext;
import eu.strasbourg.portlet.project.display.context.ViewProjectsDisplayContext;
import eu.strasbourg.portlet.project.display.context.ViewSaisineObservatoireDisplayContext;
import eu.strasbourg.service.project.constants.ParticiperCategories;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

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
			"javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_BO,
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
		Boolean fromAjaxSaisineObservatoire = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxSaisineObservatoire"));
		Boolean fromAjaxBudgetParticipatif = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxBudgetParticipatif"));
		Boolean fromAjaxInitiative = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxInitiative"));

		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			Boolean fromAjax = fromAjaxProject || fromAjaxParticipation || fromAjaxPetition || fromAjaxSaisineObservatoire || fromAjaxBudgetParticipatif || fromAjaxInitiative;
			if(fromAjax){
				switch (navigationDC.getSelectedCmd()) {
					case EDIT_PROJECT:
						setEditProjectDisplayContext(renderRequest, renderResponse);
						break;
					case EDIT_PARTICIPATION:
						setEditParticipationDisplayContext(renderRequest, renderResponse);
						break;
					case EDIT_PETITION:
						setEditPetitionDisplayContext(renderRequest, renderResponse, themeDisplay);
						break;
					case EDIT_INITIATIVE:
						setEditInitiativeDisplayContext(renderRequest, renderResponse);
						break;
					case EDIT_BUDGET_PARICIPATIF:
						setEditBudgetParticipatifDisplayContext(renderRequest, renderResponse, navigationDC, themeDisplay);
						break;
					case EDIT_BUDGET_PHASE:
						setEditBudgetPhaseDisplayContext(renderRequest, renderResponse);
						break;
					case EDIT_SAISINE_OBSERVATOIRE:
						setEditSaisineObservatoireDisplayContext(renderRequest, renderResponse, themeDisplay);
						break;
				}
			}
			else {
				switch (navigationDC.getSelectedTab()) {
					case PROJECTS:
						if (navigationDC.getSelectedCmd().equals(EDIT_PROJECT) || navigationDC.getSelectedCmd().equals(SAVE_PROJECT) ) {
							setEditProjectDisplayContext(renderRequest, renderResponse);
						} else {
							setViewProjectsDisplayContext(renderRequest, renderResponse, servletRequest);
						}
						break;
					case PARTICIPATIONS:
						if (navigationDC.getSelectedCmd().equals(EDIT_PARTICIPATION) || navigationDC.getSelectedCmd().equals(SAVE_PARTICIPATION) ) {
							setEditParticipationDisplayContext(renderRequest, renderResponse);
						} else {
							setViewParticipationsDisplayContext(renderRequest, renderResponse, servletRequest);
						}
						break;
					case PETITIONS:
						if (navigationDC.getSelectedCmd().equals(EDIT_PETITION) || navigationDC.getSelectedCmd().equals(SAVE_PETITION) ) {
							setEditPetitionDisplayContext(renderRequest, renderResponse, themeDisplay);

						} else {
							setViewPetitionsDisplayContext(renderRequest, renderResponse, servletRequest);
						}
						break;
					case INITIATIVES:
						if (navigationDC.getSelectedCmd().equals(EDIT_INITIATIVE) || navigationDC.getSelectedCmd().equals(SAVE_INITIATIVE) ) {
							setEditInitiativeDisplayContext(renderRequest, renderResponse);
						} else {
							setViewInitiativesDisplayContext(renderRequest, renderResponse, servletRequest);
						}
						break;
					case BUDGET_PARICIPATIFS:
						if (navigationDC.getSelectedCmd().equals(EDIT_BUDGET_PARICIPATIF)
								|| navigationDC.getSelectedCmd().equals(SAVE_BUDGET_PARICIPATIF)) {
							setEditBudgetParticipatifDisplayContext(renderRequest, renderResponse, navigationDC, themeDisplay);
						} else {
							setViewBudgetParticipatifDisplayContext(renderRequest, renderResponse, servletRequest);
						}
						break;
					case BUDGET_PHASES:
						if (navigationDC.getSelectedCmd().equals(EDIT_BUDGET_PHASE) || navigationDC.getSelectedCmd().equals(SAVE_BUDGET_PHASE)) {
							setEditBudgetPhaseDisplayContext(renderRequest, renderResponse);
						} else {
							setViewBudgetPhasesDisplayContext(renderRequest, renderResponse, servletRequest);
						}
						break;
					case SAISINE_OBSERVATOIRE:
						if (navigationDC.getSelectedCmd().equals(EDIT_SAISINE_OBSERVATOIRE) || navigationDC.getSelectedCmd().equals(SAVE_SAISINE_OBSERVATOIRE)) {
							setEditSaisineObservatoireDisplayContext(renderRequest, renderResponse, themeDisplay);
						} else {
							setViewSaisineObservatoireDisplayContext(renderRequest, renderResponse, servletRequest);
						}
						break;

				}
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

	public void setEditProjectDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {
		EditProjectDisplayContext dc = new EditProjectDisplayContext(renderRequest, renderResponse);
		renderRequest.setAttribute("dc", dc);
	}

	public void setViewProjectsDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, HttpServletRequest servletRequest) throws PortalException {
		ViewProjectsDisplayContext dc = new ViewProjectsDisplayContext(renderRequest, renderResponse);
		ManagementProjectsToolBarDisplayContext managementDC = new ManagementProjectsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
				(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
		renderRequest.setAttribute("dc", dc);
		renderRequest.setAttribute("managementDC", managementDC);
	}

	public void setEditParticipationDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {
		EditParticipationDisplayContext dc = new EditParticipationDisplayContext(renderRequest, renderResponse);
		renderRequest.setAttribute("dc", dc);
	}

	public void setViewParticipationsDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, HttpServletRequest servletRequest) throws PortalException {
		ViewParticipationsDisplayContext dc = new ViewParticipationsDisplayContext(renderRequest, renderResponse);
		ManagementParticipationsToolBarDisplayContext managementDC = new ManagementParticipationsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
				(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
		renderRequest.setAttribute("dc", dc);
		renderRequest.setAttribute("managementDC", managementDC);
	}

	public void setEditPetitionDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, ThemeDisplay themeDisplay) {
		EditPetitionDisplayContext dc = new EditPetitionDisplayContext(renderRequest, renderResponse);
		String signatureNumber = Integer.toString((int) themeDisplay.getSiteGroup().getExpandoBridge().getAttribute("number_of_signatures_required_per_petition"));
		renderRequest.setAttribute("signatureNumber", signatureNumber);
		renderRequest.setAttribute("dc", dc);
	}

	public void setViewPetitionsDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, HttpServletRequest servletRequest) throws PortalException {
		ViewPetitionsDisplayContext dc = new ViewPetitionsDisplayContext(renderRequest, renderResponse);
		ManagementPetitionsToolBarDisplayContext managementDC = new ManagementPetitionsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
				(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
		renderRequest.setAttribute("dc", dc);
		renderRequest.setAttribute("managementDC", managementDC);
	}

	public void setEditInitiativeDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {
		EditInitiativeDisplayContext dc = new EditInitiativeDisplayContext(renderRequest, renderResponse);
		renderRequest.setAttribute("dc", dc);
	}

	public void setViewInitiativesDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, HttpServletRequest servletRequest) throws PortalException {
		ViewInitiativesDisplayContext dc = new ViewInitiativesDisplayContext(renderRequest, renderResponse);
		ManagementInitiativesToolBarDisplayContext managementDC = new ManagementInitiativesToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
				(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
		renderRequest.setAttribute("dc", dc);
		renderRequest.setAttribute("managementDC", managementDC);
	}

	public void setEditBudgetParticipatifDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, NavigationBarDisplayContext navigationDC, ThemeDisplay themeDisplay) {
		EditBudgetParticipatifDisplayContext dc = new EditBudgetParticipatifDisplayContext(renderRequest, renderResponse);

		//On initialise le BP avec la catégorie de la phase en cours, la catégorie et la phase en cours et la catégorie statut depose
		if (navigationDC.getSelectedCmd().equals(SAVE_BUDGET_PARICIPATIF)) {
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
	}

	public void setViewBudgetParticipatifDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, HttpServletRequest servletRequest) throws PortalException {
		ViewBudgetParticipatifDisplayContext dc = new ViewBudgetParticipatifDisplayContext(renderRequest, renderResponse);
		ManagementBudgetParticipatifsToolBarDisplayContext managementDC = new ManagementBudgetParticipatifsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
				(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
		renderRequest.setAttribute("dc", dc);
		renderRequest.setAttribute("managementDC", managementDC);
	}

	public void setEditBudgetPhaseDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {
		EditBudgetPhaseDisplayContext dc = new EditBudgetPhaseDisplayContext(renderRequest, renderResponse);
		renderRequest.setAttribute("dc", dc);
	}

	public void setViewBudgetPhasesDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, HttpServletRequest servletRequest) throws PortalException {
		ViewBudgetPhasesDisplayContext dc = new ViewBudgetPhasesDisplayContext(renderRequest, renderResponse);
		ManagementBudgetPhasesToolBarDisplayContext managementDC = new ManagementBudgetPhasesToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
				(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
		renderRequest.setAttribute("dc", dc);
		renderRequest.setAttribute("managementDC", managementDC);
	}

	public void setEditSaisineObservatoireDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, ThemeDisplay themeDisplay) {
		EditSaisineObservatoireDisplayContext dc = new EditSaisineObservatoireDisplayContext(renderRequest, renderResponse);
		String signatureNumber = Integer.toString((int) themeDisplay.getSiteGroup().getExpandoBridge().getAttribute("number_of_signatures_required_per_petition"));
		renderRequest.setAttribute("signatureNumber", signatureNumber);
		renderRequest.setAttribute("dc", dc);
	}

	public void setViewSaisineObservatoireDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse, HttpServletRequest servletRequest) throws PortalException {
		ViewSaisineObservatoireDisplayContext dc = new ViewSaisineObservatoireDisplayContext(renderRequest, renderResponse);
		ManagementSaisineObservatoireToolBarDisplayContext managementDC = new ManagementSaisineObservatoireToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
				(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
		renderRequest.setAttribute("dc", dc);
		renderRequest.setAttribute("managementDC", managementDC);
	}


}