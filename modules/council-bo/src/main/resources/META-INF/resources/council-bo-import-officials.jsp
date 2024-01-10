<%@ include file="/council-bo-init.jsp" %>

<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<liferay-portlet:actionURL name="getDataToImportOfficials" var="getDataToImportOfficialsURL">
    <portlet:param name="cmd" value="importOfficials" />
    <portlet:param name="mvcPath" value="/council-bo-import-officials.jsp" />
    <portlet:param name="returnURL" value="${returnURL}" />
</liferay-portlet:actionURL>

<liferay-portlet:renderURL varImpl="importOfficialsURL">
    <portlet:param name="cmd" value="importOfficials" />
    <portlet:param name="mvcPath" value="/council-bo-import-officials.jsp" />
    <portlet:param name="returnURL" value="${officialsURL}" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="startImportOfficials" var="startImportOfficialsURL">
	<portlet:param name="tab" value="officials" />
    <portlet:param name="returnURL" value="${returnURL}" />
</liferay-portlet:actionURL>


<%-- Composant : Body --%>
<div class="container-fluid-1280 main-content-body council-bo">
    <aui:fieldset-group markupView="lexicon">
        <liferay-ui:error key="error-import-officials" message="${requestScope.error}"/>
        <liferay-ui:error key="error-parse-order" message="${requestScope.errorParse}"/>

        <div class="import">

            <c:if test="${toImport}">
                <c:if test="${officialsToCreate.size() > 0}">
                    <liferay-ui:message key="eu.council.recap-import-to-create" />
                    <ul>
                        <c:forEach items="${officialsToCreate}" var="official">
                            <li>${official.get("NOM")} ${official.get("PRENOM")} - ${official.get("EMAIL")}
                            <liferay-ui:message key="eu.council.type-link" /> ${fn:replace(official.get("TYPE_CONSEIL"), ';', ', ')}</li>
                        </c:forEach>
                    </ul><br/>
                </c:if>
                <c:if test="${officialsToUpdate.size() > 0}">
                    <liferay-ui:message key="eu.council.recap-import-to-update" />
                    <ul>
                        <c:forEach items="${officialsToUpdate}" var="official">
                            <li>${official.get("NOM")} ${official.get("PRENOM")} - ${official.get("EMAIL")}
                            <liferay-ui:message key="eu.council.type-link" /> ${fn:replace(official.get("TYPE_CONSEIL"), ';', ', ')}</li>
                        </c:forEach>
                    </ul><br/>
                </c:if>
                <c:if test="${officialsToDelete.size() > 0}">
                     <liferay-ui:message key="eu.council.recap-import-to-delete" />
                     <ul>
                         <c:forEach items="${officialsToDelete}" var="official">
                             <li>${official.get("NOM")} ${official.get("PRENOM")} - ${official.get("EMAIL")}</li>
                         </c:forEach>
                     </ul>
                </c:if>
                <aui:form action="${startImportOfficialsURL}" method="post" name="fmImport" enctype="multipart/form-data" >
                    <aui:button-row>
                        <aui:button cssClass="btn-lg" href="${importOfficialsURL}" type="cancel" value="Cancel" />
                        <aui:button cssClass="btn-lg" type="submit" value="Import" />
                    </aui:button-row>
                </aui:form>
            </c:if>
            <c:if test="${not toImport}">
                <%-- Champ : Import du fichier --%>
                <aui:form action="${getDataToImportOfficialsURL}" method="post" name="fmImport" enctype="multipart/form-data" >
                    <aui:fieldset label="import-officials">
                        <aui:input type="file" name="officials-file">
                            <aui:validator name="acceptFiles">'csv'</aui:validator>
                        </aui:input>
                    </aui:fieldset>
                    <aui:button-row>
                        <aui:button cssClass="btn-lg" type="submit" value="Import" />
                    </aui:button-row>
                </aui:form>
            </c:if>
        </div>
    </aui:fieldset-group>
</div>
