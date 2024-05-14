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
<header class="st-header-without-sticky st-wrapper st-wrapper-small">
    <div>
        <h1 class="st-h1">${title.getData()}</h1>
        <@liferay.breadcrumbs />
    </div>
</header>

<div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
    <p class="st-surtitre">
        <strong>
            ${chapo.getData()}
        </strong>
    </p>
    <div class="st-component-container st-text-styles">
        ${content.getData()}
    </div>
</div>