<%@ include file="/official-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="officialsURL">
	<portlet:param name="tab" value="officials" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/official-bo-view-officials.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="officialsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.official.model.Official"
				modelVar="official" keyProperty="officialId" rowIdProperty="officialId">
				<liferay-portlet:renderURL varImpl="editOfficialURL">
					<portlet:param name="cmd" value="editOfficial" />
					<portlet:param name="officialId" value="${official.officialId}" />
					<portlet:param name="backURL" value="${officialsURL}" />
					<portlet:param name="mvcPath" value="/official-bo-edit-official.jsp" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editOfficialURL}" name="lastName" truncate="true"
					orderable="true" value="${official.lastName}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editOfficialURL}" name="firstName" truncate="true"
					orderable="true" value="${official.firstName}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					name="fonction-city" truncate="true"
					orderable="true" value="${official.fonctionCity.getTitle(locale)}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					name="fonction-euro" truncate="true"
					orderable="true" >
					${official.fonctionEurometropole.getTitle(locale)}<br>
					${official.town.getTitle(locale)}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${official.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsOfficial(official).getActionDropdownItems()}"	/>
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
	<portlet:param name="tab" value="officials" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/official-bo-view-officials.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="officials" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/official-bo-view-officials.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="officials" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/official-bo-view-officials.jsp" />
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