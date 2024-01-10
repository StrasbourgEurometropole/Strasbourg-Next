package eu.strasbourg.liferay.updater;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.utils.SiteUpdater;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component
public class SitesUpdater {
    @Reference private SiteUpdater siteUpdater;
    @Reference private GroupLocalService groupLocalService;

    @Activate
    private void activate() {
        // TODO add variable in portal-ext.properties to enable/disable this
        long defaultCompanyId = PortalUtil.getDefaultCompanyId();
        List<Group> groups = groupLocalService.getGroups(defaultCompanyId,0,true);
        for (Group group : groups) {
             siteUpdater.updateSite(group.getFriendlyURL(), this.getClass());
        }
    }

}