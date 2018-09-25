<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
  <#assign homeURL = "/web${layout.group.friendlyURL}" />
<#else>
  <#assign homeURL = "/" />
</#if>
<nav class="navbar mns-nav">
    <div id="search-bar" class="mns-search-bar">
        <div class="container">
            <div class="row">
                <form action="${homeURL}recherche" method="get">
                    <input type="hidden" name="p_p_id" value="eu_strasbourg_portlet_search_asset_SearchAssetPortlet" />
                    <input type="text" name="_eu_strasbourg_portlet_search_asset_SearchAssetPortlet_keywords" id="search" placeholder="Rechercher..." />
                </form>
            </div>
        </div>
    </div>
    <div class="container mns-navbar-wrapper">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${homeURL}">Strasbourg <span class="subtitle"><@liferay_ui.message key='christmas-capital' /></span></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="mns-top-header mns-top-header-mobile">
                    <div>
                        <!-- a href="#" class="mns-w-fixe-2"><span>Pro & Presse</span></a -->
                        <a href="/fr${homeURL}${layout.friendlyURL}">FR</a>
                        <a href="/de${homeURL}${layout.friendlyURL}" title="Deutsch">DE</a>
                        <a href="/en${homeURL}${layout.friendlyURL}" title="English">EN</a>
                    </div>
                </li>
                <li class="mns-search-bar mns-search-bar-mobile">
                    <div class="row">
                        <form action="${homeURL}recherche" method="get">
                            <input type="hidden" name="p_p_id" value="eu_strasbourg_portlet_search_asset_SearchAssetPortlet" />
                            <input type="text" name="_eu_strasbourg_portlet_search_asset_SearchAssetPortlet_keywords" id="search" placeholder="Rechercher..." />
                        </form>
                    </div>
                </li>
                <li class="hidden-sm hidden-xs menu-accueil">
                    <a href="${homeURL}">
                        <span class="icon-ico-home"></span>
                    </a>
                </li>
                <#list nav_items as nav_item>
                    <#if nav_item.hasChildren()>
                        <li class="dropdown">
                            <a href="${nav_item.getURL()}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${nav_item.getName()}</a>
                            <ul class="dropdown-menu">
                                <#list nav_item.getChildren() as nav_child>
                                    <li>
                                        <a href="${nav_child.getURL()}">
                                            <span class='icon-chevron-thin-right'></span> 
                                            ${nav_child.getName()}
                                        </a>
                                    </li>
                                </#list>
                            </ul>
                        </li>
                    <#else>
                        <li><a href="${nav_item.getURL()}">${nav_item.getName()}</a></li>
                    </#if>
                </#list>
                <li>
                    <a href="#" class="mns-btn-yellow"><@liferay_ui.message key='magic-christmas' /></a>
                </li>
            </ul>
        </div>
    </div>
</nav>