<%@ include file="/contact-form-init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true"
	var="configurationRenderURL" />

<aui:form action="${configurationActionURL}" method="post" name="fm">
    <aui:input name="cmd" type="hidden"
        value="update" />

    <aui:input name="redirect" type="hidden"
        value="${configurationRenderURL}" />

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">
            <aui:fieldset-group markupView="lexicon">

                <aui:fieldset id="general" label="general">

                    <!-- Affichage -->
                    <aui:select name="template" label="display">
                        <aui:option value="generic" label="generic" />
                        <aui:option value="default" label="strasbourg" selected="${template eq 'default'}"/>
                        <aui:option value="christmas" label="christmas" selected="${template eq 'christmas'}"/>
                        <aui:option value="tipi" label="tipi" selected="${template eq 'tipi'}"/>
                        <aui:option value="placit" label="placit" selected="${template eq 'placit'}"/>
                        <aui:option value="help" label="help" selected="${template eq 'help'}"/>
                    </aui:select>

                    <!-- Titre -->
                    <aui:input required="true" type="text" name="title" value="${title}" label="form-name" localized="true"/>

                    <!-- Email -->
                    <aui:input required="true" type="text" name="email" value="${email}" label="email" />

                    <!-- Texte de description -->
                    <aui:input name="descriptionText" value="${descriptionText}" localized="true" type="editor" label="description-text" />

                    <!-- Texte "confidentialitÃ©" -->
                    <aui:input name="privacyText" value="${privacyText}" localized="true" type="editor" label="privacy-text" />
                </aui:fieldset>

            </aui:fieldset-group>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>