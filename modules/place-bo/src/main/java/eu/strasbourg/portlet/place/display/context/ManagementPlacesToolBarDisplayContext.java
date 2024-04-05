package eu.strasbourg.portlet.place.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ManagementPlacesToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<Place> {

    public ManagementPlacesToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                Place.class, searchContainer);

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * Dans la liste de vocabulaire, on regarde si le User a un type de lieu en category (pour limiter l'accès aux fiches lieu)
     * Si c'est le cas on l'empêche d'avoir le filtre par "Type de lieu"
     * Si pas de catégorie sur le Uer, on a accès au vocabulaire à filtrer
     * @return Liste des vocabulaires sur lesquels on veut filtrer
     */
    @Override
    protected List<AssetVocabulary> getVocabularies() {
        if(_vocabularies == null) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) httpServletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);
            List<AssetCategory> categoriesUser = AssetCategoryLocalServiceUtil.getCategories(User.class.getName(), themeDisplay.getUserId());
            List<Long> vocabIdUser = new ArrayList<>();
            for (AssetCategory assetCategory : categoriesUser) {
                vocabIdUser.add(assetCategory.getVocabularyId());
            }
            long companyGroupId = themeDisplay.getCompanyGroupId();
            long classNameId = ClassNameLocalServiceUtil.getClassNameId(Place.class);
            long scopeGroupId = themeDisplay.getScopeGroupId();
            _vocabularies = AssetVocabularyLocalServiceUtil
                    .getAssetVocabularies(-1, -1).stream()
                    .filter(v -> (v.getGroupId() == companyGroupId || v.getGroupId() == scopeGroupId) && LongStream.of(v.getSelectedClassNameIds())
                            .anyMatch(c -> c == classNameId) && !vocabIdUser.contains(v.getVocabularyId()))
                    .collect(Collectors.toList());
        }

        return _vocabularies;
    }

    @Override
    protected boolean hasUpdatePermission() {
        return !WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
                _themeDisplay.getCompanyId(), _themeDisplay.getScopeGroupId(),
                Place.class.getName())
                && _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.PLACE_BO, StrasbourgPortletKeys.PLACE_BO, "EDIT_PLACE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    @Override
    protected boolean hasDeletePermission() {
        return _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.PLACE_BO, StrasbourgPortletKeys.PLACE_BO, "DELETE_PLACE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "placesSearchContainer";
    }

    private final ThemeDisplay _themeDisplay;
    private List<AssetVocabulary> _vocabularies;
}