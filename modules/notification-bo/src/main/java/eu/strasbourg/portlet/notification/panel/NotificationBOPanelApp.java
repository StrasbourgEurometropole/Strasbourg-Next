package eu.strasbourg.portlet.notification.panel;

import org.osgi.service.component.annotations.Component;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;

import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
    immediate = true,
    property = {
        "panel.app.order:Integer=299",
    	"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
    },
    service = PanelApp.class
)
public class NotificationBOPanelApp extends BasePanelApp {
	@Override
	public String getPortletId() {
		return StrasbourgPortletKeys.NOTIFICATION_BO;
	}
}