<!-- Vignette association -->
<#setting locale=locale />
<#assign plId=renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />
<@liferay_portlet.renderURL plid=plId var="detailURL" portletName="eu_strasbourg_portlet_entity_detail_EntityDetailPortlet" windowState="normal">
    <@liferay_portlet.param name="classPK" value="${entry.assetEntry.classPK}" />
    <@liferay_portlet.param name="returnURL" value="${currentURL}" />
</@liferay_portlet.renderURL>

<@liferay_portlet.actionURL var="detailURLFilter">
    <@liferay_portlet.param name="userTargetClassId" value="${entry.assetEntry.classNameId}" />
    <@liferay_portlet.param name="userTargetClassPK" value="${entry.assetEntry.classPK}" />
    <@liferay_portlet.param name="userTargetTitle" value="${entry.getName(locale)}" />
    <@liferay_portlet.param name="detailURL" value="${detailURL}" />
</@liferay_portlet.actionURL>

<#assign uniqueDomaines=[]>
<#list entry.practicesCategories as practiceCategories>
    <#assign currentDomaine=practiceCategories.getDomaine(locale)>
    <#if currentDomaine?is_string && !(uniqueDomaines?seq_contains(currentDomaine))>
        <#assign uniqueDomaines=uniqueDomaines + [currentDomaine]>
    </#if>
</#list>

<#assign uniqueTerritoires=[]>
<#list entry.getTerritories() as territoire>
    <#assign currentTerritoire=territoire.getName()>
    <#assign uniqueTerritoires=uniqueTerritoires + [currentTerritoire]>
</#list>
<li>
    <div class="st-card-container">
        <a href="${detailURL}" title="${entry.getName(locale)}"
           class="st-card st--card-horizontal st--with-icon hihi-${entry.assetEntry.classPK}">
            <div class="st-caption">
                <h3 class="st-title-card">
                    ${entry.getName(locale)}
                </h3>
                <p class="st-surtitre-cat">
                    ${uniqueDomaines?join(", ")}
                </p>
                <p class="st-location">${uniqueTerritoires?join(", ")?truncate(65, '...')}</p>
            </div>
            <div class="st-image">
                <span class="st-icon st-icon-gps-activites"></span>
            </div>
        </a>
    </div>
</li>