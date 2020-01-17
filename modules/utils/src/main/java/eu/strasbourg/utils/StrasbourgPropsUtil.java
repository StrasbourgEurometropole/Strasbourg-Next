package eu.strasbourg.utils;

import com.liferay.portal.kernel.util.PropsUtil;

public class StrasbourgPropsUtil {

	public static String getEnvironment() {
		return PropsUtil.get("eu.strasbourg.environment");
	}

	public static String getURL() {
		return PropsUtil.get("eu.strasbourg.url");
	}

	public static String getRecaptchaSecretKey() {
		return PropsUtil.get("eu.strasbourg.recaptcha.secret");
	}

	public static String getRecaptchaPublicKey() {
		return PropsUtil.get("eu.strasbourg.recaptcha.public");
	}

	public static String getLegacyPlaceApiUrl() {
		return PropsUtil.get("eu.strasbourg.legacy.place.api.url");
	}

	public static String getLegacyPlaceApiAutocompleteUrl() {
		return PropsUtil.get("eu.strasbourg.legacy.place.api.autocomplete.url");
	}

	public static String getAgendaImportMails() {
		return PropsUtil.get("eu.strasbourg.agenda.mail");
	}

	public static String getAgendaImportMailsForProvider(String provider) {
		return PropsUtil.get("eu.strasbourg.agenda.mail." + provider);
	}

	public static String getAgendaImportDirectory() {
		return PropsUtil.get("eu.strasbourg.agenda.file");
	}

	public static String getPlaceImportMails() {
		return PropsUtil.get("eu.strasbourg.place.mail");
	}

	public static String getAgendaPlatformURL() {
		return PropsUtil.get("eu.strasbourg.agenda.platform.url");
	}

	public static String getPlaceDetailURL() {
		return PropsUtil.get("eu.strasbourg.place.detail.url");
	}

	public static String getAgendaDetailURL() {
		return PropsUtil.get("eu.strasbourg.agenda.detail.url");
	}

	public static String getTwitterConsumerKey() {
		return PropsUtil.get("eu.strasbourg.twitter.key");
	}

	public static String getTwitterConsumerSecret() {
		return PropsUtil.get("eu.strasbourg.twitter.secret");
	}

	public static String getTwitterToken() {
		return PropsUtil.get("eu.strasbourg.twitter.token");
	}

	public static String getTwitterTokenSecret() {
		return PropsUtil.get("eu.strasbourg.twitter.token.secret");
	}

	public static String getInstagramClientId() {
		return PropsUtil.get("eu.strasbourg.instagram.client");
	}

	public static String getInstagramClientSecret() {
		return PropsUtil.get("eu.strasbourg.instagram.secret");
	}

	public static String getInstagramAccessToken() {
		return PropsUtil.get("eu.strasbourg.instagram.token");
	}

	public static String getTipiURL() {
		return PropsUtil.get("eu.strasbourg.tipi.url");
	}

	public static String getTipiCallbackURL() {
		return PropsUtil.get("eu.strasbourg.tipi.callback.url");
	}

	public static String getFelecURL() {
		return PropsUtil.get("eu.strasbourg.felec.url");
	}

	public static String getPublikClientId() {
		return PropsUtil.get("eu.strasbourg.publik.id");
	}

	public static String getPublikClientSecret() {
		return PropsUtil.get("eu.strasbourg.publik.secret");
	}

	public static String getPublikAuthorizeURL() {
		return PropsUtil.get("eu.strasbourg.publik.url.authorize");
	}

	public static String getPublikTokenURL() {
		return PropsUtil.get("eu.strasbourg.publik.url.token");
	}

	public static String getPublikUserInfoURL() {
		return PropsUtil.get("eu.strasbourg.publik.url.userinfo");
	}

	public static String getPublikIssuer() {
		return PropsUtil.get("eu.strasbourg.publik.issuer");
	}

	public static String getPublikLogoutURL() {
		return PropsUtil.get("eu.strasbourg.publik.url.logout");
	}

	public static String getPublikApiBase() {
		return PropsUtil.get("eu.strasbourg.publik.url.api.base");
	}

	public static String getPublikApiOrigin() {
		return PropsUtil.get("eu.strasbourg.publik.url.api.auth.origin");
	}

	public static String getPublikApiKey() {
		return PropsUtil.get("eu.strasbourg.publik.url.api.auth.key");
	}

	public static String getInternalSecret() {
		return PropsUtil.get("eu.strasbourg.internal.secret");
	}

	public static String getInternalIssuer() {
		return PropsUtil.get("eu.strasbourg.internal.issuer");
	}

	public static long getDaysBeforeSuppression() {
		String daysBeforeSuppression = PropsUtil.get("eu.strasbourg.privacy.days-before-suppression");
		return Long.parseLong(daysBeforeSuppression);
	}

	public static String getAdictBaseURL() {
		return PropsUtil.get("eu.strasbourg.adict.url");
	}

	public static String getAdictSectorBaseURL() {
		return PropsUtil.get("eu.strasbourg.adict.sector.url");
	}

	public static String getAdictSectorTypesBaseURL() {
		return PropsUtil.get("eu.strasbourg.adict.sector.types.url");
	}

	public static String getAdictTrafficURL() {
		return PropsUtil.get("eu.strasbourg.adict.traffic.url");
	}

	public static String getAdictAlertsURL() {
		return PropsUtil.get("eu.strasbourg.adict.alerts.url");
	}

	public static String getPublikProfileURL(){
		return PropsUtil.get("eu.strasbourg.publik.url.profile");
	}
	
	public static String getObjtpURL(){
		return PropsUtil.get("eu.strasbourg.objtp.url");
	}

	public static String getObjtpImportMails(){
		return PropsUtil.get("eu.strasbourg.objtp.mail");
	}

	public static String getGraveyardURL(){
		return PropsUtil.get("eu.strasbourg.graveyard.url");
	}

	public static String getMediathequeBorrower(){
		return PropsUtil.get("eu.strasbourg.mediatheque.borrower");
	}

	public static String getMediathequeAssociation(){
		return PropsUtil.get("eu.strasbourg.mediatheque.association");
	}

	public static String getMediathequeValidation(){
		return PropsUtil.get("eu.strasbourg.mediatheque.validation");
	}

	public static String getMediathequeDestroy(){
		return PropsUtil.get("eu.strasbourg.mediatheque.destroy");
	}

	public static String getResidantURL(){
		return PropsUtil.get("eu.strasbourg.resid.url");
	}

	public static String getDailymotionApiUrl() {
		return PropsUtil.get("eu.strasbourg.dailymotion.api.url");
	}

	public static String getYoutubeApiUrl() {
		return PropsUtil.get("eu.strasbourg.youtube.api.url");
	}
	
	public static int getWebServiceDefaultTimeout() {
		return Integer.parseInt(PropsUtil.get("eu.strasbourg.webservice.default.timeout"));
	}

	public static String getRecordAddressURL(){
		return PropsUtil.get("eu.strasbourg.publik.url.record.address");
	}

	public static String getEMSZipCode(){
		return PropsUtil.get("eu.strasbourg.ems.zip_code");

	}

	public static String getFamilySpace(){
		return PropsUtil.get("eu.strasbourg.family.space.url");
	}

	public static String getDashboardURL() {
		return PropsUtil.get("eu.strasbourg.dashboard.url");
	}

	public static String getParticiperName() {
		return PropsUtil.get("eu.strasbourg.participer.name");
	}

	public static String getDemarcheSuiviURL(){
		return PropsUtil.get("eu.strasbourg.demarches.suivi.url");
	}

	public static String getRodrigueOPSStructureID() {
		return PropsUtil.get("eu.strasbourg.ops.rodrigue.structure.id");
	}
	
	public static String getOPSTicketingURL() {
		return PropsUtil.get("eu.strasbourg.ops.ticketing.url");
	}
	
	public static String getRodrigueAPIURL() {
		return PropsUtil.get("eu.strasbourg.ops.rodrigue.api.url");
	}

	public static String getGMBClientId() {return PropsUtil.get("eu.strasbourg.google.synchronized.id_client");}

	public static String getGMBSecretCode() {return PropsUtil.get("eu.strasbourg.google.synchronized.code_secret");}

	public static String getGMBAccessTokenURL() {return PropsUtil.get("eu.strasbourg.google.access-token-url");}
}
