<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="eu.strasbourg.service.agenda.service.EventLocalServiceUtil" %>
<%@ page import="eu.strasbourg.service.agenda.model.EventPeriod" %>
<%@ page import="eu.strasbourg.service.agenda.model.Event" %>
<%@ page import="java.util.*" %>
<%@ page import="eu.strasbourg.portlet.search_asset_v2.context.SearchAssetDisplayContext" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/search-asset-init.jsp" %>
<%@ page isELIgnored="false" %>

<liferay-portlet:actionURL varImpl="searchActionURL" />

<!-- Formulaire -->
<aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form" cssClass="seu-view-filters">
	<liferay-portlet:renderURLParams varImpl="searchActionURL" />
	<liferay-util:include page="/forms/strasbourg-agenda-form.jsp" servletContext="<%=application %>" />
</aui:form>

<header class="st-small-header st--two-columns st-basic-grid st-col-2@t-landscape st-wrapper st-wrapper-small">
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

</div>

<liferay-util:include page="/includes/overlay-event.jsp" servletContext="<%=application %>" />