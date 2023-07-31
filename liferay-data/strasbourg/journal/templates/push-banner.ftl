<div class="st-wrapper st-bloc st-bloc-focus st--two-elements st--has-line">
    <#if PushFieldset.getSiblings()?has_content>
        <#list PushFieldset.getSiblings() as cur_PushFieldset>
            <div class="st-container st--with-image">
                <div class="st-col-left">
                    <div class="st-visual-container">
                        <#if (cur_PushFieldset.PictoImage.getData())?? && cur_PushFieldset.PictoImage.getData() != "">
                            <img alt="${cur_PushFieldset.PictoImage.getAttribute("alt")}" data-fileentryid="${cur_PushFieldset.PictoImage.getAttribute("fileEntryId")}" src="${cur_PushFieldset.PictoImage.getData()}" />
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
                        <p>
                            <#if (cur_PushFieldset.DescriptionText.getData())??>
                                ${cur_PushFieldset.DescriptionText.getData()}
                            </#if>
                        </p>
                    </div>
                </div>
                <div class="st-col-right">
                    <#if cur_PushFieldset.ActionFieldSet.getSiblings()?has_content>
                        <#list cur_PushFieldset.ActionFieldSet.getSiblings() as cur_PushFieldset_ActionFieldSet>
                            <a href="<#if (PushFieldset.ActionFieldSet.ExternalLinkText.getData())??>
	${PushFieldset.ActionFieldSet.ExternalLinkText.getData()}
</#if>" class="st-btn st--btn-secondary">
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
