<%@ include file="/council-bo-init.jsp"%>

<%@page import="eu.strasbourg.service.council.model.Official"%>

<c:set var="typeIdsUser" value="${dc.getTypeIdsForUser()}"/>

<%-- URL : definit le lien menant vers la page de listage de l'entite --%>
<liferay-portlet:renderURL varImpl="officialsURL">
	<portlet:param name="tab" value="officials" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien menant vers la suppression de l'entite --%>
<liferay-portlet:actionURL name="deleteOfficial" var="deleteOfficialURL">
	<portlet:param name="cmd" value="deleteOfficial" />
	<portlet:param name="tab" value="officials" />
	<portlet:param name="officialId"
	    value="${not empty dc.official ? dc.official.officialId : ''}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien menant vers la sauvegarde de l'entite --%>
<liferay-portlet:actionURL name="saveOfficial" varImpl="saveOfficialURL">
	<portlet:param name="tab" value="officials" />
</liferay-portlet:actionURL>

<%-- Composant : Body --%>
<div class="container-fluid container-fluid-max-xl main-content-body">

	<%-- Composant : definit la liste des messages d'erreur  (voir methode "validate" dans le saveAction de l'entite) --%>
	<liferay-ui:error key="error-missing-lastname" message="error-missing-lastname" />
	<liferay-ui:error key="error-missing-firstname" message="error-missing-firstname" />
	<liferay-ui:error key="error-missing-email" message="error-missing-email" />

	<%-- Composant : formulaire de saisie de l'entite --%>
	<aui:form action="${saveOfficialURL}" method="post" name="fm" onSubmit="submitForm(event);">

		<%-- Propriete : definit l'entite de reference pour le formulaire--%>
		<aui:model-context bean="${dc.official}" model="<%=Official.class %>" />
        <div class="sheet"><div class="panel-group panel-group-flush">

			<%-- Champ : (cache) PK de l'entite --%>
			<aui:input name="officialId" type="hidden" />

			<%-- Groupe de champs : Generalites --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="eu.council.bo.personal.informations">

			    <%-- Champ : Nom --%>
                <aui:input name="lastname" required="true" size="75" />

                <%-- Champ : Prénom --%>
                <aui:input name="firstname" required="true" size="75" />

                <%-- Champ : E-mail --%>
                <aui:input name="email" required="true" size="75" />

			</aui:fieldset>

			<%-- Groupe de champs : Generalites --%>
            <aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="eu.council.bo.council.informations">

                <%-- Champ : Type de conseil --%>
                <c:forEach items="${dc.types}" var="type">
                        <c:set var="isAuthorized" value="${typeIdsUser.contains(type.typeId)}" />
                        <c:set var="hasType" value="${dc.hasTypeCouncil(type.typeId)}" />

                        <c:choose>
                            <c:when test="${hasType && !isAuthorized}">
                                <aui:input type="hidden" name="${type.title}" value="${type.typeId}" />
                            </c:when>
                            <c:when test="${isAuthorized}">
                                <aui:input name="${type.title}" label="${type.title}" type="checkbox"
                                    title="${type.title}" checked="${hasType}" value="${type.typeId}" data-type="${type.typeId}" onChange="changeIsActive()" />
                            </c:when>
                        </c:choose>
                </c:forEach>

            </aui:fieldset>

            <%-- Groupe de champs : Statut --%>
            <aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="eu.council.bo.statut">

                <%-- Champ : Est Actif --%>
                <aui:input name="isActive" disabled="true"/>

            </aui:fieldset>

            <%-- Groupe de champs : Categorisations (cachée via la classe 'hidden') --%>
            <aui:fieldset collapsed="<%=true%>" cssClass="hidden" collapsible="<%=true%>" label="categorization">

                <%-- Champ : Selection des categories (gere par le portail dans l'onglet "Categories" du BO) --%>
                <liferay-asset:asset-categories-selector
                        className="<%= Official.class.getName() %>"
                        classPK="${dc.official.officialId}"
                />
                <%-- Hack pour ajouter une validation sur les vocabulaires obligatoires --%>
                <div class="has-error">
                    <aui:input type="hidden" name="assetCategoriesValidatorInputHelper" value="placeholder">
                        <aui:validator name="custom" errorMessage="requested-vocabularies-error">
                            function (val, fieldNode, ruleValue) {
                                var validated = true;
                                var fields = document.querySelectorAll('[id$=assetCategoriesSelector]  > .field-content');
                                for (var i = 0; i < fields.length; i++) {
                                    fieldContent = fields[i];
                                    if ($(fieldContent).find('.lexicon-icon-asterisk').length > 0
                                        && $(fieldContent).find('input[type="hidden"]').length == 0) {
                                        validated = false;
                                        break;
                                    }
                                }
                                return validated;
                            }
                        </aui:validator>
                    </aui:input>
                </div>

            </aui:fieldset>

        </div></div>

		<%-- Composant : Menu de gestion de l'entite --%>
		<aui:button-row>

			<aui:input type="hidden" name="workflowAction" value="" />

			<%-- Test : Verification des droits d'edition et de sauvegarde --%>
			<c:if test="${(dc.hasPermission('ADD_OFFICIAL') and empty dc.official or dc.hasPermission('EDIT_OFFICIAL') and not empty dc.official) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
                <c:if test="${not dc.workflowEnabled}">
                    <aui:button cssClass="btn-lg" type="submit" name="publish" value="save" />
                </c:if>
			</c:if>

			<%-- Composant : bouton de retour a la liste des entites --%>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />

		</aui:button-row>

	</aui:form>

</div>

<liferay-util:html-top>
	<script>
		var editOfficial = true;
	</script>
</liferay-util:html-top>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteOfficialURL}';
		}
	}
</aui:script>

<liferay-util:html-bottom>
    <script src="/o/councilbo/js/council-bo-edit-official.js" type="text/javascript"></script>
</liferay-util:html-bottom>