<!-- Rubrique -->
<#setting locale = locale />

<section id="rubric" class="margin-bottom">
    <div  class="content container">
        <#if entries?has_content>
            <div class="list">
                <#list entries as currentPage>
                    <#if !currentPage.hidden>
                        <#assign hasImage = currentPage.expandoBridge.getAttribute('image')?has_content />
                        <#if hasImage>
                            <#assign backgroundImage = currentPage.expandoBridge.getAttribute('image') />
                            <a href="${strasbourg.homeURL()}${currentPage.friendlyURL?remove_beginning('/')}" aria-label="${currentPage.getName(locale)?html}" title="${currentPage.getName(locale)?html}" class="rubric-thumbnail" style="background-image: url(${backgroundImage});">
                        <#else>
                            <a href="${strasbourg.homeURL()}${currentPage.friendlyURL?remove_beginning('/')}" aria-label="${currentPage.getName(locale)?html}" title="${currentPage.getName(locale)?html}" class="rubric-thumbnail">
                        </#if>
                            <div class="info">
                                <div class="title">
                                    <span>${currentPage.getName(locale)}</span>
                                </div>
                            </div>
                        </a>
                    </#if>
                </#list>
            </div>
        </#if>
    </div>
</section>