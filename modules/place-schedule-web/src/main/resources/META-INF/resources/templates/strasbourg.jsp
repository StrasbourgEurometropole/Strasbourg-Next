<%@ include file="/place-schedule-init.jsp" %>

<liferay-portlet:renderURL var="searchURL" />

<div class="seu-container">

	<!-- Formulaire de recherche -->
	<aui:form action="${searchURL}" method="post" name="fm" id="search-asset-form" cssClass="seu-view-filters">
		<div class="seu-filter-line">
		    <div class="widget" style="width: calc( 50% - 15px);">
		        <div class="title">
		           <label for="place"><liferay-ui:message key="eu.place" /></label>
		        </div>
		        <div class="content">
		            <select class="toCustomSelect" id="place" name="<portlet:namespace />placeId">
		            	<aui:option value=""></aui:option>
		                <c:forEach var="place" items="${places}">
		                    <c:choose>
		                        <c:when test="${place.placeId == placeId}">
		                            <aui:option value="${place.placeId}" selected="true" >
		                                ${place.getAlias(locale)}
		                            </aui:option>
		                        </c:when>
		                        <c:otherwise>
		                            <aui:option value="${place.placeId}" >
		                                ${place.getAlias(locale)}
		                            </aui:option>
		                        </c:otherwise>
		                    </c:choose>
		                </c:forEach>
		            </select>
		        </div>
		    </div>
		    
		    <div class="widget">
		        <div class="title">
		            <label for="date-start"><liferay-ui:message key="eu.date" /></label>
		        </div>
		        <div class="content">
                    <input name="date" data-type="date" type="text" id="date" placeholder="JJ/MM/AAAA"
                      value="${selectedDay}/${selectedMonth + 1}/${selectedYear}">
		            <input type="hidden" name="<portlet:namespace />day" data-name="dateDay" value="${selectedDay}" />
		            <input type="hidden" name="<portlet:namespace />month" data-name="dateMonth" value="${selectedMonth}" />
		            <input type="hidden" name="<portlet:namespace />year" data-name="dateYear" value="${selectedYear}" />
		        </div>
		    </div>
		</div>
	    
	    <div class="seu-btn-line">
	        <button type="submit" class="seu-btn-square seu-filled seu-core">
	            <span class="seu-flexbox">
	                <span class="seu-btn-text"><liferay-ui:message key="search" /></span>
	                <span class="seu-btn-arrow"></span>
	            </span>
	        </button>
	    </div>
	</aui:form>
	
	<!-- Liste des lieux -->
	<c:forEach items="${selectedPlaces}" var="place">
		<liferay-portlet:renderURL var="detailURL" portletName="eu_strasbourg_portlet_entity_detail_EntityDetailPortlet" windowState="normal" plid="${plId}" >
			<liferay-portlet:param name="classPK" value="${place.placeId}" />
			<liferay-portlet:param name="returnURL" value="${currentURL}" />
		</liferay-portlet:renderURL>
		<div class="seu-place-schedule-thumbnail">
			<a href="${detailURL}" class="item-link">
				<h2>${place.getAlias(locale)}</h2>
			</a>
			<div class="detail-block">
				<div class="item-info">
					<c:if test="${place.isEnabled()}">
						<div class="item-real-time">
							<c:set var="occupationState" value="${place.getRealTime()}" />
							<c:set var="isSwimmingPool" value="${place.isSwimmingPool()}" />
							<c:set var="isIceRink" value="${place.isIceRink()}" />
							<c:set var="isMairie" value="${place.isMairie()}" />
							<c:set var="isParking" value="${place.isParking()}" />
							<div class="crowded-amount ${occupationState.cssClass}" <c:if test="${isMairie}">style="font-size: 1.5rem"</c:if>>
								<c:choose>
									<c:when test="${isSwimmingPool or isIceRink or isMairie}">
										${occupationState.occupationLabel}
									</c:when>
									<c:when test="${isParking}">
											${occupationState.available}
									</c:when>
								</c:choose>
							</div>
							<div class="real-time-info">
								<span class="real-time-title">
									<c:choose>
										<c:when test="${isSwimmingPool or isIceRink}">
											<liferay-ui:message key="live-frequentation" />
										</c:when>
										<c:when test="${isMairie}">
											<liferay-ui:message key="estimated-time" />
										</c:when>
									    <c:when test="${isParking}">
											<liferay-ui:message key="live-occupation" />
										</c:when>
									</c:choose>
								</span>
								<span class="real-time-detail">
									<c:choose>
										<c:when test="${isSwimmingPool or isIceRink or isMairie}">
											<liferay-ui:message key="${occupationState.label}" />
										</c:when>
									    <c:when test="${isParking}">
											<liferay-ui:message key="eu.place.available-spots" /> ${occupationState.available} - <liferay-ui:message key="parking-total-capacity" /> ${occupationState.capacity}
										</c:when>
									</c:choose>
								</span>
							</div>
						</div>
					</c:if>
					<div class="item-geoloc"><span>${place.getCity(locale)}</span></div>
				</div>
				<c:if test="${place.hasURLSchedule}">
                    <div class="rte">
                        <a href="${place.getScheduleLinkURL(locale)}" target="_blank" title="${place.getScheduleLinkName(locale)} (<liferay-ui:message key="eu.new-window" />)">
                            <span class="seu-btn-text">${place.getScheduleLinkName(locale)}</span>
                        </a>
                    </div>
				</c:if>
				<c:if test="${not empty place.periods && !place.hasURLSchedule}">
					<div class="item-schedule">
						<span class="schedule-title">
							<div>
								<liferay-ui:message key="eu.place.schedule-for-day" /> ${jourChoisiFormate}
							</div>
							<div class="schedule">
								<c:forEach items="${place.getPlaceSchedule(selectedCalendar, locale)}" var="schedule" varStatus="loopStatus">
									<c:choose>
										<c:when test="${schedule.isClosed()}">
											<liferay-ui:message key="eu.closed" />
										</c:when>
										<c:when test="${schedule.isAlwaysOpen()}">
											<liferay-ui:message key="always-open" />
										</c:when>
										<c:otherwise>
											<c:forEach items="${schedule.openingTimes}" var="openingTime" varStatus="timeLoopStatus">
												<div>${openingTime.first} - ${openingTime.second}</div>
												<c:if test="${not empty schedule.comments[timeLoopStatus.index]}">
													<div style="text-transform: none; font-weight: 400; margin-top:-10px;">(${schedule.comments[timeLoopStatus.index]})</div>
												</c:if>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</div>
						</span>
						<c:if test="${not empty place.publishedSubPlaces}">
							<div class="subplace-schedule-list">
								<c:forEach items="${place.publishedSubPlaces}" var="subPlace">
									<div class="subplace-schedule">
										<div class="subplace-title">${subPlace.getName(locale)}</div>
										<div class="schedule">
											<c:forEach items="${subPlace.getSubPlaceSchedule(selectedCalendar, locale)}" var="schedule" varStatus="loopStatus">
												<c:choose>
													<c:when test="${schedule.isClosed()}">
														<liferay-ui:message key="eu.closed" />
													</c:when>
													<c:when test="${schedule.isAlwaysOpen()}">
														<liferay-ui:message key="always-open" />
													</c:when>
													<c:otherwise>
														<c:forEach items="${schedule.openingTimes}" var="openingTime" varStatus="timeLoopStatus">
															<div>${openingTime.first} - ${openingTime.second}</div>
															<c:if test="${not empty schedule.comments[timeLoopStatus.index]}">
																<div style="text-transform: none; font-weight: 400; margin-top:-10px;">(${schedule.comments[timeLoopStatus.index]})</div>
															</c:if>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</div>
									</div>
								</c:forEach>
							</div>
						</c:if>
					</div>
				</c:if>
				<div class="btn-line">
					<a href="${detailURL}" title="${place.getAlias(locale)}">
						<button type="button" class="seu-btn-square--filled--second">
					    	<span class="seu-flexbox">
					        	<span class="seu-btn-text"><liferay-ui:message key="eu.place.more-information" /></span>
					            <span class="seu-btn-arrow"></span>
					        </span>
					    </button>
					</a>
				</div>
			</div>
		</div>
	</c:forEach>

</div>