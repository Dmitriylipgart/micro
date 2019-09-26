package com.example.countries.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Country {
    private String name;
    private String code;
    private List<Currency> currencies;
    private String flag;
}
