<!-- Liens utiles -->
<#setting locale = locale />
<div class="useful-links">
    <h3 class="useful-links-title">
        <@liferay_ui.message key="eu.useful-links" />
    </h3>
    <#if entries?has_content>
        <ul>
        <#list entries as curEntry>
            <li>
                <#assign link = curEntry.getAssetRenderer().getLink() />
                <a href="${link.getURL(locale)}" ${link.getHoverText(locale)?has_content?then(title="link.getHoverText(locale) ","")} target="_blank" >
                  ${link.getTitle(locale)}
                </a>
            </li>
        </#list>
        </ul>
    </#if>
</div>
