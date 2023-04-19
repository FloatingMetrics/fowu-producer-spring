package com.fowu.weatherproducer.APImodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WaveDataUnitsAPI(
        @JsonProperty("time") String captureTime,
        @JsonProperty("wave_height") String waveHeight,
        @JsonProperty("wave_period") String wavePeriod,
        @JsonProperty("wave_direction") String waveDirection) {
}
