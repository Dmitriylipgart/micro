package com.example.countries.service;

import com.example.countries.domain.Country;
import com.example.countries.domain.Currency;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Iterator;

@Service
@Slf4j
public class CountriesService {
    private final RestTemplate restTemplate;
    private static ObjectMapper objectMapper;
    private String url = "url";

    public CountriesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Country getCountryByName(String name){
        ResponseEntity<String> json = restTemplate.getForEntity(url, String.class);
        return parse(json.getBody());
    }

    private Country parse(String json) {
        Country country = new Country();

        try {
            JsonNode node = objectMapper.readTree(json);
            String name = node.get("name").asText();
            Currency currency = new Currency();
            Iterator<JsonNode> currencyNodes = node.get("currencies").elements();
            currencyNodes.forEachRemaining(jsonNode -> {
                currency.setCode(jsonNode.get("code").asText());
                currency.setName(jsonNode.get("name").asText());
            });
            country.setName(name);
        } catch (IOException e) {
            log.error("Json parse error: ", e);
        }
        return country;
    }

}