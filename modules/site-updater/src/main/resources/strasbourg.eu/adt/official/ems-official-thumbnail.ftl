<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#assign plId=renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />

<li>
    <div class="st-card-container">
        <a href="#" role="button" class="st-card st-card-person" onclick="updateModalOfficial(this)"
           data-detailurl="${homeURL}elu/-/entity/id/${entry.getOfficialId()}"
           data-mailaddress="<#if entry.listeContact?has_content>${homeURL}elu/-/entity/id/${entry.getOfficialId()}#st-overlay-contact</#if>"
           data-overlay-open="st-overlay-preview-person">

            <div class="st-caption">
                <h3 class="st-title-card">
                    ${entry.firstName} ${entry.lastName}
                </h3>
                <#if entry.getName(entry.fonctionEurometropole,locale)?has_content>
                    <p class="st-surtitre-cat">
                        ${entry.getName(entry.fonctionEurometropole,locale)}
                    </p>
                </#if>
                <#if entry.fonctionTown?has_content>
                    <p class="st-role">
                        ${entry.getName(entry.fonctionTown, locale)}
                        <@liferay_ui.message key="eu.official.of-the-city-of" />
                        ${entry.getTown().getTitle(locale)}
                    </p>
                </#if>
            </div>
            <div class="st-image">
                <#assign defaultFile = "silhouette_homme.jpg" />
                <#if entry.gender == 2>
                    <#assign defaultFile = "silhouette_femme.jpg" />
                </#if>
                <@strasbourg.addImage fileEntryId=entry.imageId defaultFile=defaultFile maxWidth=195 showLegende=false showCopyright=false isFigure=true />
            </div>
        </a>
        <div class="st-hide st-description">
            <#if entry.fonctionCity?has_content>
                <div class="st-container st-text-styles">
                    <h3 class="st-title-small">
                        ${entry.getName(entry.fonctionCity, locale)}
                    </h3>
                    ${entry.getThematicDelegation(locale)}
                    <p class="st-note">
                        <@liferay_ui.message key="eu.official.political-group" /> :
                        ${entry.getPoliticalGroupCity().getTitle(locale)}
                    </p>
                </div>
            </#if>
            <#if entry.fonctionEurometropole?has_content>
                <div class="st-container st-text-styles">
                    <h3 class="st-title-small">
                        ${entry.getName(entry.fonctionEurometropole, locale)}
                        <#if entry.fonctionTown?has_content>,
                            ${entry.getName(entry.fonctionTown, locale)}
                            <@liferay_ui.message key="eu.official.of-the-city-of" />
                            ${entry.getTown().getTitle(locale)}
                        </#if>
                    </h3>
                    ${entry.getMissions(locale)}
                    <p class="st-note">
                        <@liferay_ui.message key="eu.official.political-group" /> :
                        ${entry.getPoliticalGroupEurometropole().getTitle(locale)}
                    </p>
                </div>
            </#if>
        </div>
    </div>
</li>