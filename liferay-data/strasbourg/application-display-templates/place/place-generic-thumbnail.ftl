<!-- Vignette lieu -->
<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>

<li>
    <div class="st-card-container">
        <a href="${homeURL}lieu/-/entity/sig/${entry.getSIGid()}/${entry.getNormalizedAlias(locale)}" class="st-card st--card-horizontal st--with-gradient">
            <div class="st-caption">
                <p class="st-title-card">
                    ${entry.getAlias(locale)}
                </p>
                <p class="st-surtitre-cat">
                    ${entry.getTypeLabel(locale)}
                </p>
                <p class="st-location">
                    ${entry.getCity(locale)}
                </p>
            </div>
            <div class="st-image">
                <@strasbourg.addImage fileEntryId=entry.getImageId() showLegende=false showCopyright=false isFigure=true />
                <#if entry.isOpenNow()>
                    <p class="st-badge-ouverture">
                        <@liferay_ui.message key='open-period' />
                    </p>
                <#else>
                    <p class="st-badge-ouverture st--closed">
                        <@liferay_ui.message key='closed-period' />
                    </p>
                </#if>
            </div>
        </a>
        <@strasbourg.isFavourite entryId=entry.placeId entryType=1  entityGroupId=0 title=entry.getAlias(locale) url="${homeURL}lieu/-/entity/sig/${entry.getSIGid()}/${entry.getNormalizedAlias(locale)}" />
    </div>
</li>