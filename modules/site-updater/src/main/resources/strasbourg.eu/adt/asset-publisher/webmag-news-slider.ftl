<!-- Webmag - Gros slider -->
<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<#assign assetPublisherTemplateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.AssetPublisherTemplateHelperService")/>


<div class="st-bloc st-bloc-slider-focus st-js-slider-focus splide st-u-overflow-x-hidden st--type-cards" role="group">
    <div class="st-wrapper st-wrapper-small st-bloc-slider-focus__top">
        <div class="splide__arrows st-nav-arrows">
            <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
            <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
        </div>
    </div>
    <div class="st-bloc-slider-focus__track-wrapper">
        <div class="st-wrapper">
            <div class="splide__track st-u-overflow-visible">
                <ul class="splide__list">
                    <#assign assetEntryLocalService=serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
                    <#assign assetVocabularyHelper=serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />

                    <#list entries as curEntry>
                        <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
                        <#assign asset=assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', curEntry.getAssetRenderer().getArticle().getResourcePrimKey())>
                        <#assign newsTypes=assetVocabularyHelper.getAssetEntryCategoriesByVocabulary(asset, "type d'actualite" ) />
                        <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()")/>
                        <#assign chapo = docXml.valueOf("//dynamic-element[@name='chapo']/dynamic-content/text()") />
                        <#assign thumbnail = docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
                        <#assign thumbnailId ="" />
                        <#if thumbnail?has_content>
                            <#assign thumbnailId = assetPublisherTemplateHelperService.getDocumentId(thumbnail) />
                        </#if>
                        <#assign currentURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry) />
                        <#assign viewURL = curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL) />
                        <#assign id = curEntry.getAssetRenderer().getArticle().getArticleId() />
                        <li class="splide__slide">
                            <div class="st-card-container">
                                <a href="${viewURL}" class="st-card ">
                                    <div class="st-caption">
                                        <p class="st-title-card">${title}</p>
                                        <p class="st-surtitre-cat">${newsTypes?map(news -> news.getTitle(locale))?join(', ')}</p>
                                        <p class="st-text">${chapo}</p>
                                    </div>
                                    <div class="st-image">
                                        <@strasbourg.addImage fileEntryId=thumbnailId maxWidth=265 showLegende=false showCopyright=false isFigure=true />
                                    </div>
                                </a>
                            </div>
                        </li>
                    </#list>


                </ul>
            </div>
        </div>
    </div>
    <div class="st-wrapper st-wrapper-small st-bloc-slider-focus__bottom">
        <ul class="splide__pagination st-nav-dots"></ul>
        <a href="/actualite" class="st-btn st--btn-secondary st--btn-full-width-mobile st-btn-cta">Tous les articles</a>
    </div>
</div>

<div class="st-wrapper st-wrapper-small st-bloc-separateur" role="group">
</div>