<!-- Vignette video -->


<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>
<#setting date_format="d/MM/yyyy">
<#assign fromSearch = renderRequest.getAttribute("fromSearchPortlet")!false >
<#assign plId = 0 />
<#if fromSearch>
    <#assign plId = renderRequest.getAttribute("classNameLayoutId")[entry.getModelClassName()] />
</#if>


<li>
    <div class="st-card-container">
        <a href="${strasbourg.homeURL()}video/-/entity/id/${entry.getVideoId()}" class="st-card" style="--aspect-ratio: 16/9;">
            <div class="st-caption">
                <h3 class="st-title-card">${entry.getTitle(locale)}</h3>
                <p class="st-surtitre-cat">${entry.getThemesLabel(locale)}</p>
                <p class="st-text">${entry.getDescription(locale)?replace(r'<[^>]*>', '', 'r')[0..*150]}...</p>
            </div>
            <div class="st-image">
                <@strasbourg.addImage fileEntryId=entry.imageId maxWidth=430 showLegende=false showCopyright=false isFigure=true />
            </div>

        </a>
    </div>
</li>