FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Download Azul JDK 11 https://cdn.azul.com/zulu/bin/zulu11.70.15-ca-jdk11.0.22-linux_amd64.deb with wget
RUN wget -q -O zulu11.70.15-ca-jdk11.0.22-linux_amd64.deb https://cdn.azul.com/zulu/bin/zulu11.70.15-ca-jdk11.0.22-linux_amd64.deb

# Install Azul JDK 11
RUN apt-get update && apt-get install -y ./zulu11.70.15-ca-jdk11.0.22-linux_amd64.deb

# Clean up
RUN rm zulu11.70.15-ca-jdk11.0.22-linux_amd64.deb

# Install Node.js
wget -qO- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.7/install.sh | bash

# Install Node.js 16.13.0
RUN /bin/bash -c "source /root/.nvm/nvm.sh && nvm install 16.13.0"