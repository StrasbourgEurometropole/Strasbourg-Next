<%@ include file="/form-send-bo-init.jsp"%>

<%-- URL : definit le lien menant vers la sauvegarde de l'entite --%>
<liferay-portlet:actionURL name="saveFormSend" varImpl="saveFormSendURL">
    <portlet:param name="tab" value="viewFormSends" />
    <portlet:param name="backURL" value="${param.backURL}" />
</liferay-portlet:actionURL>

<%-- Composant : Body --%>
<div class="container-fluid container-fluid-max-xl main-content-body">

    <%-- Composant : formulaire de saisie de l'entite --%>
    <aui:form action="${saveFormSendURL}" method="post" name="fm">

        <%-- Propriete : definit l'entite de reference pour le formulaire--%>
        <div class="sheet"><div class="panel-group panel-group-flush">

            <%-- Champ : (cache) PK de l'entite --%>
            <aui:input name="recordId" type="hidden" value="${dc.record.formInstanceRecordId}"/>

            <c:forEach items="${dc.getRecordFields(locale)}" var="recordField">
                <aui:fieldset collapsed="false" collapsible="true" label="${recordField[0]}">
                    ${recordField[1]}<br /><br />
                    <label>R&eacute;ponse</label>
                    <liferay-ui:input-editor contents="${recordField[3]}" width="80%" name="rep-ville_${recordField[2]}"/>
                </aui:fieldset>
            </c:forEach>

        </div></div>

        <%-- Composant : Menu de gestion de l'entite --%>
        <aui:button-row>
            <%-- Composant : bouton de valider a la liste des entites --%>
            <aui:button cssClass="btn-lg" type="submit" value="save" />

            <%-- Composant : bouton de retour a la liste des entites --%>
            <aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />

        </aui:button-row>

    </aui:form>
</div>