<!-- Vignette lieu Grille -->
<#setting locale=locale />

<li>
    <div class="st-card-container">
        <a href="${strasbourg.homeURL()}lieu/-/entity/sig/${entry.getSIGid()}/${entry.getNormalizedAlias(locale)}" class="st-card st--with-gradient <#if entry.getImageId() == 0 || !entry.getImageURL()?has_content>st--with-icon</#if>">
            <div class="st-caption">
                <h3 class="st-title-card">
                    ${entry.getAlias(locale)}
                </h3>
                <p class="st-surtitre-cat">
                    ${entry.getTypeLabel(locale)}
                </p>
                <p class="st-location">
                    ${entry.getCity(locale)}
                </p>
            </div>
            <div class="st-image">
                <#if entry.getImageId() !=0>
                    <@strasbourg.addImage fileEntryId=entry.getImageId() maxWidth=195 showLegende=false showCopyright=false isFigure=true />
                <#elseif entry.getImageURL()?has_content>
                    <figure class="st-figure st-fit-cover" role="group">
                        <img loading="lazy" src="${entry.getImageURL()}" />
                    </figure>
                <#else>
                    <span class="st-icon st-icon-pin"></span>
                </#if>
                <#if entry.periods?has_content>
                <#if entry.isOpenNow()>
                    <p class="st-badge-ouverture">
                        <@liferay_ui.message key='open-period' />
                    </p>
                <#else>
                    <p class="st-badge-ouverture st--closed">
                        <@liferay_ui.message key='closed-period' />
                    </p>
                </#if>
                </#if>
            </div>
        </a>
        <@strasbourg.isFavourite entryId=entry.placeId entryType=1  entityGroupId=0 title=entry.getAlias(locale) url="${strasbourg.homeURL()}lieu/-/entity/sig/${entry.getSIGid()}/${entry.getNormalizedAlias(locale)}" />
    </div>
</li>