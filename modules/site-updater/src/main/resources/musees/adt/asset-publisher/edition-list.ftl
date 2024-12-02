<#setting locale = locale />

<#if entries?has_content>
    <section id="editions" class="margin-bottom">
        <div  class="content container">
            <div class="infos">
                <h2><@liferay_ui.message key="eu.museum.editions" /></h2>
            </div>
                <div id="listEditions" class="list">
                    <#list entries as curEntry>
                        <#assign edition = curEntry.getAssetRenderer().getEdition() />
                        <#assign detailURL = strasbourg.homeURL() + "edition/-/entity/id/" + edition.editionId />
                        <a href="${detailURL}" aria-label="${edition.getTitle(locale)?html}" title="${edition.getTitle(locale)?html}" class="edition-thumbnail-list">
                            <img src="${edition.getImageURL()}" alt="${edition.getTitle(locale)?html}" title="${edition.getTitle(locale)?html}" />
                            <div class="info">
                                <div class="title">
                                    <span>${edition.getTitle(locale)}</span>
                                </div>
                                <div class="museums">
                                    <span>${edition.getMuseumsLabel(locale)}</span>
                                </div>
                            </div>
                        </a>
                    </#list>
                </div>
        </div>
    </section>
</#if>