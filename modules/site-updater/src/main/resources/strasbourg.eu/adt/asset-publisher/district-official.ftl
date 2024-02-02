<!-- Adjoint de quartier -->

<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<div class="st-wrapper st-bloc st-bloc-elu st--with-image st--has-margin st-container">
    <div class="st-container">
        <#if entries?has_content>
            <#assign official = entries[0].assetRenderer.official />
            <h2 class="st-h2 st-title">
                <#if official.gender == 1>
                    <@liferay_ui.message key="male-official-of-the-district" />
                <#else>
                    <@liferay_ui.message key="female-official-of-the-district" />
                </#if>
            </h2>

            <div class="st-bloc-elu__inner">
                <div class="st-image">
                    <@strasbourg.addImage fileEntryId=official.imageId  showCopyright=false  />
                </div>

                <div class="st-caption">
                    <p class="st-name">${official.firstName} ${official.lastName}</p>
                    <p class="st-surtitre-cat">
                        <#if official.gender == 1>
                            <@liferay_ui.message key="male-strasbourg-mayer-deputy" />
                        <#else>
                            <@liferay_ui.message key="female-strasbourg-mayer-deputy" />
                        </#if>
                    </p>
                </div>

                <a href="${strasbourg.homeURL}elu/-/entity/id/${official.officialId}" class="st-btn st--btn-secondary st--btn-secondary-ghost st--btn-small-padding st--btn-full-width-mobile"><@liferay_ui.message key="learn-more" /></a>
            </div>
        </#if>

    </div>


</div>