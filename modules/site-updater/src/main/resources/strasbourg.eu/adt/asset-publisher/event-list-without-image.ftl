

<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<div class="st-wrapper st-bloc st-bloc-agenda-home ">
    <h2 class="st-h2 st-titre">L’agenda</h2>
    <ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">
        <#list entries as entry>
            <#assign event=entry.getAssetRenderer().getEvent() />
            <li>
                <div class="st-card-container">
                    <a href="${strasbourg.homeURL()}evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}" class="st-card st-card-agenda st--text-only st--card-horizontal st--with-gradient">
                        <div class="st-caption">
                            <h3 class="st-title-card">
                                ${event.getTitle(locale)}
                            </h3>
                            <p class="st-surtitre-cat">
                                ${event.getTypeLabel(locale)}
                            </p>
                            <p class="st-date">
                                ${event.getEventScheduleDisplayShort(locale)}
                            </p>
                            <p class="st-location">
                                ${event.getPlaceAlias(locale)}
                                - ${event.getPlaceCity(locale)}
                            </p>
                        </div>
                    </a>
                    <@strasbourg.isFavourite entryId=event.eventId entryType=2  entityGroupId=0 title=entry.getTitle(locale) url="${strasbourg.homeURL()}evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}" />
                </div>
            </li>
        </#list>
    </ul>
    <a href="${strasbourg.homeURL()}agenda" class="st-btn st--btn-secondary st--btn-full-width-mobile st-btn-cta">
        <@liferay_ui.message key="eu.all-events" />
    </a>
</div>