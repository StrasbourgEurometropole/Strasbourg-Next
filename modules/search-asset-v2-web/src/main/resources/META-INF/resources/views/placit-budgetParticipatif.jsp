<%@ include file="/search-asset-init.jsp" %>

<liferay-portlet:actionURL varImpl="searchActionURL" />

<div class="couleur-ville">
    <div class="pro-search-listing couleur-ville" id="go-to-top">
        <div  class="search-header-wrapper">
            <div class="container">
                <div class="row">
                    <div class="search-header col-md-8">
                        <div id="breadcrumb">
                            <span>
                                <span><a href="${dc.getHomeURL()}"><liferay-ui:message key="eu.breadcrumb-home" /></a>
                                    <span class="breadcrumb_last"><liferay-ui:message key="eu.breadcrumb-budgetParticipatif" /></span>
                                </span>
                            </span>
                        </div>

                         <div class="pro-wrapper-sort">
                            <c:choose>
                                <c:when test='${isUserloggedIn}'>
                                    <a id="buttonDeposer" href="" class="pro-btn-yellow deposit-button" data-toggle="modal" data-target="#modalBudget">
                                        <liferay-ui:message key="file-budget" />
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a id="buttonDeposer" href="" class="pro-btn-yellow deposit-button" data-toggle="modal" data-target="#myModal">
                                        <liferay-ui:message key="file-budget" />
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 pro-bloc-listing-participation">

                    <div class="pro-inside-affine-search"></div>

                    <div class="row pro-wrapper-listing-participation">
                        <div class="col-xs-12">

                            <!-- Resultats -->
                            <aui:form method="post" name="fm">
                                <div class="pro-listing-budget"></div>
                            </aui:form>

                        </div>
                    </div>

                </div>

                <!-- Blocs lateraux -->
                <div class="col-lg-4 pro-wrapper-aside">

                    <!-- Bloc : formulaire -->
                    <div class="pro-bloc-facette pro-bloc-facette-participation">
                        <span class="pro-affiner"><liferay-ui:message key="eu.refine-research" /> <span class="icon-ico-chevron-down"></span></span>

                        <!-- Formulaire -->
                        <aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form">
                            <liferay-portlet:renderURLParams varImpl="searchActionURL" />
                            <liferay-util:include page="/forms/placit-budgetParticipatif-form.jsp" servletContext="<%=application%>" />
                        </aui:form>

                    </div>

                    <!-- Bloc : Les plus populaires -->
                    <div class="pro-widget-participation">
                        <h4><liferay-ui:message key="eu.most.popular" /></h4>
                        <c:forEach var="bpAside" items="${budgetsMostSupported}">
                            <a href="${dc.getHomeURL()}detail-budget-participatif/-/entity/id/${bpAside.budgetParticipatifId}" title="Lien vers le detail du budget">
                                <div class="pro-meta">
                                    <span>${bpAside.getDistrictLabel(locale)}</span>
                                    <span>${bpAside.getThematicsLabel(locale)}</span>
                                </div>
                                <h3>${bpAside.title}</h3>

                                <div class="pro-meta-footer">
                                    <span class="pro-comments"><strong>${bpAside.getNbApprovedComments()}</strong>Commentaire(s)</span>
                                </div>
                            </a>
                        </c:forEach>
                    </div>

                    <!-- Bloc : Les plus commentes -->
                    <div class="pro-widget-participation">
                        <h4><liferay-ui:message key="eu.most.commented" /></h4>
                        <c:forEach var="bpAside" items="${budgetsMostCommented}">
                            <a href="${dc.getHomeURL()}detail-budget-participatif/-/entity/id/${bpAside.budgetParticipatifId}" title="Lien vers le detail du budget">
                                <div class="pro-meta">
                                    <span>${bpAside.getDistrictLabel(locale)}</span>
                                    <span>${bpAside.getThematicsLabel(locale)}</span>
                                </div>
                                <h3>${bpAside.title}</h3>

                                <div class="pro-meta-footer">
                                    <span class="pro-comments"><strong>${bpAside.getNbApprovedComments()}</strong>Commentaire(s)</span>
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