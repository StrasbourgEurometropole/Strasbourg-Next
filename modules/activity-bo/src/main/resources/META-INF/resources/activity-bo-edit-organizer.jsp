<%@ include file="./activity-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.activity.model.ActivityOrganizer"%>

<liferay-portlet:actionURL name="deleteActivityOrganizer" var="deleteActivityURL">
	<portlet:param name="cmd" value="deleteActivityOrganizer" />
	<portlet:param name="tab" value="activityOrganizers" />
	<portlet:param name="mvcPath" value="/activity-bo-view-organizers.jsp" />
	<portlet:param name="activityOrganizerId"
		value="${not empty dc.activityOrganizer ? dc.activityOrganizer.activityOrganizerId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveActivityOrganizer" varImpl="saveActivityOrganizerURL">
	<portlet:param name="backURL" value="${param.backURL}" />
	<portlet:param name="tab" value="activityOrganizers" />
</liferay-portlet:actionURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="name-error" message="title-error" />
	
	<aui:form action="${saveActivityOrganizerURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.activityOrganizer}" model="<%=ActivityOrganizer.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
		<aui:input name="activityOrganizerId" type="hidden" />

			<aui:fieldset collapsed="true" collapsible="true"
				label="general">

				<aui:input name="name">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>
				
				<aui:input name="presentation" />
				
				<liferay-asset:asset-tags-selector
						className="<%= ActivityOrganizer.class.getName() %>"
						classPK="${dc.activityOrganizer.activityOrganizerId}"
				/>
				
				<aui:input name="address" />
					
				<aui:input name="phone" helpMessage="telephone-help" />
				
				<aui:input name="mail" >
					<aui:validator name="email"/>
				</aui:input>

				<aui:input name="siteURL" >
				 	<aui:validator name="url"/>
				</aui:input>
				
				<strasbourg-picker:image label="image" name="imageId"
					required="false" value="${dc.activityOrganizer.imageId}" /> 
				
			</aui:fieldset>

		</div></div>
		
		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_ACTIVITY_ORGANIZER') and empty dc.activityOrganizer or dc.hasPermission('EDIT_ACTIVITY_ORGANIZER') and not empty dc.activityOrganizer) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:input type="hidden" name="workflowAction" value="" />					<aui:button cssClass="btn-lg" type="submit" name="publish"
					value="eu.publish" />
				<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft"
					value="save-as-draft" />
			</c:if>
			<c:if test="${not empty dc.activityOrganizer and dc.hasPermission('DELETE_ACTIVITY_ORGANIZER') and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			window.location = '${deleteActivityOrganizerURL}';
		}
	}
</aui:script>