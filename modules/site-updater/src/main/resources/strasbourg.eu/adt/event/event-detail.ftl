<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>

<#assign uriHelper=serviceLocator.findService("eu.strasbourg.utils.api.UriHelperService") />
<#assign imageUrl="" />
<!-- vignette -->
<#if entry.imageURL?has_content>
    <#if !entry.imageURL?contains('http')>
        <#assign imageUrl=themeDisplay.getPortalURL() />
    </#if>
    <#assign imageUrl=imageUrl + entry.imageURL?replace('@', "" )?replace('cdn_hostroot_path', "" ) />
</#if>
<#-- Liste des infos a partager -->
<#assign openGraph={ "og:title" :"${entry.getEventScheduleDisplay(locale)} -
        ${entry.getTitle(locale)?html}", "og:description" :'${entry.getDescription(locale)?replace("<[^>]
*>", "",
"r")?html}', "og:image" :"${imageUrl}"
} />

<@liferay_util["html-bottom"]>
    <script src="/o/strasbourg-theme/js/libs/leaflet.js"></script>
</@>

<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<@barreAgenda />
<header class="st-header-fiche-agenda">
    <div class="st-wrapper st-wrapper-small">
        <p class="st-surtitre-cat st-hide-until@t-portrait">
            ${entry.getTypeLabel(locale)}
        </p>
        <h1 class="st-h1">
            ${entry.getTitle(locale)}
        </h1>
        <@liferay.breadcrumbs />
        <p class="st-title-secondary st-h3">
            ${entry.getSubtitle(locale)}
        </p>
    </div>
    <div class="st-visual-container st-wrapper st-wrapper-small">
        <div class="st-top-bar">
            <div class="st-top-bar__left">
                <p class="st-date">
                    <#if entry.firstStartDate?has_content && entry.lastEndDate?has_content>
                        <#if entry.firstStartDate?date==entry.lastEndDate?date>
                            <@liferay_ui.message key="eu.event.the" />
                            ${entry.firstStartDate?date?string.long}
                        <#else>
                            <@liferay_ui.message key="eu.event.from-date" />
                            ${entry.firstStartDate?date?string.long}
                            <@liferay_ui.message key="eu.event.to" />
                            ${entry.lastEndDate?date?string.long}
                        </#if>
                    </#if>
                </p>
                <p class="st-location">
                    ${entry.getPlaceAlias(locale)}
                    <br>
                    ${entry.getPlaceAddress(locale)} -
                    ${entry.placeZipCode} ${entry.getPlaceCity(locale)}
                </p>
            </div>
            <#if (entry.placeId> 0)>
                <div class="st-top-bar__right">
                    <a href="${strasbourg.homeURL()}lieu/-/entity/id/${entry.placeId}/${uriHelper.normalizeToFriendlyUrl(entry.getPlaceAlias(locale))}"
                       class="st-btn st--btn-full-width-mobile">
                        <@liferay_ui.message key="eu.event.see-place" />
                    </a>
                </div>
            </#if>
        </div>
        <#if entry.imageURL?has_content>
            <div class="st-image">
                <#if entry.getImageId() !=0>
                    <@strasbourg.addImage fileEntryId=entry.getImageId() maxWidth=307 isFigure=true />
                <#else>
                    <figure class="st-figure st-fit-cover" role="group" aria-label=" © ${entry.getExternalImageCopyright()}">
                        <picture>
                        <img src="${entry.getImageURL()}" alt="" />
                        </picture>
                        <figcaption>
                            <#if entry.getExternalImageCopyright()?has_content &&  entry.getExternalImageCopyright() != "n/a">
                                <button type="button" class="st-credits st-js-credits" aria-expanded="false" aria-label="© (copyright de l'image)">©</button>
                                <span class="st-credits-content">© ${entry.getExternalImageCopyright()}</span>
                            </#if>
                        </figcaption>
                    </figure>
                </#if>
            </div>
        </#if>
        <div class="st-wrapper-maps">
            <a href="#skip-map-cover" class="st-btn st--btn-xs st-skip-map st-sr-only st-sr-only-focusable">Passer la carte interactive</a>
            <div class="st-maps" role="region" aria-label="Carte interactive" data-lat="${ entry.getMercatorY() }" data-lng="${ entry.getMercatorX() }" data-zoom="17" data-callback="initMap">
            </div>
            <div id="skip-map-cover"></div>
        </div>
    </div>
</header>
<div class="st-content">
    <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title"><@liferay_ui.message key="eu.next-dates" /></h2>
        <div class="st-component-container st-text-styles">
            <div class="st-limit-height st--is-overflowing">
                <ul>
                    <#list entry.currentAndFuturePeriods as period>
                        <li>
                            ${period.getDisplay(locale)}<#if period.getTimeDetail(locale)?has_content> : ${period.getTimeDetail(locale)}</#if>
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
    <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">Présentation</h2>
        <div class="st-component-container st-text-styles">
            <div class="st-limit-height">
                ${entry.getDescription(locale)}
                <#if entry.promoter?has_content>
                    <p>
                        <strong>
                            <@liferay_ui.message key="eu.organized-by" /> : ${entry.promoter}
                        </strong>
                    </p>
                </#if>
                <#if entry.publishedManifestations?has_content>
                    <p>
                        <strong>
                            <@liferay_ui.message key="eu.this-event-is-part-of" />
                            <#list entry.getPublishedManifestations() as manifestation>
                                <#if (manifestation?index> 0)>
                                    -
                                </#if>
                                <a
                                        href="${strasbourg.homeURL()}manifestation/-/entity/id/${manifestation.manifestationId}">
                                    ${manifestation.getTitle(locale)}
                                </a>
                            </#list>
                        </strong>
                    </p>
                </#if>
            </div>
            <div class="st-show-more">
                <button class="st-btn-show-more st-btn-arrow st--down"
                        aria-expanded="false"
                        data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                </button>
            </div>
        </div>
    </div>
    <div class="st-bloc st-bloc-infos-complementaires st--two-columns st-wrapper st-wrapper-small ">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.practical-information" />
        </h2>
        <div class="st-container">
            <#if entry.free==1 || entry.getPrice(locale)?has_content>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <h3 class="st-title-small">
                            <@liferay_ui.message key="eu.prices" />
                        </h3>
                        <#if entry.free==1>
                            <div class="free-event">
                                <@liferay_ui.message key="eu.free-event" />
                            </div>
                        </#if>
                        ${entry.getPrice(locale)}
                    </div>
                </div>
            </#if>
            <#if entry.registration>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <h3 class="st-title-small">
                            <@liferay_ui.message key="eu.registration" />
                        </h3>
                        <p>
                            <@liferay_ui.message key="eu.registration.from" />
                            ${entry.registrationStartDate?date?string.long?replace('.', '')}
                        </p>
                        <p>
                            <@liferay_ui.message key="eu.registration.to" />
                            ${entry.registrationEndDate?date?string.long?replace('.', '')}
                        </p>
                    </div>
                </div>
            </#if>
            <#if entry.bookingURL?has_content || entry.getBookingDescription(locale)?has_content>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <h3 class="st-title-small">
                            <@liferay_ui.message key="eu.ticket-office" />
                        </h3>
                        <#if entry.getBookingDescription(locale)?has_content>
                            <p>
                                ${entry.getBookingDescription(locale)}
                            </p>
                        </#if>
                        <#if entry.bookingURL?has_content>
                            <a href="${entry.bookingURL}" target="_blank">
                                <@liferay_ui.message key="eu.book" />
                            </a>
                        </#if>
                    </div>
                </div>
            </#if>
            <#if entry.getWebsiteName(locale)?has_content && entry.getWebsiteURL(locale)?has_content>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <h3 class="st-title-small">
                            <@liferay_ui.message key="eu.see-also" />
                        </h3>
                        <a href="${entry.getWebsiteURL(locale)}"
                           target="_blank">
                            ${entry.getWebsiteName(locale)}
                        </a>
                    </div>
                </div>
            </#if>
            <#if entry.phone?has_content || entry.email?has_content>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <h3 class="st-title-small">
                            <@liferay_ui.message key="contact" />
                        </h3>
                        <ul class="st-liens">
                            <li class="st-lien-container">
                                <#if entry.phone?has_content>
                                    <a href="#" class="st-btn st--btn-secondary st--btn-small-padding">
                                        ${entry.phone}
                                    </a>
                                </#if>
                                <#if entry.email?has_content>
                                    <a data-overlay-open="st-overlay-contact" href="#"
                                       class="st-btn st--btn-secondary st--btn-small-padding">
                                        <@liferay_ui.message key="eu.contact-mail" />
                                    </a>
                                </#if>
                            </li>
                        </ul>
                    </div>
                </div>
            </#if>
            <#if entry.getAccess(locale)?has_content>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <h3 class="st-title-small">
                            <@liferay_ui.message key="eu.access" />
                        </h3>
                        ${entry.getAccess(locale)}
                    </div>
                </div>
            </#if>
            <#if entry.hasAnyAccessForDisabled() || entry.getAccessForDisabled(locale)?has_content>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <h3 class="st-title-small">
                            <@liferay_ui.message key="eu.access-for-disabled" />
                        </h3>
                        <ul class="st-liste-icons">
                            <#if entry.accessForWheelchair>
                                <li>
                                    <span class="st-icon-handicap" aria-hidden="true" title="<@liferay_ui.message key='eu.access-for-wheelchair' />"></span>
                                    <span class="st-sr-only"><@liferay_ui.message key='eu.access-for-wheelchair' /></span>
                                </li>
                            </#if>
                            <#if entry.accessForDeaf>
                                <li>
                                            <span class="st-icon-handicap" aria-hidden="true"
                                                  title="<@liferay_ui.message key='eu.access-for-deaf' />"></span>
                                    <span class="st-sr-only"><@liferay_ui.message key='eu.access-for-deaf' /></span>
                                </li>
                            </#if>
                            <#if entry.accessForBlind>
                                <li>
                                            <span class="st-icon-handicap-vision" aria-hidden="true"
                                                  title="<@liferay_ui.message key='eu.access-for-blind' />"></span>
                                    <span class="st-sr-only"><@liferay_ui.message key='eu.access-for-blind' /></span>
                                </li>
                            </#if>
                            <#if entry.accessForDeficient>
                                <li>
                                            <span class="st-icon-handicap" aria-hidden="true"
                                                  title="<@liferay_ui.message key='eu.access-for-deficient' />"></span>
                                    <span class="st-sr-only"><@liferay_ui.message key='eu.access-for-deficient' /></span>
                                </li>
                            </#if>
                            <#if entry.accessForElder>
                                <li>
                                            <span class="st-icon-personnes-agees" aria-hidden="true"
                                                  title="<@liferay_ui.message key='eu.access-for-elder' />"></span>
                                    <span class="st-sr-only"><@liferay_ui.message key='eu.access-for-elder' /></span>
                                </li>
                            </#if>
                        </ul>
                        ${entry.getAccessForDisabled(locale)}
                    </div>
                </div>
            </#if>
        </div>
    </div>
</div>
<#if entry.email?has_content>
    <@liferay_portlet.actionURL var="contactURL" name="contact">
        <@liferay_portlet.param name="classPK" value="${entry.getEventId()}" />
        <@liferay_portlet.param name="entityId" value="${entry.getEventId()}" />
        <@liferay_portlet.param name="title" value="${entry.getTitle(locale)}" />
        <@liferay_portlet.param name="type" value="Event" />
    </@liferay_portlet.actionURL>
    <#assign overlayContactTitle=entry.getTitle(locale) />
    <@strasbourg.overlayContact entry=entry entryType="Event" />
</#if>
<#macro barreAgenda>
    <div class="st-barre-single-sit st--agenda">
        <div class="st-barre-inner st-wrapper">
            <div class="st-container-left">
                <div class="st-content">
                    <p class="st-date">
                        <#if entry.firstStartDate?has_content && entry.lastEndDate?has_content>
                            <#if entry.firstStartDate?date==entry.lastEndDate?date>
                                <@liferay_ui.message key="eu.event.the" />
                                ${entry.firstStartDate?date?string.short}
                            <#else>
                                <@liferay_ui.message key="eu.event.from-date" />
                                ${entry.firstStartDate?date?string.short}
                                <@liferay_ui.message key="eu.event.to" />
                                ${entry.lastEndDate?date?string.short}
                            </#if>
                        </#if>
                    </p>
                    <p class="st-surtitre-cat">
                        ${entry.getTypeLabel(locale)}
                    </p>
                    <p class="st-title">
                        ${entry.getTitle(locale)}
                    </p>
                </div>
            </div>
            <div class="st-container-right">
                <ul class="st-liens-rapides">
                    <#if entry.phone?has_content>
                        <li>
                            <a href="tel:${entry.phone}" class="st-btn-icon st-btn-icon--white" target="_blank"
                               rel="noopener" title="Appeler le numéro : ${entry.phone}">
                                <span class="st-icon-phone" aria-hidden="true"></span>
                                <span class="st-sr-only">Appeler le numéro : ${entry.phone}</span>
                            </a>
                        </li>
                    </#if>
                    <#if entry.email?has_content>
                        <li>
                            <button class="st-btn-icon st-btn-icon--white" data-overlay-open="st-overlay-contact" aria-label="Formulaire de contact" aria-haspopup="dialog">
                                <span class="st-icon-email" aria-hidden="true"></span>
                            </button>
                        </li>
                    </#if>
                    <#if entry.getWebsiteName(locale)?has_content && entry.getWebsiteURL(locale)?has_content>
                        <li>
                            <a href="${entry.getWebsiteURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                               title="Site Web">
                                <span class="st-icon-web" aria-hidden="true"></span>
                                <span class="st-sr-only">Site web</span>
                            </a>
                        </li>
                    </#if>
                    <#if entry.bookingURL?has_content || entry.getBookingDescription(locale)?has_content>
                        <li>
                            <a href="${entry.bookingURL}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                               title="Billeterie">
                                <span class="st-icon-ticket" aria-hidden="true"></span>
                                <span class="st-sr-only">Billeterie</span>
                            </a>
                        </li>
                    </#if>
                </ul>
                <@strasbourg.isFavouriteSticky entryId=entry.getEventId() entryType=2 title=entry.getTitle(locale) url=themeDisplay.getPortalURL() />
                <@strasbourg.socialShare />
            </div>
        </div>
    </div>
</#macro>