<!-- Vignette activité -->
<#setting locale = locale />
<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />

<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<li>
    <div class="st-card-container">
        <a href="#" class="st-card" data-overlay-open="st-overlay-preview-activite" onclick="updateModalActivity(this)">
            <div class="st-caption">
                <p class="st-title-card">${entry.getTitle(locale)}</p>
                <p class="st-surtitre-cat">${entry.getTypesLabel(locale)}</p>
                <p class="st-text">${entry.getDescription(locale)?replace(r'<[^>]*>', '', 'r')}</p>
            </div>
            <div class="st-image">
                <@addImage fileEntryId=entry.imageId isFigure=true />
            </div>

        </a>
        <div class="cours-list st-hide">
            <#-- Si la recherche a renvoyé des cours pour l'activité, on affiche ceux-ci -->
            <#-- Sinon on affiche l'ensemble des cours de ladite activité -->
            <#-- Car si la recherche a renvoyé des activités sans ses cours, c'est certainement que ce sont des cours qui n'ont pas d'horaires mais qui doivent tout de même être affichés -->
            <#if courses?has_content>
                <#assign activityCourses = courses />
            <#else>
                <#assign activityCourses = entry.publishedActivityCourses />
            </#if>
            <#list activityCourses as course>
                <div class="st-container">
                    <p class="st-title-small">${course.getName(locale)}</p>
                    <p class="st-surtitre-cat">${course.getTypesLabels(locale)}, ${course.getPublicsLabel(locale)}</p>
                    <p class="st-surtitre-alt">durée moyenne du cours : 45 min</p>
                    <p class="st-location">Illkirch-Graffenstaden, Schiltigheim</p>
                    <div class="st-text st-text-styles">
                        ${course.getPresentation(locale)}
                    </div>
                    <a href="${homeURL}${courseDetailPageFriendlyURL?remove_beginning('/')}/-/entity/id/${course.activityCourseId}" title="${course.getName(locale)}" class="st-btn st--btn-full-width-mobile">En savoir plus</a>
                </div>
            </#list>

        </div>
    </div>
</li>