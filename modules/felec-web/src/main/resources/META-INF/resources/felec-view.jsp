<%@ include file="/felec-init.jsp" %>

<%-- Action URL du formulaire --%>
<portlet:actionURL var="searchURL" />

<div class="seu-container felec-web">
	
	<aui:form name="fm" action="${searchURL}" cssClass="seu-view-filters">
		<div class="seu-filter-line">
			<!-- Nom -->
			<div class="widget">
				<div class="title">
					<label for="name"><liferay-ui:message key="felec.name" /></label>
				</div>
				<div class="content">
					<input type="text" id="name" name="<portlet:namespace />name" 
						placeholder="<liferay-ui:message key="felec.name" />" value="${param.name}">
				</div>
			</div>

			<!-- Prénom -->
			<div class="widget">
				<div class="title">
					<label for="firstname"><liferay-ui:message key="felec.firstname" /></label>
				</div>
				<div class="content">
					<input type="text" id="firstname" name="<portlet:namespace />firstname" 
						placeholder="<liferay-ui:message key="felec.firstname" />" value="${param.firstname}">
				</div>
			</div>

			<!-- Date de naissance -->
			<div class="widget">
				<div class="title">
					<label for="birthdate"><liferay-ui:message key="felec.birthdate" /></label>
				</div>
				<div class="content">
					<input name="<portlet:namespace />birthdate" data-type="date" type="text" id="birthdate" placeholder="JJ/MM/AAAA" 
						value="${param.birthdate}">
				</div>
			</div>

			<!-- Lieu de naissance -->
			<div class="widget">
				<div class="title">
					<label for="birthplace"><liferay-ui:message key="felec.birthplace" /></label>
				</div>
				<div class="content">
					<input type="text" id="birthplace" name="<portlet:namespace />birthplace" 
						placeholder="<liferay-ui:message key="felec.birthplace" />" value="${param.birthplace}">
				</div>
			</div>
		</div>
		<span style="color: #fff;">Tous les champs sont obligatoires</span>
		<div class="seu-btn-line">
			<liferay-portlet:renderURL var="cancelURL" />
			<button type="button" onclick="window.location.href = '${cancelURL}'" class="seu-btn-square seu-bordered seu-core"> 
				<span class="seu-flexbox">            
					<span class="seu-btn-text" style="margin-right: 0"><liferay-ui:message key="cancel" /></span>
				</span>
			</button>

			<button type="submit" class="seu-btn-square seu-filled seu-core">
				<span class="seu-flexbox">
					<span class="seu-btn-text"><liferay-ui:message key="search" /></span>
					<span class="seu-btn-arrow"></span>
				</span>
			</button>
		</div>
	</aui:form>

	<!-- Messages d'erreur -->
	<liferay-ui:error key="all-fields-required" message="all-fields-required" targetNode=".seu-error-messages" />
	<liferay-ui:error key="date-not-valid" message="date-not-valid" targetNode=".seu-error-messages" />
	<liferay-ui:error key="invalid-characters" message="invalid-characters" targetNode=".seu-error-messages" />

	<div class="seu-error-messages"></div>

	<!-- Résultats -->
	<c:if test="${not empty felecResponse}">
		<div class="felec-response rte">
			<c:if test="${felecResponse.responseCode eq 0 or felecResponse.responseCode eq 1 or felecResponse.responseCode eq 4}">
				<!-- Electeur inconnu ou radiation en cours -->
				<div class="main-response">
					Nous n'avons pas trouv&eacute; d'&eacute;lecteur pour les crit&egrave;res suivants
				</div>
				<div>
					<strong>${firstname} ${name}, n&eacute;(e) le ${birthdate} &agrave; ${birthplace}.</strong>
				</div>
				<div>
					<a href="https://www.service-public.fr/particuliers/vosdroits/R16396" target="_blank" title="Inscrivez-vous en ligne (nouvelle fen&ecirc;tre)">
					    Inscrivez-vous en ligne en moins de 10 minutes
                    </a>
                    (une photographie de bonne qualit&eacute; de chaque pi&egrave;ce justificative est accept&eacute;e).
					<br><br>
					<a href="https://www.service-public.fr/particuliers/vosdroits/N47" target="_blank" title="Consultez votre situation &eacute;lectorale (nouvelle fen&ecirc;tre)">
					    Consultez votre situation &eacute;lectorale sur le site www.service-public.fr
                    </a>
				</div>
			</c:if>
			<c:if test="${felecResponse.responseCode eq 2}">
				<!-- Electeur connu -->
				<div class="main-response">
				    Vous &ecirc;tes bien inscrit sur la liste &eacute;lectorale "${felecResponse.list}" de la Ville de Strasbourg
                </div>
				<div class="poll-address">
					<div class="poll-number">Bureau de vote ${felecResponse.stationNumber}</div>
					<div>
						${felecResponse.stationLabel}<br>
						${felecResponse.address1}<br>
						<c:if test="${not empty felecResponse.address2}">${felecResponse.address2}<br></c:if>
						${felecResponse.address3}
					</div>
				</div>
                <div>
                    <c:if test="${felecResponse.codeList.equals('E')}">
                        Remarque : vous ne pouvez voter qu'aux &eacute;lections europ&eacute;ennes.
                    </c:if>
                    <c:if test="${felecResponse.codeList.equals('M')}">
                        Remarque : vous ne pouvez voter qu'aux &eacute;lections municipales.
                    </c:if>
                    <c:if test="${felecResponse.codeList.equals('C')}">
                        Remarque : vous ne pouvez voter qu'aux &eacute;lections  municipales <strong>et</strong> europ&eacute;enne.
                    </c:if>
                </div>
				<c:if test="${not empty felecResponse.center}">
					<div class="warning">
						ATTENTION, vous &ecirc;tes inscrit dans le centre de vote suivant : ${felecResponse.centerCountry} - ${felecResponse.center}
						<br>
						Pour les &eacute;lections Pr&eacute;sidentielle, L&eacute;gislatives, R&eacute;f&eacute;rendum national et Europ&eacute;ennes, vous devrez obligatoirement voter dans votre centre de vote.
					</div>
				</c:if>
			</c:if>
			<c:if test="${felecResponse.responseCode eq 3}">
				<!-- Modification en cours -->
				<div class="main-response">
					Une modification de votre inscription est en cours, merci de prendre contact avec le bureau des &eacute;lections au 03.68.98.68.94.
				</div>
			</c:if>
			<!-- responseCode = 4 pris en compte avec le responseCode = 1 ou 0 -->
			<c:if test="${felecResponse.responseCode eq 5}">
				<!-- Inscription en cours -->
				<div class="main-response">
					Votre inscription est en cours, pour plus d'information vous pouvez prendre contact avec le bureau des &eacute;lections au 03.68.98.68.94.
				</div>
			</c:if>
			<c:if test="${felecResponse.responseCode eq 9}">
				<!-- Requête trop vague -->
				<div class="main-response">
					La recherche ne peut aboutir, vous pouvez prendre contact avec le bureau des &eacute;lections au 03.68.98.68.94.
				</div>
			</c:if>
		</div>
	</c:if>


	<liferay-portlet:runtime
		portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
		instanceId="felec" />

</div>