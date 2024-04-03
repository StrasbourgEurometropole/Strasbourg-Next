package eu.strasbourg.utils.api;

import com.liferay.portal.kernel.theme.ThemeDisplay;

public interface PortalHelperService {

    /**
     * Retourne HomeURL
     */
    String getHomeURL(ThemeDisplay themeDisplay);

    /**
     * Retourne HomeURL
     */
    String getHomeURL(ThemeDisplay themeDisplay, String suffix);

    /**
     * Retourne PortalURL
     */
    String getPortalURL(ThemeDisplay themeDisplay);

}
