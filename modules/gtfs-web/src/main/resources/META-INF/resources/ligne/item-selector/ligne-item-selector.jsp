<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<div id="<portlet:namespace />productsImageSelectorWrapper" class="container-fluid-1280 main-content-body">

    <%-- Ajout du champ de recherche suite à sa disparition après migration en 7.2 --%>
    <aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
        <aui:nav-bar-search>
            <aui:form action="" name="keyword">
                <liferay-ui:input-search markupView="lexicon" />
            </aui:form>
        </aui:nav-bar-search>
    </aui:nav-bar>

	<liferay-ui:search-container
		emptyResultsMessage="no-entries-were-found"
		iteratorURL="${portletURL}"
		total="${total}"
		rowChecker="<%=new RowChecker(renderResponse) %>"
	>
		<liferay-ui:search-container-results
			results="${lignes}"
		/>

		<liferay-ui:search-container-row
			className="eu.strasbourg.service.gtfs.model.Ligne"
			modelVar="ligne" cssClass="ligne-row" keyProperty="ligneId" rowIdProperty="ligneId"
		>
			<liferay-ui:search-container-column-text cssClass="content-column"
				name="ligne" truncate="true"
				value="${ligne.title}" />

			<fmt:formatDate value="${ligne.modifiedDate}"
				var="formattedModifiedDate" type="date" pattern="dd/MM/yyyy HH:mm" />
			<liferay-ui:search-container-column-text cssClass="content-column"
				name="modified-date" truncate="true"
				value="${formattedModifiedDate}" />

			<liferay-ui:search-container-column-text name="">
				<div class="data" data-id="${ligne.ligneId}" data-title="${ligne.title}"></div>
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator  />

		<liferay-ui:search-paginator searchContainer="${searchContainer}"   />
	</liferay-ui:search-container>
</div>
<aui:script>
	$('.ligne-row input[type=checkbox]').on('change', function() {
		var multiple = ${multiple};
		if (!multiple) {
			if (this.checked) {
				$('input[type=checkbox]').prop('checked', false);
				$('input[type=checkbox]').parents('tr').removeClass('info');
				this.checked = true;
				$(this).parents('tr').addClass('info');
			}
			var id = $('.info .data').data('id');
			var title = $('.info .data').data('title');
			Liferay.Util.getOpener().Liferay.fire('${itemSelectedLigneName}', {
				data: {
					entityId: id,
					title: title
				}
			});
		} else {
			var dataDivs = $('.info .data');
			var dataToSend = [];
			for (var i = 0; i < dataDivs.length; i++) {
				dataToSend.push({
					entityId: $(dataDivs[i]).data('id'),
					title: $(dataDivs[i]).data('title')
				});
			}
				
			Liferay.Util.getOpener().Liferay.fire('${itemSelectedLigneName}', {
				data: dataToSend
			});
		}
	});
</aui:script>
<style>
	.table-first-header input {
	    display: none;
	}
</style>