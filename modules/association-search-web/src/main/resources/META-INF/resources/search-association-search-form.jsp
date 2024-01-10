<!-- Formulaire -->
<aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form">
    <liferay-portlet:renderURLParams varImpl="searchActionURL"/>
    <div class="st-barre-listing-sit">
        <div class="st-barre-inner st-wrapper form-styles">

            <div class="st-filtre st-group-field domain">
                <label for="<portlet:namespace />domain">
                    <liferay-ui:message key="domain"/>
                </label>
                <div class="st-field-select">
                    <select class="domains" id="<portlet:namespace />domain" name="<portlet:namespace />domain">
                        <aui:option value="" label="show-all"/>
                        <c:forEach items="${dc.getSortedCategories(dc.domainVocabulary)}" var="category">
                            <c:set var="category" value="${category}" scope="request"/>
                            <c:set var="level" value="0" scope="request"/>
                            <c:set var="curValue" value="${param.domain}" scope="request"/>
                            <jsp:include page="/includes/domain-speciality-option.jsp"/>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <c:set value="${dc.getSortedCategories(dc.domainVocabulary, param.speciality)}" var="subSpecialities"/>
            <c:set value="${dc.getSortedCategories(dc.domainVocabulary, param.subSpeciality)}"
                   var="subSubSpecialities"/>
            <div class="st-filtre st-group-field speciality"
                 <c:if test="${empty param.domain}">style="display: none;" </c:if>>
                <label for="<portlet:namespace />speciality">
                    <liferay-ui:message key="speciality"/>
                </label>
                <div class="st-field-select">
                    <select class="specialities" id="<portlet:namespace />speciality"
                            name="<portlet:namespace />speciality">
                        <aui:option value="" label="show-all"/>
                        <c:if test="${param.domain != null}">
                            <c:forEach items="${dc.getSortedCategories(dc.domainVocabulary, param.domain)}"
                                       var="category">
                                <c:set var="category" value="${category}" scope="request"/>
                                <c:set var="level" value="0" scope="request"/>
                                <c:set var="curValue" value="${param.speciality}" scope="request"/>
                                <jsp:include page="/includes/domain-speciality-option.jsp"/>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>

            <div class="st-filtre st-group-field subSpeciality"
                 <c:if test="${empty param.speciality || empty subSpecialities}">style="display: none;" </c:if>>
                <label for="<portlet:namespace />subSpeciality">
                    <liferay-ui:message key="sub-speciality"/>
                </label>
                <div class="st-field-select">
                    <select class="subSpecialities" id="<portlet:namespace />subSpeciality"
                            name="<portlet:namespace />subSpeciality">
                        <aui:option value="" label="show-all"/>
                        <c:if test="${param.speciality != null}">
                            <c:forEach items="${subSpecialities}" var="category">
                                <c:set var="category" value="${category}" scope="request"/>
                                <c:set var="level" value="0" scope="request"/>
                                <c:set var="curValue" value="${param.subSpeciality}" scope="request"/>
                                <jsp:include page="/includes/domain-speciality-option.jsp"/>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>

            <div class="st-filtre st-group-field subSubSpeciality"
                 <c:if test="${empty param.subSpeciality || empty subSubSpecialities}">style="display: none;" </c:if>>
                <label for="<portlet:namespace />subSubSpeciality">
                    <liferay-ui:message key="sub-sub-speciality"/>
                </label>
                <div class="st-field-select">
                    <select class="subSubSpeciality" id="<portlet:namespace />subSubSpeciality"
                            name="<portlet:namespace />subSubSpeciality">
                        <aui:option value="" label="show-all"/>
                        <c:if test="${param.subSpeciality != null}">
                            <c:forEach items="${subSubSpecialities}" var="category">
                                <c:set var="category" value="${category}" scope="request"/>
                                <c:set var="level" value="0" scope="request"/>
                                <c:set var="curValue" value="${param.subSubSpeciality}" scope="request"/>
                                <jsp:include page="/includes/domain-speciality-option.jsp"/>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>

            <aui:input type="hidden" name="vocabulariesCount" value="${fn:length(dc.vocabularies)}"/>
            <div class="col-right">
                <div class="st-listing-results st--in-barre-sticky st-hide-from@t-portrait" role="status">
                    <div class="st-results-filter">
                        <label for="results-per-page"><liferay-ui:message key="results-per-page"/></label>
                        <div class="st-results-select">
                            <select id="results-per-page"
                                    onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
                                <c:forEach var="delta" items="${[5, 10, 20, 50, 100]}">
                                    <c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}"/>
                                    <option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <span class="st-results" role="status">
                         ${dc.searchContainer.total} <liferay-ui:message key="results"/>
                     </span>
                </div>
                <liferay-portlet:renderURL var="formURL"/>
                <button class="st-btn st--btn-small-padding st-btn-submit st-hide-until@t-portrait" type="submit">
                    <liferay-ui:message key="start-search"/></button>
                <button class="st-btn-icon st-btn-icon--bg-sub st-btn-icon-filters st-hide-until@t-portrait"
                        data-overlay-open="st-overlay-filters" aria-haspopup="dialog">
                    <span class="st-icon-filters" aria-hidden="true"></span>
                    <span class="st-sr-only"><liferay-ui:message key="more-filter"/></span>
                </button>
                <button class="st-btn st--btn-filtres st-hide-from@t-portrait" data-overlay-open="st-overlay-filters"
                        aria-haspopup="dialog">
                    <liferay-ui:message key="filter-places"/>
                </button>
            </div>

        </div>
    </div>


    <div id="st-overlay-filters" class="st-overlay st-overlay-filters" role="dialog" aria-modal="true" tabindex="0"
         aria-label="Filtres">
        <button class="st-btn-close" data-overlay-close="st-overlay-filters" aria-label="Fermer"></button>

        <div class="st-overlay__inner form-styles">
            <div class="st-overlay__body st-custom-scrollbar">

                <div class="st-overlay__heading">
                    <h2 class="st-title-overlay st-h2">${dc.getLayoutTitle()}</h2>
                    <span class="st-surtitre-cat"><liferay-ui:message key="filter-results"/></span>
                </div>

                <div class="st-grid-fields st-grid-12">


                        <%-- TODO : multi select--%>
                    <c:forEach items="${dc.vocabularies}" var="vocabulary"
                               varStatus="vocStatus">
                        <div class="st-group-field">
                            <label for="vocabulary_${vocStatus.index}">
                                    ${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}
                            </label>
                            <div class="st-field-select">
                                <select class="" id="vocabulary_${vocStatus.index}"
                                        name="<portlet:namespace />vocabulary_${vocStatus.index}">
                                    <aui:option value="" label="show-all"/>
                                    <c:forEach items="${dc.getSortedCategories(vocabulary)}" var="category">
                                        <c:set var="category" value="${category}" scope="request"/>
                                        <c:set var="dc" value="${dc}" scope="request"/>
                                        <c:set var="level" value="0" scope="request"/>
                                        <jsp:include page="/includes/category-option.jsp"/>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </c:forEach>


                </div>
            </div>

            <div class="st-overlay__footer">
                <button class="st-btn-reset-filters st-js-btn-reset-filters"><liferay-ui:message
                        key="reset-my-filters"/></button>
                <button class="st-btn st--btn-secondary-ghost" type="submit"><liferay-ui:message
                        key="apply-filter"/></button>
            </div>

        </div>

    </div>


</aui:form>

<liferay-util:html-bottom>
    <script src="/o/searchassetv2web/js/strasbourg-generic.js"></script>
</liferay-util:html-bottom>