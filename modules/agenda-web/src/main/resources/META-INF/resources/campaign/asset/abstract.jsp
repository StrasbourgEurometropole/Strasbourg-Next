<%@include file="/event/event-init.jsp" %>

<liferay-portlet:renderURL plid="${fromSearchPortlet ? classNameLayoutId[entry.modelClassName] : 0 }" var="detailURL" portletName="${detailPortletName}">
	<liferay-portlet:param name="classPK" value="${entry.campaignId}" />
</liferay-portlet:renderURL>
<c:set var="detailURL" value="${(fn:split(detailURL, '?'))[0]}" />

Vignette campagne : <a href="${detailURL}">${entry.getTitle(locale)}</a>

Veuillez selectionner un modele dans la configuration du portlet