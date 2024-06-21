<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${page.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "" />
</#if>

<header class="mns-header" style="background: url(${imageUrl}) no-repeat center center /cover;">
    <div class="container mns-center">
        <h1>${title}</h1>
        <span>${subTitle}</span>
    </div>
</header>

<div class="container mns-wrapper-bread">
    <div class="mns-breadcrumbs mns-bread-color">
        <#if !page.ancestors?has_content || page.ancestors?reverse[0].friendlyURL != '/accueil'>
            <a href="${homeURL}/"><@liferay_ui.message key="home" /></a>
        </#if>
        <#list page.ancestors?reverse as ancestor>
            <a href="${homeURL}${ancestor.friendlyURL?remove_beginning('/')}">${ancestor.getName(locale)}</a>
        </#list>
        <span>${page.getName(locale)}</span>
    </div>
</div>

<style>
    @media screen and (min-width: 767px){
        #mns-global .mns-bloc-article .mns-wrapper-title{
            display: none;
        }
    }
    @media screen and (max-width: 767px){
        #mns-global .mns-header .container{
            display: none;
        }
    }
</style>