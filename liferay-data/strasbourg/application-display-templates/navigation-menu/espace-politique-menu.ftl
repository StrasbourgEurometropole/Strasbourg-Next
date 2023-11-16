<header class="st-header-presse st-u-overflow-x-hidden" role="banner">
    <div class="st-wrapper">


        <div class="st-nav-onglets st-u-overflow-x-hidden">

            <div class="st-slider-nav st-js-nav-onglets splide st-hide-until@mobileis-active is-overflow">
                <div class="splide__track st-u-overflow-visible">
                    <ul class="splide__list">

                        <#if entries?has_content>
                            <#list entries as navigationEntry>
                                <li class="splide__slide">
                                    <a href="${navigationEntry.getURL()}" class="st-link-onglets st-is-current">
                                        ${navigationEntry.getName()}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </ul>
                </div>
                <div class="splide__arrows st-nav-arrows">
                    <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                    <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                </div>
            </div>

            <div class="st-select-nav st-hide-from@mobile form-styles">
                <label for="select-menu">Espace presse</label>
                <div class="st-field-select">
                    <select id="select-menu" name="select-menu" class="st-js-nav-select">
                        <#if entries?has_content>
                            <#list entries as navigationEntry>
                                <option value="${navigationEntry.getURL()}">${navigationEntry.getName()}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>

        </div>
    </div>
</header>