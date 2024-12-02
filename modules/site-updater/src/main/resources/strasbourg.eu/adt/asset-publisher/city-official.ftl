<!-- Maire de la commune -->

<#setting locale = locale />

<div class="st-wrapper st-bloc st-bloc-elu st--with-image st--has-margin st-container">
    <div class="st-container">
        <#if entries?has_content>
            <#assign official = entries[0].assetRenderer.official />
            <h2 class="st-h2 st-title">Maire de la commune</h2>

            <div class="st-bloc-elu__inner">
                <div class="st-image">
                    <#assign defaultFile = "silhouette_homme.jpg" />
                    <#if official.gender == 2>
                        <#assign defaultFile = "silhouette_femme.jpg" />
                    </#if>
                    <@strasbourg.addImage fileEntryId=official.imageId defaultFile=defaultFile maxWidth=900 showCopyright=false />
                </div>

                <div class="st-caption">
                    <p class="st-name">${official.firstName} ${official.lastName}</p>
                    <p class="st-resume-fonction"> ${official.getResumeFonction(locale)}</p>
                    <p class="st-surtitre-cat"> ${official.getName(official.fonctionTown, locale)} <@liferay_ui.message key="eu.official.of" /> ${official.getTown().getTitle(locale)}</p>
                </div>

                <a href="${strasbourg.homeURL()}elu/-/entity/id/${official.officialId}" class="st-btn st--btn-secondary st--btn-secondary-ghost st--btn-small-padding st--btn-full-width-mobile"><@liferay_ui.message key="learn-more" /></a>
            </div>
        </#if>

    </div>


</div>