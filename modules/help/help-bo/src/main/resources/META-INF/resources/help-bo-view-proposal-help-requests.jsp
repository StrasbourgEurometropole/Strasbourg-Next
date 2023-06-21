<%@ include file="/help-bo-init.jsp"%>

<%-- URL : definit le lien vers la page d'edition de l'entite selectionne --%>
<liferay-portlet:renderURL varImpl="editHelpProposalURL">
	<portlet:param name="cmd" value="editHelpProposal" />
	<portlet:param name="helpProposalId" value="${dc.helpProposal.helpProposalId}" />
	<portlet:param name="backURL" value="${dc.currentUrl}" />
	<portlet:param name="mvcPath" value="/help-bo-edit-help-proposal.jsp" />
</liferay-portlet:renderURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<div class="help-bo ">
		<div class="help-request-title">
			<liferay-ui:message key="proposal-help-requests-list"/>
			<liferay-ui:message key=" : ${dc.helpProposal.titleCurrentValue}"></liferay-ui:message>
		</div>
	</div>
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="helpRequestsSearchContainer"
									 searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-row className="eu.strasbourg.service.help.model.HelpRequest" modelVar="helpRequest"
											 keyProperty="helpRequestId">
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
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsProposalHelpRequest(helpRequest).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
										markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>