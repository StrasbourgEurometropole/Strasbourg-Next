<%@ include file="/help-popup-init.jsp" %>

<liferay-util:include page="/modal/${popupTemplateId}.jsp" servletContext="<%=application %>" />

<c:if test="${isSignedIn}">
    <div style="border: solid red 5px; padding: 20px">
        <h1>Popups aide</h1>
        <p>Formulaire : <liferay-ui:message key="${popupTemplateId}" /></p>
    </div>
</c:if>