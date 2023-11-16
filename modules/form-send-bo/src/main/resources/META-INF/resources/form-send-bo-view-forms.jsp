<%@ include file="/form-send-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien de retour vers cette page --%>
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
		<liferay-ui:search-container id="formsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-row
				className="com.liferay.dynamic.data.mapping.model.DDMFormInstance" modelVar="ddmFormInstance"
				keyProperty="formInstanceId" >
				<%-- URL : definit le lien vers la page d'edition de l'entite selectionnee --%>
				<liferay-portlet:renderURL varImpl="viewFormSendsURL">
	                <portlet:param name="tab" value="viewFormSends" />
					<portlet:param name="formInstanceId" value="${ddmFormInstance.formInstanceId}" />
					<portlet:param name="backURL" value="${formsURL}" />
					<portlet:param name="mvcPath" value="/form-send-bo-view-form-send-records.jsp" />
				</liferay-portlet:renderURL>

				<%-- Colonne : Name --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${viewFormSendsURL}" name="name" truncate="true" orderable="true"
					value="${ddmFormInstance.getName(locale)}" />

				<%-- Colonne : Id --%>
				<liferay-ui:search-container-column-text
					href="${viewFormSendsURL}" name="id" orderable="true"
					value="${ddmFormInstance.formInstanceId}" />

				<%-- Colonne : Date de modification --%>
				<fmt:formatDate value="${ddmFormInstance.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />
			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
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