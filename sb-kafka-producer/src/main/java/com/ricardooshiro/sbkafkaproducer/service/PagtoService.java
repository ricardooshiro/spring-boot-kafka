package com.ricardooshiro.sbkafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ricardooshiro.sbkafkaproducer.dto.PagtoDTO;
import com.ricardooshiro.sbkafkaproducer.producer.PagtoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagtoService {
    @Autowired
    private PagtoRequestProducer pagtoRequestProducer;

    public String integrarPagto(PagtoDTO pagto) {
        try {
            return pagtoRequestProducer.sendMessage(pagto);
        } catch (JsonProcessingException e) {
            return "Houve um erro ao solicitar pagto " + e.getMessage();
        }
    }
}
