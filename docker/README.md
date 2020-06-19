# Migration base de données CE 7.0 > DXP 7.2

Le processus de migration de base de données permet de transformer un dump de base de données CE 7.0 en dump DXP 7.2.

**Notes** : la partie concernant l'image MySQL n'est à prendre en compte que s'il n'existe pas d'installation locale de MySQL. Dans le cas d'une installation locale, modifier les configurations de connexion en conséquence et remplacant l'adresse du conteneur `mysql` par l'IP de la machine où se trouve MySQL.

## Fichiers en entrée :

Les fichiers suivants sont les entrées du process et doivent être déplacés :

* Dans le répertoire `images/mysql-upgrade/sources` :
    * Le dump DB Liferay 7.0 au format `.sql` ou `.dump` 
    * Le script pre-upgrade à jouer avant la migration : `pre-upgrade.sql`

## Images

Images à créer :

* mysql-upgrade dans le dossier `images/mysql-upgrade`
* liferay-portal dans le dossier `images/liferay-upgrade`

* Créer l'image MySQL
    * Placer dans le répertoire `images/mysql-upgrade/sources` le fichier dump de la base à migrer.
    * Placer dans le fichier `images/mysql-upgrade/sources/pre-upgrade.sql` les requêtes de netoyage à effectuer avant la migration.
    * Se placer dans le répertoire `images/mysql-upgrade`
    * Exécuter la commande suivante où :
        * `FILE_NAME` est le nom du fichier dump.
        ```shell
        $ docker image build --build-arg DUMP_FILE_NAME=FILE_NAME -t mysql-upgrade:ems .
        ```
* Créer l'image Liferay
    * Se placer dans le répertoire `images/liferay-upgrade`
    * Exécuter la commande suivante :
        ```shell
        $ docker image build -t liferay-upgrade .
        ```

## Exécution

### Démarrage de l'image mysql-upgrade

Se placer dans le répertoire dans le répetoire courrant.

Lancer l'image mysql-upgrade via docker-compose.

```shell
$ MYSQL_TAG=ems docker-compose -f dc-lfr-upgrade.yml up -d mysql
```

Attendre que l'import automatique du dump soit fait dans l'image Docker.

Pour cela, vérifier que dans le log soit visible pour la seconde fois le texte `mysqld: ready for connections.` via la commande :

```shell
$ docker-compose -f dc-lfr-upgrade.yml logs -f
```

C'est uniquement lors de la seconde apparition dudit texte que le dump d'entrée aura été totalement importé.

Sortir du log dès le message apparu avec `Ctrl+C`

### Démarrage de l'image liferay-portal et upgrade de la base de données

Se placer dans le répertoire dans le répetoire courrant.

Créer dans le répertoire courant le fichier `output/upgrade.log`.

```shell
$ touch output/upgrade.log
```

Lancer l'image Liferay avec la commande suivante où :
* `DATA_PATH` est le chemin vers le répertoire de persistance.

```shell
$ DATA=DATA_PATH  docker-compose -f dc-lfr-upgrade.yml up -d liferay-portal

--> $ DATA=/data/ems-data docker-compose -f dc-lfr-upgrade.yml up -d liferay-portal
--> $ DATA=/var/local docker-compose -f dc-lfr-upgrade.yml up -d liferay-portal
```

Suivre l'évolution de l'upgrade via la commande :

```shell
$ docker-compose -f dc-lfr-upgrade.yml logs -f
```

Le script peut mettre plus d'une heure à s'exécuter.

### Extraction du dump de la base migrée

Pour extraire le dump de la base migrée, exécuter la commande suivante en remplaçant `CONTAINER_ID` par l'identifiant du conteneur `mysql-upgrade` retrouvé via `docker ps`.

```shell
$ docker exec CONTAINER_ID /usr/bin/mysqldump -u liferay --password=sully liferay-db > output/migrated-dump.sql
```

Le fichier `migrated-dump.sql`se trouve désormais dans le répertoire `output` du répertoire courant.

# Lancement d'un environnement EMS complet en DXP 7.2

## Images

Images à créer :

## Fichiers d'entrées

* Pour elasticsearch-ems :
    *  dans le répertoire de configuration `configs/elasticsearch-ems` :
        *  `synonyms.txt` pour la description des synonymes.
* Pour liferay-ems :
    * dans le répertoire de source pour la création de l'image `images/liferay-ems/sources` :
        * le script `wait-for-it.sh` permettant de tester la disponibilité d'autres noeuds.
        * le certificat `certigna-authority-2015-2025.cer`
        * le certificat `apiDailymotion.cer`
        * le certificat `apiYoutube.cer`
    * dans le répertoire de livraison pour la création de l'image `images/liferay-ems/dist`
        * le repertoire `[LFR_TAG_VERSION]` contenant tous les binaires à livrer ainsi que la clef d'activation Liferay DXP (`LFR_TAG_VERION` correspond aussi au tag qui sera utilisé pour décrire l'image )
    * dans le répertoire de configuration `configs/liferay-ems` :
        * `deploy` dossier dans lequel placer tous les éléments que l'on souhaite déployer au démarrage de Liferay.
        * `files/tomcat/bin/setenv.sh` pour définir les propriétés de lancement du serveur.
        * `files/tomcat/conf/context.xml` pour définir les propriétés de lancement du serveur.
        * `files/tomcat/conf/server.xml` pour exporter le port AJP.
        * `files/portal-ext.properties` pour définir les proprités Liferay et EMS.
        * `files/portal-setup-wizzard.properties` pour définir les proprités de connection à la BDD et d'administration par defaut de Liferay.
        * `files/osgi/configs` dossier dans lequel placer tous les fichiers de config osgi.
        * `files/osgi/war/liferay-javamelody-hook-1.82.0.0.war` librairie javamelody (@see https://github.com/javamelody/javamelody/wiki/LiferayPlugin).
        * `scripts/wait-for-dependencies.sh` script lancé avant le serveur permettant d'attendre les dépendances MySQL et ElasticSearch

Créer et remplir le fichier `./.env` suivant :

```properties
# Chemin vers le repertoire de persistance
DATA_PATH=/var/local

# Version de l'imgage Liferay
LFR_TAG_VERSION=

# Connection MySQL
MYSQL_ADDRESS=
MYSQL_DB=
MYSQL_USER=
MYSQL_PASSWORD=

# Email de copie de tous les mails provenant du serveur SMTP (à ne pas utiliser en prod)
TRAIL_MAIL_ADDRESS=
```


## Exécution

Pour lancer la totalité des services, lancer la commande :

```shell
$ docker-compose up -d
```

**notes** : 
* Lors du premier lancement, toutes les images seront créés.
* Lors de la livraison d'une nouvelle version, seule l'image Liferay sera recrée.

Suivre les logs via la commande :

```shell
$ docker-compose logs -f
```

## Livraison d'une nouvelle version

1. Changer la variable d'environnement `LFR_TAG_VERSION` dans le fichier `./.env`. 

    **Notes** : cette dernière sera utilisée comme tag de l'image `liferay-ems` et comme référence pour trouver les nouveaux binaires à déployer.

2. Créer un dossier correspondant exactement à la variable `LFR_TAG_VERSION` dans le dossier `./images/liferay-ems/sources/dist/`.

3. Placer tous les binaires devant être déployés ainsi que la clef Liferay DXP de l'environnement dans le dossier précédemment créé.

4. Effectuer un dump de la base.

5. Lancer la commande suivante à la racine pour arrêter les services conteneurisés :

    ```shell
    docker-compose down
    ```

6. Lancer la commande suivante à la racine pour créer la nouvelle image Liferay et relancer les services conteneurisés :

    ```shell
    docker-compose up -d
    ```

7. Vérifier le bon déroulement de la livraison via la commande suivante :

    ```shell
    docker-compose logs -f
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
