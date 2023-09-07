<%@ include file="/agenda-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<liferay-portlet:renderURL varImpl="eventsURL">
	<portlet:param name="tab" value="events" />
	<portlet:param name="mvcPath" value="/agenda-bo-view-events.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="eventsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.agenda.model.Event"
				modelVar="event" keyProperty="eventId">
				<liferay-portlet:renderURL varImpl="editEventURL">
					<portlet:param name="cmd" value="editEvent" />
					<portlet:param name="eventId" value="${event.eventId}" />
					<portlet:param name="backURL" value="${eventsURL}" />
					<portlet:param name="mvcPath" value="/agenda-bo-edit-event.jsp" />
					<portlet:param name="tab" value="events" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text>
					<img src="${event.imageURL}" style="max-height: 120px; max-width: 180px;" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editEventURL}" name="title" truncate="true"
					orderable="true" value="${event.titleCurrentValue}" />

				<fmt:formatDate value="${event.publicationDate}"
					var="formattedPublicationDate" type="date" pattern="dd/MM/yyyy" />
				<liferay-ui:search-container-column-text
					name="publication-date" orderable="true"
					value="${formattedPublicationDate}" />

				<fmt:formatDate value="${event.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />

				<liferay-ui:search-container-column-text name="provider">
					${not empty event.source ? event.source : event.statusByUserName}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${event.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsEvent(event).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
	
	<liferay-portlet:resourceURL var="exportXlsxURL" id="exportXlsx">
	</liferay-portlet:resourceURL>
	<form method="POST" action="${exportXlsxURL}">
		<aui:input type="hidden" name="eventIds" value="${dc.allEventIds}" />
		<aui:button-row>
			<aui:button cssClass="btn-lg" type="submit"
				value="export-xlsx" />
		</aui:button-row>
	</form>
</div>

<liferay-portlet:actionURL name="selectionAction"
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="events" />
	<portlet:param name="mvcPath" value="/agenda-bo-view-events.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="events" />
	<portlet:param name="mvcPath" value="/agenda-bo-view-events.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="events" />
	<portlet:param name="mvcPath" value="/agenda-bo-view-events.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="events" />
	<portlet:param name="mvcPath" value="/agenda-bo-view-events.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>

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

	function getCategoriesByVocabulary(vocabularyId, vocabularyName) {
		const portletURL = "${eventsURL}";

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
						if(url.includes(vocabularyName.replace(" ","+")+'_')){
							const regex = vocabularyName.replace(" ","\\+") + "(.(?<!__))*__";
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