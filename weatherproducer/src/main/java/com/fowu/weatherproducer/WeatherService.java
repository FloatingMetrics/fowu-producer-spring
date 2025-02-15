package com.fowu.weatherproducer;

import java.time.LocalDate;

import com.fowu.weatherproducer.APImodels.MarineDataAPI;
import com.fowu.weatherproducer.APImodels.WaveDataAPI;
import com.fowu.weatherproducer.APImodels.WeatherDataAPI;
import com.fowu.weatherproducer.APImodels.WindDataAPI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

  RestTemplate RestTemplate;
  private MarineDataAPI marineData;
  private WaveDataAPI waveData;
  private WeatherDataAPI weatherData;
  private WindDataAPI windData;
  private final double LATITUDE = 59.316;
  private final double LONGITUDE = 3.738;
  private final String TIME_ZONE = "Europe/London";
  private LocalDate dateNow = LocalDate.now();
  private final LocalDate endDate = dateNow;
  private final LocalDate startDate = dateNow.minusDays(7);
  private final String urlLocationAndPeriod = "&latitude=" + LATITUDE + "&longitude=" +
                                              LONGITUDE + "&start_date=" + startDate + "&end_date=" + endDate +
                                              "&timezone=" + TIME_ZONE;

  public WeatherService(RestTemplate restTemplate) {
    this.RestTemplate = restTemplate;
  }

  public WeatherData getWeatherData() {

    waveData = getMarineData();
    windData = getWindData();

    assert waveData != null && windData != null;

    var weatherData = new WeatherData(waveData.captureTime(),
                                      waveData.waveHeight(), waveData.wavePeriod(),
        waveData.waveDirection(), windData.windDirection(), windData.windSpeed());

    return weatherData;
  }

  private WaveDataAPI getMarineData() {
    System.out.println("FETCHING MARINE DATA...");

    marineData = RestTemplate.getForObject(
        "https://marine-api.open-meteo.com/v1/marine?hourly=wave_height,wave_direction,wave_period" + urlLocationAndPeriod,
        MarineDataAPI.class);

    assert marineData != null;

    waveData = marineData.hourlyData();
    return waveData;
  }

  private WindDataAPI getWindData() {
    System.out.println("FETCHING WEATHER DATA...");

    weatherData = RestTemplate.getForObject(
        "https://api.open-meteo.com/v1/forecast?hourly=windspeed_10m,winddirection_10m&windspeed_unit=ms" + urlLocationAndPeriod,
        WeatherDataAPI.class);

    assert weatherData != null;
    windData = weatherData.windData();

    return windData;
  }

}
