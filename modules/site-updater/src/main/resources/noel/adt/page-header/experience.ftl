<#setting locale = locale />

<div class="mns-page-experience">
    <div class="mns-header mns-header-fullpage">
        <figure class="fit-cover">
                <img src="${page.expandoBridge.getAttribute('image')}" width="1600" height="900" alt="">
            </figure>
            <div class="container mns-caption">
                <h1>${page.getTitle(locale)}</h1>
            </div>
        <div class="small-container mns-wrapper-bread">
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
    </div>
</div>