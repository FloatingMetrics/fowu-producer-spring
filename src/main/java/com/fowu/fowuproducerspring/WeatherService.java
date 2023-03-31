package com.fowu.fowuproducerspring;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fowu.fowuproducerspring.APImodels.WaveDataAPI;
import com.fowu.fowuproducerspring.APImodels.MarineDataAPI;
import com.fowu.fowuproducerspring.APImodels.WeatherDataAPI;
import com.fowu.fowuproducerspring.APImodels.WindDataAPI;

@Service
public class WeatherService {

  RestTemplate RestTemplate;
  private MarineDataAPI marineData;
  private WaveDataAPI waveData;
  private WeatherDataAPI weatherData;
  private WindDataAPI windData;
  private final double latitude = 54.3213;
  private final double longitude = 10.1348;

  public WeatherService(RestTemplate restTemplate) {
    this.RestTemplate = restTemplate;
  }

  public WeatherData getWeatherData() {

    waveData = getMarineData();
    windData = getWindData();

    assert waveData != null && windData != null;

    var weatherData = new WeatherData(waveData.time(), waveData.waveHeight(), waveData.wavePeriod(),
        waveData.waveDirection(), windData.windDirection(), windData.windSpeed());

    return weatherData;
  }

  private WaveDataAPI getMarineData() {
    System.out.println("FETCHING MARINE DATA...");

    marineData = RestTemplate.getForObject(
        "https://marine-api.open-meteo.com/v1/marine?latitude=" + latitude + "&longitude=" + longitude
            + "&hourly=wave_height,wave_direction,wave_period",
        MarineDataAPI.class);

    assert marineData != null;

    waveData = marineData.hourlyData();
    return waveData;
  }

  private WindDataAPI getWindData() {
    System.out.println("FETCHING WEATHER DATA...");

    weatherData = RestTemplate.getForObject(
        "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude
            + "&hourly=windspeed_10m,winddirection_10m&windspeed_unit=ms",
        WeatherDataAPI.class);

    assert weatherData != null;
    windData = weatherData.windData();

    return windData;
  }

}
