
<div class="st-bloc st-bloc-editions-dossiers st-wrapper ">
    <div class="st-col-right st-js-slider-dossiers splide" role="group">
        <div class="st-top-bar">
            <h2 class="st-h2">
                <@liferay_ui.message key='dossiers' />
            </h2>
            <div class="splide__arrows st-nav-arrows st-hide-until@mobile">
                <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
            </div>
        </div>
        <div class="splide__track st-u-overflow-visible">
            <ul class="splide__list">
                <#list entries as navigationEntry>
                    <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
                    <#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />
                    <#assign assetVocabularyHelper = serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />

                    <#assign curEntry = assetEntryLocalService.getEntry("com.liferay.portal.kernel.model.Layout", navigationEntry.getLayout().getPlid()) />

                    <#assign newsTypes = assetVocabularyHelper.getAssetEntryCategoriesByVocabulary(curEntry, "type d'actualite") />
                    <li class="splide__slide">
                        <div class="st-card-container">
                            <a href="${navigationEntry.getRegularFullURL()}" class="st-card ">
                                <div class="st-caption">
                                    <p class="st-title-card">
                                        ${navigationEntry.getLayout().getName()}
                                    </p>
                                    <p class="st-surtitre-cat">
                                        ${newsTypes?map(news -> news.getTitle(locale))?join(', ')}
                                    </p>
                                    <p class="st-text">
                                        ${navigationEntry.getLayout().getDescription()}
                                    </p>
                                </div>
                                <div class="st-image">
                                    <figure class="st-figure st-fit-cover" role="group">
                                        <picture>
                                            <img alt=""
                                                 src="${navigationEntry.getLayout().expandoBridge.getAttribute('image')}">
                                        </picture>
                                    </figure>
                                </div>
                            </a>
                        </div>
                    </li>
                </#list>
            </ul>
        </div>
        <div class="st-bottom-bar">
            <ul class="splide__pagination st-nav-dots"></ul>
            <a href="#" class="st-btn st--btn-secondary">
                <@liferay_ui.message key='all-dossiers' />
            </a>
        </div>
    </div>
</div>