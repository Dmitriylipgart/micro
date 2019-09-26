package com.example.countries.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient("conversion")
public interface CurrencyConversionClient {
    @GetMapping("/from/{from}/to/{to}")
    BigDecimal convertCurrency(@PathVariable String from, @PathVariable String to);
}
