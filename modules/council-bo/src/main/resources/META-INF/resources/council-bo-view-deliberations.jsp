<%@ include file="/council-bo-init.jsp" %>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%@page import="eu.strasbourg.service.council.constants.StageDeliberation"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<liferay-portlet:renderURL varImpl="deliberationsURL">
	<portlet:param name="tab" value="deliberations" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="mvcPath" value="/council-bo-view-deliberations.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="importDeliberationURL">
	<portlet:param name="cmd" value="importDeliberation" />
	<portlet:param name="mvcPath" value="/council-bo-import-deliberation.jsp" />
	<portlet:param name="backURL" value="${importDeliberationURL}" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">

    <%-- Composant : definit la liste des messages d'erreur --%>
    <liferay-ui:error key="quorum-error">
        <liferay-ui:message key="quorum-error" arguments='<%= SessionErrors.get(liferayPortletRequest, "quorum-error") %>' />
    </liferay-ui:error>
    <liferay-ui:error key="council.deliberation-already-open" message="council.deliberation-already-open" />

    <liferay-ui:success key="import-successful" message="import-successful" />

	<aui:form method="post" name="fm">

		<liferay-ui:search-container id="deliberationsSearchContainer"
			searchContainer="${dc.searchContainer}">


			<liferay-ui:search-container-row
				className="eu.strasbourg.service.council.model.Deliberation"
				modelVar="deliberation" keyProperty="deliberationId" >
				<liferay-portlet:renderURL varImpl="editDeliberationURL">
					<portlet:param name="cmd" value="editDeliberation" />
					<portlet:param name="tab" value="deliberations" />
					<portlet:param name="deliberationId" value="${deliberation.deliberationId}" />
					<portlet:param name="backURL" value="${deliberationsURL}" />
					<portlet:param name="mvcPath" value="/council-bo-edit-deliberation.jsp" />
				</liferay-portlet:renderURL>

                <liferay-ui:search-container-column-text
                name="order"
                orderable="true" value="${deliberation.order}" />

				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editDeliberationURL}" name="title" truncate="true"
					orderable="true" value="${deliberation.title}" />

				<fmt:formatDate value="${deliberation.councilSession.date}"
					var="formattedDate" type="date" pattern="dd/MM/yyyy" />
				<!-- Colonne : Date de conseil - Type de conseil -->
				<liferay-ui:search-container-column-text cssClass="content-column"
                    name="councilSession"
                    orderable="true" value="${formattedDate} - ${deliberation.councilSession.typeCouncil.title}" />


                <liferay-ui:search-container-column-text cssClass="content-column ${dc.getCSSClass(deliberation)}"
                    name="stage"
                    orderable="true" value="${deliberation.stage}" />

				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsDeliberations(deliberation).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>

	<aui:button-row>
        <aui:button cssClass="btn-lg" type="submit" href="${importDeliberationURL}" value="Nouvel import" title="Importer des deliberations"/>
    </aui:button-row>
</div>


<liferay-util:html-bottom>
    <script src="/o/councilbo/js/council-bo-view-deliberations.js" type="text/javascript"></script>
</liferay-util:html-bottom>

<liferay-portlet:actionURL name="selectionAction"
	var="deleteSelectionURL">
	<portlet:param name="cmd" value="delete" />
	<portlet:param name="tab" value="deliberations" />
	<portlet:param name="mvcPath" value="/council-bo-view-deliberations.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:actionURL>
<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	function deleteSelection() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-selected-entries" />')) {
			submitForm(form, '${deleteSelectionURL}');
		}
	}

	function getCategoriesByVocabulary(vocabularyId, vocabularyName, categoriesId) {
		const portletURL = "${activityCoursesURL}";

		const url = Liferay.Util.PortletURL.createPortletURL(portletURL, {
			p_p_id: "com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet",
			p_p_lifecycle: 0,
			p_p_state: "pop_up",
			eventName: "com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet_selectCategory",
			selectedCategories: categoriesId,
			singleSelect : false,
			vocabularyIds: vocabularyId,
		});

		Liferay.Util.openSelectionModal(
			{
				onSelect: function (selectedItem) {
					if (selectedItem) {
						var url = "${filterSelectionURL}";
						if(!url.includes("filterCategoriesIdByVocabulariesName"))
							url += "&<portlet:namespace />filterCategoriesIdByVocabulariesName=";
						if(url.includes(encodeURI(vocabularyName.replaceAll(" ","+"))+'_')){
							const regex = encodeURI(vocabularyName).replaceAll("%20","\\+") + "(.(?<!__))*__";
							const re = new RegExp(regex, 'gi');
							url = url.replace(re,"");
						}
						for(index in Object.keys(selectedItem)){
							var selection = selectedItem[Object.keys(selectedItem)[index]];
							url += vocabularyName + '_' + selection.title + '_' + selection.categoryId + '__';
						}
						submitForm(form, url);
					}
				},
				selectEventName: 'com_liferay_asset_categories_selector_web_portlet_AssetCategoriesSelectorPortlet_selectCategory',
				title: vocabularyName,
				multiple: true,
				url: url
			}
		)
	}
</aui:script>