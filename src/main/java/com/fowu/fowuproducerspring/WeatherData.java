package com.fowu.fowuproducerspring;

import java.util.List;

public record WeatherData(
                List<String> time,
                List<Double> waveHeight,
                List<Double> wavePeriod,
                List<Double> windSpeed,
                List<Integer> windDirection,
                List<Integer> waveDirection) {
}
