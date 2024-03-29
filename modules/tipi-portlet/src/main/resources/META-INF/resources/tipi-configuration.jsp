<%@ include file="/META-INF/resources/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="actionURL" />

<div class="container-fluid-1280 main-content-body">
	<aui:form action="${actionURL}" method="post" name="fm">
		
		<aui:input name="cmd" type="hidden"
				value="update" />
		
		<h1>TIPI</h1>
		
		<aui:fieldset>
			<aui:select name="form">
				<aui:option value="0"/>
				<aui:option value="childhood" label="Facturation petite enfance" selected="${form eq 'childhood'}"/>
				<aui:option value="schoolRestaurantAfterSchool" label="Facturation Enfance (Cantine, ALM et APM)" selected="${form eq 'schoolRestaurantAfterSchool'}" />
				<aui:option value="water" label="Facturation d'eau et d'assainissement" selected="${form eq 'water'}" />
				<aui:option value="reom" label="Facturation D&eacute;chet REOM" selected="${form eq 'reom'}" />
				<aui:option value="rs" label="Facturation D&eacute;chet Redevance Sp&eacute;ciale" selected="${form eq 'rs'}" />
			</aui:select>
			
			<aui:fieldset>
				<aui:input name="complement" value="${complement}" localized="true" type="editor" label="complement-text" />
			</aui:fieldset>
			
			<aui:input type="hidden" name="form" />
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