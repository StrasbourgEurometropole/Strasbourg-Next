<%@ include file="/search-asset-init.jsp"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.kernel.security.permission.ResourceActionsUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetRendererFactory"%>

<liferay-portlet:actionURL portletConfiguration="true" varImpl="configurationActionURL" />

<liferay-ui:error key="wrong-friendly-url" message="eu.search.asset.web.configuration.wrong-friendly-url" />

<aui:form action="${configurationActionURL}" id="fmConfig" method="post" name="fmConfig" cssClass="container-fluid container-fluid-max-xl container-form-lg container-no-gutters">

    <aui:input name="cmd" type="hidden" value="update" />

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280" id="container">

            <div class="sheet">
                <div class="panel-group panel-group-flush">
                    <!-- GROUPE : Type d'asset -->
                    <aui:fieldset collapsed="false" collapsible="true" label="asset-type">

                        <liferay-ui:message key="eu.search.asset.web.configuration.asset-types-explanations" />

                        <div id="asset-types-content">
                            <c:set var="assetTypeList" value="${dc.configurationData.assetTypeDataList}"/>
                            <c:set var="assetTypeNames" value="${dc.availableAssetTypeNames}" scope="request"/>

                            <aui:input name="nbAssetType" type="hidden" value="${assetTypeList.isEmpty() ? '1' : assetTypeList.size()}" />
                            <aui:input name="assetTypeIndexes" type="hidden" />

                            <c:if test="${empty assetTypeList}">
                                <liferay-util:include page="/includes/asset-type-row.jsp" servletContext="<%=application %>">
                                        <liferay-util:param name="index" value="0" />
                                </liferay-util:include>
                            </c:if>

                            <c:forEach items="${assetTypeList}" var="assetTypeData" varStatus="status">
                                <c:set var="assetTypeData" value="${assetTypeData}" scope="request"/>
                                <liferay-util:include page="/includes/asset-type-row.jsp" servletContext="<%=application %>">
                                        <liferay-util:param name="index" value="${status.index}" />
                                </liferay-util:include>
                            </c:forEach>
                        </div>

                        <aui:button cssClass="btn-icon icon icon-plus icon-2x" type="button" onClick="addAssetType();"/>

                    </aui:fieldset>

                    <!-- GROUPE : Criteres de recherche -->
                    <aui:fieldset collapsed="true" collapsible="true" label="eu.search.asset.web.configuration.search-criterias">

                        <liferay-ui:message key="eu.search.asset.web.configuration.vocabularies-explanations" />

                        <div  id="vocabularies-content">
                            <c:set var="vocabularyControlTypesMap" value="${dc.configurationData.vocabulariesControlTypesMap}"/>
                            <aui:input type="hidden" name="nbVocabularies" value="${vocabularyControlTypesMap.isEmpty() ? '0' : vocabularyControlTypesMap.size()}" />
                            <aui:input name="vocabularyIndexes" type="hidden" />

                            <c:forEach items="${vocabularyControlTypesMap}" var="vocabularyControlType" varStatus="status">
                                <c:set var="vocabularyControlType" value="${vocabularyControlType}" scope="request"/>
                                <liferay-util:include page="/includes/vocabulary-row.jsp" servletContext="<%=application %>">
                                        <liferay-util:param name="index" value="${status.index}" />
                                </liferay-util:include>
                            </c:forEach>
                        </div>

                        <aui:button cssClass="btn-icon icon icon-plus icon-2x" type="button" onClick="addVocabulary();"/>

                        <!-- CHAMP : Affichage du filtre par date -->
                        <div>
                            <liferay-ui:message key="eu.search.asset.web.configuration.date-explanations" />
                            <aui:input type="checkbox" name="displayDateField" value="${dc.configurationData.isDisplayDateField()}" label="eu.search.asset.web.configuration.date-field" />
                        </div>

                        <!-- CHAMP : Affichage des boutons de dates -->
                        <div>
                            <liferay-ui:message key="eu.search.asset.web.configuration.dates-buttons-explanations" />
                            <aui:input type="checkbox" name="displayDatesButtons" value="${dc.configurationData.isDisplayDatesButtons()}" label="eu.search.asset.web.configuration.show-dates-buttons-field" />
                        </div>

                        <!-- CHAMP : Affichage du selecteur de tri -->
                        <div>
                            <liferay-ui:message key="eu.search.asset.web.configuration.date-sorting-explanations" />
                            <aui:input type="checkbox" name="displaySorting" value="${dc.configurationData.isDisplaySorting()}" label="eu.search.asset.web.configuration.date-sorting-field" />
                        </div>

                        <!-- CHAMP : Affichage des types d'asset -->
                        <div>
                            <liferay-ui:message key="eu.search.asset.web.configuration.asset-type-explanations" />
                            <aui:input type="checkbox" name="displayAssetType" value="${dc.configurationData.isDisplayAssetType()}" label="eu.search.asset.web.configuration.asset-type-field" />
                        </div>

                    </aui:fieldset>

                    <!-- GROUPE : Boosts -->
                    <aui:fieldset collapsed="true" collapsible="true" label="eu.search.asset.web.configuration.boosts" cssClass="tag-selector">

                        <liferay-ui:message key="eu.search.asset.web.configuration.boost.explanations" />
                        <liferay-asset:asset-tags-selector
                                hiddenInput="boostTagsNames"
                                tagNames="${dc.configurationData.boostTagsNames}"
                        />

                    </aui:fieldset>

                    <!-- GROUPE : Filtres -->
                    <aui:fieldset collapsed="true" collapsible="true" label="eu.search.asset.web.configuration.filters">

                        <!-- CHAMP : Colonne sur laquelle filtrer par défaut -->
                        <aui:select name="filterField" label="eu.search.asset.web.configuration.filter-field">
                            <aui:option label="eu.search.asset.web.configuration.filter.modification-date" value="modified_sortable" selected="${dc.configurationData.filterField eq 'modified_sortable'}"/>
                            <aui:option label="eu.search.asset.web.configuration.filter.publication-date" value="publishDate_sortable" selected="${dc.configurationData.filterField eq 'publishDate_sortable'}"/>
                            <aui:option label="eu.search.asset.web.configuration.filter.entity-date" value="dates_Number_sortable" selected="${dc.configurationData.filterField eq 'dates_Number_sortable'}"/>
                            <aui:option label="eu.search.asset.web.configuration.filter.due-date" value="endDate_Number_sortable" selected="${dc.configurationData.filterField eq 'endDate_Number_sortable'}"/>
                        </aui:select>

                        <!-- CHAMP : Filtre par date par defaut -->
                        <aui:input type="number" name="defaultFilterDateRange" min="-1000" max="+1000" cssClass="date-range" value="${dc.configurationData.defaultFilterDateRange}" label="eu.search.asset.web.configuration.default-date-range" inlineField="true"/>

                    </aui:fieldset>

                    <!-- GROUPE : Tris -->
                    <aui:fieldset collapsed="true" collapsible="true" label="eu.search.asset.web.configuration.sorting">

                        <!-- CHAMP : Tri aléatoire -->
                        <div>
                            <aui:input type="checkbox" name="randomSort" value="${dc.configurationData.isRandomSort()}" label="eu.search.asset.web.configuration.random-sort" />
                        </div>

                        <aui:row id="ordering">
                            <aui:col width="<%= 50 %>">

                                <!-- CHAMP : Tri colonne 1 -->
                                <aui:select label="order-by" name="firstSortingField" value="" wrapperCssClass="field-inline w80 d-inline-block">
                                    <aui:option label="title" value="localized_title_fr_FR_sortable" selected="${dc.configurationData.firstSortingField eq 'localized_title_fr_FR_sortable'}"/>
                                    <aui:option label="create-date" value="createDate" selected="${dc.configurationData.firstSortingField eq 'createDate'}" />
                                    <aui:option label="modified-date" value="modified_sortable" selected="${dc.configurationData.firstSortingField eq 'modified_sortable'}" />
                                    <aui:option label="publish-date" value="publishDate_sortable" selected="${dc.configurationData.firstSortingField eq 'publishDate_sortable'}" />
                                    <aui:option label="expiration-date" value="expirationDate" selected="${dc.configurationData.firstSortingField eq 'expirationDate'}" />
                                    <aui:option label="eu.search.asset.web.configuration.filter.entity-date" value="dates_Number_sortable" selected="${dc.configurationData.firstSortingField eq 'dates_Number_sortable'}"/>
                                    <aui:option label="eu.search.asset.web.configuration.sort.start-date" value="startDate_Number_sortable" selected="${dc.configurationData.firstSortingField eq 'startDate_Number_sortable'}"/>
                                    <aui:option label="eu.search.asset.web.configuration.sort.end-date" value="endDate_Number_sortable" selected="${dc.configurationData.firstSortingField eq 'endDate_Number_sortable'}"/>
                                    <aui:option label="eu.search.asset.web.configuration.sort.city-order-property" value="order_city_Number_sortable" selected="${dc.configurationData.firstSortingField eq 'order_city_Number_sortable'}" />
                                    <aui:option label="eu.search.asset.web.configuration.sort.ems-order-property" value="order_ems_Number_sortable" selected="${dc.configurationData.firstSortingField eq 'order_ems_Number_sortable'}"/>
                                    <aui:option label="eu.search.asset.web.configuration.sort.order-priority" value="priority_sortable" selected="${dc.configurationData.firstSortingField eq 'priority_sortable'}"/>
                                </aui:select>

                                <!-- CHAMP : Tri type 1 -->
                                <aui:field-wrapper cssClass="field-label-inline order-by-type-container d-inline-block">

                                    <div class="d-inline-flex lfr-portal-tooltip ml-1 order-by-type-container">
                                        <clay:button
                                                borderless="<%= true %>"
                                                cssClass='icon ${dc.configurationData.firstSortingType == "DESC" ? "hide" : ""}'
                                                displayType="secondary"
                                                icon="order-list-up"
                                                monospaced="<%= true %>"
                                                title="ascending"
                                        />

                                        <clay:button
                                                borderless="<%= true %>"
                                                cssClass='icon ${dc.configurationData.firstSortingType == "ASC" ? "hide" : ""}'
                                                displayType="secondary"
                                                icon="order-list-down"
                                                monospaced="<%= true %>"
                                                title="descending"
                                        />

                                        <aui:input cssClass="order-by-type-field" name="firstSortingType" type="hidden" value="${dc.configurationData.firstSortingType}" />
                                    </div>

                                </aui:field-wrapper>


                            </aui:col>

                            <aui:col width="<%= 50 %>">

                                <!-- CHAMP : Tri colonne 2 -->
                                <aui:select label="and-then-by" name="secondSortingField" wrapperCssClass="field-inline w80 d-inline-block">
                                    <aui:option label="title" value="localized_title_fr_FR_sortable" selected="${dc.configurationData.secondSortingField eq 'localized_title_fr_FR_sortable'}"/>
                                    <aui:option label="create-date" value="createDate" selected="${dc.configurationData.secondSortingField eq 'createDate'}" />
                                    <aui:option label="modified-date" value="modified_sortable" selected="${dc.configurationData.secondSortingField eq 'modified_sortable'}" />
                                    <aui:option label="publish-date" value="publishDate_sortable" selected="${dc.configurationData.secondSortingField eq 'publishDate_sortable'}" />
                                    <aui:option label="expiration-date" value="expirationDate" selected="${dc.configurationData.secondSortingField eq 'expirationDate'}" />
                                    <aui:option label="eu.search.asset.web.configuration.filter.entity-date" value="dates_Number_sortable" selected="${dc.configurationData.secondSortingField eq 'dates_Number_sortable'}"/>
                                    <aui:option label="eu.search.asset.web.configuration.sort.start-date" value="startDate_Number_sortable" selected="${dc.configurationData.firstSortingField eq 'startDate_Number_sortable'}"/>
                                    <aui:option label="eu.search.asset.web.configuration.sort.end-date" value="endDate_Number_sortable" selected="${dc.configurationData.firstSortingField eq 'endDate_Number_sortable'}"/>
                                    <aui:option label="eu.search.asset.web.configuration.sort.city-order-property" value="order_city_Number_sortable" selected="${dc.configurationData.secondSortingField eq 'order_city_Number_sortable'}" />
                                    <aui:option label="eu.search.asset.web.configuration.sort.ems-order-property" value="order_ems_Number_sortable" selected="${dc.configurationData.secondSortingField eq 'order_ems_Number_sortable'}"/>
                                    <aui:option label="eu.search.asset.web.configuration.sort.order-priority" value="priority_sortable" selected="${dc.configurationData.secondSortingField eq 'priority_sortable'}"/>
                                </aui:select>

                                <!-- CHAMP : Tri type 2 -->
                                <aui:field-wrapper cssClass="field-label-inline order-by-type-container d-inline-block">

                                    <div class="d-inline-flex lfr-portal-tooltip ml-1 order-by-type-container">
                                        <clay:button
                                                borderless="<%= true %>"
                                                cssClass='icon ${dc.configurationData.secondSortingType == "DESC" ? "hide" : ""}'
                                                displayType="secondary"
                                                icon="order-list-up"
                                                monospaced="<%= true %>"
                                                title="ascending"
                                        />

                                        <clay:button
                                                borderless="<%= true %>"
                                                cssClass='icon ${dc.configurationData.secondSortingType == "ASC" ? "hide" : ""}'
                                                displayType="secondary"
                                                icon="order-list-down"
                                                monospaced="<%= true %>"
                                                title="descending"
                                        />

                                        <aui:input cssClass="order-by-type-field" name="secondSortingType" type="hidden" value="${dc.configurationData.secondSortingType}" />
                                    </div>
                                </aui:field-wrapper>
                            </aui:col>
                        </aui:row>

                        <aui:script use="aui-base">
                            A.one('#<portlet:namespace />ordering').delegate(
                                'click',
                                function(event) {
                                    var currentTarget = event.currentTarget;

                                    var orderByTypeContainer = currentTarget.ancestor(
                                        '.order-by-type-container'
                                    );

                                    orderByTypeContainer.all('.icon').toggleClass('hide');

                                    var orderByTypeField = orderByTypeContainer.one('.order-by-type-field');

                                    var newVal = orderByTypeField.val() === 'ASC' ? 'DESC' : 'ASC';

                                    orderByTypeField.val(newVal);
                                },
                                '.icon'
                            );
                        </aui:script>

                    </aui:fieldset>

                    <!-- GROUPE : Groupement -->
                    <%-- <aui:fieldset collapsed="true" collapsible="true" label="eu.search.asset.web.configuration.group">

                        <!-- CHAMP : Champ sur lequel effectuer le groupement -->
                        <aui:input name="groupBySelectedId" value="${dc.configurationData.groupBy}" type="hidden" />
                        <select class="form-control" name="<portlet:namespace />groupBy" id="<portlet:namespace />groupBy"></select>

                    </aui:fieldset>
                    --%>

                    <!-- GROUPE : Affichage -->
                    <aui:fieldset collapsed="true" collapsible="true" label="eu.search.asset.web.configuration.display">

                        <!-- CHAMP : Ne pas afficher de resultats avant que l'utilisateur n'ait fait de recherche -->
                        <aui:input type="checkbox" name="hideResultsBeforeSearch" value="${dc.configurationData.isHideResultsBeforeSearch()}" label="eu.search.asset.web.configuration.hide.results.before.search" />

                        <!-- CHAMP : Nombre de resultats par page -->
                        <aui:input type="number" name="delta" label="eu.search.asset.web.configuration.delta" value="${dc.configurationData.delta}" />

                        <!-- CHAMP : Formulaire de recherche -->
                        <aui:select name="searchForm" label="eu.search.asset.web.configuration.search-form">
                            <aui:option value="museum-actu" selected="${dc.configurationData.searchForm eq 'museum-actu'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.museum-actu" />
                            </aui:option>
                            <aui:option value="museum-generic" selected="${dc.configurationData.searchForm eq 'museum-generic'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.museum-generic" />
                            </aui:option>
                            <aui:option value="official" selected="${dc.configurationData.searchForm eq 'official'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.official" />
                            </aui:option>
                            <aui:option value="videos" selected="${dc.configurationData.searchForm eq 'videos'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.videos" />
                            </aui:option>
                            <aui:option value="summer-christmas-general" selected="${dc.configurationData.searchForm eq 'summer-christmas-general'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.summer-christmas-general" />
                            </aui:option>
                            <aui:option value="summer-christmas-agenda" selected="${dc.configurationData.searchForm eq 'summer-christmas-agenda'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.summer-christmas-agenda" />
                            </aui:option>
                            <aui:option value="christmas-experience" selected="${dc.configurationData.searchForm eq 'christmas-experience'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.christmas-experience" />
                            </aui:option>
                            <aui:option value="bib-sae-agenda" selected="${dc.configurationData.searchForm eq 'bib-sae-agenda'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.bib-sae-agenda" />
                            </aui:option>
                            <aui:option value="strasbourg-int-generic" selected="${dc.configurationData.searchForm eq 'strasbourg-int-generic'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.strasbourg-int-generic" />
                            </aui:option>
                            <aui:option value="strasbourg-agenda" selected="${dc.configurationData.searchForm eq 'strasbourg-agenda'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.strasbourg-agenda" />
                            </aui:option>
                            <aui:option value="strasbourg-generic" selected="${dc.configurationData.searchForm eq 'strasbourg-generic'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.strasbourg-generic" />
                            </aui:option>
                            <aui:option value="strasbourg-generic-grille" selected="${dc.configurationData.searchForm eq 'strasbourg-generic-grille'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.strasbourg-generic" /> Grille
                            </aui:option>
                            <aui:option value="placit-projects" selected="${dc.configurationData.searchForm eq 'placit-projects'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-projects" />
                            </aui:option>
                            <aui:option value="placit-participations" selected="${dc.configurationData.searchForm eq 'placit-participations'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-participations" />
                            </aui:option>
                            <aui:option value="placit-agenda" selected="${dc.configurationData.searchForm eq 'placit-agenda'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-agenda" />
                            </aui:option>
                            <aui:option value="placit-news" selected="${dc.configurationData.searchForm eq 'placit-news'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-news" />
                            </aui:option>
                            <aui:option value="placit-videos" selected="${dc.configurationData.searchForm eq 'placit-videos'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-videos" />
                            </aui:option>
                            <aui:option value="placit-petitions" selected="${dc.configurationData.searchForm eq 'placit-petitions'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-petitions" />
                            </aui:option>
                            <aui:option value="placit-saisinesObservatoire" selected="${dc.configurationData.searchForm eq 'placit-saisinesObservatoire'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-saisinesObservatoire" />
                            </aui:option>
                            <aui:option value="placit-budgetParticipatif" selected="${dc.configurationData.searchForm eq 'placit-budgetParticipatif'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-budgetParticipatif" />
                            </aui:option>
                            <aui:option value="placit-initiatives" selected="${dc.configurationData.searchForm eq 'placit-initiatives'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-initiatives" />
                            </aui:option>
                            <aui:option value="placit-project-workshop" selected="${dc.configurationData.searchForm eq 'placit-project-workshop'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.placit-project-workshop" />
                            </aui:option>
                            <aui:option value="ops-agenda" selected="${dc.configurationData.searchForm eq 'ops-agenda'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.ops-agenda" />
                            </aui:option>
                            <aui:option value="ops-general" selected="${dc.configurationData.searchForm eq 'ops-general'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.ops-general" />
                            </aui:option>
                            <aui:option value="ops-news" selected="${dc.configurationData.searchForm eq 'ops-news'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.ops-news" />
                            </aui:option>
                            <aui:option value="help" selected="${dc.configurationData.searchForm eq 'help'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.template.aide" />
                            </aui:option>
                        </aui:select>

                    </aui:fieldset>

                    <!-- GROUPE : Export -->
                    <aui:fieldset collapsed="true" collapsible="true" label="eu.search.asset.web.configuration.export">

                        <!-- CHAMP : Bouton exporter -->
                        <aui:input type="checkbox" name="displayExport" value="${dc.configurationData.isDisplayExport()}"
                            label="eu.search.asset.web.configuration.display-export" />

                        <!-- CHAMP : Type d'export -->
                        <aui:select name="exportType" showEmptyOption="true" label="eu.search.asset.web.configuration.export-type">
                            <aui:option value="city" selected="${dc.configurationData.exportType eq 'city'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.type-export.city" />
                            </aui:option>
                            <aui:option value="ems" selected="${dc.configurationData.exportType eq 'ems'}">
                                <liferay-ui:message key="eu.search.asset.web.configuration.type-export.ems" />
                            </aui:option>
                        </aui:select>

                    </aui:fieldset>

                    </div>
                </div>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>

</aui:form>

<liferay-util:html-top>
   	<script>
	        var assetTypeNames = "${dc.getAvailableAssetTypeNamesWithTrad(locale)}";
	        var assetTemplates = ${dc.availableAssetTemplates};
         	var scopesJson = ${dc.availableScopes};
   	</script>
</liferay-util:html-top>


<liferay-util:html-bottom>
    <script src="/o/searchassetv2web/js/vendors/choices.min.js"></script>
    <script src="/o/searchassetv2web/js/bloc-asset-type-configuration.js"></script>
    <script src="/o/searchassetv2web/js/bloc-prefilter-configuration.js"></script>
    <script src="/o/searchassetv2web/js/bloc-critere-recherche-configuration.js"></script>
    <script src="/o/searchassetv2web/js/searchassetv2web-config.js"></script>
    <link href="/o/searchassetv2web/css/search-asset-configuration.css" rel="stylesheet"></script>
    <link href="/o/searchassetv2web/css/vendors/choices.min.css" rel="stylesheet">
</liferay-util:html-bottom>