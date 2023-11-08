<!-- Header titre et description -->
<#setting locale = locale />
<#assign portalHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortalHelperService") />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<header class="st-header-edito" role="banner">
    <div class="st-wrapper">
        <div class="st-wrapper-modifier">
            <h1 class="st-h1">${layout.getName(locale)}</h1>
            <@liferay.breadcrumbs />
            <p>${layout.getDescription(locale)}</p>
        </div>
    </div>
</header>