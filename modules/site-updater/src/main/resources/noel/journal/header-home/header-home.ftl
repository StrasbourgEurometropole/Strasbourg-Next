<header class="mns-cover mns-cover-fullimg mns-header" data-fullscreen="85">
    <figure class="o60">
        <img alt="" width="1600" height="900" src="${layout.expandoBridge.getAttribute('image')}"/>
    </figure>
    <div class="container mns-center">
        <h1>${title.data}</h1>
        <#if subtitle?? && subtitle.data?has_content>
            <h2 style="margin-top: 25px;">${subtitle.data}</h2>
        </#if>
        <#if catchphrase?? && catchphrase.data?has_content>
            <h2>${catchphrase.data}</h2>
        </#if>
        <#if fieldGroupButon.getSiblings()?has_content>
            <div class="button-flex">
                <#list fieldGroupButon.getSiblings() as cur_fieldGroupButon>
                    <#if cur_fieldGroupButon.buttonLink?? && cur_fieldGroupButon.buttonLink.data?has_content
                    && cur_fieldGroupButon.buttonLabel?? && cur_fieldGroupButon.buttonLabel.data?has_content>
                        <a href="${cur_fieldGroupButon.buttonLink.data}" class="mns-btn-chevron">
                            ${cur_fieldGroupButon.buttonLabel.data}
                        </a>
                    </#if>
                </#list>
            </div>
        </#if>
    </div>
</header>
