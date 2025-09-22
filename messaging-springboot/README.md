<h1 align="center">
  Messaging Spring Boot
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Demo&color=8257E5&labelColor=000000" alt="Demo" />
</p>

Demo para introduzir o conceito de mensageria Pub/Sub utilizando Spring Boot e Kafka.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring for Kafka](https://docs.spring.io/spring-kafka/reference/html/)
- [Kafka](https://kafka.apache.org)
- [Docker Compose](https://docs.docker.com/compose/)

## Como Executar

- Rodar o Kafka com o Docker Compose:
```
$ docker-compose up
```

- Adicionar /etc/hosts o hostname `kafka`.
- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/messaging-springboot-0.0.1-SNAPSHOT.jar
```

- Enviar um hello
```
Browser: http://localhost:8080/kafka/hello/tester
OK
```

- Visualizar mensagem recebida no log:
```
Consumer Message: Hello, tester
```