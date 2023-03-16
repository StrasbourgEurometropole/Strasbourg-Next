package eu.strasbourg.utils;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;
import java.util.TreeMap;

public class PortalHelper {

    public static String getHomeURL(ThemeDisplay themeDisplay) {
        String home = "";
        String virtualHostName = getVirtualHostname(themeDisplay.getScopeGroup(), themeDisplay.getLanguageId());
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
            String virtualHostName = getVirtualHostname(themeDisplay.getScopeGroup(), themeDisplay.getLanguageId());
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

    public static String getVirtualHostname(Group group, String languageId)  {
        String virtualHostName = null;
        try {
            TreeMap<String, String> virtualHostNames = group.getPublicLayoutSet().getVirtualHostnames();
            virtualHostName = virtualHostNames.entrySet().stream()
                    .filter(entry -> languageId.equals(entry.getValue()) || "".equals(entry.getValue()))
                    .findFirst().map(Map.Entry::getKey)
                    .orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return virtualHostName;
    }
}
