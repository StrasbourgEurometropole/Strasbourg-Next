<!-- Détail association -->
<#setting locale=locale />
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
<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
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
                <p class="st-location">Adresse</p>
            </div>
        </div>
        <div class="st-container-right">
            <ul class="st-liens-rapides">
                <#if entry.phone?has_content>
                    <li>
                        <a href="tel:${entry.phone}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener" title="<@liferay_ui.message key=" phone" /> : ${entry.phone}">
                            <span class="st-icon-phone" aria-hidden="true"></span>
                        </a>
                    </li>
                </#if>
                <#if entry.getSiteURL(locale)?has_content>
                    <li>
                        <a href="${entry.getSiteURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener" title="<@liferay_ui.message key=" eu.website" /> (
                                    <@liferay_ui.message key="eu.new-window" />)">
                            <span class="st-icon-web" aria-hidden="true"></span>
                        </a>
                    </li>
                </#if>
                <#if entry.mail?has_content>
                    <li>
                        <a class="st-btn-icon st-btn-icon--white" href="mailto:${entry.mail}" aria-label="Nous contacter par mail">
                            <span class="st-icon-email" aria-hidden="true"></span>
                        </a>
                    </li>
                </#if>
                <#if entry.getFacebookURL(locale)?has_content>
                    <li>
                        <a href="${entry.getFacebookURL(locale)}" class="st-btn-icon st-btn-icon--white" target="_blank" rel="noopener" title="<@liferay_ui.message key=" facebook" /> (
                                    <@liferay_ui.message key="eu.new-window" />)">
                            <span class="st-icon-facebook" aria-hidden="true"></span>
                        </a>
                    </li>
                </#if>
            </ul>
            <div class="st-social-share">
                <input class="st-toggle-input" id="toggle-input" type="checkbox">
                <label for="toggle-input" class="st-toggle">
                    <span class="st-icon-social-share"></span>
                </label>
                <#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/network-list.ftl" />
            </div>
        </div>
    </div>
</div>
<header class="st-header-fiche-association" role="banner">
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
                <@showMore />
            </div>
        </div>
    </#if>
    <div class="st-bloc st-bloc-sit-onglets st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">Pratiques proposées</h2>
        <div class="st-container">
            <div class="st-slider-thumb st-js-slider-onglet splide" role="group"
                 aria-label="Slider avec des informations sur les horaires de visite">
                <div class="splide__track">
                    <ul class="splide__list">
                        <#assign uniqueDomaines=[]>
                        <#list entry.practicesCategories as practiceCategories>
                            <#assign currentDomaine=practiceCategories.getDomaine(locale)>
                            <#if currentDomaine?is_string && !(uniqueDomaines?seq_contains(currentDomaine))>
                                <#assign uniqueDomaines=uniqueDomaines + [currentDomaine]>
                                <li class="splide__slide">
                                    <p class="st-title">
                                        ${currentDomaine}
                                    </p>
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
            <div class="st-slider-content st-js-slider-onglet-content splide" role="group"
                 aria-label="Contenu des slides">
                <div class="splide__track">
                    <ul class="splide__list">
                        <@listGroups entry.practicesCategories; groupName, groupItems>
                            <li class="splide__slide st-single-slide">
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
                            </li>
                        </@listGroups>
                    </ul>
                </div>
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