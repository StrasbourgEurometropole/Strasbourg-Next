<div class="st-ancres st-wrapper">
    <div class="st-ancres-container">
        <div class="st-js-slider-ancres splide splide--slide splide--ttb splide--draggable is-active is-overflow"
             aria-label="Slider avec une liste de liens rapides pour accéder plus facilement aux différents section de la page">
            <div class="splide__track">
                <ul class="splide__list">
                    <#if entries?has_content>
                        <#list entries as navigationEntry>
                            <li class="splide__slide st-single-ancre">
                                <a href="#ancre-${navigationEntry.hashCode()}" class="st-menu-ancre is-active">
                                    <span>${navigationEntry.getName()}</span>
                                </a>
                            </li>
                        </#list>
                    </#if>
                </ul>
            </div>
            <div class="splide__arrows st-nav-arrows">
                <button class="splide__arrow splide__arrow--prev st-btn-arrow st--up"></button>
                <button class="splide__arrow splide__arrow--next st-btn-arrow st--down"></button>
            </div>
        </div>
    </div>

</div>
<#if entries?has_content>
    <#list entries as navigationEntry>
        <div id="ancre-${navigationEntry.hashCode()}" class="st-bloc-ancre" tabindex="-1"></div>
        <div class="st-bloc st-bloc-politiques-publiques st-wrapper st-u-overflow-x-hidden st--has-margin" role="group">
            <div class="st-wrapper-modifier">

                <h2 class="st-wrapper st-h2 st-titre">${navigationEntry.getName()}</h2>

                <div
                        class="st-wrapper st-bloc-politiques-publiques__top st-js-slider-politiques-publiques-links splide">
                    <div class="splide__track st-u-overflow-visible">

                        <ul class="splide__list st-links">
                            <#if navigationEntry.getChildren()?size !=0>
                                <#list navigationEntry.getChildren() as navigationChildren>
                                    <li class="splide__slide st-links__item">
                                        <a href="${navigationChildren.getURL()}" class="st-btn-text-arrow" ${navigationChildren.getTarget()}>
                                            ${navigationChildren.getName()}
                                            <span class="st-icon-arrow-right" aria-hidden="true"></span>
                                        </a>
                                    </li>
                                </#list>
                            </#if>


                        </ul>

                    </div>
                </div>

                <div class="st-wrapper st-bloc-politiques-publiques__inner st-js-slider-politiques-publiques splide st-component-container">
                    <div class="st-limit-height st--is-overflowing">
                        <div class="splide__track st-u-overflow-visible">
                            <ul class="splide__list st-cards-wrapper">
                                <#if navigationEntry.getChildren()?size !=0>
                                    <#list navigationEntry.getChildren() as navigationChildren>
                                        <li class="splide__slide">
                                            <div class="st-card-container">
                                                <a href="${navigationChildren.getURL()}" class="st-card st-card-actu st--with-icon" ${navigationChildren.getTarget()}>
                                                    <div class="st-caption">
                                                        <p class="st-title-card">${navigationChildren.getName()}
                                                        </p>
                                                    </div>
                                                    <div class="st-image">
                                                        <span class="st-icon st-icon-info"></span>
                                                    </div>
                                                </a>
                                            </div>
                                        </li>
                                    </#list>
                                </#if>

                            </ul>
                        </div>

                        <ul class="splide__pagination st-nav-dots" role="tablist" aria-label="Select a slide to show">
                        </ul>
                    </div>

                    <div class="st-show-more">
                        <button class="st-btn-show-more st-btn st--btn-secondary" aria-expanded="false"
                                aria-controls="123" aria-label="Voir tout le contenu" data-open-label="Voir tout le contenu"
                                data-close-label="Réduire l'affichage du contenu">En voir plus
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</#if>