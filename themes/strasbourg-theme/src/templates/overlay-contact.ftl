<#--Il faut ajouter le variable avant de l'appeler dans le template:-->
<#--<@liferay_portlet.actionURL var="contactURL" name="contact">-->
<#--    <@liferay_portlet.param name="classPK" value="${entry.getPlaceId()}" />-->
<#--    <@liferay_portlet.param name="to" value="${entry.mail}" />-->
<#--    <@liferay_portlet.param name="title" value="${entry.getAlias(locale)}" />-->
<#--    <@liferay_portlet.param name="type" value="Place" />-->
<#--</@liferay_portlet.actionURL>-->
<#--<#assign overlayContactTitle=entry.getAlias(locale) />-->
<#--<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/overlay-contact.ftl" />-->
<#if themeDisplay.isSignedIn() >
    <@clay["alert"] message="Overlay de contact est present sur cette page"
    displayType="secondary"
    title="Overlay" />
</#if>
<div id="st-overlay-contact" class="st-overlay st-overlay-contact" role="dialog" aria-modal="true" tabindex="0" aria-label="Formulaire de contact">
    <button class="st-btn-close" data-overlay-close="st-overlay-contact" aria-label="Fermer"></button>

    <form  id="contactForm" action="${contactURL}#st-overlay-contact" name="contactForm" method="post" class="st-overlay__inner form-styles">
        <div class="st-overlay__body st-custom-scrollbar">

            <div class="st-overlay__heading">
                <h2  class="st-title-overlay st-h2">${overlayContactTitle}</h2>
                <span class="st-surtitre-cat"><@liferay_ui.message key="eu.contact" /></span>
            </div>
            <div class="st-grid-fields st-grid-12">
                <@strasbourg.alertError key="all-fields-required" message="eu.all-fields-required" />
                <@strasbourg.alertError key="invalid-mail" message="eu.invalid-mail" />
                <@strasbourg.alertError key="recaptcha-error" message="eu.recaptcha-error" />
                <@strasbourg.alertInfo key="mail-success-with-copy" message="eu.form-success-with-copy" />
                <@strasbourg.alertInfo key="mail-success" message="eu.form-success" />


                <#if renderRequest.getAttribute("mailSent")?? == false>
                    <p class="st-text-mandatory"><@liferay_ui.message key="eu.required-field-star" /></p>

                    <div class="st-group-field">
                        <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName"><@liferay_ui.message key="contact.lastname" /> <span class="st-field-required">*</span></label>
                        <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName" aria-required="true" type="text" autocomplete="family-name" placeholder="<@liferay_ui.message key="contact.your-lastname" />" value="${renderRequest.getAttribute("lastName")!""}"/>
                    </div>

                    <div class="st-group-field">
                        <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName"><@liferay_ui.message key="contact.firstname" /> <span class="st-field-required">*</span></label>
                        <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName" aria-required="true" type="text" autocomplete="given-name" placeholder="<@liferay_ui.message key="contact.your-firstname" />" value="${renderRequest.getAttribute("firstName")!""}"/>
                    </div>

                    <div class="st-group-field st--has-error">
                        <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email"><@liferay_ui.message key="contact.mail" /> <span class="st-field-required">*</span></label>
                        <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email" aria-required="true" type="text" autocomplete="email" placeholder="<@liferay_ui.message key="contact.your-mail" />" value="${renderRequest.getAttribute("email")!""}"/>
                    </div>

                    <div class="st-group-field">
                        <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message"><@liferay_ui.message key="contact.request" /> <span class="st-field-required">*</span></label>
                        <textarea id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message" name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message" rows="5" placeholder="<@liferay_ui.message key="contact.your-message" />">${renderRequest.getAttribute("message")!""}</textarea>
                    </div>

                    <div class="st-group-field">
                        <div class="st-group-radio">
                            <label for="checkbox-_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_notificationEmail"  class="st-field-checkbox">
                                <input checked type="checkbox" name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_notificationEmail" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_notificationEmail" />
                                <@liferay_ui.message key="eu.do-you-want-a-notification" />
                            </label>
                        </div>
                    </div>

                    <div>
                        <div id="recaptcha-contact" class="g-recaptcha" data-sitekey="${propsUtil.get('eu.strasbourg.recaptcha.public')}"></div>
                    </div>


                    <div class="st-text-mentions">
                        <h3 class="st-title-mentions"> <@liferay_ui.message key="contact.mention" /></h3>

                        <@liferay_ui.message key="contact.default-privacy" />
                    </div>
                </#if>



            </div>
        </div>

        <div class="st-overlay__footer">
            <#if renderRequest.getAttribute("mailSent")?? == false>
            <button class="st-btn st--btn-full-width" name="submit" value="<@liferay_ui.message key="send" />"><@liferay_ui.message key="send" /></button>
            </#if>
        </div>

    </form>

</div>