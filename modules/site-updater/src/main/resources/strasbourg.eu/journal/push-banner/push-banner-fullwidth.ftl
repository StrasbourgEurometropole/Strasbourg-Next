
<#if ((PushFieldset.PictoImage.getData())?? && PushFieldset.PictoImage.getData() !="") || ((PushFieldset.PictoIcon.getData())?? && PushFieldset.PictoIcon.getData() != "")>
    <div class="st-wrapper st-bloc st-bloc-focus st--with-image st--has-line">
        <div class="st-container">
            <div class="st-col-left">
                <div class="st-visual-container">
                    <#if (PushFieldset.PictoImage.getData())?? && PushFieldset.PictoImage.getData() != "">
                        <@strasbourg.getImage imageNode=PushFieldset.PictoImage />
                    <#else>
                        <#if (PushFieldset.PictoIcon.getData())?? && PushFieldset.PictoIcon.getData() != "">
                            <span class="${PushFieldset.PictoIcon.getData()}" aria-hidden="true"></span>
                        </#if>
                    </#if>


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
                    <p class="st-desc">
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
                           class="st-btn <#if !getterUtil.getBoolean(cur_PushFieldset_ActionFieldSet.GreenBackgroundCheckbox.getData())>st--btn-secondary</#if>" <#if getterUtil.getBoolean(cur_PushFieldset_ActionFieldSet.newTab.getData())>target="_blank"</#if>>
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
                               class="st-btn <#if !getterUtil.getBoolean(cur_PushFieldset_ActionFieldSet.GreenBackgroundCheckbox.getData())>st--btn-secondary</#if>" <#if getterUtil.getBoolean(cur_PushFieldset_ActionFieldSet.newTab.getData())>target="_blank"</#if>>
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
