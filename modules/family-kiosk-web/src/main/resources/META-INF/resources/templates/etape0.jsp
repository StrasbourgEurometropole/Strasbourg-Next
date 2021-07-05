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
        <!-- contenu web -->
        <liferay-portlet:runtime
            portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
            instanceId="family-kiosk" />
        <!-- Etape 0 -->
        <c:if test="${not empty error}">
            <!-- Message d'erreur -->
            <div class="error">${error}</div>
        </c:if>

        <div align="center">
            <a href="${dc.familyKioskURL}" class="btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="access-family-kiosk" /> (<liferay-ui:message key="eu.new-window" />)">
                <span class="flexbox">
                    <span class="btn-text"><liferay-ui:message key="access-family-kiosk" /></span>
                    <span class="btn-arrow"></span>
                </span>
            </a>
        </div>
    </div>
</section>