package com.fowu.fowuproducerspring.weather;

public class Weather {

    String captureTime;
    double waveHeight;
    double wavePeriod;
    int waveDirection;
    double windSpeed;
    int windDirection;

    public Weather(String time, double waveHeight, double wavePeriod, int waveDirection, double windSpeed, int windDirection) {

        this.captureTime = time;
        this.waveHeight = waveHeight;
        this.wavePeriod = wavePeriod;
        this.waveDirection = waveDirection;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "time=" + captureTime +
                ", waveHeight=" + waveHeight +
                ", wavePeriod=" + wavePeriod +
                ", waveDirection=" + waveDirection +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                '}';
    }
}
