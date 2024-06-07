/**
 * Copyright 2000-present Liferay, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.strasbourg.portlet.council.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.council.constants.OfficialDataConstants;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.model.Type;
import eu.strasbourg.service.council.service.OfficialLocalService;
import eu.strasbourg.service.council.service.TypeLocalService;
import eu.strasbourg.utils.ImportCsvHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(immediate = true, property = {"javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO,
        "mvc.command.name=getDataToImportOfficials"}, service = MVCActionCommand.class)
public class GetDataToImportOfficialsActionCommand implements MVCActionCommand {

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());


    @Reference(unbind = "-")
    protected void setTypeLocalService(TypeLocalService typeLocalService) {
        this.typeLocalService = typeLocalService;
    }

    private TypeLocalService typeLocalService;

    @Reference(unbind = "-")
    protected void setOfficialLocalService(OfficialLocalService officialLocalService) {
        this.officialLocalService = officialLocalService;
    }

    private OfficialLocalService officialLocalService;
    private List<String> types;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {

        try {
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
            File officialsCsv = uploadRequest.getFile("officials-file");

            // Vérification du header du CSV et de l'extension
            String filename = officialsCsv.getName();
            int pos = filename.lastIndexOf('.');
            String extension = pos > 0 ? filename.substring(pos + 1) : "";

            boolean isValid = validate(request, extension, officialsCsv);
            if (!isValid) {
                return false;
            }

            // Récupération des données du fichier sans gestion en base de données -> écran intermédiaire
            List<Map<String, String>> officialsToCreate = new ArrayList<>();
            List<Map<String, String>> officialsToUpdate = new ArrayList<>();
            List<Map<String, String>> officialsToDelete = new ArrayList<>();
            List<String> errorParse = new ArrayList<>();
            CSVFormat csvFileFormat = CSVFormat.EXCEL.withHeader(OfficialDataConstants.OFFICIALS_HEADER_MAPPING).withDelimiter(',');
            CSVParser csvFileParser = CSVParser.parse(officialsCsv, Charset.forName("windows-1252"), csvFileFormat);
            List<CSVRecord> csvRecords = csvFileParser.getRecords();
            // Check if email is duplicated
            List<String> emails = new ArrayList<>();
            if (csvRecords.size() > 0) {
                for (int i = 1; i < csvRecords.size(); i++) {
                    CSVRecord record = csvRecords.get(i);
                    // Get email
                    String email = record.get(OfficialDataConstants.EMAIL);
                    String errorDuplicate = "";
                    if (emails.contains(email)) {
                        errorDuplicate = "Colonne: EMAIL : " + "L'email " + email + " est pr\u00e9sent plusieurs fois dans le CSV<br>";
                    } else {
                        emails.add(email);
                    }
                    // Récupération des données de la ligne CSV
                    String erreur = validate(record);
                    if(Validator.isNotNull(erreur))
                        errorParse.add("<br><strong>Ligne " + i + "</strong> : <br>" + errorDuplicate + erreur);
                    else {
                        Map<String, String> official = new HashMap<>();
                        official.put(OfficialDataConstants.NOM, record.get(OfficialDataConstants.NOM));
                        official.put(OfficialDataConstants.PRENOM, record.get(OfficialDataConstants.PRENOM));
                        official.put(OfficialDataConstants.EMAIL, record.get(OfficialDataConstants.EMAIL));
                        official.put(OfficialDataConstants.TYPE_CONSEIL, record.get(OfficialDataConstants.TYPE_CONSEIL));
                        // vérification si email existant
                        Official officialBDD = officialLocalService.findByEmail(record.get(OfficialDataConstants.EMAIL));
                        if (Validator.isNull(officialBDD)){
                            officialsToCreate.add(official);
                        }
                        else {
                            official.put(OfficialDataConstants.ID, String.valueOf(officialBDD.getOfficialId()));
                            if(Validator.isNull(record.get(OfficialDataConstants.TYPE_CONSEIL))) {
                                officialsToDelete.add(official);
                            }else{
                                officialsToUpdate.add(official);
                            }
                        }
                    }
                }
            }

            if (errorParse.isEmpty()) {
                request.setAttribute("toImport", "true");
                HttpServletRequest originalRequest = PortalUtil.getHttpServletRequest(request);
                HttpSession session = originalRequest.getSession();
                session.setAttribute("officialsToCreate", officialsToCreate);
                session.setAttribute("officialsToUpdate", officialsToUpdate);
                session.setAttribute("officialsToDelete", officialsToDelete);
//                request.setAttribute("returnURL", ParamUtil.getString(request, "returnURL"));
            } else {
                SessionErrors.add(request, "error-parse-order");
                request.setAttribute("errorParse", String.join("\n", errorParse));
                return false;
            }

        } catch (Exception e) {
            SessionErrors.add(request, "error-import-officials");
            request.setAttribute("error", e.getMessage());
            _log.error(e);
            return false;
        }
        return true;
    }

    /**
     * Effectue les vérifications sur le header
     */
    private boolean validate(ActionRequest actionRequest, String extension, File officialsCsv) throws IOException {

        String errorCsvCheck = ImportCsvHelper.csvCheckHeader(officialsCsv, OfficialDataConstants.OFFICIALS_HEADER_MAPPING, '\t', ',');
        if (Validator.isNotNull(errorCsvCheck) || !extension.equals("csv")) {
            SessionErrors.add(actionRequest, "error-import-officials");
            actionRequest.setAttribute("error", errorCsvCheck);

            _log.error(errorCsvCheck);
            return false;
        }
        return true;
    }

    /**
     * Effectue les vérifications sur les lignes du fichier CSV
     */
    private String validate(CSVRecord rowRecord) {
        List<String> error = new ArrayList<>();

        // Vérification si la ligne n'est pas null et si la première colonne n'est pas null
        if (rowRecord != null && rowRecord.get(0) != null) {

            // Vérification de l'Email
            String email = rowRecord.get(OfficialDataConstants.EMAIL);
            verifierChamp(email, OfficialDataConstants.EMAIL, true, 75, error);
            if (!Validator.isEmailAddress(email)) {
                error.add("Colonne : " + OfficialDataConstants.EMAIL + " : email invalide");
            }

            // Vérification du nom
            String nom = rowRecord.get(OfficialDataConstants.NOM);
            verifierChamp(nom, OfficialDataConstants.NOM, true, 75, error);

            // Vérification du prénom
            String prenom = rowRecord.get(OfficialDataConstants.PRENOM);
            verifierChamp(prenom, OfficialDataConstants.PRENOM, true, 75, error);

            // Vérification du type de conseil
            String[] councilTypes = rowRecord.get(OfficialDataConstants.TYPE_CONSEIL).split(";");
            verifierTypeConseil(councilTypes, error);
        }


        // Join the string with <br>
        return String.join("<br>", error);
    }

    /**
     * Vérifie les champs communs
     */
    private void verifierChamp(String valeur, String colonne, boolean obligatoire, int longueurMax, List<String> error) {
        if (Validator.isNull(valeur)) {
            if (obligatoire) {
                error.add(" Colonne : " + colonne +" : Champ obligatoire");
            }
        } else {
            if (valeur.length() > longueurMax) {
                error.add(" Colonne : " + colonne + " : Valeur trop longue. Taille max : " + longueurMax + " caract\u00e8res");
            }
        }
    }

    /**
     * Vérifie le type de conseil
     */
    private void verifierTypeConseil(String[] councilTypes, List<String> error) {
        StringBuilder errorTypes = new StringBuilder();
        for (String councilType : councilTypes) {
            if (!getTypes().contains(councilType)) {
                if (errorTypes.length() > 0) {
                    errorTypes.append(", ");
                }
                errorTypes.append(councilType);
            }
        }
        if (errorTypes.length() > 0) {
            error.add("Colonne " + OfficialDataConstants.TYPE_CONSEIL + " : le(s) type(s) : " + errorTypes + " n'existe(nt) pas");
        }
    }


    /**
     * Récupère les types de conseil
     */
    private List<String> getTypes() {

        if (Validator.isNull(types)) {
            types = typeLocalService.getTypes(-1,-1).stream()
                    .map(Type::getTitle).collect(Collectors.toList());

        }
        return types;
    }
}
