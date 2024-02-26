<%@ include file="/search-asset-init.jsp" %>

<liferay-portlet:actionURL varImpl="searchActionURL" />
	<!-- Formulaire -->
	<aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form" cssClass="seu-view-filters">
		<liferay-portlet:renderURLParams varImpl="searchActionURL" />
		<liferay-util:include page="/forms/strasbourg-generic-form.jsp" servletContext="<%=application %>" />
	</aui:form>
	<header class="st-small-header st-wrapper st-wrapper-small">
		<h1 class="st-h1">${dc.getLayoutTitle()}</h1>
		<liferay-portlet:runtime
				portletName="com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet"
				instanceId="breadcrumb-generic" />

	</header>
			<aui:form method="post" name="fm">
				<!-- Résultats -->
	<div class="st-listing st--listing-cards-horizontales listing st-wrapper st-wrapper-small">
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
		<div class="st-listing-cards st-wrapper st-wrapper-small"
			 data-loading="Chargement en cours" data-noresults="Aucun résultat trouvé pour votre recherche.">
			<ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">

				<liferay-ui:search-container id="entriesSearchContainer"
											 searchContainer="${dc.searchContainer}">

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
						<c:if test="${!entry.className.equals('Procedure')}">
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
						</c:if>
						<c:if test="${entry.className.equals('Procedure')}" >
							<%-- Les procédure n'ayant pas de template, la vignette est crée directement ici --%>
							<div class="wi-search-result wi-search-generic wi-search-procedure">
								<div class="seu-result-left">
									<div class="seu-result-icon"></div>
								</div>
								<div class="seu-result-right">
									<a class="seu-result-content" href="${entry.url}">
										<h2 class="seu-result-title">${entry.title}</h2>
										<div class="seu-result-catcher">
											<c:set var="description" value="${entry.description.replaceAll(\"<[^>]*>\", \"\")}" />
											<c:if test="${description.length() > 100}">
												${description.substring(0,100)}...
											</c:if>
											<c:if test="${description.length() <= 100}">
												${description}
											</c:if>
										</div>
									</a>
								</div>
							</div>
						</c:if>
					</liferay-ui:search-container-row>



				</liferay-ui:search-container>
			</ul>

		</div>
		<!-- Export -->
		<c:if test="${dc.displayExport}">
			<div class="btn-line st--has-margin-top">
				<a href="${dc.exportResourceURL}" title="<liferay-ui:message key="print" />" target="_blank">
					<button type="button" class="st-btn"><liferay-ui:message key="print" /></button>
				</a>
			</div>
		</c:if>

		<!-- Pagination -->
		<c:if test="${dc.pager.lastPage > 1}">
			<nav class="st-wrapper st-wrapper-small st-pagination" role="navigation" aria-label="Pagination">
				<ul class="st-pagination__list">
					<li class="st-pagination__item st--prev">
						<a rel="prev" class="st-btn-arrow st--prev" aria-disabled="${dc.pager.currentPage == 0 ? 'true' : 'false'}">
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
	</div>
			</aui:form>

<liferay-util:include page="/includes/overlay-official.jsp" servletContext="<%=application %>" />