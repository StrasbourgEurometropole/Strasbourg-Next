<%@ include file="/sectorized-init.jsp" %>
<div class="st-wrapper st-wrapper-small st-form-defunt">

</div>

<div class="st-wrapper st-wrapper-small st-form-defunt">
	
	<liferay-portlet:actionURL var="searchURL" name="search">
	</liferay-portlet:actionURL>
	<aui:form name="fm" action="${searchURL}" cssClass="form-styles">
		<div class="st-grid-fields st-grid-12" >
			<!-- Adresse -->
			<div class="st-group-field">
				<label for="query"><liferay-ui:message key="sect.query" /></label>
				<input type="text" id="query" name="query"
					   placeholder="<liferay-ui:message key="sect.address-placeholder" />" value="${not empty streetName ? streetName : query}">
			</div>
			<!-- Validation -->
			<div class="st-col-12@t-small st-btn-submit-wrapper">
				<button type="submit" class="st-btn st--btn-full-width-mobile">
					<liferay-ui:message key="search" />
				</button>
			</div>
		</div>
	</aui:form>
	
	<!-- Erreurs -->
	<div class="mt-5">
		<liferay-ui:error key="unknown-error" message="eu.unknown-error" targetNode=".seu-error-messages" />
	   	<liferay-ui:error key="no-result" message="eu.no-result" targetNode=".seu-error-messages" />
	   	<liferay-ui:error key="too-many-results" message="eu.too-many-results" targetNode=".seu-error-messages" />
	</div>
	
	<!-- RÃ©sultats -->
	<c:if test="${not empty places}">
		<div class="st-listing st--listing-cards-horizontales listing st-wrapper st-wrapper-small">
			<div class="st-listing-results st-hide-until@t-portrait">
				<span class="st-results" role="status">
					${fn:length(places)}
					<c:choose>
					<c:when test="${fn:length(places) gt 1}">
						<liferay-ui:message key="results" />
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="result" />
					</c:otherwise>
				</c:choose></span>
			</div>
			<div class="st-listing-cards st-wrapper st-wrapper-small">
				<ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-3@mobile st-col-4@t-small"><!-- Vignette lieu Grille -->
					<c:forEach var="place" items="${places}">
						<div id="seu-grid--list01">
							<liferay-ddm:template-renderer
									className="${className}"
									contextObjects="${dc.getContextObjects(place)}"
									displayStyle="${displayStyle}"
									displayStyleGroupId="${displayStyleGroupId}"
									entries="${entries}"
							>
								no-config
							</liferay-ddm:template-renderer>
						</div>
					</c:forEach>
				</ul>
			</div>
		</div>

	</c:if>

</div>

<liferay-util:html-bottom>
	<script	src="/o/agendabo/js/vendors/jquery.autocomplete.js"></script>
	<script>
		<%--
			Si la configuration demande qu'on force la recherche sur Strasbourg
		 	on set cette variable globale utilisÃ©e dans le JS
		--%>		
		<c:choose>
			<c:when test="${forceStrasbourg}">
				window.forcedCity = 'Strasbourg';
			</c:when>
			<c:otherwise>
				window.forcedCity = '';
			</c:otherwise>
		</c:choose>
	</script>
	<script
		src="/o/sectorized/js/sectorized.js"
		type="text/javascript"></script>
		
	<style>
		.alert-success {
			display: none;
		}
	</style>
</liferay-util:html-bottom>