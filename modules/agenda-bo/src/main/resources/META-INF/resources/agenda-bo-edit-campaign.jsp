<%@ include file="/agenda-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.agenda.model.Campaign"%>

<liferay-portlet:actionURL name="deleteCampaign" var="deleteCampaignURL">
	<portlet:param name="cmd" value="deleteCampaign" />
	<portlet:param name="tab" value="campaigns" />
	<portlet:param name="mvcPath" value="/agenda-bo-view-campaigns.jsp" />
	<portlet:param name="campaignId"
		value="${not empty dc.campaign ? dc.campaign.campaignId : ''}" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveCampaign" varImpl="saveCampaignURL">
	<portlet:param name="tab" value="campaigns" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>


<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="provider-error" message="provider-error" />
	<liferay-ui:error key="image-error" message="image-error" />
	<liferay-ui:error key="copyright-error" message="copyright-error" />
	<liferay-ui:error key="managers-error" message="managers-error" />
	<liferay-ui:error key="themes-error" message="themes-error" />
	<liferay-ui:error key="start-date-error" message="start-date-error" />
	<liferay-ui:error key="end-date-error" message="end-date-error" />
	<liferay-ui:error key="dates-error" message="dates-error" />
	
	<aui:form action="${saveCampaignURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.campaign}" model="<%=Campaign.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="campaignId" type="hidden" />

			<aui:fieldset collapsed="false" collapsible="true" label="general">

				<aui:input name="title">
					<aui:validator name="required"
								   errorMessage="this-field-is-required" />
				</aui:input>

				<aui:input name="provider" label="source-name">
					<aui:validator name="required"
								   errorMessage="this-field-is-required" />
				</aui:input>

				<strasbourg-picker:image label="eu.default-image" name="defaultImageId"
						required="true" value="${dc.campaign.defaultImageId}" global="true" />
						
				<aui:input name="defaultImageCopyright" label="default-copyright" required="true" />

				<aui:input name="exportEnabled" type="toggle-switch"
					value="${not empty dc.campaign ? dc.campaign.exportEnabled : false}" />

				<label><liferay-ui:message key="themes" /><span class="icon-asterisk text-warning"></span></label>
				<select id="themesIds" name="<portlet:namespace />themesIds" placeholder="<liferay-ui:message key="select-themes" />" multiple >
					<c:forEach var="theme" items="${dc.themes}">
						<option value="${theme.categoryId}"
							<c:if test="${fn:contains(dc.themesIds, theme.categoryId)}">
								selected
							</c:if>
						>
							${theme.getTitle(locale)}
						</option>
					</c:forEach>
				</select>

				<label><liferay-ui:message key="types" /></label>
				<select id="typesIds" name="<portlet:namespace />typesIds" placeholder="<liferay-ui:message key="select-types" />" multiple >
					<c:forEach var="type" items="${dc.types}">
						<option value="${type.categoryId}"
							<c:if test="${fn:contains(dc.typesIds, type.categoryId)}">
								selected
							</c:if>
						>
							${type.getTitle(locale)}
						</option>
					</c:forEach>
				</select>

				<label><liferay-ui:message key="managers" /><span class="icon-asterisk text-warning"></span></label>
				<select class="form-control" name="<portlet:namespace />managersIds"
						id="managersIds"
						placeholder="<liferay-ui:message key="select-managers" />" multiple>
				</select>
			</aui:fieldset>

			<%-- Groupe de champs : Periode de campagne --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="period">

				<aui:input name="startDate" required="true" />
                <div class="start-date-error" style="display: none">
                    <liferay-ui:message key="this-field-is-required" />
                </div>

                <div class="incorrect-date-error" style="display: none">
                    <liferay-ui:message key="dates-error" />
                </div>

				<aui:input name="endDate" required="true" />
                <div class="end-date-error" style="display: none">
                    <liferay-ui:message key="this-field-is-required" />
                </div>

			</aui:fieldset>

			<aui:fieldset collapsed="true" collapsible="true"
				label="categorization">

				<liferay-asset:asset-tags-selector
						groupIds="${dc.groupsIds}"
						tagNames="${dc.tagsNames}"/>

			</aui:fieldset>

		</div></div>


		<aui:button-row>
			<c:if
				test="${(dc.hasPermission('ADD_CAMPAIGN') and empty dc.campaign or dc.hasPermission('EDIT_CAMPAIGN') and not empty dc.campaign) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:input type="hidden" name="workflowAction" value="" />
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
				<c:if test="${not dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" name="publish"
						value="eu.publish" />
					<aui:button cssClass="btn-lg btn-default" type="submit"
						name="save-as-draft" value="save-as-draft" />
				</c:if>
			</c:if>
			<c:if
				test="${not empty dc.campaign and dc.hasPermission('DELETE_CAMPAIGN') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel"
					value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>
<liferay-util:html-bottom>
	<script>
		var managersIds = "${dc.campaign.managersIds}";
	</script>
	<!-- Include Choices CSS -->
	<link rel="stylesheet" href="/o/agendabo/css/vendors/choices.min.css">
	<!-- Include Choices JavaScript -->
	<script src="/o/agendabo/js/vendors/moment.min.js" type="text/javascript"></script>
	<script src="/o/agendabo/js/vendors/choices.min.js"></script>
	<script src="/o/agendabo/js/agenda-bo-edit-campaign.js"></script>
	<script src="/o/agendabo/js/agenda-bo-main.js"></script>
</liferay-util:html-bottom>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteCampaignURL}';
		}
	}
</aui:script>