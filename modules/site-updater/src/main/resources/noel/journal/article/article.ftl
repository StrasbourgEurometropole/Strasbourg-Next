<#setting locale = locale />
<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext() />
<#assign themeDisplay = serviceContext.getThemeDisplay() />
<#assign currentUrl = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />
<#assign request = serviceContext.getRequest()/>

<#-- Liste des infos a partager -->
<#assign openGraph = {
"og:description":'${catcher.data?replace("<[^>]*>", "", "r")?html}'
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}

<!-- Détail article -->
<div class="mns-fck container mns-p50">
    <div class="text-center">
        <p>${catcher.data}</p>
	</div>
    ${text.data}
</div>


