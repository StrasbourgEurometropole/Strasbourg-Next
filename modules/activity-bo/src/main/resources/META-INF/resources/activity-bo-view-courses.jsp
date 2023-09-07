<%@ include file="/activity-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="activityCoursesURL">
	<portlet:param name="tab" value="activityCourses" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/activity-bo-view-courses.jsp" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="activityCoursesSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.activity.model.ActivityCourse"
				modelVar="activityCourse" keyProperty="activityCourseId" >
				<liferay-portlet:renderURL varImpl="editActivityCourseURL">
					<portlet:param name="tab" value="activityCourses" />
					<portlet:param name="cmd" value="editActivityCourse" />
					<portlet:param name="activityCourseId" value="${activityCourse.activityCourseId}" />
					<portlet:param name="backURL" value="${activityCoursesURL}" />
					<portlet:param name="mvcPath" value="/activity-bo-edit-course.jsp" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editActivityCourseURL}" name="name" truncate="true"
					orderable="true" value="${activityCourse.nameCurrentValue}" />

				<liferay-ui:search-container-column-text name="activity"
				    cssClass="content-column" truncate="true" >
					${activityCourse.activity.titleCurrentValue}
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="activity-organizer"
				    cssClass="content-column" truncate="true" >
					${activityCourse.activityOrganizer.nameCurrentValue}
				</liferay-ui:search-container-column-text>
					
				<fmt:formatDate value="${activityCourse.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />

				<liferay-ui:search-container-column-text name="user">
					${activityCourse.statusByUserName}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${activityCourse.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsActivityCourse(activityCourse).getActionDropdownItems()}"
					/>
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
	<portlet:param name="tab" value="activityCourses" />
	<portlet:param name="mvcPath" value="/activity-bo-view-courses.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="activityCourses" />
	<portlet:param name="mvcPath" value="/activity-bo-view-courses.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="activityCourses" />
	<portlet:param name="mvcPath" value="/activity-bo-view-courses.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>
<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="activityCourses" />
	<portlet:param name="mvcPath" value="/activity-bo-view-courses.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>

<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");s
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
	function getCategoriesByVocabulary(vocabularyId, vocabularyName) {
		const portletURL = "${activityCoursesURL}";

		const url = Liferay.Util.PortletURL.createPortletURL(portletURL, {
			p_p_id: "com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet",
			p_p_lifecycle: 0,
			p_p_state: "pop_up",
			eventName: "com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet_selectCategory",
			selectedCategories: "",
			singleSelect : true,
			vocabularyIds: vocabularyId,
		});

		Liferay.Util.openSelectionModal(
			{
				onSelect: function (selectedItem) {
					if (selectedItem) {
						var selection = selectedItem[Object.keys(selectedItem)];
						var url = "${filterSelectionURL}";
						if(!url.includes("filterCategoriesIdByVocabulariesName"))
							url += "&<portlet:namespace />filterCategoriesIdByVocabulariesName=";
						if(url.includes(encodeURI(vocabularyName.replaceAll(" ","+"))+'_')){
							const regex = encodeURI(vocabularyName).replaceAll("%20","\\+") + "(.(?<!__))*__";
							const re = new RegExp(regex, 'gi');
							url = url.replace(re,"");
						}
						submitForm(form, url + vocabularyName + '_' + selection.title + '_' + selection.categoryId + '__');
					}
				},
				selectEventName: 'com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet_selectCategory',
				title: vocabularyName,
				url: url
			}
		)
	}
</aui:script>