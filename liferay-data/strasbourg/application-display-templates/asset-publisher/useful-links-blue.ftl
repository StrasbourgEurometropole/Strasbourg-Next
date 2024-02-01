<!-- Liens utiles (externes) - bleus -->
<#setting locale = locale />
<#assign portletHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />
<div class="seu-container">
    <div class="rte">
        <h2>
            ${portletHelper.getPortletTitle('eu.useful-links', renderRequest)}
        </h2>
    </div>
    <#list entries as curEntry>
        <#assign link = curEntry.getAssetRenderer().getLink() />
        <a href="${link.getURL(locale)}"  
            <#if link.getHoverText(locale)?has_content>title="${link.getHoverText(locale)}"</#if>
            class="seu-btn-square seu-bordered seu-core" 
            target="_blank">
            <span class="seu-btn-text"> 
                ${link.getTitle(locale)}
            </span>
            <span class="seu-btn-arrow"></span>
        </a>
        <#sep><br></#sep>
    </#list>
</div>