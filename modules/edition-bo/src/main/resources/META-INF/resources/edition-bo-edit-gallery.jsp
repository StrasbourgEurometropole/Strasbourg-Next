<%@ include file="/edition-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.edition.model.EditionGallery"%>

<liferay-portlet:renderURL varImpl="galleriesURL">
	<portlet:param name="tab" value="galleries" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="deleteGallery" var="deleteGalleryURL">
	<portlet:param name="cmd" value="deleteGallery" />
	<portlet:param name="tab" value="galleries" />
	<portlet:param name="galleryId"
		value="${not empty dc.editionGallery ? dc.editionGallery.galleryId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveGallery" varImpl="saveGalleryURL">
	<portlet:param name="cmd" value="saveGallery" />
	<portlet:param name="tab" value="galleries" />
</liferay-portlet:actionURL>


<div class="container-fluid-1280 main-content-body">
	<aui:form action="${saveGalleryURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.editionGallery}"
			model="<%=EditionGallery.class %>" />
		<aui:fieldset-group markupView="lexicon">
			<aui:input name="galleryId" type="hidden" />

			<aui:fieldset collapsed="false" collapsible="true"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

				<strasbourg-picker:image label="image" name="imageId"
					required="true" value="${dc.editionGallery.imageId}" />

				<aui:input name="description" />
				
				<strasbourg-picker:entity label="editions" name="editionsIds"
					value="${dc.editionGallery.editionsIds}"
					type="eu.strasbourg.service.edition.model.Edition"
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
				<aui:input name="publicationDate" />
			</aui:fieldset>

		</aui:fieldset-group>
		
		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_EDITION_GALLERY') and empty dc.editionGallery or dc.hasPermission('EDIT_EDITION_GALLERY') and not empty dc.editionGallery ) and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			<c:if test="${not empty dc.editionGallery and dc.hasPermission('DELETE_EDITION_GALLERY') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" href="${deleteGalleryURL}"
					type="cancel" value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.returnURL}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>