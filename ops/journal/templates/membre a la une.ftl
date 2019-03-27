<!-- MEMBRE A LA UNE -->

<#-- Création de l'URL de détail -->
<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")>
<#assign journalArticle = journalArticleLocalService.getArticle(groupId, .vars['reserved-article-id'].data)>
<#assign layoutHelper = serviceLocator.findService("eu.strasbourg.utils.api.LayoutHelperService") />
<#assign detailURL = layoutHelper.getJournalArticleLayoutURL(journalArticle.groupId, journalArticle.articleId, themeDisplay) />
 
<a id="#ops-director-orchestre" href="${detailURL}" class="ops-director-orchestre ops-content-wrapper">
    <figure class="fit-cover">
        <img src="${smallImage.getData()}" width="1220" height="450" alt="${Name.getData()}" />
        <figcaption>${credit.getData()}</figcaption>
    </figure>
    <div class="ops-info-people">
        <span class="ops-function">${post.getData()}</span>
        <span class="ops-name">${Name.getData()}</span>
        <span class="ops-link">En savoir plus</span>
    </div>
</a>