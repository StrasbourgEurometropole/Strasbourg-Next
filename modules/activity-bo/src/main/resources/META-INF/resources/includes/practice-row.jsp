<%@ include file="/activity-bo-init.jsp"%>

<div id="practice-${param.index}" class="categories-selectors detail-practice">
	<aui:input name="practiceId${param.index}" value="${param.practiceId}" type="hidden" />
    <!-- Catégories -->
    <liferay-asset:asset-categories-selector
        hiddenInput="practiceId-${param.index}"
        categoryIds="${param.categoriesIds}"
		className="eu.strasbourg.service.activity.model.Practice"/>
</div>

<c:if test="${not empty fromAjax}">
	<aui:script>
		$('#practice-fields').trigger('practiceCreated', ${param.index});
	</aui:script>
</c:if>
