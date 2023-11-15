<%@ include file="/notif-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="notificationsURL">
	<portlet:param name="tab" value="notifications" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/notif-bo-view-notifications.jsp" />
	<portlet:param name="cmd" value="notifications" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">

	<liferay-portlet:renderURL varImpl="notificationsByInProgressURL">
		<portlet:param name="cmd" value="notificationsByInProgress" />
		<portlet:param name="tab" value="notifications" />
		<portlet:param name="orderByCol" value="${dc.orderByCol}" />
		<portlet:param name="orderByType" value="${dc.orderByType}" />
		<portlet:param name="mvcPath" value="/notif-bo-view-notifications.jsp" />
		<portlet:param name="keywords" value="${dc.keywords}" />
		<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	</liferay-portlet:renderURL>

	<liferay-portlet:renderURL varImpl="notificationsByToComeURL">
		<portlet:param name="cmd" value="notificationsByToCome" />
		<portlet:param name="tab" value="notifications" />
		<portlet:param name="orderByCol" value="${dc.orderByCol}" />
		<portlet:param name="orderByType" value="${dc.orderByType}" />
		<portlet:param name="mvcPath" value="/notif-bo-view-notifications.jsp" />
		<portlet:param name="keywords" value="${dc.keywords}" />
		<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	</liferay-portlet:renderURL>

	<liferay-portlet:renderURL varImpl="notificationsByPastURL">
		<portlet:param name="cmd" value="notificationsByPast" />
		<portlet:param name="tab" value="notifications" />
		<portlet:param name="orderByCol" value="${dc.orderByCol}" />
		<portlet:param name="orderByType" value="${dc.orderByType}" />
		<portlet:param name="mvcPath" value="/notif-bo-view-notifications.jsp" />
		<portlet:param name="keywords" value="${dc.keywords}" />
		<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	</liferay-portlet:renderURL>

    <div class="filterButtons">
        <aui:button cssClass="btn-lg ${(dc.filter == dc.ALL)?'selected':''}" onClick='<%=renderResponse.getNamespace() + "filterByAll();"%>' type="button" value="eu.strasbourg.notif.filter.all" />
        <aui:button cssClass="btn-lg ${(dc.filter == dc.IN_PROGRESS)?'selected':''}" onClick='<%=renderResponse.getNamespace() + "filterByInProgress();"%>' type="button" value="eu.strasbourg.notif.filter.in-progress" />
        <aui:button cssClass="btn-lg ${(dc.filter == dc.TO_COME)?'selected':''}" onClick='<%=renderResponse.getNamespace() + "filterByToCome();"%>' type="button" value="eu.strasbourg.notif.filter.to-come" />
        <aui:button cssClass="btn-lg ${(dc.filter == dc.PAST)?'selected':''}" onClick='<%=renderResponse.getNamespace() + "filterByPast();"%>' type="button" value="eu.strasbourg.notif.filter.past" />
    </div>

	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="notifsSearchContainer" searchContainer="${dc.searchContainer}">
			<!-- Recupere les notifications en fonction du filtre -->
			<c:choose>
				<c:when test="${dc.filter == dc.IN_PROGRESS}">
					<liferay-ui:search-container-results results="${dc.inProgressNotifications}" />
				</c:when>
				<c:when test="${dc.filter == dc.TO_COME}">
					<liferay-ui:search-container-results results="${dc.toComeNotifications}" />
				</c:when>
				<c:when test="${dc.filter == dc.PAST}">
					<liferay-ui:search-container-results results="${dc.pastNotifications}" />
				</c:when>
			</c:choose>

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.notif.model.Notification"
				modelVar="notification" keyProperty="notificationId" rowIdProperty="notificationId">

                <!-- ACTION : Modifier/Voir
                <liferay-portlet:renderURL varImpl="editNotificationURL">
                    <portlet:param name="cmd" value="editNotification" />
                    <portlet:param name="notificationId" value="${notification.notificationId}" />
                    <portlet:param name="backURL" value="${notificationsURL}" />
                    <portlet:param name="mvcPath" value="/notif-bo-edit-notification.jsp" />
					<portlet:param name="tab" value="notifications" />
                </liferay-portlet:renderURL>-->

                <!-- Colonne : nom du service -->
                <c:if test="${isAdminNotification || dc.hasMultipleServices()}">
                    <liferay-ui:search-container-column-text
                        name="eu.strasbourg.notif.service.name">
                        ${dc.getService(notification.serviceId)}
					</liferay-ui:search-container-column-text>
                </c:if>

                <!-- Colonne : type -->
				<liferay-ui:search-container-column-text
					name="eu.strasbourg.notif.notification.type">
					${notification.isAlert == 1 ? 'Alerte' : 'Notification'}
				</liferay-ui:search-container-column-text>

                <!-- Colonne : nature -->
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="eu.strasbourg.notif.nature" truncate="true"
					value="${dc.getNature(notification.natureId)}" />

                <!-- Colonne : titre -->
				<liferay-ui:search-container-column-text cssClass="content-column" href="${editNotificationURL}"
					name="eu.strasbourg.notif.notification.title" truncate="true"
					value="${notification.getTitle(locale)}" />

                <!-- Colonne : date de début -->
				<fmt:formatDate value="${notification.startDate}"
					var="formattedStartDate" type="date" pattern="dd/MM/yyyy" />
				<liferay-ui:search-container-column-text
					name="eu.strasbourg.notif.notification.start-date">
					${formattedStartDate}
				</liferay-ui:search-container-column-text>

                <!-- Colonne : date de fin -->
				<fmt:formatDate value="${notification.endDate}"
					var="formattedEndDate" type="date" pattern="dd/MM/yyyy" />
				<liferay-ui:search-container-column-text
					name="eu.strasbourg.notif.notification.end-date">
					${formattedEndDate}
				</liferay-ui:search-container-column-text>

                <!-- Colonne : status -->
				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${notification.status}" />
				</liferay-ui:search-container-column-text>

                <!-- ACTIONS -->
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

<liferay-portlet:renderURL varImpl="addNotificationURL">
	<portlet:param name="cmd" value="editNotification" />
	<portlet:param name="mvcPath" value="/notif-bo-edit-notification.jsp" />
	<portlet:param name="backURL" value="${notificationsURL}" />
</liferay-portlet:renderURL>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function areYouSure(url) {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			var form = AUI.$(document.<portlet:namespace />fm);
			submitForm(form, url);
		}
	}

	function <portlet:namespace />filterByInProgress() {
		window.location = '${notificationsByInProgressURL}';
	}

	function <portlet:namespace />filterByToCome() {
		window.location = '${notificationsByToComeURL}';
	}

	function <portlet:namespace />filterByPast() {
		window.location = '${notificationsByPastURL}';
	}

	function <portlet:namespace />filterByAll() {
		window.location = '${notificationsURL}';
	}
</aui:script>