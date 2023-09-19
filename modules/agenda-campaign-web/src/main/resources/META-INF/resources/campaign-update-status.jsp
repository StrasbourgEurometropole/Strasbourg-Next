<%@ include file="/campaign-init.jsp"%>

<liferay-portlet:renderURL varImpl="eventsCampaignURL">
	<portlet:param name="keywords" value="${param.keywords}" />
	<portlet:param name="delta" value="${param.delta}" />
	<portlet:param name="campaignId" value="${param.campaignId}" />
	<portlet:param name="statusId" value="${param.statusFilterId}" />
	<portlet:param name="typeId" value="${param.typeId}" />
	<portlet:param name="themeId" value="${param.themeId}" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="updateStatus"
	varImpl="updateCampaignStatusURL">
	<portlet:param name="keywords" value="${param.keywords}" />
	<portlet:param name="delta" value="${param.delta}" />
	<portlet:param name="campaignId" value="${param.campaignId}" />
	<portlet:param name="statusFilterId" value="${param.statusFilterId}" />
	<portlet:param name="typeId" value="${param.typeId}" />
	<portlet:param name="themeId" value="${param.themeId}" />
	<portlet:param name="statusId" value="${param.statusId}" />
	<portlet:param name="campaignEventId" value="${param.campaignEventId}" />
	<portlet:param name="selectionIds" value="${param.selectionIds}" />
	<portlet:param name="newStatus" value="${param.newStatus}" />
</liferay-portlet:actionURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form action="${updateCampaignStatusURL}" method="post" name="fm">
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:fieldset collapsed="false" collapsible="false" label="status-change-${param.newStatus}">
				<aui:input type="text" name="comment" label="status-change-detail-${param.newStatus}" required="${param.newStatus eq 4 or param.newStatus eq 8}" />
			</aui:fieldset>
		</div></div>

		<aui:button-row>
			<aui:button cssClass="btn-lg" type="submit" name="submit" value="submit" />
			<c:if test="${empty param.statusId}">
				<aui:button cssClass="btn-lg" href="${eventsCampaignURL}" type="cancel" value="cancel" />
			</c:if>
		</aui:button-row>
	</aui:form>
</div>