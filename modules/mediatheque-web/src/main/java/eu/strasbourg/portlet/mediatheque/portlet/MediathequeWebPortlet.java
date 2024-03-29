package eu.strasbourg.portlet.mediatheque.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import eu.strasbourg.portlet.mediatheque.constants.CodeErreurMediathequeConstants;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.portlet.mediatheque.borrower.BorrowerResponse;
import eu.strasbourg.portlet.mediatheque.borrower.BorrowerWebService;
import eu.strasbourg.utils.PortletHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

/**
 * @author angelique.champougny
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=true", "com.liferay.portlet.required-namespaced-parameters=false",
		"com.liferay.portlet.render-weight=0",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/mediatheque-view.jsp",
		"javax.portlet.init-param.config-template=/configuration/mediatheque-configuration.jsp", "javax.portlet.display-name=Mediatheque",
		"javax.portlet.name=" + StrasbourgPortletKeys.MEDIATHEQUE_WEB, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MediathequeWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		MediathequeDisplayContext dc = new MediathequeDisplayContext(themeDisplay);
		String publikInternalId = dc.getPublikID(request);

		BorrowerResponse borrower = BorrowerWebService.getResponse(publikInternalId);
		String template = "";

		if (Validator.isNull(borrower)) {
			// erreur technique -> TECHNIQUE
			template = "etape0";
			request.setAttribute("error", "");
		} else {
			dc.setBorrower(borrower);

			// si l'utilisateur a activé son lien
			if (Validator.isNull(borrower.getCode_erreur()) && (Validator.isNull(borrower.getErr()) || borrower.getErr().equals("0"))) {
				template = "etape4";
			} else {
				if (Validator.isNull(borrower.getCode_erreur())) {
					// erreur technique -> TECHNIQUE
					template = "etape0";
					request.setAttribute("error", "");
				} else {
					switch (borrower.getCode_erreur()) {
					case CodeErreurMediathequeConstants.AUCUNE_ASSOCIATION:
						// Aucune association trouvée
						template = "etape1";
						break;
					case CodeErreurMediathequeConstants.DELAI_DEPASSE:
						// le compte n'a pas été activé dans le temps imparti
						template = "etape1";
						break;
					case CodeErreurMediathequeConstants.ASSOCIATION_A_VALIDER:
						// si l'utilisateur n'a pas activé son lien
						template = "etape2C";
						break;
					case CodeErreurMediathequeConstants.AUCUN_EMAIL:
						// son email n'est pas renseigné
						template = "etape2B";
						break;
					case CodeErreurMediathequeConstants.AUCUNE_CARTE:
						// le numéro de carte n'existe pas
						template = "etape1";
						request.setAttribute("error", borrower.getErreur());
						break;
					case CodeErreurMediathequeConstants.ASSOCIATION_SUPPRIMEE:
						// Une association a été supprimée
						template = "etape1";
						request.setAttribute("error", borrower.getErreur());
						break;
					default:
						// erreur technique -> TECHNIQUE
						template = "etape0";
						request.setAttribute("error", borrower.getErreur());
						break;
					}
				}
			}
		}

		if (template.equals("etape1") || template.equals("etape2C")) {
			String link = ParamUtil.getString(request, "link");
			if (link.equals("lier")) {
				template = dc.link(request, response);
			}
		}

		if (template.equals("etape4")) {
			String dissocier = ParamUtil.getString(request, "dissociate");
			if (dissocier.equals("dissocier")) {
				template = dc.dissociate(request, response);
			}
		}
		request.setAttribute("dc", dc);
		
		// titre personnalisable
		request.setAttribute("title", PortletHelper.getPortletTitle("account-mediatheque", request));

		include("/templates/" + template + ".jsp", request, response);
	}

}