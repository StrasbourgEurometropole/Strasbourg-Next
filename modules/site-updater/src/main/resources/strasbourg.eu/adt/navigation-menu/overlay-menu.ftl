<#if themeDisplay.isSignedIn() >
    <@clay["alert"] message="Overlay de menu est present sur cette page"
    displayType="secondary"
    title="Overlay" />
</#if>
<div id="st-overlay-menu" class="st-overlay st-overlay-menu" role="dialog" aria-modal="true" aria-label="Menu principal">
    <button class="st-btn-close" data-overlay-close="st-overlay-menu" aria-label="Fermer"></button>
    <div class="st-overlay__inner">
        <div class="st-overlay__body st-custom-scrollbar">
            <div class="st-nav-menu-mobile st-hide-from@mobile">
                <#-- liferay_portlet["runtime"] - Structure Je suis-->
                <@liferay_portlet["runtime"]
                portletProviderAction=portletProviderAction.VIEW
                portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
                instanceId="je-suis-header-mobile"
                settingsScope="group" />
                <button href="#" aria-haspopup="dialog" class="st-nav-menu-mobile__link" data-overlay-open="st-overlay-location">
                    <@liferay_ui.message key='eu.mycity' />
                </button>
                <a href="/contact" class="st-nav-menu-mobile__link"><@liferay_ui.message key='eu.ops.contact' /></a>
            </div>
            <#list entries as nav_item>
                <#assign
                nav_item_attr_has_popup=""
                nav_item_css_class=""
                nav_item_url=nav_item.getURL() />
                <div class="st-overlay__heading">
                    <#if nav_item.isBrowsable()>
                        <a href="${nav_item.getURL()}" ${nav_item.getTarget()} class="st-nav-menu__link" role="menuitem">
                            <h2 class="st-title-overlay st-h2">
                                ${nav_item.getName()}
                            </h2>
                        </a>
                    <#else>
                        <h2 class="st-title-overlay st-h2">
                                ${nav_item.getName()}
                            </h2>
                    </#if>
                </div>
                <#if nav_item.hasChildren()>
                    <nav class="st-nav-menu" role="navigation">
                        <ul class="st-nav-menu__list">
                            <#list nav_item.getChildren() as nav_child>
                                <#assign
                                nav_child_css_class="" />
                                <#if nav_item.isSelected()>
                                    <#assign
                                    nav_child_css_class="selected" />
                                </#if>
                                <li class="st-nav-menu__item ${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
                                    <a href="${nav_child.getURL()}" ${nav_child.getTarget()} class="st-nav-menu__link" role="menuitem">
                                        ${nav_child.getName()}
                                    </a>
                                </li>
                            </#list>
                        </ul>
                    </nav>
                </#if>
                </li>
            </#list>
        </div>
        <div class="st-overlay__footer st-hide-from@t-small">
            <a href="#" class="st-btn-compte">
                <span class="st-icon-demarche" aria-hidden="true"></span>
                <@liferay_ui.message key='eu.my-procedures' />
            </a>
            <select onchange="document.location.href = this.value;" class="select-lang">
                <option value="https://strasbourg.eu/" selected="selected">
                    <@liferay_ui.message key='eu.fr' />
                </option>
                <option value="https://int.strasbourg.eu/en">
                    <@liferay_ui.message key='eu.en' />
                </option>
                <option value="https://int.strasbourg.eu/de">
                    <@liferay_ui.message key='eu.de' />
                </option>
            </select>
        </div>
        <button class="st-btn-arrow st--down st-scroll-indicator st-js-scroll-overlay" aria-label="Faire défiler le menu"></button>
    </div>
</div>