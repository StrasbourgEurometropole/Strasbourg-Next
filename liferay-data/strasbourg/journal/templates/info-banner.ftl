<div class="st-wrapper st-bloc st-contenu-en-avant">
    <div class="st-content st-text-styles">
        <h2 class="st-h2">
            À la une :<br>
            <strong><#if (TitleText.getData())??>
                    ${TitleText.getData()}
                </#if></strong>
        </h2>
        <p class="st-surtitre-cat"><#if (SubtitleText.getData())??>
                ${SubtitleText.getData()}
            </#if></p>
        <p><#if (DescriptionRichText.getData())??></p>
        ${DescriptionRichText.getData()}
        </#if><#if (ExternalLinkText.getData())??>
            <a href="${ExternalLinkText.getData()}" class="st-btn">
                <#if (LabelLinkText.getData())??>
                    ${LabelLinkText.getData()}
                </#if>
            </a>
        </#if>
    </div>
    <div class="st-img-wrapper">
        <#if (PictoImage.getData())?? && PictoImage.getData() != "">
            <img alt="${PictoImage.getAttribute("alt")}" data-fileentryid="${PictoImage.getAttribute("fileEntryId")}" src="${PictoImage.getData()}" />
        </#if>

    </div>
</div>


<#macro addImage imageURL showLegende=false showCopyright=false>
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
        <figure class="st-fit-cover" role="group">
            <img src="${imageURL}">
        </figure>
    </#if>
</#macro>