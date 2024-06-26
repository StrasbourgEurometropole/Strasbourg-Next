<%@ include file="/felec-init.jsp" %>

<%-- Action URL du formulaire --%>
<portlet:actionURL var="searchURL" />
<header class="st-small-header st-header-recherche-defunt st-wrapper st-wrapper-small">
    <h2 class="st-h2"><liferay-ui:message key="eu.felec.find.vote"/></h2>
</header>

<div class="st-wrapper st-wrapper-small st-form-defunt">
    <aui:form name="fm" action="${searchURL}" cssClass="form-styles">
        <div class="st-grid-fields st-grid-12">

            <c:if test="${dc.hasError()}">
                <p><liferay-ui:message key="form-has-error" /></p>
                <ul class="st-alert-form st--has-error my-2">
                        ${dc.getAlertError("name-required", "name-required", "name")}
                        ${dc.getAlertError("first-name-required", "first-name-required", "firstname")}
                        ${dc.getAlertError("birthplace-required", "birthplace-required", "birthplace")}
                        ${dc.getAlertError("birthdate-required", "birthdate-required", "birthdate")}
                        ${dc.getAlertError("invalid-character-in-name", "invalid-character-in-name", "name")}
                        ${dc.getAlertError("invalid-character-in-first-name", "invalid-character-in-first-name", "firstname")}
                        ${dc.getAlertError("invalid-character-in-birthplace", "invalid-character-in-birthplace", "birthplace")}
                        ${dc.getAlertError("date-not-valid", "date-not-valid", "birthdate")}
                </ul>
            </c:if>

            <p class="st-text-mandatory">Tous les champs sont obligatoires</p>

            <div class="st-group-field st-col-6@t-small">
                <label for="name"><liferay-ui:message key="felec.name" /> <span class="st-field-required">*</span></label>
                <input id="name" name="<portlet:namespace />name" type="text" value="${param.name}" placeholder="<liferay-ui:message key="felec.name" />" autocomplete="family-name" aria-required="true">
            </div>

            <div class="st-group-field st-col-6@t-small">
                <label for="firstname"><liferay-ui:message key="felec.firstname" /> <span class="st-field-required">*</span></label>
                <input id="firstname" name="<portlet:namespace />firstname" type="text" value="${param.firstname}" placeholder="<liferay-ui:message key="felec.firstname" />" autocomplete="given-name" aria-required="true">
            </div>

            <div class="st-group-field st-col-6@t-small">
                <label for="birthdate"><liferay-ui:message key="felec.birthdate" /> <span class="st-field-required">*</span></label>
                <div class="st-field-date">
                    <input id="birthdate" name="<portlet:namespace />birthdate" type="date" autocomplete="bday" value="${param.birthdate}" aria-required="true">
                </div>
            </div>

            <div class="st-group-field st-col-6@t-small">
                <label for="birthplace"><liferay-ui:message key="felec.birthplace" /> <span class="st-field-required">*</span></label>
                <input id="birthplace" name="<portlet:namespace />birthplace"  type="text" value="${param.birthplace}" placeholder="<liferay-ui:message key="felec.birthplace" />"  autocomplete="address-level2" aria-required="true">
            </div>

            <div class="st-col-6@t-small">
                <liferay-portlet:renderURL var="cancelURL" />
                <a class="st-btn st--btn-full-width-mobile" href="${cancelURL}"><liferay-ui:message key="cancel" /></a>
            </div>

            <div class="st-col-6@t-small st-btn-submit-wrapper">
                <button class="st-btn st--btn-full-width-mobile" type="submit"><liferay-ui:message key="search" /></button>
            </div>
        </div>

    </aui:form>

</div>
<div class="st-wrapper st-bloc-resume">
    <div>


        <!-- Résultats -->
        <c:if test="${not empty felecResponse}">
            <div class="st-card-defunt">
                <c:if test="${felecResponse.responseCode eq 0 or felecResponse.responseCode eq 1 or felecResponse.responseCode eq 4}">
                    <!-- Electeur inconnu ou radiation en cours -->
                    <h2 class="st-h2 st-title">Nous n'avons pas trouv&eacute; d'&eacute;lecteur pour les crit&egrave;res suivants</h2>
                    <div class="st-caption">
                        <div class="st-col">
                            <p class="st-title-small">${firstname} ${name}, n&eacute;(e) le ${birthdate} &agrave; ${birthplace}</p>
                        </div>
                        <div class="st-col st-text-styles">
                            <p>
                                <a href="https://www.service-public.fr/particuliers/vosdroits/R16396" target="_blank" title="Inscrivez-vous en ligne (nouvelle fen&ecirc;tre)">
                                    Inscrivez-vous en ligne en moins de 10 minutes
                                </a> (une photographie de bonne qualit&eacute; de chaque pi&egrave;ce justificative est accept&eacute;e).
                            </p>
                            <p>

                                <a href="https://www.service-public.fr/particuliers/vosdroits/N47" target="_blank" title="Consultez votre situation &eacute;lectorale (nouvelle fen&ecirc;tre)">
                                    Consultez votre situation &eacute;lectorale sur le site www.service-public.fr
                                </a>
                            </p>
                        </div>
                    </div>

                </c:if>
                <c:if test="${felecResponse.responseCode eq 2}">
                    <!-- Electeur connu -->
                    <h2 class="st-h3 st-title">Vous &ecirc;tes bien inscrit sur la liste &eacute;lectorale "${felecResponse.list}" de la Ville de Strasbourg</h2>
                    <div class="st-caption">
                        <div class="st-col">
                            <p class="st-title-small">Bureau de vote ${felecResponse.stationNumber}</p>
                            <p>
                                    ${felecResponse.stationLabel}<br>
                                    ${felecResponse.address1}<br>
                                <c:if test="${not empty felecResponse.address2}"> ${felecResponse.address2}<br></c:if>
                                    ${felecResponse.address3}
                            </p>
                        </div>
                        <div class="st-col st-text-styles">
                            <p>
                                <c:if test="${felecResponse.codeList.equals('E')}">
                                    Remarque : vous ne pouvez voter qu'aux &eacute;lections europ&eacute;ennes.
                                </c:if>
                                <c:if test="${felecResponse.codeList.equals('M')}">
                                    Remarque : vous ne pouvez voter qu'aux &eacute;lections municipales.
                                </c:if>
                                <c:if test="${felecResponse.codeList.equals('C')}">
                                    Remarque : vous ne pouvez voter qu'aux &eacute;lections  municipales <strong>et</strong> europ&eacute;enne.
                                </c:if>
                            </p>
                            <c:if test="${not empty felecResponse.center}">
                                <p>
                                    <strong>ATTENTION</strong>: vous &ecirc;tes inscrit dans le centre de vote suivant : ${felecResponse.centerCountry} - ${felecResponse.center}
                                </p>
                                <p>
                                    <i>Pour les &eacute;lections Pr&eacute;sidentielle, L&eacute;gislatives, R&eacute;f&eacute;rendum national et Europ&eacute;ennes, vous devrez obligatoirement voter dans votre centre de vote.</i>
                                </p>
                            </c:if>
                        </div>
                    </div>
                </c:if>
                <c:if test="${felecResponse.responseCode eq 3}">
                    <!-- Modification en cours -->
                    <h2 class="st-h2 st-title">Une modification de votre inscription est en cours</h2>
                    <div class="st-text-styles">
                        <p>
                            Merci de prendre contact avec le bureau des &eacute;lections au 03.68.98.68.94.
                        </p>
                    </div>
                </c:if>
                <!-- responseCode = 4 pris en compte avec le responseCode = 1 ou 0 -->
                <c:if test="${felecResponse.responseCode eq 5}">
                    <!-- Inscription en cours -->
                    <div class="main-response">
                        <h2 class="st-h2 st-title">Votre inscription est en cours</h2>
                        <div class="st-text-styles">
                            <p>
                                Pour plus d'information vous pouvez prendre contact avec le bureau des &eacute;lections au 03.68.98.68.94.
                            </p>
                        </div>

                    </div>
                </c:if>
                <c:if test="${felecResponse.responseCode eq 9}">
                    <!-- Requête trop vague -->
                    <div class="main-response">
                        <h2 class="st-h2 st-title">La recherche ne peut aboutir</h2>
                        <div class="st-text-styles">
                            <p>
                                Vous pouvez prendre contact avec le bureau des &eacute;lections au 03.68.98.68.94.
                            </p>
                        </div>


                    </div>
                </c:if>
            </div>
        </c:if>


        <liferay-portlet:runtime
                portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
                instanceId="felec" />

    </div>
</div>
