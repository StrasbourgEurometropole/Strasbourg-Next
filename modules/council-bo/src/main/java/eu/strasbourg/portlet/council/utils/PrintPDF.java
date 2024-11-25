package eu.strasbourg.portlet.council.utils;

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
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.model.Vote;
import eu.strasbourg.service.council.service.CouncilSessionLocalServiceUtil;
import eu.strasbourg.service.council.service.DeliberationLocalServiceUtil;
import eu.strasbourg.service.council.service.OfficialLocalServiceUtil;
import eu.strasbourg.service.council.service.VoteLocalServiceUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PrintPDF {

	private static CouncilSession council;
	private static LocalDateTime now;
	private static Timestamp timestamp;

	public static String printPDFs(long councilSessionId)
			throws IOException, SystemException {

		now = LocalDateTime.now();
		timestamp = new Timestamp(System.currentTimeMillis());

		File folder = new File(System.getProperty("java.io.tmpdir") + "/council_results_" +
				timestamp.getTime());
		folder.mkdirs();

		council = CouncilSessionLocalServiceUtil.fetchCouncilSession(councilSessionId);

		// on récpère toutes les délibérations du conseil de session qui sont adoptées ou rejetées avec des votes
		List<Deliberation> deliberations = DeliberationLocalServiceUtil.findByCouncilSessionId(councilSessionId)
				.stream().filter(d -> d.isRejete() || d.isAdopte()).collect(Collectors.toList());
		for (Deliberation deliberation : deliberations) {
			// on vérifi s'il y a des votes
			if(Validator.isNotNull(deliberation)) {
				List<Vote> votes = VoteLocalServiceUtil.findByDeliberationId(deliberation.getDeliberationId());
				if (Validator.isNotNull(votes) && !votes.isEmpty()) {
//					PrintPDF.printPDF(folder, deliberation, votes);

					String domaine = StrasbourgPropsUtil.getBaseURL();

					// titre du PDF
					String title = "";
					if (Validator.isNotNull(council)) {
						title +=  council.getTypeCouncil().getTitleLong().toUpperCase();
						SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyy", Locale.FRANCE);
						title += " DU " + sdf.format(council.getDate());
					}
					title = title.toUpperCase() + " - Point n"
							+ LanguageUtil.get(Locale.FRANCE, "eu.numero")
							+ deliberation.getOrder();

					String subtitle = deliberation.getOrderAmendement() + ". " + deliberation.getTitle();

					int hauteur_pour = 330;
					int hauteur_contre = 95;
					int hauteur_abstention = 95;
					int hauteur_totale = hauteur_pour + hauteur_contre + hauteur_abstention;

					// votes pour
					List<Vote> votesPour = votes.stream().filter(v -> v.getResult().equals("Pour")).collect(Collectors.toList());
					List<String> offialsFullNamePour = new ArrayList<>();
					for (Vote vote : votesPour) {
						Official elu = OfficialLocalServiceUtil.fetchOfficial(vote.getOfficialId());
						if (elu != null)
							offialsFullNamePour.add(elu.getFullName());
					}
					offialsFullNamePour.sort( Comparator.comparing( String::toString ) );

					// votes contre
					List<Vote> votesContre = votes.stream().filter(v -> v.getResult().equals("Contre")).collect(Collectors.toList());
					int nbVotesContre = votesContre.size();
					List<String> offialsFullNameContre = new ArrayList<>();
					for (Vote vote : votesContre) {
						Official elu = OfficialLocalServiceUtil.fetchOfficial(vote.getOfficialId());
						if (elu != null)
							offialsFullNameContre.add(elu.getFullName());
					}
					offialsFullNameContre.sort( Comparator.comparing( String::toString ) );

					// abstention
					List<Vote> abstentions = votes.stream().filter(v -> v.getResult().equals("Abstention")).collect(Collectors.toList());
					int nbAbstentions = abstentions.size();
					List<String> offialsFullNameAbstentions = new ArrayList<>();
					for (Vote vote : abstentions) {
						Official elu = OfficialLocalServiceUtil.fetchOfficial(vote.getOfficialId());
						if (elu != null)
							offialsFullNameAbstentions.add(elu.getFullName());
					}
					offialsFullNameAbstentions.sort( Comparator.comparing( String::toString ) );

					int nbVotesTotal = votes.size();

					if(nbVotesContre >= 25 || nbAbstentions >= 25){
						int hauteur_min = 95;
						int hauteur_restante = hauteur_totale - 3 * hauteur_min;
						hauteur_abstention = hauteur_min + nbAbstentions * hauteur_restante / nbVotesTotal;
						hauteur_contre = hauteur_min + nbVotesContre * hauteur_restante / nbVotesTotal;
						hauteur_pour = hauteur_totale - hauteur_contre - hauteur_abstention;
					}
					try {
						//Chargement du template contenant le corps du mail
						TemplateResource templateResource = new URLTemplateResource("0",
								Objects.requireNonNull(PrintPDF.class.getClassLoader()
										.getResource("/templates/council-result.ftl")));
						Template template = TemplateManagerUtil.getTemplate(
								TemplateConstants.LANG_TYPE_FTL, templateResource, false);

						// récupération des données
						Map<String, Object> context = new HashMap<>();
						context.put("domaine", domaine);
						context.put("title", title);
						context.put("subtitle", subtitle);
						context.put("pour", offialsFullNamePour);
						context.put("contre", offialsFullNameContre);
						context.put("abstention", offialsFullNameAbstentions);
						context.put("hauteur_pour", hauteur_pour);
						context.put("hauteur_contre", hauteur_contre);
						context.put("hauteur_abstention", hauteur_abstention);

						// Traitement du template
						StringWriter out = new StringWriter();
						template.putAll(context);
						template.processTemplate(out);


						// enregistrement du fichier
						String fileName = "";
						if (Validator.isNotNull(council)) {
							// Supprime les accents qui posent souci sur la création de fichier
							fileName +=  Normalizer.normalize(council.getTypeCouncil().getTitle(), Normalizer.Form.NFD).replaceAll("\\p{M}", "");
						}
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
						fileName += " " + sdf.format(council.getDate()) + " - Point " + deliberation.getOrder() + deliberation.getAmendement() + ".pdf";

						File deliberationpdf = new File(folder.getAbsolutePath() + "/" + fileName);
						deliberationpdf.getParentFile().mkdirs();
						try (OutputStream outputStream = new FileOutputStream(deliberationpdf)) {
							ITextRenderer renderer = new ITextRenderer();
							renderer.setDocumentFromString(out.toString());
							renderer.layout();
							renderer.createPDF(outputStream);
						} catch (IOException e) {
							_log.error(e.getMessage());
						}
					} catch (TemplateException e) {
						_log.error(e.getMessage(), e);
					}
				}
			}
		}

		return folder.getAbsolutePath();
	}

	private static final Log _log = LogFactoryUtil.getLog(PrintPDF.class);

}
