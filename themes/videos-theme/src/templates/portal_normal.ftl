<!DOCTYPE html>


<#include init />

<#assign currentGroup = layout.getGroup() />

<html class="<@liferay.language key="lang.dir" />" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} | Videos.strasbourg.eu</title>

	<!-- jQuery 1.9.1 -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>

    <link rel="stylesheet" type="text/css" href="${images_folder}/../bower_components/owl.carousel.js/owl.carousel.min.css" />
    <link rel="stylesheet" type="text/css" href="${images_folder}/../bower_components/owl.carousel.js/owl.theme.default.min.css" />

	<@liferay_util["include"] page=top_head_include />
	<link rel="icon" type="image/png" href="${images_folder}/logo/favicon.png" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  	<script type="text/javascript" src="/o/0-global-theme/libs/tarteaucitron/tarteaucitron.js"></script>
  	<script type="text/javascript" src="/o/0-global-theme/js/tarteaucitron.init.js"></script>
  	<script type="text/javascript" src="${javascript_folder}/tarteaucitron.custom.js"></script>
</head>

<body class="${css_class}">
<!-- Google Analytics -->

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<#include "${full_templates_path}/navigation_mobile.ftl" />
<div id="page" class="video-site">
	<div id="wrapper">
		<div class="video-header">
	       <!-- HEADEROND -->
	        <#if layout.getFriendlyURL() == "/accueil">
		       	<@liferay_portlet["runtime"]
					defaultPreferences="${freeMarkerPortletPreferences}"
					portletProviderAction=portletProviderAction.VIEW
					portletName="com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet"
					instanceId="header-home"
					settingsScope="group" />
			<#else>
		       	<@liferay_portlet["runtime"]
					defaultPreferences="${freeMarkerPortletPreferences}"
					portletProviderAction=portletProviderAction.VIEW
					portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
					instanceId="header-pages"
					settingsScope="group" />
			</#if>
	       <!-- /HEADEROND -->
		</div>
		<#if has_navigation>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>

		<div id="content">
			<#if selectable>
				<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}
				${portletDisplay.setTitle(the_title)}
				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
		</div>
		<a class="to-top"></a>
		<div class="footer">

			<@liferay_portlet["runtime"]
				defaultPreferences="${freeMarkerPortletPreferences}"
				portletProviderAction=portletProviderAction.VIEW
				portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
				instanceId="footer"
				settingsScope="group" />
		</div>
	</div>
</div>
<!--[if lt IE 9]>
	#set ($articleIE8Name = "ie8")
	#getArticleContentFooter ($articleIE8Name $lang $themeDisplay $GroupIdGlobal)
	<style>
		#page { display: none; }
	</style>
<!-- <![endif]-->
	<script src="https://api.dmcdn.net/all.js"></script>
	<script src="${javascript_folder}/mobile-menu.js"></script>
	<script src="${javascript_folder}/responsive-grid.js"></script>
	<script src="${javascript_folder}/players-api.js"></script>
	<script src="${javascript_folder}/more-videos.js"></script>
	<script src="${javascript_folder}/search.js"></script>
	<script src="${javascript_folder}/carrousel.js"></script>
    <script src="${images_folder}/../bower_components/owl.carousel.js/owl.carousel.min.js"></script>
    <script src="${images_folder}/../bower_components/retina.js/src/retina.js"></script>


	<#if  propsUtil.get('eu.strasbourg.environment') == "PROD">
		<!-- Global site tag (gtag.js) - Google Analytics -->
		<script async src="https://www.googletagmanager.com/gtag/js?id=UA-33301756-4"></script>
		<script>
		  window.dataLayer = window.dataLayer || [];
		  function gtag(){dataLayer.push(arguments);}
		  gtag('js', new Date());

		  gtag('config', 'UA-33301756-4');
		</script>
	</#if>
</body>

	<@liferay_util["include"] page=body_bottom_include />

	<@liferay_util["include"] page=bottom_include />

</html>