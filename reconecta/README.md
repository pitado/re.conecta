# Re.Conecta (Spring Boot + PostgreSQL - Neon)

API para conectar doadores de eletrônicos a estudantes.

## Como rodar

1. Tenha Java 17 e Maven.
2. Configure o `application.yml` (já apontado para Neon).
3. Rode:

```bash
mvn spring-boot:run
```

Acesse o Swagger: `http://localhost:8080/swagger-ui/index.html`

## Endpoints principais

- `/usuarios` (CRUD)
- `/eletronicos` (CRUD e `/eletronicos/disponiveis`)
- `/doacoes` (CRUD)

## Banco de dados

Script SQL em `db/postgres/ddl_dml_reconecta.sql`.

> **Atenção**: As credenciais do Neon estão no `application.yml` (fornecidas pelo autor).
