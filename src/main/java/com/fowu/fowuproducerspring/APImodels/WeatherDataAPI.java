package com.fowu.fowuproducerspring.APImodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonIgnoreProperties
public record WeatherDataAPI(
    @JsonPropertyDescription("hourly") WindDataAPI windData) {
}
