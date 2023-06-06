<%@ include file="/place-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.place.model.SubPlace"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<liferay-portlet:renderURL varImpl="subPlacesURL">
	<portlet:param name="tab" value="subPlaces" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="addSubPlaceURL">
	<portlet:param name="cmd" value="editSubPlace" />
	<portlet:param name="mvcPath" value="/place-bo-edit-subplace.jsp" />
	<portlet:param name="returnURL" value="${subPlacesURL}" />
</liferay-portlet:renderURL>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<liferay-frontend:management-bar includeCheckBox="true"
	searchContainerId="subPlacesSearchContainer">

		<liferay-frontend:management-bar-action-buttons>
			<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
				<liferay-frontend:management-bar-button
					href='<%="javascript:" + renderResponse.getNamespace() + "publishSelection();"%>'
					icon="check" label="publish" />
				<liferay-frontend:management-bar-button
					href='<%="javascript:" + renderResponse.getNamespace() + "unpublishSelection();"%>'
					icon="times" label="unpublish" />
				<liferay-frontend:management-bar-button
					href='<%="javascript:" + renderResponse.getNamespace() + "deleteSelection();"%>'
					icon="trash" label="delete" />
			</c:if>
		</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

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
					<portlet:param name="returnURL" value="${subPlacesURL}" />
					<portlet:param name="mvcPath" value="/place-bo-edit-subplace.jsp" />
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
					<liferay-ui:icon-menu markupView="lexicon">
						<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="edit" url="${editSubPlaceURL}" />
						</c:if>

						<liferay-portlet:actionURL name="deleteSubPlace" var="deleteSubPlaceURL">
							<portlet:param name="cmd" value="deleteSubPlace" />
							<portlet:param name="tab" value="subPlaces" />
							<portlet:param name="subPlaceId" value="${subPlace.subPlaceId}" />
						</liferay-portlet:actionURL>
						<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="delete" url="${deleteSubPlaceURL}" />
						</c:if>
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<liferay-frontend:add-menu>
	<c:if
		test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
		<liferay-frontend:add-menu-item title="Ajouter un sous lieu"
			url="${addSubPlaceURL}" />
	</c:if>
</liferay-frontend:add-menu>


<liferay-portlet:actionURL name="selectionAction"
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="subPlaces" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="subPlaces" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="subPlaces" />
</liferay-portlet:actionURL>
<aui:script>
	function <portlet:namespace />deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-subplaces" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function <portlet:namespace />publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-subplaces" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${publishSelectionURL}');
		}
	}
	function <portlet:namespace />unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-subplaces" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${unpublishSelectionURL}');
		}
	}
</aui:script>
