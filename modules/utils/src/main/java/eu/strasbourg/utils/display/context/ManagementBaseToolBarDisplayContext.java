package eu.strasbourg.utils.display.context;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItemListBuilder;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public abstract class ManagementBaseToolBarDisplayContext<T> extends SearchContainerManagementToolbarDisplayContext {

    public ManagementBaseToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            Class<T> tClass, SearchContainer searchContainer) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                searchContainer);
        this.tClass = tClass;
        _httpServletRequest = httpServletRequest;
    }

    /**
     * The list of dropdown items to display when a result is checked
     * or the master checkbox in the Management Toolbar is checked
     * Content : publish, unpublish and delete
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
     * Sets the search container’s filtering options
     * cotent filter by and order by
     */
    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        if(!getVocabularies().isEmpty()) {
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

        for (AssetVocabulary vocabulary : getVocabularies()) {
            filterVocabularyDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(hasVocabulary(vocabulary.getName()))
                            .setHref("javascript:getCategoriesByVocabulary(" + vocabulary.getVocabularyId()
                                    + ", \"" + vocabulary.getName() + "\", '"
                                    + getFilterCategoriesIdsByVocabularyName(vocabulary.getName()) +"');")
                            .setLabel(vocabulary.getName())
                            .build()
            );
        }

        return filterVocabularyDropdownItems;
    }

    public boolean hasVocabulary(String vocabularyName){
        return getFilterCategoriesIdByVocabulariesName().contains(vocabularyName+"_");
    }

    /**
     * Retourne un String des IDs des catégories sur lesquels on doit filtrer
     *  sous forme de string qui se présente comme suit :
     * "vocabularyName_categoryName_categoryId__..."
     */
    public String getFilterCategoriesIdByVocabulariesName() {
        return ParamUtil.getString(_httpServletRequest, "filterCategoriesIdByVocabulariesName","");
    }

    /**
     * Retourne la liste des IDs des catégories d'un vocabulaire, sur lequel on doit filtrer
     *  sous forme de string qui se présente comme suit :
     * "categoryId1,categoryId2,categoryId3,"
     */
    public String getFilterCategoriesIdsByVocabularyName(String vocabularyName) {
        List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
                .split("__"));
        StringBuilder filterCategoriesIdsByVocabulary = new StringBuilder();
        for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
            if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
                String[] arrayCategoryIdByVocabularyName = filterCategoryIdByVocabularyName.split("_");
                if(arrayCategoryIdByVocabularyName[0].equals(vocabularyName))
                    filterCategoriesIdsByVocabulary.append(arrayCategoryIdByVocabularyName[2]).append(",");
            }
        }
        return filterCategoriesIdsByVocabulary.toString();
    }

    /**
     * Sets the search container’s filter labels to display
     */
    @Override
    public List<LabelItem> getFilterLabelItems() {
        List<String[]> categoriesSelected = getCategVocabularies();
        LabelItemListBuilder.LabelItemListWrapper vocabulariesLabelItems = new LabelItemListBuilder.LabelItemListWrapper();

        MutableRenderParameters parameters = this.currentURLObj.getRenderParameters();
        String originalFilterCategoriesIdByVocabulariesName = parameters.getValue("filterCategoriesIdByVocabulariesName");
        for (String[] categorySelected : categoriesSelected) {
            try {
                PortletURL newURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);
                String filterCategoriesIdByVocabulariesName;
                // on enlève le vocabularyName_CategoryName_CategoryId__ correspondant du paramètre
                String CategoryToDelete = categorySelected[0] + '_' + categorySelected[1] + '_' + categorySelected[2] + "__";
                if (originalFilterCategoriesIdByVocabulariesName
                        .contains(CategoryToDelete)) {
                    filterCategoriesIdByVocabulariesName = originalFilterCategoriesIdByVocabulariesName
                            .replace(CategoryToDelete, "");
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
     * Retourne la liste des IDs des catégories sur lesquels on doit filtrer
     *  chaque entrée de liste contient un tableau de String :
     * [vocabularyName, categoryName, categoryId]
     */
    public List<String[]> getCategVocabularies() {
        if (_categVocabularies == null) {
            _categVocabularies = new ArrayList<>();
            List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
                    .split("__"));
            for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
                if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
                    _categVocabularies.add(filterCategoryIdByVocabularyName.split("_"));
                }
            }
        }

        return _categVocabularies;
    }

    /**
     * Fields that can be sorted
     * cntent : "publication-date", "modified-date","title", "status"
     */
    @Override
    protected String[] getOrderByKeys() {
        return new String[] {  "publication-date", "modified-date","title", "status" };
    }




    /**
     * The URL to reset the search
     */
    @Override
    public String getClearResultsURL() {
        return PortletURLBuilder.create(getPortletURL())
                .setKeywords("")
                .setParameter("orderByCol", "modified-date")
                .setParameter("orderByType", "desc")
                .setParameter( "filterCategoriesIdByVocabulariesName", "")
                .buildString();
    }

    /**
     * The search form’s name
     */
    @Override
    public String getSearchFormName() {
        return "fm1";
    }


    /**
     * Get Vocabularies
     */
    protected List<AssetVocabulary> getVocabularies() {
        if(_vocabularies == null) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) httpServletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);
            long companyGroupId = themeDisplay.getCompanyGroupId();
            long classNameId = ClassNameLocalServiceUtil.getClassNameId(tClass);
            long scopeGroupId = themeDisplay.getScopeGroupId();
            _vocabularies = AssetVocabularyLocalServiceUtil
                    .getAssetVocabularies(-1, -1).stream()
                    .filter(v -> (v.getGroupId() == companyGroupId || v.getGroupId() == scopeGroupId) && LongStream.of(v.getSelectedClassNameIds())
                            .anyMatch(c -> c == classNameId))
                    .collect(Collectors.toList());
        }

        return _vocabularies;
    }

    private List<String[]> _categVocabularies;
    private List<AssetVocabulary> _vocabularies;
    private final Class<T> tClass;
    private final HttpServletRequest _httpServletRequest;

}