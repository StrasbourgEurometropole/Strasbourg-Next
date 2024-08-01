<!-- Vignette video -->


<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<#setting date_format="d/MM/yyyy">
<#assign fromSearch = renderRequest.getAttribute("fromSearchPortlet")!false >
<#assign plId = 0 />
<#if fromSearch>
    <#assign plId = renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />
</#if>

<@liferay_portlet.renderURL plid=plId var="detailURL" portletName="eu_strasbourg_portlet_entity_detail_EntityDetailPortlet" windowState="normal">
    <@liferay_portlet.param name="classPK" value="${entry.getVideoId()}" />
    <@liferay_portlet.param name="returnURL" value="${currentURL}" />
</@liferay_portlet.renderURL>

<@liferay_portlet.actionURL var="detailURLFilter">
    <@liferay_portlet.param name="userTargetClassId" value="${entry.assetEntry.classNameId}" />
    <@liferay_portlet.param name="userTargetClassPK" value="${entry.assetEntry.classPK}" />
    <@liferay_portlet.param name="userTargetTitle" value="${entry.getTitle(locale)}" />
    <@liferay_portlet.param name="detailURL" value="${detailURL}" />
    <@liferay_portlet.param name="searchLogId" value="${renderRequest.getAttribute('searchLogId')!0}" />
</@liferay_portlet.actionURL>

<li>
    <div class="st-card-container">
        <a href="${detailURLFilter}" class="st-card" style="--aspect-ratio: 16/9;">
            <div class="st-caption">
                <h3 class="st-title-card">${entry.getTitle(locale)}</h3>
                <p class="st-surtitre-cat">${entry.getThemesLabel(locale)}</p>
                <p class="st-text">${entry.getDescription(locale)?replace(r'<[^>]*>', '', 'r')[0..*150]}...</p>
            </div>
            <div class="st-image">
                <@strasbourg.addImage fileEntryId=entry.imageId maxWidth=430 showLegende=false showCopyright=false isFigure=true />
            </div>

        </a>
        <@strasbourg.isFavourite entryId=entry.assetEntry.classPK entryType=3  entityGroupId=0 title=entry.getTitle(locale) url=detailURLFilter />
    </div>
</li>