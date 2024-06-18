package eu.strasbourg.portlet.council.panel;

import com.liferay.application.list.constants.PanelCategoryKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;

import com.liferay.portal.kernel.model.Portlet;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"panel.app.order:Integer=403",
				"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
		},
		service = PanelApp.class
)
public class CouncilBOPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return StrasbourgPortletKeys.COUNCIL_BO;
	}

	@Override
	public Portlet getPortlet() {
		return _portlet;
	}

	@Reference(
			target = "(javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO + ")"
	)
	private Portlet _portlet;

}