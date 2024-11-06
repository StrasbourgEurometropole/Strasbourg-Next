package eu.strasbourg.service.objtp.service.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import eu.strasbourg.utils.MailHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class ImportReportObjtp {


	private int objectCategoryStatus;
	private String globalErrorCauseObjectCategory;
	private int totalObjectCategoryCount;
	private int errorObjectCategoryCount;
	private List<ImportReportLineObjtp> reportLinesObjectCategory;
	private int foundObjectStatus;
	private String globalErrorCauseFoundObject;
	private int createdFoundObjectCount;
	private int modifiedFoundObjectCount;
	private int unmodifiedFoundObjectCount;
	private int errorFoundObjectCount;
	private List<ImportReportLineObjtp> reportLinesFoundObject;
	private Map<String, List<Integer>> reportLinesImageCount;
	private Date endDate;
	
	public ImportReportObjtp() {
		this.setObjectCategoryStatus(ImportReportStatusObjtp.SUCCESS);
		this.setFoundObjectStatus(ImportReportStatusObjtp.SUCCESS);

		this.reportLinesObjectCategory = new ArrayList<>();
		this.reportLinesFoundObject = new ArrayList<>();
		this.reportLinesImageCount = new HashMap<>();
	}
	

	public int getObjectCategoryStatus() {
		return objectCategoryStatus;
	}
	public void setObjectCategoryStatus(int objectCategoryStatus) {
		this.objectCategoryStatus = objectCategoryStatus;
	}

	public String getGlobalErrorCauseObjectCategory() {
		return globalErrorCauseObjectCategory;
	}
	public void setGlobalErrorCauseObjectCategory(String globalErrorCauseObjectCategory) {
		this.globalErrorCauseObjectCategory = globalErrorCauseObjectCategory;
	}

	public int getTotalObjectCategoryCount() {
		return totalObjectCategoryCount;
	}
	public void setTotalObjectCategoryCount(int totalObjectCategoryCount) {
		this.totalObjectCategoryCount = totalObjectCategoryCount;
	}

	public int getErrorObjectCategoryCount() {
		return errorObjectCategoryCount;
	}
	public void setErrorObjectCategoryCount(int errorObjectCategoryCount) {
		this.errorObjectCategoryCount = errorObjectCategoryCount;
	}

	public List<ImportReportLineObjtp> getReportLinesObjectCategory() {
		return reportLinesObjectCategory;
	}

	public int getFoundObjectStatus() {
		return foundObjectStatus;
	}
	public void setFoundObjectStatus(int foundObjectStatus) {
		this.foundObjectStatus = foundObjectStatus;
	}

	public String getGlobalErrorCauseFoundObject() {
		return globalErrorCauseFoundObject;
	}
	public void setGlobalErrorCauseFoundObject(String globalErrorCauseFoundObject) {
		this.globalErrorCauseFoundObject = globalErrorCauseFoundObject;
	}

	public int getCreatedFoundObjectCount() {
		return createdFoundObjectCount;
	}
	public void setCreatedFoundObjectCount(int createdFoundObjectCount) {
		this.createdFoundObjectCount = createdFoundObjectCount;
	}

	public int getModifiedFoundObjectCount() {
		return modifiedFoundObjectCount;
	}
	public void setModifiedFoundObjectCount(int modifiedFoundObjectCount) {
		this.modifiedFoundObjectCount = modifiedFoundObjectCount;
	}

	public int getUnmodifiedFoundObjectCount() {
		return unmodifiedFoundObjectCount;
	}
	public void setUnmodifiedFoundObjectCount(int unmodifiedFoundObjectCount) {
		this.unmodifiedFoundObjectCount = unmodifiedFoundObjectCount;
	}

	public int getErrorFoundObjectCount() {
		return errorFoundObjectCount;
	}
	public void setErrorFoundObjectCount(int errorFoundObjectCount) {
		this.errorFoundObjectCount = errorFoundObjectCount;
	}

	public List<ImportReportLineObjtp> getReportLinesFoundObject() {
		return reportLinesFoundObject;
	}

	public Map<String, List<Integer>> getReportLinesImageCount() {
		return reportLinesImageCount;
	}

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/*
	 * Incrémente le nombre d'erreurs liées aux catégories d'objets
	 */
	public void incrementErrorObjectCategoryCount() {
		this.setErrorObjectCategoryCount(
			this.getErrorObjectCategoryCount() + 1);
	}
	
	/*
	 * Incrémente le nombre d'erreurs liées aux objets trouvés
	 */
	public void incrementErrorFoundObjectCount() {
		this.setErrorFoundObjectCount(
			this.getErrorFoundObjectCount() + 1);
	}
	
	/*
	 * Incrémente le nombre d'objets trouvés crées
	 */
	public void incrementCreatedFoundObjectCount() {
		this.setCreatedFoundObjectCount(
				this.getCreatedFoundObjectCount() + 1);
	}

	/*
	 * Incrémente le nombre d'objets trouvés modifiés
	 */
	public void incrementModifiedFoundObjectCount() {
		this.setModifiedFoundObjectCount(
				this.getModifiedFoundObjectCount() + 1);
	}

	/*
	 * Incrémente le nombre d'objets trouvés non modifiés
	 */
	public void incrementUnmodifiedFoundObjectCount() {
		this.setUnmodifiedFoundObjectCount(
				this.getUnmodifiedFoundObjectCount() + 1);
	}

	/*
	 * Action entreprise lors d'une erreur arrêtant l'import des catégories d'objet
	 */
	public void globalErrorObjectCategory(String cause) {
		this.setObjectCategoryStatus(ImportReportStatusObjtp.FAILURE);
		this.setGlobalErrorCauseObjectCategory(cause);
	}
	
	/*
	 * Action entreprise lors d'une erreur arrêtant l'import des objets trouvés
	 */
	public void globalErrorFoundObject(String cause) {
		this.setFoundObjectStatus(ImportReportStatusObjtp.FAILURE);
		this.setGlobalErrorCauseFoundObject(cause);
	}
	
	public void sendMail() {
		String environment = StrasbourgPropsUtil.getEnvironment();

		String mailAddresses = StrasbourgPropsUtil.getObjtpImportMails();

		StringWriter out = new StringWriter();
		String mailSubject;
		String mailBody;

		try {
			// Chargement du template contenant le sujet du mail
			TemplateResource templateResourceSubject = new URLTemplateResource(
					"0",
					Objects.requireNonNull(this.getClass().getClassLoader()
							.getResource("/templates/import-notification-mail-subject.ftl")));
			Template subjectTemplate = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResourceSubject, false);

			// Traitement du template sujet
			subjectTemplate.put("environment", environment);
			subjectTemplate.processTemplate(out);
			mailSubject = out.toString();

			//Chargement du template contenant le corps du mail
			TemplateResource templateResourceBody = new URLTemplateResource(
					"0",
					Objects.requireNonNull(this.getClass().getClassLoader()
							.getResource("/templates/import-notification-mail-body.ftl")));
			Template bodyTemplate = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResourceBody, false);

			// Traitement du template corps
			out = new StringWriter();
			bodyTemplate.put("report", this);
			bodyTemplate.processTemplate(out);
			mailBody = out.toString();

			String adminEmailFromAddress = PrefsPropsUtil.getString(
				PortalUtil.getDefaultCompanyId(),
				PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			// Envoi du mail
			MailHelper.sendMailWithPlainText(adminEmailFromAddress, mailAddresses, mailSubject, mailBody);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(this.getClass());
}
