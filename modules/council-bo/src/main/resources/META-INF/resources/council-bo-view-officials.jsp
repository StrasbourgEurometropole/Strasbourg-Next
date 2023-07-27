<%@ include file="/council-bo-init.jsp" %>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="officialsURL">
	<portlet:param name="tab" value="officials" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/council-bo-view-officials.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">

		<liferay-ui:search-container id="officialsSearchContainer" searchContainer="${dc.searchContainer}">


			<liferay-ui:search-container-row
				className="eu.strasbourg.service.council.model.Official"
				modelVar="official" keyProperty="officialId" >

				<liferay-portlet:renderURL varImpl="editOfficialURL">
					<portlet:param name="cmd" value="editOfficial" />
					<portlet:param name="officialId" value="${official.officialId}" />
					<portlet:param name="backURL" value="${officialsURL}" />
					<portlet:param name="tab" value="officials" />
					<portlet:param name="mvcPath" value="/council-bo-edit-official.jsp" />
				</liferay-portlet:renderURL>

                <!-- Colonne : Nom complet -->
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editOfficialURL}" name="full-name" truncate="true"
					orderable="true" value="${official.fullName}" />

				<!-- Colonne : Email -->
                <liferay-ui:search-container-column-text cssClass="content-column"
                    href="${editOfficialURL}" name="email" truncate="true"
                    orderable="false" value="${official.email}" />

                <!-- Colonne : Est actif ? -->
                <liferay-ui:search-container-column-text
                    name="is-active"
                    orderable="false" value="${official.isActive ? 'Oui' : 'Non'}" />

                <!-- ACTIONS -->
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsOfficials(official).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>

	<!-- ACTION RESOURCE : Export des élus-->
    <liferay-portlet:resourceURL var="exportOfficialsURL" id="exportOfficials" />
	<form method="POST" action="${exportOfficialsURL}">
        <aui:button-row>
            <aui:button cssClass="btn-lg" type="submit" value="eu.council.bo.export.officials" />
        </aui:button-row>
    </form>

</div>

