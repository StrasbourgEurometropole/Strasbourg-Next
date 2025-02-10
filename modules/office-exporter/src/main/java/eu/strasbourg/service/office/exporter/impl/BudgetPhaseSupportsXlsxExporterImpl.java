package eu.strasbourg.service.office.exporter.impl;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.office.exporter.api.BudgetPhaseSupportsXlsxExporter;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.model.BudgetSupport;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalService;
import eu.strasbourg.service.project.service.BudgetPhaseLocalService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

@Component(
	immediate = true,
	property = {},
	service = BudgetPhaseSupportsXlsxExporter.class
)
public class BudgetPhaseSupportsXlsxExporterImpl implements BudgetPhaseSupportsXlsxExporter {
	
	private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
			this.getClass().getClassLoader());

	@Override
	public void exportBudgetPhaseSupports(OutputStream stream, long budgetPhaseId) {
		// Recherche du budgetPhase
		BudgetPhase budgetPhase = _budgetPhaseLocalService.fetchBudgetPhase(budgetPhaseId);

		// Recherche des budgetParticipatifs liés au budgetPhase
		List<BudgetParticipatif> budgetParticipatifs = _budgetParticipatifLocalService.getByBudgetPhase(budgetPhaseId);

		this.exportBudgetPhaseSupports(stream, budgetPhase.getTitle(), budgetParticipatifs);
	}

	@Override
	public void exportBudgetPhaseSupports(OutputStream stream, String budgetPhaseTitle, List<BudgetParticipatif> budgetParticipatifs) {

		// Initialisation du document
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Creation du document
		XSSFSheet sheet = workbook.createSheet("Soutiens_" + budgetPhaseTitle +
				"_" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		// Initialisation des colonnes
		Object[][] supportData = { {
				LanguageUtil.get(bundle, "budgetPhaseName"),
				LanguageUtil.get(bundle, "budgetParticipatifId"),
				LanguageUtil.get(bundle, "budgetParticipatifTitle"),
				LanguageUtil.get(bundle, "lastname"),
				LanguageUtil.get(bundle, "firstname"),
				LanguageUtil.get(bundle, "birthday"),
				LanguageUtil.get(bundle, "address"),
				LanguageUtil.get(bundle, "postal-code"),
				LanguageUtil.get(bundle, "city"),
				LanguageUtil.get(bundle, "email"),
				LanguageUtil.get(bundle, "phone"),
				LanguageUtil.get(bundle, "mobile"),
				LanguageUtil.get(bundle, "support-date"),
				LanguageUtil.get(bundle, "support-type")
		} };

		// Recuperation des supports du budgetParticipatif
		for (BudgetParticipatif budgetParticipatif: budgetParticipatifs) {
			List<BudgetSupport> budgetSupports = budgetParticipatif.getSupports();
			supportData = this.exportBudgetPhaseSupports(supportData, budgetPhaseTitle, budgetParticipatif.getTitle(), budgetSupports);
		}

		// Parcours et ajout des donnees dans les cellules
		int rowIndex = 0;
		int columnIndex = 0;

		for (Object[] budgetSupportObject : supportData) {
			Row row = sheet.createRow(rowIndex);
			columnIndex = 0;
			for (Object field : budgetSupportObject) {
				Cell cell = row.createCell(columnIndex);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Long) {
					cell.setCellValue((Long) field);
				}
				columnIndex++;
			}
			rowIndex++;
		}

		try {
			workbook.write(stream);
			workbook.close();
			stream.flush();
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		}

	}


	@Override
	public Object[][] exportBudgetPhaseSupports(Object[][] supportData, String budgetPhaseTitle, String budgetParticipatifTitle, List<BudgetSupport> budgetSupports) {

			// Parcours des soutiens et creation de la ligne à ajouter dans l'excel
			for (BudgetSupport budgetSupport : budgetSupports) {
				try {

					DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");

					Object[] budgetSupportRow = {
							budgetPhaseTitle,
							budgetSupport.getBudgetParticipatifId(),
							budgetParticipatifTitle,
							budgetSupport.getCitoyenLastName(),
							budgetSupport.getCitoyenFirstname(),
							Validator.isNotNull(budgetSupport.getCitoyenBirthday())?dateFormat.format(budgetSupport.getCitoyenBirthday()):"",
							budgetSupport.getCitoyenAddress(),
							budgetSupport.getCitoyenPostalCode(),
							budgetSupport.getCitoyenCity(),
							budgetSupport.getCitoyenMail(),
							budgetSupport.getCitoyenPhone(),
							budgetSupport.getCitoyenMobilePhone(),
							dateFormat.format(budgetSupport.getCreateDate()),
							budgetSupport.getIsNegatif()?LanguageUtil.get(bundle, "negatif"):LanguageUtil.get(bundle, "positif")
					};

					supportData = ArrayUtil.append(supportData, budgetSupportRow);
				}catch (Exception e){
					_log.error(e.getMessage(), e);
				}

			}
		return supportData;
	}

	@Reference(unbind = "-")
	protected void setBudgetPhaseLocalService(BudgetPhaseLocalService budgetPhaseLocalService) {
		this._budgetPhaseLocalService = budgetPhaseLocalService;
	}

	private BudgetPhaseLocalService _budgetPhaseLocalService;

	@Reference(unbind = "-")
	protected void setBudgetParticipatifLocalService(BudgetParticipatifLocalService budgetParticipatifLocalService) {
		this._budgetParticipatifLocalService = budgetParticipatifLocalService;
	}

	private BudgetParticipatifLocalService _budgetParticipatifLocalService;

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
