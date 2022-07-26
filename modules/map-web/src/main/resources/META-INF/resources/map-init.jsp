<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<jsp:useBean id="strasbourgPropsUtil" class="eu.strasbourg.utils.StrasbourgPropsUtil"/>

<liferay-util:body-top>
    <aui:script>
        window.userAddress = '${fn:escapeXml(address)}';
        window.zipCode = '${fn:escapeXml(zipCode)}';
        window.city = '${fn:escapeXml(city)}';

        window.mode = '${mode}';
        window.isWidgetMode = ${widgetMod};
        window.typesContenu = "${typesContenu}";
        window.coordinatesZone = '${coordinatesZone}';
        window.groupId = ${groupId};
        window.newTab = ${openInNewTab};
        window.backgroundId = '${backgroundId}';
        window.zoom = '${zoom}';
        window.cadrageX = '${cadrageX}';
        window.cadrageY = '${cadrageY}';
        window.prefilterCategoriesIds = "${prefilterCategoriesIds}";
        window.prefilterTags = "${prefilterTags}";
        window.interestsCheckedIds = "${fn:replace(interestsCheckedIds, '"', '')}";
        window.showFavoritesByDefault = ${showFavorites};
        window.showTraffic = ${showTraffic};
        window.dateField = ${dateField};
        window.defaultDateRange = ${defaultDateRange};
        window.globalGroupId = ${globalGroupId};
        window.fromDate = '${fromDate}';
        window.toDate = '${toDate}';

        window.aroundMePortletNamespace = '<portlet:namespace />';
        window.publikProfileURL = '${strasbourgPropsUtil.getPublikProfileURL()}';
        window.publikInternalId = '${internalId}';
        window.linkCategoryId = '${trafficCategoryId}';
        window.linkInterestId = '${trafficInterestId}';

        mymap = '';
    </aui:script>
</liferay-util:body-top>

<link rel="stylesheet" href="/o/mapweb/css/leaflet.css" />
<link rel="stylesheet" href="/o/mapweb/css/MarkerCluster.css" />
<link rel="stylesheet" href="/o/mapweb/css/MarkerCluster.Default.css" />
<link rel="stylesheet" href="/o/mapweb/css/leaflet-gesture-handling.css" />
<link rel="stylesheet" href="/o/mapweb/css/map.css" />

<liferay-util:html-bottom>
    <script src="/o/mapweb/js/leaflet.js"></script>
    <script src="/o/mapweb/js/leaflet.markercluster-src.js"></script>
    <script src="/o/mapweb/js/leaflet-list-markers.src.js"></script>
    <script src="/o/mapweb/js/leaflet.snogylop.js"></script>
    <script src="/o/mapweb/js/map.js"></script>
    <script src="/o/mapweb/js/leaflet-gesture-handling.js"></script>
</liferay-util:html-bottom>
