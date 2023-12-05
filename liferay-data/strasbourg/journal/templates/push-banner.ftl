<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />


<div class="st-wrapper st-bloc st-bloc-focus st--two-elements st--has-line">
    <#if PushFieldset.getSiblings()?has_content>
        <#list PushFieldset.getSiblings() as cur_PushFieldset>
            <div class="st-container st--with-image">
                <div class="st-col-left">
                    <div class="st-visual-container">
                        <#if (cur_PushFieldset.PictoImage.getData())?? && cur_PushFieldset.PictoImage.getData() !="">
                            <@getImage imageNode=cur_PushFieldset.PictoImage />
                        <#else>
                            <#if (PushFieldset.PictoIcon.getData())?? && PushFieldset.PictoIcon.getData() != "">
                                <span class="${PushFieldset.PictoIcon.getData()}" aria-hidden="true"></span>
                            </#if>
                        </#if>

                    </div>
                    <div class="st-content">
                        <h2 class="st-h2">
                            <#if (cur_PushFieldset.TitleText.getData())??>
                                ${cur_PushFieldset.TitleText.getData()}
                            </#if>
                        </h2>
                        <p class="st-surtitre-cat">
                            <#if (cur_PushFieldset.SubtitleText.getData())??>
                                ${cur_PushFieldset.SubtitleText.getData()}
                            </#if>
                        </p>
                        <p class="st-desc">
                            <#if (cur_PushFieldset.DescriptionText.getData())??>
                                ${cur_PushFieldset.DescriptionText.getData()}
                            </#if>
                        </p>
                    </div>
                </div>
                <div class="st-col-right">
                    <#if cur_PushFieldset.ActionFieldSet.getSiblings()?has_content>
                        <#list cur_PushFieldset.ActionFieldSet.getSiblings() as cur_PushFieldset_ActionFieldSet>
                            <a href="<#if (cur_PushFieldset_ActionFieldSet.ExternalLinkText.getData())??>${cur_PushFieldset_ActionFieldSet.ExternalLinkText.getData()}<#else>${cur_PushFieldset_ActionFieldSet.InternalLinkText.getFriendlyUrl()}</#if>"
                               class="st-btn <#if !getterUtil.getBoolean(cur_PushFieldset_ActionFieldSet.GreenBackgroundCheckbox.getData())>st--btn-secondary</#if>">
                                <#if (cur_PushFieldset_ActionFieldSet.LinkLabelText.getData())??>
                                    ${cur_PushFieldset_ActionFieldSet.LinkLabelText.getData()}
                                </#if>
                            </a>
                        </#list>
                    </#if>
                </div>
            </div>
        </#list>
    </#if>
</div>