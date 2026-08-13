#!/bin/bash

#se ocorrer um erro, o script para
set -e

#exibe menssagem no terminal
echo "Iniciando MySQL..."
#inicia o MySQL
service mysql start

echo "Aguardando MySQL ficar pronto..."
# Verifica se o MySQL ja iniciou
# Tenta pingar trinta vezes
for tentativa in $(seq 1 30); do
    if mysqladmin ping --silent; then
        echo "MySQL pronto."
        break
    fi
    sleep 1
done

# Se passou das 30 tentativas sem resposta, para o script com erro.
if ! mysqladmin ping --silent; then
    echo "Erro: MySQL não respondeu a tempo." >&2
    exit 1
fi

echo "Configurando banco..."

#Envia para o MySQL os comandos
# CREATE USER - Cria um usuário
# GRANT - Dá permissões para o usuário
# FLUSH - Confirma as alteração
mysql <<EOF
CREATE DATABASE IF NOT EXISTS ecommerce
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'Liquid' IDENTIFIED BY '1223#';

GRANT ALL PRIVILEGES ON ecommerce.* TO 'Liquid';

FLUSH PRIVILEGES;
EOF

echo "MySQL configurado com sucesso!"
