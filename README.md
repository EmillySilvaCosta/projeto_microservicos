# Desafio Final Microsserviços

O projeto aborda o desenvolvimento de dois serviços onde o serviço de controle de chamados de um Help Desk se comunica
com o serviço de envio de email. Foi utilizado o serviço de descoberta para catalogar todas as URLs dos endereços dos serviços
e suas instâncias.
O projeto teve como objetivo aplicar os conteúdos estudados sobre criação de Microsserviços com Spring Boot, Eureka, Gateway, AWS RDS PostgreSQL 
e deploy através de Docker, AWS EC2.

### Observações: 

Ao rodar o projeto seguir esta ordem: ms_server, envio-de-email-ms, help-desk, ms_gateway.


**Desenvolvido por:**

* Elida Emilly 

----

### Configurações utilizadas:

* STS - IDE Spring Tools Suite 4 for Eclipse
* Maven
* Spring Boot 2.7.7
* Java 17
* Eureka Client 
* Eureka Server
* Gateway
* AWS RDS PostgreSQL 
* AWS EC2
* Docker
* Java Mail Sender
* Spring Boot DevTools
* Spring Web
* Spring JPA
* Validation


### Endpoints:

# envio-de-email-ms

## Email

**Enviar email**

POST

http://localhost:8083/envio-de-email-ms/v1/emails/enviar

```json
{
    "destinatario":"cliente@gmail.com",
    "assunto": "Assunto do email",
    "texto": "Texto do email"
}
```

# help-desk

## Operador

**Criar operador**

POST

http://localhost:8083/help-desk/v1/operadores

```json
{
    "nome": "Operador",
    "email": "operador@gmail.com",
    "idSetor": 1,
    "nivel": "NIVEL_2"
}
```

**Buscar operador** 

GET

http://localhost:8083/help-desk/v1/operadores/1

**Buscar todos operadores**

GET

http://localhost:8083/help-desk/v1/operadores

**Buscar operador** 

GET

http://localhost:8083/help-desk/v1/operadores/1

## Setor

**Criar setor**

POST

http://localhost:8083/help-desk/v1/setores

```json
{
    "nome": "RH"
}
```

**Buscar setores**

GET

http://localhost:8083/help-desk/v1/setores

**Buscar  todos setores**

GET

http://localhost:8083/help-desk/v1/setores/1

## Chamado

**Abrir chamado** 

POST

http://localhost:8083/help-desk/v1/chamados

```json
{
    "nomeCliente":"cliente",
    "emailCliente":"clientenome@gmail.com",
    "assunto":"Teste 02",
    "texto":"Testando aplicação",
    "idSetor": 1
}
```

**Buscar chamado por Id**

GET

http://localhost:8083/help-desk/v1/chamados/1

**Escalar chamado**

PATCH

http://localhost:8083/help-desk/v1/chamados/escalar/1/nivel/3

PATCH

**Transferir chamado**

PATCH

http://localhost:8083/help-desk/v1/chamados/transferir/1/setor/2

**Finalizar chamado**

PATCH

http://localhost:8083/help-desk/v1/chamados/finalizar/1

