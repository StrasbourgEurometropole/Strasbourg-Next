<%@ include file="/council-bo-init.jsp" %>

<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

<liferay-portlet:actionURL name="getDataToImportOfficials" var="getDataToImportOfficialsURL">
    <portlet:param name="cmd" value="importOfficials"/>
    <portlet:param name="mvcPath" value="/council-bo-import-officials.jsp"/>
    <portlet:param name="returnURL" value="${returnURL}"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL varImpl="importOfficialsURL">
    <portlet:param name="cmd" value="importOfficials"/>
    <portlet:param name="mvcPath" value="/council-bo-import-officials.jsp"/>
    <portlet:param name="returnURL" value="${officialsURL}"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="startImportOfficials" var="startImportOfficialsURL">
    <portlet:param name="tab" value="officials"/>
    <portlet:param name="returnURL" value="${returnURL}" />
</liferay-portlet:actionURL>

<%-- Composant : Body --%>
<div class="container-fluid-1280 main-content-body council-bo">


    <div class="import">
        <liferay-ui:error key="error-import-officials" message="${requestScope.error}"/>
        <liferay-ui:error key="error-parse-order" message="${requestScope.errorParse}"/>

        <c:if test="${toImport}">

            <h2 class="clay-h2"><liferay-ui:message key="eu.council.recap-title"/></h2>

            <ul class="list-group">
                <c:if test="${officialsToCreate.size() > 0}">
                    <li class="list-group-header">
                        <p class="list-group-header-title">
                            <liferay-ui:message key="eu.council.recap-import-to-create"/>
                        </p>
                    </li>
                    <c:forEach items="${officialsToCreate}" var="official">
                        <li class="list-group-item list-group-item-flex">
                            <div class="autofit-col autofit-col-expand"><p class="list-group-title">${official.get("NOM")} ${official.get("PRENOM")}</p>
                                <p class="list-group-text">${official.get("EMAIL")}</p></div>
                            <div class="autofit-col"><liferay-ui:message
                                    key="eu.council.type-link"/> ${fn:replace(official.get("TYPE_CONSEIL"), ';', ', ')}</div>
                        </li>
                    </c:forEach>

                </c:if>

                <c:if test="${officialsToUpdate.size() > 0}">
                    <li class="list-group-header">
                        <p class="list-group-header-title">
                            <liferay-ui:message key="eu.council.recap-import-to-update"/>
                        </p>
                    </li>
                    <c:forEach items="${officialsToUpdate}" var="official">
                        <li class="list-group-item list-group-item-flex">
                            <div class="autofit-col autofit-col-expand"><p class="list-group-title">${official.get("NOM")} ${official.get("PRENOM")}</p>
                                <p class="list-group-text">${official.get("EMAIL")}</p></div>
                            <div class="autofit-col"><liferay-ui:message
                                    key="eu.council.type-link"/> ${fn:replace(official.get("TYPE_CONSEIL"), ';', ', ')}</div>
                        </li>
                    </c:forEach>

                </c:if>

                <c:if test="${officialsToDelete.size() > 0}">
                    <li class="list-group-header">
                        <p class="list-group-header-title">
                            <liferay-ui:message key="eu.council.recap-import-to-delete"/>
                        </p>
                    </li>
                    <c:forEach items="${officialsToDelete}" var="official">
                        <li class="list-group-item list-group-item-flex">
                            <div class="autofit-col autofit-col-expand"><p class="list-group-title">${official.get("NOM")} ${official.get("PRENOM")}</p>
                                <p class="list-group-text">${official.get("EMAIL")}</p></div>
                        </li>
                    </c:forEach>

                </c:if>
            </ul>

            <aui:form action="${startImportOfficialsURL}" method="post" name="fmImport" enctype="multipart/form-data">
                <aui:button-row>
                    <aui:button cssClass="btn-lg" href="${importOfficialsURL}" type="cancel" value="Cancel"/>
                    <aui:button cssClass="btn-lg" type="submit" value="Import"/>
                </aui:button-row>
            </aui:form>
        </c:if>
        <c:if test="${not toImport}">
            <clay:alert
                    type="info">
                <ul>
                    <liferay-ui:message key="eu.council.import-officials-info"/>
                </ul>
            </clay:alert>
            <%-- Champ : Import du fichier --%>
            <aui:form action="${getDataToImportOfficialsURL}" method="post" name="fmImport"
                      enctype="multipart/form-data">
                <aui:fieldset label="import-officials">
                    <aui:input type="file" name="officials-file">
                        <aui:validator name="acceptFiles">'csv'</aui:validator>
                    </aui:input>
                </aui:fieldset>
                <aui:button-row>
                    <aui:button cssClass="btn-lg" type="submit" value="Import"/>
                </aui:button-row>
            </aui:form>
        </c:if>
    </div>
</div>
