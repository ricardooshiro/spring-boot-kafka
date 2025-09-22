package com.ricardooshiro.sbkafkaproducer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PagtoDTO {
    private Integer numero  ;
    private String descricao;
    private BigDecimal valor;
}
