<#setting locale = locale />

<div class="st-bloc st-bloc-sit-presentation st-wrapper st-wrapper-small st--has-margin st-page-boutons">
    <div class="st-container-buttons">
        <#if linkLabel.getSiblings()?has_content>
        <#list linkLabel.getSiblings() as cur_linkLabel>
        <#if cur_linkLabel?counter gt (linkLabel.getSiblings()?size - 2 )>
            <#assign css = "st-btn st-btn st--btn-secondary" />
        <#else>
            <#assign css = "st-btn" />
        </#if>
        <#if cur_linkLabel.getChildren()[0].getFriendlyUrl()?has_content>
        <a href="${cur_linkLabel.getChildren()[0].getFriendlyUrl()}" class="${css}" title="${cur_linkLabel.getData()}">
            <#else>
            <#if cur_linkLabel.getChildren()[1].getChildren()[0]?has_content && cur_linkLabel.getChildren()[1].getChildren()[0].getData()?has_content >
            <a href="${cur_linkLabel.getChildren()[1].getData()}" class="${css}" title="${cur_linkLabel.getData()}" >
                <#else>
                <a href="${cur_linkLabel.getChildren()[1].getData()}" class="${css}" title="${cur_linkLabel.getData()} (<@liferay_ui.message key="eu.new-window" />)" target="_blank">
                    </#if>
                    </#if>

                    <span class="seu-flexbox">
            <span class="seu-btn-text">${cur_linkLabel.getData()}</span>
            <span class="seu-btn-arrow"></span>
          </span>
                </a>
                </#list>
                </#if>
    </div>
</div>