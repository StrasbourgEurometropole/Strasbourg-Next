<div class="st-barre-dropdown">
    <button id="my-profil-mobile" type="button" class="st-js-btn-disclosure" aria-expanded="false" aria-controls="menu-public-mobile">
        <@liferay_ui.message key='my-profil' />
    </button>

    <ul id="menu-public-mobile" class="st-barre-dropdown__list">
        <#if FieldsetIam.getSiblings()?has_content>
            <#list FieldsetIam.getSiblings() as cur_FieldsetIam>
                <li>
                    <a href="<#if (cur_FieldsetIam.linkJesuis.getData())??>
          ${cur_FieldsetIam.linkJesuis.getData()}
        </#if>">
                        <strong>
                            <#if (cur_FieldsetIam.nameJesuis.getData())??>
                                ${cur_FieldsetIam.nameJesuis.getData()}
                            </#if>
                        </strong>
                    </a>
                </li>
            </#list>
        </#if>
    </ul>

</div>