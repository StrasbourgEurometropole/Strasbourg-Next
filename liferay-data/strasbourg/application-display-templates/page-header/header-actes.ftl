<!-- Entête liste des actes réglementaires et normatifs -->
<#setting locale=locale />
<#assign portalHelper=serviceLocator.findService("eu.strasbourg.utils.api.PortalHelperService") />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<header class="st-small-header st-wrapper st-wrapper-small" role="banner">
    <h1 class="st-h1">
        ${layout.getName(locale)}
    </h1>
    <@liferay.breadcrumbs />
</header>
<div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
    <div class="st-component-container st-text-styles">
        <p>
            ${layout.getDescription(locale)}
        </p>
    </div>
</div>