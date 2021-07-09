<%@ include file="/family-kiosk-init.jsp"%>

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
			<aui:input name="introMap" value="${intro}" localized="true" type="editor" label="introdution-text" />
		</aui:fieldset>

		<aui:fieldset>
			<aui:input name="familyKioskURL" value="${familyKioskURL}" type="text" label="family-kiosk-url" />
		</aui:fieldset>

		<aui:fieldset>
			<aui:input name="requestsURL" value="${requestsURL}" type="text" label="requests-url" />
		</aui:fieldset>
		
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