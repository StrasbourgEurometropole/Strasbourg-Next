<%@ include file="/init.jsp" %>
<c:set var="newsItems" value="${dc.getAssetEntries()}" />
<c:set var="newsItemAlaUne" value="${newsItems[0]}" />
<c:set var="newsItemsHeadline" value="${newsItems.subList(1, 3)}" />
<c:set var="newsItemsOthers" value="${newsItems.subList(3, newsItems.size())}" />

<c:if test="${newsItemAlaUne != null}">
    <div class="st-wrapper st-bloc st-contenu-en-avant ">
        <div class="st-content st-text-styles">
            <h2 class="st-h2">
                <liferay-ui:message key="eu.slider-one" /> :<br>
                    ${newsItemAlaUne.titleCourt != '' ? newsItemAlaUne.titleCourt : newsItemAlaUne.title}
                <strong>${newsItemAlaUne.title}</strong>
            </h2>
            <p class="st-surtitre-cat">${newsItemAlaUne.category}</p>
            <p class="st-text-small">${newsItemAlaUne.description}</p>
            <a href="${newsItemAlaUne.detailURL}" class="st-btn"><liferay-ui:message key="learn-more" /></a>
        </div>
        <div class="st-img-wrapper">
            <figure class="st-figure st-fit-cover" role="group">
                <picture>
                    <img src="${newsItemAlaUne.imageURL}" />
                </picture>
            </figure>



        </div>
    </div>
</c:if>

<div class="st-bloc st-bloc-actu-home st-u-overflow-x-hidden " role="group">
    <div class="st-wrapper st-bloc-actu-home__inner st-js-slider-actu-home splide st-component-container">
        <h2 class="st-h2 st-titre"><liferay-ui:message key="eu.news.header" /></h2>
        <div class="st-limit-height">
            <div class="splide__track">
                <ul class="splide__list st-cards-wrapper">
                    <c:forEach items="${newsItemsHeadline}" var="newsItem">
                        <li class="splide__slide">
                            <c:if test="${newsItem != null}">
                            <div class="st-card-container">
                                <a href="${newsItem.detailURL}" class="st-card st-card-actu st--is-featured">
                                    <div class="st-caption">
                                        <p class="st-title-card">${newsItem.title}</p>
                                        <p class="st-surtitre-cat">${newsItem.category}</p>
                                        <p class="st-date"><liferay-ui:message key="eu.published-on" /> ${newsItem.publicationDate}</p>
                                    </div>

                                    <div class="st-image">

                                        <figure class="st-figure st-fit-cover" role="group">
                                            <picture>
                                                <img alt="" src="${newsItem.imageURL}">
                                            </picture>
                                        </figure>
                                    </div>

                                </a>


                            </div>
                            </c:if>
                        </li>

                    </c:forEach>
                <c:forEach items="${newsItemsOthers}" var="newsItem">
                    <li class="splide__slide">
                        <c:if test="${newsItem != null}">
                            <div class="st-card-container">
                                <a href="${newsItem.detailURL}" class="st-card st-card-actu">
                                    <div class="st-caption">
                                        <p class="st-title-card">${newsItem.title}</p>
                                        <p class="st-surtitre-cat">${newsItem.category}</p>
                                        <p class="st-date"><liferay-ui:message key="eu.published-on" /> ${newsItem.publicationDate}</p>
                                    </div>

                                    <div class="st-image">

                                        <figure class="st-figure st-fit-cover" role="group">
                                            <picture>
                                                <img alt="" src="${newsItem.imageURL}" />
                                            </picture>
                                        </figure>
                                    </div>
                                </a>
                            </div>
                        </c:if>

                    </li>
                </c:forEach>

                </ul>
            </div>

            <ul class="splide__pagination st-nav-dots"></ul>

            <a href="#" class="st-btn st--btn-secondary st--btn-full-width-mobile st-btn-cta">
                <liferay-ui:message key="eu.news.all-news" /></a>
        </div>

        <div class="st-show-more">
            <button class="st-btn-show-more st-btn st--btn-secondary" aria-expanded="false"
                    aria-label="Voir tout le contenu" data-open-label="Voir tout le contenu"
                    data-close-label="Réduire l'affichage du contenu"><liferay-ui:message key="eu.news.more" />
            </button>
        </div>
    </div>
</div>
