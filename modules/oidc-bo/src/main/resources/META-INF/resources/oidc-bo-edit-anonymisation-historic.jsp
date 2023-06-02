<%@ include file="/oidc-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.oidc.model.AnonymisationHistoric"%>

<%-- Composant : Body --%>
<div class="container-fluid container-fluid-max-xl main-content-body">

	<%-- Propriete : definit l'entite de reference pour le formulaire--%>
	<aui:model-context bean="${dc.anonymisationHistoric}" model="<%=AnonymisationHistoric.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">

		<%-- Champ : (cache) PK de l'entite --%>
		<aui:input name="anonymisationHistoricId" type="hidden" />

		<%-- Groupe de champs : Generalites --%>
		<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="anonymisation - ${dc.anonymisationHistoric.resultLabel}">

			<%-- Champ : Date debut --%>
			<aui:input name="startDate" required="false" disabled="true" />

			<%-- Champ : Date fin --%>
			<aui:input name="finishDate" required="false" disabled="true" />

			<%-- Champ : Operateur --%>
			<aui:input name="userName" required="false" disabled="true" />

		</aui:fieldset>

		<%-- Groupe de champs : operation --%>
		<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="work">

			<%-- Champ : Budget --%>
			<aui:input name="operations" required="false" disabled="true" />

		</aui:fieldset>

		<%-- Groupe de champs : En bref --%>
		<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="error">

			<%-- Champ : Description d'erreur --%>
			<aui:input name="errorDescription" required="false" disabled="true" />

			<%-- Champ : StackTrace --%>
			<aui:input name="errorStackTrace" required="false" disabled="true" />

		</aui:fieldset>

		</div></div>

</div>