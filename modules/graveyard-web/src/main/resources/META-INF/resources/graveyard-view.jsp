<%@ include file="/graveyard-init.jsp" %>
<fmt:setLocale value="${locale}"/>
<c:set var="virtualHostName" value="${virtualHostName}"/>
<c:if test="${empty virtualHostName}">
    <c:set var="homeURL" value="/web/strasbourg.eu/"/>
</c:if>
<c:if test="${not empty virtualHostName}">
    <c:set var="homeURL" value="https://${virtualHostName}/"/>
</c:if>

<liferay-portlet:renderURL varImpl="rechercheURL"/>


<div class="st-wrapper st-wrapper-small st-form-defunt form-styles">
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

            <p class="st-text-mandatory"><liferay-ui:message key="eu.required-field-star"/></p>

            <div class="st-group-field st-col-6@t-small">
                <label for="name"><liferay-ui:message key="graveyard.name"/><strong style="color:red">*</strong></label>
                <input type="text" id="name" name="<portlet:namespace />name"
                       value="${name}" placeholder="<liferay-ui:message key="graveyard.enter.name" />">
            </div>

            <div class="st-group-field st-col-6@t-small">
                <label for="firstname"><liferay-ui:message key="graveyard.firstname"/></label>
                <input type="text" id="firstname" name="<portlet:namespace />firstname"
                       value="${firstname}" placeholder="<liferay-ui:message key="graveyard.enter.firstname" />">
            </div>


            <div class="st-group-field st-col-6@t-small">
                <label for="birthdate"><liferay-ui:message key="graveyard.birthdate"/></label>
                <div class="st-field-date">
                    <input name="<portlet:namespace />birthdate" data-type="date" type="date" id="birthdate"
                           min="1998-01-01"
                           value="${birthdate}" <c:if test="${birthdateunknown}">disabled="disabled"</c:if>>
                </div>

                <label for="birthdateunknown" class="st-field-checkbox">
                    <input type="checkbox" id="birthdateunknown" name="<portlet:namespace />birthdateunknown"
                           <c:if test="${birthdateunknown }">checked</c:if> />
                    <span><span><liferay-ui:message key="graveyard.birthdateunknown"/></span></span>
                </label>
                <div id="birthRange" class="mt-3" <c:if test="${!birthdateunknown }">style="display: none;"</c:if>>
                    <label for="birthdatestart"><liferay-ui:message key="graveyard.birthrange"/></label>
                    <div class="st-grid-fields st-grid-12">
                        <div class="st-field-date st-col-6">
                            <input name="<portlet:namespace />birthdatestart" data-type="date" type="date"
                                   id="birthdatestart" min="1998-01-01"
                                   value="${birthdatestart}">
                        </div>
                        <div class="st-field-date st-col-6">
                            <input name="<portlet:namespace />birthdateend" data-type="date" type="date"
                                   id="birthdateend" min="1998-01-01"
                                   value="${birthdateend}">
                        </div>
                    </div>
                </div>
            </div>


            <div class="st-group-field st-col-6@t-small">
                <label for="deathDate"><liferay-ui:message key="graveyard.deathdate"/></label>
                <div class="st-field-date">
                    <input name="<portlet:namespace />deathdate" data-type="date" type="date" id="deathDate"
                           min="1998-01-01"
                           value="${deathdate}" <c:if test="${deathdateunknown}">disabled="disabled"</c:if>>
                </div>

                <label for="deathdateunknown" class="mt-3 st-field-checkbox">
                    <input type="checkbox" id="deathdateunknown" name="<portlet:namespace />deathdateunknown"
                           <c:if test="${deathdateunknown }">checked</c:if> />
                    <span><span><liferay-ui:message key="graveyard.deathdateunknown"/></span></span>
                </label>
                <div id="deathRange" class="mt-3" <c:if test="${!deathdateunknown }">style="display: none;"</c:if>>
                    <label for="deathdatestart"><liferay-ui:message key="graveyard.deathrange"/></label>
                    <div class="st-grid-fields st-grid-12">
                        <div class="st-field-date st-col-6">
                            <input name="<portlet:namespace />deathdatestart" data-type="date" type="date"
                                   id="deathdatestart" min="1998-01-01"
                                   value="${deathdatestart}">
                        </div>
                        <div class="st-field-date st-col-6">
                            <input name="<portlet:namespace />deathdateend" data-type="date" type="date"
                                   id="deathdateend" min="1998-01-01"
                                   value="${deathdateend}">
                        </div>
                    </div>
                </div>
            </div>


            <div class="st-group-field st-col-6@t-small">
                <label for="deathplace"><liferay-ui:message key="graveyard.deathplace"/></label>
                <input type="text" id="deathplace" name="<portlet:namespace />deathplace"
                       value="${deathplace}" placeholder="<liferay-ui:message key="graveyard.enter.deathplace" />">
            </div>

            <div class="st-group-field st-col-6@t-small">
                <label for="concession"><liferay-ui:message key="graveyard.concession"/></label>
                <div class="st-field-select">
                    <select id="concession" class="toCustomSelect silencedSelect"
                            name="<portlet:namespace />concession">
                        <option value=""><liferay-ui:message key="graveyard.select.concession"/></option>
                        <c:forEach var="cimetiere" items="${dc.concessions}">
                            <option value="${cimetiere.id}"
                                    <c:if test="${concession eq cimetiere.id}">selected</c:if>>${cimetiere.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <input type="hidden" id="rechercher" name="<portlet:namespace />rechercher" value="lancer">
            <input type="hidden" id="delta" name="<portlet:namespace />delta" value="4">

            <div class="st-col-12@t-small st-btn-submit-wrapper">
                <button class="st-btn st--btn-full-width-mobile" type="submit"><liferay-ui:message
                        key="search"/></button>
            </div>
        </div>

    </aui:form>

</div>

<c:if test="${dc.graveyard.err eq 1 or not empty dc.graveyard.erreur}">
    <div class="st-wrapper st-wrapper-small">
        <div class="st-card-defunt">
            <h3 class="st-h3 st-title">
                <c:if test="${dc.graveyard.err eq 1}">
                    ${dc.graveyard.err_desc}
                </c:if>
                <c:if test="${dc.graveyard.err eq 0}">
                    <c:if test="${not empty dc.graveyard.erreur}">
                        <c:if test="${dc.graveyard.codeErreur == 'LIMITE_DEPASSEE'}">
                            <liferay-ui:message key="too-many-results"/>
                            <a href="${dc.contactURL}" target="_blank"
                               title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
                                <liferay-ui:message key="graveyard.contact"/>
                            </a>
                        </c:if>
                        <c:if test="${dc.graveyard.codeErreur != 'LIMITE_DEPASSEE'}">
                            ${dc.graveyard.erreur}
                        </c:if>
                    </c:if>
                </c:if>

            </h3>
        </div>
    </div>
</c:if>


<!-- Résultats -->
<c:if test="${empty error and not empty dc and not empty dc.graveyard and empty dc.graveyard.erreur and dc.graveyard.err eq 0}">
    <div class="st-listing-cards st-wrapper st-wrapper-small" id="result">
        <!-- Nombre de rÃ©sultats et items par page -->
        <div class="st-listing-results">
    <span class="st-results" role="status">
         <c:choose>
             <c:when test="${dc.graveyard.count lt 2}">
                 ${dc.searchContainer.total} <liferay-ui:message key="graveyard.result"/>
             </c:when>
             <c:otherwise>
                 ${dc.searchContainer.total} <liferay-ui:message key="graveyard.results"/>
             </c:otherwise>
         </c:choose>
    </span>

            <div class="st-results-filter">
                <label for="results-per-page"><liferay-ui:message key="graveyard.results-per-page"/></label>
                <div class="st-results-select">
                    <select id="results-per-page" name="results-per-page"
                            onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
                        <c:forEach var="delta" items="${[5, 10, 20, 50, 100]}">
                            <c:set var="selected" value="${delta eq dc.delta ? 'selected' : ''}"/>
                            <option value="${dc.getURLForDelta(delta)}" ${selected} >${delta}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <c:if test="${dc.graveyard.count == '0'}">
            <liferay-ui:message key="no-tot"/>
            <a href="${dc.contactURL}" target="_blank"
               title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
                <liferay-ui:message key="graveyard.contact"/>
            </a>
        </c:if>
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
                                            (<liferay-ui:message key="graveyard.birthname"
                                                                 arguments=""/> ${tot.birthName})
                                        </c:if>
                                    </h2>

                                    <div class="st-caption">
                                        <div class="st-col">
                                            <p class="st-title-small"><liferay-ui:message
                                                    key="graveyard.birthdate"/></p>
                                            <p class="st-surtitre-cat">
                                                <c:if test="${tot.birthDate == ''}">
                                                    <liferay-ui:message key="unknown"/>
                                                </c:if>
                                                <c:if test="${tot.birthDate != ''}">
                                                    ${tot.birthDate}
                                                </c:if>
                                            </p>
                                            <p class="st-title-small"><liferay-ui:message
                                                    key="graveyard.deathdate"/></p>
                                            <p class="st-surtitre-cat"><c:if test="${tot.deathDate == ''}">
                                                <liferay-ui:message key="unknown"/>
                                            </c:if>
                                                <c:if test="${tot.deathDate != ''}">
                                                    ${tot.deathDate}
                                                </c:if></p>
                                            <p class="st-title-small"><liferay-ui:message
                                                    key="graveyard.deathplace"/></p>
                                            <p class="st-surtitre-cat">
                                                <c:if test="${tot.deathPlace == ''}">
                                                    <liferay-ui:message key="unknown"/>
                                                </c:if>
                                                <c:if test="${tot.deathPlace != ''}">
                                                    ${tot.deathPlace}
                                                </c:if>
                                            </p>
                                        </div>

                                        <div class="st-col st-text-styles">
                                            <a href="${homeURL}lieu/-/entity/sig/${tot.graveyardMapping.sigId}/${dc.getNormalizedForURL(tot.graveyardMapping.name)}"
                                               class="st-title-small" target="_blank">${tot.graveyardMapping.name}</a>
                                            <p><liferay-ui:message key="graveyard.gravesector"/>
                                                : ${tot.graveSector}<br><liferay-ui:message key="graveyard.graverow"/>
                                                : ${tot.graveRow}<br><liferay-ui:message key="graveyard.gravenumber"/>
                                                : ${tot.graveNumber}</p>
                                        </div>
                                    </div>

                                    <a href="/o/graveyardweb/images/${tot.graveyardMapping.sigId}.jpg" download
                                       class="st-btn st--btn-secondary st--btn-secondary-ghost st--btn-small-padding st--btn-full-width-mobile"><liferay-ui:message
                                            key="graveyard.downloadPlan"/></a>
                                </div>
                            </li>


                        </c:forEach>


                    </ul>
                    <!-- Pagination -->
                    <c:if test="${dc.pager.lastPage > 1}">
                        <nav class="st-wrapper st-wrapper-small st-pagination" role="navigation"
                             aria-label="Pagination">
                            <ul class="st-pagination__list">
                                <li class="st-pagination__item st--prev">
                                    <a rel="prev" href="${dc.getURLForPage(dc.pager.currentPage - 1)}"
                                       class="st-btn-arrow st--prev"
                                       aria-disabled="${dc.pager.currentPage == 1 ? 'true' : 'false'}">
                                        <span class="st-sr-only"><liferay-ui:message key="eu.previous"/></span>
                                    </a>
                                </li>


                                <!-- Note pour le cablage changer dynamiquement les numéros de page dans les aria-label. Aussi, l'aria-label pour l'élément actif doit être différent par rapport aux autres -->
                                <c:forEach var="page" items="${dc.pager.pages}">
                                    <c:choose>
                                        <c:when test="${page.isALink() and not (page.index eq dc.pager.currentPage)}">
                                            <!-- Lien vers page -->
                                            <li class="st-pagination__item">
                                                <a href="${dc.getURLForPage(page.index)}" class="st-pagination__link"
                                                   aria-label="Page ${page.label}"
                                                   aria-current="false">${page.label}</a>
                                            </li>

                                        </c:when>
                                        <c:when test="${page.isALink() and (page.index eq dc.pager.currentPage)}">
                                            <!-- Page en cours -->
                                            <li class="st-pagination__item">
                                                <a href="#" class="st-pagination__link st-is-active"
                                                   aria-label="Page ${page.label}" aria-current="true">${page.label}</a>
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
                                    <a href="${dc.getURLForPage(dc.pager.currentPage + 1)}" rel="next"
                                       class="st-btn-arrow st--next"
                                       aria-disabled="${dc.pager.currentPage == dc.pager.lastPage ? 'true' : 'false'}">
                                        <span class="st-sr-only"><liferay-ui:message key="eu.next"/></span>
                                    </a>
                                </li>

                            </ul>
                        </nav>
                    </c:if>
                </liferay-ui:search-container>
            </aui:form>
        </c:if>

        <div class="form-styles mt-3">
            <p class="st-title-medium"><liferay-ui:message key="before-98"/></p>
            <p class="st-title-medium mt-3"><liferay-ui:message key="please"/> <a href="${dc.contactURL}"
                                                                                  target="_blank">
                <liferay-ui:message key="graveyard.contact"/>
            </a></p>

        </div>

    </div>


</c:if>


<script>
    $(document).ready(function () {

        $('#birthdateunknown').on('change', function () {

            if ($('#birthdateunknown').is(':checked')) {
                $('input#birthDate').attr({'disabled': 'disabled'});
                $('input#birthDate').val("");
                $('#birthRange').show();
            } else {
                $('input#birthDate').removeAttr('disabled');
                $('#birthRange').hide();
            }
        });
        $('#deathdateunknown').on('change', function () {
            if ($('#deathdateunknown').is(':checked')) {
                $('input#deathDate').attr({'disabled': 'disabled'});
                $('input#deathDate').val("");
                $('#deathRange').show();
            } else {
                $('#deathDate input').removeAttr('disabled');
                $('#deathRange').hide();
            }
        });
        if ($("#result").length > 0) {
            // scroll to result
            $('html, body').animate({
                scrollTop: $("#result").offset().top - $(".st-barre-navigation").height() - $(".cadmin.control-menu-container").height()
            }, 1000);
        }
    });

</script>