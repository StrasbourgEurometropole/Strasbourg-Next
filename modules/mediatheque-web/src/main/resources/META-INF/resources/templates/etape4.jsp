<%@ include file="/mediatheque-init.jsp" %>

<section id="mediatheque">
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
		<!-- Etape 4 -->
        <div class="webform-layout-box">
			<!-- Numéro de carte -->
            <div class="form-group">
				<div class="title">
					<label><liferay-ui:message key="card-number" /></label>
				</div>
				<div class="content">
					<p>${dc.borrower.cardNumber}</p>
				</div>
            </div>

			<!-- date d'échéance -->
            <div class="form-group">
				<div class="title">
					<label><liferay-ui:message key="due-date" /></label>
				</div>
				<div class="content">
					<p>
						<c:if test="${dc.borrower.expireDate != null}">
							<fmt:parseDate value="${dc.borrower.expireDate}" pattern="yyyy-MM-dd" var="expireDate" type="both" />
							<fmt:formatDate value="${expireDate}" type="date" var="newExpireDate" pattern="dd/MM/yyyy" />
							${newExpireDate}
						</c:if>
					</p>
				</div>
            </div>
        </div>
		<c:if test="${dc.borrower.expireDate != null}">
	        <c:set var="today" value="${dc.today}" />
	        <c:if test="${today.isAfter(dc.borrower.expireDate)}">
	        	<div class="warning">
	        		<strong><liferay-ui:message key="warning" /></strong><br>
	        		<liferay-ui:message key="warning-text" />
	        	</div>
	        </c:if>
			<c:set var="nextMonth" value="${today.plusMonths(1)}"/>
	        <c:if test="${nextMonth.isAfter(dc.borrower.expireDate)}">
	        	<div class="information">
	        		<strong><liferay-ui:message key="information" /></strong><br>
	        		<liferay-ui:message key="information-text" />
	        	</div>
	        </c:if>
		</c:if>
        <div class="webform-layout-box">
			<!-- Médias empruntés -->
			<c:set var="borrowings" value="${dc.borrower.borrowings}"/>
            <div class="form-group">
				<div class="upper-title">
					<label><liferay-ui:message key="borrowings-medias" /> : ${fn:length(borrowings)}</label>
				</div>
				<input type="hidden" id="borrowingCount" value="${fn:length(borrowings)}" />
				<c:forEach items="${borrowings}" var="media" varStatus="count"> 
        			<div id="borrowing_${count.index}" class="borrowing 
	        			<c:if test="${media.returnDate != null && today.isAfter(media.returnDate)}">
	        				out-of-date
						</c:if>
	        			<c:if test="${count.index gt 2}">
	        				hidden
						</c:if>
					">
						<div class="title">
							<label>${media.name}<c:if test="${fn:length(media.name) eq 25}"> ...</c:if></label>
						</div>
						<p>
		        			<c:if test="${not empty dc.getType(media.type)}">
								${dc.getType(media.type)}<br>
							</c:if>
							<c:if test="${media.returnDate != null}">
			        			<c:if test="${today.isAfter(media.returnDate)}">
			        				<liferay-ui:message key="return-date-passed" />
								</c:if>
			        			<c:if test="${!today.isAfter(media.returnDate)}">
			        				<liferay-ui:message key="return-date" />
								</c:if>
								 : 
			        			<c:if test="${not empty media.returnDate}">
									<fmt:parseDate value="${media.returnDate}" pattern="yyyy-MM-dd" var="returnDate" type="both" />
									<fmt:formatDate value="${returnDate}" type="date" var="newReturnDate" pattern="dd/MM/yyyy" />
									${newReturnDate}
								</c:if>
							</c:if>
						</p>
        			</div>
				</c:forEach>
	        	<c:if test="${fn:length(borrowings) gt 3}">
		        	<div>
						<a class="btn-square--bordered--core" title="<liferay-ui:message key="eu.see-more" />" id="borrowingSeeMore">
							<span class="flexbox">
								<span class="btn-text"><liferay-ui:message key="eu.see-more" /></span>
								<span class="btn-arrow"></span>
							</span>
						</a>
						<a class="btn-square--bordered--core hidden" title="<liferay-ui:message key="eu.see-less" />" id="borrowingSeeLess">
							<span class="flexbox">
								<span class="btn-text"><liferay-ui:message key="eu.see-less" /></span>
								<span class="btn-arrow"></span>
							</span>
						</a>
		        	</div>
				</c:if>
            </div>

			<!-- Médias réservés -->
			<c:set var="reservations" value="${dc.borrower.reservations}"/>
            <div class="form-group">
				<div class="upper-title">
					<label><liferay-ui:message key="reservations-medias" /> : ${fn:length(reservations)}</label>
				</div>
				<input type="hidden" id="reservationCount" value="${fn:length(reservations)}" />
				<c:forEach items="${reservations}" var="media" varStatus="count">
        			<div id="reservation_${count.index}" class="reservation 
	        			<c:if test="${count.index gt 2}">
	        				hidden
						</c:if>
					">
						<div class="title">
							<label>${media.name}<c:if test="${fn:length(media.name) eq 25}"> ...</c:if></label>
						</div>
						<c:if test="${not empty dc.getType(media.type)}">
							<p>
								${dc.getType(media.type)}
							</p>
						</c:if>
					</div>
				</c:forEach>
	        	<c:if test="${fn:length(reservations) gt 3}">
		        	<div>
						<a class="btn-square--bordered--core" title="<liferay-ui:message key="eu.see-more" />" id="reservationSeeMore">
							<span class="flexbox">
								<span class="btn-text"><liferay-ui:message key="eu.see-more" /></span>
								<span class="btn-arrow"></span>
							</span>
						</a>
						<a class="btn-square--bordered--core hidden" title="<liferay-ui:message key="eu.see-less" />" id="reservationSeeLess">
							<span class="flexbox">
								<span class="btn-text"><liferay-ui:message key="eu.see-less" /></span>
								<span class="btn-arrow"></span>
							</span>
						</a>
		        	</div>
				</c:if>
            </div>
        </div>
	
		<div align="center">
			<a href="${dc.mediathequeURL}" class="btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="site-mediatheques" /> (<liferay-ui:message key="eu.new-window" />)">
				<span class="flexbox">
					<span class="btn-text"><liferay-ui:message key="site-mediatheques" /></span>
					<span class="btn-arrow"></span>
				</span>
			</a>
		</div>
		
		
		<!-- Dissocier -->
		<div class="upper-title">
			<label><liferay-ui:message key="dissociate" /></label>
		</div>
		<p><liferay-ui:message key="dissociate-text" /></p>
		<div align="center">
			<liferay-portlet:renderURL varImpl="dissociateURL" >
				<portlet:param name="dissociate" value="dissocier" />
			</liferay-portlet:renderURL>
			<a href="${dissociateURL}#mediatheque" class="btn-square--bordered--core" title="<liferay-ui:message key="dissociate" />" data-dissociateconfirm="dissociate">
				<span class="flexbox">
					<span class="btn-text"><liferay-ui:message key="dissociate" /></span>
					<span class="btn-arrow"></span>
				</span>
			</a>
		</div>
    </div>
</section>