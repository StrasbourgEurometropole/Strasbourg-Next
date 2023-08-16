
<div id="st-overlay-contact" class="st-overlay st-overlay-contact" role="dialog" aria-modal="true" tabindex="0" aria-label="Modale de contact">
    <button class="st-btn-close" data-overlay-close="st-overlay-contact" aria-label="Fermer la modale"></button>
    <@liferay_portlet.actionURL var="contactURL" name="contact">
        <@liferay_portlet.param name="classPK" value="${entry.getPlaceId()}" />
        <@liferay_portlet.param name="to" value="${entry.mail}" />
        <@liferay_portlet.param name="title" value="${entry.getAlias(locale)}" />
        <@liferay_portlet.param name="type" value="Place" />
    </@liferay_portlet.actionURL>

    <form  id="contactForm" action="${contactURL}#st-overlay-contact" name="contactForm" method="post" class="st-overlay__inner form-styles">
        <div class="st-overlay__body st-custom-scrollbar">

            <div class="st-overlay__heading">
                <span class="st-title-overlay">Piscine d’Ostwald</span>
                <span class="st-surtitre-cat"><@liferay_ui.message key="eu.contact" /></span>
            </div>



            <div class="st-grid-fields st-grid-12">
                <p class="st-text-mandatory">Les champs marqués par * sont obligatoires</p>

                <@liferay_ui.error key="all-fields-required" message="eu.all-fields-required" targetNode="#contactForm" />
                <@liferay_ui.error key="invalid-mail" message="eu.invalid-mail" targetNode="#contactForm" />
                <@liferay_ui.error key="recaptcha-error" message="eu.recaptcha-error" targetNode="#contactForm" />

                <div class="st-group-field">
                    <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName"><@liferay_ui.message key="contact.lastname" /> <span class="st-field-required" aria-hidden="true">*</span></label>
                    <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName" aria-required="true" type="text" placeholder="<@liferay_ui.message key="contact.your-lastname" />" value="${renderRequest.getAttribute("lastName")!""}"/>
                </div>

                <div class="st-group-field">
                    <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName"><@liferay_ui.message key="contact.firstname" /> <span class="st-field-required" aria-hidden="true">*</span></label>
                    <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName" aria-required="true" type="text" placeholder="<@liferay_ui.message key="contact.your-firstname" />" value="${renderRequest.getAttribute("firstName")!""}"/>
                </div>

                <div class="st-group-field st--has-error">
                    <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email"><@liferay_ui.message key="contact.mail" /> <span class="st-field-required" aria-hidden="true">*</span></label>
                    <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email" aria-required="true" type="text" placeholder="<@liferay_ui.message key="contact.your-mail" />" value="${renderRequest.getAttribute("email")!""}"/>
                </div>

                <div class="st-group-field">
                    <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message"><@liferay_ui.message key="contact.request" /> <span class="st-field-required" aria-hidden="true">*</span></label>
                    <textarea id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message" name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message" rows="5" placeholder="<@liferay_ui.message key="contact.your-message" />">${renderRequest.getAttribute("message")!""}</textarea>
                </div>

                <div class="st-group-field">
                    <div class="st-group-radio">
                        <label class="st-field-checkbox">
                            <input type="checkbox" name="group-checkbox" />
                            Je souhaites un e-mail de confirmation de l’envoi
                        </label>
                    </div>
                </div>

                <div class="st-text-mentions">
                    <p class="st-title-mentions">Mentions d’information</p>

                    <p>(Article L114-8 Code des relations entre le public et l’administration)</p>

                    <p>La Ville et l’Eurométropole de Strasbourg, 1 parc de l’étoile, 67076 Strasbourg Cedex, traitent vos données à caractère personnel
                        collectées via ce formulaire de contact dans le but de répondre à votre demande.</p>

                    <p>Ce traitement est réalisé par l’envoi d’une réponse immédiate ou le transfert de votre demande vers le service de la collectivité
                        concerné. Les données collectées dans le cadre de ce traitement sont de type « données d’identification » uniquement. Les destinataires
                        des données sont les Directions et/ou les services de la Ville et l’Eurométropole de Strasbourg concernés par la demande. Vos données
                        sont stockées dans notre outil de création de formulaires et seront supprimées dans les trois mois suivant le traitement de votre
                        demande. Les données sont également conservées dans notre système de messagerie interne pendant toute la durée de traitement de votre
                        demande et sont supprimées immédiatement après qu’une réponse vous ait été envoyée.</p>

                    <p>Conformément au Règlement (UE) 2016/679 du Parlement Européen et du Conseil du 27 avril 2016, règlement général sur la protection des
                        données (RGPD) et à la Loi n°78-17 du 6 janvier 1978, loi informatique et libertés (LIL), modifiée, vous avez un droit d’accès, de
                        rectification, d’effacement, d’opposition, de limitation du traitement et de portabilité des données que vous pouvez exercer en vous
                        adressant à la Délégation à la Protection des Données, Ville et Eurométropole de Strasbourg, 1 parc de l’étoile, 67076 Strasbourg Cedex
                        ou par courriel à <a href="mailto:dpo@strasbourg.eu">dpo@strasbourg.eu</a> ou <a href="#">via le formulaire dédié</a>.</p>

                    <p>Si vous estimez, après nous avoir contactés, que vos droits "Informatique et Libertés" ne sont pas respectés, vous pouvez adresser une
                        réclamation à la <a href="#">Commission Nationale de l’Informatique et des Libertés (CNIL)</a>.</p>
                </div>

            </div>
        </div>

        <div class="st-overlay__footer">
            <button class="st-btn st--btn-full-width" name="submit" value="<@liferay_ui.message key="send" />"><@liferay_ui.message key="send" /></button>
        </div>

    </form>

</div>