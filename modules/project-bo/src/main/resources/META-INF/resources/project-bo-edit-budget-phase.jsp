<%@ include file="/project-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.project.model.BudgetPhase"%>

<%-- URL : definit le lien menant vers la page de listage de l'entite --%>
<liferay-portlet:renderURL varImpl="budgetPhasesURL">
	<portlet:param name="tab" value="budget-phases" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien menant vers la suppression de l'entite --%>
<liferay-portlet:actionURL name="deleteBudgetPhase" var="deleteBudgetPhaseURL">
	<portlet:param name="cmd" value="deleteBudgetPhase" />
	<portlet:param name="tab" value="budget-phases" />
	<portlet:param name="mvcPath" value="/project-bo-view-budget-phases.jsp" />
	<portlet:param name="budgetPhaseId" value="${not empty dc.budgetPhase ? dc.budgetPhase.budgetPhaseId : ''}" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien menant vers la sauvegarde de l'entite --%>
<liferay-portlet:actionURL name="saveBudgetPhase" varImpl="saveBudgetPhaseURL">
	<portlet:param name="tab" value="budget-phases" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<%-- Composant : Body --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	
	<%-- Composant : definit la liste des messages d'erreur 
	(voir methode "validate" dans le saveAction de l'entite) --%>
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="description-error" message="description-error" />
	<liferay-ui:error key="dates-error" message="dates-error" />
	<liferay-ui:error key="is-active-error" message="is-active-error" />

	<%-- Composant : formulaire de saisie de l'entite --%>
	<aui:form action="${saveBudgetPhaseURL}" method="post" name="fm" onSubmit="submitForm(event);">

		<%-- Propriete : definit l'entite de reference pour le formulaire--%>
		<aui:model-context bean="${dc.budgetPhase}" model="<%=BudgetPhase.class %>" />

		<div class="sheet"><div class="panel-group panel-group-flush">
		
			<%-- Champ : (cache) PK de l'entite --%>
			<aui:input name="budgetPhaseId" type="hidden" />
			
			<%-- Groupe de champs : Generalites --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="general">
			
				<%-- Champ : Titre --%>
				<aui:input name="title" required="true" />
				
				<%-- Champ : Description --%>
				<aui:input name="description" required="true" />
				
			</aui:fieldset>
			
			<%-- Groupe de champs : Gestion de la phase --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="management">
				
				<%-- Champ : Nombre de votes necessaires --%>
				<aui:input name="numberOfVote" required="true" />
				
				<%-- Champ : Phase en cours d'activite --%>
				<aui:input name="isActive" label="is-active" type="toggle-switch"
					value="${not empty dc.budgetPhase ? dc.budgetPhase.isActive : true}" />
				
			</aui:fieldset>
			
			<%-- Groupe de champs : Periode de depot --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="deposit-period">
				
				<%-- Champ : Budget --%>
				<aui:input name="beginDate" required="true" />

				<%-- Champ : Label --%>
				<aui:input name="endDate" required="true" />

				<%-- Champ : URL de la page de dépôt --%>
				<aui:input name="depositUrl" helpMessage="depositUrlHelp"/>
				
			</aui:fieldset>
			
			<%-- Groupe de champs : Periode de vote --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="vote-period">
				
				<%-- Champ : Budget --%>
				<aui:input name="beginVoteDate" required="true" />

				<%-- Champ : Label --%>
				<aui:input name="endVoteDate" required="true" />

				<%-- Champ : URL de la page de Vote --%>
				<aui:input name="voteUrl" helpMessage="voteUrlHelp"/>
				
			</aui:fieldset>
			
			<%-- Groupe de champs : Categorisations --%>
			<aui:fieldset collapsed="<%=true%>" collapsible="<%=true%>" label="categorization">
				
				<%-- Champ : Selection des categories (gere par le portail dans l'onglet "Categories" du BO) --%>
				<liferay-asset:asset-categories-selector
						className="<%= BudgetPhase.class.getName() %>"
						classPK="${dc.budgetPhase.budgetPhaseId}"
				/>
				<!-- Hack pour ajouter une validation sur les vocabulaires obligatoires -->
				<div class="has-error">
					<aui:input type="hidden" name="assetCategoriesValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-vocabularies-error">
							function (val, fieldNode, ruleValue) {
								var validated = true;
								var fields = document.querySelectorAll('[id*=assetCategoriesSelector]');
								for (var i = 0; i < fields.length; i++) {
									var fieldContent = fields[i];
								    if ($(fieldContent).find('.lexicon-icon-asterisk').length > 0
								    	&& $(fieldContent).find('input[type="hidden"]').length == 0) {
								    	validated = false;
		                                event.preventDefault();
								    	break;
								    }
								}
								return validated;
							}
						</aui:validator>
					</aui:input>
				</div>
				
				<%-- Champ : Selection des etiquettes (gere par le portail dans l'onglet "Etiquettes" du BO) --%>
				<liferay-asset:asset-tags-selector
						className="<%= BudgetPhase.class.getName() %>"
						classPK="${dc.budgetPhase.budgetPhaseId}"
				/>

			</aui:fieldset>

		</div></div>

		<%-- Composant : Menu de gestion de l'entite --%>
		<aui:button-row>
			
			<aui:input type="hidden" name="workflowAction" value="" />
			
			<%-- Test : Verification des droits d'edition et de sauvegarde --%>
			<c:if test="${(dc.hasPermission('ADD_BUDGET_PHASE') and empty dc.budgetPhase or dc.hasPermission('EDIT_BUDGET_PHASE') and not empty dc.budgetPhase) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
				<c:if test="${not dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" name="publish" value="eu.publish" />
					<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft" value="save-as-draft" />
				</c:if>
			</c:if>
			
			<%-- Test : Verification des droits de supression --%>
			<c:if test="${not empty dc.budgetPhase && dc.hasPermission('DELETE_BUDGET_PHASE') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel" value="delete" />
			</c:if>

			<%-- Composant : bouton de retour a la liste des entites --%>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
			
		</aui:button-row>

	</aui:form>
	
</div>

<liferay-util:html-top>
	<script>
		var editBudgetPhase = true;
	</script>
	<script src="/o/projectbo/js/project-bo-edit-budget-phase.js" type="text/javascript"></script>
</liferay-util:html-top>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteProjectURL}';
		}
	}
</aui:script>