<%@ include file="/init.jsp"%>
<script src="/o/news-home/js/Sortable.min.js"></script>
<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true"
	var="configurationRenderURL" />
<div class="container" id="configuration-news-home">

	<aui:form action="${configurationActionURL}" method="post" name="fm">

		<aui:input name="cmd" type="hidden"
			value="update" />

		<aui:input name="redirect" type="hidden"
			value="${configurationRenderURL}" />
        <aui:input type="text"
            name="link"
            value="${link}"
            label="Lien vers toutes les actus"
            inlineField="false" />

		<h3>A la une</h3>
		<div id="vignettes-a-la-une" class="vignettes">
			<c:forEach begin="1" end="1" step="1" var="i">
				<div id="vignette_${i}" class="vignette" >
					<liferay-util:include page="/configuration/news-home-configuration-selectors.jsp" servletContext="<%=application %>">
						<liferay-util:param name="index" value="${i}" />
						<liferay-util:param name="classPK" value="${classPKs[i - 1]}" />
					</liferay-util:include>
				</div>
			</c:forEach>

		</div>
		<h3>2 premier</h3>
		<div id="vignettes-headline" class="vignettes">
			<c:forEach begin="2" end="3" step="1" var="i">
				<div id="vignette_${i}" class="vignette" >
					<liferay-util:include page="/configuration/news-home-configuration-selectors.jsp" servletContext="<%=application %>">
						<liferay-util:param name="index" value="${i}" />
						<liferay-util:param name="classPK" value="${classPKs[i - 1]}" />
					</liferay-util:include>
				</div>
			</c:forEach>

		</div>
		<h3>Les autres</h3>
		<div id="vignettes-items" class="vignettes">
			<c:forEach begin="4" end="11" step="1" var="i">
				<div id="vignette_${i}" class="vignette" >
					<liferay-util:include page="/configuration/news-home-configuration-selectors.jsp" servletContext="<%=application %>">
						<liferay-util:param name="index" value="${i}" />
						<liferay-util:param name="classPK" value="${classPKs[i - 1]}" />
					</liferay-util:include>
				</div>
			</c:forEach>

		</div>
		<div class="vignette_empty">
			<div id="vignette_12" class="vignette" >
				<liferay-util:include page="/configuration/news-home-configuration-selectors.jsp" servletContext="<%=application %>">
					<liferay-util:param name="index" value="25" />
					<liferay-util:param name="classPK" value="" />
				</liferay-util:include>
			</div>
		</div>

			<aui:button-row>
				<clay:button
						displayType="primary"
						label="save"
						type="submit"
				/>
			</aui:button-row>


	</aui:form>
</div>
<script>
	var vignettesHeadline = document.getElementById('vignettes-headline');
	var vignettesALaUne = document.getElementById('vignettes-a-la-une');
	var vignettesItem = document.getElementById('vignettes-items');

    new Sortable(vignettesHeadline, {
		group: "vignettes",
        handle: '.vignette-move',
        animation: 150,
		swap: true,
		swapClass: 'highlight',
		// Change la valeur des ids et names des itemspickers
        onSort: function (evt) {
            reindex();
        }
    });

	new Sortable(vignettesALaUne, {
		group: "vignettes",
		handle: '.vignette-move',
		animation: 150,
		swap: true,
		swapClass: 'highlight',
		// Change la valeur des ids et names des itemspickers
		onSort: function (evt) {
			reindex();
		}
	});

	new Sortable(vignettesItem, {
		group: "vignettes",
		handle: '.vignette-move',
		animation: 150,
		swap: true,
		swapClass: 'highlight',
		// Change la valeur des ids et names des itemspickers
		onSort: function (evt) {
			reindex();
		}
	});

    $('.vignette-delete').on('click', function(event){
        var index = $(this).attr('data-index');
        $('#vignette_' + index).replaceWith($('#vignette_12').clone())
        reindex();
    });

    function reindex(){
        $('.vignette').each(function(i, value) {
            var index = i + 1;
            $(value).attr('id', "vignette_" + index);
            $(value).find('.detail').attr('id', $(value).find('.detail').attr('id').split("classPK_")[0] + "classPK_" + index);
            $(value).find('.eventButton').attr('id', $(value).find('.eventButton').attr('id').split("classPK_")[0] + "classPK_" + index);
            $(value).find('.eventButton').attr('name', $(value).find('.eventButton').attr('name').split("classPK_")[0] + "classPK_" + index);
            $(value).find('.articleButton').attr('id', $(value).find('.articleButton').attr('id').split("classPK_")[0] + "classPK_" + index);
            $(value).find('.articleButton').attr('name', $(value).find('.articleButton').attr('name').split("classPK_")[0] + "classPK_" + index);
            $(value).find('.has-error > input').attr('id', $(value).find('.has-error > input').attr('id').split("classPK_")[0] + "classPK_" + index);
            $(value).find('.has-error > input').attr('name', $(value).find('.has-error > input').attr('name').split("classPK_")[0] + "classPK_" + index);
            $(value).find('.vignette-delete').attr('data-index', index);
        });
    };

</script>