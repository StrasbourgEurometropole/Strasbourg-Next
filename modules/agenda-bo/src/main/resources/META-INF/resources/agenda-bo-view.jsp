<%@ include file="/agenda-bo-init.jsp"%>

<c:set var="tab"
	value="${not empty param.tab ? param.tab : 'events' }" />

<liferay-portlet:renderURL var="manifestationsURL">
	<portlet:param name="tab" value="manifestations" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="eventsURL">
	<portlet:param name="tab" value="events" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="importURL">
	<portlet:param name="tab" value="import" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="campaignsURL">
	<portlet:param name="tab" value="campaigns" />
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
		<aui:nav-item href="${eventsURL}" label="events"
			selected="${tab eq 'events'}" />

		<aui:nav-item href="${manifestationsURL}" label="manifestations"
			selected="${tab eq 'manifestations'}" />
			
		<aui:nav-item href="${importURL}" label="import"
			selected="${tab eq 'import'}" />
			
		<aui:nav-item href="${campaignsURL}" label="campaigns"
			selected="${tab eq 'campaigns'}" />
	</aui:nav>

	<aui:nav-bar-search>
		<aui:form action="${searchURL}" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<c:choose>
    <c:when test="${tab eq 'events'}">
		<liferay-util:include page="/agenda-bo-view-events.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
    <c:when test="${tab eq 'manifestations'}">
		<liferay-util:include page="/agenda-bo-view-manifestations.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
    <c:when test="${tab eq 'import'}">
		<liferay-util:include page="/agenda-bo-view-import.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
    <c:when test="${tab eq 'campaigns'}">
		<liferay-util:include page="/agenda-bo-view-campaigns.jsp" servletContext="<%=application %>">
		</liferay-util:include>
    </c:when>
</c:choose>


