<!-- Webmag - Gros slider -->
<#setting locale = locale />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<div id="smag-banner">
    <section class="smag-hp-une">
        <div class="slider-une rte-item">
            <div class="slider-une-main">
                <div class="slider-une-main__loader">
                    <div class="loader"></div>
                </div>
    
                <!-- Slider -->
                <ul class="slider-une-main__slider unstyled">
                    <#list entries as curEntry>
                        <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
                        <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()")/>
                        <#assign chapo = docXml.valueOf("//dynamic-element[@name='chapo']/dynamic-content/text()") />
                        <#assign thumbnail = docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
                        <#assign image = docXml.valueOf("//dynamic-element[@name='image']/dynamic-content/text()") />
                        <#assign currentURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry) />
                        <#assign viewURL = curEntry.getAssetRenderer().getURLViewInContext(renderRequest, renderResponse, currentURL) />
                        <#assign id = curEntry.getAssetRenderer().getArticle().getArticleId() />
                        <li class="slider-une-main__slider-item">
                            <div class="slider-une-main__slide" data-title="${title}" data-description="${chapo}" data-link="${viewURL}" style="background-image: url(${image});">
                                <div class="slider-une-main__slide-image">
                                    <div class="slider-une-main__slide-background" style="background-image: url(${thumbnail});"></div>
                                    </div> 
                                <div class="slider-une-main__slide-text">
                                    <h3 class="slider-une-main__slide-title" data-dot="2">${title}</h3>
                                    <div class="slider-une-main__slide-description" data-dot="2">${chapo}</div>
                                </div>
                            </div>
                        </li>
                    </#list>    
                </ul>
    
                <!-- Slider Arrows -->
                <div class="slider-une-main__nav">
                    <h2 class="smag-hp-une__title slider-une-main__nav-title">à la une</h2>
                    <div class="slider-une-main__pager slider-une-main__pager--current"></div>
                    <div class="slider-une-main__pager slider-une-main__pager--total slider-une-main__pager--total--slideNpop"></div>
                    <button class="slider-une-main__arrow slider-une-main__arrow--prev">
                        <div class="flexbox">
                            <div class="slider-une-main__arrow-icon"></div>
                            <div class="slider-une-main__arrow-pagination">
                                <div class="slider-une-main__pager slider-une-main__pager--prev"></div>
                                <div class="slider-une-main__pager slider-une-main__pager--total"></div>
                            </div>
                        </div>
                    </button>
                    <button class="slider-une-main__arrow slider-une-main__arrow--next">
                        <div class="flexbox">
                            <div class="slider-une-main__arrow-icon"></div>
                            <div class="slider-une-main__arrow-pagination">
                                <div class="slider-une-main__pager slider-une-main__pager--next"></div>
                                <div class="slider-une-main__pager slider-une-main__pager--total"></div>
                            </div>
                        </div>
                    </button>
                </div>  
    
                <!-- Slider Dots -->
                <div class="slider-une-main__dots">
                    <button class="slider-une-main__dot" data-slider-index=""></button>
                </div>    
                
                <!-- Slider Play / Pause -->
                <button class="slider-une-main__playpause play"></button> 
    
                <!-- Slider Text -->
                <a class="slider-une-main__text slider-une-main__link unstyled" href="#" >
                    <div class="waved-title waved-title--small waved-title--after waved-title--t-white waved-title--w-transparent slider-une-main__suptitle">Le Mag'</div>
                    <h2 class="slider-une-main__title unstyled"></h2>
                    <div class="slider-une-main__description" data-dot="2"></div>
                </a>
            </div>
        </div>
    
        <div class="smag-container">
            <div class="slider-une__more" data-scroll-animation>
                <a href="${homeURL}actualite" class="a-btn-main h-inverted icon-right core-inverted">
                    <span class="flexbox">
                        <i class="mag mag-arrow-right"></i>
                        <span class="btn-text">Recherche d'actus</span>
                    </span>
                </a>
            </div>
        </div>
    </section>
</div>


<@liferay_util["html-bottom"]>
    <script type="text/javascript">
        document.addEventListener("mouseup", function(event){
            var targetElement = event.target;
            var items = $('.slider-une .slider-une-thumbnail__slider .owl-stage-outer .owl-stage .owl-item');
            var trouve = false;
            var link;
            items.each(function(){  
                if($(this).prop("class").indexOf("center") > 0 ){
                    trouve = true;
                    link = $(targetElement).closest('div.owl-item.center > li[class^="slider-une-"] > div').attr('data-link');
                }
            });
            // si on ne trouve pas de center, c'est que l'on est en mode smartphone
            if(!trouve){
                link = $(targetElement).closest('div.owl-item.active > li[class^="slider-une-"] > div').attr('data-link');
            }
            if (link != undefined) {
                window.location.href = link;
            }
        }); 

    </script>
</@>