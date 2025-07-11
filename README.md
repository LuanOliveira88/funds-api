# funds-api

API RESTful para gestão de fundos de investimento, desenvolvida em Java com Spring Boot.

## Tecnologias
- Java 21
- Spring Boot 3.5.3
- Maven
- H2 Database (banco em memória para desenvolvimento)
- Lombok
- Spring Data JPA
- Spring Boot DevTools

## Funcionalidades

- CRUD completo para fundos de investimento
- Listar todos os fundos
- Adicionar novos fundos
- (Futuro) Atualizar fundos existentes
- (Futuro) Deletar fundos

## Como rodar o projeto

1. Clone o repositório

```bash
git clone https://github.com/LuanOliveira88/funds-api
cd funds-api
```

2. Compile e rode com Maven:

```bash
mvn clean spring-boot:run
```

3. Acesse a API:

- Endpoint para listar fundos: ``GET http://localhost:8080/fundos``
- Endpoint para adicionar fundos: ``POST http://localhost:8080/fundos``

## Estrutura do Projeto

```bash
funds-api/
├── src/
│   ├── main/
│   │   ├── java/com/luan/funds/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── controller/
│   │   │   └── FundsApiApplication.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Observações

Utiliza banco H2 em memória, ideal para testes e desenvolvimento
Futuramente poderá ser configurado para bancos relacionais em produção

## Contribuição
Pull requests são bem-vindos! Para mudanças maiores, abra uma issue primeiro para discutirmos.

