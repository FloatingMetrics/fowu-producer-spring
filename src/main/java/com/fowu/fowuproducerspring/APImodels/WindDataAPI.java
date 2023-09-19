package com.fowu.fowuproducerspring.APImodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WindDataAPI(
  @JsonProperty("time") String[] time,
  @JsonProperty("windspeed_10m") double[] windSpeed,
  @JsonProperty("winddirection_10m") int[] windDirection
) {}
