package eu.strasbourg.liferay.updater;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
    private final Log log = LogFactoryUtil.getLog(SitesUpdater.class.getName());

    @Activate
    private void activate() {
        long startTime = System.nanoTime();
        // TODO add variable in portal-ext.properties to enable/disable this
        long defaultCompanyId = PortalUtil.getDefaultCompanyId();
        List<Group> groups = groupLocalService.getGroups(defaultCompanyId,-1,true);
        for (Group group : groups) {
             siteUpdater.updateSite(group.getFriendlyURL(), this.getClass());
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000_000;
        this.log.info("update all sites : " + duration + "s");
    }

}