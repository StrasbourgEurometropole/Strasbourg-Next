FROM ubuntu:latest

# Create the user
ARG USERNAME=app
ARG USER_UID=1000
ARG USER_GID=$USER_UID

RUN  apt-get update -y && \
     apt-get install -y sudo

# Create the user
RUN groupadd --gid $USER_GID $USERNAME \
    && useradd --uid $USER_UID --gid $USER_GID -m $USERNAME \
    #
    # [Optional] Add sudo support. Omit if you don't need to install software after connecting.
    && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME

USER $USERNAME
CMD [ "sleep", "infinity"]