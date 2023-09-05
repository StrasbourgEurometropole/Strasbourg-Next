<div class="st-barre-listing-sit">
    <div class="st-barre-inner st-wrapper form-styles">

        <div class="st-filtre st-group-field st--is-expanded">
            <label for="filter-keywords">Mots-clés</label>
            <input id="filter-keywords" type="text" placeholder="Saisir un mot clé…" />
        </div>

        <div class="st-filtre st-group-field">
            <label for="filter-territoire">Par territoire</label>
            <div class="st-field-select">
                <select id="filter-territoire" name="filter-territoire">
                    <option value="" selected>Tout afficher</option>
                    <option value="strasbourg">Strasbourg</option>
                    <option value="hagenau">Hagenau</option>
                    <option value="schiltigheim">Schiltigheim</option>
                    <option value="illkirch-graffenstaden">Illkirch-Graffenstaden</option>
                </select>
            </div>
        </div>

        <div class="st-filtre st-group-field">
            <label for="filter-type-lieu">Type de lieu</label>
            <div class="st-field-select">
                <select id="filter-type-lieu" name="filter-type-lieu">
                    <option value="" selected>Tout afficher</option>
                    <option value="strasbourg">Palais universitaire</option>
                    <option value="hagenau">Cité</option>
                    <option value="schiltigheim">Parc/jardin</option>
                    <option value="illkirch-graffenstaden">Château</option>
                    <option value="illkirch-graffenstaden">Centre socioculturel</option>
                </select>
            </div>
        </div>

        <div class="col-right">
            <p class="st-resultats">
                <span class="st-resultats-range">1 à 16</span>sur
                <span class="st-resultats-total">1189 résultat(s)</span>
            </p>

            <button class="st-btn st--btn-filtres">Filtrer</button>
        </div>
    </div>
</div>

<%--<!-- Formulaire -->--%>
<%--<aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form" cssClass="seu-view-filters">--%>
<%--    <liferay-portlet:renderURLParams varImpl="searchActionURL" />--%>
<%--    <liferay-ui:error key="practice-error" message="practice-error" />--%>
<%--    <p class="error" style="display: none; color:#ff1818;"><liferay-ui:message key="practice-error" /></p>--%>

<%--    <div class="seu-filter-line">--%>
<%--        <div class="widget">--%>
<%--            <div class="title content">--%>
<%--                <aui:select cssClass="toCustomSelect domains" id="domain" name="domain" label="domain">--%>
<%--                    <aui:option value="" disabled="disabled" />--%>
<%--                    <c:forEach items="${dc.getSortedCategories(dc.domainVocabulary)}" var="category">--%>
<%--                        <c:set var="category" value="${category}" scope="request" />--%>
<%--                        <c:set var="level" value="0" scope="request" />--%>
<%--                        <jsp:include page="/includes/category-option.jsp" />--%>
<%--                    </c:forEach>--%>
<%--                </aui:select>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="widget speciality" <c:if test="${empty param.domain}">style="display: none;" </c:if>>--%>
<%--            <div class="title content">--%>
<%--                <aui:select cssClass="toCustomSelect specialities" id="speciality" name="speciality" label="speciality">--%>
<%--                    <aui:option value="" disabled="disabled" />--%>
<%--                    <c:if test="${param.domain != null}">--%>
<%--                        <c:forEach items="${dc.getSortedCategories(dc.domainVocabulary, param.domain)}" var="category">--%>
<%--                            <c:set var="category" value="${category}" scope="request" />--%>
<%--                            <c:set var="level" value="0" scope="request" />--%>
<%--                            <jsp:include page="/includes/category-option.jsp" />--%>
<%--                        </c:forEach>--%>
<%--                    </c:if>--%>
<%--                </aui:select>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <c:set value="${dc.getSortedCategories(dc.domainVocabulary, param.speciality)}" var = "subSpecialities" />--%>
<%--        <div class="widget subSpeciality" <c:if test="${empty param.speciality || empty subSpecialities}">style="display: none;" </c:if>>--%>
<%--            <div class="title content">--%>
<%--                <aui:select cssClass="toCustomSelect subSpecialities" id="subSpeciality" name="subSpeciality" label="sub-speciality">--%>
<%--                    <aui:option value="" disabled="disabled" />--%>
<%--                    <c:if test="${param.speciality != null}">--%>
<%--                        <c:forEach items="${subSpecialities}" var="category">--%>
<%--                            <c:set var="category" value="${category}" scope="request" />--%>
<%--                            <c:set var="level" value="0" scope="request" />--%>
<%--                            <jsp:include page="/includes/category-option.jsp" />--%>
<%--                        </c:forEach>--%>
<%--                    </c:if>--%>
<%--                </aui:select>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <c:set value="${dc.getSortedCategories(dc.domainVocabulary, param.subSpeciality)}" var = "subSubSpecialities" />--%>
<%--        <div class="widget subSubSpeciality" <c:if test="${empty param.subSpeciality || empty subSubSpecialities}">style="display: none;" </c:if>>--%>
<%--            <div class="title content">--%>
<%--                <aui:select cssClass="toCustomSelect subSubSpecialities" id="subSubSpeciality" name="subSubSpeciality" label="sub-sub-speciality">--%>
<%--                    <aui:option value="" disabled="disabled" />--%>
<%--                    <c:if test="${param.subSpeciality != null}">--%>
<%--                        <c:forEach items="${subSubSpecialities}" var="category">--%>
<%--                            <c:set var="category" value="${category}" scope="request" />--%>
<%--                            <c:set var="level" value="0" scope="request" />--%>
<%--                            <jsp:include page="/includes/category-option.jsp" />--%>
<%--                        </c:forEach>--%>
<%--                    </c:if>--%>
<%--                </aui:select>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


<%--    <div class="seu-filter-line">--%>
<%--        <c:forEach items="${dc.vocabularies}" var="vocabulary"--%>
<%--                   varStatus="vocStatus">--%>
<%--            <div class="widget otherVocabularies">--%>
<%--                <div class="title content">--%>
<%--                    <aui:select cssClass="toCustomSelect" id="vocabulary_${vocStatus.index}" name="vocabulary_${vocStatus.index}" label="${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}">--%>
<%--                        <aui:option value="" disabled="disabled" />--%>
<%--                        <c:forEach items="${dc.getSortedCategories(vocabulary)}" var="category">--%>
<%--                            <c:set var="category" value="${category}" scope="request" />--%>
<%--                            <c:set var="level" value="0" scope="request" />--%>
<%--                            <jsp:include page="/includes/category-option.jsp" />--%>
<%--                        </c:forEach>--%>
<%--                    </aui:select>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--    <aui:input type="hidden" name="vocabulariesCount" value="${fn:length(dc.vocabularies)}" />--%>
<%--    <div class="seu-btn-line">--%>
<%--        <liferay-portlet:renderURL var="formURL" />--%>
<%--        <button type="button" onclick="window.location.href = '${formURL}'" class="seu-btn-square seu-bordered seu-core">--%>
<%--                    <span class="seu-flexbox">--%>
<%--                        <span class="seu-btn-text" style="margin-right: 0">--%>
<%--                            <liferay-ui:message key="cancel" />--%>
<%--                        </span>--%>
<%--                    </span>--%>
<%--        </button>--%>
<%--        <button type="submit" class="seu-btn-square seu-filled seu-core">--%>
<%--                    <span class="seu-flexbox">--%>
<%--                        <span class="seu-btn-text">--%>
<%--                            <liferay-ui:message key="search" />--%>
<%--                        </span>--%>
<%--                        <span class="seu-btn-arrow"></span>--%>
<%--                    </span>--%>
<%--        </button>--%>
<%--    </div>--%>
<%--</aui:form>--%>