<%@ include file="/search-asset-init.jsp"%>
<liferay-portlet:actionURL varImpl="searchActionURL" />
<section id="news-listing" class="pro-search-news">
    <div class="pro-search-listing" id="go-to-top">
        <div class="pro-search-heading">
            <div class="container">
                <div class="pro-search-title">
                    <h1>Actualités</h1>
                </div>
            </div>
            <!-- File d'ariane -->
            <div class="pro-wrapper-top-listing">
                <div class="container">
                    <div id="breadcrumb">
                <span>
                    <span>
                        <a href="${dc.getHomeURL()}"><liferay-ui:message key="eu.breadcrumb-home" /></a>
                        <span class="breadcrumb_last"><liferay-ui:message key="eu.breadcrumb-news" /></span>
                    </span>
                </span>
                    </div>

                </div>
            </div>
        </div>
        <div class="container">
            <div class="pro-wrapper-sort">
                <!-- Formulaire de recherche -->
                <aui:form action="${searchActionURL}" method="get" name="fm"
                          id="search-asset-form">
                    <liferay-portlet:renderURLParams varImpl="searchActionURL" />
                    <liferay-util:include page="/forms/placit-news-form.jsp"
                                          servletContext="<%=application%>" />
                </aui:form>
            </div>
        </div>


        <!-- Listing -->

        <aui:form method="post" name="fm">
            <section class="container pro-listing pro-listing-news" data-egalize=" > *" data-row="true">
            </section>
        </aui:form>

        <!-- Pagination -->
        <div class="pro-pagination">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-4 pull-left">
                        <p class="hidden-xs"></p>
                    </div>

                    <!-- Pagination : liens de navigation -->
                    <div class="col-sm-6 col-xs-8 pull-right">
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<style>
	.comment-portlet {
	    display: none !important;
	}
</style>