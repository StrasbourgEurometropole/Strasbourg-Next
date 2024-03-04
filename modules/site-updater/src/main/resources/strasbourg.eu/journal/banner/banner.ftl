<!-- Banniere accueil -->

<div class="st-barre-liens-en-avant st-js-slider-barre-liens splide st-u-overflow-x-hidden" role="group">
    <div class="st-wrapper">
        <div class="st-slider-container">
            <div class="splide__arrows st-nav-arrows">
                <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
            </div>
            <div class="splide__track">
                <ul class="splide__list">
                    <#if linkLabelFieldSet.getSiblings()?has_content>
                        <#list linkLabelFieldSet.getSiblings() as cur_linkLabelFieldSet>
                            <li class="splide__slide">
                                <#if cur_linkLabelFieldSet.linkURL.getFriendlyUrl()?has_content>
                                <a href="${cur_linkLabelFieldSet.linkURL.getFriendlyUrl()}" <#if getterUtil.getBoolean(cur_linkLabelFieldSet.externalLinkFieldSet.activeTab.getData())>target="_blank"</#if> class="st-container">
                                    <#else>
                                    <#if (cur_linkLabelFieldSet.externalLinkFieldSet.externalLink.getData())??>
                                    <a href="${cur_linkLabelFieldSet.externalLinkFieldSet.externalLink.getData()}"
                                       <#if getterUtil.getBoolean(cur_linkLabelFieldSet.externalLinkFieldSet.activeTab.getData())>target="_blank"</#if>
                                       class="st-container">
                                        <#else>
                                        <a href="#" class="st-container">
                                            </#if>
                                            </#if>
                                            <div class="st-content">
                                                <h2 class="st-title">
                                                    <strong>
                                                        <#if (cur_linkLabelFieldSet.linkLabel.getData())??>
                                                            ${cur_linkLabelFieldSet.linkLabel.getData()}
                                                        </#if>
                                                    </strong>
                                                </h2>
                                                <p class="st-text">
                                                    <#if (cur_linkLabelFieldSet.DescriptionText.getData())??>
                                                        ${cur_linkLabelFieldSet.DescriptionText.getData()}
                                                    </#if>
                                                </p>
                                            </div>
                                            <span class="st-btn-arrow st--btn-outline st--next" aria-hidden="true"></span>
                                        </a>
                            </li>
                        </#list>
                    </#if>
                </ul>
            </div>
        </div>
    </div>
</div>
