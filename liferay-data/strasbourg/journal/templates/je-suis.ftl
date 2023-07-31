<div class="st-barre-dropdown">
    <button type="button" id="menubutton" aria-haspopup="true" aria-controls="menu2">
        Je suis <strong>un habitant</strong>
    </button>
    <ul id="menu2" role="menu" aria-labelledby="menubutton">
        <#if FieldsetIam.getSiblings()?has_content>
            <#list FieldsetIam.getSiblings() as cur_FieldsetIam>
                <li role="none">
                    <a role="menuitem" href="<#if (cur_FieldsetIam.linkJesuis.getData())??>
	${cur_FieldsetIam.linkJesuis.getData()}
</#if>"> Je suis <strong><#if (cur_FieldsetIam.nameJesuis.getData())??>
                                ${cur_FieldsetIam.nameJesuis.getData()}
                            </#if></strong></a>
                </li>
            </#list>
        </#if>

    </ul>
</div>