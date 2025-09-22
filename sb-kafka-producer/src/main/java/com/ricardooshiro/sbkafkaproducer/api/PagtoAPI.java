package com.ricardooshiro.sbkafkaproducer.api;

import com.ricardooshiro.sbkafkaproducer.dto.PagtoDTO;
import com.ricardooshiro.sbkafkaproducer.service.PagtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagtos")
public class PagtoAPI {
    @Autowired
    private PagtoService pagtoService;

    @PostMapping
    public String pagar(@RequestBody PagtoDTO pagto) {
        return pagtoService.integrarPagto(pagto);
    }
}
