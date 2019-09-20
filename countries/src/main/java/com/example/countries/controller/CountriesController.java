package com.example.countries.controller;

import com.example.countries.domain.Country;
import com.example.countries.service.CountriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {
    private final CountriesService countriesService;

    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping("/country/{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable String name){
        Country country = countriesService.getCountryByName(name);
        return ResponseEntity.ok(country);
    }
}
