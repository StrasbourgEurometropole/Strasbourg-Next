<!-- Vignette lieu -->

<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<li>
    <div class="st-card-container">
        <a href="${homeURL}lieu/-/entity/sig/${entry.getSIGid()}/${entry.getNormalizedAlias(locale)}" class="st-card st--with-gradient">
            <div class="st-caption">
                <p class="st-title-card">${entry.getAlias(locale)}
                </p>
                <p class="st-surtitre-cat">${entry.getTypeLabel(locale)}</p>
                <p class="st-location">${entry.getCity(locale)}</p>
            </div>
            <div class="st-image">
                <figure class="st-figure st-fit-cover" role="group">
                    <picture>
                        <img alt="" src="${entry.getImageURL()}" />
                    </picture>
                </figure>
                <#if entry.isOpenNow()>
                    <p class="st-badge-ouverture">
                        Ouvert
                    </p>
                <#else>
                    <p class="st-badge-ouverture st--closed">
                        Fermé
                    </p>
                </#if>


            </div>
        </a>
        <button class="st-btn-favorite-card" data-id="${entry.placeId}">
            <@liferay_ui.message key='eu.add-to-favorite' />
        </button>
    </div>
</li>