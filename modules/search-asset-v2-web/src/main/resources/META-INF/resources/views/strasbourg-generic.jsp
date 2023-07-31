<%@ include file="/search-asset-init.jsp" %>

<liferay-portlet:actionURL varImpl="searchActionURL" />
<main class="st-listing st--listing-cards-horizontales" role="main" tabindex="-1">
	<!-- Formulaire -->
	<aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form" cssClass="seu-view-filters">
		<liferay-portlet:renderURLParams varImpl="searchActionURL" />
		<liferay-util:include page="/forms/strasbourg-generic-form.jsp" servletContext="<%=application %>" />
	</aui:form>
	<header class="st-small-header st-wrapper st-wrapper-small" role="banner">
		<c:if test="${not empty dc.getPortletTitle('')}">
			<h1 class="st-h1">${dc.getPortletTitle('')}</h1>
		</c:if>

	</header>
			<aui:form method="post" name="fm">
				<!-- Résultats -->
	<div class="listing st-wrapper st-wrapper-small">
		<div>
			<span><liferay-ui:message key="results-per-page" /></span>
			<select name="filter" id="" class="toCustomSelect" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
				<c:forEach var="delta" items="${[5, 10, 20, 50, 100]}">
					<c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}" />
					<option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
				</c:forEach>
			</select>
		</div>
		<div class="st-listing-two-col st-cards-horizontales js-listing-card-container"
			 data-loading="Chargement en cours" data-noresults="Aucun résultat trouvé pour votre recherche.">

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

		</div>
		<!-- Export -->
		<c:if test="${dc.displayExport}">
			<div class="btn-line">
				<a href="${dc.exportResourceURL}" title="<liferay-ui:message key="print" />" target="_blank">
					<button type="button" class="seu-btn-square--filled--second">
								<span class="seu-flexbox">
									<span class="seu-btn-text"><liferay-ui:message key="print" /></span>
									<span class="seu-btn-arrow"></span>
								</span>
					</button>
				</a>
			</div>
		</c:if>

		<!-- Pagination -->
		<c:if test="${dc.pager.lastPage > 1}">
			<ul class="seu-pagination unstyled">
				<!-- Page précédente -->
				<li class="seu-pagin-prev disabled seu-pagin-item">
					<c:if test="${not dc.pager.onFirstPage}">
						<a class="seu-btn-square seu-bordered seu-core" data-action="prev" title="<liferay-ui:message key="go-to-previous-page" />"
						   href="${dc.getURLForPage(dc.pager.currentPage - 1)}">
			                        <span class="seu-flexbox">
			                            <span class="seu-btn-text"><liferay-ui:message key="previous" /></span>
			                            <span class="seu-btn-arrow"></span>
			                        </span>
						</a>
					</c:if>
				</li>
				<c:forEach var="page" items="${dc.pager.pages}">
					<c:choose>
						<c:when test="${page.isALink() and not (page.index eq dc.pager.currentPage)}">
							<!-- Lien vers page -->
							<li class="seu-pagin-item">
								<a data-page="${page.index}" href="${dc.getURLForPage(page.index)}">
					                        <span class="seu-flexbox">
					                            <span class="seu-btn-text">${page.label}</span>
					                        </span>
								</a>
							</li>
						</c:when>
						<c:when test="${page.isALink() and (page.index eq dc.pager.currentPage)}">
							<!-- Page en cours -->
							<li class="seu-pagin-item seu-is-active">
				                        <span class="seu-flexbox">
				                            <span class="seu-btn-text">${page.label}</span>
				                        </span>
							</li>
						</c:when>
						<c:otherwise>
							<!-- Texte -->
							<li class="seu-pagin-item">
				                        <span class="seu-flexbox">
				                            <span class="seu-btn-text">${page.label}</span>
				                        </span>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<!-- Page suivante -->
				<li class="seu-pagin-next seu-pagin-item">
					<c:if test="${not dc.pager.onLastPage}">
						<a class="seu-btn-square seu-bordered seu-core" title="<liferay-ui:message key="go-to-next-page" />"
						   data-action="next" href="${dc.getURLForPage(dc.pager.currentPage + 1)}">
			                        <span class="seu-flexbox">
			                            <span class="seu-btn-text"><liferay-ui:message key="next" /></span>
			                            <span class="seu-btn-arrow"></span>
			                        </span>
						</a>
					</c:if>
				</li>
			</ul>
		</c:if>
	</div>
			</aui:form>

</main>