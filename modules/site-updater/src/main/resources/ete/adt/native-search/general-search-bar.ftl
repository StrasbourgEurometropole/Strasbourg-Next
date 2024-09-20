<div class="search-asset-form container">
    <div class="form mns-view-filters">
        <div class="seu-filter-line">
            <div class="widget widget-big">
                <div class="title">
                    <label for="name">
                        <@liferay_ui.message key="eu.ops.search" />
                    </label>
                </div>
                <div class="content">
                    <input type="text" id="name" class="mns-general-keywords"
                           name="${searchBarPortletDisplayContext.getKeywordsParameterName()}"
                           placeholder="Saisir un mot clé..." value="<#if searchBarPortletDisplayContext?has_content>${searchBarPortletDisplayContext.getKeywords()}</#if>">
                </div>
            </div>
        </div>
        <div class="mns-btn-line"> <button type="button"
                                           onclick="window.location.href = '?${searchBarPortletDisplayContext.getKeywordsParameterName()}='"
                                           class="mns-btn-square mns-bordered mns-core">
                <span class="mns-flexbox">
                    <span class="mns-btn-text" style="margin-right: 0">
                         <@liferay_ui.message key="eu.cancel" />
                    </span>
                </span>
            </button>
            <button type="submit" class="mns-btn-square mns-filled mns-core">
                <span class="mns-flexbox">
                    <span class="mns-btn-text">
                        <@liferay_ui.message key="eu.ops.search" />
                    </span>
                    <span class="seu-btn-arrow"></span>
                </span>
            </button>
        </div>
    </div>
</div>