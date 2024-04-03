<%@ include file="/form-send-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationUnderItems}'/>

<%-- URL : definit le lien de retour vers la 1ère page --%>
<liferay-portlet:renderURL varImpl="formsURL">
    <portlet:param name="tab" value="forms" />
    <portlet:param name="orderByCol" value="${dc.orderByCol}" />
    <portlet:param name="orderByType" value="${dc.orderByType}" />
    <portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="delta" value="${dc.searchContainer.delta}" />
    <portlet:param name="mvcPath" value="/form-send-bo-view-forms.jsp" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entite --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="signalementsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-row
				className="eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement" modelVar="signalement"
				keyProperty="signalementId" >

				<%-- Colonne : debut de la réponse--%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="response" truncate="true" value="${dc.getResponse(signalement.formSendRecordFieldId)}" />

				<%-- Colonne : Date de signalement --%>
				<fmt:formatDate value="${signalement.createDate}"
					var="formattedCreatedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="reporting-date" truncate="true" orderable="true"
					value="${formattedCreatedDate}" />

				<%-- Colonne : Type de signalement--%>
				<liferay-ui:search-container-column-text cssClass="content-column"
                    name="report-type" truncate="true" orderable="true"
                    value="${signalement.getCategorieName()}" />

                <%-- URL : Definit le lien vers la page d'edition du commentaire liee au signalement selectionnee --%>
                <c:choose>
                    <c:when test="${signalement.status eq 0}">
                        <liferay-portlet:renderURL varImpl="ShowResponseURL">
	                        <portlet:param name="tab" value="viewReportings" />
                            <portlet:param name="cmd" value="showResponse" />
                            <portlet:param name="formSendRecordFieldId" value="${signalement.formSendRecordFieldId}" />
                            <portlet:param name="formInstanceId" value="${formInstanceId}" />
                            <portlet:param name="backURL" value="${formsURL}" />
                            <portlet:param name="mvcPath" value="/form-send-bo-view-form-send-signalements.jsp" />
                        </liferay-portlet:renderURL>

                        <%-- Colonne : approuver la réponse --%>
                        <liferay-ui:search-container-column-text cssClass="content-column" >
                            <aui:button href="${ShowResponseURL}" value="show-response"/>
                        </liferay-ui:search-container-column-text>
                    </c:when>
                    <c:when test="${signalement.status eq 4}">
                        <liferay-portlet:renderURL varImpl="HideResponseURL">
	                        <portlet:param name="tab" value="viewReportings" />
                            <portlet:param name="cmd" value="hideResponse" />
                            <portlet:param name="formSendRecordFieldId" value="${signalement.formSendRecordFieldId}" />
                            <portlet:param name="formInstanceId" value="${formInstanceId}" />
                            <portlet:param name="backURL" value="${formsURL}" />
                            <portlet:param name="mvcPath" value="/form-send-bo-view-form-send-signalements.jsp" />
                        </liferay-portlet:renderURL>

                        <%-- Colonne : cacher la réponse --%>
                        <liferay-ui:search-container-column-text cssClass="content-column" >
                            <aui:button href="${HideResponseURL}" value="hide-response"/>
                        </liferay-ui:search-container-column-text>
                    </c:when>
                </c:choose>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="false" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<style>
    .lfr-checkbox-column{
        display:none;
    }
</style>

<aui:script>
    var form = document.querySelector("[name='<portlet:namespace />fm']");
    var json = '{"desiredItemSelectorReturnTypes":"infoitem","itemSubtype":null,"itemType":"com.liferay.asset.kernel.model.AssetCategory","mimeTypes":null,"multiSelection":true,"refererClassPK":"0","status":0}';

    function getCategoriesByVocabulary(vocabularyId, vocabularyName, categoriesId) {
        const portletURL = location.protocol + '//' + location.host + location.pathname + "/-/select/com.liferay.item.selector.criteria.info.item.criterion.InfoItemItemSelectorCriterion/<portlet:namespace />selectCategory";
        const url = Liferay.Util.PortletURL.createPortletURL(portletURL, {
            p_p_id: 'com_liferay_item_selector_web_portlet_ItemSelectorPortlet',
            '0_json': json,
            p_p_lifecycle: 0,
            p_p_state: "pop_up",
            selectedCategories: categoriesId,
            selectedCategoryIds: categoriesId,
            singleSelect : false,
            showAddCategoryButton: true,
            vocabularyIds: vocabularyId,
        });

        Liferay.Util.openSelectionModal(
            {
                onSelect: function (selectedItem) {
                    if (selectedItem) {
                        var url = "${filterSelectionURL}";
                        if(!url.includes("filterCategoriesIdByVocabulariesName"))
                            url += "&<portlet:namespace />filterCategoriesIdByVocabulariesName=";
                        if(url.includes(encodeURIComponent(vocabularyName).replaceAll("%20","+").replaceAll("'","%27")+'__')){
                            const regex = encodeURIComponent(vocabularyName).replaceAll("%20","\\+").replaceAll("'","%27") + "(.(?<!___))*___";
                            const re = new RegExp(regex, 'gi');
                            url = url.replace(re,"");
                        }
                        for(index in Object.keys(selectedItem)){
                            var selection = selectedItem[Object.keys(selectedItem)[index]];
                            url += encodeURIComponent(vocabularyName) + '__' + encodeURIComponent(selection.title) + '__' + selection.categoryId + '___';
                        }
                        submitForm(form, url);
                    }
                },
                selectEventName: '<portlet:namespace />selectCategory',
                title: vocabularyName,
                multiple: true,
                url: url
            }
        )
    }
</aui:script>