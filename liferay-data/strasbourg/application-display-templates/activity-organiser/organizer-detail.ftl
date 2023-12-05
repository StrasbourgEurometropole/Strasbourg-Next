<!-- Détail organisateurs -->
<#setting locale = locale />

<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<#-- Liste des infos a partager -->
<#assign openGraph = {
"og:description":'${entry.getPresentation(locale)?replace("<[^>]*>", "", "r")?html}'
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}

<header class="st-header-fiche-person" role="banner">
    <div class="st-wrapper st-wrapper-small">
        <div class="st-heading">
            <div class="st-caption">
                <h1 class="st-h1 st-title">${entry.getName(locale)}</h1>
                <@liferay.breadcrumbs />
            </div>
            <div class="st-image">
                <@addImage fileEntryId=entry.imageId isFigure=true />
            </div>
        </div>
    </div>
</header>

<#if entry.getPresentation(locale)?has_content>
    <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.presentation" />
        </h2>
        <div class="st-component-container st-text-styles">
            <div class="st-limit-height st--is-overflowing">
                <p>
                    ${entry.getPresentation(locale)}
                </p>
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

<div class="st-bloc st-bloc-sit-colonnes st-wrapper st-wrapper-small st-basic-grid st-col-2@t-small st--has-margin">
    <#if entry.getAddress(locale)?has_content>
        <div class="st-col">
            <div class="st-component-container st-text-styles">
                <h2 class="st-h2 st-bloc-sit-title">
                    <@liferay_ui.message key="address" />
                </h2>
                ${entry.getAddress(locale)}
            </div>
        </div>
    </#if>

    <#if entry.getSiteURL(locale)?has_content>
        <div class="st-col">
            <div class="st-component-container st-text-styles">
                <h2 class="st-h2 st-bloc-sit-title">
                    <@liferay_ui.message key="eu.website" />
                </h2>
                <a href="${entry.getSiteURL(locale)}" title="<@liferay_ui.message key='eu.new-window' />" target="_blank">${entry.getSiteURL(locale)}</a>
            </div>
        </div>
    </#if>
</div>

<!-- Contact -->
<#if entry.mail?has_content>
    <div class="st-bloc st-bloc-sit-focus st-wrapper ">
        <div class="st-container">
            <div class="st-col-left">
                <h2 class="st-h2">Contact</h2>
                <p class="st-surtitre-cat">
                    ${entry.getName(locale)}
                </p>
            </div>
            <div class="st-col-right">
                <a href="tel:${entry.phone}" class="st-btn st--btn-secondary-ghost">
                    ${entry.phone}
                </a>

                <a href="#st-overlay-contact" class="st-btn st--btn-secondary-ghost">
                    <@liferay_ui.message key="eu.contact-mail" />
                </a>
            </div>
        </div>
    </div>
    <@liferay_portlet.actionURL var="contactURL" name="contact">
        <@liferay_portlet.param name="classPK" value="${entry.activityOrganizerId}" />
        <@liferay_portlet.param name="entityId" value="${entry.activityOrganizerId}" />
        <@liferay_portlet.param name="title" value="Organisateur d'activité ${entry.getName(locale)}" />
        <@liferay_portlet.param name="type" value="ActivityOrganizer" />
    </@liferay_portlet.actionURL>
    <#assign overlayContactTitle="${entry.getName(locale)}" />
    <#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/overlay-contact.ftl" />
</#if>
<style>
    .mail-success {
        background: #4CAF50;
        color: white;
        padding: 40px;
    }
</style>