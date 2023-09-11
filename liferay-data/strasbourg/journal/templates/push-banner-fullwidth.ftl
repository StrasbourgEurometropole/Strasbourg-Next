<#include "/strasbourg-theme_SERVLET_CONTEXT_/templates/macros.ftl" />

<#if (PushFieldset.PictoImage.getData())?? && PushFieldset.PictoImage.getData() !="">
    <div class="st-wrapper st-bloc st-bloc-focus st--with-image st--has-line">
        <div class="st-container">
            <div class="st-col-left">
                <div class="st-visual-container">
                    <@getImage imageNode=PushFieldset.PictoImage />

                </div>
                <div class="st-content">
                    <h2 class="st-h2">
                        <#if (PushFieldset.TitleText.getData())??>
                            ${PushFieldset.TitleText.getData()}
                        </#if>
                    </h2>
                    <p class="st-surtitre-cat">
                        <#if (PushFieldset.SubtitleText.getData())??>
                            ${PushFieldset.SubtitleText.getData()}
                        </#if>
                    </p>
                    <p>
                        <#if (PushFieldset.DescriptionText.getData())??>
                            ${PushFieldset.DescriptionText.getData()}
                        </#if>
                    </p>
                </div>
            </div>
            <div class="st-col-right">
                <#if PushFieldset.ActionFieldSet.getSiblings()?has_content>
                    <#list PushFieldset.ActionFieldSet.getSiblings() as cur_PushFieldset_ActionFieldSet>
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
    </div>
<#else>
    <div class="st-strate-footer">
        <div class="st-strate-newsletter st-wrapper">
            <div class="st-container">
                <div class="st-col-left">
                    <h2 class="st-h2">
                        <#if (PushFieldset.TitleText.getData())??>
                            ${PushFieldset.TitleText.getData()}
                        </#if>
                    </h2>
                    <p class="st-surtitre-cat">
                        <#if (PushFieldset.SubtitleText.getData())??>
                            ${PushFieldset.SubtitleText.getData()}
                        </#if>
                    </p>
                    <p>
                        <#if (PushFieldset.DescriptionText.getData())??>
                            ${PushFieldset.DescriptionText.getData()}
                        </#if>
                    </p>
                </div>
                <div class="st-col-right">
                    <#if PushFieldset.ActionFieldSet.getSiblings()?has_content>
                        <#list PushFieldset.ActionFieldSet.getSiblings() as cur_PushFieldset_ActionFieldSet>
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
        </div>
    </div>


</#if>