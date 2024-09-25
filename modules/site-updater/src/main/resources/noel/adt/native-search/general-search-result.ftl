<#assign curPage = searchResultsPortletDisplayContext.getSearchContainer().getStart()/searchResultsPortletDisplayContext.getSearchContainer().getDelta() + 1 />
<#assign pageCount=(searchResultsPortletDisplayContext.getSearchContainer().getTotal()/searchResultsPortletDisplayContext.getSearchContainer().getDelta())?ceiling />
<#assign keyword = searchResultsPortletDisplayContext.getKeywords() />
<#assign delta = searchResultsPortletDisplayContext.getSearchContainer().getDelta() />
<#assign layoutHelper = serviceLocator.findService("eu.strasbourg.utils.api.LayoutHelperService") />
<#assign journalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleService") />

<div class="container">
    <div class="mns-view-results">
        <div class="mns-result-count">
            ${searchContainer.getTotal()} ${languageUtil.get(locale, "results")}
        </div>
        <div class="mns-filler"></div>
        <div class="mns-result-filter">
            <span>Résultats par page</span>
            <span class="sr-only"><@liferay_ui.message key="reload-after-select" /></span>
            <select name="filter" class="toCustomSelect" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
                <option value="?q=${keyword}&delta=10" <#if delta==10>selected</#if>>10</option>
                <option value="?q=${keyword}&delta=20" <#if delta==20>selected</#if>>20</option>
                <option value="?q=${keyword}&delta=50" <#if delta==50>selected</#if>>50</option>
            </select>
        </div>
    </div>

    <div class="search-asset-search-container">
        <div class="search-asset-results">
            <#if entries?has_content>
                <#list entries as entry>
                    <div>
                        <div class="mns-item-results">
                            <#assign url = entry.getViewURL() />
                            <#if entry.getClassName() == "com.liferay.journal.model.JournalArticle">
                                <#assign journalArticle = journalService.getLatestArticle(entry.getClassPK()) />
                                <#assign detailURL = layoutHelper.getJournalArticleLayoutURL(journalArticle.getGroupId(), journalArticle.getArticleId(), themeDisplay) />
                                <#assign url = detailURL />


                            </#if>


                            <a href="${url}">
                                <h3>${entry.getHighlightedTitle()}</h3>
                                <#if entry.getContent()?has_content>
                                    <p>${entry.getContent()?replace('Entête de page','')?replace('Accueil','')}</p>
                                </#if>
                                <span class="basic-link">Découvrir</span>
                            </a>
                        </div>
                    </div>
                </#list>
            </#if>
        </div>
        <#if (pageCount > 1)>
            <ul class="mns-pagination unstyled">
                <!-- Page précédente -->
                <li class="mns-pagin-prev disabled mns-pagin-item">
                    <#if curPage != 1>
                        <a class="mns-btn-square mns-bordered mns-core" data-action="prev" title="<@liferay_ui.message key="previous" />"
                           href="?q=${keyword}&delta=${delta}&start=${curPage - 1}">
				                        <span class="mns-flexbox">
				                            <span class="mns-btn-text"><@liferay_ui.message key="previous" /></span>
				                            <span class="mns-btn-arrow"></span>
				                        </span>
                        </a>
                    </#if>
                </li>
                <#list 1..pageCount as i>
                    <#if i==curPage>
                        <li class="mns-pagin-item mns-is-active">
					                        <span class="mns-flexbox">
					                            <span class="mns-btn-text">${i}</span>
					                        </span>
                        </li>
                    <#else>
                        <li class="mns-pagin-item">
                            <a href="?q=${keyword}&delta=${delta}&start=${i}">
						                        <span class="mns-flexbox">
						                            <span class="mns-btn-text">${i}</span>
						                        </span>
                            </a>
                        </li>
                    </#if>


                </#list>

                <!-- Page suivante -->
                <li class="mns-pagin-next seu-pagin-item">
                    <#if curPage != pageCount >
                        <a class="mns-btn-square mns-bordered mns-core" title='<@liferay_ui.message key="next" />' href="?q=${keyword}&delta=${delta}&start=${curPage + 1}">
				                        <span class="mns-flexbox">
				                            <span class="mns-btn-text"><@liferay_ui.message key="next" /></span>
				                            <span class="mns-btn-arrow"></span>
				                        </span>
                        </a>
                    </#if>
                </li>
            </ul>
        </#if>



    </div>

</div>