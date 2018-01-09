# Bem vindo

Bem vindo ao Poll REST API.


## Informações Gerais

Está API também estará hospedada no [Heroku](https://poll-api.herokuapp.com/swagger-ui.html)                                .


## Especificações

- Java 8
- Spring Framework
- Hiraki
- Swagger
- MySQL
- Flyway


## Database

Crie uma instancia do banco de dados com nome 'poll' e ao executar o sistema pela primeira serão criadas as tabelas e adicionado um registro de exemplo. 
Caso queira, pode modificar o nome, usuario e senha do banco de dados no arquivo 'application.properties'.

```
spring.datasource.url=jdbc:mysql://localhost:3306/poll
spring.datasource.username=root
spring.datasource.password=root
```


## Download e Execução

Para fazer download do código fonte digite o comando abaixo no prompt de comando:

```
$ git clone https://github.com/maiconkeller/springboot_poll_api.git
```

Para compilar o código com Maven (3.5.2)

```
$ mvn clean install
```

