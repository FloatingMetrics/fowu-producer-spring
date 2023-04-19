package com.fowu.weatherproducer;

public record WeatherData(
    String[] captureTime,
    double[] waveHeight,
    double[] wavePeriod,
    int[] waveDirection,
    int[] windDirection,
    double[] windSpeed) {

}
