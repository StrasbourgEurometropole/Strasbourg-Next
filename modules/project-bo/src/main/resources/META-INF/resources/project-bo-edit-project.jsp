<%@ include file="/project-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.project.model.Project"%>

<%-- URL : definit le lien menant vers la page de listage de l'entite --%>
<liferay-portlet:renderURL varImpl="projectsURL">
	<portlet:param name="tab" value="projects" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien menant vers la suppression de l'entite --%>
<liferay-portlet:actionURL name="deleteProject" var="deleteProjectURL">
	<portlet:param name="cmd" value="deleteProject" />
	<portlet:param name="tab" value="projects" />
	<portlet:param name="mvcPath" value="/project-bo-view-projects.jsp" />
	<portlet:param name="projectId" value="${not empty dc.project ? dc.project.projectId : ''}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien menant vers la sauvegarde de l'entite --%>
<liferay-portlet:actionURL name="saveProject" varImpl="saveProjectURL">
	<portlet:param name="tab" value="projects" />
</liferay-portlet:actionURL>

<%-- Composant : Body --%>
<div class="container-fluid container-fluid-max-xl main-content-body">

	<%-- Composant : definit la liste des messages d'erreur 
	(voir methode "validate" dans le saveAction de l'entite) --%>
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="description-error" message="description-error" />
	<liferay-ui:error key="image-error" message="image-error" />
	<liferay-ui:error key="place-error" message="place-error" />

	<%-- Composant : formulaire de saisie de l'entite --%>
	<aui:form action="${saveProjectURL}" method="post" name="fm" onSubmit="submitForm(event);">

		<%-- Propriete : definit l'entite de reference pour le formulaire--%>
		<aui:model-context bean="${dc.project}" model="<%=Project.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
		
			<%-- Champ : (cache) PK de l'entite --%>
			<aui:input name="projectId" type="hidden" />

			<%-- Groupe de champs : Generalites --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="general">

				<%-- Champ : Titre --%>
				<aui:input name="title" required="true" />

				<aui:input name="description" label="required-description" />
				<!-- Hack pour ajouter une validation sur la description -->
				<div class="has-error">
					<aui:input type="hidden" name="descriptionValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-description-error">
							function (val, fieldNode, ruleValue) {
							var validate = $('#_eu_strasbourg_portlet_agenda_AgendaBOPortlet_description_fr_FR').val().length > 0;
							if (!validate) {
							$("#_eu_strasbourg_portlet_agenda_AgendaBOPortlet_descriptionEditorContainer").get(0).scrollIntoView();
							event.preventDefault();
							}
							return validate;
							}
						</aui:validator>
					</aui:input>
				</div>
				
				<%-- Selecteur : Image interne ou externe ? --%>
				<label><input type="radio" value="internalImage" name="imageType" 
					<c:if test="${(not empty dc.project.imageId and dc.project.imageId gt 0) or empty dc.project.externalImageURL }">checked</c:if>> Image interne</label><br>
				<label><input type="radio" value="externalImage" name="imageType"
					<c:if test="${(empty dc.project.imageId or dc.project.imageId eq 0) and not empty dc.project.externalImageURL }">checked</c:if>> Image externe</label><br><br>
				
				<%-- Champ : Image interne --%>
				<div class="internalImage" <c:if test="${(empty dc.project.imageId or dc.project.imageId eq 0) and not empty dc.project.externalImageURL }">style="display: none;"</c:if>>
					<strasbourg-picker:image label="image" name="imageId" required="true" value="${dc.project.imageId}" global="false"/>
				</div>
				
				<%-- Groupe de champs : Image externe --%>
				<div class="externalImage" <c:if test="${(not empty dc.project.imageId and dc.project.imageId gt 0) or empty dc.project.externalImageURL }">style="display: none;"</c:if>>
					
					<%-- Champ : URL de l'image externe --%>
					<aui:input name="externalImageURL" helpMessage="help-image-size" >
						<aui:validator name="required" errorMessage="this-field-is-required" />
					</aui:input>
					
					<%-- Champ : Copyright de l'image externe --%>
					<aui:input name="externalImageCopyright" >
						<aui:validator name="required" errorMessage="this-field-is-required" />
					</aui:input>
					
				</div>
				
				<%-- Champ : opacite de l'image --%>
				<c:if test="${empty dc.project}">
					<aui:input name="opacityImage" required="false" helpMessage="opacityHelp" value="1.00" />
				</c:if>
				<c:if test="${not empty dc.project}">
					<aui:input name="opacityImage" required="false" helpMessage="opacityHelp" />
				</c:if>

				<%-- Champ : URL detail du projet --%>
				<aui:input name="detailURL" required="false" helpMessage="urlHelp2"/>
				
			</aui:fieldset>
			
			<%-- Groupe de champs : En bref --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="in-short">
				
				<%-- Champ : Budget --%>
				<aui:input name="budget" required="false" />
				
				<%-- Champ : Label --%>
				<aui:input name="label" required="false" />
				
				<%-- Champ : Duree --%>
				<aui:input name="duration" required="false" />
				
				<%-- Champ : Liste des partenaires --%>
				<aui:input name="partners" />
				
			</aui:fieldset>
			
			<%-- Groupe de champs : Contact --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="contact">
				
				<%-- Champ : Nom --%>
				<aui:input name="contactName" required="false" />
				
				<%-- Champ : Ligne 1 --%>
				<aui:input name="contactLine1" required="false" />
				
				<%-- Champ : Ligne 2 --%>
				<aui:input name="contactLine2" required="false" />
				
				<%-- Champ : Numero de telephone --%>
				<aui:input name="contactPhoneNumber" required="false" />

			</aui:fieldset>
			
			<%-- Groupe de champs : Lieux de consultation --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="consultation-places">
				
				<%-- Champ : Lieux --%>
				<div id="place-fields">
					<c:if test="${empty dc.project.getPlacitPlaces()}">
						<div class="lfr-form-row lfr-form-row-inline main-content-card row-place">
							<h3><liferay-ui:message key="place" /></h3>
							<div class="row-fields">
								<liferay-util:include page="/includes/placit-place-row.jsp" servletContext="<%=application %>">
									<liferay-util:param name="index" value="0" />
								</liferay-util:include>
							</div>
						</div>
					</c:if>
					<c:forEach items="${dc.project.getPlacitPlaces()}" var="placitPlace" varStatus="status">
						<c:set var="placitPlace" value="${placitPlace}" scope="request"/>
						<div class="lfr-form-row lfr-form-row-inline main-content-card row-place">
							<h3><liferay-ui:message key="place" /></h3>
							<div class="row-fields">
								<liferay-util:include page="/includes/placit-place-row.jsp" servletContext="<%=application %>">
									<liferay-util:param name="index" value="${status.index}" />
								</liferay-util:include>
							</div>
						</div>
					</c:forEach>
					
					<aui:input type="hidden" name="placeIndexes" value="${dc.defaultPlaceIndexes}" />
				</div>
				
			</aui:fieldset>
			
			<%-- Groupe de champs : Categorisations --%>
			<aui:fieldset collapsed="<%=true%>" collapsible="<%=true%>" label="categorization">
				
				<%-- Champ : Selection des categories (gere par le portail dans l'onglet "Categories" du BO) --%>
				<liferay-asset:asset-categories-selector
						className="<%= Project.class.getName() %>"
						classPK="${dc.project.projectId}"/>
				<%-- Hack pour ajouter une validation sur les vocabulaires obligatoires --%>
				<div class="has-error">
					<aui:input type="hidden" name="assetCategoriesValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-vocabularies-error">
							function (val, fieldNode, ruleValue) {
								var validated = true;
								var fields = document.querySelectorAll('[id$=assetCategoriesSelector] > .field-content');
								for (var i = 0; i < fields.length; i++) {
									fieldContent = fields[i];
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
						className="<%= Project.class.getName() %>"
						classPK="${dc.project.projectId}"/>

			</aui:fieldset>
			
			<%-- Groupe de champs : Timeline --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="timeline">
			
				<div class="timeline-label"><label><liferay-ui:message key="enter-a-timeline" /></label></div>
				
				<%-- Composant : Definit l'utilisation d'un selecteur multiple --%>
				<div id="timeline-fields">
				
					<c:if test="${empty dc.project.projectTimelines}">
						<div class="lfr-form-row lfr-form-row-inline row-timeline">
							<div class="row-fields">
								<liferay-util:include page="/includes/timeline-row.jsp" servletContext="<%=application %>">
									<liferay-util:param name="index" value="0" />
								</liferay-util:include>
							</div>
						</div>
					</c:if>
					
					<c:forEach items="${dc.project.projectTimelines}" var="projectTimeline" varStatus="status">
 						<div class="lfr-form-row lfr-form-row-inline row-timeline">
							<div class="row-fields">
								<fmt:formatDate value="${projectTimeline.date}" pattern="yyyy-MM-dd" type="date" var="formattedDate"/>
								<liferay-util:include page="/includes/timeline-row.jsp" servletContext="<%=application %>">
									<liferay-util:param name="index" value="${status.count}" />
									<liferay-util:param name="startDay" value="${projectTimeline.startDay}" />
									<liferay-util:param name="date" value="${formattedDate}" />
									<liferay-util:param name="dateFormat" value="${projectTimeline.dateFormat}" />
									<liferay-util:param name="title" value="${projectTimeline.title}" />
									<liferay-util:param name="link" value="${projectTimeline.link}" />
									<liferay-util:param name="spacing" value="${projectTimeline.spacing}" />
								</liferay-util:include>
							</div>
						</div>
					</c:forEach>

					<%-- Variable : Definit les variables de gestion et de retour du selecteur 
					(voir "autofields" dans le .js de l'edit de l'entite)  --%>
					<aui:input type="hidden" name="timelineIndexes" value="${dc.defaultTimelineIndexes}" />
					
				</div>
			
			</aui:fieldset>
			
			<%-- Groupe de champs : Suivre un projet --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="project-followed">
				
				<%-- Checkbox : envoi aÂ  tout les suiveurs--%>
				<aui:input name="cheboxMail" type="checkbox" checked="false" required="false"/>

			</aui:fieldset>

		</div></div>

		<%-- Composant : Menu de gestion de l'entite --%>
		<aui:button-row>
			
			<aui:input type="hidden" name="workflowAction" value="" />
			
			<%-- Test : Verification des droits d'edition et de sauvegarde --%>
			<c:if test="${(dc.hasPermission('ADD_PROJECT') and empty dc.project or dc.hasPermission('EDIT_PROJECT') and not empty dc.project) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
				<c:if test="${not dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" name="publish" value="eu.publish" />
					<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft" value="save-as-draft" />
				</c:if>
			</c:if>
			
			<%-- Test : Verification des droits de supression --%>
			<c:if test="${not empty dc.project && dc.hasPermission('DELETE_PROJECT') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel" value="delete" />
			</c:if>

			<%-- Composant : bouton de retour a la liste des entites --%>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
			
		</aui:button-row>

	</aui:form>
	
</div>

<liferay-portlet:actionURL name="getProjectPlaceRow" varImpl="placeRowURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="mvcPath" value="/includes/placit-place-row.jsp" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="getProjectTimelineRow" varImpl="timelineRowURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="mvcPath" value="/includes/timeline-row.jsp" />
</liferay-portlet:actionURL>

<liferay-util:html-top>
	<script>
		var editProject = true;
		var getProjectPlaceRowURL = '${placeRowURL}';
		var getProjectTimelineRowJSPURL = '${timelineRowURL}';
	</script>
</liferay-util:html-top>

<liferay-util:html-bottom>
	<script	src="/o/agendabo/js/vendors/jquery.autocomplete.js"></script>
	<script src="/o/projectbo/js/project-bo-edit-project.js" type="text/javascript"></script>
</liferay-util:html-bottom>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteProjectURL}';
		}
	}
</aui:script>