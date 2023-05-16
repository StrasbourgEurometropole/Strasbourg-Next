<%@ include file="/edition-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<liferay-portlet:renderURL varImpl="editionsURL">
	<portlet:param name="tab" value="editions" />
	<portlet:param name="mvcPath" value="/edition-bo-view-editions.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>


<liferay-portlet:renderURL varImpl="addEditionURL">
	<portlet:param name="cmd" value="editEdition" />
	<portlet:param name="tab" value="editions" />
	<portlet:param name="mvcPath" value="/edition-bo-edit-edition.jsp" />
	<portlet:param name="backURL" value="${editionsURL}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
<aui:form method="post" name="fm">
		<liferay-ui:search-container id="editionsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.edition.model.Edition"
				modelVar="edition" keyProperty="editionId" >
				<liferay-portlet:renderURL varImpl="editEditionURL">
					<portlet:param name="cmd" value="editEdition" />
					<portlet:param name="editionId" value="${edition.editionId}" />
					<portlet:param name="backURL" value="${editionsURL}" />
					<portlet:param name="mvcPath" value="/edition-bo-edit-edition.jsp" />
					<portlet:param name="tab" value="editions" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text>
					<img src="${edition.imageURL}" style="max-height: 120px;" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editEditionURL}" name="title" truncate="true"
					orderable="true" value="${edition.titleCurrentValue}" />

				<fmt:formatDate value="${edition.publicationDate}"
					var="formattedPublicationDate" type="date" pattern="dd/MM/yyyy" />
				<liferay-ui:search-container-column-text
					name="publication-date" orderable="true"
					value="${formattedPublicationDate}" />

				<fmt:formatDate value="${edition.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />

				<liferay-ui:search-container-column-text name="user">
					${edition.statusByUserName}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${edition.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsEdition(edition).getActionDropdownItems()}"
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
	<portlet:param name="tab" value="editions" />
	<portlet:param name="mvcPath" value="/edition-bo-view-editions.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>


<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="editions" />
	<portlet:param name="mvcPath" value="/edition-bo-view-editions.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="editions" />
	<portlet:param name="mvcPath" value="/edition-bo-view-editions.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="editions" />
	<portlet:param name="mvcPath" value="/edition-bo-view-editions.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>


<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");

	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {
			submitForm(form, '${deleteSelectionURL}');
		}
	}

	function publishSelection()
	{
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-entries" />')) {
			submitForm(form, '${publishSelectionURL}');
		}
	}

	function unpublishSelection()
	{
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-entries" />'))
		{
			submitForm(form, '${unpublishSelectionURL}');
		}
	}

	function getCategoriesByVocabulary(vocabularyId) {
		Liferay.Util.openSelectionModal(
		{
			onSelect: function (selectedItem) {
			console.log("test : " + selectedItem.value);
			alert("category : " + selectedItem.value.title);
			if (selectedItem) {
				const itemValue = selectedItem.value;
				//submitForm(form, '${filterSelectionURL}');
				//Liferay.SPA.app.navigate(urlString);

				navigate(addParams(
				{
				["${portletNamespace}vocabulary_" + vocabularyId]: itemValue.title,
				},
				PortletURLBuilder.create(getPortletURL())
				.setParameter("vocabulary_" + vocabularyId, itemValue.title)
				.buildString()
				)
				);
			}
		},
			selectEditionName: '<portlet:namespace />selectAssetCategory',
			title: Liferay.Language.get('select-category'),
			url: '${dc.getSelectCategoriesByVocabularyIdURL(vocabularyId)}'
		} )
	}
</aui:script>