<%@ include file="/contact-form-init.jsp" %>

<div class="st-wrapper st-wrapper-small st-page-formulaire">
	<c:if test="${not empty title}">
		<h2 class="st-h2">${title}</h2>
	</c:if>
	<c:if test="${not empty descriptionText}">
		<div class="st-text-styles">
				${descriptionText}
		</div>
	</c:if>

<c:if test="${not param.mailSent}">
	<liferay-portlet:actionURL name="contact" var="contactURL" />
	<form action="${contactURL}" method="post" class="form-styles">
		<liferay-ui:error key="unknown-error" message="eu.unknown-error" targetNode=".form-styles" />
		<liferay-ui:error key="recaptcha-error" message="eu.recaptcha-error" targetNode=".form-styles" />
		<liferay-ui:error key="email-error" message="email-error" targetNode=".form-styles" />
		<liferay-ui:error key="lastname-error" message="lastname-error" targetNode=".form-styles" />
		<liferay-ui:error key="firstname-error" message="firstname-error" targetNode=".form-styles" />
		<liferay-ui:error key="content-error" message="content-error" targetNode=".form-styles" />
		<liferay-ui:error key="invalid-mail-error" message="eu.invalid-mail-error" targetNode=".form-styles" />
		<div class="st-grid-fields st-grid-12">
			<p class="st-text-mandatory"><liferay-ui:message key="eu.required-field-star" /></p>

			<div class="st-group-field st-col-6@t-small">
				<label for="lastName"><liferay-ui:message key="contact.lastname" /> <span class="st-field-required"
																						  aria-hidden="true">*</span></label>
				<input type="text" id="lastName" name="lastName" value="${param.lastName}" aria-required="true" autocomplete="family-name">
			</div>

			<div class="st-group-field st-col-6@t-small">
				<label for="firstName"><liferay-ui:message key="contact.firstname" /> <span class="st-field-required">*</span></label>
				<input type="text" id="firstName" name="firstName" value="${param.firstName}" aria-required="true" autocomplete="given-name">
			</div>

			<div class="st-group-field st-col-12@t-small">
				<label for="emailFrom"><liferay-ui:message key="contact.mail" /> <span class="st-field-required">*</span></label>
				<input type="text" id="emailFrom" name="emailFrom" value="${param.emailFrom}" aria-required="true" autocomplete="email">
			</div>

			<div class="st-group-field">
				<label for="demande"><liferay-ui:message key="contact.request" /></label>
				<textarea rows="8" id="demande" name="content"
						  placeholder="Saisissez votre texte...">${param.content}</textarea>
			</div>

			<div class="st-group-field st-col-12@t-small">
				<div class="st-group-radio">
					<label class="st-field-checkbox" for="sendCopy" >
						<input type="checkbox" name="sendCopy" id="sendCopy" value="true" <c:if test="${param.sendCopy}">checked
						</c:if>>
							<liferay-ui:message key="contact.receive-copy" />
					</label>


				</div>
			</div>

			<div class="st-group-field st-col-12@t-small">
				<div class="recaptcha" style="margin-top: 20px;">
					<div class="g-recaptcha" id="recaptcha-contact-form" data-sitekey="${recaptchaKey}"></div>
				</div>
			</div>

			<div class="st-col-3@t-small">
				<button class="st-btn st--btn-full-width-mobile" name="submit" value="<liferay-ui:message key="
					contact.send" />">
					<liferay-ui:message key="contact.send" />
				</button>
			</div>
			<div class="st-col-3@t-small">
				<button type="reset" class="st-btn st--btn-full-width-mobile" name="cancel" value="Annuler"
						formnovalidate="formnovalidate">
					<liferay-ui:message key="cancel" />
				</button>
			</div>

			<div class="st-text-mentions">
				<h3 class="st-title-mentions">Mentions d’information</h3>

				${privacyText}
			</div>

		</div>

	</form>
</c:if>


	<c:if test="${param.mailSent}">
		<div class="form-styles">

			<div class="st-grid-fields st-grid-12 form-styles">
				<div class="st-col-12@t-small">
				<p class="st-alert-form"><liferay-ui:message key="success" /></p>
				</div>
				<div class="st-col-4@t-small">
					<liferay-portlet:renderURL var="formURL" />
					<a href="${formURL}" title="<liferay-ui:message key="contact.new-request" />">
						<button class="st-btn st--btn-full-width-mobile"name="previous" value="<liferay-ui:message key='new-request' />" formnovalidate="formnovalidate">
							<liferay-ui:message key="contact.new-request" />
						</button>
					</a>
				</div>

			</div>
		</div>
	</c:if>

</div>