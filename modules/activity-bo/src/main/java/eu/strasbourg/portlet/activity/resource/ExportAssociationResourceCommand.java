package eu.strasbourg.portlet.activity.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import eu.strasbourg.portlet.activity.utils.PrintCSV;
import eu.strasbourg.utils.ZipHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_BO,
                "mvc.command.name=export"
        },
        service = MVCResourceCommand.class
)
public class ExportAssociationResourceCommand implements MVCResourceCommand {

    /** Log */
    private final Log log = LogFactoryUtil.getLog(this.getClass().getName());

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {
        try {
            String repository = PrintCSV.printCSVs();

            // Définition d'un téléchargement dans le content-type
            response.setContentType("application/force-download");

            String zipFileName = "Export_associations_practices";
            response.setProperty("content-disposition","attachment; filename=" + zipFileName + ".zip");

            try {
                // Récupération de l'ouputStream de la réponse et création du zipOutputStream
                OutputStream os = response.getPortletOutputStream();

                ZipHelper.zipDirectoryinOutputStream(repository, os);

                os.flush();

                // Fermeture des outputStreams
                os.close();

            } catch (IOException e) {
                this.log.error("Une erreur est survenu lors de l'extraction des associations", e);
            }
        } catch (IOException e) {
            _log.error(e.getMessage());
        } catch (Exception e) {
            _log.error(e.getMessage());
        }

        return false;
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass());

}
