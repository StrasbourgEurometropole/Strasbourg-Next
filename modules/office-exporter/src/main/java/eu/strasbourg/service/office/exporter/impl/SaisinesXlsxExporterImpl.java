package eu.strasbourg.service.office.exporter.impl;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import eu.strasbourg.service.office.exporter.api.SaisinesXlsxExporter;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.SaisineObservatoireLocalService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.apache.commons.text.StringEscapeUtils.unescapeHtml4;

/**
 * @author AZC
 */
@Component(
        immediate = true,
        service = SaisinesXlsxExporter.class
)
public class SaisinesXlsxExporterImpl implements SaisinesXlsxExporter {

    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());

    private SaisineObservatoireLocalService saisineLocalService;

    @Reference(unbind = "-")
    public void setSaisineLocalService(SaisineObservatoireLocalService saisineLocalService) {
        this.saisineLocalService = saisineLocalService;
    }

    @Override
    public void exportSaisines(OutputStream stream) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Saisines observatoires");
        Object[][] saisinesData = {{LanguageUtil.get(bundle, "title"),
                LanguageUtil.get(bundle, "create-date"),
                LanguageUtil.get(bundle, "modification-date"),
                LanguageUtil.get(bundle, "user-liferay"),
                LanguageUtil.get(bundle, "signataire-count"),
                LanguageUtil.get(bundle, "petition-paper-count"),
                LanguageUtil.get(bundle, "description"),
                LanguageUtil.get(bundle, "petition-publication-date"),
                LanguageUtil.get(bundle, "petition-expiration-date"),
                LanguageUtil.get(bundle, "in-the-name-of"),
                LanguageUtil.get(bundle, "lastname"),
                LanguageUtil.get(bundle, "firstname"),
                LanguageUtil.get(bundle, "address"),
                LanguageUtil.get(bundle, "postal-code"),
                LanguageUtil.get(bundle, "birthday"),
                LanguageUtil.get(bundle, "city"),
                LanguageUtil.get(bundle, "phone"),
                LanguageUtil.get(bundle, "email"),
                LanguageUtil.get(bundle, "petition-issupported"),
                LanguageUtil.get(bundle, "petition-supportedby"),
                LanguageUtil.get(bundle, "petition-consultation-place-text"),
                LanguageUtil.get(bundle, "petition-status"),
                LanguageUtil.get(bundle, "thematic"),
                LanguageUtil.get(bundle, "project"),
                LanguageUtil.get(bundle, "districts")}};

        for (SaisineObservatoire sainsine : this.saisineLocalService.getSaisineObservatoires(-1,-1)) {
            String languageId = LocaleUtil.toLanguageId(Locale.FRANCE);
            String title = LocalizationUtil.getLocalization(sainsine.getTitle(), languageId);
            Object[] petitionRow = {getfield(title),
                    getfield(sainsine.getCreateDate()),
                    getfield(sainsine.getModifiedDate()),
                    getfield(sainsine.getUserName()),
                    getfield(String.valueOf(sainsine.getDistrictLabel(Locale.FRANCE))),
                    getfield(String.valueOf(sainsine.getAuthorLabel())),
                    getfield(sainsine.getDescription()),
                    getfield(sainsine.getAuthorImageURL()),
                    getfield(sainsine.getImageCopyright(Locale.FRANCE)),
                    getfield(sainsine.getImageURL()),
                    getfield(unescapeHtml4(sainsine.getPetitionnaireLastname())),
                    getfield(unescapeHtml4(sainsine.getPetitionnaireFirstname())),
                    getfield(unescapeHtml4(sainsine.getPetitionnaireAdresse())),
                    getfield(sainsine.getPetitionnairePostalCode()),
                    getfield(sainsine.getPetitionnaireBirthday()),
                    getfield(unescapeHtml4(sainsine.getPetitionnaireCity())),
                    getfield(unescapeHtml4(sainsine.getPetitionnairePhone())),
                    getfield(unescapeHtml4(sainsine.getPetitionnaireEmail())),
                    getfield(sainsine.getNbApprovedComments()),
                    getfield(unescapeHtml4(sainsine.getNbApprovedCommentsLabel())),
                    getfield(sainsine.getPlaceTextArea()),
                    getfield(sainsine.getCityResponse(Locale.FRANCE)),
                    getfield(sainsine.getProjectTitle(Locale.FRANCE)),
                    getfield(sainsine.getThematicLabel(Locale.FRANCE)),
                    getfield(sainsine.getDistrictLabel(Locale.FRANCE))};
            saisinesData = ArrayUtil.append(saisinesData, petitionRow);
        }
        int rowIndex = 0;
        int columnIndex;
        for (Object[] saisineObject : saisinesData) {
            Row row = sheet.createRow(rowIndex);
            columnIndex = 0;
            for (Object field : saisineObject) {
                Cell cell = row.createCell(columnIndex);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
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

    private String getfield(String param) {
        String result = "";
        if (param != null && !param.isEmpty())
            result = param;
        return result;
    }

    private String getfield(Date param) {
        DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");
        String result = "";
        if (param != null)
            result = dateFormat.format(param);
        return result;
    }

    private String getfield(boolean param) {
        return param ? "oui" : "non";
    }

    private String getfield(long param) {
        String result = "";
        if (param != 0L)
            result = String.valueOf(param);
        return result;
    }

    private String getfield(int param) {
        String result = "";
        if (param != 0)
            result = String.valueOf(param);
        return result;
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
