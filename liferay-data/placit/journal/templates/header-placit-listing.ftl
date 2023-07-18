<header class="pro-header-small pro-bloc-texte-header">
    <div class="container caption">
        <div class="row">
            <div class="col-lg-8">
                <h1>${title.getData()}</h1>
                <#if description.getData()?? >
                    <div class="pro-description">
                        <p>${description.getData()}</p>
                    </div>
                </#if>
            </div>
        </div>

    </div>
</header>