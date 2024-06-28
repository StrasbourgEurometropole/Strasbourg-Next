<%@ include file="/search-asset-init.jsp" %>

<liferay-portlet:actionURL varImpl="searchActionURL" />
<div class="couleur-ville">
    <div class="pro-search-listing" id="go-to-top">
        <div  class="search-header-wrapper">
            <div class="container">
                <div class="row">
                    <div class="search-header col-md-8">
                        <div id="breadcrumb">
		            <span>
		                <span><a href="${dc.getHomeURL()}"><liferay-ui:message key="eu.breadcrumb-home" /></a>
		                    <span class="breadcrumb_last"><liferay-ui:message key="eu.breadcrumb-saisineObservatoire" /></span>
		                </span>
		            </span>
                        </div>
                        <div class="pro-wrapper-sort">
                            <c:choose>
                                <c:when test='${isUserloggedIn && hasUserPactSign && !isUserBanned}'>
                                    <a id="buttonDeposer" href="" class="pro-btn-yellow" data-toggle="modal" data-target="#modalSaisineObservatoire">
                                        <liferay-ui:message key="file-saisineObservatoire" />
                                    </a>
                                </c:when>
                                <c:when test='${!hasUserPactSign && !isUserBanned}'>
                                    <a id="buttonDeposer" href="" class="pro-btn-yellow" name="#Pact-sign">
                                        <liferay-ui:message key="file-saisineObservatoire" />
                                    </a>
                                </c:when>
                                <c:when test='${isUserBanned}'>
                                    <a id="buttonDeposer" href="" class="pro-btn-yellow" name="#IsBanned">
                                        <liferay-ui:message key="file-saisineObservatoire" />
                                    </a>
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 pro-bloc-listing-participation">
                    <!-- Affiner votre recherche - Tablette portrait + Mobile -->
                    <div class="pro-inside-affine-search"></div>

                    <div class="row pro-wrapper-listing-participation">

                        <div class="col-xs-12">

                            <!-- Resultats -->
                            <aui:form method="post" name="fm">
                                <div class="pro-listing-saisineObservatoire">
                                </div>
                            </aui:form>

                        </div>
                    </div>
                </div>

                <div class="col-lg-4 pro-wrapper-aside">
                    <div class="pro-bloc-facette pro-bloc-facette-participation">
                        <span class="pro-affiner"><liferay-ui:message key="eu.refine-research" /> <span class="icon-ico-chevron-down"></span></span>

                        <!-- Formulaire -->
                        <aui:form action="${searchActionURL}" method="get" name="fm"
                                  id="search-asset-form">
                            <liferay-portlet:renderURLParams varImpl="searchActionURL" />
                            <liferay-util:include page="/forms/placit-saisinesObservatoire-form.jsp"
                                                  servletContext="<%=application%>" />
                        </aui:form>
                    </div>

                    <div class="pro-widget-participation">
                        <h4><liferay-ui:message key="eu.most.commented-fe" /></h4>
                        <c:forEach var="saisineObservatoireMost" items="${saisineObservatoireListMostCommented}">
                            <a href="${dc.getHomeURL()}detail-saisine-observatoire/-/entity/id/${saisineObservatoireMost.saisineObservatoireId}" title="Lien vers Titre de la saisine">
                                <div class="pro-meta">
                                    <span><span class="icon-ico-location"></span>${saisineObservatoireMost.getDistrictLabel(locale)}</span>

                                    <span>${saisineObservatoireMost.getThematicLabel(locale)}</span>
                                </div>
                                <h3>${saisineObservatoireMost.title}</h3>

                                <div class="pro-meta-footer">
                                    <span class="pro-comments pro-comments-right"><strong>${saisineObservatoireMost.nbApprovedComments} </strong></span>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

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
</div>