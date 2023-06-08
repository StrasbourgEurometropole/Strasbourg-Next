<%@ include file="/agenda-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.agenda.model.Manifestation"%>

<liferay-portlet:actionURL name="deleteManifestation" var="deleteManifestationURL">
	<portlet:param name="cmd" value="deleteManifestation" />
	<portlet:param name="tab" value="manifestations" />
	<portlet:param name="mvcPath" value="/agenda-bo-view-manifestations.jsp" />
	<portlet:param name="manifestationId"
		value="${not empty dc.manifestation ? dc.manifestation.manifestationId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveManifestation" varImpl="saveManifestationURL">
	<portlet:param name="tab" value="manifestations" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>


<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form action="${saveManifestationURL}" method="post" name="fm">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="description-error" message="description-error" />
	<liferay-ui:error key="image-error" message="image-error" />
	<liferay-ui:error key="image-copyright-error" message="image-copyright-error" />

		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.manifestation}"
			model="<%=Manifestation.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="manifestationId" type="hidden" />

			<aui:fieldset collapsed="false" collapsible="true"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

				<label><input type="radio" value="internalImage" name="imageType" 
					<c:if test="${(not empty dc.manifestation.imageId and dc.manifestation.imageId gt 0) or empty dc.manifestation.externalImageURL }">checked</c:if>> Image interne</label><br>
				<label><input type="radio" value="externalImage" name="imageType"
					<c:if test="${(empty dc.manifestation.imageId or dc.manifestation.imageId eq 0) and not empty dc.manifestation.externalImageURL }">checked</c:if>> Image externe</label><br><br>
					
				<div class="internalImage" <c:if test="${(empty dc.manifestation.imageId or dc.manifestation.imageId eq 0) and not empty dc.manifestation.externalImageURL }">style="display: none;"</c:if>>
					<strasbourg-picker:image label="image" name="imageId"
						required="true" value="${dc.manifestation.imageId}" global="true" />
				</div>
				
				<div class="externalImage" <c:if test="${(not empty dc.manifestation.imageId and dc.manifestation.imageId gt 0) or empty dc.manifestation.externalImageURL }">style="display: none;"</c:if>>
					<aui:input name="externalImageURL" >
						<aui:validator name="required"
							errorMessage="this-field-is-required" />
					</aui:input>
					
					<aui:input name="externalImageCopyright" >
						<aui:validator name="required"
							errorMessage="this-field-is-required" />
					</aui:input>
				</div>

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
								
				<aui:input name="startDate" />
				
				<aui:input name="endDate" />
				
				<strasbourg-picker:entity label="eu.events" name="eventsIds"
					value="${dc.manifestation.eventsIds}"
					type="eu.strasbourg.service.agenda.model.Event"
					multiple="true" />				

			</aui:fieldset>

			<aui:fieldset collapsed="true" collapsible="true"
				label="categorization">
				
				<aui:input name="categories" type="assetCategories" wrapperCssClass="categories-selectors" />
				
				<!-- Hack pour ajouter une validation sur les vocabulaires obligatoires -->
				<div class="has-error">
					<aui:input type="hidden" name="assetCategoriesValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-vocabularies-error">
							function (val, fieldNode, ruleValue) {
								var validated = true;
								var fields = document.querySelectorAll('.categories-selectors > .field-content');
								for (var i = 0; i < fields.length; i++) {
									fieldContent = fields[i];
								    if ($(fieldContent).find('.icon-asterisk').length > 0
								    	&& $(fieldContent).find('input[type="hidden"]')[0].value.length == 0) {
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

				<aui:input name="tags" type="assetTags" />

			</aui:fieldset>


			<aui:fieldset collapsed="true" collapsible="true"
				label="publication">
				
				<aui:input name="source" disabled="true" />
				<aui:input name="idSource" disabled="true" />
				<aui:input name="publicationDate" />
			</aui:fieldset>

		</div></div>
		
		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_EVENT_GALLERY') and empty dc.manifestation or dc.hasPermission('EDIT_EVENT_GALLERY') and not empty dc.manifestation) and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			<c:if test="${not empty dc.manifestation and dc.hasPermission('DELETE_EVENT_GALLERY') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel"
					value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>
<liferay-util:html-top>
	<script>
		var editManif = true;
	</script>
</liferay-util:html-top>
<liferay-util:html-bottom>
	<script
		src="/o/agendabo/js/agenda-bo-edit-manif.js"
		type="text/javascript"></script>
</liferay-util:html-bottom>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteManifestationURL}';
		}
	}
</aui:script>