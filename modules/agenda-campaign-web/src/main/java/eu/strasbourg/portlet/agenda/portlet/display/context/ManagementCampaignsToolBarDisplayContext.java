package eu.strasbourg.portlet.agenda.portlet.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItemListBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.service.agenda.service.CampaignLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.VocabularyNames;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ManagementCampaignsToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<CampaignEvent> {

    public ManagementCampaignsToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            ViewCampaignEventsDisplayContext viewCampaignEventsDisplayContext) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                CampaignEvent.class, viewCampaignEventsDisplayContext.getSearchContainer());
        _viewCampaignEventsDisplayContext = viewCampaignEventsDisplayContext;

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * The list of dropdown items to display when a result is checked
     * or the master checkbox in the Management Toolbar is checked
     * Content : publish, unpublish and delete
     */
    @Override
    public List<DropdownItem> getActionDropdownItems() {
        if(isUserAManager()) {
            return DropdownItemListBuilder
                    .addGroup(
                            dropdownGroupItem -> {
                                dropdownGroupItem.setDropdownItems(
                                        DropdownItemListBuilder.add(
                                                dropdownItem -> {
                                                    dropdownItem.put("href", "javascript:updateSelectionStatus(1);");
                                                    dropdownItem.setIcon("check");
                                                    dropdownItem.setLabel(
                                                            LanguageUtil.get(httpServletRequest, "submit-to-validation"));
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
                                                    dropdownItem.put("href", "javascript:updateSelectionStatus(0);");
                                                    dropdownItem.setIcon("thumbs-up");
                                                    dropdownItem.setLabel(
                                                            LanguageUtil.get(httpServletRequest, "approve"));
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
                                                    dropdownItem.put("href", "javascript:updateSelectionStatus(4);");
                                                    dropdownItem.setIcon("thumbs-down");
                                                    dropdownItem.setLabel(
                                                            LanguageUtil.get(httpServletRequest, "deny"));
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
                                                    dropdownItem.put("href", "javascript:updateSelectionStatus(8);");
                                                    dropdownItem.setIcon("times");
                                                    dropdownItem.setLabel(
                                                            LanguageUtil.get(httpServletRequest, "request-deletion"));
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
                    .addGroup(
                            dropdownGroupItem -> {
                                dropdownGroupItem.setDropdownItems(
                                        DropdownItemListBuilder.add(
                                                dropdownItem -> {
                                                    dropdownItem.put("href", "javascript:updateSelectionStatus(-1);");
                                                    dropdownItem.setIcon("undo");
                                                    dropdownItem.setLabel(
                                                            LanguageUtil.get(httpServletRequest, "deny-deletion"));
                                                    dropdownItem.setQuickAction(true);
                                                }
                                        ).build());
                                dropdownGroupItem.setSeparator(true);
                            }
                    )
                    .build();
        }
        return null;
    }

    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "campaignEventsSearchContainer";
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
                                    getFilterByStatusDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-status"));
                        }
                )
               .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    getFilterCampaignDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-campaign")
                            );
                        }
                )
                .addGroup(

                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    getFilterTypeDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-type"));
                        }
                )
                .addGroup(

                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    getFilterThemeDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-theme"));
                        }
                )
                .build();
    }

    protected List<DropdownItem> getFilterByStatusDropdownItems() {
        List<DropdownItem> filterStatusDropdownItems = new DropdownItemList();
        for (Integer idStatus : getStatuses().keySet()) {
            filterStatusDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(_viewCampaignEventsDisplayContext.getStatusId() == idStatus)
                            .setHref(getPortletURL(), "statusId", String.valueOf(idStatus))
                            .setLabel(getStatuses().get(idStatus))
                            .build()
            );
        }

        return filterStatusDropdownItems;
    }

    protected List<DropdownItem> getFilterCampaignDropdownItems() {
        List<DropdownItem> filterCampaignDropdownItems = new DropdownItemList();
        for (Campaign campaign : getCampaigns()) {
            filterCampaignDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(_viewCampaignEventsDisplayContext.getCampaignId() == campaign.getCampaignId())
                            .setHref(getPortletURL(), "campaignId", String.valueOf(campaign.getCampaignId()))
                            .setLabel(campaign.getTitleCurrentValue())
                            .build()
            );
        }
        return filterCampaignDropdownItems;
    }

    protected List<DropdownItem> getFilterTypeDropdownItems() {
        List<DropdownItem> filterCampaignDropdownItems = new DropdownItemList();
        try {
            for (AssetCategory type : getTypes()) {
                filterCampaignDropdownItems.add(
                        DropdownItemBuilder
                                .setActive(_viewCampaignEventsDisplayContext.getTypeId() == type.getCategoryId())
                                .setHref(getPortletURL(), "typeId", String.valueOf(type.getCategoryId()))
                                .setLabel(type.getTitleCurrentValue())
                                .build()
                );
            }
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        return filterCampaignDropdownItems;
    }

    protected List<DropdownItem> getFilterThemeDropdownItems() {
        List<DropdownItem> filterCampaignDropdownItems = new DropdownItemList();
        try {
            for (AssetCategory theme : getThemes()) {
                filterCampaignDropdownItems.add(
                        DropdownItemBuilder
                                .setActive(_viewCampaignEventsDisplayContext.getCampaignId() == theme.getCategoryId())
                                .setHref(getPortletURL(), "themeId", String.valueOf(theme.getCategoryId()))
                                .setLabel(theme.getTitleCurrentValue())
                                .build()
                );
            }
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        return filterCampaignDropdownItems;
    }

    /**
     * Sets the search container’s filter labels to display
     */
    @Override
    public List<LabelItem> getFilterLabelItems() {
        LabelItemListBuilder.LabelItemListWrapper vocabulariesLabelItems = new LabelItemListBuilder.LabelItemListWrapper();

        vocabulariesLabelItems.add( () -> _viewCampaignEventsDisplayContext.getStatusId() != -1,
                labelItem -> {
                    labelItem.putData("removeLabelURL",
                            PortletURLBuilder.create(PortletURLUtil.clone(currentURLObj, liferayPortletResponse))
                                    .setParameter("statusId", -1)
                                    .buildString()
                    );
                    labelItem.setCloseable(true);
                    labelItem.setLabel(LanguageUtil.get(httpServletRequest, "status") + " : " + getStatuses().get(_viewCampaignEventsDisplayContext.getStatusId()));
                }
        );

        vocabulariesLabelItems.add( () -> _viewCampaignEventsDisplayContext.getCampaignId() != -1,
                labelItem -> {
                    labelItem.putData("removeLabelURL",
                            PortletURLBuilder.create(PortletURLUtil.clone(currentURLObj, liferayPortletResponse))
                                    .setParameter("campaignId", -1)
                                    .buildString()
                    );
                    labelItem.setCloseable(true);
                    labelItem.setLabel(LanguageUtil.get(httpServletRequest, "campaign") + " : " + getCampaignLabel());
                }
        );

        vocabulariesLabelItems.add( () -> _viewCampaignEventsDisplayContext.getTypeId() != -1,
                labelItem -> {
                    labelItem.putData("removeLabelURL",
                            PortletURLBuilder.create(PortletURLUtil.clone(currentURLObj, liferayPortletResponse))
                                    .setParameter("typeId", -1)
                                    .buildString()
                    );
                    labelItem.setCloseable(true);
                    labelItem.setLabel(LanguageUtil.get(httpServletRequest, "type") + " : " + getTypeLabel());
                }
        );

        vocabulariesLabelItems.add( () -> _viewCampaignEventsDisplayContext.getThemeId() != -1,
                labelItem -> {
                    labelItem.putData("removeLabelURL",
                            PortletURLBuilder.create(PortletURLUtil.clone(currentURLObj, liferayPortletResponse))
                                    .setParameter("themeId", -1)
                                    .buildString()
                    );
                    labelItem.setCloseable(true);
                    labelItem.setLabel(LanguageUtil.get(httpServletRequest, "theme") + " : " + getThemeLabel());
                }
        );

        return vocabulariesLabelItems.build();
    }

    /**
     * The URL to reset the search
     */
    @Override
    public String getClearResultsURL() {
        return PortletURLBuilder.create(getPortletURL())
                .setKeywords("")
                .setParameter( "statusId", -1)
                .setParameter( "campaignId", -1)
                .setParameter( "typeId", -1)
                .setParameter( "themeId", -1)
                .buildString();
    }

    /**
     * Retourne la liste des statuts possibles
     */
    public Map<Integer, String> getStatuses() {
        if (Validator.isNull(_statuses)) {
            Map<Integer, String> statuses = new HashMap<>();
            statuses.put(WorkflowConstants.STATUS_DRAFT, LanguageUtil.get(httpServletRequest, "draft"));
            statuses.put(WorkflowConstants.STATUS_APPROVED, LanguageUtil.get(httpServletRequest, "approved"));
            statuses.put(WorkflowConstants.STATUS_DENIED, LanguageUtil.get(httpServletRequest, "denied"));
            statuses.put(WorkflowConstants.STATUS_PENDING, LanguageUtil.get(httpServletRequest, "submitted"));
            statuses.put(WorkflowConstants.STATUS_IN_TRASH,
                    LanguageUtil.get(httpServletRequest, "deletion-requested"));
            _statuses = statuses;
        }
        return _statuses;
    }

    /**
     * Retourne la liste des campagnes
     */
    public List<Campaign> getCampaigns() {
        if (Validator.isNull(_campaigns)) {
            _campaigns = CampaignLocalServiceUtil.getCampaigns(-1,
                    -1);
        }
        return _campaigns;
    }

    public String getCampaignLabel() {
        String label = "";
        Campaign campaign = CampaignLocalServiceUtil.fetchCampaign(_viewCampaignEventsDisplayContext.getCampaignId());
        if(Validator.isNotNull(campaign)){
            label = campaign.getTitleCurrentValue();
        }
        return label;
    }

    /**
     * Retourne la liste des types
     */
    public List<AssetCategory> getTypes() throws PortalException {
        if (Validator.isNull(_types)) {
            AssetVocabulary vocabulary = AssetVocabularyHelper.getGlobalVocabulary(VocabularyNames.EVENT_TYPE);
            if (vocabulary != null) {
                _types = vocabulary.getCategories();
            }
        }
        return _types;
    }

    /**
     * Retourne le nom du filtre "type" sélectionné
     * @throws PortalException
     */
    public String getTypeLabel() throws PortalException {
        Optional<AssetCategory> optionalType = this.getTypes().stream()
                .filter(t -> t.getCategoryId() == _viewCampaignEventsDisplayContext.getTypeId()).findFirst();
        if(optionalType.isPresent()) {
            return optionalType.get().getTitleCurrentValue();
        } else {
            return "";
        }
    }

    /**
     * Retourne la liste des themes
     */
    public List<AssetCategory> getThemes() throws PortalException {
        if (Validator.isNull(_themes)) {
            AssetVocabulary vocabulary = AssetVocabularyHelper.getGlobalVocabulary(VocabularyNames.EVENT_THEME);
            if (vocabulary != null) {
                _themes = vocabulary.getCategories();
            }
        }
        return _themes;
    }

    /**
     * Retourne le nom du filtre "thème" sélectionné
     * @throws PortalException
     */
    public String getThemeLabel() throws PortalException {
        Optional<AssetCategory> optionalTheme = this.getThemes().stream()
                .filter(t -> t.getCategoryId() == _viewCampaignEventsDisplayContext.getThemeId()).findFirst();
        if(optionalTheme.isPresent()) {
            return optionalTheme.get().getTitleCurrentValue();
        } else {
            return "";
        }
    }

    public boolean isUserAManager() {
        for (Campaign campaign : getCampaigns()) {
            if (campaign.isManagedByUser(this._themeDisplay.getUserId())) {
                return true;
            }
        }
        return false;
    }


    private final ViewCampaignEventsDisplayContext _viewCampaignEventsDisplayContext;
    private final ThemeDisplay _themeDisplay;
    private Map<Integer, String> _statuses;
    private List<Campaign> _campaigns;
    private List<AssetCategory> _types;
    private List<AssetCategory> _themes;
}