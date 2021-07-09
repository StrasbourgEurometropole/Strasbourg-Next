<%@ include file="/family-kiosk-init.jsp" %>

<section id="family-kiosk">
    <%-- Récupère le fait de plier ou déplier ce widget dans la config de la personnalisation --%>
    <c:set value="${dc.isFolded()}" var="isFolded" />
    <div class="buttons">
        <%-- Vérifie si ce widget peut être plié dans la config de la personnalisation --%>
        <c:if test="${dc.showRetractableButton()}">
            <button class="${isFolded?'retractable-folded-wi':'retractable-unfolded-wi'}" data-portlet-id="${themeDisplay.portletDisplay.id}"></button>
        </c:if>
        <%-- Vérifie si ce widget peut être masqué dans la config de la personnalisation --%>
        <c:if test="${dc.showDeleteButton()}">
            <button class="delete-wi" data-portlet-id="${themeDisplay.portletDisplay.id}"></button>
        </c:if>
    </div>
    <h2>${title}</h2>
    <div class="detail" ${dc.isFolded()?'style="display: none;"':''}>
        <div style="font-size: 18px">${dc.intro}</div>
        <!-- Etape 1 -->
        <c:if test="${dc.familyKiosk.family != null}">
            <c:set value="${dc.familyKiosk.family}" var="family" />
            <div id="family" style="margin: 40px 0;">
                <c:if test="${fn:length(family.children) == 0}">
                    <!-- Accès espace famille -->
                    <div class="form-group">
                        <div class="content" style="text-align: center;">
                            <p style="margin-bottom: 30px";>
                                <liferay-ui:message key="no-child" />
                            </p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${fn:length(family.children) > 0}">
                    <!-- Une alerte est définie pour avertir que le dernier jour réservé est proche. Le message devra être affiché 12 jours avant le dernier jour réservé -->
                    <c:set var="dateAlert" value="${dc.today.plusDays(13)}" />
                    <c:set value="${family.getLastDateBookingByTypeActifAndYear('REST',1,1)}" var="lastBookingDate"/>
                    <c:if test="${dateAlert.isAfter(lastBookingDate)}">
                        <fmt:parseDate value="${lastBookingDate}" pattern="yyyy-MM-dd" var="lastBookingDateString" type="both" />
                        <fmt:formatDate value="${lastBookingDateString}" type="date" var="newLastBookingDate" pattern="dd/MM/yyyy" />
                        <div class="info">
                            <liferay-ui:message key="expire-booking-text-x" arguments="${newLastBookingDate}" />
                        </div>
                    </c:if>
                    <c:forEach items="${family.children}" var="child">
                        <c:set value="${child.getInscriptionsByTypeActifAndYear('REST',1,1)}" var="inscriptions"/>
                        <div class="webform-layout-box">
                            <!-- Enfant -->
                            <div class="form-group">
                                <!-- Nom -->
                                <div class="title">
                                    <label><liferay-ui:message key="child" /></label>
                                </div>
                                <div class="content">
                                    <p>${child.firstName} ${child.lastName}</p>
                                </div>
                            </div>

                            <!-- Repas -->
                            <c:if test="${fn:length(inscriptions) > 0}">
                                <div class="form-group">
                                    <div class="title">
                                        <label><liferay-ui:message key="lunch" /></label>
                                    </div>
                                    <div class="content">
                                        <c:forEach items="${inscriptions}" var="inscription">
                                            <fmt:parseDate value="${inscription.minDateBooking}" pattern="yyyy-MM-dd" var="firstBookingDate" type="both" />
                                            <fmt:formatDate value="${firstBookingDate}" type="date" var="newFirstBookingDate" pattern="dd/MM/yyyy" />
                                            <fmt:parseDate value="${inscription.maxDateBooking}" pattern="yyyy-MM-dd" var="lastBookingDate" type="both" />
                                            <fmt:formatDate value="${lastBookingDate}" type="date" var="newLastBookingDate" pattern="dd/MM/yyyy" />
                                            <c:set value="${newFirstBookingDate}-${newLastBookingDate}" var="dates"/>
                                            <p><liferay-ui:message key="lunch-x-y" arguments="${fn:split( dates ,'-')}" /></p>
                                        </c:forEach>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${dc.familyKiosk.finance != null && dc.familyKiosk.finance.lastReturnDate != null}">
                    <c:set value="${dc.familyKiosk.finance}" var="finance" />
                    <!-- Une alerte est définie pour avertir qu'il y a des facures à payer -->
                    <div class="warning">
                        <fmt:parseDate value="${finance.lastReturnDate}" pattern="yyyy-MM-dd" var="lastReturnDateString" type="both" />
                        <fmt:formatDate value="${lastReturnDateString}" type="date" var="newLastReturnDate" pattern="dd/MM/yyyy" />
                        <c:set value="${newLastReturnDate},${finance.nb},${finance.total}" var="arg" />
                        <liferay-ui:message key="to-pay-text-x-y-z" arguments="${fn:split(arg, ',')}" />
                    </div>
                </c:if>
                <c:if test="${fn:length(dc.familyKiosk.requests.getXRequests(6)) > 0}">
                    <c:set value="${dc.familyKiosk.requests.getXRequests(6)}" var="requests" />
                    <div class="form-group request">
                        <div class="upper-title">
                            <label><liferay-ui:message key="last-requests" /></label>
                        </div>
                        <div class="webform-layout-box">
                            <div class="form-group">
                                <div class="title">
                                    <label><liferay-ui:message key="requests" /></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="title">
                                    <label><liferay-ui:message key="created-date" /></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="title">
                                    <label><liferay-ui:message key="status" /></label>
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${requests}" var="request">
                            <div class="webform-layout-box">
                                <div class="form-group">
                                    <div class="content">
                                        <p>${request.libelle}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="content">
                                        <fmt:parseDate value="${request.date}" pattern="yyyy-MM-dd" var="dateString" type="both" />
                                        <fmt:formatDate value="${dateString}" type="date" var="newDate" pattern="dd/MM/yyyy" />
                                        <p>${newDate}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="content">
                                        <p>${request.status}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="webform-layout-box">
                        <!-- Acces demandes -->
                        <div class="form-group">
                            <div class="content" style="text-align: right;">
                                <a href="${dc.familyKioskURL}" class="btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="see-all-requests" /> (<liferay-ui:message key="eu.new-window" />)">
                                    <span class="flexbox">
                                        <span class="btn-text"><liferay-ui:message key="see-all-requests" /></span>
                                        <span class="btn-arrow"></span>
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </c:if>
        <div class="webform-layout-box">
            <!-- Acces espace famille -->
            <div class="form-group">
                <div class="content" style="text-align: center;">
                    <a href="${dc.familyKioskURL}" class="btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="access-family-kiosk" /> (<liferay-ui:message key="eu.new-window" />)">
                        <span class="flexbox">
                            <span class="btn-text"><liferay-ui:message key="access-family-kiosk" /></span>
                            <span class="btn-arrow"></span>
                        </span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>