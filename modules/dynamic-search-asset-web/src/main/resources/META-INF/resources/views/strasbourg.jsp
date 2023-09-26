<%@ include file="/dynamic-search-asset-init.jsp" %>

<portlet:resourceURL id="searchSubmit" var="searchSubmitURL">
</portlet:resourceURL>
<c:if test="${themeDisplay.isSignedIn()}" >
<clay:alert message="Overlay de recherche est present sur cette page"
displayType="secondary"
title="Overlay" />
</c:if>
<div id="st-overlay-search" class="st-overlay st-overlay-search st--from-top" role="dialog" aria-modal="true" tabindex="0" aria-label="Fenêtre modale contenante le moteur de recherche">
    <button class="st-btn-close" data-overlay-close="st-overlay-search" aria-label="Fermer la modale"></button>

    <form action="#" class="st-overlay__inner">
        <div class="st-overlay__header">

            <div class="st-overlay__header-row1 st-wrapper">
                <div class="st-input-search-wrapper">
                    <input id="recherche-input" class="st-input-search" type="search" placeholder="Votre recherche" autofocus>
                </div>
                <button class="st-btn-menu" data-overlay-open="st-overlay-menu">
                   <span class="st-btn-menu__icon" aria-hidden="true">
                       <span class="st-btn-menu__line"></span>
                        <span class="st-btn-menu__line"></span>
                        <span class="st-btn-menu__line"></span>
                   </span>
                    Menu
                </button>
            </div>

            <div class="st-overlay__header-row2 st-wrapper">
                <span>Afficher :</span>
                <div class="st-filters-list">
                    <button id="st-pages" class="st-btn-filter-search st-is-active">Pages</button>
                    <button id="st-events" class="st-btn-filter-search st-is-active"><liferay-ui:message key="eu.strasbourg.events" /></button>
                    <button id="st-places" class="st-btn-filter-search st-is-active">Lieux</button>
                    <button id="st-editions" class="st-btn-filter-search">Editions</button>
                    <button id="st-officals" class="st-btn-filter-search"><liferay-ui:message key="officals" /></button>

                </div>
                <div class="st-results">
                    <liferay-ui:message key="eu.strasbourg.dynamic-search-strasbourg-result-search" /> <span class="st-results__total" id="results-total">0</span>
                </div>
            </div>

        </div>

        <div class="st-overlay__body st-custom-scrollbar">

            <div class="st-wrapper">
                <ul id="resultList" class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small">
                </ul>
            </div>
        </div>

        <div class="st-overlay__footer st-hide-from@t-portrait">
            <a href="#" class="st-btn-compte">
                <span class="st-icon-demarche" aria-hidden="true"></span>Mes démarches
            </a>
            <select onchange="document.location.href = this.value;" class="select-lang">
                <option value="https://strasbourg-refonte.s3.dev-thuria.com/" selected="selected">
                    Fr
                </option>
                <option value="https://strasbourg-refonte.s3.dev-thuria.com//en">En</option>
            </select>
        </div>

    </form>

</div>

<liferay-util:html-top>
	<script>
		var homeURL = '${homeURL}';
		var porletNamespace = '<portlet:namespace/>';
		var dynamicSearch = ${dynamicSearch};

		var searchSubmitURL = '${searchSubmitURL}';
	</script>
</liferay-util:html-top>

<liferay-util:html-bottom>
	<script src="/o/dynamicsearchassetweb/js/strasbourg.js"></script>
</liferay-util:html-bottom>