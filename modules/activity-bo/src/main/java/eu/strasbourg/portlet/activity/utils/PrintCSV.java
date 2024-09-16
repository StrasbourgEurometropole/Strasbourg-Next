package eu.strasbourg.portlet.activity.utils;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.activity.model.Association;
import eu.strasbourg.service.activity.model.Practice;
import eu.strasbourg.service.activity.service.AssociationLocalServiceUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class PrintCSV {
	private static Timestamp timestamp;

	public static String printCSVs()
			throws IOException, SystemException {

		timestamp = new Timestamp(System.currentTimeMillis());

		File folder = new File(System.getProperty("java.io.tmpdir") + "/ASSOCIATIONS_PRACTICES" +
				timestamp.getTime());
		folder.mkdirs();

		// on récupère toutes les associations
		List<Association> associations = AssociationLocalServiceUtil.getAssociations(-1,-1).stream()
				.filter(a -> a.getStatus() == WorkflowConstants.STATUS_APPROVED).collect(Collectors.toList());
		printAssociationsCSV(folder, associations);

		return folder.getAbsolutePath();
	}

	public static void printAssociationsCSV(File folder, List<Association> associations) {
		// Création du fichier practices.csv
		StringBundler practicesCsv = new StringBundler();
		String practicesFileName = "practices.csv";
		File practicesCSV = new File(folder.getAbsolutePath() + "/" + practicesFileName);
		practicesCSV.getParentFile().mkdirs();
		practicesCsv.append("Id;Domaine de pratique;Accessibilité de pratique;Public de pratique;Territoire;Id Association");
		practicesCsv.append(CharPool.NEW_LINE);

		// Création du fichier associations.csv
		StringBundler associationsCsv = new StringBundler();
		String associationsFileName = "associations.csv";
		File associationsCSV = new File(folder.getAbsolutePath() + "/" + associationsFileName);
		associationsCSV.getParentFile().mkdirs();

		// Remplissage du fichier associations.csv
		associationsCsv.append("Id;Nom;Pr\\u00E9sentation;T\\u00E9l\\u00E9phone;URL;Email;Facebook;Autres");
		associationsCsv.append(CharPool.NEW_LINE);
		for (Association association : associations) {
			associationsCsv.append(association.getAssociationId());
			associationsCsv.append(";" + association.getName(Locale.FRANCE));
			associationsCsv.append(";" + association.getPresentation(Locale.FRANCE));
			associationsCsv.append(";" + association.getPhone());
			associationsCsv.append(";" + association.getSiteURL(Locale.FRANCE));
			associationsCsv.append(";" + association.getMail());
			associationsCsv.append(";" + association.getFacebookURL(Locale.FRANCE));
			associationsCsv.append(";" + association.getOthersInformations(Locale.FRANCE));
			associationsCsv.append(CharPool.NEW_LINE);

			// Ajoute les pratiques de l'association au fichier practices.csv
			printPracticesCSV(association.getPractices(), practicesCsv);
		}

		// enregistrement du fichier associations.csv
		byte[] bytes = associationsCsv.toString().replace('.', ',').getBytes();
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(associationsCSV);
			fos.write(bytes);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		}

		// enregistrement du fichier practices.csv
		bytes = practicesCsv.toString().replace('.', ',').getBytes();
		try {
			fos = new FileOutputStream(practicesCSV);
			fos.write(bytes);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		}
	}

	public static void printPracticesCSV(List<Practice> practices, StringBundler practicesCsv){
		for (Practice practice : practices) {
			practicesCsv.append(";" + practice.getPracticeId());
			practicesCsv.append(";" + (Validator.isNotNull(practice.getPractice())?practice.getPractice().getName():""));
			String accessibilities = practice.getAccessibilities().stream()
					.map(assetCategory -> assetCategory.getName())
					.collect(Collectors.joining(","));
			practicesCsv.append(";" + accessibilities);
			String publics = practice.getPublics().stream()
					.map(assetCategory -> assetCategory.getName())
					.collect(Collectors.joining(","));
			practicesCsv.append(";" + publics);
			String territories = practice.getDistricts().stream()
					.map(assetCategory -> assetCategory.getName())
					.collect(Collectors.joining(","));
			practicesCsv.append(";" + territories);
			practicesCsv.append(";" + practice.getAssociationId());
			practicesCsv.append(CharPool.NEW_LINE);
		}
	}
	private static final Log _log = LogFactoryUtil.getLog(PrintCSV.class);

}
