<%@ include file="/activity-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.activity.model.Activity"%>

<liferay-portlet:actionURL name="deleteActivity" var="deleteActivityURL">
	<portlet:param name="cmd" value="deleteActivity" />
	<portlet:param name="tab" value="activities" />
	<portlet:param name="mvcPath" value="/activity-bo-view-activities.jsp" />
	<portlet:param name="activityId"
		value="${not empty dc.activity ? dc.activity.activityId : ''}" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveActivity" varImpl="saveActivityURL">
	<portlet:param name="backURL" value="${param.backURL}" />
	<portlet:param name="tab" value="activity" />
</liferay-portlet:actionURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	
	<aui:form action="${saveActivityURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.activity}" model="<%=Activity.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="activityId" type="hidden" />

			<aui:fieldset collapsed="true" collapsible="true"
				label="activity-description">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>
				
				<aui:input name="description" />

				<liferay-asset:asset-categories-selector
						className="<%= Activity.class.getName() %>"
						classPK="${dc.activity.activityId}"
				/>
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
						className="<%= Activity.class.getName() %>"
						classPK="${dc.activity.activityId}"
				/>
				
				<strasbourg-picker:image label="eu.illustration-image" name="imageId"
					required="false" value="${dc.activity.imageId}" /> 
				
			</aui:fieldset>

			<aui:fieldset collapsed="true" collapsible="true"
				label="medias">
				
				<strasbourg-picker:image label="eu.visuals" name="imagesIds"
					required="false" multiple="true" value="${dc.activity.imagesIds}" />
					
				<strasbourg-picker:entity type="eu.strasbourg.service.video.model.Video" label="eu.videos" name="videosIds"
					required="false" multiple="true" value="${dc.activity.videosIds}" />
					
				<strasbourg-picker:file label="eu.documents" name="filesIds"
					required="false" multiple="true" value="${dc.activity.filesIds}" /> 
				
			</aui:fieldset>

		</div></div>
		
		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_ACTIVITY') and empty dc.activity or dc.hasPermission('EDIT_ACTIVITY') and not empty dc.activity) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:input type="hidden" name="workflowAction" value="" />
				<aui:button cssClass="btn-lg" type="submit" name="publish"
					value="eu.publish" />
				<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft"
					value="save-as-draft" />
			</c:if>
			<c:if test="${not empty dc.activity and dc.hasPermission('DELETE_ACTIVITY') and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			window.location = '${deleteActivityURL}';
		}
	}
</aui:script>