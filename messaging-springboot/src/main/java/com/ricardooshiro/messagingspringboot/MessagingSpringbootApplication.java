package com.ricardooshiro.messagingspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MessagingSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagingSpringbootApplication.class, args);
    }

}

@RestController
@RequestMapping("/kafka")
class HelloController {
    private HelloProducer service;

    public HelloController(HelloProducer service) {
        this.service = service;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        service.sendMessage("Hello, " + name);
        return "OK";
    }
}