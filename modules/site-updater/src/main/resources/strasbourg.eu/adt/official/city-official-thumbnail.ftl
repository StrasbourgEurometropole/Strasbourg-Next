<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>
<#assign plId=renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />
<@liferay_portlet.renderURL plid=plId var="detailURL" portletName="eu_strasbourg_portlet_entity_detail_EntityDetailPortlet" windowState="normal">
    <@liferay_portlet.param name="classPK" value="${entry.officialId}" />
    <@liferay_portlet.param name="returnURL" value="${currentURL}" />
</@liferay_portlet.renderURL>
<@liferay_portlet.actionURL var="detailURLFilter">
    <@liferay_portlet.param name="userTargetClassId" value="${entry.assetEntry.classNameId}" />
    <@liferay_portlet.param name="userTargetClassPK" value="${entry.assetEntry.classPK}" />
    <@liferay_portlet.param name="userTargetTitle" value="${entry.firstName} ${entry.lastName}" />
    <@liferay_portlet.param name="detailURL" value="${detailURL}" />
    <@liferay_portlet.param name="searchLogId" value="${renderRequest.getAttribute('searchLogId')!0}" />
</@liferay_portlet.actionURL>

<li>
    <div class="st-card-container">
        <a href="#" class="st-card st-card-person" onclick="updateModalOfficial(this)" data-detailurl="${detailURLFilter}" data-mailaddress="<#if entry.listeContact?has_content>${detailURLFilter}#st-overlay-contact</#if>" data-overlay-open="st-overlay-preview-person">

            <div class="st-caption">
                <p class="st-title-card">
                    ${entry.firstName} ${entry.lastName}
                </p>
                <#if entry.districts?has_content>
                    <#if entry.getGender() == 1>
                        <#assign officialTranslation = "male-official-of-the-district" />
                    <#else>
                        <#assign officialTranslation = "female-official-of-the-district" />
                    </#if>
                    <p class="st-role">
                        <@liferay_ui.message key=officialTranslation />
                        <#list entry.districts as district>
                            ${district.getTitle(locale)}
                        </#list>
                    </p>
                </#if>
                <#if entry.getName(entry.fonctionCity,locale)?has_content>
                    <p class="st-surtitre-cat">
                        ${entry.getName(entry.fonctionCity,locale)}
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
                        <@liferay_ui.message key="eu.official.political-group" /> : ${entry.getPoliticalGroupCity().getTitle(locale)}
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
                        <@liferay_ui.message key="eu.official.political-group" /> : ${entry.getPoliticalGroupEurometropole().getTitle(locale)}
                    </p>
                </div>
            </#if>
        </div>
    </div>
</li>