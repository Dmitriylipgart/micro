package com.example.countries.controller;

import com.example.countries.domain.Country;
import com.example.countries.service.CountriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/country")
public class CountriesController {
    private final CountriesService countriesService;

    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable String name) {
        Country country = countriesService.getCountryByName(name);
        return ResponseEntity.ok(country);
    }

    @GetMapping("/currency/conversion")
    public ResponseEntity<Double> getConversionRate(@RequestParam("from") String from,
                                                    @RequestParam("to") String to) {
        double rate = countriesService.getConversionRate(from, to);
        return ResponseEntity.ok(rate);
    }
}
