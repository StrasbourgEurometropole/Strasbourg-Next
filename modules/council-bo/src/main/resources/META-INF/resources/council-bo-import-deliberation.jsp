<%@ include file="/council-bo-init.jsp" %>

<%@page import="eu.strasbourg.service.council.constants.StageDeliberation"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="eu.strasbourg.service.council.model.Deliberation"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<liferay-portlet:actionURL name="startImportDeliberations" var="startImportDeliberationsURL">
	<portlet:param name="tab" value="deliberations" />
</liferay-portlet:actionURL>


<%-- Composant : Body --%>
<div class="container-fluid-1280 main-content-body council-bo">
    <div class="sheet"><div class="panel-group panel-group-flush">
        <liferay-ui:error key="error-import-deliberations" message="${requestScope.error}"/>
        <liferay-ui:error key="error-parse-order" message="${requestScope.errorParse}"/>
        <liferay-ui:error key="error-no-council" message="error-no-council"/>

        <%-- Champ : Import du fichier --%>
        <aui:form action="${startImportDeliberationsURL}" method="post" name="fmPlaces" enctype="multipart/form-data" >

            <div class="import">
                <%-- Champ : Session --%>
                <aui:select name="councilSessionId" label="councilSession" required="true">
                    <aui:option selected="${empty councilSession}" label="Aucun conseil selectionne"></aui:option>
                    <c:forEach var="council" items="${dc.availableCouncilSessions}">
                        <aui:option value="${council.councilSessionId}" label="${council.getTitle()}" selected="${council.councilSessionId eq dc.deliberation.councilSessionId}"/>
                    </c:forEach>
                </aui:select>

                <aui:fieldset label="import-deliberations">
                    <aui:input type="file" name="deliberations-file">
                        <aui:validator name="acceptFiles">'csv'</aui:validator>
                    </aui:input>
                </aui:fieldset>
                <aui:button-row>
                    <aui:button cssClass="btn-lg" type="submit" value="Import" />
                </aui:button-row>
            </div>
        </aui:form>
    </div></div>
</div>
