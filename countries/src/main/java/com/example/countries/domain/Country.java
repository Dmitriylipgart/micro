package com.example.countries.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String name;
    private String code;
    private Currency currency;
    private String flag;
}
