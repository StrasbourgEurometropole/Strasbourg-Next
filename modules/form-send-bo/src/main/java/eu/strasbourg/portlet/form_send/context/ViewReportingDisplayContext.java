package eu.strasbourg.portlet.form_send.context;

import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.form_send.util.FormSendSignalementActionDropdownItemsProvider;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordField;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldLocalServiceUtil;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldSignalementLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewReportingDisplayContext extends ViewBaseDisplayContext<FormSendRecordFieldSignalement> {

    private List<FormSendRecordFieldSignalement> _allSignalements;

    public ViewReportingDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, FormSendRecordFieldSignalement.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
    }


    @Override
    public SearchContainer<FormSendRecordFieldSignalement> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/form-send-bo-view-form-send-signalements.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","viewReportings")
                    .setParameter("filterCategoriesIdByVocabulariesName", getFilterCategoriesIdByVocabulariesName())
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
            _searchContainer.setResultsAndTotal(
                    () -> {
                        // Création de la liste d'objet
                        int start = this._searchContainer.getStart();
                        int end = this._searchContainer.getEnd();
                        int total = this._searchContainer.getTotal();
                        _allSignalements= _allSignalements.subList(start, end > total ? total : end);
                        return _allSignalements;
                    }, _allSignalements.size()
            );
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
        return _searchContainer;
    }

    // Récupération de la réponse lié au signalement
    @SuppressWarnings("unused")
    public String getResponse(long formSendRecordFieldId){
        String response = "";
        //récupère le formSendRecordField correspondant
        FormSendRecordField formSendRecordField = FormSendRecordFieldLocalServiceUtil.fetchFormSendRecordField(formSendRecordFieldId);
        if(Validator.isNotNull(formSendRecordField)){
            // récupère le DDMFormInstanceRecord
            DDMFormInstanceRecord formInstanceRecord = DDMFormInstanceRecordLocalServiceUtil.getDDMFormInstanceRecords(-1, -1)
                    .stream()
                    .filter(f -> f.getStorageId() == formSendRecordField.getContentId())
                    .findFirst()
                    .orElse(null);
            if(Validator.isNotNull(formInstanceRecord)) {
                // récupère les infos du contenu du formulaire envoyé
                // Contient les valeurs et le type du champ, avec l'identifiant du champ comme cle de la Map
                try {
                    Map<String, List<DDMFormFieldValue>> formfieldvaluesMap =
                            formInstanceRecord.getDDMFormValues().getDDMFormFieldValuesMap(false);
                    for (String formFieldKey : formfieldvaluesMap.keySet()) {
                        // récupère les infos du champs
                        List<DDMFormFieldValue> formFieldValuesList = formfieldvaluesMap.get(formFieldKey);
                        try {
                            if (formFieldValuesList.size() == 1) {
                                DDMFormFieldValue formFieldValues = formFieldValuesList.get(0);
                                // on ne récupère que le champs concerné
                                String instanceId = formFieldValues.getInstanceId();
                                if (instanceId.equals(formSendRecordField.getInstanceId())) {
                                    response = formFieldValues.getValue().getString(Locale.FRANCE).replaceAll("(\r\n|\n)", "<br />");
                                    break;
                                }
                            }
                        } catch (Exception e1) {
                            _log.error(e1.getMessage(), e1);
                        }
                    }
                } catch (PortalException e) {
                    throw new RuntimeException(e);
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

    private void getHits() throws PortalException {
        if (this._allSignalements == null) {
            List<FormSendRecordFieldSignalement> signalementList = new ArrayList<>();
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
    }

    @Override
    public String getOrderByColSearchField() {
        switch (getOrderByCol()) {
            case "title":
                return "localized_title_fr_FR_sortable";
            case "modified-date":
            default:
                return "modified_sortable";
        }
    }

    protected SearchContainer <FormSendRecordFieldSignalement> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;

    private final Log _log = LogFactoryUtil.getLog(this.getClass());
}
