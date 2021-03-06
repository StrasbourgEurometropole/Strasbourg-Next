<%@ include file="/form-send-init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true"
	var="configurationRenderURL" />

<div class="container-fluid-1280 main-content-body">
	<aui:form action="${configurationActionURL}" method="post" name="fm">

		<aui:input name="cmd" type="hidden"
			value="update" />

		<aui:input name="redirect" type="hidden"
			value="${configurationRenderURL}" />

		<aui:fieldset>
			<aui:input name="title" value="${title}" type="text" label="Titre" />
		</aui:fieldset>

		<aui:fieldset>
			<aui:input name="nbEntries" value="${nbEntries}" type="text" label="Nombre d'entr&eacute;es par page" />
		</aui:fieldset>

		<aui:fieldset>
			<aui:input name="message" value="${message}" type="text" label="Message de mod&eacute;ration" />
		</aui:fieldset>

        <aui:select name="formInstanceId" inlineField="true">
            <c:forEach var="form" items="${formulaireList}">
                <aui:option value="${form.formInstanceId}"
                    selected="${fn:contains(formInstanceId, form.formInstanceId)}" >${form.getName(locale)}</aui:option>
            </c:forEach>
        </aui:select>
        <br><br>
        <strong>S&eacute;lectionnez les champs visibles en front :</strong><br><br>
        <c:set var="fieldsLib" value="${fn:split(newLibs, ',')}" />
        <c:forEach var="form" items="${formulaireList}" >
            <aui:fieldset cssClass="fields form_${form.formInstanceId}" >
                <c:forEach var="champs" items="${form.fields}" varStatus="status">
                    <c:if test="${!champs.type.equals('paragraph')}">
                        <c:set var="FieldForm" value="${form.formInstanceId}_${champs.name}" />
                        <aui:input type="checkbox" name="fieldsSelected" id="formFields" value="${FieldForm}" label="${champs.getLabel(locale)} ${champs.isRequired()?' *':' '}"
                                checked="${fn:contains(fieldsSelected, FieldForm)}" />
                        <c:set var="newLibArray" value="${fn:split(fieldsLib[status.index], '--')}" />
                        <c:if test="${fn:length(newLibArray) > 1}">
                            <aui:input type="text" name="newLib_${FieldForm}" id="newLib_${FieldForm}" value="${newLibArray[1]}" label="new-lib"/>
                        </c:if>
                        <c:if test="${fn:length(newLibArray) == 1}">
                            <aui:input type="text" name="newLib_${FieldForm}" id="newLib_${FieldForm}" label="new-lib"/>
                        </c:if>
                        <br>
                    </c:if>
                </c:forEach>
            </aui:fieldset>
        </c:forEach>

        <!-- Affichage -->
        <aui:fieldset collapsed="true" collapsible="true"
            label="display">
            <!-- Template d'affichage -->
            <aui:select name="template">
                <aui:option value="general" selected="${template eq 'general'}">
                    <liferay-ui:message key="general" />
                </aui:option>
                <aui:option value="placIt" selected="${template eq 'placIt'}">
                    <liferay-ui:message key="placIt" />
                </aui:option>
            </aui:select>
        </aui:fieldset>

        <!-- Tri par defaut -->
        <aui:select name="defaultSort">
            <aui:option value="asc" selected="${defaultSort eq 'asc'}">
                <liferay-ui:message key="asc-sorting" />
            </aui:option>
            <aui:option value="desc" selected="${defaultSort eq 'desc'}">
                <liferay-ui:message key="desc-sorting" />
            </aui:option>
        </aui:select>


		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>
</div>

<style>
	fieldset {
		margin-bottom: 20px;
	}
</style>

<script>
    var refreshFieldsDisplay = function() {
        var form = $('select option:selected').val();
        $('.fields').hide();
        $('.form_' + form).show();
    }

    $('select').change(function(){
        refreshFieldsDisplay();
    });

    $(function() {
        refreshFieldsDisplay();
    })
</script>