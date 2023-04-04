package com.fowu.fowuproducerspring.APImodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WindDataAPI(
  @JsonProperty("time") String[] time,
  @JsonProperty("windspeed_10m") double[] windSpeed,
  @JsonProperty("winddirection_10m") int[] windDirection
) {}
