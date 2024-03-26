<#setting locale = locale />

<!-- Vignette contenu web -->
<#assign docXml = saxReaderUtil.read(entry.getContentByLocale(locale)) />
<#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()")/>
<#if !title?has_content><#assign title = entry.getTitle(locale) /></#if>
<#assign catcher = docXml.valueOf("//dynamic-element[@name='catcher']/dynamic-content/text()") />
<#assign text = docXml.valueOf("//dynamic-element[@name='text']/dynamic-content/text()") />

<#assign layoutHelper = serviceLocator.findService("eu.strasbourg.utils.api.LayoutHelperService") />

<div class="mns-item-results">
    <a href="${strasbourg.homeURL()}-/${entry.getUrlTitle()}">
        <h3>${title}</h3>
        <#if catcher?has_content>
            <p>${catcher?replace("<[^>]*>", "", "r")[0..*400]}...</p>
        <#else>
            <p>${text?replace("<[^>]*>", "", "r")[0..*400]}...</p>
        </#if>
        <span class="basic-link"><@liferay_ui.message key="eu.discover" /></span>
    </a>
</div>