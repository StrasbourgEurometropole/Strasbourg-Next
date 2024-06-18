<!-- Header titre et description -->
<#setting locale = locale />
<#assign portalHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortalHelperService") />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<header class="st-small-header st--padding-top st-wrapper st-wrapper-small">
    <h1 class="st-h1">${layout.getName(locale)}</h1>
    <@liferay.breadcrumbs />
    <#if layout.getDescription(locale)?has_content>
        <div class="st-text-styles mt-3">
            <p>${layout.getDescription(locale)}</p>
        </div>
    </#if>
</header>