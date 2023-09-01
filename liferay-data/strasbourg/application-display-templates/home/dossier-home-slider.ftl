<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
<div class="st-bloc st-bloc-editions-dossiers st-wrapper ">
    <div class="st-col-right st-js-slider-dossiers splide" role="group">
        <div class="st-top-bar">
            <h2 class="st-h2"><@liferay_ui["message"] key="dossiers" /></h2>
            <div class="splide__arrows st-nav-arrows st-hide-until@mobile">
                <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
            </div>
        </div>


        <div class="splide__track st-u-overflow-visible">
            <ul class="splide__list">
                <#list entries as navigationEntry>
                    <li class="splide__slide">
                        <div class="st-card-container">
                            <a href="${navigationEntry.getRegularFullURL()}" class="st-card ">
                                <div class="st-caption">
                                    <p class="st-title-card">${navigationEntry.getLayout().getName()}</p>
                                    <p class="st-surtitre-cat">
                                        cate?
                                    </p>
                                    <p class="st-text">${navigationEntry.getLayout().getDescription()}</p>
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
            <a href="#" class="st-btn st--btn-secondary"><@liferay_ui["message"] key="all-dossiers" /></a>
        </div>

    </div>
</div>