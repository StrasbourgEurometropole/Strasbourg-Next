<!-- Vignette lieu -->

<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<div class="st-card-container">
    <a href="${homeURL}lieu/-/entity/sig/${entry.getSIGid()}/${entry.getNormalizedAlias(locale)}" class="st-card">
        <div class="st-caption">
            <p class="st-title-card">${entry.getAlias(locale)}
            </p>
            <p class="st-surtitre-cat">${entry.getTypeLabel(locale)}</p>
            <p class="st-location">${entry.getCity(locale)}</p>
        </div>
        <div class="st-image">
            <figure class="st-figure st-fit-cover" role="group">
                <picture>
                    <img width="110" height="110" alt="" src="https://placehold.co/110x110/png" />
                </picture>
            </figure>
            <p class="st-ouverture st--closed">
                Fermé
            </p>
        </div>
    </a>
    <button class="st-btn-favorite-card" data-id="${entry.placeId}">
        <@liferay_ui.message key='eu.add-to-favorite' />
    </button>
</div>
