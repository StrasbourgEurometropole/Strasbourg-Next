package eu.strasbourg.portlet.search_asset_v2.action;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlParserUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import eu.strasbourg.portlet.search_asset_v2.constants.OfficialsConstants;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.official.service.OfficialLocalServiceUtil;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExportPDF {

	public static String domaine = "http://localhost:8080";
	public static Font font = FontFactory.getFont(FontFactory.HELVETICA, 12);
	public static Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);

	public static void printPDF(ResourceRequest req, ResourceResponse res, String exportType, String officialsIds)
			throws SystemException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();

		// titre du PDF
		String titrePortlet = null;
		if(exportType.equals(OfficialsConstants.EUROMETROPOLE))
			titrePortlet = LanguageUtil.get(locale,
					"entete-annuaire-elus-municipaux-print");
		else
			titrePortlet = LanguageUtil.get(locale,
					"entete-annuaire-elus-communautaires-print");

		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			PdfWriter.getInstance(document, baos);
			document.open();
			document.setMargins(34f, 34f, 34f, 34f);

			// image d'entête
			Image img = Image.getInstance(domaine + "/o/searchassetv2web/images/bandeau.jpg");
			float newWidth = 520f;
			float newHeight = (img.getHeight() / img.getWidth()) * newWidth;
			img.scaleAbsolute(newWidth, newHeight);
			img.setSpacingAfter(5f);
			document.add(img);

			// titre du PDF
			Paragraph paragraph = new Paragraph(titrePortlet.toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20));
			paragraph.setSpacingAfter(5f);
			document.add(paragraph);

			// élus
			printPDFPeople(document, officialsIds, exportType, locale);

			// bas de page
			PdfPTable table = new PdfPTable(new float[]{22f,78f});
			table.setWidthPercentage(100f);

			PdfPCell cell = new PdfPCell();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			paragraph = new Paragraph(sdf.format(new Date()), font);
			cell.addElement(paragraph);
			cell.setPadding(0f);
			cell.setBorder(0);
			cell.setBorderWidthTop(1f);
			float[] color = Color.RGBtoHSB(151, 191, 12, null);
			cell.setBorderColorTop(Color.getHSBColor(color[0], color[1], color[2]));
			table.addCell(cell);

			cell = new PdfPCell();
			paragraph = new Paragraph(LanguageUtil.get(themeDisplay.getLocale(), "footer-title"), fontBold);
			paragraph.setAlignment(Element.ALIGN_RIGHT);
			cell.addElement(paragraph);
			Paragraph paragraph2 = new Paragraph(HtmlParserUtil.render(LanguageUtil.get(themeDisplay.getLocale(), "footer-content")), font);
			paragraph2.setAlignment(Element.ALIGN_RIGHT);
			cell.addElement(paragraph2);
			cell.setBorder(0);
			cell.setBorderWidthTop(1f);
			cell.setBorderColorTop(Color.getHSBColor(color[0], color[1], color[2]));
			cell.setPadding(0f);
			cell.setPaddingTop(1f);

			table.addCell(cell);
			document.add(table);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		document.close();

		byte[] pdfBytes = baos.toByteArray();

		getPDFFromHTML(baos, officialsIds, exportType, locale);

		// ouverture du PDF dans le navigateur
		//pdfBytes = baos.toByteArray();
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=" + titrePortlet + ".pdf");
		response.setContentLength(pdfBytes.length);
		try (OutputStream out = res.getPortletOutputStream()) {
			out.write(pdfBytes);
		}
	}

	private static void printPDFPeople(Document document, String officialsIds, String exportType, Locale locale) {
		PdfPTable table = new PdfPTable(new float[]{22f,78f});
		table.setWidthPercentage(100f);

		List<Official> elus = getPeopleList(officialsIds);
		int i = elus.size();
		for (Official elu : elus) {
			// photo de l'élu
			PdfPCell cell = new PdfPCell();
			try {
				Image img = Image.getInstance(domaine + elu.getImageURL());
				float newWidth = 90;
				float newHeight = (img.getHeight() / img.getWidth()) * newWidth;
				img.scaleAbsolute(newWidth, newHeight);
				document.add(img);
				cell.addElement(img);
			}catch (Exception e){
				System.out.println(elu.getFirstName() + " " + elu.getLastName() + " : " + e.getMessage());
			}
			cell.setPadding(0);
			cell.setPaddingTop(10f);
			cell.setPaddingBottom(10f);
			cell.setBorder(0);
			table.addCell(cell);

			// info de l'élu
			//cell = new Cell().setKeepTogether(true)
			cell = new PdfPCell();
			Paragraph paragraph = new Paragraph(elu.getFirstName() + " " + elu.getLastName().toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
			paragraph.setSpacingAfter(24f);
			cell.addElement(paragraph);
			try{
				if(exportType.equals(OfficialsConstants.EUROMETROPOLE)) {
					printPDFEurometropole(cell, elu, locale);
					paragraph = new Paragraph();
					paragraph.setSpacingAfter(16f);
					cell.addElement(paragraph);
					printPDFMunicipal(cell, elu, locale);
				}else{
					printPDFMunicipal(cell, elu, locale);
					paragraph = new Paragraph();
					paragraph.setSpacingAfter(16f);
					cell.addElement(paragraph);
					printPDFEurometropole(cell, elu, locale);
				}
			} catch (PortalException e) {
				System.out.println(elu.getFirstName() + " " + elu.getLastName() + " : " + e.getMessage());
			}
			cell.setBorder(0);
			cell.setPadding(0f);
			cell.setPaddingTop(7f);
			cell.setPaddingBottom(10f);
			table.addCell(cell);

			// séparation
			if(i > 1) {
				cell = new PdfPCell();
				cell.setBorder(0);
				table.addCell(cell);
				cell = new PdfPCell();
				cell.setBorder(0);
				cell.setBorderWidthBottom(1f);
				table.addCell(cell);
			}
			i--;
		}
		document.add(table);
	}

	private static void printPDFMunicipal(PdfPCell cell, Official elu, Locale locale)
			throws PortalException {
		if (elu.isEluMunicipal()) {
			Paragraph paragraph = new Paragraph(OfficialsConstants.TITRE_MUNICIPAL, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
			cell.addElement(paragraph);

			paragraph = new Paragraph(elu.getName(elu.getFonctionCity(), locale), fontBold);
			cell.addElement(paragraph);

			if (Validator.isNotNull(elu.getThematicDelegation())) {
				getMissions(cell, elu.getThematicDelegation(locale), locale);
			}

			List<AssetCategory> quartiers = elu.getDistricts();
			if (Validator.isNotNull(quartiers) && !quartiers.isEmpty()) {
				paragraph = new Paragraph(LanguageUtil.get(locale, "adjoint-de-quartier") + " : ", fontBold);
				cell.addElement(paragraph);
				
				StringBuilder strQuartiers = new StringBuilder();
				for (AssetCategory quartierElu : quartiers) {
					if (strQuartiers.length() > 0) {
						strQuartiers.append(", ");
					}
					strQuartiers.append(quartierElu.getName());
				}
				paragraph = new Paragraph(HtmlParserUtil.render(strQuartiers.toString()), font);
				cell.addElement(paragraph);
			}

			if (Validator.isNotNull(elu.getPoliticalGroupCity())) {
				paragraph = new Paragraph(HtmlParserUtil.render(LanguageUtil.get(locale, "groupe-politique") + " : "), fontBold);
				cell.addElement(paragraph);

				paragraph = new Paragraph(elu.getName(elu.getPoliticalGroupCity(), locale), font);
				cell.addElement(paragraph);
			}
		}
	}

	private static void printPDFEurometropole(PdfPCell cell, Official elu, Locale locale) throws PortalException {

		if (elu.isEluEurometropole()) {
			Paragraph paragraph = new Paragraph(OfficialsConstants.TITRE_EUROMETROPOLE, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
			cell.addElement(paragraph);

			paragraph = new Paragraph(elu.getName(elu.getFonctionEurometropole(), locale), fontBold);
			if (Validator.isNotNull(elu.getFonctionTown())) {
				paragraph.add(new Chunk(", " + elu.getName(elu.getFonctionTown(), locale), font));
			}
			if (Validator.isNotNull(elu.getTown())) {
				paragraph.add(new Chunk(" " + LanguageUtil.get(locale, "de-la-commune")+ " " + elu.getTown().getTitle(locale), font));
			}
			cell.addElement(paragraph);

			if (Validator.isNotNull(elu.getMissions())) {
				getMissions(cell, elu.getMissions(locale), locale);
			}

			if (Validator.isNotNull(elu.getPoliticalGroupEurometropole())) {
				paragraph = new Paragraph(HtmlParserUtil.render(LanguageUtil.get(locale, "groupe-politique")
						+ " : " ), fontBold);
				cell.addElement(paragraph);

				paragraph = new Paragraph(elu.getName(elu.getPoliticalGroupEurometropole(), locale), font);
				cell.addElement(paragraph);
			}
		}
	}

	private static void getMissions(PdfPCell cell, String mission, Locale locale){
		Paragraph paragraph = new Paragraph(LanguageUtil.get(locale, "en-charge-de") + " : ", font);
		cell.addElement(paragraph);

		org.jsoup.nodes.Document document = Jsoup.parse(mission);
		// Sélectionne les éléments
		Elements elements = document.select("body > *");
		boolean isFirst = true;for (org.jsoup.nodes.Element element : elements) {
			if(element.tagName().equals("ul")){
				List<org.jsoup.nodes.Element> sousElements = element.select("li");
				com.lowagie.text.List liste = new com.lowagie.text.List(false, false, 10);
				liste.setListSymbol("\u2022");
				ListItem listItem;
				for (org.jsoup.nodes.Element sousElement : sousElements) {
					listItem = new ListItem(HtmlParserUtil.render(sousElement.html()), font);
					liste.add(listItem);
				}
				liste.setIndentationLeft(20f);
				cell.addElement(liste);
			}else {
				paragraph = new Paragraph((isFirst?"":"\n") + HtmlParserUtil.render(element.html()), font);
				cell.addElement(paragraph);
			}
			isFirst = false;
		}
	}

	private static void getPDFFromHTML(ByteArrayOutputStream baos, String officialsIds, String exportType, Locale locale){
		String htmlContent = "<!DOCTYPE html><html><head>" +
				"<style>" +
				"html, body{margin: 0;font-size: 16px;font-family: Helvetica;}" +
				"a{text-decoration:underline; color:#007bff;}" +
				"h1{text-transform:uppercase; font-size:27px; font-weight:bold; margin-bottom:10px;}" +
				"h2{font-size:22px; font-weight:bold;margin:10px 0 40px;}" +
				"h3{font-size:22px; font-weight:bold; margin-bottom: 10px;}" +
				"strong{margin: 20px 0;}" +
				".table {clear: both;}" +
				".table .col1{float:left; min-width:22%; width:22%;}" +
				".table .col2{float: right; width:78%;}" +
				".official{page-break-after:always;}" +
				".official .col2{border-bottom:solid 1px; padding-bottom:20px;}" +
				".footer{border-top: solid #97bf0c 1px;}" +
				".footer .col2{text-align: right;}" +
				"</style>" +
				"</head>" +
				"<body>" +
				"<img width='100%' src='" + domaine + "/o/searchassetv2web/images/bandeau.jpg' />" +
				"<h1>" +
				(exportType.equals(OfficialsConstants.EUROMETROPOLE)?
						LanguageUtil.get(locale, "entete-annuaire-elus-municipaux-print") :
						LanguageUtil.get(locale, "entete-annuaire-elus-communautaires-print")) +
				"</h1>" +
				"<div class='officials'>" +
				htmlPeople(officialsIds, exportType, locale) +
				"</div>" +
				"<div class='footer table'>" +
				"<div class='col1'>" +
				new SimpleDateFormat("dd/MM/yyyy").format(new Date()) +
				"</div>" +
				"<div class='col2'>" +
				"<strong>" + LanguageUtil.get(locale, "footer-title") + "</strong><br/>" +
				LanguageUtil.get(locale, "footer-content") +
				"</div>" +
				"</div>" +
				"</body></html>";

		try (OutputStream outputStream = baos) {
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(htmlContent);
			renderer.layout();
			renderer.createPDF(outputStream);
		} catch (IOException e) {
			_log.error(e.getMessage());
		}
    }

	private static String htmlPeople(String officialsIds, String exportType, Locale locale) {
		StringBuilder html = new StringBuilder();

		List<Official> elus = getPeopleList(officialsIds);
		for (Official elu : elus) {
			html.append("<div class='official table'>" +
					"<div class='col1'>" +
                    "<img width='90px' src='" + domaine + elu.getImageURL().replaceAll("&","&amp;") + "' />" +
                    "</div>" +
					"<div class='col2'>" +
					"<h2>").append(elu.getFirstName()).append(" ").append(elu.getLastName().toUpperCase()).append("</h2>");
            try {
                if(exportType.equals(OfficialsConstants.EUROMETROPOLE)) {
					html.append(htmlEurometropole(elu, locale)).append(htmlMunicipal(elu, locale));
				}else{
					html.append(htmlMunicipal(elu, locale)).append(htmlEurometropole(elu, locale));
				}
            } catch (PortalException e) {
				_log.error(e.getMessage());
            }
			html.append("</div>" + "</div>");
        }
		return html.toString();
	}

	private static String htmlMunicipal(Official elu, Locale locale)
			throws PortalException {
		String html = "";

		if (elu.isEluMunicipal()) {
			html += "<h3>" + OfficialsConstants.TITRE_MUNICIPAL + "</h3>" +
					"<strong>" + elu.getName(elu.getFonctionCity(), locale) + "</strong>";
			
			if (Validator.isNotNull(elu.getThematicDelegation())) {
				String mission = "<div>" + LanguageUtil.get(locale, "en-charge-de") + " : ";
				String cityMission = StringUtil
						.replaceFirst(elu.getThematicDelegation(locale), "<p>", "");
				cityMission = StringUtil.replaceFirst(cityMission, "</p>", "");
				mission += cityMission;
				html += mission + "</div>";
			}

			List<AssetCategory> quartiers = elu.getDistricts();
			if (Validator.isNotNull(quartiers) && !quartiers.isEmpty()) {
				html += "<div><strong>" + LanguageUtil.get(locale, "adjoint-de-quartier") + " : </strong>";
				StringBuilder strQuartiers = new StringBuilder();
				for (AssetCategory quartierElu : quartiers) {
					if (strQuartiers.length() > 0) {
						strQuartiers.append(", ");
					}
					strQuartiers.append(quartierElu.getName());
				}
				html += strQuartiers + "</div>";
			}

			if (Validator.isNotNull(elu.getPoliticalGroupCity())) {
				html += "<div><strong>" + LanguageUtil.get(locale, "groupe-politique") + " : </strong><br/>" +
						elu.getName(elu.getPoliticalGroupCity(), locale).replaceAll("&","&amp;") + "</div>";
			}
		}
		return html;
	}

	private static String htmlEurometropole(Official elu, Locale locale) throws PortalException {
		String html = "";

		if (elu.isEluEurometropole()) {
			html += "<h3>" + OfficialsConstants.TITRE_EUROMETROPOLE + "</h3>" +
				"<div><strong>" + elu.getName(elu.getFonctionEurometropole(), locale) + "</strong>" +
				(Validator.isNotNull(elu.getFonctionTown())? ", " + elu.getName(elu.getFonctionTown(), locale) : "" ) +
				(Validator.isNotNull(elu.getTown())? " " + LanguageUtil.get(locale, "de-la-commune")+ " " + elu.getTown().getTitle(locale) : "") +
				"</div>";

			if(Validator.isNotNull(elu.getMissions())){
				String mission = "<div>" + LanguageUtil.get(locale, "en-charge-de") + " : ";
				String cusMission = StringUtil
						.replaceFirst(elu.getMissions(locale), "<p>", "");
				cusMission = StringUtil.replaceFirst(cusMission, "</p>", "");
				mission += cusMission;
				html += mission + "</div>";
			}

			if (Validator.isNotNull(elu.getPoliticalGroupEurometropole())) {
				html += "<div><strong>" + LanguageUtil.get(locale, "groupe-politique") + " : </strong><br/>" +
					elu.getName(elu.getPoliticalGroupEurometropole(), locale).replaceAll("&","&amp;") + "</div>";
			}
		}
		return html;
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
