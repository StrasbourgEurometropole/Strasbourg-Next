<div class="st-barre-dropdown">
    <button type="button" class="st-js-btn-disclosure" aria-expanded="false" aria-controls="menu-public">
        <@liferay_ui.message key='i-am' /> <strong>
            <@liferay_ui.message key='habitant' />
        </strong>
    </button>

    <ul id="menu-public" class="st-barre-dropdown__list">
        <#if FieldsetIam.getSiblings()?has_content>
            <#list FieldsetIam.getSiblings() as cur_FieldsetIam>
                <li>
                    <a href="<#if (cur_FieldsetIam.linkJesuis.getData())??>
          ${cur_FieldsetIam.linkJesuis.getData()}
        </#if>">
                        <@liferay_ui.message key='i-am' /> <strong>
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