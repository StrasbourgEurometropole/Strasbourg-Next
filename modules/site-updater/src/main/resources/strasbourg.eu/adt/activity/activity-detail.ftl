
<!-- Détail activity -->
<#setting locale=locale />
<#assign uriHelper=serviceLocator.findService("eu.strasbourg.utils.api.UriHelperService") />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#-- Liste des infos a partager -->
<#assign openGraph={ "og:description" :'${entry.getDescription(locale)?replace("<[^>]
*>", "", "r")?html}'
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<header class="st-header-fiche-agenda">
    <div class="st-wrapper st-wrapper-small">
        <p class="st-surtitre-cat st-hide-until@t-portrait">
            ${entry.getTypesLabel(locale)}
        </p>
        <h1 class="st-h1">
            ${entry.getTitle(locale)}
        </h1>
        <@liferay.breadcrumbs />
    </div>
</header>
<#if entry.getDescription(locale)?has_content>
    <div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
        <h2 class="st-h2 st-bloc-sit-title">
            <@liferay_ui.message key="eu.presentation" />
        </h2>
        <div class="st-component-container st-text-styles">
            <div class="st-limit-height st--is-overflowing">
                <p>
                    ${entry.getDescription(locale)}
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
<div class="st-bloc st-bloc-sit-colonnes st-wrapper st-wrapper-small st-bloc-sit-onglets st--has-margin">
    <#if entry.publishedActivityCourses?has_content>
        <h2 class="st-h2 st-bloc-sit-title"><@liferay_ui.message key="eu.activity.courses" /></h2>
        <div class="st-container" style="padding-top: 40px;">
            <#list entry.publishedActivityCourses as course>
                <div style="margin-bottom: 10px">
                    <a class="st-btn st--btn-secondary-ghost" href="${homeURL}cours/-/entity/id/${course.activityCourseId}" title="${entry.getTitle(locale)}">
                        ${course.getName(locale)}
                    </a>
                </div>
            </#list>
        </div>

    </#if>
</div>