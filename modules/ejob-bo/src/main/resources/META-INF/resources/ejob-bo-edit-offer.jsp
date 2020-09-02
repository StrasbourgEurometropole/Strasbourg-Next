<%@ include file="/ejob-bo-init.jsp"%>

<%@page import="eu.strasbourg.service.ejob.model.Offer"%>

<%-- URL : definit le lien menant vers la page de listage de l'entite --%>
<liferay-portlet:renderURL varImpl="offersURL">
	<portlet:param name="tab" value="offers" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien menant vers la suppression de l'entite --%>
<liferay-portlet:actionURL name="deleteOffer" var="deleteOfferURL">
	<portlet:param name="cmd" value="deleteOffer" />
	<portlet:param name="tab" value="offers" />
	<portlet:param name="offerId"
	    value="${not empty dc.offer ? dc.offer.offerId : ''}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien menant vers la sauvegarde de l'entite --%>
<liferay-portlet:actionURL name="saveOffer" varImpl="saveOfferURL">
	<portlet:param name="cmd" value="saveOffer" />
	<portlet:param name="tab" value="offers" />
</liferay-portlet:actionURL>

<%-- Composant : Body --%>
<div class="container-fluid-1280 main-content-body ejob-bo">

	<%-- Composant : definit la liste des messages d'erreur  (voir methode "validate" dans le saveAction de l'entite) --%>
	<liferay-ui:error key="type-recrutement-error" message="type-recrutement-error" />
	<liferay-ui:error key="post-error" message="post-error" />
	<liferay-ui:error key="direction-error" message="direction-error" />
	<liferay-ui:error key="full-time-error" message="full-time-error" />
	<liferay-ui:error key="filiere-error" message="filiere-error" />
	<liferay-ui:error key="categorie-error" message="categorie-error" />
    <liferay-ui:error key="grade-error" message="grade-error" />
    <liferay-ui:error key="etude-error" message="etude-error" />
    <liferay-ui:error key="introduction-error" message="introduction-error" />
    <liferay-ui:error key="activities-error" message="activities-error" />
    <liferay-ui:error key="profil-error" message="profil-error" />
    <liferay-ui:error key="conditions-error" message="conditions-error" />
    <liferay-ui:error key="avantages-error" message="avantages-error" />
    <liferay-ui:error key="famille-error" message="famille-error" />
    <liferay-ui:error key="date-limit-error" message="date-limit-error" />
    <liferay-ui:error key="contact-error" message="contact-error" />
    <liferay-ui:error key="publication-dates-error" message="publication-dates-error" />
    <liferay-ui:error key="publication-start-date-error" message="publication-start-date-error" />
    <liferay-ui:error key="publication-end-date-error" message="publication-end-date-error" />

	<%-- Composant : formulaire de saisie de l'entite --%>
	<aui:form action="${saveOfferURL}" method="post" name="fm" onSubmit="submitForm(event);">

		<%-- Propriete : definit l'entite de reference pour le formulaire--%>
		<aui:model-context bean="${dc.offer}" model="<%=Offer.class %>" />
		<aui:fieldset-group markupView="lexicon">

			<%-- Champ : (cache) PK de l'entite --%>
			<aui:input name="offerId" type="hidden" />

			<%-- Groupe de champs : Generalites --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=false%>">

                <%-- Champ : Numero de publication --%>
                    <aui:input name="publicationId" id="publicationId" required="false"/>

                <%-- Champ : Type de recrutement   --%>
                    <aui:select cssClass="toCustomSelect" id="ejobTypeRecrutement" name="ejobTypeRecrutement" label="ejobTypeRecrutement" required="true">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-typeRecrutement" /></aui:option>
                        <c:forEach items="${dc.typeRecrutements}" var="typeRecrutement">
                            <aui:option value="${typeRecrutement.categoryId}" selected="${dc.offer.offerTypeRecrutement.categoryId == typeRecrutement.categoryId}" >${typeRecrutement.name}</aui:option>
                        </c:forEach>
                    </aui:select>
                    <div id="type-recrutement-error" style="display: none">
                        <liferay-ui:message key="this-field-is-required" />
                    </div>

                <%-- Champ : Interne/Externe --%>
                <div id="typeExportTotem">
                    <label><liferay-ui:message key="ejob-type-publication" /></label><br>
                    <c:forEach items="${dc.typePublications}" var="typePublication">
                        <aui:input type="radio" value="${typePublication.categoryId}" name="typePublication" label="${typePublication.name}"
                            checked="${(empty dc.offer and typePublication.getTitle(locale) == 'Interne et externe') or dc.offer.typePublication.categoryId == typePublication.categoryId }" />
                    </c:forEach>
                </div>

                <%-- Champ : Numero de poste --%>
                    <aui:input name="postNumber" required="false"/>

                <%-- Champ : Nom de la personne remplacée ou création de poste --%>
                     <aui:input name="jobCreationDescription" required="false" />

                <%-- Champ : Date de départ  --%>
                     <fmt:formatDate value="${dc.offer.startDate}"
                        var="formattedStartDate" type="date" pattern="dd/MM/yyyy" />
                     <aui:input type="text" name="startDate2" required="false" placeHolder="JJ/MM/AAAA" value="${empty dc.offer.startDate?'':formattedStartDate}" >
                        <aui:validator name="custom" errorMessage="please-enter-a-valid-date">
                            function (val, fieldNode, ruleValue) {
                                var validate = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_startDate2').value.match(/^(\d{1,2})\/(\d{1,2})\/(\d{4})$/);
                                if (!validate) {
                                    document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_startDate2").scrollIntoView();
                                    event.preventDefault();
                                }
                                return validate;
                            }
                        </aui:validator>
                      </aui:input>

                <%-- Champ : Motif  --%>
                     <aui:input name="motif" required="false" />

                <%-- Champ : Si contrat permanent
                Ajout champ texte pré saisie « fonctionnaire ou à défaut contractuel »--%>
                     <c:set var="permanentDescriptionValue"><liferay-ui:message key='ejob-permanent-description-value' /></c:set>
                     <aui:input type="text" name="permanentDescription" required="false" value="${permanentDescriptionValue}" />

                <%-- Champ : Durée du contrat  --%>
                     <aui:input name="duration" required="false" />

                <%-- Champ : Intitulé du poste  --%>
                     <aui:input name="post" required="true" />

                <%-- Champ : Direction  --%>
                    <aui:select cssClass="toCustomSelect" id="ejobDirection" name="ejobDirection" label="ejobDirection" required="true">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-direction" /></aui:option>
                        <c:forEach items="${dc.directions}" var="direction">
                            <aui:option value="${direction.categoryId}" selected="${dc.offer.offerDirection.categoryId == direction.categoryId}">${direction.name}</aui:option>
                        </c:forEach>
                    </aui:select>

                <%-- Champ : Service  --%>
                    <aui:select cssClass="toCustomSelect" id="ejobService" name="ejobService" label="ejobService">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-service" /></aui:option>
                        <c:forEach items="${dc.services}" var="service">
                            <aui:option data-direction-id="${service.parentCategoryId}" value="${service.categoryId}" selected="${dc.offer.offerService.categoryId == service.categoryId}">${service.name}</aui:option>
                        </c:forEach>
                    </aui:select>

                <%-- Champ : Temps complet ou non   --%>
                    <div id="blockFullTime">
                        <label><liferay-ui:message key="ejob-contract-type" /></label><br>
                        <aui:input type="radio" value="1" name="isFullTime" label="ejob-full-time"
                            checked="${empty dc.offer or dc.offer.isFullTime}" />
                        <aui:input type="radio" value="0" name="isFullTime" class="no-full-time" label="ejob-partial-time"
                            checked="${not empty dc.offer and !dc.offer.isFullTime}" /><br>

                        <%-- Champ : Si temps complet   --%>
                             <aui:input name="fullTimeDescription" id="fullTimeDescription" required="false" />
                    </div>

                <%-- Champ : Filières   --%>
                    <aui:select cssClass="toCustomSelect" id="ejobFiliere" name="ejobFiliere" label="ejobFiliere" required="true">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-filiere" /></aui:option>
                        <c:forEach items="${dc.filieres}" var="filiere">
                            <aui:option value="${filiere.categoryId}" selected="${dc.offer.offerFiliere.categoryId == filiere.categoryId}">${filiere.name}</aui:option>
                        </c:forEach>
                    </aui:select>

                <%-- Champ : Catégories   --%>
                    <aui:select cssClass="toCustomSelect" id="ejobCategorie" name="ejobCategorie" label="ejobCategorie" required="true">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-categorie" /></aui:option>
                        <c:forEach items="${dc.filieresCategories}" var="categorie">
                            <aui:option data-filiere-id="${categorie.parentCategoryId}" value="${categorie.categoryId}" selected="${dc.offer.offerFiliereCategorie.categoryId == categorie.categoryId}">${categorie.name}</aui:option>
                        </c:forEach>
                    </aui:select>

                <%-- Champ : Choix du grade   --%>
                    <aui:select cssClass="toCustomSelect" id="ejobGrade" name="ejobGrade" label="ejobGrade" required="true">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-grade" /></aui:option>
                        <c:forEach items="${dc.grades}" var="grade">
                            <aui:option data-filiere-id="${grade.parentCategory.parentCategoryId}" data-categorie-id ="${grade.parentCategoryId}" value="${grade.categoryId}" selected="${dc.offer.offerGrade.categoryId == grade.categoryId}">${grade.name}</aui:option>
                        </c:forEach>
                    </aui:select>

                <%-- Champ : Niveau d'étude   --%>
                    <aui:select cssClass="toCustomSelect" id="ejobNiveauEtude" name="ejobNiveauEtude" label="ejobNiveauEtude" required="true">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-niveau-etude" /></aui:option>
                        <c:forEach items="${dc.niveauEtudes}" var="niveauEtudes">
                            <aui:option value="${niveauEtudes.categoryId}" selected="${dc.offer.offerNiveauEtude.categoryId == niveauEtudes.categoryId}">${niveauEtudes.name}</aui:option>
                        </c:forEach>
                    </aui:select>

                <%-- Champ : Introduction --%>
                    <aui:input name="introduction" required="true" />
                    <!-- Hack pour ajouter une validation -->
                    <div class="has-error form-group">
                        <aui:input type="hidden" name="introductionValidatorInputHelper" value="placeholder">
                            <aui:validator name="custom" errorMessage="this-field-is-required">
                                function (val, fieldNode, ruleValue) {
                                    var validate = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_introduction_fr_FR').value.length > 0;
                                    if (!validate) {
                                        document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_introductionEditorContainer").scrollIntoView();
                                        event.preventDefault();
                                    }
                                    return validate;
                                }
                            </aui:validator>
                        </aui:input>
                    </div>

                <%-- Champ : Activités --%>
                     <aui:input name="activities" required="true" />
                    <!-- Hack pour ajouter une validation -->
                    <div class="has-error form-group">
                        <aui:input type="hidden" name="activitiesValidatorInputHelper" value="placeholder">
                            <aui:validator name="custom" errorMessage="this-field-is-required">
                                function (val, fieldNode, ruleValue) {
                                    var validate = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_activities_fr_FR').value.length > 0;
                                    if (!validate) {
                                        document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_activitiesEditorContainer").scrollIntoView();
                                        event.preventDefault();
                                    }
                                    return validate;
                                }
                            </aui:validator>
                        </aui:input>
                    </div>

                <%-- Champ : Profil --%>
                     <aui:input name="profil" required="true" />
                    <!-- Hack pour ajouter une validation -->
                    <div class="has-error form-group">
                        <aui:input type="hidden" name="profilValidatorInputHelper" value="placeholder">
                            <aui:validator name="custom" errorMessage="this-field-is-required">
                                function (val, fieldNode, ruleValue) {
                                    var validate = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_profil_fr_FR').value.length > 0;
                                    if (!validate) {
                                        document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_profilEditorContainer").scrollIntoView();
                                        event.preventDefault();
                                    }
                                    return validate;
                                }
                            </aui:validator>
                        </aui:input>
                    </div>

                <%-- Champ : Condition d'exercice --%>
                     <aui:input name="conditions" required="true" />
                    <!-- Hack pour ajouter une validation -->
                    <div class="has-error form-group">
                        <aui:input type="hidden" name="conditionsValidatorInputHelper" value="placeholder">
                            <aui:validator name="custom" errorMessage="this-field-is-required">
                                function (val, fieldNode, ruleValue) {
                                    var validate = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_conditions_fr_FR').value.length > 0;
                                    if (!validate) {
                                        document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_conditionsEditorContainer").scrollIntoView();
                                        event.preventDefault();
                                    }
                                    return validate;
                                }
                            </aui:validator>
                        </aui:input>
                    </div>

                <%-- Champ : Avantages liés au poste --%>
                    <div id="avantages">
                        <aui:input name="avantages" required="true" />
                        <!-- Hack pour ajouter une validation -->
                        <div class="has-error form-group">
                            <aui:input type="hidden" name="avantagesValidatorInputHelper" value="placeholder">
                                <aui:validator name="custom" errorMessage="this-field-is-required">
                                    function (val, fieldNode, ruleValue) {
                                        var estRenseigne = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_avantages_fr_FR').value.length > 0;
                                        var sel = document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_ejobTypeRecrutement");
                                        var text= sel.options[sel.selectedIndex].text;
                                        var estVisible = text != "Stage";
                                        var validate = estRenseigne || !estVisible;
                                        if (!validate) {
                                            document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_avantagesEditorContainer").scrollIntoView();
                                            event.preventDefault();
                                        }
                                        return validate;
                                    }
                                </aui:validator>
                            </aui:input>
                        </div>
                    </div>

                <%-- Champ : Famille de métiers --%>
                    <aui:select cssClass="toCustomSelect" id="ejobFamille" name="ejobFamille" label="ejobFamille" required="true">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-famille" /></aui:option>
                        <c:forEach items="${dc.familles}" var="famille">
                            <aui:option value="${famille.categoryId}" selected="${dc.offer.offerFamille.categoryId == famille.categoryId}">${famille.name}</aui:option>
                        </c:forEach>
                    </aui:select>

                <%-- Champ : Date limite de candidatures --%>
                    <aui:input name="limitDate" required="true" />
                    <!-- Hack pour ajouter une validation -->
                    <div class="has-error form-group">
                        <aui:input type="hidden" name="limitDateValidatorInputHelper" value="placeholder">
                            <aui:validator name="custom" errorMessage="this-field-is-required">
                                function (val, fieldNode, ruleValue) {
                                    var validate = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_limitDate').value.length > 0;
                                    if (!validate) {
                                        document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_limitDate").scrollIntoView();
                                        event.preventDefault();
                                    }
                                    return validate;
                                }
                            </aui:validator>
                        </aui:input>
                    </div>

                <%-- Champ : Nom du RE + contact téléphonique  --%>
                    <aui:select cssClass="toCustomSelect" id="ejobContact" name="ejobContact" label="ejobContact">
                        <aui:option style="display: none" selected="${empty dc.offer}"><liferay-ui:message key="choose-contact" /></aui:option>
                        <c:forEach items="${dc.contacts}" var="contact">
                            <aui:option value="${contact.categoryId}" selected="${dc.offer.offerContact.categoryId == contact.categoryId}">${contact.name}</aui:option>
                        </c:forEach>
                    </aui:select>

                <%-- Champ : Nom du RRH + contact téléphonique --%>
                     <aui:input name="contact" required="true" />

                <%-- Champ : Envoi par mail de l’offre (lien + PDF) --%>
                    <div id="email-fields">
                        <label><liferay-ui:message key="emails" /></label>
                        <c:if test="${empty dc.offer.emails}">
                            <div class="lfr-form-row" id="email${param.index}">
                                <div class="row-fields">
                                    <liferay-util:include page="/includes/email-row.jsp" servletContext="<%=application %>">
                                        <liferay-util:param name="index" value="1" />
                                        <liferay-util:param name="email" value="" />
                                    </liferay-util:include>
                                </div>
                            </div>
                        </c:if>

                        <c:forEach items="${dc.offer.emails.split(',')}" var="email" varStatus="status">
                            <div class="lfr-form-row" id="email${param.index}">
                                <div class="row-fields">
                                    <liferay-util:include page="/includes/email-row.jsp" servletContext="<%=application %>">
                                        <liferay-util:param name="index" value="${status.count}" />
                                        <liferay-util:param name="email" value="${email}" />
                                    </liferay-util:include>
                                </div>
                            </div>
                        </c:forEach>
                        <c:if test="${empty dc.offer.emails}">
                            <aui:input type="hidden" name="emailsIndexes" value="1" />
                        </c:if>
                        <c:if test="${not empty dc.offer.emails}">
                            <aui:input type="hidden" name="emailsIndexes" value="${dc.getDefaultIndexes(dc.offer.emails)}" />
                        </c:if>
                     </div>

                <%-- Champ : Champ partage Linkedin  --%>
                     <aui:input name="shareLinkedin" required="false" />

                <%-- Champ : Date de début de publication d’une offre (programmation) --%>
                     <aui:input name="publicationStartDate" required="true" />
                    <!-- Hack pour ajouter une validation -->
                    <div class="has-error form-group">
                        <aui:input type="hidden" name="publicationStartDateValidatorInputHelper" value="placeholder">
                            <aui:validator name="custom" errorMessage="this-field-is-required">
                                function (val, fieldNode, ruleValue) {
                                    var validate = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_publicationStartDate').value.length > 0;
                                    if (!validate) {
                                        document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_publicationStartDate").scrollIntoView();
                                        event.preventDefault();
                                    }
                                    return validate;
                                }
                            </aui:validator>
                        </aui:input>
                    </div>

                <%-- Champ : Date de fin de publication d’une offre (programmation) --%>
                     <aui:input name="publicationEndDate" required="true" />
                    <!-- Hack pour ajouter une validation -->
                    <div class="has-error form-group">
                        <aui:input type="hidden" name="publicationEndDateValidatorInputHelper" value="placeholder">
                            <aui:validator name="custom" errorMessage="this-field-is-required">
                                function (val, fieldNode, ruleValue) {
                                    var validate = document.getElementById('_eu_strasbourg_portlet_ejob_EjobBOPortlet_publicationEndDate').value.length > 0;
                                    if (!validate) {
                                        document.getElementById("_eu_strasbourg_portlet_ejob_EjobBOPortlet_publicationEndDate").scrollIntoView();
                                        event.preventDefault();
                                    }
                                    return validate;
                                }
                            </aui:validator>
                        </aui:input>
                    </div>

            </aui:fieldset>

		</aui:fieldset-group>

		<%-- Composant : Menu de gestion de l'entite --%>
		<aui:button-row>

			<aui:input type="hidden" name="workflowAction" value="" />

			<%-- Test : Verification des droits d'edition et de sauvegarde --%>
			<c:if test="${(dc.hasPermission('ADD_OFFER') and empty dc.offer or dc.hasPermission('EDIT_OFFER') and not empty dc.offer) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg saveButton" type="submit" value="save" />
				</c:if>
                <c:if test="${not dc.workflowEnabled}">
                    <aui:button cssClass="btn-lg saveButton" type="submit" name="publish" value="save" />
                </c:if>
			</c:if>

			<%-- Test : Verification des droits de supression --%>
			<c:if test="${not empty dc.offer && dc.hasPermission('DELETE_OFFER') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel" value="delete" />
			</c:if>

			<%-- Composant : bouton de retour a la liste des entites --%>
			<aui:button cssClass="btn-lg" href="${param.returnURL}" type="cancel" />

		</aui:button-row>

	</aui:form>

</div>

<liferay-util:html-top>
	<script>
	var getemailRowJSPURL = '${emailRowURL}';
	</script>
</liferay-util:html-top>
<liferay-util:html-bottom>
	<script src="/o/ejobbo/js/ejob-bo-edit-offer.js" type="text/javascript"></script>
	<style>
	    strong.required{color: #B95000;}
	    [type="radio"]{margin-right: 10px;}
	    .no-full-time{margin-bottom: 1.5rem;}
	    .lfr-input-time { display: none;}
	</style>
</liferay-util:html-bottom>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deleteOfferURL}';
		}
	}
</aui:script>