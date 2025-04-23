agora arrumer meu Markdown

# 📦 Projeto de Microsserviço de Pedidos com RabbitMQ

Este projeto é uma simulação simples de arquitetura de microsserviços utilizando **Java 21**, **Spring Boot**, **RabbitMQ** e **PostgreSQL (via Docker)**.

Ele é dividido em dois serviços:

- **📝 Serviço de Pedido**: recebe uma requisição via API REST contendo um pedido com descrição e itens, persiste no banco de dados e envia a mensagem via RabbitMQ.
- **📬 Serviço de Processamento**: consome as mensagens enviadas para o RabbitMQ e apenas imprime o conteúdo no console (simulando um processamento).

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- RabbitMQ
- PostgreSQL (via Docker)
- Docker
- Maven

---

## 🧪 Como Rodar o Projeto
- Java 21 instalado
- Maven instalado
- Docker instalado
- Instância do RabbitMQ rodando (local ou remota)

## 🐘 Subir o PostgreSQL via Docker
docker run --name pedidos-db \
  -e POSTGRES_PASSWORD=123456 \
  -e POSTGRES_DB=pedidos \
  -p 5432:5432 \
  -d postgres

  # ou, se preferir, usando docker-compose
docker-compose up -d

## 🐰 Configurar o RabbitMQ
Certifique-se de ter uma instância do RabbitMQ rodando.

- Porta: 5672
- Interface de gerenciamento: http://localhost:15672
- Usuário: guest
- Senha: guest

▶️ Rodar os Microsserviços
# Serviço de Pedidos
cd order
mvn spring-boot:run


# Serviço de Processamento
cd processamento
mvn spring-boot:run


##🔄 Funcionamento
1. O usuário envia um POST com um pedido (contendo descrição e itens).
2. O serviço de pedidos:
   - Persiste os dados no PostgreSQL.
   - Envia uma mensagem com o conteúdo do pedido para o RabbitMQ.
3. O serviço de processamento consome essa mensagem e imprime no console.
