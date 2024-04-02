
<div class="st-strate-footer">
    <div class="st-strate-partenaires st-js-slider-partenaires splide" role="group">
        <div class="st-wrapper st-wrapper-small">
            <h2 class="st-h2"><@liferay.language key="galaxie" /></h2>
            <div class="st-slider-container">
                <div class="splide__arrows st-nav-arrows st-hide-until@mobile">
                    <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                    <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                </div>
                <div class="splide__track">
                    <ul class="splide__list">
                        <#if GalaxiesFieldset.getSiblings()?has_content>
                            <#list GalaxiesFieldset.getSiblings() as cur_GalaxiesFieldset>
                                <li class="splide__slide">
                                    <a href="<#if (cur_GalaxiesFieldset.ExternalLinkText.getData())??>${cur_GalaxiesFieldset.ExternalLinkText.getData()}<#else>${cur_GalaxiesFieldset.InternalLink.getFriendlyUrl()}</#if>"
                                       class="st-container">
                                        <#if (cur_GalaxiesFieldset.ImagePicto.getData())?? && cur_GalaxiesFieldset.ImagePicto.getData() !="">
                                            <@strasbourg.getImage imageNode=cur_GalaxiesFieldset.ImagePicto showLegende=false showCopyright=false maxWidth=100  />
                                        </#if>
                                        <span class="st-sr-only">
                                            <#if (cur_GalaxiesFieldset.ExternalLinkText.getData())??>
                                                ${cur_GalaxiesFieldset.ExternalLinkText.getData()}
                                            <#else>
                                                ${cur_GalaxiesFieldset.InternalLink.getFriendlyUrl()}
                                            </#if>
                                        </span>
                                        <span class="st-tooltip-logo" aria-hidden="true">
                      <#if (cur_GalaxiesFieldset.NomText.getData())??>
                          ${cur_GalaxiesFieldset.NomText.getData()}
                      </#if>
                    </span>
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </ul>
                </div>
            </div>
            <ul class="splide__pagination st-nav-dots st--color-dark"></ul>
        </div>
    </div>
</div>
