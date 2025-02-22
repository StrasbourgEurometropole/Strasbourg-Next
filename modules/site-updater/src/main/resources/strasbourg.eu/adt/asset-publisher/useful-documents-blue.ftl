<!-- Liens utiles (externes) - bleus -->
<#setting locale = locale />
<#assign portletHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />
<#assign fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />

<#assign portletTitle = portletHelper.getPortletTitle('', renderRequest) />
<#if portletTitle?has_content>
    <div class="st-bloc st-wrapper st--has-margin-small">
        <h2 class="st-h2">${portletTitle}</h2>
    </div>
</#if>

<#if !entries?has_content && themeDisplay.isSignedIn()>
    <div>
        Documents utiles - Aucune entrée (message non-visible par les visiteurs)
    </div>
</#if>


<div class="st-bloc st-bloc-liens st-wrapper st--has-margin">
    <div class="st-component-container">
        <ul class="st-liste st-limit-height">
            <#assign filesInfos = fileEntryHelper.getFilesInfos(entries, locale) />
            <#list filesInfos as fileInfos>
                <#if fileInfos[0]??>
                    <#assign fileTitle = fileInfos[0] />
                <#else>
                    <#assign fileTitle = file.getTitle() />
                </#if>
                <li class="st-lien-container">
                    <a href="${fileInfos[1]}" class="st-lien" target="_blank" aria-labelledby="fileTitle-${fileInfos?index}">
                        <p class="st-title-lien" id="fileTitle-${fileInfos?index}"> ${fileTitle?replace("_","_<wbr/>")}</p>
                        <div class="st-lien-content">
                            <p class="st-type">(${fileInfos[2]?upper_case} - ${fileInfos[3]})</p>
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