<%@ include file="/notification-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="notificationsURL">
	<portlet:param name="tab" value="notifications" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/notification-bo-view-notifications.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addNotificationURL">
	<portlet:param name="cmd" value="editNotification" />
	<portlet:param name="mvcPath" value="/notification-bo-edit-notification.jsp" />
	<portlet:param name="backURL" value="${notificationsURL}" />
</liferay-portlet:renderURL>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="notificationsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.notification.model.Notification"
				modelVar="notification" keyProperty="notificationId" rowIdProperty="notificationId">
				<liferay-portlet:renderURL varImpl="editNotificationURL">
					<portlet:param name="cmd" value="editNotification" />
					<portlet:param name="notificationId" value="${notification.notificationId}" />
					<portlet:param name="backURL" value="${notificationsURL}" />
					<portlet:param name="mvcPath" value="/notification-bo-edit-notification.jsp" />
					<portlet:param name="tab" value="notifications" />
				</liferay-portlet:renderURL>

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editNotificationURL}" name="title" truncate="true"
					orderable="true" value="${notification.titleCurrentValue}" />

				<fmt:formatDate value="${notification.publicationDate}"
					var="formattedPublicationDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="publication-date" orderable="true"
					value="${formattedPublicationDate}" />
					
				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${notification.status}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsNotification(notification).getActionDropdownItems()}"
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
	<portlet:param name="tab" value="notifications" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/notification-bo-view-notifications.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="publishSelectionURL">
	<portlet:param name="cmd" value="publish" />
	<portlet:param name="tab" value="notifications" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/notification-bo-view-notifications.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="selectionAction"
	var="unpublishSelectionURL">
	<portlet:param name="cmd" value="unpublish" />
	<portlet:param name="tab" value="notifications" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/notification-bo-view-notifications.jsp" />
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