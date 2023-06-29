<%@ include file="/project-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="petitionsURL">
	<portlet:param name="tab" value="petitions" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-petitions.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entites --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="petitionsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.project.model.Petition" modelVar="petition"
				keyProperty="petitionId" >
				
				<%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
				<liferay-portlet:renderURL varImpl="editPetitionURL">
					<portlet:param name="cmd" value="editPetition" />
					<portlet:param name="petitionId" value="${petition.petitionId}" />
					<portlet:param name="backURL" value="${petitionsURL}" />
					<portlet:param name="mvcPath" value="/project-bo-edit-petition.jsp" />
					<portlet:param name="tab" value="petitions" />
				</liferay-portlet:renderURL>

				<%-- Colonne : Titre --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editPetitionURL}" name="title" truncate="true" orderable="true"
					value="${petition.title}" />
                
                <%-- Colonne : Auteur --%>
                <liferay-ui:search-container-column-text name="author"
                    cssClass="content-column" truncate="true">
                    ${petition.getAuthorLabel()}
                </liferay-ui:search-container-column-text>
				
				<%-- Colonne : Date de modification --%>
				<fmt:formatDate value="${petition.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />
				
				<%-- Colonne : Administrateur --%>
                <liferay-ui:search-container-column-text name="administrateur">
                    ${petition.userName}
                </liferay-ui:search-container-column-text>

                <%-- Colonne : nombre signature --%>
				<liferay-ui:search-container-column-text name="signatureCount">
					${petition.nombreSignature}
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Statut --%>
				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${petition.status}" />
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Actions possibles --%>
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsPetition(petition).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>

	<liferay-portlet:resourceURL var="exportPetitionsXlsxURL" id="exportPetitionsXlsx" copyCurrentRenderParameters="false">
    </liferay-portlet:resourceURL>
   	<form method="POST" action="${exportPetitionsXlsxURL}">
   		<aui:input type="hidden" name="petitionIds" value="${dc.allPetitionIds}" />
   		<aui:button-row>
   			<aui:button cssClass="btn-lg" type="submit"
   				value="export-petitions-xlsx" />
   		</aui:button-row>
   	</form>

</div>


<%-- URL : defini le lien vers l'action de suppression --%>
<liferay-portlet:actionURL name="selectionAction" var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="petitions" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-petitions.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de publication --%>
<liferay-portlet:actionURL name="selectionAction" var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="petitions" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-petitions.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de depublication --%>
<liferay-portlet:actionURL name="selectionAction" var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="petitions" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/project-bo-view-petitions.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="petitions" />
	<portlet:param name="mvcPath" value="/project-bo-view-petitions.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>
<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {
			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-entries" />')) {
			submitForm(form, '${publishSelectionURL}');
		}
	}
	function unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-entries" />')) {
			submitForm(form, '${unpublishSelectionURL}');
		}
	}
</aui:script>