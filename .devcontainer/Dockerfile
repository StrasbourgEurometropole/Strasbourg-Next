FROM liferay/dxp:2023.q4.3


USER root

RUN adduser --disabled-password --home /home/vscode vscode --uid 1001 && \
	usermod -g 1001 liferay


USER vscode:liferay

WORKDIR /home/vscode

CMD ["/bin/bash"]
ENTRYPOINT ["sleep", "infinity"]