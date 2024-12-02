<#setting locale = locale />

<!-- Rubrique -->
<div class="container mns-triple-actu-bloc">
    <#if entries?has_content>
        <#assign hasPage = false />
        <#list entries as currentPage>
            <#if !currentPage.isHidden()>
                <#if !hasPage>
                    <div class="row" data-egalize=".mns-bloc-actu > a">
                        <#assign hasPage = true />
                </#if>
                <div class="col-lg-3 col-sm-6">
                    <div class="mns-bloc-actu">
                        <a href="${strasbourg.homeURL()}${currentPage.friendlyURL?remove_beginning('/')}">
                            <figure class="mns-bloc-top-img">
                                <#if currentPage.expandoBridge.getAttribute('image')?has_content>
                                    <img src="${currentPage.expandoBridge.getAttribute('image')}" alt="${currentPage.getName(locale)}" width="370" height="250" />
                                </#if>
                            </figure>
                            <div class="mns-bloc-content-actu">
                                <h2>${currentPage.getName(locale)}</h2>
                                <p>
                                    <#if currentPage.expandoBridge.getAttribute('introduction')?has_content>
                                    <#assign introductionAttribute = currentPage.expandoBridge.getAttribute('introduction') />
                                        <#list introductionAttribute?keys as key> 
                                            <#if key == locale>
                                                <#assign introduction = introductionAttribute?values[key_index] />
                                            </#if>
                                        </#list>
                                    </#if>
                                    <#if introduction?has_content>
                                        ${introduction}
                                    </#if>
                                    <#assign introduction = '' />
                                </p>
                                <span class="link"><@liferay_ui.message key="read-more" /></span>
                            </div>
                        </a>
                    </div>
                </div>
            </#if>
        </#list>
        <#if hasPage>
            </div>
        </#if>
    </#if>
</div>