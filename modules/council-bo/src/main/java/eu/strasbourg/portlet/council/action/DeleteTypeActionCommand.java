package eu.strasbourg.portlet.council.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import eu.strasbourg.service.council.service.TypeLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO,
                "mvc.command.name=deleteType"
        },
        service = MVCActionCommand.class
)
public class DeleteTypeActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
        long typeId = ParamUtil.getLong(request, "typeId");

        // On vérifi qu'il n'y a pas de conseil lié à ce type
        if(!this.typeLocalService.hasCouncil(typeId)){
            // Suppression de l'entité
            this.typeLocalService.removeType(typeId);
        }else{
            SessionErrors.add(request, "type-has-council-error");
        }

        response.sendRedirect(ParamUtil.getString(request, "backURL"));
    }

    @Reference(unbind = "-")
    protected void setTypLocalService(TypeLocalService typeLocalService) {
        this.typeLocalService = typeLocalService;
    }

    private TypeLocalService typeLocalService;

}
