<!-- Rubrique -->
<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<header class="st-header-edito" role="banner">
    <div class="st-wrapper">
        <div class="st-wrapper-modifier">
            <h1 class="st-h1">
                ${layout.getName(locale)}
            </h1>
            <@liferay.breadcrumbs />
            <p>
                ${layout.getDescription(locale)}
            </p>
        </div>
    </div>
</header>
<#if entries?has_content>
    <#list entries as currentPage>
        <#if currentPage.getName(locale) !='Raccourcis' && !currentPage.hidden>
            <#assign hasImage=currentPage.expandoBridge.getAttribute('image')?has_content />
            <#assign hasVisibleChildren=false>
            <#if currentPage.children?has_content>
                <#list currentPage.children as currentSubPage>
                    <#if !currentSubPage.hidden>
                        <#assign hasVisibleChildren=true>
                        <#break>
                    </#if>
                </#list>
            </#if>
            <#if hasImage>
                <div class="st-bloc st-bloc-image-hub st-wrapper st--has-margin">
                    <div class="st-wrapper-modifier">
                        <div class="st-container <#if currentPage?is_even_item>st--text-right<#else>st--text-left</#if>">
                            <div class="st-col-text">
                                <div class="st-text-styles">
                                    <h2 class="st-h2">${currentPage.getName(locale)}</h2>
                                </div>
                                <div class="st-component-container">
                                    <ul class="st-liste st-limit-height">
                                        <li class="st-lien-container">
                                            <a href="${homeURL}${currentPage.friendlyURL?remove_beginning('/')}" class="st-lien">
                                                <p class="st-title-lien">
                                                    ${currentPage.getName(locale)}
                                                </p>
                                                <span class="st-btn-arrow st--btn-outline st--next" aria-hidden="true"></span>
                                            </a>
                                        </li>
                                        <#list currentPage.children as currentSubPage>
                                            <#if !currentSubPage.hidden>
                                                <li class="st-lien-container">
                                                    <a href="${homeURL}${currentSubPage.friendlyURL?remove_beginning('/')}" class="st-lien">
                                                        <p class="st-title-lien">
                                                            ${currentSubPage.getName(locale)}
                                                        </p>
                                                        <span class="st-btn-arrow st--btn-outline st--next" aria-hidden="true"></span>
                                                    </a>
                                                </li>
                                            </#if>
                                        </#list>
                                    </ul>
                                    <div class="st-show-more">
                                        <button class="st-btn-show-more st-btn-arrow st--down"
                                                aria-expanded="false"
                                                data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <#if hasImage>
                                <#assign backgroundImage=currentPage.expandoBridge.getAttribute('image') />
                                <div class="st-st-col-image">
                                    <div class="st-image">
                                        <span class="st-credits" aria-hidden="true">© Abraham Lebowski</span>
                                        <figure class="st-figure st-fit-cover figcaption-only-credits" role="group"
                                                aria-label="Photo, © Abraham Lebowski">
                                            <picture>
                                                <img alt="Photo" src="${backgroundImage}">
                                            </picture>
                                        </figure>
                                    </div>
                                </div>
                            </#if>
                        </div>
                    </div>
                </div>

            <#else>
                <div class="st-bloc st-bloc-image-hub st-wrapper st--has-margin">
                    <div class="st-container st--text-only">
                        <div class="st-col-text">
                            <div class="st-text-styles">
                                <h2 class="st-h2">
                                    ${currentPage.getName(locale)}
                                </h2>
                                <div class="st-component-container">
                                    <ul class="st-liste st-limit-height">
                                        <li class="st-lien-container">
                                            <a href="${homeURL}${currentPage.friendlyURL?remove_beginning('/')}" class="st-lien">
                                                <p class="st-title-lien">
                                                    ${currentPage.getName(locale)}
                                                </p>
                                                <span class="st-btn-arrow st--btn-outline st--next" aria-hidden="true"></span>
                                            </a>
                                        </li>
                                        <#list currentPage.children as currentSubPage>
                                            <#if !currentSubPage.hidden>
                                                <li class="st-lien-container">
                                                    <a href="${homeURL}${currentSubPage.friendlyURL?remove_beginning('/')}" class="st-lien">
                                                        <p class="st-title-lien">
                                                            ${currentSubPage.getName(locale)}
                                                        </p>
                                                        <span class="st-btn-arrow st--btn-outline st--next" aria-hidden="true"></span>
                                                    </a>
                                                </li>
                                            </#if>
                                        </#list>
                                    </ul>
                                    <div class="st-show-more">
                                        <button class="st-btn-show-more st-btn-arrow st--down"
                                                aria-expanded="false"
                                                data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#if>
        </#if>
    </#list>
</#if>