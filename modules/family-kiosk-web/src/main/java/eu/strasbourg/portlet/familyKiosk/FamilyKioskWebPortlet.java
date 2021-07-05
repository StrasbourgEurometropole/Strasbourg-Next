package eu.strasbourg.portlet.familyKiosk;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.PortletHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * @author angelique.champougny
 */
@Component(immediate = true, property = {"com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=true", "com.liferay.portlet.required-namespaced-parameters=false",
		"javax.portlet.display-name=Kiosque famille", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/family-kiosk-view.jsp",
		"com.liferay.portlet.render-weight=0",
		"javax.portlet.init-param.config-template=/configuration/family-kiosk-configuration.jsp",
		"javax.portlet.name=" + StrasbourgPortletKeys.FAMILY_KIOSK_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"}, service = Portlet.class)
public class FamilyKioskWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse response) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		FamilyKioskDisplayContext dc = new FamilyKioskDisplayContext(themeDisplay);
		String publikInternalId = dc.getPublikID(renderRequest);
		String template = "";
		try {
			FamilyKioskResponse familyKiosk = FamilyKioskWebService.getResponse(publikInternalId, renderRequest);

			if (Validator.isNull(familyKiosk)) {
				// erreur technique
				template = "etape0";
				renderRequest.setAttribute("error", LanguageUtil.get(Locale.FRANCE, "eu.webservice-indispo"));
			} else {
				if (familyKiosk.getCodeRetour() == 1) {
					// erreur
					template = "etape0";
					renderRequest.setAttribute("error", familyKiosk.getErreurDescription());
				} else {
					/*if (familyKiosk.getCount() == 0) {
						// pas de comptes liés
						template = "etape0";
					} else {*/
						dc.setFamilyKiosk(familyKiosk);
						template = "etape1";
//					}
				}
			}
		} catch (Exception e) {
			// erreur technique
			template = "etape0";
			renderRequest.setAttribute("error", LanguageUtil.get(Locale.FRANCE, "eu.webservice-indispo"));
		}
		renderRequest.setAttribute("dc", dc);

		// titre personnalisable
		renderRequest.setAttribute("title", PortletHelper.getPortletTitle("my-family-kiosk", renderRequest));

		include("/templates/" + template + ".jsp", renderRequest, response);
	}
}