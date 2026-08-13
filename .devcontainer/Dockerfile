# Imagem básica
# Instala o Ubuntu com java e maven
FROM maven:3.9-eclipse-temurin-21-noble

# Habilita a interação não interativa 
ENV DEBIAN_FRONTEND=noninteractive

# Instala as ferramentas que não estão na imagem base
# apt-get update - Atualiza os repositórios de Software
# apt-get install - Instala as ferramentas e esse -y é sim pra tudo.
# curl - testa as APIs
# git-fls - Armazenamento de arquivos binários

RUN apt-get update && apt-get install -y \
    mysql-server-8.0 \
    git \
    git-lfs \
    curl \
    unzip \
    zip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*
