<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0" prefix="portlet" %>

<liferay-util:html-top>
    <link rel="stylesheet" href="/o/asset-category-selector-taglib/static/styles/choices.min.css"/>
</liferay-util:html-top>

<select class="form-control" name="<portlet:namespace />${id}"
        id="<portlet:namespace />${id}"
        multiple="${multiple}">
    <option placeholder><liferay-ui:message key="select-prefilters" /></option>
</select>

<script src="/o/asset-category-selector-taglib/static/scripts/choices.min.js"></script>
<script src="/o/asset-category-selector-taglib/js/asset-category-selector-taglib.js"></script>
<script>
    initCategorySelector(
        document.querySelector("#<portlet:namespace />${id}"),
        [${groupIds}], [${values}]
        <c:if test="${classname.length() > 0}">,${classname}</c:if>
    );
</script>
