<!DOCTYPE html>

<#include init />

<#assign currentGroup = layout.getGroup() />
<#assign currentGroupName = currentGroup.getName() />
<#assign isHome = layout.getFriendlyURL() == "/accueil" />
<#assign websiteUrl = "//www.strasbourg.eu" />
<#if locale.language == "en">
  <#assign websiteUrl = "//www.en.strasbourg.eu" />
<#else>
	<#if locale.language == "de">
      <#assign websiteUrl = "//www.de.strasbourg.eu" />
    </#if>
</#if>
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames?has_content || themeDisplay.scopeGroup.isStagingGroup()>
  <#assign homeURL = "/web${layout.group.friendlyURL}" />
<#else>
  <#assign homeURL = "" />
</#if>

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}" class="no-js">

  <head>
    <title>${layout.getName(locale)} | Strasbourg aime ses &eacute;tudiants</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
      <meta name="description" content="" />
    <meta content="" name="keywords">
    <meta name="format-detection" content="telephone=no">

    <link rel="Shortcut icon" href="${images_folder}/favicon/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" sizes="57x57" href="${images_folder}/favicon/apple-touch-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="${images_folder}/favicon/apple-touch-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="${images_folder}/favicon/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="${images_folder}/favicon/apple-touch-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="${images_folder}/favicon/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="${images_folder}/favicon/apple-touch-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="${images_folder}/favicon/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="${images_folder}/favicon/apple-touch-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="${images_folder}/favicon/apple-touch-icon-180x180.png">
    <link rel="icon" type="image/png" href="${images_folder}/favicon/favicon-32x32.png" sizes="32x32">
    <link rel="icon" type="image/png" href="${images_folder}/favicon/android-chrome-192x192.png" sizes="192x192">
    <link rel="icon" type="image/png" href="${images_folder}/favicon/favicon-96x96.png" sizes="96x96">
    <link rel="icon" type="image/png" href="${images_folder}/favicon/favicon-16x16.png" sizes="16x16">

    <link rel="stylesheet" type="text/css" href="${css_folder}/sae.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${css_folder}/swiper-bundle.min.css" media="screen" />
	  <link type="text/css" rel="stylesheet" href="/o/0-global-theme/css/hackliferay.css" />
    <script type="text/javascript" src="${javascript_folder}/swiper-bundle.min.js" charset="utf-8"></script>
    <@liferay_util["include"] page=top_head_include />

    <#assign currentUrlOG = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />

    <#assign descriptionOG = '${layout.getDescription(locale)?replace("<[^>]*>", "", "r")?html?js_string}' />
    <#if !descriptionOG?has_content>
      <#assign descriptionOG = '${themeDisplay.siteGroup.expandoBridge.getAttribute("opengraph_default_description")}' />
    </#if> 

    <#assign imageOG = '${layout.expandoBridge.getAttribute("image")}' />
    <#if !imageOG?has_content>
      <#assign imageOG = '${themeDisplay.siteGroup.expandoBridge.getAttribute("opengraph_default_image")}' />
    </#if> 
    <#if imageOG?has_content && !imageOG?contains('http')>
      <#assign imageOG = '${themeDisplay.getPortalURL()}${imageOG}' />
    </#if> 
    
    <#assign openGraph = {
      "og:type":"website",
      "og:locale":"${locale}",
      "og:url":"${currentUrlOG}",
      "og:title":"${the_title_OG}",
      "og:description":'${descriptionOG}',
      "og:image":"${imageOG}",
      "og:image:width":"620",
      "og:image:height":"400"
    } />

    <#if request.getAttribute("LIFERAY_SHARED_OPENGRAPH")?has_content>
        <#assign openGraphCustom = request.getAttribute("LIFERAY_SHARED_OPENGRAPH")>   
        <#list openGraphCustom?keys as keyOG>  
          <#if openGraphCustom[keyOG]?has_content>
            <#assign openGraph = openGraph + {keyOG : openGraphCustom[keyOG]} >
          </#if>
          <#if !openGraphCustom[keyOG]?has_content && openGraph[keyOG]?has_content>
            <#assign openGraph = openGraph + {keyOG : openGraph[keyOG]} >
          </#if>
        </#list>
    </#if>
    
    <meta name="twitter:card" content="summary" />
    <#list openGraph?keys as keyOG>
      <#assign valueOG = openGraph[keyOG]> 
      <#if keyOG == "og:description" >
        <#assign valueOG = valueOG[0..*300] + (valueOG?length > 300)?then('...','') > 
      </#if>
      <#if keyOG == "og:description" && valueOG?has_content >
          <meta property="${keyOG}" content="${valueOG}" />
      <#elseif keyOG?contains("og:image") && openGraph["og:image"]?has_content>
          <meta property="${keyOG}" content="${valueOG}" />
      <#elseif keyOG != "og:description" && !keyOG?contains("og:image")>
          <meta property="${keyOG}" content="${valueOG}" />
      </#if>
    </#list>
  </head>

  <body class="${css_class} <#if isHome> front-home </#if> <#if !isHome> class-inner </#if>">
    <div id="wrapper">


    <@liferay_ui["quick-access"] contentId="#main-content" />

    <@liferay_util["include"] page=body_top_include />
    <@liferay.control_menu />
      
    <!-- Menu responsive -->
    <nav id="mmenu" data='mmenu'>
      <ul class="list-principal">
      </ul>
    </nav>

    <main id="skiptocontent" class="wrapper" role="main">
      <!-- Header -->
      <!-- pre-header -->
      <nav class="nav-lang"> 
        <div class="center"> 
          <a href="//www.strasbourg.eu" title="Strasbourg.eu (<@liferay.language key="new-window" />)" class="logo-strasbourg" target="_blank">
            <img src="${images_folder}/pre-header/logo.png" alt="Strasbourg.eu" />
          </a>
          <ul>
            <#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames?has_content || themeDisplay.scopeGroup.isStagingGroup()>
              <#assign currURL = "/web${layout.group.friendlyURL}" />
            <#else>
              <#assign currURL = "" />
            </#if>
            <li class="active"><a href="#" class="menu-search"><span class="icon-search"></span></a></li>
            <li <#if locale.language == "fr"> class="active" </#if> ><a accesskey="1" href="/fr${currURL}${layout.friendlyURL}" title="Français">FR</a></li>
            <li <#if locale.language == "de"> class="active" </#if> ><a accesskey="1" href="/de${currURL}${layout.friendlyURL}" title="Deutsch">DE</a></li>
            <li <#if locale.language == "en"> class="active" </#if> ><a accesskey="1" href="/en${currURL}${layout.friendlyURL}" title="English">EN</a></li>
          </ul>
          <div class="clearfix"></div> 
        </div> 
      </nav>
      <div id="search-bar" class="mns-search-bar">
          <div class="container">
              <div class="row">
                  <div class="content-close">
                    <button type="button" id="search-close" tabindex="0">
                      <svg xmlns="http://www.w3.org/2000/svg" width="15.556" height="15.556" viewBox="0 0 15.556 15.556">
                        <g id="Groupe_22" data-name="Groupe 22" transform="translate(-767.222 -44)">
                          <g id="Groupe_2" data-name="Groupe 2" transform="translate(700 42)">
                            <g id="Groupe_29" data-name="Groupe 29" transform="translate(7)">
                              <rect id="Rectangle_9" data-name="Rectangle 9" width="20" height="2" transform="translate(60.222 16.142) rotate(-45)"></rect>
                              <rect id="Rectangle_11" data-name="Rectangle 11" width="20" height="2" transform="translate(61.636 2) rotate(45)"></rect>
                            </g>
                          </g>
                        </g>
                      </svg>
                    </button>
                  </div>
                  <form action="${homeURL}/recherche" method="get">
                      <input type="text" name="keywords" id="search" placeholder="Rechercher..." />
                  </form>
              </div>
          </div>
      </div>
      <!-- Header HP comprenant la video / menu principal + sous menu / la popup search / le titre -->
      <header class="page-header">
         <#if !isHome>
          <div style="display: none">
        </#if>
        <@liferay_portlet["runtime"]
          defaultPreferences="${freeMarkerPortletPreferences}"
          portletProviderAction=portletProviderAction.VIEW
          portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
          instanceId="header-sae"
          settingsScope="group" />
        <#if !isHome>
          </div>
	        <script>
		        var elements = document.getElementsByClassName('parameter-video');
		        while(elements.length > 0){
		            elements[0].parentNode.removeChild(elements[0]);
		        }
	        </script>
        </#if>
        <#include "${full_templates_path}/navigation.ftl" />
      
        <#if !isHome>
          <div class="fil-ariane">
            <div class="container">
              <div class="nav">
                <#assign layoutService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService") />
                <#assign parentURL = "/" />
                <#if layout.getParentPlid() gt 0>
                  <#assign parentLayout = layoutService.fetchLayout(layout.getParentPlid()!0) />
                  <#assign parentName = parentLayout.getName(themeDisplay.getLocale()) />
                  <#assign parentURL = parentLayout.getFriendlyURL() />
                </#if>
                <ul class="back-to">
                <#if parentLayout?has_content>
                  <li class="back-to">
                    <a href="${parentURL}">Retour vers "${parentName}"</a>
                  </li>
                <#else>
                  <li class="back-to">
                    <a href="${parentURL}">Retour vers "Accueil"</a>
                  </li>
                </#if>
                </ul>
                <@liferay.breadcrumbs />
              </div>
            </div>
          </div>
        </#if>
      </header>
      <!-- End header -->

      <div class="content" id="content">
        <section class="">
            <#if selectable>
              <@liferay_util["include"] page=content_include />
            <#else>
              ${portletDisplay.recycle()}

              ${portletDisplay.setTitle(the_title)}

              <@liferay_theme["wrap-portlet"] page="portlet.ftl">
                <@liferay_util["include"] page=content_include />
              </@>
            </#if>
        </section>    
      </div>
    
      <!-- Social Share sur chaque page - Apparait au moment du scroll de la page -->
      <div class="social-share">
          <input class="toggle-input" id="toggle-input" type="checkbox" /> 
          <label aria-hidden="true" aria-label="Partagez sur les réseaux sociaux" class="toggle" for="toggle-input">
            <span>Réseaux sociaux</span>
          </label>
          <ul class="network-list">
            <li class="facebook">
              <a aria-label="Partagez sur Facebook" data-href="#" id="sharefacebook" target="_blank" title="Lien de partage sur Facebook"></a>
            </li>
            <li class="twitter">
              <a aria-label="Partagez sur Twitter" id="sharetwitter" target="_blank" title="Lien de partage sur Twitter"></a>
            </li>
            <li class="linkedin">
              <a aria-label="Partagez sur LinkedIn" id="ShareLinkedIn" target="_blank" title="Lien de partage sur LinkedIn"></a>
            </li>
            <li class="mail">
              <a aria-label="Partagez par Email" id="ShareMail" title="Lien de partage par Email"></a>
            </li>
          </ul>
      </div>

      <!-- FOOTER -->
      <footer class="footer">
        <@liferay_portlet["runtime"]
          defaultPreferences="${freeMarkerPortletPreferences}"
          portletProviderAction=portletProviderAction.VIEW
          portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
          instanceId="footer"
          settingsScope="group" />
        <!-- <div class="closure">
            <div class="center">
                <a href="${websiteUrl}" title="Strasbourg.eu (<@liferay_ui.message key='new-window' />)" target="_blank">Strasbourg.eu</a>
            </div>
        </div> -->
      </footer>
      <!-- END FOOTER -->

    </main>
    <script type="text/javascript" src="${javascript_folder}/bootstrapValidator.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/owl.carousel.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/parallax.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/jquery.dotdotdot.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/jquery.mmenu.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/device.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/custom-select.js" charset="utf-8"></script>
    <script type="text/javascript" src="/o/0-global-theme/js/environment.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/social-share.js" charset="utf-8"></script>
    <script type="text/javascript" src="${javascript_folder}/based.js" charset="utf-8"></script>
  	<script type="text/javascript" src="/o/0-global-theme/libs/tarteaucitron/tarteaucitron.js"></script>
    <script type="text/javascript" src="/o/0-global-theme/js/tarteaucitron.init.js"></script>
    <script type="text/javascript" src="${javascript_folder}/tarteaucitron.custom.js" charset="utf-8"></script>

    <script type="text/javascript">
        window.onload = function(){
            var url = window.location.toString();
            document.getElementById("sharefacebook").setAttribute("href","https://www.facebook.com/sharer/sharer.php?u="+ encodeURIComponent(document.URL));
            document.getElementById("sharetwitter").setAttribute("href","https://twitter.com/intent/tweet?text="+url);
            document.getElementById("ShareLinkedIn").setAttribute("href","https://www.linkedin.com/shareArticle?mini=true&url="+url);
            document.getElementById("ShareMail").setAttribute("href","mailto:?body="+url);
        }
    </script>
    <@liferay_util["include"] page=body_bottom_include />
    <@liferay_util["include"] page=bottom_include />
    </div>
 </body>
</html>