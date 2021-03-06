<%@ include file="/gtfs-bo-init.jsp"%>

<liferay-portlet:renderURL varImpl="arretsURL">
	<portlet:param name="tab" value="arrets" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds"
		value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<liferay-frontend:management-bar includeCheckBox="true"
	searchContainerId="arretsSearchContainer">
		<liferay-frontend:management-bar-filters>
			<c:if test="${fn:length(dc.globalVocabularies) > 0}">
				<li><a>Filtrer par :</a></li>
			</c:if>
			<c:if test="${not dc.hasPermission('CONTRIBUTE') or themeDisplay.permissionChecker.isOmniadmin()}">
				<c:forEach var="vocabulary" items="${dc.globalVocabularies}">
					<liferay-frontend:management-bar-filter 
						managementBarFilterItems="${dc.getManagementBarFilterItems(vocabulary)}" 
						value="${dc.getVocabularyFilterLabel(vocabulary)}" />
				</c:forEach>
			</c:if>

			<liferay-frontend:management-bar-sort orderByCol="${dc.orderByCol}"
				orderByType="${dc.orderByType}"
				orderColumns='<%= new String[] {"title", "modified-date"} %>'
				portletURL="${arretsURL}" />
		</liferay-frontend:management-bar-filters>

		<liferay-frontend:management-bar-action-buttons>
			<c:if test="${not dc.workflowEnabled}">
				<c:if test="${dc.hasPermission('EDIT_ARRET') and empty themeDisplay.scopeGroup.getStagingGroup()}">
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "publishSelection();"%>'
						icon="check" label="publish" />
					<liferay-frontend:management-bar-button
						href='<%="javascript:" + renderResponse.getNamespace() + "unpublishSelection();"%>'
						icon="times" label="unpublish" />
				</c:if>
			</c:if>
		</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<div class="container-fluid-1280 main-content-body">
	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="arretsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-results results="${dc.arrets}" />

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.gtfs.model.Arret" modelVar="arret"
				keyProperty="arretId" rowIdProperty="arretId">
				<liferay-portlet:renderURL varImpl="editArretURL">
					<portlet:param name="cmd" value="editArret" />
					<portlet:param name="arretId" value="${arret.arretId}" />
					<portlet:param name="returnURL" value="${arretsURL}" />
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
					<liferay-ui:icon-menu markupView="lexicon">
						<c:if test="${dc.hasPermission('EDIT_ARRET') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="edit" url="${editArretURL}" />
						</c:if>
					</liferay-ui:icon-menu>
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
	<portlet:param name="filterCategoriesIds"
		value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="arrets" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds"
		value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<aui:script>

	function <portlet:namespace />publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-arrets" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${publishSelectionURL}');
		}
	}
	function <portlet:namespace />unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-arrets" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			var selectionIdsInput = document
					.getElementsByName('<portlet:namespace />selectionIds')[0];
			selectionIdsInput.value = Liferay.Util.listCheckedExcept(form,
					'<portlet:namespace />allRowIds');

			submitForm(form, '${unpublishSelectionURL}');
		}
	}
</aui:script>