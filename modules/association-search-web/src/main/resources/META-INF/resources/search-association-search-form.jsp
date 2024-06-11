<!-- Formulaire -->
<c:set value="${dc.getSortedCategories(dc.domainVocabulary, param.speciality)}" var="subSpecialities"/>
<c:set value="${dc.getSortedCategories(dc.domainVocabulary, param.subSpeciality)}"
       var="subSubSpecialities"/>


<aui:form action="${searchActionURL}" method="get" name="fm" id="search-asset-form">
    <liferay-portlet:renderURLParams varImpl="searchActionURL"/>
    <div class="st-wrapper st-form-defunt form-styles st-grid-12">
        <c:if test="${domainError}">
        <div class="st-alert-form st--has-error">
            <p class="st-alert-form__content">
                <a href="#<portlet:namespace />domain"><liferay-ui:message key="select-at-least-one-domain" /></a>
            </p>
        </div>
        </c:if>
        <div class="st-grid-fields st-grid-12">

            <div class="st-group-field domain st-col-3@t-small">
                <label for="<portlet:namespace />domain">
                    <liferay-ui:message key="domain"/>
                </label>
                <div class="st-field-select">
                    <select class="domains" id="<portlet:namespace />domain" name="<portlet:namespace />domain">
                        <aui:option value="" label=""/>
                        <c:forEach items="${dc.getSortedCategories(dc.domainVocabulary)}" var="category">
                            <c:set var="category" value="${category}" scope="request"/>
                            <c:set var="level" value="0" scope="request"/>
                            <c:set var="curValue" value="${param.domain}" scope="request"/>
                            <jsp:include page="/includes/domain-speciality-option.jsp"/>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="st-group-field speciality st-col-3@t-small"
                 <c:if test="${empty param.domain}">style="display: none;" </c:if>>
                <label for="<portlet:namespace />speciality">
                    <liferay-ui:message key="speciality"/>
                </label>
                <div class="st-field-select">
                    <select class="specialities" id="<portlet:namespace />speciality"
                            name="<portlet:namespace />speciality">
                        <aui:option value="" label="show-all"/>
                        <c:if test="${param.domain != null}">
                            <c:forEach items="${dc.getSortedCategories(dc.domainVocabulary, param.domain)}"
                                       var="category">
                                <c:set var="category" value="${category}" scope="request"/>
                                <c:set var="level" value="0" scope="request"/>
                                <c:set var="curValue" value="${param.speciality}" scope="request"/>
                                <jsp:include page="/includes/domain-speciality-option.jsp"/>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>

            <div class="st-group-field subSpeciality st-col-3@t-small"
                 <c:if test="${empty param.speciality || empty subSpecialities}">style="display: none;" </c:if>>
                <label for="<portlet:namespace />subSpeciality">
                    <liferay-ui:message key="sub-speciality"/>
                </label>
                <div class="st-field-select">
                    <select class="subSpecialities" id="<portlet:namespace />subSpeciality"
                            name="<portlet:namespace />subSpeciality">
                        <aui:option value="" label="show-all"/>
                        <c:if test="${param.speciality != null}">
                            <c:forEach items="${subSpecialities}" var="category">
                                <c:set var="category" value="${category}" scope="request"/>
                                <c:set var="level" value="0" scope="request"/>
                                <c:set var="curValue" value="${param.subSpeciality}" scope="request"/>
                                <jsp:include page="/includes/domain-speciality-option.jsp"/>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>

            <div class="st-group-field subSubSpeciality st-col-3@t-small"
                 <c:if test="${empty param.subSpeciality || empty subSubSpecialities}">style="display: none;" </c:if>>
                <label for="<portlet:namespace />subSubSpeciality">
                    <liferay-ui:message key="sub-sub-speciality"/>
                </label>
                <div class="st-field-select">
                    <select class="subSubSpeciality" id="<portlet:namespace />subSubSpeciality"
                            name="<portlet:namespace />subSubSpeciality">
                        <aui:option value="" label="show-all"/>
                        <c:if test="${param.subSpeciality != null}">
                            <c:forEach items="${subSubSpecialities}" var="category">
                                <c:set var="category" value="${category}" scope="request"/>
                                <c:set var="level" value="0" scope="request"/>
                                <c:set var="curValue" value="${param.subSubSpeciality}" scope="request"/>
                                <jsp:include page="/includes/domain-speciality-option.jsp"/>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>




        </div>

        <div class="st-grid-fields st-grid-12">

            <c:forEach items="${dc.vocabularies}" var="vocabulary"
                       varStatus="vocStatus">
                <div class="st-group-field st-col-6@t-small">
                    <span class="label-fake">${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}</span>
                    <label for="vocabulary_${vocStatus.index}">
                            ${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}
                    </label>
                    <select class="" id="vocabulary_${vocStatus.index}"
                            name="<portlet:namespace />vocabulary_${vocStatus.index}"  data-select-a11y="" multiple="">
                        <c:forEach items="${dc.getSortedCategories(vocabulary)}" var="category">
                            <c:set var="category" value="${category}" scope="request"/>
                            <c:set var="dc" value="${dc}" scope="request"/>
                            <c:set var="level" value="0" scope="request"/>
                            <jsp:include page="/includes/category-option.jsp"/>
                        </c:forEach>
                    </select>
                </div>
            </c:forEach>

            <aui:input type="hidden" name="vocabulariesCount" value="${fn:length(dc.vocabularies)}"/>



        </div>
        <div class="st-col-12@t-small st-btn-submit-wrapper">
            <button class="st-btn st--btn-full-width-mobile" type="submit"><liferay-ui:message
                    key="start-search"/></button>
        </div>
    </div>


</aui:form>

<liferay-util:html-bottom>
    <script src="/o/searchassetv2web/js/strasbourg-generic.js"></script>
</liferay-util:html-bottom>