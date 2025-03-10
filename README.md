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
    
    class Product {
        - id : String
        - name : String
        - description : String
        - value : Double
        + getId() : String
        + getName() : String
        + getDescription() : String
        + getValue() : Double
    }
    class Vendas {
        - id : String
        - user : User
        - product : Product
        - date : Date
        + getId() : String
        + getUser() : User
        + getProduct() : Product
        + getDate() : Date
    }
       
    User "1" -- "1" Account : possui
    User "1" -- "N" Feature : possui
    User "1" -- "1" Card : possui
    User "1" -- "N" News : possui
    Vendas "N" -- "1" User : realiza
    Vendas "N" -- "1" Product : vendido
    
````
===========================================================================

Principais Tecnologias

1. Java 17: Adotaremos a versão LTS mais recente do Java para explorar as inovações desta linguagem robusta e amplamente utilizada.
2. Spring Boot 3: Implementaremos a versão mais recente do Spring Boot, maximizando a produtividade do desenvolvedor com sua poderosa autoconfiguração.
3. Spring Data JPA: Simplificaremos a camada de acesso a dados com o Spring Data JPA, facilitando a integração com bancos de dados SQL.
4. OpenAPI (Swagger): Criaremos documentação de API eficaz e clara com o OpenAPI (Swagger), alinhada à alta produtividade do Spring Boot.
5. Railway: Facilitaremos o deploy e monitoramento das soluções na nuvem com o Railway, que oferece bancos de dados como serviço e pipelines de CI/CD.
6. IA Gemini: Adicionaremos o uso da tecnologia IA Gemini para auxiliar no desenvolvimento, otimização e implementação de soluções mais inteligentes e eficientes.
 
===========================================================================

https://decola-tech-2025-production-72ce.up.railway.app/swagger-ui/index.html

===========================================================================

Descrição do Projeto:
* 
* Este projeto consiste em uma API RESTful desenvolvida em Java utilizando o framework Spring Boot. O objetivo principal é fornecer um conjunto de serviços para gerenciar informações de usuários e produtos.
* 
* Funcionalidades Principais:
* 
* Gerenciamento de Usuários:
* Criação, leitura, atualização e exclusão de usuários.
* Autenticação e autorização de usuários (implementação de JWT).
* Gerenciamento de Produtos:
* Criação, leitura, atualização e exclusão de produtos.
* Documentação da API:
* A API é documentada utilizando o Swagger, facilitando o consumo e teste dos endpoints.
* Segurança:
* Implementação de segurança com o JWT para autenticação e autorização.
* Persistencia de dados:
* Utilização do Spring Data JPA para persistência de dados em banco de dados SQL.
* Tecnologias Utilizadas:
* 
* Java 17
* Spring Boot 3
* Spring Data JPA
* JWT
* Swagger
* Maven
* Estrutura do Projeto:
* 
* O projeto segue uma estrutura de pacotes organizada, separando as responsabilidades em:
* 
* controller: Lida com as requisições HTTP e roteamento.
* service: Contém a lógica de negócio da aplicação.
* repository: Responsável pela interação com o banco de dados.
* model: Define as entidades de domínio.
* config: Configurações da aplicação.
* security: Implementação da segurança.
* Observações:
* 
* O projeto demonstra boas práticas de desenvolvimento RESTful, como o uso de verbos HTTP adequados e códigos de status.
* A documentação com Swagger facilita o consumo da API.
* A implementação de segurança com JWT garante que os endpoints estejam protegidos.
* Em resumo, este projeto é uma API RESTful bem estruturada e documentada, que fornece funcionalidades básicas de gerenciamento de usuários e produtos, com segurança implementada.

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


