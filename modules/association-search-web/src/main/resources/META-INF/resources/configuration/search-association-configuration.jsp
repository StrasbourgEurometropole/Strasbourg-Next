<%@ include file="/search-association-init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	varImpl="configurationActionURL" />

<liferay-ui:error key="wrong-friendly-url" message="wrong-friendly-url" />
<aui:form action="${configurationActionURL}" method="post" name="fm" >

    <aui:input name="cmd" type="hidden" value="update" />

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">

            <div class="sheet"><div class="panel-group panel-group-flush">
                <!-- Type d'asset -->
                <aui:fieldset collapsed="false" collapsible="true"
                    label="asset-type">
                    <aui:select name="templateKey"
                        inlineField="true">
                        <c:forEach var="template"
                            items="${templateList}">
                            <aui:option value="${template.templateKey}"
                                selected="${templateKey == template.templateKey}">${template.getName(locale)}</aui:option>
                        </c:forEach>
                    </aui:select>
                </aui:fieldset>

                <!-- Layout -->
                <aui:fieldset collapsed="false" collapsible="true"
                    label="display">
                    <aui:input type="text"
                        name="layoutFriendlyURL" inlineField="true"
                        value="${layoutFriendlyURL}" />
                </aui:fieldset>


                <!-- Affichage -->
                <aui:fieldset collapsed="true" collapsible="true"
                    label="display">
                    <!-- Nombre de resultats par page -->
                    <aui:input type="number" name="delta" value="${delta}" />

                    <aui:input type="text"
                               name="description"
                               value="${description}" />
                </aui:fieldset>

            </div></div>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>