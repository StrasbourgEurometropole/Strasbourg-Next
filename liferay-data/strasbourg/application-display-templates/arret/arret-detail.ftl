<!-- Détail arret -->
<#setting locale = locale />

<script>
    title = '${entry.title?html?js_string}';
</script>

<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<#assign fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />


<header class="st-header-fiche-lieu">
    <div class="st-wrapper st-wrapper-small">
        <h1 class="st-h1">
            ${entry.typeText} - ${entry.title}
        </h1>
        <@liferay.breadcrumbs />
        <div class="st-text-styles">
            <!-- Ancre vers la zone d'alerte -->
            <#assign alerts = entry.alertsActives />
            <#if alerts?size != 0>
                <a href="#alert" class="ancrage-alerte" title="<@liferay_ui.message key='eu.see-perturbation' />">
                    <@liferay_ui.message key="eu.see-perturbation" />
                </a>
            </#if>
        </div>

    </div>
    <div class="st-visual-container st-wrapper st-wrapper-small">
        <div class="st-top-bar">
            <div class="st-top-bar__left">
                <p class="st-h3"><@liferay_ui.message key="eu.arret.code" /> ${entry.code}</p>
                <p class="st-small-text"><@liferay_ui.message key="eu.arret.info" /></p>
            </div>
            <div class="st-top-bar__right st-hide-until@t-portrait"><a href="https://www.cts-strasbourg.eu/${locale?keep_before('_')}" class="st-btn st--btn-full-width-mobile"><@liferay_ui.message key="eu.arret.cts.website" /></a>
            </div>
        </div>
        <div class="st-cover-container">
            <div class="st-wrapper-maps">
                <a href="#skip-map-cover" class="st-btn st--btn-xs st-skip-map st-sr-only st-sr-only-focusable">Passer la carte interactive</a>
                <div class="st-maps" role="region" aria-label="Carte interactive" data-lat="${ entry.getLatitude() }" data-lng="${ entry.getLongitude() }" data-zoom="17" data-callback="initMap">
                </div>
                <div id="skip-map-cover"></div>
            </div>
        </div>

    </div>
</header>
<div class="st-bloc st-bloc-sit-onglets st-wrapper st-wrapper-small st--has-margin">
    <h2 class="st-h2 st-bloc-sit-title"><@liferay_ui.message key="eu.arret.next-bus-stop" /></h2>
    <div class="st-container st-arret-container">
        <div class="st-tabpanel st-component-container">
            <ul class="st-list-rows st-basic-grid st-limit-height">
                <#if entry.code == "999">
                    <li><@liferay_ui.message key="eu.no-real-time-for-stop" /></li>
                </#if>
                <#if entry.code != "999">
                    <#assign arretRealTime = entry.arretRealTime/>
                    <#if arretRealTime?size == 0>
                        <li><@liferay_ui.message key="eu.no-visit-found" /></li>
                    </#if>
                    <#if arretRealTime?size != 0>
                        <#assign ligneService = serviceLocator.findService("eu.strasbourg.service.gtfs.service.LigneService") />
                        <#assign ligneColors = ligneService.getLigneColorsFreemarker() />
                        <#list arretRealTime as realTime>
                            <#if realTime?counter gt 12>
                                <#break>
                            </#if>
                            <#if ligneColors[realTime.MonitoredVehicleJourney.LineRef]??>
                                <#assign colors = ligneColors[realTime.MonitoredVehicleJourney.LineRef] />
                            </#if>
                            <#if !ligneColors[realTime.MonitoredVehicleJourney.LineRef]??>
                                <#assign colors = "" />
                            </#if>
                            <#assign backgroundColor = (colors?has_content && colors[0]?has_content)?then(colors[0],"eeeeee") />
                            <#assign textColor = (colors?has_content && colors[1]?has_content)?then(colors[1],"000000") />
                            <li class="st-item-row st-arret">
                                <span class="transport-letters-icon" style="background:#${backgroundColor}; color:#${textColor};">${realTime.MonitoredVehicleJourney.PublishedLineName}</span>
                                <p class="st-title" style="flex: 1;">${realTime.MonitoredVehicleJourney.DestinationName}</p>
                                <div class="st-info st-u-color-secondary">
                                    <strong>${realTime.MonitoredVehicleJourney.MonitoredCall.ExpectedDepartureTime?datetime.xs?string["HH:mm"]}</strong>
                                </div>
                            </li>

                        </#list>
                    </#if>
                </#if>

            </ul>
            <div class="st-show-more">
                <button class="st-btn-show-more st-btn-arrow st--down"
                        aria-expanded="false"
                        data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                </button>
            </div>
        </div>
    </div>

</div>
<!-- Alertes -->
<#if alerts?size != 0>
<div class="st-bloc st-bloc-infos-complementaires st--two-columns st-wrapper st-wrapper-small " id="alert">

    <h2 class="st-h2 st-bloc-sit-title"><@liferay_ui.message key="eu.arret.alert" /></h2>

    <div class="st-container">
        <#list alerts as alert>
        <div class="st-component st-component-type-3">
            <div class="st-component-container">
                <h3 class="st-title-small">
                    <#if alert.startDate?date == alert.endDate?date>
                        <@liferay_ui.message key="eu.event.the" /> ${alert.startDate?date?string.short?replace('/', '.')}
                    <#else>
                        <@liferay_ui.message key="eu.event.from-date" /> ${alert.startDate?date?string.short?replace('/', '.')} <@liferay_ui.message key="eu.event.to" /> ${alert.endDate?date?string.short?replace('/', '.')}
                    </#if>
                </h3>
                <h4 class="st-title-medium">${alert.getLigneAndDirection(locale)}</h4>
                <p>${alert.getPerturbation(locale)}</p>
            </div>
        </div>
        </#list>
    </div>

</div>
</#if>