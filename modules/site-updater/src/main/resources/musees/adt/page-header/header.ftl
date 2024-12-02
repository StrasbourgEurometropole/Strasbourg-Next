<#setting locale = locale />

<section id="header" class="margin-top margin-bottom">
    <h1>${layout.getTitle(locale)}</h1>
    <#if page.getDescription(locale)?has_content>
        <div class="chapo">${page.getDescription(locale)}</div>
    </#if>
</section>