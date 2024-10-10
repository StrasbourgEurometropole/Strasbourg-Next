<%@ include file="/search-asset-init.jsp"%>
<div class="vocabulary-configuration" id="vocabulary${param.index}">
    <aui:input name="numVocabulary${param.index}" value="${param.index}" type="hidden" />
    <aui:input name="vocabularySelectedId${param.index}" value="${vocabularyControlType.key}" type="hidden" />
    <div class="align-items-center c-gap-3 d-flex mb-0 panel-body">
        <div class="form-group form-group-inline input-select-wrapper2">
            <select class="form-control" name="<portlet:namespace />vocabularyIds_${param.index}" id="<portlet:namespace />vocabularyIds_${param.index}">
                <option value="false"><liferay-ui:message key="select-vocabulary" /></option>
            </select>
        </div>
        <aui:select id="vocabularyControlType_${param.index}" name="vocabularyControlType_${param.index}" inlineField="true" label="">
            <aui:option value="list-showcase" selected="${vocabularyControlType.value.equals('list-showcase') ? 'true' : 'false'}">
                <liferay-ui:message key="dropdown-list-showcase"/>
            </aui:option>
            <aui:option value="list" selected="${vocabularyControlType.value.equals('list') ? 'true' : 'false'}">
                <liferay-ui:message key="dropdown-list"/>
            </aui:option>
            <aui:option value="radio" selected="${vocabularyControlType.value.equals('radio') ? 'true' : 'false'}">
                <liferay-ui:message key="radio-button"/>
            </aui:option>
            <aui:option value="check" selected="${vocabularyControlType.value.equals('check') ? 'true' : 'false'}">
                <liferay-ui:message key="checkbox"/>
            </aui:option>
        </aui:select>
        <clay:button icon="trash"  onClick="deleteVocabulary(${param.index});" />
    </div>
</div>