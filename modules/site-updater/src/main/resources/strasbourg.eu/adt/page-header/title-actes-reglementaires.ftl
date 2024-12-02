<!-- Entête liste des actes réglementaires et normatifs -->
<#setting locale = locale />
<#assign portalHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortalHelperService") />

<header class="st-header-without-sticky">
    <div class="st-wrapper">
        <h1 class="st-h1">${layout.getName(locale)}</h1>
        <@liferay.breadcrumbs />
        <div class="st-text-styles mt-3">
            <p>${layout.getDescription(locale)}</p>
        </div>

    </div>
</header>