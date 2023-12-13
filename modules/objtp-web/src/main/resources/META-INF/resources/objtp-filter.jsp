<div class="st-barre-listing-sit st--listing-lost-and-found">
    <div class="st-barre-inner st-wrapper form-styles">

        <div class="st-filtre st-group-field">
            <label for="filter-territoire">Par mois</label>
            <div class="st-field-select">
                <select id="filter-mois" name="filter-mois">
                    <option value="" selected="">Tout afficher</option>
                    <option value="2023-09">Septembre 2023</option>
                    <option value="2023-08">Août 2023</option>
                    <option value="2023-07">Juillet 2023</option>
                    <option value="2023-06">Juin 2023</option>
                </select>
            </div>
        </div>


        <div class="col-right">
            <p class="st-resultats st--resultats-agenda">
                <span class="st-resultats-range">${(dc.pager.currentPage - 1) * dc.delta + 1} <liferay-ui:message key="eu.to" />
                ${(dc.pager.currentPage * dc.delta) > dc.searchContainer.total ? dc.searchContainer.total : dc.pager.currentPage * dc.delta}
                </span>
                <span class="st-resultats-total">${dc.searchContainer.total} <liferay-ui:message key="results" /></span>
            </p>

            <a href="${urlDeclareLost}" class="st-btn st--btn-small-padding st--btn-secondary-ghost"><liferay-ui:message key="objtp.url.declare-lost" /></a>
            <a href="${urlGuideHowTo}" class="st-btn st--btn-small-padding"><liferay-ui:message key="objtp.url.how-to" /></a>

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
        </div>
    </div>
</div>