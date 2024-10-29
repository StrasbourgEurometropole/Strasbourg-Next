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
            <#list fieldGroupButon.getSiblings() as cur_fieldGroupButon>
                <#if fieldGroupButon.buttonLink?? && fieldGroupButon.buttonLink.data?has_content
                && fieldGroupButon.buttonLabel?? && fieldGroupButon.buttonLabel.data?has_content>
                    <a style="margin-top: 40px;" href="${fieldGroupButon.buttonLink.data}" class="mns-btn-chevron">
                        ${fieldGroupButon.buttonLabel.data}
                    </a>
                </#if>
            </#list>
        </#if>
    </div>
</header>