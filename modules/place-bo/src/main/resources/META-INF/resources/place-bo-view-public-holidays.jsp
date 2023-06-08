<%@ include file="/place-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.place.model.PublicHoliday"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<liferay-portlet:renderURL varImpl="publicHolidaysURL">
	<portlet:param name="tab" value="publicHolidays" />
	<portlet:param name="mvcPath" value="/place-bo-view-public-holidays.jsp" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="addPublicHolidayURL">
	<portlet:param name="cmd" value="editPublicHoliday" />
	<portlet:param name="mvcPath" value="/place-bo-edit-public-holiday.jsp" />
	<portlet:param name="backURL" value="${publicHolidaysURL}" />
	<portlet:param name="tab" value="publicHolidays" />
</liferay-portlet:renderURL>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="publicHolidaysSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.place.model.PublicHoliday" modelVar="publicHoliday"
				keyProperty="publicHolidayId">
				<liferay-portlet:renderURL varImpl="editPublicHolidayURL">
					<portlet:param name="cmd" value="editPublicHoliday" />
					<portlet:param name="publicHolidayId" value="${publicHoliday.publicHolidayId}" />
					<portlet:param name="backURL" value="${publicHolidaysURL}" />
					<portlet:param name="mvcPath" value="/place-bo-edit-public-holiday.jsp" />
					<portlet:param name="tab" value="publicHolidays" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editPublicHolidayURL}" name="name-public-holiday" truncate="true" orderable="true"
					value="${publicHoliday.nameCurrentValue}" />
				
				<fmt:formatDate value="${publicHoliday.date}"
					var="formattedDate" type="date" pattern="dd/MM/yyyy" />
				<liferay-ui:search-container-column-text
					name="date-public-holiday" orderable="true"
					value="${formattedDate}" />
				
				<liferay-ui:search-container-column-text
					name="recurrent" orderable="true"
					value="${publicHoliday.recurrent? 'Oui' : 'Non'}" />


				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsPublicHoliday(publicHoliday).getActionDropdownItems()}"	/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>


<liferay-portlet:actionURL name="selectionAction"
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="publicHolidays" />
</liferay-portlet:actionURL>

<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-public-holidaies" />')) {
			submitForm(form, '${deleteSelectionURL}');
		}
	}
</aui:script>