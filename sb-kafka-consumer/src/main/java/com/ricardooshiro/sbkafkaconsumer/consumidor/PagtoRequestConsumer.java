package com.ricardooshiro.sbkafkaconsumer.consumidor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagtoRequestConsumer {
    @KafkaListener(
            topics = "${topicos.pagto.request.topic}",
            groupId = "pagto-request-consumer-1"
    )
    public void consume(String message){
        System.out.println("===== MENSAGEM RECEBIDA ===== " + message);
    }
}
