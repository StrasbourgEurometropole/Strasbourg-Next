<div class="home-carousel">
    <div class="owl-carousel">
        <#list title.getSiblings() as cur_title>
            <div class="carousel-item">
                <div class="carousel-item-image">
                    <img src="${cur_title.getChild("image").getData()}">
                </div>
                <div class="carousel-item-info">
                    <h1 class="carousel-item-title">${cur_title.getData()}</h1>
                    <a href="${cur_title.getChild("link").getFriendlyUrl()}" class="carousel-item-button">Entrez</a>
                </div>
            </div>
        </#list>
    </div>
    <div class="carousel-controls">
        <div class="museum-name" data-original="Découvrez nos 13 musées">Découvrez nos 13 musées</div>
        <ul id="carousel-custom-dots" class="owl-dots" role="nav">
            <#list title.getSiblings() as cur_title>
                <li class="owl-dot" data-title="${cur_title.getData()}">
                    <img src="${cur_title.getChild("image").getData()}">
                </li>
            </#list>
        </ul>
    </div> 
</div>