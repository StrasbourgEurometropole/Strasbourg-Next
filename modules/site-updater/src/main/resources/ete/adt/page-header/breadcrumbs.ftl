<#setting locale = locale />
<header class="mns-header-single">
    <div class="container">
        <div class="mns-wrapper-bread">
            <div class="mns-breadcrumbs">
                 <#if !page.ancestors?has_content || page.ancestors?reverse[0].friendlyURL != '/accueil'>
                    <a href="${strasbourg.homeURL()}/"><@liferay_ui.message key="home" /></a>
                </#if>
                <#list page.ancestors?reverse as ancestor>
                    <a href="${strasbourg.homeURL()}${ancestor.friendlyURL}">${ancestor.getName(locale)}</a>
                </#list>
                <span>${page.getName(locale)}</span>
            </div>
        </div>
    </div>
</header>

<script>
    $('.navbar.mns-nav').addClass('mns-nav-no-header');
</script>