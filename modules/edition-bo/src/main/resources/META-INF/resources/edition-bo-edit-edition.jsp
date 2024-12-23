<%@ include file="/edition-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.edition.model.Edition"%>
<%@ page import="com.liferay.asset.kernel.exception.AssetCategoryException" %>
<%@ page import="com.liferay.asset.kernel.model.AssetVocabulary" %>
<%@ page import="com.liferay.petra.string.StringPool" %>

<liferay-portlet:actionURL name="deleteEdition" var="deleteEditionURL">
	<portlet:param name="cmd" value="deleteEdition" />
	<portlet:param name="tab" value="editions" />
	<portlet:param name="mvcPath" value="/edition-bo-view-editions.jsp" />
	<portlet:param name="editionId"
		value="${not empty dc.edition ? dc.edition.editionId : ''}" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveEdition" varImpl="saveEditionURL">
	<portlet:param name="tab" value="editions" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

	<liferay-ui:error key="title-error" message="title-error" />
<div class="container-fluid container-fluid-max-xl main-content-body">
<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="image-error" message="image-error" />
	<liferay-ui:error key="description-error" message="description-error" />
	<liferay-ui:error key="year-error" message="year-error" />
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

	<aui:form action="${saveEditionURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.edition}" model="<%=Edition.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="editionId" type="hidden" />

			<aui:fieldset collapsed="true" collapsible="true"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

				<aui:input name="subtitle" />
				
				<strasbourg-picker:image label="image" name="imageId"
					required="true" value="${dc.edition.imageId}" />
				
				<aui:input name="description" label="required-description" />
				<!-- Hack pour ajouter une validation sur la description -->
				<div class="has-error">
					<aui:input type="hidden" name="descriptionValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-description-error">
							function (val, fieldNode, ruleValue) {
								var validate = $('#_eu_strasbourg_portlet_edition_EditionBOPortlet_description_fr_FR').val().length > 0;
								if (!validate) {
									$("#_eu_strasbourg_portlet_edition_EditionBOPortlet_descriptionEditorContainer").get(0).scrollIntoView();
									event.preventDefault();
								}
								return validate;
							}
						</aui:validator>
					</aui:input>
				</div>

				<aui:input name="author" />

				<aui:input name="editor" label="eu.co-editor" />


			</aui:fieldset>
			<aui:fieldset collapsed="true" collapsible="true"
				label="file">
				<aui:input name="URL">
					<aui:validator name="url" errorMessage="url-error" />
				</aui:input>
				
				
				<strasbourg-picker:file label="file" name="fileId"
					required="false" value="${dc.edition.fileId}" localized="true" multiple="false" />
			</aui:fieldset>
			<aui:fieldset collapsed="true" collapsible="true"
				label="metadata">
				<aui:input name="distribution" />
				<aui:input name="ISBN" />
				<aui:input name="price" />
				<aui:input name="availableForExchange" type="toggle-switch" value="${not empty dc.edition ? dc.edition.availableForExchange : false}" />
				<aui:input name="inStock" type="toggle-switch" value="${not empty dc.edition ? dc.edition.inStock : false}" />
				<label>Date de diffusion</label><br>
				<aui:input type="number" label="month" name="diffusionDateMonth" inlineField="true" min="1" max="12" value="${dc.edition.diffusionDateMonth}" />
				<aui:input type="number" label="year" name="diffusionDateYear" inlineField="true" min="1900" max="2100" value="${dc.edition.diffusionDateYear}">
					<aui:validator name="required" errorMessage="this-field-is-required" />
				</aui:input>
				<aui:input name="pageNumber" />
				<aui:input name="pictureNumber" />
			</aui:fieldset>

			<aui:fieldset collapsed="true" collapsible="true"
				label="categorization">
				
				<strasbourg-picker:entity label="eu.galleries" name="galleriesIds"
					value="${dc.edition.editionGalleriesIds}"
					type="eu.strasbourg.service.edition.model.EditionGallery"
					multiple="true" />
					
				<liferay-asset:asset-categories-selector
						className="<%= Edition.class.getName() %>"
						classPK="${dc.edition.editionId}"
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

				<liferay-asset:asset-tags-selector
						className="<%= Edition.class.getName() %>"
						classPK="${dc.edition.editionId}"
				/>

			</aui:fieldset>


			<aui:fieldset collapsed="true" collapsible="true"
				label="publication">
				<aui:input name="publicationDate" />
			</aui:fieldset>
		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_EDITION') and empty dc.edition or dc.hasPermission('EDIT_EDITION') and not empty dc.edition) and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			<c:if test="${not empty dc.edition and dc.hasPermission('DELETE_EDITION') and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			window.location = '${deleteEditionURL}';
		}
	}
</aui:script>