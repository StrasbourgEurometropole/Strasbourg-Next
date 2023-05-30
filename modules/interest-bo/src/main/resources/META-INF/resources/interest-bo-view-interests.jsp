<%@ include file="/interest-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />e
<liferay-portlet:renderURL varImpl="interestsURL">
	<portlet:param name="tab" value="interests" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/interest-bo-view-interests.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addInterestURL">
	<portlet:param name="cmd" value="editInterest" />
	<portlet:param name="mvcPath" value="/interest-bo-edit-interest.jsp" />
	<portlet:param name="backURL" value="${interestsURL}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="interestsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.interest.model.Interest"
				modelVar="interest" keyProperty="interestId" >
				<liferay-portlet:renderURL varImpl="editInterestURL">
					<portlet:param name="cmd" value="editInterest" />
					<portlet:param name="interestId" value="${interest.interestId}" />
					<portlet:param name="bacckURL" value="${interestsURL}" />
					<portlet:param name="mvcPath" value="/interest-bo-edit-interest.jsp" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editInterestURL}" name="title" truncate="true"
					orderable="true" value="${interest.titleCurrentValue}" />

				<fmt:formatDate value="${interest.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />
					
				<liferay-ui:search-container-column-text name="user">
					${interest.statusByUserName}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${interest.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsInterest(interest).getActionDropdownItems()}"
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
	<portlet:param name="tab" value="interests" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/interest-bo-view-interests.jsp" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="interests" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/interest-bo-view-interests.jsp" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="interests" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/interest-bo-view-interests.jsp" />
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