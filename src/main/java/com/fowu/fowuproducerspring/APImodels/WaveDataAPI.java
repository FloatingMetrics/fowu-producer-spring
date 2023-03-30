package com.fowu.fowuproducerspring.APImodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public record WaveDataAPI(
                @JsonProperty("time") List<String> time,
                @JsonProperty("wave_height") List<Double> waveHeight,
                @JsonProperty("wave_period") List<Double> wavePeriod,
                @JsonProperty("wave_direction") List<Integer> waveDirection) {
}
