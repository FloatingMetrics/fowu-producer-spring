package com.fowu.weatherproducer;

public record WeatherData(
    String[] time,
    double[] waveHeight,
    double[] wavePeriod,
    int[] waveDirection,
    int[] windDirection,
    double[] windSpeed) {

}
