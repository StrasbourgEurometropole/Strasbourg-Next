<!-- Webmag - Vidéo -->
<#setting locale = locale />
<#assign GroupLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.GroupLocalService")>


<div class="st-bloc st-bloc-slider-focus st-js-slider-focus splide st-u-overflow-x-hidden st--type-medias" role="group">
    <div class="st-wrapper st-wrapper-small st-bloc-slider-focus__top">
        <h2 class="st-h2 st-title">Vidéos</h2>
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

                        <#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
                            <#assign homeURL = "/web${layout.group.friendlyURL}/" />
                        <#else>
                            <#assign homeURL = "/" />
                        </#if>

                        <#assign entry = curEntry.getAssetRenderer().getVideo() />
                        <#assign viewURL = homeURL + "video/-/entity/id/" + entry.getVideoId() />
                        <#assign videoURL = homeURL + "videos" />
                        <li class="splide__slide">
                            <a href="${viewURL}" class="st-slide-media">
                                <div class="st-caption">
                                    <div class="st-btn-play">
                                        <span class="st-icon-arrow-right" aria-hidden="true"></span>
                                    </div>
                                    <p class="st-surtitre">${entry.getTitle(locale)}</p>
                                </div>
                                <div class="st-image">
                                    <figure class="st-figure st-fit-cover" role="group" aria-label="">
                                        <picture>
                                            <img alt="" loading="lazy" src="${entry.getImageURL()}" >
                                        </picture>
                                    </figure>
                                </div>
                            </a>
                        </li>
                    </#list>

                </ul>
            </div>
        </div>
    </div>
    <div class="st-wrapper st-wrapper-small st-bloc-slider-focus__bottom">
        <ul class="splide__pagination st-nav-dots"></ul>
        <a href="${videoURL}" class="st-btn st--btn-secondary st--btn-full-width-mobile st-btn-cta">Toutes les vidéos</a>
    </div>
</div>

<div class="st-wrapper st-wrapper-small st-bloc-separateur" role="group">
</div>