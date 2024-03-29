# Lancement d'un environnement EMS complet en DXP 7.2

## Fichiers d'entrées

* Pour elasticsearch-ems :
    *  dans le répertoire de configuration `configs/elasticsearch-ems` :
        *  `synonyms.txt` pour la description des synonymes.
* Pour liferay-ems :
    * dans le répertoire des clefs d'activation `images/liferay-ems/sources/activation-keys`
        * la clef d'activation du cluster Liferay
    * dans le répertoire de source pour la création de l'image `images/liferay-ems/sources` :
        * le script `wait-for-it.sh` permettant de tester la disponibilité d'autres noeuds.
        * le certificat `certigna-authority-2015-2025.cer`
        * le certificat `apiDailymotion.cer`
        * le certificat `apiYoutube.cer`
    * dans le répertoire de livraison pour la création de l'image `images/liferay-ems/dist`
        * le repertoire `[LFR_TAG_VERSION]` contenant tous les binaires à livrer ainsi que la clef d'activation Liferay DXP (`LFR_TAG_VERION` correspond aussi au tag qui sera utilisé pour décrire l'image )
    * dans le répertoire de configuration `configs/liferay-ems-[ENV]` :
        * `deploy` dossier dans lequel placer tous les éléments que l'on souhaite déployer au démarrage de Liferay.
        * `files/tomcat/bin/setenv.sh` pour définir les propriétés de lancement du serveur.
        * `files/tomcat/conf/context.xml` pour définir le protocole de cookies utilisé.
        * `files/tomcat/conf/server.xml` pour exporter le port AJP.
        * `files/tomcat/lib/ext/mysql-connector-java-8.0.20.jar` pour surcharger le connecteur MySQL par defaut posant des problèmes SSH.
        * `files/portal-ext.properties` pour définir les proprités Liferay et EMS.
        * `files/portal-setup-wizzard.properties` pour définir les proprités de connection à la BDD et d'administration par defaut de Liferay.
        * `files/osgi/configs` dossier dans lequel placer tous les fichiers de config osgi.
        * `files/osgi/modules` dossier dans lequel placer tous les clefs d'activation Liferay DXP.
        * `scripts/wait-for-dependencies.sh` script lancé avant le serveur permettant d'attendre les dépendances ElasticSearch et Liferay actif pour le backup.

Créer et remplir le fichier `./.env` à la racine du repertoire `docker` où :
 * `LFR_TAG_VERSION` est la version de l'image Liferay
 * `CUR_ENV` est l'environnement courant (RECETTE / PREPROD / PROD)
 * `DATA_PATH_LIFERAY` est le chemin vers le repertoire de persistance liferay (monté en NFS)
 * `DATA_PATH_ES` est le chemin vers le repertoire de persistance elasticsearch (non monté en NFS)
 * `DB_BACKUPS_PATH` est le chemin vers le répertoire où seront placés les backups de base de données lors des livraisons
 * `LCS_LIFERAY_ACTIVE_HOSTNAME` est le hostname utilisé par le conteneur Liferay actif (pour enregistrer la licence)
 * `LCS_LIFERAY_BACKUP_HOSTNAME` est le hostname utilisé par le conteneur Liferay backup (pour enregistrer la licence)
 * `REGISTRY_ADDRESS` est l'adresse du registry Docker dans Nexus
 * `MYSQL_ADDRESS` est l'addresse de connexion à MySQL en prenant en compte, de préférence,  le port
 * `MYSQL_DB` est le nom de la base MySQL utilisé par Liferay
 * `MYSQL_USER` est l'utilisateur MySQL dédié à Liferay
 * `MYSQL_PASSWORD` est le mot de passe de l'utilisateur MySQL dédié à Liferay
 * `PMA_URL` URL d'accès au service PhpMyAdmin
 * `TRAIL_MAIL_ADDRESS` est l'email de copie de tous les mails provenant du serveur SMTP (**A NE PAS REMPLIR EN PRODUCTION !**)

```properties
LFR_TAG_VERSION=
CUR_ENV=
DATA_PATH_LIFERAY=
DATA_PATH_ES=
DB_BACKUPS_PATH=
LCS_LIFERAY_ACTIVE_HOSTNAME=
LCS_LIFERAY_BACKUP_HOSTNAME=
REGISTRY_ADDRESS=
MYSQL_ADDRESS=
MYSQL_DB=
MYSQL_USER=
MYSQL_PASSWORD=
PMA_URL=
TRAIL_MAIL_ADDRESS=
```

## Exécution

Pour préparer les services, lancer le premier script :

```shell
$ sh 1_prepare-delivery.sh
```

**Notes**
Etapes du script de préparation :
1. Export des variables d'environnement contenues dans le fichier `.env`
2. Build de l'image `elasticsearch-ems`. L'image ne sera pas recrée si elle existe déjà dans le même état (même build id), toutefois s'il y a la moindre modification des fichiers la composant, elle sera rebuildée.
3. Push de l'image `elasticsearch-ems` sur le registry `REGISTRY_ADDRESS` indiqué dans le fichier `.env` permettant ainsi à tous les noeuds de récupérer la même version de l'image.
4. Création de l'image `liferay-ems` ayant pour tag `LFR_TAG_VERSION` indiqué dans le fichier `.env`. Ce tag servira aussi à récupérer les ressources EMS (modules, layouts, thèmes) présentes dans le dossier "./images/liferay-ems/dist/`LFR_TAG_VERSION`". Les mêmes principes que l'image `elasticsearch-ems`sont appliqués.
5. Push de l'image `liferay-ems` sur les mêmes principes que l'image `elasticsearch-ems`.

Pour lancer les services, lancer le troisième script :

```shell
$ sh 3_startup-services.sh
```

**Notes**
Etapes du script de lancement :
1. Lancement de la totalité des services contenus dans le fichier `docker-compose.yml`.
2. Visualisation des services lancés.

Suivre les logs d'un service via la commande suivante en remplaçant `SERVICE_ID` par celui récupéré avec `docker service ls` (dernière commande lancée par le script `startup.sh`) :

```shell
$ docker service logs SERVICE_ID -f
```

## Livraison d'une nouvelle version

1. Changer la variable d'environnement `LFR_TAG_VERSION` dans le fichier `./.env`. 

    **Notes** : cette dernière sera utilisée comme tag de l'image `liferay-ems` et comme référence pour trouver les nouveaux binaires à déployer.

2. Créer un dossier correspondant exactement à la variable `LFR_TAG_VERSION` dans le dossier `./images/liferay-ems/sources/dist/`.

3. Placer tous les binaires devant être déployés ainsi que la clef Liferay DXP de l'environnement dans le dossier précédemment créé.

4. Lancer le script de préparation de la livraison :

    ```shell
    $ sh 1_prepare-delivery.sh
    ```

5. Lancer le script d'arrêt des services et du backup de base de données :

    ```shell
    $ sh 2_shutdown-services-and-backups.sh
    ```

6. [OPTIONNEL] Exécuter les scripts SQL de la livraison en cours. Se connecter à MySQL via ligne de commande en remplaçant :
    * `MYSQL_USER` par l'utilisateur MySQL utilisé par Liferay;
    * `MYSQL_DB` par le nom de la base de données MySQL utilisé par Liferay.

    ```shell
    # Connexion à MySQL
    $ mysql -u MYSQL_USER -p MYSQL_DB

    # Sortir de MySQL
    $ exit
    ```

7. Lancer le script de démarrage des services :

    ```shell
    $ sh 3_startup-services.sh
    ```

8. Vérifier le bon déroulement de la livraison sur le noeud principal via la commande suivante en remplaçant `SERVICE_ID` par celui récupéré avec `docker service ls` (dernière commande lancée par le script `startup.sh`):

    ```shell
    $ docker service logs SERVICE_ID -f
    ```

    **Notes** : `ctrl + c` pour quitter les logs.



# Commandes Docker utiles

## Commandes générales sur les conteneurs

1. **Voir l'aide des commandes docker pour les conteneurs** :

    ```shell
    $ docker container -h
    ```

2. **Voir tous les conteneurs lancés** :

    ```shell
    $ docker ps
    ```

3. **Voir tous les conteneurs (même ceux stoppés)** :

    ```shell
    $ docker ps -a
    ```

4. **Rentrer en bash dans un conteneur** en remplaçant :
    * `CONTAINER_ID` par l'ID obtenu via la commande `docker ps`

    ```shell
    $ docker container exec -it CONTAINER_ID bash
    ```

5. **Lancer un conteneur simple** en remplaçant :
    * `IMAGE` le nom de l'image que l'on prend pour base pour lancer le conteneur (voir les images sur un registry comme https://hub.docker.com/)
    * `PORTS` par l'association de ports hôte:conteneur (ex : "80:8080" pour rediriger le port 8080 du conteneur sur le port 80 de l'hôte)

    ```shell
    $ docker container run -p PORTS IMAGE 
    ```

    **notes** : voir les autres options via la commande `docker container run -h` ou sur https://docs.docker.com/engine/reference/commandline/container_run/

6. **Stopper un conteneur** en remplaçant :
    * `CONTAINER_ID` par l'ID obtenu via la commande `docker ps`

    ```shell
    $ docker container stop CONTAINER_ID
    ```

7. **Supprimer un conteneur** en remplaçant :
    * `CONTAINER_ID` par l'ID obtenu via la commande `docker ps`

    ```shell
    $ docker container rm CONTAINER_ID
    ```

    **notes** : peut nécessiter l'option `-f` pour forcer la suppression d'un conteneur déjà démarré. 

8. **Relancer un conteneur** en remplaçant :
    * `CONTAINER_ID` par l'ID obtenu via la commande `docker ps`

    ```shell
    $ docker container restart CONTAINER_ID
    ```

9. **Consulter les logs d'un conteneur** en remplaçant :
    * `CONTAINER_ID` par l'ID obtenu via la commande `docker ps`

    ```shell
    $ docker container logs CONTAINER_ID
    ```

    **notes** : lancer avec l'option `-f` pour les suivre en continu et faire `Ctrl + C` pour arrêter le suivi.

10. **Inspecter les informations du conteneur** en remplaçant :
    * `CONTAINER_ID` par l'ID obtenu via la commande `docker ps`

    ```shell
    $ docker container inspect CONTAINER_ID
    ```

## Commandes spcéifiques sur les conteneurs

1. **Effectuer un dump à partir d'un conteneur MySQL lancé** en remplaçant :
    * `CONTAINER_ID` par l'ID obtenu via la commande `docker ps`
    * `USER_NAME` est le nom d'utilisateur MySQL
    * `USER_PSW` est le mot de passe d'utilisateur MySQL
    * `SCHEMA_NAME` est le nom du schéma à extraire
    * `DEST_PATH` est le chemin de la machine hôte (nom du fichier .sql inclu) où mettre le dump

    ```shell
    $ docker exec CONTAINER_ID /usr/bin/mysqldump -u USER_NAME --password=USER_PSW SCHEMA_NAME > DEST_PATH
    ```

## Commandes générales docker-compose

Les commandes docker-compose sont toujours à lancer dans le répertoire où se situe ledit fichier `docker-compose.yml`

1. **Voir l'aide des commandes docker-compose** :

    ```shell
    $ docker-compose -h
    ```

2. **Lancer tous les "services" d'un docker-compose** :

    **notes** : cette commande va créer tous les conteneurs et réseaux contenus dans le docker-compose.

    ```shell
    $ docker-compose up -d
    ```

3. **Couper tous les "services" d'un docker-compose** :

    **notes** : cette commande va supprimer tous les conteneurs et réseaux contenus dans le docker-compose. La commande `docker-compose kill` possède les mêmes attributions mais effectue l'équivalent d'un `--force` pour les conteneurs récidivistes.

    ```shell
    $ docker-compose down
    ```

4. **Stopper tous les "services" d'un docker-compose** :

    **notes** : cette commande va couper tous les conteneurs et réseaux contenus dans le docker-compose mais ils pourront être relancés là où ils en étaient.

    ```shell
    $ docker-compose stop
    ```

5. **Relancer, après arrêt, tous les "services" d'un docker-compose** :

    **notes** : cette commande ne relancera que les conteneurs ayant été stoppés au préalable, elle ne créera rien de nouveau et ne peut donc pas remplacer la commande `docker-compose up` pour un nouveau lancement.

    ```shell
    $ docker-compose start -d
    ```

9. **Consulter les logs d'un docker-compose** 

    ```shell
    $ docker container logs
    ```

    **notes** : lancer avec l'option `-f` pour les suivre en continu et faire `Ctrl + C` pour arrêter le suivi.

## Commandes générales Docker Swarm

Les commandes Docker Swarm sont toujours à lancer dans le répertoire où se situe ledit fichier `docker-compose.yml`

1. **Voir l'aide des commandes docker-compose** :

    ```shell
    $ docker stack -h
    ```

2. **Lancer tous les "services" d'un docker-compose** en remplaçant :
    * `STACK_NAME` par un nom décrivant le contenu des services lancés

    **notes** : cette commande va créer tous les services et réseaux contenus dans le docker-compose. Si la stack était déjà lancée, elle va être mise à jour.

    ```shell
    $ docker stack deploy -f docker-compose.yml STACK_NAME
    ```

3. **Couper tous les "services" d'un docker-compose** en remplaçant :
    * `STACK_NAME` par le nom de la stack à supprimer

    **notes** : cette commande va supprimer tous les conteneurs et réseaux contenus dans le docker-compose.

    ```shell
    $ docker stack rm STACK_NAME
    ```

4. **Consulter la liste des stacks** :

    ```shell
    $ docker stack ls
    ```

5. **Consulter la liste des services** 

    ```shell
    $ docker service ls
    ```

6. **Consulter la liste des services d'une stack particulière** en remplaçant :
    * `STACK_NAME` par le nom de la stack à consulter

    ```shell
    $ docker stack ps STACK_NAME
    ```

7. **Consulter les logs d'un service** en remplaçant :
    * `SERVICE_ID` par l'ID obtenu via la commande `docker service ls`

    ```shell
    $ docker service logs SERVICE_ID
    ```

    **notes** : lancer avec l'option `-f` pour les suivre en continu et faire `Ctrl + C` pour arrêter le suivi.
