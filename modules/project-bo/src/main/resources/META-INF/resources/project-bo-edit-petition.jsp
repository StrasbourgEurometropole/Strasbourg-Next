<%@ include file="/project-bo-init.jsp"%>
<%@page import="eu.strasbourg.service.project.model.Petition"%>

<%-- URL : definit le lien menant vers la page de listage de l'entite --%>
<liferay-portlet:renderURL varImpl="petitionsURL">
	<portlet:param name="tab" value="petitions" />
</liferay-portlet:renderURL>

<%-- URL : definit le lien menant vers la suppression de l'entite --%>
<liferay-portlet:actionURL name="deletePetition" var="deletePetitionURL">
	<portlet:param name="cmd" value="deletePetition" />
	<portlet:param name="tab" value="petitions" />
	<portlet:param name="mvcPath" value="/project-bo-view-petitions.jsp" />
	<portlet:param name="petitionId" value="${not empty dc.petition ? dc.petition.petitionId : ''}" />
</liferay-portlet:actionURL>

<%-- URL : definit le lien menant vers la sauvegarde de l'entite --%>
<liferay-portlet:actionURL name="savePetition" varImpl="savePetitionURL">
	<portlet:param name="cmd" value="savePetition" />
	<portlet:param name="tab" value="petitions" />
</liferay-portlet:actionURL>

<%-- Composant : Body --%>
<div class="container-fluid container-fluid-max-xl main-content-body">

	<%-- Composant : definit la liste des messages d'erreur 
	(voir methode "validate" dans le saveAction de l'entite) --%>
	<liferay-ui:error key="title-error" message="title-error" />
	<liferay-ui:error key="description-error" message="description-error" />
	<liferay-ui:error key="image-error" message="image-error" />
	<liferay-ui:error key="place-error" message="place-error" />

	<%-- Composant : formulaire de saisie de l'entite --%>
	<aui:form action="${savePetitionURL}" method="post" name="fm" onSubmit="submitForm(event);">

		<%-- Propriete : definit l'entite de reference pour le formulaire--%>
		<aui:model-context bean="${dc.petition}" model="<%=Petition.class %>" />
		<div markupView="lexicon">

			<%-- Champ : (cache) PK de l'entite --%>
			<aui:input name="petitionId" type="hidden" />

			<%-- Groupe de champs : Generalites --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="general">

				<%-- Champ : Titre --%>
				<aui:input name="title" required="true" />
				
				<%-- Champ : Auteur penom --%>
				<aui:input name="petitionnaireFirstname" required="true">
				    <aui:validator name="maxLength">45</aui:validator>
				</aui:input>
				
				<%-- Champ : Auteur nom --%>
				<aui:input name="petitionnaireLastname" required="true" />
				
				<%-- Champ : Au nom de ... --%>
				<aui:input name="inTheNameOf" required="false">
					<aui:validator name="maxLength">140</aui:validator>
				</aui:input>

				<%-- Champ : quota Signataire --%>
				<aui:input name="quotaSignature" required="true" type="number" readonly="true"
					value="${not empty dc.petition ? dc.petition.quotaSignature : signatureNumber}"/>

			</aui:fieldset>

            <%-- Groupe de champs : video/image --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="label-video">

				<%-- Champ : Choix du media --%>
				<aui:input name="mediaChoice" label="media-preference" type="toggle-switch"
					value="${not empty dc.petition ? dc.petition.mediaChoice : true}" />

				<%-- Champ : URL de la video --%>
				<aui:input name="videoUrl" required="false" />

			    <%-- Selecteur : Image interne ou externe ? --%>
                <label><input type="radio" value="internalImage" name="imageType"
                    <c:if test="${(not empty dc.petition.imageId and dc.petition.imageId gt 0) or empty dc.petition.externalImageURL }">checked</c:if>> Image interne</label><br>
                <label><input type="radio" value="externalImage" name="imageType"
                    <c:if test="${(empty dc.petition.imageId or dc.petition.imageId eq 0) and not empty dc.petition.externalImageURL }">checked</c:if>> Image externe</label><br><br>

                <%-- Champ : Image interne --%>
                <div class="internalImage" <c:if test="${(empty dc.petition.imageId or dc.petition.imageId eq 0) and not empty dc.petition.externalImageURL }">style="display: none;"</c:if>>
                    <strasbourg-picker:image label="image" name="imageId" required="true" value="${dc.petition.imageId}" global="false"/>
                </div>

                <%-- Groupe de champs : Image externe --%>
                <div class="externalImage" <c:if test="${(not empty dc.petition.imageId and dc.petition.imageId gt 0) or empty dc.petition.externalImageURL }">style="display: none;"</c:if>>

                    <%-- Champ : URL de l'image externe --%>
                    <aui:input name="externalImageURL" helpMessage="help-image-size">
						<aui:validator name="required" errorMessage="this-field-is-required" />
					</aui:input>

                    <%-- Champ : Copyright de l'image externe --%>
                    <aui:input name="externalImageCopyright">
						<aui:validator name="required" errorMessage="this-field-is-required" />
					</aui:input>

                </div>

			</aui:fieldset>

            <%-- Groupe de champs : Description --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="label-describe">
				<aui:input name="description" required="false" />
			</aui:fieldset>

	        <%-- Champ : Corps du résumé --%>
            <aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="label-summary">
                <aui:input name="summary" label="input-summary" type="textarea" required="false" maxLength="500">
				    <aui:validator name="maxLength">500</aui:validator>
				</aui:input>
            </aui:fieldset>

			<%-- Groupe de champs : Soutien --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="label-support">
		
				<%-- Champ : Est soutenue ? --%>
				<aui:input name="isSupported" label="is-supported" type="toggle-switch"
					value="${not empty dc.petition ? dc.petition.isSupported : true}" />
				
				<%-- Champ : Soutenue par --%>
				<aui:input name="supportedBy" required="false" />

			</aui:fieldset>

            <%-- Groupe de champs : Lieux --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="label-place">
				
				<%-- Champ : Lieux de texte libre --%>
				<aui:input name="placeTextArea" label="place-text-area" required="false" />
				
				<%-- Champ : Lieux --%>
				<div id="place-fields">
					<c:if test="${empty dc.petition.getPlacitPlaces()}">
						<div class="lfr-form-row lfr-form-row-inline main-content-card row-place">
							<h3><liferay-ui:message key="place" /></h3>
							<div class="row-fields">
								<liferay-util:include page="/includes/placit-place-row.jsp" servletContext="<%=application %>">
									<liferay-util:param name="index" value="0" />
								</liferay-util:include>
							</div>
						</div>
					</c:if>
					<c:forEach items="${dc.petition.getPlacitPlaces()}" var="placitPlace" varStatus="status">
						<c:set var="placitPlace" value="${placitPlace}" scope="request"/>
						<div class="lfr-form-row lfr-form-row-inline main-content-card row-place">
							<h3><liferay-ui:message key="place" /></h3>
							<div class="row-fields">
								<liferay-util:include page="/includes/placit-place-row.jsp" servletContext="<%=application %>">
									<liferay-util:param name="index" value="${status.index}" />
								</liferay-util:include>
							</div>
						</div>
					</c:forEach>

					<aui:input type="hidden" name="placeIndexes" value="${dc.defaultPlaceIndexes}" />
                </div>
			</aui:fieldset>

            <%-- Groupe de champs : Documents a telecharger --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="label-document">

				<%-- Champ : Selection des documents --%>
				<strasbourg-picker:file label="eu.documents" name="filesIds"
					required="false" multiple="true" value="${dc.petition.filesIds}" />

			</aui:fieldset>

            <%-- Groupe de champs : vocabulaire --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="label-vocabulary">

				<%-- Champ : Selection des categories (gere par le portail dans l'onglet "Categories" du BO) --%>
				<liferay-asset:asset-categories-selector
						className="<%= Petition.class.getName() %>"
						classPK="${dc.petition.petitionId}"/>
				<!-- Hack pour ajouter une validation sur les vocabulaires obligatoires -->
				<div class="has-error">
					<aui:input type="hidden" name="assetCategoriesValidatorInputHelper" value="placeholder">
						<aui:validator name="custom" errorMessage="requested-vocabularies-error">
							function (val, fieldNode, ruleValue) {
								var validated = true;
								var fields = document.querySelectorAll('[id$=assetCategoriesSelector] > .field-content');
								for (var i = 0; i < fields.length; i++) {
									fieldContent = fields[i];
								    if ($(fieldContent).find('.lexicon-icon-asterisk').length > 0
								    	&& $(fieldContent).find('input[type="hidden"]').length == 0) {
								    	validated = false;
		                                event.preventDefault();
								    	break;
								    }
								}
								return validated;
							}
						</aui:validator>
					</aui:input>
				</div>

				<%-- Champ : Selection des etiquettes (gere par le portail dans l'onglet "Etiquettes" du BO) --%>
				<liferay-asset:asset-tags-selector
						className="<%= Petition.class.getName() %>"
						classPK="${dc.petition.petitionId}"/>

			</aui:fieldset>

            <%-- Groupe de champs : Autre --%>
			<aui:fieldset collapsed="<%=false%>" collapsible="<%=true%>" label="label-other">

				<%-- Champ : nombre signataire --%>
                <div class="form-group input-Date-wrapper">
                    <label class="control-label"><liferay-ui:message key="nb-fake-signataires" /></label>
				    <input class="field form-control lfr-input-text" type="text" name="<portlet:namespace />nbFakeSignataire"
				    value="${dc.getCountFakeSignataires()}"/>
                </div >

				<%-- Champ : Date de publication --%>
				<aui:input name="publicationDate" required="false" />

				<%-- Champ : Date d'expiration --%>
				<aui:input name="expirationDate" required="false" />
				
				<%-- Champ : Date d'extension --%>
				<aui:input name="extensionDate" required="false" />

			</aui:fieldset>

		</div></div>

		<%-- Composant : Menu de gestion de l'entite --%>
		<aui:button-row>
			
			<aui:input type="hidden" name="workflowAction" value="" />
			
			<%-- Test : Verification des droits d'edition et de sauvegarde --%>
			<c:if test="${(dc.hasPermission('ADD_PETITION') and empty dc.petition or dc.hasPermission('EDIT_PETITION') and not empty dc.petition) and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<c:if test="${dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" value="save" />
				</c:if>
				<c:if test="${not dc.workflowEnabled}">
					<aui:button cssClass="btn-lg" type="submit" name="publish" value="eu.publish" />
					<aui:button cssClass="btn-lg btn-default" type="submit" name="save-as-draft" value="save-as-draft" />
				</c:if>
			</c:if>
			
			<%-- Test : Verification des droits de supression --%>
			<c:if test="${not empty dc.petition && dc.hasPermission('DELETE_PETITION') and empty themeDisplay.scopeGroup.getStagingGroup()}">
				<aui:button cssClass="btn-lg" onClick='<%=renderResponse.getNamespace() + "deleteEntity();"%>' type="cancel" value="delete" />
			</c:if>
			
			<%-- Composant : bouton de retour a la liste des entites --%>
			<aui:button cssClass="btn-lg" href="${param.backURL}" type="cancel" />
			
		</aui:button-row>

	</aui:form>
	
</div>

<liferay-portlet:actionURL name="getPetitionPlaceRow" var="placeRowURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="mvcPath" value="/includes/placit-place-row.jsp" />
</liferay-portlet:actionURL>

<liferay-util:html-top>
	<script>
		var editPetition = true;
		var getPetitionPlaceRowURL = '${placeRowURL}';
	</script>
</liferay-util:html-top>

<liferay-util:html-bottom>
	<script	src="/o/agendabo/js/vendors/jquery.autocomplete.js"></script>
	<script src="/o/projectbo/js/project-bo-edit-petition.js" type="text/javascript"></script>
</liferay-util:html-bottom>

<%-- Script : permet l'affichage des alertes de validation d'action --%>
<aui:script>
	function <portlet:namespace />deleteEntity() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry" />')) {
			window.location = '${deletePetitionURL}';
		}
	}
</aui:script>