<%@ include file="/form-send-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="formsURL">
	<portlet:param name="tab" value="forms" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/form-send-bo-view-forms.jsp" />
</liferay-portlet:renderURL>

<!-- Declaration de l'URL de recherche dans le listing de l'entite courrante -->
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="cmd" value="search" />
	<portlet:param name="tab" value="${param.tab}" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/form-send-bo-view-forms.jsp" />
</liferay-portlet:renderURL>
<%-- Composant : barre de filtres et de gestion des entite --%>
<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>
<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid-1280 main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="formsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-row
				className="com.liferay.dynamic.data.mapping.model.DDMFormInstance" modelVar="ddmFormInstance"
				keyProperty="formInstanceId" >
				<%-- URL : definit le lien vers la page d'edition de l'entite selectionnee --%>
				<liferay-portlet:renderURL varImpl="viewFormSendsURL">
	                <portlet:param name="tab" value="viewFormSends" />
					<portlet:param name="formInstanceName" value="${ddmFormInstance.getName(locale)}" />
					<portlet:param name="formInstanceId" value="${ddmFormInstance.formInstanceId}" />
					<portlet:param name="backURL" value="${formsURL}" />
					<portlet:param name="mvcPath" value="/form-send-bo-view-form-send.jsp" />
				</liferay-portlet:renderURL>

				<%-- Colonne : Name --%>
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${viewFormSendsURL}" name="name" truncate="true" orderable="true"
					value="${ddmFormInstance.getName(locale)}" />

				<%-- Colonne : Id --%>
				<liferay-ui:search-container-column-text
					href="${viewFormSendsURL}" name="id" orderable="true"
					value="${ddmFormInstance.formInstanceId}" />

				<%-- Colonne : Date de modification --%>
				<fmt:formatDate value="${ddmFormInstance.modifiedDate}"
					var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="modified-date" orderable="true"
					value="${formattedModifiedDate}" />
			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<style>
    .lfr-checkbox-column{
        display:none;
    }
</style>