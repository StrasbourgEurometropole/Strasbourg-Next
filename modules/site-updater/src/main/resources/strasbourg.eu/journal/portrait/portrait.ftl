<#setting locale = locale />

<#-- Liste des infos a partager -->
<#assign openGraph = {
"og:title":"${title.getData()?html}",
"og:description":'${chapo.getData()?replace("<[^>]*>", "", "r")?html}'
} />


<script>
    $('.bg-banner .banner__title').text("${title.getData()?js_string}");
    $('.bg-banner .banner__description').hide();
</script>

<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<header class="st-header-fiche-person">
    <div class="st-wrapper st-wrapper-small">
        <div class="st-heading">
            <div class="st-caption">
                <h1 class="st-h1 st-title">
                    ${title.getData()}
                </h1>

                <p class="st-surtitre-cat">
                    <@liferay_ui.message key="eu.published-on" />
                    ${.vars['reserved-article-display-date'].getData()?date("EEE, dd MMM yyyy hh:mm:ss Z")?string["dd/MM/yyyy"]}
                    - <@liferay_ui.message key="eu.modified-on" />
                    ${.vars['reserved-article-modified-date'].getData()?date("EEE, dd MMM yyyy hh:mm:ss Z")?string["dd/MM/yyyy"]}
                </p>
                <@liferay.breadcrumbs />
            </div>
        </div>
    </div>
</header>

<div class="st-content">
    <div class="st-bloc st-wrapper st-text-styles st-wrapper-small st--has-margin">
        <p class="st-surtitre">${chapo.getData()}</p>
        ${content.getData()}
    </div>
</div>
<style>
    .search-asset-portlet, .portlet-body .component-title {
        display: none !important;
    }

    .autofit-row.metadata-author {
        display:none;
    }

    .lfr-tooltip-scope {
        position: absolute;
        right: 0;
    }
    @media (max-width: 700px) {
        .journal-content-article .st-content .st-bloc img {
            margin-left: 0 !important;
            margin-right: 0 !important;
        }
    }
</style>
