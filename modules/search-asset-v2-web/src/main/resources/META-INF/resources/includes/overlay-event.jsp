<%@ include file="/search-asset-init.jsp"%>
<div id="st-overlay-preview-agenda" class="st-overlay st-overlay-preview-agenda" role="dialog" aria-modal="true" tabindex="0" aria-label="Modale de liste">
    <button class="st-btn-close" data-overlay-close="st-overlay-preview-agenda" aria-label="Fermer"></button>

    <div class="st-overlay__inner">
        <div class="st-overlay__body st-custom-scrollbar">

            <div class="st-overlay__heading">
                <div class="st-overlay__heading-top">
                    <div class="st-caption">
                        <h2 class="st-title-overlay st-h2"></h2>
                        <span class="st-surtitre-cat"></span>
                    </div>
                    <div class="st-image">

                        <figure class="st-figure st-fit-cover" role="group">
                            <picture>
                                <img alt="" src="/o/strasbourg-theme/images/default/default.jpg" class="st-img"
                                        />
                            </picture>
                        </figure>

                    </div>
                </div>

                <div class="st-overlay__heading-infos">
                    <p class="st-date"></p>
                    <p class="st-location"></p>
                </div>
            </div>

            <div class="st-overlay__content st-text-styles" id="description-overlay">

            </div>

        </div>

        <div class="st-overlay__footer">
            <a href="#" class="st-btn st--btn-full-width-mobile st--btn-secondary-ghost detail-button">En savoir plus</a>
        </div>

    </div>
</div>