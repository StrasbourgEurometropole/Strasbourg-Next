<%@ include file="/activity-bo-init.jsp"%>

<c:set var="tab"
	value="${not empty param.tab ? param.tab : 'activities' }" />

<liferay-portlet:renderURL var="activitiesURL">
	<portlet:param name="tab" value="activities" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="activitiesCoursesURL">
	<portlet:param name="tab" value="activityCourses" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="activityOrganizersURL">
	<portlet:param name="tab" value="activityOrganizers" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="associationsURL">
	<portlet:param name="tab" value="associations" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="cmd" value="search" />
	<portlet:param name="tab" value="${param.tab}" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="filterCategoriesIds" value="${dc.filterCategoriesIds}" />
</liferay-portlet:renderURL>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="${activitiesURL}" label="activities"
			selected="${tab eq 'activities'}" />

		<aui:nav-item href="${activitiesCoursesURL}" label="activity-courses"
			selected="${tab eq 'activityCourses'}" />

		<aui:nav-item href="${activityOrganizersURL}" label="activity-organizers"
			selected="${tab eq 'activityOrganizers'}" />

		<aui:nav-item href="${associationsURL}" label="associations"
			selected="${tab eq 'associations'}" />
	</aui:nav>

	<aui:nav-bar-search>
		<aui:form action="${searchURL}" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<c:choose>
    <c:when test="${tab eq 'activities'}">
		<liferay-util:include page="/activity-bo-view-activities.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
    <c:when test="${tab eq 'activityCourses'}">
		<liferay-util:include page="/activity-bo-view-courses.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
    <c:when test="${tab eq 'activityOrganizers'}">
		<liferay-util:include page="/activity-bo-view-organizers.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
    <c:when test="${tab eq 'associations'}">
		<liferay-util:include page="/activity-bo-view-associations.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
</c:choose>


