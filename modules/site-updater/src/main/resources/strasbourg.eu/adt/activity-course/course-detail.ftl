<!-- Détail cours -->
<#setting locale=locale />
<#assign uriHelper=serviceLocator.findService("eu.strasbourg.utils.api.UriHelperService") />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#-- Liste des infos a partager -->
<#assign openGraph={ "og:description" :'${entry.getPresentation(locale)?replace("<[^>]
*>", "", "r")?html}'
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<header class="st-header-fiche-agenda">
    <div class="st-wrapper st-wrapper-small">
        <p class="st-surtitre-cat st-hide-until@t-portrait">
            ${entry.getTypesLabels(locale)}
        </p>
        <h1 class="st-h1">
            ${entry.getName(locale)}
        </h1>
        <@liferay.breadcrumbs />
        <p class="st-title-secondary st-h3">
            <@liferay_ui.message key="eu.activity.part-of-activity" /> <a href="${homeURL}activite/-/entity/id/${entry.activityId}" title="${entry.activity.getTitle(locale)}">
                ${entry.activity.getTitle(locale)}
            </a>
        </p>
    </div>
</header>
<#if entry.getPresentation(locale)?has_content>
    <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.presentation" />
        </h2>
        <div class="st-component-container st-text-styles">
            <div class="st-limit-height st--is-overflowing">
                <p>
                    ${entry.getPresentation(locale)}
                </p>
            </div>
            <div class="st-show-more">
                <button class="st-btn-show-more st-btn-arrow st--down"
                        aria-expanded="false"
                        data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                </button>
            </div>
        </div>
    </div>
</#if>
<div class="st-bloc st-bloc-sit-colonnes st-wrapper st-wrapper-small st-basic-grid st-col-2@t-small st--has-margin">
    <#if entry.getPrice(locale)?has_content>
        <div class="st-col">
            <div class="st-component-container st-text-styles">
                <h2 class="st-h2 st-bloc-sit-title">
                    <@liferay_ui.message key="eu.prices" />
                </h2>
                <div class="st-limit-height st--is-overflowing">
                    ${entry.getPrice(locale)}
                </div>
                <div class="st-show-more">
                    <button class="st-btn-show-more st-btn-arrow st--down"
                            aria-expanded="false"
                            data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                    </button>
                </div>
            </div>
        </div>
    </#if>
    <#if entry.getArrangements(locale)?has_content>
        <div class="st-col">
            <div class="st-component-container st-text-styles">
                <h2 class="st-h2 st-bloc-sit-title">
                    <@liferay_ui.message key="eu.activity.arrangements" />
                </h2>
                <div class="st-limit-height st--is-overflowing">
                    ${entry.getArrangements(locale)}
                </div>
                <div class="st-show-more">
                    <button class="st-btn-show-more st-btn-arrow st--down"
                            aria-expanded="false"
                            data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                    </button>
                </div>
            </div>
        </div>
    </#if>
    <#if (entry.getPublics()?size !=0)>
        <div class="st-col">
            <div class="st-component-container st-text-styles">
                <h2 class="st-h2 st-bloc-sit-title">
                    <#if (entry.getPublics()?size==1)>
                        <@liferay_ui.message key="eu.activity.public" />
                    </#if>
                    <#if (entry.getPublics()?size> 1)>
                        <@liferay_ui.message key="eu.activity.publics" />
                    </#if>
                </h2>
                <div class="st-limit-height st--is-overflowing">
                    <ul>
                        <#list entry.getPublics() as public>
                            <li>
                                <p>
                                    ${public.getTitle(locale)}
                                </p>
                            </li>
                        </#list>
                    </ul>
                </div>
                <div class="st-show-more">
                    <button class="st-btn-show-more st-btn-arrow st--down"
                            aria-expanded="false"
                            data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                    </button>
                </div>
            </div>
        </div>
    </#if>
    <#if entry.getOrganizerName(locale)?has_content>
        <div class="st-col">
            <div class="st-component-container st-text-styles">
                <h2 class="st-h2 st-bloc-sit-title">
                    <@liferay_ui.message key="eu.activity.manager" />
                </h2>
                <div class="st-limit-height st--is-overflowing">
                    <a href="${homeURL}organisateur-activites/-/entity/id/${entry.organizerId}">
                        ${entry.getOrganizerName(locale)}
                    </a>
                </div>
                <div class="st-show-more">
                    <button class="st-btn-show-more st-btn-arrow st--down"
                            aria-expanded="false"
                            data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                    </button>
                </div>
            </div>
        </div>
    </#if>
</div>
<#assign documents=entry.getDocuments() />
<#if documents?has_content>
    <div class="st-bloc st-bloc-liens st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.useful-documents" />
        </h2>
        <div class="st-component-container">
            <ul class="st-liste st-limit-height">
                <#list documents?keys as title>
                    <li class="st-lien-container" data-num="${title?index}">
                        <a href="${documents[title]}" class="st-lien" download="" title="${title}">
                            <p class="st-title-lien">
                                ${title}
                            </p>
                            <div class="st-lien-content">
                                <p class="st-text">
                                    <@liferay_ui.message key="eu.download" />
                                </p>
                            </div>
                        </a>
                    </li>
                </#list>
            </ul>
            <div class="st-show-more">
                <button class="st-btn-show-more st-btn-arrow st--down"
                        aria-expanded="false"
                        data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                </button>
            </div>
        </div>
    </div>
</#if>
<#assign agenda=entry.getCourseAgenda(themeDisplay.scopeGroupId, locale) />
<#if agenda.periods?has_content>
    <div class="st-bloc st-bloc-sit-onglets st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.activity.places-and-schedules" />
        </h2>
        <div class="st-container">
            <div class="st-slider-tablist st-js-slider-tablist splide" role="tablist">
                <div class="splide__track">
                    <ul class="splide__list">
                        <#list agenda.periods as period>
                            <li class="splide__slide">
                                <button class="st-slider-tablist__button" id="tab-button-${period.periodId}" type="button" role="tab" aria-selected="true" aria-controls="tabpanel-${period.periodId}">
                                    <span class="st-title">${period.periodName}</span>
                                </button>

                            </li>
                        </#list>
                    </ul>
                </div>
                <div class="splide__arrows st-nav-arrows">
                    <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                    <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                </div>
            </div>
            <div class="st-tabpanels">
                        <#list agenda.periods as period>
                            <div class="st-tabpanel" id="tabpanel-${period.periodId}" role="tabpanel" tabindex="0" aria-labelledby="tab-button-${period.periodId}">
                                <#list period.places as periodPlace>
                                    <div class="st-detail-lien">
                                        <p class="st-title-medium">
                                            ${periodPlace.placeName}
                                        </p>
                                        <#if periodPlace.placeSigId?has_content>
                                            <a href="${homeURL}lieu/-/entity/sig/${periodPlace.placeSigId}/${uriHelper.normalizeToFriendlyUrl(periodPlace.placeName)}" class="st-btn st--btn-secondary-ghost st--btn-xs st--btn-small-padding">
                                                <@liferay_ui.message key="eu.activity.see-place-detail" />
                                            </a>
                                        </#if>
                                    </div>
                                    <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                                        <#list 0..6 as day>
                                            <#assign schedules=periodPlace.getSchedulesForDay(day) />
                                            <#if schedules?has_content>
                                                <li class="st-item-row">
                                                    <p class="st-title">
                                                        <@liferay_ui.message key="${periodPlace.getDayName(day)}" />
                                                    </p>
                                                    <div class="st-info st-u-color-secondary">
                                                        <#list schedules as schedule>
                                                            <div>
                                                                <p>
                                                                    ${schedule.startTime} - ${schedule.endTime}
                                                                    <#if schedule.getComments(locale)?has_content>
                                                                        *
                                                                    </#if>
                                                                </p>
                                                                <#if schedule.getComments(locale)?has_content>
                                                                    <p class="st-note">*${schedule.getComments(locale)}
                                                                    </p>
                                                                </#if>
                                                            </div>
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
<#else>
    <div class="st-bloc st-bloc-sit-onglets st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.activity.places-and-schedules" />
        </h2>
        <div class="st-container">
            <div class="st-tabpanel">
                <#list entry.getPlaceSIGIds(locale) as sigId>
                    <li class="st-detail-lien">
                        <p class="st-title-medium">
                            ${entry.getPlaceNames(locale)[sigId?index]}
                        </p>
                        <a href="${homeURL}lieu/-/entity/sig/${sigId}/${uriHelper.normalizeToFriendlyUrl(entry.getPlaceNames(locale)[sigId?index])}" class="st-btn st--btn-secondary-ghost st--btn-xs st--btn-small-padding">
                            <@liferay_ui.message key="eu.activity.see-place-detail" />
                        </a>
                    </li>
                </#list>
            </div>
        </div>
    </div>
</#if>