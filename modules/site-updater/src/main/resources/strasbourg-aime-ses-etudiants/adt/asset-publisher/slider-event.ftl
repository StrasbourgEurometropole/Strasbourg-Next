<#setting locale = locale />

<div class="portlet-agenda">
    <div class="agenda-body agenda-carousel owl-agenda owl-carousel owl-theme">  
        <#list entries as curEntry>
            <#assign entry = curEntry.getAssetRenderer().getEvent() />

            <div class="event-content"> 
                <a href="${strasbourg.homeURL()}evenement/-/entity/id/${entry.eventId}/${entry.getNormalizedTitle(locale)}">
                    <img class="event-image" src="${entry.getImageThumbnailURL()}" />
                </a>
                <div class="event-meta"> 
                    <span class="event-category">${entry.getThemeLabel(locale)}</span>
                    <span class="event-date">
                        <a href="${strasbourg.homeURL()}evenement/-/entity/id/${entry.eventId}/${entry.getNormalizedTitle(locale)}">
                            ${entry.getEventScheduleDisplay(locale)}
                        </a>
                    </span>
                    <a class="btn-tps-forts" href="${strasbourg.homeURL()}evenement/-/entity/id/${entry.eventId}/${entry.getNormalizedTitle(locale)}">
                        <h4>${entry.getTitle(locale)}</h4> 
                    </a>
                </div>
            </div>
        </#list>
    </div>
    <#if agendaURL?has_content && agendaURLText?has_content>
    <div class="link-all"><a href="${agendaURL}">${agendaURLText}</a></div>
    </#if>
</div>