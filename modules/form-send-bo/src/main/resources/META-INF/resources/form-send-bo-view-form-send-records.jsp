<%@ include file="/form-send-bo-init.jsp"%>
<%-- URL : definit le lien de retour --%>

<%-- URL : definit le lien avec les parametres de recherche des entites--%>
<liferay-portlet:renderURL varImpl="viewFormSendsURL">
	<portlet:param name="tab" value="viewFormSends" />
	<portlet:param name="orderByCol" value="${dc.orderByCol}" />
	<portlet:param name="orderByType" value="${dc.orderByType}" />
	<portlet:param name="keywords" value="${dc.keywords}" />
    <portlet:param name="formInstanceId" value="${formInstanceId}" />
	<portlet:param name="delta" value="${dc.searchContainer.delta}" />
    <portlet:param name="backURL" value="${formsURL}" />
	<portlet:param name="mvcPath" value="/form-send-bo-view-form-send-records.jsp" />
</liferay-portlet:renderURL>

<clay:management-toolbar
		managementToolbarDisplayContext="${managementDC}"
/>

<%-- Composant : tableau de visualisation des entites --%>
<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form method="post" name="fm">
		<liferay-ui:search-container id="formSendsSearchContainer"
			searchContainer="${dc.searchContainer}">
			<liferay-ui:search-container-row
				className="com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord" modelVar="ddmFormInstanceRecord"
				keyProperty="recordId">

				<%-- URL : definit le lien vers la page d'edition de l'entite selectionnee --%>
				<liferay-portlet:renderURL varImpl="editFormSendURL">
					<portlet:param name="cmd" value="editFormSend" />
                    <portlet:param name="formInstanceId" value="${formInstanceId}" />
					<portlet:param name="formInstanceName" value="${formInstanceId}" />
					<portlet:param name="recordId" value="${ddmFormInstanceRecord.formInstanceRecordId}" />
					<portlet:param name="backURL" value="${viewFormSendsURL}" />
					<portlet:param name="mvcPath" value="/form-send-bo-edit-form-send.jsp" />
				</liferay-portlet:renderURL>

				<%-- Colonne : Date de création --%>
				<fmt:formatDate value="${ddmFormInstanceRecord.createDate}"
					var="formattedCreateDate" type="date" pattern="dd/MM/yyyy HH:mm" />
				<liferay-ui:search-container-column-text cssClass="content-column"
					href="${editFormSendURL}" name="create-date" truncate="true" orderable="true"
					value="${formattedCreateDate}" />

                <c:forEach items="${dc.getRecordFields(ddmFormInstanceRecord.storageId, locale)}" var="recordField">
                    <liferay-ui:search-container-column-text cssClass="content-column"
                        href="${editFormSendURL}" name="${recordField[0]}" truncate="true" orderable="true"
                        value="${recordField[1]}" />
                </c:forEach>
			</liferay-ui:search-container-row>

			<%-- Iterateur --%>
			<liferay-ui:search-iterator paginate="false" displayStyle="list"
				markupView="lexicon" searchContainer="${dc.searchContainer}" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<style>
    .lfr-checkbox-column{
        display:none;
    }
</style>