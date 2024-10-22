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
                <#if locationLinkLabelFieldSet.locationLinkURL.getFriendlyUrl()?has_content>
                    <li>
                        <a href="${locationLinkLabelFieldSet.locationLinkURL.getFriendlyUrl()}" class="st-lien">
                            <span class="st-icon-itineraire" aria-hidden="true"></span>
                            <span class="st-text">
                          ${locationLinkLabelFieldSet.locationLinkLabel.getData()}
                        </span>
                        </a>
                    </li>
                </#if>
                <#if cityHallLinkLabelFieldSet.cityHallLinkURL.getFriendlyUrl()?has_content>
                    <li>
                        <a href="${cityHallLinkLabelFieldSet.cityHallLinkURL.getFriendlyUrl()}" class="st-lien">
                            <span class="st-icon-maison" aria-hidden="true"></span>
                            <span class="st-text">
                          ${cityHallLinkLabel.getData()}
                        </span>
                        </a>
                    </li>
                </#if>
            </ul>
            <ul class="st-liens-contact">
                <#if phoneNumberFieldSet.phoneLink.getData()?has_content && phoneNumberFieldSet.phoneNumber.getData()?has_content>
                    <li>
                        <a href="tel:${phoneNumberFieldSet.phoneLink.getData()}"
                           class="st-btn st--btn-secondary st--btn-footer">
                            ${phoneNumberFieldSet.phoneNumber.getData()}
                        </a>
                    </li>
                </#if>
                <#if contactLinkLabelFieldSet.linkContact.getData()?has_content && contactLinkLabelFieldSet.labelContact.getData()?has_content>
                    <li>
                        <a href="${contactLinkLabelFieldSet.linkContact.getData()}"
                           class="st-btn st--btn-secondary st--btn-footer">
                            ${contactLinkLabelFieldSet.labelContact.getData()}
                        </a>
                    </li>
                </#if>
            </ul>
        </div>
        <div class="st-col-right">
            <div class="st-social">
                <p class="st-surtitre">
                    ${followUs.getData()}
                </p>
                <p class="st-hashtag">#${hashtag.getData()?has_content?then(hashtag.getData(), "Strasbourg")}</p>
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
                <#if footerLinkLabel.getSiblings()?has_content>
                    <#list footerLinkLabel.getSiblings() as cur_footerLinkLabel>
                        <li>
                            <#if cur_footerLinkLabel.footerLink.getFriendlyUrl()?has_content>
                                <a href="${cur_footerLinkLabel.footerLink.getFriendlyUrl()}"
                                   title="${cur_footerLinkLabel.getData()}">
                                    ${cur_footerLinkLabel.getData()}
                                </a>
                            <#else>
                                <#if cur_footerLinkLabel.footerActiveTab?? && cur_footerLinkLabel.footerActiveTab.getData()??
                                && cur_footerLinkLabel.footerActiveTab.getData()=="true">
                                    <a href="${cur_footerLinkLabel.footerExtLink.getData()}">
                                        ${cur_footerLinkLabel.getData()}
                                    </a>
                                <#else>
                                    <a href="${cur_footerLinkLabel.footerExtLink.getData()}" target="_blank">
                                        ${cur_footerLinkLabel.getData()}
                                    </a>
                                </#if>
                            </#if>
                        </li>
                    </#list>
                </#if>
        </div>
    </div>
    <div  class="st-container-mentions">
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
