<#setting locale = locale />

<#assign date = dateUtil.parseDate("yyyy-MM-dd", date.getData(), locale)/>  

<style>
.portlet-body>div>div.h2 {
    display : none;

}

.has-control-menu #ops-wrapper main.ops-page-rh, .ops-page-rh {
    padding-top : 100px
}
</style>

<main class="ops-page-rh">

        <div class="ops-wrapper-content-rh ops-content-wrapper">

            <!-- DETAIL OFFRE RH -->
            <header>
                <div class="ops-meta-card-article">
                    <div class="ops-cats">
                        <span class="ops-cat">${postName.getData()}</span>
                    </div>
                    <span class="ops-date-article">Date du concours : le ${date?string("dd.MM.yyyy")}</time></span>
                </div>
                <h1>${title.getData()}</h1>
            </header>


            <!-- SECTION PRINCIPAL OFFRE RH -->
            <section>
                ${postContent.getData()}
            </section>

        </div>

    </main>