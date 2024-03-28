<!DOCTYPE html>

<#include init />
<#assign layoutHelper = serviceLocator.findService("eu.strasbourg.utils.api.LayoutHelperService") />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
    <title>${the_title?replace('-', '|')}</title>
    <meta content="initial-scale=1.0, width=device-width" name="viewport"/>
    <script type="text/javascript" src="/o/0-global-theme/libs/tarteaucitron/tarteaucitron.js"></script>
    <script type="text/javascript" src="/o/0-global-theme/js/tarteaucitron.init.js"></script>
    <@liferay_util["include"] page=top_head_include />
    <#include "${full_templates_path}/seo.ftl" />
</head>

<body class="${css_class}" id="content">

<@liferay_util["include"] page=body_top_include />
<@liferay.control_menu />




<div class="st-page-wrapper" id="wrapper">
    <a href="#main-content" class="st-skip-link st-btn">Aller au contenu</a>
    <#if selectable>
        <@liferay_util["include"] page=content_include />
    <#else>
        ${portletDisplay.recycle()}

        ${portletDisplay.setTitle(the_title)}

        <@liferay_theme["wrap-portlet"] page="portlet.ftl">
            <@liferay_util["include"] page=content_include />
        </@>
    </#if>
    <div id="overlay-shadow" class="st-shadow-overlay"></div>
    <script type="text/javascript">
        window.onload = function () {
            window.loginURL = '${layoutHelper.getPublikLoginURL(portalUtil.getCurrentCompleteURL(request))?html}';
            var url = window.location.toString();
            document.getElementById("sharefacebook")?.setAttribute("href", "https://www.facebook.com/sharer/sharer.php?u=" + encodeURIComponent(document.URL));
            document.getElementById("sharetwitter")?.setAttribute("href", "https://twitter.com/intent/tweet?text=" + url);
            document.getElementById("ShareLinkedIn")?.setAttribute("href", "http://www.linkedin.com/shareArticle?mini=true&url=" + url);
            document.getElementById("ShareMail")?.setAttribute("href", "mailto:?body=" + url);
        }
        environment = 'desktop';
    </script>
    <@liferay_util["include"] page=body_bottom_include />
    <#include "${full_templates_path}/alert.ftl" />
</div>

</body>

<@liferay_util["include"] page=bottom_include />

</html>