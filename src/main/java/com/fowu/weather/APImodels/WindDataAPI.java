package com.fowu.weather.APImodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WindDataAPI(
  @JsonProperty("time") String[] time,
  @JsonProperty("windspeed_10m") double[] windSpeed,
  @JsonProperty("winddirection_10m") int[] windDirection
) {}
