<#-- DETAIL D'UNE SAISINE -->

<#-- Recuperation de la localisation de l'utilisateur -->
<#setting locale = locale />

<#-- Recuperation du gestionnaire de fichiers Liferay -->
<#assign fileEntryHelper = serviceLocator.findService("eu.strasbourg.utils.api.FileEntryHelperService") />

<#-- Recuperation de l'URL de "base" du site -->
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostname?has_content || themeDisplay.scopeGroup.isStagingGroup()>
    <#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
    <#assign homeURL = "/" />
</#if>

<#-- Récupération de l'ID de l'utilisateur -->
<#assign userID = request.session.getAttribute("publik_internal_id")!"" />

<#-- Récupération du contexte de navigation de l'utilisateur -->
<#assign isUserloggedIn = request.session.getAttribute("publik_logged_in")!false />
<#assign hasUserPactSign = request.session.getAttribute("has_pact_signed")!false />
<#assign isUserBanned = request.session.getAttribute("is_banish")!false />

<#-- Recuperation des thématiques de la saisine -->
<#if entry.getThematicCategories()??>
    <#assign saisineObservatoireThematics = entry.getThematicCategories() />
</#if>

<#-- Recuperation des thématiques de la saisine observatoire -->
<#if entry.getProjectCategory()??>
    <#assign saisineObservatoireProject = entry.getProjectCategory() />
</#if>

<#assign isUserloggedIn = request.session.getAttribute("publik_logged_in")!false />

<#-- Recuperation de l'id de l'instance du portlet pour separer le metier des portlets doublons -->
<#assign instanceId = themeDisplay.getPortletDisplay().getId() />

<#-- Initialisation des conteneurs de vignettes -->
<#assign saisineObservatoireJSON = entry.toJSON(userID) />

<#assign imageUrlOG = ""/>
<!-- vignette -->
<#if entry.imageURL?has_content>
    <#assign imageUrlOG=themeDisplay.getPortalURL() + entry.imageURL?replace('@', "")?replace('cdn_hostroot_path', "") />
</#if>

<#-- Liste des infos a partager -->
<#assign openGraph = {
"og:title":"${entry.title?html}",
"og:description":'${entry.description?replace("<[^>]*>", "", "r")?html}',
"og:image":"${imageUrlOG}"
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}
<div id="content" class="pro-page-detail pro-page-detail-initiative">

    <div class="container">

        <div class="col-lg-11 col-lg-offset-1">

            <article>
                <div class="row pro-container-detail-event">
                    <div class="col-lg-8 pr-lg-5">
                        <header>
                            <div class="pro-header-participation pro-theme-information">
                                <h1>${entry.title}</h1>
                                <div class="pro-wrapper-meta">
                                    <div class="pro-statut"><span>${entry.getFrontStatusFR()}</span></div>
                                    <div class="pro-meta">
                                        <#-- Liste des quartiers de la saisine observatoire -->
                                        <span class="prefix-location">${entry.getDistrictLabel(locale)}</span>
                                        <#-- Liste des thématiques de la saisine observatoire -->
                                        <#if saisineObservatoireThematics?? >
                                            <#list saisineObservatoireThematics as saisineObservatoireThematic >
                                                <span>${saisineObservatoireThematic.getTitle(locale)}</span>
                                            </#list>
                                        </#if>
                                        <#if saisineObservatoireProject?? >
                                            <span>${saisineObservatoireProject.getTitle(locale)}</span>
                                        </#if>
                                    </div>
                                </div>
                                <div class="pro-header-auteur">
                                    <figure><#-- Si une image de la saisine existe -->
                                        <img src="${entry.getAuthorImageURL()}" width="40" height="40"
                                             alt="Arrière plan page standard"/>
                                    </figure>
                                    <p>saisine publiée le ${entry.getCreateDate()?date?string['dd/MM/yyyy']} par
                                        :</p>
                                    <p><strong>${entry.getAuthorLabel()}</strong></p>
                                </div>
                            </div>

                            <div id="breadcrumb">
                        <span>
                            <span>
                                <a href="${homeURL}">Accueil</a>
                                <a href="${homeURL}saisines-observatoire">Listing des saisines</a>
                                <span class="breadcrumb_last">${entry.title}</span>
                            </span>
                        </span>
                            </div>
                        </header>
                        <#-- Test du choix du media : "true"/image, "false"/video -->
                        <#if entry.getMediaChoice() == false && entry.getVideoUrl() != "" >
                        <div class="pro-bloc-texte pro-main-img">
                            <div class="pro-bloc-video bloc-standard">
                                <div class="mask-video">
                                    <figure class="o80" role="group">
                                        <#-- Si une image existe malgrès le choix d'une vidéo pour l'affichage,
                                        on la présente en tant qu'image de couverture  -->
                                        <#if entry.getImageURL()?has_content>
                                            <img src="${entry.getImageURL()}" alt="Couverture de la vidéo" width="960"
                                                 height="600"/>
                                        </#if>
                                    </figure>
                                    <a href="#play" class="btn-ytbe" title="Lire la vidéo">
                                        <span class="pro-btn-video" title="Lire la vidéo"><span
                                                    class="icon-ico-lecteur"></span>Voir la vidéo</span>
                                    </a>
                                </div>
                                <div class="embed-container" data-urlvideo="${entry.videoUrl}"></div>
                            </div>
                            <#else>
                            <div class="pro-main-img">
                                <figure>
                                    <img src='${entry.getImageURL()}' alt="Image agenda" width="880" height="593"
                                         class="fit-cover"/>
                                    <#if !entry.getImageCopyright(locale)??>
                                        <figcaption>${entry.getImageCopyright(locale)}</figcaption>
                                    </#if>
                                </figure>
                                </#if>
                                <#if entry.isSupported >
                                    <div class="pro-bookmark">
                                        <div>
                                            <span class="icon-ico-cathedrale"></span>
                                            <p>Saisine soutenue par${entry.supportedBy}</p>
                                        </div>
                                    </div>
                                </#if>
                            </div>

                            <div class="row pro-bloc pro-bloc-texte">
                                <#if entry.summary?has_content>
                                    <h4>Résumé</h4>
                                    <p>${entry.summary}</p>
                                </#if>
                            </div>

                            <div class="row pro-bloc pro-bloc-texte">${entry.description}</div>
                            <#if entry.filesURLs?has_content>
                                <div class="pro-bloc-texte pro-bloc-telechargements">
                                    <h3>Document(s) téléchargé(s)</h3>
                                    <div class="row">
                                        <#list entry.filesURLs as fileURL>
                                            <#assign file = fileEntryHelper.getFileEntryByRelativeURL(fileURL) />
                                            <#assign title = fileEntryHelper.getFileTitle(file.getFileEntryId(), locale) />
                                            <#assign size = fileEntryHelper.getReadableFileEntrySize(file.getFileEntryId(), locale) />
                                            <div class="col-sm-6">
                                                <a href="${fileURL}" download title="${title}">
                                                    <span class="pro-filename">${title}</span>
                                                    <span class="pro-poids">Poids ${size}</span>
                                                </a>
                                            </div>
                                        </#list>
                                    </div>
                                </div>
                            </#if>
                            <div class="pro-contact-petition">
                                <span class="title">Saisine adressée à :</span>
                                <div>
                                    <p><strong>Maire de Strasbourg</strong></p>

                                    <@liferay_portlet["runtime"]
                                    portletProviderAction=portletProviderAction.VIEW
                                    portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
                                    instanceId="${entry.getSaisineObservatoireId()}"/>

                                </div>
                            </div>
                        </div>

                        <#-- Blocs lateraux -->
                        <aside class="col-lg-4 side-petition">


                            <#-- Bloc : map -->
                            <div class="bloc-iframe leaflet-map" id="mapid"></div>

                            <div class="pro-wrapper-links">
                                <a href="#pro-link-commentaire" class="pro-btn-black"
                                   title="Scroll jusqu'à la zone de commentaire">Réagir</a>
                            </div>

                        </aside>
                    </div>
                </div>
            </article>
        </div>
    </div>

    <#-- Recuperation des suggéstions de la saisine -->
    <#assign suggestions = entry.getSuggestions(request, 10) />

    <#-- Liste des suggéstions -->
    <#if suggestions?size gt 0 >
        <section id="pro-link-petition" class="pro-bloc-slider pro-slider-event" style="background-color: white;">
            <div class="container">
                <div>
                    <h2>D’autres saisines</h2>
                    <div class="pro-wrapper">
                        <#if isUserloggedIn && hasUserPactSign && !isUserBanned>
                            <a id="buttonDeposer" href="#deposerSaisineObservatoire" class="pro-btn-yellow" data-toggle="modal" data-target="#modalSaisineObservatoire">Déposer une saisine</a>
                        <#elseif !hasUserPactSign>
                            <a class="pro-btn-yellow" name="#Pact-sign" href="#">Déposer une saisine</a>
                        <#elseif isUserBanned>
                            <a class="pro-btn-yellow" name="#IsBanned" href="#">Déposer une saisine</a>
                        </#if>
                        <a href="${homeURL}saisines-observatoire" class="pro-btn">Toutes les saisines</a>
                    </div>
                </div>
                <div>
                    <div class="owl-carousel owl-opacify owl-theme owl-cards">

                        <#list suggestions as suggestion >
                            <div class="item pro-bloc-card-petition" data-linkall="a">
                                <div class="pro-header-petition">
                                    <figure role="group">
                                        <img src="${suggestion.getAuthorImageURL()}" width="40" height="40"
                                             alt="Portrait de ${suggestion.getUserName()}"/>
                                    </figure>
                                    <p>
                                        Saisine publiée par :
                                    </p>
                                    <p>
                                        <strong>
                                            ${suggestion.petitionnaireFirstname}
                                            ${suggestion.petitionnaireLastname}
                                        </strong>
                                    </p>
                                </div>
                                <div class="pro-content-petition">
                                    <div class="pro-meta">
                                        <span>${suggestion.getFrontStatusFR()}</span>
                                        <span>${suggestion.getThematicLabel(locale)}</span>
                                    </div>
                                    <span class="prefix-location">
											${suggestion.getDistrictLabel(locale)}
									</span>
                                    <a href="${homeURL}detail-saisine-observatoire/-/entity/id/${suggestion.saisineObservatoireId}"
                                       title="Lien vers ${suggestion.title}">
                                        <h3>${suggestion.title}</h3>
                                    </a>
                                    <p>
                                        Saisine adressée à <u>la ville de Strasbourg</u>
                                    </p>
                                    <span class="pro-time">Publiée le
                                        <time datetime="${suggestion.createDate?date?string['dd/MM/yyyy']}">${suggestion.createDate?date?string['dd/MM/yyyy']}</time>
                                    </span>

                                </div>
                                <div class="footer-comment">
                                    <span>${suggestion.getApprovedComments()?size} Commentaires</span>
                                </div>
                            </div>

                        </#list>

                    </div>
                </div>
            </div>
        </section>
    </#if>
</div>

<script>
    // Récupération des entités en JSON à afficher sur la map et ajout des données dynamiques manquantes
    var saisineObservatoireJSON = ${saisineObservatoireJSON};
    saisineObservatoireJSON.link = '${homeURL}detail-saisine-observatoire/-/entity/id/${entry.saisineObservatoireId}';

    $(document).ready(function () {
        // Gestion de la carte interactive
        // Notes : voir dans le theme placit "override/custom.js"

        //Création de la carte au centre de strasbourg
        leafletMap = getLeafletMap()

        // Définition du marqueur
        var saisineObservatoireMarkerIcon = getMarkerIcon('saisineObservatoire');

        // Ajout des marqueurs sur la map
        var saisineObservatoireMarkers = [];

        // Création du cluster permettant le regroupement de points et le centrage
        var markersCluster = L.markerClusterGroup();

        var marker;

        for (var i = 0; i < saisineObservatoireJSON.placitPlaces.length; i++) {
            marker = getSaisineObservatoireMarker(
                saisineObservatoireJSON,
                [saisineObservatoireJSON.placitPlaces[i].mercatorY, saisineObservatoireJSON.placitPlaces[i].mercatorX]
            );

            // Ajout du point dans le Cluster de marqueurs
            markersCluster.addLayer(marker);
            // Ajout du marker dans le tempon
            saisineObservatoireMarkers.push(marker);
        }

        leafletMap.addLayer(markersCluster);

        // Adapter le zoom si des marqueurs existent
        if (markersCluster.getBounds().isValid()) {
            leafletMap.fitBounds(markersCluster.getBounds());
        }

    });
</script>