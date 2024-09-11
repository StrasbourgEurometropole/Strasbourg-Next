<%@ include file="/project-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="budgetParticipatifURL">
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>


<%-- Composant : barre de filtres et de gestion des entites --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="budgetParticipatifsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.project.model.BudgetParticipatif" modelVar="budgetParticipatif"
				keyProperty="budgetParticipatifId" >

				<%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
				<liferay-portlet:renderURL varImpl="editBudgetParticipatifURL">
					<portlet:param name="cmd" value="editBudgetParticipatif" />
					<portlet:param name="budgetParticipatifId" value="${budgetParticipatif.budgetParticipatifId}" />
					<portlet:param name="backURL" value="${budgetParticipatifURL}" />
					<portlet:param name="mvcPath" value="/project-bo-edit-budget-participatif.jsp" />
					<portlet:param name="tab" value="budgets-participatifs" />
				</liferay-portlet:renderURL>

				<%-- Colonne : Titre --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editBudgetParticipatifURL}" name="title" truncate="true" orderable="true"
					value="${budgetParticipatif.title}" />
				
				<%-- Colonne : Depositaire (Publik) --%>
                <liferay-ui:search-container-column-text name="depositary">
                    <c:out value="${budgetParticipatif.author}" escapeXml='true'/>
                </liferay-ui:search-container-column-text>
                
                <%-- Colonne : Phase --%>
                <liferay-ui:search-container-column-text name="budget-phase">
                    ${budgetParticipatif.phaseTitleLabel}
                </liferay-ui:search-container-column-text>
                
                

				<%-- Colonne : Administrateur liferay --%>
                <liferay-ui:search-container-column-text name="administrator">
                    ${budgetParticipatif.statusByUserName}
                </liferay-ui:search-container-column-text>
                
                <%-- Colonne : Date de modification --%>
				<fmt:formatDate value="${budgetParticipatif.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />
					
				<%-- Colonne : Statut BP --%>
                <liferay-ui:search-container-column-text name="status-bp">
                    ${budgetParticipatif.getBudgetParticipatifStatusTitle(locale)}
                </liferay-ui:search-container-column-text>

				<%-- Colonne : Statut --%>
				<liferay-ui:search-container-column-text name="status-liferay">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${budgetParticipatif.status}" />
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Actions possibles --%>
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsBudgetParticipatif(budgetParticipatif).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
	


	<liferay-portlet:resourceURL var="exportBudgetsXlsxURL" id="exportBudgetsXlsx" copyCurrentRenderParameters="false">
    </liferay-portlet:resourceURL>
    
   	<form method="POST" action="${exportBudgetsXlsxURL}">
   		<aui:button-row>
   			<aui:button cssClass="btn-lg" type="submit" value="export-budgets-participatifs-xlsx" />
   		</aui:button-row>
   	</form>
</div>


<%-- URL : defini le lien vers l'action de suppression --%>
<liferay-portlet:actionURL name="selectionAction" var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de publication --%>
<liferay-portlet:actionURL name="selectionAction" var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de depublication --%>
<liferay-portlet:actionURL name="selectionAction" var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de changement de statut a : Faisable --%>
<liferay-portlet:actionURL name="selectionBudgetParticipatifAction" var="acceptableSelectionURL">
	<portlet:param name="cmd" value="acceptable" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de changement de statut a : Faisable --%>
<liferay-portlet:actionURL name="selectionBudgetParticipatifAction" var="feasibleSelectionURL">
	<portlet:param name="cmd" value="feasible" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>


<%-- URL : defini le lien vers l'action de changement de statut a : Faisable --%>
<liferay-portlet:actionURL name="selectionBudgetParticipatifAction" var="realizedSelectionURL">
	<portlet:param name="cmd" value="realized" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de changement de statut a : Faisable --%>
<liferay-portlet:actionURL name="selectionBudgetParticipatifAction" var="laureatSelectionURL">
	<portlet:param name="cmd" value="laureat" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>
<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="mvcPath" value="/project-bo-view-budgets-participatifs.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>
<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	var json = '{"desiredItemSelectorReturnTypes":"infoitem","itemSubtype":null,"itemType":"com.liferay.asset.kernel.model.AssetCategory","mimeTypes":null,"multiSelection":true,"refererClassPK":"0","status":0}';

	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {

			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function <portlet:namespace />publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-entries" />')) {

			submitForm(form, '${publishSelectionURL}');
		}
	}
	function unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-entries" />')) {

			submitForm(form, '${unpublishSelectionURL}');
		}
	}
	function acceptableSelection() {
		if (confirm('<liferay-ui:message key="acceptable-selected-entries" />')) {

			submitForm(form, '${acceptableSelectionURL}');
		}
	}
	function feasibleSelection() {
		if (confirm('<liferay-ui:message key="feasible-selected-entries" />')) {

			submitForm(form, '${feasibleSelectionURL}');
		}
	}
	function realizedSelection() {
		if (confirm('<liferay-ui:message key="realized-selected-entries" />')) {

			submitForm(form, '${realizedSelectionURL}');
		}
	}
	function laureatSelection() {
		if (confirm('<liferay-ui:message key="laureat-selected-entries" />')) {

			submitForm(form, '${laureatSelectionURL}');
		}
	}

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