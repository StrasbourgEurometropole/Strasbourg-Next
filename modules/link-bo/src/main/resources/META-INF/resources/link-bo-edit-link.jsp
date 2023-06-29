<%@ include file="/link-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.link.model.Link"%>


<liferay-portlet:actionURL name="deleteLink" var="deleteLinkURL">
	<portlet:param name="cmd" value="deleteLink" />
	<portlet:param name="tab" value="links" />
	<portlet:param name="mvcPath" value="/link-bo-view-links.jsp" />
	<portlet:param name="linkId"
		value="${not empty dc.link ? dc.link.linkId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveLink" varImpl="saveLinkURL">
</liferay-portlet:actionURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="need-url-error" message="need-url-error" />
	<liferay-ui:error key="infobulle-error" message="infobulle-error" />

	<aui:form action="${saveLinkURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.link}" model="<%=Link.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="linkId" type="hidden" />

			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>"
				label="general">

				<aui:input name="title" required="true" />
				
				<aui:input name="URL" helpMessage="urlHelp" required="true">
					<aui:validator name="url" errorMessage="url-error" />
				</aui:input>
				
				<aui:input name="hoverText" required="true" />
				
			</aui:fieldset>

			<aui:fieldset collapsed="<%=true%>" collapsible="<%=true%>"
				label="categorization">
					
				<liferay-asset:asset-categories-selector
						className="<%= Link.class.getName() %>"
						classPK="${dc.link.linkId}"
				/>
				
				<!-- Hack pour ajouter une validation sur les vocabulaires obligatoires -->
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

				<aui:input name="tags" type="assetTags" />

			</aui:fieldset>

		</div></div>

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
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
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