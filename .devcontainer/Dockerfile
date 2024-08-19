FROM liferay/portal:2024.q4.8

USER root

RUN apt-get update

RUN apt-get install -y wget git sudo gnupg2 screen mysql-client gettext

RUN usermod -aG sudo liferay

RUN echo 'liferay ALL=(ALL) NOPASSWD: ALL' >> /etc/sudoers

# Install dependencies
RUN apt-get install -y debian-keyring debian-archive-keyring apt-transport-https && \
    curl -1sLf 'https://dl.cloudsmith.io/public/caddy/stable/gpg.key' | sudo gpg --dearmor -o /usr/share/keyrings/caddy-stable-archive-keyring.gpg && \
    curl -1sLf 'https://dl.cloudsmith.io/public/caddy/stable/debian.deb.txt' | sudo tee /etc/apt/sources.list.d/caddy-stable.list && \
    apt-get update && \
    apt-get install -y caddy

# Copy the Caddyfile to the container
COPY Caddyfile /etc/caddy/Caddyfile

USER liferay

RUN curl -L https://raw.githubusercontent.com/liferay/liferay-blade-cli/master/cli/installers/local | sh

RUN echo 'export PATH="$PATH:$HOME/jpm/bin"' >> ~/.bash_profile

ENV JAVA_VERSION=zulu11

CMD ["/bin/bash"]

ENTRYPOINT ["tail", "-f" ,  "/dev/null"]