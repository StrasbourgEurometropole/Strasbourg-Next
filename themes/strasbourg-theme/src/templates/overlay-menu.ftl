<div id="overlay-shadow" class="st-shadow-overlay"></div>


<div id="st-overlay-menu" class="st-overlay st-overlay-menu">

    <button class="st-btn-close" data-overlay-close="st-overlay-menu" aria-label="Fermer le menu"></button>

    <div class="st-overlay__inner">
        <div class="st-overlay__body st-custom-scrollbar">
            <div class="st-nav-menu-mobile st-hide-from@mobile">
                <div class="st-select-visitor">
                    <span>Je suis</span>
                    <select class="st-js-select-autoresize">
                        <option value="habitant" selected="selected">un habitant</option>
                        <option value="elu">un élu</option>
                        <option value="enseignant">un enseignant</option>
                        <option value="etudiant">un étudiant</option>
                        <option value="demandeur">demandeur d'emploi</option>
                    </select>
                </div>
                <a href="#" class="st-nav-menu-mobile__link">Mon quartier / Ma commune</a>
                <a href="#" class="st-nav-menu-mobile__link">Contact</a>
            </div>
            <#list nav_items as nav_item>
                <#assign
                nav_item_attr_has_popup = ""
                nav_item_css_class = ""
                nav_item_layout = nav_item.getLayout()
                />

                      <a href="${nav_item.getURL()}" ${nav_item.getTarget()} class="st-nav-menu__link" role="menuitem">
                           <span class="st-title-overlay">
                          ${nav_item.getName()}
                        </span>
                      </a>

                    <#if nav_item.hasChildren()>
                        <nav class="st-nav-menu" role="navigation">
                            <ul class="st-nav-menu__list">
                                <#list nav_item.getChildren() as nav_child>
                                    <#assign
                                    nav_child_css_class = ""
                                    />

                                    <#if nav_item.isSelected()>
                                        <#assign
                                        nav_child_css_class = "selected"
                                        />
                                    </#if>
                                    <li class="st-nav-menu__item ${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
                                        <a href="${nav_child.getURL()}" ${nav_child.getTarget()} class="st-nav-menu__link" role="menuitem">${nav_child.getName()}</a>
                                    </li>
                                </#list>
                            </ul>
                        </nav>
                    </#if>
                </li>
            </#list>

            <span class="st-title-overlay">Politiques publiques</span>

            <nav class="st-nav-menu" role="navigation">
                <ul class="st-nav-menu__list">
                    <li class="st-nav-menu__item">
                        <a href="#" class="st-nav-menu__link">Air, climat, énergie</a>
                    </li>
                    <li class="st-nav-menu__item">
                        <a href="#" class="st-nav-menu__link">Alimentation</a>
                    </li>
                </ul>
            </nav>
            <span class="st-title-overlay">Politiques publiques</span>

            <nav class="st-nav-menu" role="navigation">
                <ul class="st-nav-menu__list">
                    <li class="st-nav-menu__item">
                        <a href="#" class="st-nav-menu__link">Air, climat, énergie</a>
                    </li>
                    <li class="st-nav-menu__item">
                        <a href="#" class="st-nav-menu__link">Alimentation</a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="st-overlay__footer st-hide-from@t-small">
            <a href="#" class="st-btn-compte">
                <span class="st-icon-demarche" aria-hidden="true"></span>Mes démarches
            </a>
            <select onchange="document.location.href = this.value;" class="select-lang">
                <option value="https://strasbourg-refonte.s3.dev-thuria.com/" selected="selected">
                    Fr
                </option>
                <option value="https://strasbourg-refonte.s3.dev-thuria.com//en">En</option>
            </select>
        </div>

        <button class="st-btn-arrow st--down st-scroll-indicator st-js-scroll-overlay" aria-label="Faire défiler le menu"></button>
    </div>

</div>
