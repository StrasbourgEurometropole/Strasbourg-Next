<div class="st-bloc st-bloc-slider-focus st-js-slider-focus splide st-u-overflow-x-hidden st--type-diaporamas"
     role="group">
    <div class="st-wrapper st-wrapper-small st-bloc-slider-focus__top">
        <h2 class="st-h2 st-title">Diaporamas</h2>
        <div class="splide__arrows st-nav-arrows st-hide-until@mobile">
            <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
            <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
        </div>
    </div>

    <div class="st-bloc-slider-focus__track-wrapper">
        <div class="st-wrapper">
            <div class="splide__track st-u-overflow-visible">
                <ul class="splide__list">
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

                        <li class="splide__slide">
                            <a href="${viewURL}" class="st-slide-diaporama">
                                <div class="st-image">

                                    <figure class="st-figure st-fit-cover figcaption-only-credits" role="group"
                                            aria-label="">
                                        <picture>
                                            <img alt="" src="${imageURL}">
                                        </picture>
                                        <figcaption>
                                        </figcaption>
                                    </figure>


                                </div>

                                <p class="st-caption st-surtitre">
                                    ${title}
                                </p>
                            </a>
                        </li>


                    </#list>

                </ul>
            </div>
        </div>
    </div>

    <div class="st-wrapper st-wrapper-small st-bloc-slider-focus__bottom">
        <ul class="splide__pagination st-nav-dots"></ul>
        <a href="/diaporama" class="st-btn st--btn-secondary st--btn-full-width-mobile st-btn-cta">Tous les diaporamas</a>
    </div>

</div>

<div class="st-wrapper st-wrapper-small st-bloc-separateur" role="group">
</div>