<%@ include file="/council-bo-init.jsp" %>

<%@page import="eu.strasbourg.service.council.constants.StageDeliberation"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<liferay-portlet:renderURL varImpl="deliberationsURL">
	<portlet:param name="tab" value="deliberations" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addDeliberationURL">
	<portlet:param name="cmd" value="editDeliberation" />
	<portlet:param name="mvcPath" value="/council-bo-edit-deliberation.jsp" />
	<portlet:param name="returnURL" value="${deliberationsURL}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="importDeliberationURL">
	<portlet:param name="cmd" value="importDeliberation" />
	<portlet:param name="mvcPath" value="/council-bo-import-deliberation.jsp" />
	<portlet:param name="returnURL" value="${importDeliberationURL}" />
</liferay-portlet:renderURL>

<liferay-frontend:management-bar includeCheckBox="true" searchContainerId="deliberationsSearchContainer">
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
				orderColumns='<%= new String[] {"order", "title"} %>'
				portletURL="${deliberationsURL}" />
		</liferay-frontend:management-bar-filters>

		<liferay-frontend:management-bar-action-buttons>
			<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
				<liferay-frontend:management-bar-button
					href='<%="javascript:" + renderResponse.getNamespace() + "deleteSelection();"%>'
					icon="trash" label="delete" />
			</c:if>
		</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<div class="container-fluid-1280 main-content-body">

    <%-- Composant : definit la liste des messages d'erreur --%>
    <liferay-ui:error key="quorum-error">
        <liferay-ui:message key="quorum-error" arguments='<%= SessionErrors.get(liferayPortletRequest, "quorum-error") %>' />
    </liferay-ui:error>
    <liferay-ui:error key="council.deliberation-already-open" message="council.deliberation-already-open" />

    <liferay-ui:success key="import-successful" message="import-successful" />

	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="deliberationsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-results results="${dc.deliberations}" />

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.council.model.Deliberation"
				modelVar="deliberation" keyProperty="deliberationId" rowIdProperty="deliberationId">

				<liferay-portlet:renderURL varImpl="editDeliberationURL">
					<portlet:param name="cmd" value="editDeliberation" />
					<portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
					<portlet:param name="returnURL" value="${deliberationsURL}" />
					<portlet:param name="mvcPath" value="/council-bo-edit-deliberation.jsp" />
				</liferay-portlet:renderURL>

                <liferay-ui:search-container-column-text
                name="order"
                orderable="true" value="${deliberation.order}" />

                <liferay-ui:search-container-column-text
                name="amendement-column"
                orderable="true" value="${deliberation.amendement}" />

				<liferay-ui:search-container-column-text cssClass="content-column table-cell-content"
					href="${editDeliberationURL}" name="title"
					orderable="true" >
					<div id="delib-${deliberation.deliberationId}">${deliberation.title}</div>
                </liferay-ui:search-container-column-text>

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
					<liferay-ui:icon-menu markupView="lexicon">
						<c:if test="${dc.hasPermission('EDIT_DELIBERATION') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="edit" url="${editDeliberationURL}" />
						</c:if>

						<liferay-portlet:actionURL name="stageChangeDeliberation"
							var="examinateDeliberationURL">
							<portlet:param name="tab" value="deliberations" />
							<portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
							<portlet:param name="stage" value="${dc.getStageDeliberationName(2)}" />
						</liferay-portlet:actionURL>
						<c:if test="${deliberation.isCree() and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="examinate" url="${examinateDeliberationURL}" />
						</c:if>

						<liferay-portlet:actionURL name="openDeliberation"
                            var="openDeliberationURL">
                            <portlet:param name="tab" value="deliberations" />
                            <portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
                            <portlet:param name="stage" value="${dc.getStageDeliberationName(3)}" />
                        </liferay-portlet:actionURL>
                        <c:if test="${deliberation.isAffichageEnCours() and empty themeDisplay.scopeGroup.getStagingGroup()}">
                            <liferay-ui:icon message="open" url="${openDeliberationURL}" />
                        </c:if>

						<liferay-portlet:actionURL name="closeDeliberation"
                            var="closeDeliberationURL">
                            <portlet:param name="tab" value="deliberations" />
                            <portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
                        </liferay-portlet:actionURL>
                        <c:if test="${deliberation.isVoteOuvert() and empty themeDisplay.scopeGroup.getStagingGroup()}">
                            <liferay-ui:icon message="close" url="${closeDeliberationURL}" />
                        </c:if>

						<liferay-portlet:actionURL name="stageChangeDeliberation"
                            var="adoptDeliberationURL">
                            <portlet:param name="tab" value="deliberations" />
                            <portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
                            <portlet:param name="stage" value="${dc.getStageDeliberationName(4)}" />
                        </liferay-portlet:actionURL>
                        <c:if test="${(deliberation.isCree() or deliberation.isRejete() or deliberation.isAffichageEnCours()) and empty themeDisplay.scopeGroup.getStagingGroup()}">
                            <liferay-ui:icon message="adopt" url="${adoptDeliberationURL}" />
                        </c:if>

						<liferay-portlet:actionURL name="stageChangeDeliberation"
                            var="rejectDeliberationURL">
                            <portlet:param name="tab" value="deliberations" />
                            <portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
                            <portlet:param name="stage" value="${dc.getStageDeliberationName(5)}" />
                        </liferay-portlet:actionURL>
                        <c:if test="${(deliberation.isCree() or deliberation.isAdopte() or deliberation.isAffichageEnCours()) and empty themeDisplay.scopeGroup.getStagingGroup()}">
                            <liferay-ui:icon message="reject" url="${rejectDeliberationURL}" />
                        </c:if>

						<liferay-portlet:actionURL name="stageChangeDeliberation"
                            var="communicateDeliberationURL">
                            <portlet:param name="tab" value="deliberations" />
                            <portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
                            <portlet:param name="stage" value="${dc.getStageDeliberationName(6)}" />
                        </liferay-portlet:actionURL>
                        <c:if test="${deliberation.isCree() or deliberation.isAffichageEnCours() and empty themeDisplay.scopeGroup.getStagingGroup()}">
                            <liferay-ui:icon message="communicate" url="${communicateDeliberationURL}" />
                        </c:if>

						<liferay-portlet:actionURL name="stageChangeDeliberation"
                            var="pullOutDeliberationURL">
                            <portlet:param name="tab" value="deliberations" />
                            <portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
                            <portlet:param name="stage" value="${dc.getStageDeliberationName(7)}" />
                        </liferay-portlet:actionURL>
                        <c:if test="${deliberation.isCree() and empty themeDisplay.scopeGroup.getStagingGroup()}">
                            <liferay-ui:icon message="pull-out" url="${pullOutDeliberationURL}" />
                        </c:if>

					</liferay-ui:icon-menu>
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

<c:if test="${dc.hasPermission('ADD_DELIBERATION') and empty themeDisplay.scopeGroup.getStagingGroup()}">
	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title="Ajouter une deliberation" url="${addDeliberationURL}"/>
	</liferay-frontend:add-menu>
</c:if>

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