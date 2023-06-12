<%@ include file="/notif-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="servicesURL">
	<portlet:param name="tab" value="services" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/notif-bo-view-services.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<div class="container-fluid container-fluid-max-xl main-content-body">

	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="notifsSearchContainer" searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.notif.model.ServiceNotif"
				modelVar="service" keyProperty="serviceId" rowIdProperty="serviceId">

				<liferay-portlet:renderURL varImpl="editServiceURL">
					<portlet:param name="cmd" value="editService" />
					<portlet:param name="serviceId" value="${service.serviceId}" />
					<portlet:param name="backURL" value="${servicesURL}" />
					<portlet:param name="mvcPath" value="/notif-bo-edit-service.jsp" />
				</liferay-portlet:renderURL>

                <!-- Colonne : nom du service -->
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="eu.strasbourg.notif.service.name" truncate="true"
					href="${editServiceURL}" value="${service.name}" />

                <!-- ACTIONS -->
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsService(service).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>


<liferay-portlet:renderURL varImpl="addServiceURL">
	<portlet:param name="cmd" value="editService" />
	<portlet:param name="mvcPath" value="/notif-bo-edit-service.jsp" />
	<portlet:param name="backURL" value="${servicesURL}" />
</liferay-portlet:renderURL>


<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function areYouSure(url) {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			submitForm(form, url);
		}
	}
</aui:script>