<!-- Detail lieu -->
<#setting locale=locale />

<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />



<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}

<#-- Liste des infos a partager -->
<#assign openGraph={ "og:title" :"${entry.getAlias(locale)?html}", "og:description"
:'${entry.getPresentation(locale)?replace("<[^>]*>", "", "r")?html}',
"og:image":"${homeURL}${entry.imageURL}"
} />


<#assign fileEntryHelper=serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
<#assign
EventLocalService=serviceLocator.findService("eu.strasbourg.service.agenda.service.EventLocalService") />

<div class="st-barre-single-sit">
    <div class="st-barre-inner st-wrapper">
        <div class="st-container-left">
            <div class="st-image">
                <@addImage fileEntryId=entry.imageId  />
            </div>
            <div class="st-content">
                <p class="st-title">${entry.getAlias(locale)}</p>
                <address><#if entry.addressStreet?has_content>
                        ${entry.addressStreet} <br>
                    </#if>
                    <#if entry.addressComplement?has_content>
                        ${entry.addressComplement} <br>
                    </#if>
                    <#if entry.addressDistribution?has_content>
                        ${entry.addressDistribution} <br>
                    </#if>
                    ${entry.addressZipCode} ${entry.getCity(locale)}
                </address>
                <#if entry.isOpenNow()>
                    <p class="st-ouverture st--open"> <@liferay_ui.message key="eu.currently-open" /></p>
                <#else>
                    <p class="st-ouverture st--closed"> <@liferay_ui.message key="eu.currently-closed" /></p>
                </#if>
            </div>
        </div>
        <div class="st-container-right">
            <ul class="st-liens-rapides">
                <li>
                    <a href="#horaire" class="st-btn-icon st-btn-icon--white"
                       title="Aller sur l'horaire">
                        <span class="st-icon-clock" aria-hidden="true"></span>
                    </a>
                </li>
                <#if entry.phone?has_content>
                    <li>
                        <a href="tel:${entry.phone}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                           title="<@liferay_ui.message key="phone" /> : ${entry.phone}">
                            <span class="st-icon-phone" aria-hidden="true"></span>
                        </a>
                    </li>
                </#if>
                <li>
                    <button class="st-btn-icon st-btn-icon--white" data-overlay-open="st-overlay-contact"
                            aria-label="Nous contacter par mail">
                        <span class="st-icon-email" aria-hidden="true"></span>
                    </button>
                </li>
                <#if entry.getSiteLabel(locale)?has_content && entry.getSiteURL(locale)?has_content>
                    <li>
                        <a href="${entry.getSiteURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                           title="${entry.getSiteLabel(locale)}">
                            <span class="st-icon-web" aria-hidden="true"></span>
                        </a>
                    </li>
                </#if>
                <#if entry.getFacebookLabel(locale)?has_content && entry.getFacebookURL(locale)?has_content>
                    <li>
                        <a href="${entry.getFacebookURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                           title="${entry.getFacebookLabel(locale)}">
                            <span class="st-icon-facebook" aria-hidden="true"></span>
                        </a>
                    </li>
                </#if>
                <#if entry.getInstagramLabel(locale)?has_content && entry.getInstagramURL(locale)?has_content>
                    <li>
                        <a href="${entry.getInstagramURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                           title="${entry.getInstagramLabel(locale)}">
                            <span class="st-icon-instagram" aria-hidden="true"></span>
                        </a>
                    </li>
                </#if>


            </ul>

            <button class="st-btn-favorite-sticky" data-addpanier="10525">
                <@liferay_ui.message key="eu.add-to-favorite" />
            </button>


            <div class="st-social-share">
                <input class="st-toggle-input" id="toggle-input" type="checkbox">
                <label for="toggle-input" class="st-toggle">
                    <span class="st-icon-social-share"></span>
                </label>

                <#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/network-list.ftl" />
            </div>


        </div>
    </div>
</div>


<div class="st-page-fiche-lieu"=>
<header
        class="st-header-fiche-lieu"
        role="banner">
    <div class="st-wrapper st-wrapper-small">
        <h1 class="st-h1 st-hide-until@t-portrait">${entry.getAlias(locale)}</h1>
        <@liferay.breadcrumbs />
    </div>

    <div class="st-visual-container st-wrapper">

        <#if entry.isEnabled()>
            <#assign occupationState = entry.getRealTime() />
            <#assign isSwimmingPool = entry.isSwimmingPool() />
            <#assign isIceRink = entry.isIceRink() />
            <#assign isMairie = entry.isMairie() />
            <#assign isParking = entry.isParking() />
            <#assign isVelhopStation = entry.isVelhopStation() />
            <div class="st-top-bar">
                <h2 class="st-h2 st-top-bar__title">
                    <#if isSwimmingPool || isIceRink || isMairie>
                        <@liferay_ui.message key="${occupationState.label}-short" />
                    <#else>
                        <#if entry.isOpenNow()>
                            <p class="st-ouverture st--open"> <@liferay_ui.message key="eu.currently-open" /></p>
                        <#else>
                            <p class="st-ouverture st--closed"> <@liferay_ui.message key="eu.currently-closed" /></p>
                        </#if>
                    </#if>
                </h2>
                <div class="st-top-bar__content">
                    <p class="st-frequentation">
                        <#if isSwimmingPool || isIceRink || isMairie>
                            ${occupationState.occupationLabel} personnes
                        <#elseif isParking || isVelhopStation>
                            ${occupationState.available} places
                        </#if>
                    </p>
                    <p class="st-surtitre-cat">
                        <#if isSwimmingPool >
                            <@liferay_ui.message key="eu.place.total-capacity-long" /> ${occupationState.capacity} personnes
                        <#elseif isParking>
                            <@liferay_ui.message key="eu.place.total-capacity-long" /> ${occupationState.capacity} places
                        </#if>
                    </p>
                    <p class="st-small-text">
                        <#if isSwimmingPool>
                            <@liferay_ui.message key="live-occupation-explanation" />
                        <#elseif isMairie>
                            <@liferay_ui.message key="estimated-time-explanation" />
                        <#elseif isIceRink>
                            <@liferay_ui.message key="live-ice-rink-occupation-explanation" />
                        </#if>
                    </p>
                </div>
            </div>
        </#if>

        <div class="st-cover-container">
            <div class="st-image">
                <@addImage fileEntryId=entry.imageId showCopyright=true />
            </div>
            <div class="st-maps" data-lat="${ entry.getMercatorY() }" data-lng="${ entry.getMercatorX() }" data-zoom="17" data-callback="initMap">

            </div>
        </div>

    </div>
</header>

<div class="st-content">

    <!-- Horaires -->
    <#if entry.periods?has_content || entry.hasURLSchedule>
        <div class="st-bloc st-bloc-sit-onglets st-wrapper st-wrapper-small st--has-margin" id="horaire">
            <h2 class="st-h2 st-bloc-sit-title">
                <@liferay_ui.message key="eu.times" />
            </h2>
            <div class="st-container">
                <div class="st-slider-thumb st-js-slider-onglet splide" role="group"
                     aria-label="Slider avec des informations sur les horaires de visite">
                    <div class="splide__track">
                        <ul class="splide__list">
                            <li class="splide__slide">
                                <p class="st-title">
                                    <@liferay_ui.message key="eu.place.next-days" />
                                </p>
                            </li>
                            <#if entry.defaultPeriod?has_content>
                                <li class="splide__slide">
                                    <p class="st-title">${entry.defaultPeriod.getName(locale)}
                                    </p>
                                </li>
                            </#if>

                            <!-- Autres periodes -->
                            <#list entry.nonDefaultPeriods as period>
                                <li class="splide__slide">
                                    <p class="st-title">${period.getName(locale)}</p>
                                    <p class="st-surtitre-cat">${period.getDisplay(locale)}</p>
                                </li>
                            </#list>

                        </ul>
                    </div>
                    <div class="splide__arrows st-nav-arrows">
                        <button
                                class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                        <button
                                class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                    </div>
                </div>
                <div class="st-slider-content st-js-slider-onglet-content splide" role="group"
                     aria-label="Contenu des slides">

                    <div class="splide__track">
                        <ul class="splide__list">

                            <!-- Jours suivants -->
                            <li class="splide__slide st-single-slide">
                                <#if entry.publishedSubPlaces?has_content>
                                    <p class="st-title">${entry.getAlias(locale)}</p>
                                </#if>

                                <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                    <#assign daySchedulesMap=entry.getFollowingWeekSchedules(.now,
                                    locale) />
                                    <#assign hasException=false />
                                    <#list daySchedulesMap?keys as day>
                                        <!-- Correctif car suite a une modif on n'envoie plus une liste vide mais null, donc erreur freemarker -->
                                        <#if daySchedulesMap[day]?size !=1 ||
                                        (daySchedulesMap[day]?size==1 &&
                                        daySchedulesMap[day][0]?? &&
                                        daySchedulesMap[day][0]?has_content)>

                                            <li  class="st-item-row">
                                                <p class="st-title">${day}</p>
                                                <div class="st-info st-u-color-secondary">
                                                    <#list daySchedulesMap[day] as schedule>
                                                        <#if schedule.isException() ||
                                                        schedule.isPublicHoliday()>
                                                            <#assign hasException=true />
                                                            <#assign hasAnyException=true />
                                                        <#else>
                                                            <#assign hasException=false />
                                                        </#if>
                                                        <#if schedule.isClosed()>
                                                            <p class="st-ouverture st--closed">
                                                                <@liferay_ui.message
                                                                key="eu.closed" />
                                                            </p>
                                                        <#elseif schedule.isAlwaysOpen()>
                                                            <p class="st-ouverture">
                                                                <@liferay_ui.message
                                                                key="always-open" />
                                                            </p>
                                                        <#else>
                                                            <#list schedule.openingTimes as
                                                            openingTime>
                                                                <p>
                                                                    ${openingTime.first} -
                                                                    ${openingTime.second}
                                                                    <#if hasException>
                                                                        <span
                                                                                class="st-symbol">*</span>
                                                                    </#if>
                                                                </p>
                                                                <#if
                                                                schedule.comments[openingTime?index]?has_content>
                                                                    <p class="st-note">
                                                                        ${schedule.comments[openingTime?index]}
                                                                    </p>
                                                                </#if>

                                                            </#list>
                                                        </#if>
                                                    </#list>

                                                </div>
                                            </li>

                                        </#if>
                                    </#list>
                                </ul>
                                <!-- Jours suivants pour les sous-lieux -->
                                <#list entry.publishedSubPlaces as subPlace>
                                    <p class="st-title">${subPlace.getName(locale)}</p>
                                    <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                        <#assign
                                        daySchedulesMap=subPlace.getFollowingWeekSchedules(.now,
                                        locale) />
                                        <#list daySchedulesMap?keys as day>
                                            <!-- Correctif car suite a une modif on n'envoie plus une liste vide mais null, donc erreur freemarker -->
                                            <#if daySchedulesMap[day]?size !=1 ||
                                            (daySchedulesMap[day]?size==1 &&
                                            daySchedulesMap[day][0]?? &&
                                            daySchedulesMap[day][0]?has_content)>
                                                <li class="st-item-row">
                                                    <p class="st-title">${day}</p>
                                                    <div class="st-info  st-u-color-secondary">
                                                        <#list daySchedulesMap[day] as schedule>
                                                            <#if schedule.isException() ||
                                                            schedule.isPublicHoliday()>
                                                                <#assign hasException=true />
                                                                <#assign hasAnyException=true />
                                                            <#else>
                                                                <#assign hasException=false />
                                                            </#if>
                                                            <#if schedule.isClosed()>
                                                                <p class="st-ouverture st--closed">
                                                                    <@liferay_ui.message
                                                                    key="eu.closed" />
                                                                </p>
                                                            <#elseif schedule.isAlwaysOpen()>
                                                                <p class="st-ouverture">
                                                                    <@liferay_ui.message
                                                                    key="always-open" />
                                                                </p>
                                                            <#else>
                                                                <#list schedule.openingTimes
                                                                as openingTime>
                                                                    <p>
                                                                        ${openingTime.first}
                                                                        -
                                                                        ${openingTime.second}
                                                                        <#if hasException>
                                                                            <span
                                                                                    class="st-symbol">*</span>
                                                                        </#if>
                                                                    </p>
                                                                    <#if
                                                                    schedule.comments[openingTime?index]?has_content>
                                                                        <p class="st-note">
                                                                            ${schedule.comments[openingTime?index]}
                                                                        </p>
                                                                    </#if>

                                                                </#list>
                                                            </#if>

                                                        </#list>
                                                    </div>
                                                </li>
                                            </#if>
                                        </#list>
                                    </ul>
                                </#list>
                                <#if hasAnyException?has_content && hasAnyException>
                                    <!-- Message pour exceptions -->
                                    <p class="st-note">
                                        <@liferay_ui.message
                                        key="eu.place.look-at-exceptionnal-schedule" />
                                    </p>
                                </#if>

                            </li>

                            <!-- Periode par defaut -->
                            <#if entry.defaultPeriod?has_content>
                                <li class="splide__slide st-single-slide">
                                    <#if entry.publishedSubPlaces?has_content>
                                        <p class="st-title">${entry.getAlias(locale)}</p>
                                    </#if>
                                    <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                        <#assign
                                        weekSchedules=entry.defaultPeriod.getWeekSchedule() />
                                        <#assign day=0 />
                                        <#list weekSchedules as schedule>
                                            <@showTime day schedule hasException />
                                            <#assign day=day + 1 />
                                        </#list>
                                    </ul>
                                    <!-- Periode par defaut pour les sous-lieux -->
                                    <#list entry.publishedSubPlaces as subPlace>
                                        <p class="st-small-title">${subPlace.getName(locale)}
                                        </p>
                                        <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                            <#assign
                                            weekSchedules=subPlace.defaultPeriod.getWeekSchedule(subPlace.subPlaceId) />
                                            <#assign day=0 />
                                            <#list weekSchedules as schedule>
                                                <@showTime day schedule hasException />
                                                <#assign day=day + 1 />
                                            </#list>
                                        </ul>
                                    </#list>
                                    <#if hasAnyException?has_content && hasAnyException>
                                        <!-- Message pour exceptions -->
                                        <p class="st-note">
                                            <@liferay_ui.message
                                            key="eu.place.look-at-exceptionnal-schedule" />
                                        </p>
                                    </#if>

                                </li>
                            </#if>

                            <!-- Autres periodes -->
                            <#list entry.nonDefaultPeriods as period>
                                <li class="splide__slide st-single-slide">
                                    <#if entry.publishedSubPlaces?has_content>
                                        <p class="st-title">${entry.getAlias(locale)}</p>
                                    </#if>

                                    <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                        <#assign weekSchedules=period.getWeekSchedule() />
                                        <#assign day=0 />
                                        <#list weekSchedules as schedule>
                                            <@showTime day schedule hasException />
                                            <#assign day=day + 1 />
                                        </#list>
                                    </ul>
                                    <!-- Periode par defaut pour les sous-lieux -->
                                    <#list entry.publishedSubPlaces as subPlace>
                                        <p class="st-small-title">${subPlace.getName(locale)}
                                        </p>
                                        <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                            <#assign
                                            weekSchedules=subPlace.defaultPeriod.getWeekSchedule(subPlace.subPlaceId) />
                                            <#assign day=0 />
                                            <#list weekSchedules as schedule>
                                                <@showTime day schedule hasException />
                                                <#assign day=day + 1 />
                                            </#list>
                                        </ul>
                                    </#list>
                                    <#if hasAnyException?has_content && hasAnyException>
                                        <!-- Message pour exceptions -->
                                        <p class="st-note">
                                            <@liferay_ui.message
                                            key="eu.place.look-at-exceptionnal-schedule" />
                                        </p>
                                    </#if>
                                </li>


                            </#list>
                        </ul>
                    </div>
                </div>
                <div>
                    <#if entry.hasURLSchedule>
                        <a href="${entry.getScheduleLinkURL(locale)}" target="_blank"
                           title="${entry.getScheduleLinkName(locale)} (<@liferay_ui.message key="
                                eu.new-window" />)">
                            <button class="st-btn st--btn-secondary st--btn-full-width">
                                ${entry.getScheduleLinkName(locale)}
                            </button>
                        </a>
                    </#if>
                </div>
                <div class="st-bottom-part st-text-styles">
                    <#if entry.hasScheduleTable()>
                        <#assign
                        assetVocabularyHelper=serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />
                        <#assign
                        placeLocalService=serviceLocator.findService("eu.strasbourg.service.place.service.PlaceLocalService") />
                        <#list entry.types as type>
                            <#if (assetVocabularyHelper.getCategoryProperty(type.categoryId, 'schedule' )=='true' )>
                                <#assign category=type />
                            </#if>
                        </#list>
                        <div>
                            <a href="${homeURL}horaires-lieux/-/schedules/category/${category.categoryId}" class="st-btn st--btn-secondary st--btn-full-width">
                                <@liferay_ui.message key="eu.see-all-schedule-of" />
                                ${category.getTitle(locale)?lower_case}
                            </a>
                        </div>
                    </#if>


                    <#if !entry.hasURLSchedule>
                        <!-- Liste des exceptions -->
                        <#assign exceptions=entry.getPlaceScheduleExceptionFreeMarker(.now, true,
                        locale) />
                        <#if exceptions?has_content || (hasAnyException?has_content &&
                        hasAnyException)>
                            <#assign totalExceptionsCount=0 />
                            <p class="st-title-medium">
                                <@liferay_ui.message key="eu.exceptional-closings-openings" />
                            </p>
                            <ul>
                                <#list exceptions as exception>
                                    <#assign totalExceptionsCount++ />
                                    <li>
                                        <strong>${exception.getPeriodDisplay(locale)}</strong> :
                                        <#if exception.isClosed()>
                                            <@liferay_ui.message key="eu.closed" />
                                        <#else>
                                            <#list exception.openingTimes as openingTime>
                                                ${openingTime.first} - ${openingTime.second}
                                                <#sep>, </#sep>
                                            </#list>
                                        </#if>
                                        - ${exception.description}
                                    </li>
                                </#list>
                                <#list entry.publishedSubPlaces as subPlace>
                                    <#assign
                                    exceptions=subPlace.getSubPlaceScheduleExceptionFreeMarker(.now,
                                    true, locale) />
                                    <#if exceptions?has_content>
                                        <#list exceptions as exception>
                                            <#assign totalExceptionsCount++ />
                                            <li>
                                                <strong>${subPlace.getName(locale)} -
                                                    ${exception.getPeriodDisplay(locale)}</strong>
                                                :
                                                <#if exception.isClosed()>
                                                    <@liferay_ui.message key="eu.closed" />
                                                <#else>
                                                    <#list exception.openingTimes as
                                                    openingTime>
                                                        ${openingTime.first} -
                                                        ${openingTime.second}<#sep>, </#sep>
                                                    </#list>
                                                </#if>
                                                - ${exception.description}
                                            </li>
                                        </#list>
                                    </#if>
                                </#list>
                            </ul>
                        </#if>
                    </#if>

                    <#if entry.getExceptionalSchedule(locale)?has_content>
                        <p class="st-small-title">
                            <@liferay_ui.message key="eu.exceptional-schedule" />
                        </p>
                        ${entry.getExceptionalSchedule(locale)}

                    </#if>
                </div>

            </div>

        </div>
    </#if>
    <#if entry.isSearchable()>
        <#assign
        assetVocabularyHelper=serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />
        <#assign
        placeLocalService=serviceLocator.findService("eu.strasbourg.service.place.service.PlaceLocalService") />
        <#list entry.types as type>
            <#if (assetVocabularyHelper.getCategoryProperty(type.categoryId, 'searchable' )=='true' )>
                <#assign category=type />
            </#if>
        </#list>
        <#assign imageEntryId = assetVocabularyHelper.getCategoryImage(category.categoryId,'picto-vert') ! "" />
        <!-- Listing Lieu meme type -->
        <div class="st-bloc st-bloc-sit-focus st--with-icon st-wrapper st-wrapper-small st--has-margin">
            <div class="st-container">

                <div class="st-col-left">
                    <#if imageEntryId?has_content>
                        <div class="st-icon-picto" style="width: 145px;">
                            <@addImage fileEntryId=imageEntryId.getFileEntryId()  />
                        </div>

                    </#if>

                    <div class="st-content">
                        <h2 class="st-h2">Vous preferez aller ailleurs ?</h2>
                        <p class="st-surtitre-cat">Il y a ${placeLocalService.getPlaceCountByAssetCategory(category, themeDisplay.getCompanyGroupId())} autres
                            ${category.getTitle(locale)?lower_case} dans l'eurometropole</p>
                    </div>
                </div>

                <div class="st-col-right">
                    <a href="${homeURL}rechercher-lieu-public?category=${category.categoryId}"
                       class="st-btn st--btn-secondary">
                        <@liferay_ui.message key="eu.see-all-other-places" />
                    </a>
                </div>
            </div>
        </div>
    </#if>





    <!-- Presentation -->
    <#if entry.getPresentation(locale)?has_content>
        <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
            <h2 class="st-h2 st-bloc-sit-title">
                <@liferay_ui.message key="eu.presentation" />
            </h2>
            <div class="st-component-container st-text-styles">
                <div class="st-limit-height ">
                    <p>${entry.getPresentation(locale)}</p>
                </div>
                <@showMore />
            </div>
        </div>
    </#if>

    <!-- Agenda  -->
    <#assign
    placeEvents=EventLocalService.getCurrentAndFuturePublishedEventsFromPlace(entry.getSIGid()) />
    <#if entry.displayEvents && placeEvents?has_content>
        <div class="st-bloc st-bloc-sit-agenda st-wrapper st-wrapper-small st--has-margin">
            <h2 class="st-h2 st-bloc-sit-title">
                <@liferay_ui.message key="agenda" />
            </h2>
            <ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">
                <#assign i=0 />
                <#list placeEvents?sort_by("startDateFirstCurrentAndFuturePeriod") as event>
                    <#if i==5>
                        <#break>
                    </#if>
                    <li>
                        <div class="st-card-container">
                            <a href="${homeURL}evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}"
                               class="st-card st-card-agenda st--card-horizontal st--with-gradient" title="${event.getTitle(locale)}">
                                <div class="st-caption">
                                    <p class="st-title-card">${event.getTitle(locale)}</p>
                                    <p class="st-surtitre-cat">${entry.getTypeLabel(locale)}</p>
                                    <p class="st-date">
                                        <#if event.firstStartDate?date==event.lastEndDate?date>
                                            <@liferay_ui.message key="eu.event.the" />
                                            ${event.firstStartDate?date?string['dd/MM']}
                                        <#else>
                                            <@liferay_ui.message key="eu.event.from-date" />
                                            ${event.firstStartDate?date?string['dd/MM']}
                                            <@liferay_ui.message key="eu.event.to" />
                                            ${event.lastEndDate?date?string['dd/MM']}
                                        </#if>
                                    </p>
                                    <p class="st-location">
                                        ${event.getPlaceAlias(locale)}
                                        <#if event.getPlaceAddress(locale)?has_content>
                                            - ${event.getPlaceAddress(locale)}
                                        </#if>
                                        - ${event.placeZipCode} ${event.getPlaceCity(locale)}
                                    </p>
                                </div>
                                <div class="st-image">
                                    <#if event.getImageId() != 0 >
                                        <@addImage fileEntryId=event.getImageId() isFigure=true />
                                    <#else>
                                        <figure class="st-figure st-fit-cover" role="group">
                                            <img src="${event.getImageURL()}" />
                                        </figure>
                                    </#if>

                                </div>
                            </a>
                            <@isFavourite entryId=event.eventId entryType=2 />

                        </div>
                    </li>
                    <#assign i++>
                </#list>
            </ul>
            <a href="${homeURL}agenda?idSIGPlace=${entry.getSIGid()}"
               class="st-btn st--btn-secondary"> <@liferay_ui.message key="sae.all-events" /></a>
        </div>
    </#if>
    <!-- Fin Agenda -->

    <!-- Activite -->
    <#assign
    activityLocalService=serviceLocator.findService("eu.strasbourg.service.activity.service.ActivityLocalService") />
    <#assign placeActivityAgenda=activityLocalService.getPlaceAgenda(entry.getSIGid(), locale) />
    <#if placeActivityAgenda.periods?has_content>
        <div class="st-bloc st-bloc-sit-onglets st-wrapper st-wrapper-small st--has-margin">
            <h2 class="st-h2 st-bloc-sit-title">
                <@liferay_ui.message key="eu.activity.activities" />
            </h2>
            <div class="st-container">
                <div class="st-slider-thumb st-js-slider-onglet splide" role="group"
                     aria-label="Slider avec des informations sur les horaires de visite">
                    <div class="splide__track">
                        <ul class="splide__list">
                            <#list placeActivityAgenda.periods as period>
                                <li class="splide__slide">
                                    <p class="st-title">${period.periodName}</p>
                                </li>
                            </#list>
                        </ul>
                    </div>
                    <div class="splide__arrows st-nav-arrows">
                        <button
                                class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                        <button
                                class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                    </div>
                </div>
                <div class="st-slider-content st-js-slider-onglet-content splide" role="group"
                     aria-label="Contenu des slides">
                    <div class="splide__track">
                        <ul class="splide__list">
                            <#list placeActivityAgenda.periods as period>
                                <li class="splide__slide st-single-slide">
                                    <#list period.courses as course>
                                        <div class="st-detail-lien">
                                            <p class="st-title-medium">${course.courseName} </p>
                                            <a href="${homeURL}cours/-/entity/id/${course.courseId}"
                                               class="st-btn st--btn-secondary st--btn-xs">
                                                <@liferay_ui.message key="eu.see-detail" />
                                            </a>
                                        </div>
                                        <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                            <#list 0..6 as day>
                                                <#assign schedules=course.getSchedulesForDay(day) />
                                                <#if schedules?has_content>
                                                    <li class="st-item-row">
                                                        <p class="st-title">
                                                            <@liferay_ui.message
                                                            key="${course.getDayName(day)}" />
                                                        </p>
                                                        <div class="st-info st-u-color-secondary">
                                                            <p>
                                                                <#list schedules as schedule>
                                                                    ${schedule.startTime} -
                                                                    ${schedule.endTime}<#sep><br>
                                                                </#sep>
                                                                </#list>
                                                            </p>
                                                        </div>
                                                    </li>
                                                </#if>
                                            </#list>
                                        </ul>
                                    </#list>

                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </#if>

    <!-- Documents Utiles/Medias -->
    <#if entry.documentURLs?has_content || entry.videos?has_content>
        <div class="st-bloc st-bloc-liens st-wrapper st-wrapper-small st--has-margin">
            <h2 class="st-h2 st-bloc-sit-title"><@liferay_ui.message key="eu.place.medias" /></h2>
            <div class="st-component-container">
                <ul class="st-liste st-limit-height">
                    <#list entry.documentURLs as fileURL>
                        <#if fileURL?has_content>
                            <#assign file = fileEntryHelper.getFileEntryByRelativeURL(fileURL) />
                            <#assign title = fileEntryHelper.getFileTitle(file.getFileEntryId(), locale) />
                            <#assign size = fileEntryHelper.getReadableFileEntrySize(file.getFileEntryId(), locale) />
                            <li class="st-lien-container">
                                <a href="${fileURL}" class="st-lien" download>
                                    <p class="st-title-lien">${title}</p>
                                    <div class="st-lien-content">
                                        <p class="st-type">(${file.getExtension()?upper_case} - ${size})</p>
                                        <p class="st-text"><@liferay_ui.message key="eu.download" /></p>

                                    </div>
                                    <span class="st-sr-only"><@liferay_ui.message key="eu.download" /></span>
                                </a>
                            </li>
                        </#if>
                    </#list>
                </ul>
                <@showMore />
            </div>
        </div>
    </#if>

    <div class="st-bloc st-bloc-sit-colonnes st-wrapper st-wrapper-small st-basic-grid st-col-2@t-small st--has-margin">
        <!-- Informations complementaires -->
        <#if entry.getAdditionalInformation(locale)?has_content>
            <div class="st-col">
                <div class="st-component-container st-text-styles">
                    <h2 class="st-h2 st-bloc-sit-title">
                        <@liferay_ui.message key="eu.place.additional-information" />
                    </h2>
                    <div class="st-limit-height ">
                        ${entry.getAdditionalInformation(locale)}
                    </div>
                    <@showMore />
                </div>
            </div>
        </#if>



        <!-- Acces -->
        <#if entry.getAccess(locale)?has_content>
            <div class="st-col">
                <div class="st-component-container st-text-styles">
                    <h2 class="st-h2 st-bloc-sit-title">
                        <@liferay_ui.message key="access" />
                    </h2>
                    <div class="st-limit-height">
                        ${entry.getAccess(locale)}
                    </div>
                    <@showMore />
                </div>
            </div>
        </#if>

    </div>
    <!-- Acces pour handicapes -->
    <#if entry.hasAnyAccessForDisabled() || entry.getAccessForDisabled(locale)?has_content>
        <div class="st-bloc st-bloc-sit-services-handicap st-wrapper st-wrapper-small st--has-margin">
            <h2 class="st-h2 st-bloc-sit-title">
                <@liferay_ui.message key="eu.access-for-disabled" />
            </h2>
            <ul class="st-meta-wrapper">
                <#if entry.accessForWheelchair>
                    <li>
                        <span class="st-icon-handicap" aria-hidden="true"></span>
                        <@liferay_ui.message key='eu.access-for-wheelchair' />
                    </li>
                </#if>
                <#if entry.accessForDeaf>
                    <li>
                        <span class="st-icon-handicap-vision" aria-hidden="true"></span>
                        <@liferay_ui.message key='eu.access-for-deaf' />
                    </li>
                </#if>
                <#if entry.accessForBlind>
                    <li>
                        <span class="st-icon-handicap-vision" aria-hidden="true"></span>
                        <@liferay_ui.message key='eu.access-for-blind' />
                    </li>
                </#if>

                <#if entry.accessForDeficient>
                    <li>
                        <span class="st-icon-handicap-vision" aria-hidden="true"></span>
                        <@liferay_ui.message key='eu.access-for-deficient' />
                    </li>
                </#if>

                <#if entry.accessForElder>
                    <li>
                        <span class="st-icon-handicap-vision" aria-hidden="true"></span>
                        <@liferay_ui.message key='eu.access-for-elder' />
                    </li>
                </#if>
            </ul>
            <div class="st-component-container st-text-styles">
                <#if entry.getAccessForDisabled(locale)?has_content>
                    <div class="st-limit-height ">
                        ${entry.getAccessForDisabled(locale)}
                    </div>
                </#if>
                <@showMore />
            </div>
        </div>
    </#if>

    <div class="st-bloc st-bloc-sit-colonnes st-wrapper st-wrapper-small st-basic-grid st-col-2@t-small st--has-margin">
        <!-- Services -->
        <#if entry.getServiceAndActivities(locale)?has_content>
            <div class="st-services">
                <div class="st-component-container st-text-styles">
                    <h2 class="st-h2 st-bloc-sit-title">
                        <@liferay_ui.message key="eu.services-and-activities" />
                    </h2>
                    <div class="st-limit-height">
                        ${entry.getServiceAndActivities(locale)}
                    </div>
                    <@showMore />
                </div>
            </div>
        </#if>
        <!-- Caracteristiques -->
        <#if entry.getCharacteristics(locale)?has_content>
            <div class="st-caracteristiques">
                <div class="st-component-container st-text-styles">
                    <h2 class="st-h2 st-bloc-sit-title">
                        <@liferay_ui.message key="eu.features" />
                    </h2>
                    <div class="st-limit-height ">
                        ${entry.getCharacteristics(locale)}
                    </div>
                    <@showMore />
                </div>
            </div>
        </#if>


    </div>

    <!-- Contact -->
    <div class="st-bloc st-bloc-sit-focus st-wrapper st--has-margin">
        <div class="st-container">
            <div class="st-col-left">
                <h2 class="st-h2"><@liferay_ui.message key="contact" /></h2>
                <p class="st-surtitre-cat">${entry.getAlias(locale)}</p>
            </div>
            <div class="st-col-right">
                <#if entry.phone?has_content>
                    <a href="tel:${entry.phone}" class="st-btn st--btn-secondary">${entry.phone}</a>
                </#if>

                <a href="#st-overlay-contact" class="st-btn st--btn-secondary"><@liferay_ui.message key="eu.contact-mail" /></a>
            </div>
        </div>
    </div>



</div>


</div>


<@liferay_portlet.actionURL var="contactURL" name="contact">
    <@liferay_portlet.param name="classPK" value="${entry.getPlaceId()}" />
    <@liferay_portlet.param name="entityId" value="${entry.getPlaceId()}" />
    <@liferay_portlet.param name="title" value="${entry.getAlias(locale)}" />
    <@liferay_portlet.param name="type" value="Place" />
</@liferay_portlet.actionURL>
<#assign overlayContactTitle=entry.getAlias(locale) />

<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/overlay-contact.ftl" />

<!-- Mise en place adict strasbourg pour les cartes -->
<script type="text/javascript">
    function initMap(t) {
        t.zoomControl.setPosition("topright")
        L.tileLayer.wms('https://adict.strasbourg.eu/mapproxy/service?', {
            layers: 'monstrasbourg'
        }).addTo(th_maps.maps[0]);
    }
</script>


<#macro showTime day schedule hasException>
    <li class="st-item-row">
        <p class="st-title">
            <@liferay_ui.message key="jour-semaine${day}" />
        </p>
        <div class="st-info st-u-color-secondary">
            <#if schedule.isClosed()>
                <p class="st-ouverture st--closed">
                    <@liferay_ui.message key="eu.closed" />
                </p>
            <#elseif schedule.isAlwaysOpen()>
                <p class="st-ouverture">
                    <@liferay_ui.message key="always-open" />
                </p>
            <#else>
                <#list schedule.openingTimes as openingTime>
                    <p>
                        ${openingTime.first}
                        -
                        ${openingTime.second}
                        <#if hasException>
                            <span class="st-symbol">*</span>
                        </#if>
                    </p>
                    <#if schedule.comments[openingTime?index]?has_content>
                        <p class="st-note">
                            ${schedule.comments[openingTime?index]}
                        </p>
                    </#if>

                </#list>
            </#if>
        </div>
    </li>
</#macro>