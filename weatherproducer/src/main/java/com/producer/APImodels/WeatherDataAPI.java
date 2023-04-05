package com.producer.APImodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public record WeatherDataAPI(
    @JsonProperty("hourly") WindDataAPI windData) {
}
