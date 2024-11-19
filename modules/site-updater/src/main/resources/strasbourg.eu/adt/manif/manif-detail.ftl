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
<#assign openGraph={ "og:title" :"${entry.getManifestationScheduleDisplay(locale)} -
        ${entry.getTitle(locale)?html}", "og:description" :'${entry.getDescription(locale)?replace("<[^>]
*>", "",
"r")?html}', "og:image" :"${imageUrl}"
} />

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
    </div>
    <div class="st-visual-container st-wrapper st-wrapper-small">
        <div class="st-top-bar">
            <div class="st-top-bar__left">
                <p class="st-date">
                    <#if entry.startDate?has_content && entry.endDate?has_content>
                        <#if entry.startDate?date==entry.endDate?date>
                            <@liferay_ui.message key="eu.event.the" />
                            ${entry.startDate?date?string.long}
                        <#else>
                            <@liferay_ui.message key="eu.event.from-date" />
                            ${entry.startDate?date?string.long}
                            <@liferay_ui.message key="eu.event.to" />
                            ${entry.endDate?date?string.long}
                        </#if>
                    </#if>
                </p>
            </div>
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
    </div>
</header>
<div class="st-content">
    <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">Présentation</h2>
        <div class="st-component-container st-text-styles">
            <div class="st-limit-height">
                ${entry.getDescription(locale)}
            </div>
            <div class="st-show-more">
                <button class="st-btn-show-more st-btn-arrow st--down"
                        aria-expanded="false"
                        data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                </button>
            </div>
        </div>
    </div>
    <div class="st-bloc st--has-margin">
        <div class="st-listing-cards st--listing-agenda st-wrapper st-wrapper-small">
            <div id="eventList" aria-busy="false" style="display: flex;flex-direction: column;align-items: center;">
                <div class="loading-animation st-hide" aria-hidden="true">
                    <div></div>
                </div>
                <#assign totalEvents=entry.getPublishedEvents() />
                <#assign events=entry.getPublishedEventsByDelta(0) />
                <input type="hidden" id="nb-total-events" value="${totalEvents?size}" />
                <input type="hidden" id="nb-events" value="${events?size}" />
                <ul id="events"  class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small" style="width: 100%;">
                    <#list events as event>
                        <li>
                            <div class="st-card-container">
                                <a class="st-card st-card-agenda st--card-horizontal st--with-gradient"
                                   href="${strasbourg.homeURL()}evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}"
                                >
                                    <div class="st-caption">
                                        <h3 class="st-title-card">
                                            ${event.getTitle(locale)}
                                        </h3>
                                        <p class="st-surtitre-cat">
                                            ${event.getTypeLabel(locale)}
                                        </p>
                                        <p class="st-date">
                                            <#if event.firstStartDate?has_content && event.lastEndDate?has_content>
                                                <#if event.firstStartDate?date==event.lastEndDate?date>
                                                    <@liferay_ui.message key="eu.event.the" />
                                                    ${event.firstStartDate?date?string.short?replace('/', '.')}
                                                <#else>
                                                    <@liferay_ui.message key="eu.event.from-date" />
                                                    ${event.firstStartDate?date?string.short?replace('/', '.')}
                                                    <@liferay_ui.message key="eu.event.to" />
                                                    ${event.lastEndDate?date?string.short?replace('/', '.')}
                                                </#if>
                                            </#if>
                                        </p>
                                        <p class="st-location">
                                            ${event.getPlaceAlias(locale)} - ${event.getPlaceCity(locale)}
                                        </p>
                                    </div>
                                    <div class="st-image">
                                        <#if event.getImageId() !=0>
                                            <@strasbourg.addImage fileEntryId=event.getImageId() maxWidth=100 showLegende=false showCopyright=false isFigure=true />
                                        <#else>
                                            <figure class="st-figure st-fit-cover" role="group">
                                                <img alt="" loading="lazy" src="${event.getImageThumbnailURL()}" />
                                            </figure>
                                        </#if>
                                    </div>
                                </a>
                                <@strasbourg.isFavourite entryId=event.assetEntry.classPK entryType=2  entityGroupId=0 title=event.getTitle(locale) />
                            </div>
                        </li>
                    </#list>
                </ul>
                <button type="button" id="see-more-event" class="st-btn" style="margin-top: 30px; display: ${(events?size lt totalEvents?size)?then("block","none")}" onclick="addEvents()">
                    <@liferay_ui.message key="eu.strasbourg.see-more" />
                </button>
            </div>
        </div>
    </div>
    <div class="st-bloc st-bloc-infos-complementaires st--two-columns st-wrapper st-wrapper-small ">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.practical-information" />
        </h2>
        <div class="st-container">
            <#if entry.externalURL?has_content>
                <div class="st-component st-component-type-3">
                    <div class="st-component-container st-text-styles">
                        <h3 class="st-title-small">
                            <@liferay_ui.message key="eu.see-also" />
                        </h3>
                        <a href="${entry.externalURL}"
                           target="_blank">
                            ${entry.externalURL}
                        </a>
                    </div>
                </div>
            </#if>
        </div>
    </div>
</div>
<#macro barreAgenda>
    <div class="st-barre-single-sit st--agenda">
        <div class="st-barre-inner st-wrapper">
            <div class="st-container-left">
                <div class="st-content">
                    <p class="st-date">
                        <#if entry.startDate?has_content && entry.endDate?has_content>
                            <#if entry.startDate?date==entry.endDate?date>
                                <@liferay_ui.message key="eu.event.the" />
                                ${entry.startDate?date?string.short}
                            <#else>
                                <@liferay_ui.message key="eu.event.from-date" />
                                ${entry.startDate?date?string.short}
                                <@liferay_ui.message key="eu.event.to" />
                                ${entry.endDate?date?string.short}
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
                    <#if entry.externalURL?has_content>
                        <li>
                            <a href="${entry.externalURL}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener"
                               title="<@liferay_ui.message key="eu.web-site" />">
                                <span class="st-icon-web" aria-hidden="true"></span>
                                <span class="st-sr-only"><@liferay_ui.message key="eu.web-site" /></span>
                            </a>
                        </li>
                    </#if>
                </ul>
                <@strasbourg.isFavouriteSticky entryId=entry.getManifestationId() entryType=12 title=entry.getTitle(locale) url=themeDisplay.getPortalURL() />
                <@strasbourg.socialShare />
            </div>
        </div>
    </div>
</#macro>
<script>
    var manifestationId = ${entry.manifestationId};
    var homeURL = '${strasbourg.homeURL()}';
    var language = '${locale}';
    var userFavorites = {'eventIds':[]};
    <#if request.session.getAttribute("publik_logged_in")!false>
        <#assign favoriteLocalService = serviceLocator.findService("eu.strasbourg.service.favorite.service.FavoriteLocalService") />
        <#assign favorites = favoriteLocalService.getEventsFavoriteByUser(request.session.getAttribute("publik_internal_id")) />
        userFavorites = ${favorites};
    </#if>

    addEvents = function () {
        // Add the "loading" class when the request is loading
        document.querySelector('#eventList .loading-animation')?.classList.remove('st-hide');
        // update aria-busy to true
        document.querySelector('#eventList').setAttribute("aria-busy", "true");
        var start = document.getElementById('nb-events').value;
        Liferay.Service(
            '/agenda.event/get-events-by-manifestation-with-limit', {
                manifestationId: manifestationId,
                start: start,
                delta: 20,
                language: language
            },
            function(json) {
                addEventList(json);
                // Remove the "loading" class when the request is complete
                document.querySelector('#eventList .loading-animation')?.classList.add('st-hide');
                // update aria-busy to false
                document.querySelector('#eventList').setAttribute("aria-busy", "false");
            }
        );
    }

    function addEventList(json) {
        var resultList = document.getElementById('events');
        var totalResult = document.getElementById('nb-total-events').value;
        var seeMore = document.getElementById('see-more-event');
        json.events.forEach(function (event) {
            var vignette = createEventThumbnail(event);
            if(vignette != undefined) {
                resultList.insertAdjacentHTML('beforeend', vignette);
            }
        });
        var nbResults = Number(document.getElementById('nb-events').value) + json.events.length;
        document.getElementById('nb-events').value = nbResults;
        if(totalResult > nbResults) {
            seeMore.style.display = "block";
        }else {
            seeMore.style.display = "none"
        }
    }

    function createEventThumbnail(event) {
        var isFavorite = userFavorites.eventIds.includes(Number(event.id));
        vignette =
        "<li>" +
            "<div class='st-card-container'>" +
                "<a href='" + event.eventURL + "' class='st-card st-card-agenda st--card-horizontal st--with-gradient'>" +
                    "<div class='st-caption'>" +
                        "<h3 class='st-title-card'>" +
                            event.title +
                        "</h3>" +
                        "<p class='st-surtitre-cat'>" +
                            event.type +
                        "</p>" +
                        "<p class='st-date'>" +
                            event.date +
                        "</p>" +
                        "<p class='st-location'>" +
                            event.alias + " - " + event.city +
                        "</p>" +
                    "</div>" +
                    "<div class='st-image'>" +
                        "<figure class='st-figure st-fit-cover' role='group'>" +
                            "<img alt='' loading='lazy' src='"+event.imageURL+"' />" +
                        "</figure>" +
                    "</div>" +
                "</a>" +
                "<button class='st-btn-favorite-card "+(isFavorite?"st-is-favorite":"")+"' " +
                    "data-groupid='0' " +
                    "data-title='"+event.title + "' " +
                    "data-id='"+event.id+"' " +
                    "data-type='2' " +
                    "aria-pressed='false'>" +
                    (isFavorite?Liferay.Language.get("eu.remove-from-favorite"):Liferay.Language.get("eu.add-to-favorite")) +
                "</button>" +
            "</div>" +
        "</li>";

        return vignette;
    }
    </script>