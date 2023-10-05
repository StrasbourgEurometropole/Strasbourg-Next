<%@ include file="/agenda-export-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.agenda.model.AgendaExport"%>
<c:set var="agendaExport" value="${dc.agendaExport}" />

<liferay-portlet:actionURL name="saveAgendaExport" varImpl="saveAgendaExportURL">
	<portlet:param name="tab" value="agendaExports" />
	<portlet:param name="isCopy" value="true" />
	<portlet:param name="agendaExportId"
		value="${not empty agendaExport ? agendaExport.agendaExportId : ''}" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>


<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form action="${saveAgendaExportURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${agendaExport}"
			model="<%=AgendaExport.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="agendaExportId" type="hidden" />

			<aui:fieldset collapsed="false" collapsible="true"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

			</aui:fieldset>
		</div></div>
		
		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_AGENDA_EXPORT') and empty agendaExport or dc.hasPermission('EDIT_AGENDA_EXPORT') and not empty agendaExport) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:input type="hidden" name="workflowAction" value="" />
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
				<c:if test="${not dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" name="publish"
							value="eu.publish" />
					<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft"
							value="save-as-draft" />
				</c:if>
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.returnURL}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>