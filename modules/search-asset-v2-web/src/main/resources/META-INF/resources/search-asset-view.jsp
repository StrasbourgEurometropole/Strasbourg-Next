<%@ include file="/search-asset-init.jsp" %>

<liferay-util:include page="/views/${dc.searchForm}.jsp" servletContext="<%=application %>" />
<%
    request.setAttribute("javax.portlet.request",renderRequest.getAttribute("javax.portlet.request"));
    request.setAttribute("javax.portlet.response",renderRequest.getAttribute("javax.portlet.response")) ;
    request.setAttribute("javax.portlet.config",renderRequest.getAttribute("javax.portlet.config")) ;
%>
<p>
    javax
    ${renderRequest.getAttribute("javax.portlet.request")}

</p>

<liferay-util:body-top>
    <aui:script>
		var homeURL = '${homeURL}';
		var delta = ${dc.delta};
    </aui:script>
</liferay-util:body-top>
