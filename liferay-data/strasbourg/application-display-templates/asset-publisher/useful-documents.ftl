<!-- Documents utiles (externes) -->
<#setting locale = locale />
<#assign portletHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />
<#assign fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />

<div class="st-bloc st-wrapper st--has-margin-small">
    <h2 class="st-h2">${portletHelper.getPortletTitle('eu.useful-documents', renderRequest)}</h2>
</div>

<#if !entries?has_content && themeDisplay.isSignedIn()>
    <div>
        Documents utiles - Aucune entrée (message non-visible par les visiteurs)
    </div>
</#if>


<div class="st-bloc st-bloc-liens st-wrapper st--has-margin">
    <div class="st-component-container">
        <ul class="st-liste st-limit-height">
            <#list entries as curEntry>
                <#assign file = curEntry.getAssetRenderer().getAssetObject() />
                <#if fileEntryHelper.getFileTitle??>
                    <#assign fileTitle = fileEntryHelper.getFileTitle(file.getFileEntryId(), locale) />
                <#else>
                    <#assign fileTitle = file.getTitle() />
                </#if>
                <#assign AssetVocabularyLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService")>
                <li class="st-lien-container">
                    <a href="${fileEntryHelper.getFileEntryURL(file.getFileEntryId())}" class="st-lien" target="_blank" >
                        <p class="st-title-lien"> ${fileTitle}</p>
                        <div class="st-lien-content">
                            <p class="st-type">(${file.getExtension()} - ${fileEntryHelper.getReadableFileEntrySize(file.getFileEntryId(), locale)})</p>
                            <p class="st-text"><@liferay_ui.message key="eu.download" /></p>
                        </div>
                    </a>
                </li>
            </#list>

        </ul>
        <div class="st-show-more">
            <button class="st-btn-show-more st-btn-arrow st--down"
                    aria-expanded="false"
                    data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
            </button>
        </div>    </div>
</div>