<%@ include file="/csmap-bo-agenda-init.jsp" %>

<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="agendaThematiqueURL">
	<portlet:param name="tab" value="agendaThematique" />
</liferay-portlet:renderURL>
<%-- URL : definit le lien vers la page d'edition d'une entite --%>
<liferay-portlet:renderURL varImpl="addAgendaThematiqueURL">
	<portlet:param name="cmd" value="editAgendaThematique" />
    <portlet:param name="backURL" value="${agendaThematiqueURL}" />
    <portlet:param name="mvcPath" value="/csmap-bo-agenda-edit-thematique.jsp" />
</liferay-portlet:renderURL>

<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="agendasThematiqueSearchContainer"
			searchContainer="${dc.searchContainer}">


			<liferay-ui:search-container-row
				className="eu.strasbourg.service.csmap.model.Agenda" modelVar="agenda"
				keyProperty="agendaId" >

                <%-- URL : definit le lien vers la page d'edition de l'entite selectionnee --%>
                <liferay-portlet:renderURL varImpl="editAgendaThematiqueURL">
                    <portlet:param name="cmd" value="editAgendaThematique" />
                    <portlet:param name="agendaId" value="${agenda.agendaId}" />
                    <portlet:param name="backURL" value="${agendaThematiqueURL}" />
                    <portlet:param name="mvcPath" value="/csmap-bo-agenda-edit-thematique.jsp" />
                </liferay-portlet:renderURL>
                <%-- URL : definit le lien vers l'action de supprimer l'entite selectionnee --%>
                <liferay-portlet:actionURL name="deleteAgendaThematique" var="deleteAgendaThematiqueURL">
                    <portlet:param name="cmd" value="deleteAgendaThematique" />
                    <portlet:param name="tab" value="agendaThematique" />
                    <portlet:param name="agendaId" value="${agenda.agendaId}" />
                </liferay-portlet:actionURL>
                <%-- URL : definit le lien vers l'action d'activer l'entite selectionnee --%>
                <liferay-portlet:actionURL name="ActivateAgendaThematique" var="ActivateAgendaThematiqueURL">
                    <portlet:param name="cmd" value="ActivateAgendaThematique" />
                    <portlet:param name="tab" value="agendaThematique" />
                    <portlet:param name="agendaId" value="${agenda.agendaId}" />
                </liferay-portlet:actionURL>
                <%-- URL : definit le lien vers l'action de désactiver l'entite selectionnee --%>
                <liferay-portlet:actionURL name="deactivateAgendaThematique" var="deactivateAgendaThematiqueURL">
                    <portlet:param name="cmd" value="deactivateAgendaThematique" />
                    <portlet:param name="tab" value="agendaThematique" />
                    <portlet:param name="agendaId" value="${agenda.agendaId}" />
                </liferay-portlet:actionURL>

				<%-- Colonne : Titre --%>
				<liferay-ui:search-container-column-text cssClass="content-column" href="${editAgendaThematiqueURL}"
					name="title" truncate="true" orderable="true" value="${agenda.getTitle()}" />

				<%-- Colonne : IsActive --%>
				<liferay-ui:search-container-column-text cssClass="content-column ${dc.getCSSClass(agenda.getIsActive())}"
					name="isActive" truncate="true" orderable="true"
					value="${agenda.getIsActive()?'Oui':'Non'}" />


				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsAgendaThematique(agenda).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>
			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>

</div>

<aui:script>
	function areYouSure(url) {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-activate-this-agenda" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			submitForm(form, url);
		}
	}
</aui:script>

<style>
    .green {color: #76BD4A;}

    .red {color: #C73C42;}
</style>