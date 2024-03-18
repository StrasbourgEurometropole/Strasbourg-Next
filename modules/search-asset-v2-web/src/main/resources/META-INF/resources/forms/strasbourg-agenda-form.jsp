<%@ include file="/search-asset-init.jsp"%>
<div class="st-barre-listing-sit st--listing-agenda" role="region" aria-label="Agenda, formulaire de filtre">
    <div class="st-barre-inner st-wrapper form-styles">
<c:if test="${dc.displayDatesButtons}">
    <c:set var="dateSelected" value="${dc.dateSelected}" />
    <input type="hidden" name="<portlet:namespace />dateSelected" value="" />
        <div class="st-filtre st-group-field st--is-date">
            <label for="<portlet:namespace />fromDate"><liferay-ui:message key="eu.event.from-date" /></label>
            <div class="st-field-date">
                <input data-name="from" name="from" data-type="date" type="date" id="<portlet:namespace />fromDate"
                       value="${dc.fromYear}-${dc.fromMonthValue lt 10 ? '0' :''}${dc.fromMonthValue}-${dc.fromDay lt 10 ? '0' :''}${dc.fromDay}" />
            </div>
        </div>

        <div class="st-filtre st-group-field st--is-date">
            <label for="<portlet:namespace />toDate"><liferay-ui:message key="eu.event.to" /></label>
            <div class="st-field-date">
                <input data-name="to" name="to" data-type="date" type="date" id="<portlet:namespace />toDate"
                       value="${dc.toYear}-${dc.toMonthValue lt 10 ? '0' :''}${dc.toMonthValue}-${dc.toDay lt 10 ? '0' :''}${dc.toDay}" />
            </div>
        </div>
</c:if>
        <div class="st-filtre st-group-field">
            <span class="label-fake"> <liferay-ui:message key="eu.place" /></span>
            <label for="place-select" >
                <liferay-ui:message key="eu.place" />
            </label>
            <select class="select-place" id="place-select" data-hide-tag=""  data-name="idSIGPlace">
            </select>
        </div>

        <c:forEach items="${dc.vocabularies}" var="vocabulary"
                   varStatus="vocStatus">
            <c:if test="${dc.getVocabularyDisplayType(vocabulary) eq 'list-showcase'}">
                <div class="st-filtre st-group-field">
                     <span class="label-fake"> ${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}</span>
                    <label for="vocabulary_${vocStatus.index}Barre" >
                            ${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}
                    </label>
                    <select class="" id="vocabulary_${vocStatus.index}Barre" data-name="<portlet:namespace />vocabulary_${vocStatus.index}" data-select-a11y="" data-hide-tag="" multiple="">
                        <c:forEach items="${dc.getSortedCategories(vocabulary)}" var="category">
                            <c:set var="category" value="${category}" scope="request"/>
                            <c:set var="dc" value="${dc}" scope="request"/>
                            <c:set var="level" value="0" scope="request" />
                            <jsp:include page="/forms/category-option.jsp"/>
                        </c:forEach>
                    </select>
                </div>
            </c:if>
        </c:forEach>



        <aui:input type="hidden" name="vocabulariesCount" value="${fn:length(dc.vocabularies)}" />
        <div class="col-right">
            <div class="st-listing-results st--in-barre-sticky st-hide-from@t-portrait" role="status">
                <div class="st-results-filter">
                    <label for="small-results-per-page"><liferay-ui:message key="results-per-page" /></label>
                    <div class="st-results-select">
                        <select id="small-results-per-page"  onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
                            <c:forEach var="delta" items="${[5, 10, 20, 50, 100]}">
                                <c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}" />
                                <option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <span class="st-results" role="status">
        ${dc.searchContainer.total} <liferay-ui:message key="results" />
    </span>
            </div>
            <liferay-portlet:renderURL var="formURL" />
            <button class="st-btn st--btn-small-padding st-btn-submit st-hide-until@t-portrait" type="submit"><liferay-ui:message key="to-research" /></button>
            <button class="st-btn-icon st-btn-icon--bg-sub st-btn-icon-filters st-hide-until@t-portrait" data-overlay-open="st-overlay-filters" aria-haspopup="dialog">
                <span class="st-icon-filters" aria-hidden="true"></span>
                <span class="st-sr-only"><liferay-ui:message key="search" /></span>
            </button>
            <button class="st-btn st--btn-filtres st-hide-from@t-portrait" data-overlay-open="st-overlay-filters" aria-haspopup="dialog">
                <liferay-ui:message key="filter" />
            </button>
        </div>
    </div>
</div>

<div id="st-overlay-filters" class="st-overlay st-overlay-filters" role="dialog" aria-modal="true" tabindex="0" aria-label="Filtres">
    <button class="st-btn-close" data-overlay-close="st-overlay-filters" aria-label="Fermer"></button>

    <div class="st-overlay__inner form-styles">
        <div class="st-overlay__body st-custom-scrollbar">

            <div class="st-overlay__heading">
                <h2 class="st-title-overlay st-h2">${dc.getLayoutTitle()}</h2>
                <span class="st-surtitre-cat"><liferay-ui:message key="filter-results" /></span>
            </div>

            <div class="st-grid-fields st-grid-12">
                <div class="st-group-field ">
                    <label for="name"><liferay-ui:message key="keywords" /></label>
                    <input type="text" id="name" name="<portlet:namespace />keywords"
                           placeholder="<liferay-ui:message key="please-enter-keyword" />" value="${dc.keywords}" >
                </div>
                <div class="st-group-field ">
                    <label for="place"><liferay-ui:message key="eu.place" /></label>
                    <select class="select-place" id="place" name="idSIGPlace">
                    </select>
                </div>

                <c:if test="${dc.dateField}">
                    <div class="st-group-field st-col-6@t-small">
                        <label for="date-start"><liferay-ui:message key="eu.event.from-date" /></label>
                        <div class="st-field-date">
                            <input name="from" data-type="date" type="date" id="date-start"
                                   value="${dc.fromYear}-${dc.fromMonthValue lt 10 ? '0' :''}${dc.fromMonthValue}-${dc.fromDay lt 10 ? '0' :''}${dc.fromDay}" />
                        </div>
                        <input type="hidden" name="<portlet:namespace />fromDay" data-name="fromDay" value="${dc.fromDay}" />
                        <input type="hidden" name="<portlet:namespace />fromMonth" data-name="fromMonth" value="${dc.fromMonthIndex}" />
                        <input type="hidden" name="<portlet:namespace />fromYear" data-name="fromYear" value="${dc.fromYear}" />
                    </div>


                    <div class="st-group-field st-col-6@t-small">
                        <label for="date-end"><liferay-ui:message key="eu.event.to" /></label>
                        <div class="st-field-date">
                            <input name="to" data-type="date" type="date" id="date-end"
                                   value="${dc.toYear}-${dc.toMonthValue lt 10 ? '0' :''}${dc.toMonthValue}-${dc.toDay lt 10 ? '0' :''}${dc.toDay}">
                        </div>
                        <input type="hidden" name="<portlet:namespace />toDay" data-name="toDay" value="${dc.toDay}" />
                        <input type="hidden" name="<portlet:namespace />toMonth" data-name="toMonth" value="${dc.toMonthIndex}" />
                        <input type="hidden" name="<portlet:namespace />toYear" data-name="toYear" value="${dc.toYear}" />
                    </div>


                </c:if>




                <c:forEach items="${dc.vocabularies}" var="vocabulary"
                           varStatus="vocStatus">
                    <div class="st-group-field">
                        <span class="label-fake"> ${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}</span>
                        <label for="vocabulary_${vocStatus.index}" >
                                ${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}
                        </label>
                        <select class="" id="vocabulary_${vocStatus.index}" name="<portlet:namespace />vocabulary_${vocStatus.index}" data-select-a11y="" multiple="">
                            <c:forEach items="${dc.getSortedCategories(vocabulary)}" var="category">
                                <c:set var="category" value="${category}" scope="request"/>
                                <c:set var="dc" value="${dc}" scope="request"/>
                                <c:set var="level" value="0" scope="request" />
                                <jsp:include page="/forms/category-option.jsp"/>
                            </c:forEach>
                        </select>
                    </div>
                </c:forEach>



            </div>
        </div>

        <div class="st-overlay__footer">
            <button class="st-btn-reset-filters st-js-btn-reset-filters" type="reset"><liferay-ui:message key="reset-my-filters" /></button>
            <button class="st-btn st--btn-secondary-ghost" type="submit"><liferay-ui:message key="apply-filter" /></button>
        </div>

    </div>

</div>

<liferay-util:html-bottom>
    <aui:script>
        var idSIGPlace = '${dc.idSIGPlace}' ;
    </aui:script>

	<script src="/o/searchassetv2web/js/bloc-date.js"></script>
    <script src="/o/searchassetv2web/js/date-strasbourg.js"></script>
	<script src="/o/searchassetv2web/js/strasbourg-agenda.js"></script>
    <script src="/o/searchassetv2web/js/strasbourg-generic.js"></script>
</liferay-util:html-bottom>

