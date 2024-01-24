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

<@liferay_util["html-bottom"]>
    <script src="/o/strasbourg-theme/js/libs/leaflet.js"></script>
</@>

<#assign fileEntryHelper=serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
<#assign
EventLocalService=serviceLocator.findService("eu.strasbourg.service.agenda.service.EventLocalService") />

<div class="st-barre-single-sit">
    <div class="st-barre-inner st-wrapper">
        <div class="st-container-left">
            <#if  fileEntryId?has_content && fileEntryId?number != 0>
                <div class="st-image">
                    <@addImage fileEntryId=entry.imageId  />
                </div>
            </#if>
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
                    <a href="#horaire" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                       title="Horaires">
                        <span class="st-icon-clock" aria-hidden="true"></span>
                        <span class="st-sr-only">Horaires</span>
                    </a>
                </li>
                <#if entry.phone?has_content>
                    <li>
                        <a href="tel:${entry.phone}" class="st-btn-icon st-btn-icon--white" target="_blank"
                           rel="noopener"
                           title="<@liferay_ui.message key="phone" /> : ${entry.phone}">
                            <span class="st-icon-phone" aria-hidden="true"></span>
                            <span class="st-sr-only"><@liferay_ui.message key="phone" /> : ${entry.phone}</span>
                        </a>
                    </li>
                </#if>
                <li>
                    <button class="st-btn-icon st-btn-icon--white" data-overlay-open="st-overlay-contact"
                            aria-label="Formulaire de contact" aria-haspopup="dialog">
                        <span class="st-icon-email" aria-hidden="true"></span>
                    </button>
                </li>
                <#if entry.getSiteLabel(locale)?has_content && entry.getSiteURL(locale)?has_content>
                    <li>
                        <a href="${entry.getSiteURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank"
                           rel="noopener"
                           title="${entry.getSiteLabel(locale)}">
                            <span class="st-icon-web" aria-hidden="true"></span>
                            <span class="st-sr-only">${entry.getSiteLabel(locale)}</span>
                        </a>
                    </li>
                </#if>
                <#if entry.getFacebookLabel(locale)?has_content && entry.getFacebookURL(locale)?has_content>
                    <li>
                        <a href="${entry.getFacebookURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank"
                           rel="noopener"
                           title="${entry.getFacebookLabel(locale)}">
                            <span class="st-icon-facebook" aria-hidden="true"></span>
                            <span class="st-sr-only">${entry.getFacebookLabel(locale)}</span>
                        </a>
                    </li>
                </#if>
                <#if entry.getInstagramLabel(locale)?has_content && entry.getInstagramURL(locale)?has_content>
                    <li>
                        <a href="${entry.getInstagramURL(locale)}" class="st-btn-icon st-btn-icon--white"
                           target="_blank" rel="noopener"
                           title="${entry.getInstagramLabel(locale)}">
                            <span class="st-icon-instagram" aria-hidden="true"></span>
                            <span class="st-sr-only">${entry.getInstagramLabel(locale)}</span>
                        </a>
                    </li>
                </#if>


            </ul>

            <@isFavouriteSticky entryId=entry.getPlaceId() entryType=1 title=entry.getAlias(locale) url=themeDisplay.getPortalURL() />


            <#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/social-share.ftl" />


        </div>
    </div>
</div>


<div class="st-page-fiche-lieu">
    <header class="st-header-fiche-lieu">
        <div class="st-wrapper st-wrapper-small">
            <h1 class="st-h1">${entry.getAlias(locale)}</h1>
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
                <#if entry.imageId?has_content && entry.imageId?number != 0>
                    <div class="st-image">
                        <@addImage fileEntryId=entry.imageId showCopyright=true />
                    </div>
                </#if>
                <div class="st-wrapper-maps">
                    <a href="#skip-map-cover" class="st-btn st--btn-xs st-skip-map st-sr-only st-sr-only-focusable">Passer
                        la carte interactive</a>
                    <div class="st-maps" role="region" aria-label="Carte interactive"
                         data-lat="${ entry.getMercatorY() }" data-lng="${ entry.getMercatorX() }" data-zoom="17"
                         data-callback="initMap">
                    </div>
                    <div id="skip-map-cover"></div>
                </div>

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
                <div class="st-slider-tablist st-js-slider-tablist splide" role="tablist">
                    <div class="splide__track">
                        <ul class="splide__list">
                            <li class="splide__slide">
                                <button class="st-slider-tablist__button" id="tab-button-1" type="button" role="tab"
                                        aria-selected="true" aria-controls="tabpanel-1">
                                    <span class="st-title"><@liferay_ui.message key="eu.place.next-days" /></span>
                                </button>
                            </li>
                            <#if entry.defaultPeriod?has_content>
                                <li class="splide__slide">
                                    <button class="st-slider-tablist__button"
                                            id="tab-button-${entry.defaultPeriod.getPeriodId()}" type="button" role="tab"
                                            aria-selected="true"
                                            aria-controls="tabpanel-${entry.defaultPeriod.getPeriodId()}">
                                        <span class="st-title">${entry.defaultPeriod.getName(locale)}</span>
                                    </button>
                                </li>
                            </#if>

                            <!-- Autres periodes -->
                            <#list entry.nonDefaultPeriods as period>
                                <li class="splide__slide">
                                    <button class="st-slider-tablist__button" id="tab-button-${period.getPeriodId()}"
                                            type="button" role="tab" aria-selected="true"
                                            aria-controls="tabpanel-${period.getPeriodId()}">
                                        <span class="st-title">${period.getName(locale)}</span>
                                        <span class="st-surtitre-cat">${period.getDisplay(locale)}</span>
                                    </button>
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
                <div class="st-tabpanels">

                    <div class="st-tabpanel" id="tabpanel-1" role="tabpanel" tabindex="0" aria-labelledby="tab-button-1">
                        <#if entry.publishedSubPlaces?has_content>
                            <h3 class="st-subplaces">${entry.getAlias(locale)}</h3>
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

                                    <li class="st-item-row">
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
                            <h3 class="st-subplaces mt-4">${subPlace.getName(locale)}</h3>
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

                    </div>

                    <!-- Periode par defaut -->
                    <#if entry.defaultPeriod?has_content>
                        <div class="st-tabpanel st-is-hidden" id="tabpanel-${entry.defaultPeriod.getPeriodId()}" role="tabpanel" tabindex="0"
                             aria-labelledby="tab-button-${entry.defaultPeriod.getPeriodId()}">
                            <#if entry.publishedSubPlaces?has_content>
                                <h3 class="st-title-medium mt-4">${entry.getAlias(locale)}</h3>
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
                                <h3 class="st-title-medium mt-4">${subPlace.getName(locale)}</h3>
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

                        </div>
                    </#if>

                    <!-- Autres periodes -->
                    <#list entry.nonDefaultPeriods as period>
                        <div class="st-tabpanel st-is-hidden" id="tabpanel-${period.getPeriodId()}" role="tabpanel" tabindex="0"
                             aria-labelledby="tab-button-${period.getPeriodId()}">
                            <#if entry.publishedSubPlaces?has_content>
                                <h3 class="st-title-medium">${entry.getAlias(locale)}</h3>
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
                                <h3 class="st-title-medium mt-4">${subPlace.getName(locale)}</h3>
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
                        </div>


                    </#list>
                    </ul>
                </div>
                <div>
                    <#if entry.hasURLSchedule>
                        <a href="${entry.getScheduleLinkURL(locale)}" target="_blank"
                           title="${entry.getScheduleLinkName(locale)}">
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
                            <a href="${homeURL}horaires-lieux/-/schedules/category/${category.categoryId}"
                               class="st-btn st--btn-secondary st--btn-full-width">
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
                            <h3 class="st-title-medium">
                                <@liferay_ui.message key="eu.exceptional-closings-openings" />
                            </h3>
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
                        <h3 class="st-title-medium"><@liferay_ui.message key="eu.exceptional-schedule" /></h3>
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
                        <p class="st-surtitre-cat">Il y
                            a ${placeLocalService.getPlaceCountByAssetCategory(category, themeDisplay.getCompanyGroupId())}
                            autres
                            ${category.getTitle(locale)?lower_case} dans l'eurometropole</p>
                    </div>
                </div>

                <div class="st-col-right">
                    <a href="${homeURL}rechercher-lieu-public?p_p_id=eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_vocabulariesCount=2&_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_keywords=&_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_vocabulary_0=${category.categoryId}&_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_vocabulary_1="
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
                               class="st-card st-card-agenda st--card-horizontal st--with-gradient"
                               title="${event.getTitle(locale)}">
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

                                    <#if event.getImageId() !=0>
                                        <@addImage fileEntryId=event.getImageId() isFigure=true />
                                    <#else>
                                        <figure class="st-figure st-fit-cover" role="group" aria-label=" © ${event.getExternalImageCopyright()}">
                                            <picture>
                                                <img src="${event.getImageURL()}" alt="" />
                                            </picture>
                                            <figcaption>
                                                <#if event.getExternalImageCopyright()?has_content &&  event.getExternalImageCopyright() != "n/a">
                                                    <button type="button" class="st-credits st-js-credits" aria-expanded="false" aria-label="© (copyright de l'image)">©</button>
                                                    <span class="st-credits-content">© ${event.getExternalImageCopyright()}</span>
                                                </#if>
                                            </figcaption>
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
                <div class="st-slider-tablist st-js-slider-tablist splide" role="tablist">
                    <div class="splide__track">
                        <ul class="splide__list">
                            <#list placeActivityAgenda.periods as period>
                                <li class="splide__slide">
                                    <button class="st-slider-tablist__button" id="tab-button-${period.periodId}" type="button" role="tab" aria-selected="true" aria-controls="tabpanel-${period.periodId}">
                                        <span class="st-title">${period.periodName}</span>
                                    </button>
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
                <div class="st-tabpanels">
                    <#list placeActivityAgenda.periods as period>
                        <div class="st-tabpanel st-is-hidden" id="tabpanel-${period.periodId}" role="tabpanel" tabindex="0" aria-labelledby="tab-button-${period.periodId}">
                            <#list period.courses as course>
                                <div class="st-detail-lien">
                                    <h3 class="st-title-medium">${course.courseName} </h3>
                                    <a href="${homeURL}cours/-/entity/id/${course.courseId}"
                                       class="st-btn st--btn-secondary-ghost st--btn-xs st--btn-small-padding">
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

                                                    <#list schedules as schedule>
                                                        <p>${schedule.startTime} -
                                                        ${schedule.endTime} </p><#sep>
                                                    </#sep>
                                                    </#list>

                                                </div>
                                            </li>
                                        </#if>
                                    </#list>
                                </ul>
                            </#list>

                        </div>
                    </#list>
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

                    <#list entry.documentsIds?split(",") as fileId>
                        <#if fileId?has_content>
                            <#assign url = fileEntryHelper.getFileEntryURL(fileId?number) />
                            <#assign title = fileEntryHelper.getFileTitle(fileId?number, locale) />
                            <#assign size = fileEntryHelper.getReadableFileEntrySize(fileId?number, locale) />
                            <#assign extension = fileEntryHelper.getFileExtension(fileId?number) />
                            <li class="st-lien-container">
                                <a href="${url}" class="st-lien" download>
                                    <p class="st-title-lien">${title}</p>
                                    <div class="st-lien-content">
                                        <p class="st-type">(${extension?upper_case} - ${size})</p>
                                        <p class="st-text"><@liferay_ui.message key="eu.download" /></p>

                                    </div>
                                </a>
                            </li>
                        </#if>
                    </#list>
                </ul>
                <@showMore />
            </div>
        </div>
    </#if>

    <div class="st-bloc st-bloc-sit-colonnes st-bloc-sit-services-handicap st-wrapper st-wrapper-small st-basic-grid st-col-2@t-small st--has-margin">
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

    <div class="st-bloc st-bloc-sit-colonnes st-bloc-sit-services-handicap st-wrapper st-wrapper-small st-basic-grid st-col-2@t-small st--has-margin">
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

                <a href="#st-overlay-contact"
                   class="st-btn st--btn-secondary"><@liferay_ui.message key="eu.contact-mail" /></a>
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