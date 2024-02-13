<!-- Vignette actualité -->

<#setting locale = locale />

<#if entry?has_content>
    <#-- Récupération des champs du contenu web -->
    <#assign docXml = saxReaderUtil.read(entry.getContentByLocale(locale)) />
    <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()")/>
    <#if !title?has_content><#assign title = entry.getTitle(locale) /></#if>
    <#assign chapo = docXml.valueOf("//dynamic-element[@name='chapo']/dynamic-content/text()") />
    <#assign text = docXml.valueOf("//dynamic-element[@name='text']/dynamic-content/text()") />
    <#assign thumbnail = docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
    <#assign assetPublisherTemplateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.AssetPublisherTemplateHelperService")/>
    <#assign imageURL ="" />
    <#if thumbnail?has_content>
        <#assign imageURL = assetPublisherTemplateHelperService.getDocumentUrl(thumbnail) />
    </#if>
                    
    <#-- Récupération des catégories "Type d'actualité de l'entité -->
    <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
    <#assign assetVocabularyHelper = serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />

    <#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', entry.resourcePrimKey) >
    <#assign newsTypes = assetVocabularyHelper.getAssetEntryCategoriesByVocabulary(asset, "type d-'actualite") />

    <#-- Création de l'URL de détail -->
    <#assign layoutHelper = serviceLocator.findService("eu.strasbourg.utils.api.LayoutHelperService") />
    <#assign detailURL = layoutHelper.getJournalArticleLayoutURL(entry.groupId, entry.articleId, themeDisplay) />

    <#-- Récupération de DateHelper pour le format date -->
    <#assign dateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.DateHelperService") />

    <@liferay_portlet.actionURL var="detailURLFilter">
      <@liferay_portlet.param name="userTargetClassId" value="${entry.getClassNameId()}" />
      <@liferay_portlet.param name="userTargetClassPK" value="${entry.getArticleId()}" />
      <@liferay_portlet.param name="userTargetTitle" value="${title}" />
      <@liferay_portlet.param name="detailURL" value="${detailURL}" />
      <@liferay_portlet.param name="searchLogId" value="${renderRequest.getAttribute('searchLogId')!0}" />
    </@liferay_portlet.actionURL>

    <li>
    <div class="st-card-container">
        <a  href="${detailURL}" class="st-card st-card-actu">
            <div class="st-caption">
                <p class="st-title-card">${title}</p>
                <p class="st-surtitre-cat">${newsTypes?map(news -> news.getTitle(locale))?join(', ')}</p>
                <p class="st-date">Publié le ${dateHelperService.displayShortDate(entry.getModifiedDate()?date, locale)}</p>
            </div>
            <div class="st-image">
                <figure class="st-figure st-fit-cover" role="group">
                    <picture>
                        <img alt="" src="${imageURL}" />
                    </picture>
                </figure>
            </div>
        </a>
    </div>
</li>

</#if>