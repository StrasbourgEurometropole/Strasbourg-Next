package eu.strasbourg.portlet.council.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItemListBuilder;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagementDeliberationsToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<Deliberation> {

    public ManagementDeliberationsToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer, String filterCategories) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                Deliberation.class, searchContainer);

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        _filterCategories = filterCategories;
    }

    /**
     * The list of dropdown items to display when a result is checked
     * or the master checkbox in the Management Toolbar is checked
     */
    @Override
    public List<DropdownItem> getActionDropdownItems() {
        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder.add(
                                            dropdownItem -> {
                                                dropdownItem.put("href", "javascript:deleteSelection();");
                                                dropdownItem.setIcon("trash");
                                                dropdownItem.setLabel(
                                                        LanguageUtil.get(httpServletRequest, "delete"));
                                                dropdownItem.setQuickAction(true);
                                            }
                                    ).build());
                            dropdownGroupItem.setSeparator(true);
                        }
                )
                .build();
    }

    /**
     * Récupère le String des Vocabulaire/catégorie/categId sur lesquels on doit filtrer
     *  qui se présente comme suit :
     * "vocabularyName__categoryName__categoryId___..."
     */
    @Override
    public String getFilterCategoriesIdByVocabulariesName() {
        return _filterCategories;
    }

    /**
     * Sets the search container’s filter labels to display
     */
    @Override
    public List<LabelItem> getFilterLabelItems() {
        LabelItemListBuilder.LabelItemListWrapper vocabulariesLabelItems = new LabelItemListBuilder.LabelItemListWrapper();

        String originalFilterCategoriesIdByVocabulariesName = _filterCategories;
        for (String filterCategoryIdByVocabularyName : getListFilterCategoriesIdByVocabulariesName()) {
            try {
                PortletURL newURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);
                String filterCategoriesIdByVocabulariesName;
                // on enlève le vocabularyName__CategoryName__CategoryId___ correspondant du paramètre
                filterCategoriesIdByVocabulariesName = originalFilterCategoriesIdByVocabulariesName
                        .replace(filterCategoryIdByVocabularyName + "___", "");
                newURL.getRenderParameters().removeParameter("filterCategoriesIdByVocabulariesName");
                vocabulariesLabelItems.add(
                        labelItem -> {
                            labelItem.putData("removeLabelURL",
                                    PortletURLBuilder.create(PortletURLUtil.clone(newURL, liferayPortletResponse))
                                            .setParameter("filterCategoriesIdByVocabulariesName", filterCategoriesIdByVocabulariesName)
                                            .buildString()
                            );
                            labelItem.setDismissible(true);
                            String[] categorySelected = filterCategoryIdByVocabularyName.split("__");
                            labelItem.setLabel(categorySelected[0] + " : " + categorySelected[1]);
                        }
                );
            } catch (PortletException e) {
                throw new RuntimeException(e);
            }
        }

        return vocabulariesLabelItems.build();
    }

    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "deliberationsSearchContainer";
    }

    /**
     * Fields that can be sorted
     */
    @Override
    protected String[] getOrderByKeys() {
        return new String[] { "order", "title"};
    }

    /**
     * creates an add menu button
     */
    @Override
    public CreationMenu getCreationMenu() {
        return CreationMenuBuilder.addPrimaryDropdownItem(
                dropdownItem -> {
                    ThemeDisplay themeDisplay =
                            (ThemeDisplay)httpServletRequest.getAttribute(
                                    WebKeys.THEME_DISPLAY);

                    dropdownItem.setHref(
                            liferayPortletResponse.createRenderURL(),
                            "tab", "deliberations",
                            "cmd", "editDeliberation",
                            "mvcPath", "/council-bo-edit-deliberation.jsp",
                            "backURL", themeDisplay.getURLCurrent());

                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "add"));
                }
        ).build();
    }

    /**
     * Add menu visibility
     */
    @Override
    public Boolean isShowCreationMenu() {
        ThemeDisplay themeDisplay =
                (ThemeDisplay)httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        Group group = themeDisplay.getScopeGroup();
        if(_themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.COUNCIL_BO, StrasbourgPortletKeys.COUNCIL_BO, "ADD_DELIBERATION") &&
                group.getStagingGroup() == null){
            return true;
        }
        return false;

    }

    private final ThemeDisplay _themeDisplay;
    private final String _filterCategories;



}