<#assign fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
<#assign editorialTitle = fileEntryHelper.getFileTitle(illustration.getAttribute("fileEntryId")?number, locale) />
<#assign copyright = fileEntryHelper.getImageCopyright(illustration.getAttribute("fileEntryId")?number, locale) />

<div class="article-detail">
    <#if illustration.getAttribute('alt')?has_content>
       <h1 class="article-title ${illustration.getAttribute('alt')}">${title.getData()}</h1>
    <#else>
       <h1 class="article-title ">${title.getData()}</h1>
    </#if>
    <#if illustration.getData()?has_content>
        <div class="article-image">
            <div class="imgcontainer">
                

                <a href="${illustration.getData()}" title="${editorialTitle} © ${copyright}" class="magnific-popup">
                    <#if illustration.getAttribute('alt')?has_content && editorialTitle?has_content >
                        <img src="${illustration.getData()}" alt="${illustration.getAttribute('alt')}" title="${editorialTitle}" />
                    <#elseif editorialTitle?has_content >
                     <img src="${illustration.getData()}" title="${editorialTitle}" />
                    <#else>
                        <img src="${illustration.getData()}" />
                    </#if>
                </a>
                            
                <#if copyright?has_content>
                    <div class="copyright-caption">
                      &copy; ${copyright}
                    </div>
                </#if>                            
            </div>
        </div>
    </#if>
    <div class="article-catcher">${catcher.getData()}</div>
    <div class="article-clear"></div>
    <div class="article-texte">
        ${text.getData()}
    </div>
</div>