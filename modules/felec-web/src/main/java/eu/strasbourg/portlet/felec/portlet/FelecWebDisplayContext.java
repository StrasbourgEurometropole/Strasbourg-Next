package eu.strasbourg.portlet.felec.portlet;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.utils.display.context.BaseDisplayContext;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class FelecWebDisplayContext extends BaseDisplayContext {

    private RenderRequest request;

    /**
     * Constructeur
     * @param request
     * @param response
     */
        public FelecWebDisplayContext(RenderRequest request, RenderResponse response) {
            super(request, response);
            this.request = request;
        }



}
