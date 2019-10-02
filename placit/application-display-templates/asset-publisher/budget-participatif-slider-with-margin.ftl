<!-- SLIDER BUDGET PARTICIPATIF AVEC MARGE -->

<#if entries?size != 0 >

    <#-- Recuperation de la localisation de l'utilisateur -->
    <#setting locale = locale />

    <#-- Recuperation de l'URL de "base" du site -->
    <#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
        <#assign homeURL = "/web${layout.group.friendlyURL}/" />
    <#else>
        <#assign homeURL = "/" />
    </#if>

    <section id="pro-link-evenement" class="pro-bloc-slider pro-slider-event">
        <div class="container">

            <div class="col-lg-10 col-lg-offset-1">
                <h2>Les projets citoyens</h2>
                <div class="pro-wrapper">
                    <a href="${homeURL}projets-budget-participatif" class="pro-btn">Voir tous les projets</a>
                </div>
            </div>

            <div class="col-lg-10 col-lg-offset-1">
                <div class="owl-carousel owl-opacify owl-theme owl-cards">

                    <#-- Parcours des entites de l'asset publisher -->
                    <#list entries as curEntry>

                        <#-- Recuperation de l'entite -->
                        <#assign entry = curEntry.getAssetRenderer().getBudgetParticipatif() />

                        <#-- Recuperation de la couleur hexa correspondant au type de la participation -->
                        <#assign statusColor = entry.getBudgetParticipatifStatusCategoryColor() />

                        <#assign imageURL = entry.getAuthorImageURL() />
						
						<#if entry.isNotDoable()>
							<#assign classFaisable = "pro-theme-non-faisable"/>
						<#else>
							<#assign classFaisable = "pro-theme-faisable" />
						</#if>

                        <div class="item pro-bloc-card-budget ${classFaisable} data-linkall="a">
                            <#if entry.getImageURL()?has_content>
									<figure role="group" class="fit-cover">
										<img src="${entry.getImageURL()}" width="155" height="200" alt="Image budget participatif"/>
									</figure>
                            </#if>
                            <div class="pro-header-budget">
                                <#if imageURL?has_content >
                                    <figure role="group">
                                        <img src="${imageURL}" width="40" height="40" alt="Image du budget participatif"/>
                                    </figure>
                                </#if>
                                <p>Projet déposé par :</p>
                                <p><strong>${entry.getAuthor()}</strong></p>
                                <div class="pro-info-top-right">
                                    <span class="pro-encart-theme" style="background : #${statusColor}">
                                        ${entry.getBudgetParticipatifStatusTitle(locale)}
                                    </span>
                                </div>
                            </div>
                            <div class="pro-content-budget">
                                <a href="${homeURL}detail-budget-participatif/-/entity/id/${entry.budgetParticipatifId}" title="lien de la page de détail">
                                    <h3>${entry.title}</h3>
                                </a>
                                <p>Projet adressée à <u>la ville de Strasbourg</u></p>
                                <span class="pro-time">
                                    Publiée le <time datetime="${entry.createDate?date?string['dd/MM/yyyy']}">${entry.createDate?date?string['dd/MM/yyyy']}</time>
                                </span>
                            </div>
                            <div class="pro-footer-budget">
                                <p>
									<#if entry.isNotDoable()>
                                        Ce projet a été étudié et déclaré "${entry.getBudgetParticipatifStatusTitle(locale)}"
                                    <#else>
                                        <strong>${entry.getNbSupports()}</strong> Citoyens-nes 
                                        <#if entry.hasBeenVoted() >
                                            ont soutenus ce projet
                                        <#else>
                                            soutiennent ce projet
                                        </#if>
                                    </#if>      									
								</p>
                            </div>
                        </div>

                    </#list>

                </div>
            </div>

        </div>
    </section>

<#else>
    <div style="height:25px"><div>
</#if>