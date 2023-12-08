<#assign portletHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />
<#assign layoutHelper = serviceLocator.findService("eu.strasbourg.utils.api.LayoutHelperService") />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<#function getRootElement curEntry>

    <#assign journalArticle = curEntry.getAssetRenderer().getArticle()>
    <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
    <#assign rootElement = document.getRootElement() />
    <#return rootElement>
</#function>


<#function getFieldValue rootElement name>
    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='${name}']")/>
    <#assign value = xPathSelector.selectSingleNode(rootElement).getStringValue()/>

    <#return value>
</#function>

<#macro addImage fileEntryId showLegende=true showCopyright=true isFigure=true>
    <#if  fileEntryId?has_content && fileEntryId != 0>
        <#local copyright = getCopyright(fileEntryId) />
        <#local legend = getLegend(fileEntryId) />
        <figure class="<#if isFigure>st-figure</#if> st-fit-cover" role="group" aria-label="${copyright} ${legend}">
         <@getImageByFileEntry fileEntryId=fileEntryId />
            <figcaption>
                    <#if legend?has_content && showLegende>
                        ${legend}
                    </#if>
                <#if copyright?has_content>
                    <button type="button" class="st-credits st-js-credits" aria-expanded="false" aria-label="© (copyright de l'image)">©</button>
                    <span class="st-credits-content">${copyright}</span>
                </#if>
            </figcaption>
        </figure>
        <#else>
            <figure class="<#if isFigure>st-figure</#if> st-fit-cover" role="group">
                <img src="https://placehold.co/600x400?text=404" />
            </figure>
    </#if>
</#macro>


<#macro showMore>
    <div class="st-show-more">
        <button class="st-btn-show-more st-btn-arrow st--down"
                aria-expanded="false"
                data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
        </button>
    </div>
</#macro>

<#function getCopyright fileEntryId >
    <#local fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
    <#local copyright = fileEntryHelper.getImageCopyright(fileEntryId?number, locale) />
    <#if copyright?has_content >
        <#return "©  ${copyright}">
    </#if>
    <#return copyright>

</#function>

<#function getLegend fileEntryId >
    <#local fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
    <#local legend = fileEntryHelper.getImageLegend(fileEntryId?number, locale) />
    <#return legend>
</#function>

<#function slugify inputString>
    <#local normalized = inputString?replace("\\s+", "-", "r")?replace("\\n", "-", "r")?lower_case>
    <#local slug = normalized?replace("[^a-z0-9-]", "", "r")>
    <#return slug>
</#function>

<#function getFileFromURL fileURL>
    <#list fileURL?split("/") as x>
        <#if x?counter==3>
            <#assign groupId=x?number>
        </#if>

        <#if x?counter==6>
            <#assign uuId=x?keep_before("?")>
        </#if>
    </#list>
    <#assign
    dlFileEntry=serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>
    <#if (uuId??) && (groupId??)>
        <#assign file=dlFileEntry.getFileEntryByUuidAndGroupId(uuId,groupId)>
        <#return file>
    </#if>

</#function>


<#macro getImage imageNode>
    <#assign fileEntryId = imageNode.getAttribute("fileEntryId")>
    <@addImage fileEntryId=fileEntryId />
</#macro>

<#macro getImageByFileEntry fileEntryId>
    <#assign dlAppServiceUtil = serviceLocator.findService("com.liferay.document.library.kernel.service.DLAppService")>
    <@adaptive_media_image["img"] fileVersion=dlAppServiceUtil.getFileEntry(fileEntryId).getFileVersion() />
</#macro>

<#macro alertError key message>
    <#assign multiSessionErrors = staticUtil["com.liferay.portal.kernel.servlet.MultiSessionErrors"]>
    <#if multiSessionErrors.contains(renderRequest, key)>
        <p class="st-alert-form st--has-error"><@liferay_ui.message key=message /></p>
    </#if>

</#macro>


<#macro alertInfo key message>
    <#assign sessionMessage = staticUtil["com.liferay.portal.kernel.servlet.SessionMessages"]>
    <#if sessionMessage.contains(renderRequest, key)>
        <p class="st-alert-form"><@liferay_ui.message key=message /></p>
    </#if>
</#macro>

<#macro isFavourite entryId entryType title="Item Favori" url="https://strasbourg.eu" entityGroupId="0" >
    <#assign favoriteLocalService = serviceLocator.findService("eu.strasbourg.service.favorite.service.FavoriteLocalService")>
    <#assign isFavouriteBool = favoriteLocalService.isFavorite(entryId, entryType, request.session.getAttribute("publik_internal_id"))>
    <button class="st-btn-favorite-card <#if isFavouriteBool>st-is-favorite</#if>" data-groupId="${entityGroupId}" data-title="${title}" data-url="${url}" data-id="${entryId}" data-type="${entryType}" aria-pressed="<#if isFavouriteBool>true<#else>false</#if>">
        <#if isFavouriteBool>
                <@liferay_ui.message key='eu.remove-from-favorite' />
            <#else>
                <@liferay_ui.message key='eu.add-to-favorite' />
        </#if>
    </button>
</#macro>

<#macro isFavouriteSticky entryId entryType title="Item Favori" url="https://strasbourg.eu" entityGroupId="0" >
    <#assign favoriteLocalService = serviceLocator.findService("eu.strasbourg.service.favorite.service.FavoriteLocalService")>
    <#assign isFavouriteBool = favoriteLocalService.isFavorite(entryId, entryType, request.session.getAttribute("publik_internal_id"))>
    <button class="st-btn-favorite-sticky <#if isFavouriteBool>st-is-favorite</#if>" data-groupId="${entityGroupId}" data-title="${title}" data-url="${url}" data-id="${entryId}" data-type="${entryType}" aria-pressed="<#if isFavouriteBool>true<#else>false</#if>">
        <#if isFavouriteBool>
            <@liferay_ui.message key='eu.remove-from-favorite' />
        <#else>
            <@liferay_ui.message key='eu.add-to-favorite' />
        </#if>
    </button>
</#macro>