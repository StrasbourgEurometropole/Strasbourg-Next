<!-- Détail galerie d'éditions -->

<#setting locale=locale />
<#assign imageUrl="" />
<!-- image -->
<#if entry.imageURL?has_content>
    <#assign imageUrl=themeDisplay.getPortalURL() + entry.imageURL?replace('@', "" )?replace('cdn_hostroot_path', "" ) />
</#if>
<#-- Liste des infos a partager -->
<#assign openGraph={ "og:title" :"${entry.getTitle(locale)?html}", "og:description" :'${entry.getDescription(locale)?replace("<[^>]
*>", "", "r")?html}', "og:image" :"${imageUrl}"
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<header class="st-header-without-sticky">
    <div class="st-wrapper">
        <h1 class="st-h1">
            ${entry.getTitle(locale)}
        </h1>
        <@liferay.breadcrumbs />
        <div class="st-img-wrapper st-img-fit-content st-img-center" tabindex="0">
            <#if entry.publishedEditions?has_content>
                <#assign edition=entry.publishedEditions?reverse?first />
                <@strasbourg.addImage fileEntryId=edition.getImageId() maxWidth=1120 showCopyright=false  />
            </#if>
        </div>
    </div>
</header>
<div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
    <h2 class="st-h2 st-bloc-sit-title">
        <@liferay_ui.message key="description" />
    </h2>
    <div class="st-component-container st-text-styles">
        <div class="st-limit-height st--is-overflowing">
            ${entry.getDescription(locale)}
        </div>
        <div class="st-show-more">
            <button class="st-btn-show-more st-btn-arrow st--down"
                    aria-expanded="false"
                    data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
            </button>
        </div>
    </div>
    <p class="st-surtitre">
        <strong>
            Nombre d'éditions : ${entry.publishedEditions?size}
        </strong>
    </p>
</div>
<div class="st-listing-cards st-wrapper st-wrapper-small st-bloc-editions-dossiers">
    <ul class="st-cards-wrapper st--has-cards-vertical st-basic-grid st-col-1@mobile st-col-2@t-small">
        <#if entry.publishedEditions?has_content>
            <#list entry.publishedEditions?reverse as edition>
                <li class="st-edition">
                    <div class="st-image " style="width: 130px">
                        <@strasbourg.addImage fileEntryId=edition.getImageId() maxWidth=130 showLegende=false showCopyright=false  />
                    </div>
                    <div class="st-content">
                        <h3 class="st-h3">
                            ${edition.getTitle(locale)}
                        </h3>
                        <a href="${edition.getURL(locale)}" class="st-btn st--btn-xs st--btn-secondary">
                            <@liferay_ui.message key="eu.edition.view" />
                        </a>
                        <a href="${edition.getFileDownloadURL(locale)}" class="st-btn st--btn-xs" download>
                            <@liferay_ui.message key="eu.download" />
                        </a>
                    </div>
                </li>
            </#list>
        </#if>
    </ul>
</div>