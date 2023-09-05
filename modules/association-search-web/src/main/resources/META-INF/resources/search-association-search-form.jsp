<!-- Formulaire -->
<aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form">
    <liferay-portlet:renderURLParams varImpl="searchActionURL" />
    <liferay-ui:error key="practice-error" message="practice-error" />
<div class="st-barre-listing-sit">
<div class="st-barre-inner st-wrapper form-styles">

    <div class="st-filtre st-group-field domain">
        <label for="<portlet:namespace />domain" >
            <liferay-ui:message key="domain" />
        </label>
        <div class="st-field-select">
            <select class="domains" id="<portlet:namespace />domain" name="<portlet:namespace />domain">
                <aui:option value="" disabled="disabled" />
                <c:forEach items="${dc.getSortedCategories(dc.domainVocabulary)}" var="category">
                    <c:set var="category" value="${category}" scope="request" />
                    <c:set var="level" value="0" scope="request" />
                    <jsp:include page="/includes/category-option.jsp" />
                </c:forEach>
            </select>
        </div>
    </div>
    <c:set value="${dc.getSortedCategories(dc.domainVocabulary, param.speciality)}" var = "subSpecialities" />
    <c:set value="${dc.getSortedCategories(dc.domainVocabulary, param.subSpeciality)}" var = "subSubSpecialities" />
    <div class="st-filtre st-group-field speciality" <c:if test="${empty param.domain}">style="display: none;" </c:if>>
        <label for="<portlet:namespace />speciality" >
            <liferay-ui:message key="speciality" />
        </label>
        <div class="st-field-select">
            <select class="specialities" id="<portlet:namespace />speciality" name="<portlet:namespace />speciality">
                <aui:option value="" disabled="disabled" />
                <c:if test="${param.domain != null}">
                    <c:forEach items="${dc.getSortedCategories(dc.domainVocabulary, param.domain)}" var="category">
                        <c:set var="category" value="${category}" scope="request" />
                        <c:set var="level" value="0" scope="request" />
                        <jsp:include page="/includes/category-option.jsp" />
                    </c:forEach>
                </c:if>
            </select>
        </div>
    </div>

    <div class="st-filtre st-group-field subSpeciality" <c:if test="${empty param.speciality || empty subSpecialities}">style="display: none;" </c:if>>
        <label for="<portlet:namespace />subSpeciality" >
            <liferay-ui:message key="sub-speciality" />
        </label>
        <div class="st-field-select">
            <select class="subSpecialities" id="<portlet:namespace />subSpeciality" name="<portlet:namespace />subSpeciality">
                <aui:option value="" disabled="disabled" />
                <c:if test="${param.speciality != null}">
                    <c:forEach items="${subSpecialities}" var="category">
                        <c:set var="category" value="${category}" scope="request" />
                        <c:set var="level" value="0" scope="request" />
                        <jsp:include page="/includes/category-option.jsp" />
                    </c:forEach>
                </c:if>
            </select>
        </div>
    </div>

    <div class="st-filtre st-group-field subSubSpeciality" <c:if test="${empty param.subSpeciality || empty subSubSpecialities}">style="display: none;" </c:if>>
        <label for="<portlet:namespace />subSubSpeciality" >
            <liferay-ui:message key="sub-sub-speciality" />
        </label>
        <div class="st-field-select">
            <select class="subSubSpeciality" id="<portlet:namespace />subSubSpeciality" name="<portlet:namespace />subSubSpeciality">
                <aui:option value="" disabled="disabled" />
                <c:if test="${param.subSpeciality != null}">
                    <c:forEach items="${subSubSpecialities}" var="category">
                        <c:set var="category" value="${category}" scope="request" />
                        <c:set var="level" value="0" scope="request" />
                        <jsp:include page="/includes/category-option.jsp" />
                    </c:forEach>
                </c:if>
            </select>
        </div>
    </div>

    <c:forEach items="${dc.vocabularies}" var="vocabulary"
               varStatus="vocStatus">
        <div class="st-filtre st-group-field">
            <label for="<portlet:namespace />vocabulary_${vocStatus.index}" >
                    ${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}
            </label>
            <div class="st-field-select">
                <select class="" id="vocabulary_${vocStatus.index}" name="<portlet:namespace />vocabulary_${vocStatus.index}">
                    <aui:option value="" disabled="disabled" />
                    <c:forEach items="${dc.getSortedCategories(vocabulary)}" var="category">
                        <c:set var="category" value="${category}" scope="request"/>
                        <c:set var="dc" value="${dc}" scope="request"/>
                        <c:set var="level" value="0" scope="request" />
                        <jsp:include page="/includes/category-option.jsp" />
                    </c:forEach>
                </select>
            </div>
        </div>
    </c:forEach>
    <aui:input type="hidden" name="vocabulariesCount" value="${fn:length(dc.vocabularies)}" />
    <div class="col-right">
        <liferay-portlet:renderURL var="formURL" />
        <p class="st-resultats">
                <span class="st-resultats-range">${(dc.pager.currentPage - 1) * dc.delta + 1} <liferay-ui:message key="eu.to" />
                ${(dc.pager.currentPage * dc.delta) > dc.searchContainer.total ? dc.searchContainer.total : dc.pager.currentPage * dc.delta}
                </span>
            <span class="st-resultats-total">${dc.searchContainer.total} <liferay-ui:message key="results" /></span>
            <span class="st-resultats-period st-hide-from@t-portrait">Du </span>
        </p>

        <button type="button" onclick="window.location.href = '${formURL}'" class="st-btn st--btn-filtres"><liferayui:message key="cancel" /></button>
        <button type="submit" class="st-btn st--btn-filtres"><liferay-ui:message key="search" /></button>
    </div>

</div>
</div>
</aui:form>