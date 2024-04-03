<!-- Liens utiles (externes) -->
<#setting locale=locale />
<#assign portletHelper=serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />
<div class="st-bloc st-bloc-infos-complementaires st-wrapper st--has-margin">
    <div class="st-container">
        <div class="st-component st-component-type-2">
            <h2 class="st-h2 st-title">
                ${portletHelper.getPortletTitle('eu.useful-links', renderRequest)}
            </h2>
            <div class="st-component-container">
                <ul class="st-liste st-limit-height">
                    <#if entries?has_content>
                        <#list entries as curEntry>
                            <#assign link=curEntry.getAssetRenderer().getLink() />
                            <li class="st-lien-container">
                                <a href="${link.getURL(locale)}" class="st-lien" target="_blank"
                                    <#if link.getHoverText(locale)?has_content>
                                   title="${link.getHoverText(locale)}"
                                    </#if> >
                                    <p class="st-title-lien">
                                        ${link.getTitle(locale)}
                                    </p>
                                    <p class="st-text">
                                        <@liferay_ui.message key="eu.access-page" />
                                    </p>
                                </a>
                            </li>
                        </#list>
                    </#if>
                </ul>
                <div class="st-show-more">
                    <button class="st-btn-show-more st-btn-arrow st--down"
                            aria-expanded="false"
                            data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>