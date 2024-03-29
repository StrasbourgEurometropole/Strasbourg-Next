<%@ include file="/project-bo-init.jsp"%>

<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="budgetParticipatifURL">
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien vers la page d'ajout/edition d'une entite --%>
<liferay-portlet:renderURL varImpl="addBudgetParticipatifURL">
	<portlet:param name="cmd" value="addBudgetParticipatif" />
	<portlet:param name="mvcPath" value="/project-bo-edit-budget-participatif.jsp" />
	<portlet:param name="returnURL" value="${budgetParticipatifURL}" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entites --%>
<liferay-frontend:management-bar includeCheckBox="true" searchContainerId="budgetParticipatifsSearchContainer">

		<%-- Composant : partie filtres et selection --%>
		<liferay-frontend:management-bar-filters>
			<c:if test="${fn:length(dc.vocabularies) > 0}">
				<li><a>Filtrer par :</a></li>
			</c:if>
			<c:forEach var="vocabulary" items="${dc.vocabularies}">
				<liferay-frontend:management-bar-filter 
					managementBarFilterItems="${dc.getManagementBarFilterItems(vocabulary)}" 
					value="${dc.getVocabularyFilterLabel(vocabulary)}" />
			</c:forEach>

			<liferay-frontend:management-bar-sort orderByCol="${dc.orderByCol}"
				orderByType="${dc.orderByType}"
				orderColumns='<%= new String[] {"title", "modified-date"} %>'
				portletURL="${budgetParticipatifURL}" />
		</liferay-frontend:management-bar-filters>

		<%-- Composant : partie gestion (affichee apres une selection) --%>
		<liferay-frontend:management-bar-action-buttons>
			<c:if test="${not dc.workflowEnabled}">
				<c:if test="${dc.hasPermission('EDIT_BUDGET_PARTICIPATIF') and empty themeDisplay.scopeGroup.getStagingGroup()}">
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "acceptableSelection();"%>'
						label="Recevable" />
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "feasibleSelection();"%>'
						label="Faisable" />
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "realizedSelection();"%>' 
						label='realise'/>
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "laureatSelection();"%>'
						label="laureat" />
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "publishSelection();"%>'
						icon="check" label="publish" />
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "unpublishSelection();"%>'
						icon="times" label="unpublish" />
				</c:if>
			</c:if>
			<c:if test="${dc.hasPermission('DELETE_BUDGET_PARTICIPATIF') and empty themeDisplay.scopeGroup.getStagingGroup()}">
			<liferay-frontend:management-bar-button
				href='<%="javascript:" + renderResponse.getNamespace() + "deleteSelection();"%>'
				icon="trash" label="delete" />
			</c:if>
		</liferay-frontend:management-bar-action-buttons>

</liferay-frontend:management-bar>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid-1280 main-content-body">
	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="budgetParticipatifsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-results results="${dc.budgetParticipatifs}" />

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.project.model.BudgetParticipatif" modelVar="budgetParticipatif"
				keyProperty="budgetParticipatifId" rowIdProperty="budgetParticipatifId">

				<%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
				<liferay-portlet:renderURL varImpl="editBudgetParticipatifURL">
					<portlet:param name="cmd" value="editBudgetParticipatif" />
					<portlet:param name="budgetParticipatifId" value="${budgetParticipatif.budgetParticipatifId}" />
					<portlet:param name="returnURL" value="${budgetParticipatifURL}" />
					<portlet:param name="mvcPath" value="/project-bo-edit-budget-participatif.jsp" />
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
					<liferay-ui:icon-menu markupView="lexicon">
					
						<c:if test="${dc.hasPermission('EDIT_BUDGET_PARTICIPATIF') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="edit" url="${editBudgetParticipatifURL}" />
						</c:if>
						
						<liferay-portlet:resourceURL id="exportBudgetSupportsXlsx" var="exportBudgetSupportsXlsxURL" copyCurrentRenderParameters="false">
							<portlet:param name="budgetParticipatifId" value="${budgetParticipatif.budgetParticipatifId}" />
						</liferay-portlet:resourceURL>
						<liferay-ui:icon message="export-xlsx-budget-participatifs" url="${exportBudgetSupportsXlsxURL}" />

						<liferay-portlet:actionURL name="deleteBudgetParticipatif" var="deleteBudgetParticipatifURL">
							<portlet:param name="tab" value="budgets-participatifs" />
							<portlet:param name="budgetParticipatifId" value="${budgetParticipatif.budgetParticipatifId}" />
						</liferay-portlet:actionURL>
						
						<c:if test="${dc.hasPermission('DELETE_BUDGET_PARTICIPATIF') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="delete" url="${deleteBudgetParticipatifURL}" />
						</c:if>
						
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
	


	<liferay-portlet:resourceURL var="exportBudgetsXlsxURL" id="exportBudgetsXlsx">
    </liferay-portlet:resourceURL>
    
   	<form method="POST" action="${exportBudgetsXlsxURL}">
   		<aui:input type="hidden" name="budgetsParticipatifsIds" value="${dc.budgetParticipatifIds}" />
   		<aui:button-row>
   			<aui:button cssClass="btn-lg" type="submit" value="export-budgets-participatifs-xlsx" />
   		</aui:button-row>
   	</form>

</div>


<%-- Composant : bouton d'ajout d'entite --%>
<liferay-frontend:add-menu>
	<c:if test="${dc.hasPermission('ADD_BUDGET_PARTICIPATIF') and empty themeDisplay.scopeGroup.getStagingGroup()}">
		<liferay-frontend:add-menu-item title="Ajouter un budget participatif" url="${addBudgetParticipatifURL}" />
	</c:if>
</liferay-frontend:add-menu>

<%-- URL : defini le lien vers l'action de suppression --%>
<liferay-portlet:actionURL name="selectionAction" var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de publication --%>
<liferay-portlet:actionURL name="selectionAction" var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de depublication --%>
<liferay-portlet:actionURL name="selectionAction" var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de changement de statut a : Faisable --%>
<liferay-portlet:actionURL name="selectionBudgetParticipatifAction" var="acceptableSelectionURL">
	<portlet:param name="cmd" value="acceptable" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de changement de statut a : Faisable --%>
<liferay-portlet:actionURL name="selectionBudgetParticipatifAction" var="feasibleSelectionURL">
	<portlet:param name="cmd" value="feasible" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>


<%-- URL : defini le lien vers l'action de changement de statut a : Faisable --%>
<liferay-portlet:actionURL name="selectionBudgetParticipatifAction" var="realizedSelectionURL">
	<portlet:param name="cmd" value="realized" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de changement de statut a : Faisable --%>
<liferay-portlet:actionURL name="selectionBudgetParticipatifAction" var="laureatSelectionURL">
	<portlet:param name="cmd" value="laureat" />
	<portlet:param name="tab" value="budgets-participatifs" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function <portlet:namespace />deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function <portlet:namespace />publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');
			submitForm(form, '${publishSelectionURL}');
		}
	}
	function <portlet:namespace />unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${unpublishSelectionURL}');
		}
	}
	function <portlet:namespace />acceptableSelection() {
		if (confirm('<liferay-ui:message key="acceptable-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${acceptableSelectionURL}');
		}
	}
	function <portlet:namespace />feasibleSelection() {
		if (confirm('<liferay-ui:message key="feasible-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${feasibleSelectionURL}');
		}
	}
	function <portlet:namespace />realizedSelection() {
		if (confirm('<liferay-ui:message key="realized-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${realizedSelectionURL}');
		}
	}
	function <portlet:namespace />laureatSelection() {
		if (confirm('<liferay-ui:message key="laureat-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${laureatSelectionURL}');
		}
	}
</aui:script>