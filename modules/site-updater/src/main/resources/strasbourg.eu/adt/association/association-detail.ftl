<!-- Détail association -->
<#setting locale=locale />
<#setting url_escaping_charset='ISO-8859-1'>
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#assign assetVocabularyHelper=serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />
<#assign utils=serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />
<#-- Liste des infos a partager -->
<#assign openGraph={ "og:description" :'${entry.getPresentation(locale)?replace("<[^>]
*>", "", "r")?html}'
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<#assign uniqueDomaines=[]>
<#list entry.practicesCategories as practiceCategories>
    <#assign currentDomaine=practiceCategories.getDomaine(locale)>
    <#if currentDomaine?is_string && !(uniqueDomaines?seq_contains(currentDomaine))>
        <#assign uniqueDomaines=uniqueDomaines + [currentDomaine]>
    </#if>
</#list>


<#assign uniqueTerritoires=[]>
<#list entry.getTerritories() as territoire>
    <#assign currentTerritoire=territoire.getName()>
    <#assign uniqueTerritoires=uniqueTerritoires + [currentTerritoire]>
</#list>

<div class="st-barre-single-sit st--association">
    <div class="st-barre-inner st-wrapper">
        <div class="st-container-left">
            <div class="st-content">
                <p class="st-surtitre-cat">
                    ${uniqueDomaines?join(", ")}
                </p>
                <p class="st-title">
                    ${entry.getName(locale)}
                </p>
                <p class="st-location">${uniqueTerritoires?join(", ")?truncate(65, '...')}</p>
            </div>
        </div>
        <div class="st-container-right">
            <ul class="st-liens-rapides">
                <#if entry.phone?has_content>
                    <li>
                        <a href="tel:${entry.phone}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener" title="<@liferay_ui.message key=" phone" /> : ${entry.phone}">
                            <span class="st-icon-phone" aria-hidden="true"></span>
                            <span class="st-sr-only"><@liferay_ui.message key=" phone" /> : ${entry.phone}</span>
                        </a>
                    </li>
                </#if>
                <#if entry.getSiteURL(locale)?has_content>
                    <li>
                        <a href="${entry.getSiteURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener" title="Site web">
                            <span class="st-icon-web" aria-hidden="true"></span>
                            <span class="st-sr-only">Site web</span>
                        </a>
                    </li>
                </#if>
                <#if entry.mail?has_content>
                    <li>
                        <a class="st-btn-icon st-btn-icon--white" href="mailto:${entry.mail}" aria-label="Nous contacter par mail">
                            <span class="st-icon-email" aria-hidden="true"></span>
                            <span class="st-sr-only">Nous contacter par mail</span>
                        </a>
                    </li>
                </#if>
                <#if entry.getFacebookURL(locale)?has_content>
                    <li>
                        <a href="${entry.getFacebookURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener" title="<@liferay_ui.message key=" facebook" />">
                            <span class="st-icon-facebook" aria-hidden="true"></span>
                            <span class="st-sr-only">Facebook</span>
                        </a>
                    </li>
                </#if>
            </ul>
            <@strasbourg.socialShare />
        </div>
    </div>
</div>
<header class="st-header-fiche-association">
    <div class="st-wrapper st-wrapper-small">
        <div class="st-heading st-hide-until@t-portrait">
            <h1 class="st-h1 st-title">
                ${entry.getName(locale)}
            </h1>
        </div>
        <@liferay.breadcrumbs />
    </div>
</header>
<div class="st-content">
    <!-- Présentation -->
    <#if entry.getPresentation(locale)?has_content>
        <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
            <h2 class="st-h2 st-bloc-sit-title">Présentation</h2>
            <div class="st-component-container st-text-styles">
                <div class="st-limit-height st--is-overflowing">
                    ${entry.getPresentation(locale)}
                </div>
                <@strasbourg.showMore />
            </div>
        </div>
    </#if>
    <div class="st-bloc st-bloc-sit-onglets st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">Pratiques proposées</h2>
        <div class="st-container">
            <div class="st-slider-tablist st-js-slider-tablist splide" role="tablist">
                <div class="splide__track">
                    <ul class="splide__list">
                        <#assign uniqueDomaines=[]>
                        <#list entry.practicesCategories as practiceCategories>
                            <#assign currentDomaine=practiceCategories.getDomaine(locale)>
                            <#if currentDomaine?is_string && !(uniqueDomaines?seq_contains(currentDomaine))>
                                <#assign uniqueDomaines=uniqueDomaines + [currentDomaine]>
                                <li class="splide__slide">
                                    <button class="st-slider-tablist__button" id="tab-button-${currentDomaine?url}" type="button" role="tab" aria-selected="true" aria-controls="tabpanel-${currentDomaine?url}">
                                        <span class="st-title">${currentDomaine}</span>
                                    </button>

                                </li>
                            </#if>
                        </#list>
                    </ul>
                </div>
                <div class="splide__arrows st-nav-arrows">
                    <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                    <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                </div>
            </div>
            <div class="st-tabpanels">
                <@listGroups entry.practicesCategories; groupName, groupItems>
                    <div class="st-tabpanel st-is-hidden" id="tabpanel-${groupName?url}" role="tabpanel" tabindex="0" aria-labelledby="tab-button-${groupName?url}">
                        <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                            <#list groupItems as groupItem>
                                <li class="st-item-row st--with-location">
                                    <p class="st-surtitre">
                                        ${groupItem.getPratique(locale)}
                                    </p>
                                    <p class="st-text-small">
                                        ${groupName}
                                        <#if groupItem.getSous_specialite(locale)?has_content>
                                            - ${groupItem.getSpecialite(locale)}
                                            <#if groupItem.getSous_sous_specialite(locale)?has_content>
                                                - ${groupItem.getSous_specialite(locale)}
                                            </#if>
                                        </#if>
                                    </p>
                                    <div class="st-info">
                                        <p class="st-surtitre-cat">
                                            ${groupItem.getPublics(locale)}
                                        </p>
                                        <p class="st-location">
                                            ${groupItem.getDistricts(locale)}
                                        </p>
                                    </div>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </@listGroups>
            </div>
        </div>
    </div>
    <div class="st-bloc st-bloc-sit-focus st-wrapper ">
        <div class="st-container">
            <div class="st-col-left">
                <h2 class="st-h2">Contact</h2>
                <p class="st-surtitre-cat">
                    ${entry.getName(locale)}
                </p>
            </div>
            <div class="st-col-right">
                <#if entry.phone?has_content>
                    <a href="tel:${entry.phone}" class="st-btn st--btn-secondary-ghost">
                        ${entry.phone}
                    </a>
                </#if>
                <#if entry.mail?has_content>
                    <a href="mailto:${entry.mail}" class="st-btn st--btn-secondary-ghost">
                        <@liferay_ui.message key="eu.contact-mail" />
                    </a>
                </#if>
            </div>
        </div>
    </div>
</div>
<#macro listGroups items>
    <#if items?size==0>
        <#return>
    </#if>
    <#local sortedItems=items>
    <#local groupStart=0>
    <#list sortedItems as item>
        <#if !item?is_first && item.getDomaine(locale) !=lastItem.getDomaine(locale)>
            <#local groupEnd=item?index>
            <#nested lastItem.getDomaine(locale), sortedItems[groupStart ..< groupEnd]>
            <#local groupStart=groupEnd>
        </#if>
        <#local lastItem=item>
    </#list>
    <#local groupEnd=sortedItems?size>
    <#nested lastItem.getDomaine(locale), sortedItems[groupStart ..< groupEnd]>
</#macro>