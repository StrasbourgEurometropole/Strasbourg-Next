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
                <strong>${(newsItemAlaUne.titleCourt != '' && newsItemAlaUne.titleCourt != null) ? newsItemAlaUne.titleCourt : newsItemAlaUne.title}</strong>
            </h2>
            <p class="st-surtitre-cat">${newsItemAlaUne.category}</p>
            <p class="st-text-small">${newsItemAlaUne.description}</p>
            <a href="${newsItemAlaUne.detailURL}" class="st-btn"><liferay-ui:message key="learn-more" /></a>
        </div>
        <div class="st-img-wrapper">
            <figure class="st-figure st-fit-cover" role="group">
                <picture>
                    <img alt="" src="${(newsItemAlaUne.topLevelImageURL != '' && newsItemAlaUne.topLevelImageURL != null) ? newsItemAlaUne.topLevelImageURL : newsItemAlaUne.imageURL}" />
                </picture>
            </figure>



        </div>
    </div>
</c:if>

<div class="st-bloc st-bloc-actu st--in-home st-u-overflow-x-hidden" role="group">
    <div class="st-wrapper st-bloc-actu__inner st-js-slider-actu splide st-component-container">
        <h2 class="st-h2 st-titre"><liferay-ui:message key="eu.news.header" /></h2>
        <div class="d-flex flex-column st-no-auto-rgaa">
            <div class="splide__track">
                <ul class="splide__list st-cards-wrapper">
                    <c:forEach items="${newsItemsHeadline}" var="newsItem">
                        <li class="splide__slide">
                            <c:if test="${newsItem != null}">
                                <div class="st-card-container">
                                    <a href="${newsItem.detailURL}" class="st-card st-card-actu st--is-featured">
                                        <div class="st-caption">
                                            <h3 class="st-title-card">${newsItem.title}</h3>
                                            <p class="st-surtitre-cat">${newsItem.category}</p>
                                            <p class="st-text">${newsItem.descriptionCourt}</p>
                                        </div>

                                        <div class="st-image">

                                            <figure class="st-figure st-fit-cover" role="group">
                                                <picture>
                                                    <img alt="" loading="lazy" src="${(newsItemAlaUne.topLevelImageURL != '' && newsItemAlaUne.topLevelImageURL != null) ? newsItemAlaUne.topLevelImageURL : newsItemAlaUne.imageURL}">
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
                                            <h3 class="st-title-card">${newsItem.title}</h3>
                                            <p class="st-surtitre-cat">${newsItem.category}</p>
                                            <p class="st-text">${newsItem.descriptionCourt}</p>
                                        </div>

                                        <div class="st-image">

                                            <figure class="st-figure st-fit-cover" role="group">
                                                <picture>
                                                    <img alt="" loading="lazy" src="${newsItem.imageURL}" />
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

            <a href="${dc.getLink()}" class="st-btn st--btn-secondary st--btn-full-width-mobile st-btn-cta">
                <liferay-ui:message key="eu.news.all-news" /></a>
        </div>
    </div>
</div>
