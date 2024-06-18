package eu.strasbourg.service.office.exporter.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.office.exporter.api.PetitionsXlsxExporter;
import eu.strasbourg.service.office.exporter.api.PlaceXlsxExporter;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalService;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.service.PetitionLocalService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.apache.commons.text.StringEscapeUtils.unescapeHtml4;

@Component(
        immediate = true,
        service = PlaceXlsxExporter.class
)
public class PlaceXlsxExporterImpl implements PlaceXlsxExporter {

    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());

    private PlaceLocalService placeLocalService;

    @Reference(unbind = "-")
    public void setPlaceLocalService(PlaceLocalService placeLocalService) {
        this.placeLocalService = placeLocalService;
    }



    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    @Override
    public void export(OutputStream stream, List<Place> places) throws IOException {
        // Export to Excel
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet("lieux");

        createHeaderRow(sheet);
        CellStyle cellStyle = createCellStyle(workbook);
        populateDataRows(sheet, places, cellStyle);

        workbook.write(stream);
        workbook.close();

    }

    private void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Alias", "Type", "Territoire", "Statut"};
        // Make the header bold
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
            Font font = sheet.getWorkbook().createFont();
            font.setBold(true);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
        }
    }

    private CellStyle createCellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        return cellStyle;
    }

    private void populateDataRows(Sheet sheet, List<Place> places, CellStyle cellStyle) {
        int rowNum = 1;
        for (Place place : places) {
            Row row = sheet.createRow(rowNum++);

            createCell(row, 0, place.getAlias(Locale.FRANCE, true), cellStyle);
            createCell(row, 1, buildTypePlace(place), cellStyle);
            createCell(row, 2, buildTerritory(place), cellStyle);
            createCell(row, 3, LanguageUtil.get(Locale.FRANCE,WorkflowConstants.getStatusLabel(place.getStatus())) , cellStyle);
        }
    }

    private void createCell(Row row, int column, String value, CellStyle cellStyle) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    public String buildTypePlace(Place place) {
        StringBuilder typePlace = new StringBuilder();
        List<AssetCategory> categories = place.getTypes();

        for (AssetCategory category : categories) {
            if (typePlace.length() > 0) {
                typePlace.append(", ");
            }
            typePlace.append(category.getName());
        }

        return typePlace.toString();
    }

    public String buildTerritory(Place place) {
        StringBuilder territory = new StringBuilder();
        List<AssetCategory> categories = place.getTerritories();

        for (AssetCategory category : categories) {
            if (territory.length() > 0) {
                territory.append(", ");
            }
            territory.append(category.getName());
        }

        return territory.toString();
    }
}
