<div class="st-barre-listing-sit">
    <form class="seu-view-filters" method="post" action="${searchURL}">
    <div class="st-barre-inner st-wrapper form-styles">
        <!-- Activités -->
        <div class="st-filtre st-group-field">
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
        <div class="st-filtre st-group-field">
            <label for="typeId"><liferay-ui:message key="type" /></label>
            <div class="st-field-select">
                <select id="typeId" name="typeId">
                    <aui:option value="" label="all-types" />
                    <c:forEach items="${dc.activityTypes}" var="category">
                        <c:set var="category" value="${category}" scope="request" />
                        <c:set var="level" value="0" scope="request" />
                        <jsp:include page="/category-option.jsp" />
                    </c:forEach>
                </select>
            </div>
        </div>
</c:if>

        <!-- Publics -->
<c:if test="${not empty dc.publics}">
        <div class="st-filtre st-group-field">
            <label for="typeId"><liferay-ui:message key="public" /></label>
            <div class="st-field-select">
                <select id="publicId" name="publicId">
                    <aui:option value="" label="all-publics" />
                    <c:forEach items="${dc.publics}" var="category">
                        <c:set var="category" value="${category}" scope="request" />
                        <c:set var="level" value="0" scope="request" />
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
                    <select id="territoryId" name="territoryId">
                        <aui:option value="" label="all-territories" />
                        <c:forEach items="${dc.territories}" var="category">
                            <c:set var="category" value="${category}" scope="request" />
                            <c:set var="level" value="0" scope="request" />
                            <jsp:include page="/category-option.jsp" />
                        </c:forEach>
                    </select>
                </div>
            </div>
        </c:if>

        <!--  Heure de debut-->
        <div class="st-filtre st-group-field">
            <label for="hour_start"><liferay-ui:message key="start-time" /></label>
            <div class="st-field-select">
                <select class="toCustomSelect" id="hour_start" name="startTimeHour">
                    <c:forEach var="hour" begin="0" end="23">
                        <fmt:formatNumber minIntegerDigits="2" value="${hour}" var="twoDigitsHour" />
                        <aui:option value="${twoDigitsHour}" label="${twoDigitsHour}" selected="${twoDigitsHour eq param.startTimeHour}" />
                    </c:forEach>
                </select>
            </div>
            <div class="st-field-select">
            <select class="toCustomSelect" id="minute_start" name="startTimeMinute">
                <aui:option value="00" label=":00" selected="${param.startTimeMinute eq '00'}" />
                <aui:option value="15" label=":15" selected="${param.startTimeMinute eq '15'}" />
                <aui:option value="30" label=":30" selected="${param.startTimeMinute eq '30'}" />
                <aui:option value="45" label=":45" selected="${param.startTimeMinute eq '45'}" />
            </select>
            </div>
        </div>

        <!-- Heure de fin -->
        <div class="st-filtre st-group-field">
            <label for="hour_end"><liferay-ui:message key="end-time" /></label>
            <div class="st-field-select">
                <select class="toCustomSelect" id="hour_end" name="endTimeHour">
                    <c:forEach var="hour" begin="0" end="23">
                        <fmt:formatNumber minIntegerDigits="2" value="${hour}" var="twoDigitsHour" />
                        <aui:option value="${twoDigitsHour}" label="${twoDigitsHour}"
                                    selected="${twoDigitsHour eq param.endTimeHour or (empty param.endTimeHour and twoDigitsHour eq '23')}" />
                    </c:forEach>
                </select>
            </div>
                <div class="st-field-select">
                <select class="toCustomSelect" id="minute_end" name="endTimeMinute">
                    <aui:option value="00" label=":00" selected="${param.endTimeMinute eq '00'}" />
                    <aui:option value="15" label=":15" selected="${param.endTimeMinute eq '15'}" />
                    <aui:option value="30" label=":30" selected="${param.endTimeMinute eq '30'}" />
                    <aui:option value="45" label=":45" selected="${param.endTimeMinute eq '45' or empty param.endTimeMinute}" />
                </select>
            </div>
        </div>

        <div class="st-filtre st-group-field">
            <label for="days"><liferay-ui:message key="day" /></label>
            <div class="st-field-select">
                <select id="days" name="days">
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

        <div class="col-right">
            <p class="st-resultats">
                <span class="st-resultats-range">${(dc.pager.currentPage - 1) * dc.delta + 1} <liferay-ui:message key="eu.to" />
                ${(dc.pager.currentPage * dc.delta) > dc.searchContainer.total ? dc.searchContainer.total : dc.pager.currentPage * dc.delta}
                </span>
                <span class="st-resultats-total">${dc.searchContainer.total} <liferay-ui:message key="results" /></span>
                <span class="st-resultats-period st-hide-from@t-portrait">Du </span>
            </p>

            <liferay-portlet:renderURL var="cancelURL" />
            <button type="button" onclick="window.location.href = '${formURL}'" class="st-btn st--btn-filtres">
                <liferay-ui:message key="cancel" />
            </button>
            <button class="st-btn st--btn-filtres" type="submit"><liferay-ui:message key="search" /></button>
        </div>
    </div>
    </form>
</div>