<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
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
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<@barreAgenda />
<header class="st-header-fiche-agenda" role="banner" aria-label="Entête de la fiche agenda">
    <div class="st-wrapper st-wrapper-small">
        <p class="st-surtitre-cat st-hide-until@t-portrait">
            ${entry.getTypeLabel(locale)}
        </p>
        <h1 class="st-h1 st-hide-until@t-portrait">
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
                <p class="st-schedule">De 18h00 à 20h00 (WIP)</p>
                <p class="st-location">
                    ${entry.getPlaceAlias(locale)}
                    <br>
                    ${entry.getPlaceAddress(locale)} -
                    ${entry.placeZipCode} ${entry.getPlaceCity(locale)}
                </p>
            </div>
            <#if (entry.placeId> 0)>
                <div class="st-top-bar__right">
                    <a href="${homeURL}lieu/-/entity/id/${entry.placeId}/${uriHelper.normalizeToFriendlyUrl(entry.getPlaceAlias(locale))}"
                       class="st-btn st--btn-full-width-mobile">
                        <@liferay_ui.message key="eu.event.see-place" />
                    </a>
                </div>
            </#if>
        </div>
        <#if entry.imageURL?has_content>
            <div class="st-image">
                <#if entry.getImageId() !=0>
                    <@addImage fileEntryId=entry.getImageId() isFigure=true />
                <#else>
                    <figure class="st-figure st-fit-cover" role="group">
                        <img src="${entry.getImageURL()}" />
                    </figure>
                </#if>
            </div>
        </#if>
        <div class="st-maps" data-lat="${ entry.getMercatorY() }" data-lng="${ entry.getMercatorX() }" data-zoom="17" data-callback="initMap">

        </div>
    </div>
</header>
<div class="st-content">
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
                                        href="${homeURL}manifestation/-/entity/id/${manifestation.manifestationId}">
                                    ${manifestation.getTitle(locale)}
                                </a>
                            </#list>
                        </strong>
                    </p>
                </#if>
            </div>
            <div class="st-show-more">
                <button class="st-btn-show-more st-btn-arrow st--down" aria-expanded="false"
                        aria-controls="123" aria-label="Voir tout le texte" data-open-label="Voir tout le texte"
                        data-close-label="Réduire l'affichage du texte">
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
                        <p class="st-title-small">
                            <@liferay_ui.message key="eu.prices" />
                        </p>
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
                        <p class="st-title-small">
                            <@liferay_ui.message key="eu.registration" />
                        </p>
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
                        <p class="st-title-small">
                            <@liferay_ui.message key="eu.ticket-office" />
                        </p>
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
                        <p class="st-title-small">
                            <@liferay_ui.message key="eu.see-also" />
                        </p>
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
                        <p class="st-title-small">
                            <@liferay_ui.message key="contact" />
                        </p>
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
                        <p class="st-title-small">
                            <@liferay_ui.message key="eu.access" />
                        </p>
                        ${entry.getAccess(locale)}
                    </div>
                </div>
            </#if>
            <#if entry.hasAnyAccessForDisabled() || entry.getAccessForDisabled(locale)?has_content>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <p class="st-title-small">
                            <@liferay_ui.message key="eu.access-for-disabled" />
                        </p>
                        <ul class="st-liste-icons">
                            <#if entry.accessForWheelchair>
                                <li>
                                            <span class="st-icon-handicap" aria-hidden="true"
                                                  aria-label="<@liferay_ui.message key='eu.access-for-wheelchair' />"
                                                  title="<@liferay_ui.message key='eu.access-for-wheelchair' />"></span>
                                </li>
                            </#if>
                            <#if entry.accessForDeaf>
                                <li>
                                            <span class="st-icon-handicap" aria-hidden="true"
                                                  aria-label="<@liferay_ui.message key='eu.access-for-deaf' />"
                                                  title="<@liferay_ui.message key='eu.access-for-deaf' />"></span>
                                </li>
                            </#if>
                            <#if entry.accessForBlind>
                                <li>
                                            <span class="st-icon-handicap-vision" aria-hidden="true"
                                                  aria-label="<@liferay_ui.message key='eu.access-for-blind' />"
                                                  title="<@liferay_ui.message key='eu.access-for-blind' />"></span>
                                </li>
                            </#if>
                            <#if entry.accessForDeficient>
                                <li>
                                            <span class="st-icon-handicap" aria-hidden="true"
                                                  aria-label="<@liferay_ui.message key='eu.access-for-deficient' />"
                                                  title="<@liferay_ui.message key='eu.access-for-deficient' />"></span>
                                </li>
                            </#if>
                            <#if entry.accessForElder>
                                <li>
                                            <span class="st-icon-personnes-agees" aria-hidden="true"
                                                  aria-label="<@liferay_ui.message key='eu.access-for-elder' />"
                                                  title="<@liferay_ui.message key='eu.access-for-elder' />"></span>
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
        <@liferay_portlet.param name="to" value="${entry.email}" />
        <@liferay_portlet.param name="title" value="${entry.getTitle(locale)}" />
        <@liferay_portlet.param name="type" value="Event" />
    </@liferay_portlet.actionURL>
    <#assign overlayContactTitle=entry.getTitle(locale) />
    <#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/overlay-contact.ftl" />
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
                            </a>
                        </li>
                    </#if>
                    <#if entry.email?has_content>
                        <li>
                            <button class="st-btn-icon st-btn-icon--white"
                                    data-overlay-open="st-overlay-contact" aria-label="Nous contacter par mail">
                                <span class="st-icon-email" aria-hidden="true"></span>
                            </button>
                        </li>
                    </#if>
                    <#if entry.getWebsiteName(locale)?has_content && entry.getWebsiteURL(locale)?has_content>
                        <li>
                            <a href="${entry.getWebsiteURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                               title="Ouvrir le lien (nouvelle fenêtre)">
                                <span class="st-icon-web" aria-hidden="true"></span>
                            </a>
                        </li>
                    </#if>
                    <#if entry.bookingURL?has_content || entry.getBookingDescription(locale)?has_content>
                        <li>
                            <a href="${entry.bookingURL}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                               title="Ouvrir le lien (nouvelle fenêtre)">
                                <span class="st-icon-ticket" aria-hidden="true"></span>
                            </a>
                        </li>
                    </#if>
                </ul>
                <button class="st-btn-favorite-sticky">
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
</#macro>