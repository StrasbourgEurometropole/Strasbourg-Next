<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<section id="expo">
    <div  class="content container">
        <h2>
            <@liferay_ui.message key="eu.museum.expos" />
            <span><@liferay_ui.message key="eu.museum.collection.discover" /></span>
        </h2>
        <#if entries?has_content>
            <div class="list">
        	    <#list entries as curEntry>
                    <#if curEntry?has_content && curEntry.getAssetRenderer()?has_content && curEntry.getAssetRenderer().getArticle()?has_content>
                        <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
                        <#assign image = docXml.valueOf("//dynamic-element[@name='image']/dynamic-content/text()") />
                        <#assign assetPublisherTemplateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.AssetPublisherTemplateHelperService")/>
                        <#assign imageURL ="" />
                        <#if image?has_content>
                            <#assign imageURL = assetPublisherTemplateHelperService.getDocumentUrl(image) />
                        </#if>
                        <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()") />
                        <#assign dates = docXml.valueOf("//dynamic-element[@name='dates']/dynamic-content/text()") />
                        <a href="" aria-label="${title}" title="${title}" class="expo-thumbnail">
                            <img src="${imageURL}" alt="${title}" title="${title}" />
                            <div class="info">
                                <div class="title">
                                    <span>${title}</span>
                                </div>
                                <div class="museums">
                                    <#if curEntry.categories?first?has_content>
                                        <#assign vocabularyLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService") />
                                        <span>
                                            <#assign nbMusees = 0 />
                                            <#list curEntry.categories as category>
                                                <#assign vocabulary = vocabularyLocalService.getVocabulary(category.vocabularyId) />
                                                <#if vocabulary.name == "Musées">
                                                    <#if nbMusees gt 0 >
                                                        , 
                                                    </#if>
                                                    ${category.getTitle(locale)}
                                                    <#assign nbMusees++ />
                                                </#if>
                                            </#list>
                                        </span>
                                    </#if>
                                </div>
                                <div class="dates">
                                    <span>${dates}</span>
                                </div>
            
                                <button class="button1" aria-label="<@liferay_ui.message key="eu.museum.know-more" />" title='<@liferay_ui.message key="eu.museum.know-more" />'>
                                    <span class="points">
                                        <span class="trait">
                                            <span class="background">
                                                <span>
                                                    <@liferay_ui.message key="eu.museum.know-more" />
                                                </span>
                                            </span>
                                        </span>
                                    </span>
                                </button>
                            </div>
                        </a>
                    </#if>
                </#list>
            </div>
        </#if>
    </div>
</section>