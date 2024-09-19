<div class="search-asset-form container">
    <div class="form mns-view-filters">
        <div class="seu-filter-line">
            <div class="widget widget-big">
                <div class="title">
                    <label for="name">
                        Rechercher
                    </label>
                </div>
                <div class="content">
                    <input type="text" id="name" class="mns-general-keywords"
                           name="q"
                           placeholder="Saisir un mot clé..." value="<#if searchBarPortletDisplayContext?has_content>${searchBarPortletDisplayContext.getKeywords()}</#if>">
                </div>
            </div>
        </div>
        <div class="mns-btn-line"> <button type="button"
                                           onclick="window.location.href = '/recherche'"
                                           class="mns-btn-square mns-bordered mns-core">
                <span class="mns-flexbox">
                    <span class="mns-btn-text" style="margin-right: 0">
                        Annuler
                    </span>
                </span>
            </button>
            <button type="submit" class="mns-btn-square mns-filled mns-core">
                <span class="mns-flexbox">
                    <span class="mns-btn-text">
                        Rechercher
                    </span>
                    <span class="seu-btn-arrow"></span>
                </span>
            </button>
        </div>
    </div>
</div>