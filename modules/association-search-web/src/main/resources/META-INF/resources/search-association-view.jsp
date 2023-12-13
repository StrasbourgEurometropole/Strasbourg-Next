<%@ include file="/search-association-init.jsp" %>


<liferay-portlet:actionURL varImpl="searchActionURL" />
<!-- Filtres -->
<%@ include file="/search-association-search-form.jsp"  %>

<header class="st-small-header st-wrapper st-wrapper-small" >
	<h1 class="st-h1">	<c:if test="${not empty dc.getPortletTitle('')}">
		<h1 class="st-h1">${dc.getPortletTitle('')}</h1>
	</c:if></h1>
	<liferay-portlet:runtime
			portletName="com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet"
			instanceId="breadcrumb-generic" />
</header>

<div class="st-listing-introduction st-wrapper st-wrapper-small st-text-styles">
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer a erat sodales, auctor neque non,
		varius purus. Morbi tempor finibus magna, id dignissim quam. Aliquam elementum, felis vitae sagittis
		iaculis, est eros euismod urna, sit amet consectetur odio orci vitae nibh. Mauris at efficitur sem,
		eget iaculis purus. Maecenas et lacinia diam.</p>
</div>




		<aui:form method="post" name="fm">
			<!-- RÃ©sultats -->
			<liferay-ui:search-container id="entriesSearchContainer"
						searchContainer="${dc.searchContainer}">
				<div class="st-listing-cards st-wrapper st-wrapper-small">
					<!-- Nombre de rÃ©sultats et items par page -->
					<div class="seu-view-results">
						<div class="seu-result-filter">
							<span><liferay-ui:message key="results-per-page" /></span>
							<select name="filter" id="" class="toCustomSelect" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
								<c:forEach var="delta" items="${[5, 10, 20, 50, 100]}">
									<c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}" />
									<option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				<ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">

		        	<liferay-ui:search-container-results results="${dc.entries}" />
		        	<liferay-ui:search-container-row
						className="com.liferay.asset.kernel.model.AssetEntry"
						modelVar="entry" keyProperty="entryId" rowIdProperty="entryId">
							<c:set var="className" value="${entry.className}" />
                            <liferay-ddm:template-renderer
                                className="${className}"
                                contextObjects="${dc.getTemplateContextObjects(entry)}"
                                displayStyle="${dc.displayStyle}"
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
	</div>
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

			</liferay-ui:search-container>
		</aui:form>

<liferay-util:body-top>
    <aui:script>
		var homeURL = '${homeURL}';
		var delta = ${dc.delta};
    </aui:script>
</liferay-util:body-top>

<liferay-util:html-bottom>
	<script	src="/o/associationsearchweb/js/search-association-main.js"></script>
</liferay-util:html-bottom>