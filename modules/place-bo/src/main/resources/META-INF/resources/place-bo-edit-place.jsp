<%@page import="java.util.Date"%>
<%@ include file="/place-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.place.model.Place"%>

<liferay-portlet:renderURL varImpl="placesURL">
	<portlet:param name="tab" value="places" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="deletePlace" var="deletePlaceURL">
	<portlet:param name="cmd" value="deletePlace" />
	<portlet:param name="tab" value="places" />
	<portlet:param name="placeId"
		value="${not empty dc.place ? dc.place.placeId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="savePlace" varImpl="savePlaceURL">
	<portlet:param name="cmd" value="savePlace" />
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="manageSubPlacesURL">
	<portlet:param name="tab" value="subPlaces" />
</liferay-portlet:renderURL>

<div class="container-fluid-1280 main-content-body">
	<aui:form action="${savePlaceURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.place}" model="<%=Place.class %>" />
		<aui:fieldset-group markupView="lexicon">
			<aui:input name="placeId" type="hidden" />

			<!-- Informations g�ographique -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="geographic-information">
				
					<div class="col-md-6">
						
						<aui:input name="SIGid2" type="hidden" value="${dc.place.SIGid}" />
						
						<aui:input name="SIGid" disabled="true" />
						
						<aui:input name="name2" type="hidden" value="${dc.place.name}" />
					
						<aui:input name="name" disabled="true" />
						
						<aui:input name="addressStreet2" type="hidden" value="${dc.place.addressStreet}" />
						
						<aui:input name="addressStreet" disabled="true" />
						
						<aui:input name="addressComplement2" type="hidden" value="${dc.place.addressComplement}" />
						
						<aui:input name="addressComplement" disabled="true" />
						
						<aui:input name="addressDistribution2" type="hidden" value="${dc.place.addressDistribution}" />
						
						<aui:input name="addressDistribution" disabled="true" />
						
						<aui:input name="addressZipCode2" type="hidden" value="${dc.place.addressZipCode}" />
						
						<aui:input name="addressZipCode" disabled="true" />
						
						<aui:input name="addressCountry2" type="hidden" value="${dc.place.addressCountry}" />
						
						<aui:input name="addressCountry" disabled="true" />
						
					</div>
					
					<div class="col-md-6">
					
						<label><liferay-ui:message key="mercator-coordinates" /></label><br>
						
						<aui:input name="mercatorX2" type="hidden" value="${dc.place.mercatorX}" />
						
						<aui:input name="mercatorX" disabled="true" />
						
						<aui:input name="mercatorY2" type="hidden" value="${dc.place.mercatorY}" />
						
						<aui:input name="mercatorY" disabled="true" />
						
						<label><liferay-ui:message key="rgf93" /></label><br>
						
						<aui:input name="RGF93X2" type="hidden" value="${dc.place.RGF93X}" />
						
						<aui:input name="RGF93X" disabled="true" />
						
						<aui:input name="RGF93Y2" type="hidden" value="${dc.place.RGF93Y}" />
						
						<aui:input name="RGF93Y" disabled="true" />
						
					</div>
				
			</aui:fieldset>
			
			<!-- Categorisation -->
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
				
			<!-- Description -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="description">
						
				<aui:input name="alias">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>
				
				<aui:input name="presentation"  />
				<!-- Hack pour ajouter une validation sur la description -->
				<div class="has-error">
					<aui:input type="hidden" name="presentationValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-presentation-error">
							function (val, fieldNode, ruleValue) {
								var validate = $('#_eu_strasbourg_portlet_place_PlaceBOPortlet_presentation_fr_FR').val().length > 0;
								if (!validate) {
									$("#_eu_strasbourg_portlet_place_PlaceBOPortlet_presentationContainer").get(0).scrollIntoView();
								}
								return validate;
							}
						</aui:validator>
					</aui:input>
				</div>
				
				<aui:input name="serviceAndActivities"   />
				<!-- Hack pour ajouter une validation sur les services et activit�s -->
				<div class="has-error">
					<aui:input type="hidden" name="serviceAndActivitiesValidatorInputHelper" value="placeholder" />
				</div>
				
				<aui:input name="characteristics"   />
				<!-- Hack pour ajouter une validation sur les caract�ristiques -->
				<div class="has-error">
					<aui:input type="hidden" name="characteristicsValidatorInputHelper" value="placeholder" />
				</div>
				
			</aui:fieldset>
				
			<!-- M�dias -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="media">
				
				<strasbourg-picker:image label="mane-image" name="imageId"
					required="false" value="${dc.place.imageId}" />
				
				<strasbourg-picker:image label="additional-images" name="imageIds"
					required="false" value="${dc.place.imageIds}" multiple="true" />
					
				<strasbourg-picker:entity label="videos" name="videosIds"
					value="${dc.place.videosIds}"
					type="eu.strasbourg.service.video.model.Video"
					multiple="true" />
				
			</aui:fieldset>
				
			<!-- Contact -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="contact">
					
						<aui:input name="phone" />
						
						<aui:input name="mail" />
						
						<aui:input name="siteLabel" id="siteLabel" helpMessage="site-help" >
							<aui:validator name="required"
								errorMessage="site-label-is-required" />
						</aui:input>
						
						<aui:input name="siteURL" id="siteURL" >
						 	<aui:validator name="url"/>
							<aui:validator name="required"
								errorMessage="site-url-is-required" />
						</aui:input>
						
						<aui:input name="facebookLabel" helpMessage="facebook-help" >
					        <aui:validator name="require" errorMessage="facebook-label-required" />
						</aui:input>
						
						<aui:input name="facebookURL">
							<aui:validator name="url"/>
							<aui:validator name="require" errorMessage="facebook-url-required" />
						</aui:input>		

			</aui:fieldset>
				
			<!-- Acc�s -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="acces">
				
				<aui:input name="access" label="access-mod" />
				<!-- Hack pour ajouter une validation sur le mode d'acc�s -->
				<div class="has-error">
					<aui:input type="hidden" name="accessValidatorInputHelper" value="placeholder"/>
				</div>		
				
				<strasbourg-picker:file label="access-map" name="accesMap"
					required="false" value="${dc.place.accesMap}" localized="true" multiple="false" />
				
				<aui:input name="accessForDisabled"  />
				<!-- Hack pour ajouter une validation sur le service aux personnes handicap�es -->
				<div class="has-error">
					<aui:input type="hidden" name="accessForDisabledValidatorInputHelper" value="placeholder"/>
				</div>	
						
					
				<div class="checkbox">
				
					<aui:input name="accessForBlind" type="toggle-switch" value="${not empty dc.place ? dc.place.accessForBlind : false}" />
					<aui:input name="accessForDeaf" type="toggle-switch" value="${not empty dc.place ? dc.place.accessForDeaf : false}" />
					<aui:input name="accessForWheelchair" type="toggle-switch" value="${not empty dc.place ? dc.place.accessForWheelchair : false}" />
					<aui:input name="accessForElder" type="toggle-switch" value="${not empty dc.place ? dc.place.accessForElder : false}" />
					<aui:input name="accessForDeficient" type="toggle-switch" value="${not empty dc.place ? dc.place.accessForDeficient : false}" />
					
				</div>
				
			</aui:fieldset>
				
			<!-- Horaires -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="horaire">
				
				<!-- P�riodes & horaires -->
				<aui:fieldset collapsed="false" collapsible="true"
					label="period-time">
				
					<div id="date-fields2">
						<c:if test="${empty dc.place.periods}">
							<div class="lfr-form-row lfr-form-row-inline period">
								<div class="row-fields">
									<liferay-util:include page="/includes/period-row.jsp" servletContext="<%=application %>">
										<liferay-util:param name="index" value="1" />
									</liferay-util:include>
								</div>
							</div>
						</c:if>
					
						<c:forEach items="${dc.place.periods}" var="period" varStatus="status">
							<div class="lfr-form-row lfr-form-row-inline period">
								<div class="row-fields">
									<fmt:formatDate value="${period.startDate}" pattern="yyyy-MM-dd" type="date" var="formattedStartDate"/>
									<fmt:formatDate value="${period.endDate}" pattern="yyyy-MM-dd" type="date" var="formattedEndDate"/>
									<liferay-util:include page="/includes/period-row.jsp" servletContext="<%=application %>">
										<liferay-util:param name="index" value="${status.count}" />
										<liferay-util:param name="name" value="${period.name}" />
										<liferay-util:param name="defaultPeriod" value="${period.defaultPeriod}" />
										<liferay-util:param name="startDate" value="${formattedStartDate}" />
										<liferay-util:param name="endDate" value="${formattedEndDate}" />
										<liferay-util:param name="linkLabel" value="${period.linkLabel}" />
										<liferay-util:param name="linkURL" value="${period.linkURL}" />
										<liferay-util:param name="alwaysOpen" value="${period.alwaysOpen}" />
										<liferay-util:param name="periodId" value="${period.periodId}" />
										<liferay-util:param name="nbSlot" value="${fn:length(period.slots)}" />
										<c:set var="slotJour" value="" />
										<c:set var="slotStartHour" value="" />
										<c:set var="slotEndHour" value="" />
										<c:forEach items="${period.slots}" var="slot">
											<c:if test="${not empty slotJour}">
												<c:set var="slotJour" value="${slotJour},${slot.dayOfWeek}" />
												<c:set var="slotStartHour" value="${slotStartHour},${slot.startHour}" />
												<c:set var="slotEndHour" value="${slotEndHour},${slot.endHour}" />
											</c:if>
											<c:if test="${empty slotJour}">
												<c:set var="slotJour" value="${slot.dayOfWeek}" />
												<c:set var="slotStartHour" value="${slot.startHour}" />
												<c:set var="slotEndHour" value="${slot.endHour}" />
											</c:if>
										</c:forEach>
										<liferay-util:param name="slotJours" value="${slotJour}" />
										<liferay-util:param name="slotStartHours" value="${slotStartHour}" />
										<liferay-util:param name="slotEndHours" value="${slotEndHour}" />
									</liferay-util:include>
								</div>
							</div>
						</c:forEach>
						<c:if test="${empty dc.place.periods}">
							<aui:input type="hidden" name="periodsIndexes" value="1" />
						</c:if>
						<c:if test="${not empty dc.place.periods}">
							<aui:input type="hidden" name="periodsIndexes" value="${dc.getDefaultIndexes(fn:length(dc.place.periods))}" />
						</c:if>
					</div>
					
				</aui:fieldset>
					
				<!-- Fermetures exceptionnelles -->
				<aui:fieldset collapsed="false" collapsible="true"
					label="exceptional-schedule">
				
					<div id="date-fields">
						<c:if test="${empty dc.place.scheduleExceptions}">
							<div class="lfr-form-row lfr-form-row-inline">
								<div class="row-fields">
									<liferay-util:include page="/includes/exceptional-schedule-row.jsp" servletContext="<%=application %>">
										<liferay-util:param name="index" value="1" />
									</liferay-util:include>
								</div>
							</div>
						</c:if>
					
						<c:forEach items="${dc.place.scheduleExceptions}" var="scheduleException" varStatus="status">
							<div class="lfr-form-row lfr-form-row-inline">
								<div class="row-fields">
									<fmt:formatDate value="${scheduleException.date}" pattern="yyyy-MM-dd" type="date" var="formattedDate"/>
									<liferay-util:include page="/includes/exceptional-schedule-row.jsp" servletContext="<%=application %>">
										<liferay-util:param name="index" value="${status.count}" />
										<liferay-util:param name="startHour" value="${scheduleException.startHour}" />
										<liferay-util:param name="endHour" value="${scheduleException.endHour}" />
										<liferay-util:param name="comment" value="${scheduleException.comment}" />
										<liferay-util:param name="date" value="${formattedDate}" />
										<liferay-util:param name="closed" value="${scheduleException.closed}" />
									</liferay-util:include>
								</div>
							</div>
						</c:forEach>
						<c:if test="${empty dc.place.scheduleExceptions}">
							<aui:input type="hidden" name="shedulesExceptionsIndexes" value="1" />
						</c:if>
						<c:if test="${not empty dc.place.scheduleExceptions}">
							<aui:input type="hidden" name="shedulesExceptionsIndexes" value="${dc.getDefaultIndexes(fn:length(dc.place.scheduleExceptions))}" />
						</c:if>
					</div>
					
				</aui:fieldset>
					
			</aui:fieldset>
				
			<!-- Informations compl�mentaires -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="add-information">
				
				<aui:input name="displayEvents" type="toggle-switch" value="${not empty dc.place ? dc.place.displayEvents : false}" />
				
				<aui:input name="additionalInformation" label="required-additionalInformation"  />
				<!-- Hack pour ajouter une validation sur les inforrmations compl�mentaires -->
				<div class="has-error">
					<aui:input type="hidden" name="additionalInformationValidatorInputHelper" value="placeholder"/>
				</div>	
				
			</aui:fieldset>
				
			<!-- Fr�quentation temps r�el -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="attendance">
				
				<aui:input name="RTExternalId" />
				<aui:input name="RTGreenThreshold" />
				<aui:input name="RTOrangeThreshold" />
				<aui:input name="RTRedThreshold" />
				<aui:input name="RTMaxThreshold" />
				
			</aui:fieldset>
				
			<!-- Sous lieux -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="sub-places">
				
				<ul class="full-borders tabular-list-group">
				
					<li class="list-group-item">
						<div class="list-group-item-content">
							<liferay-ui:message key="sub-place" />
						</div>
						<div class="list-group-item-content">
							<liferay-ui:message key="delete" />
						</div>
					</li>
					<c:forEach var="subPlace" items="${dc.place.subPlaces}">
						<li class="list-group-item">
							<div class="list-group-item-content">
								${subPlace.name}
							</div>
							<div class="list-group-item-content">
								<aui:input name="suppression" label="" type="checkbox" value="${subPlace.subPlaceId}" />
							</div>
						</li>
					</c:forEach>
					
				</ul>	

				<aui:button cssClass="btn-lg" href="${manageSubPlacesURL}"
					type="button" value="manage-sub-places" target="_blank" />
					
			</aui:fieldset>

		</aui:fieldset-group>

		<aui:button-row>
			<aui:input type="hidden" name="workflowAction" value="" />
			<c:if test="${(dc.hasPermission('ADD_PLACE') and empty dc.place or dc.hasPermission('EDIT_PLACE') and not empty dc.place) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
				<c:if test="${not dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" name="publish"
							value="publish" />
					<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft"
							value="save-as-draft" />
				</c:if>
			</c:if>
			<c:if test="${not empty dc.place && dc.hasPermission('DELETE_PLACE') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" href="${deletePlaceURL}"
					type="cancel" value="delete" />
			</c:if>
			<aui:button cssClass="btn-lg" href="${param.returnURL}" type="cancel" />
		</aui:button-row>

	</aui:form>
</div>

<liferay-util:html-top>
	<script>
		var getscheduleExceptionRowJSPURL = '${scheduleExceptionRowURL}';
		var getperiodRowJSPURL = '${periodRowURL}';
	</script>
</liferay-util:html-top>
<liferay-util:html-bottom>
	<script
		src="/o/placebo/js/place-bo-edit-place.js"
		type="text/javascript"></script>
</liferay-util:html-bottom>
