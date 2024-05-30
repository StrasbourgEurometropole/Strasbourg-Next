package eu.strasbourg.portlet.council.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import eu.strasbourg.service.council.service.CouncilSessionLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO,
                "mvc.command.name=deleteCouncilSession"
        },
        service = MVCActionCommand.class
)
public class DeleteCouncilSessionActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {

        long councilSessionId = ParamUtil.getLong(request, "councilSessionId");

        // On vérifi qu'il n'y a pas de délib lié à ce conseil
        if(!this.councilSessionLocalService.hasDelib(councilSessionId)){
            // Suppression de l'entité
            this.councilSessionLocalService.removeCouncilSession(councilSessionId);
        }else{
            SessionErrors.add(request, "council-has-delib-error");
        }

        response.sendRedirect(ParamUtil.getString(request, "backURL"));
    }

    @Reference(unbind = "-")
    protected void setCouncilSessionLocalService(CouncilSessionLocalService councilSessionLocalService) {
        this.councilSessionLocalService = councilSessionLocalService;
    }

    private CouncilSessionLocalService councilSessionLocalService;

}
