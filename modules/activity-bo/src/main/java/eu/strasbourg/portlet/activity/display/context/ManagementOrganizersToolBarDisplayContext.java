package eu.strasbourg.portlet.activity.display.context;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItemListBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.activity.model.ActivityOrganizer;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ManagementOrganizersToolBarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

    public ManagementOrganizersToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            ViewActivityOrganizersDisplayContext viewActivityOrganizersDisplayContext) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                viewActivityOrganizersDisplayContext.getSearchContainer());
        _viewActivityOrganizersDisplayContext= viewActivityOrganizersDisplayContext;

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
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
                                                dropdownItem.put("href", "javascript:publishSelection();");
                                                dropdownItem.setIcon("check");
                                                dropdownItem.setLabel(
                                                        LanguageUtil.get(httpServletRequest, "publish"));
                                                dropdownItem.setQuickAction(true);
                                            }
                                    ).build());
                            dropdownGroupItem.setSeparator(true);
                        }
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder.add(
                                            dropdownItem -> {
                                                dropdownItem.put("href", "javascript:unpublishSelection();");
                                                dropdownItem.setIcon("times");
                                                dropdownItem.setLabel(
                                                        LanguageUtil.get(httpServletRequest, "unpublish"));
                                                dropdownItem.setQuickAction(true);
                                            }
                                    ).build());
                            dropdownGroupItem.setSeparator(true);
                        }
                )
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
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "activityOrganizersSearchContainer";
    }

    /**
     * Sets the search container’s filtering options
     */
    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    getFilterVocabularyDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by"));
                        }
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(getOrderByDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "order-by")
                            );
                        }
                )
                .build();
    }
    /**
     * Add filtering options to Vocabulary
     */
    protected List<DropdownItem> getFilterVocabularyDropdownItems() {
        List<DropdownItem> filterVocabularyDropdownItems = new DropdownItemList();

        for (AssetVocabulary vocabulary : getActivityOrganizerVocabularies()) {
            filterVocabularyDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(_viewActivityOrganizersDisplayContext.hasVocabulary(vocabulary.getName()))
                            .setHref("javascript:getCategoriesByVocabulary(" + vocabulary.getVocabularyId() + ", '" + vocabulary.getName() + "');")
                            .setLabel(vocabulary.getName())
                            .build()
            );
        }

        return filterVocabularyDropdownItems;
    }

    /**
     * Sets the search container’s filter labels to display
     */
    @Override
    public List<LabelItem> getFilterLabelItems() {
        List<String[]> categoriesSelected = _viewActivityOrganizersDisplayContext.getCategVocabularies();
        LabelItemListBuilder.LabelItemListWrapper vocabulariesLabelItems = new LabelItemListBuilder.LabelItemListWrapper();

        MutableRenderParameters parameters = this.currentURLObj.getRenderParameters();
        String originalFilterCategoriesIdByVocabulariesName = parameters.getValue("filterCategoriesIdByVocabulariesName");
        for (String[] categorySelected : categoriesSelected) {
            try {
                PortletURL newURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);
                String filterCategoriesIdByVocabulariesName;
                if (originalFilterCategoriesIdByVocabulariesName.contains(categorySelected[0] + '_')) {
                    String regex = categorySelected[0] + "(.(?<!__))*__";
                    filterCategoriesIdByVocabulariesName = originalFilterCategoriesIdByVocabulariesName.replaceAll(regex, "");
                } else {
                    filterCategoriesIdByVocabulariesName = originalFilterCategoriesIdByVocabulariesName;
                }
                newURL.getRenderParameters().removeParameter("filterCategoriesIdByVocabulariesName");
                vocabulariesLabelItems.add(
                        labelItem -> {
                            labelItem.putData(
                                    "removeLabelURL",
                                    PortletURLBuilder.create(
                                                    PortletURLUtil.clone(newURL, liferayPortletResponse))
                                            .setParameter("filterCategoriesIdByVocabulariesName", filterCategoriesIdByVocabulariesName)
                                            .buildString());
                            labelItem.setCloseable(true);
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
     * Fields that can be sorted
     */
    @Override
    protected String[] getOrderByKeys() {
        return new String[] { "publication-date", "modified-date","title", "status" };
    }




    /**
     * The URL to reset the search
     */
    @Override
    public String getClearResultsURL() {
        return PortletURLBuilder.create(getPortletURL())
                .setKeywords("")
                .setParameter( "orderByCol", "modified-date")
                .setParameter( "orderByType", "desc")
                .setParameter( "filterCategoriesIdByVocabulariesName", "")
                .buildString();
    }

    /**
     * The action URL to send the search form
     */
    @Override
    public String getSearchActionURL() {
        return PortletURLBuilder.createRenderURL(liferayPortletResponse)
                .setMVCPath("/activity-bo-view-organizers.jsp")
                .setParameter("O")
                .setParameter( "orderByCol", ParamUtil.getString( liferayPortletRequest, "orderByCol"))
                .setParameter( "orderByType", ParamUtil.getString(liferayPortletRequest, " orderByType "))
                .setParameter("tab","activityOrganizers").buildString();
    }

    /**
     * The search form’s name
     */
    @Override
    public String getSearchFormName() {
        return "fm1";
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
                            "tab", "activityOrganizers",
                            "cmd", "editActivityOrganizer",
                            "mvcPath", "/activity-bo-edit-organizer.jsp",
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
                StrasbourgPortletKeys.ACTIVITY_BO, StrasbourgPortletKeys.ACTIVITY_BO, "ADD_ACTIVITY_ORGANIZER") &&
                group.getStagingGroup() == null){
            return true;
        }
        return false;

    }
    /**
     * Get ActivityCourse Vocabularies
     */
    protected List<AssetVocabulary> getActivityOrganizerVocabularies() {
        if(_vocabularies == null) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) httpServletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);
            long companyGroupId = themeDisplay.getCompanyGroupId();
            long classNameId = ClassNameLocalServiceUtil.getClassNameId(ActivityOrganizer.class);
            long scopeGroupId = themeDisplay.getScopeGroupId();
            List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil
                    .getAssetVocabularies(-1, -1).stream()
                    .filter(v -> (v.getGroupId() == companyGroupId || v.getGroupId() == scopeGroupId) && LongStream.of(v.getSelectedClassNameIds())
                            .anyMatch(c -> c == classNameId))
                    .collect(Collectors.toList());
            _vocabularies = vocabularies;
        }

        return _vocabularies;
    }

    private final ViewActivityOrganizersDisplayContext _viewActivityOrganizersDisplayContext;
    private final ThemeDisplay _themeDisplay;
    private List<AssetVocabulary> _vocabularies;

}