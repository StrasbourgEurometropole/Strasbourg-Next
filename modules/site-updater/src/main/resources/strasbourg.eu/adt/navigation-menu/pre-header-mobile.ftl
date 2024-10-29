<div class="st-nav-menu-mobile st-hide-from@t-portrait">
    <#if entries?has_content>
        <#list entries as navigationEntry>
            <#if navigationEntry.isBrowsable()>
                <a href="${navigationEntry.getURL()}" class="st-nav-menu-mobile__link">${navigationEntry.getName()}</a>
            </#if>
        </#list>
    </#if>
</div>