<%@ include file="/place-schedule-init.jsp" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" type="date" var="fullNow" dateStyle="FULL"/>
<fmt:setLocale value="${locale}" />
<c:choose>
    <c:when test="${empty themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames or themeDisplay.scopeGroup.isStagingGroup()}">
        <c:set var="homeURL" value="/web${layout.group.friendlyURL}/" />
    </c:when>
    <c:otherwise>
        <c:set var="homeURL" value="/" />
    </c:otherwise>
</c:choose>

<liferay-portlet:renderURL var="previousURL">
    <portlet:param name="categoryId" value="${category.categoryId}" />
    <portlet:param name="date" value="${previous}" />
    <portlet:param name="placeId" value="${placeId}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="nextURL" >
    <portlet:param name="categoryId" value="${category.categoryId}" />
    <portlet:param name="date" value="${next}" />
    <portlet:param name="placeId" value="${placeId}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="changeDataURL">
    <portlet:param name="categoryId" value="${category.categoryId}" />
</liferay-portlet:renderURL>


<c:choose>
    <c:when test="${noconfig}">
        <liferay-ui:message key="no-config" />
    </c:when>
    <c:when test="${empty places}">
        <liferay-ui:message key="no-places-x" arguments="${category.getTitle(locale)}" />
    </c:when>
    <c:otherwise>

        <header class="st-small-header st-header-horaires st-wrapper st-wrapper-small">
            <h1 class="st-h1">${category.getTitle(locale)}</h1>
            <liferay-portlet:runtime
                    portletName="com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet"
                    instanceId="breadcrumb-generic" />
        </header>

        <%@ include file="/strasbourg-form.jsp"%>


        <div class="st-wrapper st-grid st-grid-12 mb-6">
            <a href="${previousURL}" class="st-btn st--btn-secondary st-col-3">
                <liferay-ui:message key="previous" />
            </a>
            <c:if test="${!empty selectedPlaces}">
                <span class="st-title-medium st-col-6 text-center my-auto">${jourChoisiFormate} - ${lastDayFormate}</span>
            </c:if>
            <a href="${nextURL}" class="st-btn st--btn-secondary st-col-3">
                <liferay-ui:message key="next" />
            </a>
        </div>

        <c:set var="hasException" value="${false}" />
        <c:forEach var="place" items="${selectedPlaces}" varStatus="placeStatus">
            <c:set var="occupationState" value="${place.getRealTime()}" />
            <c:set var="isSwimmingPool" value="${place.isSwimmingPool()}" />
            <c:set var="isIceRink" value="${place.isIceRink()}" />
            <c:set var="isMairie" value="${place.isMairie()}" />
            <c:set var="isParking" value="${place.isParking()}" />
            <c:set var="isVelhopStation" value="${place.isVelhopStation()}" />
            <div class="st-bloc st-bloc-sit-onglets st--horaires st-wrapper st-wrapper-small st--has-margin">
                <div class="st-top-bar">
                    <h2 class="st-h2 st-top-bar__title">${place.getAlias(locale)}</h2>
                    <div class="st-top-bar__content">
                        <c:choose>

                            <c:when test="${!place.isOpenNow()}">
                                <p class="st-title-medium st-u-color-pink"> <liferay-ui:message key="eu.currently-closed" /> </p>
                            </c:when>
                            <c:when test="${occupationState.toString() eq 'DISABLED' && place.isOpenNow()}">
                                <p class="st-frequentation"><liferay-ui:message key="eu.currently-open" /></p>
                            </c:when>
                            <c:when test="${occupationState.toString() eq 'NOT_AVAILABLE' && place.isOpenNow()}">
                                <p class="st-frequentation"><liferay-ui:message key="eu.currently-open" /></p>
                                <p class="st-small-text"> <liferay-ui:message key="${occupationState.label}-short" /></p>
                            </c:when>
                            <c:when test="${place.isOpenNow()}">
                                <p class="st-frequentation">
                                    <c:choose>
                                        <c:when test="${isSwimmingPool || isIceRink || isMairie}">
                                            ${occupationState.occupationLabel} <liferay-ui:message key="eu.place.person-capacity" />
                                            (<liferay-ui:message key="${occupationState.label}-short" />)
                                        </c:when>
                                        <c:when test="${isParking || isVelhopStation}">
                                            ${occupationState.available} <liferay-ui:message key="eu.place.place-capacity" />
                                        </c:when>
                                        <c:otherwise>
                                            <liferay-ui:message key="eu.currently-open" />
                                        </c:otherwise>
                                    </c:choose>

                                </p>
                                <p class="st-surtitre-cat">
                                    <c:choose>
                                        <c:when test="${isSwimmingPool}">
                                            <liferay-ui:message key="eu.place.total-capacity-long" />
                                            ${occupationState.capacity} <liferay-ui:message key="eu.place.person-capacity" />
                                        </c:when>
                                        <c:when test="${isParking}">
                                            <liferay-ui:message key="eu.place.total-capacity-long" />
                                            ${occupationState.capacity} <liferay-ui:message key="eu.place.place-capacity" />
                                        </c:when>
                                    </c:choose>
                                </p>
                                <p class="st-small-text">
                                    <c:choose>
                                        <c:when test="${isSwimmingPool}">
                                            <liferay-ui:message key="live-occupation-explanation" />
                                        </c:when>
                                        <c:when test="${isMairie}">
                                            <liferay-ui:message key="estimated-time-explanation" />
                                        </c:when>
                                        <c:when test="${isIceRink}">
                                            <liferay-ui:message key="live-ice-rink-occupation-explanation" />
                                        </c:when>
                                    </c:choose>
                                </p>
                            </c:when>
                        </c:choose>
                    </div>
                </div>

                <div class="st-container">
                    <div class="st-slider-tablist st-js-slider-tablist splide" role="tablist">
                        <div class="splide__track">
                            <ul class="splide__list">

                                <li class="splide__slide">
                                    <button class="st-slider-tablist__button" id="tab-button-${place.getSIGid()}-place" type="button" role="tab"
                                            aria-selected="true" aria-controls="tabpanel-${place.getSIGid()}-0">
                                        <span class="st-title">${place.getAlias(locale)}</span>
                                    </button>
                                </li>

                                <c:forEach var="subPlace" items="${place.getSubPlaces()}" varStatus="loop">
                                    <li class="splide__slide">
                                        <button class="st-slider-tablist__button" id="tab-button-${place.getSIGid()}-${loop.index}" type="button"
                                                role="tab" aria-selected="true" aria-controls="tabpanel-${place.getSIGid()}-${loop.count}">
                                            <span class="st-title">${subPlace.getName(locale)}</span>
                                        </button>
                                    </li>
                                </c:forEach>


                            </ul>
                        </div>
                        <div class="splide__arrows st-nav-arrows">
                            <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                            <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                        </div>
                    </div>

                    <div class="st-tabpanels">

                        <div class="st-tabpanel" id="tabpanel-${place.getSIGid()}-0" role="tabpanel" tabindex="0"
                             aria-labelledby="tab-button-${place.getSIGid()}-place">

                            <c:if test="${place.hasURLSchedule}">
                                <a href="${place.getScheduleLinkURL(locale)}" target="_blank"
                                   class="st-btn st--btn-secondary st--btn-full-width">
                                    <span class="seu-btn-text">${place.getScheduleLinkName(locale)}</span>
                                </a>
                            </c:if>

                            <c:if test="${!place.hasURLSchedule}">
                                <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                    <c:forEach var="horaires" items="${place.getPlaceSchedule(jourChoisi, 5, locale)}"
                                               varStatus="status">

                                        <%@ include file="/horaire-row.jsp"%>

                                        </td>
                                    </c:forEach>
                                </ul>
                            </c:if>
                        </div>

                        <c:forEach var="subPlace" items="${place.getSubPlaces()}" varStatus="loop">
                            <div class="st-tabpanel" id="tabpanel-${place.getSIGid()}-${loop.count}" role="tabpanel" tabindex="0"
                                 aria-labelledby="tab-button-${place.getSIGid()}-${loop.index}">

                                <c:if test="${!place.hasURLSchedule}">
                                    <c:if test="${isToday}">
                                        <p class="st-badge-today"><liferay-ui:message key="today" /></p>
                                    </c:if>
                                    <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                        <c:forEach var="horaires" items="${subPlace.getSubPlaceSchedule(jourChoisi, 5, locale)}"
                                                   varStatus="status">

                                            <%@ include file="/horaire-row.jsp"%>

                                            </td>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                            </div>
                        </c:forEach>



                    </div>

                    <div class="st-bottom-part st-text-styles st-u-text-right">
                        <a href="${homeURL}lieu/-/entity/sig/${place.getSIGid()}/${place.getNormalizedAlias(locale)}" class="st-btn st--btn-secondary-ghost st--btn-full-width-mobile"><liferay-ui:message key="eu.see-place" /></a>
                    </div>
                </div>

            </div>
        </c:forEach>

        <div class="st-wrapper st-grid st-grid-12">
            <a href="${previousURL}" class="st-btn st--btn-secondary st-col-3">
                <liferay-ui:message key="previous" />
            </a>
            <c:if test="${!empty selectedPlaces}">
                <span class="st-title-medium st-col-6 text-center my-auto">${jourChoisiFormate} - ${lastDayFormate}</span>
            </c:if>
            <a href="${nextURL}" class="st-btn st--btn-secondary st-col-3">
                <liferay-ui:message key="next" />
            </a>
        </div>

        <div class="st-wrapper text-styles mt-4">
            <c:if test="${hasException}">
                <div class="st-title-medium st-u-color-pink">
                    <liferay-ui:message key="eu.place.look-at-exceptionnal-schedule" />
                </div>
            </c:if>
            <c:if test="${!empty exceptions}">
                <div class="st-component-container calendar-schedule-exceptions rte">
                    <h3 id="exceptions"><liferay-ui:message key="eu.exceptional-closings-openings" /></h3>
                    <c:set var="nbExceptions" value="0" />
                    <ul class="st-limit-height" style="--max-height-desktop: 9rem;">
                        <c:forEach var="exception" items="${exceptions}">
                            <c:set var="nbExceptions" value="${nbExceptions + 1}" />
                            <li>
                                <strong>
                                        ${exception.key[0]}
                                    <c:if test="${fn:length(exception.key) > 1}">
                                        - ${exception.key[1]}
                                    </c:if>
                                    -
                                        ${exception.value.period} :
                                </strong>
                                <c:if test="${exception.value.isClosed()}">
                                    <liferay-ui:message key="eu.closed" />
                                </c:if>
                                <c:if test="${!exception.value.isClosed()}">
                                    <c:forEach var="openingTime" items="${exception.value.openingTimes}">
                                        ${openingTime.first} - ${openingTime.second}
                                    </c:forEach>
                                </c:if>
                                - ${exception.value.getDescription()}
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="st-show-more">
                        <button class="st-btn-show-more st-btn-arrow st--down"
                                aria-expanded="false"
                                data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                        </button>
                    </div>
                </div>
            </c:if>
        </div>




    </c:otherwise>
</c:choose>
