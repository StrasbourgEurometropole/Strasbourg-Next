<!-- Webmag - Liste diaporama -->
<#setting locale = locale />
<#-- Récupération de DateHelper pour le format date -->
<#assign dateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.DateHelperService") />

<header class="st-small-header st-wrapper st-wrapper-small">
    <h1 class="st-h1">Diaporama</h1>
    <@liferay.breadcrumbs />
</header>

<div class="st-listing-cards st-wrapper st-wrapper-small">
    <ul class="st-cards-wrapper st--has-cards-vertical st-basic-grid st-col-3@mobile st-col-4@t-small">
        <#list entries as curEntry>
            <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
            <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()")/>
            <#assign content = docXml.valueOf("//dynamic-element[@name='content']/dynamic-content/text()") />
            <#assign image = docXml.valueOf("//dynamic-element[@name='image']/dynamic-content/text()") />
            <#assign assetPublisherTemplateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.AssetPublisherTemplateHelperService")/>
            <#assign imageURL ="" />
            <#if image?has_content>
                <#assign imageURL = assetPublisherTemplateHelperService.getDocumentUrl(image) />
            </#if>
            <#assign currentURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry) />
            <#assign viewURL = curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL) />

            <#assign id = curEntry.getAssetRenderer().getArticle().getArticleId() />
            <li>
                <div class="st-card-container">
                    <a href="${viewURL}" class="st-card st-card-actu st--with-gradient ">
                        <div class="st-caption">
                            <p class="st-title-card">${title}</p>
                            <p class="st-date">Publié le ${dateHelperService.displayShortDate(curEntry.getModifiedDate()?date, locale)}</p>
                            <p class="st-text"> ${content?replace("<[^>]*>", "", "r")[0..*100]}
                                <#if (content?replace("<[^>]*>", "", "r")?length gt 100)>
                                    ...
                                </#if></p>
                        </div>

                        <div class="st-image">

                            <figure class="st-figure st-fit-cover" role="group"
                                    aria-label="Photo">
                                <picture>
                                    <img alt="" loading="lazy" src="${imageURL}">
                                </picture>
                            </figure>
                        </div>

                    </a>
                </div>
            </li>


        </#list>

    </ul>
</div>