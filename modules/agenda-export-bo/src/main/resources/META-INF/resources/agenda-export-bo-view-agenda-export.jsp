<%@ include file="/META-INF/resources/agenda-export-bo-init.jsp" %>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="agendaExportsURL">
	<portlet:param name="tab" value="agendaExports" />
	<portlet:param name="mvcPath" value="/agenda-export-bo-view-agenda-export.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>



<%-- Composant : barre de filtres et de gestion des entite --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="agendaExportsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.agenda.model.AgendaExport" modelVar="agendaExport"
				keyProperty="agendaExportId">
				
				<%-- URL : definit le lien vers la page d'edition de l'entite selectionnee --%>
				<liferay-portlet:renderURL varImpl="editAgendaExportURL">
					<portlet:param name="tab" value="agendaExports" />
					<portlet:param name="cmd" value="editAgendaExports" />
					<portlet:param name="toExport" value="false" />
					<portlet:param name="agendaExportId" value="${agendaExport.agendaExportId}" />
					<portlet:param name="backURL" value="${agendaExportsURL}" />
					<portlet:param name="mvcPath" value="/agenda-export-bo-edit-agenda-export.jsp" />
				</liferay-portlet:renderURL>

				<%-- Colonne : userName --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editAgendaExportURL}" name="userName" truncate="true" orderable="true"
					value="${agendaExport.userName}" />

                <%-- Colonne : titre --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
														 href="${editAgendaExportURL}" name="title" truncate="true" orderable="true"
														 value="${agendaExport.titleCurrentValue}" />
				
				<%-- Colonne : Date de modification --%>
				<fmt:formatDate value="${agendaExport.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="modified-date" truncate="true" orderable="true"
					value="${formattedModifiedDate}" />

				<%-- Colonne : Statut --%>
				<liferay-ui:search-container-column-text name="status" orderable="true">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${agendaExport.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionAgendaExport(agendaExport).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>
