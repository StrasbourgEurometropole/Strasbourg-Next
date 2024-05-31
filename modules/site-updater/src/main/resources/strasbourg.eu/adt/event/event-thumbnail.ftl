<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>

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
                    <h3 class="st-title-small"><@liferay_ui.message key="eu.next-dates" /></h3>
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
        <a href="#" role="button" aria-haspopup="dialog" aria-controls="st-overlay-preview-agenda" class="st-card st-card-agenda st--card-horizontal st--with-gradient" onclick="updateDescription(this)" onkeydown="simulateClick(event)" data-overlay-open="st-overlay-preview-agenda" data-classpk="${entry.assetEntry.classPK}"
           <#if entry.bookingURL?has_content>data-bookingURL="${entry.bookingURL}"</#if>
           data-date="<#if entry.firstStartDate?has_content && entry.lastEndDate?has_content>
                        <#if entry.firstStartDate?date==entry.lastEndDate?date>
                            <@liferay_ui.message key="eu.event.the" /> ${entry.firstStartDate?date?string.short?replace('/', '.')}
                        <#else>
                            <@liferay_ui.message key="eu.event.from-date" /> ${entry.firstStartDate?date?string.short?replace('/', '.')} <@liferay_ui.message key="eu.event.to" /> ${entry.lastEndDate?date?string.short?replace('/', '.')}
                        </#if></#if>"
           data-address="${entry.getPlaceAddress(locale)}"
           data-detailurl="${strasbourg.homeURL()}evenement/-/entity/id/${entry.eventId}/${entry.getNormalizedTitle(locale)}"
        >
            <div class="st-caption">
                <h3 class="st-title-card">
                    ${entry.getTitle(locale)}
                </h3>
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
                    <@strasbourg.addImage fileEntryId=entry.getImageId() maxWidth=100 showLegende=false showCopyright=false isFigure=true />
                <#else>
                    <figure class="st-figure st-fit-cover" role="group">
                        <img alt="" loading="lazy" src="${entry.getImageURL()}" />
                    </figure>
                </#if>
            </div>
        </a>
        <@strasbourg.isFavourite entryId=entry.assetEntry.classPK entryType=2  entityGroupId=0 title=entry.getTitle(locale) url=detailURLFilter />
    </div>
</li>