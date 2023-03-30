package com.fowu.fowuproducerspring.APImodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public record WaveData(
        @JsonProperty("latitude") double latitude,
        @JsonProperty("longitude") double longitude,
        @JsonProperty("hourly") HourlyWaveData hourlyData,
        @JsonProperty("hourly_units") WaveDataUnits hourlyUnits) {
}
