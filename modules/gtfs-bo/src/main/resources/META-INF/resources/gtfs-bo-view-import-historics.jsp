<%@ include file="/gtfs-bo-init.jsp"%>
<clay:navigation-bar inverted="true" navigationItems='${navigationDC.navigationItems}' />
<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="importHistoricsURL">
	<portlet:param name="tab" value="import-historics" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
	<portlet:param name="mvcPath" value="/gtfs-bo-view-import-historics.jsp" />
</liferay-portlet:renderURL>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="importHistoricsSearchContainer"
			searchContainer="${dc.searchContainer}">

			<liferay-ui:search-container-row
				className="eu.strasbourg.service.gtfs.model.ImportHistoric" modelVar="importHistoric"
				keyProperty="importHistoricId" >
				
				<%-- URL : definit le lien vers la page d'edition de l'entite selectionnee --%>
				<liferay-portlet:renderURL varImpl="editImportHistoricURL">
					<portlet:param name="tab" value="import-historics" />
					<portlet:param name="cmd" value="editImportHistoric" />
					<portlet:param name="importHistoricId" value="${importHistoric.importHistoricId}" />
					<portlet:param name="backURL" value="${importHistoricsURL}" />
					<portlet:param name="mvcPath" value="/gtfs-bo-edit-import-historic.jsp" />
				</liferay-portlet:renderURL>

				<%-- Colonne : Resultat --%>
				<liferay-ui:search-container-column-text cssClass="content-column" href="${editImportHistoricURL}"
					name="result" truncate="true" orderable="true" value="${importHistoric.getResultLabel()}" />
				
				<%-- Colonne : Date de creation --%>
				<fmt:formatDate value="${importHistoric.createDate}"
					var="formattedCreateDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text
					name="create-date" orderable="true"
					value="${formattedCreateDate}" />
				
				<%-- Colonne : Createur --%>
				<liferay-ui:search-container-column-text name="user"
				    cssClass="content-column" truncate="true" >
					${importHistoric.statusByUserName}
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="true" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
				
		</liferay-ui:search-container>
	</aui:form>
	
	<liferay-portlet:resourceURL var="importGTFSURL" id="importGTFS">
    </liferay-portlet:resourceURL>
	
	<form method="POST" action="${importGTFSURL}">
        <c:if test="${isAdmin}">
            <aui:button cssClass="btn-lg" type="submit" value="import-gtfs" />
        </c:if>
        <c:if test="${not isAdmin}">
            <aui:button cssClass="btn-lg" type="submit" value="import-gtfs"  disabled="true" />
            <div class="tooltip-inner"><liferay-ui:message key="import-forbidden" /></div>
        </c:if>
   	</form>
   	
</div>