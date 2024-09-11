<!-- Liste de contenus webs -->
<#setting locale=locale />
<#assign portletHelper=serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />
<div class="st-bloc st-bloc-liens st-wrapper st--has-margin">
    <h2 class="st-h2 st-title">
        ${portletHelper.getPortletTitle('list', renderRequest)}
    </h2>
    <div class="st-component-container mt-5">
        <ul class="st-liste">
            <#list entries as curEntry>
                <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
                <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()")/>
                <#assign currentURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry) />
                <#assign viewURL = curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL) />
                <div class="st-lien-container">
                    <a href="${viewURL}" class="st-lien" title="${title}">
                        <p class="st-title-lien">
                            <#if title?has_content>
                                ${title}
                            <#else>
                                ${curEntry.getTitle(locale)}
                            </#if>
                        </p>
                        <div class="st-lien-content">
                            <p class="st-text"><@liferay_ui.message key="eu.access-page" /></p>
                        </div>
                    </a>
                </div>

            </#list>

        </ul>

    </div>
</div>