<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<link rel="stylesheet" href="/o/strasbourg-theme/css/style.css">

	<@liferay_util["include"] page=top_head_include />
</head>+


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

	<#-- liferay_portlet["runtime"] - Structure footer-->
<@liferay_portlet["runtime"]
portletProviderAction=portletProviderAction.VIEW
portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
instanceId="footer"
settingsScope="group" />


	<#include "${full_templates_path}/overlay-menu.ftl" />


<script type="text/javascript">
	window.onload = function(){
		var url = window.location.toString();
		document.getElementById("sharefacebook").setAttribute("href","https://www.facebook.com/sharer/sharer.php?u="+ encodeURIComponent(document.URL));
		document.getElementById("sharetwitter").setAttribute("href","https://twitter.com/intent/tweet?text="+url);
		document.getElementById("ShareLinkedIn").setAttribute("href","http://www.linkedin.com/shareArticle?mini=true&url="+url);
		document.getElementById("ShareMail").setAttribute("href","mailto:?body="+url);
	}
</script>
<#if themeDisplay.isSignedIn() >
	<@liferay_util["include"] page=body_bottom_include />
</#if>



	</div>
<script src="/o/strasbourg-theme/js/strasbourg.min.js" type="text/javascript"></script>
</body>

<#if themeDisplay.isSignedIn() >
	<@liferay_util["include"] page=bottom_include />
</#if>


</html>
