<%@ include file="/oidc-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="publikUsersURL">
	<portlet:param name="tab" value="publikUsers" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/oidc-bo-view-publikusers.jsp" />
</liferay-portlet:renderURL>

<%-- Composant : definit la liste des messages d'erreur --%>
<liferay-ui:error key="anonym-user-unfound" message="anonym-user-unfound" />
<liferay-ui:error key="no-anonym-user-id" message="no-anonym-user-id" />
<liferay-ui:error key="user-unfound" message="user-unfound" />
<liferay-ui:error key="no-user-id" message="no-user-id" />
<%-- Composant : definit la liste des messages de réalisation --%>
<liferay-ui:success key="anonymised" message="anonymised" />

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="publikUsersSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.oidc.model.PublikUser" modelVar="publikUser"
				keyProperty="publikUserLiferayId"  escapedModel="true">
				
				<%-- URL : definit le lien vers la page d'edition de l'entite selectionnee --%>
				<liferay-portlet:renderURL varImpl="editPublikUserURL">
					<portlet:param name="cmd" value="editPublikUser" />
					<portlet:param name="publikUserLiferayId" value="${publikUser.publikUserLiferayId}" />
					<portlet:param name="backURL" value="${publikUsersURL}" />
					<portlet:param name="mvcPath" value="/oidc-bo-edit-publikuser.jsp" />
				</liferay-portlet:renderURL>

				<%-- Colonne : Nom --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editPublikUserURL}" name="last-name" truncate="true" orderable="true"
					value="${publikUser.lastName}" />
				
				<%-- Colonne : Prenom --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editPublikUserURL}" name="first-name" truncate="true" orderable="true"
					value="${publikUser.firstName}" />
				
				<%-- Colonne : Email --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editPublikUserURL}" name="email" truncate="true" orderable="true"
					value="${publikUser.email}" />
				
				<%-- Colonne : Date de bannissement --%>
				<fmt:formatDate value="${publikUser.banishDate}"
					var="formattedBanishDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="banish-date" truncate="true" orderable="true"
					value="${formattedBanishDate}" />

				<%-- Colonne : Actions possibles --%>
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsPublikUser(publikUser).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>

	<liferay-portlet:resourceURL var="exportXlsxURL" id="exportXlsx" copyCurrentRenderParameters="false">
    </liferay-portlet:resourceURL>
   	<form method="POST" action="${exportXlsxURL}">
   		<aui:button-row>
   			<aui:button cssClass="btn-lg" type="submit"
   				value="extract-signing-pact" />
   		</aui:button-row>
   	</form>
</div>

<aui:script>
	var form = document.querySelector("[name='<portlet:namespace />fm']");
	var json = '{"desiredItemSelectorReturnTypes":"infoitem","itemSubtype":null,"itemType":"com.liferay.asset.kernel.model.AssetCategory","mimeTypes":null,"multiSelection":true,"refererClassPK":"0","status":0}';

	function getCategoriesByVocabulary(vocabularyId, vocabularyName, categoriesId) {
		const portletURL = location.protocol + '//' + location.host + location.pathname + "/-/select/com.liferay.item.selector.criteria.info.item.criterion.InfoItemItemSelectorCriterion/<portlet:namespace />selectCategory";
			const url = Liferay.Util.PortletURL.createPortletURL(portletURL, {
			p_p_id: 'com_liferay_item_selector_web_portlet_ItemSelectorPortlet',
			'0_json': json,
			p_p_lifecycle: 0,
			p_p_state: "pop_up",
			selectedCategories: categoriesId,
			selectedCategoryIds: categoriesId,
			singleSelect : false,
			showAddCategoryButton: true,
			vocabularyIds: vocabularyId,
		});

		Liferay.Util.openSelectionModal(
			{
				onSelect: function (selectedItem) {
					if (selectedItem) {
						var url = "${filterSelectionURL}";
						if(!url.includes("filterCategoriesIdByVocabulariesName"))
							url += "&<portlet:namespace />filterCategoriesIdByVocabulariesName=";
						if(url.includes(encodeURIComponent(vocabularyName).replaceAll("%20","+").replaceAll("'","%27")+'__')){
							const regex = encodeURIComponent(vocabularyName).replaceAll("%20","\\+").replaceAll("'","%27") + "(.(?<!___))*___";
							const re = new RegExp(regex, 'gi');
							url = url.replace(re,"");
						}
						for(index in Object.keys(selectedItem)){
							var selection = selectedItem[Object.keys(selectedItem)[index]];
							url += encodeURIComponent(vocabularyName) + '__' + encodeURIComponent(selection.title) + '__' + selection.categoryId + '___';
						}
						submitForm(form, url);
					}
				},
				selectEventName: '<portlet:namespace />selectCategory',
				title: vocabularyName,
				multiple: true,
				url: url
			}
		)
	}
</aui:script>
