<footer id="st-footer" class="st-footer" role="contentinfo">
    <div class="st-container st-wrapper st-wrapper-small">
        <div class="st-col-left">
            <h2 class="st-title">
                ${addressLine1.getData()}
            </h2>
            <div class="st-adresse">
                <p>
                    ${addressLine2.getData()}
                    <br>
                    ${addressLine3.getData()}
                </p>
            </div>
            <ul class="st-liens-rapides">
                <li>
                    <a href="${locationLinkLabelFieldSet.locationLinkURL.getFriendlyUrl()}" class="st-lien">
                        <span class="st-icon-itineraire" aria-hidden="true"></span>
                        <span class="st-text">
                          ${locationLinkLabelFieldSet.locationLinkLabel.getData()}
                        </span>
                    </a>
                </li>
                <li>
                    <a href="${cityHallLinkLabelFieldSet.cityHallLinkURL.getFriendlyUrl()}" class="st-lien">
                        <span class="st-icon-maison" aria-hidden="true"></span>
                        <span class="st-text">
                          ${cityHallLinkLabel.getData()}
                        </span>
                    </a>
                </li>
            </ul>
            <ul class="st-liens-contact">
                <li>
                    <a href="tel:${phoneNumberFieldSet.phoneLink.getData()}"
                       class="st-btn st--btn-secondary st--btn-footer">
                        ${phoneNumberFieldSet.phoneNumber.getData()}
                    </a>
                </li>
                <li>
                    <a href="/contact" class="st-btn st--btn-secondary st--btn-footer">
                        <@liferay.language key="eu.contact-mail" />
                    </a>
                </li>
            </ul>
        </div>
        <div class="st-col-right">
            <div class="st-social">
                <p class="st-surtitre">
                    ${followUs.getData()}
                </p>
                <p class="st-hashtag">#Strasbourg</p>
                <ul class="st-social-links">
                    <#if socialNetwork.getSiblings()?has_content>
                        <#list socialNetwork.getSiblings() as cur_socialNetwork>
                            <li>
                                <a href="${cur_socialNetwork.getChild('socialNetworkURL').getData()}" rel="noopener" target="_blank" class="st-btn-icon"
                                   title="${cur_socialNetwork.getChild('classePicto').getData()}">
                <span class="st-icon-${cur_socialNetwork.getChild('classePicto').getData()}"
                      aria-hidden="true"></span>
                                    <span class="st-sr-only">${cur_socialNetwork.getChild('classePicto').getData()}</span>
                                </a>
                            </li>
                        </#list>
                    </#if>
                </ul>
            </div>
            <ul class="st-menu-footer">
                <li>
                    <a href="${mediaLinkLabel.getChild('mediaLinkURL').getFriendlyUrl()}"
                       title="${mediaLinkLabel.getData()} (<@liferay_ui.message key=" eu.new-window" />)"
                       target="_blank">
                        ${mediaLinkLabel.getData()}
                    </a>
                </li>
                <li>
                    <a href="${newsletterLinkLabel.getChild('newsletterLinkURL').getFriendlyUrl()}"
                       title="${newsletterLinkLabel.getData()} (<@liferay_ui.message key=" eu.new-window" />)"
                       target="_blank">
                        ${newsletterLinkLabel.getData()}
                    </a>
                </li>
                <li>
                    <a href="${offerLinkLabel.getChild('offerLinkURL').getFriendlyUrl()}"
                       title="${offerLinkLabel.getData()} (<@liferay_ui.message key=" eu.new-window" />)"
                       target="_blank">
                        ${offerLinkLabel.getData()}
                    </a>
                </li>
                <li>
                    <a href="${strasAppLinkLabel.getChild('strasAppLinkURL').getData()}"
                       title="${strasAppLinkLabel.getData()} (<@liferay_ui.message key=" eu.new-window" />)"
                       target="_blank">
                        ${strasAppLinkLabel.getData()}
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div  class="st-container-mentions" role="navigation">
        <ul class="st-liens">
            <#if subfooterLinkLabel.getSiblings()?has_content>
                <#list subfooterLinkLabel.getSiblings() as cur_subfooterLinkLabel>
                    <li>
                        <#if cur_subfooterLinkLabel.Lien2ga2.getFriendlyUrl()?has_content>
                            <a href="${cur_subfooterLinkLabel.Lien2ga2.getFriendlyUrl()}"
                               title="${cur_subfooterLinkLabel.getData()}">
                                ${cur_subfooterLinkLabel.getData()}
                            </a>
                        <#else>
                            <#if cur_subfooterLinkLabel.activeTab?? && cur_subfooterLinkLabel.activeTab.getData()??
                            && cur_subfooterLinkLabel.activeTab.getData()=="true">
                                <a href="${cur_subfooterLinkLabel.ExtLink.getData()}">
                                    ${cur_subfooterLinkLabel.getData()}
                                </a>
                            <#else>
                                <a href="${cur_subfooterLinkLabel.ExtLink.getData()}" target="_blank">
                                    ${cur_subfooterLinkLabel.getData()}
                                </a>
                            </#if>

                        </#if>
                    </li>
                </#list>
            </#if>
        </ul>
    </div >
</footer>
