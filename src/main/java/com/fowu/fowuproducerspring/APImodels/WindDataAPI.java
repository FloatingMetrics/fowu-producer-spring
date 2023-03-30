package com.fowu.fowuproducerspring.APImodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WindDataAPI(
  @JsonProperty("time") List<String> time,
  @JsonProperty("windspeed_10m") List<Double> windSpeed,
  @JsonProperty("winddirection_10m") List<Integer> windDirection
) {}
