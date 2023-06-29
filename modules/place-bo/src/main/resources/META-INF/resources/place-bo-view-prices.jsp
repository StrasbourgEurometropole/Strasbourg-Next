<%@ include file="/place-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.place.model.Price"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="pricesURL">
	<portlet:param name="tab" value="prices" />
	<portlet:param name="mvcPath" value="/place-bo-view-prices.jsp" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="addPriceURL">
	<portlet:param name="tab" value="prices"/>
	<portlet:param name="cmd" value="editPrice" />
	<portlet:param name="mvcPath" value="/place-bo-edit-price.jsp" />
	<portlet:param name="backURL" value="${pricesURL}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="pricesSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-row
				className="eu.strasbourg.service.place.model.Price" modelVar="price"
				keyProperty="priceId" >
				<liferay-portlet:renderURL varImpl="editPriceURL">
					<portlet:param name="cmd" value="editPrice" />
					<portlet:param name="priceId" value="${price.priceId}" />
					<portlet:param name="backURL" value="${pricesURL}" />
					<portlet:param name="mvcPath" value="/place-bo-edit-price.jsp" />
					<portlet:param name="tab" value="prices"/>
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editPriceURL}" name="title" truncate="true" orderable="true"
					value="${price.titleCurrentValue}" />

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${price.status}" />
				</liferay-ui:search-container-column-text>


				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu markupView="lexicon">
						<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="edit" url="${editPriceURL}" />
						</c:if>

						<liferay-portlet:actionURL name="deletePrice" var="deletePriceURL">
							<portlet:param name="cmd" value="deletePrice" />
							<portlet:param name="tab" value="prices" />
							<portlet:param name="priceId" value="${price.priceId}" />
						</liferay-portlet:actionURL>
						<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
							<liferay-ui:icon message="delete" url="${deletePriceURL}" />
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
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="prices" />
	<portlet:param name="mvcPath" value="/place-bo-view-prices.jsp" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="prices" />
	<portlet:param name="mvcPath" value="/place-bo-view-prices.jsp" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="prices" />
	<portlet:param name="mvcPath" value="/place-bo-view-prices.jsp" />
</liferay-portlet:actionURL>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-prices" />')) {

			submitForm(form, '${deleteSelectionURL}');
		}
	}
	function publishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-publish-selected-prices" />')) {
			submitForm(form, '${publishSelectionURL}');
		}
	}
	function unpublishSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-unpublish-selected-prices" />')) {
			submitForm(form, '${unpublishSelectionURL}');
		}
	}
</aui:script>