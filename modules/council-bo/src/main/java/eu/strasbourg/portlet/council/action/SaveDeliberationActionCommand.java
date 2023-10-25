package eu.strasbourg.portlet.council.action;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.council.constants.StageDeliberation;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.model.Type;
import eu.strasbourg.service.council.service.CouncilSessionLocalServiceUtil;
import eu.strasbourg.service.council.service.DeliberationLocalService;
import eu.strasbourg.service.council.service.TypeLocalService;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.util.Date;
import java.util.List;

@Component(
        immediate = true,
        property = { "javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO,
                "mvc.command.name=saveDeliberation" },
        service = MVCActionCommand.class)
public class SaveDeliberationActionCommand extends BaseMVCActionCommand {

    private DeliberationLocalService deliberationLocalService;

    @Reference(unbind = "-")
    protected void setDeliberationLocalService(
            DeliberationLocalService deliberationLocalService) {
        this.deliberationLocalService = deliberationLocalService;
    }

    private TypeLocalService typeLocalService;

    @Reference(unbind = "-")
    protected void setTypeLocalService(
            TypeLocalService typeLocalService) {
        this.typeLocalService = typeLocalService;
    }

    @Override
    protected void doProcessAction(ActionRequest request,
                                   ActionResponse response) throws Exception {

        // Récupération des paramètres
        ServiceContext sc = ServiceContextFactory.getInstance(request);
        ThemeDisplay themeDisplay = (ThemeDisplay) request
                .getAttribute(WebKeys.THEME_DISPLAY);
        String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);

        long deliberationId = ParamUtil.getLong(request, "deliberationId");
        int order = ParamUtil.getInteger(request, "order");
        String amendement = ParamUtil.getString(request, "amendement");
        String title = ParamUtil.getString(request, "title");
        long councilSessionId = ParamUtil.getLong(request, "councilSessionId");

        Deliberation deliberation;
        String stage;
        Date dateStatus = null;
        boolean isNew = false;
        boolean isValid;

        // Création ou mise à jour de la déliberation
        if (deliberationId == 0) {
            deliberation = deliberationLocalService.createDeliberation(sc);
            stage = StageDeliberation.get(1).getName();
            deliberation.setStage(stage);
            isNew = true;
        } else {
            stage = ParamUtil.getString(request, "stage");
            deliberation = deliberationLocalService.getDeliberation(deliberationId);
            dateStatus = deliberation.getStatusDate();

            String deliberationStage = deliberation.getStage();
            if (deliberationStage.equals(StageDeliberation.ADOPTE.getName()) || deliberationStage.equals(StageDeliberation.REJETE.getName()) || deliberationStage.equals(StageDeliberation.COMMUNIQUE.getName())) {
                if (!title.equals(deliberation.getTitle()) || councilSessionId != deliberation.getCouncilSessionId()) {
                    SessionErrors.add(request, "stage-deliberation-error");
                    errorResponse(request, response, themeDisplay, portletName);
                    return;
                }
            }
        }

        // Validation
        isValid = validate(request);
        if (!isValid) {
            errorResponse(request, response, themeDisplay, portletName);
            return;
        }

        // Set des champs de la délibération
        deliberation.setOrder(order);
        deliberation.setAmendement(amendement);
        deliberation.setTitle(title);
        deliberation.setCouncilSessionId(councilSessionId);

        CouncilSession council = CouncilSessionLocalServiceUtil.fetchCouncilSession(councilSessionId);
        // Récupère la catégorie du conseil
        AssetVocabulary conseil = AssetVocabularyHelper.getVocabulary(VocabularyNames.COUNCIL_SESSION, themeDisplay.getScopeGroupId());
        Type type = this.typeLocalService.fetchType(council.getTypeId());
        AssetCategory typeCategory = conseil.getCategories().stream().filter(c -> c.getName().equals(type.getTitle())).findFirst().get();
        AssetCategory councilCategory = AssetCategoryLocalServiceUtil.getChildCategories(typeCategory.getCategoryId()).stream().filter(c -> c.getName().equals(council.getTitle())).findFirst().get();

        if (deliberation != null && deliberation.getAssetEntry() != null) {
            //Récupère les anciennes catégories liées au statut pour les effacer (on veut qu'un seul abonnement à une catégorie de statut, celui en cours)
            List<AssetCategory> existingStageCategories = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(deliberation.getAssetEntry(), "Statut");
            for (AssetCategory existingCat : existingStageCategories) {
                AssetEntryLocalServiceUtil.deleteAssetCategoryAssetEntry(existingCat.getCategoryId(), deliberation.getAssetEntry().getEntryId());
            }
        }
        AssetCategory stageCategory = AssetVocabularyHelper.getCategory(deliberation.getStage(), themeDisplay.getScopeGroupId());

        if (councilCategory != null && stageCategory != null) {
            sc.setAssetCategoryIds(new long[]{councilCategory.getCategoryId(), stageCategory.getCategoryId()});
        } else if (councilCategory != null)
            sc.setAssetCategoryIds(new long[]{councilCategory.getCategoryId()});
        else if (stageCategory != null)
            sc.setAssetCategoryIds(new long[]{stageCategory.getCategoryId()});

        // Update de l'entité
        deliberationLocalService.updateDeliberation(deliberation, sc);

        // Parce que le SC enregistre une date NULL
        if (isNew) {
            deliberation.setStatusDate(new Date());
            deliberationLocalService.updateDeliberation(deliberation);
        } else {
            deliberation.setStatusDate(dateStatus);
            deliberationLocalService.updateDeliberation(deliberation);
        }

        // Post / Redirect / Get si tout est bon
        PortletURL renderURL = PortletURLFactoryUtil.create(request, portletName, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        renderURL.setParameter("tab", request.getParameter("tab"));
        response.sendRedirect(renderURL.toString());
    }

    /**
     * Validation des champs obligatoires
     */
    private boolean validate(ActionRequest request) {
        boolean isValid = true;

        if (Validator.isNull(ParamUtil.getString(request, "order"))) {
            SessionErrors.add(request, "order-error");
            isValid = false;
        }
        if (Validator.isNull(ParamUtil.getString(request, "title"))) {
            SessionErrors.add(request, "title-error");
            isValid = false;
        }
        if (Validator.isNull(ParamUtil.getString(request, "councilSessionId"))) {
            SessionErrors.add(request, "council-session-error");
            isValid = false;
        }
        return isValid;
    }

    /**
     * Permet de rester sur la même page lors d'une erreur
     */
    private void errorResponse(ActionRequest request, ActionResponse response, ThemeDisplay themeDisplay, String portletName) {

        // Si pas valide : on reste sur la page d'édition
        PortalUtil.copyRequestParameters(request, response);

        PortletURL returnURL = PortletURLFactoryUtil.create(request, portletName, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        returnURL.setParameter("tab", request.getParameter("tab"));

        response.setRenderParameter("returnURL", returnURL.toString());
        response.setRenderParameter("mvcPath", "/council-bo-edit-deliberation.jsp");
    }
}
