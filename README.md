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
- Springdoc OpenAPI (Swagger)

## Funcionalidades

- CRUD completo para fundos de investimento
- Listar todos os fundos
- Adicionar novos fundos
- Atualizar fundos existentes
- Deletar fundos
- Documentação automática com Swagger UI
- Paginação e ordenação de resultados

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

3. Acesse no navegador ou via Postman:
   - Swagger UI: http://localhost:8080/swagger-ui.html
   - H2 Console: http://localhost:8080/h2-console (usuário:admin, senha em branco)

## Endpoints principais

| Método | Rota             | Descrição                |
|--------|------------------|--------------------------|
| GET    | `/fundos`        | Lista todos os fundos    |
| GET    | `/fundos/{id}`   | Retorna fundo por ID     |
| POST   | `/fundos`        | Cria um novo fundo       |
| PUT    | `/fundos/{id}`   | Atualiza fundo existente |
| DELETE | `/fundos/{id}`   | Remove fundo por ID      |


## Estrutura do Projeto


```bash
funds-api/
├── src/
│   ├── main/
│   │   ├── java/com/luan/funds/
│   │   │   ├── controller/
│   │   │   └── FundoController.java
│   │   │   ├── dto/
│   │   │   └── FundoDTO.java
│   │   │   ├── model/
│   │   │   └── Fundo.java
│   │   │   ├── repository/
│   │   │   └── FundoRepository.java
│   │   │   ├── config/ 
│   │   │   ├── DataLoader.java
│   │   │   └── SwaggerConfig.java
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

