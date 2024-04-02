
<div class="st-bloc st-bloc-editions-dossiers">
    <div class="st-col-left">
        <h2 class="st-h2"><@liferay_ui.message key="eu.our.edition" /></h2>
        <ul class="st-editions-container">
            <#list entries as curEntry>
                <#assign entry=curEntry.getAssetRenderer().getEdition() />
                <li class="st-edition">
                    <div class="st-image" style="width: 130px;">
                        <@strasbourg.addImage fileEntryId=entry.getImageId() maxWidth=130 showLegende=false showCopyright=false isFigure=true />
                    </div>
                    <div class="st-content">
                        <h3 class="st-h3">
                            ${entry.getTitle(locale)}
                        </h3>
                        <a href="${entry.getURL(locale)}" class="st-btn st--btn-xs st--btn-secondary">
                            <@liferay_ui.message key="eu.edition.view" />
                        </a>
                        <#if entry.getEditionGalleries()?size != 0>
                            <#assign galery = entry.getEditionGalleries()[0] >
                            <a href="${strasbourg.homeURL()}galerie-editions/-/entity/id/${galery.getGalleryId()}" class="st-btn st--btn-xs">
                                <@liferay_ui.message key="eu.all.of-x" arguments="${galery.getTitle(locale)}" />
                            </a>
                        </#if>

                    </div>
                </li>
            </#list>
        </ul>

    </div>

</div>