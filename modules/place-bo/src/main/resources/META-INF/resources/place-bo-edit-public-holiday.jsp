<%@ include file="/place-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.place.model.PublicHoliday"%>

<liferay-portlet:actionURL name="deletePublicHoliday"
	var="deletePublicHolidayURL">
	<portlet:param name="cmd" value="deletePublicHoliday" />
	<portlet:param name="tab" value="publicHolidays" />
	<portlet:param name="publicHolidayId"
		value="${not empty dc.publicHoliday ? dc.publicHoliday.publicHolidayId : ''}" />
	<portlet:param name="mvcPath" value="/place-bo-view-public-holidays.jsp" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="savePublicHoliday"
	varImpl="savePublicHolidayURL">
	<portlet:param name="tab" value="publicHolidays" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="name-error" message="name-error" />
	<liferay-ui:error key="date-error" message="date-error" />

	<aui:form action="${savePublicHolidayURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.publicHoliday}"
			model="<%=PublicHoliday.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="publicHolidayId" type="hidden" />

			<!-- Informations gÃ©nÃ©rale -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="general-information">

				<aui:input name="name" label="name-public-holiday">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

				<aui:input name="date" label="date-public-holiday">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

				<aui:input name="recurrent" type="toggle-switch"
					value="${not empty dc.publicHoliday ? dc.publicHoliday.recurrent : false}" />

			</aui:fieldset>

		</div></div>

		<aui:button-row>
			<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
			</c:if>
			<c:if
				test="${not empty dc.publicHoliday and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" href="${deletePublicHolidayURL}" type="cancel"
					value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
		</aui:button-row>

	</aui:form>
</div>