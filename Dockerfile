FROM harbor-cds.sully-group.fr/proxy_cache/liferay/dxp:2024.q3.2

COPY --chown=liferay:liferay build/docker/deploy /mnt/liferay/deploy

USER root

RUN apt update && apt install gettext mysql-client -y

# Création du repertoire de données
RUN mkdir -p /data \
    && chown -R liferay:liferay /data

COPY liferay_entrypoint_debug.sh /usr/local/bin/
RUN chmod ug+rwx,o+rx /usr/local/bin/liferay_entrypoint_debug.sh

# Création des dossiers temporaires
RUN mkdir -p /tmp/certificates

# Copie du script permettant d'attendre les autres services avant démarrage du serveur
COPY --chown=liferay:liferay wait-for-it.sh /
RUN chmod +x /wait-for-it.sh

ENV JAVA_VERSION=zulu11

# Repositionnement sur l'utilisateur liferay
USER liferay

# Création des dossiers utils pour la persistance et les imports
RUN mkdir -p /data/import/agenda/archives \
    && mkdir -p /data/liferay/document_library
