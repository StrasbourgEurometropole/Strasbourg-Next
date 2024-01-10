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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.council.constants.OfficialDataConstants;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.model.OfficialTypeCouncil;
import eu.strasbourg.service.council.model.Type;
import eu.strasbourg.service.council.service.OfficialLocalService;
import eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService;
import eu.strasbourg.service.council.service.TypeLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component(immediate = true, property = {"javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO,
        "mvc.command.name=startImportOfficials"}, service = MVCActionCommand.class)
public class StartImportOfficialsActionCommand implements MVCActionCommand {

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
    private List<Type> types;

    private OfficialLocalService officialLocalService;

    @Reference(unbind = "-")
    protected void setOfficialLocalService(OfficialLocalService officialLocalService) {
        this.officialLocalService = officialLocalService;
    }

    private OfficialTypeCouncilLocalService officialTypeCouncilLocalService;

    @Reference(unbind = "-")
    protected void setOfficialTypeCouncilLocalService(OfficialTypeCouncilLocalService officialTypeCouncilLocalService) {
        this.officialTypeCouncilLocalService = officialTypeCouncilLocalService;
    }

    private TypeLocalService typeLocalService;

    @Reference(unbind = "-")
    protected void setTypeLocalService(TypeLocalService typeLocalService) {
        this.typeLocalService = typeLocalService;
    }

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {

        HttpServletRequest originalRequest = PortalUtil.getHttpServletRequest(request);
        HttpSession session = originalRequest.getSession();
        List<Map<String, String>> officialsToCreate = (List<Map<String, String>>) session.getAttribute("officialsToCreate");
        List<Map<String, String>> officialsToUpdate = (List<Map<String, String>>) session.getAttribute("officialsToUpdate");
        List<Map<String, String>> officialsToDelete = (List<Map<String, String>>) session.getAttribute("officialsToDelete");
        try {

            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

            // Import en base de données
            for (Map<String, String> officialToCreate : officialsToCreate) {
                // Création d'un votant
                Official official = officialLocalService.createOfficial(serviceContext);
                official.setLastname(officialToCreate.get(OfficialDataConstants.NOM));
                official.setFirstname(officialToCreate.get(OfficialDataConstants.PRENOM));
                official.setEmail(officialToCreate.get(OfficialDataConstants.EMAIL));
                official.setIsActive(true);
                // Mise à jour de l'entrée
                this.officialLocalService.updateOfficial(official, serviceContext);

                // Ajout des nouveaux types de conseil liés
                addOfficialTypes(official.getOfficialId(), officialToCreate.get(OfficialDataConstants.TYPE_CONSEIL), serviceContext);
            }

            for (Map<String, String> officialToUpdate : officialsToUpdate) {
                long id = Long.parseLong(officialToUpdate.get(OfficialDataConstants.ID));
                // gestion des types de conseil
                // Suppression des anciens types de conseil liés
                removeOfficialTypes(officialLocalService.fetchOfficial(id));
                // Ajout des nouveaux types de conseil liés
                addOfficialTypes(id, officialToUpdate.get(OfficialDataConstants.TYPE_CONSEIL), serviceContext);
            }

            for (Map<String, String> officialToDelete : officialsToDelete) {
                long id = Long.parseLong(officialToDelete.get(OfficialDataConstants.ID));
                // Inactivation du votant
                Official official = officialLocalService.fetchOfficial(id);
                official.setIsActive(false);
                // Mise à jour de l'entrée
                this.officialLocalService.updateOfficial(official, serviceContext);
                // gestion des types de conseil
                // Suppression des anciens types de conseil liés
                removeOfficialTypes(official);
            }

            SessionMessages.add(request, "import-successful");
        } catch (PortalException e) {
            SessionErrors.add(request, "error-parse-order");
            request.setAttribute("errorParse", e.getMessage());
            prepareErrorResponse(response);
            _log.error(e);
            return false;
        }
        return true;
    }

    /**
     * Permet de préparer la réponse dans le cas d'une erreur et de rester sur la même page
     */
    private void prepareErrorResponse(ActionResponse response) {
        response.setRenderParameter("cmd", "importOfficials");
        response.setRenderParameter("mvcPath", "/council-bo-import-officials.jsp");
    }

    /**
     * Permet la suppression des anciens type de conseil liés
     */
    private void removeOfficialTypes(Official official) throws PortalException {
        List<Type> oldCouncilsTypes = official.getCouncilTypes();
        for (Type type : oldCouncilsTypes) {
            officialTypeCouncilLocalService.removeOfficialTypeCouncil(official.getOfficialId(), type.getTypeId());
        }
    }

    /**
     * Permet l'ajout' des anciens type de conseil liés
     */
    private void addOfficialTypes(long id, String types, ServiceContext sc) {
        for (Type type : getTypes()) {
            if(Arrays.asList(types.split(";")).contains(type.getTitle())) {
                OfficialTypeCouncil newOfficialTypeCouncil = officialTypeCouncilLocalService.createOfficialTypeCouncil(id, type.getTypeId(), sc);
                officialTypeCouncilLocalService.updateOfficialTypeCouncil(newOfficialTypeCouncil);
            }
        }
    }

    /**
     * Récupère les types de conseil
     */
    private List<Type> getTypes() {
        if (Validator.isNull(types)) {
            types = typeLocalService.getTypes(-1,-1);
        }
        return types;
    }
}
