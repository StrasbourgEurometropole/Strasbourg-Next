package eu.strasbourg.portlet.project.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import eu.strasbourg.service.office.exporter.api.BudgetPhaseSupportsXlsxExporter;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_BO,
		"mvc.command.name=exportBudgetPhaseSupportsXlsx"
	},
	service = MVCResourceCommand.class
)
public class ExportBudgetPhaseSupportsToXlsxResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		resourceResponse.setContentType("application/force-download");
		resourceResponse.setProperty("content-disposition", "attachment; filename=Soutiens.xlsx");
		Long budgetPhaseId = ParamUtil.getLong(resourceRequest, "budgetPhaseId");
		
		try {
			_budgetPhaseSupportsXlsxExporter.exportBudgetPhaseSupports(resourceResponse.getPortletOutputStream(), budgetPhaseId);
			resourceResponse.getPortletOutputStream().flush();
		} catch (IOException e) {
			_log.error("Probleme lors de l'écriture en fichier : ", e);
		}
		
		return true;
	}
	
	private BudgetPhaseSupportsXlsxExporter _budgetPhaseSupportsXlsxExporter;
	
    @Reference(unbind = "-")
    public void setBudgetPhaseSupportsXlsxExporter(BudgetPhaseSupportsXlsxExporter budgetPhaseSupportsXlsxExporter) {
        this._budgetPhaseSupportsXlsxExporter = budgetPhaseSupportsXlsxExporter;
    }
    
    /**
	 * le log
	 */
	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
