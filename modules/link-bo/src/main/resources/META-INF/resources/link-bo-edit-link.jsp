<%@ include file="/link-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.link.model.Link"%>

<liferay-portlet:renderURL varImpl="linksURL">
	<portlet:param name="tab" value="links" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="deleteLink" var="deleteLinkURL">
	<portlet:param name="cmd" value="deleteLink" />
	<portlet:param name="tab" value="links" />
	<portlet:param name="linkId"
		value="${not empty dc.link ? dc.link.linkId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveLink" varImpl="saveLinkURL">
	<portlet:param name="cmd" value="saveLink" />
</liferay-portlet:actionURL>

<div class="container-fluid-1280 main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="need-url-error" message="need-url-error" />

	<aui:form action="${saveLinkURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.link}" model="<%=Link.class %>" />
		<aui:fieldset-group markupView="lexicon">
			<aui:input name="linkId" type="hidden" />

			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>"
				label="general">

				<aui:input name="title" required="true" />
				
				<aui:input name="URL" helpMessage="urlHelp" required="true">
					<aui:validator name="url" errorMessage="url-error" />
				</aui:input>
				
				<aui:input name="hoverText" />
				
			</aui:fieldset>

			<aui:fieldset collapsed="<%=true%>" collapsible="<%=true%>"
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

		</aui:fieldset-group>

		<aui:button-row>
			<aui:input type="hidden" name="workflowAction" value="" />
			<c:if test="${(dc.hasPermission('ADD_LINK') and empty dc.link or dc.hasPermission('EDIT_LINK') and not empty dc.link) and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			<c:if test="${not empty dc.link && dc.hasPermission('DELETE_LINK') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel"
					value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.returnURL}" type="cancel" />
		</aui:button-row>

	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteLinkURL}';
		}
	}
</aui:script>