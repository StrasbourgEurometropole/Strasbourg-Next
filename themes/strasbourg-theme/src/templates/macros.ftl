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

<#macro addImage fileEntryId showLegende=false showCopyright=false isFigure=false>
    <#if  fileEntryId?has_content && fileEntryId != 0>
        <figure class="<#if isFigure>st-figure</#if> st-fit-cover" role="group">
         <@getImageByFileEntry fileEntryId=fileEntryId />
        </figure>
        <#else>
            <figure class="<#if isFigure>st-figure</#if> st-fit-cover" role="group">
                <img src="https://placehold.co/600x400?text=404" />
            </figure>
    </#if>
</#macro>


<#macro showMore>
    <div class="st-show-more">
        <button class="st-btn-show-more st-btn-arrow st--down" aria-expanded="false" aria-controls="123"
                aria-label="<@liferay_ui.message key='eu.view-more' />" data-open-label="<@liferay_ui.message key='eu.view-more' />"
                data-close-label="<@liferay_ui.message key='eu.view-less' />">
        </button>
    </div>
</#macro>

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


<#macro getImage imageNode showCopyright=false>
    <#assign imageURL = imageNode.getData()>
    <#assign fileEntryId = imageNode.getAttribute("fileEntryId")>
    <#assign copyright = imageNode.getAttribute("alt")>
    <#assign legende = imageNode.getAttribute("alt")>

    <#if showCopyright == true>
        <span class="st-credits" aria-hidden="true">${copyright}</span>
    </#if>
    <figure class="st-figure st-fit-cover<#if !legende?has_content && copyright?has_content> figcaption-only-credits</#if>" role="group" aria-label="${legende} © ${copyright}">
        <picture>
            <img data-fileentryid="${fileEntryId}"
                    alt="${legende}"
                    src="${imageURL}">
        </picture>
    </figure>
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

<#macro isFavourite entryId entryType >
    <#assign favoriteLocalService = serviceLocator.findService("eu.strasbourg.service.favorite.service.FavoriteLocalService")>
    <#assign isFavouriteBool = favoriteLocalService.isFavorite(entryId, entryType, request.session.getAttribute("publik_internal_id"))>
    <button class="st-btn-favorite-card <#if isFavouriteBool>st-is-favorite</#if>">
        <@liferay_ui.message key='eu.add-to-favorite' />
    </button>
</#macro>