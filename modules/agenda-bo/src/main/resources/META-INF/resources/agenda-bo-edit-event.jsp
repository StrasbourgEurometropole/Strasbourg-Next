<%@ include file="/agenda-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.agenda.model.Event"%>
<%@ page import="com.liferay.asset.kernel.exception.AssetCategoryException" %>
<%@ page import="com.liferay.asset.kernel.model.AssetVocabulary" %>
<%@ page import="com.liferay.petra.string.StringPool" %>

<liferay-portlet:actionURL name="deleteEvent" var="deleteEventURL">
	<portlet:param name="cmd" value="deleteEvent" />
	<portlet:param name="tab" value="events" />
	<portlet:param name="mvcPath" value="/agenda-bo-view-events.jsp" />
	<portlet:param name="eventId"
		value="${not empty dc.event ? dc.event.eventId : ''}" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveEvent" varImpl="saveEventURL">
	<portlet:param name="tab" value="events" />
	<portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="description-error" message="description-error" />
	<liferay-ui:error key="image-error" message="image-error" />
	<liferay-ui:error key="image-format-error" message="image-format-error" />
	<liferay-ui:error key="image-load-error" message="image-load-error" />
	<liferay-ui:error key="image-copyright-error" message="image-copyright-error" />
	<liferay-ui:error key="place-selected-error" message="place-selected-error" />
	<liferay-ui:error key="place-name-error" message="place-name-error" />
	<liferay-ui:error key="place-city-error" message="place-city-error" />
	<liferay-ui:error key="period-date-error" message="period-date-error" />
	<liferay-ui:error key="period-error" message="period-error" />
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

	<aui:form action="${saveEventURL}" method="post" name="fm" onSubmit="validatePeriods(event);">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.event}" model="<%=Event.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
			<aui:input name="eventId" type="hidden" />

			<aui:fieldset collapsed="false" collapsible="true"
				label="general">

				<aui:input name="title">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>

				<aui:input name="subtitle" />

				<aui:input name="description" label="required-description" />
				<!-- Hack pour ajouter une validation sur la description -->
				<div class="has-error">
					<aui:input type="hidden" name="descriptionValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-description-error">
							function (val, fieldNode, ruleValue) {
								var validate = $('#_eu_strasbourg_portlet_agenda_AgendaBOPortlet_description_fr_FR').val().length > 0;
								if (!validate) {
									$("#_eu_strasbourg_portlet_agenda_AgendaBOPortlet_descriptionEditorContainer").get(0).scrollIntoView();
		                            event.preventDefault();
								}
								return validate;
							}
						</aui:validator>
					</aui:input>
				</div>
				
				<strasbourg-picker:entity label="eu.manifestations"
					name="manifestationsIds" value="${dc.event.manifestationsIds}"
					type="eu.strasbourg.service.agenda.model.Manifestation"
					multiple="true" />
			</aui:fieldset>
			
			<aui:fieldset collapsed="true" collapsible="true"
				label="eu.dates-and-times">

				<div class="no-event-period" style="display: none; margin-top: 0">
                    <liferay-ui:message key="no-event-period" />
                </div>

				<div class="event-periods-title">
					<p class="control-label"><liferay-ui:message key="event-periods" /><span class="icon-asterisk text-warning"></span></p>
				</div>
				<div id="date-fields">
					<c:if test="${empty dc.event || fn:length(dc.event.eventPeriods) == 0}">
                        <div class="lfr-form-row lfr-form-row-inline">
                            <div class="row-fields">
                                <liferay-util:include page="/includes/period-row.jsp" servletContext="<%=application %>">
                                    <liferay-util:param name="index" value="0" />
                                </liferay-util:include>
                            </div>
                        </div>
                    </c:if>
						
					<c:forEach items="${dc.event.eventPeriods}" var="period" varStatus="status">
						<div class="lfr-form-row lfr-form-row-inline">
							<div class="row-fields">
								<fmt:formatDate value="${period.startDate}" pattern="dd/MM/YYYY" type="date" var="formattedStartDate"/>
								<fmt:formatDate value="${period.endDate}" pattern="dd/MM/YYYY" type="date" var="formattedEndDate"/>
								<liferay-util:include page="/includes/period-row.jsp" servletContext="<%=application %>">
									<liferay-util:param name="index" value="${status.index}" />
									<liferay-util:param name="startDate" value="${formattedStartDate}" />
									<liferay-util:param name="endDate" value="${formattedEndDate}" />
									<liferay-util:param name="startTime" value="${period.startTime}" />
									<liferay-util:param name="endTime" value="${period.endTime}" />
									<liferay-util:param name="isRecurrent" value="${period.isRecurrent}" />
									<liferay-util:param name="timeDetail" value="${period.timeDetail}" />
								</liferay-util:include>
							</div>
						</div>
					</c:forEach>
					<aui:input type="hidden" name="periodIndexes" value="${dc.defaultPeriodIndexes}" />
				</div>

                <div class="change-times-section">
                    <div class="event-periods-title">
                        <p class="control-label"><liferay-ui:message key="update-current-language-times" /></p>
                    </div>
                    <div class="time-detail-generator-wrapper">
                        <aui:input type="text" name="timeDetailGenerator" label="event-times" inlineField="true" helpMessage="event-times-help"/>
                    </div>
                    <aui:button id="changeTimes" name="changeTimes" value="update-times" />
                </div>
				
			</aui:fieldset>
			
			<aui:fieldset collapsed="true" collapsible="true" label="image">
				<label><input type="radio" value="internalImage" name="imageType" 
					<c:if test="${(not empty dc.event.imageId and dc.event.imageId gt 0) or empty dc.event.externalImageURL }">checked</c:if>> Image interne</label><br>
				<label><input type="radio" value="externalImage" name="imageType"
					<c:if test="${(empty dc.event.imageId or dc.event.imageId eq 0) and not empty dc.event.externalImageURL }">checked</c:if>> Image externe</label><br><br>
					
				<div class="internalImage" <c:if test="${(empty dc.event.imageId or dc.event.imageId eq 0) and not empty dc.event.externalImageURL }">style="display: none;"</c:if>>
					<strasbourg-picker:image label="image" name="imageId"
						required="true" value="${dc.event.imageId}" global="true" />
				</div>
				
				<div class="externalImage" <c:if test="${(not empty dc.event.imageId and dc.event.imageId gt 0) or empty dc.event.externalImageURL }">style="display: none;"</c:if>>
					<aui:input name="externalImageURL" >
						<aui:validator name="required"
							errorMessage="this-field-is-required" />
					</aui:input>
					
					<aui:input name="externalImageCopyright" >
						<aui:validator name="required"
							errorMessage="this-field-is-required" />
					</aui:input>
				</div>
			</aui:fieldset>
			
			<aui:fieldset collapsed="true" collapsible="true" label="place">
			
				<label><input type="radio" value="sig" name="<portlet:namespace />placeType"
					<c:if test="${not empty dc.event.placeSIGId or empty dc.event.placeName }">checked</c:if>> Lieu SIG</label><br>
				<label><input type="radio" value="manual" name="<portlet:namespace />placeType"
					<c:if test="${empty dc.event.placeSIGId and not empty dc.event.placeName }">checked</c:if>> Saisie manuelle</label><br><br>
					
				<div class="sig" <c:if test="${empty dc.event.placeSIGId and not empty dc.event.placeName}">style="display: none;"</c:if>>
					<div class="place-autocomplete  form-group">
						<div class="place-autocomplete-input-wrapper">
							<aui:input label="Choisir un lieu" type="text" name="place" value="" />
						</div>
						<span id="place-autocomplete-hidden-value">
							<aui:input type="hidden" name="placeSIGId" value="${dc.event.placeSIGId}" />
						</span>
						<aui:input label="choosen-place" type="text" value="${not empty dc.event.placeSIGId ? dc.event.getPlaceAlias(locale) : ''}" name="selectedPlace" disabled="true" cssClass="selected-place" />
						<aui:input type="hidden" value="${not empty dc.event.placeSIGId ? dc.event.getPlaceAlias(locale) : ''}" name="selectedPlace2" cssClass="selected-place2" >
                            <aui:validator name="required" errorMessage="this-field-is-required" />
						</aui:input>
					</div>
				</div>
				
				<div class="manual" <c:if test="${not empty dc.event.placeSIGId or empty dc.event.placeName }">style="display: none;"</c:if>>
					<aui:input name="placeName" helpMessage="place-name-help">
						<aui:validator name="required"
							errorMessage="this-field-is-required" />
					</aui:input>
					<aui:input name="placeStreetNumber" />
					<aui:input name="placeStreetName" />
					<aui:input name="placeZipCode" />
					<aui:input name="placeCity" >
						<aui:validator name="required"
							errorMessage="this-field-is-required" />
					</aui:input>
					<aui:input name="placeCountry" />
					
					
					<aui:input name="access" helpMessage="access-help"/>
					<aui:input name="accessForDisabled" />
					<label><liferay-ui:message key="disabled-access-help" /></label>
					<aui:input name="accessForBlind" type="checkbox" checked="${dc.event.accessForBlind}" /> 
					<aui:input name="accessForWheelchair" type="checkbox" checked="${dc.event.accessForWheelchair}" />
					<aui:input name="accessForDeaf" type="checkbox" checked="${dc.event.accessForDeaf}" />
					<aui:input name="accessForElder" type="checkbox" checked="${dc.event.accessForElder}" />
					<aui:input name="accessForDeficient" type="checkbox" checked="${dc.event.accessForDeficient}" />
				</div>
			</aui:fieldset>
			
			<aui:fieldset collapsed="true" collapsible="true" label="contact">
				<aui:input name="promoter" />
				<aui:input name="phone" helpMessage="phone-help" />
				<aui:input name="email">
					<aui:validator name="email" errorMessage="email-error" />
				</aui:input>
				<aui:input name="websiteName" helpMessage="website-name-help"/>
				<aui:input name="websiteURL"  helpMessage="website-url-help">
					<aui:validator name="url" errorMessage="website-url-error" />
				</aui:input>
			</aui:fieldset>
			
			<aui:fieldset collapsed="true" collapsible="true" label="concert">
				<aui:input name="concertId" />
				<aui:input name="composer" />
				<aui:input name="distribution" />
				<aui:input name="program" />
			</aui:fieldset>

			<aui:fieldset collapsed="true" collapsible="true" label="event-price">
				<div class="form-group">
					<label><liferay-ui:message key="free-event" /></label>
					<aui:input name="free" value="1" type="radio" checked="${dc.event.free eq 1}" label="yes" />
					<aui:input name="free" value="0" type="radio" checked="${dc.event.free eq 0}" label="no" />
					<aui:input name="free" value="2" type="radio" checked="${dc.event.free eq 2 or empty dc.event.free}" label="not-communicated" />
				</div>
				<aui:input label="event-price" name="price" />
			</aui:fieldset>
			
			<%-- Groupe de champs : Reservation de billet --%>
			<aui:fieldset collapsed="true" collapsible="true" label="event-booking">
			
				<%-- Champ : Description de la reservation de billet --%>
				<aui:input label="booking-description" name="bookingDescription" />
				
				<%-- Champ : URL de la reservation de billet --%>
				<aui:input label="booking-url" name="bookingURL" />
				
				<%-- Champ : URL d'achat d'abonnement --%>
				<aui:input label="subscription-url" name="subscriptionURL" />
				
			</aui:fieldset>

			<aui:fieldset collapsed="true" collapsible="true" label="registration" >

                <div class="event-periods-title">
                    <p class="control-label"><liferay-ui:message key="necessary-registration" /><span class="icon-asterisk text-warning"></span></p>
                </div>

                <%-- Champ : Inscription ou non   --%>
                <aui:input type="radio" value="1" name="registrationValue" class="registrationTrue" label="registrationTrue"
                    checked="${not empty dc.event and dc.event.registration}" />
                <aui:input type="radio" value="0" name="registrationValue" class="registrationFalse" label="registrationFalse"
                    checked="${empty dc.event or !dc.event.registration}" />

                <div id="registrationDiv">
                    <aui:input name="registrationStartDate">
                        <aui:validator name="required"
                            errorMessage="this-field-is-required" />
                     </aui:input>

                    <aui:input name="registrationEndDate">
                        <aui:validator name="required"
                            errorMessage="this-field-is-required" />
                     </aui:input>

                    <%-- Champ : Nombre jauge max   --%>
                    <aui:input name="maxGauge" id="maxGauge" label="maxGauge" type="number" min="0" max="99999" >
                        <aui:validator name="number" />
                        <aui:validator name="required"
                            errorMessage="this-field-is-required" />
                        <aui:validator name="range">[0,99999]</aui:validator>
                     </aui:input>
                 </div>
			</aui:fieldset>

			<aui:fieldset collapsed="true" collapsible="true"
				label="categorization">

				<liferay-asset:asset-categories-selector
					className="<%= Event.class.getName() %>"
					classPK="${dc.event.eventId}"/>
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
						className="<%= Event.class.getName() %>"
						classPK="${dc.event.eventId}"
				/>

			</aui:fieldset>
			
			<aui:fieldset collapsed="true" collapsible="true" label="management">
				<aui:input name="source" disabled="true" />
				<aui:input name="idSource" disabled="true" />
				<aui:input name="publicationDate" />
			</aui:fieldset>
		</div></div>

		<aui:button-row>
			<c:if
				test="${(dc.hasPermission('ADD_EVENT') and empty dc.event or dc.hasPermission('EDIT_EVENT') and not empty dc.event) and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
				test="${not empty dc.event and dc.hasPermission('DELETE_EVENT') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel"
					value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
		</aui:button-row>

	</aui:form>
	<liferay-util:html-top>
		<script>
			var editEvent = true;
		</script>
	</liferay-util:html-top>
	
</div>

<liferay-util:html-top>
	<script>
		var getPeriodRowJSPURL = '${periodRowURL}';
	</script>
</liferay-util:html-top>
<liferay-util:html-bottom>
	<script src="/o/agendabo/js/vendors/moment.min.js"
		type="text/javascript"></script>
	<script
		src="/o/agendabo/js/vendors/daterangepicker.js"
		type="text/javascript"></script>
	<script
		src="/o/agendabo/js/vendors/jquery.autocomplete.js"
		type="text/javascript"></script>
	<script
		src="/o/agendabo/js/agenda-bo-edit-event.js"
		type="text/javascript"></script>
</liferay-util:html-bottom>


<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteEventURL}';
		}
	}
</aui:script>