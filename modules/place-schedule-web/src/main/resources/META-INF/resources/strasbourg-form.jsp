<!-- Formulaire de recherche -->
<aui:form action="${changeDataURL}" method="post" name="fm" id="search-asset-form" cssClass="seu-view-filters">
<div class="st-barre-listing-sit st--horaires" role="region" aria-label="Horaire des lieux, filtre des horaires">
    <div class="st-barre-inner st-wrapper form-styles">

        <div class="st-filtre st-group-field">
            <label for="place"><liferay-ui:message key="eu.place" /></label>
            <div class="st-field-select">
                <%@ include file="/select-place.jsp"%>
            </div>
        </div>

        <div class="st-filtre st-group-field">
            <label for="date">Date</label>
            <div class="st-field-date">
                <input name="date" data-type="date" type="date" id="date"
                       value="${selectedYear}-${selectedMonth<9?'0':''}${selectedMonth + 1}-${selectedDay}">
                <input type="hidden" name="<portlet:namespace />day" data-name="dateDay" value="${selectedDay}" />
                <input type="hidden" name="<portlet:namespace />month" data-name="dateMonth" value="${selectedMonth}" />
                <input type="hidden" name="<portlet:namespace />year" data-name="dateYear" value="${selectedYear}" />
            </div>

        </div>

<%--        Present dans la maquette mais pas dans le fonctionnel--%>
<%--        <div class="st-filtre st-group-field st--affluence">--%>
<%--            <label for="checkbox-1" class="st-field-checkbox">--%>
<%--                <input id="checkbox-1" type="checkbox" name="group-checkbox">--%>
<%--                Affluence faible uniquement--%>
<%--            </label>--%>
<%--        </div>--%>


        <div class="col-right">
            <button class="st-btn st--btn-small-padding st-btn-submit" type="submit"><liferay-ui:message key="to-research" /></button>
        </div>
    </div>
</div>

</aui:form>