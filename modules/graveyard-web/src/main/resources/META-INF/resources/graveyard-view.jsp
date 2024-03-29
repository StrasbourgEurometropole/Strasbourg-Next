<%@ include file="/graveyard-init.jsp" %>
<fmt:setLocale value="${locale}" />
<c:set var="virtualHostName" value="${virtualHostName}"/>
<c:if test="${empty virtualHostName}">
    <c:set var="homeURL" value="/web/strasbourg.eu/"/>
</c:if>
<c:if test="${not empty virtualHostName}">
    <c:set var="homeURL" value="https://${virtualHostName}/"/>
</c:if>

<liferay-portlet:renderURL varImpl="rechercheURL" />

<%-- Action URL du formulaire --%>
<section id="graveyard">
	<div class="seu-container graveyard-web">
		
		<aui:form name="fm" action="${rechercheURL}" class="generic-form toValidate">
	
	        <div class="webform-layout-box">
				<!-- Nom -->
	            <div class="form-group">
					<div class="title">
						<label for="name"><liferay-ui:message key="graveyard.name" /><strong style="color:red">*</strong></label>
					</div>
					<div class="content">
						<input type="text" id="name" name="<portlet:namespace />name" 
							value="${name}">
					</div>
	            </div>
	
				<!-- Prénom -->
	            <div class="form-group">
					<div class="title">
						<label for="firstname"><liferay-ui:message key="graveyard.firstname" /></label>
					</div>
					<div class="content">
						<input type="text" id="firstname" name="<portlet:namespace />firstname" 
							value="${firstname}">
					</div>
	            </div>
	        </div>
	
	        <div class="webform-layout-box">
				<!-- Date de naissance -->
				<div class="form-group">
		            <div>
						<div class="title">
							<label for="birthdate"><liferay-ui:message key="graveyard.birthdate" /></label>
						</div>
						<div class="content" id="birthDate">
							<input name="<portlet:namespace />birthdate" data-type="date" type="text" id="birthdate" placeholder="JJ/MM/AAAA" 
								value="${birthdate}" <c:if test="${birthdateunknown}">disabled="disabled"</c:if>>
						</div>
					</div>
					<label for="birthdateunknown">
						<input type="checkbox" id="birthdateunknown" name="<portlet:namespace />birthdateunknown" <c:if test="${birthdateunknown }">checked</c:if> />
						<span><span><liferay-ui:message key="graveyard.birthdateunknown" /></span></span>
					</label>
		            <div id="birthRange" <c:if test="${!birthdateunknown }">style="display: none;"</c:if>>
						<div class="title">
							<label for="birthrange"><liferay-ui:message key="graveyard.birthrange" /></label>
						</div>
						<div class="content">
	        				<div class="webform-layout-box">
								<div class="form-group">
									<div class="content">
										<input name="<portlet:namespace />birthdatestart" data-type="date" type="text" id="birthdatestart" placeholder="JJ/MM/AAAA" 
											value="${birthdatestart}">
									</div>
								</div>
								<div class="form-group">
									<div class="content">
										<input name="<portlet:namespace />birthdateend" data-type="date" type="text" id="birthdateend" placeholder="JJ/MM/AAAA" 
											value="${birthdateend}">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	
				<!-- Date de décès -->
				<div class="form-group">
		            <div>
						<div class="title">
							<label for="deathdate"><liferay-ui:message key="graveyard.deathdate" /></label>
						</div>
						<div class="content" id="deathDate" >
							<input name="<portlet:namespace />deathdate" data-type="date" type="text" id="deathdate" class="date-min" placeholder="JJ/MM/AAAA"
								value="${deathdate}" <c:if test="${deathdateunknown }">disabled="disabled"</c:if>>
						</div>
					</div>
					<label for="deathdateunknown">
						<input type="checkbox" id="deathdateunknown" name="<portlet:namespace />deathdateunknown" <c:if test="${deathdateunknown }">checked</c:if> />
						<span><span><liferay-ui:message key="graveyard.deathdateunknown" /></span></span>
					</label>
		            <div id="deathRange" <c:if test="${!deathdateunknown }">style="display: none;"</c:if>>
						<div class="title">
							<label for="deathrange"><liferay-ui:message key="graveyard.deathrange" /></label>
						</div>
						<div class="content">
	        				<div class="webform-layout-box">
								<div class="form-group">
									<div class="content">
										<input name="<portlet:namespace />deathdatestart" data-type="date" type="text" class="date-min" id="deathdatestart" placeholder="JJ/MM/AAAA"
											value="${deathdatestart}">
									</div>
								</div>
								<div class="form-group">
									<div class="content">
										<input name="<portlet:namespace />deathdateend" data-type="date" type="text" class="date-min" id="deathdateend" placeholder="JJ/MM/AAAA"
											value="${deathdateend}">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	        </div>
	
	        <div class="webform-layout-box">
				<!-- Lieu de décès -->
	            <div class="form-group">
					<div class="title">
						<label for="deathplace"><liferay-ui:message key="graveyard.deathplace" /></label>
					</div>
					<div class="content">
						<input type="text" id="deathplace" name="<portlet:namespace />deathplace" 
							value="${deathplace}">
					</div>
				</div>
	
				<!-- Localisation de la concession -->
	            <div class="form-group list" >
	                <div class="form-label"><label for="concession"><liferay-ui:message key="graveyard.concession" /></label></div>
	                <div class="form-field">
	                    <select id="concession" class="toCustomSelect silencedSelect" name="<portlet:namespace />concession">
	                        <option value=""></option>
							<c:forEach var="cimetiere" items="${dc.concessions}">
								<option value="${cimetiere.id}" <c:if test="${concession eq cimetiere.id}">selected</c:if>>${cimetiere.name}</option>
							</c:forEach>
	                    </select>
	                </div>
	            </div>
			</div>
			<br>
			<input type="hidden" id="rechercher" name="<portlet:namespace />rechercher" value="lancer">
			<input type="hidden" id="delta" name="<portlet:namespace />delta" value="4">
			<div class="seu-btn-line">
				<button type="submit" class="seu-btn-square seu-filled seu-core">
					<span class="seu-flexbox">
						<span class="seu-btn-text"><liferay-ui:message key="search" /></span>
						<span class="seu-btn-arrow"></span>
					</span>
				</button>
			</div>
		</aui:form>
	
		<!-- Messages d'erreur géré en backOffice -->	
		<c:if test="${not empty error}">
			<div class="seu-error-messages">${error}</div>
		</c:if>

		<!-- Résultats -->
        <c:if test="${empty error and not empty dc and not empty dc.graveyard}">
            <div id="result">
                <!-- Messages d'erreur au niveau du lien -->
                <c:if test="${dc.graveyard.err eq 1}">
                    <div class="seu-error-messages">${dc.graveyard.err_desc}</div>
                </c:if>
                <c:if test="${dc.graveyard.err eq 0}">
                    <!-- Messages d'erreur géré par l'api -->
                    <c:if test="${not empty dc.graveyard.erreur}">
                        <div class="seu-error-messages">
                            <c:if test="${dc.graveyard.codeErreur == 'LIMITE_DEPASSEE'}">
                                <liferay-ui:message key="too-many-results" />
                                <a href="${dc.contactURL}" target="_blank" title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
                                    <liferay-ui:message key="graveyard.contact" />
                                </a>
                            </c:if>
                            <c:if test="${dc.graveyard.codeErreur != 'LIMITE_DEPASSEE'}">
                                ${dc.graveyard.erreur}
                            </c:if>
                        </div>
                    </c:if>
                    <c:if test="${empty dc.graveyard.erreur}">
                        <div class="graveyard-response rte">
                            <p>
                                <c:choose>
                                    <c:when test="${dc.graveyard.count == '0'}">
                                        <liferay-ui:message key="no-tot" />
                                        <a href="${dc.contactURL}" target="_blank" title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
                                            <liferay-ui:message key="graveyard.contact" />
                                        </a>
                                    </c:when>
                                    <c:when test="${dc.graveyard.count == '1'}">
                                        ${dc.searchContainer.total} <liferay-ui:message key="graveyard.result" />
                                    </c:when>
                                    <c:otherwise>
                                        ${dc.searchContainer.total} <liferay-ui:message key="graveyard.results" />
                                    </c:otherwise>
                                </c:choose>
                            </p>

                            <c:if test="${dc.searchContainer.total gt 0}">
                                <!-- Liste des résultats -->
                                <aui:form method="post" name="fm">
                                    <liferay-ui:search-container id="entriesSearchContainer"
                                                searchContainer="${dc.searchContainer}">
                                        <c:forEach items="${dc.paginatedResults}" var="tot">
                                            <div class="tot">
                                                <span class="name">
                                                    ${tot.firstName} ${tot.name}
                                                    <c:if test="${tot.birthName != ''}">
                                                        (<liferay-ui:message key="graveyard.birthname" arguments=""/> ${tot.birthName})
                                                    </c:if>
                                                </span>

                                                <div class="webform-layout-box">
                                                    <div class="form-group left">
                                                        <!-- Date de naissance -->
                                                        <div class="form-label"><label><liferay-ui:message key="graveyard.birthdate" /></label></div>
                                                        <div class="form-field">
                                                            <c:if test="${tot.birthDate == ''}">
                                                                <liferay-ui:message key="unknown" />
                                                            </c:if>
                                                            <c:if test="${tot.birthDate != ''}">
                                                                ${tot.birthDate}
                                                            </c:if>
                                                        </div>
                                                        <!-- Date du dÃÂ©cÃÂ¨s -->
                                                        <div class="form-label"><label><liferay-ui:message key="graveyard.deathdate" /></label></div>
                                                        <div class="form-field">
                                                            <c:if test="${tot.deathDate == ''}">
                                                                <liferay-ui:message key="unknown" />
                                                            </c:if>
                                                            <c:if test="${tot.deathDate != ''}">
                                                                ${tot.deathDate}
                                                            </c:if>
                                                        </div>
                                                        <!-- Ville du dÃÂ©cÃÂ¨s -->
                                                        <div class="form-label"><label><liferay-ui:message key="graveyard.deathplace" /></label></div>
                                                        <div class="form-field">
                                                            <c:if test="${tot.deathPlace == ''}">
                                                                <liferay-ui:message key="unknown" />
                                                            </c:if>
                                                            <c:if test="${tot.deathPlace != ''}">
                                                                ${tot.deathPlace}
                                                            </c:if>
                                                        </div>
                                                    </div>

                                                    <!-- Localisation de la concession -->
                                                    <div class="form-group">
                                                        <div class="form-label">
                                                            <a href="${homeURL}lieu/-/entity/sig/${tot.graveyardMapping.sigId}/${dc.getNormalizedForURL(tot.graveyardMapping.name)}" target="_blank" title="${tot.graveyardMapping.name} (<liferay-ui:message key="eu.new-window" />)">${tot.graveyardMapping.name}</a>
                                                        </div>
                                                        <div class="form-field"><liferay-ui:message key="graveyard.gravesector" /> : ${tot.graveSector}</div>
                                                        <div class="form-field"><liferay-ui:message key="graveyard.graverow" /> : ${tot.graveRow}</div>
                                                        <div class="form-field"><liferay-ui:message key="graveyard.gravenumber" /> : ${tot.graveNumber}</div>
                                                    </div>
                                                </div>
                                                <div align="right">
                                                    <a href="/o/graveyardweb/images/${tot.graveyardMapping.sigId}.jpg" class="seu-btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="graveyard.downloadPlan" /> (<liferay-ui:message key="eu.new-window" />)">
                                                        <span class="seu-flexbox">
                                                            <span class="seu-btn-text"><liferay-ui:message key="graveyard.downloadPlan" /></span>
                                                            <span class="seu-btn-arrow"></span>
                                                        </span>
                                                    </a>
                                                </div>
                                            </div>
                                        </c:forEach>

                                        <!-- Pagination -->
                                        <c:if test="${dc.pager.lastPage > 1}">
                                            <ul class="seu-pagination unstyled">
                                                <!-- Page précédente -->
                                                <li class="seu-pagin-prev seu-pagin-item">
                                                    <c:if test="${not dc.pager.onFirstPage}">
                                                        <a class="seu-btn-square seu-bordered seu-core" data-action="prev" title="<liferay-ui:message key="go-to-previous-page" />"
                                                            href="${dc.getURLForPage(dc.pager.currentPage - 1)}">
                                                            <span class="seu-flexbox">
                                                                <span class="seu-btn-text"><liferay-ui:message key="previous" /></span>
                                                                <span class="seu-btn-arrow"></span>
                                                            </span>
                                                        </a>
                                                    </c:if>
                                                </li>
                                                <c:forEach var="page" items="${dc.pager.pages}">
                                                    <c:choose>
                                                        <c:when test="${page.isALink() and not (page.index eq dc.pager.currentPage)}">
                                                            <!-- Lien vers page -->
                                                            <li class="seu-pagin-item">
                                                                <a data-page="${page.index}" href="${dc.getURLForPage(page.index)}">
                                                                    <span class="seu-flexbox">
                                                                        <span class="seu-btn-text">${page.label}</span>
                                                                    </span>
                                                                </a>
                                                            </li>
                                                        </c:when>
                                                        <c:when test="${page.isALink() and (page.index eq dc.pager.currentPage)}">
                                                            <!-- Page en cours -->
                                                            <li class="seu-pagin-item seu-is-active">
                                                                <span class="seu-flexbox">
                                                                    <span class="seu-btn-text">${page.label}</span>
                                                                </span>
                                                            </li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <!-- Texte -->
                                                            <li class="seu-pagin-item">
                                                                <span class="seu-flexbox">
                                                                    <span class="seu-btn-text">${page.label}</span>
                                                                </span>
                                                            </li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>

                                                <!-- Page suivante -->
                                                <li class="seu-pagin-next seu-pagin-item">
                                                    <c:if test="${not dc.pager.onLastPage}">
                                                        <a class="seu-btn-square seu-bordered seu-core" title="<liferay-ui:message key="go-to-next-page" />"
                                                            data-action="next" href="${dc.getURLForPage(dc.pager.currentPage + 1)}">
                                                            <span class="seu-flexbox">
                                                                <span class="seu-btn-text"><liferay-ui:message key="next" /></span>
                                                                <span class="seu-btn-arrow"></span>
                                                            </span>
                                                        </a>
                                                    </c:if>
                                                </li>
                                            </ul>
                                        </c:if>
                                    </liferay-ui:search-container>
                                </aui:form>
                            </c:if>
                            <div>
                                <liferay-ui:message key="before-98" />
                                <a href="${dc.contactURL}" target="_blank" title="<liferay-ui:message key="graveyard.contact" /> (<liferay-ui:message key="eu.new-window" />)">
                                    <liferay-ui:message key="graveyard.contact" />
                                </a>
                            </div>
                        </div>
                    </c:if>
                </c:if>
            </div>
        </c:if>
	</div>
</section>

<script>
	$(document).ready(function() {
        $('input[data-type="date"].date-min').datepicker(
            $.extend({
                minDate: new Date(1998,0,1)
            }, $.datepicker.regional[ "fr" ])
        );


		$('#birthdateunknown').on('change', function() {
			if($('#birthdateunknown').is(':checked')){
            	$('#birthDate input').attr({'disabled': 'disabled' });
            	$('#birthDate input').val("");
            	$('#birthRange').show();
			}else{
	            $('#birthDate input').removeAttr('disabled');
	            $('#birthRange').hide();
			}
        });
		$('#deathdateunknown').on('change', function() {
			if($('#deathdateunknown').is(':checked')){
            	$('#deathDate input').attr({'disabled': 'disabled' });
            	$('#deathDate input').val("");
            	$('#deathRange').show();
			}else{
	            $('#deathDate input').removeAttr('disabled');
	            $('#deathRange').hide();
			}
        });
        if($("#result").length > 0) {
            $('html,body').animate({scrollTop: $("#result").offset().top - (($('.seu-nav-bottom #seu-main-menu').length > 0)?115:55)});
        }
	});

</script>