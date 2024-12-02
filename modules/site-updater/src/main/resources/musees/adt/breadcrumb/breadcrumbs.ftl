<!-- Fil d'ariane -->
<#setting locale = locale />

<div id="breadcrumbs">
    <div class="content container">
        <a href="${strasbourg.homeURL()}"><@liferay_ui.message key="home" /></a>
        <#if entries?has_content>
            <#list entries as curEntry>
                <#if !curEntry.baseModel?has_content || curEntry.baseModel.friendlyURL != '/accueil'>
                        <#if curEntry?is_last>
                            <span>${curEntry.getTitle()}</span>
                        <#else>
                            <#if curEntry.getURL()?has_content>
                                <a href="${curEntry.getURL()}">${curEntry.getTitle()}</a>
                            <#else>
                                <span>${curEntry.getTitle()}</span>
                            </#if>
                        </#if>
                    </li>
                </#if>
            </#list>
        </#if>
    </div>
</div>