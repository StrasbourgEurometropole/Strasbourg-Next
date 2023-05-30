<%@ include file="/form-send-bo-init.jsp"%>

<c:set var="tab" value="${not empty param.tab ? param.tab : 'viewFormSends' }" />

<!-- Corps de la page et selection du listing a afficher -->



<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL var="viewFormSendsURL">
	<portlet:param name="tab" value="viewFormSends" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="formInstanceId" value="${formInstanceId}" />
	<portlet:param name="formInstanceId" value="${formInstanceId}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
    <portlet:param name="backURL" value="${formsURL}" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="viewReportingsURL">
	<portlet:param name="tab" value="viewReportings" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="formInstanceId" value="${formInstanceId}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
    <portlet:param name="backURL" value="${formsURL}" />
</liferay-portlet:renderURL>

<!-- Declaration de l'URL de recherche dans le listing de l'entite courrante -->
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="cmd" value="search" />
	<portlet:param name="tab" value="${param.tab}" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="formInstanceId" value="${formInstanceId}" />
    <portlet:param name="backURL" value="${formsURL}" />
</liferay-portlet:renderURL>

<!-- Barre de navigation -->

<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationUnderItems}'/>

<!-- Corps de la page et selection du listing a afficher -->
<c:choose>
    <c:when test="${tab eq 'viewFormSends'}">
        <liferay-util:include page="/form-send-bo-view-form-send-records.jsp" servletContext="<%=application %>">
        </liferay-util:include>
    </c:when>
    <c:when test="${tab eq 'viewReportings'}">
        <liferay-util:include page="/form-send-bo-view-form-send-signalements.jsp" servletContext="<%=application %>">
        </liferay-util:include>
    </c:when>
</c:choose>