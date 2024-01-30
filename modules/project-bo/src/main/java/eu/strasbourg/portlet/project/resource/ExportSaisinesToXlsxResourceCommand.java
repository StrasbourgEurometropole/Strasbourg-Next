package eu.strasbourg.portlet.project.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import eu.strasbourg.service.office.exporter.api.SaisinesXlsxExporter;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

/**
 * @author AZC
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_BO,
        "mvc.command.name=exportSaisinesXlsx"
        },
        service = MVCResourceCommand.class)
public class ExportSaisinesToXlsxResourceCommand implements MVCResourceCommand {

    private SaisinesXlsxExporter saisinesXlsxExporter;

    @Reference(unbind = "-")
    public void setSaisinesXlsxExporter(SaisinesXlsxExporter saisinesXlsxExporter) {
        this.saisinesXlsxExporter = saisinesXlsxExporter;
    }

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        resourceResponse.setContentType("application/force-download");
        resourceResponse.setProperty("content-disposition","attachment; filename=Saisines observatoires.xlsx");
        try {
            saisinesXlsxExporter.exportSaisines(resourceResponse.getPortletOutputStream());
            resourceResponse.getPortletOutputStream().flush();
        } catch (IOException e) {
            _log.error(e.getMessage(), e);
        }
        return true;
    }

    private Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
