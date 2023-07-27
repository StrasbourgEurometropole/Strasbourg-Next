<%@ include file="/help-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="helpRequestsURL">
    <portlet:param name="tab" value="helpRequests" />
    <portlet:param name="orderByCol" value="${dc.orderByCol}" />
    <portlet:param name="mvcPath" value="/help-bo-view-help-requests.jsp" />
    <portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
        managementToolbarDisplayContext="${managementDC}"
/>
<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
    <aui:form method="post" name="fm">
        <liferay-ui:search-container id="helpRequestsSearchContainer"
                                     searchContainer="${dc.searchContainer}">

            <liferay-ui:search-container-row
                    className="eu.strasbourg.service.help.model.HelpRequest" modelVar="helpRequest">

                <%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
                <liferay-portlet:renderURL varImpl="editHelpProposalURL">
                    <portlet:param name="cmd" value="editHelpProposal" />
                    <portlet:param name="backURL" value="${helpRequestsURL}" />
                    <portlet:param name="helpProposalId" value="${helpRequest.helpProposalId}" />
                    <portlet:param name="mvcPath" value="/help-bo-edit-help-proposal.jsp" />
                    <portlet:param name="tab" value="helpRequests" />
                </liferay-portlet:renderURL>

                <%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
                <liferay-portlet:renderURL varImpl="editHelpRequestURL">
                    <portlet:param name="cmd" value="editHelpRequest" />
                    <portlet:param name="helpRequestId" value="${helpRequest.helpRequestId}" />
                    <portlet:param name="backURL" value="${helpRequestsURL}" />
                    <portlet:param name="mvcPath" value="/help-bo-edit-help-request.jsp" />
                    <portlet:param name="tab" value="helpRequests" />
                </liferay-portlet:renderURL>

                <%-- URL : definit le lien vers l'action de passage en Conforme --%>
                <liferay-portlet:actionURL name="changeStatusHelpRequest" var="validHelpRequestURL">
                    <portlet:param name="cmd" value="changeStatusHelpRequest" />
                    <portlet:param name="tab" value="helpRequests" />
                    <portlet:param name="backURL" value="${dc.currentURL}" />
                    <portlet:param name="requestModerationStatus" value="Conforme" />
                    <portlet:param name="helpRequestId" value="${helpRequest.helpRequestId}" />
                    <portlet:param name="mvcPath" value="/help-bo-view-help-requests.jsp" />
                </liferay-portlet:actionURL>

                <%-- URL : definit le lien vers l'action de passage en Alerte --%>
                <liferay-portlet:actionURL name="changeStatusHelpRequest" var="alertHelpRequestURL">
                    <portlet:param name="cmd" value="changeStatusHelpRequest" />
                    <portlet:param name="tab" value="helpRequests" />
                    <portlet:param name="requestModerationStatus" value="Alerte" />
                    <portlet:param name="helpRequestId" value="${helpRequest.helpRequestId}" />
                    <portlet:param name="mvcPath" value="/help-bo-view-help-requests.jsp" />
                </liferay-portlet:actionURL>

                <%-- URL : definit le lien vers l'action de passage en Non-conforme --%>
                <liferay-portlet:actionURL name="changeStatusHelpRequest" var="notValidHelpRequestURL">
                    <portlet:param name="cmd" value="changeStatusHelpRequest" />
                    <portlet:param name="tab" value="helpRequests" />
                    <portlet:param name="requestModerationStatus" value="Non-conforme" />
                    <portlet:param name="helpRequestId" value="${helpRequest.helpRequestId}" />
                    <portlet:param name="mvcPath" value="/help-bo-view-help-requests.jsp" />
                </liferay-portlet:actionURL>
                <%-- URL : defini le lien vers l'action de suppression --%>
                <liferay-portlet:actionURL name="deleteStudentCardImages" var="deleteSelectionURL">
                    <portlet:param name="cmd" value="deleteStudentCardImages" />
                    <portlet:param name="tab" value="helpRequests" />
                    <portlet:param name="mvcPath" value="/help-bo-view-help-requests.jsp" />
                    <portlet:param name="studentPublikId" value="${helpRequest.publikId}" />
                </liferay-portlet:actionURL>

                <%-- Colonne : Date de creation --%>
                <fmt:formatDate value="${helpRequest.createDate}"
                                var="formattedCreateDate" type="date" pattern="dd/MM/yyyy HH:mm" />
                <liferay-ui:search-container-column-text cssClass="content-column"
                                                         href="${editHelpRequestURL}"
                                                         name="request-create-date" truncate="true" orderable="true"
                                                         value="${formattedCreateDate}" />

                <%-- Colonne : Titre de la proposition d'aide --%>
                <liferay-ui:search-container-column-text cssClass="content-column"
                                                         href="${editHelpRequestURL}" name="help-proposal-title" truncate="true" orderable="true">
                    <c:out value="${helpRequest.helpProposal.titleCurrentValue}" escapeXml='true'/>
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Identifiant --%>
                <liferay-ui:search-container-column-text name="help-proposal-id"
                                                         href="${editHelpRequestURL}">
                    <c:out value="${helpRequest.helpProposalId}" escapeXml='true'/>
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Demandeur d'aide --%>
                <liferay-ui:search-container-column-text name="request-author"
                                                         href="${editHelpRequestURL}">
                    <c:out value="${helpRequest.authorNameLabel}" escapeXml='true'/>
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Statut modération de la demande --%>
                <liferay-ui:search-container-column-text name="statusHelpModeration"
                                                         href="${editHelpRequestURL}">
				    <span class="badge ${helpRequest.getModerationStatusClass()}">
                            ${helpRequest.getModerationStatusTitle(locale)}
                    </span>
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Consentement a etre contacte--%>
                <liferay-ui:search-container-column-text name="request-contact-consent"
                                                         href="${editHelpRequestURL}">
                    <c:if test="${helpRequest.agreementSigned3}">
                        <liferay-ui:message key="yes"/>
                    </c:if>
                    <c:if test="${not helpRequest.agreementSigned3}">
                        <liferay-ui:message key="no"/>
                    </c:if>

                </liferay-ui:search-container-column-text>

                <%-- Colonne : Actions possibles --%>
                <liferay-ui:search-container-column-text>
                    <clay:dropdown-actions
                            aria-label="<liferay-ui:message key='show-actions' />"
                            dropdownItems="${dc.getActionsHelpRequest(helpRequest).getActionDropdownItems(dc.getImagesCount(helpRequest.publikId))}"
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

    var form = document.querySelector("[name='<portlet:namespace />fm']");

    function validHelpRequestSelection() {
        var messageDialog = "${renderRequest.getAttribute('validMessageDialog')}";
        if (confirm(messageDialog)) {
            submitForm(form, '${validHelpRequestURL}');

        }
    }
    function alertHelpRequestSelection() {
        var messageDialog = "${renderRequest.getAttribute('alertMessageDialog')}";
        if (confirm(messageDialog)) {
            submitForm(form, '${alertHelpRequestURL}');

        }
    }
    function notValidHelpRequestSelection() {
        var messageDialog = "${renderRequest.getAttribute('notValidMessageDialog')}";
        if (confirm(messageDialog)) {
            submitForm(form, '${notValidHelpRequestURL}');

        }
    }
    function deleteSelection() {

    if (confirm('<liferay-ui:message key="delete-student-ids-confirm" />')) {
    submitForm(form, '${deleteSelectionURL}');
    }
    }

</aui:script>