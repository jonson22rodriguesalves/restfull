# Decola Tech 2025
#JAVA RESTFUL API

## Diagrama de Classes

````mermaid
classDiagram
    class User {
        +String name
        +Account account
        +List~Feature~ features
        +Card card
        +List~News~ news
    }
    class Account {
        - number : String
        - agency : String
        - balance : Double
        - limit : Double
        + getNumber() : String
        + getAgency() : String
        + getBalance() : Double
        + getLimit() : Double
    }
    class Feature {
        - icon : String
        - description : String
        + getIcon() : String
        + getDescription() : String
    }
    class Card {
        - number : String
        - limit : Double
        + getNumber() : String
        + getLimit() : Double
    }
    class News {
        - icon : String
        - description : String
        + getIcon() : String
        + getDescription() : String
    }
    User "1" -- "1" Account : possui
    User "1" -- "N" Feature : possui
    User "1" -- "1" Card : possui
    User "1" -- "N" News : possui
````
===========================================================================

Principais Tecnologias

JJava 17 (LTS): Utilizaremos a versão de suporte de longo prazo mais recente do Java, garantindo acesso às últimas otimizações e funcionalidades da linguagem.
Spring Boot 3: Implementaremos a aplicação utilizando a versão mais recente do Spring Boot, aproveitando seus recursos de autoconfiguração para aumentar a produtividade e reduzir o tempo de desenvolvimento.
Spring Data JPA: Simplificaremos a camada de acesso a dados através do Spring Data JPA, facilitando a interação com bancos de dados relacionais.
OpenAPI (Swagger): Geraremos documentação de API completa e interativa utilizando OpenAPI (Swagger), assegurando clareza e facilidade de uso para os consumidores da API.
Railway: A plataforma Railway será utilizada para o deploy e monitoramento da aplicação em nuvem, além de prover serviços de banco de dados e integração contínua/entrega contínua (CI/CD)."
===========================================================================

https://decola-tech-2025-production-72ce.up.railway.app/swagger-ui/index.html

===========================================================================

Documentação da API RESTful de Usuários e Produtos
Este documento fornece exemplos de como interagir com a API RESTful de usuários e produtos, incluindo exemplos de requisições e respostas para as operações de criação e atualização.

1. Criação de Usuários (CREATE)
   1.1. Requisição (POST /users)
   Para criar um novo usuário, envie uma requisição POST para o endpoint /users com um corpo JSON contendo os dados do usuário.

Exemplo de Requisição JSON:

{
"name": "Jonson Rodrigues",
"account": {
"number": "123456",
"agency": "0231",
"balance": 5000.00,
"limit": 5000.00
},
"card": {
"number": "9876 5432 1012 3455",
"limit": 5000.00
},
"features": [
{
"icon": "icone-pix",
"description": "Pix"
}
],
"news": [
{
"icon": "icone-dolar",
"description": "Dólar sobe"
}
]
}

{
"name": "Tania Porto",
"account": {
"number": "123457",
"agency": "0231",
"balance": 5000.00,
"limit": 5000.00
},
"card": {
"number": "9876 5432 1012 3456",
"limit": 5000.00
},
"features": [
{
"icon": "icone-pix",
"description": "Pix"
}
],
"news": [
{
"icon": "icone-dolar",
"description": "Dólar sobe"
}
]
}

1.2. Resposta (201 Created)
Em caso de sucesso, a API retornará uma resposta com código de status 201 (Created) e o corpo da resposta conterá o usuário criado com o ID gerado pelo banco de dados.

Exemplo de Resposta JSON:

{
"id": 1,
"name": "Jonson Rodrigues",
"account": {
"id": 1,
"number": "123456",
"agency": "0231",
"balance": 5000.00,
"limit": 5000.00
},
"card": {
"id": 1,
"number": "9876 5432 1012 3455",
"limit": 5000.00
},
"features": [
{
"id": 1,
"icon": "icone-pix",
"description": "Pix"
}
],
"news": [
{
"id": 1,
"icon": "icone-dolar",
"description": "Dólar sobe"
}
]
}

2. Atualização de Usuários (UPDATE)
   2.1. Requisição (PUT /users/{id})
   Para atualizar um usuário existente, envie uma requisição PUT para o endpoint /users/{id}, substituindo {id} pelo ID do usuário que você deseja atualizar. O corpo da requisição deve conter um JSON com os dados atualizados do usuário.

Exemplo de Requisição JSON:

{
"name": "João da Silva",
"account": {
"id": 1,
"number": "123456",
"agency": "7890",
"balance": 8000.00,
"limit": 900.00
},
"card": {
"id": 1,
"number": "9876 5432 1012 3456",
"limit": 4000.00
},
"features": [
{
"id": 1,
"icon": "icone.jpg",
"description": "SEG"
}
],
"news": [
{
"id": 1,
"icon": "dolar.jpg",
"description": "DI sobe"
}
]
}

2.2. Resposta (200 OK)
Em caso de sucesso, a API retornará uma resposta com código de status 200 (OK) e o corpo da resposta conterá o usuário atualizado.

Exemplo de Resposta JSON:

{
"id": 1,
"name": "João da Silva",
"account": {
"id": 1,
"number": "123456",
"agency": "7890",
"balance": 8000.00,
"limit": 900.00
},
"card": {
"id": 1,
"number": "9876 5432 1012 3456",
"limit": 4000.00
},
"features": [
{
"id": 1,
"icon": "icone.jpg",
"description": "SEG"
}
],
"news": [
{
"id": 1,
"icon": "dolar.jpg",
"description": "DI sobe"
}
]
}

3. Criação de Produtos (CREATE)
   3.1. Requisição (POST /products)
   Para criar um novo produto, envie uma requisição POST para o endpoint /products com um corpo JSON contendo os dados do produto.

Exemplo de Requisição JSON:

{
"nome": "BBPREV",
"preco": 1000,
"icon": "PREV.jpg",
"description": "Previdencia Complementar"
}

Documentação da API RESTful de Usuários e Produtos
Este documento fornece exemplos de como interagir com a API RESTful de usuários e produtos, incluindo exemplos de requisições e respostas para as operações de criação e atualização.

1. Criação de Usuários (CREATE)
   1.1. Requisição (POST /users)
   Para criar um novo usuário, envie uma requisição POST para o endpoint /users com um corpo JSON contendo os dados do usuário.

Exemplo de Requisição JSON:

JSON

{
"name": "Jonson Rodrigues",
"account": {
"number": "123456",
"agency": "0231",
"balance": 5000.00,
"limit": 5000.00
},
"card": {
"number": "9876 5432 1012 3455",
"limit": 5000.00
},
"features": [
{
"icon": "icone-pix",
"description": "Pix"
}
],
"news": [
{
"icon": "icone-dolar",
"description": "Dólar sobe"
}
]
}
JSON

{
"name": "Tania Porto",
"account": {
"number": "123457",
"agency": "0231",
"balance": 5000.00,
"limit": 5000.00
},
"card": {
"number": "9876 5432 1012 3456",
"limit": 5000.00
},
"features": [
{
"icon": "icone-pix",
"description": "Pix"
}
],
"news": [
{
"icon": "icone-dolar",
"description": "Dólar sobe"
}
]
}
1.2. Resposta (201 Created)
Em caso de sucesso, a API retornará uma resposta com código de status 201 (Created) e o corpo da resposta conterá o usuário criado com o ID gerado pelo banco de dados.

Exemplo de Resposta JSON:

JSON

{
"id": 1,
"name": "Jonson Rodrigues",
"account": {
"id": 1,
"number": "123456",
"agency": "0231",
"balance": 5000.00,
"limit": 5000.00
},
"card": {
"id": 1,
"number": "9876 5432 1012 3455",
"limit": 5000.00
},
"features": [
{
"id": 1,
"icon": "icone-pix",
"description": "Pix"
}
],
"news": [
{
"id": 1,
"icon": "icone-dolar",
"description": "Dólar sobe"
}
]
}
2. Atualização de Usuários (UPDATE)
   2.1. Requisição (PUT /users/{id})
   Para atualizar um usuário existente, envie uma requisição PUT para o endpoint /users/{id}, substituindo {id} pelo ID do usuário que você deseja atualizar. O corpo da requisição deve conter um JSON com os dados atualizados do usuário.

Exemplo de Requisição JSON:

JSON

{
"name": "João da Silva",
"account": {
"id": 1,
"number": "123456",
"agency": "7890",
"balance": 8000.00,
"limit": 900.00
},
"card": {
"id": 1,
"number": "9876 5432 1012 3456",
"limit": 4000.00
},
"features": [
{
"id": 1,
"icon": "icone.jpg",
"description": "SEG"
}
],
"news": [
{
"id": 1,
"icon": "dolar.jpg",
"description": "DI sobe"
}
]
}
2.2. Resposta (200 OK)
Em caso de sucesso, a API retornará uma resposta com código de status 200 (OK) e o corpo da resposta conterá o usuário atualizado.

Exemplo de Resposta JSON:

JSON

{
"id": 1,
"name": "João da Silva",
"account": {
"id": 1,
"number": "123456",
"agency": "7890",
"balance": 8000.00,
"limit": 900.00
},
"card": {
"id": 1,
"number": "9876 5432 1012 3456",
"limit": 4000.00
},
"features": [
{
"id": 1,
"icon": "icone.jpg",
"description": "SEG"
}
],
"news": [
{
"id": 1,
"icon": "dolar.jpg",
"description": "DI sobe"
}
]
}
3. Criação de Produtos (CREATE)
   3.1. Requisição (POST /products)
   Para criar um novo produto, envie uma requisição POST para o endpoint /products com um corpo JSON contendo os dados do produto.

Exemplo de Requisição JSON:

JSON

{
"nome": "BBPREV",
"preco": 1000,
"icon": "PREV.jpg",
"description": "Previdencia Complementar"
}
3.2. Resposta (201 Created)
Em caso de sucesso, a API retornará uma resposta com código de status 201 (Created) e o corpo da resposta conterá o produto criado com o ID gerado pelo banco de dados.

Exemplo de Resposta JSON:

{
"id": 1,
"nome": "BBPREV",
"preco": 1000,
"icon": "PREV.jpg",
"description": "Previdencia Complementar"
}

4. Observações:
   Certifique-se de substituir os valores de exemplo pelos dados reais que você deseja usar.
   A API pode retornar outros códigos de status em caso de erros, como 400 (Bad Request) para requisições inválidas ou 500 (Internal Server Error) para erros internos do servidor.
   Para obter informações mais detalhadas sobre os endpoints e os modelos de dados, consulte a documentação da API ou o código-fonte do projeto.


