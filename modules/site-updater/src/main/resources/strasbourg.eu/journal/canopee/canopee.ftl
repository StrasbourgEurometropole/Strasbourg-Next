<!-- Canopée -->
<#setting locale = locale />
<#setting number_format="00000">
<div class="st-bloc st-bloc-canopee st-wrapper st--has-margin">
    <div class="st-bloc-canopee__inner">
        <ul class="st-chiffres-container">
            <#if arbres?? && arbres.getData()?has_content && arbres.getData()!='0'>
                <li class="st-container st-single-chiffre">
                    <div class="st-inner-container">
                        <figure class="st-figure st-fit-cover" role="group" aria-label="">
                            <picture>
                                <img alt="" src="/o/strasbourg-theme/images/assets/images/medias/logo-plan-canopee.png" srcset="/o/strasbourg-theme/images/medias/logo-plan-canopee.png 1x, /o/strasbourg-theme/images/medias/logo-plan-canopee@2x.png 2x">
                            </picture>
                        </figure>
                        <p class="number">${arbres.getData()?number}</p>
                        <p class="text"><@liferay_ui.message key="eu.canopee.arbres" /></p>
                    </div>
                </li>
            </#if>
            <#if ecole?? && ecole.getData()?has_content && ecole.getData()!='0'>
                <li class="st-container st-single-chiffre">
                    <div class="st-inner-container">
                        <figure class="st-figure st-fit-cover" role="group" aria-label="">
                            <picture>
                                <img alt="" src="/o/strasbourg-theme/images/assets/images/medias/logo-plan-canopee.png" srcset="/o/strasbourg-theme/images/medias/logo-plan-canopee.png 1x, /o/strasbourg-theme/images/medias/logo-plan-canopee@2x.png 2x">
                            </picture>
                        </figure>
                        <p class="number">${ecole.getData()?number}</p>
                        <p class="text"><@liferay_ui.message key="eu.canopee.ecole" /></p>
                    </div>
                </li>
            </#if>
            <#if demineralisee?? && demineralisee.getData()?has_content && demineralisee.getData()!='0'>
                <li class="st-container st-single-chiffre">
                    <div class="st-inner-container">
                        <figure class="st-figure st-fit-cover" role="group" aria-label="">
                            <picture>
                                <img alt="" src="/o/strasbourg-theme/images/assets/images/medias/logo-plan-canopee.png" srcset="/o/strasbourg-theme/images/medias/logo-plan-canopee.png 1x, /o/strasbourg-theme/images/medias/logo-plan-canopee@2x.png 2x">
                            </picture>
                        </figure>
                        <p class="number">${demineralisee.getData()?number}</p>
                        <p class="text"><@liferay_ui.message key="eu.canopee.demineralise" /></p>
                    </div>
                </li>
            </#if>
        </ul>
        <#if (Texte93pi.getData())??>
            <p class="st-note text-center">${Texte93pi.getData()}</p>

        </#if>

    </div>
</div>