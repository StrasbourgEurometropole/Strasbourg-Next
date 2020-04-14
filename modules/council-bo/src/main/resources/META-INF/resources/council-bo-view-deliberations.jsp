<%@ include file="/council-init.jsp" %>

<liferay-portlet:renderURL varImpl="deliberationsURL">
	<portlet:param name="tab" value="deliberations" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds"
		value="${dc.filterCategoriesIds}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addDeliberationURL">
	<portlet:param name="cmd" value="editDeliberation" />
	<portlet:param name="mvcPath" value="/council-bo-edit-deliberation.jsp" />
	<portlet:param name="returnURL" value="${deliberationsURL}" />
</liferay-portlet:renderURL>


<liferay-frontend:management-bar includeCheckBox="true"
	searchContainerId="deliberationsSearchContainer">

		<liferay-frontend:management-bar-filters>

			<liferay-frontend:management-bar-sort orderByCol="${dc.orderByCol}"
				orderByType="${dc.orderByType}"
				orderColumns='<%= new String[] {"title", "modified-date", "publication-date", "status"} %>'
				portletURL="${deliberationsURL}" />
		</liferay-frontend:management-bar-filters>

</liferay-frontend:management-bar>


<div class="container-fluid-1280 main-content-body">
	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="deliberationsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-results results="${dc.deliberations}" />

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.council.model.Deliberation"
				modelVar="deliberation" keyProperty="deliberationId" rowIdProperty="deliberationId">
				<liferay-portlet:renderURL varImpl="editDeliberationURL">
					<portlet:param name="cmd" value="editDeliberation" />
					<portlet:param name="sessionId" value="${deliberation.deliberationId}" />
					<portlet:param name="returnURL" value="${deliberationsURL}" />
					<portlet:param name="mvcPath" value="/council-bo-edit-deliberation.jsp" />
				</liferay-portlet:renderURL>

                <liferay-ui:search-container-column-text cssClass="content-column"
                name="title" truncate="true"
                orderable="true" value="${deliberation.order}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editDeliberationURL}" name="title" truncate="true"
					orderable="true" value="${deliberation.title}" />


				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu markupView="lexicon">
						<c:if test="${dc.hasPermission('EDIT_DELIBERATION') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="edit" url="${editDeliberationURL}" />
						</c:if>

						<liferay-portlet:actionURL name="deleteDeliberation"
							var="deleteDeliberationURL">
							<portlet:param name="cmd" value="deleteDeliberation" />
							<portlet:param name="tab" value="deliberations" />
							<portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
						</liferay-portlet:actionURL>
						<c:if test="${dc.hasPermission('DELETE_DELIBERATION') and empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="delete" url="${deleteDeliberationURL}" />
						</c:if>
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<c:if test="${dc.hasPermission('ADD_DELIBERATION') and empty themeDisplay.scopeGroup.getStagingGroup()}">
	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title="Ajouter une deliberation"
			url="${addDeliberationURL}" />
	</liferay-frontend:add-menu>
</c:if