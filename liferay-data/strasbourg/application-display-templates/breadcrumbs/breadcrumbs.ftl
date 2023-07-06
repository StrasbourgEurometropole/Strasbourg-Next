<!-- Fil d'ariane -->
<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
  <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
  <#assign homeURL = "/" />
</#if>
 <ul class="st-breadcrumbs" aria-label="Fil d'ariane de la page">
    <li class="st-breadcrumbs__item">
        <a href="${homeURL}" class="st-breadcrumbs__link"><@liferay_ui.message key="home" /></a>
    </li>
    <#if entries?has_content>
        <#list entries as curEntry>
            <#if !curEntry.baseModel?has_content || curEntry.baseModel.friendlyURL != '/accueil'>
                <li class="st-breadcrumbs__item">
                    <#if curEntry?is_last>
                        <span>${curEntry.getTitle()}</span>
                    <#else>
                        <#if curEntry.getURL()?has_content>
                            <a href="${curEntry.getURL()}" class="st-breadcrumbs__link">${curEntry.getTitle()}</a>
                        <#else>
                            <span>${curEntry.getTitle()}</span>
                        </#if>
                    </#if>
                </li>
            </#if>
        </#list>
    </#if>
</ul>