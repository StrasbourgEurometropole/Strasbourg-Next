<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
<!-- Vignette événement -->
<#if isFeatured>
    <#assign cssClass='coup-de-coeur' />
<#else>
    <#assign cssClass='' />
</#if>
<li>
    <div class="st-card-container ${cssClass}">
        <div class="st-description st-hide">
            <div class="st-bloc-infos-complementaires">
                <div class="st-component-container mb-4 pb-3">
                    <p class="st-title-small"><@liferay_ui.message key="eu.next-dates" /></p>
                    <ul>
                        <#list entry.currentAndFuturePeriods as period>
                            <li>
                                ${period.getDisplay(locale)}<#if period.getTimeDetail(locale)?has_content> : ${period.getTimeDetail(locale)}</#if>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>

            ${entry.getDescription(locale)}
        </div>
        <a href="#" class="st-card st-card-agenda st--card-horizontal st--with-gradient" onclick="updateDescription(this)" data-overlay-open="st-overlay-preview-agenda" data-classpk="${entry.assetEntry.classPK}"
           <#if entry.bookingURL?has_content>data-bookingURL="${entry.bookingURL}"</#if>
           data-date="<#if entry.firstStartDate?has_content && entry.lastEndDate?has_content>
                        <#if entry.firstStartDate?date==entry.lastEndDate?date>
                            <@liferay_ui.message key="eu.event.the" /> ${entry.firstStartDate?date?string.short?replace('/', '.')}
                        <#else>
                            <@liferay_ui.message key="eu.event.from-date" /> ${entry.firstStartDate?date?string.short?replace('/', '.')} <@liferay_ui.message key="eu.event.to" /> ${entry.lastEndDate?date?string.short?replace('/', '.')}
                        </#if></#if>"
           data-address="${entry.getPlaceAddress(locale)}"
           data-detailurl="${homeURL}evenement/-/entity/id/${entry.eventId}/${entry.getNormalizedTitle(locale)}"
        >
            <div class="st-caption">
                <p class="st-title-card">
                    ${entry.getTitle(locale)}
                </p>
                <p class="st-surtitre-cat">
                    ${entry.getTypeLabel(locale)}
                </p>
                <p class="st-date">
                    <#if entry.firstStartDate?has_content && entry.lastEndDate?has_content>
                        <#if entry.firstStartDate?date==entry.lastEndDate?date>
                            <@liferay_ui.message key="eu.event.the" />
                            ${entry.firstStartDate?date?string.short?replace('/', '.')}
                        <#else>
                            <@liferay_ui.message key="eu.event.from-date" />
                            ${entry.firstStartDate?date?string.short?replace('/', '.')}
                            <@liferay_ui.message key="eu.event.to" />
                            ${entry.lastEndDate?date?string.short?replace('/', '.')}
                        </#if>
                    </#if>
                </p>
                <p class="st-location">
                    ${entry.getPlaceAlias(locale)} - ${entry.getPlaceCity(locale)}
                </p>
            </div>
            <div class="st-image">
                <#if entry.getImageId() !=0>
                    <@addImage fileEntryId=entry.getImageId() isFigure=true />
                <#else>
                    <figure class="st-figure st-fit-cover" role="group">
                        <img src="${entry.getImageURL()}" />
                    </figure>
                </#if>
            </div>
        </a>
        <@isFavourite entryId=entry.assetEntry.classPK entryType=2  entityGroupId=0 title=entry.getTitle(locale) url=detailURLFilter />
    </div>
</li>