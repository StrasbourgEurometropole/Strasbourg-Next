<%@ include file="/objtp-init.jsp" %>

<header class="st-small-header st-wrapper st-wrapper-small">
	<h1 class="st-h1">${title}</h1>
	<liferay-portlet:runtime
			portletName="com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet"
			instanceId="breadcrumb-generic" />
</header>

<c:set var="numeroLabel"><liferay-ui:message key="objtp-numero" /></c:set>
<c:set var="dateLabel"><liferay-ui:message key="objtp-date" /></c:set>


<aui:form method="post" name="fm">
		<liferay-ui:search-container id="entriesSearchContainer"
									 searchContainer="${dc.searchContainer}">
	<div class="st-listing-cards st-wrapper st-wrapper-small">
		<div class="st-listing-results st-hide-until@t-portrait">
    <span class="st-results" role="status">
         ${dc.searchContainer.total} <liferay-ui:message key="results" />
    </span>

			<div class="st-results-filter">
				<label for="results-per-page"><liferay-ui:message key="results-per-page" /></label>
				<div class="st-results-select">
					<select id="results-per-page" name="results-per-page" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
						<c:forEach var="delta" items="${[5, 10, 20, 50, 100]}">
							<c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}" />
							<option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
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
				<nav class="st-wrapper st-wrapper-small st-pagination" role="navigation" aria-label="Pagination">
					<ul class="st-pagination__list">
						<li class="st-pagination__item st--prev">
							<a rel="prev" href="${dc.getURLForPage(dc.pager.currentPage - 1)}" class="st-btn-arrow st--prev" aria-disabled="${dc.pager.currentPage == 1 ? 'true' : 'false'}">
								<span class="st-sr-only"><liferay-ui:message key="eu.previous" /></span>
							</a>
						</li>


						<!-- Note pour le cablage changer dynamiquement les numéros de page dans les aria-label. Aussi, l'aria-label pour l'élément actif doit être différent par rapport aux autres -->
						<c:forEach var="page" items="${dc.pager.pages}">
							<c:choose>
								<c:when test="${page.isALink() and not (page.index eq dc.pager.currentPage)}">
									<!-- Lien vers page -->
									<li class="st-pagination__item">
										<a href="${dc.getURLForPage(page.index)}" class="st-pagination__link" aria-label="Page ${page.label}" aria-current="false">${page.label}</a>
									</li>

								</c:when>
								<c:when test="${page.isALink() and (page.index eq dc.pager.currentPage)}">
									<!-- Page en cours -->
									<li class="st-pagination__item">
										<a href="#" class="st-pagination__link st-is-active" aria-label="Page ${page.label}" aria-current="true">${page.label}</a>
									</li>
								</c:when>
								<c:otherwise>
									<!-- Texte -->
									<li class="st-pagination__item">
										<span class="st-pagination__dots">...</span>
									</li>

								</c:otherwise>
							</c:choose>
						</c:forEach>
						<li class="st-pagination__item st--next">
							<a href="${dc.getURLForPage(dc.pager.currentPage + 1)}" rel="next" class="st-btn-arrow st--next" aria-disabled="${dc.pager.currentPage == dc.pager.lastPage ? 'true' : 'false'}">
								<span class="st-sr-only"><liferay-ui:message key="eu.next" /></span>
							</a>
						</li>

					</ul>
				</nav>
			</c:if>
		</liferay-ui:search-container>
	</aui:form>

<%@ include file="/objtp-filter.jsp" %>