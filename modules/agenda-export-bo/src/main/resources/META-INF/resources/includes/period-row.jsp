<%@ include file="/agenda-export-bo-init.jsp"%>

<div class="period-label"><label><liferay-ui:message key="eu.agenda.export.period.field" /></label></div>
<span class="date-range" id="dateRange${param.index}" >
	<c:if test="${not empty param.startDate}">
		${param.startDate} - ${param.endDate}
	</c:if>
	<c:if test="${empty param.startDate}">
		<liferay-ui:message key="select" />
	</c:if>
</span>

<aui:input type="hidden" value="${param.startDate}" id="startDate${param.index}" name="startDate${param.index}" cssClass="startDate" />
<aui:input type="hidden" value="${param.endDate}" id="endDate${param.index}" name="endDate${param.index}" cssClass="endDate" />
<div class="event-period-conflict" style="display: none">
	<liferay-ui:message key="event-period-conflict" />
</div>


<c:if test="${not empty fromAjax}">
	<aui:script>
		$('#date-fields').trigger('dateRangeCreated', ${param.index});
	</aui:script>
</c:if>