
<form class="seu-view-filters" method="post" action="${searchURL}">
<div class="st-barre-listing-sit" role="region" aria-label="page de recherche, formulaire de filtre">
    <div class="st-barre-inner st-wrapper form-styles">

        <div class="st-filtre st-group-field">
            <label for="activityBarre"><liferay-ui:message key="activity" /></label>
            <div class="st-field-select">
                <select cssClass="toCustomSelect" id="activityBarre" data-name="activityId" >
                    <aui:option value="" label="all-activities" selected="${empty param.activityId}" />
                    <c:forEach items="${dc.activitiesForDropdown}" var="activity">
                        <aui:option value="${activity.activityId}" label="${activity.getTitle(locale)}"
                                    selected="${param.activityId eq activity.activityId}" />
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Type -->
        <c:if test="${not empty dc.activityTypes}">
            <div class="st-filtre st-group-field">
                <label for="typeIdBarre"><liferay-ui:message key="type" /></label>
                <div class="st-field-select">
                    <select id="typeIdBarre" data-name="typeId">
                        <aui:option value="" label="all-types" />
                        <c:forEach items="${dc.activityTypes}" var="category">
                            <c:set var="category" value="${category}" scope="request" />
                            <c:set var="level" value="0" scope="request" />
                            <c:set var="curValue" value="${param.typeId}" scope="request" />
                            <jsp:include page="/category-option.jsp" />
                        </c:forEach>
                    </select>
                </div>
            </div>
        </c:if>

        <!-- Publics -->
        <c:if test="${not empty dc.publics}">
            <div class="st-filtre st-group-field">
                <label for="publicIdBarre"><liferay-ui:message key="public" /></label>
                <div class="st-field-select">
                    <select id="publicIdBarre" data-name="publicId">
                        <aui:option value="" label="all-publics" />
                        <c:forEach items="${dc.publics}" var="category">
                            <c:set var="category" value="${category}" scope="request" />
                            <c:set var="level" value="0" scope="request" />
                            <c:set var="curValue" value="${param.publicId}" scope="request" />
                            <jsp:include page="/category-option.jsp" />
                        </c:forEach>
                    </select>
                </div>
            </div>
        </c:if>

        <!-- Territoire -->
        <c:if test="${not empty dc.territories}">
            <div class="st-filtre st-group-field">
                <label for="typeId"><liferay-ui:message key="territory" /></label>
                <div class="st-field-select">
                    <select id="territoryIdBarre" data-name="territoryId">
                        <aui:option value="" label="all-territories" />
                        <c:forEach items="${dc.territories}" var="category">
                            <c:set var="category" value="${category}" scope="request" />
                            <c:set var="level" value="0" scope="request" />
                            <c:set var="curValue" value="${param.territoryId}" scope="request" />
                            <jsp:include page="/category-option.jsp" />
                        </c:forEach>
                    </select>
                </div>
            </div>
        </c:if>


        <div class="col-right">
            <div class="st-listing-results st--in-barre-sticky st-hide-from@t-portrait" role="status">
                <div class="st-results-filter">
                    <label for="results-per-page"><liferay-ui:message key="results-per-page" /></label>
                    <div class="st-results-select">
                        <select id="results-per-page"  onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
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
                <liferay-ui:message key="filter-places" />
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
                <!-- Activités -->
                <div class="st-group-field">
                    <label for="activity"><liferay-ui:message key="activity" /></label>
                    <div class="st-field-select">
                        <select cssClass="toCustomSelect" id="activity" name="activityId" >
                            <aui:option value="" label="all-activities" selected="${empty param.activityId}" />
                            <c:forEach items="${dc.activitiesForDropdown}" var="activity">
                                <aui:option value="${activity.activityId}" label="${activity.getTitle(locale)}"
                                            selected="${param.activityId eq activity.activityId}" />
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <!-- Type -->
                <c:if test="${not empty dc.activityTypes}">
                    <div class="st-group-field">
                        <label for="typeId"><liferay-ui:message key="type" /></label>
                        <div class="st-field-select">
                            <select id="typeId" name="typeId">
                                <aui:option value="" label="all-types" />
                                <c:forEach items="${dc.activityTypes}" var="category">
                                    <c:set var="category" value="${category}" scope="request" />
                                    <c:set var="level" value="0" scope="request" />
                                    <c:set var="curValue" value="${param.typeId}" scope="request" />
                                    <jsp:include page="/category-option.jsp" />
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </c:if>

                <!-- Publics -->
                <c:if test="${not empty dc.publics}">
                    <div class="st-group-field">
                        <label for="typeId"><liferay-ui:message key="public" /></label>
                        <div class="st-field-select">
                            <select id="publicId" name="publicId">
                                <aui:option value="" label="all-publics" />
                                <c:forEach items="${dc.publics}" var="category">
                                    <c:set var="category" value="${category}" scope="request" />
                                    <c:set var="level" value="0" scope="request" />
                                    <c:set var="curValue" value="${param.publicId}" scope="request" />
                                    <jsp:include page="/category-option.jsp" />
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </c:if>

                <!-- Territoire -->
                <c:if test="${not empty dc.territories}">
                    <div class="st-group-field">
                        <label for="typeId"><liferay-ui:message key="territory" /></label>
                        <div class="st-field-select">
                            <select id="territoryId" name="territoryId">
                                <aui:option value="" label="all-territories" />
                                <c:forEach items="${dc.territories}" var="category">
                                    <c:set var="category" value="${category}" scope="request" />
                                    <c:set var="level" value="0" scope="request" />
                                    <c:set var="curValue" value="${param.territoryId}" scope="request" />
                                    <jsp:include page="/category-option.jsp" />
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </c:if>

                <!--  Heure de debut-->
                <div class="st-group-field st-col-6@t-small">
                    <label for="hour_start"><liferay-ui:message key="start-time" /></label>
                    <div class="st-grid-fields st-grid-12">
                    <div class="st-field-select st-col-5">
                        <select class="toCustomSelect" id="hour_start" name="startTimeHour">
                            <c:forEach var="hour" begin="0" end="23">
                                <fmt:formatNumber minIntegerDigits="2" value="${hour}" var="twoDigitsHour" />
                                <aui:option value="${twoDigitsHour}" label="${twoDigitsHour}" selected="${twoDigitsHour eq param.startTimeHour}" />
                            </c:forEach>
                        </select>
                    </div>
                    <div class="st-field-select st-col-5">
                        <select class="toCustomSelect" id="minute_start" name="startTimeMinute">
                            <aui:option value="00" label=":00" selected="${param.startTimeMinute eq '00'}" />
                            <aui:option value="15" label=":15" selected="${param.startTimeMinute eq '15'}" />
                            <aui:option value="30" label=":30" selected="${param.startTimeMinute eq '30'}" />
                            <aui:option value="45" label=":45" selected="${param.startTimeMinute eq '45'}" />
                        </select>
                    </div>
                    </div>
                </div>

                <!-- Heure de fin -->
                <div class="st-group-field st-col-6@t-small">
                    <label for="hour_end"><liferay-ui:message key="end-time" /></label>
                    <div class="st-grid-fields st-grid-12">
                    <div class="st-field-select st-col-5">
                        <select class="toCustomSelect" id="hour_end" name="endTimeHour">
                            <c:forEach var="hour" begin="0" end="23">
                                <fmt:formatNumber minIntegerDigits="2" value="${hour}" var="twoDigitsHour" />
                                <aui:option value="${twoDigitsHour}" label="${twoDigitsHour}"
                                            selected="${twoDigitsHour eq param.endTimeHour or (empty param.endTimeHour and twoDigitsHour eq '23')}" />
                            </c:forEach>
                        </select>
                    </div>
                    <div class="st-field-select st-col-5">
                        <select class="toCustomSelect" id="minute_end" name="endTimeMinute">
                            <aui:option value="00" label=":00" selected="${param.endTimeMinute eq '00'}" />
                            <aui:option value="15" label=":15" selected="${param.endTimeMinute eq '15'}" />
                            <aui:option value="30" label=":30" selected="${param.endTimeMinute eq '30'}" />
                            <aui:option value="45" label=":45" selected="${param.endTimeMinute eq '45' or empty param.endTimeMinute}" />
                        </select>
                    </div>
                </div>
            </div>

                <div class="st-group-field">
                    <label for="days"><liferay-ui:message key="day" /></label>
                    <div class="st-field-select">
                        <select id="days" name="days">
                            <aui:option value="" label="every-day" />
                            <aui:option value="monday" label="monday" selected="${dc.isDaySelected('monday')}" />
                            <aui:option value="tuesday" label="tuesday" selected="${dc.isDaySelected('tuesday')}" />
                            <aui:option value="wednesday" label="wednesday" selected="${dc.isDaySelected('wednesday')}" />
                            <aui:option value="thursday" label="thursday" selected="${dc.isDaySelected('thursday')}" />
                            <aui:option value="friday" label="friday" selected="${dc.isDaySelected('friday')}" />
                            <aui:option value="saturday" label="saturday" selected="${dc.isDaySelected('saturday')}" />
                            <aui:option value="sunday" label="sunday" selected="${dc.isDaySelected('sunday')}" />
                        </select>
                    </div>
                </div>
            </div>
        </div>

        <div class="st-overlay__footer">
            <button class="st-btn-reset-filters st-js-btn-reset-filters"><liferay-ui:message key="reset-my-filters" /></button>
            <button class="st-btn st--btn-secondary-ghost" type="submit"><liferay-ui:message key="apply-filter" /></button>
        </div>

    </div>

</div>
</form>

<liferay-util:html-bottom>
    <script src="/o/searchassetv2web/js/strasbourg-generic.js"></script>
</liferay-util:html-bottom>
