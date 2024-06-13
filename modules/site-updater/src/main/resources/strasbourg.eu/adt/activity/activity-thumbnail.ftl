<!-- Vignette activité -->
<#setting locale = locale />


<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<li>
    <div class="st-card-container">
        <a role="button" href="#st-overlay-preview-activite-${entry.getActivityId()}" class="st-card" id="${entry.getActivityId()}" onclick="updateModalActivity(this)">
            <div class="st-caption">
                <p class="st-title-card">${entry.getTitle(locale)}</p>
                <p class="st-surtitre-cat">${entry.getTypesLabel(locale)}</p>
                <p class="st-text">${entry.getDescription(locale)?replace(r'<[^>]*>', '', 'r')?truncate(170, "...")}</p>
                <p class="st-all-text hidden">${entry.getDescription(locale)?replace(r'<[^>]*>', '', 'r')}</p>
            </div>
            <div class="st-image">
                <@strasbourg.addImage fileEntryId=entry.imageId maxWidth=210 showLegende=false showCopyright=false isFigure=true />
            </div>

        </a>
        <div class="cours-list st-hide">
            <#-- Si la recherche a renvoyé des cours pour lactivité, on affiche ceux-ci -->
            <#-- Sinon on affiche lensemble des cours de ladite activité -->
            <#-- Car si la recherche a renvoyé des activités sans ses cours, cest certainement que ce sont des cours qui nont pas dhoraires mais qui doivent tout de même être affichés -->
            <#if courses?has_content>
                <#assign activityCourses = courses />
            <#else>
                <#assign activityCourses = entry.publishedActivityCourses />
            </#if>
            <#list activityCourses as course>
                <div class="st-container">
                    <h3 class="st-title-small">${course.getName(locale)}</h3>
                    <p class="st-surtitre-cat">${course.getTypesLabels(locale)}, ${course.getPublicsLabel(locale)}</p>
                    <#if course.getDuration()?has_content &&  course.getDuration() != 0>
                        <p class="st-surtitre-alt">durée moyenne du cours : ${course.getDuration()} mins</p>
                    </#if>
                    <p class="st-location">${course.getPlaceNames(locale)?join(", ")}</p>

                    <div class="st-text st-text-styles">
                        ${course.getPresentation(locale)}
                    </div>
                    <a href="${strasbourg.homeURL()}${courseDetailPageFriendlyURL?remove_beginning('/')}/-/entity/id/${course.activityCourseId}" title="${course.getName(locale)}" class="st-btn st--btn-full-width-mobile">En savoir plus</a>
                </div>
            </#list>

        </div>
    </div>
</li>