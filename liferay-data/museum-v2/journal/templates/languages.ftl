<ul role="navigation">
	<#if language.getSiblings()?has_content>
    	<#list language.getSiblings() as cur_language>
    	    <li class="${cur_language.label.getData()}">
    	        <a aria-label="${cur_language.getData()?html}" href="${cur_language.link.getData()}" title="${cur_language.getData()?html}">
                	<#if cur_language.svg?? && cur_language.svg.getData()?has_content>
                		${cur_language.svg.getData()}
                	<#else>
            		    ${cur_language.label.getData()}
                    </#if>
                </a>
            </li>
    	</#list>
    </#if>
</ul>
<script>
    var currentLanguageId = Liferay.ThemeDisplay.getLanguageId();
    $('.' + currentLanguageId.split('_')[1]).addClass('active');
</script>