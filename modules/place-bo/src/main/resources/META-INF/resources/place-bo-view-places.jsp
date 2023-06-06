<%@ include file="/place-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="placesURL">
	<portlet:param name="tab" value="places" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/place-bo-view-places.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="placesSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.place.model.Place" modelVar="place"
				keyProperty="placeId" >
				<liferay-portlet:renderURL varImpl="editPlaceURL">
					<portlet:param name="cmd" value="editPlace" />
					<portlet:param name="placeId" value="${place.placeId}" />
					<portlet:param name="backURL" value="${placesURL}" />
					<portlet:param name="mvcPath" value="/place-bo-edit-place.jsp" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editPlaceURL}" name="alias" truncate="true" orderable="true"
					value="${place.aliasCurrentValue}" />
				
				<c:set var="typePlace" value="" />	
				<c:forEach var="category" items="${place.getTypes()}">
					<c:if test="${not empty typePlace}">
						<c:set var="typePlace" value="${typePlace}, ${category.getName()}" />
					</c:if>
					<c:if test="${empty typePlace}">
						<c:set var="typePlace" value="${category.getName()}" />
					</c:if>	
				</c:forEach>	
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="type-place" truncate="true" orderable="true"
					value="${typePlace}" />
					
				<c:set var="territory" value="" />	
				<c:forEach var="category" items="${place.getTerritories()}">
					<c:if test="${not empty territory}">
						<c:set var="territory" value="${territory}, ${category.getName()}" />
					</c:if>	
					<c:if test="${empty territory}">
						<c:set var="territory" value="${category.getName()}" />
					</c:if>
				</c:forEach>
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="territory" truncate="true" orderable="true"
					value="${territory}" />

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${place.status}" />
				</liferay-ui:search-container-column-text>


				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsPlace(place).getActionDropdownItems()}"	/>
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
	<portlet:param name="tab" value="places" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/place-bo-view-places.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="places" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/place-bo-view-places.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="places" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/place-bo-view-places.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-places" />')) {
			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-places" />')) {

			submitForm(form, '${publishSelectionURL}');
		}
	}
	function unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-places" />')) {

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
			selectPlacelName: '<portlet:namespace />selectAssetCategory',
			title: Liferay.Language.get('select-category'),
			url: '${dc.getSelectCategoriesByVocabularyIdURL(vocabularyId)}'
		} )
	}
</aui:script>