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
    <div>${dc.intro}</div>
    <div class="detail" ${dc.isFolded()?'style="display: none;"':''}>
        <!-- contenu web -->
        <liferay-portlet:runtime
            portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
            instanceId="family-kiosk" />
        <!-- Etape 1 -->
        <c:if test="${dc.familyKiosk.family != null}">
            <c:set value="${dc.familyKiosk.family}" var="family" />
            <div name="${family.idFamily}" class="family">
                <div><liferay-ui:message key="family-x" arguments="${family.idFamily}" /></div>
            </div>
            <div id="family${family.idFamily}" style="margin-bottom: 40px;">
                <c:if test="${fn:length(family.children) == 0}">
                    <!-- Accès espace famille -->
                    <div class="form-group">
                        <div class="content" style="text-align: center;">
                            <p style="margin-bottom: 30px";>
                                <liferay-ui:message key="no-child" />
                            </p>
                            <a href="${dc.familyKioskURL}" class="btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="manage-family-kiosk" /> (<liferay-ui:message key="eu.new-window" />)">
                                <span class="flexbox">
                                    <span class="btn-text"><liferay-ui:message key="manage-family-kiosk" /></span>
                                    <span class="btn-arrow"></span>
                                </span>
                            </a>
                        </div>
                    </div>
                </c:if>
                <c:forEach items="${family.children}" var="child" varStatus="count">
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
                        <c:if test="${fn:length(child.restoInscriptions) > 0}">
                            <c:set value="${child.restoInscriptions}" var="inscription" />
                            <fmt:parseDate value="${inscription.minDateBooking}" pattern="yyyy-MM-dd" var="firstBookingDate" type="both" />
                            <fmt:formatDate value="${firstBookingDate}" type="date" var="newFirstBookingDate" pattern="dd/MM/yyyy" />
                            <fmt:parseDate value="${inscription.maxDateBooking}" pattern="yyyy-MM-dd" var="lastBookingDate" type="both" />
                            <fmt:formatDate value="${lastBookingDate}" type="date" var="newLastBookingDate" pattern="dd/MM/yyyy" />
                            <c:set value="${newFirstBookingDate}-${newLastBookingDate}" var="dates"/>
                            <div class="form-group">
                                <div class="title">
                                    <label><liferay-ui:message key="lunch" /></label>
                                </div>
                                <div class="content">
                                    <p><liferay-ui:message key="lunch-x-y" arguments="${fn:split( dates ,'-')}" /></p>
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <c:if test="${person.hasLunchBooked}">
                        <!-- Une alerte est définie pour avertir que le dernier jour réservé est proche. Le message devra être affiché 12 jours avant le dernier jour réservé -->
                        <c:set var="dateAlert" value="${dc.today.plusDays(13)}" />
                        <c:if test="${dateAlert.isAfter(person.lastBookingDate)}">
                            <div class="warning">
                                <strong><liferay-ui:message key="warning" /></strong><br>
                                <liferay-ui:message key="expire-validity-text-x" arguments="${newLastBookingDate}" />
                            </div>
                        </c:if>
                    </c:if>
                </c:forEach>
            </div>
        </c:if>
        <div class="webform-layout-box">
            <!-- Acces espace famille -->
            <div class="form-group">
                <div class="content" style="text-align: right;">
                    <a href="${dc.familyKioskURL}" class="btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="access-family-Kiosk" /> (<liferay-ui:message key="eu.new-window" />)">
                        <span class="flexbox">
                            <span class="btn-text"><liferay-ui:message key="access-family-Kiosk" /></span>
                            <span class="btn-arrow"></span>
                        </span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>