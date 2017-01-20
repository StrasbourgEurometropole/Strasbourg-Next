<!-- Entête de page - 50% -->
<#setting locale = locale />
<div class="page-header with-image alt-theme alt-theme-2">
    <div class="page-header-image">
        <img src="${layout.expandoBridge.getAttribute('image')}" />
        <#if (imageCredit?length > 0)>
            <div class="page-header-image-credit">
                ${imageCredit}
            </div>
        </#if>
    </div>
    <div class="page-header-info">
        <div class="page-header-title-and-share">
            <div class="page-header-title">
                <h1>${page.getName(locale)}</h1>
            </div>
            <div class="page-header-share">
                <span><@liferay_ui.message key="eu.share-page" /></span>
                <div class="page-header-share-buttons">
                    <a href="https://www.facebook.com/sharer.php?u=${currentURL}" target="_blank"><div class="facebook"></div></a>
                    <div class="twitter"></div>
                </div>
            </div>
        </div>
        <div class="page-header-description">
            ${page.getDescription(locale)}
        </div>
    </div>
</div>
