<%@ include file="/search-activity-init.jsp"%>

<liferay-portlet:renderURL var="searchURL" />
<%@ include file="/templates/overlay/activity-overlay.jsp"%>
<%@ include file="/templates/form/strasbourg-form.jsp"%>

<%--  form--%>
<header class="st-small-header st-wrapper st-wrapper-small" role="banner">
	<h1 class="st-h1">${dc.getPortletTitle('eu.strasbourg.search-aquatique')}</h1>
	<liferay-portlet:runtime
			portletName="com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet"
			instanceId="breadcrumb-generic" />
</header>

<!-- Nombre de rÃ©sultats et items par page -->
<div class="seu-view-results">
	<div class="seu-result-count">${dc.searchContainer.total}
		<c:choose>
			<c:when test="${dc.searchContainer.total gt 1}">
				<liferay-ui:message key="results" />
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="result" />
			</c:otherwise>
		</c:choose>
	</div>
	<div class="seu-filler"></div>
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


<!-- Liste des rÃ©sultats -->
<aui:form method="post" name="fm">
	<!-- RÃ©sultats -->
	<liferay-ui:search-container id="entriesSearchContainer"
								 searchContainer="${dc.searchContainer}">
<div class="st-listing-cards st-wrapper st-wrapper-small">
	<ul class="st-cards-wrapper st--has-cards-vertical st-basic-grid st-col-3@mobile st-col-4@t-small">
		<c:forEach var="activityEntry" items="${dc.paginatedResults}">
			<liferay-ddm:template-renderer
					className="<%= Activity.class.getName() %>"
					contextObjects="${dc.getTemplateContextObjects(activityEntry.key)}"
					displayStyle="${displayStyle}"
					displayStyleGroupId="${displayStyleGroupId}"
					entries="${templateEntries}">
				Veuillez sÃ©lectionner un template dans la configuration du portlet.
			</liferay-ddm:template-renderer>
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


<liferay-util:html-bottom>
	<script	src="/o/activitysearchweb/js/search-activity-main.js"></script>
</liferay-util:html-bottom>
