package com.fowu.fowuproducerspring;

import java.util.List;

public record WeatherData(
    List<String> time,
    List<Double> waveHeight,
    List<Double> wavePeriod,
    List<Integer> waveDirection,
    List<Integer> windDirection,
    List<Double> windSpeed) {

}
