<#setting locale = locale />

<!-- Liste de lieux -->
<#assign portletHelper = serviceLocator.findService("eu.strasbourg.utils.api.PortletHelperService") />

<div class="st-listing-cards st-wrapper st-wrapper-small st-bloc st--has-margin">
    <#if entries?has_content>
        <ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">

            <#list entries as curEntry>
                <#assign place=curEntry.assetRenderer.place />
                <li>
                    <div class="st-card-container">
                        <a href="${strasbourg.homeURL()}lieu/-/entity/sig/${place.getSIGid()}/${place.getNormalizedAlias(locale)}" class="st-card st--card-horizontal st--with-gradient <#if place.getImageId() == 0 || !place.getImageURL()?has_content>st--with-icon</#if>">
                            <div class="st-caption">
                                <h3 class="st-title-card">
                                    ${place.getAlias(locale)}
                                </h3>
                                <p class="st-surtitre-cat">
                                    ${place.getTypeLabel(locale)}
                                </p>
                                <p class="st-location">
                                    ${place.getCity(locale)}
                                </p>
                            </div>
                            <div class="st-image">
                                <#if place.getImageId() !=0>
                                    <@strasbourg.addImage fileEntryId=place.getImageId() maxWidth=100 showLegende=false showCopyright=false isFigure=true />
                                <#elseif place.getImageURL()?has_content>
                                    <figure class="st-figure st-fit-cover" role="group">
                                        <img alt="" loading="lazy" src="${place.getImageURL()}" />
                                    </figure>
                                <#else>
                                    <span class="st-icon st-icon-pin"></span>
                                </#if>
                                <#if place.periods?has_content>
                                <#if place.isOpenNow()>
                                    <p class="st-badge-ouverture">
                                        <@liferay_ui.message key='open-period' />
                                    </p>
                                <#else>
                                    <p class="st-badge-ouverture st--closed">
                                        <@liferay_ui.message key='closed-period' />
                                    </p>
                                </#if>
                                </#if>
                            </div>
                        </a>
                    </div>
                </li>
            </#list>
        </ul>
    </#if>
</div>