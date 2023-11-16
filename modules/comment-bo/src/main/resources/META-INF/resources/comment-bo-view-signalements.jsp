<%@ include file="/comment-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="signalementsURL">
	<portlet:param name="tab" value="reportings" />
	<portlet:param name="mvcPath" value="/comment-bo-view-signalements.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entite --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<aui:input type="hidden" name="selectionIds" />
		<liferay-ui:search-container id="signalementsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-results results="${dc.signalements}" />

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.comment.model.Signalement" modelVar="signalement"
				keyProperty="signalementId" rowIdProperty="signalementId" escapedModel="true">

				<%-- Colonne : Signaleur --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="signal-author" truncate="true" orderable="true" value="${fn:escapeXml(signalement.getSignalementAuthorLabel())}" />
					
				<%-- Colonne : Signale --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="comment-author" truncate="true" orderable="true" value="${fn:escapeXml(signalement.getCommentAuthorLabel())}" />

				<%-- Colonne : debut du commentaire --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="comment" truncate="true" value="${fn:escapeXml(signalement.getCommentContent())}" />

				<%-- Colonne : Date de modification--%>
				<fmt:formatDate value="${signalement.createDate}"
					var="formattedCreatedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text cssClass="content-column"
					name="reporting-date" truncate="true" orderable="true"
					value="${formattedCreatedDate}" />

				<%-- Colonne : Statut--%>
				<liferay-ui:search-container-column-text name="status">
					<aui:workflow-status markupView="lexicon" showIcon="false"
						showLabel="false" status="${signalement.status}" />
				</liferay-ui:search-container-column-text>

				<%-- Colonne : Type de signalement--%>
				<liferay-ui:search-container-column-text cssClass="content-column"
                    name="reportType" truncate="true" orderable="true"
                    value="${signalement.getCategorieName()}" />
                
                <%-- URL : Definit le lien vers la page d'edition du commentaire liee au signalement selectionnee --%>
				<liferay-portlet:renderURL varImpl="editCommentURL">
					<portlet:param name="tab" value="reportings" />
					<portlet:param name="cmd" value="editComment" />
					<portlet:param name="commentId" value="${signalement.commentId}" />
					<portlet:param name="backURL" value="${signalementsURL}" />
					<portlet:param name="mvcPath" value="/comment-bo-edit-comment.jsp" />
				</liferay-portlet:renderURL>
                    
                <%-- Colonne : lien vers le BO du commentaire --%>
				<liferay-ui:search-container-column-text cssClass="content-column" name="edit-comment-link" >
				    <aui:button href="${editCommentURL}" value="link-comment-bo"/>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<liferay-portlet:renderURL varImpl="filterSelectionURL">
	<portlet:param name="tab" value="reportings" />
	<portlet:param name="mvcPath" value="/comment-bo-view-signalements.jsp" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="filterCategoriesIdByVocabulariesName" value="${dc.filterCategoriesIdByVocabulariesName}" />
</liferay-portlet:renderURL>
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