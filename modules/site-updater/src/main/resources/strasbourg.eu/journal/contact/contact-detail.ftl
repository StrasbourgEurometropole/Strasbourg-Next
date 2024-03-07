<!-- Détail contact -->
<#setting locale=locale />
<header class="st-header-fiche-service">
    <div class="st-wrapper st-wrapper-small">
        <div class="st-heading">
            <h1 class="st-h1 st-title">
                ${name.data}
            </h1>
        </div>
        <@liferay.breadcrumbs />
    </div>
</header>
<#if presentation.data?has_content>
    <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.presentation" />
        </h2>
        <div class="st-component-container st-text-styles">
            <div class="st-limit-height st--is-overflowing">
                ${presentation.data}
            </div>
            <div class="st-show-more">
                <button class="st-btn-show-more st-btn-arrow st--down"
                        aria-expanded="false"
                        data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
                </button>
            </div>
        </div>
    </div>
</#if>
<div class="st-bloc st-bloc-infos-complementaires st-wrapper st-wrapper-small st--has-margin">
    <div class="st-container">
        <#if office.data?has_content>
            <div class="st-component st-component-type-4">
                <h2 class="st-h2 st-title">
                    <@liferay_ui.message key="eu.place.public-reception" />
                </h2>
                <div class="st-component-container">
                    <div class="st-card-container">
                        ${office.data}
                    </div>
                </div>
            </div>
        </#if>
        <#if address.data?has_content>
            <div class="st-component st-component-type-3">
                <h2 class="st-h2 st-title">
                    <@liferay_ui.message key="address" />
                </h2>
                <div class="st-component-container">
                    ${address.data}
                </div>
            </div>
        </#if>
    </div>
</div>
<#if websiteURL.data?has_content && websiteName.data?has_content>
    <div class="st-bloc st-bloc-infos-complementaires st-wrapper st-wrapper-small st--has-margin">
        <div class="st-container">
            <div class="st-component st-component-type-2">
                <h2 class="st-h2 st-title">
                    <@liferay_ui.message key="eu.website" />
                </h2>
                <div class="st-component-container">
                    <div class="st-liste st-limit-height">
                        <div class="st-lien-container">
                            <a href="${websiteURL.data}" class="st-lien" title="${websiteName.data}
                    <@liferay_ui.message key=" eu.new-window" />" target="_blank">
                                <p class="st-title-lien">
                                    ${websiteName.data}
                                </p>
                                <p class="st-text">
                                    <@liferay_ui.message key="eu.access-page" />
                                </p>
                            </a>
                        </div>
                    </div>
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
</#if>
<#if mondayMorning.data?has_content ||
mondayAfternoon.data?has_content ||
tuesdayMorning.data?has_content ||
tuesdayAfternoon.data?has_content ||
wednesdayMorning.data?has_content ||
wednesdayAfternoon.data?has_content ||
thursdayMorning.data?has_content ||
thursdayAfternoon.data?has_content ||
fridayMorning.data?has_content ||
fridayAfternoon.data?has_content ||
saturdayMorning.data?has_content ||
saturdayAfternoon.data?has_content ||
sundayMorning.data?has_content ||
sundayAfternoon.data?has_content>
    <div class="st-bloc st-bloc-sit-onglets st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.times" />
        </h2>
        <div class="st-container st-tabpanel">
            <ul class="st-list-rows st-basic-grid st-col-2@t-small">
                <#if mondayMorning.data?has_content || mondayAfternoon.data?has_content>
                    <li class="st-item-row">
                        <p class="st-title">
                            <@liferay_ui.message key="monday" />
                        </p>
                        <div class="st-info st-u-color-secondary">
                            <#if mondayMorning.data?has_content>
                                <p>
                                    ${mondayMorning.data}
                                </p>
                            </#if>
                            <#if mondayAfternoon.data?has_content>
                                <p>
                                    ${mondayAfternoon.data}
                                </p>
                            </#if>
                        </div>
                    </li>
                </#if>
                <#if tuesdayMorning.data?has_content || tuesdayAfternoon.data?has_content>
                    <li class="st-item-row">
                        <p class="st-title">
                            <@liferay_ui.message key="tuesday" />
                        </p>
                        <div class="st-info st-u-color-secondary">
                            <#if tuesdayMorning.data?has_content>
                                <p>
                                    ${tuesdayMorning.data}
                                </p>
                            </#if>
                            <#if tuesdayAfternoon.data?has_content>
                                <p>
                                    ${tuesdayAfternoon.data}
                                </p>
                            </#if>
                        </div>
                    </li>
                </#if>
                <#if wednesdayMorning.data?has_content || wednesdayAfternoon.data?has_content>
                    <li class="st-item-row">
                        <p class="st-title">
                            <@liferay_ui.message key="wednesday" />
                        </p>
                        <div class="st-info st-u-color-secondary">
                            <#if wednesdayMorning.data?has_content>
                                <p>
                                    ${wednesdayMorning.data}
                                </p>
                            </#if>
                            <#if wednesdayAfternoon.data?has_content>
                                <p>
                                    ${wednesdayAfternoon.data}
                                </p>
                            </#if>
                        </div>
                    </li>
                </#if>
                <#if thursdayMorning.data?has_content || thursdayAfternoon.data?has_content>
                    <li class="st-item-row">
                        <p class="st-title">
                            <@liferay_ui.message key="thursday" />
                        </p>
                        <div class="st-info st-u-color-secondary">
                            <#if thursdayMorning.data?has_content>
                                <p>
                                    ${thursdayMorning.data}
                                </p>
                            </#if>
                            <#if thursdayAfternoon.data?has_content>
                                <p>
                                    ${thursdayAfternoon.data}
                                </p>
                            </#if>
                        </div>
                    </li>
                </#if>
                <#if fridayMorning.data?has_content || fridayAfternoon.data?has_content>
                    <li class="st-item-row">
                        <p class="st-title">
                            <@liferay_ui.message key="friday" />
                        </p>
                        <div class="st-info st-u-color-secondary">
                            <#if fridayMorning.data?has_content>
                                <p>
                                    ${fridayMorning.data}
                                </p>
                            </#if>
                            <#if fridayAfternoon.data?has_content>
                                <p>
                                    ${fridayAfternoon.data}
                                </p>
                            </#if>
                        </div>
                    </li>
                </#if>
                <#if saturdayMorning.data?has_content || saturdayAfternoon.data?has_content>
                    <li class="st-item-row">
                        <p class="st-title">
                            <@liferay_ui.message key="saturday" />
                        </p>
                        <div class="st-info st-u-color-secondary">
                            <#if saturdayMorning.data?has_content>
                                <p>
                                    ${saturdayMorning.data}
                                </p>
                            </#if>
                            <#if saturdayAfternoon.data?has_content>
                                <p>
                                    ${saturdayAfternoon.data}
                                </p>
                            </#if>
                        </div>
                    </li>
                </#if>
                <#if sundayMorning.data?has_content || sundayAfternoon.data?has_content>
                    <li class="st-item-row">
                        <p class="st-title">
                            <@liferay_ui.message key="sunday" />
                        </p>
                        <div class="st-info st-u-color-secondary">
                            <#if sundayMorning.data?has_content>
                                <p>
                                    ${sundayMorning.data}
                                </p>
                            </#if>
                            <#if sundayAfternoon.data?has_content>
                                <p>
                                    ${sundayAfternoon.data}
                                </p>
                            </#if>
                        </div>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</#if>
<#if exceptionnalSchedule.data?has_content>
    <h3>
        <@liferay_ui.message key="eu.exceptional-schedule" />
    </h3>
    <div>
        ${exceptionnalSchedule.data}
    </div>
</#if>
<div class="st-bloc st-bloc-sit-contact-service st-wrapper st-wrapper-small ">
    <div class="st-bloc-heading">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="contact.contact-us" />
        </h2>
        <#if phone.data?has_content>
            <a href="tel:${phone.data}" class="st-btn st--btn-full-width-mobile">
                ${phone.data}
            </a>
        </#if>
    </div>
</div>