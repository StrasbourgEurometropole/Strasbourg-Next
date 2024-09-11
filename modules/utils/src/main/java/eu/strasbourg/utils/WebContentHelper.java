package eu.strasbourg.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

public class WebContentHelper {

    private static final Log _log = LogFactoryUtil.getLog("WebContentHelper");

    /*
     * Récupère l'Url d'une page à partir de la donnée récupérée d'une structure dans un ADT
     * Celle ci se présente sous la forme : XX@public@XXXX pré 7.3 fp1
     * Celle ci se présente sous la forme d'un JSON post 7.3 fp1
     */
    public static String getLinkToPageUrl(String linkToPageStructure, ThemeDisplay themeDisplay) {
        if (Validator.isNull(linkToPageStructure)) {
            return "";
        }
        // On récupère la friendlyURL à partir des données récoltées
        try {
            Layout page = getLinkToPageLayout(linkToPageStructure);
            return PortalUtil.getLayoutFriendlyURL(page, themeDisplay, themeDisplay.getLocale());
        } catch (PortalException e) {
            _log.error("Une erreur est survenue lors de la récupération de l'URL d'un LinkToPage : ", e);
        }
        return "";
    }

    public static Layout getLinkToPageLayout(String linkToPageStructure) throws PortalException {
        long linkPageId = 0;
        boolean linkPrivate = false;
        long linkGroupId = 0;
        // Soit on arrive à le parser et dans ce cas c'est le JSON post 7.3FP1
        // SOit on est dans le pré 7.3FP1 et on utilise le split
        try {
            JSONObject json = JSONFactoryUtil.createJSONObject(linkToPageStructure);
            linkPageId = json.getLong("layoutId");
            linkGroupId = json.getLong("groupId");
            linkPrivate = json.getBoolean("privateLayout");
        } catch (JSONException e) {
            String[] linkToPageSplit = linkToPageStructure.split("@");
            // On récupère les différentes informations à partir de la string fournie (XX@public@XXXXX)
            for (int i = 0; i < linkToPageSplit.length; i++) {
                if (i == 0) {
                    linkPageId = GetterUtil.getLong(linkToPageSplit[i]);
                } else if (i == 1) {
                    if (linkToPageSplit[i].equals("private-group")) {
                        linkPrivate = true;
                    } else {
                        linkPrivate = false;
                    }
                } else if (i == 2) {
                    linkGroupId = GetterUtil.getLong(linkToPageSplit[i]);
                }
            }
        }
        Layout page = LayoutLocalServiceUtil.getLayout(linkGroupId, linkPrivate, linkPageId);
        return page;
    }
}


