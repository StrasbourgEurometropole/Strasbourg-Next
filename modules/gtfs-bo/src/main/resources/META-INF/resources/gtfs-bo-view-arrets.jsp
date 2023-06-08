<%@ include file="/gtfs-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="arretsURL">
	<portlet:param name="tab" value="arrets" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/gtfs-bo-view-arrets.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/gtfs-bo-view-arrets.jsp" />
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
</liferay-portlet:actionURL>
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
	function getCategoriesByVocabulary(vocabularyId) {
		Liferay.Util.openSelectionModal(
		{
			onSelect: function (selectedItem) {
				alert("category : " + selectedItem.value.title);
				if (selectedItem)
				{
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