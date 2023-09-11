<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />
<div class="st-bloc st-bloc-editions-dossiers st-wrapper ">
    <div class="st-col-left">
        <h2 class="st-h2">Nos éditions</h2>
        <ul class="st-editions-container">
            <#list entries as curEntry>
                <#assign entry=curEntry.getAssetRenderer().getEdition() />
                <li class="st-edition">
                    <div class="st-image">
                        <@addImage fileEntryId=entry.getImageId() isFigure=true />
                    </div>
                    <div class="st-content">
                        <h3 class="st-h3">
                            ${entry.getTitle(locale)}
                        </h3>
                        <a href="${homeURL}edition/-/entity/id/${entry.getEditionId()}" class="st-btn st--btn-xs st--btn-secondary">
                            <@liferay_ui.message key="eu.edition.view" />
                        </a>
                        <a href="${entry.getFileDownloadURL(locale)}" class="st-btn st--btn-xs" download>
                            <@liferay_ui.message key="eu.download" />
                        </a>
                    </div>
                </li>
            </#list>
        </ul>
        <a href="#" class="st-btn st--btn-secondary">
            <@liferay_ui.message key="eu.all-editions" />
        </a>
    </div>
</div>