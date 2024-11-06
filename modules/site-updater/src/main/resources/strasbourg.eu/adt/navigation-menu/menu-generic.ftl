<div class="st-wrapper">
    <div class="st-barre-inner-container nav-bar">

        <div>
            <a href="/" class="st-logo">
                <figure class="st-figure st-fit-cover">
                    <picture>
                        <img width="154" height="30" alt="Strasbourg.eu eurométropole" src="/o/strasbourg-theme/images/medias/logo.png" srcset="/o/strasbourg-theme/images/medias/logo.png 1x, /o/strasbourg-theme/images/medias/logo@2x.png 2x">
                    </picture>
                </figure> </a>
        </div>
        <nav class="st-nav-primary" role="navigation">
            <ul class="st-nav-primary__menu">
                <#if entries?has_content>
                    <#list entries as navigationEntry>
                        <li class="st-nav-primary__item dropdown-button">
                            <#assign found = false>
                            <#list  navigationEntry.getBrowsableChildren() as obj>
                                <#if obj.isSelected()>
                                    <#assign found = true>
                                    <#break>
                                </#if>
                            </#list>
                            <${navigationEntry.isBrowsable()?then("a","span tabindex='0'")}  href="${navigationEntry.isBrowsable()?then(navigationEntry.getURL(),"#")}" class="st-nav-primary__link ${(found || navigationEntry.isSelected())?then("link-selected","")}">${navigationEntry.getName()}</${navigationEntry.isBrowsable()?then("a","span")}>
                            <#if navigationEntry.hasBrowsableChildren()>
                                <div class="dropdown-content" aria-label="Services Dropdown">
                                    <ul class="sub-menu">
                                        <#list navigationEntry.getBrowsableChildren() as nav_item>
                                            <li class="st-nav-primary__item">
                                                <a href="${nav_item.isBrowsable()?then(nav_item.getURL(),"#")}" class="st-nav-primary__link" >${nav_item.getName()}</a>
                                            </li>
                                        </#list>
                                    </ul>
                                </div>
                            </#if>

                        </li>
                    </#list>
                </#if>
            </ul>
        </nav>
    </div>

</div>


