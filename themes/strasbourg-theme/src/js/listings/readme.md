# JS des listings

## liste des fichiers

### Fichiers à considerer comme des libs :

Normalement les fichiers suivants ne sont pas à modifier dans des projets standards, mais uniquement dans le cadre
d'évolution ou de fonctionnement spécifiques pour un projet :

- listing_ajax.js
- listing_form.js
- listing_manager.js
- listing_map.js
- listing_pagination.js

### Fichiers à adapater selon le projet :

- listing_overlay_cards.js : gère le remplissage de l'overlay des cards fma sur les listings => adapter les classes
  selon structure de l'overlay
- setupt_listings.js : gère l'initialisation des listings, la déclaration des callbacks de map, ouverture d'overlay etc
  ... mettre le code custom par ici
- inputs_date_synchronises.js : gères les datePickers des listings quand ils doivent se synchroniser dans l'overlay, la
  barre de filtre et/ou la couverture de page

### Evos à prévoir

- passer le contenu de inputs_date_synchronises.js sous forme de lib
- barre de "rappel" des filtres séléctionnés non développée
