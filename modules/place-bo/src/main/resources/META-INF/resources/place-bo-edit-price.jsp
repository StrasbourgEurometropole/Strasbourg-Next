<%@ include file="/place-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.place.model.Price"%>

<liferay-portlet:renderURL varImpl="pricesURL">
	<portlet:param name="tab" value="prices" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="deletePrice" var="deletePriceURL">
	<portlet:param name="cmd" value="deletePrice" />
	<portlet:param name="tab" value="prices" />
	<portlet:param name="priceId"
		value="${not empty dc.price ? dc.price.priceId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="savePrice" varImpl="savePriceURL">
	<portlet:param name="cmd" value="savePrice" />
	<portlet:param name="tab" value="prices" />
</liferay-portlet:actionURL>

<div class="container-fluid-1280 main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="price-error" message="price-error" />

	<aui:form action="${savePriceURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.price}" model="<%=Price.class %>" />
		<aui:fieldset-group markupView="lexicon">
			<aui:input name="priceId" type="hidden" />

			<!-- Informations générale -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="general-information">
				
				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>
				
				<aui:input label="price-price" name="priceDescription" />
				<!-- Hack pour ajouter une validation sur le prix -->
				<div class="has-error">
					<aui:input type="hidden" name="priceValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-price-error">
							function (val, fieldNode, ruleValue) {
								var validate = $('#_eu_strasbourg_portlet_place_PlaceBOPortlet_priceDescription_fr_FR').val().length > 0;
								if (!validate) {
									$("#_eu_strasbourg_portlet_place_PlaceBOPortlet_priceDescriptionEditorContainer").get(0).scrollIntoView();
									event.preventDefault();
								}
								return validate;
							}
						</aui:validator>
					</aui:input>
				</div>
					
				<strasbourg-picker:entity label="place"
					name="placesIds" value="${dc.price.placesIds}"
					type="eu.strasbourg.service.place.model.Place"
					multiple="true" />
						
			</aui:fieldset>
			
		</aui:fieldset-group>

		<aui:button-row>
			<aui:input type="hidden" name="workflowAction" value="" />
			<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" type="submit" name="publish"
						value="eu.publish" />
				<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft"
						value="save-as-draft" />
			</c:if>
			<c:if test="${not empty dc.price and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" href="${deletePriceURL}"
					type="cancel" value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.returnURL}" type="cancel" />
		</aui:button-row>
		
	</aui:form>
</div>