<%@ include file="/help-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="helpProposalsURL">
	<portlet:param name="tab" value="helpProposals" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/help-bo-view-help-proposals.jsp" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entites --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
<liferay-portlet:actionURL name="redirectToHelpProposal" var="redirectToHelpProposalURL">
	<portlet:param name="helpProposalId" value="TO_BE_REPLACED" />
	<portlet:param name="backURL" value="${helpProposalsURL}" />
</liferay-portlet:actionURL>
<%-- Composant : Champ d'acces direct par reference de proposition --%>
<div class="container-fluid-1280">
	<div class="input-group">
		<div class="input-group-prepend">
			<span class="input-group-text"><liferay-ui:message key="go-directly-to-proposal-detail"/></span>
		</div>
		<input type="text" id="proposal-id-input" aria-label="Référence de la proposition" placeholder="Identifiant (ex : 354440815215)" class="form-control">
		<div class="input-group-append">
			<button class="btn btn-outline-secondary"  type="button" id="direct-proposal-access-button">Valider</button>
		</div>
	</div>
</div>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="helpProposalsSearchContainer"
			searchContainer="${dc.searchContainer}">


			<liferay-ui:search-container-row
				className="eu.strasbourg.service.help.model.HelpProposal" modelVar="helpProposal"
				keyProperty="helpProposalId" rowIdProperty="helpProposalId">

				<%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
				<liferay-portlet:renderURL varImpl="editHelpProposalURL">
					<portlet:param name="cmd" value="editHelpProposal" />
					<portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
					<portlet:param name="backURL" value="${helpProposalsURL}" />
					<portlet:param name="mvcPath" value="/help-bo-edit-help-proposal.jsp" />
				</liferay-portlet:renderURL>

				<%-- URL : definit le lien vers la page de consultation des demandes d'aide --%>
                <liferay-portlet:renderURL varImpl="viewProposalHelpRequestsURL">
                    <portlet:param name="cmd" value="viewProposalHelpRequests" />
                    <portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
                    <portlet:param name="backURL" value="${helpProposalsURL}" />
                    <portlet:param name="mvcPath" value="/help-bo-view-proposal-help-requests.jsp" />
                </liferay-portlet:renderURL>

				<%-- Colonne : Titre --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editHelpProposalURL}" name="title" truncate="true" orderable="true">
					<c:out value="${helpProposal.titleCurrentValue}" escapeXml='true'/>
                </liferay-ui:search-container-column-text>

				<%-- Colonne : Createur --%>
				<liferay-ui:search-container-column-text name="user">
					<c:out value="${helpProposal.authorNameLabel}" escapeXml='true'/>
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Date de modification --%>
				<fmt:formatDate value="${helpProposal.modifiedDate}"
								var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text cssClass="content-column"
														 name="modified-date" truncate="true" orderable="true"
														 value="${formattedModifiedDate}" />

				<%-- Colonne : Statut activité de l'aide --%>
				<liferay-ui:search-container-column-text name="statusHelpActivity">
                    <span class="badge ${helpProposal.getActivityStatusClass()}">
                        ${helpProposal.getActivityStatusTitle(locale)}
                    </span>
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Statut modération de l'aide --%>
				<liferay-ui:search-container-column-text name="statusHelpModeration">
				    <span class="badge ${helpProposal.getModerationStatusClass()}">
				        ${helpProposal.getModerationStatusTitle(locale)}
                    </span>
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Nombre de demandes --%>
				<liferay-ui:search-container-column-text name="nb-requests">
					${dc.helpRequestsByProposal[helpProposal.helpProposalId]}
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Statut de publication de l'aide --%>
				<liferay-ui:search-container-column-text name="statusHelpPublication">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${helpProposal.status}" />
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Actions possibles --%>
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsHelpProposal(helpProposal).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>


<%-- URL : defini le lien vers l'action de suppression --%>
<liferay-portlet:actionURL name="selectionAction" var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="helpProposals" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/help-bo-view-help-proposals.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de publication --%>
<liferay-portlet:actionURL name="selectionAction" var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="helpProposals" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/help-bo-view-help-proposals.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de depublication --%>
<liferay-portlet:actionURL name="selectionAction" var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="helpProposals" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/help-bo-view-help-proposals.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- Script : Permet d'accéeder directement la proposition par son identifiant--%>
<script type="text/javascript">
	/*
	* Lors du click sur le bouton d'acces direct par reference
	*/
	$("#direct-proposal-access-button").click(function(event){
		event.preventDefault();

		var modifiedURL = "${redirectToHelpProposalURL}";
		var helpProposalId = $("#proposal-id-input").val();
		modifiedURL = modifiedURL.replace("TO_BE_REPLACED", helpProposalId);
		window.location.assign(modifiedURL);

	});

</script>

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
	function <portlet:namespace />deleteHelp() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
				.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
				'<portlet:namespace />allRowIds');

			submitForm(form, '${deleteSelectionURL}');
		}
	}
</aui:script>