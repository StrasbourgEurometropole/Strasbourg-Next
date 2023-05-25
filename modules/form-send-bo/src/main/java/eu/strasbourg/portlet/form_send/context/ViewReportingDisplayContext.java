package eu.strasbourg.portlet.form_send.context;

import com.liferay.asset.categories.item.selector.AssetCategoryTreeNodeItemSelectorReturnType;
import com.liferay.asset.categories.item.selector.criterion.AssetCategoryTreeNodeItemSelectorCriterion;
import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.form_send.util.FormSendActionDropdownItemsProvider;
import eu.strasbourg.portlet.form_send.util.FormSendSignalementActionDropdownItemsProvider;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordField;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldLocalServiceUtil;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldSignalementLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.display.context.ViewListBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class ViewReportingDisplayContext {

    private List<FormSendRecordFieldSignalement> _allSignalements;

    public ViewReportingDisplayContext(RenderRequest request, RenderResponse response, ItemSelector itemSelector) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        _itemSelector=itemSelector;
    }

    public List<FormSendRecordFieldSignalement> getAllSignalements() {
        if (this._allSignalements == null) {
            List<FormSendRecordFieldSignalement> signalementList = new ArrayList<FormSendRecordFieldSignalement>();
            long formInstanceId = ParamUtil.getLong(_request,"formInstanceId");
            //récupère tous les formulaires envoyés du formulaire
            List<DDMFormInstanceRecord> recordlist = DDMFormInstanceRecordLocalServiceUtil.getDDMFormInstanceRecords(-1,-1);
            recordlist = recordlist.stream().filter(r -> r.getFormInstanceId() == formInstanceId).collect(Collectors.toList());
            if(Validator.isNotNull(recordlist)){
                for (DDMFormInstanceRecord record : recordlist) {
                    //récupère les formSendRecordFields du formulaire
                    List<FormSendRecordField> formSendRecordFieldList = FormSendRecordFieldLocalServiceUtil.getByContentId(record.getStorageId());

                    // récupère les signalements du formSendRecordField
                    for (FormSendRecordField formSendRecordField : formSendRecordFieldList) {
                        List<FormSendRecordFieldSignalement> formSendRecordFieldSignalementList = FormSendRecordFieldSignalementLocalServiceUtil.findByFormSendRecordFieldId(formSendRecordField.getFormSendRecordFieldId());

                        for (FormSendRecordFieldSignalement formSendRecordFieldSignalement : formSendRecordFieldSignalementList) {
                            signalementList.add(formSendRecordFieldSignalement);
                        }
                    }
                }
                //effectue le tri
                signalementList.sort((s1, s2) -> s1.getCreateDate().compareTo(s2.getCreateDate()));
                if("desc".equals(this.getOrderByType()))
                    Collections.reverse(signalementList);

                this._allSignalements = signalementList;
            }
        }
        return this._allSignalements;
    }

    public List<FormSendRecordFieldSignalement> getSignalements() {

        //TODO pour la pagination
//        if (this._signalements == null) {
//            List<FormSendRecordFieldSignalement> signalementList = new ArrayList<FormSendRecordFieldSignalement>();
//            long recordSetId = ParamUtil.getLong(_request,"recordSetId");
//            //récupère tous les formulaires envoyés du formulaire
//            List<DDLRecord> recordlist = DDLRecordLocalServiceUtil.getDDLRecords(-1,-1);
//            recordlist = recordlist.stream().filter(r -> r.getRecordSetId() == recordSetId).collect(Collectors.toList());
//            if(Validator.isNotNull(recordlist)){
//                // récupère les signalements des formulaires envoyés
//                for (DDLRecord record : recordlist) {
//                    //récupère les formSendRecordFields du formulaire
//                    List<FormSendRecordField> formSendRecordFieldList = FormSendRecordFieldLocalServiceUtil.getByContentId(record.getDDMStorageId());
//
//                    // récupère les signalements du formSendRecordField
//                    for (FormSendRecordField formSendRecordField : formSendRecordFieldList) {
//                        List<FormSendRecordFieldSignalement> formSendRecordFieldSignalementList = FormSendRecordFieldSignalementLocalServiceUtil.findByFormSendRecordFieldId(formSendRecordField.getFormSendRecordFieldId());
//
//                        for (FormSendRecordFieldSignalement formSendRecordFieldSignalement : formSendRecordFieldSignalementList) {
//                            signalementList.add(formSendRecordFieldSignalement);
//                        }
//                    }
//                }
//                //effectue le tri
//                signalementList.sort((s1, s2) -> s1.getCreateDate().compareTo(s2.getCreateDate()));
//                if("desc".equals(this.getOrderByType()))
//                    Collections.reverse(signalementList);
//
//                this._signalements = signalementList.subList(
//                        this._searchContainer.getStart()>this._allSignalements.size()?this._allSignalements.size():this._searchContainer.getStart(),
//                        this._searchContainer.getEnd()>this._allSignalements.size()?this._allSignalements.size():this._searchContainer.getEnd());
//            }
//        }
//        return this._signalements;

        return this._allSignalements;
    }

    /**
     * Retourne le searchContainer
     */
    /*public SearchContainer<FormSendRecordFieldSignalement> getSearchContainer() {
        if (this._searchContainer == null && Validator.isNotNull(this.getAllSignalements())) {
            PortletURL iteratorURL = this._response.createRenderURL();
            iteratorURL.setParameter("tab", ParamUtil.getString(this._request, "tab"));
            iteratorURL.setParameter("orderByCol", this.getOrderByCol());
            iteratorURL.setParameter("orderByType", this.getOrderByType());
            iteratorURL.setParameter("keywords", this.getKeywords());

            this._searchContainer = new SearchContainer<FormSendRecordFieldSignalement>(this._request,
                    iteratorURL, null, "no-entries-were-found");

            this._searchContainer.setEmptyResultsMessageCssClass(
                    "taglib-empty-result-message-header-has-plus-btn");
            this._searchContainer
                    .setRowChecker(new EmptyOnClickRowChecker(this._response));
            this._searchContainer.setOrderByColParam("orderByCol");
            this._searchContainer.setOrderByTypeParam("orderByType");
            this._searchContainer.setResults(this._allSignalements);
            this._searchContainer.setTotal(this._allSignalements.size());
        }
        return this._searchContainer;
    }*/
    public SearchContainer<FormSendRecordFieldSignalement> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/form-send-bo-view-form-send-signalements.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .buildPortletURL();
            _searchContainer = new SearchContainer<>(_request, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
            _searchContainer.setEmptyResultsMessageCssClass(
                    "taglib-empty-result-message-header-has-plus-btn");
            _searchContainer.setOrderByColParam("orderByCol");
            _searchContainer.setOrderByTypeParam("orderByType");
            _searchContainer.setOrderByCol(getOrderByCol());
            _searchContainer.setOrderByType(getOrderByType());
            try {
                getHits(this._themeDisplay.getScopeGroupId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(
                    () -> {
                        // Création de la liste d'objet
                        List<FormSendRecordFieldSignalement> results = new ArrayList<>();
                        if (_hits != null) {
                            for (Document document : _hits.getDocs()) {
                                FormSendRecordFieldSignalement form = FormSendRecordFieldSignalementLocalServiceUtil.
                                        fetchFormSendRecordFieldSignalement(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (form!= null)
                                    results.add(form);
                            }
                        }

                        return results;
                    }, _hits.getLength()
            );
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
        return _searchContainer;
    }
    // Récupération de la réponse lié au signalement
    public String getResponse(long formSendRecordFieldId){
        String response = "";
        //récupère le formSendRecordField correspondant
        FormSendRecordField formSendRecordField = FormSendRecordFieldLocalServiceUtil.fetchFormSendRecordField(formSendRecordFieldId);
        if(Validator.isNotNull(formSendRecordField)){
            //Récupère le contenu du formulaire
            DDMContent content = DDMContentLocalServiceUtil.fetchDDMContent(formSendRecordField.getContentId());
            if(Validator.isNotNull(content)) {
                String jsonString = content.getData();
                if (Validator.isNotNull(jsonString)) {
                    try {
                        // récupère les infos de tous les champs du formualaire
                        JSONArray jsonArray = JSONFactoryUtil.createJSONObject(jsonString).getJSONArray("fieldValues");
                        for (Object jsonObject : jsonArray) {
                            // on ne récupère que le champs concerné
                            JSONObject json = JSONFactoryUtil.createJSONObject(jsonObject.toString());
                            String instanceId = json.getString("instanceId");
                            if(instanceId.equals(formSendRecordField.getInstanceId()))
                                response = json.getJSONObject("value").getString(Locale.FRANCE.toString()).replaceAll("(\r\n|\n)", "<br />");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return response;
    }
    /**
     * Retourne le dropdownItemsProvider de Form
     *
     * @return officialActionDropdownItemsProvider
     */
    @SuppressWarnings("unused")
    public FormSendSignalementActionDropdownItemsProvider getActionsForm(FormSendRecordFieldSignalement formSignalement) {
        return new FormSendSignalementActionDropdownItemsProvider(formSignalement, _request,
                _response);
    }

    private void getHits(long groupId) throws PortalException {
        HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(_request);
        SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

        // Recherche des hits
        String keywords = ParamUtil.getString(servletRequest, "keywords");
        _hits = SearchHelper.getBOSearchHits(searchContext,
                getSearchContainer().getStart(),
                getSearchContainer().getEnd(), FormSendRecordFieldSignalement.class.getName(), groupId,
                "", keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }

    public String getOrderByColSearchField() {
        switch (getOrderByCol()) {
            case "title":
                return "localized_title_fr_FR_sortable";
            case "modified-date":
            default:
                return "modified_sortable";
        }
    }

    public boolean hasVocabulary(String vocabularyName){
        return getCategVocabularies().containsKey(vocabularyName);
    }

    public Map<String, String> getCategVocabularies() {
        if (_categVocabularies == null) {
            _categVocabularies = new HashMap<>();
            _categVocabularies.put("vocabulary1", ParamUtil.getString(
                    _httpServletRequest, "vocabulary1", ""));
        }

        return _categVocabularies;
    }

    @SuppressWarnings("unused")
    public String getSelectCategoriesByVocabularyIdURL(long vocabularyId) {
        RequestBackedPortletURLFactory requestBackedPortletURLFactory =
                RequestBackedPortletURLFactoryUtil.create(_request);
        AssetCategoryTreeNodeItemSelectorCriterion categoryTreeNodeItemSelectorCriterion =
                new AssetCategoryTreeNodeItemSelectorCriterion();
        categoryTreeNodeItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                new AssetCategoryTreeNodeItemSelectorReturnType());

        return String.valueOf(
                _itemSelector.getItemSelectorURL(
                        requestBackedPortletURLFactory,
                        _response.getNamespace() + "selectAssetCategory",
                        categoryTreeNodeItemSelectorCriterion));
    }
    /**
     * Renvoie la colonne sur laquelle on fait le tri
     *
     * @return String
     */
    public String getOrderByCol() {
        return ParamUtil.getString(_request, "orderByCol", "modified-date");
    }

    /**
     * Retourne le type de tri (desc ou asc)
     *
     * @return String
     */
    public String getOrderByType() {
        return ParamUtil.getString(_request, "orderByType", "desc");
    }

    /**
     * Retourne les mots clés de recherche saisis
     */
    @SuppressWarnings("unused")
    public String getKeywords() {
        if (Validator.isNull(_keywords)) {
            _keywords = ParamUtil.getString(_request, "keywords");
        }
        return _keywords;
    }
    private Hits _hits;
    protected SearchContainer <FormSendRecordFieldSignalement> _searchContainer;
    private Map<String, String> _categVocabularies;
    private String _keywords;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;

}
