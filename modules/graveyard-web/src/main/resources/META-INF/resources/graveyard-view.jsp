<%@ include file="/graveyard-init.jsp" %>
<fmt:setLocale value="${locale}" />
<c:set var="virtualHostName" value="${virtualHostName}"/>
<c:if test="${empty virtualHostName}">
    <c:set var="homeURL" value="/web/strasbourg.eu/"/>
</c:if>
<c:if test="${not empty virtualHostName}">
    <c:set var="homeURL" value="https://${virtualHostName}/"/>
</c:if>

<liferay-portlet:renderURL varImpl="rechercheURL" />

<%-- Action URL du formulaire --%>
<section id="graveyard">
	<div class="seu-container graveyard-web">
	
		<!-- Messages d'erreur géré en backOffice -->	
		<c:if test="${not empty error}">
			<div class="seu-error-messages">${error}</div>
		</c:if>

		<!-- Résultats -->
        <c:if test="${empty error and not empty dc and not empty dc.graveyard}">
            <div id="result">
                <!-- Messages d'erreur au niveau du lien -->
                <c:if test="${dc.graveyard.err eq 1}">
                    <div class="seu-error-messages">${dc.graveyard.err_desc}</div>
                </c:if>
                <c:if test="${dc.graveyard.err eq 0}">
                    <!-- Messages d'erreur géré par l'api -->
                    <c:if test="${not empty dc.graveyard.erreur}">
                        <div class="seu-error-messages">
                            <c:if test="${dc.graveyard.codeErreur == 'LIMITE_DEPASSEE'}">
                                <liferay-ui:message key="too-many-results" />
                                <a href="${dc.contactURL}" target="_blank" title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
                                    <liferay-ui:message key="graveyard.contact" />
                                </a>
                            </c:if>
                            <c:if test="${dc.graveyard.codeErreur != 'LIMITE_DEPASSEE'}">
                                ${dc.graveyard.erreur}
                            </c:if>
                        </div>
                    </c:if>
                    <c:if test="${empty dc.graveyard.erreur}">
                        <div class="graveyard-response rte">
                            <p>
                                <c:choose>
                                    <c:when test="${dc.graveyard.count == '0'}">
                                        <liferay-ui:message key="no-tot" />
                                        <a href="${dc.contactURL}" target="_blank" title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
                                            <liferay-ui:message key="graveyard.contact" />
                                        </a>
                                    </c:when>
                                    <c:when test="${dc.graveyard.count == '1'}">
                                        ${dc.searchContainer.total} <liferay-ui:message key="graveyard.result" />
                                    </c:when>
                                    <c:otherwise>
                                        ${dc.searchContainer.total} <liferay-ui:message key="graveyard.results" />
                                    </c:otherwise>
                                </c:choose>
                            </p>

                            <c:if test="${dc.searchContainer.total gt 0}">
                                <!-- Liste des résultats -->
                                <aui:form method="post" name="fm">
                                    <liferay-ui:search-container id="entriesSearchContainer"
                                                searchContainer="${dc.searchContainer}">
                                        <c:forEach items="${dc.paginatedResults}" var="tot">
                                            <div class="tot">
                                                <span class="name">
                                                    ${tot.firstName} ${tot.name}
                                                    <c:if test="${tot.birthName != ''}">
                                                        (<liferay-ui:message key="graveyard.birthname" arguments=""/> ${tot.birthName})
                                                    </c:if>
                                                </span>

                                                <div class="webform-layout-box">
                                                    <div class="form-group left">
                                                        <!-- Date de naissance -->
                                                        <div class="form-label"><label><liferay-ui:message key="graveyard.birthdate" /></label></div>
                                                        <div class="form-field">
                                                            <c:if test="${tot.birthDate == ''}">
                                                                <liferay-ui:message key="unknown" />
                                                            </c:if>
                                                            <c:if test="${tot.birthDate != ''}">
                                                                ${tot.birthDate}
                                                            </c:if>
                                                        </div>
                                                        <!-- Date du dÃÂ©cÃÂ¨s -->
                                                        <div class="form-label"><label><liferay-ui:message key="graveyard.deathdate" /></label></div>
                                                        <div class="form-field">
                                                            <c:if test="${tot.deathDate == ''}">
                                                                <liferay-ui:message key="unknown" />
                                                            </c:if>
                                                            <c:if test="${tot.deathDate != ''}">
                                                                ${tot.deathDate}
                                                            </c:if>
                                                        </div>
                                                        <!-- Ville du dÃÂ©cÃÂ¨s -->
                                                        <div class="form-label"><label><liferay-ui:message key="graveyard.deathplace" /></label></div>
                                                        <div class="form-field">
                                                            <c:if test="${tot.deathPlace == ''}">
                                                                <liferay-ui:message key="unknown" />
                                                            </c:if>
                                                            <c:if test="${tot.deathPlace != ''}">
                                                                ${tot.deathPlace}
                                                            </c:if>
                                                        </div>
                                                    </div>

                                                    <!-- Localisation de la concession -->
                                                    <div class="form-group">
                                                        <div class="form-label">
                                                            <a href="${homeURL}lieu/-/entity/sig/${tot.graveyardMapping.sigId}/${dc.getNormalizedForURL(tot.graveyardMapping.name)}" target="_blank" title="${tot.graveyardMapping.name} (<liferay-ui:message key="eu.new-window" />)">${tot.graveyardMapping.name}</a>
                                                        </div>
                                                        <div class="form-field"><liferay-ui:message key="graveyard.gravesector" /> : ${tot.graveSector}</div>
                                                        <div class="form-field"><liferay-ui:message key="graveyard.graverow" /> : ${tot.graveRow}</div>
                                                        <div class="form-field"><liferay-ui:message key="graveyard.gravenumber" /> : ${tot.graveNumber}</div>
                                                    </div>
                                                </div>
                                                <div align="right">
                                                    <a href="/o/graveyardweb/images/${tot.graveyardMapping.sigId}.jpg" class="seu-btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="graveyard.downloadPlan" /> (<liferay-ui:message key="eu.new-window" />)">
                                                        <span class="seu-flexbox">
                                                            <span class="seu-btn-text"><liferay-ui:message key="graveyard.downloadPlan" /></span>
                                                            <span class="seu-btn-arrow"></span>
                                                        </span>
                                                    </a>
                                                </div>
                                            </div>
                                        </c:forEach>

                                        <!-- Pagination -->
                                        <c:if test="${dc.pager.lastPage > 1}">
                                            <ul class="seu-pagination unstyled">
                                                <!-- Page précédente -->
                                                <li class="seu-pagin-prev seu-pagin-item">
                                                    <c:if test="${not dc.pager.onFirstPage}">
                                                        <a class="seu-btn-square seu-bordered seu-core" data-action="prev" title="<liferay-ui:message key="go-to-previous-page" />"
                                                            href="${dc.getURLForPage(dc.pager.currentPage - 1)}">
                                                            <span class="seu-flexbox">
                                                                <span class="seu-btn-text"><liferay-ui:message key="previous" /></span>
                                                                <span class="seu-btn-arrow"></span>
                                                            </span>
                                                        </a>
                                                    </c:if>
                                                </li>
                                                <c:forEach var="page" items="${dc.pager.pages}">
                                                    <c:choose>
                                                        <c:when test="${page.isALink() and not (page.index eq dc.pager.currentPage)}">
                                                            <!-- Lien vers page -->
                                                            <li class="seu-pagin-item">
                                                                <a data-page="${page.index}" href="${dc.getURLForPage(page.index)}">
                                                                    <span class="seu-flexbox">
                                                                        <span class="seu-btn-text">${page.label}</span>
                                                                    </span>
                                                                </a>
                                                            </li>
                                                        </c:when>
                                                        <c:when test="${page.isALink() and (page.index eq dc.pager.currentPage)}">
                                                            <!-- Page en cours -->
                                                            <li class="seu-pagin-item seu-is-active">
                                                                <span class="seu-flexbox">
                                                                    <span class="seu-btn-text">${page.label}</span>
                                                                </span>
                                                            </li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <!-- Texte -->
                                                            <li class="seu-pagin-item">
                                                                <span class="seu-flexbox">
                                                                    <span class="seu-btn-text">${page.label}</span>
                                                                </span>
                                                            </li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>

                                                <!-- Page suivante -->
                                                <li class="seu-pagin-next seu-pagin-item">
                                                    <c:if test="${not dc.pager.onLastPage}">
                                                        <a class="seu-btn-square seu-bordered seu-core" title="<liferay-ui:message key="go-to-next-page" />"
                                                            data-action="next" href="${dc.getURLForPage(dc.pager.currentPage + 1)}">
                                                            <span class="seu-flexbox">
                                                                <span class="seu-btn-text"><liferay-ui:message key="next" /></span>
                                                                <span class="seu-btn-arrow"></span>
                                                            </span>
                                                        </a>
                                                    </c:if>
                                                </li>
                                            </ul>
                                        </c:if>
                                    </liferay-ui:search-container>
                                </aui:form>
                            </c:if>
                            <div>
                                <liferay-ui:message key="before-98" />
                                <a href="${dc.contactURL}" target="_blank" title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
                                    <liferay-ui:message key="graveyard.contact" />
                                </a>
                            </div>
                        </div>
                    </c:if>
                </c:if>
            </div>
        </c:if>
	</div>
</section>



<div class="st-wrapper st-wrapper-small st-form-defunt">
<aui:form name="fm" action="${rechercheURL}" class="generic-form toValidate">
        <div class="st-grid-fields st-grid-12">

            <!-- Messages d'erreur géré en backOffice -->
            <c:if test="${not empty error}">
                <div class="st-alert-form st--has-error">
                    <p class="st-alert-form__content">
                        ${error}
                    </p>
                </div>
            </c:if>

            <p class="st-text-mandatory">Les champs marqués par * sont obligatoires</p>

            <div class="st-group-field st-col-6@t-small">
                <label for="name"><liferay-ui:message key="graveyard.name" /><strong style="color:red">*</strong></label>
                <input type="text" id="name" name="<portlet:namespace />name"
                       value="${name}">
            </div>

            <div class="st-group-field st-col-6@t-small">
                <label for="firstname"><liferay-ui:message key="graveyard.firstname" /></label>
                <input type="text" id="firstname" name="<portlet:namespace />firstname"
                       value="${firstname}">
            </div>


            <div class="st-group-field st-col-6@t-small">
                <label for="birthdate"><liferay-ui:message key="graveyard.birthdate" /></label>
                <div class="st-field-date">
                    <input name="<portlet:namespace />birthdate" data-type="date" type="text" id="birthdate" placeholder="JJ/MM/AAAA"
                           value="${birthdate}" <c:if test="${birthdateunknown}">disabled="disabled"</c:if>>
                </div>

                <label for="birthdateunknown">
                    <input type="checkbox" id="birthdateunknown" name="<portlet:namespace />birthdateunknown" <c:if test="${birthdateunknown }">checked</c:if> />
                    <span><span><liferay-ui:message key="graveyard.birthdateunknown" /></span></span>
                </label>
                <div id="birthRange" <c:if test="${!birthdateunknown }">style="display: none;"</c:if>>
                <label for="birthdatestart"><liferay-ui:message key="graveyard.birthrange" /></label>
                <div class="st-grid-fields st-grid-12">
                <div class="st-field-date st-col-5">
                    <input name="<portlet:namespace />birthdatestart" data-type="date" type="text" id="birthdatestart" placeholder="JJ/MM/AAAA"
                           value="${birthdatestart}">
                </div>
                <div class="st-field-date st-col-5">
                    <input name="<portlet:namespace />birthdateend" data-type="date" type="text" id="birthdateend" placeholder="JJ/MM/AAAA"
                           value="${birthdateend}">
                </div>
                </div>
                </div>
            </div>


            <div class="st-group-field st-col-6@t-small">
                <label for="deathDate"><liferay-ui:message key="graveyard.deathDate" /></label>
                <div class="st-field-date">
                    <input name="<portlet:namespace />deathDate" data-type="date" type="text" id="deathDate" placeholder="JJ/MM/AAAA"
                           value="${deathDate}" <c:if test="${deathdateunknown}">disabled="disabled"</c:if>>
                </div>

                <label for="deathdateunknown">
                    <input type="checkbox" id="deathdateunknown" name="<portlet:namespace />deathdateunknown" <c:if test="${deathdateunknown }">checked</c:if> />
                    <span><span><liferay-ui:message key="graveyard.deathdateunknown" /></span></span>
                </label>
                <div id="deathRange" <c:if test="${!deathdateunknown }">style="display: none;"</c:if>>

                <label for="deathdatestart"><liferay-ui:message key="graveyard.deathrange" /></label>
                <div class="st-grid-fields st-grid-12">
                    <div class="st-field-date st-col-5">
                        <input name="<portlet:namespace />deathdatestart" data-type="date" type="text" id="deathdatestart" placeholder="JJ/MM/AAAA"
                               value="${deathdatestart}">
                    </div>
                    <div class="st-field-date st-col-5">
                        <input name="<portlet:namespace />deathdateend" data-type="date" type="text" id="deathdateend" placeholder="JJ/MM/AAAA"
                               value="${deathdateend}">
                    </div>
                </div>
                </div>
            </div>



            <div class="st-group-field st-col-6@t-small">
                <label for="deathplace"><liferay-ui:message key="graveyard.deathplace" /></label>
                <input type="text" id="deathplace" name="<portlet:namespace />deathplace"
                       value="${deathplace}">
            </div>

            <div class="st-group-field st-col-6@t-small">
                <label for="concession"><liferay-ui:message key="graveyard.concession" /></label>
                <div class="st-field-select">
                    <select id="concession" class="toCustomSelect silencedSelect" name="<portlet:namespace />concession">
                        <option value=""></option>
                        <c:forEach var="cimetiere" items="${dc.concessions}">
                            <option value="${cimetiere.id}" <c:if test="${concession eq cimetiere.id}">selected</c:if>>${cimetiere.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <input type="hidden" id="rechercher" name="<portlet:namespace />rechercher" value="lancer">
            <input type="hidden" id="delta" name="<portlet:namespace />delta" value="4">

            <div class="st-col-12@t-small st-btn-submit-wrapper">
                <button class="st-btn st--btn-full-width-mobile" type="submit"><liferay-ui:message key="search" /></button>
            </div>
        </div>

    </aui:form>

</div>

<!-- Résultats -->
<c:if test="${empty error and not empty dc and not empty dc.graveyard}">
<div class="st-listing-cards st-wrapper st-wrapper-small">
    <!-- Nombre de rÃ©sultats et items par page -->
    <div class="st-listing-results">
    <span class="st-results" role="status">
         ${dc.searchContainer.total} <liferay-ui:message key="results" />
    </span>

        <div class="st-results-filter">
            <label for="results-per-page"><liferay-ui:message key="results-per-page" /></label>
            <div class="st-results-select">
                <select id="results-per-page" name="results-per-page" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
                    <c:forEach var="delta" items="${[5, 10, 20, 50, 100]}">
                        <c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}" />
                        <option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <c:if test="${dc.searchContainer.total gt 0}">
        <!-- Liste des résultats -->
        <aui:form method="post" name="fm">
            <liferay-ui:search-container id="entriesSearchContainer"
                                         searchContainer="${dc.searchContainer}">
    <ul class="st-cards-defunts-wrapper st-basic-grid">
                <c:forEach items="${dc.paginatedResults}" var="tot">
                    <li>
                        <div class="st-card-defunt">
                            <h2 class="st-h2 st-title">${tot.firstName} ${tot.name}
                                <c:if test="${tot.birthName != ''}">
                                    (<liferay-ui:message key="graveyard.birthname" arguments="" /> ${tot.birthName})
                                </c:if>
                            </h2>

                            <div class="st-caption">
                                <div class="st-col">
                                    <p class="st-title-small"><liferay-ui:message key="graveyard.birthdate" /></p>
                                    <p class="st-surtitre-cat">
                                        <c:if test="${tot.birthDate == ''}">
                                            <liferay-ui:message key="unknown" />
                                        </c:if>
                                        <c:if test="${tot.birthDate != ''}">
                                            ${tot.birthDate}
                                        </c:if>
                                    </p>
                                    <p class="st-title-small"><liferay-ui:message key="graveyard.deathdate" /></p>
                                    <p class="st-surtitre-cat"><c:if test="${tot.deathDate == ''}">
                                        <liferay-ui:message key="unknown" />
                                    </c:if>
                                        <c:if test="${tot.deathDate != ''}">
                                            ${tot.deathDate}
                                        </c:if></p>
                                    <p class="st-title-small"><liferay-ui:message key="graveyard.deathplace" /></p>
                                    <p class="st-surtitre-cat">
                                        <c:if test="${tot.deathPlace == ''}">
                                        <liferay-ui:message key="unknown" />
                                    </c:if>
                                        <c:if test="${tot.deathPlace != ''}">
                                            ${tot.deathPlace}
                                        </c:if>
                                    </p>
                                </div>

                                <div class="st-col st-text-styles">
                                    <a href="${homeURL}lieu/-/entity/sig/${tot.graveyardMapping.sigId}/${dc.getNormalizedForURL(tot.graveyardMapping.name)}" class="st-title-small">${tot.graveyardMapping.name}</a>
                                    <p><liferay-ui:message key="graveyard.gravesector" /> : ${tot.graveSector}<br><liferay-ui:message key="graveyard.graverow" /> : ${tot.graveRow}<br><liferay-ui:message key="graveyard.gravenumber" /> : ${tot.graveNumber}</p>
                                </div>
                            </div>

                            <a href="/o/graveyardweb/images/${tot.graveyardMapping.sigId}.jpg" class="st-btn st--btn-secondary st--btn-secondary-ghost st--btn-small-padding st--btn-full-width-mobile"><liferay-ui:message key="graveyard.downloadPlan" /></a>
                        </div>
                    </li>


                </c:forEach>

        <!-- Pagination -->
        <c:if test="${dc.pager.lastPage > 1}">
            <nav class="st-wrapper st-wrapper-small st-pagination" role="navigation" aria-label="Pagination">
                <ul class="st-pagination__list">
                    <li class="st-pagination__item st--prev">
                        <a rel="prev" class="st-btn-arrow st--prev" aria-disabled="${dc.pager.currentPage == 0 ? 'true' : 'false'}">
                            <span class="st-sr-only"><liferay-ui:message key="eu.previous" /></span>
                        </a>
                    </li>


                    <!-- Note pour le cablage changer dynamiquement les numéros de page dans les aria-label. Aussi, l'aria-label pour l'élément actif doit être différent par rapport aux autres -->
                    <c:forEach var="page" items="${dc.pager.pages}">
                        <c:choose>
                            <c:when test="${page.isALink() and not (page.index eq dc.pager.currentPage)}">
                                <!-- Lien vers page -->
                                <li class="st-pagination__item">
                                    <a href="${dc.getURLForPage(page.index)}" class="st-pagination__link" aria-label="Page ${page.label}" aria-current="false">${page.label}</a>
                                </li>

                            </c:when>
                            <c:when test="${page.isALink() and (page.index eq dc.pager.currentPage)}">
                                <!-- Page en cours -->
                                <li class="st-pagination__item">
                                    <a href="#" class="st-pagination__link st-is-active" aria-label="Page ${page.label}" aria-current="true">${page.label}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <!-- Texte -->
                                <li class="st-pagination__item">
                                    <span class="st-pagination__dots">...</span>
                                </li>

                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <li class="st-pagination__item st--next">
                        <a href="${dc.getURLForPage(dc.pager.currentPage + 1)}" rel="next" class="st-btn-arrow st--next" aria-disabled="${dc.pager.currentPage == dc.pager.lastPage ? 'true' : 'false'}">
                            <span class="st-sr-only"><liferay-ui:message key="eu.next" /></span>
                        </a>
                    </li>

                </ul>
            </nav>
        </c:if>
    </ul>
            </liferay-ui:search-container>
        </aui:form>
    </c:if>

    <div>
        <liferay-ui:message key="before-98" />
        <a href="${dc.contactURL}" target="_blank" title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
            <liferay-ui:message key="graveyard.contact" />
        </a>
    </div>

</div>


</c:if>


<script>
	$(document).ready(function() {
        $('input[data-type="date"].date-min').datepicker(
            $.extend({
                minDate: new Date(1998,0,1)
            }, $.datepicker.regional[ "fr" ])
        );


		$('#birthdateunknown').on('change', function() {
			if($('#birthdateunknown').is(':checked')){
            	$('#birthDate input').attr({'disabled': 'disabled' });
            	$('#birthDate input').val("");
            	$('#birthRange').show();
			}else{
	            $('#birthDate input').removeAttr('disabled');
	            $('#birthRange').hide();
			}
        });
		$('#deathdateunknown').on('change', function() {
			if($('#deathdateunknown').is(':checked')){
            	$('#deathDate input').attr({'disabled': 'disabled' });
            	$('#deathDate input').val("");
            	$('#deathRange').show();
			}else{
	            $('#deathDate input').removeAttr('disabled');
	            $('#deathRange').hide();
			}
        });
        if($("#result").length > 0) {
            $('html,body').animate({scrollTop: $("#result").offset().top - (($('.seu-nav-bottom #seu-main-menu').length > 0)?115:55)});
        }
	});

</script>