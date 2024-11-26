package eu.strasbourg.portlet.council.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.portlet.council.bean.ProcurationBean;
import eu.strasbourg.service.council.constants.ProcurationModeEnum;
import eu.strasbourg.service.council.constants.ProcurationPresentialEnum;
import eu.strasbourg.service.council.exception.NoSuchDeliberationException;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.model.Procuration;
import eu.strasbourg.service.council.model.ProcurationModel;
import eu.strasbourg.service.council.service.CouncilSessionLocalServiceUtil;
import eu.strasbourg.service.council.service.DeliberationLocalServiceUtil;
import eu.strasbourg.service.council.service.OfficialLocalServiceUtil;
import eu.strasbourg.service.council.service.ProcurationLocalServiceUtil;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PrintProcurationsPDF {

    private static CouncilSession council;
    private static Timestamp timestamp;

    public static File printPDFs(long councilSessionId) throws SystemException {

        timestamp = new Timestamp(System.currentTimeMillis());

        File folder = new File(System.getProperty("java.io.tmpdir") + "/council_procurations_history_" +
                timestamp.getTime());
        folder.mkdirs();

        council = CouncilSessionLocalServiceUtil.fetchCouncilSession(councilSessionId);

        // on récpère toutes les délibérations du conseil de session qui sont adoptées ou rejetées avec des votes
        List<Procuration> procurations = ProcurationLocalServiceUtil.findByCouncilSessionId(councilSessionId).stream()
                .sorted(Comparator.comparing(ProcurationModel::getStartHour))
                .sorted(Comparator.comparing(p -> OfficialLocalServiceUtil.fetchOfficial(p.getOfficialUnavailableId()).getFullName()))
                .collect(Collectors.toList());
        File deliberationpdf = null;

        String domaine = StrasbourgPropsUtil.getBaseURL();

        // titre du PDF
        String title = "";
        if (Validator.isNotNull(council)) {
            title += council.getTypeCouncil().getTitleLong();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyy", Locale.FRANCE);
            title += " DU " + sdf.format(council.getDate());
        }

        // Verifie s'il y a encore des procurations ouvertes et créer un procurationBean
        Boolean isStillOpen = false;
        List<ProcurationBean> procurationsBean = new ArrayList<>();
        for (Procuration procuration : procurations) {
            if (Validator.isNull(procuration.getEndHour()) || procuration.getEndDelib() == -1) {
                isStillOpen = true;
            } else {
                try {
                    if (Validator.isNull(DeliberationLocalServiceUtil.getDeliberation(procuration.getEndDelib()))) {
                        isStillOpen = true;
                    }
                } catch (Exception e) {
                }
            }

            // Votant
            String votant = OfficialLocalServiceUtil.fetchOfficial(procuration.getOfficialUnavailableId()).getFullName();
            // Mode de procuration
            String procurationModeValue = "-";
            int procurationMode = procuration.getProcurationMode();
            if (procurationMode != 0) {
                procurationModeValue = procurationMode == 4 ? procuration.getOtherProcurationMode() : ProcurationModeEnum.get(procurationMode).getName();
            }
            // Présentiel
            String presentialValue = ProcurationPresentialEnum.get(procuration.getPresential()).getName();
            String presential = Validator.isNull(presentialValue) ? "-" : presentialValue;
            // Bénéficiaire de procuration
            String officialVoter = procuration.getOfficialVotersFullName();
            String officialVoterValue = Validator.isNull(officialVoter) ? "Aucun" : officialVoter;
            // Traitement pour l'affichage des heures de debut et fin de procuration
            SimpleDateFormat hour = new SimpleDateFormat("HH", Locale.FRANCE);
            SimpleDateFormat minute = new SimpleDateFormat("mm");
            // Si minute 00 alors on affiche rien pour avoir 12h et pas 12h00
            String startMinute = minute.format(procuration.getStartHour()).equals("00") ? "" : minute.format(procuration.getStartHour());
            String startTime = hour.format(procuration.getStartHour()) + "h" + startMinute;
            String endTime = "";
            if (Validator.isNotNull(procuration.getEndHour())) {
                String endMinute = minute.format(procuration.getEndHour()).equals("00") ? "" : minute.format(procuration.getEndHour());
                endTime = hour.format(procuration.getEndHour()) + "h" + endMinute;
            }
            // Traitement pour l'affichage des points de deliberation d'ouverture et de fermeture de procuration
            String startDelibValue = "";
            Deliberation startDelib = null;
            try {
                startDelib = DeliberationLocalServiceUtil.getDeliberation(procuration.getStartDelib());
            } catch (PortalException e) {
                _log.error(e.getMessage() + " : " + procuration);
            }
            if (Validator.isNotNull(startDelib)) {
                startDelibValue = procuration.getStartDelib() == -1 ? "" : startDelib.getOrder()+startDelib.getAmendement();
                if (procuration.isIsAfterVote() && procuration.getStartHour() != null) {
                    startDelibValue += "-AV";
                }
            }
            String endDelibValue = "";
            Deliberation endDelib = null;
            try {
                endDelib = DeliberationLocalServiceUtil.getDeliberation(procuration.getEndDelib());
            } catch (PortalException e) {
                _log.error(e.getMessage() + " : " + procuration);
            }
            if (Validator.isNotNull(endDelib)) {
                endDelibValue = procuration.getEndDelib() == -1 ? "" : endDelib.getOrder()+endDelib.getAmendement();
            }
            ProcurationBean procurationBean = new ProcurationBean(votant, procurationModeValue, presential,
                    officialVoterValue, startTime, startDelibValue, endTime, endDelibValue);

            procurationsBean.add(procurationBean);
        }

        try {
            //Chargement du template contenant le corps du mail
            TemplateResource templateResource = new URLTemplateResource("0",
                    Objects.requireNonNull(PrintProcurationsPDF.class.getClassLoader()
                            .getResource("/templates/procuration-result.ftl")));
            Template template = TemplateManagerUtil.getTemplate(
                    TemplateConstants.LANG_TYPE_FTL, templateResource, false);

            // récupération des données
            Map<String, Object> context = new HashMap<>();
            context.put("domaine", domaine);
            context.put("title", title.toUpperCase());
            context.put("isStillOpen", isStillOpen);
            context.put("procurations", procurationsBean);

            // Traitement du template
            StringWriter out = new StringWriter();
            template.putAll(context);
            template.processTemplate(out);

            //enregistrement du fichier
            String fileName = "";
            if (Validator.isNotNull(council)) {
                // Supprime les accents qui posent souci sur la création de fichier
                fileName += Normalizer.normalize(council.getTypeCouncil().getTitle(), Normalizer.Form.NFD).replaceAll("\\p{M}", "");;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            fileName += " " + sdf.format(council.getDate()) + "_procurations_history_" + timestamp.getTime() + ".pdf";

            deliberationpdf = new File(folder.getAbsolutePath() + "/" + fileName);
            deliberationpdf.getParentFile().mkdirs();
            try (OutputStream outputStream = new FileOutputStream(deliberationpdf)) {
                ITextRenderer renderer = new ITextRenderer();
                renderer.setDocumentFromString(out.toString());
                renderer.layout();
                renderer.createPDF(outputStream);
            } catch (IOException e) {
                _log.error(e.getMessage(), e);
            }
        } catch (TemplateException e) {
            _log.error(e.getMessage(), e);
        }
        return deliberationpdf;
    }

    private static final Log _log = LogFactoryUtil.getLog(PrintProcurationsPDF.class.getName());
}
