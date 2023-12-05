<#setting locale = locale />

<!-- Liste des actes réglementaires et normatifs -->
<#assign portletHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<#assign dLFileEntryLocalService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>
<#assign dateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.DateHelperService") />
<#assign assetTagService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetTagService") />


<div class="st-bloc st-bloc-liens st-wrapper st--has-margin">
    <div class="st-component-container">
        <ul class="st-liste st-limit-height">
            <#list entries as curEntry>
                <#assign file=curEntry.getAssetRenderer().getAssetObject() />
                <#assign fileEntryHelper=serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
                <#if file.description?has_content>
                    <#assign description=file.description />
                <#else>
                    <#assign description=file.getTitle()?keep_before_last(".") />
                </#if>
                <#assign description=file.getTitle()?keep_before_last(".") />
                <li class="st-lien-container">
                    <a href="${fileEntryHelper.getFileEntryURL(file.getFileEntryId())}" class="st-lien" target="_blank">
                        <p class="st-title-lien">
                            ${description}
                        </p>
                        <div class="st-lien-content">
                            <p class="st-type">
                                <#assign dlFileEntry=dLFileEntryLocalService.fetchDLFileEntry(file.getFileEntryId()) />
                                <#assign fileVersionId=dlFileEntry.getLatestFileVersion(true).getFileVersionId() />
                                <#assign ddmFormValuesMap=dlFileEntry.getDDMFormValuesMap(fileVersionId) />
                                <#list ddmFormValuesMap as ddmFormKeys,ddmFormValues>
                                    <#list ddmFormValues.getDDMFormFieldValues() as ddmFormFieldValue>
                                        <#if ddmFormFieldValue.getName()=="publicationDate">
                                            Publié le
                                            <#assign publicationDate=ddmFormFieldValue.getValue().getString(locale) />
                                            ${dateHelperService.displayShortDate(publicationDate?date.xs, locale)}
                                        </#if>
                                    </#list>
                                </#list>
                                (${file.getExtension()?upper_case} -
                                ${fileEntryHelper.getReadableFileEntrySize(file.getFileEntryId(), locale)})
                            </p>
                            <p class="st-text">
                                <@liferay_ui.message key="eu.download" />
                            </p>
                        </div>
                        <span class="st-sr-only">
                            <@liferay_ui.message key="eu.download" /> le document
                        </span>
                    </a>
                </li>
            </#list>
        </ul>
        <div class="st-show-more">
            <button class="st-btn-show-more st-btn-arrow st--down"
                    aria-expanded="false"
                    data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
            </button>
        </div>
    </div>
</div>

<style>
    h3.asset-entries-group-label{
        display: none;
    }
</style>