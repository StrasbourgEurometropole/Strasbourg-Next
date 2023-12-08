<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
<div class="st-listing-cards st-wrapper st-wrapper-small">
    <h3>
        ${searchContainer.total} resultats
        </h4>
        <ul class="st-cards-wrapper st--has-cards-vertical st-basic-grid st-col-3@mobile st-col-4@t-small">
            <#if entries?has_content>
                <#list entries as entry>
                    <#assign resultMap={}>
                    <#assign
                    templateHelperService=serviceLocator.findService("eu.strasbourg.utils.api.TemplateHelperService") />
                    <#list entry.getDocumentFormFieldDisplayContexts() as item>
                        <#assign key=item.name>
                        <#assign resultMap=resultMap + {key:
                        templateHelperService.unescapeHtml(item.getValuesToString()) }>
                    </#list>
                    <li>
                        <div class="st-card-container">
                            <a href="#" class="st-card" data-overlay-open="st-overlay-preview-activite"
                               onclick="updateModalActivity(this)">
                                <div class="st-caption">
                                    <p class="st-title-card">${entry.getTitle()}</p>
                                    <p class="st-surtitre-cat">${resultMap["typeLabel"]!""}</p>
                                    <p class="st-text">${resultMap["descriptionWithoutHTML"]!""}</p>
                                </div>

                                <div class="st-image">
                                    <@addImage fileEntryId=resultMap["imageEntityId"]?number showLegende=false showCopyright=false isFigure=true />

                                </div>

                            </a>
                            <div class="cours-list st-hide">
                                <#assign overlayContentObjectString=resultMap["activityOverlayContent"]!"{}">
                                <#assign
                                overlayContentArray=jsonFactoryUtil.createJSONArray(overlayContentObjectString)>
                                <#list 0 ..< overlayContentArray.length() as i>
                                    <#assign cours=overlayContentArray.get(i)>
                                    <div class='st-container'>
                                        <p class='st-title-small'>${cours.get("name")}</p>
                                        <p class='st-surtitre-cat'>${cours.get("typesLabels")},
                                            ${cours.get("publicsLabel")}</p>
                                        <#if cours.get("duration") !=0>
                                            <p class='st-surtitre-alt'><@liferay.language key="duration.average" /> ${cours.get("duration")} mins</p>
                                        </#if>

                                        <p class='st-location'>${cours.get("placeNames")}</p>
                                        <div class='st-text st-text-styles'>
                                            <p>
                                                ${cours.get("description")!""}
                                            </p>
                                        </div>
                                        <a href='${homeURL}/cours/-/entity/id/${cours.get("activityCourseId")}'
                                           title="${cours.get("name")}"
                                           class='st-btn st--btn-full-width-mobile'>En savoir plus</a>
                                    </div>
                                </#list>

                            </div>


                        </div>
                    </li>
                </#list>
            </#if>

        </ul>
</div>

<#assign pageSize=searchContainer.delta />
<#assign currentPage=searchContainer.cur />
<#assign totalResults=searchContainer.total />
<#assign totalPages=(totalResults + pageSize - 1) / pageSize />

<#if totalPages gte 1>
    <nav class="st-wrapper st-wrapper-small st-pagination" role="navigation" aria-label="Pagination">
        <ul class="st-pagination__list">
            <#if currentPage !=1>
                <li class="st-pagination__item st--prev">
                    <a rel="prev" class="st-btn-arrow st--prev" aria-disabled="false" href="?${searchContainer.deltaParam}=${searchContainer.delta}&${searchContainer.curParam}=${currentPage - 1}">
                        <span class="st-sr-only">Précédent</span>
                    </a>
                </li>

            <#else>
                <li class="st-pagination__item st--prev">
                    <a rel="prev" class="st-btn-arrow st--prev" aria-disabled="true">
                        <span class="st-sr-only">Précédent</span>
                    </a>
                </li>

            </#if>

                <#list 1..totalPages as page>
                    <#if (totalPages> 10) && (page < currentPage - 2 || page> currentPage + 2)>
                        <#if (page==1 && currentPage> 3)>
                            <li class="st-pagination__item">
                                <a href="?${searchContainer.deltaParam}=${searchContainer.delta}&${searchContainer.curParam}=${page}" class="st-pagination__link" aria-label="Page ${page}" aria-current="false">${page}</a>
                            </li>
                            <li class="st-pagination__item">
                                <span class="st-pagination__dots">...</span>
                            </li>
                        <#elseif (page==totalPages && currentPage < totalPages - 2)>
                            <li class="st-pagination__item">
                                <span class="st-pagination__dots">...</span>
                            </li>

                            <li class="st-pagination__item">
                                <a href="?${searchContainer.deltaParam}=${searchContainer.delta}&${searchContainer.curParam}=${page}" class="st-pagination__link" aria-label="Page ${page}" aria-current="false">${page}</a>
                            </li>
                        </#if>
                    <#else>
                        <#if page==currentPage>
                            <li class="st-pagination__item">
                                <a href="#" class="st-pagination__link st-is-active" aria-label="Page ${page}" aria-current="true">${page}</a>
                            </li>

                        <#else>
                            <li class="st-pagination__item">
                                <a href="?${searchContainer.deltaParam}=${searchContainer.delta}&${searchContainer.curParam}=${page}" class="st-pagination__link" aria-label="Page ${page}" aria-current="false">${page}</a>
                            </li>
                        </#if>
                    </#if>
                </#list>

            <#if currentPage < totalPages>
                <li class="st-pagination__item st--next">
                    <a href="?${searchContainer.deltaParam}=${searchContainer.delta}&${searchContainer.curParam}=${currentPage + 1}" rel="next" class="st-btn-arrow st--next">
                        <span class="st-sr-only">Suivant</span>
                    </a>
                </li>

            </#if>
        </div>
    </nav>
</#if>


<div id="st-overlay-preview-activite" class="st-overlay st-overlay-preview-activite " role="dialog" aria-modal="true"
     tabindex="0" aria-label="Modale de liste">
    <button class="st-btn-close" data-overlay-close="st-overlay-preview-activite"
            aria-label="Fermer"></button>

    <div class="st-overlay__inner">
        <div class="st-overlay__body st-custom-scrollbar">

            <div class="st-overlay__heading">
                <span class="st-surtitre-cat"></span>
                <span class="st-title-overlay st-h2"></span>
            </div>

            <div class="st-overlay__content">
                <div class="st-intro st-text-styles">
                    <p></p>
                </div>
                <div class="cours">
                </div>
            </div>
        </div>
    </div>
</div>