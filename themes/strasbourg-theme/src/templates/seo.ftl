<#assign currentUrlOG = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />

<#assign descriptionOG = '${layout.getDescription(locale)?replace("<[^>]*>", "", "r")?html?js_string}' />
<#if !descriptionOG?has_content>
    <#assign descriptionOG = '${themeDisplay.siteGroup.expandoBridge.getAttribute("opengraph_default_description")}' />
</#if>

<#assign imageOG = '${layout.expandoBridge.getAttribute("image")}' />
<#if !imageOG?has_content>
    <#assign imageOG = '${themeDisplay.siteGroup.expandoBridge.getAttribute("opengraph_default_image")}' />
</#if>
<#if imageOG?has_content && !imageOG?contains('http')>
    <#assign imageOG = '${themeDisplay.getPortalURL()}${imageOG}' />
</#if>

<#assign openGraph = {
"og:type":"website",
"og:locale":"${locale}",
"og:url":"${currentUrlOG}",
"og:title":"${the_title_OG}",
"og:description":'${descriptionOG}',
"og:image":"${imageOG}",
"og:image:width":"620",
"og:image:height":"400"
} />

<#if request.getAttribute("LIFERAY_SHARED_OPENGRAPH")?has_content>
    <#assign openGraphCustom = request.getAttribute("LIFERAY_SHARED_OPENGRAPH")>
    <#list openGraphCustom?keys as keyOG>
        <#if openGraphCustom[keyOG]?has_content>
            <#assign openGraph = openGraph + {keyOG : openGraphCustom[keyOG]} >
        </#if>
        <#if !openGraphCustom[keyOG]?has_content && openGraph[keyOG]?has_content>
            <#assign openGraph = openGraph + {keyOG : openGraph[keyOG]} >
        </#if>
    </#list>
</#if>

<meta name="twitter:card" content="summary" />
<#list openGraph?keys as keyOG>
    <#assign valueOG = openGraph[keyOG]>
    <#if keyOG == "og:description" >
        <#assign valueOG = valueOG[0..*300] + (valueOG?length > 300)?then('...','') >
    </#if>
    <#if keyOG == "og:description" && valueOG?has_content >
        <meta property="${keyOG}" content="${valueOG}" />
    <#elseif keyOG?contains("og:image") && openGraph["og:image"]?has_content>
        <meta property="${keyOG}" content="${valueOG}" />
    <#elseif keyOG != "og:description" && !keyOG?contains("og:image")>
        <meta property="${keyOG}" content="${valueOG}" />
    </#if>
</#list>