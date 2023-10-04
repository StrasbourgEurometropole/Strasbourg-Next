<!-- Rubrique -->
<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#list entries as nav_item>
    <#if nav_item.getLayout()??>
        <#assign backgroundImage=nav_item.getLayout().expandoBridge.getAttribute('image') />
        <div class="st-bloc st-bloc-image-hub st-wrapper st--has-margin">
            <div class="st-container <#if nav_item?is_even_item>st--text-right<#else>st--text-left</#if>">
                <div class="st-col-text">
                    <div class="st-text-styles">
                        <h2 class="st-h2">
                            ${nav_item.getName()}
                        </h2>
                    </div>
                    <div class="st-component-container">
                        <ul class="st-liste st-limit-height">
                            <#list nav_item.getChildren() as nav_child>
                                <li class="st-lien-container">
                                    <a href="${nav_child.getURL()}" ${nav_child.getTarget()} class="st-lien">
                                        <p class="st-title-lien">
                                            ${nav_child.getName()}
                                        </p>
                                        <span class="st-btn-arrow st--btn-outline st--next"
                                              aria-hidden="true"></span>
                                    </a>
                                </li>
                            </#list>
                        </ul>
                        <div class="st-show-more">
                            <button class="st-btn-show-more st-btn-arrow st--down" aria-expanded="false"
                                    aria-controls="123" aria-label="Voir tout le texte"
                                    data-open-label="Voir tout le texte"
                                    data-close-label="Réduire l'affichage du texte">
                            </button>
                        </div>
                    </div>
                </div>
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
            </div>
        </div>
    <#else>
        <div class="st-bloc st-bloc-image-hub st-wrapper st--has-margin">
            <div class="st-container st--text-only">
                <div class="st-col-text">
                    <div class="st-text-styles">
                        <h2 class="st-h2">
                            ${nav_item.getName()}
                        </h2>
                        <div class="st-component-container">
                            <ul class="st-liste st-limit-height">
                                <#list nav_item.getChildren() as nav_child>
                                    <li class="st-lien-container">
                                        <a href="${nav_child.getURL()}" ${nav_child.getTarget()} class="st-lien">
                                            <p class="st-title-lien">
                                                ${nav_child.getName()}
                                            </p>
                                            <span class="st-btn-arrow st--btn-outline st--next"
                                                  aria-hidden="true"></span>
                                        </a>
                                    </li>
                                </#list>
                            </ul>
                            <div class="st-show-more">
                                <button class="st-btn-show-more st-btn-arrow st--down" aria-expanded="false"
                                        aria-controls="123" aria-label="Voir tout le texte"
                                        data-open-label="Voir tout le texte"
                                        data-close-label="Réduire l'affichage du texte">
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#if>
</#list>