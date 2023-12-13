<%@ include file="/internal-link-init.jsp"%>

<div class="st-bloc st-bloc-infos-complementaires st-wrapper st--has-margin">
    <div class="st-container">
        <div class="st-component st-component-type-2">
            <h2 class="st-h2 st-title">
                <liferay-ui:message key="${strasbourgPortletTitle}" />
            </h2>
            <div class="st-component-container">
                <ul class="st-liste st-limit-height">
                    <c:forEach items="${selectedLayouts}" var="layout">
                        <liferay-portlet:renderURL plid="${layout.plid}" var="layoutURL" />
                        <li class="st-lien-container">
                            <a href="${layoutURL}" class="st-lien" target="_blank" title="${layout.getName(locale)}">
                                <p class="st-title-lien">
                                        ${layout.getName(locale)}
                                </p>
                                <p class="st-text">
                                    <liferay-ui:message key="eu.access-page" />
                                </p>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
                <div class="st-show-more">
                        <button class="st-btn-show-more st-btn-arrow st--down"
                                aria-expanded="false"
                                data-open-label="<liferay-ui:message key="eu.strasbourg.show-more" />" data-close-label="<liferay-ui:message key="eu.strasbourg.show-less" />"><liferay-ui:message key="eu.strasbourg.show-more" />
                        </button>
                </div>
            </div>
        </div>
    </div>
