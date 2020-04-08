package eu.strasbourg.portlet.gtfs.panel;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;

import org.osgi.service.component.annotations.Component;

import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
    immediate = true,
    property = {
        "panel.app.order:Integer=260",
    	"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
    },
    service = PanelApp.class
)
public class GTFSBOPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return StrasbourgPortletKeys.GTFS_BO;
	}

}