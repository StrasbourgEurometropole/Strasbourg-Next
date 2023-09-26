<%@ include file="/search-asset-init.jsp" %>

<liferay-portlet:actionURL varImpl="searchActionURL" />

<!-- Formulaire -->
<aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form" cssClass="seu-view-filters">
	<liferay-portlet:renderURLParams varImpl="searchActionURL" />
	<liferay-util:include page="/forms/strasbourg-agenda-form.jsp" servletContext="<%=application %>" />
</aui:form>

<header class="st-small-header st--two-columns st-basic-grid st-col-2@t-landscape st-wrapper st-wrapper-small" role="banner">
	<div class="col-left">
		<h1 class="st-h1"><liferay-ui:message key="eu.agenda" /></h1>
		<liferay-portlet:runtime
				portletName="com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet"
				instanceId="breadcrumb-generic" />
	</div>

	<div class="col-right">
		<div class="st-filters-agenda">

			<div class="st-filter-agenda">
				<input type="radio" name="filters-agenda" value="filter-aujourdhui" id="today">
				<label for="today"><liferay-ui:message key="today" /> </label>
			</div>
			<div class="st-filter-agenda">
				<input type="radio" name="filters-agenda" value="filter-demain" id="tomorrow">
				<label for="tomorrow"><liferay-ui:message key="tomorrow" /></label>
			</div>
			<div class="st-filter-agenda">
				<input type="radio" name="filters-agenda" value="filter-weekend" id="week-end">
				<label for="week-end"><liferay-ui:message key="weekend" /></label>
			</div>

		</div>
	</div>
</header>

<div class="st-listing-cards st--listing-agenda st-wrapper st-wrapper-small">
		<div class="seu-result-filter">
			<span><liferay-ui:message key="results-per-page" /></span>
			<select name="filter" id="" class="toCustomSelect" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
				<c:forEach var="delta" items="${[5, 10, 20, 50, 100]}">
					<c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}" />
					<option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
				</c:forEach>
			</select>
		</div>

	<aui:form method="post" name="fm">
		<!-- Résultats -->
		<liferay-ui:search-container id="entriesSearchContainer"
									 searchContainer="${dc.searchContainer}">
			<ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">

				<liferay-ui:search-container-results results="${dc.entries}" />
				<liferay-ui:search-container-row
						className="com.liferay.asset.kernel.model.AssetEntry"
						modelVar="entry" keyProperty="entryId" rowIdProperty="entryId">
					<c:set var="className" value="${entry.className}" />
					<c:choose>
						<c:when test="${fn:contains(className, 'JournalArticle')}">
							<c:set var="className" value="com.liferay.asset.kernel.model.AssetEntry" />
						</c:when>
						<c:when test="${fn:contains(className, 'DLFileEntry')}">
							<c:set var="className" value="com.liferay.portal.kernel.repository.model.FileEntry" />
						</c:when>
					</c:choose>
					<liferay-ddm:template-renderer
							className="${className}"
							contextObjects="${dc.getTemplateContextObjects(entry)}"
							displayStyle="${dc.templatesMap[entry.className]}"
							displayStyleGroupId="${themeDisplay.scopeGroupId}"
							entries="${dc.templateEntries }"
					>
						<liferay-asset:asset-display
								assetEntry="${entry}"
								assetRenderer="${entry.assetRenderer}"
								assetRendererFactory="${entry.assetRendererFactory}"
								template="abstract"
						/>
					</liferay-ddm:template-renderer>
				</liferay-ui:search-container-row>
			</ul>

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

</div>

<liferay-util:include page="/includes/overlay-event.jsp" servletContext="<%=application %>" />