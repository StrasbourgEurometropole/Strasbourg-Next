<!-- Vignette événement -->
<#setting locale = locale />
<#assign fromSearch = renderRequest.getAttribute("fromSearchPortlet")!false >
<#assign plId = 0 />
<#if fromSearch>
  <#assign plId = renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />
</#if>

<#assign detailURL = strasbourg.homeURL() + "evenement/-/entity/id/" + entry.getEventId() />

<a href="${detailURL}" aria-label="${entry.getTitle(locale)?html}" title="${entry.getTitle(locale)?html}" class="event-thumbnail" style="background-image: url(${entry.getImageThumbnailURL()})">
    <#if entry.getActivityTypeLabel(locale)?has_content>
        <div class="visit">
            <span>${entry.getActivityTypeLabel(locale)}</span>
        </div>
    </#if>
    <div class="info">
        <div class="title">
            <span>${entry.getTitle(locale)}</span>
        </div>
        <div class="dates">
            <span>${entry.getEventScheduleDisplay(locale)}</span>
        </div>
        <div class="museums">
            <span>${entry.getMuseumsLabel(locale)}</span>
        </div>
    </div>
</a>