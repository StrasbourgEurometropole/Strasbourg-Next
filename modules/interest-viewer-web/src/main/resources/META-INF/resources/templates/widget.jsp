<%@ include file="/interest-viewer-init.jsp" %>
<c:if test="${empty dc.getVirtualHostName()}">
    <c:set var="homeURL" value="/web/strasbourg.eu/"/>
</c:if>
<c:if test="${not empty dc.getVirtualHostName()}">
    <c:set var="homeURL" value="https://${dc.getVirtualHostName()}/"/>
</c:if>
       

<c:if test="${not dc.hasInterest()}">
	<section id="actu-agenda-no-interest">
</c:if>
<c:if test="${dc.hasInterest()}">
	<section id="actu-agenda">
</c:if>

    <%-- Récupère le fait de plier ou déplier ce widget dans la config de la personnalisation --%>
    <c:set value="${dc.isFolded()}" var="isFolded" />
    <div class="buttons">
        <%-- Vérifie si ce widget peut être plié dans la config de la personnalisation --%>
        <c:if test="${dc.showRetractableButton()}">
            <button class="${isFolded?'retractable-folded-wi':'retractable-unfolded-wi'}" data-portlet-id="${themeDisplay.portletDisplay.id}"></button>
        </c:if>
        <%-- Vérifie si ce widget peut être masqué dans la config de la personnalisation --%>
        <c:if test="${dc.showDeleteButton()}">
            <button class="delete-wi" data-portlet-id="${themeDisplay.portletDisplay.id}"></button>
        </c:if>
    </div>
	<h2>${title}</h2>
    <div class="detail" ${dc.isFolded()?'style="display: none;"':''}>
        <c:if test="${not dc.hasInterest()}">
            <p>${dc.getNoInterestText()}</p>
            <div align="center">
                <a href="${strasbourgPropsUtil.getPublikProfileURL()}" class="btn-square--bordered--core">
                    <span class="flexbox">
                        <span class="btn-text">compl&eacute;ter mon compte</span>
                        <span class="btn-arrow"></span>
                    </span>
                </a>
            </div>
        </c:if>
        <c:set value="${dc.entries}" var="entries" />
        <c:if test="${dc.hasInterest() and not empty entries}">
            <script type="text/javascript">
                <c:set var="newsCount" value="0"/>
                <c:set var="editionCount" value="0"/>
                <c:set var="eventCount" value="0"/>
                var mega_source = [];
                mega_source.push([
                    <c:forEach var="curEntry" items="${entries}" varStatus="loopStatus">
                        <c:if test="${curEntry.getClassName().equals('com.liferay.journal.model.JournalArticle')}">
                            <c:if test="${not empty curEntry and not empty curEntry.getAssetRenderer() and not empty curEntry.getAssetRenderer().getArticle() }">
                                <c:set var="article" value="${curEntry.getAssetRenderer().getArticle()}"/>
                                <c:set var="title" value="${dc.DeleteTag(dc.getJournalArticleTitle(article,locale))}"/>
                                <c:set var="chapo" value="${dc.DeleteTag(dc.getJournalArticleCatcher(article,locale))}"/>
                                <c:set var="image" value="${dc.getJournalArticleImage(article,locale)}"/>
                                <c:set var="id" value="${article.getArticleId()}"/>
                                <c:set var="groupId" value="${article.getGroupId()}"/>
                                <c:set var="currentURL" value="${assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry)}"/>
                                <c:set var="viewURL" value="${curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL)}"/>
                              {
                                <c:if test="${dc.isMag(curEntry.getTagNames())}">
                                  <c:set var="editionCount" value="${editionCount + 1}"/>
                                  category: 'mag',
                                </c:if>
                                <c:if test="${!dc.isMag(curEntry.getTagNames())}">
                                  <c:set var="newsCount" value="${newsCount + 1}"/>
                                  category: 'actu',
                                </c:if>
                                title: '${dc.getJSONEncodedString(title)}',
                                lead: '${dc.getJSONEncodedString(chapo)}',
                                picture: '${image}',
                                link: '${viewURL}',
                                id: '${id}',
                                groupId: '${groupId}'
                              }
                            </c:if>
                        </c:if>
                        <c:if test="${!curEntry.getClassName().equals('com.liferay.journal.model.JournalArticle')}">
                            <c:set var="eventCount" value="${eventCount + 1}"/>
                            <c:set var="event" value="${curEntry.getAssetRenderer().getEvent()}"/>
                    {
                        category: 'agenda',
                        title: '${dc.getJSONEncodedString(dc.DeleteTag(event.getTitle(locale)))}',
                        type: '${dc.getJSONEncodedString(dc.DeleteTag(event.getTypeLabel(locale)))}',
                        link: '${homeURL}evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}',
                        ville: '${event.getCity(locale)} <c:if test="${not empty event.getCity(locale)}">-</c:if> ${dc.getJSONEncodedString(event.getPlaceAlias(locale))}',
                        id: '${event.eventId}',
                        <c:set var="dates" value="${event.getMapDateRange(locale, 'dd.MM')}"/>
                        date_prefix: '${dates.get("date_prefix")}',
                        date_start: '${dates.get("date_start")}',
                        date_suffix: '${dates.get("date_suffix")}',
                        date_end: '${dates.get("date_end")}'
                    }
                    </c:if>
                    <c:if test="${!loopStatus.last}">,
                    </c:if>
                    </c:forEach>
                ]);
            </script>

            <div class="slider--mega">
                <div class="top-line">
                    <div class="filters">
                        <button class="actu-filter actif btn-round--grey" data-category="tous">
                            <span class="flexbox">
                                <span class="btn-text"><liferay-ui:message key="all" /></span>
                            </span>
                        </button>
                        <c:if test="${newsCount > 0}">
                            <button class="actu-filter btn-round--grey" data-category="actu">
                                <span class="flexbox">
                                    <span class="btn-text"><liferay-ui:message key="actus" /></span>
                                </span>
                            </button>
                        </c:if>
                        <c:if test="${editionCount > 0}">
                            <button class="actu-filter btn-round--grey" data-category="mag">
                                <span class="flexbox">
                                    <span class="btn-text"><liferay-ui:message key="mag" /></span>
                                </span>
                            </button>
                        </c:if>
                        <c:if test="${eventCount > 0}">
                            <button class="actu-filter btn-round--grey" data-category="agenda">
                                <span class="flexbox">
                                    <span class="btn-text"><liferay-ui:message key="agenda" /></span>
                                </span>
                            </button>
                        </c:if>
                    </div>
                </div>
                <div class="slider-mega-container">
                    <div class="slider-overflow">
                        <div class="slider">
                        </div>
                    </div>
                    <div class="owl-nav">
                        <button class="owl-prev">
                            <span class="picto"></span>
                        </button>
                        <button class="owl-next">
                            <span class="picto"></span>
                        </button>
                    </div>
                </div>
                <div id="mega-templates">
                    <!--Template Event-->
                    <div class="item event">
                        <a href="__link__" class="link" title="__title__">
                            <div class="date">
                                <div class="date-sup">
                                    <span class="date-prefix">__date_prefix__</span>
                                    <span class="date-start">__date_start__</span>
                                    <span class="date-suffix">__date_suffix__</span>
                                </div>
                                <div class="date-end">__date_end__</div>
                            </div>
                            <div class="title dotme" data-dot="3">__title__</div>
                            <div class="ville">__ville__</div>
                            <div class="item-categories" data-dot="3">__type__</div>
                        </a>
                        <a href="#" class="add-favorites"
                            data-type="2"
                            data-title="__title__"
                            data-url="__link__"
                            data-id="__id__" >
                            <span><liferay-ui:message key="eu.add-to-favorite" /></span>
                        </a>
                    </div>

                    <!-- Template actu-->
                    <div class="item actu">
                        <a href="__link__" class="link" title="__title__">
                            <div class="text">
                                <div class="title dotme" data-dot="3">__title__</div>
                                <div class="lead dotme" data-dot="3">__lead__</div>
                            </div>
                            <div class="picture" style="background-image: url(__picture__)">
                            </div>
                        </a>
                        <a href="#" class="add-favorites"
                            data-type="6"
                            data-title="__title__"
                            data-url="__link__"
                            data-id="__id__"
                            data-group-id="__groupId__">
                            <span><liferay-ui:message key="eu.add-to-favorite" /></span>
                        </a>
                    </div>

                    <!--Template Mag-->
                    <div class="item mag">
                        <a href="__link__" class="link" title="__title__">
                            <div class="picture" style="background-image: url(__picture__)">
                            </div>
                            <div class="mag-logo">
                                <div class="mag-text">Mag'</div>
                                <div class="mag-picto"></div>
                            </div>
                            <div class="text">
                                <div class="title dotme" data-dot="3">__title__</div>
                                <div class="lead dotme" data-dot="3">__lead__</div>
                            </div>
                        </a>
                        <a href="#" class="add-favorites"
                            data-type="6"
                            data-title="__title__"
                            data-url="__link__"
                            data-id="__id__"
                            data-group-id="__groupId__">
                            <span><liferay-ui:message key="eu.add-to-favorite" /></span>
                        </a>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</section>

<style>
	
	.slider--mega .slider-mega-container .slider .owl-item .item .link{
    	overflow: hidden;
	} 

</style>