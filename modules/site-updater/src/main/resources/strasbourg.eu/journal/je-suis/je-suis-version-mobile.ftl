<div class="st-select-visitor">
    <label for="select-public">
        <@liferay_ui.message key='my-profil' />
        <span class="st-sr-only">Sélectionner une option entraînera une redirection</span>
    </label>
    <select class="st-js-select-autoresize" id="select-public" style="width: 80px;">
        <#if FieldsetIam.getSiblings()?has_content>
            <#list FieldsetIam.getSiblings() as cur_FieldsetIam>
                <option value="${cur_FieldsetIam.linkJesuis.getData()}">${cur_FieldsetIam.nameJesuis.getData()}</option>
            </#list>
        </#if>
    </select>
</div>