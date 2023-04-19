package com.fowu.weatherproducer.APImodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public record WaveDataAPI(
                @JsonProperty("time") String[] captureTime,
                @JsonProperty("wave_height") double[] waveHeight,
                @JsonProperty("wave_period") double[] wavePeriod,
                @JsonProperty("wave_direction") int[] waveDirection) {
}
