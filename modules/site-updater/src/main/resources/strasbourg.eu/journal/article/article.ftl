<#setting locale = locale />
<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext() />
<#assign request = serviceContext.getRequest()/>
<#-- Liste des infos a partager -->
<#assign openGraph = {
"og:description":'${chapo.getData()?replace("<[^>]*>", "", "r")?html}'
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}

<#assign currentUrl = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />
<header class="st-header-without-sticky st-wrapper">
    <div>
            <h1 class="st-h1">${title.getData()}</h1>
            <@liferay.breadcrumbs />
        <#if layout.expandoBridge.getAttribute('image')?has_content>
            <div class="st-img-wrapper" tabindex="0">
                <figure class="st-figure st-fit-cover figcaption-only-credits" role="group" aria-label="">
                    <picture>
                        <img alt="" src="${layout.expandoBridge.getAttribute('image')}">
                    </picture>
                </figure>
            </div>
        </#if>
    </div>
</header>

<div class="st-bloc st-bloc-sit-presentation st-wrapper st--has-margin st-text-styles">
    <#if chapo?has_content>
        <p class="st-surtitre st-surtitre mb-4">
            <strong>
                ${chapo.getData()}
            </strong>
        </p>
    </#if>
    <div class="st-component-container st-text-styles">
        ${content.getData()}
    </div>
</div>