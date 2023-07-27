<header id="st-barre-navigation" class="st-barre-navigation" role="banner">
    <div class="st-barre-liens">
        <div class="st-wrapper st-barre-inner-container">
            <h1 class="st-h1">
                <a href="{{ HOME_PATH }}" class="st-logo"
                   title="Accueil, site de la ville et l'eurométropole de Strasbourg">
                    <figure class="st-figure st-fit-cover" role="group">
                        <picture>
                            <img src="/o/strasbourg-theme/images/logo.png">
                        </picture>
                    </figure>

                </a>
            </h1>

            <nav class="st-nav-primary" role="navigation">
                <div class="st-barre-dropdown">
                    <button type="button" id="menubutton" aria-haspopup="true" aria-controls="menu2">
                        Je suis <strong>un habitant</strong>
                    </button>
                    <ul id="menu2" role="menu" aria-labelledby="menubutton">
                        <li role="none">
                            <a role="menuitem" href="https://www.w3.org/"> Je suis <strong>un élu </strong></a>
                        </li>
                        <li role="none">
                            <a role="menuitem" href="https://www.w3.org/standards/webdesign/accessibility">Je suis
                                <strong>un enseignant</strong></a>
                        </li>
                        <li role="none">
                            <a role="menuitem" href="https://www.w3.org/TR/wai-aria/">Je suis <strong>un
                                    étudiant</strong></a>
                        </li>
                        <li role="none">
                            <a role="menuitem" href="https://www.w3.org/TR/wai-aria-practices/">Je suis <strong>demandeur
                                    d'emploi</strong></a>
                        </li>
                    </ul>
                </div>
                <ul class="st-nav-primary__menu">
                    <li class="st-nav-primary__item">
                        <a href="#" class="st-nav-primary__link">Mon quartier / Ma commune</a>
                    </li>
                    <li class="st-nav-primary__item">
                        <a href="#" class="st-nav-primary__link">Contact</a>
                    </li>
                    <li class="st-has-lang-dropdown">
                        <select onchange="document.location.href = this.value;" class="select-lang">
                            <option value="https://strasbourg-refonte.s3.dev-thuria.com/"
                                    selected="selected">Fr
                            </option>
                            <option value="https://strasbourg-refonte.s3.dev-thuria.com//en">En
                            </option>
                        </select>
                    </li>
                    <li class="st-has-btn-compte">
                        <a href="#" class="st-btn-compte">
                            <span class="st-icon-demarche" aria-hidden="true"></span>Mes démarches
                        </a>
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
