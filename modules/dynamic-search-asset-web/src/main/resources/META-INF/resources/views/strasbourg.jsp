<%@ include file="/dynamic-search-asset-init.jsp" %>

<portlet:resourceURL id="searchSubmit" var="searchSubmitURL">
</portlet:resourceURL>
<c:if test="${themeDisplay.isSignedIn()}" >
<clay:alert message="Overlay de recherche est present sur cette page"
displayType="secondary"
title="Overlay" />
</c:if>
<div id="st-overlay-search" class="st-overlay st-overlay-search st--from-top" role="dialog" aria-modal="true" tabindex="0" aria-label="Moteur de recherche">
    <button class="st-btn-close" data-overlay-close="st-overlay-search" aria-label="<liferay-ui:message key='eu.closed' />"></button>

    <div class="st-overlay__inner">
        <form action="#" class="st-overlay__header">
                <div class="st-overlay__header-row1 st-wrapper">
                    <div class="st-input-search-wrapper">
                        <input id="recherche-input" class="st-input-search st-js-input-search"  type="search" placeholder="Votre recherche" aria-label="Votre recherche">
                    </div>
                </div>

                <div class="st-overlay__header-row2 st-wrapper flex-wrap">
                    <fieldset>
                        <legend><liferay-ui:message key="eu.strasbourg.dynamic-search.legend" /></legend>

                        <ul class="st-filters-list">
                            <li>
                                <button type="button" id="dynamic_search_type_pages" data-entity-classname="com.liferay.journal.model.JournalArticle" class="st-btn-filter-search st-is-active" aria-pressed="true">Pages</button>
                            </li>
                            <li>
                                <button type="button" id="dynamic_search_type_events" data-entity-classname="eu.strasbourg.service.agenda.model.Event" class="st-btn-filter-search st-is-active" aria-pressed="true"><liferay-ui:message key="search.event" /></button>
                            </li>
                            <li>
                                <button type="button" id="dynamic_search_type_places" data-entity-classname="eu.strasbourg.service.place.model.Place" class="st-btn-filter-search st-is-active" aria-pressed="true"><liferay-ui:message key="search.place" /></button>
                            </li>
                            <li>
                                <button type="button" id="dynamic_search_type_editions" data-entity-classname="eu.strasbourg.service.edition.model.Edition" class="st-btn-filter-search st-is-active" aria-pressed="true"><liferay-ui:message key="search.editions" /></button>
                            </li>
                            <li>
                                <button type="button" id="dynamic_search_type_officals" data-entity-classname="eu.strasbourg.service.official.model.Official" class="st-btn-filter-search st-is-active" aria-pressed="true"><liferay-ui:message key="search.officals" /></button>
                            </li>
                        </ul>
                    </fieldset>


                    <div class="st-results" role="status" aria-live="polite" aria-busy="false">
                        <span class="loading-small-animation st-hide" aria-hidden="true"></span>
                        <liferay-ui:message key="eu.strasbourg.dynamic-search-strasbourg-result-search" /> <span class="st-results__total" id="results-total">0</span>
                    </div>

                    <p id="results-display" class="st-text" style="width:100%; font-size: 12px; display: none;"><liferay-ui:message key="eu.strasbourg.dynamic-search-strasbourg-result-display-x" arguments="${delta}" /></p>
                </div>
        </form>

        <div class="st-overlay__body st-custom-scrollbar">

            <div class="st-wrapper">
                <div id="resultList" class="st-cards-wrapper st--has-cards-horizontal st-basic-grid st-col-2@t-small" aria-busy="false">
                    <div class="loading-animation st-hide" aria-hidden="true">
                        <div></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="st-overlay__footer st-hide-from@t-portrait">
            <button class="st-btn-compte">
                <span class="st-icon-demarche" aria-hidden="true"></span>Mes démarches
            </button>
            <select onchange="document.location.href = this.value;" class="select-lang" title="<liferay-ui:message key='eu.fr' /> - <liferay-ui:message key='eu.change-language' />">
                <option value="https://strasbourg.eu"  aria-label="<liferay-ui:message key='eu.fr-label' />" selected="selected">
                    <liferay-ui:message key="eu.fr" />
                </option>
                <option value="https://int.strasbourg.eu/en" aria-label="<liferay-ui:message key='eu.en-label' />" lang="en">
                    <liferay-ui:message key="eu.en" />
                </option>
                <option value="https://int.strasbourg.eu/de" aria-label="<liferay-ui:message key='eu.de-label' />" lang="de">
                    <liferay-ui:message key="eu.de" />
                </option>
            </select>
        </div>
    </div>

</div>

<liferay-util:html-top>
	<script>
		var homeURL = '${homeURL}';
		var porletNamespace = '<portlet:namespace/>';
		var dynamicSearch = ${dynamicSearch};

		var searchSubmitURL = '${searchSubmitURL}';
	</script>
    <link rel="stylesheet" href="/o/dynamicsearchassetweb/css/dynamic-search.css" />
</liferay-util:html-top>

<liferay-util:html-bottom>
	<script src="/o/dynamicsearchassetweb/js/strasbourg.js"></script>
</liferay-util:html-bottom>