<%@ include file="/project-bo-init.jsp"%>

<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="saisinesObservatoireURL">
    <portlet:param name="tab" value="saisines-observatoire" />
    <portlet:param name="orderByCol" value="${dc.orderByCol}" />
    <portlet:param name="orderByType" value="${dc.orderByType}" />
    <portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
    <portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien vers la page d'ajout/edition d'une entite --%>
<liferay-portlet:renderURL varImpl="addSaisineObservatoireURL">
    <portlet:param name="cmd" value="editSaisineObservatoire" />
    <portlet:param name="mvcPath" value="/project-bo-edit-saisine-observatoire.jsp" />
    <portlet:param name="returnURL" value="${saisinesObservatoireURL}" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entites --%>
<liferay-frontend:management-bar includeCheckBox="true" searchContainerId="saisinesObservatoireSearchContainer">

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
                                              portletURL="${saisinesObservatoireURL}" />
    </liferay-frontend:management-bar-filters>

    <%-- Composant : partie gestion (affichee apres une selection) --%>
    <liferay-frontend:management-bar-action-buttons>
        <c:if test="${not dc.workflowEnabled}">
            <c:if test="${dc.hasPermission('EDIT_SAISINE_OBSERVATOIRE') and empty themeDisplay.scopeGroup.getStagingGroup()}">
                <liferay-frontend:management-bar-button
                        href='<%="javascript:" + renderResponse.getNamespace() + "unpublishSelection();"%>'
                        icon="times" label="unpublish" />
            </c:if>
        </c:if>
        <c:if test="${dc.hasPermission('DELETE_SAISINE_OBSERVATOIRE') and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
        <liferay-ui:search-container id="saisinesObservatoireSearchContainer"
                                     searchContainer="${dc.searchContainer}">
            <liferay-ui:search-container-results results="${dc.saisinesObservatoire}" />

            <liferay-ui:search-container-row
                    className="eu.strasbourg.service.project.model.SaisineObservatoire" modelVar="saisineObservatoire"
                    keyProperty="saisineObservatoireId" rowIdProperty="saisineObservatoireId">

                <%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
                <liferay-portlet:renderURL varImpl="editSaisineObservatoireURL">
                    <portlet:param name="cmd" value="editSaisineObservatoire" />
                    <portlet:param name="saisineObservatoireId" value="${saisineObservatoire.saisineObservatoireId}" />
                    <portlet:param name="returnURL" value="${saisinesObservatoireURL}" />
                    <portlet:param name="mvcPath" value="/project-bo-edit-saisine-observatoire.jsp" />
                </liferay-portlet:renderURL>

                <%-- Colonne : Titre --%>
                <liferay-ui:search-container-column-text cssClass="content-column"
                                                         href="${editSaisineObservatoireURL}" name="title" truncate="true" orderable="true"
                                                         value="${saisineObservatoire.title}" />

                <%-- Colonne : Auteur --%>
                <liferay-ui:search-container-column-text name="author"
                                                         cssClass="content-column" truncate="true">
                    ${saisineObservatoire.getAuthorLabel()}
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Date de modification --%>
                <fmt:formatDate value="${saisineObservatoire.modifiedDate}"
                                var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
                <liferay-ui:search-container-column-text
                        name="modified-date" orderable="true"
                        value="${formattedModifiedDate}" />

                <%-- Colonne : Statut --%>
                <liferay-ui:search-container-column-text name="status">
                    <aui:workflow-status markupView="lexicon" showIcon="false"
                                         showLabel="false" status="${saisineObservatoire.status}" />
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Actions possibles --%>
                <liferay-ui:search-container-column-text>
                    <liferay-ui:icon-menu markupView="lexicon">

                        <c:if test="${dc.hasPermission('EDIT_SAISINE_OBSERVATOIRE') and empty themeDisplay.scopeGroup.getStagingGroup()}">
                            <liferay-ui:icon message="edit" url="${editSaisineObservatoireURL}" />
                        </c:if>

                        <liferay-portlet:actionURL name="deleteSaisineObservatoire" var="deleteSaisineObservatoireURL">
                            <portlet:param name="cmd" value="deleteSaisineObservatoire" />
                            <portlet:param name="tab" value="saisines-observatoire" />
                            <portlet:param name="saisineObservatoireId" value="${saisineObservatoire.saisineObservatoireId}" />
                        </liferay-portlet:actionURL>

                        <c:if test="${dc.hasPermission('DELETE_SAISINE_OBSERVATOIRE') and empty themeDisplay.scopeGroup.getStagingGroup()}">
                            <liferay-ui:icon message="delete" url="${deleteSaisineObservatoireURL}" />
                        </c:if>

                    </liferay-ui:icon-menu>
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
        <aui:input type="hidden" name="petitionIds" value="${dc.allSaisineObservatoireIds}" />
        <aui:button-row>
            <aui:button cssClass="btn-lg" type="submit"
                        value="export-saisines-observatoire-xlsx" />
        </aui:button-row>
    </form>
</div>


<%-- Composant : bouton d'ajout d'entite --%>
<liferay-frontend:add-menu>
    <c:if test="${dc.hasPermission('ADD_SAISINE_OBSERVATOIRE') and empty themeDisplay.scopeGroup.getStagingGroup()}">
        <liferay-frontend:add-menu-item title="Ajouter une saisine" url="${addSaisineObservatoireURL}" />
    </c:if>
</liferay-frontend:add-menu>

<%-- URL : defini le lien vers l'action de suppression --%>
<liferay-portlet:actionURL name="selectionAction" var="deleteSelectionURL">
    <portlet:param name="cmd" value="delete" />
    <portlet:param name="tab" value="saisines-observatoire" />
    <portlet:param name="orderByCol" value="${dc.orderByCol}" />
    <portlet:param name="orderByType" value="${dc.orderByType}" />
    <portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
    <portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de publication --%>
<liferay-portlet:actionURL name="selectionAction" var="publishSelectionURL">
    <portlet:param name="cmd" value="publish" />
    <portlet:param name="tab" value="saisines-observatoire" />
    <portlet:param name="orderByCol" value="${dc.orderByCol}" />
    <portlet:param name="orderByType" value="${dc.orderByType}" />
    <portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
    <portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<%-- URL : defini le lien vers l'action de depublication --%>
<liferay-portlet:actionURL name="selectionAction" var="unpublishSelectionURL">
    <portlet:param name="cmd" value="unpublish" />
    <portlet:param name="tab" value="saisines-observatoire" />
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
</aui:script>