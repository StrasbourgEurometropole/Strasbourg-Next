<%@ include file="/council-bo-init.jsp" %>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="councilSessionsURL">
	<portlet:param name="tab" value="councilSessions" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/council-bo-view-council-sessions.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>


<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">

	<%-- Composant : definit la liste des messages d'erreur  (voir methode "doProcessAction" dans le deleteAction de l'entite) --%>
	<liferay-ui:error key="council-has-delib-error" message="council-has-delib-error" />

	<aui:form method="post" name="fm">

		<liferay-ui:search-container id="councilSessionsSearchContainer" searchContainer="${dc.searchContainer}">


			<liferay-ui:search-container-row
				className="eu.strasbourg.service.council.model.CouncilSession"
				modelVar="councilSession" keyProperty="councilSessionId" >

				<liferay-portlet:renderURL varImpl="editCouncilSessionURL">
					<portlet:param name="cmd" value="editCouncilSession" />
					<portlet:param name="councilSessionId" value="${councilSession.councilSessionId}" />
					<portlet:param name="backURL" value="${councilSessionsURL}" />
					<portlet:param name="tab" value="councilSessions" />
					<portlet:param name="mvcPath" value="/council-bo-edit-council-session.jsp" />
				</liferay-portlet:renderURL>

                <!-- Colonne : Titre -->
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editCouncilSessionURL}" name="title" truncate="true"
					orderable="true" value="${councilSession.title}" />

                <c:if test="${isAdmin || isAdminEvote}">
                    <!-- Colonne : Type de conseil -->
                    <liferay-ui:search-container-column-text
                        name="council-type"
                        orderable="true" value="${councilSession.typeCouncil.title}" />
                </c:if>

				<fmt:formatDate value="${councilSession.date}"
					var="formattedDate" type="date" pattern="dd/MM/yyyy" />

				<!-- Colonne : Date -->
				<liferay-ui:search-container-column-text
					name="date" orderable="true"
					value="${formattedDate}" />

                <!-- Colonne : Président -->
                <liferay-ui:search-container-column-text cssClass="content-column"
                    name="official-leader" truncate="true" orderable="true"
                    value="${councilSession.officialLeader.fullName}" />

                <!-- ACTIONS -->
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsConcilSessions(councilSession).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

