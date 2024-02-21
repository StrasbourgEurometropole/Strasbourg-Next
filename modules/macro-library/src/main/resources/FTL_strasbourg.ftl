<#function homeURL>
    <#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
        <#return "/web${layout.group.friendlyURL}/" />
    <#else>
        <#return "/" />
    </#if>
</#function>

<#function getRootElement curEntry>
    <#assign journalArticle = curEntry.getAssetRenderer().getArticle()>
    <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
    <#assign rootElement = document.getRootElement() />
    <#return rootElement>
</#function>


<#function getFieldValue rootElement name>
    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='${name}']")/>
    <#assign value = xPathSelector.selectSingleNode(rootElement).getStringValue()/>
    <#return value>
</#function>

<#macro addImage fileEntryId maxWidth=2000 showLegende=true showCopyright=true isFigure=true>
    <#if  fileEntryId?has_content && fileEntryId?number != 0>
        <#local copyright = getCopyright(fileEntryId) />
        <#local legend = getLegend(fileEntryId) />
        <figure class="<#if isFigure>st-figure</#if> st-fit-cover" role="group" aria-label="${copyright} ${legend}">
            <@strasbourg.getImageByFileEntry fileEntryId=fileEntryId?number maxWidth=maxWidth />
            <figcaption>
                <#if legend?has_content && showLegende>
                    ${legend}
                </#if>
                <#if copyright?has_content && showCopyright>
                    <button type="button" class="st-credits st-js-credits" aria-expanded="false" aria-label="© (copyright de l'image)">©</button>
                    <span class="st-credits-content">${copyright}</span>
                </#if>
            </figcaption>
        </figure>
    <#else>
        <figure class="<#if isFigure>st-figure</#if> st-fit-cover" role="group">
            <img alt="" src="https://placehold.co/600x400/20272F/2AD783/png?text=!&font=roboto" />
        </figure>
    </#if>
</#macro>

<#macro showMore>
    <div class="st-show-more">
        <button class="st-btn-show-more st-btn-arrow st--down"
                aria-expanded="false"
                data-open-label="<@liferay_ui.message key='eu.view-more' />" data-close-label="<@liferay_ui.message key='eu.view-less' />"><@liferay_ui.message key='eu.view-more' />
        </button>
    </div>
</#macro>

<#function getCopyright fileEntryId >
    <#local fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
    <#local copyright = fileEntryHelper.getImageCopyright(fileEntryId?number, locale) />
    <#if copyright?has_content >
        <#return "©  ${copyright}">
    </#if>
    <#return copyright>
</#function>

<#function getLegend fileEntryId >
    <#local fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
    <#local legend = fileEntryHelper.getImageLegend(fileEntryId?number, locale) />
    <#return legend>
</#function>

<#function slugify inputString>
    <#local normalized = inputString?replace("\\s+", "-", "r")?replace("\\n", "-", "r")?lower_case>
    <#local slug = normalized?replace("[^a-z0-9-]", "", "r")>
    <#return slug>
</#function>

<#function getFileFromURL fileURL>
    <#list fileURL?split("/") as x>
        <#if x?counter==3>
            <#assign groupId=x?number>
        </#if>

        <#if x?counter==6>
            <#assign uuId=x?keep_before("?")>
        </#if>
    </#list>
    <#assign
    dlFileEntry=serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>
    <#if (uuId??) && (groupId??)>
        <#assign file=dlFileEntry.getFileEntryByUuidAndGroupId(uuId,groupId)>
        <#return file>
    </#if>
</#function>

<#macro getImage imageNode>
    <#local fileEntryIdString = imageNode.getAttribute("fileEntryId")>
    <@strasbourg.addImage fileEntryId=fileEntryIdString?number />
</#macro>

<#macro getImageByFileEntry fileEntryId maxWidth>
    <#assign dlAppServiceUtil = serviceLocator.findService("com.liferay.document.library.kernel.service.DLAppService")>
    <#assign file = dlAppServiceUtil.getFileEntry(fileEntryId?number)>
    <#if  maxWidth != 2000>
        <#assign fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />
        <img alt="${file.getDescription()}" src="${fileEntryHelper.getClosestSizeImageURL(fileEntryId, maxWidth)}" />
    <#else>
        <@adaptive_media_image["img"] fileVersion=file.getFileVersion() />
    </#if>
</#macro>

<#macro alertError key message>
    <#assign multiSessionErrors = staticUtil["com.liferay.portal.kernel.servlet.MultiSessionErrors"]>
    <#if multiSessionErrors.contains(renderRequest, key)>
        <p class="st-alert-form st--has-error"><@liferay_ui.message key=message /></p>
    </#if>
</#macro>

<#macro alertInfo key message>
    <#assign sessionMessage = staticUtil["com.liferay.portal.kernel.servlet.SessionMessages"]>
    <#if sessionMessage.contains(renderRequest, key)>
        <p class="st-alert-form"><@liferay_ui.message key=message /></p>
    </#if>
</#macro>

<#macro isFavourite entryId entryType title="Item Favori" url="https://strasbourg.eu" entityGroupId="0" >
    <#assign favoriteLocalService = serviceLocator.findService("eu.strasbourg.service.favorite.service.FavoriteLocalService")>
    <#assign isFavouriteBool = favoriteLocalService.isFavorite(entryId, entryType, request.session.getAttribute("publik_internal_id"))>
    <button class="st-btn-favorite-card <#if isFavouriteBool>st-is-favorite</#if>" data-groupId="${entityGroupId}" data-title="${title}" data-url="${url}" data-id="${entryId}" data-type="${entryType}" aria-pressed="<#if isFavouriteBool>true<#else>false</#if>">
        <#if isFavouriteBool>
            <@liferay_ui.message key='eu.remove-from-favorite' />
        <#else>
            <@liferay_ui.message key='eu.add-to-favorite' />
        </#if>
    </button>
</#macro>

<#macro isFavouriteSticky entryId entryType title="Item Favori" url="https://strasbourg.eu" entityGroupId="0" >
    <#assign favoriteLocalService = serviceLocator.findService("eu.strasbourg.service.favorite.service.FavoriteLocalService")>
    <#assign isFavouriteBool = favoriteLocalService.isFavorite(entryId, entryType, request.session.getAttribute("publik_internal_id"))>
    <button class="st-btn-favorite-sticky <#if isFavouriteBool>st-is-favorite</#if>" data-groupId="${entityGroupId}" data-title="${title}" data-url="${url}" data-id="${entryId}" data-type="${entryType}" aria-pressed="<#if isFavouriteBool>true<#else>false</#if>">
        <#if isFavouriteBool>
            <@liferay_ui.message key='eu.remove-from-favorite' />
        <#else>
            <@liferay_ui.message key='eu.add-to-favorite' />
        </#if>
    </button>
</#macro>

<#macro overlayContact entry entryType>
    <@liferay_portlet.actionURL varImpl="contactURL" name="contact">
        <@liferay_portlet.param name="classPK" value="${entry.getPlaceId()}" />
        <@liferay_portlet.param name="to" value="${entry.mail}" />
        <@liferay_portlet.param name="title" value="${entry.getAlias(locale)}" />
        <@liferay_portlet.param name="type" value="${entryType}" />
    </@liferay_portlet.actionURL>
    <#assign overlayContactTitle=entry.getAlias(locale) />
    <#if themeDisplay.isSignedIn() >
        <@clay["alert"] message="Overlay de contact est present sur cette page"
        displayType="secondary"
        title="Overlay" />
    </#if>

    <div id="st-overlay-contact" class="st-overlay st-overlay-contact" role="dialog" aria-modal="true" tabindex="0" aria-label="Formulaire de contact">
        <button class="st-btn-close" data-overlay-close="st-overlay-contact" aria-label="Fermer"></button>

        <form  id="contactForm" action="${contactURL}#st-overlay-contact" name="contactForm" method="post" class="st-overlay__inner form-styles">
            <div class="st-overlay__body st-custom-scrollbar">

                <div class="st-overlay__heading">
                    <h2  class="st-title-overlay st-h2">${overlayContactTitle}</h2>
                    <span class="st-surtitre-cat"><@liferay_ui.message key="eu.contact" /></span>
                </div>
                <div class="st-grid-fields st-grid-12">
                    <@strasbourg.alertError key="all-fields-required" message="eu.all-fields-required" />
                    <@strasbourg.alertError key="invalid-mail" message="eu.invalid-mail" />
                    <@strasbourg.alertError key="recaptcha-error" message="eu.recaptcha-error" />
                    <@strasbourg.alertInfo key="mail-success-with-copy" message="eu.form-success-with-copy" />
                    <@strasbourg.alertInfo key="mail-success" message="eu.form-success" />

                    <#if renderRequest.getAttribute("mailSent")?? == false>
                        <p class="st-text-mandatory"><@liferay_ui.message key="eu.required-field-star" /></p>

                        <div class="st-group-field">
                            <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName"><@liferay_ui.message key="contact.lastname" /> <span class="st-field-required">*</span></label>
                            <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_lastName" aria-required="true" type="text" autocomplete="family-name" placeholder="<@liferay_ui.message key="contact.your-lastname" />" value="${renderRequest.getAttribute("lastName")!""}"/>
                        </div>

                        <div class="st-group-field">
                            <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName"><@liferay_ui.message key="contact.firstname" /> <span class="st-field-required">*</span></label>
                            <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_firstName" aria-required="true" type="text" autocomplete="given-name" placeholder="<@liferay_ui.message key="contact.your-firstname" />" value="${renderRequest.getAttribute("firstName")!""}"/>
                        </div>

                        <div class="st-group-field st--has-error">
                            <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email"><@liferay_ui.message key="contact.mail" /> <span class="st-field-required">*</span></label>
                            <input name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_email" aria-required="true" type="text" autocomplete="email" placeholder="<@liferay_ui.message key="contact.your-mail" />" value="${renderRequest.getAttribute("email")!""}"/>
                        </div>

                        <div class="st-group-field">
                            <label for="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message"><@liferay_ui.message key="contact.request" /> <span class="st-field-required">*</span></label>
                            <textarea id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message" name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_message" rows="5" placeholder="<@liferay_ui.message key="contact.your-message" />">${renderRequest.getAttribute("message")!""}</textarea>
                        </div>

                        <div class="st-group-field">
                            <div class="st-group-radio">
                                <label for="checkbox-_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_notificationEmail"  class="st-field-checkbox">
                                    <input checked type="checkbox" name="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_notificationEmail" id="_eu_strasbourg_portlet_entity_detail_EntityDetailPortlet_notificationEmail" />
                                    <@liferay_ui.message key="eu.do-you-want-a-notification" />
                                </label>
                            </div>
                        </div>

                        <div>
                            <div id="recaptcha-contact" class="g-recaptcha" data-sitekey="${propsUtil.get('eu.strasbourg.recaptcha.public')}"></div>
                        </div>

                        <div class="st-text-mentions">
                            <h3 class="st-title-mentions"> <@liferay_ui.message key="contact.mention" /></h3>

                            <@liferay_ui.message key="contact.default-privacy" />
                        </div>
                    </#if>
                </div>
            </div>

            <div class="st-overlay__footer">
                <#if renderRequest.getAttribute("mailSent")?? == false>
                    <button class="st-btn st--btn-full-width" name="submit" value="<@liferay_ui.message key="send" />"><@liferay_ui.message key="send" /></button>
                </#if>
            </div>
        </form>
    </div>
</#macro>

<#macro socialShare >
    <div class="st-social-share st-js-social-share">
        <button class="st-social-share__toggle" aria-expanded="false">
            <span class="st-icon-social-share"></span>
            <span class="st-sr-only">Partager</span>
        </button>

        <ul class="st-social-share__list">
            <li>
                <a id="sharefacebook" href="#facebook" class="st-btn-icon st-btn-icon--small" target="_blank" rel="noopener" title="Facebook">
                    <span class="st-icon-facebook" aria-hidden="true"></span>
                    <span class="st-sr-only">Facebook</span>
                </a>
            </li>
            <li>
                <a href="#twitter" id="sharetwitter" class="st-btn-icon st-btn-icon--small" target="_blank" rel="noopener" title="Twitter">
                    <span class="st-icon-twitter" aria-hidden="true"></span>
                    <span class="st-sr-only">Twitter</span>
                </a>
            </li>
            <li>
                <a href="#linkedin" id="ShareLinkedIn" class="st-btn-icon st-btn-icon--small" target="_blank" rel="noopener" title="LinkedIn">
                    <span class="st-icon-linkedin" aria-hidden="true"></span>
                    <span class="st-sr-only">LinkedIn</span>
                </a>
            </li>
            <li>
                <a href="#Mail" id="ShareMail"  class="st-btn-icon st-btn-icon--small" target="_blank" rel="noopener" title="Email">
                    <span class="st-icon-email" aria-hidden="true"></span>
                    <span class="st-sr-only">Email</span>
                </a>
            </li>
        </ul>
    </div>
</#macro>