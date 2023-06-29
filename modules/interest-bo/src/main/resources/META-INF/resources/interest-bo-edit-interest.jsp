<%@ include file="/interest-bo-init.jsp"%>

<liferay-util:html-bottom>
	<script
		src="/o/interestbo/js/interest-bo-edit-interest.js"
		type="text/javascript"></script>
</liferay-util:html-bottom>

<%@page import="eu.strasbourg.service.interest.model.Interest"%>

<liferay-portlet:actionURL name="deleteInterest" var="deleteInterestURL">
	<portlet:param name="cmd" value="deleteInterest" />
	<portlet:param name="tab" value="interests" />
	<portlet:param name="mvcPath" value="/interest-bo-view-interests.jsp" />
	<portlet:param name="interestId"
		value="${not empty dc.interest ? dc.interest.interestId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveInterest" varImpl="saveInterestURL">
	<portlet:param name="cmd" value="saveInterest" />
	<portlet:param name="tab" value="interests" />

</liferay-portlet:actionURL>


<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="type-error" message="type-error" />

	<aui:form action="${saveInterestURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.interest}"
			model="<%=Interest.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="interestId" type="hidden" />

			<aui:fieldset collapsed="false" collapsible="true"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

				<aui:input name="description" />
				
				<aui:select name="typeId" label="type" required="true">
					<aui:option value="" label="" />
					<c:forEach items="${dc.types}" var="category">
						<aui:option value="${category.categoryId}" selected="${dc.interest.typeId eq  category.categoryId}">
							${category.getTitle(locale)}
						</aui:option>
					</c:forEach>
				</aui:select>
				
			</aui:fieldset>

			<aui:fieldset collapsed="true" collapsible="true"
				label="categorization">

                <div class="has-error" style="margin-bottom:10px;">
				    <span class="condition">Veuillez choisir au moins une cat&eacute;gorie</span>
				</div>

				<liferay-asset:asset-categories-selector
						className="<%= Interest.class.getName() %>"
						classPK="${dc.interest.interestId}"/>
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
						className="<%= Interest.class.getName() %>"
						classPK="${dc.interest.interestId}"/>

			</aui:fieldset>

		</div></div>
		
		<aui:button-row>
			<c:if test="${(dc.hasPermission('ADD_INTEREST') and empty dc.interest or dc.hasPermission('EDIT_INTEREST') and not empty dc.interest) and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			<c:if test="${not empty dc.interest and dc.hasPermission('DELETE_INTEREST') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel"
					value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>
<liferay-util:html-bottom>
	<script
		src="/o/interestbo/js/interest-bo-edit-manif.js"
		type="text/javascript"></script>
</liferay-util:html-bottom>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteInterestURL}';
		}
	}
</aui:script>