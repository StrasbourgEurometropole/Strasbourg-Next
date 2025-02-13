<%@ include file="/init.jsp"%>

<portlet:actionURL var="saveProfilURL" name="saveProfil">
	<portlet:param name="redirectURL" value="${redirectURL}" />
	<portlet:param name="cmd" value="saveProfil" />
</portlet:actionURL>
<jsp:useBean id="uriHelper" class="eu.strasbourg.utils.UriHelper"/>

<portlet:actionURL var="resetSupportsURL" name="resetSupports">
	<portlet:param name="redirectURL" value="${redirectURL}" />
	<portlet:param name="cmd" value="resetSupports" />
</portlet:actionURL>

<c:if test="${!isUserloggedIn}">
	<script>
        $("#myModal").modal("show");
    </script>
</c:if>

<c:if test="${isUserloggedIn}">

	<!-- MODAL DE PREMIER VOTE NEGATIF A UN BUDGET PARTICIPATIF -->
	<!-- HTML pour la modal de contestation d'un budget participatif -->
	<div class="pro-modal pro-bloc-pcs-form fade" id="modalReset" tabindex="-1" role="dialog" aria-labelledby="modalUnsupport">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<div class="pro-modal-top">
					<h3><liferay-ui:message key="dashboard.modal.title"/></h3>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true"><span class="icon-multiply"></span></span>
					</button>
				</div>

				<div class="pro-wrapper">
					<h4></h4>

					<form id="form-reset-budget-support" method="post" action="${resetSupportsURL}">
						<!-- Bonton de soumission -->
						<div class="centerButtonValidation">
							<input id="resetSupports" type="submit" class="pro-btn-yellow" value="Valider">
						</div>
					</form>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<div class="pro-bloc-dashboard">

		<div class="container pro-wrapper-dashboard">

			<!-- ONGLET ACTIVITE -->
			<div id="pro-onglet-activite">
				<div class="pro-title-dashboard col-xs-12">
					<h1>
						<liferay-ui:message key="dashboard.front.myactivity" />
					</h1>
					<div class="pro-user">
						<span><liferay-ui:message key="dashboard.front.welcome" />
							<span id="pro-user-name">
								<c:out value="${userConnected.get('first_name')}" escapeXml='true'/> <c:out value="${userConnected.get('last_name')}" escapeXml='true'/>
							</span>
						</span>
						<a href="#pro-onglet-account">
							<figure>
								<img src="${userConnected.get('photo')}" width="40" height="40" alt="Nom de l'utilisateur" />
							</figure>
							<span><liferay-ui:message key="dashboard.front.profil" /></span>
						</a>
					</div>
				</div>

				<div class="col-lg-3 col-sm-6 col-xs-12">
					<a href="#pro-link-listing-projet" class="pro-item pro-item-projet">
						<div class="pro-item-center">
							<span class="pro-number">${projectFollowedsCount}</span>
							<span class="pro-txt"><liferay-ui:message key="dashboard.front.project" /></span>
						</div>
						<div class="pro-link-dashboard">
							<span class="pro-txt"><liferay-ui:message key="dashboard.front.event.goto" /></span>
						</div>
					</a>
					<a href="#pro-link-listing-event" class="pro-item pro-item-agenda">
						<div class="pro-item-center">
							<span class="pro-number">${eventCount}</span>
							<span class="pro-txt"><liferay-ui:message key="dashboard.front.event" /></span>
						</div>
						<div class="pro-link-dashboard">
							<span class="pro-txt"><liferay-ui:message key="dashboard.front.event.goto" /></span>
						</div>
					</a>
				</div>

				<div class="col-lg-3 col-sm-6 col-xs-12">
					<div class="pro-item pro-item-petition">
						<div class="pro-item-center">
							<span class="pro-number">${petitionsFiledCount+petitionSignedCount}</span>
							<span class="pro-txt"><liferay-ui:message key="dashboard.front.petition" /></span>
						</div>
						<div class="pro-link-dashboard">
							<a href="#pro-link-listing-petition-signe" class="pro-txt">
								<strong>${petitionSignedCount}</strong>
								<liferay-ui:message key="dashboard.front.petition.signed" />
							</a>
							<a href="#pro-link-listing-petition-depose" class="pro-txt">
								<strong>${petitionsFiledCount}</strong>
								<liferay-ui:message key="dashboard.front.petition.filed" />
							</a>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-sm-6 col-xs-12">
					<div class="pro-item pro-item-initiative">
						<div class="pro-item-center">
							<div>
								<span class="icon-ico-initiative"></span>
								<span class="pro-txt"><liferay-ui:message key="dashboard.front.initiative" /></span>
							</div>
						</div>
						<div class="pro-bloc-link-dashboard">
							<a href="#pro-link-listing-initiative-signe" class="pro-txt">
								<strong>${initiativeFiledsCount}</strong>
								<span><liferay-ui:message key="dashboard.front.initiative.signed" /></span>
							</a>
							<a href="#pro-link-listing-initiative-aide" class="pro-txt">
								<strong>${initiativeAidesCount}</strong>
								<span><liferay-ui:message key="dashboard.front.initiative.aidees" /></span>
							</a>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-sm-6 col-xs-12">
					<div class="pro-item pro-item-budget">
						<div class="pro-item-center">
							<p></p>
						</div>
						<div class="pro-title-budget">
							<span class="pro-number">${budgetFiled.size() + budgetVoted.size()}</span>
							<span class="pro-title"><liferay-ui:message key="dashboard.front.budget" /></span>
						</div>

						<div class="pro-link-dashboard">
							<a href="#pro-link-listing-projet-soumis" class="pro-txt">
								<strong>${budgetFiled.size()}</strong>
								<span><liferay-ui:message key="dashboard.front.budget.filed" /></span>
							</a>
							<a href="#pro-link-listing-projet-vote" class="pro-txt">
								<strong>${budgetVoted.size()}</strong>
								<span><liferay-ui:message key="dashboard.front.budget.voted" /></span>
							</a>
						</div>

						<c:if test="${voteLeft != ''}">
							<div class="pro-info-vote">
								<span>
									<liferay-ui:message key="dashboard.front.budget.reliquat" />
									<strong>
										${voteLeft}
										<liferay-ui:message key="dashboard.front.budget.reliquat2" />
									</strong>
								</span>
							</div>
						</c:if>

						<c:if test="${showResetButton}">
							<!-- Bonton de réinitialisation -->
							<div class="pro-info-reset">
								<a id="resetBudgetSupports" href="#popin" class="pro-btn-black " data-toggle="modal" data-target="#modalReset">
									<liferay-ui:message key="dashboard.reset.support" />
								</a>
							</div>
						</c:if>
					</div>
				</div>
			</div>

			<!-- ONGLET ACCOUNT -->
			<div id="pro-onglet-account" class="pro-hide">
				<div class="pro-title-dashboard col-xs-12">
					<h2>
						<liferay-ui:message key="dashboard.account.title" />
					</h2>
					<span></span>
				</div>
				<div class="col-xs-12">
					<a href="#pro-onglet-activite" class="pro-btn-back"><liferay-ui:message
							key="dashboard.account.information" /></a>
				</div>

				<form id="form-save-profil" method="post" action="${saveProfilURL}">
					<div class="pro-wrapper col-md-3">
						<div class="profile">
							<div class="photo">
								<div class="photo__helper">
									<div class="photo__frame photo__frame--circle">
										<a href="${profilePictureURL}">
											<img src="${userConnected.get('photo')}" width="185" height="185" alt="Image" class="pro-img-bg" />
											<canvas class="photo__canvas"></canvas>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="pro-wrapper col-md-9">
						<div class="pro-row">
							<div class="form-group form-third">
								<aui:input name="username" disabled="true"
									label="dashboard.account.profile.username" required="true"
									value="${userConnected.get('last_name')}" />
							</div>
							<div class="form-group form-third">
								<aui:input name="firstname" disabled="true"
									label="dashboard.account.profile.firstname"
									value="${userConnected.get('first_name')}" />
							</div>
							<div class="form-group form-third">
								<c:if test="${userConnected.get('birthdate') ne 'null'}">
									<fmt:parseDate pattern="yyyy-MM-dd" value="${userConnected.get('birthdate')}" var="parsedStatusDate" />
									<fmt:formatDate value="${parsedStatusDate}" var="formattedDate" type="date" pattern="dd/MM/yyyy" />
								</c:if>
								<aui:input name="birthday" cssClass="frm_date" label="dashboard.account.profile.birthday" required="true" placeholder="jj/mm/aaaa" value="${formattedDate}" />
							</div>
						</div>
						<div class="pro-row">
							<div class="form-group form-half">
								<aui:input name="address"
									label="dashboard.account.profile.address"
									value="${userConnected.get('address')}" />
							</div>
							<div class="form-group form-half">
								<div class="form-city">
									<aui:input name="city" label="dashboard.account.profile.city"
										required="true" placeholder="Strasbourg"
										value="${userConnected.get('city')}" />
								</div>
								<div class="form-code">
									<aui:input name="postalcode"
										label="dashboard.account.profile.postalcode"
										placeholder="67XXX" value="${userConnected.get('zipcode')}" />
								</div>
							</div>
						</div>
						<div class="pro-row">
							<div class="form-group form-third">
								<aui:input type="email" name="mail" disabled="true"
									label="dashboard.account.profile.mail"
									value="${userConnected.get('email')}" />
							</div>
							<div class="form-group form-third">
								<aui:input type="number" name="phone"
									label="dashboard.account.profile.phone"
									placeholder="0311111111" value="${userConnected.get('phone')}" />
							</div>
							<div class="form-group form-third">
								<aui:input type="number" name="mobile"
									label="dashboard.account.profile.mobile"
									placeholder="0611111111" value="${userConnected.get('mobile')}" />
							</div>
						</div>
						
						<div class="pro-row">
							<div class="form-group displayListing2">
				            	<aui:input name="displayListing" type="checkbox" checked="${isDisplayListing}" />
							</div>
						</div>
						
						<div class="pro-form-submit pro-row">
							<button type="submit" class="btn btn-default">
								<liferay-ui:message key="dashboard.account.profile.button.save" />
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="pro-wrapper-list-dashboard">
		<!-- LISTING DE TUILES -->
		<!--     projets -->
		<c:if test="${projectFollowedsCount != 0}">
			<section id="pro-link-listing-projet" class="pro-bloc-slider">
				<div class="container">
					<h2>
						<liferay-ui:message key="dashboard.thumbnail.project.title" />
						(${projectFollowedsCount})
					</h2>
					<a href="${homeURL}projets" class="pro-btn"
					   title="<liferay-ui:message key='dashboard.thumbnail.project.link.title'/>">
						<liferay-ui:message key="dashboard.thumbnail.project.link" />
					</a>

					<!-- SlIDER LISTE DES PROJETS - TOUS LES PROJETS -->
					<div id="pro-projet-all"
						 class="owl-carousel owl-opacify owl-theme owl-cards owl-projet">
						<c:forEach var="projectFollowed" items="${projectFolloweds}">
							<div class="item bloc-card-projet">
								<a href="${projectFollowed.detailURL}" title="<liferay-ui:message key='dashboard.thumbnail.link'/>">
									<div class="img">
										<figure role="group">
											<img src='${projectFollowed.imageURL}?imagePreview=1' loading="lazy" alt="Image projet" width="360" height="242" class="fit-cover"/>
										</figure>

									</div>
									<div class="content">
										<span class="location">${projectFollowed.getDistrictLabel(locale)}</span>
										<h3>${projectFollowed.title}</h3>
									</div>
									<ul>
										<li>
											<span>Voir le projet</span>
										</li>
									</ul>

								</a>
								<ul>

									<li>
										<a href="${projectFollowed.detailURL}#pro-link-participation" title="Participation(s) du projet" tabindex="-1">
												${fn:length(projectFollowed.getParticipations())}  <liferay-ui:message
														key="dashboard.thumbnail.project.participation" />
										</a>
									</li>
									<li>
										<a href="${projectFollowed.detailURL}#pro-link-evenement" title="Événement(s) du projet" tabindex="-1">
												${fn:length(projectFollowed.getEvents())} <liferay-ui:message
														key="dashboard.thumbnail.project.events" />
										</a>
									</li>
								</ul>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</c:if>


		<!--    event -->
		<c:if test="${eventCount != 0}">
			<section id="pro-link-listing-event"
				class="pro-bloc-slider pro-slider-event">
				<div class="container">
					<h2>Mon agenda (${eventCount})</h2>
					<a href="${homeURL}agenda" class="pro-btn"
						title="<liferay-ui:message key='dashboard.thumbnail.agenda.title'/>">
						<liferay-ui:message key="dashboard.thumbnail.agenda" />
					</a>

					<div class="owl-carousel owl-opacify owl-theme owl-cards">
						<c:forEach var="event" items="${event}">
							<div class="item pro-bloc-card-event" data-linkall="a">
								<div>
									<div class="pro-header-event">
										<span class="pro-time">${event.getCurrentOrFuturePeriodStringDate()}</time></span>
										<a
											href="${homeURL}detail-evenement/-/entity/id/${event.eventId}/${event.getNormalizedTitle(locale)}"
											title="<liferay-ui:message key='dashboard.thumbnail.link'/>"><h3>${event.getTitle(locale)}</h3></a>
										<span class="prefix-location">
												${event.getPlaceAlias(locale)}
										</span>
									</div>
									<div class="pro-footer-event">
										 <span
											class="pro-number"><strong>${event.getNbEventParticipations()}</strong>
											<liferay-ui:message
												key="dashboard.thumbnail.agenda.participant" /></span>
										<span class="pro-btn-action active"><liferay-ui:message
												key="dashboard.thumbnail.agenda.participe" /></span>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</c:if>

		<!-- Tuile des petitions signes -->		<c:if test="${petitionSignedCount ne 0}">
			<section id="pro-link-listing-petition-signe"
				class="pro-bloc-slider pro-slider-event">
				<div class="container">
					<h2>
						<liferay-ui:message key="dashboard.thumbnail.petition.signed.mine" />
						(${petitionSignedCount})
					</h2>
					<a href="${homeURL}petitions" class="pro-btn"
						title="<liferay-ui:message key='dashboard.thumbnail.petition.main.alt'/>"><liferay-ui:message
							key="dashboard.thumbnail.petition.main" /></a>

					<div class="owl-carousel owl-opacify owl-theme owl-cards">
						<c:forEach var="petitionSigned" items="${petitionSigned}">
							<div class="item pro-bloc-card-petition" data-linkall="a">
								<div class="pro-header-petition">
									<figure role="group">
										<img src="${petitionSigned.getAuthorImageURL()}" width="40" height="40" alt=<liferay-ui:message
												key="dashboard.thumbnail.petition.img.alt" />/>
									</figure>
									<p>
										<liferay-ui:message key="dashboard.thumbnail.petition.from" />
									</p>
									<p>
										<strong>
											<c:out value="${petitionSigned.petitionnaireFirstname}" escapeXml='true' />
											<c:out value="${petitionSigned.petitionnaireLastname}" escapeXml='true' />
										</strong>
									</p>
								</div>
								<div class="pro-content-petition">
									<div class="pro-meta">
										<span>${petitionSigned.getFrontStatusFR()}</span>
										<span>${petitionSigned.getThematicLabel(locale)}</span>
									</div>
									<span class="prefix-location">
											${petitionSigned.getDistrictLabel(locale)}
									</span>
									<a href="${homeURL}detail-petition/-/entity/id/${petitionSigned.petitionId}"
									   title="<liferay-ui:message key='dashboard.thumbnail.link'/>">
										<h3>
											<c:out value="${petitionSigned.title}" escapeXml='true' />
										</h3>
									</a>
									<p>
										<liferay-ui:message key="dashboard.thumbnail.petition.to" />
									</p>
									<span class="pro-time"><liferay-ui:message key="dashboard.thumbnail.petition.publish.date" /> <time
											datetime="${petitionSigned.getPublicationDateFr()}">${petitionSigned.getPublicationDateFr()}</time>
				/ <span class="pro-duree">${petitionSigned.getProDureeFR()}</span></span>

								</div>
								<div class="footer-comment">
									<span>${petitionSigned.getApprovedComments().size()} Commentaires</span>
								</div>
								<div class="pro-footer-petition">
									<div class="pro-progress-bar">
										<div class="pro-progress-container">
											<div style="width:${petitionSigned.getPourcentageSignature()}%"></div>
										</div>
										<p class="pro-txt-progress">
											<strong> ${petitionSigned.getNombreSignature()} </strong>
											<liferay-ui:message key="dashboard.thumbnail.petition.progress" />
												${petitionSigned.getQuotaSignature()}
											<liferay-ui:message key="dashboard.thumbnail.petition.progress2" />
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</c:if>

		<!-- Tuile des petitions deposees -->
		<c:if test="${petitionsFiledCount != 0}">
			<section id="pro-link-listing-petition-depose"
				class="pro-bloc-slider pro-slider-event">
				<div class="container">
					<h2>
						<liferay-ui:message key="dashboard.thumbnail.petition.filed.mine" />
						(${petitionsFiledCount})
					</h2>
					<a href="${homeURL}petitions" class="pro-btn"
						title="<liferay-ui:message key='dashboard.thumbnail.petition.main.alt'/>"><liferay-ui:message
							key="dashboard.thumbnail.petition.main" /></a>

					<div class="owl-carousel owl-opacify owl-theme owl-cards">
						<c:forEach var="petitionFiled" items="${petitionsFiled}">
							<div class="item pro-bloc-card-petition" data-linkall="a">
								<div class="pro-header-petition">
									<figure role="group">
										<img src="${petitionFiled.getAuthorImageURL()}" width="40" height="40" alt=<liferay-ui:message
												key="dashboard.thumbnail.petition.img.alt" />/>
									</figure>
									<p>
										<liferay-ui:message key="dashboard.thumbnail.petition.from" />
									</p>
									<p>
										<strong>
											<c:out value="${petitionFiled.petitionnaireFirstname}" escapeXml='true' />
											<c:out value="${petitionFiled.petitionnaireLastname}" escapeXml='true' />
										</strong>
									</p>
								</div>
								<div class="pro-content-petition">
									<div class="pro-meta">
											<span>${petitionFiled.getFrontStatusFR()}</span>
										<span>${petitionFiled.getThematicLabel(locale)}</span>
									</div>
									<span class="prefix-location">
											${petitionFiled.getDistrictLabel(locale)}
									</span>
									<a href="${homeURL}detail-petition/-/entity/id/${petitionFiled.petitionId}"
									   title="<liferay-ui:message key='dashboard.thumbnail.link'/>">
										<h3>
											<c:out value="${petitionFiled.title}" escapeXml='true' />
										</h3>
									</a>
									<p>
										<liferay-ui:message key="dashboard.thumbnail.petition.to" />
									</p>
									<span class="pro-time"><liferay-ui:message key="dashboard.thumbnail.petition.publish.date" /> <time
											datetime="${petitionFiled.getPublicationDateFr()}">${petitionFiled.getPublicationDateFr()}</time>
				/ <span class="pro-duree">${petitionFiled.getProDureeFR()}</span></span>

								</div>
								<div class="footer-comment">
									<span>${petitionFiled.getApprovedComments().size()} Commentaires</span>
								</div>
								<div class="pro-footer-petition">
									<div class="pro-progress-bar">
										<div class="pro-progress-container">
											<div style="width:${petitionFiled.getPourcentageSignature()}%"></div>
										</div>
										<p class="pro-txt-progress">
											<strong> ${petitionFiled.getNombreSignature()} </strong>
											<liferay-ui:message key="dashboard.thumbnail.petition.progress" />
												${petitionFiled.getQuotaSignature()}
											<liferay-ui:message key="dashboard.thumbnail.petition.progress2" />
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</c:if>

		<!-- Tuile des initiatives depose -->
		<c:if test="${initiativeFiledsCount != 0}">
			<section id="pro-link-listing-initiative-depose"
				class="pro-bloc-slider pro-slider-event">
				<div class="container">
					<h2><liferay-ui:message key="dashboard.thumbnail.initiative.signed.mine" />
						(${initiativeFiledsCount})</h2>
					<a href="${homeURL}ateliers-quartier" class="pro-btn"
						title="<liferay-ui:message key='dashboard.thumbnail.initiative.main.alt'/>"><liferay-ui:message
							key="dashboard.thumbnail.initiative.main" /></a>

					<div class="owl-carousel owl-opacify owl-theme owl-cards">
						<c:forEach var="initiative" items="${initiativeFileds}">
							<div class="item pro-bloc-card-budget" data-linkall="a">
								<c:if test="${initiative.getImageURL() != ''}">
									<figure role="group" class="fit-cover">
										<img src="${initiative.getImageURL()}" width="155" height="200" alt="Image atelier"/>
									</figure>
								</c:if>
								<div class="pro-header-budget">
									<figure role="group">
										<img src="${initiative.getAuthorImageURL()}" width="40" height="40" alt=<liferay-ui:message key="dashboard.thumbnail.petition.img.alt"/>/>
									</figure>
									<p><liferay-ui:message key="dashboard.thumbnail.initiative.from" /></p>
									<p>
										<strong><c:out value="${initiative.getAuthorLabel()}" escapeXml='true'/></strong>
									</p>
									<div class="pro-info-top-right">
										<span class="pro-encart-theme encart-budget">
												${initiative.getStatusCategory().getTitle(locale)}
										</span>
										<c:forEach items="${initiative.getThematicCategories()}" var="assetCategory">
											 <span class="pro-encart-theme encart-budget">
													 ${assetCategory.toString()}
											 </span>
										</c:forEach>
									</div>
								</div>
								<div class="pro-content-budget">
                                <span class="prefix-location">
                                    Strasbourg
                                </span>
									<a href="${homeURL}detail-atelier/-/entity/id/${initiative.initiativeId}" title="lien de la page de détail">
										<h3><c:out value="${initiative.title}" escapeXml='true'/></h3>
									</a>
									<span class="pro-time">
                                    <liferay-ui:message key="dashboard.thumbnail.initiative.publish.date" />
                                    <time datetime="${initiative.getPublicationDateFr()}">${initiative.getPublicationDateFr()}</time>
                                </span>
								</div>

								<div class="pro-footer-budget">
									<p>
										<strong>${initiative.getNbHelps()} Citoyens-nes</strong> ont soutenus cette initiative
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</c:if>

		<!-- Tuile des initiatives aidees -->
		<c:if test="${initiativeAidesCount != 0}">
			<section id="pro-link-listing-initiative-aide"
				class="pro-bloc-slider pro-slider-event">
				<div class="container">
					<h2><liferay-ui:message key="dashboard.thumbnail.initiative.filed.mine" />
						(${initiativeAidesCount})</h2>
					<a href="${homeURL}ateliers-quartier" class="pro-btn"
						title="<liferay-ui:message key='dashboard.thumbnail.initiative.main.alt'/>"><liferay-ui:message
							key="dashboard.thumbnail.initiative.main" /></a>

					<div class="owl-carousel owl-opacify owl-theme owl-cards">
						<c:forEach var="initiative" items="${initiativeAides}">
							<div class="item pro-bloc-card-budget" data-linkall="a">
								<c:if test="${initiative.getImageURL() != ''}">
									<figure role="group" class="fit-cover">
										<img src="${initiative.getImageURL()}" width="155" height="200" alt="Image atelier"/>
									</figure>
								</c:if>
								<div class="pro-header-budget">
									<figure role="group">
										<img src="${initiative.getAuthorImageURL()}" width="40" height="40" alt=<liferay-ui:message key="dashboard.thumbnail.petition.img.alt"/>/>
									</figure>
									<p><liferay-ui:message key="dashboard.thumbnail.initiative.from" /></p>
									<p>
										<strong><c:out value="${initiative.getAuthorLabel()}" escapeXml='true'/></strong>
									</p>
									<div class="pro-info-top-right">
										<span class="pro-encart-theme encart-budget">
												${initiative.getStatusCategory().getTitle(locale)}
										</span>
										<c:forEach items="${initiative.getThematicCategories()}" var="assetCategory">
											 <span class="pro-encart-theme encart-budget">
													 ${assetCategory.toString()}
											 </span>
										</c:forEach>
									</div>
								</div>
								<div class="pro-content-budget">
                                <span class="prefix-location">
                                    Strasbourg
                                </span>
									<a href="${homeURL}detail-atelier/-/entity/id/${initiative.initiativeId}" title="lien de la page de détail">
										<h3><c:out value="${initiative.title}" escapeXml='true'/></h3>
									</a>
									<span class="pro-time">
                                    <liferay-ui:message key="dashboard.thumbnail.initiative.publish.date" />
                                    <time datetime="${initiative.getPublicationDateFr()}">${initiative.getPublicationDateFr()}</time>
                                </span>
								</div>

								<div class="pro-footer-budget">
									<p>
										<strong>${initiative.getNbHelps()} Citoyens-nes</strong> ont soutenus cette initiative
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</c:if>
		
		<!-- Tuile des budgets soumis -->
		<c:if test="${budgetFiled.size() > 0}">
			<section id="pro-link-listing-projet-soumis"
				class="pro-bloc-slider pro-slider-event">
				<div class="container">
					<h2><liferay-ui:message key="dashboard.thumbnail.bp.filed.mine" /> (${budgetFiled.size()})</h2>
					<a href="${homeURL}projets-budget-participatif" class="pro-btn" title="<liferay-ui:message key='dashboard.thumbnail.bp.main.alt'/>">
						<liferay-ui:message key="dashboard.thumbnail.bp.main" />
					</a>
					
					<div class="owl-carousel owl-opacify owl-theme owl-cards">
						<c:forEach var="budget" items="${budgetFiled}">
							
							<c:choose >
								<c:when test="${budget.isNotDoable()}">
									<c:set var="classFaisable" value="pro-theme-non-faisable" scope="page" />
								</c:when>
								<c:otherwise>
									<c:set var="classFaisable" value="pro-theme-faisable" scope="page" />
								</c:otherwise>
							</c:choose>
						
							<div class="item pro-bloc-card-budget ${classFaisable}" data-linkall="a">
								<c:if test="${budget.getImageURL() != ''}">
									<figure role="group" class="fit-cover">
                                    	<img src="${budget.getImageURL()}" width="155" height="200" alt="Image atelier"/>
                                	</figure>
                               	</c:if>
								<div class="pro-header-budget">
									<figure>
										<img src="${budget.getAuthorImageURL()}" width="40" height="40" alt="Nom de l'utilisateur" />
									</figure>
									<p><liferay-ui:message key="dashboard.thumbnail.bp.from" /></p>
									<p>
										<strong><c:out value="${budget.getAuthor()}" escapeXml='true'/></strong>
									</p>
									<div class="pro-info-top-right">
										<span class="pro-encart-theme" style="background:#${budget.getBudgetParticipatifStatusCategoryColor()}">
											${budget.getBudgetParticipatifStatusTitle(locale)}
										</span>
									</div>
								</div>
								<div class="pro-content-budget">
									<a href="${homeURL}detail-budget-participatif/-/entity/id/${budget.budgetParticipatifId}"
										title="<liferay-ui:message key='dashboard.thumbnail.link'/>"><h3><c:out value="${budget.title}" escapeXml='true'/></h3></a>
								
									<p><liferay-ui:message key="dashboard.thumbnail.bp.to" /></p>
									<span class="pro-time"><liferay-ui:message key="dashboard.thumbnail.bp.publish.date" /> 
									<time datetime="${budget.getPublicationDateFr()}">${budget.getPublicationDateFr()}</time>
									/ <span class="pro-duree"></span></span>
								</div>
								<div class="pro-footer-budget">
									<p>
										<c:choose >
											<c:when test="${budget.isNotDoable()}">
												<liferay-ui:message key="dashboard.thumbnail.bp.not.doable" />
											</c:when>
											<c:otherwise>
												<strong>${budget.getNbSupports()}</strong> <liferay-ui:message key="dashboard.thumbnail.bp.doable" />
											</c:otherwise>
										</c:choose>
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</c:if>
		
		<!-- Tuile des budgets votes -->
		<c:if test="${budgetVoted.size() > 0}">
			<section id="pro-link-listing-projet-vote"
				class="pro-bloc-slider pro-slider-event">
				<div class="container">
					<h2><liferay-ui:message key="dashboard.thumbnail.bp.signed.mine" /> (${budgetVoted.size()})</h2>
					<a href="${homeURL}projets-budget-participatif" class="pro-btn" title="<liferay-ui:message key='dashboard.thumbnail.bp.main.alt'/>">
						<liferay-ui:message key="dashboard.thumbnail.bp.main" />
					</a>
					
					<div class="owl-carousel owl-opacify owl-theme owl-cards">
						<c:forEach var="budget" items="${budgetVoted}">
							
							<c:choose >
								<c:when test="${budget.isNotDoable()}">
									<c:set var="classFaisable" value="pro-theme-non-faisable" scope="page" />
								</c:when>
								<c:otherwise>
									<c:set var="classFaisable" value="pro-theme-faisable" scope="page" />
								</c:otherwise>
							</c:choose>
						
							<div class="item pro-bloc-card-budget ${classFaisable}" data-linkall="a">
								<c:if test="${budget.getImageURL() != ''}">
									<figure role="group" class="fit-cover">
                                    	<img src="${budget.getImageURL()}" width="155" height="200" alt="Image atelier"/>
                                	</figure>
                               	</c:if>
								<div class="pro-header-budget">
									<figure>
										<img src="${budget.getAuthorImageURL()}" width="40" height="40" alt="Nom de l'utilisateur" />
									</figure>
									<p><liferay-ui:message key="dashboard.thumbnail.bp.from" /></p>
									<p>
										<strong><c:out value="${budget.getAuthor()}" escapeXml='true'/></strong>
									</p>
									<div class="pro-info-top-right">
										<span class="pro-encart-theme" style="background:#${budget.getBudgetParticipatifStatusCategoryColor()}">
											${budget.getBudgetParticipatifStatusTitle(locale)}
										</span>
									</div>
								</div>
								<div class="pro-content-budget">
									<a href="${homeURL}detail-budget-participatif/-/entity/id/${budget.budgetParticipatifId}"
										title="<liferay-ui:message key='dashboard.thumbnail.link'/>"><h3><c:out value="${budget.title}" escapeXml='true'/></h3></a>
								
									<p><liferay-ui:message key="dashboard.thumbnail.bp.to" /></p>
									<span class="pro-time"><liferay-ui:message key="dashboard.thumbnail.bp.publish.date" /> 
									<time datetime="${budget.getPublicationDateFr()}">${budget.getPublicationDateFr()}</time>
									/ <span class="pro-duree"></span></span>
								</div>
								<div class="pro-footer-budget">
									<p>
										<c:choose >
											<c:when test="${budget.isNotDoable()}">
												<liferay-ui:message key="dashboard.thumbnail.bp.not.doable" />
											</c:when>
											<c:otherwise>
												<strong>${budget.getNbSupports()}</strong> <liferay-ui:message key="dashboard.thumbnail.bp.doable" />
											</c:otherwise>
										</c:choose>
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</c:if>
		
	</div>

	<a href="#backtop" class="pro-btn-back-top">
		<span class="icon-ico-chevron-down"></span>
	</a>
</c:if>

<style>
    .pro-bloc-dashboard .pro-wrapper-dashboard #pro-onglet-account form .pro-row .displayListing2 label{
        display:flex;
        align-items: center;
        height: 40px;
    }

    .displayListing2 label input{
        margin-right: 10px;
    }

</style>

<script type="text/javascript">

	/*
    * Lors du click sur le bouton de réinitialisation des votes
    */
	$(document).on("click", "[href='#resetBudgetSupports']", function(event) {
		event.preventDefault();
		$("#modalReset").modal('show');
	});

	/*
    * Lors du click sur la validation de réinitialisation
    */
	$("#resetSupports").click(function(event){
		event.preventDefault();
		$("#form-reset-budget-support").submit();
	});

</script>