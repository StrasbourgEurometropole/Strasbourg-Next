package eu.strasbourg.portlet.news_home.configuration;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Component(
        configurationPid = "eu.strasbourg.portlet.news_home.configuration.NewsHomeConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.NEWSHOME   },
        service = ConfigurationAction.class)
public class NewsHomeConfigurationAction
        extends DefaultConfigurationAction {


    /**
     * Sauvegarde les informations entrées par l'utilisateur dans le formulaire de configuration
     * @param portletConfig
     * @param request
     * @param response
     * @throws Exception
     * @see DefaultConfigurationAction#processAction(PortletConfig, ActionRequest, ActionResponse)
     * @note on transforme les classPKs en String pour pouvoir les stocker dans le portlet preferences
     */
    @Override
    public void processAction(PortletConfig portletConfig,
                              ActionRequest request, ActionResponse response) throws Exception {
        String cmd = ParamUtil.getString(request, "cmd");
        if (cmd.equals("update")) {

            // Collect selected classPKs using StringJoiner
            StringJoiner classPKsString = new StringJoiner(",");
            for (int i = 1; i < 12; i++) {
                String classPK = ParamUtil.getString(request, "classPK_" + i);
                if (Validator.isNotNull(classPK)) {
                    classPKsString.add(classPK);
                }
                else {
                    classPKsString.add("");
                }
            }
            setPreference(request, "classPKs", classPKsString.toString());

            // Set the preference for the link
            String link = ParamUtil.getString(request, "link");
            setPreference(request, "link", link);
        }
        super.processAction(portletConfig, request, response);
    }


    /**
     * Envoie à la JSP de configuration des informations nécessaires à son affichage
     * @param portletConfig
     * @param request
     * @param response
     * @throws Exception
     * @see DefaultConfigurationAction#include(PortletConfig, HttpServletRequest, HttpServletResponse)
     * @note On transforme les classPKs en liste pour pouvoir les afficher dans le formulaire
     */
    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) request
                    .getAttribute(WebKeys.THEME_DISPLAY);

            NewsHomeConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(NewsHomeConfiguration.class, themeDisplay);

            List<String> classPKsList = Arrays.asList(configuration.classPKs().split(",", -1));

            request.setAttribute("classPKs", classPKsList);

            // Lien vers toutes les actus
            String link = ParamUtil.getString(request,
                    "link", configuration.link());
            request.setAttribute("link", link);

        } catch (ConfigurationException e) {
            _log.error("An error occurred while processing the configuration.", e);
        }
        super.include(portletConfig, request, response);
    }


    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
