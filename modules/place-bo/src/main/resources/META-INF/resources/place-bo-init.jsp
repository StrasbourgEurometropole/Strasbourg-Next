<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0" prefix="portlet" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>

<%@ taglib uri="http://strasbourg.eu/tld/picker"
	prefix="strasbourg-picker"%>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-portlet:renderURL varImpl="periodRowURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/includes/period-row.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="slotRowURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/includes/slot-row.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="attendanceRowURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/includes/attendance-row.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="scheduleExceptionRowURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/includes/exceptional-schedule-row.jsp" />
</liferay-portlet:renderURL>