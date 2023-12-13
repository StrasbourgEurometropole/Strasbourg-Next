<!-- Liste d'actualités -->
<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<#assign portletHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />
<div class="st-bloc st-bloc-actu st--with-anchors st-wrapper st-u-overflow-x-hidden st--has-margin" role="group">
    <div class="st-wrapper st-bloc-actu__inner st-js-slider-actu splide st-component-container" id="splide02" role="region">
        <h2 class="st-h2 st-titre">${portletHelper.getPortletTitle('eu.news', renderRequest)}</h2>
        <div class="splide__track st-u-overflow-visible" id="splide02-track">
            <ul class="splide__list st-cards-wrapper" id="splide02-list">
                <#list entries as curEntry>
                    <#if curEntry?has_content && curEntry.getAssetRenderer()?has_content && curEntry.getAssetRenderer().getArticle()?has_content>
                        <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
                        <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()")/>
                        <#assign chapo = docXml.valueOf("//dynamic-element[@name='chapo']/dynamic-content/text()") />
                        <#assign thumbnail = docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
                        <#assign assetPublisherTemplateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.AssetPublisherTemplateHelperService")/>
                        <#assign imageURL ="" />
                        <#if thumbnail?has_content>
                            <#assign imageURL = assetPublisherTemplateHelperService.getDocumentUrl(thumbnail) />
                        </#if>
                        <#assign currentURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry) />
                        <#assign viewURL = curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL) />
                        <#assign id = curEntry.getAssetRenderer().getArticle().getArticleId() />
                    <#-- Récupération de DateHelper pour le format date -->
                        <#assign dateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.DateHelperService") />

                    <#-- Récupération des catégories "Type d'actualité de l'entité -->
                        <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
                        <#assign assetVocabularyHelper = serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />


                        <#assign newsTypes = assetVocabularyHelper.getAssetEntryCategoriesByVocabulary(curEntry, "type d'actualite") />

                        <li class="splide__slide" id="splide02-slide01">
                            <div class="st-card-container">
                                <a  href="${viewURL}" class="st-card st-card-actu">
                                    <div class="st-caption">
                                        <p class="st-title-card">${title}</p>
                                        <p class="st-surtitre-cat">${newsTypes?map(news -> news.getTitle(locale))?join(', ')}</p>
                                        <p class="st-date">Publié le ${dateHelperService.displayShortDate(entry.getModifiedDate()?date, locale)}</p>
                                    </div>
                                    <div class="st-image">
                                        <figure class="st-figure st-fit-cover" role="group">
                                            <picture>
                                                <img alt="" src="${imageURL}" />
                                            </picture>
                                        </figure>
                                    </div>
                                </a>
                            </div>
                        </li>
                    </#if>
                </#list>



            </ul>
        </div>
        <ul class="splide__pagination st-nav-dots" role="tablist" aria-label="Select a slide to show"></ul>
        <a href="${homeURL}actualite" class="st-btn st--btn-secondary st--btn-full-width st-btn-cta">Toutes les actualités</a>
    </div>
</div>