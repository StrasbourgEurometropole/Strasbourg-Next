<%@ include file="/place-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.place.model.SubPlace"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<liferay-portlet:renderURL varImpl="subPlacesURL">
	<portlet:param name="tab" value="subPlaces" />
	<portlet:param name="mvcPath" value="/place-bo-view-subplaces.jsp" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="subPlacesSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.place.model.SubPlace"
				modelVar="subPlace" keyProperty="subPlaceId">
				<liferay-portlet:renderURL varImpl="editSubPlaceURL">
					<portlet:param name="cmd" value="editSubPlace" />
					<portlet:param name="subPlaceId" value="${subPlace.subPlaceId}" />
					<portlet:param name="backURL" value="${subPlacesURL}" />
					<portlet:param name="mvcPath" value="/place-bo-edit-subplace.jsp" />
					<portlet:param name="tab" value="subPlaces" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editSubPlaceURL}" name="name-subplace" truncate="true"
					orderable="true" value="${subPlace.nameCurrentValue}" />
				
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="name-parent" truncate="true" orderable="true"
					value="${subPlace.getPlaceByPlaceId(subPlace.placeId).aliasCurrentValue}" />

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${subPlace.status}" />
				</liferay-ui:search-container-column-text>


				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsSubPlace(subPlace).getActionDropdownItems()}"	/>
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
	<portlet:param name="tab" value="subPlaces" />
	<portlet:param name="mvcPath" value="/place-bo-view-subplaces.jsp" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="subPlaces" />
	<portlet:param name="mvcPath" value="/place-bo-view-subplaces.jsp" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="subPlaces" />
	<portlet:param name="mvcPath" value="/place-bo-view-subplaces.jsp" />
</liferay-portlet:actionURL>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-subplaces" />')) {
			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-subplaces" />')) {
					submitForm(form, '${publishSelectionURL}');
		}
	}
	function unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-subplaces" />')) {
			submitForm(form, '${unpublishSelectionURL}');
		}
	}
</aui:script>
