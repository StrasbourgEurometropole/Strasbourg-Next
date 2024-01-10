package eu.strasbourg.portlet.association;

import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.association.configuration.SearchAssociationConfiguration;
import eu.strasbourg.portlet.association.display.context.SearchAssociationDisplayContext;
import eu.strasbourg.service.activity.model.Association;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author angelique.champougny
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.version=3.0",
			"com.liferay.portlet.display-category=Strasbourg",
			"com.liferay.portlet.header-portlet-css=/css/search-association-main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Recherche d'association",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/search-association-view.jsp",
			"javax.portlet.init-param.config-template=/configuration/search-association-configuration.jsp",
			"javax.portlet.init-param.check-auth-token=false",
			"javax.portlet.name=" + StrasbourgPortletKeys.ASSOCIATION_SEARCH_WEB,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"}, service = Portlet.class)
public class SearchAssociationPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			this._configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(SearchAssociationConfiguration.class, themeDisplay);

			// On set le DisplayContext
			SearchAssociationDisplayContext dc = new SearchAssociationDisplayContext(request, response);
			request.setAttribute("dc", dc);

			// On envoie a la jsp la map className / layout qui fait
			// correspondre à chaque type d'asset une page de détail
			Map<String, Long> className_layoutId = new HashMap<>();
			String layoutFriendlyURL = this._configuration.layoutFriendlyURL();
			String description = this._configuration.description();
			Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
					themeDisplay.getScopeGroupId(), false,
					layoutFriendlyURL);
			if (layout != null) {
				className_layoutId.put(Association.class.getName(), layout.getPlid());
			}

			request.setAttribute("classNameLayoutId", className_layoutId);
			request.setAttribute("description", description);

			super.render(request, response);
		} catch (Exception ex) {
			log.error(ex);
		}
	}

	/**
	 * L'utilisateur a fait une recherche, on en profite pour set un attribut
	 */
	@Override
	public void processAction(ActionRequest actionRequest,
							  ActionResponse actionResponse)
			throws IOException, PortletException {

		Boolean isValid = validate(actionRequest);

		if (!isValid) {
			actionRequest.setAttribute("userSearch", false);
		}else {
			actionRequest.setAttribute("userSearch", true);
		}

		super.processAction(actionRequest, actionResponse);
	}

	private boolean validate(ActionRequest request) {
		boolean isValid = true;

		return isValid;
	}

	private Log log = LogFactoryUtil.getLog(this.getClass());

	private SearchAssociationConfiguration _configuration;
}