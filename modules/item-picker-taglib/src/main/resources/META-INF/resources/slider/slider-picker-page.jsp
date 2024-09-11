<%@include file="/picker-init.jsp" %>

<div class="strasbourg-slider-picker form-group">
	<p>
		<label class="label-vignette" >${label}</label>
	</p>
    <ul id="thumbnail-${name}" class="detail">
        <c:if test="${event != null}">
            <li>
                ${not empty event.titleMap ? event.getTitle(locale) : event.title}<br>
                <c:if test="${article.status == 0}">
                    <fmt:formatDate value="${event.publicationDate}" var="formattedPublicationDate" type="date" pattern="dd/MM/yyyy" />
                    Publi&eacute; le : ${formattedPublicationDate}<br>
                </c:if>
                <c:if test="${article.status != 0}">
                    <fmt:formatDate value="${event.publicationDate}" var="formattedPublicationDate" type="date" pattern="dd/MM/yyyy HH:mm" />
                    <span style="color:red">Date de publication : ${formattedPublicationDate}</span><br>
                </c:if>
                <fmt:formatDate value="${event.lastEndDate}" var="formattedLastEndDate" type="date" pattern="dd/MM/yyyy" />
                Fin de l'&eacute;v&egrave;nement le : ${formattedLastEndDate}
            </li>
        </c:if>
        <c:if test="${article != null}">
            <li>
                ${not empty article.titleMap ? article.getTitle(locale) : article.title}<br>
                <c:if test="${article.status == 0}">
                    <fmt:formatDate value="${article.createDate}" var="formattedCreateDate" type="date" pattern="dd/MM/yyyy" />
                    Publi&eacute; le : ${formattedCreateDate}<br>
                </c:if>
                <c:if test="${article.status == 7}">
                    <fmt:formatDate value="${article.displayDate}" var="formattedPublishDate" type="date" pattern="dd/MM/yyyy HH:mm" />
                    <span style="color:red">Date de publication : ${formattedPublishDate}</span><br>
                </c:if>
                <c:if test="${article.expirationDate != null}">
                    <fmt:formatDate value="${article.expirationDate}" var="formattedExpirationDate" type="date" pattern="dd/MM/yyyy" />
                    D&eacute;publi&eacute; le : ${formattedExpirationDate}
                </c:if>
            </li>
        </c:if>
    </ul>
	<p>
		<aui:button name="choose-event-${name}" id="choose-event-${name}" value="&Eacute;v&eacute;nement" cssClass="eventButton" />
		<aui:button name="choose-article-${name}" id="choose-article-${name}" value="Actu/Webmag" cssClass="articleButton" />

	</p>
	<div class="has-error">
		<aui:input name="${name}" type="hidden" value="${value}" />
	</div>
</div>
<aui:script>
    // JS gérant l'ouverture du popup de selection de l'évènement
    $(document).on('click','#<portlet:namespace />choose-event-${name}',
        function(event) {
            var itemPicker = $(event.target).closest(".strasbourg-slider-picker");
            Liferay.Util.openSelectionModal(
                {
                    selectEventName: 'itemSelected${name}',
                    onSelect: function(item) {
                        var items = [];
                        if (!!item) {
                            items.push(item);
                        }

                        for (var i = 0; i < items.length; i++) {
                            var selectedItem = items[i];
                            var htmlToAppend = '<li>'
                                + selectedItem.title + '<br>'
                                + 'Publi&eacute; le : ' + selectedItem.publicationDate + '<br>'
                                + "Fin de l'&eacute;v&egrave;nement le : " + selectedItem.lastEndDate
                                +'</li>';
                            $(itemPicker).find('.detail').empty();
                            $(itemPicker).find('.detail').append(htmlToAppend);
                            $(itemPicker).find('.has-error input').val(selectedItem.entityId);
                            $(itemPicker).find('.label-vignette').html("&Eacute;v&eacute;nement");
                        }
                    },
                    title: 'S&eacute;lectionnez un &eacute;v&egrave;nement',
                    url: '${itemEventSelectorURL}'
                }
            );
        }
    );

    // JS gérant l'ouverture du popup de selection du contenu web
    $(document).on('click','#<portlet:namespace />choose-article-${name}',
        function(event) {
            var itemPicker = $(event.target).closest(".strasbourg-slider-picker");
            Liferay.Util.openSelectionModal(
                {
                    selectEventName: 'itemSelected${name}',
                    onSelect: function(item) {
                        var items = [];
                        if (!!item) {
                            items.push(item);
                        }

                        for (var i = 0; i < items.length; i++) {
                            var selectedItem = items[i];
                            var htmlToAppend = '<li>'
                                + selectedItem.title + '<br>'
                                + 'Publi&eacute; le : ' + selectedItem.createDate + '<br>';
                            if(selectedItem.expirationDate != "")
                                htmlToAppend += 'D&eacute;publi&eacute; le : ' + selectedItem.expirationDate;
                            htmlToAppend += '</li>';
                            $(itemPicker).find('.detail').empty();
                            $(itemPicker).find('.detail').append(htmlToAppend);
                            $(itemPicker).find('.has-error input').val(selectedItem.entityId);
                            if(selectedItem.folderId == ${folderWebmagId})
                                $(itemPicker).find('.label-vignette').html("Webmag");
                            else
                                $(itemPicker).find('.label-vignette').html("Actu");
                        }
                    },
                    title: 'S&eacute;lectionnez un article/webmag',
                    url: '${itemArticleSelectorURL}'
                }
            );
        }
    );
</aui:script>