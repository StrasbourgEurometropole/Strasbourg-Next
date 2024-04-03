<%@ include file="/help-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="helpSeekersURL">
	<portlet:param name="tab" value="helpSeekers" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="mvcPath" value="/help-bo-view-help-seekers.jsp" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>

<%-- Composant : barre de filtres et de gestion des entite --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="helpSeekersSearchContainer" searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
                className="eu.strasbourg.portlet.help.context.ViewHelpSeekersDisplayContext.HelpSeeker" modelVar="helpSeeker"
                keyProperty="publikUser.publikUserLiferayId" escapedModel="true">

                <%-- URL : definit le lien vers la page de consultation des demandes d'aide --%>
                <liferay-portlet:renderURL varImpl="viewSeekerHelpRequestsURL">
                    <portlet:param name="cmd" value="viewSeekerHelpRequests" />
                    <portlet:param name="helpSeekerId" value="${helpSeeker.publikUser.publikId}" />
                    <portlet:param name="backURL" value="${helpSeekersURL}" />
                    <portlet:param name="mvcPath" value="/help-bo-view-seeker-help-requests.jsp" />
					<portlet:param name="tab" value="helpSeekers" />
                </liferay-portlet:renderURL>

                <%-- Colonne : Nom --%>
                <liferay-ui:search-container-column-text cssClass="content-column"
                    href="${viewSeekerHelpRequestsURL}" name="last-name" truncate="true" orderable="true">
                    <c:out value="${helpSeeker.publikUser.lastName}" escapeXml='true'/>
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Prenom --%>
                <liferay-ui:search-container-column-text cssClass="content-column"
                    href="${viewSeekerHelpRequestsURL}" name="first-name" truncate="true" orderable="true">
                    <c:out value="${helpSeeker.publikUser.firstName}" escapeXml='true'/>
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Email --%>
                <liferay-ui:search-container-column-text cssClass="content-column"
                    href="${viewSeekerHelpRequestsURL}" name="email" truncate="true" orderable="true">
                    <c:out value="${helpSeeker.publikUser.email}" escapeXml='true'/>
                </liferay-ui:search-container-column-text>

                <%-- Colonne : Nombre de demandes de l'utilisateur --%>
                <liferay-ui:search-container-column-text cssClass="content-column"
                    href="${viewSeekerHelpRequestsURL}" name="nb-requests" truncate="true" orderable="true"
                    value="${helpSeeker.requestsNumber}" />

                <%-- Colonne : Date de dernière demande --%>
                <fmt:formatDate value="${helpSeeker.lastRequest.createDate}"
                    var="formattedLastRequestDate" type="date" pattern="dd/MM/yyyy HH:mm" />
                <liferay-ui:search-container-column-text cssClass="content-column"
                    href="${viewSeekerHelpRequestsURL}" name="last-request-date" truncate="true" orderable="true"
                    value="${formattedLastRequestDate}" />

                <%-- Colonne : Actions possibles --%>
                <liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsHelpSeeker(helpSeeker).getActionDropdownItems(helpSeeker.imagesCount)}"
					/>
                </liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
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
