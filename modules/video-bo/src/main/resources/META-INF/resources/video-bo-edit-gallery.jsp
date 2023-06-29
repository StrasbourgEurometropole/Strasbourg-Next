<%@ include file="/video-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.video.model.VideoGallery"%>

<liferay-portlet:actionURL name="deleteGallery" var="deleteGalleryURL">
	<portlet:param name="cmd" value="deleteGallery" />
	<portlet:param name="tab" value="galleries" />
	<portlet:param name="mvcPath" value="/video-bo-view-galleries.jsp" />
	<portlet:param name="galleryId"
		value="${not empty dc.videoGallery ? dc.videoGallery.galleryId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveGallery" varImpl="saveGalleryURL">
	<portlet:param name="tab" value="galleries" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>


<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="image-error" message="image-error" />
	<liferay-ui:error key="description-error" message="description-error" />

	<aui:form action="${saveGalleryURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.videoGallery}"
			model="<%=VideoGallery.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="galleryId" type="hidden" />

			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

				<strasbourg-picker:image label="image" name="imageId"
					required="true" value="${dc.videoGallery.imageId}" />

				<aui:input name="description" label="required-description" />
				<!-- Hack pour ajouter une validation sur la description -->
				<div class="has-error">
					<aui:input type="hidden" name="descriptionValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-description-error">
							function (val, fieldNode, ruleValue) {
								var validate = $('#_eu_strasbourg_portlet_video_VideoBOPortlet_description_fr_FR').val().length > 0;
								if (!validate) {
									$("#_eu_strasbourg_portlet_video_VideoBOPortlet_descriptionEditorContainer").get(0).scrollIntoView();
									event.preventDefault();
								}
								return validate;
							}
						</aui:validator>
					</aui:input>
				</div>
				
				<strasbourg-picker:entity label="eu.videos" name="videosIds"
					value="${dc.videoGallery.videosIds}"
					type="eu.strasbourg.service.video.model.Video"
					multiple="true" />				

			</aui:fieldset>

			<aui:fieldset collapsed="<%=true%>" collapsible="<%=true%>"
				label="categorization">

				<liferay-asset:asset-categories-selector
						className="<%= VideoGallery.class.getName() %>"
						classPK="${dc.videoGallery.galleryId}"/>
				<!-- Hack pour ajouter une validation sur les vocabulaires obligatoires -->
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

				<liferay-asset:asset-tags-selector
						className="<%= VideoGallery.class.getName() %>"
						classPK="${dc.videoGallery.galleryId}"/>

			</aui:fieldset>
			
			<aui:fieldset collapsed="true" collapsible="true"
				label="publication">
				<aui:input name="publicationDate" />
			</aui:fieldset>

		</div></div>
		
		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_VIDEO_GALLERY') and empty dc.videoGallery or dc.hasPermission('EDIT_VIDEO_GALLERY') and not empty dc.videoGallery) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:input type="hidden" name="workflowAction" value="" />
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
				<c:if test="${not dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" name="publish"
							value="publish" />
					<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft"
							value="save-as-draft" />
				</c:if>
			</c:if>
			<c:if test="${not empty dc.videoGallery and dc.hasPermission('DELETE_VIDEO_GALLERY') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel"
					value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteGalleryURL}';
		}
	}
</aui:script>