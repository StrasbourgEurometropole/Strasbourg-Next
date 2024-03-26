<!-- Vignette événement -->
<#setting locale = locale />
<#assign uriHelper = serviceLocator.findService("eu.strasbourg.utils.api.UriHelperService")/>
<#assign fromSearch = renderRequest.getAttribute("fromSearchPortlet")!false >
<#assign plId = 0 />
<#if fromSearch>
  <#assign plId = renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />
</#if>

<div class="event portlet-event-item" headers="tsud_col-1"> 
  <div class="entry-category"> ${entry.getTypeLabel(locale)} - ${entry.getThemeLabel(locale)}
  </div>
  <div class="entry-image"> 
    <a href="${strasbourg.homeURL()}evenement/-/entity/id/${entry.eventId}/${entry.getNormalizedTitle(locale)}" title="${entry.getTitle(locale)}">
      <img src="${entry.imageURL}" alt="${entry.getTitle(locale)}">
    </a>
  </div> 
  <div class="entry-header">
    <span class="category" style="word-wrap: break-word;"> ${entry.getTypeLabel(locale)} - ${entry.getThemeLabel(locale)}
    </span>
    <h2 style="word-wrap: break-word;">
      <a href="${strasbourg.homeURL()}evenement/-/entity/id/${entry.eventId}/${entry.getNormalizedTitle(locale)}" title="${entry.getTitle(locale)}">${entry.getTitle(locale)}</a>
    </h2>
    <span class="date" style="word-wrap: break-word;"> ${entry.getEventScheduleDisplay(locale)}</span> 
    <div class="place" style="word-wrap: break-word;"> ${entry.getCity(locale)} - ${entry.getPlaceAlias(locale)}
    </div> 
  </div>
  <footer class="entry-meta">
    <time></time>
    <a href="${strasbourg.homeURL()}evenement/-/entity/id/${entry.eventId}/${entry.getNormalizedTitle(locale)}" title="Lire la suite" class="btn-more"><@liferay_ui.message key="read-more" /></a>
    <div class="clearfix"></div>
  </footer>
</div>
