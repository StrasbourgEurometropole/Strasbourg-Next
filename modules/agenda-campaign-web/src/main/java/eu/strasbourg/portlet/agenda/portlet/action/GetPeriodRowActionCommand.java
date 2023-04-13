package eu.strasbourg.portlet.agenda.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
	immediate = true,
	property = { "javax.portlet.name=" + StrasbourgPortletKeys.CAMPAIGN_WEB,
		"mvc.command.name=getPeriodRow" },
	service = MVCActionCommand.class)
public class GetPeriodRowActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {
		request.setAttribute("fromAjax", true);
		return true;
	}
}