# crud-cliente-backend
Crud Simples de Cliente

Tecnologias usadas:
- Java 17;
- Spring Boot 3.2;
- JDBC API;
- Lombok;
- Mapstruct;
- Liquibase;
- Banco de Dados H2.

O projeto deve ser importado pelo intellij, e a partir dele buscar os dados via postman.
A aplicação tem as seguintes rotas:

- /cliente (Post): Cria clientes na base de dados;
- /cliente (Get): Busca todos os clientes da base;
- /cliente/:id (Get): Buscar cliente pelo id.

Este backend já se encontra configurado para funcionar com o [crud-cliente-frontend](https://github.com/rendersonjunior/crud-cliente-frontend)
o cors já está configurado para esse frontend que roda no caminho: http://localhost:4200.

Próximos passos:
- Incluir a busca por nome;
- Incluir os testes para as rotas;
- Incluir as validações de dados duplicados antes de inserir o cliente;
- Tratamento de erros para exceções de banco;
- Incluir a rota de edição;
- Incluir o Dockerfile para conteinerização deste projeto.
