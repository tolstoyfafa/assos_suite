# Assosuite API documentation
You can follow the steps below to get a runing developpment env for assosuite backend side.

- AssoSuite backend is written with java 11 usig [spring boot 2.2.4](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) framework
- we use maven to build the project

> The backend component require a runing MongoDB

### available commands

#### mvn spring-boot run 
- this command launch a tomcat server that contains the backend application
the api is available by default on http://localhost:8080
> Note that after each  modification the server is reload so you don't need to stop it to get the new changes.

#### mvn test
- launch all available tests in src/test directory

#### mvn clean 
- remove the target directory that contains the jars to get a clean env 

### Swagger API

To get the API documentation you nee to run the application with `mvn spring-boot run` than you can follow this  [link](http://localhost:8080/swagger-ui.html)

### Configuration
all available configuration for devolepment env of backend are [here](./src/main/resources/application.properties) you can follow available comments there to better understanding
