<#setting locale = locale />
<header class="mns-header" style="background: url(${page.expandoBridge.getAttribute('image')}) no-repeat center center /cover;">
    <div class="container mns-center">
        <h1>${page.getTitle(locale)}</h1>
    </div>
</header>

<div class="container mns-wrapper-bread">
    <div class="mns-breadcrumbs">
        <#if !page.ancestors?has_content || page.ancestors?reverse[0].friendlyURL != '/accueil'>
            <a href="${strasbourg.homeURL()}"><@liferay_ui.message key="home" /></a>
        </#if>
        <#list page.ancestors?reverse as ancestor>
            <a href="${strasbourg.homeURL()}${ancestor.friendlyURL?remove_beginning('/')}">${ancestor.getName(locale)}</a>
        </#list>
        <span>${page.getName(locale)}</span>
    </div>
</div>
