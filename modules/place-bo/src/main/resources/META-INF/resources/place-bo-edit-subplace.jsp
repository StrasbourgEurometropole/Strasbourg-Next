<%@ include file="/place-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.place.model.SubPlace"%>

<liferay-portlet:renderURL varImpl="subPlacesURL">
	<portlet:param name="tab" value="subPlaces" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="deleteSubPlace"
	var="deleteSubPlaceURL">
	<portlet:param name="cmd" value="deleteSubPlace" />
	<portlet:param name="tab" value="subPlaces" />
	<portlet:param name="subPlaceId"
		value="${not empty dc.subPlace ? dc.subPlace.subPlaceId : ''}" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="saveSubPlace"
	varImpl="saveSubPlaceURL">
	<portlet:param name="cmd" value="saveSubPlace" />
	<portlet:param name="tab" value="subPlaces" />
</liferay-portlet:actionURL>

<div class="container-fluid-1280 main-content-body">
	<aui:form action="${saveSubPlaceURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.subPlace}"
			model="<%=SubPlace.class %>" />
		<aui:fieldset-group markupView="lexicon">
			<aui:input name="subPlaceId" type="hidden" />

			<!-- Informations générale -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="general-information">
				
				<aui:input name="name">
					<aui:validator name="required"
						errorMessage="this-field-is-required" />
				</aui:input>
				
				<aui:input name="description" />
				<!-- Hack pour ajouter une validation sur la description -->
				<div class="has-error">
					<aui:input type="hidden" name="descriptionValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-description-error">
							function (val, fieldNode, ruleValue) {
								var validate = $('#_eu_strasbourg_portlet_place_PlaceBOPortlet_description_fr_FR').val().length > 0;
								if (!validate) {
									$("#_eu_strasbourg_portlet_place_PlaceBOPortlet_descriptionContainer").get(0).scrollIntoView();
								}
								return validate;
							}
						</aui:validator>
					</aui:input>
				</div>
					
				<strasbourg-picker:entity label="place"
					name="placeId" value="${dc.subPlace.placeId}"
					type="eu.strasbourg.service.place.model.Place"
					multiple="false" />

			</aui:fieldset>
				
			<!-- Horaires -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="horaire">
				
				<!-- Périodes & horaires -->
				<aui:fieldset collapsed="false" collapsible="true"
					label="period-time">
				
					<div id="date-fields2">
						<c:if test="${empty dc.subPlace.periods}">
							<div class="lfr-form-row lfr-form-row-inline period">
								<div class="row-fields">
									<liferay-util:include page="/includes/period-row.jsp" servletContext="<%=application %>">
										<liferay-util:param name="index" value="1" />
									</liferay-util:include>
								</div>
							</div>
						</c:if>
					
						<c:forEach items="${dc.subPlace.periods}" var="period" varStatus="status">
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
						<c:if test="${empty dc.subPlace.periods}">
							<aui:input type="hidden" name="periodsIndexes" value="1" />
						</c:if>
						<c:if test="${not empty dc.subPlace.periods}">
							<aui:input type="hidden" name="periodsIndexes" value="${dc.getDefaultIndexes(fn:length(dc.subPlace.periods))}" />
						</c:if>
					</div>
					
				</aui:fieldset>
					
				<!-- Fermetures exceptionnelles -->
				<aui:fieldset collapsed="false" collapsible="true"
					label="exceptional-schedule">
				
					<div id="date-fields">
						<c:if test="${empty dc.subPlace.scheduleExceptions}">
							<div class="lfr-form-row lfr-form-row-inline">
								<div class="row-fields">
									<liferay-util:include page="/includes/exceptional-schedule-row.jsp" servletContext="<%=application %>">
										<liferay-util:param name="index" value="1" />
									</liferay-util:include>
								</div>
							</div>
						</c:if>
					
						<c:forEach items="${dc.subPlace.scheduleExceptions}" var="scheduleException" varStatus="status">
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
						<c:if test="${empty dc.subPlace.scheduleExceptions}">
							<aui:input type="hidden" name="shedulesExceptionsIndexes" value="1" />
						</c:if>
						<c:if test="${not empty dc.subPlace.scheduleExceptions}">
							<aui:input type="hidden" name="shedulesExceptionsIndexes" value="${dc.getDefaultIndexes(fn:length(dc.subPlace.scheduleExceptions))}" />
						</c:if>
					</div>
					
				</aui:fieldset>
					
			</aui:fieldset>

		</aui:fieldset-group>

		<aui:button-row>
			<c:if test="${empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" type="submit" name="publish"
					value="eu.publish" />
				<aui:button cssClass="btn-lg btn-default" type="submit"
					name="save-as-draft" value="save-as-draft" />
			</c:if>
			<c:if
				test="${not empty dc.subPlace and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" href="${deleteSubPlaceURL}" type="cancel"
					value="delete" />
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
		src="/o/placebo/js/place-bo-edit-subplace.js"
		type="text/javascript"></script>
</liferay-util:html-bottom>