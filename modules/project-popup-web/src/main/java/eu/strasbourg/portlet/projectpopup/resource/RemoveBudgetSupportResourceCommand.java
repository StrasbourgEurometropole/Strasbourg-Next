package eu.strasbourg.portlet.projectpopup.resource;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetSupport;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalServiceUtil;
import eu.strasbourg.service.project.service.BudgetSupportLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component(
	immediate = true,
    property = {
            "javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_POPUP_WEB,
            "mvc.command.name=removeBudgetSupport"
    },
    service = MVCResourceCommand.class
)
public class RemoveBudgetSupportResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response) {
		
		boolean result = false;

        // Initialisations respectives de : nombre de votes pour l'entite courante, le nombre de votes de l'utilisateur
        // pour l'entite courante, le nombre de votes de l'utilisateur, le nombre de votes pour la phase active
        int nbUserSupports = 0;
        int nbUserUnsupports = 0;
        int nbUserEntrySupports = 0;
        int nbEntrySupports = 0;
        long nbSupportForActivePhase = 0;
        long nbUnsupportForActivePhase = 0;
        long nbUserSupportForEntry = 0;
        long thresholdNegative = 0;
		
		// Recuperation de l'utilsiteur Publik ayant lance la demande
        PublikUser user = null;
        String publikID = getPublikID(request);
        if (publikID != null && !publikID.isEmpty()) {
            user = PublikUserLocalServiceUtil.getByPublikUserId(publikID);
        }
        
        // Recuperation du budget participatif en question
        BudgetParticipatif budgetParticipatif = null;
        long entryID = ParamUtil.getLong(request, "entryId");
        BudgetSupport budgetSupport = null;
        try {
            AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(entryID);
            budgetParticipatif = BudgetParticipatifLocalServiceUtil.getBudgetParticipatif(assetEntry.getClassPK());
            // Recuperation du nombre de votes + de l'utilisateur
            nbUserSupports = budgetParticipatif.getNbSupportOfUserInActivePhase(publikID);
            // Recuperation du nombre de votes - de l'utilisateur
            nbUserUnsupports = budgetParticipatif.getNbUnsupportOfUserInActivePhase(publikID);
            // Recuperation du nombre de votes + de l'utilisateur pour l'entite courante
            nbUserEntrySupports = budgetParticipatif.getNbPositiveSupportOfUser(publikID);
            // Recuperation du nombre de votes + et - pour l'entite courante
            nbEntrySupports = (int) budgetParticipatif.getNbSupports();
            // Recuperation du nombre de votes + pour la phase
            nbSupportForActivePhase = budgetParticipatif.getPhase().getNumberOfVote();
            // Recuperation du nombre de votes - pour la phase
            nbUnsupportForActivePhase = budgetParticipatif.getPhase().getNumberOfNegativeVote();
            // Recuperation du nombre max de votes + pour l'entité pour un utilisateur
            nbUserSupportForEntry = budgetParticipatif.getPhase().getMaxVoteBudget();
            // Recuperation du seuil de votes + pour permettre les votes -
            thresholdNegative = budgetParticipatif.getPhase().getThresholdNegative();

            // Recuperation du 1er budget support positif lié
            budgetSupport = BudgetSupportLocalServiceUtil.getBudgetSupportPositifByBudgetParticipatifIdAndPublikUserId(
                    budgetParticipatif.getBudgetParticipatifId(),
                    publikID).stream().findFirst().orElse(null);
        } catch (PortalException e1) {
            _log.error(e1);
        }


        // Verification de la validite des informations
        String message = validate(publikID, user, budgetParticipatif, budgetSupport, nbUserUnsupports);
        if (message.equals("")) {

            if (budgetSupport != null) {
                result = removeBudgetSupport(budgetSupport);
            }
        }
        
        // Récupération du json des entités
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        jsonResponse.put("result", result);
        jsonResponse.put("message", message);
        
        JSONObject updatedSupportsInfo = JSONFactoryUtil.createJSONObject();

        updatedSupportsInfo.put("nbUserSupports", nbUserSupports);
        updatedSupportsInfo.put("nbUserUnsupports", nbUserUnsupports);
        updatedSupportsInfo.put("nbUserEntrySupports", nbUserEntrySupports);
        updatedSupportsInfo.put("nbEntrySupports", nbEntrySupports);
        updatedSupportsInfo.put("nbSupportForActivePhase", nbSupportForActivePhase);
        updatedSupportsInfo.put("nbUnsupportForActivePhase", nbUnsupportForActivePhase);
        updatedSupportsInfo.put("nbUserSupportForEntry", nbUserSupportForEntry);
        updatedSupportsInfo.put("thresholdNegative", thresholdNegative);
        
        jsonResponse.put("updatedSupportsInfo", updatedSupportsInfo);

        // Recuperation de l'élément d'écriture de la réponse
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
        	_log.error(e);
        }
        if (writer != null) {
            writer.print(jsonResponse.toString());
        }

        return result;
	}
	
	/**
	 * Envoi de la demande de supression de soutien
	 * @return Si la demande s'est bien passee
	 */
	private boolean removeBudgetSupport(BudgetSupport budgetSupport) {
        BudgetSupportLocalServiceUtil.removeBudgetSupport(budgetSupport.getBudgetSupportId());

        _log.info("Soutien retire : " + budgetSupport);
        return true;
    }
	
	/**
	 * Verification des information du formulaire issu de la requete et validation
	 * du contexte fonctionnel de la requete (ex: vote possible, entite perime, etc)
	 * @return Si la requete est tangible
	 */
	private String validate(String publikID, PublikUser user, BudgetParticipatif budgetParticipatif, BudgetSupport budgetSupport, int nbUserUnsupports) {
		
		// Utilisateur
        if (publikID == null || publikID.isEmpty()) {
            return "Utilisateur non recconu";
        } else {
        	if (user.isBanned()) {
                return "Vous ne pouvez revenir sur votre vote";
        	} else if (user.getPactSignature() == null) {
                return "Vous devez signer le Pacte pour revenir sur votre vote";
        	}
        }

        // Vote négatif
        if (nbUserUnsupports > 0) {
            return "Vous ne pouvez plus retirer votre vote apr\u00e8s avoir vot\u00e9 n\u00e9gativement";
        }

        // Budget participatif
        if (budgetParticipatif != null) {
            if (!budgetParticipatif.isVotable()) {
                return "Ce budget participatif n\u0027est pas en phase de vote";
            }
        } else {
            return "Erreur lors de la recherche du budget participatif";
        }

        // Soutien
        if (Validator.isNull(budgetSupport)) {
            return "Erreur lors de la recherche du vote";
        }
        
        return "";
	}
	
	/**
     * Recuperation du publik ID avec la session
     */
    private String getPublikID(PortletRequest request) {
        LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(request);
        HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();
        return SessionParamUtil.getString(originalRequest, "publik_internal_id");
    }
	
	/**
     * Le log
     */
    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
