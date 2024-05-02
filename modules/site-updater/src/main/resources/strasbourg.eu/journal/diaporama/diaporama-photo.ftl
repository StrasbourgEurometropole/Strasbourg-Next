<!-- diaporama photo -->
<#setting locale = locale />
<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext() />
<#assign request = serviceContext.getRequest()/>

<#assign imageUrl = ""/>
<!-- image -->
<#if image.getData()?has_content>
    <#assign imageUrl = image.getData()?replace('@', "")?replace('cdn_hostroot_path', "") />
</#if>

<#-- Liste des infos a partager -->
<#assign openGraph = {
"og:title":"${title.getData()?html}",
"og:description":'${content.getData()?replace("<[^>]*>", "", "r")?html}',
"og:image":"${imageUrl}"
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}


<header class="st-header-without-sticky">
    <div class="st-wrapper">
        <div class="st-wrapper-modifier">
            <h1 class="st-h1">${title.getData()}</h1>
            <@liferay.breadcrumbs />
        </div>
    </div>
</header>

<div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">
    <div class="st-component-container st-text-styles">
        <p class="st-surtitre">
            <strong>
                ${content.getData()}
            </strong>
        </p>

        <div class="st-bloc st-bloc-galerie st-js-slider-galerie splide st-u-overflow-x-hidden st--direction-ltr" role="group">
            <div class="st-wrapper st-bloc-galerie__inner">
                <#if photos.getSiblings()?has_content>
                <div class="st-slider-container">
                    <div class="splide__arrows st-nav-arrows">
                        <button class="splide__arrow splide__arrow--prev st-btn-arrow st--prev"></button>
                        <button class="splide__arrow splide__arrow--next st-btn-arrow st--next"></button>
                    </div>

                    <div class="splide__track st-u-overflow-visible">
                        <ul class="splide__list">
                            <#list photos.getSiblings() as photo>
                                <li class="splide__slide">
                                    <figure class="st-figure st-fit-cover" role="group" aria-label="">
                                        <picture>
                                            <img alt="${photo.getAttribute("alt")! ""}" data-fileentryid="${photo.getAttribute("fileEntryId")! ""}" src="${photo.getData()}" />
                                        </picture>
                                        <figcaption>
                                            <#if photo.getChildren()[0].getData()?has_content>
                                                ${photo.getChildren()[0].getData()}
                                            </#if>
                                        </figcaption>
                                    </figure>
                                    <button class="st-slide-galerie" aria-label="Afficher en grand"></button>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>

                <ul class="splide__pagination st-nav-dots"></ul>
            </div>
            </#if>
        </div>



    </div>
</div>


<style>
    .component-title.h4 {
        display: none;
    }
</style>
