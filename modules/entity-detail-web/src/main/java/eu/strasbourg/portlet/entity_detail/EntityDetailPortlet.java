package eu.strasbourg.portlet.entity_detail;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.entity_detail.configuration.EntityDetailConfiguration;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.PortletHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component(
		immediate = true,
		property = {
			"javax.portlet.version=3.0",
			"com.liferay.portlet.display-category=Strasbourg",
			"com.liferay.portlet.instanceable=false", "com.liferay.portlet.requires-namespaced-parameters=false",
			"com.liferay.portlet.css-class-wrapper=entity-detail-portlet",
			"com.liferay.portlet.footer-portlet-javascript=/js/entity-detail-main.js",
			"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/entity-detail-view.jsp",
			"javax.portlet.init-param.config-template=/entity-detail-configuration.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.name=" + StrasbourgPortletKeys.ENTITY_DETAIL_WEB,
			"javax.portlet.supported-public-render-parameter=message"
		},
		service = Portlet.class
)
public class EntityDetailPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		try {

			// Récupération de l'entité : soit via le paramètre classPk, soit le
			// sigId (dans le cas d'un lieu)
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			EntityDetailConfiguration configuration;
			configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(EntityDetailConfiguration.class, themeDisplay);

			Long entryId = ParamUtil.getLong(request, "classPK");
			String sigId = ParamUtil.getString(request, "sigId");
			String className = configuration.className();
			if (entryId <= 0) {
				entryId = configuration.classPK();
			}
			AssetEntry entry = null;
			if (entryId > 0) {
				entry = AssetEntryLocalServiceUtil.fetchEntry(className, entryId);
			}
			if (entry == null && Validator.isNotNull(sigId)) {
				Place place = PlaceLocalServiceUtil.getPlaceBySIGId(sigId);
				if (place != null) {
					entry = place.getAssetEntry();
				}
			}
			if (entry != null && entry.getVisible()) {
				request.setAttribute("entry", entry);
			}

			// Application display templates stuff
			PortletPreferences preferences = request.getPreferences();
			String displayStyle = GetterUtil.getString(preferences.getValue("displayStyle", StringPool.BLANK));
			long displayStyleGroupId = GetterUtil.getLong(preferences.getValue("displayStyleGroupId", null), 0);
			Map<String, Object> contextObjects = new HashMap<>();
			contextObjects.put("entry", entry != null ? entry.getAssetRenderer().getAssetObject() : null);
			request.setAttribute("entries", new ArrayList<AssetEntry>());
			request.setAttribute("displayStyle", displayStyle);
			request.setAttribute("displayStyleGroupId", displayStyleGroupId);
			request.setAttribute("contextObjects", contextObjects);
			contextObjects.put("mailSent", false);
			
			//Partage l'asset entry configurée dans la config. D'autres portlets peuvent ainsi la récupérer.
			//Pour partager une variable en session il faut préfixer le nom de la variable par LIFERAY_SHARED_
			PortletSession portletSession = request.getPortletSession();
			if (entry != null) {
				portletSession.setAttribute("LIFERAY_SHARED_assetEntryID"
						, entry != null ? entry.getEntryId() : null
						, PortletSession.APPLICATION_SCOPE);
			}

			
			if (entry != null) {
				PortalUtil.setPageTitle(entry.getTitle(themeDisplay.getLocale()),
						PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)));
				// Ajout du fil d'ariane
				PortletHelper.addBreadcrumbEntry(request, entry.getTitle(themeDisplay.getLocale()), PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), StrasbourgPortletKeys.ENTITY_DETAIL_WEB, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE));
			}

			if (entry == null) {
				HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(response);
				httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
				String journalArticleContent = "<header class=\"st-header-without-sticky st-wrapper st-wrapper-small\" role=\"banner\">\n" +
						"    <div>\n" +
						"            <h1 class=\"st-h1\">Page introuvable</h1>\n" +
						"    </div>\n" +
						"</header>";
				request.setAttribute("notFoundHTML", journalArticleContent);
			}

			
			super.render(request, response);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}