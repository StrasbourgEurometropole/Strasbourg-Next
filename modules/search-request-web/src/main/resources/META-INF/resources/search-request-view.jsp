<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL varImpl="searchActionURL" />
<aui:form action="${searchActionURL}" method="get" name="fm" id="search-request-form">
<br><br><br>
    <liferay-portlet:renderURLParams varImpl="searchActionURL" />
    <aui:button type="submit" value="search" />
</aui:form>
