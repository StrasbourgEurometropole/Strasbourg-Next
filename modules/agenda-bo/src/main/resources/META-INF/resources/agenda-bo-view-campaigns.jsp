<%@ include file="/agenda-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<liferay-portlet:renderURL varImpl="campaignsURL">
	<portlet:param name="tab" value="campaigns" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="campaignsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.agenda.model.Campaign"
				modelVar="campaign" keyProperty="campaignId">
				<liferay-portlet:renderURL varImpl="editCampaignURL">
					<portlet:param name="cmd" value="editCampaign" />
					<portlet:param name="campaignId" value="${campaign.campaignId}" />
					<portlet:param name="backURL" value="${campaignsURL}" />
					<portlet:param name="mvcPath" value="/agenda-bo-edit-campaign.jsp" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editCampaignURL}" name="title" truncate="true"
					orderable="true" value="${campaign.titleCurrentValue}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					name="themes" truncate="true">
					<c:forEach var="theme" items="${campaign.themes}" varStatus="themeStatus">
						<c:if test="${themeStatus.index > 0}"> - </c:if>
						${theme.getTitle(locale)}
					</c:forEach>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="export">
					<c:choose>
						<c:when test="${campaign.exportEnabled}">
							<liferay-ui:message key="yes" />
						</c:when>
						<c:otherwise>
							<liferay-ui:message key="no" />
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${campaign.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsXXX(campaign).getActionDropdownItems()}"
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
	<portlet:param name="tab" value="campaigns" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="campaigns" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="campaigns" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
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
</aui:script>