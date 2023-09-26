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

            <div class="st-social-share">
                <input class="st-toggle-input" id="toggle-input" type="checkbox">
                <label for="toggle-input" class="st-toggle">
                    <span class="st-icon-social-share"></span>
                </label>

                <ul class="st-network-list">
                    <li>
                        <a href="#facebook" id="sharefacebook" target="_blank" aria-label="Partagez sur Facebook"
                           class="st-btn-icon st-btn-icon--small st-ga-event-facebook"
                           title="Lien de partage sur Facebook">
                            <span class="st-icon-facebook" aria-hidden="true"></span>
                        </a>
                    </li>
                    <li>
                        <a href="#twitter" id="sharetwitter"  target="_blank" aria-label="Partagez sur Twitter"
                           class="st-btn-icon st-btn-icon--small st-ga-event-twitter"
                           title="Lien de partage sur Twitter">
                            <span class="st-icon-twitter" aria-hidden="true"></span>
                        </a>
                    </li>
                    <li>
                        <a href="#linkedin" id="ShareLinkedIn" target="_blank" aria-label="Partagez sur LinkedIn"
                           class="st-btn-icon st-btn-icon--small st-ga-event-linkedin"
                           title="Lien de partage sur LinkedIn">
                            <span class="st-icon-linkedin" aria-hidden="true"></span>
                        </a>
                    </li>
                    <li>
                        <a href="#Mail" id="ShareMail"  target="_blank" aria-label="Partagez par Email"
                           class="st-btn-icon st-btn-icon--small st-ga-event-mail"
                           title="Lien de partage par Email">
                            <span class="st-icon-email" aria-hidden="true"></span>
                        </a>
                    </li>
                </ul>
            </div>        </div>
    </div>
</div>