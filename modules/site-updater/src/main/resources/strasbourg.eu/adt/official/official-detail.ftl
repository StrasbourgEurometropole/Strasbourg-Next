<!-- Détail élu -->
<#setting locale=locale />


<#assign fonction = "" />
<#if entry.fonctionCity?has_content>
    <#assign fonction = languageUtil.get(locale, "eu.official.city-of-strasbourg") + " : " + entry.getName(entry.fonctionCity, locale) />
</#if>
<#if entry.fonctionEurometropole?has_content>
    <#if fonction?has_content>
        <#assign fonction = fonction + "; " />
    </#if>
    <#assign fonction = fonction + languageUtil.get(locale, "eu.official.eurometropole-of-strasbourg") + " : " + entry.getName(entry.fonctionEurometropole, locale) />
    <#if entry.fonctionTown?has_content>
        <#assign fonction = fonction + ", " + entry.getName(entry.fonctionTown, locale) + " " + languageUtil.get(locale, "eu.official.of-the-city-of") + " " + entry.getTown().getTitle(locale)/>
    </#if>
</#if>

<#assign imageUrl = ""/>
<!-- image -->
<#if entry.imageURL?has_content>
    <#assign imageUrl = themeDisplay.getPortalURL() + entry.imageURL?replace('@', "")?replace('cdn_hostroot_path', "") />
</#if>
<#-- Liste des infos a partager -->
<#assign openGraph={ "og:title" :"${entry.firstName?html} ${entry.lastName?html}", "og:description" :'${fonction?html}', "og:image" :"${imageUrl}"
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<header class="st-header-fiche-person">
    <div class="st-wrapper st-wrapper-small">
        <div class="st-heading">
            <div class="st-caption">
                <h1 class="st-h1 st-title">
                    ${entry.firstName} ${entry.lastName}
                </h1>
                <#if entry.fonctionCity?has_content>
                    <p class="st-role">
                        ${entry.getName(entry.fonctionCity, locale)}
                    </p>
                </#if>

                <p class="st-surtitre-cat">
                    ${entry.getName(entry.fonctionEurometropole, locale)}
                </p>
                <#if entry.fonctionTown?has_content>
                    <p class="st-surtitre-cat">
                        ${entry.getName(entry.fonctionTown, locale)}
                        <@liferay_ui.message key="eu.official.of-the-city-of" />
                        ${entry.getTown().getTitle(locale)}
                    </p>
                </#if>
                <@liferay.breadcrumbs />
            </div>
            <div class="st-image">
                <@strasbourg.addImage fileEntryId=entry.imageId maxWidth=270 isFigure=true />
            </div>
        </div>
    </div>
</header>
<div class="st-content">
    <#if entry.fonctionCity?has_content>
        <div class="st-bloc st-bloc-sit-text-person st-wrapper st-wrapper-small st-text-styles st--has-margin">
            <h2 class="st-h2">
                <@liferay_ui.message key="eu.official.city-of-strasbourg" /> :<br><span class="st-text-light">
                        ${entry.getName(entry.fonctionCity, locale)}
                    </span>
            </h2>
            <#if entry.districts?has_content>
                <#if entry.getGender() == 1>
                    <p class="st-surtitre-cat"><@liferay_ui.message key="male-official-of-the-district" /></p>
                <#else>
                    <p class="st-surtitre-cat"><@liferay_ui.message key="female-official-of-the-district" /></p>
                </#if>
                <ul>
                    <#list entry.districts as district>
                        <li>${district.getTitle(locale)}</li>
                    </#list>
                </ul>
            </#if>
            <#if entry.getThematicDelegation(locale)?has_content>
                <p class="st-surtitre-cat">
                    <@liferay_ui.message key="eu.official.in-charge-of" /> :
                </p>
                ${entry.getThematicDelegation(locale)}
            </#if>
            <#if entry.getPoliticalGroupCity()?has_content>
                <p class="st-surtitre-cat">
                    <@liferay_ui.message key="eu.official.political-group" />
                </p>
                <p class="st-note">
                    ${entry.getPoliticalGroupCity().getTitle(locale)}
                </p>
            </#if>
        </div>
    </#if>
    <#if entry.fonctionEurometropole?has_content>
        <div class="st-bloc st-bloc-sit-text-person st-wrapper st-wrapper-small st-text-styles st--has-margin">
            <h2 class="st-h2">
                <@liferay_ui.message key="eu.official.eurometropole-of-strasbourg" /> :<br><span class="st-text-light">
                        ${entry.getName(entry.fonctionEurometropole, locale)}
                    <#if entry.fonctionTown?has_content>,
                        ${entry.getName(entry.fonctionTown, locale)}
                        <@liferay_ui.message key="eu.official.of-the-city-of" />
                        ${entry.getTown().getTitle(locale)}
                    </#if>
                    </span>
            </h2>

            <#if entry.getMissions(locale)?has_content>
                <p class="st-surtitre-cat">
                    <@liferay_ui.message key="eu.official.in-charge-of" />
                </p>
                ${entry.getMissions(locale)}
            </#if>
            <#if entry.getPoliticalGroupEurometropole()?has_content>
                <p class="st-surtitre-cat">
                    <@liferay_ui.message key="eu.official.political-group" />
                </p>
                <p class="st-note">
                    ${entry.getPoliticalGroupEurometropole().getTitle(locale)}
                </p>
            </#if>
        </div>
    </#if>
    <div class="st-bloc st-bloc-sit-focus st-wrapper ">
        <div class="st-container">
            <div class="st-col-left">
                <h2 class="st-h2">Contact</h2>
                <p class="st-surtitre-cat">
                    ${entry.firstName} ${entry.lastName}
                </p>
            </div>
            <#if entry.listeContact?has_content>
                <div class="st-col-right">
                    <a href="#st-overlay-contact" class="st-btn st--btn-secondary-ghost">
                        <@liferay_ui.message key="eu.contact-mail" />
                    </a>
                </div>
            </#if>
        </div>
    </div>
</div>

<#if entry.listeContact?has_content>
    <@liferay_portlet.actionURL var="contactURL" name="contact">
        <@liferay_portlet.param name="classPK" value="${entry.getOfficialId()}" />
        <@liferay_portlet.param name="entityId" value="${entry.getOfficialId()}" />
        <@liferay_portlet.param name="title" value="${entry.getFirstName()} ${entry.getLastName()}" />
        <@liferay_portlet.param name="type" value="Official" />
    </@liferay_portlet.actionURL>
    <#assign overlayContactTitle="${entry.getFirstName()} ${entry.getLastName()}" />
    <@strasbourg.overlayContact entry=entry entryType="Official" />
</#if>