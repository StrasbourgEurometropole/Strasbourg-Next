<%@ include file="/council-bo-init.jsp" %>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%@page import="eu.strasbourg.service.council.constants.StageDeliberation"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<liferay-portlet:renderURL varImpl="deliberationsURL">
	<portlet:param name="tab" value="deliberations" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/council-bo-view-deliberations.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="importDeliberationURL">
	<portlet:param name="cmd" value="importDeliberation" />
	<portlet:param name="mvcPath" value="/council-bo-import-deliberation.jsp" />
	<portlet:param name="backURL" value="${importDeliberationURL}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">

    <%-- Composant : definit la liste des messages d'erreur --%>
    <liferay-ui:error key="quorum-error">
        <liferay-ui:message key="quorum-error" arguments='<%= SessionErrors.get(liferayPortletRequest, "quorum-error") %>' />
    </liferay-ui:error>
    <liferay-ui:error key="council.deliberation-already-open" message="council.deliberation-already-open" />

    <liferay-ui:success key="import-successful" message="import-successful" />

	<aui:form method="post" name="fm">

		<liferay-ui:search-container id="deliberationsSearchContainer"
			searchContainer="${dc.searchContainer}">


			<liferay-ui:search-container-row
				className="eu.strasbourg.service.council.model.Deliberation"
				modelVar="deliberation" keyProperty="deliberationId" >
				<liferay-portlet:renderURL varImpl="editDeliberationURL">
					<portlet:param name="cmd" value="editDeliberation" />
					<portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
					<portlet:param name="backURL" value="${deliberationsURL}" />
					<portlet:param name="mvcPath" value="/council-bo-edit-deliberation.jsp" />
				</liferay-portlet:renderURL>

                <liferay-ui:search-container-column-text
                name="order"
                orderable="true" value="${deliberation.order}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editDeliberationURL}" name="title" truncate="true"
					orderable="true" value="${deliberation.title}" />

				<fmt:formatDate value="${deliberation.councilSession.date}"
					var="formattedDate" type="date" pattern="dd/MM/yyyy" />
				<!-- Colonne : Date de conseil - Type de conseil -->
				<liferay-ui:search-container-column-text cssClass="content-column"
                    name="councilSession"
                    orderable="true" value="${formattedDate} - ${deliberation.councilSession.typeCouncil.title}" />


                <liferay-ui:search-container-column-text cssClass="content-column ${dc.getCSSClass(deliberation)}"
                    name="stage"
                    orderable="true" value="${deliberation.stage}" />

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsDeliberations(deliberation).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>

	<aui:button-row>
        <aui:button cssClass="btn-lg" type="submit" href="${importDeliberationURL}" value="Nouvel import" title="Importer des deliberations"/>
    </aui:button-row>
</div>


<liferay-util:html-bottom>
    <script src="/o/councilbo/js/council-bo-view-deliberations.js" type="text/javascript"></script>
</liferay-util:html-bottom>

<liferay-portlet:actionURL name="selectionAction"
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="deliberations" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
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
</aui:script>