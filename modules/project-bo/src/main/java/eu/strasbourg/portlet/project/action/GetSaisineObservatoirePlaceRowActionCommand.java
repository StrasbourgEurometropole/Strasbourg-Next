package eu.strasbourg.portlet.project.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

/**
 * @author Joshua Chacha
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_BO,
                "mvc.command.name=getSaisineObservatoirePlaceRow"
        },
        service = MVCActionCommand.class
)
public class GetSaisineObservatoirePlaceRowActionCommand implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        actionRequest.setAttribute("fromAjaxSaisineObservatoire",true);
        return true;
    }
}
