<%@ include file="/search-asset-init.jsp"%>
<div class="st-barre-listing-sit st-js-barre-listing-filtre">
	<div class="st-barre-inner st-wrapper">
			<c:if test="${dc.dateField}">
				<div class="st-filtre">
					<label for="date-start"><liferay-ui:message key="eu.event.from-date" /></label>
					<input name="from" data-type="date" type="text" id="date-start" placeholder="JJ/MM/AAAA"
						   value="${dc.fromDay}/${dc.fromMonthValue}/${dc.fromYear}">
					<input type="hidden" name="<portlet:namespace />fromDay" data-name="fromDay" value="${dc.fromDay}" />
					<input type="hidden" name="<portlet:namespace />fromMonth" data-name="fromMonth" value="${dc.fromMonthIndex}" />
					<input type="hidden" name="<portlet:namespace />fromYear" data-name="fromYear" value="${dc.fromYear}" />
				</div>
				<div class="st-filtre">
					<label for="date-end"><liferay-ui:message key="eu.event.to" /></label>
					<input name="to" data-type="date" type="text" id="date-end" placeholder="JJ/MM/AAAA"
						   value="${dc.toDay}/${dc.toMonthValue}/${dc.toYear}">
					<input type="hidden" name="<portlet:namespace />toDay" data-name="toDay" value="${dc.toDay}" />
					<input type="hidden" name="<portlet:namespace />toMonth" data-name="toMonth" value="${dc.toMonthIndex}" />
					<input type="hidden" name="<portlet:namespace />toYear" data-name="toYear" value="${dc.toYear}" />
				</div>
			</c:if>
		<div class="st-filtre">
			<label for="name"><liferay-ui:message key="keywords" /></label>
			<input type="text" id="name" name="<portlet:namespace />keywords"
				   placeholder="<liferay-ui:message key="please-enter-keyword" />" value="${dc.keywords}" >
		</div>


		<c:forEach items="${dc.vocabularies}" var="vocabulary"
				varStatus="vocStatus">
		<div class="st-filtre st--is-select">
			<label for="vocabulary_${vocStatus.index}" >
				${not empty vocabulary.getDescription(locale) ? vocabulary.getDescription(locale) : vocabulary.getTitle(locale)}
			</label>
			<select class="" id="vocabulary_${vocStatus.index}" name="<portlet:namespace />vocabulary_${vocStatus.index}">
				<c:forEach items="${dc.getSortedCategories(vocabulary)}" var="category">
					<c:set var="category" value="${category}" scope="request"/>
					<c:set var="dc" value="${dc}" scope="request"/>
					<c:set var="level" value="0" scope="request" />
					<jsp:include page="/forms/category-option.jsp"/>
				</c:forEach>
			</select>
		</div>
		    </c:forEach>
		<aui:input type="hidden" name="vocabulariesCount" value="${fn:length(dc.vocabularies)}" />
		<div class="col-right">
			<liferay-portlet:renderURL var="formURL" />
			    <button type="button" onclick="window.location.href = '${formURL}'" class="st-btn st--btn-filtres">
					<liferay-ui:message key="cancel" />
			    </button>
			    <button type="submit" class="st-btn st--btn-filtres">
					<liferay-ui:message key="search" />
			    </button>
		</div>
	</div>
</div>