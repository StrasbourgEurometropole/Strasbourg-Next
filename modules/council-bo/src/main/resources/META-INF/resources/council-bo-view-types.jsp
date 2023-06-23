<%@ include file="/council-bo-init.jsp" %>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<liferay-portlet:renderURL varImpl="typesURL">
	<portlet:param name="tab" value="types" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
</liferay-portlet:renderURL>


<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<div class="container-fluid container-fluid-max-xl main-content-body">

	<%-- Composant : definit la liste des messages d'erreur  (voir methode "doProcessAction" dans le deleteAction de l'entite) --%>
	<liferay-ui:error key="type-has-council-error" message="type-has-council-error" />

	<aui:form method="post" name="fm">

		<liferay-ui:search-container id="typesSearchContainer" searchContainer="${dc.searchContainer}">


			<liferay-ui:search-container-row
				className="eu.strasbourg.service.council.model.Type"
				modelVar="type" keyProperty="typeId">

				<liferay-portlet:renderURL varImpl="editTypeURL">
					<portlet:param name="cmd" value="editType" />
					<portlet:param name="typeId" value="${type.typeId}" />
					<portlet:param name="backURL" value="${typesURL}" />
					<portlet:param name="mvcPath" value="/council-bo-edit-type.jsp" />
				</liferay-portlet:renderURL>

                <!-- Colonne : Titre -->
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editTypeURL}" name="title" truncate="true"
					orderable="true" value="${type.title}" />

                <!-- ACTIONS -->
				<liferay-ui:search-container-column-text>
					<clay:dropdown-actions
							aria-label="<liferay-ui:message key='show-actions' />"
							dropdownItems="${dc.getActionsTypes(type).getActionDropdownItems()}"
					/>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>
