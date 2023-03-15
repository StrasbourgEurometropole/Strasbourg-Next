package eu.strasbourg.utils;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;
import java.util.TreeMap;

public class PortalHelper {

    public static String getHomeURL(ThemeDisplay themeDisplay) {
        String home = "";
        TreeMap<String, String> virtualHostNames = themeDisplay.getScopeGroup().getPublicLayoutSet().getVirtualHostnames();
        String virtualHostName = virtualHostNames.entrySet().stream()
                .filter(entry -> themeDisplay.getLanguageId().equals(entry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);
        boolean stagingGroup = themeDisplay.getScopeGroup().isStagingGroup();
        if(Validator.isNotNull(virtualHostName) && ! stagingGroup)
            home = "";
        else {
            home = "/web" + themeDisplay.getLayout().getGroup().getFriendlyURL();
        }
        return home;
    }

    public static String getPortalURL(ThemeDisplay themeDisplay)  {
        String home = "";
        try {
            TreeMap<String, String> virtualHostNames = themeDisplay.getScopeGroup().getPublicLayoutSet().getVirtualHostnames();
            String virtualHostName = virtualHostNames.entrySet().stream()
                    .filter(entry -> themeDisplay.getLanguageId().equals(entry.getValue()))
                    .findFirst().map(Map.Entry::getKey)
                    .orElse(null);
            boolean stagingGroup = themeDisplay.getScopeGroup().isStagingGroup();
            if (Validator.isNotNull(virtualHostName) && !stagingGroup) {
                home = "https://"+virtualHostName;
            } else {
                home = PortalUtil.getPortalURL(themeDisplay);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return home;
    }
}
