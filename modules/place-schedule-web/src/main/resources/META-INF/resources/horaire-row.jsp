<li class="st-item-row">
    <p class="st-title">${horaires.key}</p>
    <div class="st-info st-u-color-secondary">
        <c:forEach var="placeSchedule" items="${horaires.value}" varStatus="status">
            <c:set var="isException"
                   value="${placeSchedule.isException() || placeSchedule.isPublicHoliday()}" />
            <c:if test="${isException}">
                <c:set var="hasException" value="${true}" />
            </c:if>
            <c:choose>
                <c:when test="${placeSchedule.isClosed()}">
                    <p class="st-u-color-pink"> <liferay-ui:message key="eu.closed" />
                            ${isException ? '*' : '' }</p>
                </c:when>
                <c:when test="${placeSchedule.isAlwaysOpen()}">
                    <p class="st-u-color-primary"><liferay-ui:message key="always-open" />
                            ${isException ? '*' : '' }</p>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${placeSchedule.openingTimes}" var="openingTime"
                               varStatus="loopStatus">
                        <p>${openingTime.first} - ${openingTime.second} ${isException ? '*'
                                : '' }</p>
                        <c:if test="${not empty placeSchedule.comments[loopStatus.index]}">
                            <p class="st-note">
                                    ${placeSchedule.comments[loopStatus.index]}
                            </p>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</li>