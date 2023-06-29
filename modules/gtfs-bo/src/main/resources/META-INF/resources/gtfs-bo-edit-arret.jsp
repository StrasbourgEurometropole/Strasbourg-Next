<%@page import="java.util.Date"%>
<%@ page import="eu.strasbourg.service.gtfs.model.Arret" %>
<%@ include file="/gtfs-bo-init.jsp"%>

<liferay-portlet:actionURL name="saveArret" varImpl="saveArretURL">
	<portlet:param name="tab" value="arrets" />
</liferay-portlet:actionURL>
<div class="container-fluid container-fluid-max-xl main-content-body">
<liferay-ui:error key="start-date-error" message="start-date-error" />
	<liferay-ui:error key="end-date-error" message="end-date-error" />
	<liferay-ui:error key="period-date-error" message="period-date-error" />
	<liferay-ui:error key="ligne-error" message="ligne-error" />
	<liferay-ui:error key="perturbation-error" message="perturbation-error" />

	<aui:form action="${saveArretURL}" method="post" name="fm">
		<aui:translation-manager availableLocales="${dc.availableLocales}"
			changeableDefaultLanguage="false" defaultLanguageId="${locale}"
			id="translationManager" />

		<aui:model-context bean="${dc.arret}" model="<%=Arret.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">
		<aui:input name="arretId" type="hidden" />

			<!-- Informations générale -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="general-information">

                    <aui:input name="title" disabled="true" />

                    <aui:input name="code" disabled="true"/>
				
			</aui:fieldset>

			<!-- Lignes et directions -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="lignes-directions">

                <c:forEach items="${dc.arret.directionsUniques}" var="direction" varStatus="status">
                    <div class="ligne-direction">
                        <p class="tram-destination-letter">
                            <span class="transport-letters-icon" style="background:#${direction.value[0]}; color:#${direction.value[1]};">
                                ${direction.key}
                            </span>
                        </p>
                        <p class="tram-destination-name">
                            ${direction.value[2]}
                        </p>
                    </div>
				</c:forEach>

			</aui:fieldset>
			
			<!-- Categorisation -->
			<aui:fieldset collapsed="true" collapsible="true"
				label="categorization">

				<liferay-asset:asset-categories-selector
						className="<%= Arret.class.getName() %>"
						classPK="${dc.arret.arretId}"/>
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
						className="<%= Arret.class.getName() %>"
						classPK="${dc.arret.arretId}"/>

			</aui:fieldset>
				
			<!-- Alertes -->
			<aui:fieldset collapsed="false" collapsible="true"
				label="alerts">

				<c:set value="${dc.arret.alerts}" var="alerts" />
                <div id="alert-fields">
                    <c:if test="${empty alerts}">
                        <div class="lfr-form-row lfr-form-row-inline">
                            <div class="row-fields">
                                <liferay-util:include page="/includes/alert-row.jsp" servletContext="<%=application %>">
                                    <liferay-util:param name="index" value="1" />
                                </liferay-util:include>
                            </div>
                        </div>

                        <div class="lfr-form-row lfr-form-row-inline">
                            <div class="row-fields">
                                <liferay-util:include page="/includes/alert-row.jsp" servletContext="<%=application %>">
                                    <liferay-util:param name="index" value="2" />
                                </liferay-util:include>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty alerts}">
				        <c:set value="${alerts.get(0)}" var="alert1" />
                        <div class="lfr-form-row lfr-form-row-inline">
                            <div class="row-fields">
                                <fmt:formatDate value="${alert1.startDate}" pattern="yyyy-MM-dd" type="date" var="formattedStartDate"/>
                                <fmt:formatDate value="${alert1.endDate}" pattern="yyyy-MM-dd" type="date" var="formattedEndDate"/>
                                <liferay-util:include page="/includes/alert-row.jsp" servletContext="<%=application %>">
                                    <liferay-util:param name="index" value="1" />
                                    <liferay-util:param name="startDate" value="${formattedStartDate}" />
                                    <liferay-util:param name="endDate" value="${formattedEndDate}" />
                                    <liferay-util:param name="ligneAndDirection" value="${alert1.ligneAndDirection}" />
                                    <liferay-util:param name="perturbation" value="${alert1.perturbation}" />
                                </liferay-util:include>
                            </div>
                        </div>

                        <c:if test="${alerts.size() == 1}">
                            <div class="lfr-form-row lfr-form-row-inline">
                                <div class="row-fields">
                                    <liferay-util:include page="/includes/alert-row.jsp" servletContext="<%=application %>">
                                        <liferay-util:param name="index" value="2" />
                                    </liferay-util:include>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${alerts.size() > 1}">
                            <c:set value="${alerts.get(1)}" var="alert2" />
                            <div class="lfr-form-row lfr-form-row-inline">
                                <div class="row-fields">
                                    <fmt:formatDate value="${alert2.startDate}" pattern="yyyy-MM-dd" type="date" var="formattedStartDate"/>
                                    <fmt:formatDate value="${alert2.endDate}" pattern="yyyy-MM-dd" type="date" var="formattedEndDate"/>
                                    <liferay-util:include page="/includes/alert-row.jsp" servletContext="<%=application %>">
                                        <liferay-util:param name="index" value="2" />
                                        <liferay-util:param name="startDate" value="${formattedStartDate}" />
                                        <liferay-util:param name="endDate" value="${formattedEndDate}" />
                                        <liferay-util:param name="ligneAndDirection" value="${alert2.ligneAndDirection}" />
                                        <liferay-util:param name="perturbation" value="${alert2.perturbation}" />
                                    </liferay-util:include>
                                </div>
                            </div>
                        </c:if>
                    </c:if>
                </div>
					
			</aui:fieldset>

		</div></div>

		<aui:button-row>
			<aui:input type="hidden" name="workflowAction" value="" />
			<c:if test="${(empty dc.arret or dc.hasPermission('EDIT_ARRET') and not empty dc.arret) and empty themeDisplay.scopeGroup.getStagingGroup()}">
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
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
		</aui:button-row>

	</aui:form>
</div>
<liferay-util:html-bottom>
	<script
		src="/o/gtfsbo/js/gtfs-bo-edit-arret.js"
		type="text/javascript"></script>
</liferay-util:html-bottom>
