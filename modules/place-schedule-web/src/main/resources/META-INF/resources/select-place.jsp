<select class="toCustomSelect" id="place" name="<portlet:namespace />placeId">
    <aui:option value="" label="select-place"/>
    <c:forEach var="place" items="${places}">
        <c:choose>
            <c:when test="${place.placeId == placeId}">
                <aui:option value="${place.placeId}" selected="true" >
                    ${place.getAlias(locale)}
                </aui:option>
            </c:when>
            <c:otherwise>
                <aui:option value="${place.placeId}" >
                    ${place.getAlias(locale)}
                </aui:option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select>