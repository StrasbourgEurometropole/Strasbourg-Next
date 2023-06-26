<%@ include file="/search-asset-init.jsp"%>

<portlet:resourceURL id="entrySelectionParticipation" var="participationsSelectionURL">
</portlet:resourceURL>

<c:set var="groupID" value="${themeDisplay.scopeGroupId}" />

<!-- Recherche par mots-clefs -->
<div class="pro-group">
    <div class="pro-header">
        <h4><liferay-ui:message key="eu.placite.keywords" /></h4>
    </div>
    <fieldset class="pro-text">
        <legend aria-hidden="true" class="hide">Effectuer une recherche</legend>
        <div>
            <input type="text" 
            	name="<portlet:namespace />keywords"
            	id="name"
            	placeholder="<liferay-ui:message key="please-enter-keyword" />"
            	value="${dc.keywords}">
            <label for="name" class="hide"><liferay-ui:message key="keywords" /></label>
        </div>

		<span class="pro-remove dynamic"><liferay-ui:message key="eu.erase" /></span>
    </fieldset>
</div>

<!-- Recherche par dates -->
<c:if test="${dc.dateField}">
	<div class="pro-group">
	    <div class="pro-header">
	        <h4><liferay-ui:message key="eu.dates" /></h4>
	        <span class="pro-remove dynamic"><liferay-ui:message key="eu.erase" /></span>
	    </div>
	    <fieldset>
	        <legend aria-hidden="true" class="hide">Choix par date</legend>
	        <div>
	            <div class="pro-facette-date">
	                <label for="startDate" class="hide"><liferay-ui:message key="eu.dates" /></label>
	                <span class="pro-wrapper-date">
	                	<input name="from" data-type="date" type="text" id="date-start"  class="frm_date dynamic"
			            	readonly="readonly" value="${dc.fromDay}/${dc.fromMonthValue}/${dc.fromYear}">
			            <input type="hidden" name="<portlet:namespace />fromDay" data-name="fromDay" value="${dc.fromDay}" />
			            <input type="hidden" name="<portlet:namespace />fromMonth" data-name="fromMonth" value="${dc.fromMonthIndex}" />
			            <input type="hidden" name="<portlet:namespace />fromYear" data-name="fromYear" value="${dc.fromYear}" />
	                </span>
	                <label for="endDate"><liferay-ui:message key="eu.au" /></label>
	                <span class="pro-wrapper-date"> 
	                	<input name="to" data-type="date" type="text" id="date-end" class="frm_date dynamic"
			            	readonly="readonly" value="${dc.toDay}/${dc.toMonthValue}/${dc.toYear}">
			            <input type="hidden" name="<portlet:namespace />toDay" data-name="toDay" value="${dc.toDay}" />
			            <input type="hidden" name="<portlet:namespace />toMonth" data-name="toMonth" value="${dc.toMonthIndex}" />
			            <input type="hidden" name="<portlet:namespace />toYear" data-name="toYear" value="${dc.toYear}" />
	                </span>
	            </div>
	        </div>
	    </fieldset>
	</div>
</c:if>

<!-- Recherche par etat -->
<div class="pro-group">
	<input type="checkbox" id="participation_states_checkbox"/>
	<label for="participation_states_checkbox">
		<span class="pro-group-title"><liferay-ui:message key="eu.state" /> :</span>
		<span class="see-less">Voir moins</span>
		<span class="see-more">Voir plus</span>
	</label>
    <fieldset id="states_fieldset" class="pro-checkbox">
        <legend aria-hidden="true" class="hide">Choix par denomination de l'etat</legend>
        
        <c:set var="statusVocabulary" value="${vocabularyAccessor.getPlacitStatus(groupID)}" />
		<c:forEach
			items="${dc.getDropdownRootCategories(statusVocabulary)}"
			var="category"
			varStatus="catStatus">
			<aui:input type="checkbox" name="vocabulary_0"
				value="${category.categoryId}"
				checked="${fn:contains(dc.filterCategoriesIdsString, category.categoryId)}"
				id="vocabulary_0_${catStatus.index}"
				label="${category.getTitle(locale)}"
				cssClass="move-to-grand-parent" />
		</c:forEach>
		<span class="pro-remove dynamic"><liferay-ui:message key="eu.erase" /></span>
    </fieldset>
</div>

<!-- Recherche par quartiers -->
<div class="pro-group">
	<input type="checkbox" id="participation_districts_checkbox"/>
	<label for="participation_districts_checkbox">
		<span class="pro-group-title"><liferay-ui:message key="eu.search.asset.web.platit.participation.territories" /> :</span>
		<span class="see-less">Voir moins</span>
		<span class="see-more">Voir plus</span>
	</label>
    <fieldset id="districts_fieldset" class="pro-checkbox">
        <legend aria-hidden="true" class="hide">Choix par nom de territoire</legend>
        
        <c:set var="districtVocabulary" value="${vocabularyAccessor.getTerritories()}" />
		<c:forEach
			items="${dc.getDropdownRootCategories(districtVocabulary)}"
			var="category"
			varStatus="catStatus">
			<aui:input type="checkbox" name="vocabulary_1"
				value="${category.categoryId}"
				checked="${fn:contains(dc.filterCategoriesIdsString, category.categoryId)}"
				id="vocabulary_1_${catStatus.index}"
				label="${category.getTitle(locale)}"
				cssClass="move-to-grand-parent" />
		</c:forEach>

		<span class="pro-remove dynamic"><liferay-ui:message key="eu.erase" /></span>
        
    </fieldset>
</div>

<!-- Recherche par thematiques -->
<div class="pro-group">
	<input type="checkbox" id="participation_thematics_checkbox"/>
	<label for="participation_thematics_checkbox">
		<span class="pro-group-title"><liferay-ui:message key="eu.thematics" /> :</span>
		<span class="see-less">Voir moins</span>
		<span class="see-more">Voir plus</span>
	</label>
    <fieldset id="thematics_fieldset" class="pro-checkbox">
        <legend aria-hidden="true" class="hide">Choix par nom de la thematique</legend>
        		
		<c:set var="thematicVocabulary" value="${vocabularyAccessor.getThematics(groupID)}" />
		<c:forEach
			items="${dc.getDropdownRootCategories(thematicVocabulary)}"
			var="category"
			varStatus="catStatus">
			<aui:input type="checkbox" name="vocabulary_2"
				value="${category.categoryId}"
				checked="${fn:contains(dc.filterCategoriesIdsString, category.categoryId)}"
				id="vocabulary_2_${catStatus.index}"
				label="${category.getTitle(locale)}"
				cssClass="move-to-grand-parent" />
		</c:forEach>

		<span class="pro-remove dynamic"><liferay-ui:message key="eu.erase" /></span>
		
    </fieldset>
</div>

<!-- Recherche par types -->
<div class="pro-group">
	<input type="checkbox" id="participation_types_checkbox"/>
	<label for="participation_types_checkbox">
		<span class="pro-group-title"><liferay-ui:message key="eu.participation.types" /> :</span>
		<span class="see-less">Voir moins</span>
		<span class="see-more">Voir plus</span>
	</label>
    <fieldset id="types_fieldset" class="pro-checkbox">
        <legend aria-hidden="true" class="hide">Choix par type de participation</legend>
		
		<c:set var="participationTypesVocabulary" value="${vocabularyAccessor.getParticipationTypes(groupID)}" />
		<c:forEach
			items="${dc.getDropdownRootCategories(participationTypesVocabulary)}"
			var="category"
			varStatus="catStatus">
			<aui:input type="checkbox" name="vocabulary_3"
				value="${category.categoryId}"
				checked="${fn:contains(dc.filterCategoriesIdsString, category.categoryId)}"
				id="vocabulary_3_${catStatus.index}"
				label="${category.getTitle(locale)}"
				cssClass="move-to-grand-parent" />
		</c:forEach>

		<span class="pro-remove dynamic"><liferay-ui:message key="eu.erase" /></span>
		
    </fieldset>
</div>

<script>
	$(document).ready(function() {
		$('.move-to-grand-parent').each(function() {
		  $(this).prependTo($(this).parent().parent());
		});
	});
</script>

<liferay-util:html-top>
	<script>
		var porletNamespace = '<portlet:namespace/>';

        var participationsSelectionURL = '${participationsSelectionURL}';
	</script>
</liferay-util:html-top>

<liferay-util:html-bottom>
	<script src="/o/searchassetweb/js/placit-participation.js"></script>

</liferay-util:html-bottom>