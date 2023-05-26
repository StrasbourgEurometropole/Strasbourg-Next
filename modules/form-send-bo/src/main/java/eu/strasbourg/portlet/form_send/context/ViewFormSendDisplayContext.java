package eu.strasbourg.portlet.form_send.context;

import com.liferay.asset.categories.item.selector.AssetCategoryTreeNodeItemSelectorReturnType;
import com.liferay.asset.categories.item.selector.criterion.AssetCategoryTreeNodeItemSelectorCriterion;
import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.form_send.util.FormSendActionDropdownItemsProvider;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordField;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class ViewFormSendDisplayContext {

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());


    public ViewFormSendDisplayContext(RenderRequest request,
                                      RenderResponse response, ItemSelector itemSelector) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        _itemSelector=itemSelector;

    }

    // Récupère les formulaires envoyés du formulaire choisi
    /*public List<DDMFormInstanceRecord> getAllFormSends() {
        if (this._allFormSends == null) {
            List<DDMFormInstanceRecord> recordList = DDMFormInstanceRecordLocalServiceUtil.getDDMFormInstanceRecords(-1,-1);

            // ne garde que les formulaires envoyé du formulaire choisi
            long formInstanceId = ParamUtil.getLong(_request,"formInstanceId");
            recordList = recordList.stream().filter(r -> r.getFormInstanceId() == formInstanceId).collect(Collectors.toList());

            //effectue le tri
            recordList.sort((r1, r2) -> r1.getModifiedDate().compareTo(r2.getModifiedDate()));
            if("desc".equals(this.getOrderByType()))
                Collections.reverse(recordList);

            this._allFormSends = recordList;
        }
        return this._allFormSends;
    }*/

    /*public List<DDMFormInstanceRecord> getFormSends() {

        //TODO pour la pagination
//        if (this._formSends == null) {
//            List<DDLRecord> recordList = DDLRecordLocalServiceUtil.getDDLRecords(-1,-1);
//
//            // ne garde que les formulaires envoyé du formulaire choisi
//            long recordSetId = ParamUtil.getLong(_request,"recordSetId");
//            recordList = recordList.stream().filter(r -> r.getRecordSetId() == recordSetId).collect(Collectors.toList());
//
//            //effectue le tri
//            recordList.sort((r1, r2) -> r1.getModifiedDate().compareTo(r2.getModifiedDate()));
//            if("desc".equals(this.getOrderByType()))
//                Collections.reverse(recordList);
//
//            this._formSends = recordList.subList(
//                    this._searchContainer.getStart()>this._allFormSends.size()?this._allFormSends.size():this._searchContainer.getStart(),
//                    this._searchContainer.getEnd()>this._allFormSends.size()?this._allFormSends.size():this._searchContainer.getEnd());
//        }
//        return this._formSends;

        return this.getAllFormSends();
    }*/

    // récupère les valeurs d'un formulaire envoyé (nom du champ, valeur du champ)
    public List<String[]> getRecordFields(long recordStorageId, Locale locale) {
        List<String[]> recordFields = new ArrayList<String[]>();
        // récupère tous les champs qui devront être affichés
        Map<String, String[]> texteFields = getTexteFields();

        // récupère les infos du contenu du formulaire envoyé
        DDMContent content = DDMContentLocalServiceUtil.fetchDDMContent(recordStorageId);
        if(Validator.isNotNull(content)){
            // récupère le contenu du formulaire envoyé
            String jsonString = content.getData();
            if(Validator.isNotNull(jsonString)){
                try {
                    // récupère les infos de tous les champs du formualaire
                    JSONArray jsonArray = JSONFactoryUtil.createJSONObject(jsonString).getJSONArray("fieldValues");
                    for (Object jsonObject : jsonArray) {
                        // récupère les infos du champs
                        JSONObject json = JSONFactoryUtil.createJSONObject(jsonObject.toString());
                        // on ne garde que les type text
                        if(Validator.isNotNull(texteFields.get(json.getString("name")))) {
                            // remplace la réponse "" par la réponse réelle
                            texteFields.get(json.getString("name"))[1] = json.getJSONObject("value").getString(locale.toString()).replaceAll("(\r\n|\n)", "<br />");
                        }
                    }

                    // transform la map en list
                    if(Validator.isNotNull(texteFields)) {
                        recordFields = new ArrayList<String[]>(texteFields.values());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return recordFields;
    }


    // récupère les champ text qui devront être affiché (nom, {valeur,reponse:""})
    private Map<String, String[]> getTexteFields() {

        if(this._texteAreaFields == null) {
            Map<String, String[]> texteAreaFields = new LinkedHashMap<String, String[]>();
            //récupère le formulaire
            long formInstanceId = ParamUtil.getLong(_request, "formInstanceId");
            DDMFormInstance formInstance = DDMFormInstanceLocalServiceUtil.fetchFormInstance(formInstanceId);
            if (Validator.isNotNull(formInstance)) {
                // récupère la structure du formulaire
                try {
                    DDMStructure structure = formInstance.getStructure();
                    JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
                    if (Validator.isNotNull(structure))
                        jsonArray = JSONFactoryUtil.createJSONObject(structure.getDefinition()).getJSONArray("fields");

                    for (Object json : jsonArray) {
                        // récupère le type de champs
                        JSONObject jsonField = JSONFactoryUtil.createJSONObject(json.toString());
                        String type = jsonField.getString("type");

                        // ne garde que les text
                        if (Validator.isNotNull(type) && type.equals("text")) {
                            texteAreaFields.put(jsonField.getString("name"),
                                    new String[]{jsonField.getJSONObject("label").getString(Locale.FRANCE.toString()), ""});
                        }
                    }
                } catch (PortalException e) {
                    e.printStackTrace();
                }
            }

            this._texteAreaFields = texteAreaFields;
        }else{
            // initialise toutes les réponses à ""
            for (String[] value : _texteAreaFields.values()){
                value[1] = "";
            }
        }
        return this._texteAreaFields;
    }

    /**
     * Retourne le searchContainer
     *
     */
    public SearchContainer<DDMFormInstanceRecord> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/form-send-bo-view-form-send-records.jsp")
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
                getHits();
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(_allFormSends);
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
        return _searchContainer;
    }
    /**
     * Retourne le dropdownItemsProvider de Form
     *
     * @return officialActionDropdownItemsProvider
     */
    @SuppressWarnings("unused")
    public FormSendActionDropdownItemsProvider getActionsForm(DDMFormInstanceRecord formSend) {
        return new FormSendActionDropdownItemsProvider(formSend, _request,
                _response);
    }

    private void getHits() throws PortalException {

        List<DDMFormInstanceRecord> recordList = DDMFormInstanceRecordLocalServiceUtil.getDDMFormInstanceRecords(-1,-1);

        // ne garde que les formulaires envoyé du formulaire choisi
        long formInstanceId = ParamUtil.getLong(_request,"formInstanceId");

        recordList = recordList.stream().filter(r -> r.getFormInstanceId() == formInstanceId).collect(Collectors.toList());

        //effectue le tri
        recordList.sort((r1, r2) -> r1.getModifiedDate().compareTo(r2.getModifiedDate()));
        if("desc".equals(this.getOrderByType()))
            Collections.reverse(recordList);
        _allFormSends=recordList;
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
    protected SearchContainer <DDMFormInstanceRecord> _searchContainer;
    private Map<String, String> _categVocabularies;
    private String _keywords;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;
    private List<DDMFormInstanceRecord> _allFormSends;
    private Map<String, String[]> _texteAreaFields;
}
