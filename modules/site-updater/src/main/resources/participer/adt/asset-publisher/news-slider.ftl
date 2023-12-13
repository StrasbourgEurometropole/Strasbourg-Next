<!-- SLIDER NEWS -->

<!-- Recuperation de la localisation de l'utilisateur -->
<#setting locale = locale />

<!-- Recuperation de l'URL de "base" du site -->
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
<#assign assetVocabularyHelper = serviceLocator.findService("eu.strasbourg.utils.api.AssetVocabularyHelperService") />
<#assign assetPublisherTemplateHelperService = serviceLocator.findService("eu.strasbourg.utils.api.AssetPublisherTemplateHelperService")/>

<section class="pro-bloc-select pro-bloc-slider">
    <div class="container">
		<div>
			<h2>Actualités</h2>
                    <div class="pro-wrapper">
                        <a href="${themeDisplay.getPortalURL()}${homeURL}actualites" class="pro-btn" title="Lien vers la page de toutes les actualités">Tout voir</a>
                    </div>
            </div>
        <div>
            <div class="owl-carousel owl-opacify owl-theme owl-cards">

                <!-- Parcours des entites de l'asset publisher -->
            <#list entries as curEntry>

			<#assign territories = assetVocabularyHelper.getAssetEntryCategoriesByVocabulary(curEntry, "territoire") />
			<#assign cities = assetVocabularyHelper.getCityCategories(territories) />
			<#assign districts = assetVocabularyHelper.getDistrictCategories(territories) />
			<#assign territoriesLabel = assetVocabularyHelper.getDistrictTitle(locale, districts, cities) />		
			

            <!-- Recuperation de l'entite -->
             <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContentByLocale(locale)) />
             <#assign title = docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()")/>
             <#assign thumbnail = docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
             <#assign imageURL ="" />
			 <#if thumbnail?has_content>
			 	<#assign imageURL = assetPublisherTemplateHelperService.getDocumentUrl(thumbnail) />
			 </#if>

			 <#assign chapo = docXml.valueOf("//dynamic-element[@name='chapo']/dynamic-content/text()") />

             <#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', curEntry.getAssetRenderer().getArticle().resourcePrimKey) >

	            <div class="item">
	                <a href="${homeURL}-/${curEntry.getAssetRenderer().getArticle().urlTitle}" class="pro-bloc-actu" title="Lien vers la page de détail de l'article">
	                    <div class="img">
	                        <figure role="group">
	                            <img src='${imageURL}?imagePreview=1' loading="lazy" alt="Image agenda" width="360" height="174" class="fit-cover"/>
	                        </figure>
	                        
	                    </div>
	                    <div class="content">
	                        <span class="publication">
                             Publié le ${curEntry.getAssetRenderer().getDisplayDate()?date}
	                        </span>
	                        <h3>${title}</h3>
	                        <p>${chapo?replace("<[^>]*>", "", "r")[0..*100]}...</p>
	                        	<span class="actu-location"> <span class="icon-ico-location"></span>${territoriesLabel} </span>
	                       
	                    </div>
						<div class="footer-news">
							<span class="link">Lire la suite</span>
							<span class="icon-ico-chevron-right"></span>
						</div>
	                </a>
	            </div> 

            </#list>

            </div>
        </div>
    </div>
</section>