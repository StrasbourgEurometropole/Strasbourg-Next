<%@ include file="/search-asset-init.jsp"%>
<div class="st-barre-listing-sit st--listing-agenda">
    <div class="st-barre-inner st-wrapper form-styles">
<c:if test="${dc.displayDatesButtons}">
    <c:set var="dateSelected" value="${dc.dateSelected}" />
    <input type="hidden" name="<portlet:namespace />dateSelected" value="" />
        <div class="st-filtre st-group-field st--is-date">
            <label for="<portlet:namespace />fromDate"><liferay-ui:message key="eu.event.from-date" /></label>
            <div class="st-field-date">
                <input name="from" data-type="date" type="text" id="<portlet:namespace />fromDate" placeholder="JJ/MM/AAAA"
                       value="${dc.fromDay}/${dc.fromMonthValue lt 10 ? '0' :''}${dc.fromMonthValue}/${dc.fromYear}" />
                <input type="hidden" name="<portlet:namespace />fromDay" data-name="fromDay" value="${dc.fromDay}" />
                <input type="hidden" name="<portlet:namespace />fromMonth" data-name="fromMonth" value="${dc.fromMonthIndex}" />
                <input type="hidden" name="<portlet:namespace />fromYear" data-name="fromYear" value="${dc.fromYear}" />
            </div>
        </div>

        <div class="st-filtre st-group-field st--is-date">
            <label for="<portlet:namespace />toDate"><liferay-ui:message key="eu.event.to" /></label>
            <div class="st-field-date">
                <input name="to" data-type="date" type="text" id="<portlet:namespace />toDate" placeholder="JJ/MM/AAAA"
                       value="${dc.toDay}/${dc.toMonthValue lt 10 ? '0' :''}${dc.toMonthValue}/${dc.toYear}" />
                <input type="hidden" name="<portlet:namespace />toDay" data-name="toDay" value="${dc.toDay}" />
                <input type="hidden" name="<portlet:namespace />toMonth" data-name="toMonth" value="${dc.toMonthIndex}" />
                <input type="hidden" name="<portlet:namespace />toYear" data-name="toYear" value="${dc.toYear}" />
            </div>
        </div>
</c:if>

        <div class="st-filtre st-group-field st--is-expanded">
            <label for="type"><liferay-ui:message key="eu.event-type" /></label>
            <div class="st-field-select">
                <select id="type" name="<portlet:namespace />vocabulary_1" multiple="multiple" >
                    <option value="" disabled><liferay-ui:message key="eu.event-choose-type" /></option>
                    <c:set var="typeVocabulary" value="${vocabularyAccessor.eventTypes}" />
                    <c:forEach items="${dc.getDropdownRootCategories(typeVocabulary)}" var="category">
                        <c:set var="category" value="${category}" scope="request"/>
                        <c:set var="dc" value="${dc}" scope="request"/>
                        <c:set var="level" value="0" scope="request" />
                        <jsp:include page="/forms/category-option.jsp"/>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="st-filtre st-group-field st--is-expanded">
            <label for="place"><liferay-ui:message key="eu.place" /></label>
            <div class="st-field-select">
                <select id="place"  class="" name="idSIGPlace" multiple="multiple" >
                </select>
            </div>
        </div>

        <div class="st-filtre st-group-field  st--is-expanded">
            <label for="filter-lieu"><liferay-ui:message key="keywords" /></label>
            <input id="filter-lieu" type="text" name="<portlet:namespace />keywords"
                   placeholder="<liferay-ui:message key="please-enter-keyword" />" value="${dc.keywords}" />
        </div>

        <aui:input type="hidden" name="vocabulariesCount" value="4" />

        <div class="col-right">
            <p class="st-resultats st--resultats-agenda">
                <span class="st-resultats-range">${(dc.pager.currentPage - 1) * dc.delta + 1} <liferay-ui:message key="eu.to" />
                ${(dc.pager.currentPage * dc.delta) > dc.searchContainer.total ? dc.searchContainer.total : dc.pager.currentPage * dc.delta}
                </span>
                <span class="st-resultats-total">${dc.searchContainer.total} <liferay-ui:message key="results" /></span>
                <span class="st-resultats-period st-hide-from@t-portrait">Du </span>
            </p>

            <button class="st-btn st--btn-filtres">Filtrer <span class="st-filter-counter" aria-atomic="true">(2)</span></button>
        </div>
    </div>
</div>

<liferay-util:html-bottom>
    <aui:script>
        var idSIGPlace = '${dc.idSIGPlace}' ;
    </aui:script>
	
	<script src="/o/searchassetv2web/js/bloc-date.js"></script>
	<script src="/o/searchassetv2web/js/strasbourg-agenda.js"></script>
</liferay-util:html-bottom>

	