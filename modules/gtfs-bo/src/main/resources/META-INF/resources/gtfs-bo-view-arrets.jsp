<%@ include file="/gtfs-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="arretsURL">
	<portlet:param name="tab" value="arrets" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/gtfs-bo-view-arrets.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="arretsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.gtfs.model.Arret" modelVar="arret"
				keyProperty="arretId" >
				<liferay-portlet:renderURL varImpl="editArretURL">
					<portlet:param name="cmd" value="editArret" />
					<portlet:param name="arretId" value="${arret.arretId}" />
					<portlet:param name="backURL" value="${arretsURL}" />
					<portlet:param name="mvcPath" value="/gtfs-bo-edit-arret.jsp" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editArretURL}" name="codes" truncate="true" orderable="true"
					value="${arret.code}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editArretURL}" name="titles" truncate="true" orderable="true"
					value="${arret.title}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editArretURL}" name="modified-date" truncate="true" orderable="true"
					value="${arret.modifiedDate}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editArretURL}" name="user-name" truncate="true" orderable="true"
					value="${dc.getUserName(arret.statusByUserId)}" />

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${arret.status}" />
				</liferay-ui:search-container-column-text>


				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsArret(arret).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
		
</div>


<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="arrets" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/gtfs-bo-view-arrets.jsp" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="arrets" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/gtfs-bo-view-arrets.jsp" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>
<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="arrets" />
	<portlet:param name="mvcPath" value="/gtfs-bo-view-arrets.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-arrets" />')) {
			submitForm(form, '${publishSelectionURL}');
		}
	}
	function unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-arrets" />')) {

			submitForm(form, '${unpublishSelectionURL}');
		}
	}
	function getCategoriesByVocabulary(vocabularyId, vocabularyName, categoriesId) {
		const portletURL = "${arretsURL}";

		const url = Liferay.Util.PortletURL.createPortletURL(portletURL, {
			p_p_id: "com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet",
			p_p_lifecycle: 0,
			p_p_state: "pop_up",
			eventName: "com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet_selectCategory",
			selectedCategories: categoriesId,
			singleSelect : false,
			vocabularyIds: vocabularyId,
		});

		Liferay.Util.openSelectionModal(
			{
				onSelect: function (selectedItem) {
					if (selectedItem) {
						var url = "${filterSelectionURL}";
						if(!url.includes("filterCategoriesIdByVocabulariesName"))
							url += "&<portlet:namespace />filterCategoriesIdByVocabulariesName=";
						if(url.includes(encodeURI(vocabularyName.replaceAll(" ","+")).replaceAll("'","%27")+'_')){
							const regex = encodeURI(vocabularyName).replaceAll("%20","\\+").replaceAll("'","%27") + "(.(?<!__))*__";
							const re = new RegExp(regex, 'gi');
							url = url.replace(re,"");
						}
						for(index in Object.keys(selectedItem)){
							var selection = selectedItem[Object.keys(selectedItem)[index]];
							url += vocabularyName + '_' + selection.title + '_' + selection.categoryId + '__';
						}
						submitForm(form, url);
					}
				},
				selectEventName: 'com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet_selectCategory',
				title: vocabularyName,
				multiple: true,
				url: url
			}
		)
	}
</aui:script>