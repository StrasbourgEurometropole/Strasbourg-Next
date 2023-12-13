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
"og:description":'${entry.getDescription(locale)?replace("<[^>]*>", "", "r")?html}',
"og:image":"${imageUrlOG}"
} />
<#-- partage de la configuration open graph dans la request -->
${request.setAttribute("LIFERAY_SHARED_OPENGRAPH", openGraph)}

<style>
.pro-bloc {
    flex-direction: column;
}
</style>
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
                                    <div class="pro-statut"><span>${entry.getSaisineObservatoireStatus()}</span></div>
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
                            </div>

                            <div class="row pro-bloc pro-bloc-texte">
                                <h4>Objet de la saisine</h4>
                                <p>${entry.projectTarget}</p>
                            </div>

                            <div class="row pro-bloc pro-bloc-texte">
                                <h4>Description</h4>
                                ${entry.getDescription(locale)}
                            </div>

                            <#if entry.getCityResponse(locale)?has_content>
                                <div style="padding:5px; background-color:#9ba0ee; border:2px solid #656ab0; -moz-border-radius:9px; -khtml-border-radius:9px; -webkit-border-radius:9px; border-radius:9px;">
                                    <div style="font-size: 2em; float: left; width: 40px; text-align: center; margin-right: 5px; height: 20px; padding:3px;">!</div>
                                    <p><strong>Commentaires de la collectivité : "${entry.getSaisineObservatoireStatus()}"</strong><br />
                                        &nbsp;</p>
                                    <em>${entry.getCityResponse(locale)}</em>
                                </div>
                            </#if>
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
            marker = getSaisineMarker(
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