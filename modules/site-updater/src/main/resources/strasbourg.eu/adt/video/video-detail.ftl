<!-- Détail Vidéo -->
<#setting locale=locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL="/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL="/" />
</#if>


<header class="st-header-without-sticky">
    <div class="st-wrapper">
        <div class="st-wrapper-modifier">
            <h1 class="st-h1">${entry.getTitle(locale)}</h1>
            <@liferay.breadcrumbs />
        </div>
    </div>
</header>

<div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin">

    <div class="st-component-container st-text-styles">
        <strong>
            ${entry.getDescription(locale)}
        </strong>


        <div class="st-bloc-video">
            <div class="st-container">
                <div class="st-embed-container">
                    ${entry.getPlayer(locale)}
                </div>
            </div>
        </div>

        <#if entry.getCopyright(locale) !="">
            <div class="source">
                <strong>
                    <@liferay.language key="credit" />
                </strong>&nbsp;${entry.getCopyright(locale)}
            </div>
        </#if>
    </div>
</div>