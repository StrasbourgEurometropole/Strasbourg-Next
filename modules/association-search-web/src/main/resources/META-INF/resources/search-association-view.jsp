<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/site-navigation" %>
<%@ include file="/search-association-init.jsp" %>


<liferay-portlet:actionURL varImpl="searchActionURL" />

<header class="st-small-header st-wrapper st-wrapper-small" role="banner">
	<h1 class="st-h1">	<c:if test="${not empty dc.getPortletTitle('')}">
		<h1 class="st-h1">${dc.getPortletTitle('')}</h1>
	</c:if></h1>
	<liferay-ui:breadcrumb />
</header>

<div class="st-listing-introduction st-wrapper st-wrapper-small st-text-styles">
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer a erat sodales, auctor neque non,
		varius purus. Morbi tempor finibus magna, id dignissim quam. Aliquam elementum, felis vitae sagittis
		iaculis, est eros euismod urna, sit amet consectetur odio orci vitae nibh. Mauris at efficitur sem,
		eget iaculis purus. Maecenas et lacinia diam.</p>
</div>
<div class="st-listing-cards st-wrapper st-wrapper-small">
	<ul class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">
		<li>
			<div class="st-card-container">
				<a href="/templates/pages/fiches/fiche-association.php"
				   class="st-card st--card-horizontal ">
					<div class="st-caption">
						<p class="st-title-card">ASPTT Strasbourg</p>
						<p class="st-surtitre-cat">ARTS PLASTIQUES & VISUELS, Danses</p>
						<p class="st-location">Cronenbourg Nord, Cronenbourg Sud, Koenigshoffen</p>
					</div>

					<div class="st-image">

						<figure class="st-figure st-fit-cover" role="group">
							<picture>
								<img alt="" src="/assets/images/medias/card-asso-1.png"
									 srcset="/assets/images/medias/card-asso-1.png 1x, /assets/images/medias/card-asso-1@2x.png 2x">
							</picture>
						</figure>



					</div>

				</a>


			</div>
		</li>

	</ul>
</div>



<main class="seu-container">
	<div class="seu-view-activity">
		<!-- Filtres -->
		<%@ include file="/search-association-search-form.jsp"  %>

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

		<aui:form method="post" name="fm">
			<!-- RÃ©sultats -->
			<liferay-ui:search-container id="entriesSearchContainer"
						searchContainer="${dc.searchContainer}">
				<div class="st-listing-cards st-wrapper st-wrapper-small">
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
											<a href="#" class="st-pagination-link active" role="button" aria-label="Page courante ${page.label}"
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
</main>

<style>
	.seu-view-filters .seu-filter-line .widget.otherVocabularies:last-child{
        width: calc(50% - 10px);
    }
</style>

<script>
	$(document).ready(function() {
        if($("#seu-grid--list01 li").length > 0) {
            $('html,body').animate({scrollTop: $(".seu-view-results").offset().top - (($('.seu-nav-bottom #seu-main-menu').length > 0)?115:55)});
        }
	});

</script>

<liferay-util:body-top>
    <aui:script>
		var homeURL = '${homeURL}';
		var delta = ${dc.delta};
    </aui:script>
</liferay-util:body-top>

<liferay-util:html-bottom>
	<script	src="/o/associationsearchweb/js/search-association-main.js"></script>
</liferay-util:html-bottom>