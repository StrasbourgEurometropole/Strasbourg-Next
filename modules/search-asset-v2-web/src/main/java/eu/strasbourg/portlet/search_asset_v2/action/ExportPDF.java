package eu.strasbourg.portlet.search_asset_v2.action;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.search_asset_v2.constants.OfficialsConstants;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.official.service.OfficialLocalServiceUtil;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class ExportPDF {

	public static String domaine = "http://localhost:8080";

	public static void printPDF(ResourceRequest req, ResourceResponse res, String exportType, String officialsIds)
			throws SystemException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		String title = null;
		boolean isEMS = false;
		if(exportType.equals(OfficialsConstants.EUROMETROPOLE)) {
			title = LanguageUtil.get(locale,
					"entete-annuaire-elus-municipaux-print");
			isEMS = true;
		}else
			title = LanguageUtil.get(locale,
					"entete-annuaire-elus-communautaires-print");
		List<Official> officials = getPeopleList(officialsIds);

		try {
			//Chargement du template contenant le corps du mail
			TemplateResource templateResource = new URLTemplateResource("0",
				Objects.requireNonNull(ExportPDF.class.getClassLoader()
						.getResource("/templates/officials.ftl")));
            Template template = TemplateManagerUtil.getTemplate(
                    TemplateConstants.LANG_TYPE_FTL, templateResource, false);

			// récupération des données
			Map<String, Object> context = new HashMap<>();
			context.put("domaine", domaine);
			context.put("locale", locale);
			context.put("title", title);
			context.put("isEMS",isEMS);
			context.put("officials", officials);
			context.put("commune", LanguageUtil.get(locale, "de-la-commune"));
			context.put("charge", LanguageUtil.get(locale, "en-charge-de"));
			context.put("adjoint", LanguageUtil.get(locale, "adjoint-de-quartier"));
			context.put("groupe", LanguageUtil.get(locale, "groupe-politique"));
			context.put("footerTitle",LanguageUtil.get(locale, "footer-title"));
			context.put("footerContent", LanguageUtil.get(locale, "footer-content"));

			// Traitement du template
			StringWriter out = new StringWriter();
			template.putAll(context);
			template.processTemplate(out);

			try (OutputStream outputStream = baos) {
				ITextRenderer renderer = new ITextRenderer();
				renderer.setDocumentFromString(out.toString());
				renderer.layout();
				renderer.createPDF(outputStream);

				// ouverture du PDF dans le navigateur
				HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
				response.setContentType("application/pdf");
				response.addHeader("Content-Disposition", "inline; filename=" + title + ".pdf");
				byte[] pdfBytes = baos.toByteArray();
				response.setContentLength(pdfBytes.length);
				try (OutputStream os = res.getPortletOutputStream()) {
					os.write(pdfBytes);
				}
			} catch (IOException e) {
				_log.error(e.getMessage());
			}

        } catch (TemplateException e) {
			_log.error(e.getMessage(), e);
        }
	}

	private static List<Official> getPeopleList(String officialsIds)
			throws SystemException {

		List<Official> elus = new ArrayList<Official>();
		for (String id : officialsIds.split(",")) {
			if (Validator.isNotNull(id)) {
				elus.add(OfficialLocalServiceUtil
						.fetchOfficial(Long.parseLong(id)));
			}
		}

		return elus;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(ExportPDF.class.getName());
}
