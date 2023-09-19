package com.fowu.weatherproducer.APImodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public record MarineDataAPI(
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("hourly") WaveDataAPI hourlyData,
    @JsonProperty("hourly_units") WaveDataUnitsAPI hourlyUnits) {
}
