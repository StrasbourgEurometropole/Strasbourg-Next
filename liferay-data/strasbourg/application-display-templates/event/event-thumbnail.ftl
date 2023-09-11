<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#assign plId=renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />
<@liferay_portlet.renderURL plid=plId var="detailURL" portletName="eu_strasbourg_portlet_entity_detail_EntityDetailPortlet" windowState="normal">
    <@liferay_portlet.param name="classPK" value="${entry.assetEntry.classPK}" />
    <@liferay_portlet.param name="title" value="${entry.getNormalizedTitle(locale)}" />
    <@liferay_portlet.param name="returnURL" value="${currentURL}" />
</@liferay_portlet.renderURL>
<@liferay_portlet.actionURL var="detailURLFilter">
    <@liferay_portlet.param name="userTargetClassId" value="${entry.assetEntry.classNameId}" />
    <@liferay_portlet.param name="userTargetClassPK" value="${entry.assetEntry.classPK}" />
    <@liferay_portlet.param name="userTargetTitle" value="${entry.getTitle(locale)}" />
    <@liferay_portlet.param name="detailURL" value="${detailURL}" />
    <@liferay_portlet.param name="searchLogId" value="${renderRequest.getAttribute('searchLogId')!0}" />
</@liferay_portlet.actionURL>
<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
<!-- Vignette événement -->
<#if isFeatured>
    <#assign cssClass='coup-de-coeur' />
<#else>
    <#assign cssClass='' />
</#if>
<li>
    <div class="st-card-container ${cssClass}">
        <div class="st-description st-hide">
            ${entry.getDescription(locale)}
        </div>
        <a href="#" class="st-card st-card-agenda st--card-horizontal st--with-gradient" onclick="updateDescription(this)" data-overlay-open="st-overlay-preview-agenda" data-classpk="${entry.assetEntry.classPK}"
           <#if entry.bookingURL?has_content>data-bookingURL="${entry.bookingURL}"</#if>
           data-address="${entry.getPlaceAddress(locale)}"
           data-detailurl="${detailURLFilter}"
        >
            <div class="st-caption">
                <p class="st-title-card">
                    ${entry.getTitle(locale)}
                </p>
                <p class="st-surtitre-cat">
                    ${entry.getTypeLabel(locale)}
                </p>
                <p class="st-date">
                    <#if entry.firstStartDate?has_content && entry.lastEndDate?has_content>
                        <#if entry.firstStartDate?date==entry.lastEndDate?date>
                            <@liferay_ui.message key="eu.event.the" />
                            ${entry.firstStartDate?date?string.short?replace('/', '.')}
                        <#else>
                            <@liferay_ui.message key="eu.event.from-date" />
                            ${entry.firstStartDate?date?string.short?replace('/', '.')}
                            <@liferay_ui.message key="eu.event.to" />
                            ${entry.lastEndDate?date?string.short?replace('/', '.')}
                        </#if>
                    </#if>
                </p>
                <p class="st-location">
                    ${entry.getPlaceAlias(locale)} - ${entry.getPlaceCity(locale)}
                </p>
            </div>
            <div class="st-image">
                <#if entry.getImageId() !=0>
                    <@addImage fileEntryId=entry.getImageId() isFigure=true />
                <#else>
                    <figure class="st-figure st-fit-cover" role="group">
                        <img src="${entry.getImageURL()}" />
                    </figure>
                </#if>
            </div>
        </a>
        <button class="st-btn-favorite-card" data-addpanier="postID">
            <@liferay_ui.message key='eu.add-to-favorite' />
        </button>
    </div>
</li>