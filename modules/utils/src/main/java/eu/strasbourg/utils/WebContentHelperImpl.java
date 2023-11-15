package eu.strasbourg.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.utils.api.WebContentHelperService;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {},
        service = WebContentHelperService.class)
public class WebContentHelperImpl implements WebContentHelperService {


    @Override
    public String getLinkToPageUrl(String linkToPageStructure, ThemeDisplay themeDisplay) {
        return WebContentHelper.getLinkToPageUrl(linkToPageStructure,themeDisplay);
    }

    @Override
    public Layout getLinkToPageLayout(String linkToPageStructure) throws PortalException {
        return WebContentHelper.getLinkToPageLayout(linkToPageStructure);
    }
}

