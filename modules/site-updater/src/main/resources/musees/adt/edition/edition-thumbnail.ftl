<!-- Vignette édition -->
<#setting locale = locale />
<#assign fromSearch = renderRequest.getAttribute("fromSearchPortlet")!false >
<#assign plId = 0 />
<#if fromSearch>
    <#assign plId = renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />
</#if>

<@liferay_portlet.renderURL plid=plId var="detailURL" portletName="eu_strasbourg_portlet_entity_detail_EntityDetailPortlet" windowState="normal">
    <@liferay_portlet.param name="classPK" value="${entry.getEditionId()}" />
    <@liferay_portlet.param name="title" value="${entry.getTitle(locale)}" />
</@liferay_portlet.renderURL>

<a href="${detailURL}" aria-label="${entry.getTitle(locale)?html}" title="${entry.getTitle(locale)?html}" class="edition-thumbnail" style="background-image: url(${entry.getImageURL()})">
    <div class="info">
        <div class="title">
            <span>${entry.getTitle(locale)}</span>
        </div>
        <div class="museums">
            <span>${entry.getMuseumsLabel(locale)}</span>
        </div>
    </div>
</a>