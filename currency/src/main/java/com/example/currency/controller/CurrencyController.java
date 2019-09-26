package com.example.currency.controller;

import com.example.currency.service.CurrencyConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyController {

    private final CurrencyConverterService converterService;

    public CurrencyController(CurrencyConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/from/{from}/to/{to}")
    public BigDecimal convertCurrency(@PathVariable String from, @PathVariable String to) {
        return converterService.convert(from, to);
    }
}
