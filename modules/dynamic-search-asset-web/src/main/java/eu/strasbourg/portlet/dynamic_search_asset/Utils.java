package eu.strasbourg.portlet.dynamic_search_asset;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.utils.PortalHelper;

public class Utils {
    /**
     * Récupération de l'URL de base du site pour le lien vers les pages des entités
     */
    public static String getHomeURL(ThemeDisplay themeDisplay) {
        String virtualHostname= PortalHelper.getVirtualHostname(themeDisplay.getScopeGroup(),themeDisplay.getLanguageId());
        if (Validator.isNotNull(virtualHostname)
                || themeDisplay.getScopeGroup().isStagingGroup()) {
            return "/web" + themeDisplay.getLayout().getGroup().getFriendlyURL() + "/";
        } else {
            return "/";
        }
    }
}