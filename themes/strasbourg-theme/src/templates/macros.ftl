<#macro addImage imageURL showLegende=false showCopyright=false isFigure=false>
    <#if  fileEntryHelper.getFileEntryByRelativeURL(imageURL)?has_content>
        <#assign image = fileEntryHelper.getFileEntryByRelativeURL(imageURL) />
        <#assign title = fileEntryHelper.getFileTitle(image.getFileEntryId(), locale) />
        <#assign legend = fileEntryHelper.getImageLegend(image.getFileEntryId(), locale) />
        <#assign copyright = fileEntryHelper.getImageCopyright(image.getFileEntryId(), locale) />
        <#assign hasCredits = copyright?has_content />
        <#assign hasLegende = legend?has_content />
        <#assign creditsVisible = hasCredits && hasLegende>

        <#if creditsVisible && showCopyright>
            <span class="st-credits" aria-hidden="true">${copyright}</span>
        </#if>

        <figure class="st-fit-cover<#if !creditsVisible> figcaption-only-credits</#if>" role="group" aria-label<#if creditsVisible && showCopyright>="Photo, \u00A9 ${copyright}"</#if>>
            <img data-fileentryid="${image.getFileEntryId()}" src="${imageURL}">
            <#if creditsVisible && showLegende>
                <figcaption>
                    <span class="st-sr-only">Photo, ${copyright}</span>
                    ${legend}
                </figcaption>
            </#if>
        </figure>
        <#if !creditsVisible && hasLegende && showLegende>
            <figcaption>
                ${legend}
            </figcaption>
        </#if>
    <#else>
        <figure class="<#if isFigure>st-figure</#if> st-fit-cover" role="group">
            <img src="${imageURL}">
        </figure>
    </#if>
</#macro>


<#macro showMore>
    <div class="st-show-more">
        <button class="st-btn-show-more st-btn-arrow st--down" aria-expanded="false" aria-controls="123"
                aria-label="<@liferay_ui.message key='eu.view-more' />" data-open-label="<@liferay_ui.message key='eu.view-more' />"
                data-close-label="<@liferay_ui.message key='eu.view-less' />">
        </button>
    </div>
</#macro>

<#function slugify inputString>
    <#local normalized = inputString?replace("\\s+", "-", "r")?replace("\\n", "-", "r")?lower_case>
    <#local slug = normalized?replace("[^a-z0-9-]", "", "r")>
    <#return slug>
</#function>

<#function getFileFromURL fileURL>
    <#list fileURL?split("/") as x>
        <#if x?counter==3>
            <#assign groupId=x?number>
        </#if>

        <#if x?counter==6>
            <#assign uuId=x?keep_before("?")>
        </#if>
    </#list>
    <#assign
    dlFileEntry=serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>
    <#if (uuId??) && (groupId??)>
        <#assign file=dlFileEntry.getFileEntryByUuidAndGroupId(uuId,groupId)>
        <#return file>
    </#if>

</#function>
