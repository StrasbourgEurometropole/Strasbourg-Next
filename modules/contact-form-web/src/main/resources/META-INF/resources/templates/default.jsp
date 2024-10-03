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
		<c:if test="${dc.hasError()}">
			<p><liferay-ui:message key="form-has-error" /></p>
			<ul class="st-alert-form st--has-error my-2">
					${dc.getAlertError("lastname-error", "lastname-error", "lastName")}
					${dc.getAlertError("firstname-error", "firstname-error", "firstName")}
					${dc.getAlertError("email-error", "email-error", "emailFrom")}
					${dc.getAlertError("invalid-mail-error", "eu.invalid-mail-error", "emailFrom")}
					${dc.getAlertError("content-error", "content-error", "demande")}
					${dc.getAlertError("friendlycaptcha-error", "eu.friendlycaptcha-error", "friendlycaptcha-contact-form")}
					${dc.getAlertError("unknown-error", "eu.unknown-error", "")}
			</ul>
		</c:if>


		<div class="st-grid-fields st-grid-12">
			<p class="st-text-mandatory"><liferay-ui:message key="eu.required-field-star" /></p>

			<div class="st-group-field st-col-6@t-small">
				<label for="lastName"><liferay-ui:message key="contact.lastname" /> <span class="st-field-required">*</span></label>
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
				<label for="demande"><liferay-ui:message key="contact.request" /> <span class="st-field-required">*</span></label>
				<textarea rows="8" id="demande" name="content" aria-required="true"
						  placeholder="<liferay-ui:message key="enter-your-text" />">${param.content}</textarea>
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
					<div class="frc-captcha" id="friendlycaptcha-contact-form"
						 data-puzzle-endpoint="${friendlycaptchaPuzzleURL}"
						 data-sitekey="${friendlycaptcha}"></div>
				</div>
			</div>

			<div class="st-col-3@t-small">
				<button class="st-btn st--btn-full-width-mobile" name="submit" value="<liferay-ui:message key="
					contact.send" />">
					<liferay-ui:message key="contact.send" />
				</button>
			</div>
			<div class="st-col-3@t-small">
				<button type="reset" class="st-btn st--btn-full-width-mobile" name="cancel" value="Annuler">
					<liferay-ui:message key="cancel" />
				</button>
			</div>

			<div class="st-text-mentions">
				<h3 class="st-title-mentions"><liferay-ui:message key="notice-information" /></h3>

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
						<button class="st-btn st--btn-full-width-mobile"name="previous" value="<liferay-ui:message key='new-request' />" >
							<liferay-ui:message key="contact.new-request" />
						</button>
					</a>
				</div>

			</div>
		</div>
	</c:if>

</div>

<script type="module" src="/o/0-global-theme/libs/friendlycaptcha/widget.module.min.js" async defer ></script>
<script nomodule src="/o/0-global-theme/libs/friendlycaptcha/widget.min.js" async defer></script>