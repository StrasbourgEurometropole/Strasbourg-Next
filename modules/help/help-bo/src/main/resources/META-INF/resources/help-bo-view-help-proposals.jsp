<%@ include file="/help-bo-init.jsp"%>

<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="helpProposalsURL">
	<portlet:param name="tab" value="helpProposals" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien vers la page d'ajout/edition d'une entite --%>
<liferay-portlet:renderURL varImpl="addHelpProposalURL">
	<portlet:param name="cmd" value="edithelpProposal" />
	<portlet:param name="mvcPath" value="/help-bo-edit-help-proposal.jsp" />
	<portlet:param name="returnURL" value="${helpProposalsURL}" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entites --%>
<liferay-frontend:management-bar includeCheckBox="true" searchContainerId="helpsSearchContainer">

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
				portletURL="${helpProposalsURL}" />
		</liferay-frontend:management-bar-filters>

		<%-- Composant : partie gestion (affichee apres une selection) --%>
		<liferay-frontend:management-bar-action-buttons>
			<c:if test="${not dc.workflowEnabled}">
				<c:if test="${dc.hasPermission('EDIT_HELP') and empty themeDisplay.scopeGroup.getStagingGroup()}">
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "publishSelection();"%>'
						icon="check" label="publish" />
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "unpublishSelection();"%>'
						icon="times" label="unpublish" />
				</c:if>
			</c:if>
			<c:if test="${dc.hasPermission('DELETE_HELP') and empty themeDisplay.scopeGroup.getStagingGroup()}">
			<liferay-frontend:management-bar-button
				href='<%="javascript:" + renderResponse.getNamespace() + "deleteSelection();"%>'
				icon="trash" label="delete" />
			</c:if>
		</liferay-frontend:management-bar-action-buttons>

</liferay-frontend:management-bar>

<%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
<liferay-portlet:actionURL name="redirectToHelpProposal" var="redirectToHelpProposalURL">
	<portlet:param name="helpProposalId" value="TO_BE_REPLACED" />
	<portlet:param name="returnURL" value="${helpProposalsURL}" />
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
<div class="container-fluid-1280 main-content-body">
	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="helpProposalsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-results results="${dc.helpProposals}" />

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.help.model.HelpProposal" modelVar="helpProposal"
				keyProperty="helpProposalId" rowIdProperty="helpProposalId">

				<%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
				<liferay-portlet:renderURL varImpl="editHelpProposalURL">
					<portlet:param name="cmd" value="editHelpProposal" />
					<portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
					<portlet:param name="returnURL" value="${helpProposalsURL}" />
					<portlet:param name="mvcPath" value="/help-bo-edit-help-proposal.jsp" />
				</liferay-portlet:renderURL>

				<%-- URL : definit le lien vers la page de consultation des demandes d'aide --%>
                <liferay-portlet:renderURL varImpl="viewProposalHelpRequestsURL">
                    <portlet:param name="cmd" value="viewProposalHelpRequests" />
                    <portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
                    <portlet:param name="returnURL" value="${helpProposalsURL}" />
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
					<liferay-ui:icon-menu markupView="lexicon">
						<c:if test="${dc.hasPermission('EDIT_HELP') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="edit" url="${editHelpProposalURL}" />
						</c:if>

                        <%-- TODO : ajouter un checker sur les permissions VIEW des demandes d'aide --%>
						<c:if test="${dc.hasPermission('VIEW') and empty themeDisplay.scopeGroup.getStagingGroup()
							and dc.helpRequestsByProposal[helpProposal.helpProposalId] > 0}">
							<liferay-ui:icon message="view-help-requests" url="${viewProposalHelpRequestsURL}" />
						</c:if>

						<%-- Deactivation de la proposition d'aide --%>
						<liferay-portlet:actionURL name="changeActivityHelpProposal" var="changeActivityHelpProposalURL">
							<portlet:param name="cmd" value="changeActivityHelpProposal" />
							<portlet:param name="tab" value="helpProposals" />
							<portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
						</liferay-portlet:actionURL>
						<c:if test="${dc.hasPermission('CHANGE_ACTIVITY_HELP') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<c:if test="${helpProposal.getActivityStatusTitle(locale) == 'Active'}">
								<liferay-ui:icon-delete confirmation="help-deactivate-confirm" message="deactivate-help-proposal" url="${changeActivityHelpProposalURL}" />
							</c:if>
							<c:if test="${helpProposal.getActivityStatusTitle(locale) == 'Inactive'}">
								<liferay-ui:icon-delete confirmation="help-reactivate-confirm" message="reactivate-help-proposal" url="${changeActivityHelpProposalURL}" />
							</c:if>
						</c:if>

						<%-- URL : definit le lien vers l'action de modifier l'aide --%>
						<liferay-portlet:actionURL name="readHelpProposal" var="readHelpProposalURL">
							<portlet:param name="cmd" value="readHelpProposal" />
							<portlet:param name="tab" value="helpProposals" />
							<portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
						</liferay-portlet:actionURL>
						<c:if test="${dc.hasPermission('EDIT_HELP') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="setRead" url="${readHelpProposalURL}" />
						</c:if>

						<%-- Mise en dépublié/publié de la proposition d'aide --%>
						<liferay-portlet:actionURL name="changeStatusHelpProposal" var="publishHelpProposalURL">
							<portlet:param name="cmd" value="changeStatusHelpProposal" />
							<portlet:param name="tab" value="helpProposals" />
							<portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
							<portlet:param name="status" value="0" />
						</liferay-portlet:actionURL>
						<liferay-portlet:actionURL name="changeStatusHelpProposal" var="unpublishHelpProposalURL">
							<portlet:param name="cmd" value="changeStatusHelpProposal" />
							<portlet:param name="tab" value="helpProposals" />
							<portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
							<portlet:param name="status" value="2" />
						</liferay-portlet:actionURL>
						<c:if test="${dc.hasPermission('EDIT_HELP') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<c:if test="${helpProposal.status == '0'}">
								<liferay-ui:icon-delete confirmation="help-unpublish-confirm" message="unpublish-help-proposal" url="${unpublishHelpProposalURL}" />
							</c:if>
							<c:if test="${helpProposal.status == '2'}">
								<liferay-ui:icon-delete confirmation="help-publish-confirm" message="publish-help-proposal" url="${publishHelpProposalURL}" />
							</c:if>
						</c:if>

						<liferay-portlet:actionURL name="deleteHelpProposal" var="deleteHelpProposalURL">
							<portlet:param name="cmd" value="deleteHelpProposal" />
							<portlet:param name="tab" value="helpProposals" />
							<portlet:param name="helpProposalId" value="${helpProposal.helpProposalId}" />
						</liferay-portlet:actionURL>
						<c:if test="${dc.hasPermission('DELETE_HELP') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon-delete confirmation="help-delete-confirm" message="delete" url="${deleteHelpProposalURL}" />
						</c:if>
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<%-- Composant : bouton d'ajout d'entite --%>
<liferay-frontend:add-menu>
	<c:if test="${dc.hasPermission('ADD_HELP') and empty themeDisplay.scopeGroup.getStagingGroup()}">
		<liferay-frontend:add-menu-item title="Ajouter une proposition d'aide" url="${addHelpProposalURL}" />
	</c:if>
</liferay-frontend:add-menu>

<%-- URL : defini le lien vers l'action de suppression --%>
<liferay-portlet:actionURL name="selectionAction" var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="helpProposals" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de publication --%>
<liferay-portlet:actionURL name="selectionAction" var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="helpProposals" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de depublication --%>
<liferay-portlet:actionURL name="selectionAction" var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="helpProposals" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
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