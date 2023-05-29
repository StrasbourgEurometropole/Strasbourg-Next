<%@ include file="/activity-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="activitiesURL">
	<portlet:param name="tab" value="activities" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/activity-bo-view-activities.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addActivityURL">
	<portlet:param name="cmd" value="editActivity" />
	<portlet:param name="mvcPath" value="/activity-bo-edit-activity.jsp" />
	<portlet:param name="backURL" value="${activitiesURL}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="activitiesSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-row
				className="eu.strasbourg.service.activity.model.Activity"
				modelVar="activity" keyProperty="activityId" >
				<liferay-portlet:renderURL varImpl="editActivityURL">
					<portlet:param name="cmd" value="editActivity" />
					<portlet:param name="activityId" value="${activity.activityId}" />
					<portlet:param name="backURL" value="${activitiesURL}" />
					<portlet:param name="mvcPath" value="/activity-bo-edit-activity.jsp" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editActivityURL}" name="title" truncate="true"
					orderable="true" value="${activity.titleCurrentValue}" />

				<liferay-ui:search-container-column-text name="type"
				    cssClass="content-column" truncate="true" >
					${activity.getTypesLabel(locale)}
				</liferay-ui:search-container-column-text>
					
				<fmt:formatDate value="${activity.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />

				<liferay-ui:search-container-column-text name="user">
					${activity.statusByUserName}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${activity.status}" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsActivity(activity).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>
<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="activities" />
	<portlet:param name="mvcPath" value="/activity-bo-view-activities.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>
<liferay-portlet:actionURL name="selectionAction"
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="activities" />
	<portlet:param name="mvcPath" value="/activity-bo-view-activities.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="activities" />
	<portlet:param name="mvcPath" value="/activity-bo-view-activities.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="mvcPath" value="/activity-bo-view-activities.jsp" />
	<portlet:param name="tab" value="activities" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>

<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {
			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-entries" />')) {
			submitForm(form, '${publishSelectionURL}');
		}
	}
	function unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-entries" />')) {
			submitForm(form, '${unpublishSelectionURL}');
		}
	}
	function getCategoriesByVocabulary(vocabularyId) {
		Liferay.Util.openSelectionModal(
		{
			onSelect: function (selectedItem) {
			alert("category : " + selectedItem.value.title);
			if (selectedItem) {
				const itemValue = selectedItem.value;
				//submitForm(form, '${filterSelectionURL}');
				//Liferay.SPA.app.navigate(urlString);
				navigate(
					addParams(
					{
						["${portletNamespace}vocabulary_" + vocabularyId]: itemValue.title,
					},
					PortletURLBuilder.create(getPortletURL())
						.setParameter("vocabulary_" + vocabularyId, itemValue.title)
						.buildString()
					) );
				}
				},
				selectOfficialName: '<portlet:namespace />selectAssetCategory',
				title: Liferay.Language.get('select-category'),
				url: '${dc.getSelectCategoriesByVocabularyIdURL(vocabularyId)}'
	    } )
	}
</aui:script>