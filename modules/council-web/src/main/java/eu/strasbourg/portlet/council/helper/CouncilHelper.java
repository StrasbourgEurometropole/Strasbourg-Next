package eu.strasbourg.portlet.council.helper;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.service.OfficialLocalServiceUtil;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

public class CouncilHelper {


    public static long getOfficialId(PortletRequest request) {

        long officialId = 0;
        Official official = getOfficialFromPublikMail(request);

        if (official != null) {
            officialId = official.getOfficialId();
        }

        return officialId;
    }

    public static Official getOfficialFromPublikMail(PortletRequest request) {

        String publikMail = getPublikEmail(request);
        return OfficialLocalServiceUtil.findByEmail(publikMail);
    }

    public static String getPublikEmail(PortletRequest request) {
        LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(request);
        HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();
        return SessionParamUtil.getString(originalRequest, "publik_email");
    }
}
