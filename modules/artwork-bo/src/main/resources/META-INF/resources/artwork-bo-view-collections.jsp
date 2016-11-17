<%@ include file="/artwork-bo-init.jsp"%>

<liferay-portlet:renderURL varImpl="collectionsURL">
	<portlet:param name="tab" value="collections" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds"
		value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addCollectionURL">
	<portlet:param name="cmd" value="editCollection" />
	<portlet:param name="mvcPath" value="/artwork-bo-edit-collection.jsp" />
	<portlet:param name="returnURL" value="${collectionsURL}" />
</liferay-portlet:renderURL>

<liferay-frontend:management-bar includeCheckBox="true"
	searchContainerId="collectionsSearchContainer">
	<c:if test="${empty dc.keywords}">

		<liferay-frontend:management-bar-filters>
			<c:forEach var="vocabulary" items="${dc.vocabularies}">

				<liferay-portlet:renderURL varImpl="removeVocabularyFilterURL">
					<portlet:param name="tab" value="collections" />
					<portlet:param name="orderByCol" value="${dc.orderByCol}" />
					<portlet:param name="orderByType" value="${dc.orderByType}" />
					<portlet:param name="filterCategoriesIds"
						value="${dc.filterCategoriesIds}" />
					<portlet:param name="keywords" value="${dc.keywords}" />
					<portlet:param name="delta" value="${dc.searchContainer.delta}" />
					<portlet:param name="vocabularyToRemove"
						value="${vocabulary.vocabularyId}" />
				</liferay-portlet:renderURL>

				<liferay-frontend:management-bar-navigation
					label="${dc.getVocabularyFilterLabel(vocabulary)}">
					<liferay-frontend:management-bar-filter-item
						label="${vocabulary.name} : n'importe lequel"
						url="${removeVocabularyFilterURL}" />
					<c:forEach var="category" items="${vocabulary.categories}">
						<liferay-portlet:renderURL var="filterURL">
							<portlet:param name="tab" value="collections" />
							<portlet:param name="orderByCol" value="${dc.orderByCol}" />
							<portlet:param name="orderByType" value="${dc.orderByType}" />
							<portlet:param name="filterCategoriesIds"
								value="${dc.filterCategoriesIds}" />
							<portlet:param name="keywords" value="${dc.keywords}" />
							<portlet:param name="delta" value="${dc.searchContainer.delta}" />
							<portlet:param name="vocabularyToRemove"
								value="${vocabulary.vocabularyId}" />
							<portlet:param name="categoryToAdd"
								value="${category.categoryId}" />
						</liferay-portlet:renderURL>
						<c:set var="isActive"
							value="${dc.filterCategoriesIds.contains(String.valueOf(category.categoryId))}" />
						<liferay-frontend:management-bar-filter-item
							label="${category.name}" url="${filterURL}" active="${isActive}" />
					</c:forEach>
				</liferay-frontend:management-bar-navigation>
			</c:forEach>

			<liferay-frontend:management-bar-sort orderByCol="${dc.orderByCol}"
				orderByType="${dc.orderByType}"
				orderColumns='<%= new String[] {"title", "modified-date", "status"} %>'
				portletURL="${collectionsURL}" />
		</liferay-frontend:management-bar-filters>

		<liferay-frontend:management-bar-action-buttons>
			<c:if test="${dc.workflowEnabled}">
				<liferay-frontend:management-bar-button
					href='<%="javascript:" + renderResponse.getNamespace() + "publishSelection();"%>'
					icon="check" label="publish" />
				<liferay-frontend:management-bar-button
					href='<%="javascript:" + renderResponse.getNamespace() + "unpublishSelection();"%>'
					icon="times" label="unpublish" />
			</c:if>
			<liferay-frontend:management-bar-button
				href='<%="javascript:" + renderResponse.getNamespace() + "deleteSelection();"%>'
				icon="trash" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<div class="container-fluid-1280 main-content-body">
	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="collectionsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-results results="${dc.collections}" />

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.artwork.model.ArtworkCollection"
				modelVar="collection" keyProperty="collectionId" rowIdProperty="collectionId">
				<liferay-portlet:renderURL varImpl="editCollectionURL">
					<portlet:param name="cmd" value="editCollection" />
					<portlet:param name="collectionId" value="${collection.collectionId}" />
					<portlet:param name="returnURL" value="${collectionsURL}" />
					<portlet:param name="mvcPath" value="/artwork-bo-edit-collection.jsp" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text>
					<img src="${collection.imageURL}" style="max-height:120px;"/>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editCollectionURL}" name="title" truncate="true"
					orderable="true" value="${collection.titleCurrentValue}" />

				<fmt:formatDate value="${collection.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="modified-date" truncate="true" orderable="true"
					value="${formattedModifiedDate}" />
					
				<liferay-ui:search-container-column-text name="user">
					${collection.statusByUserName}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${collection.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu markupView="lexicon">
						<liferay-ui:icon message="edit" url="${editCollectionURL}" />

						<liferay-portlet:actionURL name="deleteCollection"
							var="deleteCollectionURL">
							<portlet:param name="cmd" value="deleteCollection" />
							<portlet:param name="tab" value="collections" />
							<portlet:param name="collectionId" value="${collection.collectionId}" />
						</liferay-portlet:actionURL>
						<liferay-ui:icon message="delete" url="${deleteCollectionURL}" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item title='add-collection'
		url="${addCollectionURL}" />
</liferay-frontend:add-menu>


<liferay-portlet:actionURL name="selectionAction"
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="collections" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="collections" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="collections" />
</liferay-portlet:actionURL>
<aui:script>
	function <portlet:namespace />deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function <portlet:namespace />publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${publishSelectionURL}');
		}
	}
	function <portlet:namespace />unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-entries" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${unpublishSelectionURL}');
		}
	}
</aui:script>