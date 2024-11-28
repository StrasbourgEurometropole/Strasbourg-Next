<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/search-asset-init.jsp"%>
<%@page
	import="com.liferay.portal.kernel.security.permission.ResourceActionsUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetRendererFactory"%>

<liferay-portlet:actionURL portletConfiguration="true"
	varImpl="configurationActionURL" />

<liferay-ui:error key="wrong-friendly-url" message="wrong-friendly-url" />
<aui:form action="${configurationActionURL}" method="post" name="fm"  cssClass="container-fluid container-fluid-max-xl container-form-lg container-no-gutters">

    <aui:input name="cmd" type="hidden" value="update" />

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">

            <div class="sheet"><div class="panel-group panel-group-flush">
            <!-- Type d'asset -->
                <aui:fieldset collapsed="false" collapsible="true"
                    label="asset-type">
                    <liferay-ui:message key="asset-types-explanations" />
                    <div class="asset-types">
                        <aui:input type="hidden" name="assetClassNamesCount"
                            value="${fn:length(availableAssetRendererFactories)}" />
                        <c:set var="i" value="${0}" />
                        <c:forEach var="assetRendererFactory" varStatus="assetStatus"
                            items="${availableAssetRendererFactories}">
                            <c:set var="classNameIsChecked"
                                value="${fn:contains(assetClassNamesIds, assetRendererFactory.classNameId)}" />
                            <div class="asset-type-configuration">
                                <%
                                    AssetRendererFactory assetRendererFactory = (AssetRendererFactory) pageContext
                                                        .getAttribute("assetRendererFactory");
                                %>
                                <aui:input type="checkbox"
                                    name="assetClassNameId_${assetStatus.index}"
                                    label="<%= ResourceActionsUtil.getModelResource(locale, assetRendererFactory.getClassName()) %>"
                                    checked="${classNameIsChecked}"
                                    value="${assetRendererFactory.classNameId}" />

                                <aui:select name="templateKey_${assetStatus.index}"
                                    inlineField="true">
                                    <aui:option value="0"><liferay-ui:message key="select-a-template" /></aui:option>
                                    <c:forEach var="template"
                                        items="${templatesList[assetStatus.index]}">
                                        <aui:option value="${template.templateKey}"
                                            selected="${fn:contains(templatesKeys, template.templateKey)}">${template.getName(locale)}</aui:option>
                                    </c:forEach>
                                </aui:select>


                                <aui:input type="text"
                                    placeholder="detail-friendly-url"
                                    name="layoutFriendlyURL_${assetStatus.index}" inlineField="true"
                                    value="${classNameIsChecked ? layoutsFriendlyURLs[i] : ''}" />

                                <c:if test="${classNameIsChecked}">
                                    <c:set var="i" value="${i + 1}" />
                                </c:if>
                            </div>
                        </c:forEach>
                        <div class="asset-type-configuration">
                            <aui:input type="checkbox"
                                name="searchJournalArticle"
                                value="${searchJournalArticle}"
                                label="web-content" />
                            <aui:select name="journalArticleTemplateKey"
                                inlineField="true">
                                <aui:option value="0"><liferay-ui:message key="select-a-template" /></aui:option>
                                <c:forEach var="template"
                                    items="${assetEntryTemplatesList}">
                                    <aui:option value="${template.templateKey}"
                                        selected="${journalArticleTemplateKey eq template.templateKey}">
                                        ${template.getName(locale)}
                                    </aui:option>
                                </c:forEach>
                            </aui:select>
                        </div>
                        <div class="asset-type-configuration">
                            <aui:input type="checkbox"
                                       name="searchDocument"
                                       value="${searchDocument}"
                                       label="file" />
                            <aui:select name="documentTemplateKey"
                                        inlineField="true">
                                <aui:option value="0"><liferay-ui:message key="select-a-template" /></aui:option>
                                <c:forEach var="template"
                                           items="${documentTemplatesList}">
                                    <aui:option value="${template.templateKey}"
                                                selected="${documentTemplateKey eq template.templateKey}">
                                        ${template.getName(locale)}
                                    </aui:option>
                                </c:forEach>
                            </aui:select>
                        </div>
                        <div class="asset-type-configuration">
                            <aui:input type="checkbox"
                                       name="searchDemarche"
                                       value="${searchDemarche}"
                                       label="procedure" />
                        </div>
                    </div>
                    <div>

                    </div>
                </aui:fieldset>

                <!-- Portee -->
                <aui:fieldset collapsed="true" collapsible="true" label="scope">
                    <liferay-ui:message key="scope-explanations" />
                    <aui:input type="checkbox" name="globalScope" value="${globalScope}" label="global-scope" />
                </aui:fieldset>

                <!-- Prefiltre -->
                <aui:fieldset collapsed="true" collapsible="true" label="prefilter" cssClass="tag-selector">
                    <liferay-ui:message key="prefilter-explanations" />
                    <label><liferay-ui:message key="categories" /></label>
                    <p>
                        <asset-category-selector:category-selector
                                id="prefilterCategoriesIds"
                                groupIds="${themeDisplay.scopeGroupId},${themeDisplay.companyGroupId}"
                                label="categories"
                                values="${prefilterCategoriesIds}"
                                multiple="true"
                        />
                    </p>
                    <br>
                    <liferay-ui:message key="prefilter-tag-explanations" />
                    <liferay-asset:asset-tags-selector
                        hiddenInput="prefilterTagsNames"
                        tagNames="${prefilterTagsNames}" />
                </aui:fieldset>

                <!-- Criteres de recherche -->
                <aui:fieldset collapsed="true" collapsible="true"
                    label="search-criterias">
                    <liferay-ui:message key="vocabularies-explanations" />
                    <aui:input type="hidden" name="vocabulariesCount"
                        value="${fn:length(vocabularies)}" />

                    <c:set var="i" value="${0}" />
                    <c:forEach var="vocabulary" items="${vocabularies}"
                        varStatus="vocStatus">

                        <c:set var="vocabularyIsChecked"
                            value="${fn:contains(vocabulariesIds, vocabulary.vocabularyId)}" />

                        <div class="vocabulary-configuration">
                            <c:set var="vocabularyLabel" value="${vocabulary.name}" />
                            <c:if test="${vocabulary.groupId eq themeDisplay.companyGroupId}">
                                <c:set var="vocabularyLabel" value="${vocabularyLabel.concat(' (global)')}" />
                            </c:if>
                            <aui:input type="checkbox" name="vocabularyId_${vocStatus.index}"
                                label="${vocabularyLabel}" value="${vocabulary.vocabularyId}"
                                checked="${fn:contains(vocabulariesIds, vocabulary.vocabularyId)}" />

                            <aui:select name="vocabularyControlType_${vocStatus.index}"
                                inlineField="true">
                                <aui:option value="list"
                                    selected="${vocabularyIsChecked ? vocabulariesControlTypes[i] eq 'list' : 'false'}">Liste d&eacute;roulante</aui:option>
                                <aui:option value="radio"
                                    selected="${vocabularyIsChecked ? vocabulariesControlTypes[i] eq 'radio' : 'false'}">Boutons radios</aui:option>
                                <aui:option value="check"
                                    selected="${vocabularyIsChecked ? vocabulariesControlTypes[i] eq 'check' : 'false'}">Checkboxes</aui:option>
                            </aui:select>
                        </div>

                        <c:if test="${vocabularyIsChecked}">
                            <c:set var="i" value="${i + 1}" />
                        </c:if>
                    </c:forEach>

                    <!-- Filtre par date -->
                    <div>
                        <liferay-ui:message key="date-explanations" />
                        <aui:input type="checkbox" name="dateField" value="${dateField}" label="date-field" />
                    </div>

                    <!-- Tri par date -->
                    <div>
                        <liferay-ui:message key="date-sorting-explanations" />
                        <aui:input type="checkbox" name="displayDateSorting" value="${displayDateSorting}" label="date-sorting-field" />
                    </div>
                </aui:fieldset>

                <!-- Boosts -->
                <aui:fieldset collapsed="true" collapsible="true" label="boosts" cssClass="tag-selector">
                    <liferay-ui:message key="boost-explanations" />
                    <liferay-asset:asset-tags-selector
                        hiddenInput="boostTagsNames"
                        tagNames="${boostTagsNames}" />
                </aui:fieldset>

                <!-- Affichage par defaut -->
                <aui:fieldset collapsed="true" collapsible="true" label="default-display">
                    <liferay-ui:message key="default-display-explanations" />
                    <!-- Ne pas afficher de resultats avant que l'utilisateur n'ait fait de recherche -->
                    <aui:input type="checkbox" name="hideResultsBeforeSearch" value="${hideResultsBeforeSearch}" label="hide-results-before-search" />

                    <!-- Tri par defaut -->
                    <aui:select name="defaultSortField">
                        <aui:option value="modified_sortable" selected="${defaultSortField eq 'modified_sortable'}">
                            <liferay-ui:message key="modification-date" />
                        </aui:option>
                        <aui:option value="publishDate_sortable" selected="${defaultSortField eq 'publishDate_sortable'}">
                            <liferay-ui:message key="publication-date" />
                        </aui:option>
                        <aui:option value="dates_Number_sortable" selected="${defaultSortField eq 'dates_Number_sortable'}">
                            <liferay-ui:message key="entity-date" />
                        </aui:option>
                        <aui:option value="endDate_Number_sortable" selected="${defaultSortField eq 'endDate_Number_sortable'}">
                            <liferay-ui:message key="due-date" />
                        </aui:option>
                        <aui:option value="order_city_Number_sortable" selected="${defaultSortField eq 'order_city_Number_sortable'}">
                            <liferay-ui:message key="city-order-property" />
                        </aui:option>
                        <aui:option value="order_ems_Number_sortable" selected="${defaultSortField eq 'order_ems_Number_sortable'}">
                            <liferay-ui:message key="ems-order-property" />
                        </aui:option>
                        <aui:option value="priority_sortable" selected="${defaultSortField eq 'priority_sortable'}">
                            <liferay-ui:message key="order-priority" />
                        </aui:option>
                    </aui:select>



                    <!-- Type de tri par defaut -->
                    <aui:select name="defaultSortType">
                        <aui:option value="asc" selected="${defaultSortType eq 'asc'}">
                            <liferay-ui:message key="asc" />
                        </aui:option>
                        <aui:option value="desc" selected="${defaultSortType eq 'desc'}">
                            <liferay-ui:message key="desc" />
                        </aui:option>
                    </aui:select>

                    <!-- Filtre par date par defaut -->
                    <aui:input type="number" name="defaultDateRange" min="-1000" max="+1000" cssClass="date-range" value="${defaultDateRange}" label="default-date-range" inlineField="true"/>
                </aui:fieldset>

                <!-- Affichage -->
                <aui:fieldset collapsed="true" collapsible="true"
                    label="display">

                    <!-- Nombre de resultats par page -->
                    <aui:input type="number" name="delta" value="${delta}" />

                    <!-- Formulaire de recherche -->
                    <aui:select name="searchForm">
                        <aui:option value="museum" selected="${searchForm eq 'museum'}">
                            <liferay-ui:message key="museum" />
                        </aui:option>
                        <aui:option value="official" selected="${searchForm eq 'official'}">
                            <liferay-ui:message key="official" />
                        </aui:option>
                        <aui:option value="videos" selected="${searchForm eq 'videos'}">
                            <liferay-ui:message key="videos" />
                        </aui:option>
                        <aui:option value="summer-christmas-agenda" selected="${searchForm eq 'summer-christmas-agenda'}">
                            <liferay-ui:message key="summer-christmas-agenda" />
                        </aui:option>
                        <aui:option value="christmas-experience" selected="${searchForm eq 'christmas-experience'}">
                            <liferay-ui:message key="christmas-experience" />
                        </aui:option>
                        <aui:option value="bib-sae-agenda" selected="${searchForm eq 'bib-sae-agenda'}">
                            <liferay-ui:message key="bib-sae-agenda" />
                        </aui:option>
                        <aui:option value="strasbourg-agenda" selected="${searchForm eq 'strasbourg-agenda'}">
                            <liferay-ui:message key="strasbourg-agenda" />
                        </aui:option>
                        <aui:option value="strasbourg-generic" selected="${searchForm eq 'strasbourg-generic'}">
                            <liferay-ui:message key="strasbourg-generic" />
                        </aui:option>
                        <aui:option value="placit-projects" selected="${searchForm eq 'placit-projects'}">
                            <liferay-ui:message key="placit-projects" />
                        </aui:option>
                        <aui:option value="placit-participations" selected="${searchForm eq 'placit-participations'}">
                            <liferay-ui:message key="placit-participations" />
                        </aui:option>
                        <aui:option value="placit-agenda" selected="${searchForm eq 'placit-agenda'}">
                            <liferay-ui:message key="placit-agenda" />
                        </aui:option>
                        <aui:option value="placit-news" selected="${searchForm eq 'placit-news'}">
                            <liferay-ui:message key="placit-news" />
                        </aui:option>
                        <aui:option value="placit-videos" selected="${searchForm eq 'placit-videos'}">
                            <liferay-ui:message key="placit-videos" />
                        </aui:option>
                        <aui:option value="placit-petitions" selected="${searchForm eq 'placit-petitions'}">
                            <liferay-ui:message key="placit-petitions" />
                        </aui:option>
                        <aui:option value="placit-saisinesObservatoire" selected="${searchForm eq 'placit-saisinesObservatoire'}">
                            <liferay-ui:message key="placit-saisinesObservatoire" />
                        </aui:option>
                        <aui:option value="placit-budgetParticipatif" selected="${searchForm eq 'placit-budgetParticipatif'}">
                            <liferay-ui:message key="placit-budgetParticipatif" />
                        </aui:option>
                        <aui:option value="placit-initiatives" selected="${searchForm eq 'placit-initiatives'}">
                            <liferay-ui:message key="placit-initiatives" />
                        </aui:option>
                        <aui:option value="placit-project-workshop" selected="${searchForm eq 'placit-project-workshop'}">
                            <liferay-ui:message key="placit-project-workshop" />
                        </aui:option>
                        <aui:option value="ops-agenda" selected="${searchForm eq 'ops-agenda'}">
                            <liferay-ui:message key="ops-agenda" />
                        </aui:option>
                        <aui:option value="ops-general" selected="${searchForm eq 'ops-general'}">
                            <liferay-ui:message key="ops-general" />
                        </aui:option>
                        <aui:option value="ops-news" selected="${searchForm eq 'ops-news'}">
                            <liferay-ui:message key="ops-news" />
                        </aui:option>
                        <aui:option value="help" selected="${searchForm eq 'help'}">
                            <liferay-ui:message key="aide" />
                        </aui:option>
                    </aui:select>

                    <!-- Bouton exporter -->
                    <aui:input type="checkbox" name="displayExport" value="${displayExport}"
                        label="display-export" />

                    <!-- Type d'export -->
                    <aui:select name="exportType" showEmptyOption="true">
                        <aui:option value="city" selected="${exportType eq 'city'}">
                            <liferay-ui:message key="city" />
                        </aui:option>
                        <aui:option value="ems" selected="${exportType eq 'ems'}">
                            <liferay-ui:message key="ems" />
                        </aui:option>
                    </aui:select>
                </aui:fieldset>

            </div></div>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>

<style>
html:not(#__):not(#___) .cadmin .asset-types .asset-type-configuration .input-select-wrapper label,
html:not(#__):not(#___) .cadmin .asset-types .input-text-wrapper label,
html:not(#__):not(#___) .cadmin .vocabulary-configuration .input-select-wrapper label
	{
	display: none;
	float: right;
}

html:not(#__):not(#___) .cadmin .asset-types .input-select-wrapper,
html:not(#__):not(#___) .cadmin .vocabulary-configuration .input-select-wrapper
{
    display: inline-block;
	width: 250px;
}

html:not(#__):not(#___) .cadmin .asset-types .input-text-wrapper {
    display: inline-block;
	margin-bottom: 10px;
	margin-left: 50px;
	width: 250px;
}

html:not(#__):not(#___) .cadmin .asset-types .asset-type-configuration select,
html:not(#__):not(#___) .cadmin .vocabulary-configuration select
	{
	margin-left: 20px;
	min-width: 150px;
	margin-bottom: -5px;
}

html:not(#__):not(#___) .cadmin .asset-types .input-checkbox-wrapper,
html:not(#__):not(#___) .cadmin .vocabulary-configuration .input-checkbox-wrapper
{
    display: inline-block;
	width: 250px;
}
p {
	max-width: 800px;
}
p.date {
	margin-top: 20px;
}

.date-range {
	width: 100px;
}

html:not(#__):not(#___) .cadmin .panel-group-flush .panel-unstyled{
    margin-bottom: 0;
}

html:not(#__):not(#___) .cadmin .sheet .panel-group .panel-body,
html:not(#__):not(#___) .cadmin .sheet .panel-group .panel:last-child .panel-body{
    padding-top:0;
    margin-bottom: 0;
}

html:not(#__):not(#___) .cadmin .tag-selector .form-group .sheet-subtitle{
    display: none;
}
</style>