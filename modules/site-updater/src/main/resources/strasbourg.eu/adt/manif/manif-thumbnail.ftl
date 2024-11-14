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
            ${entry.getDescription(locale)}
        </div>
        <a href="#" role="button" aria-haspopup="dialog" aria-controls="st-overlay-preview-agenda" class="st-card st-card-agenda st--card-horizontal st--with-gradient" onclick="updateDescription(this)" onkeydown="simulateClick(event)" data-overlay-open="st-overlay-preview-agenda" data-classpk="${entry.assetEntry.classPK}"
           data-date="<#if entry.startDate?has_content && entry.endDate?has_content>
                        <#if entry.startDate?date==entry.endDate?date>
                            <@liferay_ui.message key="eu.event.the" /> ${entry.startDate?date?string.short?replace('/', '.')}
                        <#else>
                            <@liferay_ui.message key="eu.event.from-date" /> ${entry.startDate?date?string.short?replace('/', '.')} <@liferay_ui.message key="eu.event.to" /> ${entry.endDate?date?string.short?replace('/', '.')}
                        </#if></#if>"
           data-detailurl="${strasbourg.homeURL()}manifestation/-/entity/id/${entry.manifestationId}/${entry.getNormalizedTitle(locale)}"
        >
            <div class="st-caption">
                <h3 class="st-title-card">
                    ${entry.getTitle(locale)}
                </h3>
                <p class="st-surtitre-cat">
                    ${entry.getTypeLabel(locale)}
                </p>
                <p class="st-date">
                    <#if entry.startDate?has_content && entry.endDate?has_content>
                        <#if entry.startDate?date==entry.endDate?date>
                            <@liferay_ui.message key="eu.event.the" />
                            ${entry.startDate?date?string.short?replace('/', '.')}
                        <#else>
                            <@liferay_ui.message key="eu.event.from-date" />
                            ${entry.startDate?date?string.short?replace('/', '.')}
                            <@liferay_ui.message key="eu.event.to" />
                            ${entry.endDate?date?string.short?replace('/', '.')}
                        </#if>
                    </#if>
                </p>
            </div>
            <div class="st-image">
                <#if entry.getImageId() !=0>
                    <@strasbourg.addImage fileEntryId=entry.getImageId() maxWidth=100 showLegende=false showCopyright=false isFigure=true />
                <#else>
                    <figure class="st-figure st-fit-cover" role="group">
                        <img alt="" loading="lazy" src="${entry.getImageThumbnailURL()}" />
                    </figure>
                </#if>
            </div>
        </a>
        <@strasbourg.isFavourite entryId=entry.assetEntry.classPK entryType=12  entityGroupId=0 title=entry.getTitle(locale) url=detailURLFilter />
    </div>
</li>