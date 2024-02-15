<#if themeDisplay.isSignedIn() >
    <@clay["alert"] message="Overlay de territoire est present sur cette page"
    displayType="secondary"
    title="Overlay" />
</#if>

<div id="st-overlay-location" class="st-overlay st-overlay-location st--from-bottom st-custom-scrollbar" role="dialog" aria-modal="true" tabindex="0" aria-label="${title.getData()}">
    <div class="st-overlay__inner form-styles">
        <button class="st-btn-close st-parsed-overlay" data-overlay-close="st-overlay-location" aria-label="Fermer"></button>

        <div class="st-overlay__body">

        <div class="st-overlay__heading">
            <h2 class="st-title-overlay st-h2">${title.getData()}</h2>
            <p>
                ${chapo.getData()}
            </p>
        </div>


        <div class="st-grid-fields st-grid-12">

            <div class="st-group-field">
                <label for="cityFieldSet">${citySublabel.getData()} ${cityLabel.getData()}</label>
                <div class="st-field-select">
                    <select id="cityFieldSet" onchange="document.location.href = this.value;" name="cityFieldSet">
                        <option value="" selected disabled >
                            <@liferay_ui.message key="eu.select.our.city" />
                        </option>
                        <#if cityFieldSet.getSiblings()?has_content>
                            <#list cityFieldSet.getSiblings() as cur_cityFieldSet>
                                <option value="${cur_cityFieldSet.cityLink.getFriendlyUrl()}">${cur_cityFieldSet.city.getData()}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>
            <span class="st-h3" style="text-align: center;">OU</span>

            <div class="st-group-field">
                <label for="districtFieldSet">${districtSublabel.getData()} ${districtLabel.getData()}</label>

                <div class="st-field-select">
                    <select id="districtFieldSet" onchange="document.location.href = this.value;" name="districtFieldSet">
                        <option value="" selected disabled >
                            <@liferay_ui.message key="eu.select.our.district" />
                        </option>
                        <#if districtFieldSet.getSiblings()?has_content>
                            <#list districtFieldSet.getSiblings() as cur_districtFieldSet>
                                <option value="${cur_districtFieldSet.districtLink.getFriendlyUrl()}" >${cur_districtFieldSet.district.getData()}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>
            <div class="st-btn" style="visibility: hidden"></div>
        </div>
    </div>
    </div>

</div>