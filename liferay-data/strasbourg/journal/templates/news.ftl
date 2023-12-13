<#setting locale=localeUtil.getDefault() />
<#assign displayDate=.vars['reserved-article-display-date'].getData()?date("EEE, dd MMM yyyy hh:mm:ss Z") />
<#assign modifiedDate=.vars['reserved-article-display-date'].getData()?date("EEE, dd MMM yyyy hh:mm:ss Z") />
<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
<#assign serviceContext=staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext() />
<#assign request=serviceContext.getRequest() />
<#assign currentUrl=themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />
<#assign imageUrl="" />
<!-- image -->
<#if thumbnail.getData()?has_content>
    <#assign imageUrl=themeDisplay.getPortalURL() + thumbnail.getData()?replace('@', "" )?replace('cdn_hostroot_path', "" ) />
</#if>
<#assign journalArticleLocalService=serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")>
<#assign journalArticle=journalArticleLocalService.getArticle(groupId, .vars['reserved-article-id'].data)>
<#assign assetEntryLocalService=serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
<#assign asset=assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', journalArticle.getResourcePrimKey())>
<#assign assetVocabularyHelper=serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />
<#assign newsTypes=assetVocabularyHelper.getAssetEntryCategoriesByVocabulary(asset, "type d'actualite" ) />
<#-- Liste des infos a partager -->
<#assign openGraph={ "og:title" :"${title.getData()?html}", "og:description" :'${chapo.getData()?replace("<[^>]
*>", "", "r")?html}', "og:image" :"${imageUrl}"
} />
<div class="st-barre-single-sit st--actualite st-hide-until@t-portrait">
    <div class="st-barre-inner st-wrapper">
        <div class="st-container-left">
            <div class="st-content">
                <p class="st-surtitre-cat">
                    ${newsTypes?map(news -> news.getTitle(locale))?join(', ')}
                </p>
                <p class="st-title">
                    ${title.getData()}
                </p>
            </div>
        </div>
        <div class="st-container-right">
            <#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/social-share.ftl" />
        </div>
    </div>
</div>
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<header class="st-header-fiche-actualite">
    <div class="st-wrapper st-wrapper-small">
        <div class="st-heading">
            <p class="st-surtitre-cat">
                ${newsTypes?map(news -> news.getTitle(locale))?join(', ')}
            </p>
            <p class="st-date">
                <@liferay_ui.message key="eu.published-on" />
                ${displayDate?string["dd/MM/yyyy"]}
                -
                <@liferay_ui.message key="eu.modified-on" />
                ${modifiedDate?string["dd/MM/yyyy"]}
            </p>
            <h1 class="st-h1 st-title">
                ${title.getData()}
            </h1>
        </div>
        <@liferay.breadcrumbs />
        <#if (image.getData())?? && image.getData() !="">
            <div class="st-image">
                <@getImage imageNode=image />
            </div>
        </#if>
    </div>
</header>
<div class="st-content">
    <div class="st-bloc st-wrapper st-text-styles st-wrapper-small st--has-margin">
        <p class="st-surtitre">
            ${chapo.getData()}
        </p>
        ${content.getData()}
    </div>
</div>
<style>
    .search-asset-portlet,
    .portlet-body .component-title {
        display: none !important;
    }

    .lfr-tooltip-scope {
        position: absolute;
        right: 0;
    }
</style>