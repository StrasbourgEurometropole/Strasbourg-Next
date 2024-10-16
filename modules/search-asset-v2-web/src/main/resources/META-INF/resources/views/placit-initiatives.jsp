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
									<span class="breadcrumb_last"><liferay-ui:message key="eu.breadcrumb-initiative" /></span>
								</span>
							</span>
						</div>

						<div class="pro-wrapper-sort">
							<c:choose>
								<c:when test='${isUserloggedIn && hasUserPactSign && !isUserBanned}'>
									<a id="buttonSubmitInitiative" href="" class="pro-btn-yellow" data-toggle="modal" data-target="#modalSubmitInitiative">
										<liferay-ui:message key="submit-initiative" />
									</a>
								</c:when>
								<c:when test='${!hasUserPactSign && !isUserBanned}'>
									<a id="buttonSubmitInitiative" href="" class="pro-btn-yellow" name="#Pact-sign">
										<liferay-ui:message key="submit-initiative" />
									</a>
								</c:when>
								<c:when test='${isUserBanned}'>
									<a id="buttonSubmitInitiative" href="" class="pro-btn-yellow" name="#IsBanned">
										<liferay-ui:message key="submit-initiative" />
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

					<div class="row pro-wrapper-listing-general">
						<div class="col-xs-12">

							<!-- Resultats -->
							<aui:form method="post" name="fm">
								<div class="pro-listing-initiative"></div>
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
							<liferay-util:include page="/forms/placit-initiatives-form.jsp" servletContext="<%=application%>" />
						</aui:form>

					</div>

					<!-- Bloc : Les plus populaires -->
					<div class="pro-widget-participation">
						<h4><liferay-ui:message key="eu.most.popular" /></h4>
						<c:forEach var="initiativeAside" items="${initiativesMostLiked}">
							<a href="${dc.getHomeURL()}detail-atelier/-/entity/id/${initiativeAside.initiativeId}" title="Lien vers Titre de l'initiative">
								<div class="pro-meta">
									<c:set var="initiativeDistricts" value="${initiativeAside.getDistrictLabel(locale)}"/>
									<c:set var="initiativeThematics" value="${initiativeAside.getThematicsLabel(locale)}"/>
									<c:set var="initiativeProject" value="${initiativeAside.getProjectName()}"/>

									<c:if test = "${not empty initiativeDistricts}">
										<span class="prefix-location">${initiativeDistricts}</span>
									</c:if>
									<c:if test = "${not empty initiativeThematics}">
										<span>${initiativeThematics}</span>
									</c:if>
									<c:if test = "${not empty initiativeProject}">
										<span>${initiativeProject}</span>
									</c:if>
								</div>
								<h3>${initiativeAside.title}</h3>

								<div class="pro-meta-footer">
									<span class="pro-citoyen-initiative"><strong>${initiativeAside.getNbHelps()} <liferay-ui:message key="eu.support.initiative" /></span>
									<div class="pro-avis">
										<span class="pro-like"><span class="icon-ico-like"></span> ${initiativeAside.getNbLikes()}</span>
										<span class="pro-dislike"><span class="icon-ico-like"></span> ${initiativeAside.getNbDislikes()}</span>
									</div>
								</div>
							</a>
						</c:forEach>
					</div>

					<!-- Bloc : Les plus commentes -->
					<div class="pro-widget-participation">
						<h4><liferay-ui:message key="eu.most.commented" /></h4>
						<c:forEach var="initiativeAside" items="${initiativesMostCommented}">
							<a href="${dc.getHomeURL()}detail-atelier/-/entity/id/${initiativeAside.initiativeId}" title="Lien vers Titre de l'initiative">
								<div class="pro-meta">
									<c:set var="initiativeDistricts" value="${initiativeAside.getDistrictLabel(locale)}"/>
									<c:set var="initiativeThematics" value="${initiativeAside.getThematicsLabel(locale)}"/>
									<c:set var="initiativeProject" value="${initiativeAside.getProjectName()}"/>

									<c:if test = "${not empty initiativeDistricts}">
										<span>${initiativeDistricts}</span>
									</c:if>
									<c:if test = "${not empty initiativeThematics}">
										<span>${initiativeThematics}</span>
									</c:if>
									<c:if test = "${not empty initiativeProject}">
										<span>${initiativeProject}</span>
									</c:if>
								</div>
								<h3>${initiativeAside.title}</h3>

								<div class="pro-meta-footer">
									<span class="pro-citoyen-initiative"><strong>${initiativeAside.getNbHelps()} <liferay-ui:message key="eu.support.initiative" /></span>
									<div class="pro-avis">
										<span class="pro-like"><span class="icon-ico-like"></span> ${initiativeAside.getNbLikes()}</span>
										<span class="pro-dislike"><span class="icon-ico-like"></span> ${initiativeAside.getNbDislikes()}</span>
									</div>
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
					<div class="col-sm-6 col-xs-8 pull-right"></div>
				</div>
			</div>
		</div>
	</div>
</div>