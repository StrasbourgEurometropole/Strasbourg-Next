<!-- BLOC IMAGE OU VIDEO A LA UNE POUR PACIT  -->
<header class="pro-header-small pro-bloc-texte-header">
    <div class="container caption">
        <div class="row">
            <div class="col-sm-8">
                <h1>
                    ${titleLine1.getData()}
                    <#if titleLine2.getData() != "" >
                        <br>
                        ${titleLine2.getData()}
                    </#if>
                </h1>
                <#if description.getData()?? >
                    <div class="pro-description">
                        <p>${description.getData()}</p>
                    </div>
                </#if>
            </div>
        </div>

    </div>
</header>