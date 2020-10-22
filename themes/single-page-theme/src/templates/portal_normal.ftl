<!DOCTYPE html>
<#include init />
<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
  <title>${the_title}</title>

  <link rel="stylesheet" type="text/css" href="/o/single-page-theme/css/custom-animations.css" />

   <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,300,300italic,400italic,500italic&subset=latin,latin-ext" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=PT+Sans+Caption:400,700" rel="stylesheet">
  
  <@liferay_util["include"] page=top_head_include />
  
  <link rel="Shortcut Icon" type="image/png" href="${themeDisplay.siteGroup.expandoBridge.getAttribute('Icone single-page-theme (bib, see, 5eme-lieu)')}" />
</head>
<body class="${css_class}">
  <@liferay_ui["quick-access"] contentId="#main-content" />
  <@liferay_util["include"] page=body_top_include />
  <@liferay.control_menu />

  <div class="see">
  
    <section id="content">
      <#if selectable>
        <@liferay_util["include"] page=content_include />
      <#else>
        ${portletDisplay.recycle()}
        ${portletDisplay.setTitle(the_title)}
        <@liferay_theme["wrap-portlet"] page="portlet.ftl" />
        <@liferay_util["include"] page=content_include />
      </#if>
    </section>

  </div>

  <@liferay_util["include"] page=body_bottom_include />
  <@liferay_util["include"] page=bottom_include />
  <!-- inject:js -->
  <script type="text/javascript" src="/o/single-page-theme/js/ventcamp.js"></script>
  <script type="text/javascript">
    if(typeof jQuery == 'undefined'){
      document.write('<script type="text/javascript" src="/o/single-page-theme/js/jquery-2.1.4.min.js?ver=1"></'+'script>');
    }
  </script>
  <script>
    <#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
      <#assign homeURL = "/web${layout.group.friendlyURL}" />
    <#else>
      <#assign homeURL = "/" />
    </#if>
    window.homeURL = '${homeURL}';
  </script>
  <script src="https://maps.googleapis.com/maps/api/js?v=3&libraries=places&key=AIzaSyAZ_4b-Rip0JyK5Ti8yKOxXKjKpjfcBvdM"></script>
  <script type="text/javascript" src="/o/single-page-theme/js/jquery.validate.min.js"></script>
  <script type="text/javascript" src="/o/single-page-theme/js/toastr.min.js"></script>
  <script type="text/javascript" src="/o/single-page-theme/js/jquery.waypoints.min.js"></script>
  <script type="text/javascript" src="/o/single-page-theme/js/jquery.plugin.js"></script>
  <script type="text/javascript" src="/o/single-page-theme/js/jquery.countTo.js"></script>
  <script type="text/javascript" src="/o/single-page-theme/js/jquery.appear.js"></script>
  <script type="text/javascript" src="/o/single-page-theme/js/masonry.pkgd.min.js"></script>
  <script type="text/javascript" src="/o/single-page-theme/js/modal-box.js"></script>
  <!-- endinject -->
</body>
</html>