package eu.strasbourg.portlet.help.context;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ManagementHelpSeekersToolBarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

    public ManagementHelpSeekersToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            ViewHelpSeekersDisplayContext viewHelpSeekersDisplayContext) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                viewHelpSeekersDisplayContext.getSearchContainer());
        _viewHelpSeekersDisplayContext = viewHelpSeekersDisplayContext;

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
        return "helpSeekersSearchContainer";
    }

    /**
     * Sets the search container’s filtering options
     */
    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return DropdownItemListBuilder
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

        for (AssetVocabulary vocabulary : getHelpSeekerVocabularies()) {
            filterVocabularyDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(_viewHelpSeekersDisplayContext.hasVocabulary(vocabulary.getName()))
                            .setHref("javascript:getCategoriesByVocabulary("+vocabulary.getVocabularyId()+");")
                            .setLabel(vocabulary.getName())
                            .build()
            );
        }

        return filterVocabularyDropdownItems;
    }

    /**
     * Sets the search container’s filter labels to display
     */
    // TODO : A revoir car pas testé ni fini
    @Override
    public List<LabelItem> getFilterLabelItems() {
        Map<String, String> categVocabulariesSelected = _viewHelpSeekersDisplayContext.getCategVocabularies();
        LabelItemListBuilder.LabelItemListWrapper vocabulariesLabelItems = new LabelItemListBuilder.LabelItemListWrapper();

        for (AssetVocabulary vocabulary : getHelpSeekerVocabularies()) {
            vocabulariesLabelItems.add(
                    () -> categVocabulariesSelected.keySet().contains(vocabulary.getName()),
                    labelItem -> {
                        labelItem.putData(
                                "removeLabelURL",
                                PortletURLBuilder.create(
                                                PortletURLUtil.clone(currentURLObj, liferayPortletResponse))
                                        .setParameter(vocabulary.getName(), "")
                                        .buildString());

                        labelItem.setCloseable(true);

                        String categ = categVocabulariesSelected.get(vocabulary.getName());

                        labelItem.setLabel(vocabulary.getName() + ": " + categ);
                    }
            );
        }

        return vocabulariesLabelItems.build();
    }

    /**
     * Fields that can be sorted
     */
    @Override
    protected String[] getOrderByKeys() {
        return new String[] { "last-name", "first-name", "email", "request-create-date", "nb-requests"};
    }




    /**
     * The URL to reset the search
     */
    // TODO : Il faudra rajouter la réinitialisation des vocabulaires
    @Override
    public String getClearResultsURL() {
        return PortletURLBuilder.create(getPortletURL())
                .setKeywords("")
                .setParameter( "orderByCol", "modified-date")
                .setParameter( "orderByType", "desc")
                .buildString();
    }

    /**
     * The action URL to send the search form
     */
    @Override
    public String getSearchActionURL() {

        return PortletURLBuilder.createRenderURL(liferayPortletResponse)
                .setMVCPath("/help-bo-view-help-seekers.jsp")
                .setParameter("O")
                .setParameter( "orderByCol", ParamUtil.getString( liferayPortletRequest, "orderByCol"))
                .setParameter( "orderByType", ParamUtil.getString(liferayPortletRequest, " orderByType "))
                .setParameter("tab","helpSeekers").buildString();
    }

    /**
     * The search form’s name
     */
    @Override
    public String getSearchFormName() {
        return "fm1";
    }



    /**
     * Get Help HelpSeeker Vocabularies
     */
    protected List<AssetVocabulary> getHelpSeekerVocabularies() {
        if(_vocabularies == null) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) httpServletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);
            long companyGroupId = themeDisplay.getCompanyGroupId();
            long classNameId = ClassNameLocalServiceUtil.getClassNameId(ViewHelpSeekersDisplayContext.HelpSeeker.class);
            long scopeGroupId = themeDisplay.getScopeGroupId();
            List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil
                    .getAssetVocabularies(-1, -1).stream()
                    .filter(v -> (v.getGroupId() == companyGroupId || v.getGroupId() == scopeGroupId)
                            && LongStream.of(v.getSelectedClassNameIds())
                            .anyMatch(c -> c == classNameId))
                    .collect(Collectors.toList());
            _vocabularies = vocabularies;
        }

        return _vocabularies;
    }

    private final ViewHelpSeekersDisplayContext _viewHelpSeekersDisplayContext;
    private final ThemeDisplay _themeDisplay;
    private List<AssetVocabulary> _vocabularies;

}