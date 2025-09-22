package com.ricardooshiro.sbkafkaproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardooshiro.sbkafkaproducer.dto.PagtoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagtoRequestProducer {
    @Value("${topicos.pagto.request.topic}")
    private String topicoPagtoRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(PagtoDTO pagto) throws JsonProcessingException {
        String conteudo = objectMapper.writeValueAsString(pagto);
        kafkaTemplate.send(topicoPagtoRequest, conteudo);
        return "Pagto enviado para processamento";
    }
}
