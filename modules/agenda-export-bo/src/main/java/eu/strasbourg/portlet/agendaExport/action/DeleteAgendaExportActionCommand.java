package eu.strasbourg.portlet.agendaExport.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import eu.strasbourg.service.agenda.model.AgendaExport;
import eu.strasbourg.service.agenda.model.AgendaExportPeriod;
import eu.strasbourg.service.agenda.service.AgendaExportPeriodLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import eu.strasbourg.service.agenda.service.AgendaExportLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.AGENDA_EXPORT_BO,
                "mvc.command.name=deleteAgendaExport"
        },
        service = MVCActionCommand.class
)
public class DeleteAgendaExportActionCommand implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {

		try {
			long agendaExportId = ParamUtil.getLong(request, "agendaExportId");

			//Remove periods
			AgendaExport agendaExport = _agendaExportLocalService.getAgendaExport(agendaExportId);
			List<AgendaExportPeriod> periods = agendaExport.getAgendaExportPeriods();
			for(AgendaExportPeriod period : periods) {
				_agendaExportPeriodLocalService.deleteAgendaExportPeriod(period);
			}

			_agendaExportLocalService.removeAgendaExport(agendaExportId);
		} catch (PortalException e) {
			_log.error(e);
		}
		return true;
	}

	private AgendaExportLocalService _agendaExportLocalService;

	@Reference(unbind = "-")
	protected void setAgendaExportLocalService(
			AgendaExportLocalService agendaExportLocalService) {

		_agendaExportLocalService = agendaExportLocalService;
	}

	private AgendaExportPeriodLocalService _agendaExportPeriodLocalService;

	@Reference(unbind = "-")
	protected void setAgendaExportPeriodLocalService(AgendaExportPeriodLocalService agendaExportPeriodLocalService) {

		_agendaExportPeriodLocalService = agendaExportPeriodLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}


