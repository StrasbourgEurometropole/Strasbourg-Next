<header id="st-barre-navigation" class="st-barre-navigation" role="banner">
    <div class="st-barre-liens">
        <div class="st-wrapper st-barre-inner-container">
            <h1 class="st-h1">
                <a href="{{ HOME_PATH }}" class="st-logo"
                   title="Accueil, site de la ville et l'eurométropole de Strasbourg">
                    <figure class="st-figure st-fit-cover" role="group">
                        <picture>
                            <img src="/o/strasbourg-theme/images/medias/logo.png">
                        </picture>
                    </figure>

                </a>
            </h1>

            <nav class="st-nav-primary" role="navigation">
                <#-- liferay_portlet["runtime"] - Structure footer-->
                <@liferay_portlet["runtime"]
                portletProviderAction=portletProviderAction.VIEW
                portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
                instanceId="je-suis-header"
                settingsScope="group" />

                <ul class="st-nav-primary__menu">
                    <li class="st-nav-primary__item">
                        <a href="#" class="st-nav-primary__link">Mon quartier / Ma commune</a>
                    </li>
                    <li class="st-nav-primary__item">
                        <a href="#" class="st-nav-primary__link">Contact</a>
                    </li>
                    <li class="st-has-lang-dropdown">
                        <select onchange="document.location.href = this.value;" class="select-lang">
                            <option value="https://strasbourg.eu"
                                    selected="selected">Fr
                            </option>
                            <option value="https://int.strasbourg.eu/en">En
                            </option>
                            <option value="https://int.strasbourg.eu/de">De
                            </option>
                        </select>
                    </li>
                    <li class="st-has-btn-compte">
                        <#if request.session.getAttribute("publik_logged_in")!false>
                        <a href="https://services.strasbourg.eu/" class="st-btn-compte">
                            <span class="st-icon-demarche" aria-hidden="true"></span>Mes démarches
                        </a>
                        <#else>
                            <#assign layoutHelper = serviceLocator.findService("eu.strasbourg.utils.api.LayoutHelperService") />
                            <a href="${layoutHelper.getPublikLoginURL(portalUtil.getCurrentCompleteURL(request))?html}" class="st-btn-compte">
                                <span class="st-icon-person" aria-hidden="true"></span>
                                <strong>MonStrasbourg</strong>.eu
                            </a>
                        </#if>
                    </li>
                </ul>

            </nav>
        </div>

        <div class="st-wrapper st-barre-menu" role="search">
            <div class="st-barre-menu-inner">
                <button class="st-btn-search" data-overlay-open="overlay-search"
                        aria-label="Rechercher - Ouvrir le moteur de recherche">
                    J’ai besoin d’informations sur…
                </button>
                <button class="st-btn-menu" data-overlay-open="st-overlay-menu">
                   <span class="st-btn-menu__icon" aria-hidden="true">
                       <span class="st-btn-menu__line"></span>
                        <span class="st-btn-menu__line"></span>
                        <span class="st-btn-menu__line"></span>
                   </span>
                    Menu
                </button>
            </div>
        </div>
    </div>
</header>
