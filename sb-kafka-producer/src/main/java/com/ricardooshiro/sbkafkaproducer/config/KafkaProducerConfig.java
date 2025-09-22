package com.ricardooshiro.sbkafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Value("${topicos.pagto.request.topic}")
    private String pagtoRequestTopic;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> props = kafkaProperties.buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic pagtoRequestTopicBuilder() {
        return TopicBuilder.name(pagtoRequestTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}