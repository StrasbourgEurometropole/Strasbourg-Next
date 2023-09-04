<!DOCTYPE html>

<#include init />

<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames?has_content || themeDisplay.scopeGroup.isStagingGroup()>
	<#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
	<#assign homeURL = "/" />
</#if>

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title?replace('-', '|')}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<link rel="stylesheet" href="/o/strasbourg-theme/css/style.css">

	<@liferay_util["include"] page=top_head_include />
<#--	<#include "${full_templates_path}/seo.ftl" />-->
</head>


<body class="${css_class}">
<@liferay_ui["quick-access"] contentId="#main-content" />
<@liferay_util["include"] page=body_top_include />
<@liferay.control_menu />

<div class="st-page-wrapper">

<#include "${full_templates_path}/header.ftl" />

<main>
<#-- Content of the page-->
<#if selectable>
	<@liferay_util["include"] page=content_include />
<#else>
	${portletDisplay.recycle()}

	${portletDisplay.setTitle(the_title)}

	<@liferay_theme["wrap-portlet"] page="portlet.ftl">
		<@liferay_util["include"] page=content_include />
	</@>
</#if>
</main>

<#--End Content of the page-->
	<div id="overlay-shadow" class="st-shadow-overlay"></div>

	<#-- liferay_portlet["runtime"] - Overlay menu-->
	<@liferay_portlet["runtime"]
	portletProviderAction=portletProviderAction.VIEW
	portletName="com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet"
	instanceId="overlay-menu"
	settingsScope="group" />

	<#-- liferay_portlet["runtime"] - Overlay recherche -->
	<@liferay_portlet["runtime"]
	portletProviderAction=portletProviderAction.VIEW
	portletName="eu_strasbourg_portlet_dynamic_search_asset_DynamicSearchAssetPortlet"
	instanceId="DynamicResearch"
	settingsScope="group" />

	<#-- liferay_portlet["runtime"] - Structure footer-->
<@liferay_portlet["runtime"]
portletProviderAction=portletProviderAction.VIEW
portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
instanceId="footer"
settingsScope="group" />






<script type="text/javascript">
	window.onload = function(){
		var url = window.location.toString();
		document.getElementById("sharefacebook")?.setAttribute("href","https://www.facebook.com/sharer/sharer.php?u="+ encodeURIComponent(document.URL));
		document.getElementById("sharetwitter")?.setAttribute("href","https://twitter.com/intent/tweet?text="+url);
		document.getElementById("ShareLinkedIn")?.setAttribute("href","http://www.linkedin.com/shareArticle?mini=true&url="+url);
		document.getElementById("ShareMail")?.setAttribute("href","mailto:?body="+url);
	}
</script>

	<@liferay_util["include"] page=body_bottom_include />



	</div>
<script src="/o/strasbourg-theme/js/strasbourg.min.js" type="text/javascript"></script>
</body>

	<@liferay_util["include"] page=bottom_include />


</html>
