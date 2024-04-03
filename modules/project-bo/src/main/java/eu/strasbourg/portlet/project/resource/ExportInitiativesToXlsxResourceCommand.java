package eu.strasbourg.portlet.project.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import eu.strasbourg.service.office.exporter.api.InitiativesXlsxExporter;
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
			"mvc.command.name=exportInitiativesXlsx"
		},
		service = MVCResourceCommand.class
	)
public class ExportInitiativesToXlsxResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		resourceResponse.setContentType("application/force-download");
        resourceResponse.setProperty("content-disposition","attachment; filename=Ateliers.xlsx");
        
        try {
        	initiativesXlsxExporter.exportInitiatives(resourceResponse.getPortletOutputStream());
            resourceResponse.getPortletOutputStream().flush();
        } catch (IOException e) {
			_log.error("probleme lors de l'extraction des Budgets participatifs : ",e);
        }
        
        return true;
	}

	private InitiativesXlsxExporter initiativesXlsxExporter;

    @Reference(unbind = "-")
    public void setInitiativesXlsxExporter(InitiativesXlsxExporter initiativesXlsxExporter) {
        this.initiativesXlsxExporter = initiativesXlsxExporter;
    }
    
    /**
	 * le log
	 */
	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}