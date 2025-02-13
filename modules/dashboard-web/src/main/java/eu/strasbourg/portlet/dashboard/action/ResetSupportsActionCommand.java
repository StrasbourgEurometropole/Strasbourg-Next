package eu.strasbourg.portlet.dashboard.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.dashboard.portlet.DashboardPortlet;
import eu.strasbourg.portlet.dashboard.utils.DashBoardUtils;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.model.BudgetSupport;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalServiceUtil;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.service.project.service.BudgetSupportLocalServiceUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.List;

/**
 * @author AZC
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.DASHBOARD_WEB,
                "mvc.command.name=resetSupports"
        },
        service = MVCActionCommand.class
)
public class ResetSupportsActionCommand implements MVCActionCommand {

    /**
     * le log
     */
    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        String action = ParamUtil.getString(request, "cmd");
        // Recuperation de l'URL de redirection
        String redirectURL = ParamUtil.getString(request, DashboardPortlet.REDIRECT_URL_PARAM);
        String publikID = DashBoardUtils.getPublikID(request);
        boolean result = false;
        if ("resetSupports".equals(action)) {
            if (publikID == null || publikID.isEmpty())
                throw new PortletException("veuillez vous identifier/enregistrer");

            // récupération de la phase active
            BudgetPhase activePhase  = BudgetPhaseLocalServiceUtil.getActivePhase(themeDisplay.getScopeGroupId());
            if(Validator.isNotNull(activePhase)) {
                // récupération des votes de l'utilisateur
                List<BudgetSupport> budgetSupports = BudgetSupportLocalServiceUtil.getBudgetSupportByPublikId(publikID);
                // Recuperation de budgets correspondants
                for (BudgetSupport budgetSupport : budgetSupports) {
                    BudgetParticipatif budgetParticipatif = BudgetParticipatifLocalServiceUtil.fetchBudgetParticipatif(budgetSupport.getBudgetParticipatifId());
                    // s'il fait partie de la phase active, on supprime
                    if(Validator.isNotNull(budgetParticipatif) && budgetParticipatif.getPhase().getBudgetPhaseId() == activePhase.getBudgetPhaseId()){
                        BudgetSupportLocalServiceUtil.removeBudgetSupport(budgetSupport.getBudgetSupportId());
                    }
                }
            }

            try {
                response.sendRedirect(redirectURL);
            } catch (IOException e) {
                _log.error("erreur de redirection dans save profil : ", e);
                throw new PortletException(e);
            }

        }
        return result;
    }

}
