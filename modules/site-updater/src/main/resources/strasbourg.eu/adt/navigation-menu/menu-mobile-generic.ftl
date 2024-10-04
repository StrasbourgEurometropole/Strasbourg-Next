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