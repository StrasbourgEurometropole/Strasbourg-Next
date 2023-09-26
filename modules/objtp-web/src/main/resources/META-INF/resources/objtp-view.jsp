<%@ include file="/objtp-init.jsp" %>

<header class="st-small-header st-wrapper st-wrapper-small" role="banner">
	<h1 class="st-h1">${title}</h1>
	<liferay-portlet:runtime
			portletName="com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet"
			instanceId="breadcrumb-generic" />
</header>

<c:set var="numeroLabel"><liferay-ui:message key="objtp-numero" /></c:set>
<c:set var="dateLabel"><liferay-ui:message key="objtp-date" /></c:set>

<div class="seu-result-filter">
	<span><liferay-ui:message key="results-per-page" /></span>
	<select name="filter" id="" class="toCustomSelect silencedSelect" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
		<c:forEach var="delta" items="${[10, 20, 50, 100]}">
			<c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}" />
			<option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
		</c:forEach>
	</select>
</div>

<aui:form method="post" name="fm">
		<liferay-ui:search-container id="entriesSearchContainer"
									 searchContainer="${dc.searchContainer}">
	<div class="st-listing-cards st-wrapper st-wrapper-small">
		<ul class="st-cards-wrapper st--has-cards-vertical st-basic-grid st-col-3@mobile st-col-4@t-small">
			<c:forEach items="${dc.paginatedResults}" var="object">
				<c:if test="${not empty object.imageUrl}">
					<fmt:formatDate value="${object.date}"
									var="formattedDate" type="date" pattern="dd/MM/yyyy" />
					<c:set var="legend" value="${title} : ${numeroLabel} ${object.number} ${dateLabel} ${formattedDate}"/>


					<li>
						<div class="st-card-container">
							<a href="#" class="st-card st-card-lost-and-found ">
								<div class="st-caption">
									<p class="st-title-card">${numeroLabel} ${object.number}</p>
									<p class="st-date">${dateLabel} <span>${formattedDate}</span></p>
								</div>
								<div class="st-image">
									<figure class="st-figure st-fit-cover" role="group">
										<picture>
											<img class="objtp-picture" src="${object.imageUrl}?imagePreview=1" title="${legend}"></img>
										</picture>
									</figure>
								</div>
							</a>
						</div>
					</li>
				</c:if>
			</c:forEach>

		</ul>
	</div>

			<!-- Pagination -->
			<c:if test="${dc.pager.lastPage > 1}">
				<nav class="st-wrapper st-wrapper-small st-pagination" role="navigation">
					<div class="st-container">
						<a rel="prev" class="st-nav-links st-prev st-btn-arrow st--prev" data-action="prev" title="<liferay-ui:message key="go-to-previous-page" />"
						   href="${dc.getURLForPage(dc.pager.currentPage - 1)}">
           <span class="st-sr-only">
                Précédent
           </span>
						</a>

						<!-- Note pour le cablage changer dynamiquement les numéros de page dans les aria-label. Aussi, l'aria-label pour l'élément actif doit être différent par rapport aux autres -->
						<div class="st-pagination-number">
							<c:forEach var="page" items="${dc.pager.pages}">
								<c:choose>
									<c:when test="${page.isALink() and not (page.index eq dc.pager.currentPage)}">
										<!-- Lien vers page -->
										<a data-page="${page.index}" href="${dc.getURLForPage(page.index)}" class="st-pagination-link" role="button" aria-label="Aller à ${page.label}"
										   aria-current="false">${page.label}</a>
									</c:when>
									<c:when test="${page.isALink() and (page.index eq dc.pager.currentPage)}">
										<!-- Page en cours -->
										<a href="#" class="st-pagination-link st-is-active" role="button" aria-label="Page courante ${page.label}"
										   aria-current="true">${page.label}</a>
									</c:when>
									<c:otherwise>
										<!-- Texte -->
										<span class="st-dots">...</span>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>

						<a rel="next" class="st-nav-links st-next st-btn-arrow st--next" title="<liferay-ui:message key="go-to-next-page" />"
						   data-action="next" href="${dc.getURLForPage(dc.pager.currentPage + 1)}">
              <span class="st-sr-only">
                Suivant
              </span>
						</a>
					</div>
				</nav>
			</c:if>
		</liferay-ui:search-container>
	</aui:form>

<%@ include file="/objtp-filter.jsp" %>