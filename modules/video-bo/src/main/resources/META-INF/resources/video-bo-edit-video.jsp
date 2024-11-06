<%@ include file="/video-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.video.model.Video"%>
<%@ page import="com.liferay.asset.kernel.exception.AssetCategoryException" %>
<%@ page import="com.liferay.asset.kernel.model.AssetVocabulary" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />

<liferay-portlet:actionURL name="deleteVideo" var="deleteVideoURL">
	<portlet:param name="cmd" value="deleteVideo" />
	<portlet:param name="tab" value="videos" />
	<portlet:param name="videoId"
		value="${not empty dc.video ? dc.video.videoId : ''}" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveVideo" varImpl="saveVideoURL">
	<portlet:param name="tab" value="videos" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="url-error" message="url-error" />
	<liferay-ui:error key="image-error" message="image-error" />
	<liferay-ui:error key="description-error" message="description-error" />
	<liferay-ui:error exception="<%= AssetCategoryException.class %>">

		<%
			AssetCategoryException ace = (AssetCategoryException)errorException;

			AssetVocabulary vocabulary = ace.getVocabulary();

			String vocabularyTitle = StringPool.BLANK;

			if (vocabulary != null) {
				vocabularyTitle = vocabulary.getTitle(locale);
			}
		%>

		<c:choose>
			<c:when test="<%= ace.getType() == AssetCategoryException.AT_LEAST_ONE_CATEGORY %>">
				<liferay-ui:message arguments="<%= vocabularyTitle %>" key="please-select-at-least-one-category-for-x" translateArguments="<%= false %>" />
			</c:when>
			<c:when test="<%= ace.getType() == AssetCategoryException.TOO_MANY_CATEGORIES %>">
				<liferay-ui:message arguments="<%= vocabularyTitle %>" key="you-cannot-select-more-than-one-category-for-x" translateArguments="<%= false %>" />
			</c:when>
		</c:choose>
	</liferay-ui:error>

	<aui:form action="${saveVideoURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.video}" model="<%=Video.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="videoId" type="hidden" />

			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>
				
				<aui:input name="source" label="eu.video.source" required="true" />

				<strasbourg-picker:image label="image" name="imageId"
					required="true" value="${dc.video.imageId}" />
				
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

				<aui:input name="copyright" value="${empty dc.video ? dc.defaultCopyright : dc.video.copyright}" localized="true" type="text" />
				
				<strasbourg-picker:file label="transcription" name="transcriptionFileId"
					required="false" value="${dc.video.transcriptionFileId}" />
			</aui:fieldset>

			<aui:fieldset collapsed="<%=true%>" collapsible="<%=true%>"
				label="categorization">
				
				<strasbourg-picker:entity label="eu.galleries" name="galleriesIds"
					value="${dc.video.videoGalleriesIds}"
					type="eu.strasbourg.service.video.model.VideoGallery"
					multiple="true" />

				<liferay-asset:asset-categories-selector
						className="<%= Video.class.getName() %>"
						classPK="${dc.video.videoId}"/>
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

				<liferay-asset:asset-tags-selector
						className="<%= Video.class.getName() %>"
						classPK="${dc.video.videoId}"/>

			</aui:fieldset>
			
			<aui:fieldset collapsed="true" collapsible="true"
				label="publication">
				<aui:input name="publicationDate" />
			</aui:fieldset>

		</div></div>

		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_VIDEO') and empty dc.video or dc.hasPermission('EDIT_VIDEO') and not empty dc.video) and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			<c:if test="${not empty dc.video and dc.hasPermission('DELETE_VIDEO') and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			window.location = '${deleteVideoURL}';
		}
	}
</aui:script>