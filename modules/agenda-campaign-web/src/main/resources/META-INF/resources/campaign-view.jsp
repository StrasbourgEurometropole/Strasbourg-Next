<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %>
<%@ include file="/campaign-init.jsp"%>
<liferay-portlet:renderURL var="campaignEventsURL">
</liferay-portlet:renderURL>

<liferay-portlet:actionURL varImpl="searchURL">
	<liferay-portlet:param name="statusId" value="${dc.statusId}" />
	<liferay-portlet:param name="themeId" value="${dc.themeId}" />
</liferay-portlet:actionURL>


<liferay-portlet:renderURL varImpl="updateStatusURL">
	<liferay-portlet:param name="mvcPath"
		value="/campaign-update-status.jsp" />
	<liferay-portlet:param name="statusFilterId"
		value="${dc.statusId}" />
	<liferay-portlet:param name="themeId"
		value="${dc.themeId}" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL varImpl="deleteSelectionURL" name="deleteCampaignEvent">
	<liferay-portlet:param name="statusId"
		value="${dc.statusId}" />
	<liferay-portlet:param name="themeId"
		value="${dc.themeId}" />
</liferay-portlet:actionURL>

<liferay-portlet:renderURL varImpl="addCampaignEventURL">
	<portlet:param name="cmd" value="editCampaignEvent" />
	<portlet:param name="mvcPath" value="/campaign-edit.jsp" />
	<portlet:param name="backURL" value="${campaignEventsURL}" />
</liferay-portlet:renderURL>

<div class="big-button">
	<aui:button href="${addCampaignEventURL}" type="button"
		value="add-campaign-event" primary="true" />
</div>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<aui:input type="hidden" name="campaignEventId" />
		<aui:input type="hidden" name="newStatus" />
		<liferay-ui:search-container id="campaignEventsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.agenda.model.CampaignEvent"
				modelVar="campaignEvent" keyProperty="campaignEventId">
				<liferay-portlet:renderURL varImpl="editCampaignEventURL">
					<portlet:param name="cmd" value="editCampaignEvent" />
					<portlet:param name="campaignEventId"
						value="${campaignEvent.campaignEventId}" />
					<portlet:param name="backURL" value="${campaignEventsURL}" />
					<portlet:param name="mvcPath" value="/campaign-edit.jsp" />
				</liferay-portlet:renderURL>
				<liferay-portlet:actionURL varImpl="deleteURL"
					name="deleteCampaignEvent">
					<portlet:param name="campaignEventId"
						value="${campaignEvent.campaignEventId}" />
				</liferay-portlet:actionURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editCampaignEventURL}" name="title" truncate="true"
					orderable="true" value="${campaignEvent.titleCurrentValue}" />

				<liferay-ui:search-container-column-text
					cssClass="content-column table-cell-content" name="campaign">
					${campaignEvent.campaign.getTitle(locale)}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					cssClass="content-column table-cell-content" name="theme">
					<c:forEach var="theme" items="${campaignEvent.themes}" varStatus="themeStatus">
						<c:if test="${themeStatus.index gt 0}">
						 - 
						</c:if>
						${theme.getTitle(locale)}
					</c:forEach>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					cssClass="content-column table-cell-content" name="type">
					<c:forEach var="type" items="${campaignEvent.types}" varStatus="typeStatus">
						<c:if test="${typeStatus.index gt 0}">
						 -
						</c:if>
						${type.getTitle(locale)}
					</c:forEach>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					cssClass="content-column table-cell-content" name="service">
					${campaignEvent.getServiceName(locale)}
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					cssClass="content-column table-cell-content" name="status">
					<span class="${campaignEvent.lastStatus.statusLabel}"><liferay-ui:message
							key="${campaignEvent.lastStatus.statusLabel}" /></span>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsCampaignEvent(campaignEvent).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>

	<aui:button-row>
		<aui:button href="${addCampaignEventURL}" type="button"
			value="add-campaign-event" primary="true" />
	</aui:button-row>
</div>
<liferay-portlet:renderURL var="anyStatusURL">
	<liferay-portlet:param name="statusId" value="" />
	<liferay-portlet:param name="themeId" value="${dc.themeId}" />
	<liferay-portlet:param name="typeId" value="${dc.typeId}" />
	<liferay-portlet:param name="campaignId" value="${dc.campaignId}" />
	<liferay-portlet:param name="keywords" value="${dc.keywords}" />
	<liferay-portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="anyCampaignURL">
	<liferay-portlet:param name="statusId" value="${dc.statusId}" />
	<liferay-portlet:param name="themeId" value="${dc.themeId}" />
	<liferay-portlet:param name="typeId" value="${dc.typeId}" />
	<liferay-portlet:param name="campaignId" value=""  />
	<liferay-portlet:param name="keywords" value="${dc.keywords}" />
	<liferay-portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");

	function deleteSelection() {
		submitForm(form, '${deleteSelectionURL}');
	}
	function updateSelectionStatus() {
		submitForm(form, '${updateStatusURL}');
	}
	function updateCampaignEventStatus(campaignEventId,newStatus) {
		submitForm(form, '${updateStatusURL}');
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

						navigate(
							addParams(
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
				selectEventName: '<portlet:namespace />selectAssetCategory',
				title: Liferay.Language.get('select-category'),
				url: '${dc.getSelectCategoriesByVocabularyIdURL(vocabularyId)}'
			}
		)
	}
</aui:script>
